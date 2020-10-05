package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.Order;
import lk.nnj.mdss.fx.dao.Custom.OrderDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    public Order find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order1 WHERE oid=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Order(rst.getString("oid"),
                    rst.getTimestamp("odate").toLocalDateTime().toLocalDate(),
                    rst.getString("description"),
                    rst.getString("gllno")
            );
        }
        return null;
    }

    public List<Order> findAll() throws Exception {
        ArrayList<Order> allOrder = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order1");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            LocalDate odate  = rst.getTimestamp(2).toLocalDateTime().toLocalDate();
            String desc = rst.getString(3);
            String gllno = rst.getString(4);

            Order ord=new Order(oid,odate,desc,gllno);
            allOrder.add(ord);
        }
        return allOrder;
    }

    public boolean save(Order entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Order1 VALUES (?,?,?,?)");
        pstm.setObject(1, entity.getOid());
        pstm.setObject(2, entity.getDate());
        pstm.setObject(3, entity.getDescription());
        pstm.setObject(4, entity.getGllno());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Order entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Order1 SET odate=?,gllno=? WHERE oid=?");
        pstm.setObject(3,entity.getOid());
        pstm.setObject(1,entity.getDate());
        pstm.setObject(2,entity.getGllno());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Order1 where oid=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
