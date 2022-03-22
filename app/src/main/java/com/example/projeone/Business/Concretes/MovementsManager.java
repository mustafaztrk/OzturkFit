package com.example.projeone.Business.Concretes;

import com.example.projeone.Business.Abstracts.IMovementsService;
import com.example.projeone.DataAccess.Abstracts.IMovementsDao;
import com.example.projeone.DataAccess.Abstracts.IPosesDao;
import com.example.projeone.Entities.Concretes.Movements;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;

public class MovementsManager implements IMovementsService {
    private IMovementsDao _movementsDao;

    public MovementsManager(IMovementsDao movementsDao) {
        this._movementsDao = movementsDao;
    }

    @Override
    public ArrayList<Movements> GetAll() {
        return _movementsDao.GetAll();
    }

    @Override
    public void Add(Movements movements) {
        _movementsDao.Add(movements);
    }

}
