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
package com.smi.controller;

import com.smi.model.Role;
import com.smi.model.Users;
import com.smi.model.Usersandroles;
import com.smi.service.RoleService;
import com.smi.service.UserAndRoleService;
import com.smi.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.smi.model.RolesOfUser;
import org.json.simple.JSONObject;

@RestController
public class UserController {

    @Autowired
    @Qualifier("usersService")
    UserService userService;

    @Autowired
    @Qualifier("roleService")
    RoleService roleService;

    @Autowired
    @Qualifier("userAndRoleService")
    UserAndRoleService userAndRoleService;

    @RequestMapping(value = "/rest/users/exist/{username}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> exist(@PathVariable String username) {
        Users u = userService.findByUsername(username);
        if (u != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rest/users/get/{username}", method = RequestMethod.GET)
    public Users getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/rest/users/add", method = RequestMethod.POST)
    public ResponseEntity<Long> addUser(@RequestBody Users user) {
        Long id = userService.addUser(user);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/users/edit", method = RequestMethod.POST)
    public void editUser(@RequestBody Users user) {
        userService.editUser(user);
    }

    @RequestMapping(value = "/rest/users/delete", method = RequestMethod.POST)
    public void deleteUser(@RequestBody Users user) {
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/rest/users/edit/{id}", method = RequestMethod.GET)
    public Users editUser(@PathVariable Long id) {
        return userService.findById(id);
    }
    
    @RequestMapping(value = "/rest/roles/users/{id}", method = RequestMethod.GET)
    public List<Users> usersOfRole(@PathVariable Long id) {
        List<Users> users = new ArrayList<>();
        for(Usersandroles u : userAndRoleService.findByRole(id)){
            users.add(userService.findById(u.getUserId()));
        }
        return users;
    }
    
    @RequestMapping(value = "/rest/users", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> stats = userService.findAll();
        return new ResponseEntity<List<Users>>(stats, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rest/role/users/add", method = RequestMethod.POST)
    public void addAllUsers(@RequestBody JSONObject o) {
        Integer id = (Integer) o.get("role");
        List<Integer> users = (List<Integer>) o.get("users");
        for(Usersandroles u : userAndRoleService.findByRole(id.longValue())){
            userAndRoleService.delete(u);
        }
        Usersandroles r = new Usersandroles();
        for(Integer idR : users){
            r.setRoleId(id.longValue());
            r.setUserId(idR.longValue());
            userAndRoleService.add(r);
        }
    }

    @RequestMapping(value = "/rest/roles", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/profiles/{id}", method = RequestMethod.GET)
    public List<Usersandroles> userProfiles(@PathVariable Long id) {
        List<Usersandroles> u = new ArrayList<>();
        Long userId;
        for (Usersandroles us : userAndRoleService.findByUser(1l)) {
            userId = us.getUserId();
            if (id.equals(userId)) {
                u.add(us);
            }
        }

        return u;
    }

    @RequestMapping(value = "/rest/users/profiles", method = RequestMethod.POST)
    public void addProfilestoUser(@RequestBody RolesOfUser object) {
        System.out.println("com.smi.controller.UserController.addProfilestoUser()" + object.getId());
        System.out.println("com.smi.controller.UserController.addProfilestoUser()" + object.getRoles());
        Long id = object.getId();
        for (Usersandroles uar : userAndRoleService.findByUser(id)) {
            if (uar.getUserId() == id) {
                userAndRoleService.delete(uar);
            }
        }
        Usersandroles us = null;
        if (object.getRoles() != null) {
            for (Role r : object.getRoles()) {
                us = new Usersandroles();
                us.setRoleId(r.getRoleId());
                us.setUserId(id);
                userAndRoleService.add(us);
            }
        }

    }
    
    @RequestMapping(value = "/rest/roles", method = RequestMethod.POST)
    public Long addRole(@RequestBody Role role) {
        return roleService.save(role);
    }
    
    @RequestMapping(value = "/rest/roles/delete", method = RequestMethod.POST)
    public void deleteRole(@RequestBody Role role) {
        roleService.delete(role);
    }
}
