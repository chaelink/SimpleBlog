package sss.simpleblog.member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    Long uid;
    String userName;
    String password;
}
