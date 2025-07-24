package test1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.获取数据源对象
        DataSource ds=new MysqlDataSource();
        ((MysqlDataSource)ds).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false");
//        "jdbc:mysql://127.0.0.1:3306/your_database_name?characterEncoding=utf8&useSSL=false"
        ((MysqlDataSource)ds).setUser("root");
        ((MysqlDataSource)ds).setPassword("oyjj0822");
        //2.取得连接
        Connection connection = ds.getConnection();
        //3.构建

        String sql="insert into student values(null,'张三')";
        PreparedStatement SQL=connection.prepareStatement(sql);
        //4.执行sql
        SQL.executeUpdate();
    }
}
