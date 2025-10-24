package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("/todo/list 의 doGet() 호출");
        log.info("/todo/list 의 doGet() 호출");
        log.info("/todo list ......");

        // List<TodoDTO> todoDTOList = TodoService.INSTANCE.getList();

        try {
            List<TodoDTO> dtoList = todoService.listAll();

            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp); // req.의 리퀘스트디스패처를 내 링크에 포워드해서 이동시킨다.
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo list error");
        }

    }
}
