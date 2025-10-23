package com.ssg.webmvc.todo.service;

public enum TodoService {
    INSTANCE;   // 객체의 수를 정의(결정)
    // <현재는 INSTANCE 가 1개 이므로 서비스객체 1개만 사용>
    // 접근방법 : TodoService.INSTANCE 접근
    // 객체를 하나만 생성해서 사용 (singleton pattern)
    // 여러 컨트롤러들이 TodoService 객체를 통해 원하는 데이터를 주고받는 구조로 구성하기 위해
}

// 장점 : 정해진 수만큼 객체를 생성할 수 있음