package com.sph.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AccountDao
{
    public ResultSet query(String id) throws SQLException
    {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "select * from account where id like ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return rs;
    }
}
