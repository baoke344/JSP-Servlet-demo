package com.example.demo_login;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserData userData;

    public void init() {

        userData = new UserData();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String user_name = request.getParameter("userName");
        String user_password = request.getParameter("password");

        Users user = new Users();
        user.setUserName(user_name);
        user.setUserPassword(user_password);

        try{
            userData.connect(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
        dispatcher.forward(request,response);
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/hello.jsp");
//        dispatcher.forward(request,response);
//
//    }

    public void destroy() {
    }
}