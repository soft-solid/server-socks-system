package org.courses.web.soap;

import org.courses.data.DAO.NamedDao;
import org.courses.domain.hbm.Manufacture;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.ManufactureService",
        serviceName = "ManufactureService"
)
public class ImplementationManufactureService implements ManufactureService {

    NamedDao<Manufacture, Integer> dao;
    public ImplementationManufactureService(NamedDao<Manufacture, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void save(Collection<Manufacture> entity) {
        dao.save(entity);
    }

    @Override
    public Manufacture read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Manufacture> readAll() {
        return dao.readAll();
    }

    @Override
    public Collection<Manufacture> find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
