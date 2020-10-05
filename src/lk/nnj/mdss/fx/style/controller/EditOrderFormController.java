package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
import org.controlsfx.control.textfield.TextFields;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class EditOrderFormController implements Initializable {
    @FXML
    private AnchorPane root;

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
    private JFXButton btn_edit;

    @FXML
    private ImageView lbl_search11;

    @FXML
    private JFXButton btn_del;

    @FXML
    private ImageView lbl_search111;

    @FXML
    void add(MouseEvent event) throws Exception {
        String glno = txt_cid.getText();
        String item = txt_name.getText();
        String oid = txt_oid.getText();

        int qty=0 ;
        try {
            qty = Integer.parseInt(txt_qty.getText());
            CustomerDTO cusDTO = ManageCusBussines.findCustomer(glno);
            String itemId = ManageQueryBussines.findItemId(item);
            OrderDTO oDTO = ManageOrderBussines.findOrder(oid);

            ContainDTO containDTO =
                    new ContainDTO(
                            oid,
                            itemId,
                            item,
                            qty
                    );

            try
            {
                ManageConBussines.addContain(containDTO);

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Cannot Add Same Item Twice");
            }
            String desc = ManageQueryBussines.findNameQty(oid);
            ManageQueryBussines.uptDesc(desc,oid);
            viewTable(oid);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Enter Enter Valid Quantity");
        }



    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/OrderDetailForm.fxml"));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
        }
    }

    @FXML
    void delete(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Administrator Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
                String oid = txt_oid.getText();
                String tid =txt_sno.getText();
                boolean bol1,bol2,bol3;


                try {
                    bol1 =ManageTrackBussines.deleteTrack(tid);
                    bol2 = ManageOrderBussines.deleteOrder(oid);
                    bol3 = ManageConBussines.deleteALL(oid);
                    if(bol1 && bol2 && bol3 )
                    {

                        String cid =txt_cid.getText();
                        try {
                            ManageCusBussines.deleteCustomer(cid);
                        }catch (Exception e)
                        {

                        }
                        JOptionPane.showMessageDialog(null,"Order details has been successfully removed");
                        reset();
                        viewTable(oid);
                    }else
                        {
                            JOptionPane.showMessageDialog(null,"Error, Cannot Delete");
                        }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }else
            {
                JOptionPane.showMessageDialog(null,"Entered Password is not Correct");
            }
        }

    }
    @FXML
    void edit(ActionEvent event) {
        String oid = txt_oid.getText();
        String cid =txt_cid.getText();
        LocalDate date = txt_date.getValue();
        String baname = txt_bname.getText();
        String phone =txt_phone.getText();
        String addr1 =txt_addr1.getText();
        String addr2 = txt_addr2.getText();
        String city = txt_city.getText();

        OrderDTO oDTO =
                new OrderDTO(
                        oid,
                        date,
                        "",
                        cid
                );
        CustomerDTO customerDTO=
                new CustomerDTO(
                        cid,
                        baname,
                        phone,
                        addr1,
                        addr2,
                        city
                );
        try {
            if(ManageOrderBussines.updateOrder(oDTO) && ManageCusBussines.updateCustomer(customerDTO))
            {
                JOptionPane.showMessageDialog(null,"Order Details Updated Successfully");
                reset();
                viewTable(oid);
            }else
                {
                    JOptionPane.showMessageDialog(null,"Error, Cannot Update");
                }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    void remove(MouseEvent event) throws Exception {
        String oid = txt_oid.getText();
        String item = txt_name.getText();
        if(item.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Select item to remove");
        }else{
            try {
                ManageConBussines.deletedContain(item,oid);
                List<ContainDTO> conDTOs =
                        ManageConBussines.getContains();
                if(conDTOs.size()==1)
                {
                    ManageOrderBussines.deleteOrder(oid);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
            String desc = ManageQueryBussines.findNameQty(oid);
            ManageQueryBussines.uptDesc(desc,oid);
            viewTable(oid);
        }
    }

    @FXML
    void search(ActionEvent event) {

    }
    void setText(String oid, LocalDate date, String tid, String status,String glno, String baname,String phone,String addr1,String addr2,String city)
    {
        txt_oid.setText(oid);
        try {
            txt_date.setValue(LOCAL_DATE(date.toString()));
        }catch (Exception e)
        {

        }

        txt_sno.setText(tid);
        cmd_status.setValue(status);
        txt_cid.setText(glno);
        txt_bname.setText(baname);
        txt_phone.setText(phone);
        txt_addr1.setText(addr1);
        txt_addr2.setText(addr2);
        txt_city.setText(city);

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
                    ManageConBussines.getContains(oid);
            tbl_item.setItems(FXCollections.observableList(conDTOs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Pending",
                        "Delivered",
                        "Return"
                );

        cmd_status.setItems(options);

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
    @FXML
    void click(MouseEvent event) {
        ArrayList<ContainDTO> con =  new ArrayList<>(tbl_item.getSelectionModel().getSelectedItems());
        for(ContainDTO cDTO: con)
        {
            txt_name.setText(cDTO.getName());
            txt_qty.setText(Integer.toString(cDTO.getQty()));
        }
    }
    public void viewTable(String oid)
    {
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
                    ManageConBussines.getContains(oid);
            tbl_item.setItems(FXCollections.observableList(conDTOs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reset()
    {
        txt_bname.setText("");
        txt_city.setText("");
        txt_addr2.setText("");
        txt_addr1.setText("");
        txt_phone.setText("");
        txt_cid.setText("");
        txt_sno.setText("");
        txt_date.setValue(null);
        txt_oid.setText("");
        txt_name.setText("");
        txt_qty.setText("");
        cmd_status.setValue("");
    }
}
