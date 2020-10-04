package Yatskova;

import Yatskova.Pixel_lines.BresenhamLineDrawer;
import Yatskova.Pixel_lines.DDALineDrawer;
import Yatskova.Pixel_lines.WyLineDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point2D position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics gr = bufferedImage.getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, 800, 600);
        gr.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(gr);
        LineDrawer ld = new DDALineDrawer(pd);
        LineDrawer bld = new BresenhamLineDrawer(pd);
        LineDrawer wyld = new WyLineDrawer(pd);
        drawAll(ld, bld, wyld);
        g.drawImage(bufferedImage, 0, 0, null);
        gr.dispose();
    }

    public void drawAll(LineDrawer ld, LineDrawer bld, LineDrawer wyld) {
        drawSnowFlake(ld, 200, 300, 100, 28);
        drawSnowFlake2(bld, 350,200, 100, 28);
        drawSnowFlake3(wyld, 600,300, 100, 28);
        ld.drawLine(getWidth() / 2, getHeight() / 2, (int) position.getX(), (int) position.getY());
    }

    public void drawSnowFlake(LineDrawer ld, int x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = da * i;
            double dx = r * Math.cos(a);
            double dy = r * Math.sin(a);
            ld.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    public void drawSnowFlake2(LineDrawer bld, int x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = da * i;
            double dx = r * Math.cos(a);
            double dy = r * Math.sin(a);
            bld.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    public void drawSnowFlake3(LineDrawer wyld, int x, int y, int r, int n){
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = da * i;
            double dx = r * Math.cos(a);
            double dy = r * Math.sin(a);
            wyld.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        position = new Point(mouseEvent.getX(), mouseEvent.getY());
        repaint();
    }
}
