/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author toringje_sd2082
 */
public class Columnwithout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jessa", "root", "");
        stmt = (Statement) con.createStatement();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        for (int i = 1; i < 1001; i++) {
            try {

//                ResultSet rs = stmt.executeQuery(null);
                String sql = "INSERT INTO `sql_test`(`id`, `column1`, `column2`, `column3`, `column4`, `column5`) VALUES (" + i + "," + (i) + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";

                stmt.executeUpdate(sql);
                con.close();

            } catch (SQLException e) {
//                System.out.println("Error!");

            }
        }
        DateTimeFormatter falala = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime later = LocalDateTime.now();
        System.out.println(falala.format(later));
    }
}
