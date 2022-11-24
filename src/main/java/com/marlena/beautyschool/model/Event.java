package com.marlena.beautyschool.model;

import lombok.Data;

@Data
public class Event {

    private final String date;
    private final String name;
    private final Type type;

    public enum Type {
        LOCAL, ONLINE;
    }

}
