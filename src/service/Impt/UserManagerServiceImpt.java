package service.Impt;

import bean.User;
import dao.UserManagerDao;
import dao.impt.UserManagerDaoImpt;
import service.UserManagerService;

import java.util.List;

public class UserManagerServiceImpt implements UserManagerService {
    @Override
    public List<User> queryAllUser() {
        UserManagerDao umd = new UserManagerDaoImpt();
        List<User> userList = umd.queryAllUser();
        return userList;

    }
}
