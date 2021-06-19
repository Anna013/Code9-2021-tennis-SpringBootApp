package com.example.tenniscourtservice.messaging;

import com.example.tenniscourtservice.tennis.ReserveOperation;

import com.example.tenniscourtservice.tennis.Timeslot;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;


@UtilityClass
@Slf4j
public class MessageFactory {

        public static TennisCourtMessage createMessage(Timeslot t, ReserveOperation operation) {
            return TennisCourtMessage.builder()
                    .typeOfOperation(operation.getText())
                    .version(1)
                    .notificationType(NotificationType.EMAIL.name())
                    .sendingTime(OffsetDateTime.now().toString())
                    .build();
        }
}

