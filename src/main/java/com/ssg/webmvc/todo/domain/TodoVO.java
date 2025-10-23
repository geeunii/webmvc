package com.ssg.webmvc.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

// VO (Value Object) 읽기전용
@Getter // 읽기만
@Setter // 객체 생성 시 빌더패턴을 이용하기 위해 추가
@ToString // 객체값 확인
@Builder
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
