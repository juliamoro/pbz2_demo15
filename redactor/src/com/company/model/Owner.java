package com.company.model;

import java.util.Objects;

public class Owner {
    private String faceType, name, number;

    public Owner(){}

    public Owner(String number){
        this.number = number;
    }

    public Owner(String name, String faceType, String number) {
        this.name = name;
        this.faceType = faceType;
        this.number = number;
    }

    public String getFaceType() {
        return faceType;
    }

    public void setFaceType(String faceType) {
        this.faceType = faceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return faceType.equals(owner.faceType) && name.equals(owner.name) && number.equals(owner.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceType, name, number);
    }
}
