package lk.nnj.mdss.fx.dao.Custom;

import lk.nnj.mdss.fx.Entity.DelDt;
import lk.nnj.mdss.fx.Entity.OrderDt;
import lk.nnj.mdss.fx.Entity.Return;
import lk.nnj.mdss.fx.dao.SuperDAO;
import lk.nnj.mdss.fx.dto.OrderDtDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    String findItemId(String name) throws Exception;
    String findNameQty(String oid) throws  Exception;
    boolean uptDesc(String desc,String oid) throws Exception;
    ArrayList<String> finadAllItems() throws Exception;
    ArrayList<OrderDt> findAllOrderDts() throws Exception;
    ArrayList<OrderDt> findAllOdtsOid(String oid) throws Exception;
    ArrayList<OrderDt> findAllOdtsCid(String cid) throws Exception;
    ArrayList<OrderDt> findAllOdtsTid(String tid) throws Exception;
    ArrayList<OrderDt> findAllOdtsState(String sts) throws Exception;
    ArrayList<DelDt> findAllTids() throws Exception;
    ArrayList<DelDt> findAllTids(String tid) throws Exception;
    ArrayList<DelDt> findAllTidsState(String sts) throws Exception;
    ArrayList<Return> findAllRetuns() throws Exception;
    ArrayList<Return> findAllRetTid(String tid) throws Exception;
    ArrayList<Return> findAllRetGlno(String glno) throws Exception;
    ArrayList<String> finadAllDel() throws Exception;
    int countOrder(String sts, LocalDate d1, LocalDate d2) throws Exception;
}
