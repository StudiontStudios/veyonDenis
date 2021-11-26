/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP_T2_MiniVeyon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

/**
 *
 * @author Vespertino
 */
public class Servidor {

    public static void main(String[] args) throws InterruptedException, IOException {
        empezarHilo();
        int i = 1;
        ServerSocket serverSocket = new ServerSocket(2055);
        while (true) {
            //acepta la conexion
            Socket clienteSocket = serverSocket.accept();
            //hilo servidor
            HiloServidor hs = new HiloServidor(i, clienteSocket, serverSocket);
            Thread t = new Thread(hs);
            t.start();
            Thread.sleep(2000);
            i++;
        }
    }

    public static void empezarHilo() {
        Hilo h = new Hilo("Captura", 1999);
        Thread t1 = new Thread(h);
        t1.start();
    }

}
