package project1.example.myThreads;

/**
 * DemoDaemonThread
 *
 * @author "Andrei Prokofiev"
 */


/* пример # 6 : запуск и выполнение потока-демона: DemoDaemonThread.java */
public class DemoDaemonThread {

    public static void main(String[] args) {

        T usual = new T();
        T daemon = new T();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();
        System.out.println(
                "последний оператор main");
    }

}

