package sss.simpleblog.comment;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    String id;
    Date date;
    String content;
    boolean isSecret;
}
