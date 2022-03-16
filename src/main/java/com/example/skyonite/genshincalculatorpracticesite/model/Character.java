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
}
