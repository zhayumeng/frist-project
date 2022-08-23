package dao.impt;

import bean.User;
import dao.UserDao;

import java.util.List;

public class UserDaoImpt implements UserDao {
    @Override
    public boolean insert(int userId,String userName,String userPassword,String idCard) {
        String sql = "insert into t_user (userId,userName,userPassword,idCard) values (?,?,?,?)";
        boolean insertSucc = BaseDao.update(sql, userId, userName, userPassword, idCard);
        return insertSucc;
    }

    @Override
    public List<User> queryAllUsers() {
        String sql = "select * from t_user";
        List<User> userList = BaseDao.QueryReturnList(User.class, sql);
        return userList;
    }

    @Override
    public List<User> queryUserByName(String userName) {
        String sql = "select * from t_user where userName = ?";
        List<User> users = BaseDao.QueryReturnList(User.class, sql, userName);
        return users;
    }


}
