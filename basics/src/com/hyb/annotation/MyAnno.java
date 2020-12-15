package com.hyb.annotation;
/*
* 自定义注解
	* 格式：
		元注解
		public @interface 注解名称{
			属性列表;
		}

	* 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
			cmd里使用javac命令编译生成.class文件，然后javap命令反编译.class文件生成
		* public interface MyAnno extends java.lang.annotation.Annotation {}

	* 属性：接口中的抽象方法
		* 要求：
			1. 属性的返回值类型有下列取值
				* 基本数据类型
				* String
				* 枚举
				* 注解
				* 以上类型的数组

			2. 定义了属性，在使用时需要给属性赋值
				1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
				2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
				3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
 */
public @interface MyAnno {

    int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();   //worker中举例
    /*String name() default "张三";*/
     /*String show2();

     Person per();
     MyAnno2 anno2();

     String[] strs();*/


}