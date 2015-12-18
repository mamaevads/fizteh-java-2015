package ru.fizteh.fivt.students.mamaevads.supertests;


import junit.framework.TestCase;
import org.junit.Test;
import junit.framework.Assert;

import java.time.LocalDateTime;
import java.time.Month;


public class TimeHandlerTest extends TestCase {

    @Test
    public void testGetType() throws Exception {
        LocalDateTime timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 15, 0, 4);
        LocalDateTime timeTwo = LocalDateTime.of(2010, Month.JANUARY, 20, 15, 2, 3);
        assertEquals("только что", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 23, 59, 25);
        timeTwo = LocalDateTime.of(2010, Month.JANUARY, 21, 00, 00, 30);
        assertEquals("только что", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 15, 1, 1);
        timeTwo = LocalDateTime.of(2010, Month.JANUARY, 20, 15, 3, 3);
        assertEquals("2 минуты назад", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 15, 1, 1);
        timeTwo = LocalDateTime.of(2010, Month.JANUARY, 20, 16, 1, 0);
        assertEquals("59 минут назад", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 13, 1, 1);
        timeTwo = LocalDateTime.of(2010, Month.JANUARY, 20, 16, 1, 0);
        assertEquals("2 часа назад", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2010, Month.JANUARY, 20, 23, 1, 1);
        timeTwo = LocalDateTime.of(2010, Month.JANUARY, 21, 02, 1, 0);
        assertEquals("вчера", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2012, Month.FEBRUARY, 26, 00, 1, 1);
        timeTwo = LocalDateTime.of(2012, Month.FEBRUARY, 27, 23, 59, 59);
        assertEquals("вчера", TimeHandler.getType(timeOne,timeTwo));
        timeOne = LocalDateTime.of(2012, Month.FEBRUARY, 25, 00, 1, 1);
        timeTwo = LocalDateTime.of(2012, Month.FEBRUARY, 27, 23, 59, 59);
        assertEquals("2 дня назад", TimeHandler.getType(timeOne, timeTwo));
        timeOne = LocalDateTime.of(2012, Month.FEBRUARY, 28, 00, 1, 1); //Leap year
        timeTwo = LocalDateTime.of(2012, Month.MARCH, 01, 23, 59, 59);
        assertEquals("2 дня назад", TimeHandler.getType(timeOne, timeTwo));
        timeOne = LocalDateTime.of(2012, Month.FEBRUARY, 29, 1, 1, 1);
        timeTwo = LocalDateTime.of(2012, Month.MARCH, 01, 22, 59, 59);
        assertEquals("вчера", TimeHandler.getType(timeOne, timeTwo));
        timeOne = LocalDateTime.of(2012, Month.FEBRUARY, 28, 1, 1, 1);
        timeTwo = LocalDateTime.of(2012, Month.MARCH, 06, 22, 59, 59);
        assertEquals("7 дней назад", TimeHandler.getType(timeOne, timeTwo));
        timeOne = LocalDateTime.of(2011, Month.FEBRUARY, 28, 1, 1, 1);
        timeTwo = LocalDateTime.of(2011, Month.MARCH, 06, 22, 59, 59);
        assertEquals("6 дней назад", TimeHandler.getType(timeOne, timeTwo));
    }
}