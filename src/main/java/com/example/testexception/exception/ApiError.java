package com.example.testexception.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError extends Throwable {

    private String message;
    private String responseId;
    private String requestId;


}
