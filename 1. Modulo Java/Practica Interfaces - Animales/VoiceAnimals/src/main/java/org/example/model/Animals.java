package org.example.model;

public abstract class Animals{

    private String sound;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public abstract void makeSound();

}
