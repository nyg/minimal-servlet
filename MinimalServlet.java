import java.io.IOException;
import java.util.logging.Level;
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
        logger.info("method: destroy");
    }

    @Override
    public ServletConfig getServletConfig() {
        logger.info("method: getServletConfig");
        return config;
    }

    @Override
    public String getServletInfo() {
        logger.info("method: getServletInfo");
        return "Simple Servlet";
    }

    @Override
    public void init(ServletConfig config) {
        logger.info("method: init");
        this.config = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {

        logger.info("method: service");

        try {
            res.getWriter().println(
                "received " + req.getProtocol() + " request from " + req.getLocalAddr() + ":" + req.getLocalPort());
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
