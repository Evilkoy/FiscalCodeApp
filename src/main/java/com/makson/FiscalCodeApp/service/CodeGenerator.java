package com.makson.FiscalCodeApp.service;

import com.makson.FiscalCodeApp.dao.CommuneDao;
import com.makson.FiscalCodeApp.entity.Commune;
import com.makson.FiscalCodeApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeGenerator {
    @Autowired
    private CommuneDao communeDao;

    public String generator(Person person) {
        String fiscalCode = codeSurname(person.getSurname().toLowerCase())
                + codeName(person.getName().toLowerCase())
                + codeYear(person.getBirthYear())
                + codeMonth(person.getBirthMonth().toLowerCase())
                + codeBirthDayAndGender(person.getBirthDay(), person.getGender().toLowerCase())
                + codeCommune(person.getCommune().toLowerCase());
        return fiscalCode + codeCheckDigit(fiscalCode);
    }

    private String codeSurname(String surname) {
        return surname.replaceAll("[aeiouy]", "").substring(0, 3);
    }

    private String codeName(String name) {
        return name.replaceAll("[aeiouy]", "").substring(0, 3);
    }

    private String codeYear(String birthYear) {
        return birthYear.substring(2);
    }

    private String codeMonth(String month) {
        switch (month.toLowerCase()) {
            case ("january"):
                return "a";
            case ("february"):
                return "b";
            case ("march"):
                return "c";
            case ("april"):
                return "d";
            case ("may"):
                return "e";
            case ("june"):
                return "h";
            case ("july"):
                return "l";
            case ("august"):
                return "m";
            case ("september"):
                return "p";
            case ("october"):
                return "r";
            case ("november"):
                return "s";
            case ("december"):
                return "t";
            default:
                return "Error";
        }
    }

    private String codeBirthDayAndGender(String day, String gender) {
        if (gender.equals("male")) {
            return day;
        } else {
            int dayInt = Integer.parseInt(day) + 40;
            return String.valueOf(dayInt);
        }
    }

    private String codeCommune(String communeName) {
        Commune commune = communeDao.findByName(communeName.toUpperCase());
        if (commune != null) {
            return commune.getCodiceCatastale().toLowerCase();
        } else {
            return "commune error";
        }
    }

    private String codeCheckDigit(String fiscalCode) {
        List<Character> odd = new ArrayList<>();
        odd.add(fiscalCode.charAt(0));
        odd.add(fiscalCode.charAt(2));
        odd.add(fiscalCode.charAt(4));
        odd.add(fiscalCode.charAt(6));
        odd.add(fiscalCode.charAt(8));
        odd.add(fiscalCode.charAt(10));
        odd.add(fiscalCode.charAt(12));
        odd.add(fiscalCode.charAt(14));
        List<Character> even = new ArrayList<>();
        even.add(fiscalCode.charAt(1));
        even.add(fiscalCode.charAt(3));
        even.add(fiscalCode.charAt(5));
        even.add(fiscalCode.charAt(7));
        even.add(fiscalCode.charAt(9));
        even.add(fiscalCode.charAt(11));
        even.add(fiscalCode.charAt(13));
        return remainder(oddConvertor(odd) + evenConvertor(even));
    }

    private int oddConvertor(List<Character> odd) {
        int sum = 0;
        for (Character i : odd) {
            switch (i) {
                case ('0'):
                case ('a'):
                    sum += 1;
                    break;
                case ('1'):
                case ('b'):
                    break;
                case ('2'):
                case ('c'):
                    sum += 5;
                    break;
                case ('3'):
                case ('d'):
                    sum += 7;
                    break;
                case ('4'):
                case ('e'):
                    sum += 9;
                    break;
                case ('5'):
                case ('f'):
                    sum += 13;
                    break;
                case ('6'):
                case ('g'):
                    sum += 15;
                    break;
                case ('7'):
                case ('h'):
                    sum += 17;
                    break;
                case ('8'):
                case ('i'):
                    sum += 19;
                    break;
                case ('9'):
                case ('j'):
                    sum += 21;
                    break;
                case ('k'):
                    sum += 2;
                    break;
                case ('l'):
                    sum += 4;
                    break;
                case ('m'):
                    sum += 18;
                    break;
                case ('n'):
                    sum += 20;
                    break;
                case ('o'):
                    sum += 11;
                    break;
                case ('p'):
                    sum += 3;
                    break;
                case ('q'):
                    sum += 6;
                    break;
                case ('r'):
                    sum += 8;
                    break;
                case ('s'):
                    sum += 12;
                    break;
                case ('t'):
                    sum += 14;
                    break;
                case ('u'):
                    sum += 16;
                    break;
                case ('v'):
                    sum += 10;
                    break;
                case ('w'):
                    sum += 22;
                    break;
                case ('x'):
                    sum += 25;
                    break;
                case ('y'):
                    sum += 24;
                    break;
                case ('z'):
                    sum += 23;
                    break;
            }
        }
        return sum;
    }

    private int evenConvertor(List<Character> even) {
        int sum = 0;
        for (Character i : even) {
            switch (i) {
                case ('0'):
                case ('a'):
                    sum += 0;
                    break;
                case ('1'):
                case ('b'):
                    sum += 1;
                    break;
                case ('2'):
                case ('c'):
                    sum += 2;
                    break;
                case ('3'):
                case ('d'):
                    sum += 3;
                    break;
                case ('4'):
                case ('e'):
                    sum += 4;
                    break;
                case ('5'):
                case ('f'):
                    sum += 5;
                    break;
                case ('6'):
                case ('g'):
                    sum += 6;
                    break;
                case ('7'):
                case ('h'):
                    sum += 7;
                    break;
                case ('8'):
                case ('i'):
                    sum += 8;
                    break;
                case ('9'):
                case ('j'):
                    sum += 9;
                    break;
                case ('k'):
                    sum += 10;
                    break;
                case ('l'):
                    sum += 11;
                    break;
                case ('m'):
                    sum += 12;
                    break;
                case ('n'):
                    sum += 13;
                    break;
                case ('o'):
                    sum += 14;
                    break;
                case ('p'):
                    sum += 15;
                    break;
                case ('q'):
                    sum += 16;
                    break;
                case ('r'):
                    sum += 17;
                    break;
                case ('s'):
                    sum += 18;
                    break;
                case ('t'):
                    sum += 19;
                    break;
                case ('u'):
                    sum += 20;
                    break;
                case ('v'):
                    sum += 21;
                    break;
                case ('w'):
                    sum += 22;
                    break;
                case ('x'):
                    sum += 23;
                    break;
                case ('y'):
                    sum += 24;
                    break;
                case ('z'):
                    sum += 25;
                    break;
            }
        }
        return sum;
    }

    private String remainder(int sum) {
        switch (sum % 26) {
            case (0):
                return "a";
            case (1):
                return "b";
            case (2):
                return "c";
            case (3):
                return "d";
            case (4):
                return "e";
            case (5):
                return "f";
            case (6):
                return "g";
            case (7):
                return "h";
            case (8):
                return "i";
            case (9):
                return "j";
            case (10):
                return "k";
            case (11):
                return "l";
            case (12):
                return "m";
            case (13):
                return "n";
            case (14):
                return "o";
            case (15):
                return "p";
            case (16):
                return "q";
            case (17):
                return "r";
            case (18):
                return "s";
            case (19):
                return "t";
            case (20):
                return "u";
            case (21):
                return "v";
            case (22):
                return "w";
            case (23):
                return "x";
            case (24):
                return "y";
            case (25):
                return "z";
            default:
                return "remainder error";
        }
    }
}

