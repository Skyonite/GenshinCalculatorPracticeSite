package com.example.skyonite.genshincalculatorpracticesite.model.exceptions;

public class NoSuchCharacterException extends RuntimeException{
    public NoSuchCharacterException(String message) {
        super("Character " + message + " cannot be found");
    }

    public NoSuchCharacterException() {
        super("Character does not exist");
    }
}
