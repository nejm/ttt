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

import com.smi.dao.DashboardDao;
import com.smi.model.Dashboard;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nejm
 */
public interface DashboardService {

    List<Dashboard> getDashboards(String username);
    List<Dashboard> getAllDashboards();
    Dashboard getDashboard(Long id);
    Long save(Dashboard dashboard);
    void edit(Dashboard dashboard);
    Boolean doesExist(String name);
    void delete(Dashboard d);
}
