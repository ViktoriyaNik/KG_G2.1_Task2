package Yatskova;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel drawPanel;

    public MainWindow() throws HeadlessException {
        drawPanel = new DrawPanel();
        this.add(drawPanel);
    }
}
