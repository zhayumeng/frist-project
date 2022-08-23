package dao.impt;

import bean.OpenRoomReconrd;
import com.fasterxml.jackson.databind.ser.Serializers;
import dao.OpenRoomDao;

import java.util.List;

public class OpenRoomDaoImpt implements OpenRoomDao {
    
    @Override//查询所有开房记录表
    public List<OpenRoomReconrd> queryAll() {
        String sql = "select * from t_openroomreconrd";
        List<OpenRoomReconrd> list = BaseDao.QueryReturnList(OpenRoomReconrd.class, sql);
        return list;
    }

    @Override//通过名字关键字，查询含有名字关键字客户的开房记录表
    public List<OpenRoomReconrd> queryByName(String name) {
        String s ="%"+name+"%";
        String sql = "select * from t_openroomreconrd where userName like ?";
        List<OpenRoomReconrd> list = BaseDao.QueryReturnList(OpenRoomReconrd.class, sql, s);
        return list;
    }

    @Override//通过房间id，删除开房记录
    public boolean delete(int id) {
        String sql = "delete from t_openroomreconrd where reconrdroomid = ?";
        boolean delectSucc = BaseDao.update(sql,id);
        return delectSucc;
    }

    @Override//查询总收入
    public int querySumMoney() {
        String sql = "select sum(money) from t_openroomreconrd";
        int sumMoney = BaseDao.selectSumIncome(sql);
        return sumMoney;
    }

    @Override//订房后，将所有信息插入到开房记录表中去
    public boolean insert(String userName, String idCard, int roomId, String roomType, String startTime, String endTime, int money,int day) {
        String sql = "insert into t_openroomreconrd (userName,idCard,roomId,roomType,startTime,endTime,money,day) values (?,?,?,?,?,?,?,?)";
        boolean updateSucc = BaseDao.update(sql, userName, idCard, roomId, roomType, startTime, endTime, money,day);
        return updateSucc;
    }

    @Override
    public int getTotalCount() {
        //查询数据总数量的具体实现
        String sql = "select count(1) from t_openroomreconrd";
        int count = BaseDao.getTotleCount(sql);
        return count;
    }
    //查询指定页面的数据（页面的开始值，页面的数据总数）
    //pageStart = (currentPage-1)*5 +1
    @Override
    public List<OpenRoomReconrd> selectReconrdsByPage(int currentPage, int pageSize) {
        //查询出当前页面的数据集合
        String sql = "select * from t_openroomreconrd limit ?,?";
        //limit从0开始
        //第一个占位符传pageStart, 页面的开始值，pageStart=(currentPage-1)*5
        //第二个占位符，传pageSize
        List<OpenRoomReconrd> openRoomReconrds = BaseDao.QueryReturnList(OpenRoomReconrd.class, sql, (currentPage - 1) * 5, pageSize);
        return openRoomReconrds;
    }

}
