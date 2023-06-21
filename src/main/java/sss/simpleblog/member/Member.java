package sss.simpleblog.member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    String id;
    String password;
    String userName;
}
