package org.courses.data.DAO.hbm;

import org.apache.commons.validator.routines.IntegerValidator;
import org.courses.domain.hbm.Manufacture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class ManufactureDao extends NamedBaseDao<Manufacture, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public ManufactureDao(SessionFactory factory) {
        super(factory, Manufacture.class);
    }

    @Override
    public Collection<Manufacture> find(String filter) {
        Session session = factory.getCurrentSession();
        return session
                .createQuery("from Manufacture " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }

    @Transactional(rollbackFor = Exception.class)
    public void Deactivate(Collection<Integer> ArrayID){
        Session session = factory.getCurrentSession();

        String hql = "UPDATE Manufacture set active = 0 WHERE id in :id";
        Query query = session.createQuery(hql);
        query.setParameterList("id",ArrayID);
        query.executeUpdate();
    }
}
