package com.nacl.servlet;

import com.nacl.dao.AdminIDal;
import com.nacl.daoimpl.AdminDal;
import com.nacl.entity.Admin;
import com.nacl.tool.JsonHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class getAdminById extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=0;
        resp.setContentType("text/json; charset=utf-8");
        if(req.getParameter("id")!=null){
            id =Integer.parseInt(req.getParameter("id"));
            AdminIDal adminDal=new AdminDal();
            Admin entity=adminDal.getEntityById(id);
            List<Admin> list=new ArrayList<>();
            list.add(entity);

            String json=JsonHelper.toJson(list);
            try{
                resp.getWriter().write(json);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            resp.getWriter().write("参数为空");

        }



    }
}
