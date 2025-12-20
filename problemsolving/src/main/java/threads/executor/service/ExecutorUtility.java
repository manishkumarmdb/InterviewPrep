package threads.executor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorUtility {

    /*
    * execute()
    * shutDown() ---- shutting down after execution
    * awaitTermination()
    * Future ---- stores data received by submit()
    * submit(new Runnable()) ---- returns null
    * submit(new Callable()) ---- returns data
    * invokeAny() ---- returns only single data from list of callable objects
    * invokeAll() ---- returns list of future objects
    * */

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println(new Date());
        // execute, shutDown, awaitTermination
        /*
        for (int i = 0; i < 25; i++) {
            es.execute(new ServiceRunnable(i));
        }
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        */
        // submit
        /*List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            // submit(Runnable) is void and returns null always
            // futureList.add((Future<String>) es.submit(new ServiceRunnable(i)));
            // submit(Callable) has return data
            futureList.add(es.submit(new ServiceCallable(i)));
        }*/
        // invokeAny, invokeAll
        List<Callable<String>> serviceCallableList = new ArrayList<>();
        serviceCallableList.add(new ServiceCallable(1));
        serviceCallableList.add(new ServiceCallable(2));
        serviceCallableList.add(new ServiceCallable(3));
        serviceCallableList.add(new ServiceCallable(4));
        serviceCallableList.add(new ServiceCallable(5));
        serviceCallableList.add(new ServiceCallable(6));
        serviceCallableList.add(new ServiceCallable(7));
        serviceCallableList.add(new ServiceCallable(8));
        //String str = es.invokeAny(serviceCallableList); // return only one data from the list and can be any data from the given list
        List<Future<String>> futureList = es.invokeAll(serviceCallableList);

        //
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("====================");
        //System.out.println("str : " + str);
        for (Future<String> f : futureList) {
            System.out.println(f.get());
        }
        System.out.println(new Date());
    }
}

class ServiceRunnable implements Runnable {

    int i;
    public ServiceRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("In thread : " + i);
    }
}

class ServiceCallable implements Callable<String> {

    int  i;

    public ServiceCallable(int i) {
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("In Thread " + i);
        return "From Thread " + i;
    }
}