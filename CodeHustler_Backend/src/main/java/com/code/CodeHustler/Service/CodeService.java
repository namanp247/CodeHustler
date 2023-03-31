package com.code.CodeHustler.Service;

import com.code.CodeHustler.Model.CodeHustler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CodeService {
    Exception saveCode(CodeHustler code);
    ResponseEntity<?> printCode(CodeHustler code) throws Exception;
    void delete(String id) throws Exception;
    ResponseEntity<?> findby(String id) throws Exception;
}
