package formulariosMDI;

import daos.PedidoDAO;
import daos.PedidoDetalleDAO;
import entidades.PedidoDetalle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frm_ReporteMensual extends javax.swing.JInternalFrame {

    public Frm_ReporteMensual() {
        initComponents();        
        BloquearTabla(tbReporte);
        CargarCombos();
        CargarReporte();
    }
    
    public void BloquearTabla(JTable j){        
        DefaultTableModel dt = new DefaultTableModel()
                {
                    @Override
                    public boolean isCellEditable(int row, int column){
                    return false;
                }
             };        
        j.setModel(dt);
    }
    
    public void ListarReporte(int mes, int año){
        DefaultTableModel dtm=(DefaultTableModel)this.tbReporte.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        PedidoDetalleDAO pddao = new PedidoDetalleDAO();
        ArrayList<PedidoDetalle> lc = pddao.listarMes(mes,año);
        String col[] = {"Producto","Cantidad","Precio Unit.","Precio Total"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        for (int i = 0; i < lc.size(); i++) {
            row[0] = lc.get(i).getNombre();
            row[1] = lc.get(i).getCantidad();
            row[2] = formatosalida.format(lc.get(i).getCosto());
            row[3] = formatosalida.format(lc.get(i).getTotal());
            dtm.addRow(row);
        }
    }
    
    public void CargarCombos(){
        cbxAño.removeAllItems();
        Calendar fecha = Calendar.getInstance();
        int anio = fecha.get(Calendar.YEAR);
        int anioM = anio - 4;
        
        int i;
        for(i = anioM; i < anio;i++){
            cbxAño.addItem(i + "");
        }
        
        anioM = anio + 4;
        
        for(i = anio; i <= anioM ;i++){
            cbxAño.addItem(i + "");
        }        
    }
    
    public void CargarReporte(){
        PedidoDAO pdao = new PedidoDAO();
        double total, igv, rc, subtotal;        
        Calendar fecha = Calendar.getInstance();  
        int mes = fecha.get(Calendar.MONTH) + 1;
        int año = fecha.get(Calendar.YEAR);
        total = pdao.calcularTotalMensual(mes,año);
        igv = total * 0.18;
        rc = total * 0.04;
        subtotal = total - igv - rc;
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        String salida = "SubTotal: " + formatosalida.format(subtotal) + 
                "\nIGV: " + formatosalida.format(igv) + 
                "\nRC: " + formatosalida.format(rc) +                 
                "\n-------------------" +
                "\nTotal: " + formatosalida.format(total);
        txtSalida.setText(salida);
        ListarReporte(mes,año);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMes1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReporte = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        btnReporte = new javax.swing.JButton();
        cbxMes = new javax.swing.JComboBox<>();
        lblMes = new javax.swing.JLabel();
        cbxAño = new javax.swing.JComboBox<>();

        setClosable(true);

        lblMes1.setText("Año:");

        tbReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbReporte);

        txtSalida.setEditable(false);
        txtSalida.setColumns(5);
        txtSalida.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtSalida.setRows(5);
        txtSalida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSalida.setEnabled(false);
        jScrollPane2.setViewportView(txtSalida);

        btnReporte.setText("Ver Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        cbxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbxMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMesItemStateChanged(evt);
            }
        });
        cbxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMesActionPerformed(evt);
            }
        });

        lblMes.setText("Mes:");

        cbxAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAñoItemStateChanged(evt);
            }
        });
        cbxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAñoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMes1)
                            .addComponent(cbxAño, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMes))
                        .addGap(68, 68, 68)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblMes1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        PedidoDAO pdao = new PedidoDAO();
        double total, igv, rc, subtotal;
        int mes = cbxMes.getSelectedIndex() + 1;
        int año = Integer.parseInt(cbxAño.getSelectedItem().toString());
        total = pdao.calcularTotalMensual(mes,año);
        igv = total * 0.18;
        rc = total * 0.04;
        subtotal = total - igv - rc;
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        String salida = "SubTotal: " + formatosalida.format(subtotal) + "\nIGV: " + formatosalida.format(igv) + "\nRC: " + formatosalida.format(rc) + "\nTotal: " + formatosalida.format(total);
        txtSalida.setText(salida);
        ListarReporte(mes,año);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void cbxMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMesItemStateChanged

    }//GEN-LAST:event_cbxMesItemStateChanged

    private void cbxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMesActionPerformed

    private void cbxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAñoActionPerformed

    private void cbxAñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAñoItemStateChanged

    }//GEN-LAST:event_cbxAñoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxAño;
    private javax.swing.JComboBox<String> cbxMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    private javax.swing.JTable tbReporte;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
