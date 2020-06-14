package project1.lesson10.clients;


import project1.lesson10.Listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPClient1
 * Класс создает, отправляет и принимает
 * сообщения от других пользователей.
 *
 * @author "Andrei Prokofiev"
 */
public class UDPClient1 {
    public static void main(String args[]) throws Exception {

        int serverPort = 9876;

        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1000];
        byte[] receiveData = new byte[1000];
        String sentence = "null";
        String userName = "Ivan";

        try (DatagramSocket clientSocket = new DatagramSocket();
             BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        ) {
            Listener listener = new Listener(clientSocket);
            listener.start();

            sendData = userName.getBytes();
            DatagramPacket sendPacketPort = new DatagramPacket(sendData, sendData.length, IPAddress, serverPort);
            clientSocket.send(sendPacketPort);

            while (!(sentence = inFromUser.readLine()).equals("quit")) {
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, serverPort);
                clientSocket.send(sendPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
