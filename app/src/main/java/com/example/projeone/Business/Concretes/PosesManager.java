package com.example.projeone.Business.Concretes;



import android.util.Log;

import com.example.projeone.Business.Abstracts.IPosesService;
import com.example.projeone.DataAccess.Abstracts.IPosesDao;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;

public class PosesManager implements IPosesService {
    private IPosesDao _posesDto;

    public PosesManager(IPosesDao posesDto) {
        this._posesDto = posesDto;
    }

    @Override
    public ArrayList<Poses> GetAll() {
        return _posesDto.GetAll();
    }

    @Override
    public void Add(Poses pose) {
        _posesDto.Add(pose);
    }



}
