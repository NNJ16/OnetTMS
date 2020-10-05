package lk.nnj.mdss.fx.dao.Custom;

import lk.nnj.mdss.fx.Entity.Contain;
import lk.nnj.mdss.fx.dao.CrudDAO;
import lk.nnj.mdss.fx.dto.ContainDTO;

import java.util.List;

public interface ConDAO extends CrudDAO<Contain, String> {
    List<Contain> findAll(String oid) throws Exception;
    boolean deleteALL(String key) throws Exception;
    boolean deleted(String name,String oid) throws Exception;
}
