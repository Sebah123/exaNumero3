package org.app.model.tableModel;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.app.model.Automovil;

public class TMAutomoviles extends AbstractTableModel {

    private List<Automovil> lista;

    public TMAutomoviles(List<Automovil> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Automovil a = lista.get(rowIndex);
        long num = 0;
        switch (columnIndex) {
            case 0:
                return a.getPatente();
            case 1:
                return a.getMarca();
            case 2:
                if (a.getEstado() == 0) {
                    return "Usado";
                }
                if (a.getEstado() == 1) {
                    return "Nuevo";
                }
            case 3:
                DecimalFormat formateador = new DecimalFormat("###,###.##");
                
                return "$ "+(formateador.format(a.getPrecio()));
            default:
                return a.getRed() + "," + a.getGreen() + "," + a.getBlue();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Patente";
            case 1:
                return "Marca";
            case 2:
                return "Estado";
            case 3:
                return "Precio";
            default:
                return "Color";
        }
    }
}
