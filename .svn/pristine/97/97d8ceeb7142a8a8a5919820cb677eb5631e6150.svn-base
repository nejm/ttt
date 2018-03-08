package com.smi.service;

import com.smi.dao.AliasDao;
import com.smi.dao.AttributDao;
import com.smi.model.Alias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("aliasService")
public class AliasServiceImpl implements AliasService {

    @Autowired
    @Qualifier("aliasDao")
    AliasDao aliasDao;

    @Override
    public Alias findById(Long id) {
        return aliasDao.findById(id);
    }

    @Override
    public Alias findByStat(Long id) {
        return aliasDao.findByStat(id);
    }

    @Override
    public List<Alias> findAll() {
        return aliasDao.findAll();
    }

    @Override
    public Long save(Alias alias) {
        return aliasDao.save(alias);
    }

    @Override
    public boolean update(Alias alias) {
        return aliasDao.update(alias);
    }

}
