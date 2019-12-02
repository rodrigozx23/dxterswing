package daos;
import entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.EntidadServicio;
import util.DBConn;

public class UsuarioDAO implements EntidadServicio<Usuario> {
    private Connection con;
    private CallableStatement cst;
    private ResultSet  rs;
    
    @Override
    public int crearEntidad(Usuario usuario) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{CALL sp_insertar_usuario(?,?,?,?)}");
            cst.setString(1,usuario.getUsuario());
            cst.setString(2,usuario.getPassword());
            cst.setInt(3,usuario.getTipo());
            cst.setInt(4,usuario.getEstado());
            
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }

    @Override
    public ArrayList<Usuario> listarEntidad() {
        
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        Usuario usuario;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_usuario}");
           rs = cst.executeQuery();
           while(rs.next()){
               usuario=new Usuario();
               usuario.setIdUsuario(rs.getInt(1));
               usuario.setUsuario(rs.getString(2));
               usuario.setPassword(rs.getString(3));
               usuario.setTipo(rs.getInt(4));
               usuario.setEstado(rs.getInt(5));
               lUsuario.add(usuario);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lUsuario;
    }
     public ArrayList<Usuario> listarUsuarios() {
        
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        Usuario usuario;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{CALL sp_listar_usuarioAdmin}");
           rs = cst.executeQuery();
           while(rs.next()){
               usuario=new Usuario();
               usuario.setIdUsuario(rs.getInt(1));
               usuario.setUsuario(rs.getString(2));
               usuario.setPassword(rs.getString(3));
               usuario.setTipo(rs.getInt(4));
               usuario.setEstado(rs.getInt(5));
               lUsuario.add(usuario);
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return lUsuario;
    }
    @Override
    public Usuario buscarEntidad(int id) {
        
        Usuario usuario = null;
        try{
           con = DBConn.getConnection();
           cst = con.prepareCall("{Call sp_buscar_usuario(?)}");
           cst.setInt(1,id);
           rs = cst.executeQuery();
           if(rs.next()){
               usuario=new Usuario();
               usuario.setIdUsuario(rs.getInt(1));
               usuario.setUsuario(rs.getString(2));
               usuario.setPassword(rs.getString(3));
               usuario.setTipo(rs.getInt(4));
               usuario.setEstado(rs.getInt(5));    
           }
           con.close();
        }catch(SQLException ex){
            
        }
        return usuario;
    }
    
    @Override
    public int actualizarEntidad(Usuario usuario) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_actualizar_usuario(?,?,?,?,?)}");
            cst.setInt(1,usuario.getIdUsuario());
            cst.setString(2,usuario.getUsuario());
            cst.setString(3,usuario.getPassword());  
            cst.setInt(4,usuario.getTipo());
            cst.setInt(5,usuario.getEstado());
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
            cst = con.prepareCall("{Call sp_eliminar_usuario(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    
    public int CambiarContraseña(int id, String pass) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_cambiar_contraseña(?,?)}");
            cst.setInt(1,id);  
            cst.setString(2,pass);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
    
    public Usuario Ingresar(String usu, String pass){        
        Usuario u = new Usuario();
        try {
            ResultSet rs = null;
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_ingresar(?,?)}");              
            cst.setString(1,usu);
            cst.setString(2,pass);
          
            rs=cst.executeQuery();
            if (rs.next())
            {
                u = buscarEntidad(rs.getInt(1));
            }
           
        } catch (SQLException ex) {            
                              
        }
        return u;
    }
    
    public int ContraseñaCambiada(int id) {        
        int filas=0;
        try {
            con = DBConn.getConnection();
            cst = con.prepareCall("{Call sp_contraseña_cambiada(?)}");
            cst.setInt(1,id);
            filas = cst.executeUpdate();
        } catch (SQLException ex) {
            filas = 1;
        }
        return filas;
    }
}
