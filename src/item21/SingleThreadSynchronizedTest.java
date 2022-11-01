package item21;

import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SingleThreadSynchronizedTest {
    private static final Logger log = LoggerFactory.getLogger(SingleThreadSynchronizedTest.class);

    @Test
    void testSingleThread(){
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("js");
        list.add("python");

        SynchronizedCollection<String> sc = SynchronizedCollection.synchronizedCollection(list);

        String a = "js";

        sc.forEach((s) -> {
            System.out.println(s);
        });

        sc.removeIf(p -> p.equals("js")); // 아파치 라이브러리에는 존재하지 않지만 자바 1.8의 디폴트 메서드로 구현됨

        sc.forEach((s)-> {
            System.out.println(s);
        });
    }
}
