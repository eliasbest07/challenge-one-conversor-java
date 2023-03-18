package com.btmstudio;


import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


/**
Conversor Challeger Alura ONE ORACLE
*/
public class App {
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // Obtener el factor de Convercion y guardar en base de datos 
        File archivo = new File("hotdata.db");
        ApiConsume api = new ApiConsume();
        Data valores = Data.Instancia();
        boolean archivoCreado = archivo.exists(); // si ua esta la base de datps
        BaseDeDatos db = new BaseDeDatos(); // abre o crea la base de datos
        LocalDate fechaActual = LocalDate.now(); // la fecha del dispositivo 
        String[] paises = {"ARS", "BOB", "BRL", "CLP", "COP", "CRC","CUC","USD","SVC","HNL","MXN","NIO","PAB","PYG","PEN","DOP","UYU","VEF" };
        JTextArea MesajeMostrar;
        JScrollPane scrollPane;
        MesajeMostrar = new JTextArea();
        MesajeMostrar.setEditable(false);
        MesajeMostrar.setLineWrap(true);
        MesajeMostrar.setWrapStyleWord(true);
    
        scrollPane = new JScrollPane(MesajeMostrar);
        scrollPane.setPreferredSize(new Dimension(300, 150));

        Loading apertura= new Loading();
        apertura.initializae();
 

       // System.out.println("Fecha actual: " + fechaActual +" "+fechaActual.getDayOfMonth() +" - "+fechaActual.getMonthValue()+" - "+fechaActual.getYear() );
// try {
//   APIResponce data = Converter.fromJsonString("{resp}");
//   Map<String, Double> tazas =  data.getRates();
  
// } catch (Exception e) {
//   System.out.println("falloa");
//   System.out.println(e);
// }

