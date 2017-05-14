package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.ControleFormulario;
import Business.Declaracao;

import Business.PessoaFisica;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField tNome;
	private JTextField tCpf;
	private JTextField tIdade;
	private JTextField tContribuicaoOficial;
	private JTextField tTotalRendimentos;
	private String nome, cpf;
	private int idade,totalDependentes;
	private double contribuicao,rendimentos,imposto;
	private boolean declaracaoSimplificada,declaracaoCompleta;
	private char tipodeclaracao;

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
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(10, 36, 264, 516);
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
		tIdade.setBounds(10, 138, 109, 20);
		tIdade.setColumns(10);
		
		JLabel lbNumeroDependentes = new JLabel("Qtd. Dependentes:");
		lbNumeroDependentes.setBounds(10, 247, 116, 14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 272, 94, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		
		JLabel lbContribuicaoOficial = new JLabel("Contrib.Trib.Oficial:");
		lbContribuicaoOficial.setBounds(136, 122, 118, 14);
		
		tContribuicaoOficial = new JTextField();
		tContribuicaoOficial.setBounds(136, 138, 104, 20);
		tContribuicaoOficial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(111, 178, 46, 14);
		
		JLabel lbTotalRendimentos = new JLabel("Total Rendimentos:");
		lbTotalRendimentos.setBounds(10, 169, 118, 14);
		
		JRadioButton rdSimples = new JRadioButton("Simplificada");
		rdSimples.setBounds(10, 212, 109, 23);
		panel.add(rdSimples);
		
		JRadioButton rdCompleta = new JRadioButton("Completa");
		rdCompleta.setBounds(131, 212, 109, 23);
		panel.add(rdCompleta);
		
		tTotalRendimentos = new JTextField();
		tTotalRendimentos.setBounds(10, 185, 109, 20);
		tTotalRendimentos.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(333, 32, 325, 520);
		contentPane.add(textArea);
		
		JLabel lbTitulo1 = new JLabel("FORMUL\u00C1RIO DE DECLARA\u00C7\u00C3O:");
		lbTitulo1.setForeground(new Color(224, 255, 255));
		lbTitulo1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbTitulo1.setBounds(10, 11, 275, 14);
		contentPane.add(lbTitulo1);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMA\u00C7\u00D5ES:");
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(403, 11, 179, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Enviar Dados");
		btnNewButton.setBackground(new Color(112, 128, 144));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 320, 230, 29);
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
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				nome = tNome.getText().toUpperCase();
				cpf = tCpf.getText();
				idade = Integer.parseInt(tIdade.getText());
				rendimentos = Double.parseDouble(tTotalRendimentos.getText());
				contribuicao = Double.parseDouble(tContribuicaoOficial.getText());
				totalDependentes = Integer.parseInt(comboBox.getSelectedItem().toString());
				PessoaFisica p = new PessoaFisica(nome, cpf, idade, totalDependentes, rendimentos, contribuicao);
				if(rdSimples.isSelected()){
					tipodeclaracao = 'S';
					Declaracao dec = new Declaracao(p, tipodeclaracao);
					textArea.setText(dec.imprimirDeclaracao(p));
				}
				if(rdCompleta.isSelected()){
					tipodeclaracao = 'C';
					Declaracao dec = new Declaracao(p, tipodeclaracao);
					textArea.setText(dec.imprimirDeclaracao(p));
				}
				

				
				
			}
		});

	}
}
