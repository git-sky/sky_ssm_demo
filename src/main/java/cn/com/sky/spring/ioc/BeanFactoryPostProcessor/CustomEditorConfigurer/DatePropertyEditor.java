package cn.com.sky.spring.ioc.BeanFactoryPostProcessor.CustomEditorConfigurer;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    private String datePattern;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(getDatePattern());
        Date dateValue = dateTimeFormatter.parseDateTime(text).toDate();
        setValue(dateValue);
    }

    @Override
    public String getAsText() {
        return "123";
    }


    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;

    }
}