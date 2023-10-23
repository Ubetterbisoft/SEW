package sew6.calcvm;

import com.sun.jdi.connect.spi.TransportService;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private LinkedList<Integer> list;

    public Stack(){
        list = new LinkedList<>();
    }
    public void push(int value){
        list.push(value);
    }
    public int pop(){
        return list.pop();
    }
}
