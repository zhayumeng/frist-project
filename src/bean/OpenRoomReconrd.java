package bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OpenRoomReconrd {
    private int reconrdRoomId;
    private String userName;
    private String idCard;
    private int roomId;
    private String roomType;
    private String startTime;
    private String endTime;
    private int money;
    private int day;


}
