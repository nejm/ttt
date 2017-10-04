package com.smi.dao;

import com.smi.model.Role;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nejm
 */
public class RoleDaoImpl implements RoleDao {

    final static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    private UserAndRoleImpl userAndRoleDao;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
    }

    @Override
    public Role findById(long id) {
        createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.getNamedQuery("Role.findByRoleId").setLong("roleId", id);
        //session.close();
        return (Role) q.uniqueResult();
    }

    @Override
    public List<Role> findAll() {
        createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Role> roles = session.getNamedQuery("Role.findAll").list();
        //session.close();
        return roles;
    }

    @Override
    public Role findByName(String name) {
        createSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Role role = (Role) session.getNamedQuery("Role.findByRoleName").setString("roleName", name).uniqueResult();
        //session.close();
        return role;
    }

    @Override
    public Long save(Role role) {
        createSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        return role.getRoleId();
    }

    @Override
    public void delete(Role role) {
        createSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(role);
        tx.commit();
    }
}
