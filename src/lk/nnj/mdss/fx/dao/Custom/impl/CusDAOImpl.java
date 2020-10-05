package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.Contain;
import lk.nnj.mdss.fx.Entity.Customer;
import lk.nnj.mdss.fx.dao.Custom.CustDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CusDAOImpl implements CustDAO {
    public Customer find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE gllno=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Customer(rst.getString("gllno"),
                    rst.getString("BAname"),
                    rst.getString("Phone"),
                    rst.getString("Addr1"),
                    rst.getString("Addr2"),
                    rst.getString("City")
            );
        }
        return null;
    }
    public List<Customer> findAll() throws Exception {
        ArrayList<Customer> allCus = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String gllno = rst.getString(1);
            String BAname = rst.getString(2);
            String Phone = rst.getString(3);
            String addr1 = rst.getString(4);
            String addr2 = rst.getString(5);
            String city = rst.getString(6);

            Customer cus=new Customer(gllno,BAname,Phone,addr1,addr2,city);
            allCus.add(cus);
        }
        return allCus;
    }
    public boolean save(Customer entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?)");
        pstm.setObject(1, entity.getGlno());
        pstm.setObject(2, entity.getBAname());
        pstm.setObject(3, entity.getPhone());
        pstm.setObject(4, entity.getAddr1());
        pstm.setObject(5, entity.getAddr2());
        pstm.setObject(6, entity.getCity());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Customer entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET baname=?,phone=?,addr1=?,addr2=?,city=? WHERE gllno=?");
        pstm.setObject(6,entity.getGlno());
        pstm.setObject(1,entity.getBAname());
        pstm.setObject(2,entity.getPhone());
        pstm.setObject(3,entity.getAddr1());
        pstm.setObject(4,entity.getAddr2());
        pstm.setObject(5,entity.getCity());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Customer where gllno=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
