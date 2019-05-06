package com.Dao.impl;

import com.Dao.UsersDao;
import com.Entity.User;
import com.Service.DbCoon;
import com.Service.impl.DbCoonImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UsersDao {



    @Override
    public boolean addUser(User user) {
        DbCoon DbCoon = new DbCoonImpl();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {

            connection = DbCoon.getConnection();
            ps = connection.prepareStatement("INSERT INTO t_users(username,password) VALUE (?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbCoon.closePreparedStatement(ps);
            DbCoon.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public boolean checkUsername(String username) {
        DbCoon DbCoon = new DbCoonImpl();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try{
            connection = DbCoon.getConnection();
            ps = connection.prepareStatement("SELECT * FROM t_users WHERE username=?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DbCoon.closeResultSet(rs);
            DbCoon.closePreparedStatement(ps);
            DbCoon.closeConnection(connection);
        }
        System.out.println(flag);
        return flag;
    }

    @Override
    public boolean checkPassword(String username,String password) {
        DbCoon DbCoon = new DbCoonImpl();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try{
            connection = DbCoon.getConnection();
            ps = connection.prepareStatement("SELECT username FROM t_users WHERE username=?AND password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DbCoon.closeResultSet(rs);
            DbCoon.closePreparedStatement(ps);
            DbCoon.closeConnection(connection);
        }
        return flag;
    }
}

