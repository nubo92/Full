package com.ohgiraffers.restapi.section02.responseentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {

    private int httpStatus;
    private String message;
    private Map<String, Object> results;    // 실제 데이터는 여기에 담을거다
}
