package com.example.giftsshop;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import static com.example.giftsshop.Const.*;

public class DataBaseHandler {
    private Connection dbConnection;
    private ResultSet resSet = null;

    public DataBaseHandler() {
    }

    public Connection getDbConnection()
            throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.dbConnection = DriverManager.getConnection(connectionString, dbRoot, dbPassword);
        } catch (SQLException | InvocationTargetException | InstantiationException | NoSuchMethodException |
                 IllegalAccessException | ClassNotFoundException var3) {
            throw new RuntimeException(var3);
        }

        return this.dbConnection;
    }

    public ResultSet selectClients() {
        String select = "SELECT * FROM client_";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }

        return this.resSet;
    }

    public ResultSet selectProducts() {
        String select = "SELECT * FROM product";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
        return this.resSet;
    }

    public ResultSet selectCategories() {
        String select = "SELECT * FROM category";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }

        return this.resSet;
    }

    public ResultSet selectPositions() {
        String select = "SELECT * FROM position_";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
        return this.resSet;
    }

    public ResultSet selectStaffMembers() {
        String select = "SELECT * FROM staff_member";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
        return this.resSet;
    }

    public ResultSet selectSales() {
        String select = "SELECT * FROM sale";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
        return this.resSet;
    }

    public ResultSet selectSuppliers() {
        String select = "SELECT * FROM supplier";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            this.resSet = prSt.executeQuery();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
        return this.resSet;
    }

    public ResultSet getSearchClients(String searchString) {
        String search = "SELECT * FROM client_ WHERE surname LIKE '%" + searchString +
                "%' " +
                "or name_ LIKE '%" + searchString +
                "%' or patronymic like '%" + searchString +
                "%' or address like '%" + searchString +
                "%' or telephone_number like '%" + searchString +
                "%' or date_of_birth like '%" + searchString +
                "%'";
        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchPositions(String searchString) {
        String search = "SELECT * FROM position_ WHERE position_name LIKE '%" + searchString + "%'";

        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchProducts(String searchString) {
        String search = "SELECT * FROM product WHERE product_name LIKE '%" + searchString +
                "%' " +
                "or price like '%" + searchString +
                "%'";

        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchSales(String searchString) {
        String search = "SELECT * FROM sale WHERE product_count LIKE '%" + searchString +
                "%'";

        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchStaffMembers(String searchString) {
        String search = "SELECT * FROM staff_member WHERE SNP LIKE '%" + searchString +
                "%' " +
                "or ID like '%" + searchString +
                "%' or paymentID like '%" + searchString +
                "%' or home_address like '%" + searchString +
                "%' or telephone like '%" + searchString +
                "%' or birth_date like '%" + searchString +
                "%'";

        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchSuppliers(String searchString) {
        String search = "SELECT * FROM supplier WHERE firm_name LIKE '%" + searchString +
                "%' " +
                "or country like '%" + searchString +
                "%' or firm_address like '%" + searchString +
                "%' or registration_date like '%" + searchString +
                "%'";

        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSearchCategories(String searchString) {
        String search = "SELECT * FROM category WHERE category_name LIKE '%" + searchString + "%'";
        try {
            PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(search);
            resSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void deleteClient(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM client_ WHERE client_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deletePosition(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM position_ WHERE position_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM product WHERE product_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deleteSale(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM sale WHERE sale_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deleteStaffMember(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM staff_member WHERE staff_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deleteSupplier(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM supplier WHERE supplier_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void deleteCategory(int id) {
        // SQL-запрос для удаления записи
        String delete = "DELETE FROM category WHERE category_id = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(delete)) {
            // Устанавливаем значение параметра в запросе
            preparedStatement.setInt(1, id);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи: " + e.getMessage());
        }
    }

    public void addClient(String id, String surname, String name_, String patronymic,
                          String address, String telephone_number, String date_of_birth) throws SQLException {
        String add = "INSERT INTO client_ (client_id, surname, name_, patronymic, address, telephone_number, date_of_birth ) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, name_);
            preparedStatement.setString(4, patronymic);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, telephone_number);
            preparedStatement.setString(7, date_of_birth);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateClient(String id, String surname, String name_, String patronymic,
                          String address, String telephone_number, String date_of_birth) throws SQLException {
        String add = "UPDATE client_ SET client_id = ?, surname = ?, name_ = ?," +
                "patronymic = ?, address = ?, telephone_number = ?, date_of_birth = ? WHERE client_id = ?";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, name_);
            preparedStatement.setString(4, patronymic);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, telephone_number);
            preparedStatement.setString(7, date_of_birth);
            preparedStatement.setString(8, id);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void addSale(String id, String clients_id, String products_id, String staffs_id, String product_count) throws SQLException {
        String add = "INSERT INTO sale (sale_id, clients_id, products_id, staffs_id, product_count) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, clients_id);
            preparedStatement.setString(3, products_id);
            preparedStatement.setString(4, staffs_id);
            preparedStatement.setString(5, product_count);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateSale(String id, String clients_id, String products_id, String staffs_id, String product_count) throws SQLException {
        String add = "UPDATE sale SET sale_id = ?, clients_id = ?," +
                "products_id = ?, staffs_id = ?, product_count = ? WHERE sale_id = ?";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, clients_id);
            preparedStatement.setString(3, products_id);
            preparedStatement.setString(4, staffs_id);
            preparedStatement.setString(5, product_count);
            preparedStatement.setString(6, id);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void addStaffMember(String id, String SNP, String positions_id, String ID, String paymentID,
                               String home_address, String telephone, String birth_date) throws SQLException {
        String add = "INSERT INTO staff_member (staff_id, SNP," +
                " positions_id, ID, paymentID, home_address, telephone, birth_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, SNP);
            preparedStatement.setString(3, positions_id);
            preparedStatement.setString(4, ID);
            preparedStatement.setString(5, paymentID);
            preparedStatement.setString(6, home_address);
            preparedStatement.setString(7, telephone);
            preparedStatement.setString(8, birth_date);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateStaffMember(String id, String SNP, String positions_id, String ID, String paymentID,
                               String home_address, String telephone, String birth_date) throws SQLException {
        String add ="UPDATE staff_member SET staff_id = ?, SNP = ?," +
        "positions_id = ?, ID = ?, paymentID = ?, home_address = ?, telephone = ?," +
                "birth_date = ? WHERE staff_id = ?";
        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, SNP);
            preparedStatement.setString(3, positions_id);
            preparedStatement.setString(4, ID);
            preparedStatement.setString(5, paymentID);
            preparedStatement.setString(6, home_address);
            preparedStatement.setString(7, telephone);
            preparedStatement.setString(8, birth_date);
            preparedStatement.setString(9, id);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void addSupplier(String id, String firm_name,
                        String country, String firm_address, String registration_date) throws SQLException {
        String add = "INSERT INTO supplier (supplier_id, firm_name, country, firm_address, registration_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, firm_name);
            preparedStatement.setString(3, country);
            preparedStatement.setString(4, firm_address);
            preparedStatement.setString(5, registration_date);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateSupplier(String id, String firm_name,
                            String country, String firm_address, String registration_date) throws SQLException {
        String add = "UPDATE supplier SET supplier_id = ?, firm_name = ?, " +
                "country = ?, firm_address = ?, registration_date = ? WHERE supplier_id = ?";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, firm_name);
            preparedStatement.setString(3, country);
            preparedStatement.setString(4, firm_address);
            preparedStatement.setString(5, registration_date);
            preparedStatement.setString(6, id);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void addProduct(String id, String suppliers_id,
                            String categories_id, String product_name, String price) throws SQLException {
        String add = "INSERT INTO product (product_id, suppliers_id, categories_id, product_name, price) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, suppliers_id);
            preparedStatement.setString(3, categories_id);
            preparedStatement.setString(4, product_name);
            preparedStatement.setString(5, price);
            preparedStatement.executeUpdate(); // Выполняем-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateProduct(String id, String suppliers_id,
                           String categories_id, String product_name, String price) throws SQLException {
        String add = "UPDATE product SET product_id = ?, suppliers_id = ?," +
                "categories_id = ?, product_name = ?, price = ? WHERE product_id = ?";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, suppliers_id);
            preparedStatement.setString(3, categories_id);
            preparedStatement.setString(4, product_name);
            preparedStatement.setString(5, price);
            preparedStatement.setString(6, id);
            preparedStatement.executeUpdate(); // Выполняем-запрос
        } catch (SQLException e) {
            throw e;
        }
    }


    public void addPosition(String id, String position_name) throws SQLException {
        String add = "INSERT INTO position_ (position_id, position_name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, position_name);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updatePosition(String id, String position_name) throws SQLException {
        String add = "UPDATE position_ SET position_id = ?, position_name = ? WHERE position_id = ?";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, position_name);
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос
        } catch (SQLException e) {
            throw e;
        }
    }


    public void addCategory(String id, String category_name) throws SQLException {
        String add = "INSERT INTO category (category_id, category_name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, category_name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateCategory(String id, String category_name) throws SQLException {
        String add = "UPDATE category SET category_id = ?, category_name = ? WHERE category_id = ?";

        try (PreparedStatement preparedStatement = this.getDbConnection().prepareStatement(add)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, category_name);
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}
