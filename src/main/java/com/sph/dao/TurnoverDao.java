package com.sph.dao;

import com.sph.pojo.Turnover;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Repository
public class TurnoverDao
{
    public void deposit(String fk, Integer amount, Integer balance) throws ParseException
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "insert into turnover(fk,type,amount,date)values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fk);
            ps.setString(2, "存款");
            ps.setInt(3, amount);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "update account set balance = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, balance);
            ps.setString(2, fk);
            ps.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void withdraw(String fk, Integer amount, Integer balance)
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "insert into turnover(fk,type,amount,date)values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fk);
            ps.setString(2, "取款");
            ps.setInt(3, amount);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "update account set balance = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, balance);
            ps.setString(2, fk);
            ps.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @SneakyThrows
    public Collection<Turnover> list(String fk)
    {
        Map<Integer, Turnover> res = new HashMap<Integer,Turnover>();
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "select * from turnover where fk like ? order by id desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fk);
            rs = ps.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        int idx = 1;
        while (rs.next())
        {
            res.put(idx++, new Turnover(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4),
                    rs.getDate(5)));
        }
        return res.values();
    }

    @SneakyThrows
    public Integer todayWithdraw(String fk)
    {
        Integer res = 0;
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javabank?" +
                    "user=root&password=root");
            String sql = "select amount from turnover where fk like ? and type like ? and date like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fk);
            ps.setString(2, "取款");
            ps.setDate(3, new Date(System.currentTimeMillis()));
            rs = ps.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        while (rs.next())
        {
            try
            {
                res += rs.getInt(1);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return res;
    }
}
