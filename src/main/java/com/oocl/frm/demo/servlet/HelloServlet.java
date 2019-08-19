package com.oocl.frm.demo.servlet;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String key = "k1";
            String value = "Hello World!";

            CacheFactory.ensureCluster();
            NamedCache cache = CacheFactory.getCache("PagingCache");

            cache.put(key, value);
            System.out.println(">>>>>> cache :[" + (String) cache.get(key) + "]");

//			CacheFactory.shutdown();

            PrintWriter pw = resp.getWriter();

            pw.append("<html><h1> " + ">>>>>> cache :[" + (String) cache.get(key) + "]" + "</h1></html>");

        } catch (Throwable t) {
            t.printStackTrace();
            throw new ServletException(t);
        }

    }
}
