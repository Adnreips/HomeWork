package project1.example;

/**
 * A
 *
 * @author "Andrei Prokofiev"
 */
public class A {
    int var1 = 123;
    //declaring final variables
    final int var2 = 345;
    final int var3;
//Trying to initialize a blank final variable
//    var = 555; //Error
    A(){
        var1 = 111; //No Error
//        var2 = 333; //Compilation Error
//Initializing a blank final variable
        var3 = 444; //No Error
    }
    //passing final parameters
    void avg(int param1, final int param2){
        param1 = 2345; //No Error
//        param2 = 1223; //Compilation Error
    }
    //declaring final fields
    void show(){
        final int fieldVal = 300000;
//        fieldVal = 400000; //Error
    }
}