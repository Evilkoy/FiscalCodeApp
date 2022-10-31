# FiscalCodeApp
Italian fiscal code generator, that use **MySql** database of Italian communes
## About my app
This is one of many tutorial applications i've done to learn **Java** and this one looks like useful app for some italian people  
It works, but needs improvements for some too large methods  
Application 
## How it works
Application receive a **JSON** with information about person and return generated alphanumeric fiscal code of 16 characters
by this [algorithm](https://en.wikipedia.org/wiki/Italian_fiscal_code "wikipedia")  
+ You need to do **POST** request with a **JSON** like this
```json
{
    "name" : "Marry",
    "surname" : "Black",
    "birthDay" : "21",
    "birthMonth" : "September",
    "birthYear" : "1997",
    "gender" : "Female",
    "commune" : "Dego"
}
```
+ Then methods in Service class process this information and generate a characters of code
```java
public String generator(Person person) {
        String fiscalCode = codeSurname(person.getSurname().toLowerCase())
                + codeName(person.getName().toLowerCase())
                + codeYear(person.getBirthYear())
                + codeMonth(person.getBirthMonth().toLowerCase())
                + codeBirthDayAndGender(person.getBirthDay(), person.getGender().toLowerCase())
                + codeCommune(person.getCommune().toLowerCase());
        return fiscalCode + codeCheckDigit(fiscalCode)
```
 + The hardest part was to get a registry code for the specific italian town. So i have a database with most of italian communes and codes for them. 
There is a method, that returns a code from database by the name of commune(town)
```java
private String codeCommune(String communeName) {
        Commune commune = communeDao.findByName(communeName.toUpperCase());
        if (commune != null) {
            return commune.getCodiceCatastale().toLowerCase();
        } else {
            return "commune error";
        }
    }
```
