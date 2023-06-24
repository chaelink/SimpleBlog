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
    private Long uid;
    private String userName;
    private Date date;
    private String title;
    private String contents;
    private List<Comment> comments;
    private Long hits;

    @Override
    public int compareTo(Post o) {
        return this.getDate().compareTo(o.getDate());
    }
}
