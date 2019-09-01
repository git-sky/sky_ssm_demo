package cn.com.sky.spring.ioc.BeanFactoryPostProcessor.CustomEditorConfigurer;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern;

    /**
     * 果仅仅是支持单向的从String到相应对象类型的转换，只要覆写方法setAsText(String)即可。
     * 如果想支持双向转换，需要同时考虑getAsText()方法的覆写。
     */
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