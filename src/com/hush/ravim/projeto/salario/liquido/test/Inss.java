package com.hush.ravim.projeto.salario.liquido.test;

public class Inss {
	
	double faixa1InssSalario = 0, faixa1InssAliquota = 0, 
			   faixa2InssSalario = 0, faixa2InssAliquota = 0, faixa2InssBase = 0,
			   faixa3InssSalario = 0, faixa3InssAliquota = 0, faixa3InssBase = 0,
		       faixa4InssSalario = 0, faixa4InssAliquota = 0, faixa4InssBase = 0;
	 	
	public Inss() {
		super();
	}
 
	public Inss(double faixa1Salario, double faixa1Aliquota, double faixa2InssSalario, double faixa2InssAliquota,
			double faixa2InssBase, double faixa3InssSalario, double faixa3InssAliquota, double faixa3InssBase,
			double faixa4InssSalario, double faixa4InssAliquota, double faixa4InssBase) {
		super();
		this.faixa1InssSalario = faixa1Salario;
		this.faixa1InssAliquota = faixa1Aliquota;
		this.faixa2InssSalario = faixa2InssSalario;
		this.faixa2InssAliquota = faixa2InssAliquota;
		this.faixa2InssBase = faixa2InssBase;
		this.faixa3InssSalario = faixa3InssSalario;
		this.faixa3InssAliquota = faixa3InssAliquota;
		this.faixa3InssBase = faixa3InssBase;
		this.faixa4InssSalario = faixa4InssSalario; 
		this.faixa4InssAliquota = faixa4InssAliquota;
		this.faixa4InssBase = faixa4InssBase;		
	}

	public double calculoINSS(double salario, double inssBase, double inssAliquota, double valorDevido) {
		double inssTotal = (salario - inssBase) * (inssAliquota/100) + valorDevido;
		return inssTotal;
	}
}
