package com.example.notificationservice.messaging;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Slf4j
public class MessagesListener {


    @RabbitListener(queues = "timeslot-reservation-queue")
    public void receiveTimeslotMessage(String message) {
        ReservationMessage reservationMessage = null;
        try {
            reservationMessage = new ObjectMapper().readValue(message, ReservationMessage.class);
        } catch (JsonProcessingException e) {
            log.error("Error during reading message: %s", e);
            e.printStackTrace();
            return;
        }
        log.info("Message successfully received");
    }

}
