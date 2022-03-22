package com.example.projeone.Business.Concretes;

import com.example.projeone.Business.Abstracts.IUserService;
import com.example.projeone.DataAccess.Abstracts.IUserDao;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;

public class UserManager implements IUserService {

    IUserDao _userDao;

    public UserManager(IUserDao userDao) {
        this._userDao = userDao;
    }

    @Override
    public ArrayList<User> GetAll() {
       return  _userDao.GetAll();
    }

    @Override
    public void Add(User user) {
        _userDao.Add(user);
    }

    @Override
    public void Delete(User user) {
        _userDao.Delete(user);
    }

    @Override
    public void Update(User user) {
        _userDao.Update(user);
    }
}
