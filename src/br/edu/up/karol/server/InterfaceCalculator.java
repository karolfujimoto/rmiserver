/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.karol.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author karol
 */
public interface InterfaceCalculator extends Remote  {
    public double calculate(int init, int end, int nThreads) throws RemoteException;
}
