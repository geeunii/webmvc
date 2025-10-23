package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dto.TodoDTO;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;   // 객체의 수를 정의(결정)
    // <현재는 INSTANCE 가 1개 이므로 서비스객체 1개만 사용>
    // 접근방법 : TodoService.INSTANCE 접근
    // 객체를 하나만 생성해서 사용 (singleton pattern)
    // 여러 컨트롤러들이 TodoService 객체를 통해 원하는 데이터를 주고받는 구조로 구성하기 위해

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG ......" + todoDTO);
    }

    // 10개의 TodoDTO 객체를 만들어 반환
    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(
                i -> {
                    TodoDTO dto = new TodoDTO();
                    dto.setTno((long) i);
                    dto.setTitle("Todo ... title" + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }).collect(Collectors.toList());

        return todoDTOS;
    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);

        // 샘플 데이터
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }
}

// 장점 : 정해진 수만큼 객체를 생성할 수 있음