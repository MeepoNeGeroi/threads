import java.sql.SQLException;

public class JThread extends Thread{
    private boolean fl = true;
    private final static Object lock = new Object();
    JThread(String name){
        super(name);
    }

    public void run(){
        while (true) {
            if(fl){
                try {
                    JDBC.getInstance().insertInfo("Поток " + Thread.currentThread().getName() + " выполняется!");
                    fl = false;
                } catch (SQLException throwables) {
                    fl = false;
                    System.out.println("INSERT INTO thread(name) values(" + Thread.currentThread().getName() + ")");
                }
            }
            System.out.println("Поток " + Thread.currentThread().getName() + " выполняется!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}