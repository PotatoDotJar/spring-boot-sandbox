package com.potatosaucevfx.springbootsandbox;

import com.potatosaucevfx.springbootsandbox.model.Login;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {

        // Add user object to check for authentication.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)
                && modelAndView != null) {
            Login login = (Login) authentication.getPrincipal();
            modelAndView.addObject("user", login.getUserData());
        }

        if (modelAndView != null) {
            modelAndView.addObject("date", new Date());
        }

    }

}
