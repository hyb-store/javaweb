package com.hyb.junit.test;
/*
测试分类：
	1. 黑盒测试：不需要写代码，给输入值，看程序是否能够输出期望的值。
	2. 白盒测试：需要写代码的。关注程序具体的执行流程。
junit使用：白盒测试
     步骤：
		1. 定义一个测试类(测试用例)
			建议：1.测试类名：被测试的类名Test	2.包名：xxx.xxx.xx.test
		2. 定义测试方法：可以独立运行
			建议：
				1.方法名：test+测试的方法名	2.返回值：void  3.参数列表：空参
		3. 给方法加@Test
		4. 导入junit依赖环境
判定结果：   红色：失败        绿色：成功
	 一般我们会使用断言操作来处理结果:   Assert.assertEquals(期望的结果,运算的结果);
补充：
	* @Before: 修饰的方法会在测试方法之前被自动执行
	* @After: 修饰的方法会在测试方法执行之后自动被执行
 */


import com.hyb.junit.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

//    初始化方法：
//     用于资源申请，所有测试方法在执行之前都会先执行该方法
    @Before
    public void init(){
        System.out.println("init...");
    }


//   释放资源方法：
//    在所有测试方法执行完后，都会自动执行该方法
    @After
    public void close(){
        System.out.println("close...");
    }

    //测试add方法
   @Test
    public void TestAdd(){
       //System.out.println("我被执行了");
       //1.创建计算器对象
       System.out.println("testAdd...");
       Calculator c  = new Calculator();
       //2.调用add方法
       int result = c.add(1, 2);
       System.out.println(result);

       //3.断言  我断言这个结果是3
       Assert.assertEquals(3,result);  //add方法返回如果是a-b,那么结果是-1java.lang.AssertionError:预期:3实际:-1
                                                // at org.junit.Assert.failNotEquals
    }
    @Test
    public void testSub(){
        //1.创建计算器对象
        Calculator c  = new Calculator();
        int result = c.sub(1, 2);
        System.out.println("testSub....");
        Assert.assertEquals(-1,result);
    }

}
