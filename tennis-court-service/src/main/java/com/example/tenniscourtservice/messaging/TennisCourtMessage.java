package com.example.tenniscourtservice.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
@SuperBuilder
public class TennisCourtMessage extends BaseMessage{

    @JsonProperty("email")
    String email;

    @JsonProperty("courts")
    List<String> courts;

    @JsonProperty("notification_type")
    String notificationType;

}

