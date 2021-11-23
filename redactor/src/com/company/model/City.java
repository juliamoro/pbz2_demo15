package com.company.model;

import java.util.Objects;

public class City {
    private String name, type, address;
    private int numberSeats;
    private String opening,seasonOpen,owner;

    public City() {
    }

    public City(String name, String type, String address, int numberSeats, String opening, String seasonOpen, String owner) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.numberSeats = numberSeats;
        this.opening = opening;
        this.seasonOpen = seasonOpen;
        this.owner = owner;
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }


    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public void setSeasonOpen(String seasonOpen) {
        this.seasonOpen = seasonOpen;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getSeasonOpen() {
        return seasonOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return numberSeats == city.numberSeats && name.equals(city.name) && type.equals(city.type) && address.equals(city.address) && opening.equals(city.opening) && seasonOpen.equals(city.seasonOpen) && owner.equals(city.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, address, numberSeats, opening, seasonOpen, owner);
    }
}
