package sss.simpleblog.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository repo = new MemberRepository();

    @Test
    @DisplayName("success for first sign up")
    void signUpSuccessTest() {
        // given
        String username = "username";
        String passwd = "password";
        Member member = new Member(1L, username, passwd);

        // when
        repo.signUp(member);

        // then
        assertThat(member).isEqualTo(repo.findMember(username));
        assertThat(member).isNotEqualTo(new Member(-1L, null, null));
    }

    @Test
    @DisplayName("username already exists")
    void alreadyUsernameTest() {
        // given
        String username = "same username";
        Member member1 = new Member(1L, username, "1234");
        Member member2 = new Member(1L, username, "5678");

        // when
        repo.signUp(member1);

        // then
        assertThatThrownBy(() -> repo.signUp(member2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("username is blank")
    void blankUsernameTest() {
        // given
        String username = "";
        String passwd = "passwd";
        Member member = new Member(1L, username, passwd);

        // then
        assertThatThrownBy(() -> repo.signUp(member))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("username matches password")
    void loginSuccess() {
        // given
        String username = "username";
        String passwd = "1234";
        Member member = new Member(1L, username, passwd);

        // when
        repo.signUp(member);

        // then
        assertThatCode(() -> repo.login(username, passwd))
                .doesNotThrowAnyException();
    }
    
    @Test
    @DisplayName("username and password are null or blank")
    void loginFailure() {
        // given
        String username = "username";
        String passwd = "1234";
        Member member = new Member(1L, username, passwd);
        
        // when
        repo.signUp(member);
        
        // then
        assertThatThrownBy(() -> repo.login(null, null))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> repo.login("", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

