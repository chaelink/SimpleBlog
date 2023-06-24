package sss.simpleblog.comment;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    private Long uid;
    private String userName;
    private Date date;
    private String content;
    private boolean isSecret;
}
