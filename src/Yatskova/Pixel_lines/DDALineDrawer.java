package Yatskova.Pixel_lines;

import Yatskova.LineDrawer;
import Yatskova.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            if (x1 > x2) {
                int x = x1;
                x1 = x2;
                x2 = x;
                int y = y1;
                y1 = y2;
                y2 = y;
            }
            double k = dy / dx;
            for (int j = x1; j < x2; j++) {
                double i = k * (j - x1) + y1;
                pd.drawPixel(j, (int) i, Color.red);
            }
        } else {
            if (y1 > y2) {
                int x = x1;
                x1 = x2;
                x2 = x;
                int y = y1;
                y1 = y2;
                y2 = y;
            }
            double kobr = dx / dy;
            for (int i = y1; i < y2; i++) {
                double j = kobr * (i - y1) + x1;
                pd.drawPixel((int) j, i, Color.blue);
            }
        }
    }
}
