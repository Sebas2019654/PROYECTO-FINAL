/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.conexiones;
import static Metodos.metodosSQLUsuario.con;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Propietario;
import Metodos.metodosSQLPropietarios;
import Modelo.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RegistroPropietarios extends javax.swing.JFrame {

    public RegistroPropietarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        listar2();

    }
    private PreparedStatement PS;
    private ResultSet rst;
    metodosSQLPropietarios sql = new metodosSQLPropietarios();

    conexiones con = new conexiones();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;

    public void buscaDato(String parametro) {
        String sql;

        sql = "SELECT * FROM personas WHERE documento='" + parametro + "'";

        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("tipo_documento");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");

            }
            if (parametro.equals(fila[1])) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO CORRECTAMENTE", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                txtnombre.setText(fila[2].toString());
                txtapellido.setText(fila[3].toString());

                btnregistrar.setEnabled(true);
                if (txtid.getText().equals("")) {
                    txtid.setEnabled(true);
                    txtid.setEditable(true);
                } else {
                    txtid.setEnabled(false);
                    txtid.setEditable(false);
                }
                txtdomicilio1.setEnabled(true);
                txtdomicilio1.setEditable(true);
                txtelefono.setEnabled(true);
                txtelefono.setEditable(true);
                txtedad.setEnabled(true);
                txtedad.setEditable(true);
                txtcorreo.setEnabled(true);
                txtcorreo.setEditable(true);
            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/autoicon.jpg"));

        return retValue;
    }

    void listar2() {
        String sql1 = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento";

        try {
            cn = con.Conectarse();
            st = cn.createStatement();
            rs = st.executeQuery(sql1);
            Object[] cliente = new Object[8];
            modelo = (DefaultTableModel) jtRegistro.getModel();
            while (rs.next()) {
                cliente[0] = rs.getString("documento");
                cliente[1] = rs.getString("nombre");
                cliente[2] = rs.getString("apellido");
                cliente[3] = rs.getString("domicilio");
                cliente[4] = rs.getString("telefono");
                cliente[5] = rs.getInt("edad");
                cliente[6] = rs.getString("email");
                cliente[7] = rs.getInt("id_cliente");

                modelo.addRow(cliente);

            }
            jtRegistro.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void Clear() {

        txtdoc1.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtid.setText("");
        txtdomicilio1.setText("");
        txtelefono.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
        txtdoc1.setEnabled(true);
        txtdoc1.setEditable(true);
        txtid.setEnabled(false);
        txtid.setEditable(false);
        txtdomicilio1.setEnabled(false);
        txtdomicilio1.setEditable(false);
        txtelefono.setEnabled(false);
        txtelefono.setEditable(false);
        txtedad.setEnabled(false);
        txtedad.setEditable(false);
        txtcorreo.setEnabled(false);
        txtcorreo.setEditable(false);
        btnregistrar.setEnabled(false);
    }

    void limpiartabla() {
        int filas = jtRegistro.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelbotones = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnconsultar1 = new javax.swing.JButton();
        lblminimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        tablap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRegistro = new javax.swing.JTable();
        tablap1 = new javax.swing.JPanel();
        txtelefono = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        lblcodigo6 = new javax.swing.JLabel();
        lblcodigo7 = new javax.swing.JLabel();
        lblcodigo8 = new javax.swing.JLabel();
        lblcodigo9 = new javax.swing.JLabel();
        lblcodigo10 = new javax.swing.JLabel();
        txtdomicilio1 = new javax.swing.JTextField();
        IngresoDatospanel = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        txtdoc1 = new javax.swing.JTextField();
        lblcodigo1 = new javax.swing.JLabel();
        lblcodigo2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblcodigo3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        javax.swing.JButton btnbuscar = new javax.swing.JButton();
        lblcodigo11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 5, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bradley Hand ITC", 1, 14), new java.awt.Color(111, 174, 2))); // NOI18N
        panelbotones.setOpaque(false);

        btnregistrar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(111, 174, 2));
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo_doc.png"))); // NOI18N
        btnregistrar.setText("INGRESAR");
        btnregistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistrar.setContentAreaFilled(false);
        btnregistrar.setEnabled(false);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(111, 174, 2));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar_doc.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar.setContentAreaFilled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(111, 174, 2));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_doc.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(111, 174, 2));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_32px.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnconsultar1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnconsultar1.setForeground(new java.awt.Color(111, 174, 2));
        btnconsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar_doc.png"))); // NOI18N
        btnconsultar1.setText("BUSCAR");
        btnconsultar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnconsultar1.setContentAreaFilled(false);
        btnconsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelbotonesLayout.createSequentialGroup()
                        .addComponent(btnregistrar)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(panelbotonesLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnconsultar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))))
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.add(panelbotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 280, 220));

        lblminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Expand_Arrow_32px.png"))); // NOI18N
        lblminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblminimizarMouseClicked(evt);
            }
        });
        jPanel1.add(lblminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 40, 30));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, -1, -1));

        tablap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTROS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        tablap.setOpaque(false);

        jtRegistro.setBackground(new java.awt.Color(111, 174, 2));
        jtRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(111, 174, 2), 3, true));
        jtRegistro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DOCUMENTO", "NOMBRE", "APELLIDO", "DOMICILIO", "TELEFONO", "EDAD", "E-MAIL", "ID_P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablapLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(tablap, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 560, 200));

        tablap1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROPIETARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        tablap1.setOpaque(false);

        txtelefono.setEditable(false);
        txtelefono.setBackground(new java.awt.Color(51, 51, 51));
        txtelefono.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtelefono.setForeground(new java.awt.Color(111, 174, 2));
        txtelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtelefono.setEnabled(false);
        txtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtelefonoKeyReleased(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(51, 51, 51));
        txtid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(111, 174, 2));
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtid.setEnabled(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });

        txtcorreo.setEditable(false);
        txtcorreo.setBackground(new java.awt.Color(51, 51, 51));
        txtcorreo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtcorreo.setForeground(new java.awt.Color(111, 174, 2));
        txtcorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtcorreo.setEnabled(false);
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcorreoKeyReleased(evt);
            }
        });

        txtedad.setEditable(false);
        txtedad.setBackground(new java.awt.Color(51, 51, 51));
        txtedad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtedad.setForeground(new java.awt.Color(111, 174, 2));
        txtedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtedad.setEnabled(false);
        txtedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtedadActionPerformed(evt);
            }
        });
        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtedadKeyReleased(evt);
            }
        });

        lblcodigo6.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo6.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo6.setText("domicilio");

        lblcodigo7.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo7.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo7.setText("telefono");

        lblcodigo8.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo8.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo8.setText("edad");

        lblcodigo9.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo9.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo9.setText("Id PROPIETARIO");

        lblcodigo10.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo10.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo10.setText("e-mail");

        txtdomicilio1.setEditable(false);
        txtdomicilio1.setBackground(new java.awt.Color(51, 51, 51));
        txtdomicilio1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtdomicilio1.setForeground(new java.awt.Color(111, 174, 2));
        txtdomicilio1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtdomicilio1.setEnabled(false);
        txtdomicilio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdomicilio1ActionPerformed(evt);
            }
        });
        txtdomicilio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdomicilio1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tablap1Layout = new javax.swing.GroupLayout(tablap1);
        tablap1.setLayout(tablap1Layout);
        tablap1Layout.setHorizontalGroup(
            tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablap1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tablap1Layout.createSequentialGroup()
                        .addComponent(lblcodigo10)
                        .addGap(18, 18, 18)
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablap1Layout.createSequentialGroup()
                        .addComponent(lblcodigo8)
                        .addGap(18, 18, 18)
                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablap1Layout.createSequentialGroup()
                        .addComponent(lblcodigo7)
                        .addGap(18, 18, 18)
                        .addComponent(txtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablap1Layout.createSequentialGroup()
                        .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblcodigo6)
                            .addComponent(lblcodigo9))
                        .addGap(18, 18, 18)
                        .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdomicilio1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        tablap1Layout.setVerticalGroup(
            tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablap1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdomicilio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(tablap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 450, 290));

        IngresoDatospanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18), new java.awt.Color(111, 174, 2))); // NOI18N
        IngresoDatospanel.setOpaque(false);

        lblcodigo.setFont(new java.awt.Font("Engravers MT", 1, 10)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo.setText("Pulse AQUí");

        txtdoc1.setBackground(new java.awt.Color(51, 51, 51));
        txtdoc1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtdoc1.setForeground(new java.awt.Color(111, 174, 2));
        txtdoc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtdoc1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtdoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoc1ActionPerformed(evt);
            }
        });
        txtdoc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdoc1KeyReleased(evt);
            }
        });

        lblcodigo1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo1.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo1.setText("DOCUMENTO");

        lblcodigo2.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo2.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo2.setText("NOMBRE");

        txtnombre.setEditable(false);
        txtnombre.setBackground(new java.awt.Color(51, 51, 51));
        txtnombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(111, 174, 2));
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        lblcodigo3.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo3.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo3.setText("APELLIDO");

        txtapellido.setEditable(false);
        txtapellido.setBackground(new java.awt.Color(51, 51, 51));
        txtapellido.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtapellido.setForeground(new java.awt.Color(111, 174, 2));
        txtapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(111, 174, 2)));
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(111, 174, 2));
        jLabel4.setText("*");

        jLabel5.setForeground(new java.awt.Color(111, 174, 2));
        jLabel5.setText("*");

        btnlimpiar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(111, 174, 2));
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/borrar.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(111, 174, 2));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trabajo-en-equipo.png"))); // NOI18N
        btnbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        lblcodigo11.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        lblcodigo11.setForeground(new java.awt.Color(111, 174, 2));
        lblcodigo11.setText("Elegir PERSONA");

        javax.swing.GroupLayout IngresoDatospanelLayout = new javax.swing.GroupLayout(IngresoDatospanel);
        IngresoDatospanel.setLayout(IngresoDatospanelLayout);
        IngresoDatospanelLayout.setHorizontalGroup(
            IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                            .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblcodigo1))
                                .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblcodigo2))
                                .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblcodigo3)))
                            .addGap(1, 1, 1))
                        .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(lblcodigo11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(lblcodigo))
                    .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        IngresoDatospanelLayout.setVerticalGroup(
            IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IngresoDatospanelLayout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(lblcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblcodigo11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lblcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(lblcodigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(IngresoDatospanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel1.add(IngresoDatospanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 360, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registros.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int s = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar este registro", "Si/No", 0);
        Integer id = 0;
        Integer year = 0;
        try {
            id = Integer.parseInt(txtid.getText());
            year = Integer.parseInt(txtedad.getText());
        } catch (NumberFormatException e) {

        }
        if (s == 0) {
            if (txtdomicilio1.getText().isEmpty() && txtelefono.getText().isEmpty() && txtedad.getText().isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "*CAMPOS OBLIGATORIOS");
            } else {
                if (ValidarEmail(txtcorreo.getText()) == true) {
                    Propietario p1 = new Propietario(id, txtdoc1.getText(), txtdomicilio1.getText(), txtelefono.getText(), year, txtcorreo.getText());

                    int res = sql.actualizar(p1);
                    if (res > 0) {
                        Toolkit.getDefaultToolkit().beep();
                        limpiartabla();
                        listar2();
                        Clear();
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        txtdoc1.setEditable(true);
                        txtdoc1.setEnabled(true);
                        txtdoc1.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "CORREO INVALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtcorreo.setText("");
                }

            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Integer id = 0;
        Integer year = 0;
        try {
            id = Integer.parseInt(txtid.getText());
            year = Integer.parseInt(txtedad.getText());
        } catch (NumberFormatException e) {

        }
        int s = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro", "Si/No", 0);
        if (s == 0) {
            Propietario p1 = new Propietario(id, txtdoc1.getText(), txtdomicilio1.getText(), txtelefono.getText(), year, txtcorreo.getText());
            int res = 0;

            int fila = jtRegistro.getSelectedColumnCount();
            if (fila < 1) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO DE LA TABLA", "AVISO", JOptionPane.INFORMATION_MESSAGE);

            } else {
                res = sql.eliminarPro(p1, id);
                if (res > 0) {
                    limpiartabla();
                    listar2();
                    Clear();
                    txtdoc1.setEditable(true);
                    txtdoc1.setEnabled(true);

                }
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed

        Integer id = 0;
        Integer year = 0;
        try {
            id = Integer.parseInt(txtid.getText());
            year = Integer.parseInt(txtedad.getText());
        } catch (NumberFormatException e) {

        }

        if (ValidarEmail(txtcorreo.getText()) == true) {
            Propietario pro = new Propietario(id, txtdoc1.getText(), txtdomicilio1.getText(), txtelefono.getText(), year, txtcorreo.getText());

            int i = sql.guardarPro(pro);

            if (i > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "PROPIETARIO REGISTRADO CON EXITO", "INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
                limpiartabla();
                listar2();
                Clear();
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "NO REGISTRADO, YA EXISTE UN PROPIETARIO CON ESE ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtdoc1.setEditable(true);
                txtdoc1.setEnabled(true);
                txtid.setText("");

            }

            btnregistrar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "CORREO INVALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcorreo.setText("");
        }


    }//GEN-LAST:event_btnregistrarActionPerformed
    public boolean ValidarEmail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    private void btnconsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultar1ActionPerformed
        BuscarPropietarios busca = new BuscarPropietarios(this, true);
        busca.setVisible(true);
        try{
            String id =  String.valueOf(busca.getId());
            String doc = busca.getDocumento();
            String nom = busca.getNombre();
            String ap = busca.getApellido();
            String dom = busca.getDomicilio();
            String telf = String.valueOf(busca.getTelf());
            String edad =  String.valueOf(busca.getEdad());
            String mail = busca.getCorreo();
            txtid.setText(id);
            txtdoc1.setText(doc);
            txtnombre.setText(nom);
            txtapellido.setText(ap);
            txtdomicilio1.setText(dom);
            txtelefono.setText(telf);
            txtedad.setText(edad);
            txtcorreo.setText(mail);
            
            txtdoc1.setEditable(false);
            txtdoc1.setEnabled(false);
                    
            txtdomicilio1.setEnabled(true);
            txtdomicilio1.setEditable(true);
            txtelefono.setEnabled(true);
            txtelefono.setEditable(true);
            txtedad.setEnabled(true);
            txtedad.setEditable(true);
            txtcorreo.setEnabled(true);
            txtcorreo.setEditable(true);
            txtid.setEditable(false);
            txtid.setEnabled(false);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnconsultar1ActionPerformed

    private void lblminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizarMouseClicked
        this.setState(RegistroPropietarios.ICONIFIED);
    }//GEN-LAST:event_lblminimizarMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jtRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRegistroMouseClicked
        txtdoc1.setEditable(false);
        txtdoc1.setEnabled(false);

        int fila = jtRegistro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Persona no seleccionada");
        } else {

            txtdoc1.setText(jtRegistro.getValueAt(fila, 0).toString());
            txtnombre.setText(jtRegistro.getValueAt(fila, 1).toString());
            txtapellido.setText(jtRegistro.getValueAt(fila, 2).toString());
            txtdomicilio1.setText(jtRegistro.getValueAt(fila, 3).toString());
            txtelefono.setText(jtRegistro.getValueAt(fila, 4).toString());
            txtedad.setText(jtRegistro.getValueAt(fila, 5).toString());
            txtcorreo.setText(jtRegistro.getValueAt(fila, 6).toString());
            txtid.setText(jtRegistro.getValueAt(fila, 7).toString());
            //java.sql.Date fecha = (java.sql.Date) jtRegistro.getValueAt(fila, 5)
            txtdomicilio1.setEnabled(true);
            txtdomicilio1.setEditable(true);
            txtelefono.setEnabled(true);
            txtelefono.setEditable(true);
            txtedad.setEnabled(true);
            txtedad.setEditable(true);
            txtcorreo.setEnabled(true);
            txtcorreo.setEditable(true);
            txtid.setEditable(false);
            txtid.setEnabled(false);
        }
    }//GEN-LAST:event_jtRegistroMouseClicked

    private void txtelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtelefonoKeyReleased
         Character validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "¡Ingrese solo números!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtelefono.setText("");
        }
    }//GEN-LAST:event_txtelefonoKeyReleased

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
         Character validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "¡Ingrese solo números!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtid.setText("");
        }
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txtcorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoKeyReleased

    private void txtedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtedadActionPerformed

    private void txtedadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyReleased
        Character validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "¡Ingrese solo números!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtedad.setText("");
        }
    }//GEN-LAST:event_txtedadKeyReleased

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased

    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased

    }//GEN-LAST:event_txtapellidoKeyReleased

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        Clear();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        buscaDato(txtdoc1.getText());
        txtdoc1.setEnabled(false);
        txtdoc1.setEditable(false);

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtdoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdoc1ActionPerformed

    private void txtdomicilio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdomicilio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdomicilio1ActionPerformed

    private void txtdomicilio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdomicilio1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdomicilio1KeyReleased

    private void txtdoc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdoc1KeyReleased
        //MENOR A 10 CARACTERES
        if (txtdoc1.getText().length() == 11) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "¡Debe tener 10 digitos!", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            txtdoc1.setText("");
        }

    }//GEN-LAST:event_txtdoc1KeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IngresoDatospanel;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnconsultar1;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtRegistro;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo1;
    private javax.swing.JLabel lblcodigo10;
    private javax.swing.JLabel lblcodigo11;
    private javax.swing.JLabel lblcodigo2;
    private javax.swing.JLabel lblcodigo3;
    private javax.swing.JLabel lblcodigo6;
    private javax.swing.JLabel lblcodigo7;
    private javax.swing.JLabel lblcodigo8;
    private javax.swing.JLabel lblcodigo9;
    private javax.swing.JLabel lblminimizar;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel tablap;
    private javax.swing.JPanel tablap1;
    public static javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcorreo;
    public static javax.swing.JTextField txtdoc1;
    private javax.swing.JTextField txtdomicilio1;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtelefono;
    private javax.swing.JTextField txtid;
    public static javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
