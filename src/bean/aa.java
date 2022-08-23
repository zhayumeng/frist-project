package bean;


import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class aa implements Filter {
    public void destroy() {
        System.out.println("执行destroy()");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.println("执行doFilter()");
        arg2.doFilter(arg0, arg1);
    }

    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("执行init()");
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}