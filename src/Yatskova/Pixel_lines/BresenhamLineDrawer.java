package Yatskova.Pixel_lines;

import Yatskova.LineDrawer;
import Yatskova.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            int x = x1;
            int y = y1;
            if (x <= x2) {
                if (y <= y2) {
                    while (x <= x2 && y <= y2) {
                        pd.drawPixel(x, y, Color.BLACK);
                        if ((x + 1 - x1) * dy - (y + 0.5 - y1) * dx >= 0) {
                            y += 1;
                        }
                        x += 1;
                    }
                } else {
                    while (x <= x2 && y >= y2) {
                        pd.drawPixel(x, y, Color.BLACK);
                        if ((x + 1 - x1) * dy - (y - 0.5 - y1) * dx <= 0) {
                            y -= 1;
                        }
                        x += 1;
                    }
                }
            } else {
                if (y <= y2) {
                    while (x >= x2 && y <= y2) {
                        pd.drawPixel(x, y, Color.BLACK);
                        if ((x + 1 - x1) * dy - (y + 0.5 - y1) * dx <= 0) {
                            y += 1;
                        }
                        x -= 1;
                    }
                } else {
                    while (x >= x2 && y >= y2) {
                        pd.drawPixel(x, y, Color.BLACK);
                        if ((x + 1 - x1) * dy - (y - 0.5 - y1) * dx >= 0) {
                            y -= 1;
                        }
                        x -= 1;
                    }
                }
            }
        } else {
            int x = x1;
            int y = y1;
            if (x <= x2) {
                if (y <= y2) {
                    while (x <= x2 && y <= y2) {
                        pd.drawPixel(x, y, Color.GREEN);
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx <= 0) {
                            x += 1;
                        }
                        y += 1;
                    }
                } else {
                    while (x <= x2 && y >= y2) {
                        pd.drawPixel(x, y, Color.GREEN);
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx >= 0) {
                            x += 1;
                        }
                        y -= 1;
                    }
                }
            } else {
                if (y <= y2) {
                    while (x >= x2 && y <= y2) {
                        pd.drawPixel(x, y, Color.GREEN);
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx >= 0) {
                            x -= 1;
                        }
                        y += 1;
                    }
                } else {
                    while (x >= x2 && y >= y2) {
                        pd.drawPixel(x, y, Color.GREEN);
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx <= 0) {
                            x -= 1;
                        }
                        y -= 1;
                    }
                }
            }
        }
    }
}
