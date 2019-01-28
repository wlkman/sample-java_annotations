package com.cuixb.nameValidtion;

import java.lang.reflect.Field;

public class UserBeanCheck
{
    public static boolean check(UserBean userBean)
    {
        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = UserBean.class.getDeclaredFields();

        for (Field field : fields)
        {
            // 如果属性有注解，就进行校验
            if (field.isAnnotationPresent(Validate.class))
            {
                Validate validate = field.getAnnotation(Validate.class);
                if (field.getName().equals("age"))
                {
                    if (userBean.getAge() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("！！年龄可空校验不通过：不可为空！！");
                            return false;
                        }
                        else
                        {
                            System.out.println("年龄可空校验通过：可以为空");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("年龄可空校验通过");
                    }

                    if (userBean.getAge().length() < validate.min())
                    {
                        System.out.println("！！年龄最小长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("年龄最小长度校验通过");
                    }

                    if (userBean.getAge().length() > validate.max())
                    {
                        System.out.println("！！年龄最大长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("年龄最大长度校验通过");
                    }
                }
                if (field.getName().equals("name"))
                {
                    if (userBean.getName() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("！！名字可空校验不通过：不可为空！！");
                            return false;
                        }
                        else
                        {
                            System.out.println("名字可空校验通过：可以为空");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("名字可空校验通过");
                    }

                    if (userBean.getName().length() < validate.min())
                    {
                        System.out.println("！！名字最小长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("名字最小长度校验通过");
                    }

                    if (userBean.getName().length() > validate.max())
                    {
                        System.out.println("！！名字最大长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("名字最大长度校验通过");
                    }
                }
            }
        }

        return true;
    }
}