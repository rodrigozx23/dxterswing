package formulariosMDI;

import entidades.*;
import daos.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class MDI_Principal extends javax.swing.JFrame {

    public MDI_Principal() {
        initComponents();
    }
    
    Usuario usuarioConectado;
    public MDI_Principal(int id) {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        UsuarioDAO udao = new UsuarioDAO();
        usuarioConectado = udao.buscarEntidad(id);
        ManejarPermisos(usuarioConectado.getTipo());        
        ValidarCambioCont();
    }
    
    public void ValidarCambioCont(){
        if (usuarioConectado.getEstado() == 2){
            JOptionPane.showMessageDialog(this,"Debe cambiar la contraseña predeterminada","Contraseña PredeterminaSda",WARNING_MESSAGE);
            Frm_ChngPass pss = new Frm_ChngPass(usuarioConectado.getIdUsuario());
            int x = (desktopPane.getWidth() - pss.getWidth()/2);
            int y = (desktopPane.getHeight() - pss.getHeight()/2);                 
            desktopPane.add(pss);                    
            pss.setLocation(x, y);
            pss.show();
       }
    }
    
    public void ManejarPermisos(int tipo){
        if (tipo == 1){
            desMenu.setVisible(false);
            conMenu.setVisible(false);
        }
        if (tipo == 2){
            manMenu.setVisible(false);
            desMenu.setVisible(false);
            conMenu.setVisible(false);
        }
        if (tipo == 3){
            reportDMenuItem.setVisible(false);
            reportMMenuItem.setVisible(false);
            manMenu.setVisible(false);
            desMenu.setVisible(false);
            conMenu.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        stuffMenu = new javax.swing.JMenu();
        pedMenuItem = new javax.swing.JMenuItem();
        reportDMenuItem = new javax.swing.JMenuItem();
        reportMMenuItem = new javax.swing.JMenuItem();
        manMenu = new javax.swing.JMenu();
        productoMenuItem = new javax.swing.JMenuItem();
        categoriaMenuItem = new javax.swing.JMenuItem();
        subcategoriaMenuItem = new javax.swing.JMenuItem();
        usuarioMenuItem = new javax.swing.JMenuItem();
        desMenu = new javax.swing.JMenu();
        proMenuItem = new javax.swing.JMenuItem();
        catMenuItem = new javax.swing.JMenuItem();
        subCatMenuItem = new javax.swing.JMenuItem();
        usMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        cambConMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        conMenu = new javax.swing.JMenu();
        actMenuItem = new javax.swing.JMenuItem();
        desacMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        stuffMenu.setMnemonic('h');
        stuffMenu.setText("COSAS");

        pedMenuItem.setText("Pedidos");
        pedMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedMenuItemActionPerformed(evt);
            }
        });
        stuffMenu.add(pedMenuItem);

        reportDMenuItem.setMnemonic('c');
        reportDMenuItem.setText("Reporte Diario");
        reportDMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportDMenuItemActionPerformed(evt);
            }
        });
        stuffMenu.add(reportDMenuItem);

        reportMMenuItem.setMnemonic('a');
        reportMMenuItem.setText("Reporte Mensual");
        reportMMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportMMenuItemActionPerformed(evt);
            }
        });
        stuffMenu.add(reportMMenuItem);

        menuBar.add(stuffMenu);

        manMenu.setMnemonic('f');
        manMenu.setText("Mantenimientos");

        productoMenuItem.setMnemonic('o');
        productoMenuItem.setText("Producto");
        productoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoMenuItemActionPerformed(evt);
            }
        });
        manMenu.add(productoMenuItem);

        categoriaMenuItem.setMnemonic('s');
        categoriaMenuItem.setText("Categoria");
        categoriaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaMenuItemActionPerformed(evt);
            }
        });
        manMenu.add(categoriaMenuItem);

        subcategoriaMenuItem.setMnemonic('a');
        subcategoriaMenuItem.setText("SubCategoria");
        subcategoriaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subcategoriaMenuItemActionPerformed(evt);
            }
        });
        manMenu.add(subcategoriaMenuItem);

        usuarioMenuItem.setMnemonic('x');
        usuarioMenuItem.setText("Usuarios");
        usuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioMenuItemActionPerformed(evt);
            }
        });
        manMenu.add(usuarioMenuItem);

        menuBar.add(manMenu);

        desMenu.setMnemonic('e');
        desMenu.setText("Desarrollo");

        proMenuItem.setMnemonic('t');
        proMenuItem.setText("Producto");
        proMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proMenuItemActionPerformed(evt);
            }
        });
        desMenu.add(proMenuItem);

        catMenuItem.setMnemonic('y');
        catMenuItem.setText("Categoria");
        catMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catMenuItemActionPerformed(evt);
            }
        });
        desMenu.add(catMenuItem);

        subCatMenuItem.setMnemonic('p');
        subCatMenuItem.setText("SubCategoria");
        subCatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCatMenuItemActionPerformed(evt);
            }
        });
        desMenu.add(subCatMenuItem);

        usMenuItem.setMnemonic('d');
        usMenuItem.setText("Usuario");
        usMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usMenuItemActionPerformed(evt);
            }
        });
        desMenu.add(usMenuItem);

        menuBar.add(desMenu);

        jMenu1.setText("Opciones");

        cambConMenuItem.setText("Cambiar Contraseña");
        cambConMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambConMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(cambConMenuItem);

        jMenuItem1.setText("Desconectarse");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        menuBar.add(jMenu1);

        conMenu.setText("Consola");

        actMenuItem.setText("Activar");
        actMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actMenuItemActionPerformed(evt);
            }
        });
        conMenu.add(actMenuItem);

        desacMenuItem.setText("Desactivar");
        desacMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desacMenuItemActionPerformed(evt);
            }
        });
        conMenu.add(desacMenuItem);

        menuBar.add(conMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioMenuItemActionPerformed
        Frm_MntAdmUsu us = new Frm_MntAdmUsu();
        int x = (desktopPane.getWidth()/2 - us.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - us.getHeight()/2);                 
        desktopPane.add(us);                    
        us.setLocation(x, y);
        us.show();
    }//GEN-LAST:event_usuarioMenuItemActionPerformed

    private void productoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoMenuItemActionPerformed
        Frm_MntAdmPro pro = new Frm_MntAdmPro();
        int x = (desktopPane.getWidth()/2 - pro.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - pro.getHeight()/2);                 
        desktopPane.add(pro);                    
        pro.setLocation(x, y);
        pro.show();
    }//GEN-LAST:event_productoMenuItemActionPerformed

    private void proMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proMenuItemActionPerformed
        Frm_MntoPro pro = new Frm_MntoPro();
        int x = (desktopPane.getWidth()/2 - pro.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - pro.getHeight()/2);                 
        desktopPane.add(pro);                    
        pro.setLocation(x, y);
        pro.show();
    }//GEN-LAST:event_proMenuItemActionPerformed

    private void pedMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedMenuItemActionPerformed
        Frm_Pedidos ped = new Frm_Pedidos();
        int x = (desktopPane.getWidth()/2 - ped.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - ped.getHeight()/2);                 
        desktopPane.add(ped);                    
        ped.setLocation(x, y);
        ped.show();
    }//GEN-LAST:event_pedMenuItemActionPerformed

    private void reportDMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportDMenuItemActionPerformed
        Frm_ReporteDiario rep = new Frm_ReporteDiario();
        int x = (desktopPane.getWidth()/2 - rep.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - rep.getHeight()/2);                 
        desktopPane.add(rep);                    
        rep.setLocation(x, y);
        rep.show();
    }//GEN-LAST:event_reportDMenuItemActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login log = new Login();
        log.show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void categoriaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaMenuItemActionPerformed
        Frm_MntAdmCat cat = new Frm_MntAdmCat();
        int x = (desktopPane.getWidth()/2 - cat.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - cat.getHeight()/2);                 
        desktopPane.add(cat);                    
        cat.setLocation(x, y);
        cat.show();
    }//GEN-LAST:event_categoriaMenuItemActionPerformed

    private void subcategoriaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subcategoriaMenuItemActionPerformed
        Frm_MntAdmSubCat sped = new Frm_MntAdmSubCat();
        int x = (desktopPane.getWidth()/2 - sped.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - sped.getHeight()/2);                 
        desktopPane.add(sped);                    
        sped.setLocation(x, y);
        sped.show();
    }//GEN-LAST:event_subcategoriaMenuItemActionPerformed

    private void catMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catMenuItemActionPerformed
        Frm_MntoCat cat = new Frm_MntoCat();
        int x = (desktopPane.getWidth()/2 - cat.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - cat.getHeight()/2);                 
        desktopPane.add(cat);                    
        cat.setLocation(x, y);
        cat.show();
    }//GEN-LAST:event_catMenuItemActionPerformed

    private void subCatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCatMenuItemActionPerformed
        Frm_MntoSubCat scat = new Frm_MntoSubCat();
        int x = (desktopPane.getWidth()/2 - scat.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - scat.getHeight()/2);                 
        desktopPane.add(scat);                    
        scat.setLocation(x, y);
        scat.show();
    }//GEN-LAST:event_subCatMenuItemActionPerformed

    private void usMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usMenuItemActionPerformed
        Frm_MntoUsuarios us = new Frm_MntoUsuarios();
        int x = (desktopPane.getWidth()/2 - us.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - us.getHeight()/2);                 
        desktopPane.add(us);                    
        us.setLocation(x, y);
        us.show();
    }//GEN-LAST:event_usMenuItemActionPerformed

    private void cambConMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambConMenuItemActionPerformed
        Frm_ChngPass pss = new Frm_ChngPass(usuarioConectado.getIdUsuario());
        int x = (desktopPane.getWidth()/2 - pss.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - pss.getHeight()/2);                 
        desktopPane.add(pss);                    
        pss.setLocation(x, y);
        pss.show();
    }//GEN-LAST:event_cambConMenuItemActionPerformed

    private void reportMMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportMMenuItemActionPerformed
        Frm_ReporteMensual rep = new Frm_ReporteMensual();
        int x = (desktopPane.getWidth()/2 - rep.getWidth()/2);
        int y = (desktopPane.getHeight()/2 - rep.getHeight()/2);                 
        desktopPane.add(rep);                    
        rep.setLocation(x, y);
        rep.show();
    }//GEN-LAST:event_reportMMenuItemActionPerformed

    private void actMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actMenuItemActionPerformed
        BlockDAO bdao = new BlockDAO();
        bdao.actualizarBlock(false);
        this.setSize(this.getHeight() / 2, this.getWidth() / 4);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_actMenuItemActionPerformed

    private void desacMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desacMenuItemActionPerformed
        BlockDAO bdao = new BlockDAO();
        bdao.actualizarBlock(true);
        this.setSize(this.getHeight() / 2, this.getWidth() / 4);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_desacMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MDI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actMenuItem;
    private javax.swing.JMenuItem cambConMenuItem;
    private javax.swing.JMenuItem catMenuItem;
    private javax.swing.JMenuItem categoriaMenuItem;
    private javax.swing.JMenu conMenu;
    private javax.swing.JMenu desMenu;
    private javax.swing.JMenuItem desacMenuItem;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu manMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pedMenuItem;
    private javax.swing.JMenuItem proMenuItem;
    private javax.swing.JMenuItem productoMenuItem;
    private javax.swing.JMenuItem reportDMenuItem;
    private javax.swing.JMenuItem reportMMenuItem;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JMenu stuffMenu;
    private javax.swing.JMenuItem subCatMenuItem;
    private javax.swing.JMenuItem subcategoriaMenuItem;
    private javax.swing.JMenuItem usMenuItem;
    private javax.swing.JMenuItem usuarioMenuItem;
    // End of variables declaration//GEN-END:variables

}
