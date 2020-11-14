package stl.algav567.support.gui;


import stl.algav567.support.algorithms.Algorithms;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class DiamRace {
    private static int width = 0;
    private static int height = 0;
    private static String title = "Diameter Racer";
    private static String filename = "input.points";
    private static FramedDiamRace framedGUI;

    public DiamRace() {
    }

    public void launch(final String[] args, final Algorithms algorithms) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DiamRace.framedGUI = new FramedDiamRace(DiamRace.width, DiamRace.height, DiamRace.title, algorithms);
            }
        });
        synchronized(Variables.lock) {
            try {
                Variables.lock.wait();
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }
        }

        readFile();
    }


    public static void readFile() {
        ArrayList points = new ArrayList();

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            try {
                String line;
                while((line = input.readLine()) != null) {
                    String[] coordinates = line.split("\\s+");
                    points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
                }

                framedGUI.drawPoints(points);
                synchronized(Variables.lock2) {
                    Variables.lock2.notify();
                }
            } catch (IOException var16) {
                System.err.println("Exception: interrupted I/O.");
            } finally {
                try {
                    input.close();
                } catch (IOException var14) {
                    System.err.println("I/O exception: unable to close " + filename);
                }

            }
        } catch (FileNotFoundException var18) {
            System.err.println("Input file not found.");
        }

    }
}
