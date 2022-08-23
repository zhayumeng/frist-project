package service.Impt;

import bean.User;
import dao.UserDao;
import dao.impt.UserDaoImpt;
import service.UserService;

import java.util.List;

public class UserServiceImpt implements UserService {


    @Override
    public boolean insert(int userId, String userName, String userPassword, String idCard) {
        UserDao u = new UserDaoImpt();
        boolean insertSucc = u.insert(userId,userName,userPassword,idCard);
        return insertSucc;
    }

    @Override
    public List<User> queryAllUsers() {
        UserDao u = new UserDaoImpt();
        List<User> List = u.queryAllUsers();
        return List;
    }

    @Override
    public List<User> queryUserByName(String userName) {
        UserDaoImpt u = new UserDaoImpt();
        List<User> users = u.queryUserByName(userName);
        return users;
    }


}
