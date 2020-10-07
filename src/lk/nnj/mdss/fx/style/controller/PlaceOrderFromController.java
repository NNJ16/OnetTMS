package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.*;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.*;
import lk.nnj.mdss.fx.Entity.Customer;
import lk.nnj.mdss.fx.dto.ContainDTO;
import lk.nnj.mdss.fx.dto.CustomerDTO;
import lk.nnj.mdss.fx.dto.OrderDTO;
import lk.nnj.mdss.fx.dto.TrackDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.textfield.TextFields;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class PlaceOrderFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView img_print;

    @FXML
    private JFXTextField txt_name;

    @FXML
    private JFXTextField txt_qty;

    @FXML
    private JFXTextField txt_sno;

    @FXML
    private JFXComboBox<String> cmd_status;

    @FXML
    private ImageView img_add;

    @FXML
    private ImageView img_remove;

    @FXML
    private TableView<ContainDTO> tbl_item;

    @FXML
    private JFXTextField txt_oid;

    @FXML
    private JFXDatePicker txt_date;

    @FXML
    private ImageView lbl_back;

    @FXML
    private ImageView lbl_search;

    @FXML
    private JFXTextField txt_cid;

    @FXML
    private JFXTextField txt_bname;

    @FXML
    private JFXTextField txt_phone;

    @FXML
    private JFXTextField txt_addr1;

    @FXML
    private JFXTextField txt_addr2;

    @FXML
    private JFXTextField txt_city;

    @FXML
    private JFXButton btn_add;

    @FXML
    private ImageView lbl_search11;

    @FXML
    void add(ActionEvent event) {
        String tid = txt_sno.getText();
        String oid = txt_oid.getText();
        String status = cmd_status.getValue();


        String item = txt_name.getText();

        String glno =txt_cid.getText();
        String baname = txt_bname.getText();
        String phone = txt_phone.getText();
        String addr1 =  txt_addr1.getText();
        String addr2 =  txt_addr2.getText();
        String city = txt_city.getText();

        if(tid.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Ship No to add");
        }else
        {
            TrackDTO trackDTO =
                    new TrackDTO(
                      tid,
                      null,
                      status,
                      "",
                      "",
                        oid
                    );
            OrderDTO orderDTO = new OrderDTO(
                    oid,
                    txt_date.getValue(),
                    "",
                    glno
            );
            CustomerDTO cusDTO = new CustomerDTO(
                    glno,
                    baname,
                    phone,
                    addr1,
                    addr2,
                    city
            );
            try {
                ManageOrderBussines.updateOrder(orderDTO);
                ManageCusBussines.updateCustomer(cusDTO);
                ManageTrackBussines.addTrack(trackDTO);
                String desc = ManageQueryBussines.findNameQty(oid);

                JOptionPane.showMessageDialog(null,"Order added Successfully");
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error! Can not add the Order.");
            }

        }


    }

    @FXML
    void addItem(MouseEvent event) throws Exception {
        String oid = txt_oid.getText();
        String item = txt_name.getText();
        String glno =txt_cid.getText();
        String baname = txt_bname.getText();
        String phone = txt_phone.getText();
        String addr1 =  txt_addr1.getText();
        String addr2 =  txt_addr2.getText();
        String city = txt_city.getText();
                int qty=0;

                if(item.equals("") || txt_qty.getText().equals("") || glno.equals("") || oid.equals("") || glno.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Required One or More Field is Empty");
                }else
                    {
                        try
                        {
                                qty = Integer.parseInt(txt_qty.getText());

                            String itemId = ManageQueryBussines.findItemId(item);
                            if(itemId ==null)
                            {
                                JOptionPane.showMessageDialog(null,"Cannot find the item");
                            }else
                            {
                                CustomerDTO cusDTO =ManageCusBussines.findCustomer(glno);
                                if(cusDTO == null) {
                                    cusDTO = new CustomerDTO(
                                            glno,
                                            baname,
                                            phone,
                                            addr1,
                                            addr2,
                                            city
                                    );
                                    try{
                                    ManageCusBussines.addCustomer(cusDTO);
                                }catch (Exception ex){
                                JOptionPane.showMessageDialog(null,"Phone Number is not valid.");
                            }
                                }
                                if(txt_date.getValue()==null)
                                {
                                    JOptionPane.showMessageDialog(null,"Date is required");
                                }else {
                                    OrderDTO oDTO = ManageOrderBussines.findOrder(oid);
                                    if (oDTO == null) {
                                        OrderDTO orderDTO =
                                                new OrderDTO(
                                                        oid,
                                                        txt_date.getValue(),
                                                        "",
                                                        glno
                                                );
                                        ManageOrderBussines.addOrder(orderDTO);
                                    }
                                    ContainDTO containDTO =
                                            new ContainDTO(
                                                    oid,
                                                    itemId,
                                                    item,
                                                    qty
                                            );
                                    try {
                                        if (qty != 0) {
                                            ManageConBussines.addContain(containDTO);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Cannot Add Same Item Twice");
                                    }
                                    viewTable();
                                }

                                String desc = ManageQueryBussines.findNameQty(oid);
                                ManageQueryBussines.uptDesc(desc,oid);

                                txt_name.setText("");
                                txt_qty.setText("");
                            }
                        } catch (NumberFormatException e)
                        {
                            JOptionPane.showMessageDialog(null,"Enter Valid Quantity");
                        } catch (Exception e)
                        {

                        }

                    }
    }

    public void findCustomer(String glno) throws Exception {

        CustomerDTO cusDTO =ManageCusBussines.findCustomer(glno);
        if(cusDTO == null)
        {

        }else
            {
                txt_bname.setText(cusDTO.getBAname());
                txt_phone.setText(cusDTO.getPhone());
                txt_addr1.setText(cusDTO.getAddr1());
                txt_addr2.setText(cusDTO.getAddr2());
                txt_city.setText(cusDTO.getCity());
            }
    }
    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/AdminPanel.fxml"));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
        }
    }

    @FXML
    void removeItem(MouseEvent event) throws Exception {
        String oid = txt_oid.getText();
        String cid =txt_cid.getText();
        String item = txt_name.getText();

        if(item.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Select item to remove");
        }else{
            try {
                ManageConBussines.deletedContain(item,oid);
                int tblitem = tbl_item.getItems().size();
                System.out.println(tblitem);
                if(tblitem==1)
                {
                    ManageOrderBussines.deleteOrder(oid);
                }
                ManageCusBussines.deleteCustomer(cid);

            } catch (Exception e) {

            }
            String desc = ManageQueryBussines.findNameQty(oid);
            ManageQueryBussines.uptDesc(desc,oid);
            viewTable();
        }

    }
    @FXML
    void click(MouseEvent event) {
        ArrayList<ContainDTO> con =  new ArrayList<>(tbl_item.getSelectionModel().getSelectedItems());
        for(ContainDTO cDTO: con)
        {
            txt_name.setText(cDTO.getName());
            txt_qty.setText(Integer.toString(cDTO.getQty()));
        }
    }
    @FXML
    void search(ActionEvent event) throws Exception {
        findCustomer(txt_cid.getText());
    }

    @FXML
    void searchc(MouseEvent event) throws Exception {
        findCustomer(txt_cid.getText());
    }
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Pending"
                );

        cmd_status.setItems(options);
        cmd_status.setValue("Pending");

        try {
            ArrayList<String> itemList = new ArrayList<>();
            itemList = ManageQueryBussines.findAllItems();
            String []items =  new String[itemList.size()];
            items = itemList.toArray(items);
            TextFields.bindAutoCompletion(txt_name,items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void reset()
    {
        txt_qty.setText("");
        txt_name.setText("");
        txt_city.setText("");
        txt_addr2.setText("");
        txt_addr1.setText("");
        txt_phone.setText("");
        txt_bname.setText("");
        txt_oid.setText("");
        txt_cid.setText("");
        txt_date.setValue(null);
        txt_sno.setText("");
        viewTable();
    }
    public void viewTable() {
        tbl_item.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_item.getColumns().get(1).setStyle("-fx-alignment: center");

        tbl_item.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("name")
                );
        tbl_item.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("qty")
                );

        try {
            List<ContainDTO> conDTOs =
                    ManageConBussines.getContains(txt_oid.getText());
            tbl_item.setItems(FXCollections.observableList(conDTOs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Stage stage = null;
    @FXML
    void Import(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/nnj/mdss/fx/style/AddExcelFile.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        if(root != null) {
            if(stage == null)
            {
                stage = new Stage();
                stage.setTitle("Import from Excel");
                Image image = new Image("/lk/nnj/mdss/fx/assest/main.png");
                stage.getIcons().add(image);
                stage.setResizable(false);
                stage.setOnCloseRequest(event1 -> {
                    stage =null;}
                );
                stage.setScene(new Scene(root));
                stage.show();
            }

        }

    }
}
