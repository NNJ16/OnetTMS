package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.Contain;
import lk.nnj.mdss.fx.Entity.Customer;
import lk.nnj.mdss.fx.dao.Custom.ConDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConDAOImpl implements ConDAO {
    public Contain find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Contain WHERE oid=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Contain(rst.getString("oid"),
                    rst.getString("itemId"),
                    rst.getString("name"),
                    rst.getInt("qty")
            );
        }
        return null;

    }
    public List<Contain> findAll() throws Exception {
        ArrayList<Contain> allCon = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Contain");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            String itemId = rst.getString(2);
            String name = rst.getString(3);
            int qty = rst.getInt(4);

            Contain con=new Contain(oid,itemId,name,qty);
            allCon.add(con);
        }
        return allCon;
    }
    public List<Contain> findAll(String oid) throws Exception {
        ArrayList<Contain> allCon = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Contain WHERE oid = ?");
        pstm.setObject(1,oid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String itemId = rst.getString(2);
            String name = rst.getString(3);
            int qty = rst.getInt(4);

            Contain con=new Contain(oid,itemId,name,qty);
            allCon.add(con);
        }
        return allCon;
    }

    public boolean save(Contain entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Contain VALUES (?,?,?,?)");
        pstm.setObject(1, entity.getOid());
        pstm.setObject(2, entity.getItemId());
        pstm.setObject(3, entity.getName());
        pstm.setObject(4, entity.getQty());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Contain entity) throws Exception {
        return true;
    }

    public boolean delete(String key) throws Exception {
        return true;
    }
    public boolean deleted(String name,String oid) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Contain where name=? and oid=?");
        pstm.setObject(1,name);
        pstm.setObject(2,oid);
        return pstm.executeUpdate()>0;
    }
    public boolean deleteALL(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Contain where oid=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
