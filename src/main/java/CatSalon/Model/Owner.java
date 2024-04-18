package CatSalon.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class Owner {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private List<Cat> cats;

    public Owner(UUID id,String name, LocalDate dateOfBirth, String phoneNumber, List<Cat> cats) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.cats = cats;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

}