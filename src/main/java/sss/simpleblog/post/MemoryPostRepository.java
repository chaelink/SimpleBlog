package sss.simpleblog.post;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryPostRepository implements PostRepository {
    private final Map<Long, Post> store = new HashMap<>();

    @Override
    public Post save(Post post) {
        // Comment: 이런식으로 서비스 계층에서 새글 작성 시 구현하면 편할 것 같습니다!
        // post.setUid((long)store.size());
        // post.setDate(new Date());
        return store.put(post.getUid(), post);
    }

    public Post remove(List list) {
        return store.remove(list);
    }

    @Override
    public Post findByUid(Long uid) {
        return store.get(uid);
    }

    @Override
    public List<Post> findByUsername(String userName) {
        List <Post> findList = new ArrayList<>();

        for (Post post: store.values()) {
            if (post.getUserName().equals(userName)) {
                findList.add(post);
            }
        }

        return findList;
    }

    @Override
    public List<Post> findByTitle(String title) {
        List <Post> findList = new ArrayList<>();

        for (Post post: store.values()) {
            if (post.getTitle().equals(title)) {
                findList.add(post);
            }
        }

        return findList;
    }

    @Override
    public List<Post> findByIncludeTitle(String title) {
        List <Post> findList = new ArrayList<>();

        for (Post post: store.values()) {
            if (post.getTitle().contains(title)) {
                findList.add(post);
            }
        }

        return findList;
    }

    @Override
    public List<Post> findByIncludeContents(String contents) {
        List <Post> findList = new ArrayList<>();

        for (Post post: store.values()) {
            if (post.getContents().contains(contents)) {
                findList.add(post);
            }
        }

        return findList;
    }

    @Override
    public List<Post> findByDateOrderedPage(Long pagingNum, Long pageOffset, boolean isDescent) {
        List<Post> data = new ArrayList<>(store.values());
        List<Post> findList = new ArrayList<>();

        int startIndex = pagingNum.intValue() * pageOffset.intValue();
        int lastIndex = Math.min(store.size(), startIndex + pagingNum.intValue());

        if (isDescent) {
            Collections.reverse(data);
        } else {
            Collections.sort(data);
        }

        for (int i = startIndex; i < lastIndex; i++) {
            findList.add(data.get(i));
        }

        return findList;
    }
}
