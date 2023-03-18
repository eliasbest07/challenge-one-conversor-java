package com.btmstudio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import java.util.List;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.text.DecimalFormat;



public class MainFrame extends JFrame  implements ActionListener, CallBackConf {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField inputfmoneda;
    JTextField inputsmoneda;
    JTextField inputftemp;
    JTextField inputstemp;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JButton youtube = new JButton("");
    JButton github = new JButton("");
    JButton linkedin = new JButton("");
    JButton configuracion;
    JLabel label;
    JLabel labelDos = new JLabel("Pesos Colombianos\n $ COP ");
    Data valores = Data.Instancia();
    double factorConversion;
    List<FactorDeConversion> tasas;
    JComboBox<String> gradoTop,gradoBotton;
    public void initializae(){

        //valores.getMoneda();
        tasas = valores.getTasa(valores.getMoneda());
        FactorDeConversion factorMoneda = tasas.stream()
        .filter(factor -> "USD".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        factorConversion =Double.parseDouble(factorMoneda.getValor());
       // System.out.println( factorConversion );
       ImageIcon icon = new ImageIcon(getClass().getResource("assets/icono_c.png"));
        setIconImage(icon.getImage());
// salida 
     //   DecimalFormat formato = new DecimalFormat("#.##");
    //    float valorFormateado = Float.parseFloat(formato.format(factorConversion).replace(",", "."));
      //  System.out.println( valorFormateado);
  

        JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
   
        panelDePestanas.setBounds(0, 11, 300, 300);
        JPanel panelmoneda = new JPanel();
        JPanel panetemperatura = new JPanel();
        JPanel paneacercade = new JPanel();
        panelmoneda.setLayout(new BorderLayout());
        panetemperatura.setLayout(new BorderLayout());
        paneacercade.setLayout(new BorderLayout());

        panelDePestanas.addTab("Moneda", null, panelmoneda, null);
        panelDePestanas.addTab("Temperatura", null, panetemperatura, null);
        panelDePestanas.addTab("Acerca de", null, paneacercade, null);
        

       boton1 = new JButton("");
       boton2 = new JButton("");
       boton3 = new JButton("");
       boton4 = new JButton("");
       boton5 = new JButton("");



       configuracion= new JButton("Configuraciones");
       label = new JLabel("Dolares $ USD");
      // labelDos = new JLabel("Pesos Colombianos\n $ COP ");
       label.setToolTipText("Dolares $ USD");
       //labelDos.setToolTipText("Pesos Colombianos $ COP");
      // labelDos.setPreferredSize(new Dimension(50, 80));
      // labelDos.setHorizontalAlignment(JLabel.CENTER);

        boton1.setPreferredSize(new Dimension(60, 60));
        boton2.setPreferredSize(new Dimension(60, 60));
        boton3.setPreferredSize(new Dimension(60, 60));
        boton4.setPreferredSize(new Dimension(60, 60));
        boton5.setPreferredSize(new Dimension(60, 60));

        
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);

        
       ImageIcon icono1 = new ImageIcon(this.getClass().getResource("assets/usd.png"));
       Image imagen1 = icono1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
icono1 = new ImageIcon(imagen1);
         boton1.setIcon(icono1);
         ImageIcon icono2 = new ImageIcon(this.getClass().getResource("assets/eur.png"));
         Image imagen2 = icono2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
  icono2 = new ImageIcon(imagen2);
           boton2.setIcon(icono2);
           ImageIcon icono3 = new ImageIcon(this.getClass().getResource("assets/jpy.png"));
           Image imagen3 = icono3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    icono3 = new ImageIcon(imagen3);
             boton3.setIcon(icono3);
             ImageIcon icono4 = new ImageIcon(this.getClass().getResource("assets/gbp.png"));
             Image imagen4 = icono4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      icono4 = new ImageIcon(imagen4);
               boton4.setIcon(icono4);
               ImageIcon icono5 = new ImageIcon(this.getClass().getResource("assets/krw.png"));
               Image imagen5 = icono5.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icono5 = new ImageIcon(imagen5);
                 boton5.setIcon(icono5);

        configuracion.addActionListener(this);
        JPanel lista = new JPanel();

        JScrollPane scrollPane = new JScrollPane(lista);
        lista.add(boton1);
        lista.add(boton2);
        lista.add(boton3);
        lista.add(boton4);
        lista.add(boton5);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        labelDos.setBorder(new EmptyBorder(1, 5, 0, 0));

        inputfmoneda=  new RoundJTextField(20);
        inputsmoneda= new RoundJTextField(20);
        inputftemp= new RoundJTextField(20);
        inputstemp= new RoundJTextField(20);

        inputftemp.setHorizontalAlignment(JTextField.CENTER);
        inputstemp.setHorizontalAlignment(JTextField.CENTER);
        inputfmoneda.setHorizontalAlignment(JTextField.CENTER);
        inputsmoneda.setHorizontalAlignment(JTextField.CENTER);
      //  inputfmoneda.setBorder(new RoundedBorder(20, Color.BLACK, false));

      inputfmoneda.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            String text = inputfmoneda.getText();
            if (!Character.isDigit(c) && c != '.' || (c == '.' && text.contains("."))) {
                e.consume();
            }
            if (text.indexOf(".") != -1 && text.substring(text.indexOf(".") + 1).length() == 2 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
            if (text.length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });
    
      inputfmoneda.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            String textoIngresado = inputfmoneda.getText();
            if (inputfmoneda.hasFocus()) {
                conversion(textoIngresado,true,inputsmoneda);
          //  System.out.println("El usuario ingresó: " + textoIngresado);
        //   if(!validarEntrada(textoIngresado)){

        //     return;
        //   }
        //     double resultado =0;
        //     resultado= Double.parseDouble(textoIngresado)/factorConversion;
        //     DecimalFormat formato = new DecimalFormat("#.##");
        //     float valorFormateado = Float.parseFloat(formato.format(resultado).replace(",", "."));
        //     // formatearNumeroString.format("%.2f", 
        //     DecimalFormat nuevoFormato = new DecimalFormat("#,###.00");
        //     nuevoFormato.format(valorFormateado);
        //     inputsmoneda.setText(nuevoFormato.format(valorFormateado));
        }
    }

