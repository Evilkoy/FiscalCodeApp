package com.makson.FiscalCodeApp.service;

import com.makson.FiscalCodeApp.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeGeneratorTest {
    Person person = new Person();

    @BeforeEach
    void setUp() {
        person.setBirthDay("04");
        person.setBirthMonth("june");
        person.setBirthYear("1996");
        person.setName("peter");
        person.setSurname("escobar");
        person.setCommune("roma");
        person.setGender("male");
    }

    @Test
    void codeSurnameTest() {
        String actual = person.getSurname().replaceAll("[aeiouy]", "").substring(0, 3);
        assertEquals("scb", actual);
    }

    @Test
    void codeNameTest() {
        String actual = person.getName().replaceAll("[aeiouy]", "").substring(0, 3);
        assertEquals("ptr", actual);
    }

    @Test
    void codeYearTest() {
        String actual = person.getBirthYear().substring(2);
        assertEquals("96", actual);
    }

    @Test
    void codeMonthTest() {
        String actual;
        switch (person.getBirthMonth().toLowerCase()) {
            case ("january"):
                actual = "a";
                break;
            case ("february"):
                actual = "b";
                break;
            case ("march"):
                actual = "c";
                break;
            case ("april"):
                actual = "d";
                break;
            case ("may"):
                actual = "e";
                break;
            case ("june"):
                actual = "h";
                break;
            case ("july"):
                actual = "l";
                break;
            case ("august"):
                actual = "m";
                break;
            case ("september"):
                actual = "p";
                break;
            case ("october"):
                actual = "r";
                break;
            case ("november"):
                actual = "s";
                break;
            case ("december"):
                actual = "t";
                break;
            default:
                actual = "Error";
                break;
        }
        assertEquals("h", actual);
    }

    @Test
    void codeBirthDatAndGender() {
        String actual;
        if (person.getGender().equals("male")) {
            actual = person.getBirthDay();
        } else {
            int dayInt = Integer.parseInt(person.getBirthDay()) + 40;
            actual = String.valueOf(dayInt);
        }
        assertEquals("04", actual);
    }

    @Test
    void codeCheckDigitTest() {
        String fiscalCode = "scbptr96h04h501";
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
        assertEquals("[s, b, t, 9, h, 4, 5, 1]", odd.toString());
        assertEquals("[c, p, r, 6, 0, h, 0]", even.toString());
    }

    @Test
    void oddConvertorTest() {
        List<Character> odd = new ArrayList<>();
        odd.add('s');
        odd.add('b');
        odd.add('t');
        odd.add('9');
        odd.add('h');
        odd.add('4');
        odd.add('5');
        odd.add('1');
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
        assertEquals(86, sum);
    }

    @Test
    void evenConvertorTest() {
        List<Character> even = new ArrayList<>();
        even.add('c');
        even.add('p');
        even.add('r');
        even.add('6');
        even.add('0');
        even.add('h');
        even.add('0');
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
        assertEquals(47, sum);
    }

    @Test
    void remainderTest() {
        int sum = 133;
        String actual;
        switch (sum % 26) {
            case (0):
                actual = "a";
                break;
            case (1):
                actual = "b";
                break;
            case (2):
                actual = "c";
                break;
            case (3):
                actual = "d";
                break;
            case (4):
                actual = "e";
                break;
            case (5):
                actual = "f";
                break;
            case (6):
                actual = "g";
                break;
            case (7):
                actual = "h";
                break;
            case (8):
                actual = "i";
                break;
            case (9):
                actual = "j";
                break;
            case (10):
                actual = "k";
                break;
            case (11):
                actual = "l";
                break;
            case (12):
                actual = "m";
                break;
            case (13):
                actual = "n";
                break;
            case (14):
                actual = "o";
                break;
            case (15):
                actual = "p";
                break;
            case (16):
                actual = "q";
                break;
            case (17):
                actual = "r";
                break;
            case (18):
                actual = "s";
                break;
            case (19):
                actual = "t";
                break;
            case (20):
                actual = "u";
                break;
            case (21):
                actual = "v";
                break;
            case (22):
                actual = "w";
                break;
            case (23):
                actual = "x";
                break;
            case (24):
                actual = "y";
                break;
            case (25):
                actual = "z";
                break;
            default:
                actual = "remainder error";
        }
        assertEquals("d", actual);
    }
}