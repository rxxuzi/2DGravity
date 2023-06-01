package main;

import java.awt.*;

public class Sphere {
    public static final boolean Fall = false;

    public double r;
    public double x;
    public double y;
    public double z;
    public double density;
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
    }

    public void move(double angle , double d , boolean positiveX , boolean positiveY){
        double t = 1;
        if(Fall) t = 2;

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
        g.drawOval((int) x, (int) y, (int) r*2, (int) r*2);
    }
    public void fill(Graphics g){
        if(isFixed) g.setColor(Color.WHITE);
        g.setColor(C);
        g.fillOval((int) x, (int) y, (int) r*2, (int) r*2);
    }

    public void fall(){
        if(Fall) {
            if (!isFixed) {
                if(!onTheFloor) {
                    this.y += 0.9d;
                }
            }
        }
    }

}
