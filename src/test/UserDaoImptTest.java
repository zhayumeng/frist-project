package test;

import bean.User;
import org.junit.jupiter.api.Test;
import service.Impt.UserServiceImpt;
import service.UserService;

import java.util.List;


class UserDaoImptTest {
    UserService us = new UserServiceImpt();
    @Test
    void insert(){

        boolean insert = us.insert(2, "ad刚刚我", "dfa", "ajdf");
        System.out.println(insert);
    }

    @Test
    void queryAllUsers(){
        List<User> userList = us.queryAllUsers();
        System.out.println(userList);
    }

    @Test
    void queryUserByName(){
        List<User> users = us.queryUserByName("查裕盟");
        System.out.println(users);
    }
}