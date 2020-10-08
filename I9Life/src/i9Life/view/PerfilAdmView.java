package i9Life.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PerfilAdmView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFielEmail;
	private JPasswordField passwordFieldSenha;

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PerfilAdmView.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PerfilAdmView.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PerfilAdmView.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PerfilAdmView.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdmView frame = new PerfilAdmView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PerfilAdmView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1428, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1420, 40);
		contentPane.add(menuBar);

		JMenu clientesMenu = new JMenu("Clientes");
		clientesMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(clientesMenu);

		JMenu medicosMenu = new JMenu("Médicos");
		medicosMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(medicosMenu);

		JMenu consultasMenu = new JMenu("Consultas");
		consultasMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(consultasMenu);

		JMenu agendaMenu = new JMenu("Agenda");
		agendaMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(agendaMenu);

		JMenu perfilMenu = new JMenu("Perfil");
		perfilMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		perfilMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(perfilMenu);

		JMenuItem addClienteAction = new JMenuItem("Add novo cliente");
		JMenuItem findClienteAction = new JMenuItem("Pesquisar por clientes");
		JMenuItem addMedicoAction = new JMenuItem("Add novo médico");
		JMenuItem findMedicoAction = new JMenuItem("Pesquisar por médicos");
		JMenuItem addConsultaAction = new JMenuItem("Agendar");
		JMenuItem findConsultaAction = new JMenuItem("Pesquisar por consultas");

		clientesMenu.add(addClienteAction);
		clientesMenu.add(findClienteAction);
		medicosMenu.add(addMedicoAction);
		medicosMenu.add(findMedicoAction);
		consultasMenu.add(addConsultaAction);
		consultasMenu.add(findConsultaAction);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(98, 216, 449, 33);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(98, 202, 55, 15);
		contentPane.add(lblNome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(98, 270, 55, 15);
		contentPane.add(lblEmail);

		textFielEmail = new JTextField();
		textFielEmail.setColumns(10);
		textFielEmail.setBounds(98, 284, 449, 33);
		contentPane.add(textFielEmail);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(99, 361, 449, 33);
		contentPane.add(passwordFieldSenha);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(98, 346, 55, 15);
		contentPane.add(lblSenha);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(451, 439, 98, 25);
		contentPane.add(btnEditar);
	}
}
