
package formulariosMDI;

import daos.StockDAO;
import daos.ProductoDAO;
import daos.CategoriaDAO;
import daos.MovimientosDAO;
import daos.SubCategoriaDAO;
import entidades.Stock;
import entidades.Producto;
import entidades.Categoria;
import entidades.Movimientos;
import entidades.SubCategoria;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_AgregarStock extends javax.swing.JFrame {

    /**
     * Creates new form Frm_AgregarStock
     */
    public Frm_AgregarStock() {
        initComponents(); 
        BloquearTabla();
        CargarCat();    
        ListarStock();
        
    }
    public void BloquearTabla()
        {        
        DefaultTableModel dt = new DefaultTableModel()
                {
                    @Override
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };        
         tbShowPro.setModel(dt);
         }
    int cantidad = 0;
    int[] listaidCategoriaCombo;    
    public void CargarCat(){        
        List<Categoria> c;
        CategoriaDAO cdao = new CategoriaDAO();
        c = cdao.listarEntidad();
        int i=0;
        listaidCategoriaCombo = new int[c.size()];
        for(i=0;i <= c.size()-1;i++){
            listaidCategoriaCombo[i] = c.get(i).getIdCategoria();
            cmbCategoria.addItem(c.get(i).getNombre());
        }
    }
    int[] listaidSubCategoriaCombo;   
    public void CargarSC(int id)
        {
            List<SubCategoria> c;
            SubCategoriaDAO sbCat = new SubCategoriaDAO();
            c = sbCat.filtrarSubCategoriaCat(id);        
            int i=0;
            listaidSubCategoriaCombo = new int[c.size()];
            for(i=0;i<=c.size()-1;i++)
                {
                    listaidSubCategoriaCombo[i] =c.get(i).getIdSubCategoria();
                    cmbSubCategoria.addItem(c.get(i).getNombre());     
                }   
        }
    int[] listaidProductoCombo;
    public void Cargar(int id)
        {        
            List<Producto> c;
            ProductoDAO pCat = new ProductoDAO();
            c = pCat.filtrarProductoStock(id);        
            int i=0;
            listaidProductoCombo = new int[c.size()];
            for(i=0;i<=c.size()-1;i++)
                {
                    listaidProductoCombo[i] =c.get(i).getIdProducto();
                    cmbNombre.addItem(c.get(i).getNombre());     
                }      
        }
    int[] listaidProducto;
    int[] listaidStock;
    int idStock;
    public void ListarStock(){
        DefaultTableModel dtm=(DefaultTableModel)this.tbShowPro.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        StockDAO sdao = new StockDAO();
        ArrayList<Stock> lc = sdao.listarStock();
        listaidProducto = new int[lc.size()];
        listaidStock = new int[lc.size()];        
        String col[] = {"Nombre","Cantidad"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];        
        for (int i = 0; i < lc.size(); i++) {            
            listaidStock[i] = lc.get(i).getIdStock();
            listaidProducto[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombreProducto();
            row[1] = lc.get(i).getStock();            
            dtm.addRow(row);
        }
        
    }
    public void FiltrarProductoSubCat(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbShowPro.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        StockDAO sdao = new StockDAO();
        ArrayList<Stock> lc = sdao.filtrarProductoSubCat(id);
        listaidProducto = new int[lc.size()];
        listaidStock = new int[lc.size()];
        String col[] = {"Nombre","Cantidad"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];        
        for (int i = 0; i < lc.size(); i++) {            
            listaidStock[i] = lc.get(i).getIdStock();
            listaidProducto[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombreProducto();
            row[1] = lc.get(i).getStock();            
            dtm.addRow(row);
        }
    }
    public void FiltrarProductoCat(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbShowPro.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        StockDAO sdao = new StockDAO();
        ArrayList<Stock> lc = sdao.filtrarProductoCat(id);
        listaidProducto = new int[lc.size()];
        listaidStock = new int[lc.size()];
        String col[] = {"Nombre","Cantidad"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];        
        for (int i = 0; i < lc.size(); i++) {            
            listaidStock[i] = lc.get(i).getIdStock();
            listaidProducto[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombreProducto();
            row[1] = lc.get(i).getStock();            
            dtm.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbShowPro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbNombre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnAgregarStock = new javax.swing.JButton();
        cmbSubCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbShowPro.setModel(new javax.swing.table.DefaultTableModel(
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
        tbShowPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbShowPro);

        jLabel1.setText("INGRESAR STOCK");

        jLabel2.setText("PRODUCTO");

        jLabel3.setText("CANTIDAD");

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        btnAgregarStock.setText("AGREGAR");
        btnAgregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarStockActionPerformed(evt);
            }
        });

        cmbSubCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSubCategoriaItemStateChanged(evt);
            }
        });
        cmbSubCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSubCategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbSubCategoriaMouseEntered(evt);
            }
        });
        cmbSubCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbSubCategoriaKeyPressed(evt);
            }
        });

        jLabel5.setText("SUBCATEGORIA");

        btnQuitar.setText("QUITAR");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel4.setText("CATEGORIA");

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSubCategoria, 0, 97, Short.MAX_VALUE)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNombre, 0, 120, Short.MAX_VALUE)
                            .addComponent(txtStock)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarStock, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cmbSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSubCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSubCategoriaMouseEntered
        
    }//GEN-LAST:event_cmbSubCategoriaMouseEntered

    private void cmbSubCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSubCategoriaMouseClicked
        
    }//GEN-LAST:event_cmbSubCategoriaMouseClicked

    private void cmbSubCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSubCategoriaKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int index = cmbSubCategoria.getSelectedIndex();
            int id = listaidSubCategoriaCombo[index];
            cmbNombre.removeAllItems();
            Cargar(id);
       }
    }//GEN-LAST:event_cmbSubCategoriaKeyPressed

    private void btnAgregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarStockActionPerformed
        String cos = txtStock.getText();     
        int mov = 1;
        String cant = txtStock.getText();
        int x1 = Integer.parseInt(cant);
        cos=cos.replaceAll(" ", "");
        if(cos.length()==0)
        {
            JOptionPane.showMessageDialog(this,"INGRESE STOCK");
        }
        else
        { 
            if(x1 >= 50)
            {
            JOptionPane.showMessageDialog(this,"CANTIDAD MUY ALTA");
            }
            else{
                try                    
                {
                    int index1 = cmbNombre.getSelectedIndex();
                    int id1 = listaidProducto[index1];
                    Stock stock = new Stock();   
                    StockDAO sDAO = new StockDAO(); 
                    stock = sDAO.buscarEntidad(id1);
                    idStock=stock.getIdStock();   
                                
                    stock.setIdProducto(id1);
                    stock.setStock(x1);                                       
                    sDAO.agregarStock(stock);   
                                       
                    Movimientos movimientos = new Movimientos();             
                    movimientos.setIdStock(idStock);
                    movimientos.setCantidad(x1);
                    movimientos.setTipoMov(mov);                                                                                             
                    MovimientosDAO mDAO = new MovimientosDAO();
                    mDAO.crearEntidad(movimientos);
                    ListarStock();
                    JOptionPane.showMessageDialog(this,"Se Agrego Stock a su Producto");
                    
                }
                catch (Exception e)
                {
                JOptionPane.showMessageDialog(this,e.getMessage());
                }
            }   
        }
    }//GEN-LAST:event_btnAgregarStockActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        StockDAO sDAO = new StockDAO();
        Stock stock= new Stock();
        int comp;
        
        String cos = txtStock.getText();
        int mov = 2;
        String cant = txtStock.getText();
        int x1=Integer.parseInt(cant);
        
        cos=cos.replaceAll(" ", "");
        
        int index1 = cmbNombre.getSelectedIndex();
        int id1 = listaidProducto[index1];
        stock = sDAO.buscarEntidad(id1);
        idStock=stock.getIdStock();
        comp = stock.getStock();
        if(cos.length()==0)
        {
            JOptionPane.showMessageDialog(this,"INGRESE STOCK");
        }
        else
        {
            if(x1 >= 50 || x1>comp)
            {
            JOptionPane.showMessageDialog(this,"CANTIDAD MUY ALTA");
            }
            else{
                    try
                    {                       
                        
                        stock.setIdProducto(id1);
                        stock.setStock(x1);
                        //StockDAO sDAO = new StockDAO();
                        sDAO.quitarStock(stock);              
                        
                        Movimientos movimientos = new Movimientos();               
                        movimientos.setIdStock(idStock);
                        movimientos.setCantidad(x1);
                        movimientos.setTipoMov(mov);
                        MovimientosDAO mDAO = new MovimientosDAO();
                        mDAO.crearEntidad(movimientos);

                        ListarStock();
                        JOptionPane.showMessageDialog(this,"Se Quito Stock a su Producto");
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(this,e.getMessage());
                    }
            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void cmbSubCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSubCategoriaItemStateChanged
        int index1 = cmbSubCategoria.getSelectedIndex();
        if (index1 > -1){
            int id1 = listaidSubCategoriaCombo[index1];
            cmbNombre.removeAllItems();
            Cargar(id1);
            FiltrarProductoSubCat(id1);            
        }
    }//GEN-LAST:event_cmbSubCategoriaItemStateChanged

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        int index = cmbCategoria.getSelectedIndex();
        int id = listaidCategoriaCombo[index];
        cmbSubCategoria.removeAllItems();
        CargarSC(id);
        FiltrarProductoCat(id);      
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void tbShowProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowProMouseClicked
        
    }//GEN-LAST:event_tbShowProMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_AgregarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_AgregarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_AgregarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_AgregarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_AgregarStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarStock;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbNombre;
    private javax.swing.JComboBox<String> cmbSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbShowPro;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
