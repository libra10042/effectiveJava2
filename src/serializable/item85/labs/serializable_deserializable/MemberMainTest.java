package serializable.item85.labs.serializable_deserializable;




import groovy.transform.builder.Builder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.*;

import static org.junit.Assert.assertThat;

public class MemberMainTest {

    @DisplayName("Serializable을 구현한 Person 객체 직렬화 테스트")
    @Test
    public void writeObjectTest() throws IOException {
        Person person = new Person("bingbong", 21);

        byte[] serializedPerson;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(person);
                // 직렬화된 Person 객체
                serializedPerson = baos.toByteArray();
            }
        }
        // 요런 식으로 나옴
        // -84, -19, 0, 5, 115, 114, 0, 57, 99, 111, 109, 46, 98, 105, 110, 103, 98, 111, 110, 103, 46, 101, 102, 102, 101, 99, 116, 105, 118, 101, 106, 97, 118, 97, 46, 105, 116, 101, 109, 56, 53, 46, 83, 101, 114, 105, 97, 108, 105, 122, 97, 98, 108, 101, 84, 101, 115, 116, 36, 80, 101, 114, 115, 111, 110, -126, 113, -121, -86, 125, 92, 57, 9, 2, 0, 2, 73, 0, 3, 97, 103, 101, 76, 0, 4, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 0, 0, 0, 21, 116, 0, 8, 98, 105, 110, 103, 98, 111, 110, 103
        System.out.println(serializedPerson.toString());
    }
    @DisplayName("Serializable을 구현한 Person 객체 직렬화 후, 역직렬화 테스트")
    @Test
    void writeObjectTest2() throws IOException {
        Person person = new Person("bingbong", 21);

        byte[] serializedPerson;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(person);
                // 직렬화된 Person 객체
                serializedPerson = baos.toByteArray();
            }
        }

        Person deSerializedPerson = null;

        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedPerson)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 역직렬화된 Person 객체
                deSerializedPerson = (Person) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}