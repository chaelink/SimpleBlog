package sss.simpleblog.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    Map<String, Member> members = new HashMap<>();
    public void signUp(Member member) {
        validate(member.getUserName());
        validateUsernameExists(member);
        save(member);
    }

    private void save(Member member) {
        members.put(member.getUserName(), member);
    }

    private void validate(String str) {
        if (str == null)
            throw new NullPointerException();
        if (str.isBlank())
            throw new IllegalArgumentException();
    }

    private void validateUsernameExists(Member member) {
        for (Member m : members.values()) {
            compareUsername(member.getUserName(), m.getUserName());
        }
    }

    private static void compareUsername(String m1, String m2) {
        if (!isDifferent(m1, m2))
            throw new IllegalArgumentException();
    }

    public Member findMember(String username) {
        return members.get(username);
    }

    public void login(String username, String passwd) {
        validate(username);
        validate(passwd);
        checkMatching(username, passwd);
    }

    private void checkMatching(String username, String passwd) {
        Member member = findMember(username);

        if (isDifferent(member.getPassword(), passwd)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDifferent(String str1, String str2) {
        return str1.compareTo(str2) != 0;
    }
}
