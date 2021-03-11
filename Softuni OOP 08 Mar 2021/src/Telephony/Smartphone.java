package Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> urls;
    private List<String> numbers;

    public Smartphone (List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
    }


    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        this.urls.forEach(u -> output.append
                (u.matches("^[^0-9]+$")
                        ? String.format("Browsing: %s!", u)
                        : "Invalid URL!").append(System.lineSeparator()));
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        this.numbers.forEach(n -> output.append(n.matches("^[0-9]+$")
                ? String.format("Calling... %s", n)
                : "Invalid number!").append(System.lineSeparator()));
        return output.toString();
    }
}
