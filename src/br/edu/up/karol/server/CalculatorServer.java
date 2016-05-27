/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.karol.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karol
 */
public class CalculatorServer {
    public CalculatorServer() {
        try {
            InterfaceCalculator c = new Calculator();
            Naming.rebind("rmi://localhost:1099/CalculatorService", c); 
        } catch (RemoteException ex) {
            Logger.getLogger(CalculatorServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CalculatorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new CalculatorServer();
    }
}
