package project1.example.myThreads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * DemoDaemonThread
 *
 * @author "Andrei Prokofiev"
 */


/* пример # 6 : запуск и выполнение потока-демона: DemoDaemonThread.java */
public class DemoDaemonThread {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> synchronizedCollection = (List<String>) Collections.synchronizedCollection(list);


        T usual = new T();
        T daemon = new T();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();
        System.out.println("последний оператор main");
    }

}

