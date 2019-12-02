package daos;

import entidades.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.EntidadServicio;
import util.DBConn;


public class ProductoDAO implements EntidadServicio<Producto>{
    private Connection con;
    private CallableStatement cst;
    private PreparedStatement pst;
    private ResultSet  rs;

    @Override
    public int crearEntidad(Producto producto) {
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_producto(?,?,?,?,?)}");
            cst.setString(1,producto.getNombre());
            cst.setDouble(2,producto.getCosto());
            cst.setInt(3,producto.getIdCategoria());
            cst.setInt(4,producto.getIdSubCategoria());
            //cst.setInt(5,producto.getStock());
            cst.setInt(5,producto.getEstado());
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Producto> listarEntidad() {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_producto}");
           rs = cst.executeQuery();
           while(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setIdSubCategoria(rs.getInt(5));
               producto.setEstado(rs.getInt(6));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    
    public ArrayList<Producto> listarProducto() {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_productoAdmin}");
           rs = cst.executeQuery();
           while(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setNombreCategoria(rs.getString(5));
               producto.setIdSubCategoria(rs.getInt(6));
               producto.setNombreSubCategoria(rs.getString(7));
               producto.setEstado(rs.getInt(8));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    //nuevofiltroparastockXcategoria
    public ArrayList<Producto> filtrarProductoStock(int id) {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_ProductoStock(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    
    public ArrayList<Producto> filtrarProductoCat(int id) {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_filtrar_Producto_cat(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setNombreCategoria(rs.getString(5));
               producto.setIdSubCategoria(rs.getInt(6));
               producto.setNombreSubCategoria(rs.getString(7));
               producto.setEstado(rs.getInt(8));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    
    public ArrayList<Producto> filtrarProductoSubCat(int id) {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_filtrar_Producto_subcat(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setNombreCategoria(rs.getString(5));
               producto.setIdSubCategoria(rs.getInt(6));
               producto.setNombreSubCategoria(rs.getString(7));
               producto.setEstado(rs.getInt(8));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    
    public ArrayList<Producto> FiltrarEntidadTXT(String nom) {        
        ArrayList<Producto> lProducto = new ArrayList<>();
        Producto producto;
        try{
           String sql= "Select idProducto,"
                   + "tb_Producto.nombre,"
                   + "costo,"
                   + "tb_Producto.idcategoria,"
                   + "tb_categoria.nombre as categoria,"
                   + "tb_Producto.idsubcategoria,"
                   + "tb_subcategoria.nombre as subcategoria "
                   + "from tb_Producto, tb_categoria, tb_SubCategoria "
                   + "where tb_Producto.idcategoria = tb_categoria.idcategoria "
                   + "and tb_Producto.idsubcategoria = tb_SubCategoria.idSubCategoria "
                   + "and tb_Producto.nombre like '%"+ nom +"%' ";
           con = DBConn.getConnection();
           pst = con.prepareStatement(sql);
           rs = pst.executeQuery();
           while(rs.next()){ 
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setNombreCategoria(rs.getString(5));
               producto.setIdSubCategoria(rs.getInt(6));
               producto.setNombreSubCategoria(rs.getString(7));
               lProducto.add(producto);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lProducto;
    }
    

    @Override
    public Producto buscarEntidad(int id) {
        Producto producto = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_producto(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               producto=new Producto();
               producto.setIdProducto(rs.getInt(1));
               producto.setNombre(rs.getString(2));
               producto.setCosto(rs.getDouble(3));
               producto.setIdCategoria(rs.getInt(4));
               producto.setIdSubCategoria(rs.getInt(5));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return producto;
    }
    
    @Override
    public int actualizarEntidad(Producto producto) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_producto(?,?,?,?,?,?,?)}");
            cst.setInt(1,producto.getIdProducto());
            cst.setString(2,producto.getNombre());
            cst.setDouble(3,producto.getCosto());
            cst.setInt(4,producto.getIdCategoria());
            cst.setInt(5,producto.getIdSubCategoria());
            cst.setInt(6,producto.getStock());
            cst.setInt(7,producto.getEstado());
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
            cst = con.prepareCall("{Call sp_eliminar_producto(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    public int buscarMayor() {
        int id=0;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_mayor_p}");
           rs = cst.executeQuery();
           if(rs.next()){
               id = rs.getInt(1);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return id;
    }
}
