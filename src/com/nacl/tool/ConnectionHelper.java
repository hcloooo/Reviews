package com.nacl.tool;

import java.sql.*;
import java.util.List;

public class ConnectionHelper {
    //数据库地址
    /*private static final String url = "jdbc:mysql://localhost:3306/EatInXd?useSSL=false";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "qq2016";*/
    private final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url="jdbc:sqlserver://localhost:1433;DatabaseName=EatInXd";
    private final String userName="sa";
    private final String password="qq2016";
    Connection conn=null;
    Statement stmt=null;
    PreparedStatement psmt=null;
    ResultSet rs=null;
    String sql=null;

    public Connection getConnection(){
       try{
           Class.forName(driverName);
       }catch(Exception e){
           System.out.println("驱动加载失败");
           e.printStackTrace();
           return null;
       }try{
           return DriverManager.getConnection(url,userName,password);
        }catch(Exception e){
           System.out.println("数据库连接失败");
           e.printStackTrace();
           return null;
        }
    }
    public void closeAll (Connection conn,PreparedStatement psmt,ResultSet rs){
        try {
            if(rs!=null){
                this.rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            if(psmt!=null){
                psmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet getEntities(String sql,List<Object> p){
        try{
            rs=null;
            conn=this.getConnection();
            psmt=conn.prepareStatement(sql);
            if(this.psmt!=null);{
                for(int i=0;i<+p.size();i++){
                    psmt.setObject(i+1,p.get(i));
                }
                rs=psmt.executeQuery();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;

    }
    public ResultSet getEntityById(String sql, List<Object> p){
        rs=null;
        conn=this.getConnection();
        try {
            psmt=conn.prepareStatement(sql);
            if(this.psmt!=null){
                for(int i =0;i<p.size(); i++){
                    this.psmt.setObject(i+1,p.get(i));
                }
            }
            rs=psmt.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int executeUpdate(String sql,List<Object> p) {
        System.out.println(sql);
        int num=0;
        conn=this.getConnection();
        try{
            psmt=conn.prepareStatement(sql);
            if(this.psmt!=null){
                for(int i=0;i<+p.size();i++){
                    psmt.setObject(i+1,p.get(i));
                }
            }
            num=this.psmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,psmt,rs);
        }

        return num;
    }
}
