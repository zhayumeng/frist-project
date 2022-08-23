package service;

import bean.OpenRoomReconrd;

import java.util.List;

public interface OpenRoomService {

    //查询全部开房记录
    public List<OpenRoomReconrd> queryAll();

    //根据名字关键字查询开房记录
    public List<OpenRoomReconrd> queryByName(String name);

    //根据开房记录表的id，进行删除该条记录
    public boolean delete(int id);

    //直接查询开房记录表中的总收入
    public int querySumMoney();

    //订房需要将userName,idCard,roomId,roomType,startTime,endTime,money，8个信息插入到开房记录表中去
    public boolean insert(String userName,String idCard ,int rooId,String roomType,String startTime,String endTime,int money,int day);

    //查询总人数
    public int queryTotalCount();

    //查询每页学生信息
    public List<OpenRoomReconrd> queryPageRecords(int currentPage,int pageSize);
}
