package br.com.xti.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleCombo extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2155309459381796643L;

	Container contPrincipal;
	JLabel etiqueta, imagem;
	JComboBox<String> combo = new JComboBox<String>();
	ImageIcon[] imagens = {
			new ImageIcon(getClass().getResource("img/0.jpg")),
			new ImageIcon(getClass().getResource("img/1.jpg")),
			new ImageIcon(getClass().getResource("img/2.jpg"))
	};
	
	public ControleCombo() {
		super("Álbum de fotos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
		
		contPrincipal = getContentPane();
		etiqueta = new JLabel("ARRR");
		imagem = new JLabel(imagens[0]);
		
		add(BorderLayout.SOUTH, combo);
		add(BorderLayout.CENTER, imagem);
		combo.addItem("Foto 0");
		combo.addItem("Foto 1");
		combo.addItem("Foto 2");
		combo.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			imagem.setIcon(imagens[combo.getSelectedIndex()]);
		}
	}

}
