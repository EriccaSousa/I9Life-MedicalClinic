package i9Life.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import i9Life.controller.AdministradorController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class CadastroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JButton btnLimpar;
	private JLabel label;
	private JLabel label_1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroView() {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1428, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setForeground(new Color(102, 51, 255));
		textFieldNome.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNome.setBounds(868, 301, 400, 44);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(new Color(102, 51, 255));
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(868, 386, 400, 44);
		contentPane.add(textFieldEmail);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setForeground(new Color(102, 51, 255));
		passwordFieldSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		passwordFieldSenha.setBounds(868, 475, 400, 44);
		contentPane.add(passwordFieldSenha);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(102, 51, 204));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNome.setBounds(868, 284, 65, 17);
		contentPane.add(lblNome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 51, 204));
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail.setBounds(868, 370, 65, 17);
		contentPane.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(102, 51, 204));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setBounds(868, 460, 65, 17);
		contentPane.add(lblSenha);

		JButton btnCadastrar = new JButton("Finalizar Cadastro");
		btnCadastrar.setBackground(new Color(102, 51, 204));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				AdministradorController.cadastraAdm(textFieldNome.getText(), textFieldEmail.getText(),
						passwordFieldSenha.getText());

				dispose();
				new HomeAdmView().setVisible(true);
				restaurar();
			}
		});
		btnCadastrar.setBounds(1113, 545, 155, 44);
		contentPane.add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar\n");
		btnLimpar.setForeground(new Color(102, 51, 204));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLimpar.setBounds(956, 545, 145, 44);
		contentPane.add(btnLimpar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CadastroView.class.getResource("/images/Login.png")));
		label.setBounds(92, 135, 663, 572);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CadastroView.class.getResource("/images/logo.png")));
		label_1.setBounds(956, 193, 211, 62);
		contentPane.add(label_1);

	}

	public void restaurar() {
		textFieldNome.setText("");
		textFieldEmail.setText("");
		passwordFieldSenha.setText("");
	}
}
