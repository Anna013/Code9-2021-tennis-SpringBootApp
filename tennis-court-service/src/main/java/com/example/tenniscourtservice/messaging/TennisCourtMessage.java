package com.example.tenniscourtservice.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Value
@SuperBuilder
public class TennisCourtMessage extends BaseMessage{

    @JsonProperty("email")
    String email;

    @JsonProperty("type_of_operation")
    String typeOfOperation;

    @JsonProperty("notification_type")
    String notificationType;

}