        if(!archivoCreado){// fecha : 2023-03-12 origen : "VEF" destino : "USD"
       
        String[] monedas = { "USD","EUR","JPY","GBP","KRW"};

        try {
          valores.setInformacion("Actualizado desde el dia "+fechaActual.getDayOfMonth()+" - " +fechaActual.getMonthValue()+" - "+fechaActual.getYear());
          for( String codigopais :paises ){
    
          String resp=  api.factorConversion(fechaActual+"", codigopais, "USD,EUR,JPY,GBP,KRW");
         //System.out.println(resp);
          APIResponce data = Converter.fromJsonString(resp);
         Map<String, String> tazas =  data.getRates();
          FactorDeConversion nuevatasa= new FactorDeConversion();
          for (String codigo : monedas) {
         // for (int i =0; i<monedas.length;i++) {

            nuevatasa.setCodigo(codigopais);
            nuevatasa.setOrige(codigo);
            nuevatasa.setUltfechae(fechaActual+"");
            nuevatasa.setValor(tazas.get(codigo));
           
            valores.insertarTasa(codigopais, nuevatasa);
            db.guardarObjeto(nuevatasa);
          //  System.out.println(nuevatasa);
          }
       //   System.out.println(valores.getTasa("COP").toString());
       valores.setMoneda("VEF");
       db.guardarDatos(valores);
      // apertura.dispose();
        }
        } catch (Exception e) {
         // System.out.println("si la api no funciona");
         
         MesajeMostrar.setText("Problema con la API, se utilizara la ultima actualizacion por defecto. Error "+e);
         JOptionPane.showMessageDialog(null, scrollPane, "API Internet Fail", JOptionPane.INFORMATION_MESSAGE);
        //  System.out.println(e);
          // {"ARS", "BOB", "BRL", "CLP", "COP", "CRC","CUC","USD","SVC","HNL","MXN","NIO","PAB","PYG","PEN","DOP","UYU","VEF" };

          FactorDeConversion ingresarTasa = new FactorDeConversion();
          ingresarTasa.setUltfechae("2023-03-15");
          valores.setInformacion("Actualizado desde el 15 de marzo del 2023");

          ingresarTasa.setCodigo("ARS");

          ingresarTasa.setOrige("USD");
          ingresarTasa.setValor("0.004938");
          valores.insertarTasa("ARS", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setOrige("EUR");
          ingresarTasa.setValor("0.004683");
          valores.insertarTasa("ARS", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
          ingresarTasa.setValor("0.655477");
          valores.insertarTasa("ARS", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
          ingresarTasa.setValor("0.004108");
          valores.insertarTasa("ARS", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
          ingresarTasa.setValor("6.515418");
          valores.insertarTasa("ARS", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("BOB");
          ingresarTasa.setOrige("USD");
          ingresarTasa.setValor("0.144661");
          valores.insertarTasa("BOB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
          ingresarTasa.setValor("0.137213");
          valores.insertarTasa("BOB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
          ingresarTasa.setValor("19.203963");
          valores.insertarTasa("BOB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
          ingresarTasa.setValor("0.120366");
          valores.insertarTasa("BOB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
          ingresarTasa.setValor("190.886572");
          valores.insertarTasa("BOB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("BRL");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.18791");
          valores.insertarTasa("BRL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.178235");
          valores.insertarTasa("BRL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("24.945247");
          valores.insertarTasa("BRL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.156351");
          valores.insertarTasa("BRL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("247.954692");
          valores.insertarTasa("BRL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("CLP");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.001213");
          valores.insertarTasa("CLP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.001151");
          valores.insertarTasa("CLP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("0.161066");
          valores.insertarTasa("CLP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.00101");
          valores.insertarTasa("CLP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("1.600985");
          valores.insertarTasa("CLP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("COP");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.000206");
          valores.insertarTasa("COP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.000196");
          valores.insertarTasa("COP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("0.027388");
          valores.insertarTasa("COP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.000172");
          valores.insertarTasa("COP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("0.27224");
          valores.insertarTasa("COP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("CRC");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.001832");
          valores.insertarTasa("CRC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.001737");
          valores.insertarTasa("CRC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("0.243155");
          valores.insertarTasa("CRC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.001524");
          valores.insertarTasa("CRC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("2.416947");
          valores.insertarTasa("CRC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("CUC");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("1");
          valores.insertarTasa("CUC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.94851");
          valores.insertarTasa("CUC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("132.751058");
          valores.insertarTasa("CUC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.83205");
          valores.insertarTasa("CUC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("1319.539841");
          valores.insertarTasa("CUC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("USD");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("1");
          valores.insertarTasa("USD", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.94851");
          valores.insertarTasa("USD", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("132.751058");
          valores.insertarTasa("USD", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.83205");
          valores.insertarTasa("USD", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("1319.539841");
          valores.insertarTasa("USD", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("SVC");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.114157");
          valores.insertarTasa("SVC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.10828");
          valores.insertarTasa("SVC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("15.154528");
          valores.insertarTasa("SVC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.094985");
          valores.insertarTasa("SVC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("150.635358");
          valores.insertarTasa("SVC", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("HNL");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.040535");
          valores.insertarTasa("HNL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.038448");
          valores.insertarTasa("HNL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("5.381034");
          valores.insertarTasa("HNL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.033727");
          valores.insertarTasa("HNL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("53.487248");
          valores.insertarTasa("HNL", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("MXN");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.052485");
          valores.insertarTasa("MXN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.049782");
          valores.insertarTasa("MXN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("6.967388");
          valores.insertarTasa("MXN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.04367");
          valores.insertarTasa("MXN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("69.255537");
          valores.insertarTasa("MXN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("NIO");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.02736");
          valores.insertarTasa("NIO", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.025951");
          valores.insertarTasa("NIO", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("3.63206");
          valores.insertarTasa("NIO", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.022765");
          valores.insertarTasa("NIO", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("36.102526");
          valores.insertarTasa("NIO", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("PAB");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.998895");
          valores.insertarTasa("PAB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.947462");
          valores.insertarTasa("PAB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("132.604365");
          valores.insertarTasa("PAB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.831131");
          valores.insertarTasa("PAB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("1318.081717");
          valores.insertarTasa("PAB", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("PYG");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.000139");
          valores.insertarTasa("PYG", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.000132");
          valores.insertarTasa("PYG", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("0.018452");
          valores.insertarTasa("PYG", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.000116");
          valores.insertarTasa("PYG", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("0.183412");
          valores.insertarTasa("PYG", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("PEN");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.264096");
          valores.insertarTasa("PEN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.250498");
          valores.insertarTasa("PEN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("35.059054");
          valores.insertarTasa("PEN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.219741");
          valores.insertarTasa("PEN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("348.485493");
          valores.insertarTasa("PEN", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("DOP");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.018231");
          valores.insertarTasa("DOP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.017293");
          valores.insertarTasa("DOP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("2.42024");
          valores.insertarTasa("DOP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.015169");
          valores.insertarTasa("DOP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("24.057082");
          valores.insertarTasa("DOP", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("UYU");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.025387");
          valores.insertarTasa("UYU", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.02408");
          valores.insertarTasa("UYU", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("3.370143");
          valores.insertarTasa("UYU", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.021123");
          valores.insertarTasa("UYU", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("33.499081");
          valores.insertarTasa("UYU", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          ingresarTasa.setCodigo("VEF");
          ingresarTasa.setOrige("USD");
            ingresarTasa.setValor("0.041322");
          valores.insertarTasa("VEF", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("EUR");
            ingresarTasa.setValor("0.038744");
          valores.insertarTasa("VEF", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("JPY");
            ingresarTasa.setValor("5.555555");
          valores.insertarTasa("VEF", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("GBP");
            ingresarTasa.setValor("0.034686");
          valores.insertarTasa("VEF", ingresarTasa);
          db.guardarObjeto(ingresarTasa);
          ingresarTasa.setOrige("KRW");
            ingresarTasa.setValor("0.000549");
          valores.insertarTasa("VEF", ingresarTasa);
          db.guardarObjeto(ingresarTasa);

          valores.setMoneda("VEF");
          db.guardarDatos(valores);
        //  apertura.dispose();

        }
        }

       // valores.insertarTasa("VEF", null); 
        
      //  valores.setMoneda("VEF");

    //    List<FactorDeConversion> listadeTasas = valores.getTasa("COP"); 
       
    // if( listadeTasas != null){
    //   listadeTasas.forEach(t -> db.guardarObjeto(t) );
    // }
    
        //FactorDeConversion lectura= db.leerObjeto(1);
        Data dbvalores= db.leerDatos();
if(dbvalores == null){
  valores.setMoneda("VEF");
  valores.setInformacion("Actualizado desde el 15 de marzo del 2023");
}else{
  valores.setMoneda(dbvalores.getMoneda()); // obtener de la base de datos 
  valores.setInformacion(dbvalores.getInformacion());
}
        for( String codigopais :paises ){
          List<FactorDeConversion> lista=  db.leerListaTasas(codigopais); 
           lista.forEach(t ->  valores.insertarTasa(codigopais, t));
       //    lista.forEach(t ->System.out.println(t) );
        }
       // lista.forEach(t ->System.out.println(t) );

        
        

        MainFrame mainframe = new MainFrame();
       
        mainframe.initializae();
        apertura.dispose();
        // db.seCreoElArchivo();
       //  System.out.println( archivoCreado);

        // ApiConsume api = new ApiConsume();
        // try {
        //     api.convertir("COP", "USD", "120000");   
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }

        

        // System.out.println( "end World!" );
    }
}
