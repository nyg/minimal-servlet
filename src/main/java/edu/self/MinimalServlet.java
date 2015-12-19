package edu.self;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/*")
public class MinimalServlet implements Servlet {

    private static final Logger logger = Logger.getLogger(MinimalServlet.class.getSimpleName());

    private ServletConfig config;

    @Override
    public void destroy() {
        logger.info("Servlet destroyed");
    }

    @Override
    public ServletConfig getServletConfig() {
        logger.info("Servlet config requested");
        return config;
    }

    @Override
    public String getServletInfo() {
        logger.info("Servlet info requested");
        return "A Minimal Servlet";
    }

    @Override
    public void init(ServletConfig config) {
        logger.info("Servlet initialized");
        this.config = config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        for (Method method : ServletRequest.class.getMethods()) {
            try {
                String result = method.invoke(request).toString();
                response.getWriter().println(method.getName());
                response.getWriter().println("-> " + result + "\n");
            }
            catch (Throwable e) {
                logger.info("Failed on " + method.getName());
            }
        }
    }
}
