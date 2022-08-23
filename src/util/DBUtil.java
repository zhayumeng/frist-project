package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// 连接数据库的工具类
public class DBUtil {
    // 注册驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 获取链接(输入值，返回值)
    public static Connection getConnection() throws Exception {
        InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
        Properties p = new Properties();
        p.load(input);

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        return DriverManager.getConnection(url, user, password);
    }

    // 释放资源
    public static void closeConnection(Connection c, PreparedStatement ps, ResultSet r) {
        if (r != null) {
            try {
                r.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
