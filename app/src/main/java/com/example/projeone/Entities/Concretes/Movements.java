package com.example.projeone.Entities.Concretes;

import com.example.projeone.Entities.Abstracts.IEntity;

public class Movements implements IEntity {

    private int Id;
    private int LevelId;
    private String Name;
    private String Area;

    public Movements() {
    }

    public Movements(int id, int levelId, String name, String area) {
        Id = id;
        LevelId = levelId;
        Name = name;
        Area = area;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getLevelId() {
        return LevelId;
    }

    public void setLevelId(int levelId) {
        LevelId = levelId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}
