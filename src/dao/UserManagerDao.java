package dao;

import bean.User;

import java.util.List;

public interface UserManagerDao {
    public  List<User> queryAllUser();
}
