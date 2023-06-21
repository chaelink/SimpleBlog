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
    String id;
    List<Post> posts;
    Long hits;
}