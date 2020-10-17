package Yatskova;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    private Graphics gr;

    public GraphicsLineDrawer(Graphics gr) {
        this.gr = gr;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        gr.drawLine(x1, y1, x2, y2);
    }
}
