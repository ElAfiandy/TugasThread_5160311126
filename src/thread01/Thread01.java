package thread01;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.concurrent.Task;

public class Thread01{
    int id;
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(1);
        for (int i=1; i<=5; i++){
            service.submit(new Task1(i));
        }
        service.isShutdown();
        try{
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Task1 implements Runnable{
    public int id;
    public Task1(int id){
    this.id = id;
    }

    public void run(){
    for (int i = 0; i < 100; i++) {
            if(i%2==1){
                System.out.println(" Task "+id+"-> " + i);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Selesai Task"+id);
    }
}