package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;
        System.out.println(reflection);

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflectionObject = null;
        try {
            reflectionObject = (Reflection) reflection.getDeclaredConstructor().newInstance();
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(reflectionObject);
    }
}
