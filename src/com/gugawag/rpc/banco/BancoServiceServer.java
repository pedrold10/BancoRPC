package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> contas;
    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public String listarContas() throws RemoteException{
        String contas = "";
        for(Double conta : saldoContas.values()){
            contas+="\nSaldo da conta: " + conta+"\n";
        }
        return contas;
    }

    @Override 
    public void adicionarConta(String numero, double saldo) throws RemoteException{
        contas.add(new Conta(numero, saldo));
    }
    

}
