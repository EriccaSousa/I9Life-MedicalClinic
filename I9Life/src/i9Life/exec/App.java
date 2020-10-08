package i9Life.exec;

import java.util.Date;

import i9Life.controller.ClienteController;
import i9Life.controller.MedicoController;
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
		 * Date data = (Date) DateUtil.formatData("20/02/1999");
		 * 
		 * ClienteController.cadastra(0, "Teste 10", "00000000000", data,
		 * "teste10@gmail.com", "observacoes teste 10", "Resp Teste 10",
		 * "parentesco teste 10", "respteste10@gmail.com", "00000000",
		 * "bairro teste 10", "10", "complemento teste 10", "cidade teste 10", "00",
		 * "000000000");
		 */
		MedicoController.cadastra(0, "Medico teste", "00000000001", "medicoteste@gmail.com", "00000000000",
				"especialidade");
	}

}
