package org.courses.web.soap;

import org.courses.data.DAO.UnNamedDao;
import org.courses.domain.hbm.Socks;

import javax.jws.WebService;
import java.util.Collection;

@WebService(
        endpointInterface = "org.courses.web.soap.SocksService",
        serviceName = "SocksService"
)
public class ImplementationSocksService implements SocksService {

    UnNamedDao<Socks, Integer> dao;
    public ImplementationSocksService(UnNamedDao<Socks, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public void Save(Collection<Socks> entity) {
        dao.save(entity);
    }

    @Override
    public Socks Read(int id) {
        return dao.read(id);
    }

    @Override
    public Collection<Socks> ReadAll(boolean onlyActive) { return dao.readAll(onlyActive); }

    @Override
    public Collection<Socks> Find(String filter) {
        return dao.find(filter);
    }

    @Override
    public void Delete(int id) {
        dao.delete(id);
    }
}
