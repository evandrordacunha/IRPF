package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField tNome;
	private JTextField tCpf;
	private JTextField tIdade;
	private JTextField tContribuicaoOficial;
	private JTextField tTotalRendimentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 601);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 254, 264);
		contentPane.add(panel);
		
		JLabel lbNome = new JLabel("Nome do Contribuinte:");
		lbNome.setBounds(10, 23, 230, 14);
		
		tNome = new JTextField();
		tNome.setBounds(10, 48, 230, 20);
		tNome.setColumns(10);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(10, 76, 230, 14);
		
		tCpf = new JTextField();
		tCpf.setBounds(10, 94, 230, 20);
		tCpf.setColumns(10);
		
		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setBounds(10, 122, 46, 14);
		
		tIdade = new JTextField();
		tIdade.setBounds(10, 138, 94, 20);
		tIdade.setColumns(10);
		
		JLabel lbNumeroDependentes = new JLabel("Qtd. Dependentes:");
		lbNumeroDependentes.setBounds(10, 161, 116, 14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 178, 94, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		
		JLabel lbContribuicaoOficial = new JLabel("Contrib.Trib.Oficial:");
		lbContribuicaoOficial.setBounds(136, 122, 118, 14);
		
		tContribuicaoOficial = new JTextField();
		tContribuicaoOficial.setBounds(136, 138, 104, 20);
		tContribuicaoOficial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(111, 178, 46, 14);
		
		JLabel lbTotalRendimentos = new JLabel("Rendimentos Total:");
		lbTotalRendimentos.setBounds(136, 161, 118, 14);
		
		tTotalRendimentos = new JTextField();
		tTotalRendimentos.setBounds(136, 178, 104, 20);
		tTotalRendimentos.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar Dados");
		btnNewButton.setBounds(10, 209, 230, 29);
		panel.setLayout(null);
		panel.add(lbNome);
		panel.add(tNome);
		panel.add(lbCpf);
		panel.add(tCpf);
		panel.add(lbIdade);
		panel.add(lbNumeroDependentes);
		panel.add(tIdade);
		panel.add(comboBox);
		panel.add(lbContribuicaoOficial);
		panel.add(lblNewLabel);
		panel.add(tContribuicaoOficial);
		panel.add(lbTotalRendimentos);
		panel.add(tTotalRendimentos);
		panel.add(btnNewButton);
	}
}