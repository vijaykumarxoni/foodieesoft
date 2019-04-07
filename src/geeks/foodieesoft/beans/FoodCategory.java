/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.beans;

/**
 *
 * @author Vksoni
 */
public class FoodCategory {
    
    private int food_cat_id;
    private int active;
    private int created_by;
    private int modified_by;
    private String created_date;
    private String modification_date;
    private String food_name;
public FoodCategory() {
    }
public FoodCategory(int user_cat_id) {
    this.food_cat_id=user_cat_id;
    }
    public FoodCategory(int user_cat_id, String user_type,int modified_by, String modification_date) {
    
        this.food_cat_id = user_cat_id;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
        this.food_name = user_type;
    }

    

    public FoodCategory(int user_cat_id, int active,
            int created_by, int modified_by, String created_date, String modification_date, String user_type) {
        this.food_cat_id = user_cat_id;
        this.active = active;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_date = created_date;
        this.modification_date = modification_date;
        this.food_name = user_type;
    }

    public String getFood_type() {
        return food_name;
    }

    public FoodCategory(int created_by, String created_date, String user_type) {
        this.created_by = created_by;
        this.created_date = created_date;
        this.food_name = user_type;
    }

    public void setFood_type(String user_type) {
        this.food_name = user_type;
    }

    public int getFood_cat_id() {
        return food_cat_id;
    }

    public void setFood_cat_id(int user_cat_id) {
        this.food_cat_id = user_cat_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }

    
}
