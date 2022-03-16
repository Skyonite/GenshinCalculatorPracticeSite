package com.example.skyonite.genshincalculatorpracticesite.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_builds")
public class CharacterBuild {

    @Id
    private Long id;
    @ManyToOne
    private User owner;

    private int level;
    private int totalAtk;
    private int energyRecharge;
    private int damageMultiplier;
    private int healingBonus;
    private int critRate;
    private int critDamage;



}
