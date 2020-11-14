package stl.algav567.support.gui;

import stl.algav567.support.algorithms.Algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FramedDiamRace extends JFrame {
    private static final long serialVersionUID = 599149216192397088L;
    protected RootPanel rootPanel;

    public FramedDiamRace(int width, int height, String title, int nbPoints, Algorithms algorithms) {
        super(title);
        this.setDefaultCloseOperation(3);
        this.rootPanel = new RootPanel();
        this.getContentPane().add(this.rootPanel);
        this.addKeyListener(new Keymaps(this.rootPanel, nbPoints, algorithms));
        if (width >= 100 && height >= 100) {
            this.setSize(new Dimension(width, height));
        } else {
            this.pack();
        }

        this.setVisible(true);
        synchronized(Variables.lock) {
            Variables.lock.notify();
        }
    }

    public void drawPoints(List<Point> points) {
        this.rootPanel.drawPoints(points);
    }
}
