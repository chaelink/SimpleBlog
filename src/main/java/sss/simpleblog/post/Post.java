package sss.simpleblog.post;

import lombok.*;
import sss.simpleblog.comment.Comment;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    String id;
    Date date;
    String title;
    String contents;
    List<Comment> comments;
    Long hits;
}
