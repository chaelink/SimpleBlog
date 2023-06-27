package sss.simpleblog.post;

public interface PostService {
    /**
     * 방문자 수를 증가시킵니다.
     * @param post
     * @return 성공 시 해당 포스트, 실패 시 null
     */
    Post visitPost(Post post);

    Post createPost(Long uid, String username, String title, String contents);
    Post modifyPost(Post post, String contents);
    Post removePost(String title);
}
