package tutorial.service;

import org.springframework.stereotype.Component;

@Component
public class LeapYearService {


    public boolean calculateLeapYear(Integer year) {
        Boolean isLeapYar = false;
        if (year % 4 != 0) {
            isLeapYar = false;
        } else if (year % 100 != 0) {
            isLeapYar = true;
        } else if (year % 400 != 0) {
            isLeapYar = false;
        } else {
            isLeapYar = true;
        }
        return isLeapYar;
    }
}
