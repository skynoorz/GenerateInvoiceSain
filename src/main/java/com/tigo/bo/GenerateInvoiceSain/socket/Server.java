package com.tigo.bo.GenerateInvoiceSain.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
    private final String username = "java";
    private final String password = "java";
    private final int port = 9090;
    ServerSocket serversocket;
    Socket client;
    BufferedReader input;
    PrintWriter output;

    public void start() throws IOException {
        System.out.println("Connection Starting on port:" + this.port);
        //make connection to client on port specified
        serversocket = new ServerSocket(this.port);

        //accept connection from client
        client = serversocket.accept();

        System.out.println("Waiting for connection from client");

        try {
            logInfo();
        } catch (Exception e) {
            log.error("No se pudo mostrar el resultado desde el servidor.");
            e.printStackTrace();
        }
    }

    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String username = input.readLine();
        System.out.println("SERVER SIDE" + username);
        String password = input.readLine();
        System.out.println("SERVER SIDE" + password);

        //open printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        if(username.equals(this.username) &&password.equals(this.password)){
            output.println("Welcome, " + username);
        }else{
            output.println("Login Failed");
        }
        output.flush();
        output.close();

    }
    public static void main(String[] args){
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            log.error("Error al iniciar el servidor de prueba ..");
            e.printStackTrace();
        }
    }
}
