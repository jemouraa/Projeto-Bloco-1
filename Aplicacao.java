package programadeincentivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) {

		DevJunior dev1 = new DevJunior();
		DevPleno dev2 = new DevPleno();
		DevSenior dev3 = new DevSenior();

		dev1.setNome("Daniel");
		dev1.setAdmissao("11/10/2020");
		dev1.setSalario(3000.75);
		
		dev2.setNome("Maria");
		dev2.setAdmissao("11/10/2020");
		dev2.setSalario(4000.75);
		
		dev3.setNome("Leo");
		dev3.setAdmissao("11/10/2020");
		dev3.setSalario(4000.75);

		List<Funcionarios> lista = new ArrayList<Funcionarios>();
		lista.add(dev1);
		lista.add(dev2);
		lista.add(dev3);
		for (Funcionarios dev : lista) {
			
			dev.ImprimirInfo();
			dev.avaliar();
			dev.ImprimirInfoBonificada();
		}
		

	}

}
