package service;

import bean.Room;

import java.util.List;

public interface RoomManagerService {

    //查询房间基本信息
    public List<Room> selectAll();

    //修改房间信息，通过房间号，去修改类型，价格，说明
    public boolean updateRoomIfm(int roomid,String roomType,int price,String introduce);

    //通过房间id,当房间被订房的时候，需要把房间状态修改为   占用occupy
    public boolean updateStatus(int roomid,String state);

    //通过房间id，拿到该房间对象，进行查看该房间的状态
    public List<Room> queryOne(int roomid);
}
