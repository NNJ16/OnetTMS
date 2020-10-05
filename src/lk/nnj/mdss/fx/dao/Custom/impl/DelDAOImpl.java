package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.Deliver;
import lk.nnj.mdss.fx.dao.Custom.DelDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DelDAOImpl implements DelDAO {
    public Deliver find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM DEmployee WHERE IDno=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Deliver(rst.getString("IDno"),
                    rst.getString("name"),
                    rst.getString("mobile"),
                    rst.getString("pwd"),
                    rst.getString("type")
            );
        }
        return null;
    }
    public List<Deliver> findAll() throws Exception {
        ArrayList<Deliver> allDel = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM DEmployee");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String IDno = rst.getString(1);
            String name = rst.getString(2);
            String mobile = rst.getString(3);
            String pwd = rst.getString(4);
            String type = rst.getString(5);
            Deliver del=new Deliver(IDno,name,mobile,pwd,type);
            allDel.add(del);
        }
        return allDel;
    }
    public boolean save(Deliver entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO DEmployee VALUES (?,?,?,?,?)");
        pstm.setObject(1, entity.getIDno());
        pstm.setObject(2, entity.getName());
        pstm.setObject(3, entity.getMobile());
        pstm.setObject(4, entity.getPwd());
        pstm.setObject(5, entity.getType());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Deliver entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE DEmployee SET name=?,mobile=?,pwd=?,type=? WHERE IDno=?");
        pstm.setObject(5,entity.getIDno());
        pstm.setObject(1,entity.getName());
        pstm.setObject(2,entity.getMobile());
        pstm.setObject(3,entity.getPwd());
        pstm.setObject(4,entity.getType());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from DEmployee where IDno=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
