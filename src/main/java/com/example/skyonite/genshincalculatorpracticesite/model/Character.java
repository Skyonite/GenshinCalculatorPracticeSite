package com.example.skyonite.genshincalculatorpracticesite.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String talent1;

    private String talent2;

    private String talent3;

    public Character() {
    }

    public Character(String name, String talent1, String talent2, String talent3) {
        this.name = name;
        this.talent1 = talent1;
        this.talent2 = talent2;
        this.talent3 = talent3;
    }
}
