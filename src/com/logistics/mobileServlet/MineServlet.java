package com.logistics.mobileServlet;

import com.logistics.bean.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/16.
 */
@WebServlet(name = "MineServlet",urlPatterns = "/mobileSite/mine.do")
public class MineServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if (request.getSession().getAttribute("register")==null){
            response.getWriter().print("0");
        }else{
            Register register = (Register)request.getSession().getAttribute("register");
            response.setContentType("text/plain;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            response.getWriter().print(register.getName());
        }

      /*  request.getRequestDispatcher("mine.html").forward(request,response);*/
    }
}
