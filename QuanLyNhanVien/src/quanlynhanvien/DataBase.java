/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

    public static Connection c;
    private static String db_url = "jdbc:sqlserver://localhost:1433;databaseName=Project_Java_Nhom_HoSiHung;user=sa;password=123";

    public static Connection getConnection() throws SQLException {
        if (c == null) {
            c = DriverManager.getConnection(db_url);
            System.out.println("Ket noi server thanh cong");
        }
        return c;
    }

    public static ResultSet getData(PreparedStatement stmt) throws SQLException {
        ResultSet result = stmt.executeQuery();
        return result;
    }

    public static int setData(PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();

        return result;
    }

    public static void closeConnection() throws SQLException {
        c.close();
    }
}
