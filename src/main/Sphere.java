package main;

import java.awt.*;

public class Sphere {
    public static final boolean Fall = true;

    public double r;
    public double x;
    public double y;
    public double z;
    public double mass;
    public static final double G = 6.67e-11;
    public boolean isFixed = false;
    public boolean onTheFloor = false;
    public double cx;
    public double cy;

    Color C;

    public double gx = 0d;
    public double gy = 0d;

    Sphere(double r, double x, double y , Color C) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.cx = x + r;
        this.cy = y + r;
        this.C = C;
    }

    Sphere(double r, double x, double y, boolean isFixed) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.isFixed = isFixed;
        this.cx = x + r;
        this.cy = y + r;
        this.z = 0;
        this.mass = (4.0d/3.0d) * Math.PI * Math.pow(r, 3);
    }

    public void move(double angle , double d , boolean positiveX , boolean positiveY){
        double t = 0.1d;
        if(Fall) t = 1.9d; else t = 0.1d;

        if(!isFixed){
            if(positiveX){
                this.x += Math.cos(angle) * d;
            }else{
                this.x -= Math.cos(angle) * d;
            }
            if(positiveY){
                this.y += Math.sin(angle) * d;
            }else {
                this.y -= Math.sin(angle) * d * t;
            }
        }

    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.drawOval((int) (x-r), (int) (y-r), (int) r*2, (int) r*2);
    }
    public void fill(Graphics g){
        if(isFixed) g.setColor(Color.WHITE);
        g.setColor(C);
        g.fillOval((int) (x-r), (int) (y-r), (int) r*2, (int) r*2);
    }

    public void fall(){
        if(Fall) {
            if (!isFixed) {
                if(!onTheFloor) {
                    this.y += 1.0d;
                }
            }
        }
    }

}
