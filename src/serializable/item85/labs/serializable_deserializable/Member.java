package serializable.item85.labs.serializable_deserializable;

import java.io.Serializable;
/**
 * @see <a href="https://techblog.woowahan.com/2551/">자바 직렬화 그것이 알고 싶다.- 우아한 형제들 기술 블로그.</a>
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private int age;
    // 추가된 멤버 변수.
    private String nick;

    public Member(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", nick='" + nick + '\'' +
                '}';
    }
}
