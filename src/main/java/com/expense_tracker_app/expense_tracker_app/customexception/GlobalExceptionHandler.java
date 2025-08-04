package com.expense_tracker_app.expense_tracker_app.customexception;

import com.expense_tracker_app.expense_tracker_app.customresponse.ApiResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TrackerException.class)
    public ResponseEntity<ApiResponse<?>> expenseTrackerException(TrackerException e, WebRequest request){
        return ResponseEntity.status(e.getStatus()).body(new ApiResponse<>(e.getStatus(),e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<?>> validationError(MethodArgumentNotValidException exception){

        Map<String ,String> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().
                forEach(error->{
                    errors.put(error.getField(),error.getDefaultMessage());
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(HttpStatus.BAD_REQUEST,"Validation error",errors));
    }
}
