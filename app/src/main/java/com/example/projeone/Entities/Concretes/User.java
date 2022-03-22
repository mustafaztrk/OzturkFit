package com.example.projeone.Entities.Concretes;

import com.example.projeone.Entities.Abstracts.IEntity;

public class User implements IEntity {

    private int Id;
    private String name;
    private String lastName;
    private String cinsiyet;
    private int time;
    private int weight;
    private int age;
    private int height;
    private int levelId;

    public User() {
    }

    public User(int id, String name, String lastName, String cinsiyet, int time, int weight, int age, int height, int levelId) {
        Id = id;
        this.name = name;
        this.lastName = lastName;
        this.cinsiyet = cinsiyet;
        this.time = time;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.levelId = levelId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
