package cn.com.sky.spring.applicationContext.PropertyEditor;


import java.util.Date;

public class UserManager {

    /**
     * 此处是Date，xml文件是String，类型转化失败。
     */
    private Date dataValue;

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }
}