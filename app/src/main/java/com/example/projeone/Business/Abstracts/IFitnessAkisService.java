package com.example.projeone.Business.Abstracts;


import com.example.projeone.Entities.Concretes.FıtnessAkis;
import com.example.projeone.Entities.Concretes.Movements;

import java.util.ArrayList;

public interface IFitnessAkisService {
    ArrayList<Movements> GetAll();
    void Add(Movements movements);
}
