package com.smi.dao;

import com.smi.model.Alias;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("aliasDao")
public class AliasDaoImpl implements AliasDao{
    
    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Alias findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Alias.findById").setLong("id", id);
        return (Alias) query.uniqueResult(); 
    }

    @Override
    @Transactional
    public Alias findByStat(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Alias.findByIdStat").setLong("idStat", id);
        return (Alias) query.uniqueResult(); 
    }

    @Override
    @Transactional
    public List<Alias> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Alias.findAll");
        return query.list(); 
    }

    @Override
    @Transactional
    public Long save(Alias alias) {
        Session session = sessionFactory.getCurrentSession();
        session.save(alias);
        return alias.getId();
    }

    @Override
    @Transactional
    public boolean update(Alias alias) {
        Session session = sessionFactory.getCurrentSession();
        session.update(alias);
        return true;
    }

}
