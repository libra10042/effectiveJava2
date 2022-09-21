package serializable.item85.solution;

import serializable.item85.Employee;

import java.io.*;
/**
 * @see <a href="https://techblog.woowahan.com/2551/">자바 직렬화 그것이 알고 싶다.</a>
 */
public class SerializationFilter {
    public static void main(String[] args) throws Exception{

        // Serialization
        Employee emp = new Employee("Test Name", "Test title");
        String filename = "employee.ser";
        FileOutputStream filewrite = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(filewrite);
        out.writeObject(emp);
        out.close();
        filewrite.close();

        // Deserialization
        FileInputStream fileread = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileread);

        // 개별 스트림에 대한 사용자 정의 필터 설정 ( 람다식 사용. )
        in.setObjectInputFilter(info -> ((info.serialClass() != null)
                        && info.serialClass().getName().equals("com.example.Employee"))
                ? ObjectInputFilter.Status.REJECTED : ObjectInputFilter.Status.UNDECIDED);
        Employee empread = (Employee) in.readObject();

    }
}
