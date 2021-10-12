/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodos.metodosSQLPersonas;
import java.awt.Image;
import java.awt.Toolkit;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BuscarPersonas extends javax.swing.JDialog {

    /**
     * Creates new form mBuscarPersonas
     */
    //VARIABLES
    private PreparedStatement PS;
    private DefaultTableModel DIM;
    private ResultSet rst;

    public BuscarPersonas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon imagen = new ImageIcon("src/Images/usuariofoto.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(icono);
        this.repaint();

    }
    private String tipo_documento;
    private String documento;
    private String nombre;
    private String apellido;
    private String fecha_Nacimient;
    private String genero;
    private   Date dat;

    public Date getDat() {
        return dat;
    }
    public String getTipo_documento() {
        return tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha_Nacimient() {
        return fecha_Nacimient;
    }

  
    public String getGenero() {
        return genero;
    }
    
    metodosSQLPersonas metodos = new metodosSQLPersonas();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelfond = new javax.swing.JLabel();
        panelbotones = new javax.swing.JPanel();
        btnconsultar1 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        CBDocumento = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRegistro = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelfond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscars.gif"))); // NOI18N
        jPanel1.add(labelfond, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 280));

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

        txtbuscar.setBackground(new java.awt.Color(51, 51, 51));
        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(111, 174, 2));
        txtbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        CBDocumento.setBackground(new java.awt.Color(51, 51, 51));
        CBDocumento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CBDocumento.setForeground(new java.awt.Color(111, 174, 2));
        CBDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "DOCUMENTO", "NOMBRE", "APELLIDO", "GENERO" }));
        CBDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBDocumento.setOpaque(false);

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(CBDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(CBDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(panelbotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 470, 80));

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

        jtRegistro.setBackground(new java.awt.Color(111, 174, 2));
        jtRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtRegistro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIPO DOC", "DOCUMENTO", "NOMBRE", "APELLIDO", "GENERO", "FECHA NACIMIENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtRegistro.setSelectionBackground(new java.awt.Color(102, 204, 0));
        jtRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRegistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtRegistro);

        javax.swing.GroupLayout tablapLayout = new javax.swing.GroupLayout(tablap);
        tablap.setLayout(tablapLayout);
        tablapLayout.setHorizontalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        tablapLayout.setVerticalGroup(
            tablapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 40, -1));

        lblFoto.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(111, 174, 2));
        lblFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 4, true));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 140, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar1ActionPerformed
        ImageIcon foto;
        InputStream is;
        if (CBDocumento.getSelectedIndex() == 0 || txtbuscar.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "INGRESE DATO A BUSCAR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            jtRegistro.setModel(metodos.buscaDato(CBDocumento.getSelectedIndex(), txtbuscar.getText()));

            switch (CBDocumento.getSelectedIndex()) {
                case 1:
                    if (CBDocumento.getSelectedItem().equals("DOCUMENTO")) {
                        try{
                        lblFoto.setIcon(metodos.Icon(txtbuscar.getText()));
                        }catch(Exception ex){
                        
                        }

                    } else {
                        
                        lblFoto.setText("No Imagen");
                    }
                    break;
            }

            txtbuscar.setText("");
        }
    }//GEN-LAST:event_btnconsultar1ActionPerformed

    private void jtRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRegistroMouseClicked
        int fila = jtRegistro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Persona no seleccionada");
        } else {

            tipo_documento=jtRegistro.getValueAt(fila, 0).toString();
            documento=jtRegistro.getValueAt(fila, 1).toString();
            nombre=jtRegistro.getValueAt(fila, 2).toString();
            apellido=jtRegistro.getValueAt(fila, 3).toString();
            genero = jtRegistro.getValueAt(fila, 4).toString();
            fecha_Nacimient = jtRegistro.getValueAt(fila, 5).toString();
          
            
            try {
                dat = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_Nacimient);
                
            } catch (ParseException e) {
                getToolkit().beep();
                System.out.println("Eror en fecha de ingreso");
            }
            
           
        }
         this.dispose();
    }//GEN-LAST:event_jtRegistroMouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try{
            this.dispose();
        }catch(Exception e){
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBDocumento;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnconsultar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtRegistro;
    private javax.swing.JLabel labelfond;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel tablap;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}