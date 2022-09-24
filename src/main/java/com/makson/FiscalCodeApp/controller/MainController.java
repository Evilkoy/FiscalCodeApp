package com.makson.FiscalCodeApp.controller;

import com.makson.FiscalCodeApp.model.Person;
import com.makson.FiscalCodeApp.service.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    CodeGenerator codeGenerator;

    @PostMapping("/getcode")
    public ResponseEntity<String> getFiscalCode(@RequestBody Person person){
        return new ResponseEntity<>(codeGenerator.generator(person),HttpStatus.OK);
    }
}
