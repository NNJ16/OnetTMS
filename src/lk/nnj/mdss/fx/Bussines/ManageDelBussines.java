package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Deliver;
import lk.nnj.mdss.fx.dao.Custom.DelDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.DeliverDTO;

import java.util.ArrayList;
import java.util.List;

public class ManageDelBussines {
    static DelDAO odao= (DelDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.DEL);

    public static List<DeliverDTO> getDelivers() throws Exception {
        List<Deliver> allDel = odao.findAll();
        List<DeliverDTO> tmpDTOs = new ArrayList<>();
        for (Deliver del: allDel) {
            DeliverDTO dto = new DeliverDTO(del.getIDno(),del.getName(),del.getMobile(),del.getPwd(),del.getType());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean addDeliver(DeliverDTO dto) throws Exception {
        Deliver del = new Deliver(dto.getIDno(),dto.getName(),dto.getMobile(),dto.getPwd(),dto.getType());
        return odao.save(del);
    }

    public static boolean updateDeliver(DeliverDTO dto) throws Exception {
        Deliver del = new Deliver(
                dto.getIDno(),
                dto.getName(),
                dto.getMobile(),
                dto.getPwd(),
                dto.getType()
        );
        return odao.update(del);
    }

    public static boolean deleteDeliver(String id) throws Exception {
        return odao.delete(id);
    }

    public static DeliverDTO findDeliver(String id) throws Exception {
        Deliver del = odao.find(id);
        if (del != null) {
            return new DeliverDTO(
                    del.getIDno(),
                    del.getName(),
                    del.getMobile(),
                    del.getPwd(),
                    del.getType()
                    );
        }
        return null;
    }
}
