package com.marlena.beautyschool.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="events")
public class Event extends BaseEntity {

    @Id
    private String date;
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        LOCAL, ONLINE;
    }

}
