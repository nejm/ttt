/*
 * Copyright 2017 Nejm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smi.service;

import com.smi.dao.DashboardStatDao;
import com.smi.model.DashboardStat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dashboardStatService")
public class DashboardStatServiceImpl implements DashboardStatService{

    @Autowired 
    @Qualifier("dashboardstatdao")
    DashboardStatDao dashboardStatDao;
    
    @Override
    public Long save(DashboardStat dashboard) {
        return dashboardStatDao.save(dashboard);
    }

    @Override
    public void edit(DashboardStat dashboard) {
        dashboardStatDao.edit(dashboard);
    }

    @Override
    public List<DashboardStat> getByDashboardId(Long id) {
        return dashboardStatDao.getByDashboardId(id);
    }

    @Override
    public void delete(DashboardStat dashboardStat) {
        dashboardStatDao.delete(dashboardStat);
    }

    @Override
    public List<DashboardStat> findByStatId(Long id) {
       return dashboardStatDao.findByStatId(id);
    }
    
}
