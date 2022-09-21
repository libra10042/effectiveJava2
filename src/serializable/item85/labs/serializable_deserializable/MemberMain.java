package serializable.item85.labs.serializable_deserializable;

import java.io.*;
import java.util.Base64;

public class MemberMain {
    public static void main(String[] args) {
        MemberMain m = new MemberMain();
        Member member =new Member("jin", "jin@naver.com", 25);

        m.serialize(member);
    }

    // Serialize method
    public byte[] serialize(Member member){
        byte[] serializedMember = new byte[0];
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(member);
                // serializedMember -> 직렬화된 member 객체
                serializedMember = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
        System.out.println(Base64.getEncoder().encodeToString(serializedMember));
        return serializedMember;
    }

}
