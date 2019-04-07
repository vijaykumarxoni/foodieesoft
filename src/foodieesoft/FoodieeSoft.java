/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodieesoft;

import geeks.foodieesoft.dao.DBConnection;
import geeks.foodieesoft.frames.LoginPage;

/**
 *
 * @author Vksoni
 */
public class FoodieeSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection.load();
        new LoginPage().setVisible(true);

    }
    
}
