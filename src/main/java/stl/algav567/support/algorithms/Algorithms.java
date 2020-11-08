package stl.algav567.support.algorithms;


import edu.lip6.stl.algav567.supportGUI.Circle;
import edu.lip6.stl.algav567.supportGUI.Line;

import java.awt.*;
import java.util.List;

public interface Algorithms {

    Line calculDiametre(List<Point> points);

    Circle calculCercleMin(List<Point> points);
}
