package com.example.tenniserservice.tenniser;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
public enum TenniserOperation {

    CREATE("created"),
    UPDATE("updated");

    private String text;


    TenniserOperation(String text) {
        this.text = text;
    }
}
