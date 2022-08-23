package test;

import bean.OpenRoomReconrd;
import dao.impt.OpenRoomDaoImpt;
import org.junit.jupiter.api.Test;
import service.Impt.OpenRoomServiceImpt;
import service.OpenRoomService;

import java.util.List;

class OpenRoomServiceImptTest {

    @Test
    void test01(){//测试查询所有开房记录表信息
        OpenRoomService ors = new OpenRoomServiceImpt();
        List<OpenRoomReconrd> list = ors.queryAll();
        System.out.println(list);
    }

    @Test
    void test02(){//测试根据姓名关键字模糊查询开房记录表信息
        OpenRoomService ors = new OpenRoomServiceImpt();
        List<OpenRoomReconrd> list = ors.queryByName("谢");
        System.out.println(list);
    }

    @Test
    void test03(){//测试根据开房记录id，进行删除
        OpenRoomService ors = new OpenRoomServiceImpt();
       // boolean delete = ors.delete(3);
        //System.out.println(delete);
    }

    @Test
    void test04() {//直接查询所有总收入
        OpenRoomService ors = new OpenRoomServiceImpt();
        int result = ors.querySumMoney();
        System.out.println("点击按钮，直接查询记录表中的总收入");
        System.out.println(result);
    }

    @Test
    void test05(){//插入信息到开房记录表中去
        OpenRoomService ors = new OpenRoomServiceImpt();
        boolean insertSucc = ors.insert("刘义干", "222", 102, "单人间", "2020-4-30", "2022-4-31", 400,3);
        System.out.println(insertSucc);
    }
}