package sss.simpleblog.postService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sss.simpleblog.post.MemoryPostRepository;
import sss.simpleblog.post.Post;
import sss.simpleblog.post.PostService;
import sss.simpleblog.post.PostServiceImpl;

import java.util.Date;

public class PostServiceImplTest {
    MemoryPostRepository memoryPostRepository = new MemoryPostRepository();
    PostService postService = new PostServiceImpl(memoryPostRepository);
    @Test
    void create () {
        Post post = postService.createPost(1L,"chaelin","title","contents");
        Date date = post.getDate();

        Assertions.assertThat(post.getUid()).isEqualTo(1L);
        System.out.println(date);
    }

    @Test
    void modify() {
        Post post1 = postService.createPost(2L,"chae","title","contents");
        postService.modifyPost(post1,"new contents");
        Assertions.assertThat(post1.getContents()).isEqualTo("new contents");
    }

}
