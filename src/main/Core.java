package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Core extends JPanel {
    Random R = new Random();
    public static ArrayList <Sphere> spheres = new ArrayList<>();

    Core() {
        Listener L = new Listener();
        this.setBackground(Color.BLACK);
        this.addMouseListener(L);
        this.addMouseMotionListener(L);
        this.addKeyListener(new KeyListener());

        System.out.println(spheres.size());

//        nail();
    }

    private void nail(){
        int y = 200;
        int dx;
        for (int i = 0; i < 7; i++) {
            for (int x = 0 ;  x < 800; x += 50){
                if(i % 2 == 0){
                    dx = 25;
                }else {
                    dx = 0;
                }
                spheres.add(new Sphere(7,x + dx,y,true));
            }
            y += 50;
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        int w =getWidth();
        int h = getHeight();
        int d = 10;


        for(int i = 0 ; i < spheres.size() ; i ++ ){
            for(int j = 0 ; j < i ; j ++ ){
                sameCoordinates(spheres.get(i), spheres.get(j));
                Calculate(spheres.get(i), spheres.get(j));
            }
            if(!spheres.get(i).isFixed){
                border(spheres.get(i));
            }
//            spheres.get(i).draw(g);

            switch (i % 3){
                case 0 -> g.setColor(Color.RED);
                case 1 -> g.setColor(Color.GREEN);
                case 2 -> g.setColor(Color.BLUE);
            }

            spheres.get(i).fill(g);
            spheres.get(i).fall();
        }
        sleep();
    }

    private void sameCoordinates(Sphere s1 , Sphere s2){
        if(s1.x == s2.x && s1.y == s2.y){
            s1.x += Math.random() * randomNegative();
            s1.y += Math.random() * randomNegative();
        }
    }

    private int randomNegative(){
        return R.nextBoolean() ? -1 : 1;
    }

    private double abs(double a){
        return Math.abs(a);
    }
    private void border(Sphere s){
        if(s.x < 0 + s.r){
            s.x = s.r ;
        }
        if(s.y < 0 + s.r){
            s.y = s.r;
        }
        if(s.x > getWidth()  - s.r  ){
            s.x = getWidth() - s.r ;
        }
        if (s.y > getHeight() - s.r){
            s.y = getHeight() - s.r;
            s.onTheFloor = true;
        }else{
            s.onTheFloor = false;
        }

    }
    public void Calculate(Sphere s1 , Sphere s2){
        double a = abs(abs(s1.x) - abs(s2.x)); //s1とs2のxの距離
        double b = abs(abs(s1.y) - abs(s2.y));
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        double d = s1.r + s2.r;
        double angle = Math.atan(b/a);

        double dx = 1.3d;

        if(c <= d){
//            Log.write(s1 +","+ s2 + "covered , s1: (" + s1.cx + "," + s1.cy + "), s2: (" + s2.cx + "," + s2.cy + ")");
            s1.move(angle,dx,(s1.x > s2.x) , (s1.y > s2.y));
            s2.move(angle,dx,(s1.x < s2.x) , (s1.y < s2.y));
        }
        repaint();
    }

    public void sleep() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                Core.spheres.clear();
                System.out.println("Space");
            }
        }
    }
}
