package sss.simpleblog.post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final MemoryPostRepository memoryPostRepository;

    @Override
    public Post visitPost(Post post) {
        post.setHits(post.getHits() + 1);
        return memoryPostRepository.save(post);
    }
}
