package daos;

import entidades.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.EntidadServicio;
import util.DBConn;

public class CategoriaDAO implements EntidadServicio<Categoria> {
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;
    
    @Override
    public int crearEntidad(Categoria categoria) {
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_categoria(?,?)}");
            cst.setString(1,categoria.getNombre());
            cst.setInt(2,categoria.getEstado());
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Categoria> listarEntidad() {        
        ArrayList<Categoria> lCategoria = new ArrayList<>();
        Categoria categoria;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_categoria}");
           rs = cst.executeQuery();
           while(rs.next()){
               categoria=new Categoria();
               categoria.setIdCategoria(rs.getInt(1));
               categoria.setNombre(rs.getString(2));
               categoria.setEstado(rs.getInt(3));
               lCategoria.add(categoria);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lCategoria;
    }
    
    public ArrayList<Categoria> listarCategoria() {        
        ArrayList<Categoria> lCategoria = new ArrayList<>();
        Categoria categoria;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_categoriaAdmin}");
           rs = cst.executeQuery();
           while(rs.next()){
               categoria=new Categoria();
               categoria.setIdCategoria(rs.getInt(1));
               categoria.setNombre(rs.getString(2));
               categoria.setEstado(rs.getInt(3));
               lCategoria.add(categoria);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lCategoria;
    }
    
    @Override
    public Categoria buscarEntidad(int id) {
        Categoria categoria = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_categoria(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               categoria=new Categoria();
               categoria.setIdCategoria(rs.getInt(1));
               categoria.setNombre(rs.getString(2));
               categoria.setEstado(rs.getInt(3));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return categoria;
    }

    @Override
    public int actualizarEntidad(Categoria categoria) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_categoria(?,?,?)}");
            cst.setInt(1,categoria.getIdCategoria());
            cst.setString(2,categoria.getNombre());
            cst.setInt(3,categoria.getEstado());
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
            cst = con.prepareCall("{Call sp_eliminar_categoria(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
}
