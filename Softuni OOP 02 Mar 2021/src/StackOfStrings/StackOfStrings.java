package StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class StackOfStrings extends Stack {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }
    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }
    public String peek() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.get(data.size() - 1);
        }
    }

    public boolean isEmpty() {
        if (data.isEmpty()) {
            return true;
        }
        return false;
    }
}
