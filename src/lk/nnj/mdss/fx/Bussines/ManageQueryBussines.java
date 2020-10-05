package lk.nnj.mdss.fx.Bussines;

import com.sun.org.apache.regexp.internal.RE;
import lk.nnj.mdss.fx.Entity.DelDt;
import lk.nnj.mdss.fx.Entity.OrderDt;
import lk.nnj.mdss.fx.Entity.Return;
import lk.nnj.mdss.fx.dao.Custom.QueryDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.DelDtDTO;
import lk.nnj.mdss.fx.dto.OrderDTO;
import lk.nnj.mdss.fx.dto.OrderDtDTO;
import lk.nnj.mdss.fx.dto.ReturnDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageQueryBussines {
    static QueryDAO odao= (QueryDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.QRY);

    public static String findItemId(String name)throws Exception
    {
        String id = odao.findItemId(name);
        return id;
    }
    public static String findNameQty(String oid) throws Exception
    {
        String desc ="";
        desc = odao.findNameQty(oid);
        return desc;
    }
    public static boolean uptDesc(String desc,String oid) throws Exception
    {
        return odao.uptDesc(desc,oid);
    }
    public static ArrayList<String> findAllItems() throws Exception
    {
        return odao.finadAllItems();
    }
    public static ArrayList<String> findAllDel() throws Exception
    {
        return odao.finadAllDel();
    }
    public static ArrayList<OrderDtDTO> findAllOrderDts()throws Exception
    {
        ArrayList<OrderDt> orderDts =  odao.findAllOrderDts();
        ArrayList<OrderDtDTO> tmpDTOs = new ArrayList<>();
        for(OrderDt orderDt: orderDts)
        {
            OrderDtDTO orderDTO =
                    new OrderDtDTO(
                            orderDt.getOid(),
                            orderDt.getGlno(),
                            orderDt.getBaname(),
                            orderDt.getOdate(),
                            orderDt.getDesc(),
                            orderDt.getTid(),
                            orderDt.getStatus(),
                            orderDt.getCity()
                    );
            tmpDTOs.add(orderDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<OrderDtDTO> findAllOdtsOid(String oid)throws Exception
    {
        ArrayList<OrderDt> orderDts =  odao.findAllOdtsOid(oid);
        ArrayList<OrderDtDTO> tmpDTOs = new ArrayList<>();
        for(OrderDt orderDt: orderDts)
        {
            OrderDtDTO orderDTO =
                    new OrderDtDTO(
                            orderDt.getOid(),
                            orderDt.getGlno(),
                            orderDt.getBaname(),
                            orderDt.getOdate(),
                            orderDt.getDesc(),
                            orderDt.getTid(),
                            orderDt.getStatus(),
                            orderDt.getCity()
                    );
            tmpDTOs.add(orderDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<OrderDtDTO> findAllOdtsCid(String cid)throws Exception
    {
        ArrayList<OrderDt> orderDts =  odao.findAllOdtsCid(cid);
        ArrayList<OrderDtDTO> tmpDTOs = new ArrayList<>();
        for(OrderDt orderDt: orderDts)
        {
            OrderDtDTO orderDTO =
                    new OrderDtDTO(
                            orderDt.getOid(),
                            orderDt.getGlno(),
                            orderDt.getBaname(),
                            orderDt.getOdate(),
                            orderDt.getDesc(),
                            orderDt.getTid(),
                            orderDt.getStatus(),
                            orderDt.getCity()
                    );
            tmpDTOs.add(orderDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<OrderDtDTO> findAllOdtsTid(String tid)throws Exception
    {
        ArrayList<OrderDt> orderDts =  odao.findAllOdtsTid(tid);
        ArrayList<OrderDtDTO> tmpDTOs = new ArrayList<>();
        for(OrderDt orderDt: orderDts)
        {
            OrderDtDTO orderDTO =
                    new OrderDtDTO(
                            orderDt.getOid(),
                            orderDt.getGlno(),
                            orderDt.getBaname(),
                            orderDt.getOdate(),
                            orderDt.getDesc(),
                            orderDt.getTid(),
                            orderDt.getStatus(),
                            orderDt.getCity()
                    );
            tmpDTOs.add(orderDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<OrderDtDTO> findAllOdtsState(String sts)throws Exception
    {
        ArrayList<OrderDt> orderDts =  odao.findAllOdtsState(sts);
        ArrayList<OrderDtDTO> tmpDTOs = new ArrayList<>();
        for(OrderDt orderDt: orderDts)
        {
            OrderDtDTO orderDTO =
                    new OrderDtDTO(
                            orderDt.getOid(),
                            orderDt.getGlno(),
                            orderDt.getBaname(),
                            orderDt.getOdate(),
                            orderDt.getDesc(),
                            orderDt.getTid(),
                            orderDt.getStatus(),
                            orderDt.getCity()
                    );
            tmpDTOs.add(orderDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<DelDtDTO> findAllTids()throws Exception{
        ArrayList<DelDt> tiDts = odao.findAllTids();
        ArrayList<DelDtDTO> tmpDTOs =new ArrayList<>();
        for(DelDt delDt: tiDts)
        {
            DelDtDTO delDtDTO =
                    new DelDtDTO(
                            delDt.getTid(),
                            delDt.getDate(),
                            delDt.getGlno(),
                            delDt.getBaname(),
                            delDt.getDesc(),
                            delDt.getStatus(),
                            delDt.getNote(),
                            delDt.getDelby()
                    );
            tmpDTOs.add(delDtDTO);
        }
        return tmpDTOs;
    }

    public static ArrayList<DelDtDTO> findAllTids(String tid)throws Exception{
        ArrayList<DelDt> tiDts = odao.findAllTids(tid);
        ArrayList<DelDtDTO> tmpDTOs =new ArrayList<>();
        for(DelDt delDt: tiDts)
        {
            DelDtDTO delDtDTO =
                    new DelDtDTO(
                            delDt.getTid(),
                            delDt.getDate(),
                            delDt.getGlno(),
                            delDt.getBaname(),
                            delDt.getDesc(),
                            delDt.getStatus(),
                            delDt.getNote(),
                            delDt.getDelby()
                    );
            tmpDTOs.add(delDtDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<DelDtDTO> findAllTidsState(String sts)throws Exception{
        ArrayList<DelDt> tiDts = odao.findAllTidsState(sts);
        ArrayList<DelDtDTO> tmpDTOs =new ArrayList<>();
        for(DelDt delDt: tiDts)
        {
            DelDtDTO delDtDTO =
                    new DelDtDTO(
                            delDt.getTid(),
                            delDt.getDate(),
                            delDt.getGlno(),
                            delDt.getBaname(),
                            delDt.getDesc(),
                            delDt.getStatus(),
                            delDt.getNote(),
                            delDt.getDelby()
                    );
            tmpDTOs.add(delDtDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<ReturnDTO> findAllRetuns() throws Exception
    {
        ArrayList<Return> retDts = odao.findAllRetuns();
        ArrayList<ReturnDTO> tmpDTOs =new ArrayList<>();
        for(Return ret: retDts)
        {
            ReturnDTO retDTO =
                    new ReturnDTO(
                            ret.getDate(),
                            ret.getGlno(),
                            ret.getTid(),
                            ret.getBaname(),
                            ret.getDesc(),
                            ret.getNote()
                    );
            tmpDTOs.add(retDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<ReturnDTO> findAllRetTid(String tid) throws Exception
    {
        ArrayList<Return> retDts = odao.findAllRetTid(tid);
        ArrayList<ReturnDTO> tmpDTOs =new ArrayList<>();
        for(Return ret: retDts)
        {
            ReturnDTO retDTO =
                    new ReturnDTO(
                            ret.getDate(),
                            ret.getGlno(),
                            ret.getTid(),
                            ret.getBaname(),
                            ret.getDesc(),
                            ret.getNote()
                    );
            tmpDTOs.add(retDTO);
        }
        return tmpDTOs;
    }
    public static ArrayList<ReturnDTO> findAllRetGlno(String glno) throws Exception
    {
        ArrayList<Return> retDts = odao.findAllRetGlno(glno);
        ArrayList<ReturnDTO> tmpDTOs =new ArrayList<>();
        for(Return ret: retDts)
        {
            ReturnDTO retDTO =
                    new ReturnDTO(
                            ret.getDate(),
                            ret.getGlno(),
                            ret.getTid(),
                            ret.getBaname(),
                            ret.getDesc(),
                            ret.getNote()
                    );
            tmpDTOs.add(retDTO);
        }
        return tmpDTOs;
    }
    public static  int countOrder(String sts, LocalDate d1, LocalDate d2) throws Exception
    {
        return odao.countOrder(sts,d1,d2);
    }
}
