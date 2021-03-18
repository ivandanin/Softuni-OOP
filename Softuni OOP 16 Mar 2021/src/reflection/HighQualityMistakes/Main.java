package HighQualityMistakes;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] getters = Reflection.class.getDeclaredMethods();
                Arrays.stream(getters)
                .filter(m -> m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n",
                m.getName()));

        Method[] setters = Reflection.class.getDeclaredMethods();
        Arrays.stream(setters)
                .filter(m -> m.getName().startsWith("set") &&!Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n",
                        m.getName()));


    }
}
