package com.ssg.webmvc.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list 의 doGet() 호출");

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp); // req.의 리퀘스트디스패처를 내 링크에 포워드해서 이동시킨다.


    }
}
