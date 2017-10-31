import com.sun.xml.internal.ws.util.CompletedFuture;

import javax.security.auth.kerberos.DelegationPermission;
import java.sql.CallableStatement;
import java.util.Collection;
import java.util.concurrent.*;

public class Main1 {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        System.out.println(executorService.submit(thread1));
        System.out.println(executorService.submit(thread2));
        executorService.shutdown();
    }

    static  class Thread1 implements Callable<Integer>{
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 5; i++){
                j += i;
            }
            System.out.println(j);
            return j;
        }
    }

}
