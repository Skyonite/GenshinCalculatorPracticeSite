package com.example.skyonite.genshincalculatorpracticesite.repository;

import com.example.skyonite.genshincalculatorpracticesite.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
