package com.example.myvinaphone.dao;

import com.example.myvinaphone.util.JDBCController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LogDao {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public LogDao() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }


    public boolean InsertLog(String username, String keyword, String menu_log) throws SQLException {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.LONG,
                Locale.US);
        java.util.Date utilDate = new java.util.Date();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "insert into history_search_sdt_giong(username, cum_so_giong, thoi_diem, menu_log) values('" + username + "','"+ keyword +"','" + dateFormat.format(new Date()) + "','" + menu_log +"')";
        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }
}
