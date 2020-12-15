package com.hyb.reflect;


import com.hyb.domain.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo3_Constructor {

    /**
     Class对象功能：
     * 获取功能：
     1. 获取成员变量们
         * Field[] getFields()
         * Field getField(String name)

         * Field[] getDeclaredFields()
         * Field getDeclaredField(String name)
     2. 获取构造方法们
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)

         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * Constructor<?>[] getDeclaredConstructors()
     3. 获取成员方法们：
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     4. 获取类名
        * String getName()



     */

    public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
            2. 获取构造方法们
                 * Constructor<?>[] getConstructors()
                 * Constructor<T> getConstructor(类<?>... parameterTypes)

                 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
                 * Constructor<?>[] getDeclaredConstructors()
         */


        //Constructor<T> getConstructor(类<?>... parameterTypes)
        //两个参数
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);//public com.hyb.domain.Person(java.lang.String,int)

        //创建对象
        // T newInstance(Object... initargs)
        // 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);//Person{name='张三', age=23, a='null', b='null', c='null', d='null'}

        System.out.println("----------");

        //空参
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1); //public com.hyb.domain.Person()

        //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);//Person{name='null', age=0, a='null', b='null', c='null', d='null'}

        // T newInstance()  创建此 Class 对象所表示的类的一个新实例。
        Object o = personClass.newInstance();
        System.out.println(o);//Person{name='null', age=0, a='null', b='null', c='null', d='null'}


        //constructor1.setAccessible(true);
    }


}

