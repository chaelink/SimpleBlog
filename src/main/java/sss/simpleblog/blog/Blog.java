package sss.simpleblog.blog;

import lombok.*;
import sss.simpleblog.post.Post;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Blog {
    private Long uid;
    private String userName;
    private List<Post> posts;
    private Long hits;
}