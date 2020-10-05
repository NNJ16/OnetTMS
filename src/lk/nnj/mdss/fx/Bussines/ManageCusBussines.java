package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Customer;
import lk.nnj.mdss.fx.dao.Custom.CustDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.CustomerDTO;


import java.util.ArrayList;
import java.util.List;

public class ManageCusBussines {
    static CustDAO odao= (CustDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.CUS);

    public static List<CustomerDTO> getCustomers() throws Exception {
        List<Customer> allCus = odao.findAll();
        List<CustomerDTO> tmpDTOs = new ArrayList<>();
        for (Customer cus: allCus) {
            CustomerDTO dto = new CustomerDTO(cus.getGlno(),cus.getBAname(),cus.getPhone(),cus.getAddr1(),cus.getAddr2(),cus.getCity());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean addCustomer(CustomerDTO dto) throws Exception {
        Customer cus = new Customer(dto.getGlno(),dto.getBAname(),dto.getPhone(),dto.getAddr1(),dto.getAddr2(),dto.getCity());
        return odao.save(cus);
    }

    public static boolean updateCustomer(CustomerDTO dto) throws Exception {
        Customer cus = new Customer(
                dto.getGlno(),
                dto.getBAname(),
                dto.getPhone(),
                dto.getAddr1(),
                dto.getAddr2(),
                dto.getCity()
        );
        return odao.update(cus);
    }

    public static boolean deleteCustomer(String gllno) throws Exception {
        return odao.delete(gllno);
    }

    public static CustomerDTO findCustomer(String id) throws Exception {
        Customer cus = odao.find(id);
        if (cus != null) {
            return new CustomerDTO(
                    cus.getGlno(),
                    cus.getBAname(),
                    cus.getPhone(),
                    cus.getAddr1(),
                    cus.getAddr2(),
                    cus.getCity()
            );
        }
        return null;
    }
}
