package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Log4j2
@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("/todo/register 의 doGet() 호출");
//        System.out.println("입력화면 볼 수 있도록 구성");

        log.info("/todo/register 의 doGet() 호출");
        log.info("/todo register ......");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("/todo/register 의 doPost() 호출");
//        System.out.println("입력을 구성하고 목록 페이지로 이동");

        log.info("/todo/register 의 doPost() 호출");

        req.setCharacterEncoding("UTF-8");

//        String title = req.getParameter("title");

        TodoDTO dto = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        try {
            todoService.register(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo register error");
        }

        resp.sendRedirect("/todo/list");
    }
}
