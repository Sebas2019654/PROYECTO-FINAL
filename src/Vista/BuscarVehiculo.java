/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodos.MetodoSQLVehiculos;
import java.awt.Toolkit;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BuscarVehiculo extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    String tip = "";
    String placa = "";
    String tipo = "";
    String marca = "";
    Date fecha;
    String color = "";
    String modelo = "";
    

    public String getModelo() {
        return modelo;
    }

    public String getTip() {
        return tip;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getColor() {
        return color;
    }

    MetodoSQLVehiculos m = new MetodoSQLVehiculos();

    public BuscarVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelbotones = new javax.swing.JPanel();
        btnconsultar1 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        CBDvehiculos = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jVehi = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        labelfond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        panelbotones.setOpaque(false);

        btnconsultar1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnconsultar1.setForeground(new java.awt.Color(111, 174, 2));
        btnconsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar_doc.png"))); // NOI18N
        btnconsultar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconsultar1.setContentAreaFilled(false);
        btnconsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar1ActionPerformed(evt);
            }
        });

        txtbuscar.setBackground(new java.awt.Color(0, 0, 0));
        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(111, 174, 2));
        txtbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        CBDvehiculos.setBackground(new java.awt.Color(51, 51, 51));
        CBDvehiculos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CBDvehiculos.setForeground(new java.awt.Color(111, 174, 2));
        CBDvehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PLACA", "MODELO", "COLOR" }));
        CBDvehiculos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBDvehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CBDvehiculos.setOpaque(false);
        CBDvehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBDvehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(CBDvehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CBDvehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(panelbotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 470, 80));

        btnSalir.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(111, 174, 2));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_32px.png"))); // NOI18N
        btnSalir.setText("REGRESAR");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 160, 43));

        tablap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESULTADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        tablap.setOpaque(false);

        jVehi.setBackground(new java.awt.Color(111, 174, 2));
        jVehi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "Tipo", "Marca", "Modelo", "Matricula", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jVehi.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jVehiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jVehi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVehiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jVehi);

        javax.swing.GroupLayout tablapLayout = new javax.swing.GroupLayout(tablap);
        tablap.setLayout(tablapLayout);
        tablapLayout.setHorizontalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablapLayout.setVerticalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablapLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(tablap, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 560, 200));

        btnCerrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Delete_32px.png"))); // NOI18N
        btnCerrar.setAutoscrolls(true);
        btnCerrar.setBorder(null);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, -1));

        labelfond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscars.gif"))); // NOI18N
        jPanel1.add(labelfond, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnconsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar1ActionPerformed
        // TODO add your handling code here:

        if (CBDvehiculos.getSelectedIndex() == 0 || txtbuscar.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "INGRESE DATO A BUSCAR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            jVehi.setModel(m.buscaDato(CBDvehiculos.getSelectedIndex(), txtbuscar.getText()));
            txtbuscar.setText("");
        }
    }//GEN-LAST:event_btnconsultar1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void jVehiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jVehiAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jVehiAncestorAdded

    private void jVehiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVehiMouseClicked
       
        int row = jVehi.getSelectedRow();
        
        if (row != -1) {
            placa = jVehi.getValueAt(row, 0).toString();
            tip = jVehi.getValueAt(row, 1).toString();
            marca = jVehi.getValueAt(row, 2).toString();
            modelo = jVehi.getValueAt(row, 3).toString();
            color = jVehi.getValueAt(row, 5).toString();
            
           String  fech = jVehi.getValueAt(row, 4).toString();
       
            
            try {
               fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fech);
                
            } catch (ParseException e) {
                getToolkit().beep();
                System.out.println("Eror en fecha de ingreso");
            }
//         fecha=jVehi.getValueAt(row, 4).toString();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
        }
    }//GEN-LAST:event_jVehiMouseClicked

    private void CBDvehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBDvehiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBDvehiculosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBDvehiculos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnconsultar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jVehi;
    private javax.swing.JLabel labelfond;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel tablap;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
