package com.example.projeone.Business.Abstracts;

import com.example.projeone.Entities.Concretes.Akıs;

import java.util.ArrayList;

public interface IAkısService {
    ArrayList<Akıs> GetAll();
    void Add(Akıs akıs);
    void Delete(Akıs akıs);
    void Update(Akıs akıs);

}
