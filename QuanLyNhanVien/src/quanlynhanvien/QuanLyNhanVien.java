/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;

/*
 *  Quản lý Nhân Viên
 * 31/12/2020
 */
public class QuanLyNhanVien {

    public static void main(String[] args) throws SQLException, ParseException {
        //Mở kết nối database
        DataBase.getConnection();
        //Tạo view
        QLNVView view = new QLNVView();
        //Set thuộc tính cho view
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Tạo login
        QLNVLogin login=new QLNVLogin();
        //Set thuộc tính cho login
        view.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Tạo controller
        QLNVController controller = new QLNVController(new QLNVModel(), view, login);
    }
}
