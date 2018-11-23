package org.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Data {

    private Conexion con;
    
    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("prueba3_poo");
    }

    public void RegistrarAutomovil(Automovil a) throws SQLException {
        String insert = "INSERT INTO automovil VALUES"
                + "('" + a.getPatente() + "',"
                + "'" + a.getMarca() + "',"
                + "'" + a.getEstado() + "',"
                + "'" + a.getPrecio() + "',"
                + "'" + a.getRed() + "',"
                + "'" + a.getGreen() + "',"
                + "'" + a.getBlue() + "')";
        con.ejecutar(insert);
        con.close();
    }

    public List<Automovil> getAutomovil() throws SQLException {
        List<Automovil> lista = new ArrayList<>();  
        
        String query = "SELECT * FROM automovil ORDER BY precio DESC";
        ResultSet rs = con.ejecutar(query);

        while (rs.next()) {
            Automovil auto = new Automovil();
            
            auto.setPatente(rs.getString(1));
            auto.setMarca(rs.getString(2));
            auto.setEstado(rs.getBoolean(3));
//            ??
            auto.setPrecio(rs.getLong(4));
            //???
            auto.setRed(rs.getInt(5));
            auto.setGreen(rs.getInt(6));
            auto.setBlue(rs.getInt(7));
            
            lista.add(auto);
            
        }
        con.close();
        return lista;
    }
    
    public int getNumeroDeAutos() throws SQLException{
     int contador = 0;
     ResultSet rs = con.ejecutar("SELECT COUNT(0) FROM automovil");
     if (rs.next()){
         contador = rs.getInt(1);
         System.out.println(contador);
     }
     return contador;
    }
    public int getNumeroDeAutosUsados() throws SQLException{
        int contador = 0;
        ResultSet rs = con.ejecutar("SELECT COUNT(0) FROM automovil WHERE estado = '0'");
        if(rs.next()){
            contador = rs.getInt(1);
            System.out.println("usados :"+contador);
        }
        return contador;
    }
    public int getNumeroDeAutosNuevos() throws SQLException{
        int contador = 0;
        ResultSet rs = con.ejecutar("SELECT COUNT(0) FROM automovil WHERE estado = '1'");
        if (rs.next()){
            contador = rs.getInt(1);
            System.out.println("nuevos: "+contador);
        }
        return contador;
    }
}
