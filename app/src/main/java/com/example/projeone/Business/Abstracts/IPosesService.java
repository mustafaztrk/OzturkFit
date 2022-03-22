package com.example.projeone.Business.Abstracts;

import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;

public interface IPosesService {
    ArrayList<Poses> GetAll();
    void Add(Poses pose);
}
