package com.ekarts.dao;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client_manager?useUnicode=yes;characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client_manager?useUnicode=true&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    
    @SuppressWarnings("finally")
    public static Connection getConnection() throws SQLException {
    	Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (con != null) {
                System.out.println("Connexió OK!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return con;
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    /**
    private static BasicDataSource dataSource;
    
    
    // Pool de connexions
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    */
}
