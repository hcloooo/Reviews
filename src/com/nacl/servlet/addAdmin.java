package com.nacl.servlet;

import com.nacl.daoimpl.AdminDal;
import com.nacl.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDal adminDal=new AdminDal();
        Admin admin=new Admin();
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("username"));
        admin.setName(req.getParameter("username"));
        admin.setPwd(req.getParameter("pwd"));
        admin.setNote(req.getParameter("note"));
        admin.setState(1);
        try{
            int num=adminDal.addEntity(admin);
            resp.setContentType("text/html;charset=utf-8");
            if(num!=0){
                resp.getWriter().write("success");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
