/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PSP_T2_MiniVeyon;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Vespertino
 */
public class ClienteVista extends JFrame {

    private JLabel lb;
    private GridLayout panel;

    public ClienteVista() {
        lb = new JLabel();
        panel = new GridLayout(1,1);
        getContentPane().setLayout(panel);
        getContentPane().add(lb);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        ClienteVista cv = new ClienteVista();
        cv.setVisible(true);
        String ip = "10.2.2.7";
        int puerto = 2055;
        while (true) {
            try {
                Socket clienteSocket = new Socket(ip, puerto);
                BufferedInputStream in = new BufferedInputStream(clienteSocket.getInputStream());
                BufferedImage someImage;
                someImage = ImageIO.read(in);
                
                //Icon icon = new ImageIcon(someImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), someImage.SCALE_AREA_AVERAGING));
                Icon icon = new ImageIcon(someImage);
                cv.lb.setIcon(icon);
                someImage.flush();

//                in.close();
//                clienteSocket.close();
            } catch (UnknownHostException e) {
            } catch (IOException e) {
            }
        }
        
        
    }

}
