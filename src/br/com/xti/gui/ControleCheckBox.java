package br.com.xti.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleCheckBox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361435793414552393L;
	Container container;
	JCheckBox cselNegrito, cselItálico; //csel - prefixo para JCheckboxes (caixa de seleção)
	JLabel cabeçalho;
	Font fonte;
	
	public ControleCheckBox() {
		super();
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		fonte = new Font("Helvetica", Font.PLAIN, 26);
		
		cabeçalho = new JLabel("Veja a fonte do texto mudar.");
		cabeçalho.setFont(fonte);
		
		cselNegrito = new JCheckBox("Negrito");
		cselItálico = new JCheckBox("Itálico");
		
		cselNegrito.addItemListener(new CSelListener());
		cselItálico.addItemListener(new CSelListener());
		
		
		container.add(cabeçalho);
		container.add(cselNegrito);
		container.add(cselItálico);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	public class CSelListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (cselNegrito.isSelected() && cselItálico.isSelected()) {
				fonte = fonte.deriveFont(Font.BOLD | Font.ITALIC);
				cabeçalho.setFont(fonte);
			} else if (cselNegrito.isSelected()) {
				fonte = fonte.deriveFont(Font.BOLD);
				cabeçalho.setFont(fonte);
			} else if (cselItálico.isSelected()) {
				fonte = fonte.deriveFont(Font.ITALIC);
				cabeçalho.setFont(fonte);
			} else {
				fonte = fonte.deriveFont(Font.PLAIN);
				cabeçalho.setFont(fonte);
			}
			
		}
		
	}
}
