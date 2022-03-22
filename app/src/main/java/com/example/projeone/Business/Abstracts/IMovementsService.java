package com.example.projeone.Business.Abstracts;

import com.example.projeone.Entities.Concretes.Movements;

import java.util.ArrayList;

public interface IMovementsService {
    ArrayList<Movements> GetAll();
    void Add(Movements movements);
}
