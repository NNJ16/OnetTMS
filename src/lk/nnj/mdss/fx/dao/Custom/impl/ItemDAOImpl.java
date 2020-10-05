package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.Item;
import lk.nnj.mdss.fx.dao.Custom.ItemDAO;
import lk.nnj.mdss.fx.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    public Item find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE itemId=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Item(rst.getString("itemId"),
                    rst.getString("name"),
                    rst.getString("description")
            );
        }
        return null;
    }
    public List<Item> findAll() throws Exception {
        ArrayList<Item> allItem = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String itemId = rst.getString(1);
            String name = rst.getString(2);
            String desc = rst.getString(3);

            Item item=new Item(itemId,name,desc);
            allItem.add(item);
        }
        return allItem;
    }

    public boolean save(Item entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?)");
        pstm.setObject(1, entity.getItemId());
        pstm.setObject(2, entity.getName());
        pstm.setObject(3, entity.getDesc());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Item entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET name=?,description=? WHERE itemId=?");
        pstm.setObject(3,entity.getItemId());
        pstm.setObject(1,entity.getName());
        pstm.setObject(2,entity.getDesc());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Item where itemId=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
