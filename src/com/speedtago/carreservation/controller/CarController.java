package com.speedtago.carreservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.speedtago.util.PageMove;

@WebServlet("/car")
public class CarController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public void init() {
      //adminService = new AdminServiceImpl();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String root = request.getContextPath();
      String act = request.getParameter("act");
      System.out.println("act ==== " + act);
      if ("mvopenMap".equals(act)) {
         PageMove.redirect(request, response, "/reservation/startdestsearch.jsp");
      } else if("".equals(act)) {
         
      } else if("".equals(act)) {
         
      } else if("".equals(act)) {
         
      } else if("".equals(act)) {
         
      } else if("".equals(act)) {
         
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }

}