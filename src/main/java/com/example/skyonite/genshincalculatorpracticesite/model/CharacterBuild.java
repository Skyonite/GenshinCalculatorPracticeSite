package com.example.skyonite.genshincalculatorpracticesite.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_builds")
public class CharacterBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User owner;

    private String characterName;
    private int level;
    private int totalAtk;
    private int energyRecharge;
    private int damageMultiplier;
    private int healingBonus;
    private int critRate;
    private int critDamage;

    public CharacterBuild() {
    }

    public CharacterBuild(User owner, String characterName, int level, int totalAtk, int energyRecharge,
                          int damageMultiplier, int healingBonus, int critRate, int critDamage) {
        this.owner = owner;
        this.characterName = characterName;
        this.level = level;
        this.totalAtk = totalAtk;
        this.energyRecharge = energyRecharge;
        this.damageMultiplier = damageMultiplier;
        this.healingBonus = healingBonus;
        this.critRate = critRate;
        this.critDamage = critDamage;
    }
}
