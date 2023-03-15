package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < 1039){
			return 0;
		}
		double valorDescontoINSS = calcularDescontoINSS(salarioBase);
		double valorDescontoIRRF = calcularDescontoIRRF(salarioBase - valorDescontoINSS);
		double valorFinal = salarioBase - valorDescontoINSS - valorDescontoIRRF;
		return (int) Math.round(valorFinal);
	}


	private static double calcularDescontoINSS(double salarioBase){
		double porcentagemDesconto;
		if (salarioBase > 4000){
			porcentagemDesconto= 0.11;
		}else if(salarioBase <= 4000 && salarioBase > 1500){
			porcentagemDesconto= 0.09;
		}else{
			porcentagemDesconto= 0.08;
		}
		return salarioBase * porcentagemDesconto;
	}
	private static double calcularDescontoIRRF(double salarioBase){
		double porcentagemDesconto;
		if (salarioBase > 6000){
			porcentagemDesconto= 0.15;
		}else if(salarioBase <= 6000 && salarioBase > 3000){
			porcentagemDesconto= 0.075;
		}else{
			porcentagemDesconto= 0.00;
		}
		return salarioBase * porcentagemDesconto;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/