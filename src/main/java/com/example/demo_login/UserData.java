package com.example.demo_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserData {

    public void connect(Users user) throws SQLException, ClassNotFoundException {
        //Connection and Open connection
        //Class.forName("com.example.jdbc.Driver");

        String url = "jdbc:postgresql://localhost:5432/db_users";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","nhuchuahechia");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);



        String sql_insert = "INSERT INTO user_info_2(user_name, user_password" +
                    "VALUES(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql_insert);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPassword());
        pstmt.execute();

    }
}