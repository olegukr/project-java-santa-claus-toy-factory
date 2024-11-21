package org.factoriaf5.db;

import java.util.List;

public interface IDatabase<E> {

    public void save(E entity);
    public List<E> getToys();
    public void delete(E entity);

}
