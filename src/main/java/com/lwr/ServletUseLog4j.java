package com.lwr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 纯log4j的日志打印
 */
@WebServlet("/log4j")
public class ServletUseLog4j extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(ServletUseLog4j.class);

    // private static final Logger formateLog =
    // LogManager.getFormatterLogger(ServletUseLog4j.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        m1();
        m2("jack", "flower");
        m3();
    }

    private void m1() {
        // logger方法本身就会先判断enable，再次is*Enabled()纯属浪费性能
        if (logger.isErrorEnabled()) {
            logger.error("this is logger msg");
        }
    }

    private void m2(String a, String b) {
        logger.error("hello, " + a + ",do you like " + b);
        // 对于上面的字符串拼接，如果logger级别不到不能打印，这种拼接纯属浪费
        // 使用占位符形式
        logger.error("hello {},do you like {}", a, b);
    }

    private void m3() {
        Throwable t = new Exception("a error occurs!");
        // 参数给多会忽略后面的，结果输出：我看到第一个参数是 p0
        logger.info("我看到第一个参数是  {}", "p0", "p1");

        /*
         * 把Throwable参数放到最后，会输出异常信息 ，下面结果输出： 我看到第一个参数是 p0 p1 java.lang.Exception: a
         * error occurs! at com.lwr.ServletUseLog4j.m3(ServletUseLog4j.java:46)
         * [classes/:?]
         */
        logger.info("我看到的参数是  {} {}", "p0", "p1", t);

    }

}
