package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Core core = new Core();
        JFrame frame = new JFrame("Gravity GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(750,750);
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(core);
        int a = 0;
        int b = 10;
        double e = 0.01;
        for(double x = a ; x < b ; x+=e){
            System.out.println(x * 2);
        }
    }
}