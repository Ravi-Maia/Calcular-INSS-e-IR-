package com.hush.ravim.projeto.salario.liquido.test;

import java.util.Scanner;
public class MainClass {
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);	
			System.out.println("Qual é o seu salario bruto?\n");
			
			int vd = 0;
			double salario = 0, inssAliquota = 0, inssBase = 0, irAliquota = 0, deduzirIR = 0, irFinal = 0;
			salario = scan.nextDouble();
			System.out.println("Sálario bruto: " + salario);
			double valorDevido[] = {90.9, 109.38, 145.64, 482.47};
			double tabelaINSS[][] = {{1212.00, 7.5}, {2427.35, 9.0, 1212.01}, {3641.03, 12.0, 2427.36}, {7087.22, 14.0, 3641.04}};
			
			if(salario <= tabelaINSS[0][0]) {inssAliquota = tabelaINSS[0][1]; vd = 0;
			} else if(salario <= tabelaINSS[1][0]) {inssAliquota = tabelaINSS[1][1]; inssBase = tabelaINSS[1][2]; vd = 1;
			} else if(salario <= tabelaINSS[2][0]) {inssAliquota = tabelaINSS[2][1]; inssBase = tabelaINSS[2][2]; vd = 2;
			} else if(salario <= tabelaINSS[3][0]) {inssAliquota = tabelaINSS[3][1]; inssBase = tabelaINSS[3][2]; vd = 3;
			} else {
				vd = 4; 
			} 
			scan.close();		 	
			double catchVD = 0;			
			for(int i = 0; i < vd; i++) {
				catchVD += valorDevido[i];
			}
			double inssTotal = (salario - inssBase) * (inssAliquota/100) + catchVD;
			System.out.printf("%s %.2f\n","Cálculo INSS:", inssTotal);
			double baseDeCalIRRF = salario - inssTotal;
			System.out.printf("%s %.2f\n","Base de Calculo:", baseDeCalIRRF);

			double tabelaIFFR[][] = {{2075}, {2826.65, 142.8, 7.5}, {3751.0, 354.8, 15}, {4664.68, 636.13, 22.5}, {869.36, 27.5}};
			
			if(salario <= tabelaIFFR[0][0]) {	 		
				System.out.println("IRRF Isento: R$ 0");
				
			} else if (salario <= tabelaIFFR[1][0]) {deduzirIR = tabelaIFFR[1][1]; irAliquota = tabelaIFFR[1][2]; irFinal = ((baseDeCalIRRF * (irAliquota/100) - deduzirIR));
				System.out.printf("%s %.2f\n","IRRF:",irFinal);
				System.out.printf("%s %.2f\n","Salário liquido:", (salario - (irFinal + inssTotal)));
				
			} else if (salario <= tabelaIFFR[2][0]) {deduzirIR = tabelaIFFR[2][1]; irAliquota = tabelaIFFR[2][2]; irFinal = ((baseDeCalIRRF * (irAliquota/100) - deduzirIR));
				System.out.printf("%s %.2f\n","IRRF:",irFinal);
				System.out.printf("%s %.2f\n","Salário liquido:", (salario - (irFinal + inssTotal)));
				
			} else if (salario <= tabelaIFFR[3][0]) {deduzirIR = tabelaIFFR[3][1]; irAliquota = tabelaIFFR[3][2]; irFinal = ((baseDeCalIRRF * (irAliquota/100) - deduzirIR));
				System.out.printf("%s %.2f\n","IRRF:",irFinal);
				System.out.printf("%s %.2f\n","Salário liquido:", (salario - (irFinal + inssTotal)));
				
			} else {								 deduzirIR = tabelaIFFR[4][0]; irAliquota = tabelaIFFR[4][1]; irFinal = ((baseDeCalIRRF * (irAliquota/100) - deduzirIR));
				System.out.printf("%s %.2f\n","IRRF: ",irFinal);
				System.out.printf("%s %.2f\n","Salário liquido:", (salario - (irFinal + inssTotal)));
			}			   
		}//main  
	}//Class