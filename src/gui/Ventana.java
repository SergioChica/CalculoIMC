package gui;
import clases.Logica;
import clases.PersonaVO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Ventana extends JFrame implements ActionListener{

	private JPanel JPanel;
	private JLabel etiTitulo,etiDatosBasicos,etiDocumento,etiNombre,etiEdad,etiDatosIMC,etiPeso,etiTalla,etiResultado;
	private JTextField txtDocumento,txtNombre,txtEdad,txtPeso,txtTalla;
	private JTextArea areaTexto;
	private JButton btnRegistrar,btnConsultarLista,btnCalcularPromedioImc;
	private JScrollPane scrollArea;
	
	Logica miLogica;

	public Ventana() {
		setBackground(SystemColor.desktop);
		setTitle("VENTANA OPERACIONES");
		setForeground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 530);
		JPanel = new JPanel();
		JPanel.setBackground(new Color(147, 112, 219));
		JPanel.setForeground(new Color(147, 112, 219));
		JPanel.setBorder(null);

		setContentPane(JPanel);
		setLocationRelativeTo(null);
		JPanel.setLayout(null);
		
		miLogica= new Logica();
		
		iniciar();
	}

	private void iniciar() {
		// TODO Auto-generated method stub
		
		etiTitulo = new JLabel("CALCULAR IMC");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		etiTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiTitulo.setBounds(230, 23, 159, 45);
		JPanel.add(etiTitulo);
		
		etiDatosBasicos = new JLabel("Datos Basicos");
		etiDatosBasicos.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiDatosBasicos.setBounds(30, 80, 112, 25);
		JPanel.add(etiDatosBasicos);
		
		etiDocumento = new JLabel("Documento:");
		etiDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiDocumento.setBounds(30, 116, 92, 17);
		JPanel.add(etiDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(119, 116, 86, 20);
		JPanel.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(281, 116, 184, 20);
		JPanel.add(txtNombre);
		
		etiNombre = new JLabel("Nombre:");
		etiNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiNombre.setBounds(215, 116, 68, 17);
		JPanel.add(etiNombre);
		
		etiEdad = new JLabel("Edad:");
		etiEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiEdad.setBounds(473, 116, 42, 17);
		JPanel.add(etiEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(513, 116, 86, 20);
		JPanel.add(txtEdad);
		
		etiDatosIMC = new JLabel("Datos IMC");
		etiDatosIMC.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiDatosIMC.setBounds(30, 161, 112, 25);
		JPanel.add(etiDatosIMC);
		
		etiPeso = new JLabel("Peso:");
		etiPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiPeso.setBounds(30, 197, 92, 17);
		JPanel.add(etiPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(73, 197, 86, 20);
		JPanel.add(txtPeso);
		
		etiTalla = new JLabel("Talla:");
		etiTalla.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiTalla.setBounds(178, 197, 42, 17);
		JPanel.add(etiTalla);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(218, 197, 86, 20);
		JPanel.add(txtTalla);
		
		etiResultado = new JLabel("Resultado");
		etiResultado.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiResultado.setBounds(30, 238, 112, 25);
		JPanel.add(etiResultado);		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(153, 457, 141, 23);
		btnRegistrar.addActionListener(this);
		JPanel.add(btnRegistrar);
		
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setBounds(304, 457, 141, 23);
		btnConsultarLista.addActionListener(this);
		JPanel.add(btnConsultarLista);
		
		btnCalcularPromedioImc = new JButton("Calcular Promedio IMC");
		btnCalcularPromedioImc.setBounds(458, 457, 141, 23);
		btnCalcularPromedioImc.addActionListener(this);
		JPanel.add(btnCalcularPromedioImc);
		
		areaTexto = new JTextArea();
		areaTexto.setLineWrap(true);
		
		scrollArea = new JScrollPane();
		scrollArea.setViewportView(areaTexto);
		scrollArea.setBounds(30, 274, 569, 162);
		JPanel.add(scrollArea);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnRegistrar) {
			PersonaVO miPersona = new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
			String res=miLogica.registrarPersonas(miPersona);
			areaTexto.setText(res);
		}
		
		if (e.getSource()==btnConsultarLista) {
			String res=miLogica.consultarListaPersonas();
			areaTexto.setText(res);
		}
		
		if (e.getSource()==btnCalcularPromedioImc) {
			String res=miLogica.consultarProm();
			areaTexto.setText(res);
		}
	}
}
