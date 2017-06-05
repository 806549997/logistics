package com.logistics.mobileServlet;

import com.logistics.bean.Register;
import com.logistics.dao.RegisterDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/10/16.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/mobileSite/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");
        String password=request.getParameter("pwd");
        RegisterDao rd=new RegisterDao();
        Register register=rd.login(name,password);
        if(null!=register){
            request.getSession().setAttribute("register",register);
            response.sendRedirect("index.html#/my");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
