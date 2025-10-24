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
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/modify 의 doGet() 호출");
        log.info("/todo modify ......");

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO dto = todoService.listOne(tno);

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo modify error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/modify 의 doPost() 호출");

        req.setCharacterEncoding("UTF-8");

        // 폼에서 전송된 모든 파라미터를 받음
        String tno = req.getParameter("tno");
        String title = req.getParameter("title");
        String dueDate = req.getParameter("dueDate");
        // [중요] 체크박스 값 처리: 체크가 안되면 null이 전송됨
        String finished = req.getParameter("finished");

        try {
            TodoDTO dto = TodoDTO.builder()
                    .tno(Long.parseLong(tno))
                    .title(title)
                    .dueDate(LocalDate.now())
                    .finished(finished != null)
                    .build();

            todoService.update(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo modify error");
        }
        resp.sendRedirect("/todo/read?tno=" + tno);
    }
}
