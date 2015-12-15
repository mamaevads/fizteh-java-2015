package ru.fizteh.fivt.students.mamaevads.moduletests.library;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class WordFormsTest extends TestCase {

    @Test
    public void testGetForm() throws Exception {
        Assert.assertEquals("день", WordForms.getForm(1, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуту", WordForms.getForm(1, WordForms.MINUTES_FORMS));
        Assert.assertEquals("час", WordForms.getForm(1, WordForms.HOUR_FORMS));
        Assert.assertEquals("дня", WordForms.getForm(2, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуты", WordForms.getForm(2, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часа", WordForms.getForm(2, WordForms.HOUR_FORMS));
        Assert.assertEquals("дня", WordForms.getForm(4, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуты", WordForms.getForm(4, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часа", WordForms.getForm(4, WordForms.HOUR_FORMS));
        Assert.assertEquals("дней", WordForms.getForm(12, WordForms.DAYS_FORMS));
        Assert.assertEquals("минут", WordForms.getForm(12, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часов", WordForms.getForm(12, WordForms.HOUR_FORMS));
        Assert.assertEquals("дней", WordForms.getForm(14, WordForms.DAYS_FORMS));
        Assert.assertEquals("минут", WordForms.getForm(14, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часов", WordForms.getForm(14, WordForms.HOUR_FORMS));
        Assert.assertEquals("дня", WordForms.getForm(22, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуты", WordForms.getForm(22, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часа", WordForms.getForm(22, WordForms.HOUR_FORMS));
        Assert.assertEquals("дня", WordForms.getForm(24, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуты", WordForms.getForm(24, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часа", WordForms.getForm(24, WordForms.HOUR_FORMS));
        Assert.assertEquals("дней", WordForms.getForm(11, WordForms.DAYS_FORMS));
        Assert.assertEquals("минут", WordForms.getForm(11, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часов", WordForms.getForm(11, WordForms.HOUR_FORMS));
        Assert.assertEquals("дней", WordForms.getForm(111, WordForms.DAYS_FORMS));
        Assert.assertEquals("минут", WordForms.getForm(111, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часов", WordForms.getForm(111, WordForms.HOUR_FORMS));
        Assert.assertEquals("день", WordForms.getForm(131, WordForms.DAYS_FORMS));
        Assert.assertEquals("минуту", WordForms.getForm(131, WordForms.MINUTES_FORMS));
        Assert.assertEquals("час", WordForms.getForm(131, WordForms.HOUR_FORMS));
        Assert.assertEquals("дней", WordForms.getForm(113, WordForms.DAYS_FORMS));
        Assert.assertEquals("минут", WordForms.getForm(113, WordForms.MINUTES_FORMS));
        Assert.assertEquals("часов", WordForms.getForm(113, WordForms.HOUR_FORMS));
    }
}