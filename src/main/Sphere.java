package main;

import java.awt.*;

public class Sphere {
    public double r;
    public double x;
    public double y;
    public double z;
    public double density;
    public double mass;
    public static final double G = 6.67e-11;
    public double cx;
    public double cy;

    public double gx = 0d;
    public double gy = 0d;

    Sphere(double r, double x, double y) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.cx = x + r;
        this.cy = y + r;
    }

    public void calculate(){

    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.drawOval((int) x, (int) y, (int) r*2, (int) r*2);
    }
    public void fill(Graphics g){
        g.fillOval((int) x, (int) y, (int) r*2, (int) r*2);
    }

    public void fall(){
        this.y += 0.9d;
    }

}
