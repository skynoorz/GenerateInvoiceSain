package com.tigo.bo.GenerateInvoiceSain.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion
{
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(int puerto, String host, String name, String password) throws IOException //Constructor
    {
        cs = new Socket(host, puerto); //Socket para el cliente
    }
}