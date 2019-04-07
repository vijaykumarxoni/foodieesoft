/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.foodieesoft.dao;

import geeks.foodieesoft.beans.Customer;
import geeks.foodieesoft.beans.Discount;
import geeks.foodieesoft.beans.FoodCategory;
import geeks.foodieesoft.beans.Order;
import geeks.foodieesoft.beans.OrderDetail;
import geeks.foodieesoft.beans.Permissions;
import geeks.foodieesoft.beans.Product;
import geeks.foodieesoft.beans.Questions;
import geeks.foodieesoft.beans.User;
import geeks.foodieesoft.beans.UserPermissions;
import geeks.foodieesoft.beans.UserType;
import java.security.Permission;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface DBManagerInterface {
    public  User userAuthentication(String username,String password);
   
    public  String retriveUsername(int user_id);
    public int saveUserType(UserType userType);
    public ArrayList<UserType> getAllUserTypes();
    public int modifyUserType(UserType userType);
    public int removeUserType(UserType userType);
    public String getUserType(int user_type_id);

    
    public int saveFoodCategory(FoodCategory foodCategory);
    public ArrayList<FoodCategory> getAllFoodTypes();
    public int modifyFoodCategory(FoodCategory foodCategory);
    public int removeFoodCategory(FoodCategory foodCategory);
    public String getFoodType(int food_cat_id);

    
    public int saveQuestions(Questions questions);
    public ArrayList<Questions> getAllQuestions();
    public int modifyQuestions(Questions questions);
    public int removeQuestions(Questions questions);
    public String getQuestion(int question_id);

    
    public int saveProducts(Product product);
    public ArrayList<Product> getAllProducts();
    public int modifyProducts(Product product);
    public int removeProducts(Product product);
    public int mofidyProductsQuantity(Product product);
    public int getProductId(String food_name,int price);
    public Product getProduct(int proudct_id);
    
    
    public int saveCustomer(Customer customer);
    public ArrayList<Customer> getAllCustomers();
    public int modifyCustomers(Customer customer);
    public int removeCustomer(Customer customer);
    public Customer getCustomerDetail(int cust_id);
    
    
    public int saveUsers(User user);
    public ArrayList<User> getAllUsers();
    public int modifyUser(User user);
    public int removeUser(User user);
    public ArrayList<Discount>getDiscountTypes();
    public Discount getDiscountTypeById(int discount_id );
   
    
    
    public int saveOrder(Order order);
    public int getLastOrderId();
    public ArrayList<Order> getAllOrder();
    public ArrayList<Order> getAllOrderBetweenDate(String from,String to);
    
    public ArrayList<Permissions> getAssignedPermissions(int user_cat_id);
    public ArrayList<Permissions> getUnassignedPermissions(int user_cat_id);
    public int savePermission(UserPermissions userPermissions );
    public int deletePermission(UserPermissions userPermissions );
    public ArrayList<Permissions>getUserPermissionName(int user_cat_id);
    
    public int saveOrderDetail(OrderDetail order_detail);
    public ArrayList<OrderDetail> getAllOrderDetail();
    public ArrayList<OrderDetail> getAllOrderDetailById(int order_id);    
    public int modifyOrderDetail(OrderDetail order_detail);
    public int removeOrderDetail(OrderDetail order_detail);
    
    
    
    
    
    



}
