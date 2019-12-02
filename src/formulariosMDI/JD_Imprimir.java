
package formulariosMDI;
import daos.PedidoDAO;
import daos.PedidoDetalleDAO;
import entidades.PedidoDetalle;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Crazykiwi
 */
public class JD_Imprimir extends javax.swing.JDialog implements Printable{

    public static Frm_Pedidos impr;
    private int idPedido;
    
    public JD_Imprimir(Frm_Pedidos parent, boolean modal) {
        //super(parent, modal);
        this.impr = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        BloquearTabla();
        fecha();
    }    
    
        public void fecha(){
            try{
                Calendar fecha = Calendar.getInstance();
                fecha.add(Calendar.DATE, 1);
                Date date = fecha.getTime();    
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String cadena = format.format(date);
                lblFH.setText(cadena);            
            }
            catch(Exception ex){
                lblFH.setText("ACA");  
            }
        }
    
    public void calcular(){
        PedidoDAO pdao = new PedidoDAO();
        double total = pdao.calcularTotal(idPedido);
        double subtotal, igv, rc;
        igv = total * 0.18;
        rc = total * 0.04;
        subtotal = total - igv - rc;
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        String salida = "----------------------" + 
                "\nSubTotal: " + formatosalida.format(subtotal) + 
                "\nIGV: " + formatosalida.format(igv) + 
                "\nRC: " + formatosalida.format(rc) + 
                "\nTotal: " + formatosalida.format(total) +
                "\n----------------------"+
                "\n#Fact.: " + idPedido;
        txtTotal.setText(salida);
    }
    
    private void updateHeightsAndWidths()
    {
        for (int row = 0; row < tbDetalle.getRowCount(); row++)
        {
            int rowHeight = tbDetalle.getRowHeight();

            for (int column = 0; column < tbDetalle.getColumnCount(); column++)
            {
                Component comp = tbDetalle.prepareRenderer(tbDetalle.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            tbDetalle.setRowHeight(row, rowHeight);
        }
        
        for (int i = 0; i < tbDetalle.getColumnCount(); i++) {
            adjustColumnSizes(tbDetalle, i, 2);
        }
    }    
    
    public void adjustColumnSizes(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;

        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }

        width += 2 * margin;

        col.setPreferredWidth(width);
        col.setWidth(width);
    }
    
    public void Cargar(){
        ListarPedidoDetalle(idPedido);
        updateHeightsAndWidths();
        tbDetalle.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 8));
        calcular();
    }
    
    public void ListarPedidoDetalle(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbDetalle.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        PedidoDetalleDAO pddao = new PedidoDetalleDAO();
        ArrayList<PedidoDetalle> lc = pddao.listarDetalle(id);
        String col[] = {"Prod.","#","Prec"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];   
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        for (int i = 0; i < lc.size(); i++) {
            row[0] = lc.get(i).getNombre();
            row[1] = lc.get(i).getCantidad();
            row[2] = formatosalida.format(lc.get(i).getCosto());
            dtm.addRow(row);
        }
    }
    
    public void BloquearTabla(){        
        DefaultTableModel dt = new DefaultTableModel()
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                        {
                            return false;
                        }
                };        
        tbDetalle.setModel(dt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recibo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable();
        lblFH = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTotal = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        recibo.setBackground(new java.awt.Color(255, 255, 255));
        recibo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("BUFFALO'S");
        recibo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 20));

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N

        tbDetalle.setFont(new java.awt.Font("Tahoma", 0, 7)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalle.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbDetalle);

        recibo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, 280));

        lblFH.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        recibo.add(lblFH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel4.setText("Urb. Manuel Prado Cuzco-Cuzco");
        recibo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setColumns(4);
        txtTotal.setFont(new java.awt.Font("Monospaced", 0, 8)); // NOI18N
        txtTotal.setRows(4);
        jScrollPane3.setViewportView(txtTotal);

        recibo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 130, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel5.setText("Av. La cultura Mza. N Lote");
        recibo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, -1));

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(btnImprimir))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       try
       {
           PrinterJob gap = PrinterJob.getPrinterJob();
           gap.setPrintable(this);
           PedidoDAO pdao = new PedidoDAO();
           boolean top = gap.printDialog();
           if(top)
           {
               gap.print();
               pdao.actualizarEstado(idPedido, 1);
               this.dispose();
           }
       }
       catch(PrinterException ex)
            {
                JOptionPane.showMessageDialog(null,"Error de progrmaa");
            }
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JD_Imprimir dialog = new JD_Imprimir(impr, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFH;
    private javax.swing.JPanel recibo;
    private javax.swing.JTable tbDetalle;
    private javax.swing.JTextArea txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagFor, int index) throws PrinterException {
        
       if(index >0)
       {
        return NO_SUCH_PAGE;        
       }
       Graphics2D hub=(Graphics2D)graf;
       hub.translate(pagFor.getImageableX() + 30, pagFor.getImageableY() + 30);
       hub.scale(1.0, 1.0);       
       recibo.printAll(graf);
       return PAGE_EXISTS;
       
    } 

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}