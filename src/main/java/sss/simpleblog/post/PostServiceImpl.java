package sss.simpleblog.post;

import lombok.RequiredArgsConstructor;
import sss.simpleblog.comment.Comment;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final MemoryPostRepository memoryPostRepository;

    @Override
    public Post visitPost(Post post) {
        post.setHits(post.getHits() + 1);
        return memoryPostRepository.save(post);
    }

    @Override
    public Post createPost(Long uid, String username, String title, String contents) {
        Date date = new Date();
        List<Comment> comments = new ArrayList<Comment>();
        long hits = 0;

        return new Post(uid, username, date, title, contents, comments, hits);
    }

    @Override
    public Post modifyPost(Post post, String contents) {
        Date date = new Date();
        post.setDate(date);
        post.setContents(contents);
        return memoryPostRepository.save(post);
    }

    @Override
    public Post removePost(String title) {
        List<Post> toRemoveList = memoryPostRepository.findByTitle(title);
        memoryPostRepository.remove(toRemoveList);
        return null;
    }
}
