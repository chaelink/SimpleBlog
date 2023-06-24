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
public class Post implements Comparable<Post> {
    Long uid;
    String userName;
    Date date;
    String title;
    String contents;
    List<Comment> comments;
    Long hits;

    @Override
    public int compareTo(Post o) {
        return this.getDate().compareTo(o.getDate());
    }
}
