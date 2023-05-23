package com.hush.ravim.projeto.salario.liquido.test;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Qual é o seu salario bruto?\n");
	int vd = 0;
	double salarioBruto = 0, salarioLiquido = 0, inssAliquota = 0, inssBase = 0, irAliquota = 0, deduzirIR = 0, irFinal = 0;
	salarioBruto = scan.nextDouble();
	
	double valorDevido[] = {90.9, 109.38, 145.64, 482.47};
	Inss tbInss2022 = new Inss(1212.00, 7.5, 2427.35, 9.0, 1212.01, 3641.03, 12.0, 2427.36, 7087.22, 14.0, 3641.04);
	
	if(salarioBruto <= tbInss2022.faixa1InssSalario) {
		inssAliquota = tbInss2022.faixa1InssAliquota;
		vd = 0;
	} else if(salarioBruto <= tbInss2022.faixa2InssSalario) {
		inssAliquota = tbInss2022.faixa2InssAliquota;
		inssBase = tbInss2022.faixa2InssBase;
		vd = 1;
	} else if(salarioBruto <= tbInss2022.faixa3InssSalario) {
		inssAliquota = tbInss2022.faixa3InssAliquota;
		inssBase = tbInss2022.faixa3InssBase;
		vd = 2;
	} else if(salarioBruto <= tbInss2022.faixa4InssSalario) {
		inssAliquota = tbInss2022.faixa4InssAliquota;
		inssBase = tbInss2022.faixa4InssBase;
		vd = 3;
	} else {
		vd = 4; 
	} 
	scan.close();		
	double catchVD = 0;		
	for(int i = 0; i < vd; i++) {
		catchVD += valorDevido[i];
	}
	
	double calculoINSS = tbInss2022.calculoINSS(salarioBruto, inssBase, inssAliquota, catchVD); 
	System.out.printf("%s %.2f\n","INSS Total: ", calculoINSS);
	
	Irrf irrfTable2022 = new Irrf(2075, 2826.65, 142.8, 7.5, 3751, 354.8, 15, 4664.68, 636.13, 22.5, 869.36, 27.5);
	
	double baseDeCalIRRF = irrfTable2022.baseCalculoIrrf(salarioBruto, calculoINSS);
	System.out.printf("%s %.2f\n","Base de Calculo: ", baseDeCalIRRF);
	
	if(salarioBruto <= irrfTable2022.faixa1SalarioIrrf) {			
		System.out.println("IRRF Isento: R$ 0");
	} else if (salarioBruto <= irrfTable2022.faixa2SalarioIrrf) { 
		deduzirIR = irrfTable2022.faixa2DeducaoIrrf; irAliquota = irrfTable2022.faixa2AliquotaIrrf; 
		irFinal = irrfTable2022.irrf(baseDeCalIRRF, irAliquota, deduzirIR); salarioLiquido = salarioBruto - (irFinal + calculoINSS);
		System.out.printf("%s %.2f\n","IRRF final:", irFinal);
		System.out.printf("%s %.2f\n","Seu salário final é de:", salarioLiquido); 
	} else if (salarioBruto <= irrfTable2022.faixa3SalarioIrrf) {
		deduzirIR = irrfTable2022.faixa3DeducaoIrrf; irAliquota = irrfTable2022.faixa3AliquotaIrrf;
		irFinal = irrfTable2022.irrf(baseDeCalIRRF, irAliquota, deduzirIR); salarioLiquido = salarioBruto - (irFinal + calculoINSS);
		System.out.printf("%s %.2f\n","IRRF final:",irFinal);
		System.out.printf("%s %.2f\n","Seu salário final é de:", salarioLiquido); 
	} else if (salarioBruto <= irrfTable2022.faixa4SalarioIrrf) {
		deduzirIR = irrfTable2022.faixa4DeducaoIrrf; irAliquota = irrfTable2022.faixa4AliquotaIrrf;
		irFinal = irrfTable2022.irrf(baseDeCalIRRF, irAliquota, deduzirIR); salarioLiquido = salarioBruto - (irFinal + calculoINSS);
		System.out.printf("%s %.2f\n","IRRF final:",irFinal);
		System.out.printf("%s %.2f\n","Seu salário final é de:", salarioLiquido);
	} else { 
		deduzirIR = irrfTable2022.faixa5DeducaoIrrf; irAliquota = irrfTable2022.faixa5AliquotaIrrf;
		irFinal = irrfTable2022.irrf(baseDeCalIRRF, irAliquota, deduzirIR); salarioLiquido = salarioBruto - (irFinal + calculoINSS);
		System.out.printf("%s %.2f\n","IRRF final: ",irFinal);			
		System.out.printf("%s %.2f\n","Seu salário final é de:", salarioLiquido);
	}		
	
	}//main 	
}  
	