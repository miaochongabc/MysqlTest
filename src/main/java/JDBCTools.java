import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCTools {

    public static Connection getConnection() throws Exception
    {
        //1.  准备连接数据库的4个字符串
        String driver = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;
        //1）.创建Properties 对象
        Properties properties = new Properties();
        //2）。 获取jdbc.properties 对应的输入流
        InputStream in =
                JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //3). 加载2) 对应的输入流
        properties.load(in);

        //4）. 具体决定user , password 等4个字符串
        driver = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        //2.加载数据库驱动程序（对应的Driver 实现类中有注册驱动的静态代码块）
        Class.forName(driver);

        //3. 通过DriverManager 的getConnection() 方法获取数据库连接.
        return DriverManager.getConnection(jdbcUrl, user, password);
    }



    /**
     * 关闭Statement 和Connection
     */
    public static void release(Statement statement, Connection conn)
    {
        if(statement!=null)
        {
            try {
                statement.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        //*******
        if(conn!=null)
        {
            try {
                conn.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }


    public static void release(ResultSet rs,
                               Statement statement, Connection conn)
    {
        if(rs != null)
        {
            try {
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(statement!=null)
        {
            try {
                statement.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

        //********
        if(conn!=null)
        {
            try {
                conn.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }


}


