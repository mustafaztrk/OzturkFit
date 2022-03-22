package com.example.projeone.Entities.Concretes;


import com.example.projeone.Entities.Abstracts.IEntity;

public class Poses implements IEntity {
    private int Id;
    private String NameIng;
    private String NameSnk;
    private int LevelId;

    public Poses() {
    }


    public Poses(int id, String nameIng, String nameSnk, int levelId) {
        Id = id;
        NameIng = nameIng;
        NameSnk = nameSnk;
        LevelId = levelId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameIng() {
        return NameIng;
    }

    public void setNameIng(String nameIng) {
        NameIng = nameIng;
    }

    public String getNameSnk() {
        return NameSnk;
    }

    public void setNameSnk(String nameSnk) {
        NameSnk = nameSnk;
    }

    public int getLevelId() {
        return LevelId;
    }

    public void setLevelId(int levelId) {
        LevelId = levelId;
    }
}
