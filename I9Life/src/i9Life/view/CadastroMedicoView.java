package i9Life.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import i9Life.controller.MedicoController;

public class CadastroMedicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JButton btnLimpar;
	private JLabel label_1;
	private JTextField textFieldEmail;
	private JTextField textEspecialidade;
	private JTextField textCRM;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMedicoView frame = new CadastroMedicoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroMedicoView() throws ParseException {
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
		textFieldNome.setBounds(967, 163, 400, 44);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textFieldCPF.setForeground(new Color(102, 51, 255));
		textFieldCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(967, 230, 400, 44);
		contentPane.add(textFieldCPF);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(102, 51, 204));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNome.setBounds(967, 146, 65, 17);
		contentPane.add(lblNome);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(new Color(102, 51, 204));
		lblCPF.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCPF.setBounds(967, 214, 65, 17);
		contentPane.add(lblCPF);

		JButton btnCadastrar = new JButton("Finalizar Cadastro");
		btnCadastrar.setBackground(new Color(102, 51, 204));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MedicoController.cadastra(0, textFieldNome.getText(), textFieldCPF.getText(), textFieldEmail.getText(),
						textCRM.getText(), textEspecialidade.getText());

			}
		});
		btnCadastrar.setBounds(1183, 564, 155, 44);
		contentPane.add(btnCadastrar);

		btnLimpar = new JButton("Limpar\n");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restaurar();
			}
		});
		btnLimpar.setForeground(new Color(102, 51, 204));
		btnLimpar.setBackground(Color.WHITE);
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLimpar.setBounds(1026, 564, 145, 44);
		contentPane.add(btnLimpar);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CadastroMedicoView.class.getResource("/images/logo.png")));
		label_1.setBounds(1045, 12, 211, 62);
		contentPane.add(label_1);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setForeground(new Color(102, 51, 204));
		lblEmail_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail_1.setBounds(967, 286, 65, 17);
		contentPane.add(lblEmail_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(new Color(102, 51, 255));
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(967, 302, 400, 44);
		contentPane.add(textFieldEmail);

		JLabel lblInfPessoais = new JLabel("Informações Pessoais:");
		lblInfPessoais.setForeground(new Color(102, 51, 204));
		lblInfPessoais.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfPessoais.setBounds(1077, 117, 155, 17);
		contentPane.add(lblInfPessoais);

		JLabel lblOpContato = new JLabel("Informações Profissionais:");
		lblOpContato.setForeground(new Color(102, 51, 204));
		lblOpContato.setFont(new Font("Dialog", Font.BOLD, 13));
		lblOpContato.setBounds(1085, 377, 171, 17);
		contentPane.add(lblOpContato);

		JLabel lblNomeResp = new JLabel("Especialidade");
		lblNomeResp.setForeground(new Color(102, 51, 204));
		lblNomeResp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeResp.setBounds(967, 478, 95, 17);
		contentPane.add(lblNomeResp);

		textEspecialidade = new JTextField();
		textEspecialidade.setForeground(new Color(102, 51, 255));
		textEspecialidade.setFont(new Font("Dialog", Font.PLAIN, 15));
		textEspecialidade.setColumns(10);
		textEspecialidade.setBounds(967, 495, 400, 44);
		contentPane.add(textEspecialidade);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastroMedicoView.class.getResource("/images/Login.png")));
		label.setBounds(173, 55, 595, 572);
		contentPane.add(label);

		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setForeground(new Color(102, 51, 204));
		lblCrm.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCrm.setBounds(967, 406, 65, 17);
		contentPane.add(lblCrm);

		textCRM = new JTextField();
		textCRM.setForeground(new Color(102, 51, 255));
		textCRM.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCRM.setColumns(10);
		textCRM.setBounds(967, 422, 400, 44);
		contentPane.add(textCRM);

	}

	public void restaurar() {
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldEmail.setText("");
		textCRM.setText("");
		textEspecialidade.setText("");
	}
}
