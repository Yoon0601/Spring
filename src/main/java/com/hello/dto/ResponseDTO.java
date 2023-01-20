package com.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO{
    private StatusEnum statusCode;
    private String message;
    private Object data;

    public ResponseDTO(){
        this.statusCode=StatusEnum.BAD_REQUEST;
        this.message=null;
        this.data=null;
    }
    public enum StatusEnum{
        OK(200,"OK"),
        BAD_REQUEST(400,"BAD_REQUEST"),
        NOT_FOUND(404,"NOT_FOUND");
        int statusCode;
        String code;

        StatusEnum(int statusCode, String code) {
            this.statusCode=statusCode;
            this.code=code;
        }
    }
}
