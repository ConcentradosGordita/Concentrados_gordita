/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladoresEmpleados;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleados;

/**
 *
 * @author kamt
 */
public class FrmEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form FrmEmpleados
     */
    public FrmEmpleados() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Empleados");
        this.mostrar();
    }

    public void llenarDatos(){
        int fila = this.tblEmplados.getSelectedRow();
        this.txtCodEmplado.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 0)));
        this.txtNomEmpleado.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 1)));
        this.txtApeEmpleado.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 2)));
        this.cbbCargo.setSelectedItem(String.valueOf(this.tblEmplados.getValueAt(fila, 3)));
        this.txtSalario.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 4)));
        this.txtTelEmpleado.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 5)));   
        this.cbbCodSucursal.setSelectedItem(String.valueOf(this.tblEmplados.getValueAt(fila, 6)));
        this.txtUsuario.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 7)));
        this.txtContra.setText(String.valueOf(this.tblEmplados.getValueAt(fila, 8)));
        this.cbbNivUs.setSelectedItem(String.valueOf(this.tblEmplados.getValueAt(fila, 9)));
    }
    public void mostrar(){
        String[] columnas = {"Codigo","Nombre","Apellido","Cargo","Salario","Telefono","Sucursal","Usuario","Contraseña","Nivel"};
        Object[] obj = new Object[10];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Empleados empleados= new Empleados();
        ControladoresEmpleados control = new ControladoresEmpleados();
        DecimalFormat formato = new DecimalFormat("####.00");
        ArrayList<Object> lista;
        try {
            lista= control.mostrarEmpleados();
            for(Object objeto :lista){//objeto cambiar por obj si es que no funciona asi 
            empleados = (Empleados) objeto;
            obj[0]= empleados.getId_empleado();
            obj[1]= empleados.getNombre_emp();
            obj[2]= empleados.getApellido_emp();
            obj[3]= empleados.getCargo_emp();
            obj[4]= empleados.getSalario();
            obj[5]= empleados.getTelefono();
            obj[6]= empleados.getId_sucursal();
            obj[7]= empleados.getNombre_us();
            obj[8]= empleados.getCod_us();
            obj[9]= empleados.getNivel_us();
            modelo.addRow(obj);
            }
            this.tblEmplados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    
    public void modificar(){
         Empleados empleados= new Empleados();
        ControladoresEmpleados control = new ControladoresEmpleados();
        
         try {
         empleados.setId_empleado(Integer.parseInt(this.txtCodEmplado.getText().trim()));
         empleados.setNombre_emp(this.txtNomEmpleado.getText().trim());
         empleados.setApellido_emp(this.txtApeEmpleado.getText().trim());
         empleados.setCargo_emp(this.cbbCargo.getSelectedItem().toString());
         empleados.setSalario(Double.parseDouble(this.txtSalario.getText().trim()));
         empleados.setTelefono(this.txtTelEmpleado.getText().trim());
         empleados.setId_sucursal(Integer.parseInt(this.cbbCodSucursal.getSelectedItem().toString()));
         empleados.setNombre_us(this.txtUsuario.getText().trim());
         empleados.setCod_us(this.txtContra.getText().trim());
         empleados.setNivel_us(Integer.parseInt(this.cbbNivUs.getSelectedItem().toString()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea modificar este registro ?", "Modificar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.modificarEmpleados(empleados);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del modificar
    public void agregar(){
        Empleados empleados= new Empleados();
        ControladoresEmpleados control = new ControladoresEmpleados();
        
         try {
         empleados.setId_empleado(Integer.parseInt(this.txtCodEmplado.getText().trim()));
         empleados.setNombre_emp(this.txtNomEmpleado.getText().trim());
         empleados.setApellido_emp(this.txtApeEmpleado.getText().trim());
         empleados.setCargo_emp(this.cbbCargo.getSelectedItem().toString());
         empleados.setSalario(Double.parseDouble(this.txtSalario.getText().trim()));
         empleados.setTelefono(this.txtTelEmpleado.getText().trim());
         empleados.setId_sucursal(Integer.parseInt(this.cbbCodSucursal.getSelectedItem().toString()));
         empleados.setNombre_us(this.txtUsuario.getText().trim());
         empleados.setCod_us(this.txtContra.getText().trim());
         empleados.setNivel_us(Integer.parseInt(this.cbbNivUs.getSelectedItem().toString()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea agregar este registro a la tabla?", "Agregar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.agregarEmpleados(empleados);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del agregar
    
     public void eliminar(){
         Empleados empleados= new Empleados();
        ControladoresEmpleados control = new ControladoresEmpleados();
        
         try {
         empleados.setId_empleado(Integer.parseInt(this.txtCodEmplado.getText().trim()));
         int resp = JOptionPane.showConfirmDialog(this,"¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
             if (resp == JOptionPane.OK_OPTION) {
                 String mensaje = control.eliminarEmpleados(empleados);
                 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                 this.mostrar();
             }
        } catch (Exception e) {
       JOptionPane.showMessageDialog(this, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
    }//final del eliminar
     
     public void limpiar(){
               
               this.txtApeEmpleado.setText("");
               this.txtCodEmplado.setText("");
               this.txtNomEmpleado.setText("");
               this.txtContra.setText("");
               this.txtSalario.setText("");
               this.txtTelEmpleado.setText("");
               this.txtUsuario.setText("");
               this.cbbCargo.setSelectedIndex(0);
               this.cbbCodSucursal.setSelectedIndex(0);
               this.cbbNivUs.setSelectedIndex(0);
               
          
           } 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodEmplado = new javax.swing.JTextField();
        txtNomEmpleado = new javax.swing.JTextField();
        txtApeEmpleado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmplados = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelEmpleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        cbbCargo = new javax.swing.JComboBox();
        cbbCodSucursal = new javax.swing.JComboBox();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbNivUs = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(123, 178, 197));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 87, 107));
        jLabel1.setText("Codigo Emleado");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 87, 107));
        jLabel3.setText("Nombre ");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 87, 107));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 87, 107));
        jLabel5.setText("Cargo");

        txtCodEmplado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodEmpladoMouseClicked(evt);
            }
        });
        txtCodEmplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpladoActionPerformed(evt);
            }
        });
        txtCodEmplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodEmpladoKeyTyped(evt);
            }
        });

        txtNomEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomEmpleadoMouseClicked(evt);
            }
        });
        txtNomEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomEmpleadoKeyTyped(evt);
            }
        });

        txtApeEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeEmpleadoKeyTyped(evt);
            }
        });

        tblEmplados.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmplados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpladosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmplados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 87, 107));
        jLabel6.setText("Salario");

        txtTelEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelEmpleadoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(56, 87, 107));
        jLabel8.setText("Telefono");

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(56, 87, 107));
        jLabel9.setText("Codigo Sucursal");

        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        cbbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerente", "Sub Gerente", "Vendedor", "Producción" }));

        cbbCodSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "4100", "2100", "5600", "7400" }));

        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(56, 87, 107));
        jLabel13.setText("Contraseña");

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(56, 87, 107));
        jLabel14.setText("Usuario");

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(56, 87, 107));
        jLabel15.setText("Nivel de acceso");

        cbbNivUs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCodEmplado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(txtTelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addComponent(txtApeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbCodSucursal, 0, 138, Short.MAX_VALUE)
                            .addComponent(txtSalario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(10, 10, 10)
                        .addComponent(cbbNivUs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodEmplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(cbbCodSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(cbbNivUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(322, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(56, 87, 107));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro Empleados");

        jPanel14.setBackground(new java.awt.Color(0, 102, 255));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/empleados.png"))); // NOI18N
        jButton4.setText("jButton1");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(56, 87, 107));
        jLabel10.setText("Cargo");

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(56, 87, 107));
        jLabel12.setText("Salario");

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(56, 87, 107));
        jLabel11.setText("Cod Sucursal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel12)
                .addGap(248, 248, 248)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtCodEmpladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodEmpladoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEmpladoMouseClicked

    private void txtCodEmpladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEmpladoActionPerformed

    private void txtCodEmpladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpladoKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isDigit(hl)) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtCodEmpladoKeyTyped

    private void txtNomEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpleadoMouseClicked

    private void txtNomEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomEmpleadoKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtNomEmpleadoKeyTyped

    private void txtApeEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeEmpleadoKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isLetter(hl) && hl != KeyEvent.VK_SPACE) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtApeEmpleadoKeyTyped

    private void txtTelEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if (c<'0' || c>'9'){

            evt.consume();}
    }//GEN-LAST:event_txtTelEmpleadoKeyTyped

    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped
        Character hl = evt.getKeyChar();

        if (!Character.isDigit(hl)) {

            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtSalarioKeyTyped

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraKeyTyped

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

    private void tblEmpladosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpladosMouseClicked
       
        this.llenarDatos();
        
    }//GEN-LAST:event_tblEmpladosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbbCargo;
    private javax.swing.JComboBox cbbCodSucursal;
    private javax.swing.JComboBox cbbNivUs;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblEmplados;
    private javax.swing.JTextField txtApeEmpleado;
    private javax.swing.JTextField txtCodEmplado;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtNomEmpleado;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelEmpleado;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
