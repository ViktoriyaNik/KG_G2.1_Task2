package Yatskova;

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
        gr.setColor(Color.BLUE);
        gr.fillRect(0, 0, 800, 600);
        gr.setColor(Color.CYAN);
        LineDrawer ld = new GraphicsLineDrawer(gr);
        drawAll(ld);
        g.drawImage(bufferedImage, 0, 0, null);
        gr.dispose();
    }

    public void drawAll(LineDrawer ld) {
        drawSnowFlake(ld, 200, 300, 150, 8);
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

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        position = new Point(mouseEvent.getX(), mouseEvent.getY());
        repaint();
    }
}
