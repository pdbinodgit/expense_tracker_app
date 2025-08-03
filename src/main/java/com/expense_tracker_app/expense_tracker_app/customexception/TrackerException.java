package com.expense_tracker_app.expense_tracker_app.customexception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
public class TrackerException extends RuntimeException{

    private String message;

    private HttpStatus status;

    private int code;

    public TrackerException(String message, HttpStatus status, int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}
