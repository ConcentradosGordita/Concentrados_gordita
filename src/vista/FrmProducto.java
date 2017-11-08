/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Db;
import controlador.ControladoresProducto;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author kamt
 */
public class FrmProducto extends javax.swing.JFrame {

    /**
     * Creates new form FrmProducto
     */
    public FrmProducto() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Producto");
        this.mostrar();
        
        try{
                Connection con = Db.connect();
                Statement s =  con.createStatement();
                ResultSet r = s.executeQuery("select * from proveedor  ");
                boolean found = false;
                String user_id = "";
                
                while(r.next()){ 
                    
                    user_id = r.getString("nombre_proveedor");
                this.cbbProv.addItem(user_id);}
                
                
                    
                    
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
     
    }

    public void llenarDatos(){
        try{
                Connection con = Db.connect();
                Statement s =  con.createStatement();
                String lol=cbbProv.getSelectedItem().toString();
                ResultSet r = s.executeQuery("select * from proveedor  where nombre_proveedor=\""+lol+"\" ");
                boolean found = false;
                String user_id3 = "";
                
                while(r.next()){ 
                    
                    user_id3 = r.getString("id_proveedor");
                                            }

                    int fila = this.tblProducto.getSelectedRow();
        this.txtCodProd.setText(String.valueOf(this.tblProducto.getValueAt(fila, 0)));
        this.txtNombreProduc.setText(String.valueOf(this.tblProducto.getValueAt(fila, 1)));
        this.txtfecFabri.setText(String.valueOf(this.tblProducto.getValueAt(fila, 2)));
        this.txtFecVenci.setText(String.valueOf(this.tblProducto.getValueAt(fila, 3)));
        this.txtCodBarra.setText(String.valueOf(this.tblProducto.getValueAt(fila, 4)));
        this.txtPrecio.setText(String.valueOf(this.tblProducto.getValueAt(fila, 5)));
        this.txtUnidExistencia.setText(String.valueOf(this.tblProducto.getValueAt(fila, 6)));
        this.cbbProv.setSelectedItem(user_id3);
        
        this.txtCodCategoria.setText(String.valueOf(this.tblProducto.getValueAt(fila, 8)));
        this.txtCodMarca.setText(String.valueOf(this.tblProducto.getValueAt(fila, 9)));
              
                
                
                    
                    
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
    }
    public void mostrar(){
        
        String[] columnas = {"Codigo","Nombre","Elaboracion","Vencimiente","Codigo Barras","Precio","Unidades de Existencia","Provedor Codigo","Categoria Codigo","Marca Codigo"};
        Object[] obj = new Object[10];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Producto producto= new Producto();
        ControladoresProducto control = new ControladoresProducto();
        DecimalFormat formato = new DecimalFormat("####.00");
        ArrayList<Object> lista;
        try {
            lista= control.mostrarProducto();
            for(Object objeto :lista){//objeto cambiar por obj si es que no funciona asi 
            producto = (Producto) objeto;
            obj[0]= producto.getId_producto();
            obj[1]= producto.getNombre_prod();
            obj[2]= producto.getFecha_lab();
            obj[3]= producto.getFecha_venc();
            obj[4]= producto.getCod_barras();
            obj[5]= producto.getPrecio_prod();
            obj[6]= producto.getUnidades_exsistencias();
            obj[7]= producto.getId_proveedor();
            obj[8]= producto.getId_categoria();
            obj[9]= producto.getId_marca();
            modelo.addRow(obj);
            }
            this.tblProducto.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
    public void modificar(){
        Producto producto= new Producto();
        ControladoresProducto control = new ControladoresProducto();
        
         try {
             
             Connection con = Db.connect();
                Statement s =  con.createStatement();
                String lol=cbbProv.getSelectedItem().toString();
                ResultSet r = s.executeQuery("select * from proveedor  where nombre_proveedor=\""+lol+"\" ");
                boolean found = false;
                String user_id3 = "";
                
                while(r.next()){ 
                    
                    user_id3 = r.getString("id_proveedor");
                    }
         producto.setId_producto(Integer.parseInt(this.txtCodProd.getText().trim()));
         producto.setNombre_prod(this.txtNombreProduc.getText().trim());
         producto.setFecha_lab(this.txtfecFabri.getText().trim());
         producto.setFecha_venc(this.txtFecVenci.getText().trim());
         producto.setCod_barras(Integer.parseInt(this.txtCodBarra.getText().trim()));
         producto.setPrecio_prod(Double.parseDouble(this.txtPrecio.getText().trim()));
         producto.setUnidades_exsistencias(Integer.parseInt(this.txtUnidExistencia.getText().trim()));
         producto.setId_proveedor(user_id3);
         producto.setId_categoria(this.txtCodCategoria.getText().trim());
         producto.setId_marca(Integer.parseInt(this.txtCodMarca.getText().trim()));
         
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea modificar este registro ?", "Modificar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.modificarProducto(producto);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del modificar
    
    public void agregar(){
        Producto producto= new Producto();
        ControladoresProducto control = new ControladoresProducto();
        
         try {
             
             Connection con = Db.connect();
                Statement s =  con.createStatement();
                String lol=cbbProv.getSelectedItem().toString();
                ResultSet r = s.executeQuery("select * from proveedor  where nombre_proveedor=\""+lol+"\" ");
                boolean found = false;
                String user_id2 = "";
                
                while(r.next()){ 
                    
                    user_id2 = r.getString("id_proveedor");
                    



              
                        }
         producto.setId_producto(Integer.parseInt(this.txtCodProd.getText().trim()));
         producto.setNombre_prod(this.txtNombreProduc.getText().trim());
         producto.setFecha_lab(this.txtfecFabri.getText().trim());
         producto.setFecha_venc(this.txtFecVenci.getText().trim());
         producto.setCod_barras(Integer.parseInt(this.txtCodBarra.getText().trim()));
         producto.setPrecio_prod(Double.parseDouble(this.txtPrecio.getText().trim()));
         producto.setUnidades_exsistencias(Integer.parseInt(this.txtUnidExistencia.getText().trim()));
         producto.setId_proveedor(user_id2);
         producto.setId_categoria(this.txtCodCategoria.getText().trim());
         producto.setId_marca(Integer.parseInt(this.txtCodMarca.getText().trim()));
         
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea agregar este registro a la tabla?", "Agregar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.agregarProducto(producto);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del agregar
        public void eliminar(){
         Producto producto= new Producto();
        ControladoresProducto control = new ControladoresProducto();
        
         try {
         producto.setId_producto(Integer.parseInt(this.txtCodProd.getText().trim()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.eliminarProducto(producto);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del eliminar
     public void limpiar(){
               
               this.txtCodBarra.setText("");
               this.txtCodCategoria.setText("");
               this.txtCodMarca.setText("");
               this.txtPrecio.setText("");
               this.txtCodProd.setText("");
               this.cbbProv.setSelectedIndex(0);
               this.txtFecVenci.setText("");
               this.txtNombreProduc.setText("");
               this.txtUnidExistencia.setText("");
               this.txtfecFabri.setText("");
               
          
           } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        txtNombreProduc = new javax.swing.JTextField();
        txtFecVenci = new javax.swing.JTextField();
        txtfecFabri = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtUnidExistencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodCategoria = new javax.swing.JTextField();
        txtCodMarca = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbbProv = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(56, 87, 107));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/producto.png"))); // NOI18N
        jButton9.setText("jButton9");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir))
                .addGap(47, 47, 47))
        );

        jPanel1.setBackground(new java.awt.Color(123, 178, 197));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 87, 107));
        jLabel1.setText("Codigo Producto");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 87, 107));
        jLabel3.setText("Nombre ");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 87, 107));
        jLabel4.setText("Fecha E labocion");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 87, 107));
        jLabel5.setText("Fecha Vencimiento");

        txtCodProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodProdMouseClicked(evt);
            }
        });
        txtCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProdKeyTyped(evt);
            }
        });

        txtNombreProduc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreProducMouseClicked(evt);
            }
        });
        txtNombreProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProducKeyTyped(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 87, 107));
        jLabel6.setText("Cod Barra");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtUnidExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidExistenciaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(56, 87, 107));
        jLabel8.setText("Precio");

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(56, 87, 107));
        jLabel9.setText("Unidades Existentes");

        txtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraActionPerformed(evt);
            }
        });
        txtCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(56, 87, 107));
        jLabel10.setText("Cod Categoria");

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(56, 87, 107));
        jLabel11.setText("Cod Proveedor");

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(56, 87, 107));
        jLabel12.setText("Cod Marca");

        txtCodCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodCategoriaKeyTyped(evt);
            }
        });

        txtCodMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodMarcaKeyTyped(evt);
            }
        });

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
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txtNombreProduc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecVenci, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(txtfecFabri))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodBarra, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtPrecio))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUnidExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbProv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(72, 72, 72)
                                .addComponent(txtCodCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecFabri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtUnidExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCodCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecVenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(txtCodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodProdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProdMouseClicked

    private void txtCodProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodProdKeyTyped

    private void txtNombreProducMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreProducMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProducMouseClicked

    private void txtNombreProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProducKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }

    }//GEN-LAST:event_txtNombreProducKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped

    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtUnidExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidExistenciaKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtUnidExistenciaKeyTyped

    private void txtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodBarraActionPerformed

    private void txtCodBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodBarraKeyTyped

    private void txtCodCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCategoriaKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodCategoriaKeyTyped

    private void txtCodMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMarcaKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtCodMarcaKeyTyped

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

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        this.llenarDatos();
    }//GEN-LAST:event_tblProductoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbbProv;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCodBarra;
    private javax.swing.JTextField txtCodCategoria;
    private javax.swing.JTextField txtCodMarca;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtFecVenci;
    private javax.swing.JTextField txtNombreProduc;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtUnidExistencia;
    private javax.swing.JTextField txtfecFabri;
    // End of variables declaration//GEN-END:variables
}
