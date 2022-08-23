package dao;

import bean.OpenRoomReconrd;

import java.util.List;

public interface OpenRoomDao {
    //查询全部开房记录
    public List<OpenRoomReconrd> queryAll();

    //根据名字关键字查询开房记录
    public List<OpenRoomReconrd> queryByName(String name);

    //根据开房记录表的id，进行删除该条记录
    public boolean delete(int id);

    //直接查询总收入
    public int querySumMoney();

    //订房需要将userName,idCard,roomId,roomType,startTime,endTime,money，8个信息插入到开房记录表中去
    public boolean insert(String userName,String idCard ,int rooId,String roomType,String startTime,String endTime,int money,int day);

    //查询数据总数量
    public int getTotalCount();

    //查询指定页面的数据（页面的开始值，页面的数据总数）
    //pageStart = (currentPage-1)*5 +1
    public List<OpenRoomReconrd> selectReconrdsByPage(int currentPage,int pageSize);

}
