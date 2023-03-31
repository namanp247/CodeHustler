package com.code.CodeHustler.Service;

import com.code.CodeHustler.Model.CodeHustler;
import com.code.CodeHustler.Repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CodeServiceimpl implements CodeService {
    @Autowired
    private CodeRepository codeRepository;



    @Override
    public Exception saveCode(CodeHustler code) {
        try {
        codeRepository.save(code);
        } catch (Exception e) {

            return new Exception("Data Not Entered");
        }
        return null;
    }


    @Override
    public ResponseEntity<?> printCode(CodeHustler code) throws Exception {
     try {
          List<CodeHustler> codelist= codeRepository.findAll();
         if(codelist.size()>0){
             return new ResponseEntity<List<CodeHustler>>(codelist, HttpStatus.OK);
         }else{
             return new ResponseEntity<>("Empty Database",HttpStatus.NOT_FOUND);
         }

     }
     catch(Exception e ){
         throw new Exception("Unable to Print Please try again");
     }


    }

    @Override
    public void delete(String id) throws Exception {
        try{ codeRepository.deleteById(id);
        }
        catch(Exception e){
          throw new Exception("Unable to delete Please Try Again ");
        }


    }

    @Override
    public ResponseEntity<?> findby(String id) throws Exception {
        try{
            Optional<CodeHustler> specific=codeRepository.findById(id);
          return new ResponseEntity<>(specific.get(),HttpStatus.OK);
        }
        catch(Exception e){
           return  new ResponseEntity<>("Error Finding Specific ID ",HttpStatus.NOT_FOUND);
        }

    }




}




