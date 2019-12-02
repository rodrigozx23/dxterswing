
package daos;

import entidades.Movimientos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import servicios.EntidadServicio;
import util.DBConn;

public class MovimientosDAO implements EntidadServicio<Movimientos>{
    private Connection con;
    private CallableStatement cst;
    private PreparedStatement pst;
    private ResultSet  rs;

    @Override
    public int crearEntidad(Movimientos movimientos) {
        int filas=0;
        
        Calendar fecha = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(fecha.getTime().getTime());
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_Movimientos(?,?,?,?)}");
            cst.setInt(1,movimientos.getIdStock());  
            cst.setDouble(2,movimientos.getCantidad()); 
            cst.setInt(3,movimientos.getTipoMov());
            cst.setTimestamp(4, currentTimestamp);                     
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Movimientos> listarEntidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimientos buscarEntidad(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarEntidad(Movimientos t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminarEntidad(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
