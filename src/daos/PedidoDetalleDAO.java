package daos;

import entidades.PedidoDetalle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import servicios.EntidadServicio;
import util.DBConn;

public class PedidoDetalleDAO implements EntidadServicio<PedidoDetalle> {
	private Connection con;
	private CallableStatement cst;
	private ResultSet rs;

	@Override
	public int crearEntidad(PedidoDetalle pedidodetalle) {
		int filas = 0;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{CALL sp_insertar_pedidodet(?,?,?,?)}");
			cst.setInt(1, pedidodetalle.getIdProducto());
			cst.setInt(2, pedidodetalle.getCantidad());
			cst.setInt(3, pedidodetalle.getIdPedido());
			cst.setInt(4, pedidodetalle.getEstado());
			filas = cst.executeUpdate();
		} catch (SQLException ex) {
			filas = 1;
		}
		return filas;
	}

	public PedidoDetalle VerificarProducto(int idped, int idpro) {
		PedidoDetalle pdet = null;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_verificar_producto(?,?)}");
			cst.setInt(1, idped);
			cst.setInt(2, idpro);
			rs = cst.executeQuery();
			if (rs.next()) {
				pdet = new PedidoDetalle();
				pdet.setIdPedDet(rs.getInt(1));
				pdet.setIdProducto(rs.getInt(2));
				pdet.setCantidad(rs.getInt(3));
				pdet.setIdPedido(rs.getInt(4));
				pdet.setEstado(rs.getInt(5));
			}
			con.close();
		} catch (SQLException ex) {

		}
		return pdet;
	}

	@Override
	public ArrayList<PedidoDetalle> listarEntidad() {
		ArrayList<PedidoDetalle> lPedidoDetalle = new ArrayList<>();
		PedidoDetalle pedidodetalle;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{CALL sp_listar_pedidodetalle}");
			rs = cst.executeQuery();
			while (rs.next()) {
				pedidodetalle = new PedidoDetalle();
				pedidodetalle.setIdPedDet(rs.getInt(1));
				pedidodetalle.setIdProducto(rs.getInt(2));
				pedidodetalle.setNombre(rs.getString(3));
				pedidodetalle.setCantidad(rs.getInt(4));
				pedidodetalle.setIdPedido(rs.getInt(5));
				pedidodetalle.setEstado(rs.getInt(6));
				lPedidoDetalle.add(pedidodetalle);
			}
			con.close();
		} catch (SQLException ex) {

		}
		return lPedidoDetalle;
	}

	public ArrayList<PedidoDetalle> listarDetalle(int id) {
		ArrayList<PedidoDetalle> lPedidoDetalle = new ArrayList<>();
		PedidoDetalle pedidodetalle;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{CALL sp_listar_Detalle(?)}");
			cst.setInt(1, id);
			rs = cst.executeQuery();
			while (rs.next()) {
				pedidodetalle = new PedidoDetalle();
				pedidodetalle.setIdPedDet(rs.getInt(1));
				pedidodetalle.setIdProducto(rs.getInt(2));
				pedidodetalle.setNombre(rs.getString(3));
				pedidodetalle.setCantidad(rs.getInt(4));
				pedidodetalle.setCosto(rs.getDouble(5));
				pedidodetalle.setIdPedido(rs.getInt(6));
				pedidodetalle.setEstado(rs.getInt(7));
				lPedidoDetalle.add(pedidodetalle);
			}
			con.close();
		} catch (SQLException ex) {

		}
		return lPedidoDetalle;
	}

	public ArrayList<PedidoDetalle> listarDiario(java.sql.Date fecha) {
		ArrayList<PedidoDetalle> lPedidoDetalle = new ArrayList<>();
		PedidoDetalle pedidodetalle;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{CALL sp_Listar_Diario(?)}");
			cst.setDate(1, fecha);
			rs = cst.executeQuery();
			while (rs.next()) {
				pedidodetalle = new PedidoDetalle();
				pedidodetalle.setIdProducto(rs.getInt(1));
				pedidodetalle.setNombre(rs.getString(2));
				pedidodetalle.setCantidad(rs.getInt(3));
				pedidodetalle.setCosto(rs.getDouble(4));
				pedidodetalle.setTotal(rs.getDouble(5));
				lPedidoDetalle.add(pedidodetalle);
			}
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return lPedidoDetalle;
	}

	public ArrayList<PedidoDetalle> listarMes(int mes, int año) {
		ArrayList<PedidoDetalle> lPedidoDetalle = new ArrayList<>();
		PedidoDetalle pedidodetalle;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{CALL sp_Listar_Mes(?,?)}");
			cst.setInt(1, mes);
			cst.setInt(2, año);
			rs = cst.executeQuery();
			while (rs.next()) {
				pedidodetalle = new PedidoDetalle();
				pedidodetalle.setIdProducto(rs.getInt(1));
				pedidodetalle.setNombre(rs.getString(2));
				pedidodetalle.setCantidad(rs.getInt(3));
				pedidodetalle.setCosto(rs.getDouble(4));
				pedidodetalle.setTotal(rs.getDouble(5));
				lPedidoDetalle.add(pedidodetalle);
			}
			con.close();
		} catch (SQLException ex) {

		}
		return lPedidoDetalle;
	}

	@Override
	public PedidoDetalle buscarEntidad(int id) {
		PedidoDetalle pedidodetalle = null;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_buscar_pedidodet(?)}");
			cst.setInt(1, id);
			rs = cst.executeQuery();
			if (rs.next()) {
				pedidodetalle = new PedidoDetalle();
				pedidodetalle.setIdPedDet(rs.getInt(1));
				pedidodetalle.setIdProducto(rs.getInt(2));
				pedidodetalle.setNombre(rs.getString(3));
				pedidodetalle.setCantidad(rs.getInt(4));
				pedidodetalle.setIdPedido(rs.getInt(5));
				pedidodetalle.setEstado(rs.getInt(6));
			}
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return pedidodetalle;
	}

	@Override
	public int actualizarEntidad(PedidoDetalle pedidodetalle) {
		int filas = 0;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_actualizar_pedidodetalle(?,?,?,?,?)}");
			cst.setInt(1, pedidodetalle.getIdPedDet());
			cst.setInt(2, pedidodetalle.getIdProducto());
			cst.setInt(2, pedidodetalle.getCantidad());
			cst.setInt(3, pedidodetalle.getIdPedido());
			cst.setInt(4, pedidodetalle.getEstado());
			filas = cst.executeUpdate();
		} catch (SQLException ex) {

		}
		return filas;
	}

	public int actualizarCantidad(int idPedDet, int cant) {
		int filas = 0;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_actualizar_cant(?,?)}");
			cst.setInt(1, idPedDet);
			cst.setInt(2, cant);
			filas = cst.executeUpdate();
		} catch (SQLException ex) {

		}
		return filas;
	}

	public int actualizarEstado(int idPedDet, int est) {
		int filas = 0;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_actualizar_peddetest(?,?)}");
			cst.setInt(1, idPedDet);
			cst.setInt(2, est);
			filas = cst.executeUpdate();
		} catch (SQLException ex) {

		}
		return filas;
	}

	@Override
	public int eliminarEntidad(int id) {
		int filas = 0;
		try {
			con = DBConn.getConnection();
			cst = con.prepareCall("{Call sp_eliminar_pedidodetalle(?)}");
			cst.setInt(1, id);
			filas = cst.executeUpdate();
		} catch (SQLException ex) {
			filas = 1;
		}
		return filas;
	}
}