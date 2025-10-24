package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;   // 객체의 수를 정의(결정)
    // <현재는 INSTANCE 가 1개 이므로 서비스객체 1개만 사용>
    // 접근방법 : TodoService.INSTANCE 접근
    // 객체를 하나만 생성해서 사용 (singleton pattern)
    // 여러 컨트롤러들이 TodoService 객체를 통해 원하는 데이터를 주고받는 구조로 구성하기 위해

    private TodoDAO dao; // 인젝션 !
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        // System.out.println("DEBUG ......" + todoDTO);
        // ModelMapper 를 사용해 DTO 객체를 VO 객체로 변환(매핑)합니다.
        // todoDTO 객체의 데이터를 바탕으로 새로운 TodoVO 객체를 생성하고 데이터를 복사합니다.
        // (원본 객체: todoDTO,  목적지 클래스: TodoVO.class)
        // -> DTO 로 받은 데이터를 VO로 변환해서 DB에 넣기 위해 준비하는 과정
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        // System.out.println("todoVO : " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);

        // register() TodoDTO 파라미터를 받아서 ModelMapper 를 통해 TodoVO 객체로 변환을 한 후
        // dao.insert(todoVO) 를 통해 todoVO 객체를 전달하며 등록기능을 요청함.
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList------");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO listOne(Long tno) throws Exception {
        TodoVO vo = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;
    }

    public void update(TodoDTO todoDTO) throws Exception {

        // 1. 컨트롤러에서 받은 DTO를 DAO로 보낼 VO로 변환
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        // 2. VO를 DAO로 전달하여 updateOne 실행
        dao.updateOne(todoVO);
    }

    public void delete(Long tno) throws Exception {
        log.info("Delete :{}", tno);

        dao.delete(tno);
    }

    // 테스트
    // 10개의 TodoDTO 객체를 만들어 반환
    /*
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
    } */

    /*public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);

        // 샘플 데이터
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }*/
}

// 장점 : 정해진 수만큼 객체를 생성할 수 있음