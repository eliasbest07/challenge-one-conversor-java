package com.btmstudio;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.List;
import java.util.Map;
import java.awt.event.*;  
import java.awt.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class ConfiguracionFrame extends JFrame implements ActionListener, WindowListener  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> spinner;
    JLabel etiqueta;
    JLabel informacion;
    JLabel label;
    JLabel label2;
    JLabel moneda1;
    JLabel moneda2;
    JLabel moneda3;
    JLabel moneda4;
    JLabel moneda5;
    ImageIcon icono1;
    JTextField cambiomonedaUSD;
    JTextField cambiomonedaEUR;
    JTextField cambiomonedaJYP;
    JTextField cambiomonedaGBP;
    JTextField cambiomonedaKWR;
    JTextArea MesajeMostrar;
    JScrollPane scrollPane;
    JButton guardar;
    JButton restaurar;
    Data valoresEntrada = Data.Instancia();
    DecimalFormat formato = new DecimalFormat("#.##");
    CallBackConf llamado;
    List<FactorDeConversion> tasa;
    boolean apiError =false;
    public void initializae(){ 
        llamado= new MainFrame();
        String[] valores = {
            "[ARS] Pesos Argentinos",
            "[BOB] Bolivianos Bolivia",
            "[BRL] Reales Brasileño",
            "[CLP] Pesos Chilenos",
            "[COP] Pesos Colombianos",
            "[CRC] Colones Costa Rica",
            "[CUC] Pesos convertibles Cubanos",
            "[USD] Dolares Ecuador ",
            "[SVC] Colones Salvador",
            "[HNL] Lempira Hondura",
            "[MXN] Pesos Mexicanos",
            "[NIO] Córdoba Nicaragüense ",
            "[PAB] Balboa Panameño",
            "[PYG] Guarani Paraguay",
            "[PEN] Soles Peruanos",
            "[DOP] Pesos Dominicanos",
            "[UYU] Pesos Uruguayos",
            "[VEF] Bolivares Venezolanos",
        };

      //  SpinnerModel model = new SpinnerListModel(valores);
    //  informacion.setText(valoresEntrada.getInformacion());
    ImageIcon icon = new ImageIcon(getClass().getResource("assets/icono_c.png"));
    setIconImage(icon.getImage());
    MesajeMostrar = new JTextArea();
    MesajeMostrar.setEditable(false);
    MesajeMostrar.setLineWrap(true);
    MesajeMostrar.setWrapStyleWord(true);

    scrollPane = new JScrollPane(MesajeMostrar);
    scrollPane.setPreferredSize(new Dimension(300, 150));

    

        spinner = new JComboBox<String>(valores);
        spinner.addActionListener(this);  
     
        guardar= new JButton("Guardar");
        restaurar= new JButton("Restaurar");

        icono1 = new ImageIcon(this.getClass().getResource("assets/ars.png"));
        // Image imagen1 = icono1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        etiqueta = new JLabel(icono1);
        informacion= new JLabel("Informacion");
        JPanel seleccion = new JPanel();
        JPanel ordenNS = new JPanel();
        ordenNS.setLayout(new BorderLayout());

        label = new JLabel("Moneda de Argentina");
        label2 = new JLabel("Equivale");
        
        moneda1= new JLabel("$ USD 1 Dolar");
        moneda2= new JLabel("€ EUR 1 Euros");
        moneda3= new JLabel("¥ JPY 1 Yen Japonés");
        moneda4= new JLabel("£ GBP 1 Libras Esterlinas");
        moneda5= new JLabel("₩ KRW 1 Won sur-coreano");

        cambiomonedaUSD= new JTextField();
        cambiomonedaEUR= new JTextField();
        cambiomonedaJYP= new JTextField();
        cambiomonedaGBP= new JTextField();
        cambiomonedaKWR= new JTextField();

       

        seleccion.setLayout(new GridLayout(3,1,10,10));
        seleccion.add(label);
        seleccion.add(spinner);
        seleccion.add(label2);

        JPanel fromPanel = new JPanel();
        fromPanel.setLayout(new GridLayout(1,2,15,15));
        fromPanel.add(etiqueta);
        fromPanel.add(seleccion);
        ordenNS.add(fromPanel,BorderLayout.NORTH);

        JPanel linea1 = new JPanel();
        linea1.setLayout(new GridLayout(1,2,7,7));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new GridLayout(1,2,7,7));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new GridLayout(1,2,7,7));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new GridLayout(1,2,7,7));
        JPanel linea5 = new JPanel();
        linea5.setLayout(new GridLayout(1,2,7,7));
        linea1.add(moneda1); //cambiomonedaUSD
        linea1.add(cambiomonedaUSD);
        linea2.add(moneda2);
        linea2.add(cambiomonedaEUR);
        linea3.add(moneda3);
        linea3.add(cambiomonedaJYP);
        linea4.add(moneda4);
        linea4.add(cambiomonedaGBP);
        linea5.add(moneda5);
        linea5.add(cambiomonedaKWR);
        
        linea1.setBorder(new EmptyBorder(0, 20, 0, 20));
        linea2.setBorder(new EmptyBorder(0, 20, 0, 20));
        linea3.setBorder(new EmptyBorder(0, 20, 0, 20));
        linea4.setBorder(new EmptyBorder(0, 20, 0, 20));
        linea5.setBorder(new EmptyBorder(0, 20, 0, 20));


        // linea1.add(cambiarvalo1);
        JPanel botoPanel = new JPanel();
        botoPanel.setLayout(new GridLayout(1,4,7,7));
        botoPanel.add(guardar);
        botoPanel.add(restaurar);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6,4,7,7));
        informacion.setBorder(new EmptyBorder(10, 20, 20, 0));
        informacion.setText(valoresEntrada.getInformacion());
        centerPanel.add(informacion);
        centerPanel.add(linea1);
        centerPanel.add(linea2);
        centerPanel.add(linea3);
        centerPanel.add(linea4);
        centerPanel.add(linea5);
        botoPanel.setBorder(new EmptyBorder(30, 20, 20, 20));
        ordenNS.add(centerPanel,BorderLayout.CENTER);
        ordenNS.add(botoPanel,BorderLayout.SOUTH);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(0, 0, 300, 300);
        //mainPanel.setBackground(getForeground());
       // LocalDate fechaActual = LocalDate.now();
        //System.out.println("Fecha actual: " + fechaActual +" "+fechaActual.getDayOfMonth() +" - "+fechaActual.getMonthValue()+" - "+fechaActual.getYear() );

         mainPanel.add(ordenNS);
         guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana al hacer clic en el botón
                switch(spinner.getSelectedIndex()){
                    case 0:
                    valoresEntrada.setMoneda("ARS");
                    actualizaGuardar("ARS",false);
                    break;
                    case 1:
                    valoresEntrada.setMoneda("BOB");
                    actualizaGuardar("BOB",false);
                    break;
                    case 2:
                    valoresEntrada.setMoneda("BRL");
                    actualizaGuardar("BRL",false);
                    break;
                    case 3:
                    valoresEntrada.setMoneda("CLP");
                    actualizaGuardar("CLP",false);
                    break;
                    case 4:
                    valoresEntrada.setMoneda("COP");
                    actualizaGuardar("COP",false);
                    break;
                    case 5:
                    valoresEntrada.setMoneda("CRC");
                    actualizaGuardar("CRC",false);
                    break;
                    case 6:
                    valoresEntrada.setMoneda("CUC");
                    actualizaGuardar("CUC",false);
                    break;
                    case 7:
                    valoresEntrada.setMoneda("USD");
                    actualizaGuardar("USD",false);
                    break;
                    case 8:
                    valoresEntrada.setMoneda("SVC");
                    actualizaGuardar("SVC",false);
                    break;
                    case 9:
                    valoresEntrada.setMoneda("HNL");
                    actualizaGuardar("HNL",false);
                    break;
                    case 10:
                    valoresEntrada.setMoneda("MXN");
                    actualizaGuardar("MXN",false);
                    break;
                    case 11:
                    valoresEntrada.setMoneda("NIO");
                    actualizaGuardar("NIO",false);
                    break;
                    case 12:
                    valoresEntrada.setMoneda("PAB");
                    actualizaGuardar("PAB",false);
                    break;
                    case 13:
                    valoresEntrada.setMoneda("PYG");
                    actualizaGuardar("PYG",false);
                    break;
                    case 14:
                    valoresEntrada.setMoneda("PEN");
                    actualizaGuardar("PEN",false);
                    break;
                    case 15:
                    valoresEntrada.setMoneda("DOP");
                    actualizaGuardar("DOP",false);
                    break;
                    case 16:
                    valoresEntrada.setMoneda("UYU");
                    actualizaGuardar("UYU",false);
                    break;
                    case 17:
                    valoresEntrada.setMoneda("VEF");
                    actualizaGuardar("VEF",false);
                    break;
                }

                llamado.datosGuardados();
                dispose();
            }
        });
        restaurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(spinner.getSelectedIndex()){
                    case 0:
                    valoresEntrada.setMoneda("ARS");

                    actualizaGuardar("ARS",true);
                    break;
                    case 1:
                    valoresEntrada.setMoneda("BOB");
                    actualizaGuardar("BOB",true);
                    break;
                    case 2:
                    valoresEntrada.setMoneda("BRL");
                    actualizaGuardar("BRL",true);
                    break;
                    case 3:
                    valoresEntrada.setMoneda("CLP");
                    actualizaGuardar("CLP",true);
                    break;
                    case 4:
                    valoresEntrada.setMoneda("COP");
                    actualizaGuardar("COP",true);
                    break;
                    case 5:
                    valoresEntrada.setMoneda("CRC");
                    actualizaGuardar("CRC",true);
                    break;
                    case 6:
                    valoresEntrada.setMoneda("CUC");
                    actualizaGuardar("CUC",true);
                    break;
                    case 7:
                    valoresEntrada.setMoneda("USD");
                    actualizaGuardar("USD",true);
                    break;
                    case 8:
                    valoresEntrada.setMoneda("SVC");
                    actualizaGuardar("SVC",true);
                    break;
                    case 9:
                    valoresEntrada.setMoneda("HNL");
                    actualizaGuardar("HNL",true);
                    break;
                    case 10:
                    valoresEntrada.setMoneda("MXN");
                    actualizaGuardar("MXN",true);
                    break;
                    case 11:
                    valoresEntrada.setMoneda("NIO");
                    actualizaGuardar("NIO",true);
                    break;
                    case 12:
                    valoresEntrada.setMoneda("PAB");
                    actualizaGuardar("PAB",true);
                    break;
                    case 13:
                    valoresEntrada.setMoneda("PYG");
                    actualizaGuardar("PYG",true);
                    break;
                    case 14:
                    valoresEntrada.setMoneda("PEN");
                    actualizaGuardar("PEN",true);
                    break;
                    case 15:
                    valoresEntrada.setMoneda("DOP");
                    actualizaGuardar("DOP",true);
                    break;
                    case 16:
                    valoresEntrada.setMoneda("UYU");
                    actualizaGuardar("UYU",true);
                    break;
                    case 17:
                    valoresEntrada.setMoneda("VEF");
                    actualizaGuardar("VEF",true);
                    break;
                }

              
            } 
        });
        switch(valoresEntrada.getMoneda()){
            
            case "VEF":
            spinner.setSelectedIndex(17);
            asignarTasa("VEF");
            break;
            case "ARS":
            spinner.setSelectedIndex(0);
            asignarTasa("ARS");
            break;
            case "BOB":
            spinner.setSelectedIndex(1);
            asignarTasa("BOB");
            break;
            case "BRL":
            spinner.setSelectedIndex(2);
             asignarTasa("BRL");
            break;
            case "CLP":
            spinner.setSelectedIndex(3);
             asignarTasa("CLP");
            break;
            case "COP":
            spinner.setSelectedIndex(4);

            tasa = valoresEntrada.getTasa("COP");

            FactorDeConversion factorUsd = tasa.stream()
            .filter(factor -> "USD".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            FactorDeConversion factorEur = tasa.stream()
            .filter(factor -> "EUR".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            FactorDeConversion factorJpy = tasa.stream()
            .filter(factor -> "JPY".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            FactorDeConversion factorGbp = tasa.stream()
            .filter(factor -> "GBP".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            FactorDeConversion factorkwr = tasa.stream()
            .filter(factor -> "KRW".equals(factor.getOrige()))
            .findFirst()
            .orElse(null);
            if(factorUsd!=null){
                double valorFormateado = Double.parseDouble(formato.format( 1 / Double.parseDouble(factorUsd.getValor())).replace(",", "."));
                cambiomonedaUSD.setText(Double.toString(valorFormateado));
            }
            if(factorEur!=null){
                cambiomonedaEUR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorEur.getValor())).replace(",", "."))+"");
            }
            if(factorJpy!=null){
                cambiomonedaJYP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorJpy.getValor())).replace(",", "."))+"");
                
            }
            if(factorGbp!=null){
                cambiomonedaGBP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorGbp.getValor())).replace(",", "."))+"");
                
            }
            if(factorkwr!=null){
                cambiomonedaKWR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorkwr.getValor())).replace(",", "."))+"");
            }
            break;
            case "CRC":
            spinner.setSelectedIndex(5);
             asignarTasa("CRC");
            break;
            case "CUC":
            spinner.setSelectedIndex(6);
             asignarTasa("CUC");
            break;
            case "USD":
            spinner.setSelectedIndex(7);
             asignarTasa("USD");
            break;
            case "SVC":
            spinner.setSelectedIndex(8);
             asignarTasa("SVC");
            break;
            case "HNL":
            spinner.setSelectedIndex(9);
             asignarTasa("HNL");
            break;
            case "MXN":
            spinner.setSelectedIndex(10);
             asignarTasa("MXN");
            break;
            case "NIO":
            spinner.setSelectedIndex(11);
             asignarTasa("NIO");
            break;
            case "PAB":
            spinner.setSelectedIndex(12);
             asignarTasa("PAB");
            break;
            case "PYG":
            spinner.setSelectedIndex(13);
             asignarTasa("PYG");
            break;
            case "PEN":
            spinner.setSelectedIndex(14);
             asignarTasa("PEN");
            break;
            case "DOP":
            spinner.setSelectedIndex(15);
             asignarTasa("DOP");
            break;
            case "UYU":
            spinner.setSelectedIndex(16);
             asignarTasa("UYU");
            break;
        }

        cambiomonedaUSD.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = cambiomonedaUSD.getText();
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
        cambiomonedaEUR.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = cambiomonedaEUR.getText();
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
        cambiomonedaJYP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = cambiomonedaJYP.getText();
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
        cambiomonedaGBP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = cambiomonedaGBP.getText();
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
        cambiomonedaKWR.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = cambiomonedaKWR.getText();
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

        add(mainPanel);
        addWindowListener(this);
        setBounds(300, 100, 300, 300);
        setTitle("Conversor Monedas Configuraciones");
        setSize(400, 500);
        setResizable(false);
       
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //    System.out.println( spinner.getSelectedIndex());
           switch(spinner.getSelectedIndex()){
            case 0:
            label.setText("Moneda de Argentina");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/ars.png"))));
            asignarTasa("ARS");
            break;
            case 1:
            label.setText("Moneda de Bolivia");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/bob.png"))));
            asignarTasa("BOB");
            break;
            case 2:
            label.setText("Moneda de Brazil");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/brl.png"))));
            asignarTasa("BRL");
            break;
            case 3:
            label.setText("Moneda de Chile");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/clp.png"))));
            asignarTasa("CLP");
            break;
            case 4:
            label.setText("Moneda de Colombia");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/cop.png"))));
            asignarTasa("COP");
            break;
            case 5:
            label.setText("Moneda de Costa Rica");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/crc.png"))));
            asignarTasa("CRC");
            break;
            case 6:
            label.setText("Moneda de Cuba");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/cuc.png"))));
            asignarTasa("CUC");
            break;
            case 7:
            label.setText("Moneda de Ecuador");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/usdecu.png"))));
            asignarTasa("USD");
            break;
            case 8:
            label.setText("Moneda de Salvador ");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/svc.png"))));
            asignarTasa("SVC");
            break;
            case 9:
            label.setText("Moneda de Hondura");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/hnl.png"))));
            asignarTasa("HNL");
            break;
            case 10:
            label.setText("Moneda de Mexico");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/mxn.png"))));
            asignarTasa("MXN");
            break;
            case 11:
            label.setText("Moneda de Nicaragua");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/nio.png"))));
            asignarTasa("NIO");
            break;
            case 12:
            label.setText("Moneda de Panama");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/pab.png"))));
            asignarTasa("PAB");
            break;
            case 13:
            label.setText("Moneda de Paraguay");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/pyg.png"))));
            asignarTasa("PYG");
            break;
            case 14:
            label.setText("Moneda de Peru");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/pen.png"))));
            asignarTasa("PEN");
            break;
            case 15:
            label.setText("Moneda de Rep. Dominicana");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/dop.png"))));
            asignarTasa("DOP");
            break;
            case 16:
            label.setText("Moneda de Uruguay");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/uyu.png"))));
            asignarTasa("UYU");
            break;
            case 17:
            label.setText("Moneda de Venezuela");
            etiqueta.setIcon(new ImageIcon((this.getClass().getResource("assets/vef.png"))));
            asignarTasa("VEF");
            
            break;
           }

    }
    void actualizaGuardar(String codigo,boolean api){
        LocalDate fechaActual = LocalDate.now();
        ApiConsume apiPeticion = new ApiConsume();
        Map<String, String> tazas = null;
        if(api){
            try {
                String resp=  apiPeticion.factorConversion(fechaActual+"", codigo, "USD,EUR,JPY,GBP,KRW");
               // System.out.println(resp);
                APIResponce data = Converter.fromJsonString(resp);
                tazas =  data.getRates();
 //               FactorDeConversion nuevatasa= new FactorDeConversion();
            // nuevatasa.setValor(tazas.get("USD"));
            // nuevatasa.setValor(tazas.get("EUR"));
            // nuevatasa.setValor(tazas.get("JPY"));
            // nuevatasa.setValor(tazas.get("GBP"));
            // nuevatasa.setValor(tazas.get("KRW"));
        
                
            } catch (Exception e) {
                MesajeMostrar.setText("Problema con el Internet. Error "+e);
                JOptionPane.showMessageDialog(null, scrollPane, "Restaurar", JOptionPane.INFORMATION_MESSAGE);
                apiError=true;
            }
        }else{
            valoresEntrada.setInformacion("Guardado el dia "+fechaActual);
        }
       // System.out.println("Fecha actual: " + fechaActual +" "+fechaActual.getDayOfMonth() +" - "+fechaActual.getMonthValue()+" - "+fechaActual.getYear() );
        FactorDeConversion tasaUSD,tasaEUR,tasaJPY, tasaGBP,tasaKWR;
        
        tasaUSD= new FactorDeConversion();
        tasaEUR= new FactorDeConversion();
        tasaJPY= new FactorDeConversion();
        tasaGBP= new FactorDeConversion();
        tasaKWR= new FactorDeConversion();

        tasaUSD.setCodigo(codigo);
        tasaUSD.setOrige("USD");
        tasaUSD.setUltfechae(fechaActual+"");
        if(api && tazas!= null){
            tasaUSD.setValor(tazas.get("USD"));
        }else{
            tasaUSD.setValor((1/ Double.parseDouble(cambiomonedaUSD.getText()))+"");
        }
        
        tasaEUR.setCodigo(codigo);
        tasaEUR.setOrige("EUR");
        tasaEUR.setUltfechae(fechaActual+"");
        if(api && tazas!= null){
            tasaEUR.setValor(tazas.get("EUR"));
        }else{
            tasaEUR.setValor((1/ Double.parseDouble(cambiomonedaEUR.getText()))+"");
        }
        tasaJPY.setCodigo(codigo);
        tasaJPY.setOrige("JPY");
        tasaJPY.setUltfechae(fechaActual+"");
        if(api && tazas!= null){
            tasaJPY.setValor(tazas.get("JPY"));
        }else{
            tasaJPY.setValor((1/ Double.parseDouble(cambiomonedaJYP.getText()))+"");
        }
        tasaGBP.setCodigo(codigo);
        tasaGBP.setOrige("GBP");
        tasaGBP.setUltfechae(fechaActual+"");
        if(api && tazas!= null){
            tasaGBP.setValor(tazas.get("GBP"));
        }else{
            tasaGBP.setValor((1/ Double.parseDouble(cambiomonedaGBP.getText()))+"");
        }
        tasaKWR.setCodigo(codigo);
        tasaKWR.setOrige("KRW");
        tasaKWR.setUltfechae(fechaActual+"");
        if(api && tazas!= null){
            tasaKWR.setValor(tazas.get("KRW"));
        }else{
            tasaKWR.setValor((1/ Double.parseDouble(cambiomonedaKWR.getText()))+"");
        }
       valoresEntrada.borrarTasa(codigo);

        valoresEntrada.insertarTasa(codigo, tasaUSD);
        valoresEntrada.insertarTasa(codigo, tasaEUR);
        valoresEntrada.insertarTasa(codigo, tasaJPY);
        valoresEntrada.insertarTasa(codigo, tasaGBP);
        valoresEntrada.insertarTasa(codigo, tasaKWR);
        // System.out.println(tasaJPY);
        BaseDeDatos db = new BaseDeDatos();
        if(api){
            cambiomonedaUSD.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(tasaUSD.getValor())).replace(",", "."))+"");
            cambiomonedaEUR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(tasaEUR.getValor())).replace(",", "."))+"");
            cambiomonedaJYP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(tasaJPY.getValor())).replace(",", "."))+"");
            cambiomonedaGBP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(tasaGBP.getValor())).replace(",", "."))+"");
            cambiomonedaKWR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(tasaKWR.getValor())).replace(",", "."))+"");
           if(apiError){
            JOptionPane.showMessageDialog(null, "NO se Actualizaron las tasas de Cambio", "Restaurar", JOptionPane.WARNING_MESSAGE);
           }else{
               JOptionPane.showMessageDialog(null, "Se Actualizaron las tasas de Cambio desde Internet", "Restaurar", JOptionPane.WARNING_MESSAGE);
           }
            // cambiomonedaUSD.setText(1/Double.parseDouble(tasaUSD.getValor())+"");
            // cambiomonedaEUR.setText(1/Double.parseDouble(tasaEUR.getValor())+"");
            // cambiomonedaJYP.setText(1/Double.parseDouble(tasaJPY.getValor())+"");
            // cambiomonedaGBP.setText(1/Double.parseDouble(tasaGBP.getValor())+"");
            // cambiomonedaKWR.setText(1/Double.parseDouble(tasaKWR.getValor())+"");
        }
        try {
            db.actualizarTasa(tasaUSD);
            db.actualizarTasa(tasaEUR);
            db.actualizarTasa(tasaJPY);
            db.actualizarTasa(tasaGBP);
            db.actualizarTasa(tasaKWR);
            db.actualizarData(valoresEntrada);
        } catch (Exception e) {
            MesajeMostrar.setText("Problema con el Internet. Error "+e);
            JOptionPane.showMessageDialog(null, scrollPane, "Restaurar", JOptionPane.INFORMATION_MESSAGE);
        }
        //Guardar en la base de datos 
    }
    void asignarTasa(String codigo){
        tasa = valoresEntrada.getTasa(codigo);
    if(tasa != null){
        FactorDeConversion factorUsd = tasa.stream()
        .filter(factor -> "USD".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        FactorDeConversion factorEur = tasa.stream()
        .filter(factor -> "EUR".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        FactorDeConversion factorJpy = tasa.stream()
        .filter(factor -> "JPY".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        FactorDeConversion factorGbp = tasa.stream()
        .filter(factor -> "GBP".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        FactorDeConversion factorkwr = tasa.stream()
        .filter(factor -> "KRW".equals(factor.getOrige()))
        .findFirst()
        .orElse(null);
        if(factorUsd!=null){
            double valorFormateado = Double.parseDouble(formato.format( 1 / Double.parseDouble(factorUsd.getValor())).replace(",", "."));
            cambiomonedaUSD.setText(Double.toString(valorFormateado));
        }else{
            cambiomonedaUSD.setText("0");
        }
        if(factorEur!=null){
            cambiomonedaEUR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorEur.getValor())).replace(",", "."))+"");
        }else{
            cambiomonedaEUR.setText("0");
        }
        if(factorJpy!=null){
            cambiomonedaJYP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorJpy.getValor())).replace(",", "."))+"");
        }else{
            cambiomonedaJYP.setText("0");
        }
        if(factorGbp!=null){
            cambiomonedaGBP.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorGbp.getValor())).replace(",", "."))+"");
        }else{
            cambiomonedaGBP.setText("0");
        }
        if(factorkwr!=null){
            cambiomonedaKWR.setText(Double.parseDouble(formato.format( 1 / Double.parseDouble(factorkwr.getValor())).replace(",", "."))+"");
        }else{
            cambiomonedaKWR.setText("0");
        }
    }else{
        cambiomonedaUSD.setText("0");
        cambiomonedaEUR.setText("0");
        cambiomonedaJYP.setText("0");
        cambiomonedaGBP.setText("0");
        cambiomonedaKWR.setText("0");
    }
    }
    @Override
    public void windowOpened(WindowEvent e) {
        
    }
    @Override
    public void windowClosing(WindowEvent e) {
        llamado.datosGuardados();
    }
    @Override
    public void windowClosed(WindowEvent e) {
     
    }
    @Override
    public void windowIconified(WindowEvent e) {
       
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
      
    }
    @Override
    public void windowActivated(WindowEvent e) {
      
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
      
    }

}
