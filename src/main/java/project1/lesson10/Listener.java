package project1.lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Listener
 * Класс слушает порт сервера и получает от него сообщения.
 *
 * @author "Andrei Prokofiev"
 */
public class Listener extends Thread {

    private DatagramSocket clientSocket;

    public Listener(DatagramSocket clientSocket) throws SocketException {
//        this.port = port;

        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            while (true) {
                byte[] receiveData = new byte[200];
//                System.out.println(clientSocket.getPort());

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String recieveSentence = new String(receivePacket.getData());

                System.out.println(recieveSentence);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
