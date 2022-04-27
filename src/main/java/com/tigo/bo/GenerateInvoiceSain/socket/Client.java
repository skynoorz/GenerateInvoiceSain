package com.tigo.bo.GenerateInvoiceSain.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    private String username;
    private String password;
    private int port;
    private String host;

    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public Client(String host, int puerto, String user, String password) {
        this.host = host;
        this.port = puerto;
        this.username = user;
        this.password = password;
    }

    public void startClient() throws IOException
    {
        //Create socket connection
        socket = new Socket(this.host, this.port);

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        //prompt for user name
        String username = this.username;
        output.println(username);

        //prompt for password
        String password = this.password;
        output.println(password);

        output.flush();

        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();

        //display response
        log.info("This is the response: {}", response);
    }
}