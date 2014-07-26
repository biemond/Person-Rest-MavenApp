package com.example.rest.data;


public class PersonNotFoundException extends Exception {
    @SuppressWarnings("compatibility:-7213470615692623760")
    private static final long serialVersionUID = 1L;
    //Parameterless Constructor
    public PersonNotFoundException() {
    }

    //Constructor that accepts a message
    public PersonNotFoundException(String message) {
        super(message);
    }
}
