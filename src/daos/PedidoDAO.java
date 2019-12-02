package daos;

import entidades.Pedido;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import servicios.EntidadServicio;
import util.DBConn;

public class PedidoDAO implements EntidadServicio<Pedido>{
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;
    
    @Override
    public int crearEntidad(Pedido pedido) {
        int filas=0;
        Calendar fecha = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(fecha.getTime().getTime());
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_pedido(?,?,?,?,?)}");
            cst.setInt(1,pedido.getIdUsuario());  
            cst.setTimestamp(2, currentTimestamp);  
            cst.setDouble(3,pedido.getTotal());           
            cst.setInt(4,pedido.getNumMesa());
            cst.setInt(5,pedido.getEstado());
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Pedido> listarEntidad() {
        ArrayList<Pedido> lPedido = new ArrayList<>();
        Pedido pedido;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_pedido}");
           rs = cst.executeQuery();
           while(rs.next()){
               pedido=new Pedido();
               pedido.setIdPedido(rs.getInt(1));
               pedido.setIdUsuario(rs.getInt(2));
               pedido.setFecha(rs.getDate(3));
               pedido.setTotal(rs.getDouble(4));
               pedido.setNumMesa(rs.getInt(5));
               pedido.setEstado(rs.getInt(6));
               lPedido.add(pedido);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lPedido;
    }

    @Override
    public Pedido buscarEntidad(int id) {
        Pedido pedido = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_pedido(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               pedido=new Pedido();
               pedido.setIdPedido(rs.getInt(1));
               pedido.setIdUsuario(rs.getInt(2));
               pedido.setFecha(rs.getDate(3));
               pedido.setTotal(rs.getDouble(4));
               pedido.setNumMesa(rs.getInt(5));
               pedido.setEstado(rs.getInt(7));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return pedido;
    }
    
    public int buscarMayor() {
        int id=0;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_mayor}");
           rs = cst.executeQuery();
           if(rs.next()){
               id = rs.getInt(1);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return id;
    }
    
    public Pedido VerificarMesa(int num) {
        Pedido pedido = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_verificar_mesa(?)}");
           cst.setInt(1,num);
           rs = cst.executeQuery();
           if(rs.next()){
               pedido=new Pedido();
               pedido.setIdPedido(rs.getInt(1));
               pedido.setIdUsuario(rs.getInt(2));
               pedido.setFecha(rs.getDate(3));
               pedido.setTotal(rs.getDouble(4));
               pedido.setNumMesa(rs.getInt(5));
               pedido.setEstado(rs.getInt(6));
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return pedido;
    }

    @Override
    public int actualizarEntidad(Pedido pedido) {
        return 0;
    }    
    
    public int actualizarEstado(int idPed, int est) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_pedidoest(?,?)}");
            cst.setInt(1,idPed);
            cst.setInt(2,est);     
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return filas;
    }
    
    public int actualizarTotal(int idPed, double tot) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_total(?,?)}");
            cst.setInt(1,idPed);
            cst.setDouble(2,tot);     
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
            cst = con.prepareCall("{Call sp_eliminar_pedido(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    
    public double calcularTotal(int id) {
        double total=0;
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_calcular_total(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){                
                total = rs.getDouble(1);
            }
            con.close();
        } 
        catch (SQLException ex) {
            total = 0;
        }
        return total;
    }
    
    public double calcularTotalDiario(Date fec) {
        double total=0;
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_calcular_total_Diario(?)}");
            cst.setDate(1,fec);
            rs = cst.executeQuery();
            if(rs.next()){                
                total = rs.getDouble(1);
            }
            con.close();
        } 
        catch (SQLException ex) {
            total = 0;
        }
        return total;
    }
    
    public double calcularTotalMensual(int mes, int año) {
        double total=0;
        try{
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_calcular_total_Mensual(?,?)}");
            cst.setInt(1,mes);
            cst.setInt(2,año);
            rs = cst.executeQuery();
            if(rs.next()){                
                total = rs.getDouble(1);
            }
            con.close();
        } 
        catch (SQLException ex) {
            total = 0;
        }
        return total;
    }
}
