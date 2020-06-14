package project1.lesson8.task01.realization;

/**
 * SimpleClass
 * Класс который представляет собой объект в полях которого, представлены
 * примитивные типа данных и ссылочные.
 *
 * @author "Andrei Prokofiev"
 */
public class SimpleObject {
    private int a;
    public double d;
    protected boolean aBoolean;
    String string;
    char c;
    Person person;
//    int [] array;

    public void setA(int a) {
        this.a = a;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

//    public void setArray(int[] array) {
//        this.array = array;
//    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                "a=" + a +
                ", d=" + d +
                ", aBoolean=" + aBoolean +
                ", string='" + string + '\'' +
                ", c=" + c +
                ", person=" + person +
//                ", array=" + Arrays.toString(array) +
                '}';
    }
}
