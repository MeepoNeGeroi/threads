import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        int count = getCount();

        for(int i=1; i <= count; i++) {
            new JThread(i + "").start();
        }
    }

    public static int getCount() throws IOException {
        int count;

        FileReader f = new FileReader(Const.path);
        BufferedReader br = new BufferedReader(f);

        count = Integer.parseInt(br.readLine());

        return count;
    }
}
