package service.Impt;

import bean.OpenRoomReconrd;
import dao.OpenRoomDao;
import dao.impt.OpenRoomDaoImpt;
import service.OpenRoomService;

import java.util.List;

public class OpenRoomServiceImpt implements OpenRoomService {

    OpenRoomDao ord = new OpenRoomDaoImpt();

    @Override//查询全部开房记录
    public List<OpenRoomReconrd> queryAll() {
        List<OpenRoomReconrd> result = ord.queryAll();
        return result;
    }

    @Override//根据名字关键字查询开房记录
    public List<OpenRoomReconrd> queryByName(String name) {
        List<OpenRoomReconrd> result = ord.queryByName(name);
        return result;

    }

    @Override//根据开房记录表的id，进行删除该条记录
    public boolean delete(int id) {
        boolean deleteSucc = ord.delete(id);
        return deleteSucc;
    }

    @Override//根据开发记录表，进行查询总收入金额
    public int querySumMoney() {
        int sumMoney = ord.querySumMoney();
        return sumMoney;
    }

    @Override
    public boolean insert(String userName, String idCard, int roomId, String roomType, String startTime, String endTime, int money,int day) {
        boolean insertSucc = ord.insert(userName, idCard, roomId, roomType, startTime, endTime, money,day);
        return insertSucc;
    }

    @Override
    public int queryTotalCount() {
        //调用dao中的查询总数量的方法，返回总页数
        int totalCount = ord.getTotalCount();
        return totalCount;
    }

    @Override
    public List<OpenRoomReconrd> queryPageRecords(int currentPage, int pageSize) {
        //调用dao中的查询单页数据方法返回单页的开房记录信息
        List<OpenRoomReconrd> openRoomReconrds = ord.selectReconrdsByPage(currentPage, pageSize);
        return openRoomReconrds;
    }
}
