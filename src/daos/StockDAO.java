package daos;

import entidades.Stock;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.EntidadServicio;
import util.DBConn;

public class StockDAO implements EntidadServicio<Stock>{
    private Connection con;
    private CallableStatement cst;
    private PreparedStatement pst;
    private ResultSet  rs;
    @Override
    public int crearEntidad(Stock stock) {
       int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_Stock(?,?,?)}");
            cst.setInt(1,stock.getIdProducto());
            cst.setInt(2,stock.getStock());
            cst.setInt(3,stock.getEstado());                     
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Stock> listarEntidad() {
        ArrayList<Stock> lStock = new ArrayList<>();
        Stock stock;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_stock}");
           rs = cst.executeQuery();
           while(rs.next()){
               stock=new Stock();
               stock.setIdStock(rs.getInt(1));
               stock.setIdProducto(rs.getInt(2));
               stock.setStock(rs.getInt(3));
               stock.setEstado(rs.getInt(4));               
               lStock.add(stock);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lStock;
    }
    public ArrayList<Stock> listarStock() {        
        ArrayList<Stock> lStock = new ArrayList<>();
        Stock stock;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_stockADM}");
           rs = cst.executeQuery();
           while(rs.next()){
               stock=new Stock();
               stock.setIdStock(rs.getInt(1));
               stock.setIdProducto(rs.getInt(2));
               stock.setNombreProducto(rs.getString(3));
               stock.setStock(rs.getInt(4));               
               lStock.add(stock);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lStock;
    }
    
    @Override
    public Stock buscarEntidad(int id) {
        Stock stock = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_stock(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               stock=new Stock();
               stock.setIdStock(rs.getInt(1));
               stock.setIdProducto(rs.getInt(2));
               stock.setStock(rs.getInt(3));
               stock.setEstado(rs.getInt(4));
               
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return stock;
    }
    public ArrayList<Stock> buscarProductoStock(int id) {        
        ArrayList<Stock> lStock = new ArrayList<>();
        Stock stock;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{call sp_buscar_ProductoStock(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               stock = new Stock();
               stock.setIdProducto(rs.getInt(1));               
               stock.setIdSubCategoria(rs.getInt(2));
               stock.setNombreProducto(rs.getString(3));
               stock.setStock(rs.getInt(4));
               lStock.add(stock);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lStock;
    }
    
    @Override
    public int actualizarEntidad(Stock stock) {
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_stock(?,?,?)}");
            cst.setInt(1,stock.getIdProducto());
            cst.setInt(2,stock.getStock());
            cst.setInt(3,stock.getEstado());
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
            cst = con.prepareCall("{Call sp_eliminar_stock(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    public int agregarStock(Stock stock) {
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_ingresar_stock(?,?)}");
            cst.setInt(1,stock.getIdProducto());
            cst.setInt(2,stock.getStock());
                        
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    public int quitarStock(Stock stock) {
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_restar_stock(?,?)}");
            cst.setInt(1,stock.getIdProducto());
            cst.setInt(2,stock.getStock());
                        
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    public ArrayList<Stock> filtrarProductoSubCat(int id) {        
        ArrayList<Stock> lStock = new ArrayList<>();
        Stock stock;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{call sp_listar_ProductoSCatStock(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               stock = new Stock();
               stock.setIdStock(rs.getInt(1));
               stock.setIdProducto(rs.getInt(2));
               stock.setNombreProducto(rs.getString(3));
               stock.setStock(rs.getInt(4));                 
               lStock.add(stock);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lStock;
     }
     public ArrayList<Stock> filtrarProductoCat(int id) {        
        ArrayList<Stock> lStock = new ArrayList<>();
        Stock stock;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{call sp_listar_ProductoCatStock(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           while(rs.next()){
               stock = new Stock();
               stock.setIdStock(rs.getInt(1));
               stock.setIdProducto(rs.getInt(2));
               stock.setNombreProducto(rs.getString(3));
               stock.setStock(rs.getInt(4));                 
               lStock.add(stock);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lStock;
    }
}
