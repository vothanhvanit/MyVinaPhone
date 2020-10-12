package com.example.myvinaphone.util;


import com.example.myvinaphone.data.model.JDBCModel;

import java.sql.Connection;

public class JDBCController {
    JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}
