package jdbc;

import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class JDBCDemo8Test02{

    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo8Test02().findAll2();
        System.out.println(list);
        System.out.println(list.size());
        for (Emp e : list) {
            System.out.println(e);
        }
    }

    /**
     * 演示JDBC工具类
     * @return
     */
    public List<Emp> findAll2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        List<Emp> list = null;
        try {
           /* //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", 123456789");*/
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from emp";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            res = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(res.next()){
                //获取数据
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String dep_name = res.getString("dep_name");
                String dep_location = res.getString("dep_location");
                //创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setAge(age);
                emp.setDep_name(dep_name);
                emp.setDep_location(dep_location);
                //装载集合
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JDBCUtils.close(res,stmt,conn);
        }
        return list;
    }

}
