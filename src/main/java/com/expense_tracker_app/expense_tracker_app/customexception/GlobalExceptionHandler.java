package com.expense_tracker_app.expense_tracker_app.customexception;

import com.expense_tracker_app.expense_tracker_app.customresponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TrackerException.class)
    public ResponseEntity<ApiResponse<?>> expenseTracker(TrackerException e, WebRequest request){
        return ResponseEntity.status(e.getStatus()).body(new ApiResponse<>(e.getStatus(),e.getMessage()));
    }
}
