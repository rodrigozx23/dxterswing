/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariosMDI;

import daos.CategoriaDAO;
import daos.ProductoDAO;
import daos.SubCategoriaDAO;
import entidades.Categoria;
import entidades.Producto;
import entidades.SubCategoria;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class Frm_MntoPro extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_MntoPro
     */
    public Frm_MntoPro() {
        initComponents();
        CargarC();        
        BloquearTabla();
        ListarProducto();
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
        tbShowProducto.setModel(dt);
         }
    int[] listaidCategoriaCombo;    
    public void CargarC()
        {        
            ArrayList<Categoria> c;
            CategoriaDAO sCat = new CategoriaDAO();
            c = sCat.listarEntidad();      
            listaidCategoriaCombo = new int[c.size()];
            int i=0;        
            listaidSubCategoriaCombo = new int[c.size()];
            for(i=0;i<=c.size()-1;i++)
                {
                    listaidCategoriaCombo[i] =c.get(i).getIdCategoria();
                    cmbCategoria.addItem(c.get(i).getNombre());    
                }          
        }
    
    int estado;
    int stock;
    int[] listaidSubCategoriaCombo;   
    public void CargarSC(int id)
        {
            ArrayList<SubCategoria> c;
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
    int[] listaidProducto;
    public void ListarProducto(){
        DefaultTableModel dtm=(DefaultTableModel)this.tbShowProducto.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> lc = pdao.listarEntidad();
        listaidProducto = new int[lc.size()];
        String col[] = {"IdProducto","Nombre","Costo","Categoria","SubCategoria","Estado"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];        
        for (int i = 0; i < lc.size(); i++) {
            listaidProducto[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getIdProducto();
            row[1] = lc.get(i).getNombre();
            row[2] = lc.get(i).getCosto();
            row[3] = lc.get(i).getIdCategoria();   
            row[4] = lc.get(i).getIdSubCategoria();
            row[5] = lc.get(i).getEstado();
            dtm.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbSubCategoria = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbShowProducto = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Mantenimiento Productos");

        cmbSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCategoriaActionPerformed(evt);
            }
        });

        cmbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbCategoriaMouseClicked(evt);
            }
        });
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoria");

        jLabel2.setText("SubCategoria");

        tbShowProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbShowProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbShowProducto);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel5.setText("MANTENIMIENTO DE PRODUCTOS");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Costo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(9, 9, 9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSubCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSubCategoriaActionPerformed

    private void cmbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbCategoriaMouseClicked

    }//GEN-LAST:event_cmbCategoriaMouseClicked

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        int index = cmbCategoria.getSelectedIndex();
        int id = listaidCategoriaCombo[index];
        cmbSubCategoria.removeAllItems();
        CargarSC(id);
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void tbShowProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowProductoMouseClicked
        int fila = tbShowProducto.getSelectedRow();
        int index = cmbCategoria.getSelectedIndex();
        int idcat = listaidCategoriaCombo[index];
        try
        {
            int id = listaidProducto[fila];
            ProductoDAO pdao = new ProductoDAO();
            Producto producto = new Producto();
            producto = pdao.buscarEntidad(id);
            txtNombre.setText(producto.getNombre());
            txtCosto.setText(Double.toString(producto.getCosto()));
            estado = producto.getEstado();
            stock = producto.getStock();
            ArrayList<Categoria> c;
            CategoriaDAO sCat = new CategoriaDAO();
            c = sCat.listarEntidad();
            int i=0;
            for(i=0;i<=c.size()-1;i++)
            {
                if(listaidCategoriaCombo[i] == producto.getIdCategoria())
                {
                    cmbCategoria.setSelectedIndex(i);
                }
            }
            ArrayList<SubCategoria> s;
            SubCategoriaDAO sbCat = new SubCategoriaDAO();
            s = sbCat.filtrarSubCategoriaCat(idcat);
            int j=0;
            for(j=0;j<=s.size()-1;j++)
            {
                if(listaidSubCategoriaCombo[j] == producto.getIdSubCategoria())
                {
                    cmbSubCategoria.setSelectedIndex(j);
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_tbShowProductoMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
            char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE))
        evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)&& (c != '.')&&(c != ','))
        {
            evt.consume();
        }
        if (c == '.' && txtCosto.getText().contains("."))
        {
            evt.consume();
        }
        if (c == ',' && txtCosto.getText().contains(","))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int row = tbShowProducto.getSelectedRow();
        if (row == -1)
        {
            JOptionPane.showMessageDialog(this,"Seleccione un elemento para modificar");
        }
        else
        {
            String usu= txtNombre.getText();
            String cos= txtCosto.getText();
            usu=usu.replaceAll(" ", "");
            usu=usu.replaceAll(" ", "");
            if(usu.length()==0 || txtCosto.getText().length()==0)
            {
                JOptionPane.showMessageDialog(this,"INGRESE DATOS:Nombre y/o Costo");
            }
            else
            {
                try
                {
                    int index = cmbCategoria.getSelectedIndex();
                    int idCat = listaidCategoriaCombo[index];
                    int index1 = cmbSubCategoria.getSelectedIndex();
                    int idCat1 = listaidSubCategoriaCombo[index1];
                    int fila = tbShowProducto.getSelectedRow();
                    int idProducto = listaidProducto[fila];
                    Producto producto = new Producto();
                    producto.setIdProducto(idProducto);
                    producto.setNombre(txtNombre.getText());
                    producto.setCosto(Double.parseDouble(txtCosto.getText()));
                    producto.setIdCategoria(idCat);
                    producto.setIdSubCategoria(idCat1);
                    producto.setStock(stock);
                    producto.setEstado(estado);
                    
                    ProductoDAO pdao = new ProductoDAO();
                    pdao.actualizarEntidad(producto);
                    ListarProducto();
                    JOptionPane.showMessageDialog(this,"Se Modifico Exitosamente");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this,e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nom = txtNombre.getText();
        String cos = txtCosto.getText();
        estado = 1;
        stock = 0;
        nom=nom.replaceAll(" ", "");
        cos=cos.replaceAll(" ", "");
        if(nom.length()==0 || cos.length()==0)
        {
            JOptionPane.showMessageDialog(this,"INGRESE DATOS : NOMBRE y/o COSTO");
        }
        else
        {
            try
            {
                int index = cmbCategoria.getSelectedIndex();
                int id = listaidCategoriaCombo[index];
                int index1 = cmbSubCategoria.getSelectedIndex();
                int id1 = listaidSubCategoriaCombo[index1];
                Producto producto= new Producto();
                producto.setNombre(txtNombre.getText());
                producto.setCosto(Double.parseDouble(txtCosto.getText()));
                producto.setIdCategoria(id);
                producto.setIdSubCategoria(id1);
                producto.setStock(stock);
                producto.setEstado(estado);
                
                ProductoDAO proDAO = new ProductoDAO();
                proDAO.crearEntidad(producto);
                ListarProducto();
                JOptionPane.showMessageDialog(this,"Se Agrego Exitosamente");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tbShowProducto.getSelectedRow();
        if (row == -1)
        {
            JOptionPane.showMessageDialog(this,"Seleccione un elemento para poder eliminar");
        }
        else
        {
            try
            {
                int fila = tbShowProducto.getSelectedRow();
                int id = listaidProducto[fila];
                ProductoDAO pdao = new ProductoDAO();
                pdao.eliminarEntidad(id);
                ListarProducto();
                JOptionPane.showMessageDialog(this,"Se Elimino Exitosamente");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbShowProducto;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
