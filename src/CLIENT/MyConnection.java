package CLIENT;


import doanltm.LOGIN;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class MyConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy MySQL JDBC Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối đến cơ sở dữ liệu");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        LOGIN LOGINFrame = new LOGIN();
        LOGINFrame.setVisible(true);
        LOGINFrame.pack();
        LOGINFrame.setLocationRelativeTo(null);
    }

    
}
