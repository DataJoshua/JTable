import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private Connection conn;
    public DB_Connection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        conn = DriverManager.getConnection(url , "postgres", "root");
    }

    public  Connection getConn(){
        return  this.conn;
    }
}
