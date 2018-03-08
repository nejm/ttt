/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author info-z
 */
public class CustomFilter extends OncePerRequestFilter {

    protected Logger logger = Logger.getLogger("filter");
    private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        logger.debug("Captcha verifier filter");
        logger.debug("chaptcha :: " + req.getParameter("g-recaptcha-response"));
        System.out.println("chaptcha :: " + req.getParameter("g-recaptcha-response"));
    }

}
