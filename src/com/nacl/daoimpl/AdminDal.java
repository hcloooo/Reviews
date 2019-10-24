package com.nacl.daoimpl;

import com.nacl.dao.AdminIDal;
import com.nacl.entity.Admin;
import com.nacl.tool.ConnectionHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDal implements AdminIDal {

    ConnectionHelper helper=new ConnectionHelper();
    private List<Object> parms=null;
    private String className=getClass().getName();
    private String tableName=className.substring(className.lastIndexOf(".")+1, className.indexOf("Dal"));
    public  Admin getEntityById(int id){
        Admin entity=null;
        String sql="select * from "+"Admin" +" where 1=1 and ID=?";
        List<Object> parms=new ArrayList<Object>();
        parms.add(id);
        ResultSet rs=helper.getEntityById(sql,parms);
        try {
            while(rs.next()){
                entity=new Admin(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;

    }
    public List<Admin> getEntities(){
        List<Admin> entities=new ArrayList<Admin>();
        String sql="select *from Admin";
        List<Object> parms=new ArrayList<Object>();
        parms=new ArrayList<Object>();
        ResultSet rs=helper.getEntities(sql,parms);
        try {
            while(rs.next()){
                entities.add(new Admin(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  entities;
    }


    public int addEntity(Admin entity) {
        String sql="insert into "+tableName+" values(?,?,?,?)";
        parms=new ArrayList<Object>();
        parms.add(entity.getName());
        parms.add(entity.getPwd());
        parms.add(entity.getNote());
        parms.add(entity.getState());
        int num=helper.executeUpdate(sql,parms);
        return num;
    }


    public int deleteEntity(int id) {
        int num=0;
        String sql="delete "+tableName+" where id=?";
        parms=new ArrayList<Object>();
        parms.add(id);
        num=helper.executeUpdate(sql,parms);
        return num;
    }


    public int updateEntity(Admin entity) {
        int num=0;
        String sql="update "+tableName+" set Name=?,Pwd=?,Note=?,State=? where Id=?";
        parms =new ArrayList<Object>();
        parms.add(entity.getName());
        parms.add(entity.getPwd());
        parms.add(entity.getNote());
        parms.add(entity.getState());
        parms.add(entity.getId());
        num=helper.executeUpdate(sql,parms);
        return num;
    }
}
