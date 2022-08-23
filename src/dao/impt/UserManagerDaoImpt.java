package dao.impt;

import bean.User;
import dao.UserManagerDao;

import java.util.List;

public class UserManagerDaoImpt implements UserManagerDao {
    @Override
    public List<User> queryAllUser() {
        String sql = "select * from t_user";
        List<User> userList = BaseDao.QueryReturnList(User.class, sql);
        return userList;
    }
}
