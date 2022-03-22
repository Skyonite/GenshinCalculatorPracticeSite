package com.example.skyonite.genshincalculatorpracticesite.service;


import com.example.skyonite.genshincalculatorpracticesite.model.Character;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

    Character createCharacter(String name, String talent1, String talent2, String talent3);
    Character editCharacter(Long id, String name, String talent11, String talent2, String talent3);
    Character deleteCharacter(Long id);

}
