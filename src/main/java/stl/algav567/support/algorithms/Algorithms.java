package stl.algav567.support.algorithms;



import stl.algav567.support.gui.Circle;
import stl.algav567.support.gui.Line;

import java.awt.*;
import java.util.List;

public interface Algorithms {

    Line calculDiametre(List<Point> points);

    Circle calculCercleMin(List<Point> points);
}
