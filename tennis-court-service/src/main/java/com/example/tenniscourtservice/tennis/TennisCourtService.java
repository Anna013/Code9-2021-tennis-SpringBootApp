package com.example.tenniscourtservice.tennis;


import com.example.tenniscourtservice.exception.AlreadyExistsException;

import com.example.tenniscourtservice.messaging.MessageFactory;
import com.example.tenniscourtservice.messaging.MessageService;
import com.example.tenniscourtservice.messaging.TennisCourtMessage;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class TennisCourtService {

    private final TennisCourtRepository tennisCourtRepository;
    private final TimeslotRepository timeslotRepository;
    private final MessageService messageService;


    private final TenniserClient tenniserClient = Feign.builder()
            .decoder(new GsonDecoder())
            .target(TenniserClient.class, "http://localhost:8082");


    List<TennisCourt> findAll() {
        return tennisCourtRepository.findAll();
    }

    public TennisCourt findOneByName(String name) {
        return tennisCourtRepository.findByName(name);
    }

    public void createTennisCourt(TennisCourt tc) {
        if (!tennisCourtRepository.existsByName(tc.getName())) {
            tennisCourtRepository.save(tc);
        } else {
            throw new AlreadyExistsException(String.format("Tennis court with name '%s' already exists", tc.getName()));
        }
    }

    public void deleteTennisCourt(String name) {
        if (tennisCourtRepository.existsByName(name)) {
            tennisCourtRepository.deleteByName(name);
        } else {
            throw new AlreadyExistsException(String.format("Tennis court with name '%s' not exists", name));
        }
    }


    //timeslotService

    public boolean workingHour(LocalTime startTime, LocalTime endTime, LocalDate date) {
        boolean start = startTime.isAfter(LocalTime.of(18, 0));
        boolean end = endTime.isBefore(LocalTime.of(23, 0));
        boolean start2 = startTime.isAfter(LocalTime.of(17, 0));
        boolean end2 = endTime.isBefore(LocalTime.of(22, 0));
        int day = date.getDayOfWeek().getValue();

        if ((start && end) && (day == 1 || day == 2 || day == 3 || day == 4 || day == 5)) {
            return true;
        }
        else return (start2 && end2) && (day == 6 || day == 7);
    }


    public boolean overlapping(Date date, LocalTime start, LocalTime end) {
        List<Timeslot> list = timeslotRepository.findByDate(date);
        for (Timeslot timeslot : list) {
            boolean isBefore = start.isBefore((timeslot.getStartTime().toLocalTime()));
            boolean isBefore2 = end.isBefore(timeslot.getStartTime().toLocalTime());
            boolean isAfter = start.isAfter(timeslot.getEndTime().toLocalTime());
            boolean isAfter2 = end.isAfter(timeslot.getEndTime().toLocalTime());

            if ((isBefore && isBefore2) || (isAfter && isAfter2))
                return true;
        }
        return false;
    }


    public LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }



    public void reserveTimeslot(Timeslot ts) {
        long period = Duration.between(ts.getStartTime().toLocalTime(), ts.getEndTime().toLocalTime()).getSeconds();
        int compareDate = ts.getDate().compareTo(new Date());
        boolean workingHour = workingHour(ts.getStartTime().toLocalTime(), ts.getEndTime().toLocalTime(), toLocalDate(ts.getDate()));
        boolean overlapping = overlapping(ts.getDate(), ts.getStartTime().toLocalTime(), ts.getEndTime().toLocalTime());
        List<Timeslot> list = timeslotRepository.existsByTenniserId(ts.getTenniserId());
        Tenniser tenniser = tenniserClient.getTenniser(ts.getTenniserId());

        if ((period < 7200 && period > 1800) && compareDate >= 0 && workingHour && !overlapping) {
            if (!timeslotRepository.existsByTenniserIdAndDate(ts.getTenniserId(), ts.getDate())) {
                if(list.size() < 5) {
                    timeslotRepository.save(ts);
                    publishMessageIfReserved(ts, ReserveOperation.CREATE);
                }
                else if (list.size() > 5 && tenniser.isPaid()) {
                    timeslotRepository.save(ts);
                    publishMessageIfReserved(ts, ReserveOperation.CREATE);
                }
                else
                    throw new AlreadyExistsException(String.format("Timelsot for tenniser with id: '%d', is not paid", ts.getTenniserId()));
            }
        }
        else {
            throw new AlreadyExistsException(String.format("Timelsot for tenniser with id: '%d', already exists", ts.getTenniserId()));
        }
    }

    public void deleteTimeslot(Integer id) {
        if (timeslotRepository.existsByIdTimeslot(id)) {
            timeslotRepository.deleteByIdTimeslot(id);
        } else {
            throw new AlreadyExistsException(String.format("Timeslot  with id: '%d', not exists", id));
        }
    }

    private void publishMessageIfReserved(Timeslot timeslot, ReserveOperation operation) {
            TennisCourtMessage message = MessageFactory.createMessage(timeslot, operation);
            messageService.sendMessageToTopic(message);

    }

}
