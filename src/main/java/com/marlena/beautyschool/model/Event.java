package com.marlena.beautyschool.model;

import lombok.Data;

@Data
public class Event extends BaseEntity {

    private String date;
    private String name;
    private Type type;

    public enum Type {
        LOCAL, ONLINE;
    }

}
