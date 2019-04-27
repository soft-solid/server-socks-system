package org.courses.data.DAO.hbm;

import org.courses.domain.hbm.Storage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public class StorageDao extends UnNamedBaseDao<Storage, Integer> {
    public StorageDao(SessionFactory factory) {
        super(factory, Storage.class);
    }

    @Override
    public Collection<Storage> find(String filter) {
        return null;
    }
}
