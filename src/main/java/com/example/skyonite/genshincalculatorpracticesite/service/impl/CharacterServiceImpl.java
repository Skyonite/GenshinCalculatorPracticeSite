package com.example.skyonite.genshincalculatorpracticesite.service.impl;

import com.example.skyonite.genshincalculatorpracticesite.model.Character;
import com.example.skyonite.genshincalculatorpracticesite.model.exceptions.NoSuchCharacterException;
import com.example.skyonite.genshincalculatorpracticesite.repository.CharacterRepository;
import com.example.skyonite.genshincalculatorpracticesite.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public Character createCharacter(String name, String talent1, String talent2, String talent3) {
        Character newChara = new Character(name, talent1, talent2, talent3);
        this.characterRepository.save(newChara);
        return newChara;
    }

    @Override
    public Character editCharacter(Long id, String name, String talent1, String talent2, String talent3) {
        Character modifyChara = this.characterRepository.findById(id)
                .orElseThrow(() -> new NoSuchCharacterException((name)));
        modifyChara.setName(name);
        modifyChara.setTalent1(talent1);
        modifyChara.setTalent2(talent2);
        modifyChara.setTalent3(talent3);
        this.characterRepository.save(modifyChara);
        return modifyChara;
    }

    @Override
    public Character deleteCharacter(Long id) {
        Character removeChara = this.characterRepository.findById(id)
                .orElseThrow(NoSuchCharacterException::new);
        this.characterRepository.deleteById(id);
        return removeChara;
    }
}
