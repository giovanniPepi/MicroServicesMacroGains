package org.giovanni.MicroServicesMacroGains.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
class Member {
    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private String firstName;
    private String lastName;
    private Gender genderChoice;
    private String gender;

    private double height;
    private double weight;
    private double bodyFatPercent;
    private boolean isActive;
    private Date registrationDate;

    Member() {

    }

    public Member(
            String firstName,
            String lastName,
            Gender genderChoice,
            double height,
            double weight,
            double bodyFatPercent,
            boolean isActive,
            Date registrationDate
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.bodyFatPercent = bodyFatPercent;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
        this.genderChoice = genderChoice;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBodyFatPercent() {
        return bodyFatPercent;
    }

    public void setBodyFatPercent(double bodyFatPercent) {
        this.bodyFatPercent = bodyFatPercent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean s) {
        isActive = s;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Gender getGenderChoice() {
        return genderChoice;
    }

    public void setGenderChoice(Gender genderChoice) {
        this.genderChoice = genderChoice;
    }

    public String getGender() {
        return genderChoice.getOpt();
    }

    public void setGender(String gender) {
        switch (gender){
            case "male":
                this.genderChoice = Gender.MALE;
            case "female":
                this.genderChoice = Gender.FEMALE;
            case "other":
                this.genderChoice = Gender.OTHER;
            case "not_informed":
                this.genderChoice = Gender.PREFER_NOT_TELL;
            default:
                this.genderChoice = Gender.PREFER_NOT_TELL;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Double.compare(height, member.height) == 0 && Double.compare(weight, member.weight) == 0 &&
                Double.compare(bodyFatPercent, member.bodyFatPercent) == 0 && isActive == member.isActive &&
                Objects.equals(id, member.id) && Objects.equals(firstName, member.firstName) &&
                Objects.equals(lastName, member.lastName) && genderChoice == member.genderChoice &&
                Objects.equals(registrationDate, member.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, firstName, lastName, genderChoice, height, weight, bodyFatPercent, isActive, registrationDate
        );
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" +
                this.lastName + '\'' + ", gender='" + this.getGenderChoice() + '\'' +
                ", height='" + this.height + '\'' + ", weight='" + this.weight + '\'' +
                ", bodyFatPercent='" + this.bodyFatPercent + '\''
                + ", isActive='" + this.isActive + '\'' + ", registrationDate='" +
                this.registrationDate + '\'' + '}';
    }
}
