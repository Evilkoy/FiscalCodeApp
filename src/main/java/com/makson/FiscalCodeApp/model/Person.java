package com.makson.FiscalCodeApp.model;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String gender;
    private String commune;
}
