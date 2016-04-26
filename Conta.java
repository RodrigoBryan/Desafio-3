package br.unipe.conta;

public class Conta {
	private int id;
	private String numero,titular;
	private double saldo;
	private boolean status;
	public Conta(int id, String numero, double saldo, boolean status, String titular){
		this.id=id;
		this.numero=numero;
		this.saldo=saldo;
		this.status=status;
		this.titular=titular;
	}
	
	public String toString(){
		return "id:"+this.id;
	}
}
