package com.epam.redball.filter;

import javax.servlet.*;
import java.io.IOException;

public class LanguageFilter implements Filter {

    private FilterConfig config = null;
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        String act = config.getInitParameter("active");
        if (act != null)
            active = (act.equalsIgnoreCase("TRUE"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (active) {
            // Здесь можно вставить код для обработки
            System.out.println("Работает йоптеть");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
