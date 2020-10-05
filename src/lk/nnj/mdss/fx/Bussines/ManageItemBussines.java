package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Item;
import lk.nnj.mdss.fx.dao.Custom.ItemDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class ManageItemBussines {
    static ItemDAO odao= (ItemDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.ITM);

    public static List<ItemDTO> getItems() throws Exception {
        List<Item> allItem = odao.findAll();
        List<ItemDTO> tmpDTOs = new ArrayList<>();
        for (Item itm: allItem) {
            ItemDTO dto = new ItemDTO(itm.getItemId(),itm.getName(),itm.getDesc());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean addItem(ItemDTO dto) throws Exception {
        Item itm = new Item(dto.getItemId(),dto.getName(),dto.getDesc());
        return odao.save(itm);
    }

    public static boolean updateItem(ItemDTO dto) throws Exception {
        Item itm= new Item(
                dto.getItemId(),
                dto.getName(),
                dto.getDesc()
        );
        return odao.update(itm);
    }

    public static boolean deleteItem(String itemId) throws Exception {
        return odao.delete(itemId);
    }

    public static ItemDTO findItem(String id) throws Exception {
        Item itm = odao.find(id);
        if (itm != null) {
            return new ItemDTO(
                    itm.getItemId(),
                    itm.getName(),
                    itm.getDesc()
                     );
        }
        return null;
    }
}
