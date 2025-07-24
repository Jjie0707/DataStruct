package test1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        DataSource ds=new  MysqlDataSource();
        ((MysqlDataSource)ds).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)ds).setUser("root");
        ((MysqlDataSource)ds).setPassword("oyjj0822");

        Connection connection=ds.getConnection();

        String sql="select * from student";

        PreparedStatement SQL=connection.prepareStatement(sql);

        ResultSet set=SQL.executeQuery();
        while(set.next()){
            int id=set.getInt("id");
            String name=set.getString("name");
            System.out.println("学生id是："+id+",学生姓名是："+name);
        }
        set.close();
        connection.close();
    }
}
