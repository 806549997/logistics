package com.logistics.mobileServlet;

import com.logistics.bean.Goods;
import com.logistics.dao.GoodsDao;
import org.json.JSONArray;
import org.json.JSONString;

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
@WebServlet(name = "LoadGoodsServlet",urlPatterns = "/mobileSite/getGoodsInfo.do")
public class LoadGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        ArrayList<Goods> goods = goodsDao.getAllGoods();
        JSONArray jsonArray = new JSONArray(goods);
        String jsonString = jsonArray.toString();
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonString);
    }
}
