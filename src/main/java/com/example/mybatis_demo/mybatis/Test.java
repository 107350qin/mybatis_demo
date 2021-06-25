package com.example.mybatis_demo.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Connection conn = null ;
        List list = new ArrayList();
        try{
            //加载JDBC驱动程序：
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 问号后面是解决中文乱码输入问题,UTC是统一标准世界时间
            String url = "jdbc:mysql://10.18.34.41:3306/phes_biz?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String username = "root";
            String password = "Root_12root";
            // 创建与MySQL数据库的连接类的实例
            conn = DriverManager.getConnection(url, username, password);
            // 用conn创建Statement对象类实例
            Statement sql_statement = conn.createStatement();
            // sql拼装
//		    String sql = " insert into students (name, age, no) values ('张三', 20, '00001') " ;
            String sql = " select * from t_ecrs_event_info " ;
            // 执行sql
            ResultSet result = sql_statement.executeQuery(sql);
//		    int num = sql_statement.executeUpdate(sql);
//		    System.out.println("返回结果："+num);
            //处理结果
            int column = result!=null? result.getMetaData().getColumnCount() : 0;
            // 一行数据
            while (result.next()) {
                // 对象数组，表示一行数据
                Map map = new HashMap();

                for (int i = 1; i <= column; i++) {
                    // 获得列名
                    String columnName = result.getMetaData().getColumnName(i);
                    map.put(columnName, result.getObject(columnName));
                }
                list.add(map);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                // 关闭连接
                try {
                    conn.close();
                }
                catch (Exception e) {
                    System.out.println("连接关闭异常");
                }
            }
        }
        for (Object o : list) {
            System.out.println(o);
            System.out.println();
        }
    }

}
