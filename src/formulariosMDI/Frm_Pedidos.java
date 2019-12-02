package formulariosMDI;

import daos.*;
import entidades.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frm_Pedidos extends javax.swing.JInternalFrame {

    public static JD_Imprimir impr;
    
    public void MostrarJD(){
        impr = new JD_Imprimir(this, true);
        impr.setIdPedido(idPedido);
        impr.Cargar();
        impr.setVisible(true);
    }
    
    public Frm_Pedidos() {
        super();
        initComponents();
        BloquearTabla(tbPedidoDetalle);
        BloquearTabla(tbProducto);
        ListarProducto();
        CargarCat();
    }
    
    int[] listaidProductoTB;
    int[] listaidCategoriaTB;
    int[] listaidSubCategoriaTB;
    public void ListarProducto(){
        DefaultTableModel dtm=(DefaultTableModel)this.tbProducto.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> lc = pdao.listarProducto();
        listaidProductoTB = new int[lc.size()];
        listaidCategoriaTB = new int[lc.size()];
        listaidSubCategoriaTB = new int[lc.size()];
        String col[] = {"Nombre","Costo"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        for (int i = 0; i < lc.size(); i++) {
            listaidProductoTB[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombre();
            row[1] = formatosalida.format(lc.get(i).getCosto()); 
            listaidCategoriaTB[i] = lc.get(i).getIdCategoria();
            listaidSubCategoriaTB[i] = lc.get(i).getIdSubCategoria();
            dtm.addRow(row);
        }
    }
    
    int[] listaidCatCmb;
    public void CargarCat(){        
        List<Categoria> c;
        CategoriaDAO cdao = new CategoriaDAO();
        c = cdao.listarEntidad();
        int i=0;
        listaidCatCmb = new int[c.size()];
        for(i=0;i <= c.size()-1;i++){
            listaidCatCmb[i] = c.get(i).getIdCategoria();
            cbxCategoria.addItem(c.get(i).getNombre());
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidoDetalle = new javax.swing.JTable();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        btnMesa9 = new javax.swing.JButton();
        btnMesa10 = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        cbxCantidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        lblSubCategorias = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        lblCategorias = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        btnMesa6 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa15 = new javax.swing.JButton();
        btnMesa14 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa13 = new javax.swing.JButton();
        btnMesa11 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa12 = new javax.swing.JButton();
        btnMesa1 = new javax.swing.JButton();
        cbxCantidadElim = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNumeroMesa = new javax.swing.JLabel();
        btnTogo = new javax.swing.JButton();
        lblPro = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Pedidos");
        setPreferredSize(new java.awt.Dimension(930, 740));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPedidoDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMBRE", "CANTIDAD", "COSTO"
            }
        ));
        jScrollPane1.setViewportView(tbPedidoDetalle);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 440, 380));

        btnMesa7.setText("Mesa7");
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, 40));

        btnMesa8.setText("Mesa8");
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 80, 40));

        btnMesa9.setText("Mesa9");
        btnMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa9ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 80, 40));

        btnMesa10.setText("Mesa10");
        btnMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa10ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, 40));

        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 75, 40));

        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbProducto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 440, 240));

        cbxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(cbxCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

        jLabel3.setText("CANTIDAD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, -1, -1));

        cbxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroItemStateChanged(evt);
            }
        });
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 110, -1));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 75, 40));

        lblSubCategorias.setText("SUBCATEGORIAS ");
        getContentPane().add(lblSubCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        txtFiltrar.setFont(new java.awt.Font("Meiryo UI", 0, 17)); // NOI18N
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyPressed(evt);
            }
        });
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 140, 30));

        cbxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriaItemStateChanged(evt);
            }
        });
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 130, -1));

        lblCategorias.setText("CATEGORIAS ");
        getContentPane().add(lblCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        jScrollPane3.setEnabled(false);
        jScrollPane3.setHorizontalScrollBar(null);

        txtSalida.setEditable(false);
        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtSalida.setRows(5);
        txtSalida.setEnabled(false);
        jScrollPane3.setViewportView(txtSalida);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 170, 110));

        btnMesa6.setText("Mesa6");
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 40));

        btnMesa5.setText("Mesa5");
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 80, 40));

        btnMesa15.setText("Mesa15");
        btnMesa15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa15ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 80, 40));

        btnMesa14.setText("Mesa14");
        btnMesa14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa14ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 80, 40));

        btnMesa4.setText("Mesa4");
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, 40));

        btnMesa3.setText("Mesa3");
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 40));

        btnMesa13.setText("Mesa13");
        btnMesa13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa13ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 80, 40));

        btnMesa11.setText("Mesa11");
        btnMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa11ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 80, 40));

        btnMesa2.setText("Mesa2");
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 40));

        btnMesa12.setText("Mesa12");
        btnMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa12ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 80, 40));

        btnMesa1.setText("Mesa1");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 40));

        cbxCantidadElim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(cbxCantidadElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, 20));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 90, 40));

        btnCancelar.setText("CANCELAR PEDIDO");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, 40));

        jLabel2.setText("Inf. de Consumo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, 10));

        lblNumeroMesa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNumeroMesa.setForeground(new java.awt.Color(255, 102, 0));
        lblNumeroMesa.setText("Numero(#) de Mesa.");
        getContentPane().add(lblNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        btnTogo.setText("Para llevar");
        btnTogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnTogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 40));

        lblPro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPro.setForeground(new java.awt.Color(255, 102, 0));
        lblPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPro.setText("Productos");
        getContentPane().add(lblPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 220, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int numM = -1;
    private boolean pedido = false;
    private int idPedido = 0;
    public void Boton(int numMesa) {
        
        numM = numMesa;
        
        if (numM == 0){
            lblNumeroMesa.setText("Pedido para llevar");
            lblPro.setText("Escoja un producto.");
        }
        else{            
            lblNumeroMesa.setText("Mesa #" + numMesa);
            lblPro.setText("Escoja un producto.");
        }
        
        DefaultTableModel dtm=(DefaultTableModel)this.tbPedidoDetalle.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        
        PedidoDAO pdao = new PedidoDAO(); 
        Pedido ped;
        ped = pdao.VerificarMesa(numM);
        
        if (ped != null){
            pedido = true;
            idPedido = ped.getIdPedido();
            ListarPedidoDetalle(idPedido);
            calcular();
        }
        else{
            pedido = false;
            txtSalida.setText("");
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
        String salida = "SubTotal: " + formatosalida.format(subtotal) + 
                "\nIGV: " + formatosalida.format(igv) + 
                "\nRC: " + formatosalida.format(rc) + 
                "\n-------------------" +
                "\nTotal: " + formatosalida.format(total);
        txtSalida.setText(salida);
    }
    
    int[] listaIdPedDetTB;
    public void ListarPedidoDetalle(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbPedidoDetalle.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        PedidoDetalleDAO pddao = new PedidoDetalleDAO();
        ArrayList<PedidoDetalle> lc = pddao.listarDetalle(id);
        listaIdPedDetTB = new int[lc.size()];
        String col[] = {"Producto","Cantidad","Costo Unitario","Costo Total"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];   
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        for (int i = 0; i < lc.size(); i++) {
            listaIdPedDetTB[i] = lc.get(i).getIdPedDet();
            row[0] = lc.get(i).getNombre();
            row[1] = lc.get(i).getCantidad();
            row[2] = formatosalida.format(lc.get(i).getCosto());
            row[3] = formatosalida.format(lc.get(i).getCosto() * lc.get(i).getCantidad());
            dtm.addRow(row);
        }
    }
    
    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
        Boton(7);
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
        Boton(8);
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa9ActionPerformed
        Boton(9);
    }//GEN-LAST:event_btnMesa9ActionPerformed

    private void btnMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa10ActionPerformed
        Boton(10);
    }//GEN-LAST:event_btnMesa10ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if(pedido == true){
            int reply = JOptionPane.showConfirmDialog(null, "¿Desea pagar el pedido?", "Pagar Pedido", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
//                PedidoDAO pdao = new PedidoDAO();
//                double total = pdao.calcularTotal(idPedido);
//                pdao.actualizarEstado(idPedido, 1);
//                pdao.actualizarTotal(idPedido, total);
//                double subtotal, igv, rc;
//                igv = total * 0.18;
//                rc = total * 0.04;
//                subtotal = total - igv - rc;
                MostrarJD();
                Boton(numM);
            }
            else{
                //dunno
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"No hay un pedido activo","Error",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        int index = cbxFiltro.getSelectedIndex();
        if (index > -1){
            int id = listaidSubCatCmb[index];
            FiltrarProductoSubCat(id);
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    public void FiltrarProductoSubCat(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbProducto.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> lc = pdao.filtrarProductoSubCat(id);        
        listaidProductoTB = new int[lc.size()];
        listaidCategoriaTB = new int[lc.size()];
        listaidSubCategoriaTB = new int[lc.size()];
        String col[] = {"Nombre","Costo"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];
        java.text.DecimalFormat formatosalida = new java.text.DecimalFormat("0.00");
        for (int i = 0; i < lc.size(); i++) {
            listaidProductoTB[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombre();
            row[1] = formatosalida.format(lc.get(i).getCosto());
            listaidCategoriaTB[i] = lc.get(i).getIdCategoria();
            listaidSubCategoriaTB[i] = lc.get(i).getIdSubCategoria();
            dtm.addRow(row);
        }
    }
    
    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if(numM > -1){
            if(tbProducto.getSelectedRow() >= 0){
                if(pedido == true){
                    PedidoDetalleDAO ddao = new PedidoDetalleDAO();
                    PedidoDetalle ped;
                    int fila = tbProducto.getSelectedRow();
                    int id = listaidProductoTB[fila];
                    ped = ddao.VerificarProducto(idPedido,id);

                    if (ped != null){
                        int idPedDet = ped.getIdPedDet();
                        int estado = ped.getEstado();

                        if (estado == 0){
                            ddao.actualizarEstado(idPedDet, 1);
                        }

                        int cantidad = ped.getCantidad() + Integer.parseInt(cbxCantidad.getSelectedItem().toString());
                        ddao.actualizarCantidad(idPedDet, cantidad);

                        ListarProducto();
                        ListarPedidoDetalle(idPedido);
                        cbxCantidad.setSelectedIndex(0);                        
                        Boton(numM);
                    }
                    else{
                        ped = new PedidoDetalle();
                        ped.setCantidad(Integer.parseInt(cbxCantidad.getSelectedItem().toString()));
                        ped.setIdProducto(id);
                        ped.setIdPedido(idPedido);
                        ped.setEstado(1);
                        ddao.crearEntidad(ped);

                        ListarProducto();
                        ListarPedidoDetalle(idPedido);
                        cbxCantidad.setSelectedIndex(0);
                        Boton(numM);
                    }
                }
                else{
                    int reply = JOptionPane.showConfirmDialog(null, "¿Desea iniciar un Pedido para la mesa?", "Mesa Inactiva", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        
                        PedidoDAO pdao = new PedidoDAO();
                        Pedido pe = new Pedido();
                        pe.setIdUsuario(1);
                        //pe.setFecha(currentTimestamp);
                        pe.setTotal(0);
                        pe.setNumMesa(numM);
                        pe.setEstado(0);
                        pdao.crearEntidad(pe);

                        PedidoDetalleDAO ddao = new PedidoDetalleDAO();
                        PedidoDetalle ped = new PedidoDetalle();
                        ped.setCantidad(Integer.parseInt(cbxCantidad.getSelectedItem().toString()));
                        int fila = tbProducto.getSelectedRow();
                        int id = listaidProductoTB[fila];
                        ped.setIdProducto(id);
                        ped.setIdPedido(pdao.buscarMayor());
                        ped.setEstado(1);
                        ddao.crearEntidad(ped);

                        ListarProducto();
                        ListarPedidoDetalle(pdao.buscarMayor());
                        cbxCantidad.setSelectedIndex(0);
                        Boton(numM);
                    }
                    else {
                        numM = -1;
                        lblNumeroMesa.setText("Numero(#) de Mesa.");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"No ha seleccionado un producto.","Error",ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado una mesa.","Error",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtFiltrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyPressed
        String nom = txtFiltrar.getText();
        FiltrarProductoTXT(nom);
    }//GEN-LAST:event_txtFiltrarKeyPressed

    public void FiltrarProductoTXT(String nom){
        DefaultTableModel dtm=(DefaultTableModel)this.tbProducto.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> lc = pdao.FiltrarEntidadTXT(nom);        
        listaidProductoTB = new int[lc.size()];
        listaidCategoriaTB = new int[lc.size()];
        listaidSubCategoriaTB = new int[lc.size()];
        String col[] = {"Nombre","Costo"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];        
        for (int i = 0; i < lc.size(); i++) {
            listaidProductoTB[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombre();
            row[1] = lc.get(i).getCosto();
            listaidCategoriaTB[i] = lc.get(i).getIdCategoria();
            listaidSubCategoriaTB[i] = lc.get(i).getIdSubCategoria();
            dtm.addRow(row);
        }
    }
    
    private void cbxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriaItemStateChanged
        int index = cbxCategoria.getSelectedIndex();
        int id = listaidCatCmb[index];
        CargarSubCat(id);
        FiltrarProductoCat(id);
    }//GEN-LAST:event_cbxCategoriaItemStateChanged
    
    int[] listaidSubCatCmb;
    public void CargarSubCat(int id){
        cbxFiltro.removeAllItems();
        List<SubCategoria> c;
        SubCategoriaDAO sCat = new SubCategoriaDAO();
        c = sCat.filtrarSubCategoriaCat(id);
        int i=0;
        listaidSubCatCmb = new int[c.size()];
        for(i=0;i <= c.size()-1;i++){
            listaidSubCatCmb[i] = c.get(i).getIdSubCategoria();
            cbxFiltro.addItem(c.get(i).getNombre());
        }
    }
    
    public void FiltrarProductoCat(int id){
        DefaultTableModel dtm=(DefaultTableModel)this.tbProducto.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ProductoDAO pdao = new ProductoDAO();
        ArrayList<Producto> lc = pdao.filtrarProductoCat(id);        
        listaidProductoTB = new int[lc.size()];
        listaidCategoriaTB = new int[lc.size()];
        listaidSubCategoriaTB = new int[lc.size()];
        String col[] = {"Nombre","Costo"};
        dtm.setColumnIdentifiers(col);
        Object[] row = new Object[dtm.getColumnCount()];
        
        for (int i = 0; i < lc.size(); i++) {
            listaidProductoTB[i] = lc.get(i).getIdProducto();
            row[0] = lc.get(i).getNombre();
            row[1] = lc.get(i).getCosto(); 
            listaidCategoriaTB[i] = lc.get(i).getIdCategoria();
            listaidSubCategoriaTB[i] = lc.get(i).getIdSubCategoria();
            dtm.addRow(row);
        }
    }
    
    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        // nothing
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
        Boton(6);
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        Boton(5);
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        Boton(4);
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        Boton(3);
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
        Boton(2);
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        Boton(1);
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tbPedidoDetalle.getSelectedRow() >= 0){
            PedidoDetalleDAO ddao = new PedidoDetalleDAO();
            PedidoDetalle ped;
            int fila = tbPedidoDetalle.getSelectedRow();
            int idPedDet = listaIdPedDetTB[fila];
            int cantidad = Integer.parseInt(cbxCantidadElim.getSelectedItem().toString());

            ped = ddao.buscarEntidad(idPedDet);
            
            int reply = JOptionPane.showConfirmDialog(null, "¿Desea eliminar " + cantidad + " " + ped.getNombre() + "?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                int resta = ped.getCantidad() - cantidad;
                if(resta >= 0){
                    if(resta == 0){
                        ddao.actualizarEstado(idPedDet, 0);
                        ddao.actualizarCantidad(idPedDet, resta);

                        ListarPedidoDetalle(idPedido);
                        cbxCantidadElim.setSelectedIndex(0);
                    }
                    else{
                        ddao.actualizarCantidad(idPedDet, resta);

                        ListarPedidoDetalle(idPedido);
                        cbxCantidadElim.setSelectedIndex(0);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"La cantidad a eliminar debe ser menor a la que se tiene","Error",ERROR_MESSAGE);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado un producto del pedido.","Error",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PedidoDAO pdao = new PedidoDAO();

        if(numM > -1){
            int reply = JOptionPane.showConfirmDialog(null, "¿Desea cancelar el pedido?", "Cancelar Pedido", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                pdao.actualizarEstado(idPedido, 2);
                Boton(numM);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado una mesa.","Error",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa12ActionPerformed
        Boton(12);
    }//GEN-LAST:event_btnMesa12ActionPerformed

    private void btnMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa11ActionPerformed
        Boton(11);
    }//GEN-LAST:event_btnMesa11ActionPerformed

    private void btnMesa13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa13ActionPerformed
        Boton(13);
    }//GEN-LAST:event_btnMesa13ActionPerformed

    private void btnMesa14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa14ActionPerformed
        Boton(14);
    }//GEN-LAST:event_btnMesa14ActionPerformed

    private void btnMesa15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa15ActionPerformed
        Boton(15);
    }//GEN-LAST:event_btnMesa15ActionPerformed

    private void btnTogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTogoActionPerformed
        Boton(0);
    }//GEN-LAST:event_btnTogoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
    private javax.swing.JButton btnMesa13;
    private javax.swing.JButton btnMesa14;
    private javax.swing.JButton btnMesa15;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnTogo;
    private javax.swing.JComboBox<String> cbxCantidad;
    private javax.swing.JComboBox<String> cbxCantidadElim;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lblPro;
    private javax.swing.JLabel lblSubCategorias;
    private javax.swing.JTable tbPedidoDetalle;
    private javax.swing.JTable tbProducto;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
