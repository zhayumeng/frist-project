package service;

import bean.User;

import java.util.List;

public interface UserService {
    //用户注册的功能
    public boolean insert(int userId,String userName,String userPassword,String idCard);

    //查询出所有用户信息，返回用户信息集合
    public List<User> queryAllUsers();

    //通过用户名字查询出该名字的所有信息，
    public List<User> queryUserByName(String userName);
}
