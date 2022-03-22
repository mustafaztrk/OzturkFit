package com.example.projeone.Business.Abstracts;

import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;

public interface IUserService
{
    ArrayList<User> GetAll();
    void Add(User user);
    void Delete(User user);
    void Update(User user);
}
