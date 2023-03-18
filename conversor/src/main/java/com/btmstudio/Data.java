package com.btmstudio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    
    private static Data instancia;

    private String moneda;
    Map<String, List<FactorDeConversion>> tasasMonedas = new HashMap<>();
    private String informacion;
    
    public Data() {
       
    }
    public static Data Instancia() {
        if (instancia == null) {
            instancia = new Data();
        }
        return instancia;
    }

    public String getMoneda(){
        return moneda;
    }
    public void setMoneda(String moneda){
        this.moneda=moneda;
    }
    public String getInformacion(){
        return informacion;
    }
    public void setInformacion(String informacion){
        this.informacion=informacion;
    }
    
    public void insertarTasa(String codigo,FactorDeConversion conversion ){
        if(tasasMonedas.get(codigo) == null ){
            List<FactorDeConversion> valores = new ArrayList<>();
            valores.add(conversion);
            tasasMonedas.put(codigo, valores);
        }else{
            List<FactorDeConversion> valores = tasasMonedas.get(codigo);
            valores.add(conversion);
            tasasMonedas.put(codigo, valores);
        }
    }
    public List<FactorDeConversion> getTasa(String codigo){
        return tasasMonedas.get(codigo);
    }
    public void borrarTasa(String codigo){
        List<FactorDeConversion> nueva = new ArrayList<>();
        tasasMonedas.put(codigo, nueva);
    }
}
