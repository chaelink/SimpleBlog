package sss.simpleblog.blog;

import java.util.HashMap;
import java.util.Map;

public class MemoryBlogRepository implements BlogRepository {
    private final Map<Long, Blog> store = new HashMap<>();

    @Override
    public Blog save(Blog blog) {
        return store.put(blog.getUid(), blog);
    }

    @Override
    public Blog findByUid(Long uid) {
        return store.get(uid);
    }

    @Override
    public Blog findByUserName(String userName) {

        for (Blog blog: store.values()) {
            if (blog.getUserName().equals(userName)) {
                return blog;
            }
        }
        
        return null;
    }
}
