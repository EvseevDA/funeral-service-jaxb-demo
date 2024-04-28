package com.funeralservice.dao;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> {

    public abstract List<T> getAll();
    public abstract Optional<T> getById(int id);

    public static int requireIdNonNegative(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be greater or equal 0. Now is " + id + ".");
        }
        return id;
    }

}
