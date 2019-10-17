package com.sprboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Controller
public class AuthController {
    @GetMapping("/")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> role = authResult.getAuthorities();
        for (GrantedAuthority grantedAuthority : role) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/listUsers"));
            } else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user/hi"));
            }
        }
    }
}