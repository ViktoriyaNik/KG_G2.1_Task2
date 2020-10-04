package Yatskova.Pixel_lines;

import Yatskova.LineDrawer;
import Yatskova.PixelDrawer;

import java.awt.*;

public class WyLineDrawer implements LineDrawer {
    PixelDrawer pd;

    public WyLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double dpx, dpy;
        double k = (double) dy / (double) dx;
        double c = y1 - k * x1;
        if (Math.abs(dx) > Math.abs(dy)) {
            Color color = new Color(225, 220, 10);
            pd.drawPixel(x1, y1, color);
            int x = x1;
            int y = y1;
            if (x <= x2) {
                if (y <= y2) {
                    while (x <= x2 && y <= y2) {
                        dpx = Math.abs(y - (k * (x + 1) + c));
                        dpy = Math.abs(1 - dpx);
                        if (dpx < 1) {
                            pd.drawPixel(x + 1, y, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpy < 1) {
                            pd.drawPixel(x + 1, y + 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 1 - x1) * dy - (y + 0.5 - y1) * dx >= 0) {
                            y += 1;
                        }
                        x += 1;
                    }
                } else {
                    while (x <= x2 && y >= y2) {
                        dpx = Math.abs(y - (k * (x + 1) + c));
                        dpy = Math.abs(1 - dpx);
                        if (dpx < 1) {
                            pd.drawPixel(x + 1, y, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpy < 1) {
                            pd.drawPixel(x + 1, y - 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 1 - x1) * dy - (y - 0.5 - y1) * dx <= 0) {
                            y -= 1;
                        }
                        x += 1;
                    }
                }
            } else {
                if (y <= y2) {
                    while (x >= x2 && y <= y2) {
                        dpx = Math.abs(y - (k * (x + 1) + c));
                        dpy = Math.abs(1 - dpx);
                        if (dpx < 1) {
                            pd.drawPixel(x - 1, y, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpy < 1) {
                            pd.drawPixel(x - 1, y + 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 1 - x1) * dy - (y + 0.5 - y1) * dx <= 0) {
                            y += 1;
                        }
                        x -= 1;
                    }
                } else {
                    while (x >= x2 && y >= y2) {
                        dpx = Math.abs(y - (k * (x + 1) + c));
                        dpy = Math.abs(1 - dpx);
                        if (dpx < 1) {
                            pd.drawPixel(x - 1, y, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpy < 1) {
                            pd.drawPixel(x - 1, y - 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 1 - x1) * dy - (y - 0.5 - y1) * dx >= 0) {
                            y -= 1;
                        }
                        x -= 1;
                    }
                }
            }
        } else {
            Color color = new Color(10, 220, 225);
            pd.drawPixel(x1, y1, color);
            int x = x1;
            int y = y1;
            if (x <= x2) {
                if (y <= y2) {
                    while (x <= x2 && y <= y2) {
                        dpy = Math.abs(x - (y - c) / k);
                        dpx = Math.abs(1 - dpy);
                        if (dpy < 1) {
                            pd.drawPixel(x, y + 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpx < 1) {
                            pd.drawPixel(x + 1, y + 1, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx <= 0) {
                            x += 1;
                        }
                        y += 1;
                    }
                } else {
                    while (x <= x2 && y >= y2) {
                        dpy = Math.abs(x + 0.5 - (y - c) / k);
                        dpx = Math.abs(1 - dpy);
                        if (dpy < 1) {
                            pd.drawPixel(x, y - 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpx < 1) {
                            pd.drawPixel(x + 1, y - 1, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx >= 0) {
                            x += 1;
                        }
                        y -= 1;
                    }
                }
            } else {
                if (y <= y2) {
                    while (x >= x2 && y <= y2) {
                        dpy = Math.abs(x - (y - c) / k);
                        dpx = Math.abs(1 - dpy);
                        if (dpy < 1) {
                            pd.drawPixel(x, y + 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpx < 1) {
                            pd.drawPixel(x - 1, y + 1, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if ((x + 0.5 - x1) * dy - (y + 1 - y1) * dx >= 0) {
                            x -= 1;
                        }
                        y += 1;
                    }
                } else {
                    while (x >= x2 && y >= y2) {
                        dpy = Math.abs(x - (y - c) / k);
                        dpx = Math.abs(1 - dpy);
                        if (dpy < 1) {
                            pd.drawPixel(x, y - 1, new Color((int) (color.getRed() * dpy), (int) (color.getGreen() * dpy), (int) (color.getBlue() * dpy)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
                        if (dpx < 1) {
                            pd.drawPixel(x - 1, y - 1, new Color((int) (color.getRed() * dpx), (int) (color.getGreen() * dpx), (int) (color.getBlue() * dpx)));
                        } else {
                            pd.drawPixel(x, y, color);
                        }
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
