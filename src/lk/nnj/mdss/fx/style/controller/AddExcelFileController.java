package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import lk.nnj.mdss.fx.Bussines.ManageCusBussines;
import lk.nnj.mdss.fx.Bussines.ManageOrderBussines;
import lk.nnj.mdss.fx.Bussines.ManageTrackBussines;
import lk.nnj.mdss.fx.dto.CustomerDTO;
import lk.nnj.mdss.fx.dto.OrderDTO;
import lk.nnj.mdss.fx.dto.ProgressDTO;
import lk.nnj.mdss.fx.dto.TrackDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AddExcelFileController implements Initializable{
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_back;

    @FXML
    private JFXDatePicker txt_date;

    @FXML
    private TextField txt_wsno;

    @FXML
    private TextField txt_frno;

    @FXML
    private TextField txt_fcno;

    @FXML
    private TextField txt_lrno;

    @FXML
    private TextField txt_lcno;

    @FXML
    private ProgressBar progress;

    @FXML
    private Label lbl_status;

    @FXML
    private JFXButton btnOpen;

    @FXML
    private TextField txt_ono;

    @FXML
    private TextField txt_glno;

    @FXML
    private TextField txt_baname;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_addr1;

    @FXML
    private TextField txt_addr2;

    @FXML
    private TextField txt_city;

    @FXML
    private TextField txt_des;

    @FXML
    private TextField txt_sno;

    @FXML
    private JFXButton btnApply;

    @FXML
    private JFXButton btnCancle;

    @FXML
    private TextField txt_path;

    @FXML
    private ImageView lbl_back1;

    @FXML
    private ImageView lbl_back11;

    private  ProgressDTO progressDTO = new ProgressDTO();

    private  int wsno, frow, lrow, fcol, lcol, oid, glno, baname, phone, addr1, addr2, city, desc, sno;
    private String path;
    private boolean isCancelled =false;
    private ArrayList<CustomerDTO> cusList = new ArrayList<>();
    private ArrayList<OrderDTO> orderList = new ArrayList<>();
    private ArrayList<TrackDTO> trackList = new ArrayList<>();

    @FXML
    void Apply(ActionEvent event) {
        if(txt_date.getValue()==null)
        {
            txt_date.setStyle("-fx-background-color: #FF0000;");
        }else if(txt_path.getText().equals(""))
        {
            txt_path.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_wsno.getText().equals(""))
        {
            txt_wsno.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_frno.getText().equals(""))
        {
            txt_frno.setStyle("--fx-background-color: #FF0000;");


        }else if(txt_fcno.getText().equals(""))
        {
            txt_fcno.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_lrno.getText().equals(""))
        {
            txt_lrno.setStyle("-fx-background-color: #FF0000;");

            txt_date.setStyle("-fx-background-color: #FFFFFF;");
        }else if(txt_lcno.getText().equals(""))
        {
            txt_lcno.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_ono.getText().equals(""))
        {
            txt_ono.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_glno.getText().equals(""))
        {
            txt_glno.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_baname.getText().equals(""))
        {
            txt_baname.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_phone.getText().equals(""))
        {
            txt_phone.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_addr1.getText().equals(""))
        {
            txt_addr1.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_addr2.getText().equals(""))
        {
            txt_addr2.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_city.getText().equals(""))
        {
            txt_city.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_des.getText().equals(""))
        {
            txt_des.setStyle("-fx-background-color: #FF0000;");

        }else if(txt_sno.getText().equals(""))
        {
            txt_sno.setStyle("-fx-background-color: #FF0000;");

        }else{
            txt_sno.setStyle("-fx-background-color: #FFFFFF;");
            txt_des.setStyle("-fx-background-color: #FFFFFF;");
            txt_city.setStyle("-fx-background-color: #FFFFFF;");
            txt_addr2.setStyle("-fx-background-color: #FFFFFF;");
            txt_addr1.setStyle("-fx-background-color: #FFFFFF;");
            txt_phone.setStyle("-fx-background-color: #FFFFFF;");
            txt_baname.setStyle("-fx-background-color: #FFFFFF;");
            txt_glno.setStyle("-fx-background-color: #FFFFFF;");
            txt_ono.setStyle("-fx-background-color: #FFFFFF;");
            txt_lcno.setStyle("-fx-background-color: #FFFFFF;");
            txt_lrno.setStyle("-fx-background-color: #FFFFFF;");
            txt_fcno.setStyle("-fx-background-color: #FFFFFF;");
            txt_frno.setStyle("--fx-background-color: #FFFFFF;");
            txt_wsno.setStyle("-fx-background-color: #FFFFFF;");
            txt_path.setStyle("-fx-background-color: #FFFFFF;");
            txt_date.setStyle("-fx-background-color: #FFFFFF;");

            try{
                wsno = Integer.parseInt(txt_wsno.getText()) - 1;
                frow = Integer.parseInt(txt_frno.getText()) - 1;
                lrow = Integer.parseInt(txt_lrno.getText()) - 1;
                fcol = Integer.parseInt(txt_fcno.getText()) - 1;
                lcol = Integer.parseInt(txt_lcno.getText()) - 1;
                oid = Integer.parseInt(txt_ono.getText()) - 1;
                glno = Integer.parseInt(txt_glno.getText()) - 1;
                baname = Integer.parseInt(txt_baname.getText()) - 1;
                phone = Integer.parseInt(txt_phone.getText()) - 1;
                addr1 = Integer.parseInt(txt_addr1.getText()) - 1;
                addr2 = Integer.parseInt(txt_addr2.getText()) - 1;
                city = Integer.parseInt(txt_city.getText()) - 1;
                desc = Integer.parseInt(txt_des.getText()) - 1;
                sno = Integer.parseInt(txt_sno.getText()) - 1;
                path = txt_path.getText();

                int count =0;


                Workbook wb = null;
                try {

                    FileInputStream fis = new FileInputStream(path);
                    wb = new XSSFWorkbook(fis);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Sheet sheet = wb.getSheetAt(wsno);
                Row row = null;
                Cell cell = null;
                CellType type = null;



                for(int i=frow ; i<=lrow ; i++)
                {
                    count++;
                    CustomerDTO customerDTO = new CustomerDTO();
                    OrderDTO orderDTO = new OrderDTO();
                    TrackDTO trackDTO = new TrackDTO();
                    for(int j=fcol ; j<=lcol ;j++)
                    {
                        row = sheet.getRow(i);
                        cell = row.getCell(j);
                        type = cell.getCellType();
                        if(j==oid)
                        {
                            orderDTO.setOid(cell.getStringCellValue());
                            orderDTO.setDate(txt_date.getValue());
                            trackDTO.setOid(cell.getStringCellValue());
                        }else if(j==glno)
                        {
                            orderDTO.setGllno(cell.getStringCellValue());
                            customerDTO.setGlno(cell.getStringCellValue());
                        }else if(j==baname)
                        {
                            customerDTO.setBAname(cell.getStringCellValue());
                        }else if(j==phone)
                        {
                            customerDTO.setPhone(Integer.toString((int)cell.getNumericCellValue()));
                        }else if(j==addr1)
                        {
                            customerDTO.setAddr1(cell.getStringCellValue());
                        }else if(j==addr2)
                        {
                            customerDTO.setAddr2(cell.getStringCellValue());
                        }else if(j==city)
                        {
                            customerDTO.setCity(cell.getStringCellValue());
                        }else if(j==desc)
                        {
                            orderDTO.setDescription(cell.getStringCellValue());
                        }else if(j==sno)
                        {
                            trackDTO.setTid(Integer.toString((int)cell.getNumericCellValue()));
                            trackDTO.setDelby("");
                            trackDTO.setDelDate(null);
                            trackDTO.setNote("");
                            trackDTO.setStatus("Pending");
                        }
                    }
                    cusList.add(customerDTO);
                    orderList.add(orderDTO);
                    trackList.add(trackDTO);
                }


                //Run Task
                Task task = taskCreator(count);
                progress.progressProperty().unbind();
                progress.progressProperty().bind(task.progressProperty());
                progress.progressProperty().unbind();
                progress.progressProperty().bind(task.progressProperty());
                Thread thread =new Thread(task);
                thread.setDaemon(true);
                thread.start();

            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid input found");
                e.printStackTrace();
            }

        }
    }

    @FXML
    void Cancle(ActionEvent event) throws InterruptedException {
        isCancelled = true;
    }

    private Task taskCreator(int count){
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for(int i=0; i<count;i++){
                    if(isCancelled)
                    {
                        break;
                    }
                    Thread.sleep(1000);
                    updateProgress(i+1, count);
                    System.out.println(i+"--------------------");
                        CustomerDTO customerDTO = cusList.get(i);
                        CustomerDTO cus = null;
                        try {
                            cus = ManageCusBussines.findCustomer(customerDTO.getGlno());
                            if(cus==null)
                            {
                                ManageCusBussines.addCustomer(customerDTO);
                            }else
                            {
                                ManageCusBussines.updateCustomer(customerDTO);
                            }
                            System.out.println("Customer "+i+" details added successfully "+ (lrow-i)+" remaining");
                        }catch(Exception e){

                        }

                        OrderDTO orderDTO =orderList.get(i);
                        OrderDTO ord = null;
                        try {
                            ord = ManageOrderBussines.findOrder(orderDTO.getOid());
                            if(ord==null)
                            {
                                ManageOrderBussines.addOrder(orderDTO);
                            }else
                            {
                                ManageOrderBussines.updateOrder(orderDTO);
                            }
                            System.out.println("Order "+i+" details added successfully "+ (lrow-i)+" remaining");
                        } catch (Exception e) {

                        }
                        TrackDTO trackDTO = trackList.get(i);
                        TrackDTO trd = null;
                        try {
                            trd = ManageTrackBussines.findTrack(trackDTO.getTid());
                            if(trd==null)
                            {
                                ManageTrackBussines.addTrack(trackDTO);
                            }else
                            {
                                ManageTrackBussines.updateTrack(trackDTO);
                            }
                            System.out.println("Track "+i+" details added successfully "+ (lrow-i)+" remaining");

                        } catch (Exception e) {

                        }
                    }


                return true;
            }
        };
    }
    @FXML
    void Open(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Excel File");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Excel Workbook (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (file != null)
        {
            txt_path.setText(file.getAbsolutePath());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progress.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {

                if(t1.doubleValue()==1)
                {
                    lbl_status.setText("Imported Successfully");
                    lbl_status.setTextFill(Color.GREEN);
                }else
                    {
                        double d = t1.doubleValue()*100;
                        lbl_status.setText((int)d + "% Completed");
                    }
            }

        });
    }
}