        public void removeUpdate(DocumentEvent e) {
            String textoIngresado = inputfmoneda.getText();
            if (inputfmoneda.hasFocus()) {
                conversion(textoIngresado,true,inputsmoneda);
        //     if(!validarEntrada(textoIngresado)){
        //         return;
        //       }
        //   //  System.out.println("El usuario borro: " + textoIngresado);
        //   if(textoIngresado.isEmpty()){
        //     inputsmoneda.setText("0");
        //   }else{
            
        //       double resultado =0;
        //       resultado= Double.parseDouble(textoIngresado)/factorConversion;
        //       DecimalFormat formato = new DecimalFormat("#.##");
        //       float valorFormateado = Float.parseFloat(formato.format(resultado).replace(",", "."));
        //       DecimalFormat nuevoFormato = new DecimalFormat("#,###.00");
        //       nuevoFormato.format(valorFormateado);
        //       inputsmoneda.setText(nuevoFormato.format(valorFormateado));
        //   }
         }
        }

        public void changedUpdate(DocumentEvent e) {}
    });

    inputftemp.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            String text = inputftemp.getText();
        
            if (c == '-') {
                e.consume();
                if(text.contains("-")){
                    inputftemp.setText(text.replace("-", ""));
                }else{
                    inputftemp.setText("-"+text);
                }
            } else if (c == '.') {
                if (text.contains(".") || text.length() == 0 || text.indexOf("-") > 0) {
                    e.consume();
                }
            } else if (!Character.isDigit(c)) {
                e.consume();
            }
        
            if (text.indexOf(".") != -1 && text.substring(text.indexOf(".") + 1).length() == 2 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        
            if (text.length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });
    inputstemp.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            String text = inputstemp.getText();
        
            if (c == '-') {
                e.consume();
                if(text.contains("-")){
                    inputstemp.setText(text.replace("-", ""));
                }else{
                    inputstemp.setText("-"+text);
                }
                // if (text.startsWith("-") || text.length() > 0) {
                //     e.consume();
                // }
            } else if (c == '.') {
                if (text.contains(".") || text.length() == 0 || text.indexOf("-") > 0) {
                    e.consume();
                }
            } else if (!Character.isDigit(c)) {
                e.consume();
            }
        
            if (text.indexOf(".") != -1 && text.substring(text.indexOf(".") + 1).length() == 2 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        
            if (text.length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });


    inputsmoneda.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            String text = inputsmoneda.getText();
            if (!Character.isDigit(c) && c != '.' || (c == '.' && text.contains("."))) {
                e.consume();
            }
            if (text.indexOf(".") != -1 && text.substring(text.indexOf(".") + 1).length() == 2 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
            if (text.length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });
    
    inputsmoneda.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            if (inputsmoneda.hasFocus()) {
                String textoIngresado = inputsmoneda.getText();
                conversion(textoIngresado,false,inputfmoneda);
              //  System.out.println("El usuario 2 ingresó: " + textoIngresado); 
            }
           
        }

        public void removeUpdate(DocumentEvent e) {
            if (inputsmoneda.hasFocus()) {
            String textoIngresado = inputsmoneda.getText();
            conversion(textoIngresado,false,inputfmoneda);
           // System.out.println("El usuario 2 borro: " + textoIngresado);
            }
        }

        public void changedUpdate(DocumentEvent e) {}
    });

    
        JPanel fromPanel = new JPanel();
        JPanel tempUnoPanel = new JPanel();
        JPanel tempDosPanel = new JPanel();
        JPanel acercadePanel = new JPanel();
        tempUnoPanel.setLayout(new GridLayout(1,4,2,12));
        tempDosPanel.setLayout(new GridLayout(1,4,2,12));
        acercadePanel.setLayout(new GridLayout(6,1,2,12));
        
        JPanel monedaUnoPanel = new JPanel();
        JPanel monedaDosPanel = new JPanel();
        monedaDosPanel.setLayout(new GridLayout(1,4,2,12));
        monedaUnoPanel.setLayout(new GridLayout(1,4,2,12));
      

       // fromPanel.setBounds(0, 0, 300, 300);
        fromPanel.setLayout(new GridLayout(3,1,7,7));
        // label.setBounds(20, 0, 50, 50);
        // inputfmoneda.setBounds(20, 0, 50, 50);

        monedaUnoPanel.add(label);
        monedaUnoPanel.add(inputfmoneda);
      
       
        monedaDosPanel.add(inputsmoneda);
        monedaDosPanel.add(labelDos);

        monedaUnoPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        monedaDosPanel.setBorder(new EmptyBorder(5, 5, 5, 10));
      
        scrollPane.getHorizontalScrollBar().setUI(new RoundedScrollBarUI());
        scrollPane.setBorder(null);
        panelmoneda.setOpaque(false);
        panetemperatura.setOpaque(false);
        paneacercade.setOpaque(false);

        panelmoneda.add(scrollPane,BorderLayout.NORTH);
        panelmoneda.add(configuracion,BorderLayout.SOUTH);

       // panelmoneda.add()
      //  fromPanel.add(panelDePestanas);
        fromPanel.add(monedaUnoPanel);
        fromPanel.add(monedaDosPanel);
        fromPanel.setBorder(new EmptyBorder(10, 0, 5, 0));
        panelmoneda.add(fromPanel,BorderLayout.CENTER);
        JLabel titulo= new JLabel("Conversor de Temperaturas");
        JLabel espacio= new JLabel("");
        panetemperatura.add(titulo,BorderLayout.NORTH);

        JPanel temperaturaLiena = new JPanel();
        temperaturaLiena.setLayout(new GridLayout(6,1,7,7));
       
        String[] datos = {"grados Celsius", "grados Fahrenheit", "grados Rankine", "grados Reaumur", "grados Kelvin"};
    
       
        gradoTop= new JComboBox<String>(datos);
        gradoBotton= new JComboBox<String>(datos);
       
        tempUnoPanel.add(gradoTop);
        tempUnoPanel.add(inputftemp);
        gradoTop.addActionListener(this); 
        gradoBotton.addActionListener(this); 
       
        JLabel nombre= new JLabel("Conversor BTM Studio");
        JLabel autor= new JLabel("Este programa fue realizado por Elias Montilla");
        JTextArea descrip = new JTextArea("Es un programa el cual te facilita saber cuanto equivale la moneda de algunos países de Latinoamérica en monedas extranjeras como el Dólar, el Euro, el Yen, el Won, la Libra Esterlina. Además te ayuda a obtener la equivalencia de las diferentes medidas de temperaturas");
        descrip.setEditable(false);
        descrip.setLineWrap(true);
        descrip.setWrapStyleWord(true);
        JScrollPane scrollDes = new JScrollPane(descrip);
       // scrollDes.setPreferredSize(new Dimension(300, 250));
        JTextArea indicaciones = new JTextArea("Presiona el botón de la divisa extranjera que necesitas, en el botón Configuraciones puedes elegir la moneda del país de Latinoamérica para hacer la conversión, también puedes definir la tasa de cambio y guardar la tasa que definiste o también puedes restaurar las tasas con el botón Restaurar, lo que hace es obtener de internet las tasas actualizada del día ");
        indicaciones.setEditable(false);
        indicaciones.setLineWrap(true);
        indicaciones.setWrapStyleWord(true);
        JScrollPane scrollInd = new JScrollPane(indicaciones);
        //scrollInd.setPreferredSize(new Dimension(300, 250));
        JTextArea caracteristicas = new JTextArea("Este programa obtiene las tasas de cambio de las monedas haciendo uso de una API desde Internet, las consultas son limitadas, por lo tanto, una vez obtiene las tasas las guarda en una base de datos local para su posterior uso. Está realizado en Java usando la librería javax.swing ");
        caracteristicas.setEditable(false);
        caracteristicas.setLineWrap(true);
        caracteristicas.setWrapStyleWord(true);
        JScrollPane scrollCar = new JScrollPane(caracteristicas);

        JTextArea agradecimiento = new JTextArea("Agradezco a la startup Alura y al programa de ORACLE ONE por este challenger que me complace poner a disposición de todo aquel que quiera usarlo, incluso aprender con lo que hice. Agradezco especialmente a ChatGPT por brindarme respuestas rápidas y oportunas a inconvenientes que surgieron en la elaboración de este programa.  "); //  Agradezco especialmente a ChatGPT por brindarme respuestas rapidas y oportunas a inconvenientes que surguieron en la elaboracion de este programa. Espero saber de cualquiera que tenga ganas de trabajar y desarrollar productos digitales potentes capaces de ayudar a miles de personas que se pongan en contacto conmigo, les dejo mis redes sociales, espero les guste seguirme que yo tan solo estoy comenzando este maravilloso camino de desarrollar y distribuir productos digitales, espero yo serviles de inspiracion y demostrar que todo en la programacion se puede lograr
        agradecimiento.setEditable(false);
        agradecimiento.setLineWrap(true);
        agradecimiento.setWrapStyleWord(true);
        JScrollPane scrollAgr = new JScrollPane(agradecimiento);

        JTextArea agradC = new JTextArea("Espero saber de cualquiera que tenga ganas de trabajar y desarrollar productos digitales potentes capaces de ayudar a miles de personas que se pongan en contacto conmigo, les dejo mis redes sociales, espero les guste seguirme que yo sigo en este maravilloso camino de desarrollar y distribuir productos digitales, espero yo serviles de inspiración y demostrar que todo en la programación se puede lograr"); //  
        agradC.setEditable(false);
        agradC.setLineWrap(true);
        agradC.setWrapStyleWord(true);
        JScrollPane scrollAgrC = new JScrollPane(agradC);
     
        acercadePanel.add(scrollDes);
        acercadePanel.add(scrollInd);
        acercadePanel.add(scrollCar);
        acercadePanel.add(scrollAgr);
        acercadePanel.add(scrollAgrC);
        JPanel redesSocial = new JPanel();
        JPanel espaciado = new JPanel();

        
        youtube.setPreferredSize(new Dimension(60, 30));
        github.setPreferredSize(new Dimension(60, 30));
        linkedin.setPreferredSize(new Dimension(60, 30));
        

        ImageIcon iconoyoutube = new ImageIcon(this.getClass().getResource("assets/youtube.png"));
        Image imagenyt = iconoyoutube.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoyoutube = new ImageIcon(imagenyt);
 youtube.setIcon(iconoyoutube);
          ImageIcon iconogithub = new ImageIcon(this.getClass().getResource("assets/github.png"));
          Image imagengh = iconogithub.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
          iconogithub = new ImageIcon(imagengh);
   github.setIcon(iconogithub);
            ImageIcon iconolinkedin = new ImageIcon(this.getClass().getResource("assets/linkedin.png"));
            Image imagenlk = iconolinkedin.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            iconolinkedin = new ImageIcon(imagenlk);
     linkedin.setIcon(iconolinkedin);
     youtube.addActionListener(this);
     github.addActionListener(this);
     linkedin.addActionListener(this);

        redesSocial.setLayout(new GridLayout(1,3,12,12));
        espaciado.setLayout(new GridLayout(2,1,12,12));
        redesSocial.add(youtube);
        redesSocial.add(github);
        redesSocial.add(linkedin);
        espaciado.add(redesSocial);
        espaciado.setBorder(new EmptyBorder(0, 10, 0, 10));
        JLabel fechaRealizado= new JLabel("Finalizado el 15 de Marzo del 2023");
        fechaRealizado.setBorder(new EmptyBorder(0, 27, 0, 0));
        espaciado.add(fechaRealizado);
  
       // redesSocial.setPreferredSize(new Dimension(250, 60));
        acercadePanel.add(espaciado);
        JScrollPane scrollGeneral = new JScrollPane(acercadePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollGeneral.setPreferredSize(new Dimension(250, 250));
       // scrollGeneral.add(acercadePanel);
        paneacercade.add(nombre,BorderLayout.NORTH);
        paneacercade.add(scrollGeneral,BorderLayout.CENTER);
        paneacercade.add(autor,BorderLayout.SOUTH);
       
        

        inputftemp.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                String textoIngresado = inputftemp.getText();
                if (inputftemp.hasFocus()) {
                    inputstemp.setText(convertirTemperatura(gradoTop.getItemAt(gradoTop.getSelectedIndex())+"", gradoBotton.getSelectedIndex(), textoIngresado));
            }
        }
    
            public void removeUpdate(DocumentEvent e) {
                String textoIngresado = inputftemp.getText();
                if (inputftemp.hasFocus()) {
                    if(textoIngresado.isEmpty()){
                        inputstemp.setText("0");
                    }else{
                        inputstemp.setText(convertirTemperatura(gradoTop.getItemAt(gradoTop.getSelectedIndex())+"", gradoBotton.getSelectedIndex(), textoIngresado));
                    }
             }
            }
    
            public void changedUpdate(DocumentEvent e) {}
        });
        inputstemp.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                String textoIngresado = inputstemp.getText();
                if (inputstemp.hasFocus()) {
                   inputftemp.setText(convertirTemperatura(gradoBotton.getItemAt(gradoBotton.getSelectedIndex())+"", gradoTop.getSelectedIndex(), textoIngresado));
            }
        }
    
            public void removeUpdate(DocumentEvent e) {
                String textoIngresado = inputstemp.getText();
                if (inputstemp.hasFocus()) {
                    if(textoIngresado.isEmpty()){
                        inputftemp.setText("0");
                    }else{
                  inputftemp.setText(convertirTemperatura(gradoBotton.getItemAt(gradoBotton.getSelectedIndex())+"", gradoTop.getSelectedIndex(), textoIngresado));
                    }
             }
            }
    
            public void changedUpdate(DocumentEvent e) {}
        });

        tempDosPanel.add(inputstemp);
        tempDosPanel.add(gradoBotton);
        temperaturaLiena.add(espacio);
        temperaturaLiena.add(tempUnoPanel);
        temperaturaLiena.add(tempDosPanel);

        panetemperatura.add(temperaturaLiena,BorderLayout.CENTER);

        // gradoTop.

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(0, 0, 300, 300);
        //mainPanel.setBackground(getForeground());

        switch(valores.getMoneda()){
            case "VEF":
            actualizarTextoLabel("Bolivares Venezolanos");

           // labelDos.setText("Bolivares Venezolanos");
           // labelDos.setToolTipText("Bolivares Venezolanos");
            break;
            case "ARS":
            actualizarTextoLabel("Pesos Argentinos");
            // labelDos.setText("Pesos Argentinos");
            // labelDos.setToolTipText("Pesos Argentinos");
            break;
            case "BRL":
            actualizarTextoLabel("Reales Brasileño");
            // labelDos.setText("Reales Brasileño");
            // labelDos.setToolTipText("Reales Brasileño");
            break;
            case "BOB":
            actualizarTextoLabel("Bolivianos Bolivia");
            break;
            case "CLP":
            actualizarTextoLabel("Pesos Chilenos");
            break;
            case "COP":
            actualizarTextoLabel("Pesos Colombianos");
            break;
            case "CRC":
            actualizarTextoLabel("Colones Costa Rica");
            break;
            case "CUC":
            actualizarTextoLabel("Pesos convertibles Cubanos");
            break;
            case "USD":
            actualizarTextoLabel("Dolares Ecuador");
            break;
            case "SVC":
            actualizarTextoLabel("Colones Salvador");
            break;
            case "HNL":
            actualizarTextoLabel("Lempira Hondura");
            break;
            case "MXN":
            actualizarTextoLabel("Pesos Mexicanos");
            break;
            case "NIO":
            actualizarTextoLabel("Córdoba Nicaragüense");
            break;
            case "PAB":
            actualizarTextoLabel("Balboa Panameño");
            break;
            case "PYG":
            actualizarTextoLabel("Guarani Paraguay");
            break;
            case "PEN":
            actualizarTextoLabel("Soles Peruanos");
            break;
            case "DOP":
            actualizarTextoLabel("Pesos Dominicanos");
            break;
            case "UYU":
            actualizarTextoLabel("Pesos Uruguayos");
            break;
        }

        mainPanel.add(panelDePestanas);

      //  mainPanel.add(scrollPane,BorderLayout.NORTH);
      //  mainPanel.add(fromPanel,BorderLayout.CENTER);

        add(mainPanel);
        setBounds(300, 300, 300, 300);
        setTitle("Conversor BTM Studio");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
