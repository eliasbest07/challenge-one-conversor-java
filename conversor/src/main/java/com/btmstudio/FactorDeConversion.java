package com.btmstudio;

public class FactorDeConversion {
   private String codigo;
   private String origen;
   private String valor;
   private String ultfecha;

   public FactorDeConversion(){

   }
   public String getCodigo() {
    return codigo;
    }
    void setCodigo(String codigo){
        this.codigo =codigo;
    }

    public String getOrige() {
        return origen;
        }
    void setOrige(String origen){
       this.origen =origen;
    }
    public String getValor() {
        return valor;
        }
        void setValor(String valor){
            this.valor =valor;
        }
    
        public String getUltfecha() {
            return ultfecha;
            }
        void setUltfechae(String ultfecha){
           this.ultfecha =ultfecha;
        }
        @Override
        public String toString() {
           return "ORIGEN "+origen+" Valor "+valor+" CODIGO "+codigo;
        }

}
