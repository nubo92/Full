package com.ohgiraffers.restapi.section04.hateoas;

import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/hateoas")
public class HateoasTestController {

    private List<UserDTO> users;

    public HateoasTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "고릴라", new Date()));
        users.add(new UserDTO(2, "user02", "pass02", "호랑이", new Date()));
        users.add(new UserDTO(3, "user03", "pass03", "원숭이", new Date()));
    }

    /* 전체 회원 조회 */
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        // 응답 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        /* HATEOAS 적용*/
        // 1.EntityModel : 기존 DTO를 감싸서 링크 정보를 추가할 수 있게 해주는 클래스
        List<EntityModel<UserDTO>> usersWithRel = users.stream()
                .map(user -> {
                    return EntityModel.of(
                            user, // 실제 데이터
                            // HateoasTestController의 findUserByNo(user.getNo()) 메소드를 가르키는 링크를 만든다.
                            linkTo(methodOn(HateoasTestController.class).findUserByNo(user.getNo())).withSelfRel(),
                            linkTo(methodOn(HateoasTestController.class).findAllUsers()).withRel("users")
                    );
                }).toList();

        // 응답 바디(본문)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", usersWithRel); // 링크가 포함된 리스트로 교체
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // ResponseEntity 객체 생성
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    /* 특정 번호의 회원 조회 */
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);     // JSON 변환 -> "user": {...}

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // 빌더 패턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }
}
