package entidades;

import java.util.Date;

public class Movimientos {
    private int idMovimiento;
    private int idStock;
    private int Cantidad;
    private int TipoMov;
    private Date fecha;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getTipoMov() {
        return TipoMov;
    }

    public void setTipoMov(int TipoMov) {
        this.TipoMov = TipoMov;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
