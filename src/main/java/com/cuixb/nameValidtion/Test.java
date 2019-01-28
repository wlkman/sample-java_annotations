package com.cuixb.nameValidtion;

public class Test {
    public static void main(String[] args)
    {
        UserBean userBean = new UserBean();

        userBean.setName("liang");
        userBean.setAge("1");

        System.out.println(UserBeanCheck.check(userBean));
    }
}
