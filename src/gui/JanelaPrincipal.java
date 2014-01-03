package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.rtf.RTFEditorKit;

import util.ManipulaArquivoTXT;
import javax.swing.ImageIcon;

public class JanelaPrincipal extends JFrame {

	private JMenuBar barraMenu;
	private JMenu mnArquivo;
	private JMenuItem miNovo;
	private JMenuItem miAbrir;
	private JMenuItem miSalvar;
	private JMenuItem miSair;

	private JTextArea taTexto;

	public JanelaPrincipal() {
		super("Editor de Texto Java");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		barraMenu = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		miNovo = new JMenuItem("Novo");
		miNovo.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		miAbrir = new JMenuItem("Abrir");
		miAbrir.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		miSalvar = new JMenuItem("Salvar");
		miSalvar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		miSair = new JMenuItem("Sair");
		miSair.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		taTexto = new JTextArea();

		mnArquivo.add(miNovo);
		mnArquivo.add(miAbrir);
		mnArquivo.add(miSalvar);
		mnArquivo.addSeparator();
		mnArquivo.add(miSair);

		barraMenu.add(mnArquivo);
		this.setJMenuBar(barraMenu);

		this.getContentPane().add(taTexto);

		miNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miNovoOnClick();
			}
		});

		miAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miAbrirOnClick();
			}
		});

		miSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miSalvarOnClick();
			}
		});

		miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miSairOnClick();
			}
		});
		this.setSize(640, 480);
		this.setVisible(true);

	}

	protected void miSairOnClick() {
		System.exit(0);

	}

	protected void miSalvarOnClick() {

		try {

			JFileChooser arquivo = new JFileChooser();
			int retorno = arquivo.showOpenDialog(null);
			if (retorno == JFileChooser.APPROVE_OPTION) {

				String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
				String conteudo = taTexto.getText();
				boolean retorno2 = ManipulaArquivoTXT.gravaArquivoTXT(
						nomeArquivo, conteudo);

				if (retorno2 == true) {
					JOptionPane.showMessageDialog(this, "Arquivo Salvo !!!");
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage());
		}
	}

	protected void miAbrirOnClick() {
		try {

			JFileChooser arquivo = new JFileChooser();
			int retorno = arquivo.showOpenDialog(null);
			if (retorno == JFileChooser.APPROVE_OPTION) {

				String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
				String retorno2 = ManipulaArquivoTXT.leArquivoTXT(nomeArquivo);
				taTexto.setText(retorno2);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage());
		}

	}

	protected void miNovoOnClick() {
		taTexto.setText("");

	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
