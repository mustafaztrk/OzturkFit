package com.example.projeone.Entities.Concretes;

import com.example.projeone.Entities.Abstracts.IEntity;

public class FıtnessAkis implements IEntity {
    private int Id;
    private String Poses;
    private int Time;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPoses() {
        return Poses;
    }

    public void setPoses(String poses) {
        Poses = poses;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public FıtnessAkis(int id, String poses, int time) {
        Id = id;
        Poses = poses;
        Time = time;
    }

    public FıtnessAkis() {
    }
}
