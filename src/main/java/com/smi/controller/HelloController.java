package com.smi.controller;

import com.smi.config.Push;
import com.smi.service.StatistiqueService;
import java.security.Principal;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    @Qualifier("statService")
    StatistiqueService statistiqueService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addObject("roles", authentication.getAuthorities());
        model.setViewName("home_1");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newPage(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName());
        model.addObject("id", 0);
        model.setViewName("new_1");
        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id, Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.addObject("id", id);
        model.setViewName("new_1");
        return model;
    }

    @RequestMapping(value = "/create/new", method = RequestMethod.GET)
    public ModelAndView createDashboard(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("id", 0);
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("dashboard_1");
        return model;
    }

    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.GET)
    public ModelAndView consulterDashboard(@PathVariable("id") long id, Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.addObject("id", id);
        model.setViewName("dashboard");
        return model;
    }

    @RequestMapping(value = "/dashboard/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editerDashboard(@PathVariable("id") long id, Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.addObject("id", id);
        model.setViewName("editDashboard");
        return model;
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public ModelAndView statPage(@PathVariable("id") long id, Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.addObject("id", id);
        model.setViewName("stat");
        return model;
    }

    @RequestMapping(value = "/dashboards/search", method = RequestMethod.GET)
    public ModelAndView searchDashboard(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("searchDashboard");
        return model;
    }

    @RequestMapping(value = "/statistiques/search", method = RequestMethod.GET)
    public ModelAndView searchStat(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("searchStat");
        return model;
    }

    @RequestMapping(value = "/statistiques/visualize", method = RequestMethod.GET)
    public ModelAndView visualizeStat(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("visualizeStat");
        return model;
    }

    @RequestMapping(value = "/dashboards/consulte", method = RequestMethod.GET)
    public ModelAndView consulterDashboard(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("consulterDashboard");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Principal principal, HttpServletResponse response) {

        ModelAndView model = new ModelAndView();
        //if(principal != null) 

//        Cookie c = new Cookie("nejm", "hhhhhhhhhhhhhhh");
//        response.addCookie(c);

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        if (error == null && logout == null && principal != null) {           
            return new ModelAndView("redirect:/home");
        }

        model.setViewName("login");
        return model;

    }

    @RequestMapping(value = "/users/ajout", method = RequestMethod.GET)
    public ModelAndView addUser(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("adduser");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView searchUser(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("searchUser");
        return model;
    }

    @RequestMapping(value = "/users/editer/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Long id, Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.addObject("id", id);
        model.setViewName("adduser");
        return model;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ModelAndView listRoles(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("roles");
        return model;
    }

    @RequestMapping(value = "/raw", method = RequestMethod.GET)
    public ModelAndView raw() {
        ModelAndView model = new ModelAndView();
        model.setViewName("rawData");
        return model;
    }
    
    @RequestMapping(value = "/remote", method = RequestMethod.GET)
    public ModelAndView remote() {
        ModelAndView model = new ModelAndView();
        model.setViewName("remote");
        return model;
    }
    
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView chat(Principal principal) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", principal.getName().toUpperCase());
        model.setViewName("chat");
        return model;
    }
    
    

}
