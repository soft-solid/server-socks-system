package org.courses.web.soap;

import org.courses.data.DAO.NamedDao;
import org.courses.data.DAO.hbm.ManufactureDao;
import org.courses.domain.hbm.Manufacture;

import javax.jws.WebService;
import java.util.Collection;
import java.util.Hashtable;

@WebService(
        endpointInterface = "org.courses.web.soap.ManufactureService",
        serviceName = "ManufactureService"
)
public class ImplementationManufactureService implements ManufactureService {

    ManufactureDao dao;
    public ImplementationManufactureService(NamedDao<Manufacture, Integer> dao)
    {
        this.dao = (ManufactureDao)dao;
    }

    @Override
    public Hashtable<String, Integer> Save(Collection<Manufacture> entities) {
        return dao.save(entities);
    }

    @Override
    public Collection<Manufacture> ReadAll() { return dao.readAll(); }

    @Override
    public void Deactivate(Collection<Integer> entities) {
        dao.Deactivate(entities);
    }
}
