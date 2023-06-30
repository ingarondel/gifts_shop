package com.example.giftsshop;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditAddController {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private TextField field3;

    @FXML
    private TextField field4;

    @FXML
    private TextField field5;

    @FXML
    private TextField field6;

    @FXML
    private TextField field7;

    @FXML
    private TextField field8;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Button modifyButton;
    DataBaseHandler dbHandler = new DataBaseHandler();
    private String idOfLastItemInTable;

    public TextField getField1() {
        return field1;
    }

    public TextField getField2() {
        return field2;
    }

    public TextField getField3() {
        return field3;
    }

    public TextField getField4() {
        return field4;
    }

    public TextField getField5() {
        return field5;
    }

    public TextField getField6() {
        return field6;
    }

    public TextField getField7() {
        return field7;
    }

    public TextField getField8() {
        return field8;
    }

    @FXML
    void initialize() {
    }

    public void setVisibleAddButton() {
        addButton.setVisible(true);
        modifyButton.setVisible(false);
    }

    public void setVisibleModifyButton() {
        addButton.setVisible(false);
        modifyButton.setVisible(true);
    }

    public void setColumnNames(String tableName) {
        switch (tableName) {
            case "product":
                this.label1.setText("suppliers_id");
                this.label2.setText("categories_id");
                this.label3.setText("product_name");
                this.label4.setText("price");
                this.label5.setVisible(false);
                this.label6.setVisible(false);
                this.label7.setVisible(false);
                this.field5.setVisible(false);
                this.field6.setVisible(false);
                this.field7.setVisible(false);
                break;
            case "client":
                this.label1.setText("surname");
                this.label2.setText("name_");
                this.label3.setText("patronymic");
                this.label4.setText("address");
                this.label5.setText("telephone_number");
                this.label6.setText("date_of_birth");
                this.label7.setVisible(false);
                this.field7.setVisible(false);
                break;
            case "sale":
                this.label1.setText("clients_id");
                this.label2.setText("products_id");
                this.label3.setText("staffs_id");
                this.label4.setText("product_count");
                this.label5.setVisible(false);
                this.label6.setVisible(false);
                this.label7.setVisible(false);
                this.field5.setVisible(false);
                this.field6.setVisible(false);
                this.field7.setVisible(false);
                break;
            case "staffMember":
                this.label1.setText("SNP");
                this.label2.setText("positions_id");
                this.label3.setText("ID");
                this.label4.setText("paymentID");
                this.label5.setText("home_address");
                this.label6.setText("telephone");
                this.label7.setText("birth_date");
                break;
            case "supplier":
                this.label1.setText("firm_name");
                this.label2.setText("country");
                this.label3.setText("firm_address");
                this.label4.setText("registration_date");
                this.label5.setVisible(false);
                this.label6.setVisible(false);
                this.label7.setVisible(false);
                this.field5.setVisible(false);
                this.field6.setVisible(false);
                this.field7.setVisible(false);
                break;
            case "position":
                this.label1.setText("position_name");
                this.label2.setVisible(false);
                this.field2.setVisible(false);
                this.label3.setVisible(false);
                this.field3.setVisible(false);
                this.label4.setVisible(false);
                this.field4.setVisible(false);
                this.label5.setVisible(false);
                this.field5.setVisible(false);
                this.label6.setVisible(false);
                this.field6.setVisible(false);
                this.label7.setVisible(false);
                this.field7.setVisible(false);
                break;
            case "category":
                this.label1.setText("category_name");
                this.label2.setVisible(false);
                this.field2.setVisible(false);
                this.label3.setVisible(false);
                this.field3.setVisible(false);
                this.label4.setVisible(false);
                this.field4.setVisible(false);
                this.label5.setVisible(false);
                this.field5.setVisible(false);
                this.label6.setVisible(false);
                this.field6.setVisible(false);
                this.label7.setVisible(false);
                this.field7.setVisible(false);
                break;
        }
    }

    @FXML
    private void handleCancle() {
        // Код обработки события закрытия окна
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private boolean isDateValid(String... input) {
        List<String> list = new ArrayList<>(Arrays.asList(input));
        for (String str : list) {
            if (str.isEmpty()) {
                return false; // Возвращаем false, если строка пустая
            }
            try {
                LocalDate date = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Формат даты
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isIntValid(String... input) {
        List<String> list = new ArrayList<>(Arrays.asList(input)); // Используем ArrayList
        for (String str : list) {
            if (str.isEmpty()) {
                return false; // Возвращаем false, если строка пустая
            }
            try {
                int number = Integer.parseInt(str); // Преобразуем строку в int
                if (number <= 0) {
                    return false; // Возвращаем false, если число не больше нуля
                }
            } catch (NumberFormatException e) {
                return false; // Возвращаем false, если разбор строки не удался
            }
        }
        return true; // Возвращаем true, если все числа корректны
    }

    private boolean isStringValid(String... input) {
        List<String> list = new ArrayList<>(Arrays.asList(input));
        for (String str : list) {
            if (str.isEmpty()) {
                return false; // Возвращаем false, если строка пустая или содержит не только буквы
            }
        }
        return true; // Возвращаем true, если все строки корректны
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText("Проверьте наличие или корректность данных в полях");
        alert.showAndWait();
    }

    private boolean isInputValid() {
        String inputField1 = field1.getText();
        String inputField2 = field2.getText();
        String inputField3 = field3.getText();
        String inputField4 = field4.getText();
        String inputField5 = field5.getText();
        String inputField6 = field6.getText();
        String inputField7 = field7.getText();
        switch (label1.getText()) {
            //product
            case "suppliers_id" -> {
                if (isIntValid(inputField1, inputField2, inputField4) && isStringValid(inputField3)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            //client
            case "surname" -> {
                if (isStringValid(inputField1, inputField2, inputField3, inputField4, inputField5, inputField6)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            // sale
            case "clients_id" -> {
                if (isIntValid(inputField1, inputField2, inputField3) && isStringValid(inputField4)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            //staffMember
            case "SNP" -> {
                if (isStringValid(inputField1, inputField3, inputField4, inputField5, inputField6,
                        inputField7) && isIntValid(inputField2)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            //supplier
            case "firm_name" -> {
                if (isStringValid(inputField1, inputField2, inputField3) &&
                        isDateValid(inputField4)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            //position //category
            case "position_name", "category_name" -> {
                if (isStringValid(inputField1)) {
                    return true;
                } else {
                    showAlert();
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
    }

    public void setIdOfLastItemInTable(String id) {
        this.idOfLastItemInTable = id;
    }

    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            try {
                switch (label1.getText()) {
                    //product
                    case "suppliers_id" -> {
                        this.dbHandler.addProduct(idOfLastItemInTable, field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //client
                    case "surname" -> {
                        this.dbHandler.addClient(idOfLastItemInTable, field1.getText(),
                                field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText());
                    }
                    // sale
                    case "clients_id" -> {
                        this.dbHandler.addSale(idOfLastItemInTable, field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //staffMember
                    case "SNP" -> {
                        this.dbHandler.addStaffMember(idOfLastItemInTable, field1.getText(),
                                field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText(),
                                field7.getText());
                    }
                    //supplier
                    case "firm_name" -> {
                        this.dbHandler.addSupplier(idOfLastItemInTable, field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //position
                    case "position_name" -> {
                        this.dbHandler.addPosition(idOfLastItemInTable, field1.getText());
                    }
                    //category
                    case "category_name" -> {
                        this.dbHandler.addCategory(idOfLastItemInTable, field1.getText());
                    }
                }
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            } catch (SQLException e) {
                showAlert();
            }
        }
    }

    @FXML
    private void handleModify() {
        if (isInputValid()) {
            try {
                switch (label1.getText()) {
                    //product
                    case "suppliers_id" -> {
                        this.dbHandler.updateProduct(field8.getText(), field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //client
                    case "surname" -> {
                        this.dbHandler.updateClient(field8.getText(), field1.getText(),
                                field2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText());
                    }
                    //sale
                    case "clients_id" -> {
                        this.dbHandler.updateSale(field8.getText(), field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //staffMember
                    case "SNP" -> {
                        this.dbHandler.updateStaffMember(field8.getText(), field1.getText(),
                                field2.getText(), field3.getText(), field4.getText(),
                                field5.getText(), field6.getText(), field7.getText());
                    }
                    //supplier
                    case "firm_name" -> {
                        this.dbHandler.updateSupplier(field8.getText(), field1.getText(),
                                field2.getText(), field3.getText(), field4.getText());
                    }
                    //position
                    case "position_name" -> {
                        this.dbHandler.updatePosition(field8.getText(), field1.getText());
                    }
                    //category
                    case "category_name" -> {
                        this.dbHandler.updateCategory(field8.getText(), field1.getText());
                    }
                }
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            } catch (SQLException e) {
                showAlert();
            }
        }
    }
}
