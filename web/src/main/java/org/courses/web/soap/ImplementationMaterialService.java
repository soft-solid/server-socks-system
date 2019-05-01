package org.courses.web.soap;

import org.courses.data.DAO.NamedDao;
import org.courses.data.DAO.hbm.MaterialDao;
import org.courses.domain.hbm.Material;

import javax.jws.WebService;
import java.util.Collection;
import java.util.Hashtable;

@WebService(
        endpointInterface = "org.courses.web.soap.MaterialService",
        serviceName = "MaterialService"
)
public class ImplementationMaterialService implements MaterialService {

    MaterialDao dao;
    public ImplementationMaterialService(NamedDao<Material, Integer> dao)
    {
        this.dao = (MaterialDao)dao;
    }

    @Override
    public Hashtable<String, Integer> Save(Collection<Material> entities) {
        return dao.save(entities);
    }

    @Override
    public Collection<Material> ReadAll(boolean onlyActive) { return dao.readAll(onlyActive); }

    @Override
    public void Deactivate(Collection<Integer> entities) {
        dao.Deactivate(entities);
    }
}
