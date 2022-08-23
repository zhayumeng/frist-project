package dao;

import bean.Room;

import java.util.List;

public interface RoomManagerDao {
    //查询房间信息
    public List<Room> queryAll();

    //通过房间主键，进行修改房间信息，只修改房间类型，价格/天，房间说明这三个属性
    public boolean updateRoomIfm(int id,String roomType,int price,String introduce);

    //通过房间id,当房间被订房的时候，需要把房间状态修改为   占用occupy
    public boolean updateStatus(int roomid,String state);

    //通过房间id，拿到该房间对象，进行查看该房间的状态
    public List<Room> queryOne(int roomid);
}
