package test;

import bean.User;
import dao.UserManagerDao;
import dao.impt.UserManagerDaoImpt;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserManagerServiceImptTest {
    @Test
    void selectAll(){
        UserManagerDao umd = new UserManagerDaoImpt();
        List<User> userList = umd.queryAllUser();
        System.out.println("测试完成，执行完了");
        System.out.println(userList);
    }

}