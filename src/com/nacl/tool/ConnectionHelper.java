package com.nacl.tool;

import java.sql.*;
import java.util.List;

public class ConnectionHelper {
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
}
