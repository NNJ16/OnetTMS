package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Order;
import lk.nnj.mdss.fx.dao.Custom.OrderDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.OrderDTO;

public class ManageOrderBussines {
    static OrderDAO odao= (OrderDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.ORD);

    public static boolean addOrder(OrderDTO dto) throws Exception {
        Order ord = new Order(dto.getOid(),dto.getDate(),dto.getDescription(),dto.getGllno());
        return odao.save(ord);
    }
    public static OrderDTO findOrder(String oid) throws Exception {
        Order ord = odao.find(oid);
        if (ord != null) {
            return new OrderDTO(
                    ord.getOid(),
                    ord.getDate(),
                    ord.getDescription(),
                    ord.getGllno()
            );
        }
        return null;
    }
    public static boolean deleteOrder(String oid) throws Exception {
        return odao.delete(oid);
    }
    public static boolean updateOrder(OrderDTO dto) throws Exception {
        Order ord= new Order(
                dto.getOid(),
                dto.getDate(),
                dto.getDescription(),
                dto.getGllno()
        );
        return odao.update(ord);
    }
}
