package org.courses.data.DAO.hbm;

import org.courses.domain.hbm.StorageHistory;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class StorageHistoryDao extends UnNamedBaseDao<StorageHistory, Integer> {
    public StorageHistoryDao(SessionFactory factory) {
        super(factory, StorageHistory.class);
    }

    @Override
    public Collection<StorageHistory> find(String filter) {
        return null;
    }
}