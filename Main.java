/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snsp1;

import java.util.ArrayList;
import org.apache.commons.lang.time.StopWatch;

/**
 *
 * @author Miguel & Jordi
 */
public class Main {

    private static final StopWatch SW = new StopWatch();
    private static final double[] TIMES = new double[5];
    private static int time = 0;
    private static ArrayList res = null;

    public static void main(String[] args) {

        int[] getallen = new int[]{10000, 20000, 40000, 80000, 160000};

        for (int i = 0; i < 1; i++) {
            for (int a : getallen) {
                SW.start();
                creeerStudent(a);
            }
        }
        for (int i = 0; i < TIMES.length; i++) {
            System.out.println(TIMES[i]);
        }
    }

    public static void creeerStudent(int aantalStudenten) {

        int laatsteStudentnummer = 50060000;
        Student[] studenten = new Student[aantalStudenten];
        double range = (10.0 - 1.0);

        for (int i = 0; i < aantalStudenten; i++) {

            int studentnummer = ++laatsteStudentnummer;
            double onAfgerond = (double) (Math.random() * range) + 1.0;
            double afgerond = (double) (Math.round(onAfgerond * 10.0) / 10.0);

            Student nieuweStudent = new Student(studentnummer, afgerond);
            studenten[i] = nieuweStudent;
        }
        Schud.schudden(studenten);

        Merge test = new Merge(studenten);
        /*for (Student student : studenten) {
            System.out.println(student.toString());
        }
        /*BST theTree = new BST();

        //Studenten met cijfers aan de BST toevoegen.
        for (Student student : studenten) {
            theTree.put(student.getCijfer(), student.getStudentnummer());
        }

        res = theTree.get(10.0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        
        for (double i = 10; i > 0; i--) {
            System.out.println(i + "  " + theTree.rank(i));
        }*/
        
        //Een stopwatch.
        TIMES[time] = ((double) SW.getTime() / 1000);
        SW.reset();
        time++;
    }
}
