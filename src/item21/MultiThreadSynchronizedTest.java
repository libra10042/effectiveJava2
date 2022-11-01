package item21;

import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadSynchronizedTest {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final Logger log = LoggerFactory.getLogger(MultiThreadSynchronizedTest.class);

    @Test
    void testSingleThread() throws InterruptedException{
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("js");
        list.add("python");

        SynchronizedCollection<String> sc = SynchronizedCollection.synchronizedCollection(list);

        String a = "js";

        sc.forEach((s) -> {
            System.out.println("before" + s);
        });

        // thread 10개 생성
        int nThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);

        for (int i = 0; i < nThread; i++) {
            executorService.submit(() -> {
                int idx = counter.addAndGet(1);

                System.out.println("idx : " + idx + " - removeIf " + sc.removeIf(p -> p.equals(a)));
                return null;
            });
        }

        executorService.awaitTermination(1, TimeUnit.SECONDS);

        sc.forEach((s)-> {
            System.out.println(s);
        });
    }

}
