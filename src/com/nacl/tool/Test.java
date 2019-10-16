package com.nacl.tool;

import com.nacl.daoimpl.AdminDal;
import com.nacl.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        AdminDal adminDal=new AdminDal();
        List<Admin> entitys=adminDal.getEntities();
        for(int i=0;i<entitys.size();i++){
            Admin admin=entitys.get(i);
            System.out.println(admin.getId());
        }


    }

}
