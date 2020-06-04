package src.project1.lesson12.outMetaspace;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * TestPermGenMetaSpaceOOM
 *
 * @author "Andrei Prokofiev"
 */
public class TestPermGenMetaSpaceOOM {
    private static Map<String, MyInterface> myMap = new HashMap<String, MyInterface>();
    private static Map<String, MyInterface> myMap1 = new HashMap<String, MyInterface>();
    private static Map<String, MyInterface> myMap2 = new HashMap<String, MyInterface>();

    private final static int iterationDefault = 50000;

    public static void createPermGenOOM() {
        int iterations = 0;
        try {
            while (true) {
                String classLoaderJAR = "file:" + iterations + ".jar";
                URL[] urlsOfJar = new URL[]{new URL(classLoaderJAR)};//an array containing jar url
                URLClassLoader aUrlClassLoader = new URLClassLoader(urlsOfJar); //a class loader to load all JAR urls
                //this will create new proxy to load the class loader
                MyInterface proxyObj0 = (MyInterface) Proxy.newProxyInstance(aUrlClassLoader, //adding class loader
                        new Class<?>[]{MyInterface.class},//Anonymous class/Interface array which implements myInterface
                        new MyInterfaceInvocationHandler(new MyClass())// an invocation handler(implements InvocationHandler)
                );

                MyInterface proxyObj1 = (MyInterface) Proxy.newProxyInstance(aUrlClassLoader, //adding class loader
                        new Class<?>[]{MyInterface.class},//Anonymous class/Interface array which implements myInterface
                        new MyInterfaceInvocationHandler(new MyClass())// an invocation handler(implements InvocationHandler)
                );

                MyInterface proxyObj = (MyInterface) Proxy.newProxyInstance(aUrlClassLoader, //adding class loader
                        new Class<?>[]{MyInterface.class},//Anonymous class/Interface array which implements myInterface
                        new MyInterfaceInvocationHandler(new MyClass())// an invocation handler(implements InvocationHandler)
                );
                myMap.put(classLoaderJAR, proxyObj); // this will store all loaders which eventually leak memory as it is stored.
//                TestOOM.showMemoryInfo();
                myMap1.put(classLoaderJAR, proxyObj1); // this will store all loaders which eventually leak memory as it is stored.
                myMap2.put(classLoaderJAR, proxyObj0); // this will store all loaders which eventually leak memory as it is stored.


                iterations++;

            }
        } catch (Throwable anyError) {
            anyError.printStackTrace();
            System.out.println("Error = " + anyError);
        }
    }
}

