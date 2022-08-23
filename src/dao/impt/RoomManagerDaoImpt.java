package dao.impt;

import bean.Room;
import dao.RoomManagerDao;

import java.util.List;

public class RoomManagerDaoImpt implements RoomManagerDao {


    @Override//查询房间所有信息
    public List<Room> queryAll() {
        String sql = "select * from t_room";
        List<Room> roomList = BaseDao.QueryReturnList(Room.class, sql);
        return roomList;
    }

    @Override//根据房间主键，修改房间信息，只修改房间类型，价格/天，房间说明这三个属性
    public boolean updateRoomIfm(int id,String roomType,int price,String introduce) {
        String sql = "update t_room set roomType = ?,price = ?,introduce = ? where roomid = ?";
        boolean modifySucc = BaseDao.update(sql, roomType, price, introduce, id);
        return modifySucc;

    }

    @Override//根据房间id, 当用户订房时候，修改房间状态
    public boolean updateStatus(int roomid,String state) {
        String sql = "update t_room set status = ? where roomid = ?";
        boolean updateSucc = BaseDao.update(sql, state, roomid);
        return updateSucc;
    }

    @Override
    public List<Room> queryOne(int roomid) {
        String sql ="select * from t_room where roomid = ?";
        List<Room> room = BaseDao.QueryReturnList(Room.class, sql, roomid);
        return room;
    }
}
