package sss.simpleblog.post;

import java.util.List;

public interface PostRepository {

    /**
     *
     * @param post auto increased uid
     * @return if failed return null, else return post
     */
    Post save(Post post);

    /**
     * uid와 일치한 포스트를 리턴
     * @param uid 고유 식별자
     * @return 포스트가 존재시 리턴, 실패시 null
     */
    Post findByUid(Long uid);

    /**
     * 해당 유저이름과 일치한 포스트들을 리턴
     * @param userName 유저이름
     * @return 포스트들이 존재시 리턴, 실패시 null
     */
    List<Post> findByUsername(String userName);

    /**
     * 해당 제목과 일지한 포스트를 리턴
     * @param title 제목
     * @return 포스트가 존재시 리턴, 실패시 null
     */
    List<Post> findByTitle(String title);

    /**
     * 해당 제목과 일치한 포스트들을 리턴
     * @param title 제목
     * @return 포스트들이 존재시 리턴, 실패시 null
     */
    List<Post> findByIncludeTitle(String title);

    /**
     * 해당 게시글이 포함된 포스트들을 리턴
     * @param contents 내용
     * @return 포스트들이 존재시 리턴, 실패시 null
     */
    List<Post> findByIncludeContents(String contents);

    /**
     * 포스트를 날짜순으로 페이징합니다
     * @param pagingNum 한번에 페이징하는 게시글 수
     * @param pageOffset 가져올 페이지
     * @param isDescent 내림차 순인가
     * @return 해당 페이지가 존재한다면 리턴, 실패시 null
     */
    List<Post> findByDateOrderedPage(Long pagingNum, Long pageOffset, boolean isDescent);
}
