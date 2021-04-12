package programadeincentivo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Funcionarios {
	private String nome;
	private String cargo;
	private String admissao;
	private double salario;
	private int pontuacao = 0;
	public String bonificacao;

	public Funcionarios(String cargo, double salario) {
		this.cargo = cargo;
		this.salario = salario;
	}

	public int avaliar() {
		String[] habilidades = { "\n1-Responsabilidade Pessoal", "\n2-Mentalidade de Crescimento", "\n3-Orienta��o ao futuro",
				"\n4-Persistencia", "\n5-Comunica��o", "\n6-Trabalho em equipe", "\n7-Aten��o aos Detalhes", "\n8-Proatividade",
				"\n9-Profissionalismo", "\n10-Precis�o T�cnica" };
		int op;
		pontuacao = 0;
		int x;
		Scanner leia = new Scanner(System.in);

		System.out.println("Avalia�ao do Funcion�rio " + getNome());

		for (x = 0; x < 10; x++) {
			System.out.println("Para a Habilidade " + habilidades[x]);
			System.out.println(
					"Digite a op��o desejada:\n1 - Iniciante\n2 - Em desenvolvimento\n3 - Proficiente\n4 - Avan�ado");
			op = leia.nextInt();

			if (op == 1) {
				pontuacao = pontuacao + 1;
			} else if (op == 2) {
				pontuacao = pontuacao + 2;
			} else if (op == 3) {
				pontuacao = pontuacao + 3;
			} else if (op == 4) {
				pontuacao = pontuacao + 4;
			} else {
				System.out.println("Op��o inv�lida");
			}
			System.out.println("\nO pontua��o atual: "+pontuacao);
			System.out.println("                                        ");
		}

		return pontuacao;
	}

	public void ImprimirInfo() {
		System.out.println("                                                                                       ");
		System.out.println("***************************************************************************************");
		System.out
				.println("Dados do funcion�rio \nNome: " + getNome() + "\nCargo: " + getCargo() + "\nData de admiss�o: "
						+ getAdmissao() + "\nSal�rio: " + getSalario() + "\nPontua��o total: " + pontuacao);
		System.out.println("                                                                                       ");
		System.out.println("***************************************************************************************");
		
	}
	public void ImprimirInfoBonificada() {
		System.out.println("                                                                                       ");
		System.out.println("*********************************BONIFICA��O*******************************************");
		System.out.println("Dados do funcion�rio \nNome: "+getNome()+"\nCargo: "+getCargo()+"\nData de admiss�o: "+getAdmissao()+
				"\nSal�rio: "+getSalario()+"\nPontua��o total: "+pontuacao+"\nBonifica��o: "+bonificacao());
		System.out.println("                                                                                       ");
		System.out.println("***************************************************************************************");
	}
	
	public String bonificacao() {
	
		if (pontuacao>=30 && pontuacao<=33 ) {
			String bonificacao = "Parabens! "+getNome()+" ganhou um aumento salarial de 2%, Kit Home Office e um curso de especializa��o";
			this.salario = this.salario*1.02;	
		}		
		else if (pontuacao>=34 && pontuacao<=36 ) {
			bonificacao = "Parabens! "+getNome()+" ganhou um aumento salarial de 5%, bonifica��o e um curso de especializa��o";
			this.salario = this.salario*1.05;	
		}
		else if (pontuacao>=37 && pontuacao<=39 ) {
			bonificacao = "Parabens! "+getNome()+" ganhou um aumento salarial de 7%, jantar exclusivo e uma viagem nacional";
			this.salario = this.salario*1.05;
		}
		else if (pontuacao==40 && getTempoTrabalhoMeses()>=6) {
			bonificacao = "Parabens! "+getNome()+" foi promovido, ganhou um aumento salarial de 10%, jantar exclusivo e um intercambio corporativo";
			this.salario = this.salario*1.10;
		}
		else if (pontuacao==40) {
			bonificacao = "Parabens! "+getNome()+" ganhou um aumento salarial de 10%, jantar exclusivo e um intercambio corporativo";
			this.salario = this.salario*1.10;
		}
		else  {
			bonificacao = "Funcion�rio "+getNome()+" n�o atingiu a m�dia de pontua��o";
				
		}
		return bonificacao;
		
	}
	/*public String SalarioBonificado() {
		
		if (pontuacao>=30 && pontuacao<=33 ) {
			
		}		
		else if (pontuacao>=34 && pontuacao<=36 ) {
			
			this.salario = this.salario*1.05;	
		}
		else if (pontuacao>=37 && pontuacao<=39 ) {
			
			this.salario = this.salario*1.05;
		}
		else if (pontuacao==40 && getTempoTrabalhoMeses()>=6) {
			
			this.salario = this.salario*1.10;
		}
		else if (pontuacao==40) {
			
			this.salario = this.salario*1.10;
		}
		else  {
			
				
		}
		return bonificacao;
		
	}
	*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAdmissao() {
		return this.admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getSalario() {

		Locale localBrasil = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(localBrasil).format(this.salario);

	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public long getTempoTrabalhoMeses() {
		long mesesTempoTrabalho = 0;
		long diasTempoTrabalho = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		try {
			Date date1 = myFormat.parse(admissao);
			Date date2 = myFormat.parse(dataAtual);
			long diff = date2.getTime() - date1.getTime();

			diasTempoTrabalho = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			mesesTempoTrabalho = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 30;
			// System.out.println("Dias de trabalho: "+diasTempoTrabalho);
			// System.out.println("Meses:"+mesesTempoTrabalho);
      
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return mesesTempoTrabalho;
	}

}
