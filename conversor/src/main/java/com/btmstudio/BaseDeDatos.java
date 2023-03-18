package com.btmstudio;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private Connection conexion;

    public BaseDeDatos() {
        try {
            // Cargar el controlador JDBC para SQLite en memoria
            Class.forName("org.sqlite.JDBC");
            // Establecer la conexión a la base de datos
            this.conexion = DriverManager.getConnection("jdbc:sqlite:hotdata.db");
            // Crear la tabla si no existe
            PreparedStatement statement1 = conexion.prepareStatement(
                "CREATE TABLE IF NOT EXISTS objetos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigo TEXT," +
                "origen TEXT," +
                "ultfecha TEXT," +
                "valor TEXT" +
                ");"
            );
            statement1.executeUpdate();
            statement1.close();
            
            PreparedStatement statement2 = conexion.prepareStatement(
                "CREATE TABLE IF NOT EXISTS datos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "moneda TEXT," +
                "informacion TEXT" +
                ");"
            );
            statement2.executeUpdate();
            statement2.close();
            //this.archivoCreado = true;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);

           // this.archivoCreado = false;
            e.printStackTrace();
        }
        // this.archivoCreado = false;
    }
    
    public void guardarObjeto(FactorDeConversion objeto) {
        try {
            // Insertar un nuevo objeto en la tabla
            PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO objetos (codigo, origen, ultfecha, valor) VALUES (?, ?, ?, ?);");
            statement.setString(1, objeto.getCodigo());
            statement.setString(2, objeto.getOrige());
            statement.setString(3, objeto.getUltfecha());
            statement.setString(4, objeto.getValor());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void guardarDatos(Data data) {
        try {
            PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO datos (moneda, informacion) VALUES (?, ?);");
            statement.setString(1, data.getMoneda());
            statement.setString(2, data.getInformacion());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public FactorDeConversion leerObjeto(int id) {
        try {
            // Obtener el objeto con el id especificado de la tabla
            PreparedStatement statement = conexion.prepareStatement(
                "SELECT * FROM objetos WHERE id = ?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            FactorDeConversion objeto = null;
            if (resultado.next()) {
                objeto = new FactorDeConversion();
                objeto.setCodigo(resultado.getString("codigo"));
                objeto.setOrige(resultado.getString("origen"));
                objeto.setUltfechae(resultado.getString("ultfecha"));
                objeto.setValor(resultado.getString("valor"));
            }
            resultado.close();
            statement.close();
            return objeto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);

            e.printStackTrace();
            return null;
        }
    }
    public Data leerDatos() {
        try {
            // Obtener el objeto con el id especificado de la tabla
            PreparedStatement statement = conexion.prepareStatement(
                "SELECT * FROM datos WHERE id = ?;");
            statement.setInt(1, 1);
            ResultSet resultado = statement.executeQuery();
            Data objeto = null;
            if (resultado.next()) {
                objeto = new Data();
                objeto.setMoneda(resultado.getString("moneda"));
                objeto.setInformacion(resultado.getString("informacion"));
              
            }
            resultado.close();
            statement.close();
            return objeto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);

            e.printStackTrace();
            return null;
        }
    }
    public List<FactorDeConversion> leerListaTasas(String codigo) {
        try {
            // Obtener los objetos con el id especificado de la tabla
            PreparedStatement statement = conexion.prepareStatement(
                "SELECT * FROM objetos WHERE codigo = ?;");
            statement.setString(1, codigo);
            ResultSet resultado = statement.executeQuery();
            List<FactorDeConversion> listaTasas = new ArrayList<>();
            while (resultado.next()) {
                FactorDeConversion objeto = new FactorDeConversion();
                objeto.setCodigo(resultado.getString("codigo"));
                objeto.setOrige(resultado.getString("origen"));
                objeto.setUltfechae(resultado.getString("ultfecha"));
                objeto.setValor(resultado.getString("valor"));
                listaTasas.add(objeto);
            }
            resultado.close();
            statement.close();
            return listaTasas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    public void actualizarTasa(FactorDeConversion actualizar) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:hotdata.db");
        PreparedStatement stmt = conn.prepareStatement("UPDATE objetos SET ultfecha = ?, valor = ? WHERE codigo = ? AND origen = ?");
        stmt.setString(1, actualizar.getUltfecha());
        stmt.setString(2, actualizar.getValor());
        stmt.setString(3, actualizar.getCodigo());
        stmt.setString(4, actualizar.getOrige());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    public void actualizarData(Data actualizar) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:hotdata.db");
        PreparedStatement stmt = conn.prepareStatement("UPDATE datos SET moneda = ?, informacion = ? WHERE id = ?");
        stmt.setString(1, actualizar.getMoneda());
        stmt.setString(2, actualizar.getInformacion());
        stmt.setInt(3, 1);
    
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}