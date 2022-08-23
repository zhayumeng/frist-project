package service.Impt;

import bean.Room;
import dao.RoomManagerDao;
import dao.impt.RoomManagerDaoImpt;
import service.RoomManagerService;

import java.util.List;

public class RoomManagerServiceImpt implements RoomManagerService {

    RoomManagerDao rmd = new RoomManagerDaoImpt();
    @Override
    public List<Room> selectAll() {
        List<Room> rooms = rmd.queryAll();
        return rooms;
    }

    @Override
    public boolean updateRoomIfm(int roomid, String roomType, int price, String introduce) {
        boolean updateSucc = rmd.updateRoomIfm(roomid, roomType, price, introduce);
        return updateSucc;
    }

    @Override
    public boolean updateStatus(int roomid, String state) {
        boolean updateState = rmd.updateStatus(roomid, state);
        return updateState;
    }

    @Override
    public List<Room> queryOne(int room) {
        List<Room> rooms = rmd.queryOne(room);
        return rooms;
    }

}
