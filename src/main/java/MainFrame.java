
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class MainFrame extends JFrame {
    public Connection conn;
    public MainFrame(Connection conn) throws SQLException {

        ImageIcon img = new ImageIcon("src/main/java/maxresdefault.jpg");
        this.setIconImage(img.getImage());

        this.conn = conn;
        createWindow();
        JTable table = createTable();

        JScrollPane sp = new JScrollPane(table);
        this.add(sp, BorderLayout.CENTER);


        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(10,10, d.width / 2, d.height / 2);

    }

    public void createWindow(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public JTable createTable() throws SQLException {
        Vector<Vector<String>> data = new Vector<>();

        Vector<String> head = new Vector<>();

        head.add("Pasanger Name");
        head.add("Passanger ID");

        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery("SELECT passenger_name, passenger_id FROM tickets");

        while(resultSet.next()){

            String name = resultSet.getString("passenger_name");
            String id = resultSet.getString("passenger_id");

            Vector<String> row = new Vector<>();

            // add name and id to a row and then to the data vector
            row.add(name);
            row.add(id);

            data.add(row);
        }

        return new JTable(data, head);

    }
}

