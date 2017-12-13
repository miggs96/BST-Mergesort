/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snsp1;

/**
 *
 * @author Miguel & Jordi
 */
public class Student implements Comparable<Student> {

    private int studentnummer;
    private double cijfer;

    /**
     *
     * @param studentnummer
     * @param cijfer
     */
    Student(int studentnummer, double cijfer) {
        this.studentnummer = studentnummer;
        this.cijfer = cijfer;

    }

    /**
     *
     * @return
     */
    public double getCijfer() {
        return this.cijfer;

    }

    /**
     *
     * @param cijfer
     */
    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;

    }

    /**
     *
     * @return
     */
    public int getStudentnummer() {
        return this.studentnummer;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Studentnummer: " + studentnummer + "\t"
                + "Cijfer: " + cijfer;
    }

    @Override
    public int compareTo(Student t) {
        if (cijfer == t.cijfer && studentnummer < t.studentnummer ) {
            return 1;
        } else if (cijfer > t.cijfer) {
            return 1;
        } else {
            return -1;
        }
    }
}
