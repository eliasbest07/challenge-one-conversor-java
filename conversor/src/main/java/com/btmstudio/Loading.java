package com.btmstudio;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void initializae(){

        JPanel mainPanel = new JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("assets/icono_c.png"));
        setIconImage(icon.getImage());
        mainPanel.setLayout(new BorderLayout());
        JLabel inicio = new JLabel("Alistando Conversos BTM Studio");
        inicio.setBorder(new EmptyBorder(0, 38, 0, 0));
        mainPanel.add(inicio,BorderLayout.NORTH);
        JTextArea MesajeMostrar;
        JScrollPane scrollPane;
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        MesajeMostrar = new JTextArea("Obteniendo tasas de cambio desde Internet. Espere por favor...");
        MesajeMostrar.setEditable(false);
        MesajeMostrar.setLineWrap(true);
        MesajeMostrar.setLineWrap(true);
        MesajeMostrar.setWrapStyleWord(true);
        MesajeMostrar.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        MesajeMostrar.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
    
        scrollPane = new JScrollPane(MesajeMostrar);
        scrollPane.setPreferredSize(new Dimension(300, 150));
       
        inicio.setBorder(new EmptyBorder(0, 38, 0, 40));
        mainPanel.add(scrollPane,BorderLayout.CENTER);
        mainPanel.add(progressBar,BorderLayout.SOUTH);
        
        add(mainPanel);
        setBounds(300, 300, 300, 300);
        setTitle("Conversor BTM Studio");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
