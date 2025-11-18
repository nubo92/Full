package com.ohgiraffers.chap01restapi.section02.responseentity;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/entity")
public class ResponseEntityController {

    private List<UserDTO> users;

    public ResponseEntityController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "호랑이", new Date()));
        users.add(new UserDTO(2, "user02", "pass02", "고릴라", new Date()));
        users.add(new UserDTO(3, "user03", "pass03", "코알라", new Date()));
    }

    /* 전체 회원 조회 */
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        // 응답 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        // 응답 바디(본문)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // ResponseEntity 객체 생성
        return  new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    /* 특정 번호의 회원 조회 */
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserNyNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);     // JSON 변환 -> "user" : {...}

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        // 빌더 패턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }

    @PostMapping("/users")
    // T가 Void라는 것은 응답 body가 없다는 의미이다.
    // @RequestBody : 클라이언트가 보낸 JSON 데이터를 UserDTO 객체로 변환한다.
    // {"name":"홍길동", "age":30} -> newUser.name = "홍길동", newUser.age = 30
    public ResponseEntity<Void> registUser(@RequestBody UserDTO newUser) {

        // users 리스트의 마지막 사용자의 번호를 가져온다.
        int lastUserNo = users.get(users.size() - 1).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
                .created(URI.create("/entity/users/" + newUser.getNo()))
                .build();       // 바디가 없는 응답을 만들 때 사용
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO modifyInfo) {

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo) {

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()        // 성공했지만 컨텐츠가 없음을 의미하는 HTTP 상태코드 204 No Content 반환
                .build();

    }

}
