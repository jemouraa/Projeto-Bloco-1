package programadeincentivo;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) {
		
		DevJunior daniel = new DevJunior();
		DevPleno maria = new DevPleno();
		
		daniel.cadastroFuncionario();
		maria.cadastroFuncionario();
		List<Funcionarios> lista = new ArrayList<Funcionarios>();
		lista.add(daniel);
		lista.add(maria);
		
		daniel.ImprimirInfo();
		daniel.avaliar();
	
		maria.ImprimirInfo();
		maria.avaliar();	
			
		for (Funcionarios dev : lista) {
			
			dev.ImprimirInfoBonificada();
		}
	}
}
