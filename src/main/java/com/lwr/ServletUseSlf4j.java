package com.lwr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过slf4j日志门面调用log4j2来打印日志
 */
@WebServlet("/slf4j")
public class ServletUseSlf4j extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ServletUseSlf4j.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        m1();
    }

    private void m1() {
        logger.error("hello {},do you like {}", "jack", "apple");
    }

}
