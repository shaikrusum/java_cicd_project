package com.cicd;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", ex -> {
            String host = System.getenv().getOrDefault("HOSTNAME", "unknown");
            byte[] msg = ("Hello from CI/CD! Pod: " + host).getBytes();
            ex.sendResponseHeaders(200, msg.length);
            ex.getResponseBody().write(msg);
            ex.close();
        });
        server.start();
    }
}