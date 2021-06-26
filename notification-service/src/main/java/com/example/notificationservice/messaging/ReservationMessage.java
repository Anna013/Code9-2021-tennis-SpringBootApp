package com.example.notificationservice.messaging;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
public class ReservationMessage extends BaseMessage {

    @JsonProperty("email")
    String email;

    @JsonProperty("type_of_operation")
    String typeOfOperation;

    @JsonProperty("notification_type")
    String notificationType;

}
