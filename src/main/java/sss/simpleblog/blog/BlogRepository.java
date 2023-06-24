package sss.simpleblog.blog;

public interface BlogRepository {

    Blog save(Blog blog);

    Blog findByUid(Long uid);

    Blog findByUserName(String userName);
}
