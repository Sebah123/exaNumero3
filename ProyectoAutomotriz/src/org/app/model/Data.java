package org.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.app.model.Conexion;

public class Data {

    private Conexion con;
    
    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("prueba3_poo");
    }

    public void RegistrarAutomovil(Automovil a) throws SQLException {
        String insert = "INSERT INTO automovil VALUES"
                + "('" + a.getPatente() + "',"
                + "'" + a.getMarca() + "',"
                + "'" + a.isEstado() + "',"
                + "'" + a.getPrecio() + "',"
                + "'" + a.getRed() + "',"
                + "'" + a.getGreen() + "',"
                + "'" + a.getBlue() + "')";
        con.ejecutar(insert);
        con.close();
    }

    public List<Automovil> getAutomovil() throws SQLException {
        List<Automovil> lista = new ArrayList<>();

        String query = "SELECT * FROM automovil ORDER BY precio DESC;";
        ResultSet rs = con.ejecutar(query);

        while (rs.next()) {
            Automovil auto = new Automovil();
            
            auto.setPatente(rs.getString("patente"));
            auto.setMarca(rs.getString("marca"));
            auto.setEstado(rs.getBoolean("estado"));
//            ??
            auto.setPrecio(rs.getLong("precio"));
            //???
            auto.setRed(rs.getInt("red"));
            auto.setGreen(rs.getInt("green"));
            auto.setBlue(rs.getInt("blue"));
            
            
        }
        con.close();
        return lista;
    }
}
