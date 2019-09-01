package cn.com.sky.spring.ioc.BeanFactoryPostProcessor.CustomEditorConfigurer;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;

public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

//    private PropertyEditor propertyEditor;
//
//    public void registerCustomEditors(PropertyEditorRegistry peRegistry) {
//        peRegistry.registerCustomEditor(java.util.Date.class, getPropertyEditor());
//    }
//
//    public PropertyEditor getPropertyEditor() {
//        return propertyEditor;
//    }
//
//    public void setPropertyEditor(PropertyEditor propertyEditor) {
//        this.propertyEditor = propertyEditor;
//    }

}