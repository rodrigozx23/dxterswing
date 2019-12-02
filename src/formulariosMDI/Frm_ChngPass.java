package formulariosMDI;

import daos.UsuarioDAO;
import entidades.*;
import javax.swing.JOptionPane;

public class Frm_ChngPass extends javax.swing.JInternalFrame {

    public Frm_ChngPass() {
        initComponents();
    }
    
    int idUsuario;
    public Frm_ChngPass(int id) {
        initComponents();
        idUsuario = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkMostrar = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCambiarContraseña = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtpNContraseña = new javax.swing.JPasswordField();
        txtpCContraseña = new javax.swing.JPasswordField();
        chkMostrar1 = new javax.swing.JCheckBox();
        txtAContraseña = new javax.swing.JPasswordField();

        chkMostrar.setText("Mostrar ");
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });

        setClosable(true);
        setTitle("Cambiar Contraseña");

        jLabel6.setText("CONFIRMAR CONTRASEÑA");

        jLabel2.setText("CONTRASEÑA");

        jLabel4.setText("CAMBIAR CONTRASEÑA");

        btnCambiarContraseña.setText("CAMBIAR CONTRASEÑA");
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });

        jLabel3.setText("NUEVA CONTRASEÑA");

        chkMostrar1.setText("Mostrar ");
        chkMostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrar1ActionPerformed(evt);
            }
        });

        txtAContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtpNContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpCContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(chkMostrar1))
                    .addComponent(btnCambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpNContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpCContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMostrar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed

        try{
            UsuarioDAO udao = new UsuarioDAO();
            Usuario us = new Usuario();
            us = udao.buscarEntidad(idUsuario);
            String passA = txtAContraseña.getText();
            String passN = txtpNContraseña.getText();
            String ConPass= txtpCContraseña.getText();
            if(passN.equals(ConPass)){
                if(passA.equals(us.getPassword())){
                    udao.CambiarContraseña(us.getIdUsuario(), passN);
                    if(us.getEstado() == 2){
                        udao.ContraseñaCambiada(idUsuario);
                    }
                    JOptionPane.showMessageDialog(this,"SE CAMBIO EXITOSAMENTE");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"LA CONTRASEÑA NO ES CORRECTA");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"LAS CONTRASEÑAS NO COINCIDEN");
            }

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(this,e.getMessage());

        }
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed

    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed

    }//GEN-LAST:event_chkMostrarActionPerformed

    private void chkMostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrar1ActionPerformed
        if(chkMostrar1.isSelected()){
            txtpCContraseña.setEchoChar((char)0);
            txtpNContraseña.setEchoChar((char)0);
            txtAContraseña.setEchoChar((char)0);
        }
        else{
            txtpCContraseña.setEchoChar('*');
            txtpNContraseña.setEchoChar('*');
            txtAContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_chkMostrar1ActionPerformed

    private void txtAContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JCheckBox chkMostrar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtAContraseña;
    private javax.swing.JPasswordField txtpCContraseña;
    private javax.swing.JPasswordField txtpNContraseña;
    // End of variables declaration//GEN-END:variables
}
