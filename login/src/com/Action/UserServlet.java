package com.Action;

import com.Dao.UsersDao;
import com.Dao.impl.UserDaoImpl;
import com.Entity.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserSevlet", urlPatterns = "/UserSevlet",asyncSupported = true)
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
        System.out.println("get");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String state = req.getParameter("state");//得到state对应的值并且赋值给名为state的String类型的变量
        System.out.println(state);//在控制台打印state方便debug
        switch (state) {//挑选state的值
            case "login"://如果state的值是trylogin 这个是用来处理用户的登录请求
                checkUser(req, resp);//调用checkUser方法
                break;
            case "enrol"://注册请求 也就是用户点击“注册用户”时对应这个
                req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
                break;
            case "doregister"://处理注册请求  也就是用户提交注册新用户的信息时对应这个
                tryRegister(req, resp);
                break;

            case "logout"://用户点击退出登录对应这个
                trylogout(req, resp);
                break;

        }
    }


    protected void checkUser(HttpServletRequest req, HttpServletResponse resp){
        UsersDao userDao = new UserDaoImpl();
        if(userDao.checkUsername(req.getParameter("username"))){
            if(userDao.checkPassword(req.getParameter("username"),req.getParameter("password"))) {
                try {
                    System.out.println("1");
                    HttpSession session = req.getSession();
                    session.setAttribute("currentuser",req.getParameter("username"));
                    String state = "tomain";
                    req.setAttribute("state",state);
                    req.getRequestDispatcher("/PersonSevlet?state=home").forward(req,resp);
                    System.out.println("2");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else
                try{
                    System.out.println("3");
//                    req.setAttribute("message","密码错误！");
                    req.setAttribute("information","password");
                    RequestDispatcher dd = req.getRequestDispatcher("/WEB-INF/views/LoginFailed.jsp");
                    dd.forward(req,resp);
                    System.out.println("4");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
        }
        else {
            try {
                System.out.println("5");
//                req.setAttribute("message","用户不存在！");
                req.setAttribute("information","username");
                RequestDispatcher dd = req.getRequestDispatcher("index.jsp");
                dd.forward(req,resp);
//                resp.sendRedirect("/index.jsp");
                System.out.println("6");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void trylogout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.getSession().invalidate();
        String message = "退出成功！";
        req.setAttribute("message",message);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    protected void tryRegister(HttpServletRequest req, HttpServletResponse resp){
        UsersDao userDao = new UserDaoImpl();
        if(userDao.checkUsername(req.getParameter("username"))){
            try {
                req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            User user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            userDao.addUser(user);
            try{
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}