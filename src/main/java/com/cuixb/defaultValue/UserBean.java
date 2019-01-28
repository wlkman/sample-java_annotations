package com.cuixb.defaultValue;

public class UserBean {
    @MyAnno(name = "zhang")
    private String name;

    @MyAnno(name = "zhang@example.com")
    private String email;


    @MyAnno(name = "sayHelloWorld")
    public String sayHello(){
        return "";
    }
}
