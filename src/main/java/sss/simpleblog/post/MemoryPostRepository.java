package sss.simpleblog.post;

import java.util.List;

public class MemoryPostRepository implements PostRepository {
    @Override
    public void save(Post post) {
        
    }

    @Override
    public Post findByUid(Long uid) {
        return null;
    }

    @Override
    public List<Post> findByUsername(String userName) {
        return null;
    }

    @Override
    public List<Post> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Post> findByIncludeTitle(String title) {
        return null;
    }

    @Override
    public List<Post> findByIncludeContents(String contents) {
        return null;
    }

    @Override
    public List<Post> findByDateOrderedPage(Long pagingNum, Long pageOffset, boolean isDescent) {
        return null;
    }
}
