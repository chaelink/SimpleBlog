package sss.simpleblog.comment;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    Long uid;
    String userName;
    Date date;
    String content;
    boolean isSecret;
}
