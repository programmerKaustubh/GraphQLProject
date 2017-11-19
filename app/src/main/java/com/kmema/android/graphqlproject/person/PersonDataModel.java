package com.kmema.android.graphqlproject.person;

import java.io.Serializable;
public class PersonDataModel implements Serializable {
    private String id;
    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String mass;
    private String skinColor;
    private String created;
    private String edited;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getBirthYear() {
        return birthYear;
    }

    void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    String getEyeColor() {
        return eyeColor;
    }

    void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    String getHairColor() {
        return hairColor;
    }

    void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    String getMass() {
        return mass;
    }

    void setMass(String mass) {
        this.mass = mass;
    }

    String getSkinColor() {
        return skinColor;
    }

    void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }
}
