package com.example.tenniscourtservice.messaging;

import com.example.tenniscourtservice.tennis.TennisCourt;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.OffsetDateTime.now;

@UtilityClass
@Slf4j
public class MessageFactory {

    public static TennisCourtMessage createTennisCourtMessage(List<TennisCourt> court, String mail) {
        return TennisCourtMessage.builder()
                .email(mail)
                .notificationType(NotificationType.EMAIL.name())
                .courts(court.stream()
                        .map(p -> p.getName() + ":" + p.getTimeslots())
                        .collect(Collectors.toList()))
                .sendingTime(now().toString())
                .version(1).build();
    }


}
