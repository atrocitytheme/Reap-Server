package server.reaptheflag.reaptheflag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.reaptheflag.reaptheflag.service.NetworkConditionChecker;
import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@SpringBootTest
public class NetworkCondtionTest {
    /**
     * test checker in multithraed condition
     * */
    @Test
    public void multiThreadConditionEnsure() {
        NetworkConditionChecker checker = new NetworkConditionChecker();
        ExecutorService poolService = Executors.newFixedThreadPool(10);
        Function<Integer, Runnable> func_selector = (Integer i) -> {
          int target = i;
          return () -> {
              if (target == 18) {
                  checker.setUdpCondition(false);
              }

              else {
                  checker.getUdpCondition();
              }
          };
        };
        for (int i = 0; i < 20; i++) {
            poolService.execute(func_selector.apply(i));
        }

        poolService.shutdown();
        try {
            poolService.awaitTermination(6000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return;
        }
        assertFalse(checker.getUdpCondition());
    }
}
