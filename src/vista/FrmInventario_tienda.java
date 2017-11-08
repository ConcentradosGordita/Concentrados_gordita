/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladoresInventario_tienda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Inventario_tienda;

/**
 *
 * @author kamt
 */
public class FrmInventario_tienda extends javax.swing.JFrame {

    /**
     * Creates new form FrmInventario_tienda
     */
    public FrmInventario_tienda() {
        initComponents();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Inventario");
        this.mostrar();
    }

   public void llenarDatos(){
        int fila = this.tblInventario.getSelectedRow();
        this.txtNomProduc.setText(String.valueOf(this.tblInventario.getValueAt(fila, 0)));
        this.txtMarcaProd.setText(String.valueOf(this.tblInventario.getValueAt(fila, 1)));
        this.txtCatProduc.setText(String.valueOf(this.tblInventario.getValueAt(fila, 2)));
        this.txtCodProducto.setText(String.valueOf(this.tblInventario.getValueAt(fila, 4)));
        this.txtCodProveedor.setText(String.valueOf(this.tblInventario.getValueAt(fila, 5)));
        this.txtStock.setText(String.valueOf(this.tblInventario.getValueAt(fila, 6)));
        
        
   }
   
   public void mostrar(){
        String[] columnas = {"Codigo","Marca","Categoria","Codigo Proveedor","Stock"};
        Object[] obj = new Object[6];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Inventario_tienda inventario= new Inventario_tienda();
        ControladoresInventario_tienda  control = new ControladoresInventario_tienda();
                ArrayList<Object> lista;
        try {
            
            lista= control.mostrarInventario_tienda();
            for(Object objeto :lista){//objeto cambiar por obj si es que no funciona asi 
            inventario = (Inventario_tienda) objeto;
            obj[0]= inventario.getNombre_producto();
            obj[1]= inventario.getMarca_producto();
            obj[2]= inventario.getCatego_producto();
            obj[3]= inventario.getId_producto();
            obj[4]= inventario.getId_proveedor();
            obj[5]= inventario.getStock();
            modelo.addRow(obj);
            }
            this.tblInventario.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
   
   public void modificar(){
        Inventario_tienda inventario= new Inventario_tienda();
        ControladoresInventario_tienda control = new ControladoresInventario_tienda();
        
         try {
         
         inventario.setNombre_producto(this.txtNomProduc.getText().trim());
         inventario.setMarca_producto(this.txtMarcaProd.getText().trim());
         inventario.setCatego_producto(this.txtCatProduc.getText().trim());
         inventario.setId_producto(Integer.parseInt(this.txtCodProducto.getText().trim()));
         inventario.setId_proveedor(this.txtCodProveedor.getText().trim());
         inventario.setStock(Integer.parseInt(this.txtStock.getText().trim()));
         
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea modificar este registro ?", "Modificar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.modificarInventario_tienda(inventario);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del modificar
   
   public void agregar(){
         Inventario_tienda inventario= new Inventario_tienda();
         ControladoresInventario_tienda control = new ControladoresInventario_tienda();
        
        
         try {
         inventario.setNombre_producto(this.txtNomProduc.getText().trim());
         inventario.setMarca_producto(this.txtMarcaProd.getText().trim());
         inventario.setCatego_producto(this.txtCatProduc.getText().trim());
         inventario.setId_producto(Integer.parseInt(this.txtCodProducto.getText().trim()));
         inventario.setId_proveedor(this.txtCodProveedor.getText().trim());
         inventario.setStock(Integer.parseInt(this.txtStock.getText().trim()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea agregar este registro a la tabla?", "Agregar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.agregarInventario_tienda(inventario);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del agregar
   public void eliminar(){
         Inventario_tienda inventario= new Inventario_tienda();
         ControladoresInventario_tienda control = new ControladoresInventario_tienda();
        
         try {
         inventario.setId_producto(Integer.parseInt(this.txtCodProducto.getText().trim()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.eliminarInventario_tienda(inventario);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del eliminar
   public void limpiar(){
               
               this.txtCatProduc.setText("");
               this.txtCodProducto.setText("");
               this.txtCodProveedor.setText("");
               this.txtMarcaProd.setText("");
               this.txtNomProduc.setText("");
               this.txtStock.setText("");
               
          
           } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomProduc = new javax.swing.JTextField();
        txtMarcaProd = new javax.swing.JTextField();
        txtCodProducto = new javax.swing.JTextField();
        txtCatProduc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtCodProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(56, 87, 107));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inventario Tienda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addContainerGap(743, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(123, 178, 197));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 87, 107));
        jLabel1.setText("Nombre Producto");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 87, 107));
        jLabel3.setText("Marca Producto ");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 87, 107));
        jLabel4.setText("Categorio Producto");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 87, 107));
        jLabel5.setText("Codigo Producto");

        txtNomProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProducKeyTyped(evt);
            }
        });

        txtMarcaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaProdKeyTyped(evt);
            }
        });

        txtCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProductoKeyTyped(evt);
            }
        });

        txtCatProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCatProducKeyTyped(evt);
            }
        });

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblInventario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtCodProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProveedorKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 87, 107));
        jLabel6.setText("Codigo Proveedor");

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(56, 87, 107));
        jLabel8.setText("Stock");

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(102, 153, 255));

        jLabel17.setText("Inventario");

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel17))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMarcaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCatProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtNomProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCatProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(txtMarcaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProducKeyTyped
        char c = evt.getKeyChar();
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtNomProducKeyTyped

    private void txtMarcaProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaProdKeyTyped

    }//GEN-LAST:event_txtMarcaProdKeyTyped

    private void txtCodProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProductoKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodProductoKeyTyped

    private void txtCatProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCatProducKeyTyped

    }//GEN-LAST:event_txtCatProducKeyTyped

    private void txtCodProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveedorKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodProveedorKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtStockKeyTyped

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

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        this.llenarDatos();
    }//GEN-LAST:event_tblInventarioMouseClicked

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
            java.util.logging.Logger.getLogger(FrmInventario_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInventario_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInventario_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInventario_tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInventario_tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtCatProduc;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtCodProveedor;
    private javax.swing.JTextField txtMarcaProd;
    private javax.swing.JTextField txtNomProduc;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
