package org.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.app.model.Automovil;
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
}
