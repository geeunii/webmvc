package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {

    private final TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/remove (POST) ... 삭제");

        try {
            // 폼에서 전송된 tno 값을 받음
            Long tno = Long.parseLong(req.getParameter("tno"));
            log.info("삭제할 tno: " + tno);

            todoService.delete(tno);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo delete error");
        }

        resp.sendRedirect("/todo/list");
    }
}