@Override
    public void actionPerformed(ActionEvent e) {


        if(gradoTop.hasFocus()){
            inputstemp.setText(convertirTemperatura(gradoTop.getItemAt(gradoTop.getSelectedIndex())+"", gradoBotton.getSelectedIndex(), inputftemp.getText()));
          //  System.out.println(gradoTop.getSelectedIndex());   
        }
        if(gradoBotton.hasFocus()){
            inputftemp.setText(convertirTemperatura(gradoBotton.getItemAt(gradoBotton.getSelectedIndex())+"", gradoTop.getSelectedIndex(), inputstemp.getText()));
    }
    if (e.getSource() == youtube) {
        try {
            URI uri = new URI("https://www.youtube.com/channel/UCmM8pJe1eweexNV_rUmtbBA");
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Sucedio este Error: "+err, "Problema con tu Navegador", JOptionPane.WARNING_MESSAGE);
        }
    }
    if (e.getSource() == github) {
        try {
            URI uri = new URI("https://github.com/eliasbest07");
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Sucedio este Error: "+err, "Problema con tu Navegador", JOptionPane.WARNING_MESSAGE);
        }
    }
    if (e.getSource() == linkedin) {
        try {
            URI uri = new URI("http://linkedin.com/in/elias-montilla-629110229");
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Sucedio este Error: "+err, "Problema con tu Navegador", JOptionPane.WARNING_MESSAGE);
        }
    }
        if (e.getSource() == boton1) {
            // label.setText("Nuevo texto del JLabel");
        // System.out.println("Press boton 1");
        label.setText("Dolares $ USD");
        label.setToolTipText("Dolares $ USD");

        tasas = valores.getTasa(valores.getMoneda());
        FactorDeConversion factorMoneda = tasas.stream()
        .filter(factor -> "USD".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        factorConversion =Double.parseDouble(factorMoneda.getValor());
        conversion(inputfmoneda.getText(),true,inputsmoneda);
      //  System.out.println( factorConversion );
//         JFileChooser selector = new JFileChooser();
// int resultado = selector.showOpenDialog(null);
// if (resultado == JFileChooser.APPROVE_OPTION) {
//     File archivo = selector.getSelectedFile();
//     System.out.println(archivo.getAbsolutePath());
//     // Aquí puedes trabajar con el archivo seleccionado
// }
        }
        if (e.getSource() == boton2) {
            // label.setText("Nuevo texto del JLabel");
        // System.out.println("Press boton 2");
        label.setText("Euros € EUR");
        label.setToolTipText("Euros € EUR");
        tasas = valores.getTasa(valores.getMoneda());
        FactorDeConversion factorMoneda = tasas.stream()
        .filter(factor -> "EUR".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        factorConversion =Double.parseDouble(factorMoneda.getValor());
        // System.out.println( factorConversion );
        conversion(inputfmoneda.getText(),true,inputsmoneda);
        }
        if (e.getSource() == boton3) {
            // label.setText("Nuevo texto del JLabel");
            label.setText("Yen Japonés ¥ JPY");
            label.setToolTipText("Yen Japonés ¥ JPY");
            tasas = valores.getTasa(valores.getMoneda());
        FactorDeConversion factorMoneda = tasas.stream()
        .filter(factor -> "JPY".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        factorConversion =Double.parseDouble(factorMoneda.getValor());
        // System.out.println( factorConversion );
        conversion(inputfmoneda.getText(),true,inputsmoneda);
        }
        if (e.getSource() == boton4) {
            // label.setText("Nuevo texto del JLabel");
            label.setText("Libras Esterlinas £ GBP");
            label.setToolTipText("Libras Esterlinas £ GBP");
            tasas = valores.getTasa(valores.getMoneda());
            FactorDeConversion factorMoneda = tasas.stream()
            .filter(factor -> "GBP".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            factorConversion =Double.parseDouble(factorMoneda.getValor());
            // System.out.println( factorConversion );
            conversion(inputfmoneda.getText(),true,inputsmoneda);
        }
        if (e.getSource() == boton5) {
            // label.setText("Nuevo texto del JLabel");  Won sul-coreano
            label.setText("Won sur-coreano ₩ KRW");
            label.setToolTipText("Won sur-coreano ₩ KRW");
            tasas = valores.getTasa(valores.getMoneda());
            FactorDeConversion factorMoneda = tasas.stream()
            .filter(factor -> "KRW".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            factorConversion =Double.parseDouble(factorMoneda.getValor());
            // System.out.println( factorConversion );
            conversion(inputfmoneda.getText(),true,inputsmoneda);

        }
      
        if (e.getSource() == configuracion) {
            // label.setText("Nuevo texto del JLabel");
            ConfiguracionFrame configuracionframe = new ConfiguracionFrame();
            configuracionframe.initializae();
            dispose();
        // System.out.println("Press configuraciones");
        }
    }
    public String convertirTemperatura(String entrada, int salida, String valor){
        if(!validarEntrada(valor)){
            return "0";
        }
        if(valor.isEmpty()){
            return"0";
        }
        String respuesta="";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        switch(entrada){
            case "grados Celsius":
                switch(salida){
                    case 0:// °C
                    return valor.replace(",", ".");
                    case 1:// °F // (°C × 9/5) + 32 = F
                    return (decimalFormat.format((Double.parseDouble(valor)*9/5)+ 32)).replace(",", ".");
                    case 2:// °R // (°C + 273.15) × 9/5 × 1.8 = °R
                    return (decimalFormat.format((Double.parseDouble(valor)+273.15)*9/5*1.8)).replace(",", ".");
                    case 3:// °Ré //°C × 4/5 = °Ré
                    return (decimalFormat.format(Double.parseDouble(valor)*4/5)).replace(",", ".");
                    case 4:// K //°C + 273.15 = K
                    return (decimalFormat.format(Double.parseDouble(valor)+ 273.15)).replace(",", ".");
                }
            break;
            case "grados Fahrenheit":
            switch(salida){
                case 0:// °C //(°F - 32) × 5/9 = °C
                return (decimalFormat.format((Double.parseDouble(valor)-32)* 5/9)).replace(",", ".");
                case 1:// °F 
                return valor.replace(",", ".");
                case 2:// °R //(°F + 459.67) × 5/9 = °R
                return (decimalFormat.format((Double.parseDouble(valor)+459.67)* 5/9)).replace(",", ".");
                case 3:// °Ré //(°F - 32) × 4/9 = °Ré
                return (decimalFormat.format((Double.parseDouble(valor)-32)*4/9)).replace(",", ".");
                case 4:// K //(°F + 459.67) × 5/9 = K
                return (decimalFormat.format((Double.parseDouble(valor)+459.67)*5/9)).replace(",", ".");
            }
            break;
            case "grados Rankine":
            switch(salida){
                case 0:// °C //(°R - 491.67) × 5/9 = °C
                return (decimalFormat.format((Double.parseDouble(valor)-491.67)*5/9)).replace(",", ".");
                case 1:// °F //°R × 9/5 - 459.67 = °F
                return (decimalFormat.format((Double.parseDouble(valor)*5/9)-459.67)).replace(",", ".");
                case 2:// °R
                return valor.replace(",", ".");
                case 3:// °Ré //(°R - 491.67) × 4/9 = °Ré
                return (decimalFormat.format((Double.parseDouble(valor)-491.67)*4/9)).replace(",", ".");
                case 4:// K //°R × 5/9 = K
                return (decimalFormat.format(Double.parseDouble(valor)*5/9)).replace(",", ".");
            }
            break;
            case "grados Reaumur":
            switch(salida){
                case 0:// °C //°Ré × 5/4 = °C
                return (decimalFormat.format(Double.parseDouble(valor)*5/4)).replace(",", ".");
                case 1:// °F //(°Ré × 9/4) + 32 = °F
                return (decimalFormat.format((Double.parseDouble(valor)*9/4)+ 32)).replace(",", ".");
                case 2:// °R //(°Ré + 273.15) × 9/4 × 1.8 = °R
                return (decimalFormat.format((Double.parseDouble(valor)+273.15)*9/4)).replace(",", ".");
                case 3:// °Ré
                return valor.replace(",", ".");
                case 4:// K //°Ré × 5/4 + 273.15 = K
                return (decimalFormat.format((Double.parseDouble(valor)*5/4)+ 273.15)).replace(",", ".");
            }
            break;
            case "grados Kelvin":
            switch(salida){
                case 0:// °C // K - 273.15 = °C
                return (decimalFormat.format(Double.parseDouble(valor)-273.15)).replace(",", ".");
                case 1:// °F // (K × 9/5) - 459.67 = °F
                return (decimalFormat.format((Double.parseDouble(valor)* 9/5)-459.67)).replace(",", ".");
                case 2:// °R // K × 1.8 = °R
                return (decimalFormat.format(Double.parseDouble(valor)* 1.8)).replace(",", ".");
                case 3:// °Ré // (K - 273.15) × 4/5 = °Ré
                return (decimalFormat.format((Double.parseDouble(valor)- 273.15)*4/5)).replace(",", ".");
                case 4:// K 
                return valor.replace(",", ".");
            }
            break;

        }
       
        return respuesta;

    }
    public void actualizarTextoLabel(String texto) {
        labelDos.setText(texto);
        labelDos.setToolTipText(texto);
    }
    public void conversion(String entrada, boolean isToFrom,JTextField salida ){
       // String textoIngresado = inputfmoneda.getText();
       if(entrada.contains(",")){
        entrada = entrada.replaceAll(",", ".");
       }
        if(!validarEntrada(entrada)){
            return;
          }
      if(entrada.isEmpty()){
        salida.setText("0");
      }else{
          double resultado =0;
          if(isToFrom){
              resultado= Double.parseDouble(entrada)/factorConversion;
          }else{
            resultado= Double.parseDouble(entrada)*factorConversion;
          }
          DecimalFormat formato = new DecimalFormat("#.##");
          double valorFormateado = Double.parseDouble(formato.format(resultado).replace(",", "."));
          DecimalFormat nuevoFormato = new DecimalFormat("#,###.00");
          nuevoFormato.format(valorFormateado);
          salida.setText(nuevoFormato.format(valorFormateado));
      }
    }
    @Override
    public void datosGuardados() {
        initializae();
    }
    public boolean validarEntrada(String str) {
        if(str.contains("-")){
            if(str.matches("^-?\\d+\\.?\\d*$")){
           return true;
            }     
        }
        if(str.matches("^\\d*\\.?\\d*$")){
           return true;
        }
        return false;
    }
}
