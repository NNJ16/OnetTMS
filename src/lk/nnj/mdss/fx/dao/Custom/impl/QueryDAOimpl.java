package lk.nnj.mdss.fx.dao.Custom.impl;

import lk.nnj.mdss.fx.Entity.DelDt;
import lk.nnj.mdss.fx.Entity.OrderDt;
import lk.nnj.mdss.fx.Entity.Return;
import lk.nnj.mdss.fx.dao.Custom.QueryDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


public class QueryDAOimpl implements QueryDAO {
    public String findItemId(String name) throws Exception
    {
        Connection connecttion = DBConnection.getConnection();
        PreparedStatement pstm=connecttion.prepareStatement("Select itemId from Item where name=? ");
        pstm.setObject(1,name);
        ResultSet rst = pstm.executeQuery();
        if(rst.next())
        {
            String id = rst.getString(1);
            return id;
        }
        return null;
    }
    public String findNameQty(String oid) throws  Exception
    {
        String desc = "";
        StringBuilder descAll = new StringBuilder();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Select name,qty from Contain where oid=? ");
        pstm.setObject(1,oid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String name = rst.getString(1);
            Integer qty = rst.getInt(2);
            String description = name + " X " + Integer.toString(qty)+"  ";
            descAll.append(description);
        }

        return  descAll.toString();

    }
    public boolean uptDesc(String desc,String oid) throws Exception
    {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Update Order1 Set description = ? where oid=?");
        pstm.setObject(2,oid);
        pstm.setObject(1,desc);

        return pstm.executeUpdate()>0;
    }

