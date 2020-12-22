package project1.example.myThreads;

/**
 * T
 *
 * @author "Andrei Prokofiev"
 */
class T extends Thread {
    Integer i;

    public void run() {

        try {

            if (isDaemon()){

                System.out.println("старт потока-демона");

//                sleep(1); // заменить параметр на 1

            } else {

                System.out.println("старт обычного потока");

            }

        }
//        catch (InterruptedException e) {
//
//            System.err.print("Error" + e);
//
//        }
        finally {

            if (!isDaemon())

                System.out.println(

                        "завершение обычного потока");

            else

                System.out.println(

                        "завершение потока-демона");

        }

    }

}


