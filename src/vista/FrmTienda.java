/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladoresTienda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Tienda;
import vista.MenuPrincipal;

/**
 *
 * @author kamt
 */
public class FrmTienda extends javax.swing.JFrame {

    /**
     * Creates new form FrmTienda
     */
    public FrmTienda() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tienda");
        this.mostrar();
    }

   public void llenarDatos(){
        int fila = this.tblTienda.getSelectedRow();
        this.txtCodTienda.setText(String.valueOf(this.tblTienda.getValueAt(fila, 0)));
        this.txtNomTienda.setText(String.valueOf(this.tblTienda.getValueAt(fila, 1)));
        this.txtDirecTienda.setText(String.valueOf(this.tblTienda.getValueAt(fila, 2)));
        this.cbbPaisTienda.setSelectedItem(String.valueOf(this.tblTienda.getValueAt(fila, 3)));
        this.txtTelTienda.setText(String.valueOf(this.tblTienda.getValueAt(fila, 4)));
    }
   
   public void mostrar(){
        String[] columnas = {"Codigo","Nombre","Dirección","Pais","Telefono"};
        Object[] obj = new Object[5];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Tienda tienda= new Tienda();
        ControladoresTienda control = new ControladoresTienda();
        DecimalFormat formato = new DecimalFormat("####.00");
        ArrayList<Object> lista;
        try {
            lista= control.mostrarTienda();
            for(Object objeto :lista){//objeto cambiar por obj si es que no funciona asi 
            tienda = (Tienda) objeto;
            obj[0]= tienda.getId_tienda();
            obj[1]= tienda.getNombre_tienda();
            obj[2]= tienda.getDireccion_tienda();
            obj[3]= tienda.getPais_tienda();
            obj[4]= tienda.getTelefono_suc();
            modelo.addRow(obj);
            }
            this.tblTienda.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
   
    public void modificar(){
         Tienda tienda= new Tienda();
        ControladoresTienda control = new ControladoresTienda();
        
         try {
         tienda.setId_tienda(Integer.parseInt(this.txtCodTienda.getText().trim()));
         tienda.setNombre_tienda(this.txtNomTienda.getText().trim());
         tienda.setDireccion_tienda(this.txtDirecTienda.getText().trim());
         tienda.setPais_tienda(this.cbbPaisTienda.getSelectedItem().toString());
         tienda.setTelefono_suc(this.txtTelTienda.getText().trim());
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea modificar este registro ?", "Modificar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.modificarTienda(tienda);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del modificar
   
   public void agregar(){
         Tienda tienda= new Tienda();
        ControladoresTienda control = new ControladoresTienda();
        
         try {
         tienda.setId_tienda(Integer.parseInt(this.txtCodTienda.getText().trim()));
         tienda.setNombre_tienda(this.txtNomTienda.getText().trim());
         tienda.setDireccion_tienda(this.txtDirecTienda.getText().trim());
         tienda.setPais_tienda(this.cbbPaisTienda.getSelectedItem().toString());
         tienda.setTelefono_suc(this.txtTelTienda.getText().trim());
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea agregar este registro a la tabla?", "Agregar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.agregarTienda(tienda);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del agregar
   public void eliminar(){
         Tienda tienda= new Tienda();
        ControladoresTienda control = new ControladoresTienda();
        
         try {
         tienda.setId_tienda(Integer.parseInt(this.txtCodTienda.getText().trim()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.eliminarTienda(tienda);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del eliminar
   
   public void limpiar(){
               
               this.txtCodTienda.setText("");
               this.txtDirecTienda.setText("");
               this.txtNomTienda.setText("");
               this.txtTelTienda.setText("");
               this.cbbPaisTienda.setSelectedIndex(0);
               
          
           } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodTienda = new javax.swing.JTextField();
        txtNomTienda = new javax.swing.JTextField();
        txtDirecTienda = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTienda = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtTelTienda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbbPaisTienda = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(56, 87, 107));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tienda");

        jPanel10.setBackground(new java.awt.Color(51, 153, 255));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda.png"))); // NOI18N

        jLabel12.setText("Tienda");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel12)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir))
                .addGap(51, 51, 51))
        );

        jPanel1.setBackground(new java.awt.Color(123, 178, 197));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 87, 107));
        jLabel1.setText("Codigo Tienda");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 87, 107));
        jLabel3.setText("Nombre ");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 87, 107));
        jLabel4.setText("Direccion Tienda");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 87, 107));
        jLabel5.setText("Pais Tienda");

        txtCodTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodTiendaActionPerformed(evt);
            }
        });
        txtCodTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodTiendaKeyTyped(evt);
            }
        });

        txtNomTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomTiendaKeyTyped(evt);
            }
        });

        txtDirecTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirecTiendaKeyTyped(evt);
            }
        });

        tblTienda.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTienda);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtTelTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelTiendaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 87, 107));
        jLabel6.setText("Telefono Tienda");

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

        cbbPaisTienda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "El Salvador", "Mexico", "Honduras", "Guatemala", "Venezuela", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDirecTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(cbbPaisTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtCodTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDirecTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtNomTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPaisTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtCodTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodTiendaActionPerformed

    private void txtCodTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTiendaKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodTiendaKeyTyped

    private void txtNomTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomTiendaKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }

    }//GEN-LAST:event_txtNomTiendaKeyTyped

    private void txtDirecTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecTiendaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecTiendaKeyTyped

    private void txtTelTiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelTiendaKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtTelTiendaKeyTyped

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

    private void tblTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiendaMouseClicked
        
        this.llenarDatos();
    }//GEN-LAST:event_tblTiendaMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        MenuPrincipal verformulario2=new MenuPrincipal();
        this.setVisible(false);
        verformulario2.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

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
            java.util.logging.Logger.getLogger(FrmTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbbPaisTienda;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblTienda;
    private javax.swing.JTextField txtCodTienda;
    private javax.swing.JTextField txtDirecTienda;
    private javax.swing.JTextField txtNomTienda;
    private javax.swing.JTextField txtTelTienda;
    // End of variables declaration//GEN-END:variables
}
