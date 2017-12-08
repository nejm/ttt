package com.smi.dao;

import com.smi.model.Alias;
import java.util.List;

public interface AliasDao {

    Alias findById(Long id);
    Alias findByStat(Long id);
    List<Alias> findAll();
    Long save(Alias alias);
    boolean update(Alias alias);
}