    public ArrayList<String> finadAllItems() throws Exception
    {
        ArrayList<String> nameList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Select name from Item");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            nameList.add(rst.getString(1));
        }
        return nameList;
    }
    public ArrayList<String> finadAllDel() throws Exception
    {
        ArrayList<String> nameList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Select name from DEmployee where type ='deliver'");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            nameList.add(rst.getString(1));
        }
        return nameList;
    }

    public ArrayList<OrderDt> findAllOrderDts() throws Exception
    {
        ArrayList<OrderDt> allOdts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Details");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            String glno = rst.getString(2);
            String baname = rst.getString(3);
            System.out.println(oid + "---------");
            LocalDate odate = rst.getTimestamp(4).toLocalDateTime().toLocalDate();
            System.out.println(odate + "---------");
            String desc = rst.getString(5);
            String tid = rst.getString(6);
            String status = rst.getString(7);
            String city = rst.getString(8);

            OrderDt orderDt =
                    new OrderDt(
                        oid,
                            glno,
                            baname,
                            odate,
                            desc,
                            tid,
                            status,
                            city
                    );

            allOdts.add(orderDt);
        }
        return allOdts;
    }
    public ArrayList<OrderDt> findAllOdtsOid(String oid) throws Exception
    {
        ArrayList<OrderDt> allOdts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Details where oid = ?");
        pstm.setObject(1,oid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            oid = rst.getString(1);
            String glno = rst.getString(2);
            String baname = rst.getString(3);
            LocalDate odate = rst.getTimestamp(4).toLocalDateTime().toLocalDate();
            String desc = rst.getString(5);
            String tid = rst.getString(6);
            String status = rst.getString(7);
            String city = rst.getString(8);

            OrderDt orderDt =
                    new OrderDt(
                            oid,
                            glno,
                            baname,
                            odate,
                            desc,
                            tid,
                            status,
                            city
                    );

            allOdts.add(orderDt);

        }
        return allOdts;
    }
    public ArrayList<OrderDt> findAllOdtsCid(String cid) throws Exception
    {
        ArrayList<OrderDt> allOdts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Details where gllno=?");
        pstm.setObject(1,cid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            cid = rst.getString(2);
            String baname = rst.getString(3);
            LocalDate odate = rst.getTimestamp(4).toLocalDateTime().toLocalDate();
            String desc = rst.getString(5);
            String tid = rst.getString(6);
            String status = rst.getString(7);
            String city = rst.getString(8);

            OrderDt orderDt =
                    new OrderDt(
                            oid,
                            cid,
                            baname,
                            odate,
                            desc,
                            tid,
                            status,
                            city
                    );

            allOdts.add(orderDt);
        }
        return allOdts;
    }
    public ArrayList<OrderDt> findAllOdtsTid(String tid) throws Exception
    {
        ArrayList<OrderDt> allOdts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Details where tid =?");
        pstm.setObject(1,tid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            String glno = rst.getString(2);
            String baname = rst.getString(3);
            LocalDate odate = rst.getTimestamp(4).toLocalDateTime().toLocalDate();
            String desc = rst.getString(5);
            tid = rst.getString(6);
            String status = rst.getString(7);
            String city = rst.getString(8);

            OrderDt orderDt =
                    new OrderDt(
                            oid,
                            glno,
                            baname,
                            odate,
                            desc,
                            tid,
                            status,
                            city
                    );

            allOdts.add(orderDt);
        }
        return allOdts;
    }
    public ArrayList<OrderDt> findAllOdtsState(String sts) throws Exception
    {
        ArrayList<OrderDt> allOdts = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Order_Details where status =?");
        pstm.setObject(1,sts);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String oid = rst.getString(1);
            String glno = rst.getString(2);
            String baname = rst.getString(3);
            LocalDate odate = rst.getTimestamp(4).toLocalDateTime().toLocalDate();
            String desc = rst.getString(5);
            String tid = rst.getString(6);
            sts = rst.getString(7);
            String city = rst.getString(8);

            OrderDt orderDt =
                    new OrderDt(
                            oid,
                            glno,
                            baname,
                            odate,
                            desc,
                            tid,
                            sts,
                            city
                    );

            allOdts.add(orderDt);
        }
        return allOdts;
    }
    public ArrayList<DelDt> findAllTids() throws Exception
    {
        ArrayList<DelDt> allTids = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Deliver_Details where status = 'Delivered' or status ='Return'");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String tid = rst.getString(1);
            Date date = rst.getDate(2);
            String glno = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            String status = rst.getString(6);
            String note = rst.getString(7);
            String delby = rst.getString(8);

            DelDt delDt =
                    new DelDt(
                            tid,
                            date,
                            glno,
                            baname,
                            desc,
                            status,
                            note,
                            delby
                    );
            allTids.add(delDt);
        }
        return allTids;
    }
    public ArrayList<DelDt> findAllTids(String tid) throws Exception
    {
        ArrayList<DelDt> allTids = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Deliver_Details where (status = 'Delivered' or status ='Return') and tid =?");
        pstm.setObject(1,tid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            tid = rst.getString(1);
            Date date = rst.getDate(2);
            String glno = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            String status = rst.getString(6);
            String note = rst.getString(7);
            String delby = rst.getString(8);

            DelDt delDt =
                    new DelDt(
                            tid,
                            date,
                            glno,
                            baname,
                            desc,
                            status,
                            note,
                            delby
                    );
            allTids.add(delDt);
        }
        return allTids;
    }
    public ArrayList<DelDt> findAllTidsState(String sts) throws Exception
    {
        ArrayList<DelDt> allTids = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Deliver_Details where status = ?");
        pstm.setObject(1,sts);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String tid = rst.getString(1);
            Date date = rst.getDate(2);
            String glno = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            sts = rst.getString(6);
            String note = rst.getString(7);
            String delby = rst.getString(8);

            DelDt delDt =
                    new DelDt(
                            tid,
                            date,
                            glno,
                            baname,
                            desc,
                            sts,
                            note,
                            delby
                    );
            allTids.add(delDt);
        }
        return allTids;
    }
    public ArrayList<Return> findAllRetuns() throws Exception
    {
        ArrayList<Return> allRet = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Return_Details");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            Date date = rst.getDate(1);
            String glno = rst.getString(2);
            String tid = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            String note = rst.getString(6);


            Return ret =
                    new Return(
                            date,
                            glno,
                            tid,
                            baname,
                            desc,
                            note
                    );
            allRet.add(ret);
        }
        return allRet;
    }

    public ArrayList<Return> findAllRetTid(String tid) throws Exception
    {
        ArrayList<Return> allRet = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Return_Details where tid = ?");
        pstm.setObject(1,tid);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            Date date = rst.getDate(1);
            String glno = rst.getString(2);
            tid = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            String note = rst.getString(6);


            Return ret =
                    new Return(
                            date,
                            glno,
                            tid,
                            baname,
                            desc,
                            note
                    );
            allRet.add(ret);
        }
        return allRet;
    }

    public ArrayList<Return> findAllRetGlno(String glno) throws Exception
    {
        ArrayList<Return> allRet = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Return_Details where gllno = ?");
        pstm.setObject(1,glno);
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            Date date = rst.getDate(1);
            glno = rst.getString(2);
            String tid = rst.getString(3);
            String baname = rst.getString(4);
            String desc = rst.getString(5);
            String note = rst.getString(6);


            Return ret =
                    new Return(
                            date,
                            glno,
                            tid,
                            baname,
                            desc,
                            note
                    );
            allRet.add(ret);
        }
        return allRet;
    }
    public int countOrder(String sts,LocalDate d1, LocalDate d2) throws Exception
    {
        int tot=0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("Select count(oid) from Order_Details where status = ? and odate >= ? and odate <= ?");
        pstm.setObject(1,sts);
        pstm.setObject(2,d1);
        pstm.setObject(3,d2);
        ResultSet rst = pstm.executeQuery();
        if(rst.next())
        {
            String sum = rst.getString(1);
            try
            {
                tot=Integer.parseInt(sum);
            }catch(Exception e)
            {
                return tot;
            }
        }
        return tot;
    }

}
