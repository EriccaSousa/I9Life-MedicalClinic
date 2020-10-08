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
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class HomeAdmView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmView frame = new HomeAdmView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeAdmView() {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1428, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(102, 51, 204));
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1420, 62);
		contentPane.add(menuBar);

		JMenu logo = new JMenu("");
		logo.setIcon(new ImageIcon(HomeAdmView.class.getResource("/images/logo.png")));
		logo.setFont(new Font("Dialog", Font.BOLD, 13));
		menuBar.add(logo);

		JMenu clientesMenu = new JMenu("Clientes");
		clientesMenu.setForeground(new Color(72, 61, 139));
		clientesMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(clientesMenu);

		JMenu medicosMenu = new JMenu("Médicos");
		medicosMenu.setForeground(new Color(72, 61, 139));
		medicosMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(medicosMenu);

		JMenu consultasMenu = new JMenu("Consultas");
		consultasMenu.setForeground(new Color(72, 61, 139));
		consultasMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(consultasMenu);

		JMenu agendaMenu = new JMenu("Agenda");
		agendaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		agendaMenu.setForeground(new Color(72, 61, 139));
		agendaMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(agendaMenu);

		JMenu perfilMenu = new JMenu("Perfil");
		perfilMenu.setForeground(new Color(72, 61, 139));
		perfilMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PerfilAdmView().setVisible(true);
			}
		});
		perfilMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(perfilMenu);

		JMenuItem addClienteAction = new JMenuItem("Add novo cliente");
		addClienteAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addClienteAction.setFont(new Font("Dialog", Font.BOLD, 13));
		addClienteAction.setForeground(new Color(72, 61, 139));

		JMenuItem findClienteAction = new JMenuItem("Pesquisar por clientes");
		findClienteAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		findClienteAction.setForeground(new Color(72, 61, 139));
		findClienteAction.setFont(new Font("Dialog", Font.BOLD, 13));

		JMenuItem addMedicoAction = new JMenuItem("Add novo médico");
		addMedicoAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new PerfilAdmView().setVisible(true);
			}
		});
		addMedicoAction.setForeground(new Color(72, 61, 139));
		addMedicoAction.setFont(new Font("Dialog", Font.BOLD, 13));

		JMenuItem findMedicoAction = new JMenuItem("Pesquisar por médicos");
		findMedicoAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		findMedicoAction.setFont(new Font("Dialog", Font.BOLD, 13));
		findMedicoAction.setForeground(new Color(72, 61, 139));

		JMenuItem addConsultaAction = new JMenuItem("Agendar");
		addConsultaAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addConsultaAction.setForeground(new Color(72, 61, 139));
		addConsultaAction.setFont(new Font("Dialog", Font.BOLD, 13));

		JMenuItem findConsultaAction = new JMenuItem("Pesquisar por consultas");
		findConsultaAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		findConsultaAction.setFont(new Font("Dialog", Font.BOLD, 13));
		findConsultaAction.setForeground(new Color(72, 61, 139));

		clientesMenu.add(addClienteAction);
		clientesMenu.add(findClienteAction);
		medicosMenu.add(addMedicoAction);
		medicosMenu.add(findMedicoAction);
		consultasMenu.add(addConsultaAction);
		consultasMenu.add(findConsultaAction);
	}
}
