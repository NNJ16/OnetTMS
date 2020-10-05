package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Contain;
import lk.nnj.mdss.fx.dao.Custom.ConDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.ContainDTO;

import java.util.ArrayList;
import java.util.List;

public class ManageConBussines {
    static ConDAO odao= (ConDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.CONT);

    public static boolean addContain(ContainDTO dto) throws Exception {
        Contain con = new Contain(dto.getOid(),dto.getItemId(),dto.getName(),dto.getQty());
        return odao.save(con);
    }

    public static boolean deletedContain(String name,String oid) throws Exception {
        return odao.deleted(name,oid);
    }

    public static List<ContainDTO> getContains(String oid) throws Exception {
        List<Contain> allCon = odao.findAll(oid);
        List<ContainDTO> tmpDTOs = new ArrayList<>();
        for (Contain con: allCon) {
            ContainDTO dto = new ContainDTO(con.getOid(),con.getOid(),con.getName(),con.getQty());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static List<ContainDTO> getContains() throws Exception {
        List<Contain> allCus = odao.findAll();
        List<ContainDTO> tmpDTOs = new ArrayList<>();
        for (Contain con: allCus) {
            ContainDTO dto = new ContainDTO(con.getOid(),con.getItemId(),con.getName(),con.getQty());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean deleteALL(String oid )throws Exception
    {
        return odao.deleteALL(oid);
    }
}
