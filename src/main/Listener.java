package main;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Listener extends KeyAdapter implements MouseListener, MouseMotionListener {
    Random R = new Random();

    public int mx;
    public int my;
    private static final int rad =  15;
    public static int clickCount = 0;
    private static final int numOfColor = 12;

    private Color set(int r, int g, int b){
        return new Color(r, g, b);
    }

    private Color set(){
        return switch (clickCount % numOfColor){
            case 0 -> new Color(255,30,30);
            case 1 -> new Color(255,125,30);
            case 2 -> new Color(255,255,30);
            case 3 -> new Color(125,255,30);
            case 4 -> new Color(30,255,30);
            case 5 -> new Color(30,255,125);
            case 6 -> new Color(30,255,255);
            case 7 -> new Color(30,125,255);
            case 8 -> new Color(30,30,255);
            case 9 -> new Color(125,30,255);
            case 10 -> new Color(255,30,255);
            case 11 -> new Color(255,30,125);
            default -> new Color(0,0,0);
        };
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        mx = e.getX();
//        my = e.getY();
////        int rad = R.nextInt(30) * 2 + 10;
//        Core.spheres.add(new Sphere(rad, mx - rad, my - rad, set()));
//        clickCount++;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if(e.getButton() == MouseEvent.BUTTON1){
//            int rad = R.nextInt(15) * 2 + 15;
            Core.spheres.add(new Sphere(rad, mx - (rad >> 1), my - (rad >> 1), set()));
            clickCount++;
        } else if (e.getButton() == MouseEvent.BUTTON3){
            for(int i = 0; i < 12; i++){
//                int rad = R.nextInt(15) * 2 + 15;
//                Core.spheres.add(new Sphere(rad, mx - (rad >> 1), my - (rad >> 1), set(20,20,50)));
                Core.spheres.add(new Sphere(rad, mx - (rad >> 1), my - (rad >> 1), set()));
                clickCount++;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
