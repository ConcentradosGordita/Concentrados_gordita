/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladoresProveedor;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;

/**
 *
 * @author kamt
 */
public class FrmProveedor extends javax.swing.JFrame {

    /**
     * Creates new form FrmProveedor
     */
    public FrmProveedor() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Proveedor");
        this.mostrar();
    }

    public void llenarDatos(){
        int fila = this.tblRegistroProveedor.getSelectedRow();
        this.txtCodProve.setText(String.valueOf(this.tblRegistroProveedor.getValueAt(fila, 0)));
        this.txtNomProve.setText(String.valueOf(this.tblRegistroProveedor.getValueAt(fila, 1)));
        this.txtTelProveedor.setText(String.valueOf(this.tblRegistroProveedor.getValueAt(fila, 2)));
        this.txtnombEmpresa.setText(String.valueOf(this.tblRegistroProveedor.getValueAt(fila, 3)));
        
    }
    
    public void mostrar(){
        String[] columnas = {"Codigo","Nombre","Telefono","Empresa"};
        Object[] obj = new Object[4];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Proveedor proveedor= new Proveedor();
        ControladoresProveedor control = new ControladoresProveedor();
        DecimalFormat formato = new DecimalFormat("####.00");
        ArrayList<Object> lista;
        try {
            lista= control.mostrarProveedor();
            for(Object objeto :lista){//objeto cambiar por obj si es que no funciona asi 
            proveedor = (Proveedor) objeto;
            obj[0]= proveedor.getId_proveedor();
            obj[1]= proveedor.getNombre_proveedor();
            obj[2]= proveedor.getTelefono_empresa();
            obj[3]= proveedor.getNombre_empresa();
            
            modelo.addRow(obj);
            }
            this.tblRegistroProveedor.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
    public void modificar(){
         Proveedor proveedor= new Proveedor();
        ControladoresProveedor control = new ControladoresProveedor();
        
         try {
         proveedor.setId_proveedor(this.txtCodProve.getText().trim());
         proveedor.setNombre_proveedor(this.txtNomProve.getText().trim());
         proveedor.setTelefono_empresa(this.txtTelProveedor.getText().trim());
         proveedor.setNombre_empresa(this.txtnombEmpresa.getText().trim());
         
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea modificar este registro ?", "Modificar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.modificarProveedor(proveedor);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del modificar
    
    public void agregar(){
         Proveedor proveedor= new Proveedor();
        ControladoresProveedor control = new ControladoresProveedor();
        
         try {
         proveedor.setId_proveedor(this.txtCodProve.getText().trim());
         proveedor.setNombre_proveedor(this.txtNomProve.getText().trim());
         proveedor.setTelefono_empresa(this.txtTelProveedor.getText().trim());
         proveedor.setNombre_empresa(this.txtnombEmpresa.getText().trim());
        
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea agregar este registro a la tabla?", "Agregar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.agregarProveedor(proveedor);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del agregar
     
    public void eliminar(){
         Proveedor proveedor= new Proveedor();
        ControladoresProveedor control = new ControladoresProveedor();
        
         try {
         proveedor.setId_proveedor(this.txtCodProve.getText().trim());
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.eliminarProveedor(proveedor);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del eliminar
    
    public void limpiar(){
               
               this.txtCodProve.setText("");
               this.txtNomProve.setText("");
               this.txtTelProveedor.setText("");
               this.txtnombEmpresa.setText("");
               
               
          
           } 
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodProve = new javax.swing.JTextField();
        txtNomProve = new javax.swing.JTextField();
        txtnombEmpresa = new javax.swing.JTextField();
        txtTelProveedor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRegistroProveedor = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(56, 87, 107));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro Proveedor");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro.jpg"))); // NOI18N
        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(123, 178, 197));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 87, 107));
        jLabel1.setText("Codigo Proveedor");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 87, 107));
        jLabel3.setText("Nombre Proveedor");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 87, 107));
        jLabel4.setText("Telefono");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 87, 107));
        jLabel5.setText("Nombre de Empresa");

        txtCodProve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProveKeyTyped(evt);
            }
        });

        txtNomProve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProveKeyTyped(evt);
            }
        });

        txtnombEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombEmpresaKeyTyped(evt);
            }
        });

        txtTelProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelProveedorKeyTyped(evt);
            }
        });

        tblRegistroProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRegistroProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistroProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRegistroProveedor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomProve, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodProve, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel7)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(txtCodProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtNomProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel7)
                                .addContainerGap(413, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodProveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveKeyTyped

        Character hl = evt.getKeyChar();

        if (!Character.isDigit(hl)) {

            getToolkit().beep();

            evt.consume();

        }

    }//GEN-LAST:event_txtCodProveKeyTyped

    private void txtNomProveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProveKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }

    }//GEN-LAST:event_txtNomProveKeyTyped

    private void txtnombEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombEmpresaKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtnombEmpresaKeyTyped

    private void txtTelProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelProveedorKeyTyped

        Character hl = evt.getKeyChar();

        if (!Character.isDigit(hl)) {

            getToolkit().beep();

            evt.consume();

        }

    }//GEN-LAST:event_txtTelProveedorKeyTyped

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
       
        this.agregar();
        this.mostrar();
        this.limpiar();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        
        this.modificar();
        this.mostrar();
        this.limpiar();
        
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        this.eliminar();
       this.mostrar();
       this.limpiar();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void tblRegistroProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistroProveedorMouseClicked
        this.llenarDatos();
    }//GEN-LAST:event_tblRegistroProveedorMouseClicked

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
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblRegistroProveedor;
    private javax.swing.JTextField txtCodProve;
    private javax.swing.JTextField txtNomProve;
    private javax.swing.JTextField txtTelProveedor;
    private javax.swing.JTextField txtnombEmpresa;
    // End of variables declaration//GEN-END:variables
}
