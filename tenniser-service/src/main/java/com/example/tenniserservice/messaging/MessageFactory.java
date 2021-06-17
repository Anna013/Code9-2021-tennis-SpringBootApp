package com.example.tenniserservice.messaging;


import com.example.tenniserservice.tenniser.Tenniser;
import com.example.tenniserservice.tenniser.TenniserOperation;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;

@UtilityClass
@Slf4j
public class MessageFactory {

    public static TenniserUpdateMessage createTenniserUpdateMessage(Tenniser t, TenniserOperation operation) {
        return TenniserUpdateMessage.builder().email(t.getEmail())
                .typeOfOperation(operation.getText())
                .version(1)
                .notificationType(NotificationType.EMAIL.name())
                .sendingTime(OffsetDateTime.now().toString())
                .build();
    }
}


