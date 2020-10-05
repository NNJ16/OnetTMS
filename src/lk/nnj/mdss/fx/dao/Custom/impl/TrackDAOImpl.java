package lk.nnj.mdss.fx.dao.Custom.impl;
import lk.nnj.mdss.fx.Entity.Track;
import lk.nnj.mdss.fx.dao.Custom.TrackDAO;
import lk.nnj.mdss.fx.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackDAOImpl implements TrackDAO {
    public Track find(String key) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Track WHERE tid=?");
        pstm.setObject(1, key);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Track(rst.getString("tid"),
                    rst.getDate("deldate"),
                    rst.getString("status"),
                    rst.getString("note"),
                    rst.getString("delby"),
                    rst.getString("oid")
            );
        }
        return null;
    }
    public List<Track> findAll() throws Exception {
        ArrayList<Track> allTrack = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Track");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String tid = rst.getString(1);
            Date deldate  = rst.getDate(2);
            String status = rst.getString(3);
            String note = rst.getString(4);
            String delby = rst.getString(5);
            String oid = rst.getString(6);
            Track trk=new Track(tid,deldate,status,note,delby,oid);
            allTrack.add(trk);
        }
        return allTrack;
    }
    public boolean save(Track entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Track VALUES (?,?,?,?,?,?)");
        pstm.setObject(1, entity.getTid());
        pstm.setObject(2, entity.getDelDate());
        pstm.setObject(3, entity.getStatus());
        pstm.setObject(4, entity.getNote());
        pstm.setObject(5, entity.getDelby());
        pstm.setObject(6, entity.getOid());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Track entity) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Track SET deldate=?,status=?,note=?,delby=? WHERE tid=?");
        pstm.setObject(5,entity.getTid());
        pstm.setObject(1,entity.getDelDate());
        pstm.setObject(2,entity.getStatus());
        pstm.setObject(3,entity.getNote());
        pstm.setObject(4,entity.getDelby());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String key) throws Exception {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement("Delete from Track where tid=?");
        pstm.setObject(1,key);
        return pstm.executeUpdate()>0;
    }
}
