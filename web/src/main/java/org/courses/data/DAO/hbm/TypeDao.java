package org.courses.data.DAO.hbm;

import org.apache.commons.validator.routines.IntegerValidator;
import org.courses.domain.hbm.SocksType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class TypeDao extends NamedBaseDao<SocksType, Integer> {
    private IntegerValidator Int32 = IntegerValidator.getInstance();

    public TypeDao(SessionFactory factory) {
        super(factory, SocksType.class);
    }

    @Override
    public Collection<SocksType> find(String filter) {
        Session session = factory.openSession();
        return session
                .createQuery("from SocksType " +
                        "where id = :id " +
                        "or name like :filter")
                .setParameter("id", Int32.validate(filter))
                .setParameter("filter", String.format("%%%s%%", filter))
                .list();
    }

    @Transactional(rollbackFor = Exception.class)
    public void Deactivate(Collection<Integer> ArrayID){
        Session session = factory.getCurrentSession();

        String hql = "UPDATE SocksType set active = 0 WHERE id in :id";
        Query query = session.createQuery(hql);
        query.setParameterList("id",ArrayID);
        query.executeUpdate();
    }


}
