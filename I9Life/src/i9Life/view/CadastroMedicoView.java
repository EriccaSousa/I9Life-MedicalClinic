package i9Life.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import i9Life.controller.ClienteController;
import i9Life.util.DateUtil;

public class CadastroMedicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JButton btnLimpar;
	private JLabel label_1;
	private JTextField textnumTell;
	private JTextField textFieldEmail;
	private JTextField textDataNasc;
	private JTextField textFieldNumEnd;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textComplemento;
	private JTextField textCEP;
	private JTextField textNomeResp;
	private JTextField textParentesco;
	private JTextField textEmailResp;
	private JTextField textDDD;
	private JTextArea textArea;

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
		textFieldNome.setBounds(529, 132, 400, 44);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textFieldCPF.setForeground(new Color(102, 51, 255));
		textFieldCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(529, 199, 400, 44);
		contentPane.add(textFieldCPF);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(102, 51, 204));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNome.setBounds(529, 115, 65, 17);
		contentPane.add(lblNome);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(new Color(102, 51, 204));
		lblCPF.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCPF.setBounds(529, 183, 65, 17);
		contentPane.add(lblCPF);

		JLabel lblTell = new JLabel("Numero");
		lblTell.setForeground(new Color(102, 51, 204));
		lblTell.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTell.setBounds(606, 367, 65, 17);
		contentPane.add(lblTell);

		JButton btnCadastrar = new JButton("Finalizar Cadastro");
		btnCadastrar.setBackground(new Color(102, 51, 204));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date data = (Date) DateUtil.formatData(textDataNasc.getText());

				ClienteController.cadastra(0, textFieldNome.getText(), textFieldCPF.getText(), data,
						textFieldEmail.getText(), null, textNomeResp.getText(), textParentesco.getText(),
						textEmailResp.getText(), textCEP.getText(), textBairro.getText(), textFieldNumEnd.getText(),
						textComplemento.getText(), textCidade.getText(), textDDD.getText(), textnumTell.getText());
			}
		});
		btnCadastrar.setBounds(1237, 668, 155, 44);
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
		btnLimpar.setBounds(1080, 668, 145, 44);
		contentPane.add(btnLimpar);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CadastroMedicoView.class.getResource("/images/logo.png")));
		label_1.setBounds(852, 12, 211, 62);
		contentPane.add(label_1);

		textnumTell = new JFormattedTextField(new MaskFormatter("#####-####"));
		textnumTell.setForeground(new Color(102, 51, 255));
		textnumTell.setFont(new Font("Dialog", Font.PLAIN, 15));
		textnumTell.setColumns(10);
		textnumTell.setBounds(606, 385, 323, 44);
		contentPane.add(textnumTell);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setForeground(new Color(102, 51, 204));
		lblEmail_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail_1.setBounds(529, 441, 65, 17);
		contentPane.add(lblEmail_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(new Color(102, 51, 255));
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(529, 457, 400, 44);
		contentPane.add(textFieldEmail);

		JLabel lblInfPessoais = new JLabel("Informações Pessoais:");
		lblInfPessoais.setForeground(new Color(102, 51, 204));
		lblInfPessoais.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfPessoais.setBounds(639, 86, 155, 17);
		contentPane.add(lblInfPessoais);

		JLabel lblDataNasc = new JLabel("Data Nascimento");
		lblDataNasc.setForeground(new Color(102, 51, 204));
		lblDataNasc.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDataNasc.setBounds(529, 255, 116, 17);
		contentPane.add(lblDataNasc);

		textDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textDataNasc.setForeground(new Color(102, 51, 255));
		textDataNasc.setFont(new Font("Dialog", Font.PLAIN, 15));
		textDataNasc.setColumns(10);
		textDataNasc.setBounds(529, 271, 400, 44);
		contentPane.add(textDataNasc);

		JLabel lblOpContato = new JLabel("Opções de Contato:");
		lblOpContato.setForeground(new Color(102, 51, 204));
		lblOpContato.setFont(new Font("Dialog", Font.BOLD, 13));
		lblOpContato.setBounds(647, 346, 131, 17);
		contentPane.add(lblOpContato);

		JLabel lblObserva = new JLabel("Observações");
		lblObserva.setForeground(new Color(102, 51, 204));
		lblObserva.setFont(new Font("Dialog", Font.BOLD, 13));
		lblObserva.setBounds(529, 530, 95, 17);
		contentPane.add(lblObserva);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setForeground(new Color(102, 51, 204));
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEndereo.setBounds(1125, 86, 131, 17);
		contentPane.add(lblEndereo);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setForeground(new Color(102, 51, 204));
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNumero.setBounds(992, 115, 65, 17);
		contentPane.add(lblNumero);

		textFieldNumEnd = new JTextField();
		textFieldNumEnd.setForeground(new Color(102, 51, 255));
		textFieldNumEnd.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNumEnd.setColumns(10);
		textFieldNumEnd.setBounds(992, 132, 65, 44);
		contentPane.add(textFieldNumEnd);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(102, 51, 204));
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(1067, 116, 65, 17);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setForeground(new Color(102, 51, 255));
		textBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
		textBairro.setColumns(10);
		textBairro.setBounds(1067, 132, 325, 44);
		contentPane.add(textBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(102, 51, 204));
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCidade.setBounds(992, 183, 116, 17);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setForeground(new Color(102, 51, 255));
		textCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCidade.setColumns(10);
		textCidade.setBounds(992, 199, 400, 44);
		contentPane.add(textCidade);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(102, 51, 204));
		lblComplemento.setFont(new Font("Dialog", Font.BOLD, 13));
		lblComplemento.setBounds(1138, 255, 95, 17);
		contentPane.add(lblComplemento);

		textComplemento = new JTextField();
		textComplemento.setForeground(new Color(102, 51, 255));
		textComplemento.setFont(new Font("Dialog", Font.PLAIN, 15));
		textComplemento.setColumns(10);
		textComplemento.setBounds(1138, 271, 254, 44);
		contentPane.add(textComplemento);

		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setForeground(new Color(102, 51, 204));
		lblCEP.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCEP.setBounds(992, 255, 65, 17);
		contentPane.add(lblCEP);

		textCEP = new JFormattedTextField(new MaskFormatter("######-###"));
		textCEP.setForeground(new Color(102, 51, 255));
		textCEP.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCEP.setColumns(10);
		textCEP.setBounds(992, 271, 134, 44);
		contentPane.add(textCEP);

		JLabel lblInfPessoais_1 = new JLabel("Informações Pessoais:");
		lblInfPessoais_1.setForeground(new Color(102, 51, 204));
		lblInfPessoais_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfPessoais_1.setBounds(1102, 378, 155, 17);
		contentPane.add(lblInfPessoais_1);

		JLabel lblNomeResp = new JLabel("Nome");
		lblNomeResp.setForeground(new Color(102, 51, 204));
		lblNomeResp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeResp.setBounds(992, 407, 65, 17);
		contentPane.add(lblNomeResp);

		textNomeResp = new JTextField();
		textNomeResp.setForeground(new Color(102, 51, 255));
		textNomeResp.setFont(new Font("Dialog", Font.PLAIN, 15));
		textNomeResp.setColumns(10);
		textNomeResp.setBounds(992, 424, 400, 44);
		contentPane.add(textNomeResp);

		JLabel lblParentesco = new JLabel("Parentesco");
		lblParentesco.setForeground(new Color(102, 51, 204));
		lblParentesco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblParentesco.setBounds(992, 475, 95, 17);
		contentPane.add(lblParentesco);

		textParentesco = new JTextField();
		textParentesco.setForeground(new Color(102, 51, 255));
		textParentesco.setFont(new Font("Dialog", Font.PLAIN, 15));
		textParentesco.setColumns(10);
		textParentesco.setBounds(992, 491, 400, 44);
		contentPane.add(textParentesco);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 51, 204));
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail.setBounds(992, 547, 116, 17);
		contentPane.add(lblEmail);

		textEmailResp = new JTextField();
		textEmailResp.setForeground(new Color(102, 51, 255));
		textEmailResp.setFont(new Font("Dialog", Font.PLAIN, 15));
		textEmailResp.setColumns(10);
		textEmailResp.setBounds(992, 563, 400, 44);
		contentPane.add(textEmailResp);

		JLabel lblInfResp = new JLabel("Informações do Responsável:");
		lblInfResp.setForeground(new Color(102, 51, 204));
		lblInfResp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfResp.setBounds(1073, 346, 195, 17);
		contentPane.add(lblInfResp);

		JLabel lblDDD = new JLabel("DDD");
		lblDDD.setForeground(new Color(102, 51, 204));
		lblDDD.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDDD.setBounds(529, 367, 65, 17);
		contentPane.add(lblDDD);

		textDDD = new JFormattedTextField(new MaskFormatter("(##)"));
		textDDD.setForeground(new Color(102, 51, 255));
		textDDD.setFont(new Font("Dialog", Font.PLAIN, 15));
		textDDD.setColumns(10);
		textDDD.setBounds(529, 384, 65, 44);
		contentPane.add(textDDD);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastroMedicoView.class.getResource("/images/Login.png")));
		label.setBounds(14, 35, 497, 572);
		contentPane.add(label);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new CompoundBorder());
		textArea.setBounds(529, 548, 400, 164);
		contentPane.add(textArea);

	}

	public void restaurar() {
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textDataNasc.setText("");
		textFieldEmail.setText("");
		textnumTell.setText("");
		textDDD.setText("");
		textArea.setText("");
		textBairro.setText("");
		textFieldNumEnd.setText("");
		textCidade.setText("");
		textCEP.setText("");
		textComplemento.setText("");
		textEmailResp.setText("");
		textNomeResp.setText("");
		textParentesco.setText("");
	}
}
