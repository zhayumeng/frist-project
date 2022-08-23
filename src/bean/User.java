package bean;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String idCard;

}
