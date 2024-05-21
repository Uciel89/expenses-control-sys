package com.expenses.control.sys.api.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrapperResponse <T>{
    private boolean ok;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timestamp = LocalDateTime.now() ;
    private String message;;
    private T body;

    public WrapperResponse(boolean ok, String message, T body) {
        this.ok = ok;
        this.message = message;
        this.body = body;
    }
    public ResponseEntity<WrapperResponse<T>> createResponse(){
        return new ResponseEntity<>(this, HttpStatus.OK);
    }
    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this, status);
    }
}
