package com.example.tenniscourtservice.tennis;

import lombok.Getter;

@Getter
public enum ReserveOperation {

    CREATE("reserved");

    private String text;

    ReserveOperation(String text) {
        this.text = text;
    }
}
