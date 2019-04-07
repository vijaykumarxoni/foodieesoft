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
import static geeks.foodieesoft.frames.SalePage.user_id;
import geeks.foodieesoft.frames.UserTypePage;
import java.security.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class DBManager implements DBManagerInterface {

    private static Connection con = DBConnection.con;

    @Override
    public User userAuthentication(String username, String password) {
        User user = null;
        try {

            String query = "SELECT * FROM user WHERE user_name =? AND password =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);    // Statement st=con.createStatement();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                String pass = rs.getString("password");
                int user_cat_id = rs.getInt("user_cat_id");

                user = new User(user_id, username, password, user_cat_id);
            }

        } catch (Exception e) {
            System.out.println("Error in userAuthentication");
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public String retriveUsername(int user_id) {
        String name = "";
        try {

            String query = "SELECT name FROM user WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }

        } catch (Exception e) {
            System.out.println("Error in retriveUsername ");
            e.printStackTrace();
        }

        return name;
    }

    @Override
    public int saveUserType(UserType userType) {
        int i = 0;
        String query = "INSERT INTO user_type(user_type, created_by, created_date) VALUES (?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userType.getUser_type());
            ps.setInt(2, userType.getCreated_by());
            ps.setString(3, userType.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<UserType> getAllUserTypes() {
        ArrayList<UserType> user_type_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM user_type WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int user_cat_id = rs.getInt("user_cat_id");
                String user_type = rs.getString("user_type");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                user_type_list.add(new UserType(user_cat_id, active, created_by, modified_by,
                        created_date, modification_date, user_type));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return user_type_list;
    }

    @Override
    public int modifyUserType(UserType userType) {
        int i = 0;
        String query = "UPDATE user_type SET user_type = ? ,modified_by = ? , modification_date = ? WHERE user_cat_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userType.getUser_type());
            ps.setInt(2, userType.getModified_by());
            ps.setString(3, userType.getModification_date());
            ps.setInt(4, userType.getUser_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Usertype");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeUserType(UserType userType) {
        int i = 0;
        String query = "UPDATE user_type SET active=0 WHERE `user_cat_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userType.getUser_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of Usertype");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int saveFoodCategory(FoodCategory foodCategory) {

        int i = 0;
        String query = "INSERT INTO food_category(food_name, created_by, created_date) VALUES (?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, foodCategory.getFood_type());
            ps.setInt(2, foodCategory.getCreated_by());
            ps.setString(3, foodCategory.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving food types");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<FoodCategory> getAllFoodTypes() {
        ArrayList<FoodCategory> food_type_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM food_category WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int food_cat_id = rs.getInt("food_cat_id");
                String food_name = rs.getString("food_name");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                food_type_list.add(new FoodCategory(food_cat_id, active, created_by, modified_by,
                        created_date, modification_date, food_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return food_type_list;
    }

    @Override
    public int modifyFoodCategory(FoodCategory foodCategory) {
        int i = 0;
        String query = "UPDATE food_category SET food_name = ? ,modified_by = ? , modification_date = ? WHERE food_cat_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, foodCategory.getFood_type());
            ps.setInt(2, foodCategory.getModified_by());
            ps.setString(3, foodCategory.getModification_date());
            ps.setInt(4, foodCategory.getFood_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Food type");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeFoodCategory(FoodCategory foodCategory) {
        int i = 0;
        String query = "UPDATE food_category SET active=0 WHERE `food_cat_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, foodCategory.getFood_cat_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of food type");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int saveQuestions(Questions questions) {

        int i = 0;
        String query = "INSERT INTO questions(question, created_by, created_date) VALUES (?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, questions.getQuestions());
            ps.setInt(2, questions.getCreated_by());
            ps.setString(3, questions.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving Questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Questions> getAllQuestions() {
        ArrayList<Questions> questions_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM questions WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int question_id = rs.getInt("question_id");
                String question = rs.getString("question");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                questions_list.add(new Questions(question_id, active, created_by, modified_by,
                        created_date, modification_date, question));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return questions_list;
    }

    @Override
    public int modifyQuestions(Questions questions) {
        int i = 0;
        String query = "UPDATE questions SET question = ? ,modified_by = ? , modification_date = ? WHERE question_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, questions.getQuestions());
            ps.setInt(2, questions.getModified_by());
            ps.setString(3, questions.getModification_date());
            ps.setInt(4, questions.getQuestion_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeQuestions(Questions questions) {
        int i = 0;
        String query = "UPDATE questions SET active=0 WHERE `question_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, questions.getQuestion_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int saveProducts(Product product) {

        int i = 0;
        String query = "INSERT INTO product (food_cat_id,food_name,price,quantity, created_by, created_date) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getFood_cat_id());
            ps.setString(2, product.getFood_name());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCreated_by());
            ps.setString(6, product.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM product WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                int category_id = rs.getInt("food_cat_id");
                String food_name = rs.getString("food_name");
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt("quantity");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                products_list.add(new Product(product_id, category_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, food_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return products_list;
    }

    @Override
    public int modifyProducts(Product product) {
        int i = 0;
        String query = "UPDATE product SET food_cat_id=?,food_name = ?,price=?,quantity=?,modified_by = ? , modification_date = ? WHERE product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getFood_cat_id());
            ps.setString(2, product.getFood_name());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getModified_by());
            ps.setString(6, product.getModification_date());
            ps.setInt(7, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of product");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeProducts(Product product) {
        int i = 0;
        String query = "UPDATE product SET active=0 WHERE `product_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of questions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int mofidyProductsQuantity(Product product) {
        int i = 0;
        String query = "UPDATE product SET quantity = ? WHERE product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getQuantity());
            ps.setInt(2, product.getProduct_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in updating quantity of products");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getFoodType(int food_cat_id) {
        String food_name = "";
        try {
            String query = "SELECT food_name FROM food_category WHERE food_cat_id=" + food_cat_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                food_name = rs.getString("food_name");

            }
        } catch (Exception e) {
            System.out.println("Error in getting food type");
            e.printStackTrace();
        }

        return food_name;
    }

    @Override
    public int saveCustomer(Customer customer) {
        int i = 0;
        String query = "INSERT INTO customer (customer_name, contact, address, created_by, created_date) VALUES(?, ?, ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getCreated_by());
            ps.setString(5, customer.getCreated_date());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i = rs.getInt(1);
            }

        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer WHERE active=1 AND customer_id>1 ";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                customers_list.add(new Customer(customer_id, active, contact, address, created_by, modified_by,
                        created_date, modification_date, customer_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return customers_list;
    }

    @Override
    public Customer getCustomerDetail(int cust_id) {
        Customer customer = null;
        try {
            String query = "SELECT * FROM customer WHERE active=1 and customer_id=" + cust_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                customer = new Customer(customer_id, active, contact, address, created_by, modified_by,
                        created_date, modification_date, customer_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting customer");
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public int modifyCustomers(Customer customer) {
        int i = 0;
        String query = " UPDATE customer SET customer_name = ? , contact = ? , address = ? , modified_by = ? , modification_date = ? WHERE customer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getModified_by());
            ps.setString(5, customer.getModification_date());
            ps.setInt(6, customer.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Customer");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeCustomer(Customer customer) {
        int i = 0;
        String query = "UPDATE customer SET active=0 WHERE `customer_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customer.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of Customer");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int saveUsers(User user) {

        int i = 0;
        String query = " INSERT INTO USER (user_cat_id, user_name, PASSWORD, NAME, address,contact_num,question_id,answer,created_by,created_date) VALUES (?,?,?,?,?,?,?,?,?,?)  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUser_cat_id());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getContact_num());
            ps.setInt(7, user.getQuestion_id());
            ps.setString(8, user.getAnswer());
            ps.setInt(9, user.getCreated_by());
            ps.setString(10, user.getCreated_date());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving user");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM user WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int user_cat_id = rs.getInt("user_cat_id");
                String user_name = rs.getString("user_name");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact_num = rs.getString("contact_num");
                int question_id = rs.getInt("question_id");
                String answer = rs.getString("answer");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                users_list.add(new User(user_id, user_cat_id, question_id, active, created_by, modified_by, user_name, password, name,
                        address, modification_date, contact_num, answer, created_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return users_list;
    }

    @Override
    public int modifyUser(User user) {
        int i = 0;
        String query = " UPDATE user SET user_cat_id = ? , user_name = ? , password = ? , name = ? , address = ? , contact_num = ? , question_id = ? , answer = ? , modified_by = ?, modification_date=? WHERE user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUser_cat_id());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getContact_num());
            ps.setInt(7, user.getQuestion_id());
            ps.setString(8, user.getAnswer());
            ps.setInt(9, user.getModified_by());
            ps.setString(10, user.getModification_date());
            ps.setInt(11, user.getUser_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of User");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeUser(User user) {
        int i = 0;
        String query = "UPDATE user SET active=0 WHERE `user_id` =? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getUser_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of User");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getUserType(int user_type_id) {

        String user_type = "";
        try {
            String query = "SELECT user_type FROM user_type WHERE user_cat_id=" + user_type_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                user_type = rs.getString("user_type");

            }
        } catch (Exception e) {
            System.out.println("Error in getting Usertype");
            e.printStackTrace();
        }

        return user_type;

    }

    @Override
    public String getQuestion(int question_id) {
        String question = "";
        try {
            String query = "SELECT question FROM questions WHERE question_id=" + question_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                question = rs.getString("question");

            }
        } catch (Exception e) {
            System.out.println("Error in getting question ");
            e.printStackTrace();
        }

        return question;

    }

    @Override
    public ArrayList<Discount> getDiscountTypes() {
        ArrayList<Discount> discount_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM discount";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int discount_id = rs.getInt("discount_id");
                String discount_type = rs.getString("discount_type");

                discount_list.add(new Discount(discount_id, discount_type));

            }
        } catch (Exception e) {
            System.out.println("Error in getting Discount types");
            e.printStackTrace();
        }

        return discount_list;
    }

    @Override
    public int saveOrder(Order order) {

        int i = 0;
        String query = "INSERT INTO order_table (customer_id, created_by, created_date, discount_id, discount, total_bill,number) VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order.getCustomer_id());
            ps.setInt(2, order.getCreated_by());
            ps.setString(3, order.getCreated_date());
            ps.setInt(4, order.getDiscount_id());
            ps.setInt(5, order.getDiscount());
            ps.setInt(6, order.getTotal_bill());
            ps.setInt(7, order.getNumber());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving order");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Permissions> getAssignedPermissions(int user_cat_id) {

        ArrayList<Permissions> assgined_permissions_list = new ArrayList<>();
        try {
            String query = "SELECT permission_id,NAME FROM `user_type` INNER JOIN `user_permission` USING (`user_cat_id`) INNER JOIN `permission` USING (`permission_id`) WHERE user_cat_id=" + user_cat_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String user_assignedPermissions = rs.getString("name");
                assgined_permissions_list.add(new Permissions(permission_id, user_assignedPermissions));
            }
        } catch (Exception e) {
            System.out.println("Error in getting User Assigned Permisions ");
            e.printStackTrace();
        }

        return assgined_permissions_list;

    }

    @Override
    public ArrayList<Permissions> getUnassignedPermissions(int user_cat_id) {

        ArrayList<Permissions> unassgined_permissions_list = new ArrayList<>();
        try {
            String query = "SELECT permission_id,NAME FROM permission WHERE permission_id NOT IN (SELECT permission_id FROM user_permission WHERE user_cat_id=" + user_cat_id + ")";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String user_assignedPermissions = rs.getString("name");
                unassgined_permissions_list.add(new Permissions(permission_id, user_assignedPermissions));
            }
        } catch (Exception e) {
            System.out.println("Error in getting User Assigned Permisions ");
            e.printStackTrace();
        }

        return unassgined_permissions_list;
    }

    @Override
    public int savePermission(UserPermissions userPermissions) {
        int i = 0;
        String query = "INSERT INTO `foodiee_soft`.`user_permission` (`user_cat_id`, `permission_id`) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userPermissions.getUser_cat_id());
            ps.setInt(2, userPermissions.getPermission_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving userPermissionss");
            System.out.println(e.getMessage());
        }
        return i;
    }

    @Override
    public int deletePermission(UserPermissions userPermissions) {
        int i = 0;
        String query = "DELETE FROM `foodiee_soft`.`user_permission` WHERE `user_cat_id` = ? AND `permission_id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userPermissions.getUser_cat_id());
            ps.setInt(2, userPermissions.getPermission_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of userPermissions");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<Permissions> getUserPermissionName(int user_cat_id) {

        ArrayList<Permissions> permission_name_list = new ArrayList<>();
        try {
            String query = "SELECT permission.`permission_id`,permission.`name` FROM permission WHERE permission_id IN(SELECT permission_id FROM user_permission WHERE user_cat_id=" + user_cat_id + ")";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String perm_name = rs.getString("name");

                permission_name_list.add(new Permissions(permission_id, perm_name));

            }
        } catch (Exception e) {
            System.out.println("Error in getting User permission name");
            e.printStackTrace();
        }

        return permission_name_list;
    }

    @Override
    public Product getProduct(int product_id) {
        Product product = null;
        try {
            String query = "SELECT * FROM product WHERE product_id=" + product_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int category_id = rs.getInt("food_cat_id");
                String food_name = rs.getString("food_name");
                int price = rs.getInt("price");
                int active = rs.getInt("active");
                int quantity = rs.getInt("quantity");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                product = new Product(product_id, category_id, active, price, quantity, created_by, modified_by,
                        created_date, modification_date, food_name);

            }
        } catch (Exception e) {
            System.out.println("Error in getting User permission name");
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public int getProductId(String food_name, int price) {
        int product_id = 0;

        return product_id;

    }

    @Override
    public int saveOrderDetail(OrderDetail order_detail) {
        int i = 0;
        String query = "INSERT INTO order_details(order_id, product_id, quantity, created_by, created_date,total_price) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, order_detail.getOrder_id());
            ps.setInt(2, order_detail.getProduct_id());
            ps.setInt(3, order_detail.getQantity());
            ps.setInt(4, order_detail.getCreated_by());
            ps.setString(5, order_detail.getCreated_date());
            ps.setDouble(6, order_detail.getTotal_price());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in saving usertypes");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<OrderDetail> getAllOrderDetail() {

        ArrayList<OrderDetail> order_detail_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_details WHERE active=1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_details_id = rs.getInt("order_details_id");
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                double total_price = rs.getDouble("total_price");
                int quantity = rs.getInt("quantity");

                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_detail_list.add(new OrderDetail(order_details_id, order_id, product_id, quantity, active, created_by, created_date, modified_by, total_price, modification_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting food types");
            e.printStackTrace();
        }

        return order_detail_list;

    }

    @Override
    public int modifyOrderDetail(OrderDetail order_detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeOrderDetail(OrderDetail order_detail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastOrderId() {
        int order_id = 0;
        try {
            String query = "SELECT order_id FROM order_table ORDER BY order_id DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                order_id = rs.getInt("order_id");

            }
        } catch (Exception e) {
            System.out.println("Error in getting order id");
            e.printStackTrace();
        }

        return order_id;
    }

    @Override
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_table WHERE active=1 ORDER BY order_id DESC";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting usertypes");
            e.printStackTrace();
        }

        return order_list;
    }

    @Override
    public ArrayList<OrderDetail> getAllOrderDetailById(int order_id) {
        ArrayList<OrderDetail> order_detail_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_details WHERE   active=1 AND order_id=" + order_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_details_id = rs.getInt("order_details_id");
                int ordr_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                double total_price = rs.getDouble("total_price");
                int quantity = rs.getInt("quantity");
                int active = rs.getInt("active");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_detail_list.add(new OrderDetail(order_details_id, ordr_id, product_id, quantity, active, created_by, created_date, modified_by, total_price, modification_date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting order details by id");
            e.printStackTrace();
        }

        return order_detail_list;
    }

    @Override
    public Discount getDiscountTypeById(int discount_id) {
        Discount discount = null;
        try {
            String query = "SELECT * FROM discount where discount_id=" + discount_id;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int discoun_id = rs.getInt("discount_id");
                String discount_type = rs.getString("discount_type");

                discount = new Discount(discount_id, discount_type);

            }
        } catch (Exception e) {
            System.out.println("Error in getting Discount types");
            e.printStackTrace();
        }

        return discount;
    }

    @Override
    public ArrayList<Order> getAllOrderBetweenDate(String from, String to) {
        ArrayList<Order> order_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_table WHERE created_date BETWEEN " + from + " AND " + to;
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customer_id = rs.getInt("customer_id");
                int number = rs.getInt("number");
                int active = rs.getInt("active");
                int discount_id = rs.getInt("discount_id");
                int discount = rs.getInt("discount");
                int total_bill = rs.getInt("total_bill");
                int created_by = rs.getInt("created_by");
                String created_date = rs.getString("created_date");
                int modified_by = rs.getInt("modified_by");
                String modification_date = rs.getString("modification_date");

                order_list.add(new Order(order_id, customer_id, number, active,
                        created_by, created_date, modified_by, modification_date,
                        discount_id, discount, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting order between date");
            System.out.println(e.getMessage());
        }

        return order_list;
    }

}
