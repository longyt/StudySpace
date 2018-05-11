package com.lianbi.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletUtil {

    private static final Logger logger = LoggerFactory.getLogger(ServletUtil.class);

    public static PrintWriter getJsonOut(HttpServletResponse response) throws IOException {
        response.setContentType("text/json; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, Cookie");
        return response.getWriter();
    }

    public static void  write(HttpServletResponse response,String value){
        try(PrintWriter out=getJsonOut(response)) {
            logger.info("{ response  } ==  "+value);
            out.print(value);
            out.flush();
            out.close();
            logger.info("====  response   完毕 ");
        }catch (IOException e){
            logger.error("error  ====  "+e);
        }

    }

}
