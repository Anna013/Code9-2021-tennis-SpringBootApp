package com.example.tenniscourtservice.tennis;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

    boolean existsByIdTimeslot(Integer id);

    void deleteByIdTimeslot(Integer id);

    List<Timeslot> existsByTenniserId(Integer id);

    boolean existsByTenniserIdAndDate(Integer id, Date date);

    List<Timeslot> findByDate(Date date);

}
