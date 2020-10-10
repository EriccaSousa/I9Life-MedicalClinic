package i9Life.exec;

import java.util.Date;

import i9Life.controller.ClienteController;
import i9Life.controller.ConsultaController;
import i9Life.controller.MedicoController;
import i9Life.controller.ProntuarioController;
import i9Life.model.Cliente;
import i9Life.util.DateUtil;

public class App {

	public static void main(String[] args) {
		// String teste = Criptografia.criptografa("418376");
		// System.out.println(teste);
		// System.out.println(Criptografia.descriptografa(teste));
		// AdministradorController.cadastraAdm(0, "Letícia", "leticia@gmail.com",
		// "12345678");
		// System.out.println(AdministradorController.findAll());
		// System.out.println(AdministradorController.findByNome("Érica"));
		// System.out.println(AdministradorController.findByEmail("erica@gmail.com"));
		// AdministradorController.updateNome("Érica Sousa", "erica@gmail.com");
		// AdministradorController.updateEmail("ericasousa@gmail.com",
		// "erica@gmail.com");
		// AdministradorController.updateSenha("418376em", "ericasousa@gmail.com");
		// AdministradorController.delete("teste@gmail.com");
		// AdministradorController.cadastraAdm(0, "Teste", "teste@gmail.com",
		// "teste123");

		/*
		Date data = (Date) DateUtil.formatData("20/02/1999");

		ClienteController.cadastra(0, "Teste 1", "00000000001", data, "teste1@gmail.com", "observacoes teste 1",
				"Resp Teste 1", "parentesco teste 1", "respteste1@gmail.com", "00000001", "bairro teste 1", "01",
				"complemento teste 1", "cidade teste 1", "01", "000000001");

		
		MedicoController.cadastra(0, "Medico teste", "00000000001", "medicoteste@gmail.com", "00000000000",
				"especialidade");
			
*/
		/*
		 * System.out.println(ClienteController.findByEmail("teste1@gmail.com"));
		 * System.out.println(MedicoController.findByEmail("medicoteste@gmail.com"));
		 * 
		

		
		  Date data = (Date) DateUtil.formatDataHora("20/10/2020 10:30:00");
		  
		  ConsultaController.cadastra(0,
		  MedicoController.findByEmail("medicoteste@gmail.com"),
		  ClienteController.findByEmail("teste1@gmail.com"), data, "observacoes",
		  null);
		  
		*/

		// System.out.println(ConsultaController.findById(1));

		
		 ProntuarioController.cadastra(0, "Obs", "diagnostico",
		  ClienteController.findByEmail("teste1@gmail.com"),
		  MedicoController.findByEmail("medicoteste@gmail.com"),
		  ConsultaController.findById(0));
		  
		  
	}

}
