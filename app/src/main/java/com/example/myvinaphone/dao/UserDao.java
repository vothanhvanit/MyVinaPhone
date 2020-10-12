package com.example.myvinaphone.dao;
import com.example.myvinaphone.util.JDBCController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserDao() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    //
    public boolean checkLogin(String username, String password )  {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();// Tạo đối tượng Statement.
            String sql = "select * from user_ttkd  where username = '" + username+"' and password='" + password +"'";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                connection.close();// Đóng kết nối
                result =  true;
                break;
              }
        }
        catch (Exception  ex) {
            result =  false;
        }

        return result;
    }
}
