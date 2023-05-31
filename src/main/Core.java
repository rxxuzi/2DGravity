package main;
import javax.swing.*;
import java.awt.*;
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

//        spheres.add(new Sphere(50,400,400));
//        spheres.add(new Sphere(50,401,403));
//        spheres.add(new Sphere(50,402,402));
        System.out.println(spheres.size());

//        spheres.add(new Sphere(30,400,300,true));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.WHITE);


        for(int i = 0 ; i < spheres.size() ; i ++ ){
            for(int j = 0 ; j < i ; j ++ ){
                sameCoordinates(spheres.get(i), spheres.get(j));
                Calculate(spheres.get(i), spheres.get(j));
            }

            border(spheres.get(i));
            spheres.get(i).draw(g);

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
        if(s.x < 0 ){
            s.x = 0;
        }
        if(s.y < 0 ){
            s.y = 0;
        }
        if(s.x > getWidth() - s.r*2 ){
            s.x = getWidth() - s.r*2;
        }
        if (s.y > getHeight() - s.r*2){
            s.y = getHeight() - s.r*2;
            s.onTheFloor = true;
        }else{
            s.onTheFloor = false;
        }

    }
    public void Calculate(Sphere s1 , Sphere s2){
        double a = abs(abs(s1.x) - abs(s2.x));
        double b = abs(abs(s1.y) - abs(s2.y));
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        double d = s1.r + s2.r;
        double angle = Math.atan(b/a);

        double dx = 1.5d;

        if(c <= d){
//            Log.write(s1 +","+ s2 + "covered , s1: (" + s1.cx + "," + s1.cy + "), s2: (" + s2.cx + "," + s2.cy + ")");
            s1.move(angle,dx,(s1.x > s2.x) , (s1.y > s2.y));
            s2.move(angle,dx,(s1.x < s2.x) , (s1.y < s2.y));
        }
        repaint();
    }

    public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
