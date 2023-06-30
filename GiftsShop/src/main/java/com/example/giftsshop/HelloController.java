package com.example.giftsshop;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TableColumn<Product, Integer> ID;

    @FXML
    private Button ModifyButton;

    @FXML
    private TableColumn<StaffMember, String> SNP;

    @FXML
    private TableColumn<StaffMember, String> address;

    @FXML
    private TableColumn<StaffMember, String> birth_date;

    @FXML
    private TableColumn<Product, Integer> categories_id;

    @FXML
    private TableView<Category> categoryTable;

    @FXML
    private TableColumn<Category, Integer> category_id;

    @FXML
    private TableColumn<Category, String> category_name;

    @FXML
    private ChoiceBox<String> chooseTable;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Integer> client_id;

    @FXML
    private TableColumn<Sale, Integer> clients_id;

    @FXML
    private TableColumn<Supplier, String> country;

    @FXML
    private TableColumn<Client, String> date_of_birth;

    @FXML
    private TableColumn<Supplier, String> firm_address;

    @FXML
    private TableColumn<Supplier, String> firm_name;

    @FXML
    private TableColumn<StaffMember, String> home_address;

    @FXML
    private TableColumn<Client, String> name_;

    @FXML
    private TableColumn<Client, String> patronymic;

    @FXML
    private TableColumn<StaffMember, String> paymentID;

    @FXML
    private TableView<Position> positionTable;

    @FXML
    private TableColumn<Position, Integer> position_id;

    @FXML
    private TableColumn<Position, String> position_name;

    @FXML
    private TableColumn<StaffMember, Integer> positions_id;

    @FXML
    private TableColumn<Product, Integer> price;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Sale, String> product_count;

    @FXML
    private TableColumn<Product, Integer> product_id;

    @FXML
    private TableColumn<Product, String> product_name;

    @FXML
    private TableColumn<Sale, Integer> products_id;

    @FXML
    private TableColumn<Supplier, Date> registration_date;

    @FXML
    private TableView<Sale> saleTable;

    @FXML
    private TableColumn<Sale, Integer> sale_id;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<StaffMember> staffMemberTable;

    @FXML
    private TableColumn<StaffMember, Integer> staff_id;

    @FXML
    private TableColumn<Sale, Integer> staffs_id;

    @FXML
    private TableView<Supplier> supplierTable;

    @FXML
    private TableColumn<Supplier, Integer> supplier_id;

    @FXML
    private TableColumn<Product, Integer> suppliers_id;

    @FXML
    private TableColumn<Client, String> surname;

    @FXML
    private TableColumn<StaffMember, String> telephone;

    @FXML
    private TableColumn<Client, String> telephone_number;
    ObservableList<String> tables = FXCollections.observableArrayList();
    ObservableList<Category> categories = FXCollections.observableArrayList();
    ObservableList<Position> positions = FXCollections.observableArrayList();
    ObservableList<Client> clients = FXCollections.observableArrayList();
    ObservableList<StaffMember> staffMembers = FXCollections.observableArrayList();
    ObservableList<Sale> sales = FXCollections.observableArrayList();
    ObservableList<Product> products = FXCollections.observableArrayList();
    ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
    DataBaseHandler dbHandler = new DataBaseHandler();

    public HelloController() {

    }

    private void addCategories() {
        ResultSet Category = this.dbHandler.selectCategories();
        try {
            while (Category.next()) {
                Category category = new Category();
                category.setCategory_id(Category.getInt(1));
                category.setCategory_name(Category.getString(2));
                this.categories.add(category);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addProducts() {
        ResultSet Product = this.dbHandler.selectProducts();

        try {
            while (Product.next()) {
                Product product = new Product();
                product.setProduct_id(Product.getInt(1));
                product.setSuppliers_id(Product.getInt(2));
                product.setCategories_id(Product.getInt(3));
                product.setProduct_name(Product.getString(4));
                product.setPrice(Product.getInt(5));
                this.products.add(product);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addStaffMembers() {
        ResultSet StaffMember = this.dbHandler.selectStaffMembers();

        try {
            while (StaffMember.next()) {
                StaffMember staffMember = new StaffMember();
                staffMember.setStaff_id(StaffMember.getInt(1));
                staffMember.setSNP(StaffMember.getString(2));
                staffMember.setPositions_id(StaffMember.getInt(3));
                staffMember.setID(StaffMember.getString(4));
                staffMember.setPaymentID(StaffMember.getString(5));
                staffMember.setHome_address(StaffMember.getString(6));
                staffMember.setTelephone(StaffMember.getString(7));
                staffMember.setBirth_date(StaffMember.getString(8));
                this.staffMembers.add(staffMember);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addSuppliers() {
        ResultSet Supplier = this.dbHandler.selectSuppliers();

        try {
            while (Supplier.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplier_id(Supplier.getInt(1));
                supplier.setFirm_name(Supplier.getString(2));
                supplier.setCountry(Supplier.getString(3));
                supplier.setFirm_address(Supplier.getString(4));
                supplier.setRegistration_date(Supplier.getDate(5));
                this.suppliers.add(supplier);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addSales() {
        ResultSet Sale = this.dbHandler.selectSales();

        try {
            while (Sale.next()) {
                Sale sale = new Sale();
                sale.setSale_id(Sale.getInt(1));
                sale.setClients_id(Sale.getInt(2));
                sale.setProducts_id(Sale.getInt(3));
                sale.setStaffs_id(Sale.getInt(4));
                sale.setProduct_count(Sale.getString(5));
                this.sales.add(sale);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addPositions() {
        ResultSet Position = this.dbHandler.selectPositions();

        try {
            while (Position.next()) {
                Position position = new Position();
                position.setPosition_id(Position.getInt(1));
                position.setPosition_name(Position.getString(2));
                this.positions.add(position);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void addClients() {
        ResultSet Client = this.dbHandler.selectClients();

        try {
            while (Client.next()) {
                Client client = new Client();
                client.setClient_id(Client.getInt(1));
                client.setSurname(Client.getString(2));
                client.setName_(Client.getString(3));
                client.setPatronymic(Client.getString(4));
                client.setAddress(Client.getString(5));
                client.setTelephone_number(Client.getString(6));
                client.setDate_of_birth(Client.getString(7));
                this.clients.add(client);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchClient() {
        clientTable.getItems().clear();
        ResultSet searchedClient = this.dbHandler.getSearchClients(searchField.getText());
        try {
            while (searchedClient.next()) {
                Client client = new Client();
                client.setClient_id(searchedClient.getInt(1));
                client.setSurname(searchedClient.getString(2));
                client.setName_(searchedClient.getString(3));
                client.setPatronymic(searchedClient.getString(4));
                client.setAddress(searchedClient.getString(5));
                client.setTelephone_number(searchedClient.getString(6));
                client.setDate_of_birth(searchedClient.getString(7));
                this.clients.add(client);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchSupplier() {
        supplierTable.getItems().clear();
        ResultSet searchedSupplier = this.dbHandler.getSearchSuppliers(searchField.getText());
        try {
            while (searchedSupplier.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplier_id(searchedSupplier.getInt(1));
                supplier.setFirm_name(searchedSupplier.getString(2));
                supplier.setCountry(searchedSupplier.getString(3));
                supplier.setFirm_address(searchedSupplier.getString(4));
                supplier.setRegistration_date(searchedSupplier.getDate(5));
                this.suppliers.add(supplier);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchPosition() {
        positionTable.getItems().clear();
        ResultSet searchedPosition = this.dbHandler.getSearchPositions(searchField.getText());
        try {
            while (searchedPosition.next()) {
                Position position = new Position();
                position.setPosition_id(searchedPosition.getInt(1));
                position.setPosition_name(searchedPosition.getString(2));
                this.positions.add(position);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchProduct() {
        productTable.getItems().clear();
        ResultSet searchedProduct = this.dbHandler.getSearchProducts(searchField.getText());
        try {
            while (searchedProduct.next()) {
                Product product = new Product();
                product.setProduct_id(searchedProduct.getInt(1));
                product.setSuppliers_id(searchedProduct.getInt(2));
                product.setCategories_id(searchedProduct.getInt(3));
                product.setProduct_name(searchedProduct.getString(4));
                product.setPrice(searchedProduct.getInt(5));
                this.products.add(product);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchSale() {
        saleTable.getItems().clear();
        ResultSet searchedSale = this.dbHandler.getSearchSales(searchField.getText());
        try {
            while (searchedSale.next()) {
                Sale sale = new Sale();
                sale.setSale_id(searchedSale.getInt(1));
                sale.setClients_id(searchedSale.getInt(2));
                sale.setProducts_id(searchedSale.getInt(3));
                sale.setStaffs_id(searchedSale.getInt(4));
                sale.setProduct_count(searchedSale.getString(5));
                this.sales.add(sale);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchStaffMember() {
        staffMemberTable.getItems().clear();
        ResultSet searchedStaffMember = this.dbHandler.getSearchStaffMembers(searchField.getText());
        try {
            while (searchedStaffMember.next()) {
                StaffMember staffMember = new StaffMember();
                staffMember.setStaff_id(searchedStaffMember.getInt(1));
                staffMember.setSNP(searchedStaffMember.getString(2));
                staffMember.setPositions_id(searchedStaffMember.getInt(3));
                staffMember.setID(searchedStaffMember.getString(4));
                staffMember.setPaymentID(searchedStaffMember.getString(5));
                staffMember.setHome_address(searchedStaffMember.getString(6));
                staffMember.setTelephone(searchedStaffMember.getString(7));
                staffMember.setBirth_date(searchedStaffMember.getString(8));
                this.staffMembers.add(staffMember);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public void searchCategory() {
        categoryTable.getItems().clear();
        ResultSet searchedCategory = this.dbHandler.getSearchCategories(searchField.getText());
        try {
            while (searchedCategory.next()) {
                Category category = new Category();
                category.setCategory_id(searchedCategory.getInt(1));
                category.setCategory_name(searchedCategory.getString(2));

                this.categories.add(category);
            }
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    private void updateButtonVisibility(Object newValue) {
        // Обновление видимости кнопки в зависимости от состояния выбранной записи
        if (newValue == null) {
            DeleteButton.setVisible(false);
            ModifyButton.setVisible(false);
        } else {
            DeleteButton.setVisible(true);
            ModifyButton.setVisible(true);
        }
    }

    private void initializeTableListeners() {
        // Обработчик событий для выбора записи в таблице "clients"
        clientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Обновление видимости кнопки в зависимости от состояния выбранной записи
            updateButtonVisibility(newValue);
        });
        saleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        supplierTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        productTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        staffMemberTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        positionTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonVisibility(newValue);
        });
        //Слушатель для поиска данных
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            switch (chooseTable.getValue()) {
                case "client":
                    searchClient();
                case "product":
                    searchProduct();
                case "position":
                    searchPosition();
                case "supplier":
                    searchSupplier();
                case "staffMember":
                    searchStaffMember();
                case "sale":
                    searchSale();
                case "category":
                    searchCategory();
            }
        });
    }

    public void updateTables() {
        clientTable.getItems().clear();
        categoryTable.getItems().clear();
        positionTable.getItems().clear();
        productTable.getItems().clear();
        saleTable.getItems().clear();
        staffMemberTable.getItems().clear();
        supplierTable.getItems().clear();
        addClients();
        addCategories();
        addPositions();
        addProducts();
        addSales();
        addStaffMembers();
        addSuppliers();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addClients();
        this.addCategories();
        this.addProducts();
        this.addSuppliers();
        this.addPositions();
        this.addStaffMembers();
        this.addSales();
        this.saleTable.setVisible(false);
        this.clientTable.setVisible(false);
        this.supplierTable.setVisible(false);
        this.positionTable.setVisible(false);
        this.staffMemberTable.setVisible(false);
        this.productTable.setVisible(false);
        this.categoryTable.setVisible(false);
        this.DeleteButton.setVisible(false);
        this.AddButton.setVisible(false);
        this.ModifyButton.setVisible(false);
        this.tables.addAll(new String[]{"product", "supplier", "client", "position", "category", "staffMember", "sale"});
        this.chooseTable.setItems(this.tables);
        initializeTableListeners();
        this.chooseTable.setOnAction((event) -> {
            switch ((String) this.chooseTable.getValue()) {
                case "product":
                    this.productTable.setDisable(false);
                    this.productTable.setVisible(true);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.productTable.setItems(this.products);
                    this.productTable.setLayoutX(34.0);
                    this.productTable.setLayoutY(60.0);
                    this.productTable.setPrefHeight(250.0);
                    break;
                case "supplier":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(false);
                    this.supplierTable.setVisible(true);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.supplierTable.setItems(this.suppliers);
                    this.supplierTable.setLayoutX(34.0);
                    this.supplierTable.setLayoutY(60.0);
                    this.supplierTable.setPrefHeight(250.0);
                    break;
                case "client":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(false);
                    this.clientTable.setVisible(true);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.clientTable.setItems(this.clients);
                    this.clientTable.setLayoutX(34.0);
                    this.clientTable.setLayoutY(60.0);
                    this.clientTable.setPrefHeight(250.0);
                    break;
                case "position":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(false);
                    this.positionTable.setVisible(true);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.positionTable.setItems(this.positions);
                    this.positionTable.setLayoutX(34.0);
                    this.positionTable.setLayoutY(60.0);
                    this.positionTable.setPrefHeight(250.0);
                    break;
                case "category":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(false);
                    this.categoryTable.setVisible(true);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.categoryTable.setItems(this.categories);
                    this.categoryTable.setLayoutX(34.0);
                    this.categoryTable.setLayoutY(60.0);
                    this.categoryTable.setPrefHeight(250.0);
                    break;
                case "staffMember":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(false);
                    this.staffMemberTable.setVisible(true);
                    this.saleTable.setDisable(true);
                    this.saleTable.setVisible(false);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.staffMemberTable.setItems(this.staffMembers);
                    this.staffMemberTable.setLayoutX(34.0);
                    this.staffMemberTable.setLayoutY(60.0);
                    this.staffMemberTable.setPrefHeight(250.0);
                    break;
                case "sale":
                    this.productTable.setDisable(true);
                    this.productTable.setVisible(false);
                    this.supplierTable.setDisable(true);
                    this.supplierTable.setVisible(false);
                    this.clientTable.setDisable(true);
                    this.clientTable.setVisible(false);
                    this.positionTable.setDisable(true);
                    this.positionTable.setVisible(false);
                    this.categoryTable.setDisable(true);
                    this.categoryTable.setVisible(false);
                    this.staffMemberTable.setDisable(true);
                    this.staffMemberTable.setVisible(false);
                    this.saleTable.setDisable(false);
                    this.saleTable.setVisible(true);
                    this.AddButton.setVisible(true);
                    this.searchField.setVisible(true);
                    this.saleTable.setItems(this.sales);
                    this.saleTable.setLayoutX(34.0);
                    this.saleTable.setLayoutY(60.0);
                    this.saleTable.setPrefHeight(250.0);
                    break;
            }
            updateTables();

        });
        this.product_id.setCellValueFactory(new PropertyValueFactory("product_id"));
        this.suppliers_id.setCellValueFactory(new PropertyValueFactory("suppliers_id"));
        this.categories_id.setCellValueFactory(new PropertyValueFactory("categories_id"));
        this.product_name.setCellValueFactory(new PropertyValueFactory("product_name"));
        this.price.setCellValueFactory(new PropertyValueFactory("price"));
        this.client_id.setCellValueFactory(new PropertyValueFactory("client_id"));
        this.surname.setCellValueFactory(new PropertyValueFactory("surname"));
        this.name_.setCellValueFactory(new PropertyValueFactory("name_"));
        this.patronymic.setCellValueFactory(new PropertyValueFactory("patronymic"));
        this.address.setCellValueFactory(new PropertyValueFactory("address"));
        this.telephone_number.setCellValueFactory(new PropertyValueFactory("telephone_number"));
        this.date_of_birth.setCellValueFactory(new PropertyValueFactory("date_of_birth"));
        this.category_id.setCellValueFactory(new PropertyValueFactory("category_id"));
        this.category_name.setCellValueFactory(new PropertyValueFactory("category_name"));
        this.position_id.setCellValueFactory(new PropertyValueFactory("position_id"));
        this.position_name.setCellValueFactory(new PropertyValueFactory("position_name"));
        this.staff_id.setCellValueFactory(new PropertyValueFactory("staff_id"));
        this.SNP.setCellValueFactory(new PropertyValueFactory("SNP"));
        this.positions_id.setCellValueFactory(new PropertyValueFactory("positions_id"));
        this.ID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.paymentID.setCellValueFactory(new PropertyValueFactory("paymentID"));
        this.home_address.setCellValueFactory(new PropertyValueFactory("home_address"));
        this.telephone.setCellValueFactory(new PropertyValueFactory("telephone"));
        this.birth_date.setCellValueFactory(new PropertyValueFactory("birth_date"));
        this.sale_id.setCellValueFactory(new PropertyValueFactory("sale_id"));
        this.clients_id.setCellValueFactory(new PropertyValueFactory("clients_id"));
        this.products_id.setCellValueFactory(new PropertyValueFactory("products_id"));
        this.staffs_id.setCellValueFactory(new PropertyValueFactory("staffs_id"));
        this.product_count.setCellValueFactory(new PropertyValueFactory("product_count"));
        this.supplier_id.setCellValueFactory(new PropertyValueFactory("supplier_id"));
        this.firm_name.setCellValueFactory(new PropertyValueFactory("firm_name"));
        this.country.setCellValueFactory(new PropertyValueFactory("country"));
        this.firm_address.setCellValueFactory(new PropertyValueFactory("firm_address"));
        this.registration_date.setCellValueFactory(new PropertyValueFactory("registration_date"));
    }

    /* Вызывается, когда пользователь кликает по кнопке удаления */
    @FXML
    private void handleDelete() {
        String selectedTable = chooseTable.getValue(); // Получение выбранной таблицы из ChoiceBox
        switch (selectedTable) {
            case "client":
                Client client = clientTable.getSelectionModel().getSelectedItem();
                if (client != null) {
                    int idDelete = client.getClient_id();
                    this.dbHandler.deleteClient(idDelete);
                }
                break;
            case "position":
                Position position = positionTable.getSelectionModel().getSelectedItem();
                if (position != null) {
                    int idDelete = position.getPosition_id();
                    this.dbHandler.deletePosition(idDelete);

                }
                break;
            case "supplier":
                Supplier supplier = supplierTable.getSelectionModel().getSelectedItem();
                if (supplier != null) {
                    int idDelete = supplier.getSupplier_id();
                    this.dbHandler.deleteSupplier(idDelete);
                }
                break;
            case "product":
                Product product = productTable.getSelectionModel().getSelectedItem();
                if (product != null) {
                    int idDelete = product.getProduct_id();
                    this.dbHandler.deleteProduct(idDelete);
                }
                break;
            case "staffMember":
                StaffMember staffMember = staffMemberTable.getSelectionModel().getSelectedItem();
                if (staffMember != null) {
                    int idDelete = staffMember.getStaff_id();
                    this.dbHandler.deleteStaffMember(idDelete);
                }
                break;
            case "sale":
                Sale sale = saleTable.getSelectionModel().getSelectedItem();
                if (sale != null) {
                    int idDelete = sale.getSale_id();
                    this.dbHandler.deleteSale(idDelete);
                }
                break;
            case "category":
                Category category = categoryTable.getSelectionModel().getSelectedItem();
                if (category != null) {
                    int idDelete = category.getCategory_id();
                    this.dbHandler.deleteCategory(idDelete);
                }
                break;
        }
        updateTables();
    }

    public String getIdOfLastItemInTable() {
        String selectedTable = chooseTable.getValue();
        switch (selectedTable) {
            case "client":
                clientTable.getSelectionModel().selectLast();
                return Integer.toString(clientTable.getSelectionModel().getSelectedItem().getClient_id() + 1);
            case "supplier":
                supplierTable.getSelectionModel().selectLast();
                return Integer.toString(supplierTable.getSelectionModel().getSelectedItem().getSupplier_id() + 1);
            case "product":
                productTable.getSelectionModel().selectLast();
                return Integer.toString(productTable.getSelectionModel().getSelectedItem().getProduct_id() + 1);
            case "sale":
                saleTable.getSelectionModel().selectLast();
                return Integer.toString(saleTable.getSelectionModel().getSelectedItem().getSale_id() + 1);
            case "category":
                categoryTable.getSelectionModel().selectLast();
                return Integer.toString(categoryTable.getSelectionModel().getSelectedItem().getCategory_id() + 1);
            case "position":
                positionTable.getSelectionModel().selectLast();
                return Integer.toString(positionTable.getSelectionModel().getSelectedItem().getPosition_id() + 1);
            case "staffMember":
                staffMemberTable.getSelectionModel().selectLast();
                return Integer.toString(staffMemberTable.getSelectionModel().getSelectedItem().getStaff_id() + 1);
            default:
                return "-1";
        }
    }

    @FXML
    private void handleOpenAddWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editAddWindow.fxml"));
        try {
            Parent root = loader.load();
            EditAddController editAddController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Добавление");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            editAddController.setColumnNames(chooseTable.getValue());
            editAddController.setVisibleAddButton();
            editAddController.setIdOfLastItemInTable(getIdOfLastItemInTable());
            stage.sizeToScene();
            stage.showAndWait();
            updateTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillEditData(EditAddController editController) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        switch (chooseTable.getValue()) {
            case "client" -> {
                Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(selectedClient.getSurname());
                editController.getField2().setText(selectedClient.getName_());
                editController.getField3().setText(selectedClient.getPatronymic());
                editController.getField4().setText(selectedClient.getAddress());
                editController.getField5().setText(selectedClient.getTelephone_number());
                editController.getField6().setText(selectedClient.getDate_of_birth());
                editController.getField8().setText(Integer.toString(selectedClient.getClient_id()));
            }
            case "sale" -> {
                Sale selectedSale = saleTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(Integer.toString(selectedSale.getClients_id()));
                editController.getField2().setText(Integer.toString(selectedSale.getProducts_id()));
                editController.getField3().setText(Integer.toString(selectedSale.getStaffs_id()));
                editController.getField4().setText(selectedSale.getProduct_count());
                editController.getField8().setText(Integer.toString(selectedSale.getSale_id()));
            }
            case "product" -> {
                Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(Integer.toString(selectedProduct.getSuppliers_id()));
                editController.getField2().setText(Integer.toString(selectedProduct.getCategories_id()));
                editController.getField3().setText(selectedProduct.getProduct_name());
                editController.getField4().setText(Integer.toString(selectedProduct.getPrice()));
                editController.getField8().setText(Integer.toString(selectedProduct.getProduct_id()));
            }
            case "supplier" -> {
                Supplier selectedSupplier = supplierTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(selectedSupplier.getFirm_name());
                editController.getField2().setText(selectedSupplier.getCountry());
                editController.getField3().setText(selectedSupplier.getFirm_address());
                editController.getField4().setText(sdf.format(selectedSupplier.getRegistration_date()));
                editController.getField8().setText(Integer.toString(selectedSupplier.getSupplier_id()));
            }
            case "category" -> {
                Category selectedCategory = categoryTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(selectedCategory.getCategory_name());
                editController.getField8().setText(Integer.toString(selectedCategory.getCategory_id()));
            }
            case "position" -> {
                Position selectedPosition = positionTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText(selectedPosition.getPosition_name());
                editController.getField8().setText(Integer.toString(selectedPosition.getPosition_id()));

            }
            case "staffMember" -> {
                StaffMember selectedStaffMember = staffMemberTable.getSelectionModel().getSelectedItem();
                editController.getField1().setText((selectedStaffMember.getSNP()));
                editController.getField2().setText(Integer.toString(selectedStaffMember.getPositions_id()));
                editController.getField3().setText(selectedStaffMember.getID());
                editController.getField4().setText(selectedStaffMember.getPaymentID());
                editController.getField5().setText(selectedStaffMember.getHome_address());
                editController.getField6().setText(selectedStaffMember.getTelephone());
                editController.getField7().setText(selectedStaffMember.getBirth_date());
                editController.getField8().setText(Integer.toString(selectedStaffMember.getStaff_id()));
            }
        }
    }
    @FXML
    private void handleOpenEditWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editAddWindow.fxml"));
        try {
            Parent root = loader.load();
            EditAddController editController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Редактирование");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            editController.setColumnNames(chooseTable.getValue());
            editController.setVisibleModifyButton();
            fillEditData(editController);
            stage.sizeToScene();
            stage.showAndWait();
            updateTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
