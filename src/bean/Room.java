package bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Room {
    private int roomId;
    private String roomType;
    private int price;
    private String status;
    private String introduce;


}
