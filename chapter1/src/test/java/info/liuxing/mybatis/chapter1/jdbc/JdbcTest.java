package info.liuxing.mybatis.chapter1.jdbc;

import java.sql.*;

/**
 * JdbcTest
 *
 * @author liuxing (SE)
 * @summary JdbcTest
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017-10-11 17:46
 */
public class JdbcTest {

    public static void main(String[] args) {
        Connection connection = null;
        // PreparedStatement是预编译的Statement，通过Statement发起数据库的操作
        // PreparedStatement防止sql注入，执行数据库效率高
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "");
            // 定义sql语句 ?表示占位符
            String sql = "SELECT * FROM User WHERE id = ?";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "1");
            // 向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("userName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
