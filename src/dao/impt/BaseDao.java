package dao.impt;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public abstract class BaseDao {

    public static boolean update(String sql, Object... args) {
        boolean UpdateSucc = false; // 判断更新是否执行
        Connection conn = null; // 连接对象
        PreparedStatement ps = null; // 数据库操作对象
        try {
            conn = DBUtil.getConnection(); // 注册驱动&获取连接
            ps = conn.prepareStatement(sql); // 预编译传入的SQL
            for (int i = 1; i <= args.length; i++) { // 通过循环，往预编译的SQL传值
                ps.setObject(i, args[i - 1]);
            }
            int row = ps.executeUpdate(); // 该SQL改变了多少行数据
            if (row != 0) { // 判断该条SQL是否改变数据，如改变，则将UpdateSucc设为true
                UpdateSucc = true;
            }
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常
        } finally {
            DBUtil.closeConnection(conn, ps, null); // 释放资源
        }
        return UpdateSucc;
    }


    // 2、查询返回值为集合
    public static <T> List <T> QueryReturnList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 查询T的代码
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) { // 通过循环，往预编译的SQL传值
                ps.setObject(i, args[i - 1]);
            }
            rs = ps.executeQuery();
            // 处理查询结果集的步骤（需要将不确定的查询表以及不确定的实体类对应上）
            // 需要将查询出来的结果中的列名称与实体类中的属性名称对应，然后传值
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // 查询出来的结果的信息都包含在MetaData中，所以需要创建这个对象
            int columnCount = resultSetMetaData.getColumnCount(); // 获取查询出来的列数
            if (columnCount != 0) { // 判断是否有查询数据
                List<T> list = new ArrayList<T>();
                while (rs.next()) {
                    //这样可以传入不同的实体，对不同的实体类和数据库中的字段进行比较，实体类的属性一定要和表的字段一一对应
                    T t = clazz.newInstance(); // 将对象实例化 == 等价于 new Student、new Teacher
                    //以下for循环是为了将查询出来的结果，与创建的实体类，进行有参构造
                    for (int i = 1; i <= columnCount; i++) { // 给对象中指定的属性赋值
                        // 获取列名、列值
                        String columnName = resultSetMetaData.getColumnName(i); // 列名
                        Object columnValue = rs.getObject(i);
                        // 通过反射去将两者进行匹配，并传值
                        Field field = clazz.getDeclaredField(columnName);
                        field.setAccessible(true);
                        field.set(t, columnValue);
                    }
                    list.add(t);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, ps, rs);
        }
        return null;
    }

    //通过条件返回数字, 例如返回总收入
    public static int selectSumIncome(String sql, Object... args) {
        int result = 0; // 判断更新是否执行
        String s = "";
        Connection conn = null; // 连接对象
        PreparedStatement ps = null; // 数据库操作对象
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(); // 注册驱动&获取连接
            ps = conn.prepareStatement(sql); // 预编译传入的SQL
            for (int i = 1; i <= args.length; i++) { // 通过循环，往预编译的SQL传值
                ps.setObject(i, args[i - 1]);
            }
             rs = ps.executeQuery();// 该SQL改变了多少行数据

            if (rs.next()) { // 判断该条SQL是否改变数据，如改变，
                s = rs.getString(1);

            }
             result = Integer.parseInt(s);

        } catch (Exception e) {
            e.printStackTrace(); // 打印异常
        } finally {
            DBUtil.closeConnection(conn, ps, null); // 释放资源
        }
        return result;
    }
    //计算总数
    public static int getTotleCount(String sql) {
        //计算总数的sql，String sql = "select count(1) from t_openroomreconrd";
        int count = -1;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                count = rs.getInt(1);//使用count存储查询出来的数据总数
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn, pst, rs);
        }
        return count;
    }
}
