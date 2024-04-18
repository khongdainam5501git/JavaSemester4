package CatSalon.Model;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Cat {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String breed;
    private Color color;
    private Owner owner;
    private List<Cat> friends;

    public Cat(UUID id, String name, LocalDate dateOfBirth, String breed, Color color, Owner owner, List<Cat> friends) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
        this.friends = friends;
    }



    // Getters and Setters --------------------------------------------------------------------------------------------
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Cat> getFriends() {
        return friends;
    }

    public void setFriends(List<Cat> friends) {
        this.friends = friends;
    }


}