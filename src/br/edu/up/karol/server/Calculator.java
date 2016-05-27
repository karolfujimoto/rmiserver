/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.karol.server;

import br.edu.up.karolfujimoto.remotecalculator.LocalCalculator;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karol
 */
public class Calculator extends UnicastRemoteObject implements InterfaceCalculator {
    
    private double init, end, nThreads;
    
    public Calculator() throws RemoteException {
        super();
    }
    @Override
    public double calculate(int init, int end, int nThreads) throws RemoteException {
        int step;
        LocalCalculator lc = new LocalCalculator();
        Thread t;
        
        this.init = init;
        this.end = end;
        this.nThreads = nThreads;
        step = (end-init)/nThreads;
        
        for(int i = init; i <= end;i+=step) {
            lc = new LocalCalculator(i,i+step);
            t = new Thread(lc);
            t.start();
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lc.getResult();
    }
    
}
