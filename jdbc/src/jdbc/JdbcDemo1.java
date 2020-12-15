package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
详解各个对象：
	1. DriverManager：驱动管理对象
		* 功能：
			1. 注册驱动：告诉程序该使用哪一个数据库驱动jar
				static void registerDriver(Driver driver) :注册与给定的驱动程序 DriverManager 。
				写代码使用：  Class.forName("com.mysql.jdbc.Driver");
				通过查看源码发现：在com.mysql.jdbc.Driver类中存在静态代码块
				 static {
				        try {
				            java.sql.DriverManager.registerDriver(new Driver());
				        } catch (SQLException E) {
				            throw new RuntimeException("Can't register driver!");
				        }
					}
				注意：mysql5之后的驱动jar包可以省略注册驱动的步骤。
			2. 获取数据库连接：
				* 方法：static Connection getConnection(String url, String user, String password)
				* 参数：
					* url：指定连接的路径
						* 语法：jdbc:mysql://ip地址(域名):端口号/数据库名称
						* 例子：jdbc:mysql://localhost:3306/db3
						* 细节：如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：jdbc:mysql:///数据库名称
					* user：用户名
					* password：密码
	2. Connection：数据库连接对象
		1. 功能：
			1. 获取执行sql 的对象
				* Statement createStatement()
				* PreparedStatement prepareStatement(String sql)
			2. 管理事务：
				* 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
				* 提交事务：commit()
				* 回滚事务：rollback()
	3. Statement：执行sql的对象
		1. 执行sql
			1. boolean execute(String sql) ：可以执行任意的sql 了解
			2. int executeUpdate(String sql) ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
				* 返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
			3. ResultSet executeQuery(String sql)  ：执行DQL（select)语句
     4. ResultSet：结果集对象,封装查询结果
            * boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果是，则返回false，如果不是则返回true
            * getXxx(参数):获取数据
                * Xxx：代表数据类型   如： int getInt() ,	String getString()
                * 参数：
                    1. int：代表列的编号,从1开始   如： getString(1)
                    2. String：代表列名称。 如： getDouble("balance")
 */
/**
 * JDBC快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {

        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456789");
       // Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "123456789");
        //4.定义sql语句
//        String sql = "update account set balance = 2000 where id = 1";
        String sql = "update stu set age = 20 where id = 1";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }
}