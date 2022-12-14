import java.sql.SQLException;

public class Runn {
    public static void main(String[] args) throws SQLException {
        DB_Connection conn = new DB_Connection();
        new MainFrame(conn.getConn());

    }
}
