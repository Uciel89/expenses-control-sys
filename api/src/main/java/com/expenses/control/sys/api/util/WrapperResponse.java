package com.expenses.control.sys.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrapperResponse <T>{
    private boolean ok;
    private String message;
    private T body;

    public ResponseEntity<WrapperResponse<T>> createResponse(){
        return new ResponseEntity<>(this, HttpStatus.OK);
    }
    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this, status);
    }
}
