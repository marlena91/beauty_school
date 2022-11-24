package com.marlena.beautyschool.model;

public class Event {

    private final String date;
    private final String name;
    private final Type type;

    public enum Type {
        LOCAL, ONLINE;
    }

    public Event(String date, String name, Type type) {
        this.date = date;
        this.name = name;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
