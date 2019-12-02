package daos;

import entidades.SubCategoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.EntidadServicio;
import util.DBConn;

public class SubCategoriaDAO implements EntidadServicio<SubCategoria> {
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;

    @Override
    public int crearEntidad(SubCategoria sc) {
        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_subcategoria(?,?,?)}");
            cst.setString(1,sc.getNombre());
            cst.setInt(2,sc.getIdCategoria());
            cst.setInt(3,sc.getEstado());
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<SubCategoria> listarEntidad() {
                
        ArrayList<SubCategoria> lSubCategoria = new ArrayList<>();
        SubCategoria subcategoria;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_subcategoria}");
           rs = cst.executeQuery();
           while(rs.next()){
               subcategoria=new SubCategoria();
               subcategoria.setIdSubCategoria(rs.getInt(1));
               subcategoria.setNombre(rs.getString(2));
               subcategoria.setIdCategoria(rs.getInt(3));
               subcategoria.setEstado(rs.getInt(4));
               lSubCategoria.add(subcategoria);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lSubCategoria;
    }
    
    public ArrayList<SubCategoria> listarSubCategoria() {
                
        ArrayList<SubCategoria> lSubCategoria = new ArrayList<>();
        SubCategoria subcategoria;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_subcategoriaAdmin}");
           rs = cst.executeQuery();
           while(rs.next()){
               subcategoria=new SubCategoria();
               subcategoria.setIdSubCategoria(rs.getInt(1));
               subcategoria.setNombre(rs.getString(2));
               subcategoria.setIdCategoria(rs.getInt(3));
               subcategoria.setNomCategoria(rs.getString(4));
               subcategoria.setEstado(rs.getInt(5));
               lSubCategoria.add(subcategoria);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lSubCategoria;
    }
    
    public ArrayList<SubCategoria> filtrarSubCategoriaCat(int id) {        
        ArrayList<SubCategoria> lSubCategoria = new ArrayList<>();
        SubCategoria subCategoria;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_filtrar_subcategoria_cat(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               subCategoria=new SubCategoria();
               subCategoria.setIdSubCategoria(rs.getInt(1));
               subCategoria.setNombre(rs.getString(2));
               subCategoria.setIdCategoria(rs.getInt(3));
               subCategoria.setEstado(rs.getInt(4));
               lSubCategoria.add(subCategoria);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lSubCategoria;
    }

    @Override
    public SubCategoria buscarEntidad(int id) {
        SubCategoria subcategoria = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_subcategoria(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               subcategoria=new SubCategoria();
               subcategoria.setIdSubCategoria(rs.getInt(1));
               subcategoria.setNombre(rs.getString(2));               
               subcategoria.setIdCategoria(rs.getInt(3));
               subcategoria.setEstado(rs.getInt(4));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return subcategoria;
    }

    @Override
    public int actualizarEntidad(SubCategoria subcategoria) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_subcategoria(?,?,?,?)}");
            cst.setInt(1,subcategoria.getIdSubCategoria());
            cst.setString(2,subcategoria.getNombre());            
            cst.setInt(3,subcategoria.getIdCategoria());
            cst.setInt(4,subcategoria.getEstado());
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return filas;
    }

    @Override
    public int eliminarEntidad(int id) {                
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_eliminar_subcategoria(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
}
