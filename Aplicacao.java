package programadeincentivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {

		DevJunior dev1 = new DevJunior();
		DevPleno dev2 = new DevPleno();
		DevSenior dev3 = new DevSenior();
		Scanner scan = new Scanner(System.in);

		System.out.println("Entre com o nome do funcionário: ");
		String f1 = scan.nextLine();
		dev1.setNome(f1);
		dev1.setAdmissao("11/10/2020");
		dev1.ImprimirInfo();
		dev1.avaliar();
		
		System.out.println("Entre com o nome do funcionário: ");
		String f2 = scan.nextLine();
		dev2.setNome(f2);
		dev2.setAdmissao("25/03/2018");
		dev2.ImprimirInfo();
		dev2.avaliar();
		
		System.out.println("Entre com o nome do funcionário: ");
		String f3 = scan.nextLine();
		dev3.setNome(f3);
		dev3.setAdmissao("03/07/2019");
		dev3.ImprimirInfo();
		dev3.avaliar();

		List<Funcionarios> lista = new ArrayList<Funcionarios>();
		lista.add(dev1);
		lista.add(dev2);
		lista.add(dev3);
		for (Funcionarios dev : lista) {
			
			dev.ImprimirInfoBonificada();
		}
		
	}

}
