package com.hush.ravim.projeto.salario.liquido.test;

public class Irrf {
	double faixa1SalarioIrrf = 0, 
			   faixa2SalarioIrrf = 0, faixa2DeducaoIrrf = 0, faixa2AliquotaIrrf = 0,
			   faixa3SalarioIrrf = 0, faixa3DeducaoIrrf = 0, faixa3AliquotaIrrf = 0,
			   faixa4SalarioIrrf = 0, faixa4DeducaoIrrf = 0, faixa4AliquotaIrrf = 0,
			   faixa5DeducaoIrrf = 0, faixa5AliquotaIrrf = 0;
			      
		public Irrf() {
			super();
		}
		public Irrf(double faixa1SalarioIrrf, double faixa2SalarioIrrf, double faixa2DeducaoIrrf, double faixa2AliquotaIrrf,
				double faixa3SalarioIrrf, double faixa3DeducaoIrrf, double faixa3AliquotaIrrf, double faixa4SalarioIrrf,
				double faixa4DeducaoIrrf, double faixa4AliquotaIrrf, double faixa5DeducaoIrrf, double faixa5AliquotaIrrf) {
			super();
			this.faixa1SalarioIrrf = faixa1SalarioIrrf;
			this.faixa2SalarioIrrf = faixa2SalarioIrrf;
			this.faixa2DeducaoIrrf = faixa2DeducaoIrrf;
			this.faixa2AliquotaIrrf = faixa2AliquotaIrrf;
			this.faixa3SalarioIrrf = faixa3SalarioIrrf;
			this.faixa3DeducaoIrrf = faixa3DeducaoIrrf;
			this.faixa3AliquotaIrrf = faixa3AliquotaIrrf;
			this.faixa4SalarioIrrf = faixa4SalarioIrrf;
			this.faixa4DeducaoIrrf = faixa4DeducaoIrrf;
			this.faixa4AliquotaIrrf = faixa4AliquotaIrrf;
			this.faixa5DeducaoIrrf = faixa5DeducaoIrrf;
			this.faixa5AliquotaIrrf = faixa5AliquotaIrrf;
		}
		
		public double baseCalculoIrrf(double salarioBruto, double calculoInss) {
			double baseCalculo = salarioBruto - calculoInss;
			return baseCalculo; 
		}
		
		public double irrf(double baseCalculo, double irAliquota, double deduzirIr) {
			double irrfTotal = baseCalculo * (irAliquota/100) - deduzirIr;
			return irrfTotal;
		} 
}
