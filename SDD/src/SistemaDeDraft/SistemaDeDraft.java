/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeDraft;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaspe
 */
public class SistemaDeDraft {
    
    /**
     * @param args the command line arguments
     */   
    
    public static void main(String[] args) throws IOException {
        InterfaceSE ISE = new InterfaceSE();
        ISE.Interface();
    }
    
}
