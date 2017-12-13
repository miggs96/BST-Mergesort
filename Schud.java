/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.snsp1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Miguel & Jordi
 */
public class Schud {

    public static <Student> void schudden(Student[] waardes) {
        List<Student> waardesAlsLijst = Arrays.asList(waardes);
        Collections.shuffle(waardesAlsLijst);
        waardesAlsLijst.toArray(waardes); 
    }
}
