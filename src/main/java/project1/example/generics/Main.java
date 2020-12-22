package project1.example.generics;

import project1.example.SuperBox;
import project1.lesson8.task01.realization.Person;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;


/**
 * Main
 *
 * @author Andrey
 */
public class Main implements Converter<String, Integer> {

    Integer num = 1;

    public static <T> Object getFirst(List<? super T> list) {
        return list.get(0); // compile-time error
    }

    @Override
    public  Integer convert(String from) {
        Converter<String, Integer> converter = (o) -> Integer.valueOf(o);
        Integer converted = converter.convert(from);
        System.out.println(converted);
//        Более компактный вариант
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert(from);
//        System.out.println(converted);
        return converted;
    }

    public static class Util {
        public static <T> T getValue(Object obj) {
            return (T) obj;
        }
    }
    public static void main(String[] args) throws
            ExecutionException, InterruptedException, FileNotFoundException {

        final int[] num = {1};
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(num[0] =from);
//        num = 2;
//
//        System.out.println(stringConverter.convert(2));
//        System.out.println(num[0]);


//
//        Singleton singleton = Singleton.getInstance();
//        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();


//        List<Integer> ints = new ArrayList<Integer>();
//        ints.add(1);
//        ints.add(2);
//        List<? super Integer> src = ints;
//
//        src.add(3);
//        List<? super Integer> dest =new ArrayList<>(8);
//        dest.add(5);
//        dest.add(2);
//        dest.add(1);
//        String string;
//
//        Main.copy(dest, ints);
//        System.out.println(dest);
//
//        List list = Arrays.asList(2, 3);
//        for (Object element : list) {
//            System.out.println(Util.<Integer>getValue(element) + 1);
//        }
//        ArrayList<String> strings = new ArrayList<>();
//        ArrayList arrayList = new ArrayList();
//        arrayList = strings; // Ok
//        strings = arrayList; // Unchecked assignment
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//
//        List list = new ArrayList<>();
//        list.add("Hello!");
//        list.add(123);
//        for (Object str : list) {
//            System.out.println(str);
//        }







//        MobileDao mobileDao = new MobileDaoJdbcImpl();
//        mobileDao.selectMobile();


//
//        Cat cat1 = new Cat("Васька1");
//        Cat cat2 = new Cat("Васька2");
//        Cat cat3 = new Cat("Васька3");
//
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<String> future = executorService.submit(cat1);
//        Future<String> future1 = executorService.submit(cat1);
//        Future<String> future2 = executorService.submit(cat1);
//        List<Cat> cats = new ArrayList<>();
//        cats.add(cat1);
//        cats.add(cat2);
//        executorService.invokeAll(cats);
//
//        System.out.println(future.get());
//        executorService.shutdown();
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        File file = new File("D:\\HomeWorkNew\\src\\main\\java\\project1\\example\\1.txt");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (FileReader fileReader = new FileReader(file);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//
//           char [] a = new char[200];   // Количество символов, которое будем считывать
//           bufferedReader.read(a);
//            System.out.println(a);
////            String str = bufferedReader.readLine();
////            System.out.println(str);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            BufferedReader bufferedReader;
//            ObjectOutputStream f;
//            System.out.println(fileInputStream.available());
//            int i=-1;
//            while((i=fileInputStream.read())!=-1){
//                System.out.print((char)i);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1));
        }
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        Collections.copy(dest, src);
    }

    private void doWork() {

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        Set<String> set = new TreeSet<>();
        Iterator<String> iterator = set.iterator();
        List<String> listSynh = Collections.synchronizedList(list);
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        synchronized (list) {

        }


        Person personVasya = new Person(12, "Vasya");

        SuperBox<Object> boxObject = new SuperBox<>();
        boxObject.internalVariable = new Object();

        SuperBox<Person> boxPerson = new SuperBox<>();
//        boxPerson.internalVariable = new Object(); // ТАК НЕЛЬЗЯ

        boxPerson.internalVariable = personVasya;
//        doWithPerson(boxPerson);


        boxObject.internalVariable = personVasya; // ТАК МОЖНО ЭТО НУЖНО ПОНЯТЬ

//        boxObject = boxPerson; // ТАК НЕЛЬЗЯ ЭТО НУЖНО ПОНЯТЬ, ссылке присвоить существующую ссылку параметризованного класса нельзя, а новую сделать можно
        boxObject.internalVariable = new Object();

//        boxPerson = boxObject; // ТАК НЕЛЬЗЯ ЭТО НУЖНО ПОНЯТЬ
    }

    private void doWithPerson(SuperBox<Person> box) {
        //box.object хочу узнать возраст
    }
}
