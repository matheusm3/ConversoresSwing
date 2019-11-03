package SwingConvertor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Conversoes extends Calculos{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Nova Janela");
		frame.setSize(400, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		JPanel painel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
				
		// Cria o menu Arquivo
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		
		// Cria os itens do menu
		JMenuItem item = new JMenuItem("Sair",KeyEvent.VK_I);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fecha a tela
				//frame.setVisible(false);
				//frame.dispose();
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		// Adiciona um separador
		menuArquivo.addSeparator();
		menuArquivo.add(item);
		
		JMenu menuConfigs = new JMenu("Editar");
		JMenuItem checkItem = new JMenuItem("Limpar");
		checkItem.setSelected(true);

		JCheckBoxMenuItem radio1 = new JCheckBoxMenuItem("Exibir Moeda");
		JCheckBoxMenuItem radio2 = new JCheckBoxMenuItem("Exibir Temperatura");
		JCheckBoxMenuItem radio3 = new JCheckBoxMenuItem("Exibir Comprimento");
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);

		radio1.setSelected(false);
		radio2.setSelected(false);
		radio3.setSelected(false);
		checkItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				radio1.setSelected(false);
				radio2.setSelected(false);				
				radio3.setSelected(false);				
			}
		});

		menuConfigs.add(checkItem);
		menuConfigs.addSeparator();
		menuConfigs.add(radio1);
		menuConfigs.add(radio2);
		menuConfigs.add(radio3);
		
		
		JMenu menu2 = new JMenu("Ajuda");
		JMenuItem item5 = new JMenuItem("Sobre",KeyEvent.VK_S);
		
		JTabbedPane aba = new JTabbedPane();
		ImageIcon icon = new ImageIcon("assets/imgs/icone_folder.png");
		aba.addTab("Moeda", icon, criarPanelMoeda());
		aba.addTab("Temperatura", icon, criarPanelTemperatura());
		aba.addTab("Comprimento", icon, criarPanelComprimento());
		
		
		
		
		menu2.add(item5);
		
		// Adicina o menu na barra
		menuBar.add(menuArquivo);
		menuBar.add(menuConfigs);
		menuBar.add(menu2);
		painel.add(aba);
		//Adiciona Menu Bar
		
		frame.setJMenuBar(menuBar);
		
		
		// Adiciona o painel na janela
		frame.add(painel);
		
		
		frame.show();

	}
	
	
	
	////////////////////////////////////// P A I N E I S //////////////////////////////////////

	
	
	private static JPanel criarPanelMoeda() {
			
	    	JPanel panel = new JPanel();
	    	panel.setPreferredSize(new Dimension(290, 290));
			JLabel label = new JLabel("Nenhum Item selecionado");
			String itens [] = {"Real", "Dólar"};
			
			Dimension size = new Dimension(90, 20);
			Dimension buttonsize = new Dimension(200, 20);

			JComboBox<String> inp = new JComboBox<String>(itens);
			inp.setPreferredSize(size);
			JComboBox<String> inp2 = new JComboBox<String>(itens);
			inp2.setPreferredSize(size);
			
			inp.setSelectedIndex(-1);
			inp2.setSelectedIndex(-1);


			inp.addItem("Selecionar");
			inp2.addItem("Selecionar");
			JLabel de = new JLabel("De:");
			JLabel para = new JLabel("Para:");
			

			
			inp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp.getSelectedItem())
					;
				}
				
			});
			
			inp2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp2.getSelectedItem())
					;
				}
				
			});

			JTextField result = new JTextField();
			result.setPreferredSize(size);
			JButton button = new JButton("Converter");
			button.setPreferredSize(buttonsize);

			JTextField actinput = new JTextField();
			result.setPreferredSize(size);
			actinput.setPreferredSize(size);

			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String resultado = getMoeda(inp.getSelectedItem().toString(), inp2.getSelectedItem().toString(), actinput.getText());
					
					result.setText(resultado);						
				}
			});

			panel.add(de);
			panel.add(inp);
			panel.add(para);
			panel.add(inp2);
			panel.add(actinput);
			panel.add(result);
			panel.add(button);


	    	return panel;
 	
	 }
	 	
	 private static JPanel criarPanelTemperatura() {
			
	    	JPanel panel = new JPanel();
	    	panel.setPreferredSize(new Dimension(290, 290));
			JLabel label = new JLabel("Nenhum Item selecionado");
			String itens [] = {"Celsius", "Fahrenheit", "Kelvin"};
			
			Dimension size = new Dimension(90, 20);
			Dimension buttonsize = new Dimension(200, 20);

			JComboBox<String> inp = new JComboBox<String>(itens);
			inp.setPreferredSize(size);
			JComboBox<String> inp2 = new JComboBox<String>(itens);
			inp2.setPreferredSize(size);
			
			inp.setSelectedIndex(-1);
			inp2.setSelectedIndex(-1);


			inp.addItem("Selecionar");
			inp2.addItem("Selecionar");
			JLabel de = new JLabel("De:");
			JLabel para = new JLabel("Para:");
			

			
			inp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp.getSelectedItem())
					;
				}
				
			});
			
			inp2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp2.getSelectedItem())
					;
				}
				
			});

			JTextField result = new JTextField();
			result.setPreferredSize(size);
			JButton button = new JButton("Converter");
			button.setPreferredSize(buttonsize);

			JTextField actinput = new JTextField();
			result.setPreferredSize(size);
			actinput.setPreferredSize(size);

			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// JOptionPane.showMessageDialog(null, inp2.getSelectedItem().toString());

					
					
					String resultado = getTemperatura(inp.getSelectedItem().toString(), inp2.getSelectedItem().toString(), actinput.getText());
					
					result.setText(resultado);
										
				}
			});

			panel.add(de);
			panel.add(inp);
			panel.add(para);
			panel.add(inp2);
			panel.add(actinput);
			panel.add(result);
			panel.add(button);


	    	return panel;
	
	 }
	 
	 private static JPanel criarPanelComprimento() {

	    	JPanel panel = new JPanel();
	    	panel.setPreferredSize(new Dimension(290, 290));
			JLabel label = new JLabel("Nenhum Item selecionado");
			String itens [] = {"Metro", "Centímetro", "Milímetro"};
			
			Dimension size = new Dimension(90, 20);
			Dimension buttonsize = new Dimension(200, 20);

			JComboBox<String> inp = new JComboBox<String>(itens);
			inp.setPreferredSize(size);
			JComboBox<String> inp2 = new JComboBox<String>(itens);
			inp2.setPreferredSize(size);
			
			inp.setSelectedIndex(-1);
			inp2.setSelectedIndex(-1);


			inp.addItem("Selecionar");
			inp2.addItem("Selecionar");
			JLabel de = new JLabel("De:");
			JLabel para = new JLabel("Para:");
			

			
			inp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp.getSelectedItem())
					;
				}
				
			});
			
			inp2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setText("Selecionou : "+inp2.getSelectedItem())
					;
				}
				
			});

			JTextField result = new JTextField();
			result.setPreferredSize(size);
			JButton button = new JButton("Converter");
			button.setPreferredSize(buttonsize);

			JTextField actinput = new JTextField();
			result.setPreferredSize(size);
			actinput.setPreferredSize(size);

			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// JOptionPane.showMessageDialog(null, inp2.getSelectedItem().toString());

					
					
					String resultado = getComprimento(inp.getSelectedItem().toString(), inp2.getSelectedItem().toString(), actinput.getText());
					
					result.setText(resultado);
										
				}
			});

			panel.add(de);
			panel.add(inp);
			panel.add(para);
			panel.add(inp2);
			panel.add(actinput);
			panel.add(result);
			panel.add(button);


	    	return panel;
	
	 }
	 
}