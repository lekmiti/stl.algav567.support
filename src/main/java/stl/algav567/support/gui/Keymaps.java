package stl.algav567.support.gui;



import stl.algav567.support.algorithms.Algorithms;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Keymaps implements KeyListener {
    private RootPanel rootPanel;
    private int nbPoints;
    private Algorithms algorithms;

    public Keymaps(RootPanel rootPanel, int nbPoints, Algorithms algorithms) {
        this.rootPanel = rootPanel;
        this.nbPoints = nbPoints;
        this.algorithms = algorithms;
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent event) {
        Line l;
        long t;
        switch(event.getKeyChar()) {
            case 'c':
                t = System.currentTimeMillis();
                Circle c = algorithms.calculCercleMin(this.rootPanel.getPoints());
                t = System.currentTimeMillis() - t;
                c.setColor(Color.RED);
                this.rootPanel.addCircleAndT(c, t);
                break;
            case 'd':
                t = System.currentTimeMillis();
                l = algorithms.calculDiametre(this.rootPanel.getPoints());
                t = System.currentTimeMillis() - t;
                l.setColor(Color.RED);
                this.rootPanel.addLineAndT(l, t);
                break;
            case 'e':
                try {
                    t = System.currentTimeMillis();
                    List<Point> env = algorithms.enveloppeConvexe(this.rootPanel.getPoints());
                    t = System.currentTimeMillis() - t;
                    this.rootPanel.addPolygoneAndT(env, t);
                    break;
                } catch (Exception var9) {
                }
            case 'r':
                try {
                    RandomPointsGenerator.generate(this.nbPoints);
                    DiamRace.readFile();
                    this.rootPanel.refreshLine();
                } catch (Exception var8) {
                }
            case 'f':
            case 'g':
            case 'i':
            case 'm':
            case 'n':
            case 'p':
            case 'q':
            default:
                break;
            case 'h':
                this.rootPanel.shiftLeftAll();
                break;
            case 'j':
                this.rootPanel.shiftUpAll();
                break;
            case 'k':
                this.rootPanel.shiftDownAll();
                break;
            case 'l':
                this.rootPanel.shiftRightAll();
                break;
            case 'o':
                t = System.currentTimeMillis();
                l = algorithms.calculDiametreOptimise(this.rootPanel.getPoints());
                t = System.currentTimeMillis() - t;
                l.setColor(Color.GREEN);
                this.rootPanel.addLineAndT(l, t);
        }

    }
}
