package test;

import bean.Room;
import org.junit.jupiter.api.Test;
import service.Impt.RoomManagerServiceImpt;
import service.RoomManagerService;

import java.util.List;


class RoomManagerServiceTest {

    @Test
    void selectAll(){
        RoomManagerService rms = new RoomManagerServiceImpt();
        List<Room> rooms = rms.selectAll();
        System.out.println("查询所有开房信息");
        System.out.println(rooms);
    }

    @Test
    void updateIfm(){
        RoomManagerService rms = new RoomManagerServiceImpt();
        boolean updateSucc = rms.updateRoomIfm(101, "单人间", 100, "单人间");
        System.out.println("根据数据进行修改房间个别信息");
        System.out.println(updateSucc);

    }

    @Test
    void updateState(){
        RoomManagerService rms = new RoomManagerServiceImpt();
        boolean updateState = rms.updateStatus(102, "空闲中");
        System.out.println(updateState);

    }


}