package i9Life.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import i9Life.controller.AdministradorController;
import i9Life.model.Administrador;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JButton btnCadastrar;
	private JLabel lblImgFundo;
	private JLabel labelLogo;

	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1428, 777);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 51, 255));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(850, 325, 400, 44);
		contentPane.add(textFieldEmail);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		passwordFieldSenha.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		passwordFieldSenha.setBounds(850, 414, 400, 44);
		contentPane.add(passwordFieldSenha);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 51, 204));
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail.setBounds(850, 309, 65, 17);
		contentPane.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(102, 51, 204));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setBounds(850, 399, 65, 17);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Entrar");
		btnLogar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLogar.setBackground(new Color(102, 51, 204));
		btnLogar.setForeground(UIManager.getColor("ComboBox.buttonHighlight"));
		btnLogar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Administrador admAux = AdministradorController.login(textFieldEmail.getText(),
						passwordFieldSenha.getText());

				verificaLogin(admAux);
			}
		});
		btnLogar.setBounds(1144, 492, 106, 44);
		contentPane.add(btnLogar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCadastrar.setForeground(new Color(102, 51, 204));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CadastroView().setVisible(true);
			}
		});
		btnCadastrar.setBounds(1014, 492, 106, 44);
		contentPane.add(btnCadastrar);

		lblImgFundo = new JLabel("");
		lblImgFundo.setIcon(new ImageIcon(LoginView.class.getResource("/images/Login.png")));
		lblImgFundo.setBounds(130, 12, 585, 733);
		contentPane.add(lblImgFundo);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
		labelLogo.setBounds(957, 209, 203, 62);
		contentPane.add(labelLogo);
	}

	public void restaurar() {
		textFieldEmail.setText("");
		passwordFieldSenha.setText("");
	}

	public Administrador verificaLogin(Administrador admAux) {
		if (!(admAux.equals(null))) {
			dispose();

			new HomeAdmView().setVisible(true);

			System.out.println("Logado.");
			return admAux;
		} else {
			restaurar();

			return null;
		}
	}
}
