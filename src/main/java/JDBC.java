import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    private static JDBC instance;
    private Connection conn;

    public static JDBC getInstance(){
        if(instance == null){
            instance = new JDBC();
        }
        return instance;
    }

    private JDBC(){
        try {
            conn = DriverManager.getConnection(Const.dbURL, Const.username, Const.password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertInfo(String name) throws SQLException {
        String sql = "INSERT INTO thread(name) values('" + name + "')";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.executeUpdate();
    }
}
