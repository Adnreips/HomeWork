package project1.lesson10.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

/**
 * UDPServer
 * Класс представляет собой сервер, который принимает сообщение от пользователей
 * и отправляет его всем подключенным пользователям.
 *
 * @author "Andrei Prokofiev"
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {

        int serverPort = 9876;
        List<Integer> ports = new ArrayList();
        Map<Integer, String> userInfo = new HashMap<>();

        try (DatagramSocket serverSocket = new DatagramSocket(serverPort)) {

            while (true) {
                byte[] receiveData = new byte[1000];
                byte[] sendData = new byte[1000];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData()).trim();

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                if (userInfo.containsKey(port)) {

                    String nameUser = userInfo.get(port);

                    String toSend = new String(nameUser + ": " + sentence);

                    sendData = toSend.getBytes();

                    Set<Integer> set = userInfo.keySet();
                    Iterator iterator = set.iterator();
                    System.out.println(toSend);

                    while (iterator.hasNext()) {
                        DatagramPacket sendPacket =
                                new DatagramPacket(sendData, sendData.length, IPAddress, (Integer) iterator.next());
                        serverSocket.send(sendPacket);
                    }
                } else {
                    userInfo.put(port, sentence);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
