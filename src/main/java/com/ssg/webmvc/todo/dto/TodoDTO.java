package com.ssg.webmvc.todo.dto;

import lombok.Data;

import java.time.LocalDateTime;

// DTO 용도 : 여러개의 데이터를 묶어서 하나의 객체로 구성
// 서비스 객체 메소드들의 파라미터나 리턴 타입으로 사용됨
@Data
public class TodoDTO {
    private Long tno; // 할일(todo) 고유값 pk
    private String title; // 할일 제목
    private LocalDateTime dueDate; // 등록시간
    private boolean finished; // 할일 체크
}


