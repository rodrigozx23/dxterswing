package daos;

import entidades.Block;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.EntidadServicio;
import util.DBConn;

public class BlockDAO {
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;
    
    public boolean obtenerBlock() {
        boolean b = true;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_obtener_block}");
           rs = cst.executeQuery();
           while(rs.next()){
              b = rs.getBoolean(1);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return b;
    }
    
    public int actualizarBlock(boolean b) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_block(?)}");
            cst.setBoolean(1,b);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return filas;
    }
}