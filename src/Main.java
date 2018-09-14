import com.base.practice.lock.Customer;
import com.base.practice.lock.Producer;
import com.base.practice.lock.Resource;
import com.base.practice.lock.Resource2;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        Resource2 resource = new Resource2();
        Producer producer = new Producer(resource);
        Customer customer = new Customer(resource);

        Thread th1 = new Thread(producer);
        Thread th2 = new Thread(customer);
        th1.start();
        th2.start();

    }
}
