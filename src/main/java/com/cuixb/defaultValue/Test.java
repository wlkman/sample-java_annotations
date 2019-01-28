package com.cuixb.defaultValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args)
    {
        Method[] methods = UserBean.class.getMethods();
        Field[] fields = UserBean.class.getDeclaredFields();

        for (Field field : fields) {
            MyAnno annotation = field.getAnnotation(MyAnno.class);
            if(annotation!=null){
                System.out.println("property="+annotation.name());
            }
        }
        for (Method method : methods) {
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            if(annotation!=null){
                System.out.println("sayHello="+annotation.name());
            }
        }
    }
}
