package com.logistics.mobileServlet;

import com.logistics.bean.Register;
import com.logistics.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/16.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/mobileSite/register.do")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");
        String password=request.getParameter("password");
        String phoneNum=request.getParameter("telephone");
        String sex=request.getParameter("sex");
        int identity=Integer.parseInt(request.getParameter("identity"));
        RegisterDao rd=new RegisterDao();
        Register r = new Register(name, password, sex, phoneNum, identity, 0);
        int res = rd.register(r);
        if(res!=0){
            response.sendRedirect("mine.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
