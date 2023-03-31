package com.code.CodeHustler.Controller;
import com.code.CodeHustler.Model.CodeHustler;
import com.code.CodeHustler.Repository.CodeRepository;
import com.code.CodeHustler.Service.CodeServiceimpl;
import org.bson.types.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins={"*"})
public class CodeController {
    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    CodeServiceimpl codeServiceimpl;


    @PostMapping (value = "/save")
    void createcode(@RequestBody  CodeHustler codeHustler){
      codeServiceimpl.saveCode(codeHustler);
    }

    @GetMapping("/showallcode")
    ResponseEntity<?> getallcode(CodeHustler codeHustler) throws Exception {
       return  codeServiceimpl.printCode(codeHustler);
    }

    @GetMapping(value = "/showSpecificCode/{id}")
    ResponseEntity<?> getProductbyId(@PathVariable String id) throws Exception {
       return codeServiceimpl.findby(id);
    }


    @DeleteMapping(value = "/delete/{id}")
    void deleteEmployeeById(@PathVariable String id) throws Exception {
        codeServiceimpl.delete(id);

    }


    @GetMapping(value="/specificDataStructure/{dataStructure}")
    List<CodeHustler> specificDataStructure(@PathVariable String dataStructure){

        return codeRepository.findbyName(dataStructure);
    }

    @GetMapping(value="/specificDataStructureAndDifficulty/{dataStructure}/{difficulty}")
    List<CodeHustler> specificDataStructureAndDifficulty(@PathVariable String dataStructure,@PathVariable String difficulty){

        return codeRepository.findbydataStructureAndDifficulty(dataStructure,difficulty);
    }






}

