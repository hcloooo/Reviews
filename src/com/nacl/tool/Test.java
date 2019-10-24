package com.nacl.tool;

import com.nacl.daoimpl.AdminDal;
import com.nacl.entity.Admin;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        AdminDal adminDal=new AdminDal();
        Admin entity=new Admin();
        //entity.setId(190104);
//        entity.setName("鲁班");
//        entity.setPwd("qwert");
//        entity.setNote("i am here");
//        entity.setState(1);
//        List<Admin> list=new ArrayList();
//        list.add(entity);
        List<Admin> list=adminDal.getEntities();


        String json=JsonHelper.toJson(list);
        System.out.println(json);




    }

}
