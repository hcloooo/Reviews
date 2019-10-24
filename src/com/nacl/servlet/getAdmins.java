package com.nacl.servlet;

import com.nacl.daoimpl.AdminDal;
import com.nacl.entity.Admin;
import com.nacl.tool.JsonHelper;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getAdmins extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminDal adminDal=new AdminDal();
        List<Admin> parms=new ArrayList<Admin>();
        parms=adminDal.getEntities();
        String json= JsonHelper.toJson(parms);
        resp.getWriter().write(json);
    }
}
