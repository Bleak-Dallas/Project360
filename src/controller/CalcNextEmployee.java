/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


public class CalcNextEmployee {
    
    public int greaterSeniority(int a, int b, int c, int d) {

        int tempA;
        int tempB;
        int senior;
        if ( a < b) { 
            tempA = a;
        } else {
            tempA = b;
        }
        if (c < d) {
            tempB = c;
       } else {
            tempB = d;
       }
       if (tempA < tempB) {
           senior = tempA;
       } else {
           senior = tempB;
       }
       
        System.out.println("Senior = " + senior);
       return senior;
    }  
    
    public int mostVolunteered(int a, int b, int c, int d) {
        
        int tempA;
        int tempB;
        int mostVolunteered;
        if ( a > b) { 
            tempA = a;
        } else {
            tempA = b;
        }
        if (c > d) {
            tempB = c;
       } else {
            tempB = d;
       }
       if (tempA > tempB) {
           mostVolunteered = tempA;
       } else {
           mostVolunteered = tempB;
       }
       
        System.out.println("Most Volunteered = " + mostVolunteered);
       return mostVolunteered;        
    }
    
}
