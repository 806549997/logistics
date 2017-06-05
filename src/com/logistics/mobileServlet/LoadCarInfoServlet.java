package com.logistics.mobileServlet;

import com.logistics.bean.CarInfo;
import com.logistics.dao.CarInfoDao;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/13.
 */
@WebServlet(name = "LoadCarInfoServlet",urlPatterns = "/mobileSite/getCarInfo.do")
public class LoadCarInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarInfoDao carInfoDao=new CarInfoDao();
        ArrayList<CarInfo> carInfos = carInfoDao.getAllCarInfo();
        JSONArray jsonArray =new JSONArray(carInfos);
        String jsonString = jsonArray.toString();
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonString);
    }
}
