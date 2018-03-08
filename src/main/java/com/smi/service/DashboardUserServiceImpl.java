package com.smi.service;

import com.smi.dao.DashboardUserDao;
import com.smi.model.DashboardUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dashboardUserService")
public class DashboardUserServiceImpl implements DashboardUserService{

    @Autowired
    @Qualifier("dashboarduserdao")
    DashboardUserDao  dashboardUserDao;
    
    @Override
    public List<DashboardUser> getByUser(String username) {
        return dashboardUserDao.getByUser(username);
    }

    @Override
    public List<DashboardUser> getByRole(String roleName) {
        return dashboardUserDao.getByRole(roleName);
    }

    @Override
    public Long save(DashboardUser dashboard) {
        return dashboardUserDao.save(dashboard);
    }

    @Override
    public void edit(DashboardUser dashboard) {
        dashboardUserDao.edit(dashboard);
    }

    @Override
    public void delete(DashboardUser dashboardUser) {
        dashboardUserDao.delete(dashboardUser);
    }
    
}
