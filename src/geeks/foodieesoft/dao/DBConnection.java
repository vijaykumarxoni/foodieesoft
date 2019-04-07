/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vksoni
 */
public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/foodiee_soft";
    private static String user = "root";
    private static String password = "";
    public static Connection con;

    public static void load() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DataBase Succesfully Loaded");

        } catch (Exception e) {

            System.out.println("Error in Load");
            e.printStackTrace();
        }

    }
}
