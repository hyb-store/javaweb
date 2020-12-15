package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
	* 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
				1. 定义Emp类
				2. 定义方法 public List<Emp> findAll(){}
				3. 实现方法 select * from emp;
 */
class Emp{

    private int id;
    private String name;
    private int age;
    private String dep_name;
    private  String dep_location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_location() {
        return dep_location;
    }

    public void setDep_location(String dep_location) {
        this.dep_location = dep_location;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dep_name='" + dep_name + '\'' +
                ", dep_location='" + dep_location + '\'' +
                '}';
    }
}
public class jdbcDemo8Test {
    public static void main(String[] args) {
        List<Emp> all = new jdbcDemo8Test().findAll();
        System.out.println(all);
        System.out.println(all.size());
        for (Emp e : all) {
            System.out.println(e);
        }
    }
    /**
     * 查询所有Emp对象
     * @return
     */
    public List<Emp> findAll(){
        Connection con = null;
        ResultSet res = null;
        Statement stem = null;
        List<Emp> list = null;
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql:///db1","root","123456789");
            //定义sql
            String sql = "select * from emp";
            //获取执行sql的语句
            stem = con.createStatement();
            //执行sql
             res = stem.executeQuery(sql);
            //遍历结果集，封装对象，装载集合
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(res!=null){
                try {
                    res.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stem!=null){
                try {
                    stem.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
