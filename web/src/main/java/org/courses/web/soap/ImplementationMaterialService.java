package org.courses.web.soap;

import org.courses.data.DAO.NamedDao;
import org.courses.domain.hbm.Material;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.MaterialService",
        serviceName = "MaterialService"
)
public class ImplementationMaterialService implements MaterialService {

    NamedDao<Material, Integer> dao;
    public ImplementationMaterialService(NamedDao<Material, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Material> entity) {
        dao.save(entity);
    }

    @Override
    public Material read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Material> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Material> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
