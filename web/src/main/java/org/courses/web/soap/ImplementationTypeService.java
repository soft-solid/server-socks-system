package org.courses.web.soap;

import org.courses.data.DAO.NamedDao;
import org.courses.data.DAO.hbm.TypeDao;
import org.courses.domain.hbm.SocksType;

import javax.jws.WebService;
import java.util.Collection;
import java.util.Hashtable;

@WebService(
        endpointInterface = "org.courses.web.soap.TypeService",
        serviceName = "TypeService"
)
public class ImplementationTypeService implements TypeService {
    TypeDao dao;

    public ImplementationTypeService(NamedDao<SocksType, Integer> dao)
        {
        this.dao = (TypeDao) dao;
    }

    @Override
    public Hashtable<String, Integer> Save(Collection<SocksType> entities) {
        return dao.save(entities);
    }

    @Override
    public Collection<SocksType> ReadAll() { return dao.readAll(); }

    @Override
    public void Deactivate(Collection<Integer> entities) {
        dao.Deactivate(entities);
    }

}
