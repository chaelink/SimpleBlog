package sss.simpleblog.member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    private Long uid;
    private String userName;
    private String password;
}
