/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Controlador.conexiones;
import Modelo.Usuario;
import Vista.MenuPrincipal;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class metodosSQLUsuario {

    public static conexiones con = new conexiones();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_num = 0;
   
    private PreparedStatement PS;
    private DefaultTableModel DIM = null;
    private ResultSet rst;
    public int guardar(Usuario user) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO usuarios (nombre,apellido,usuario,password,rango,estado,rol,recuperarcodigo) VALUES(?, ?, ?, ?, ?, ?,?,?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, user.getNombre());
            sentencia_preparada.setString(2, user.getApellido());
            sentencia_preparada.setString(3, user.getNick());
            sentencia_preparada.setString(4, user.getContrasena());
            sentencia_preparada.setString(5, user.getRango());
            sentencia_preparada.setBoolean(6, user.getEstado());
            sentencia_preparada.setInt(7, user.getRol());
            sentencia_preparada.setString(8, user.getCodrecuperar());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String BuscarNombre(String usuario) {
        String busqueda_nombre = null;
        Connection conexion = null;
        String nombre = "";
        String apellido = "";
        String rango = "";
        String password = "";
        int rol = 0;
        try {
            conexion = con.Conectarse();
            String sentencia_buscar = ("SELECT nombre,apellido,usuario,password,rango,rol FROM usuarios WHERE usuario= '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                nombre = resultado.getString("nombre");
                apellido = resultado.getString("apellido");
                usuario = resultado.getString("usuario");
                rango = resultado.getString("rango");
                rol = resultado.getInt("rol");
                password = resultado.getString("password");
                busqueda_nombre = ("NOMBRE: " + nombre + " " + apellido + "\nROL: " + rango);
                if (usuario != null && password != null) {
                    switch (rol) {
                        case 1:
                            MenuPrincipal men = new MenuPrincipal();
                            men.setVisible(true);

                            break;
                        case 2:
                            MenuPrincipal mens = new MenuPrincipal();
                            mens.CRUDUsuarios.setEnabled(false);
                            mens.CRUDEmpleados.setEnabled(false);
                            mens.ReportesUsuarios.setEnabled(false);
                            mens.ReportesEmpleados.setEnabled(false);

                            mens.setVisible(true);
                            break;
                    }
                }

            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;

    }

    //METODO PARA RECUPERAR USUARIOS O PASSWORD MEDIANTE UN CODIGO DE RECUPERACION MINIMO 10 CARACTERES
    public static String RecuperarUsuario(String codigorec) {
        String busqueda_user = null;
        Connection conexion = null;
        String usuario = "";
        String password = "";
        try {
            conexion = con.Conectarse();
            String sentencia_buscar = "SELECT usuario,password FROM usuarios WHERE recuperarcodigo"
                    + " ILIKE'%" + codigorec + "%'";
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                usuario = resultado.getString("usuario");
                password = resultado.getString("password");
                busqueda_user = ("USUARIO: " + usuario + "\nPASSWORD: " + password);

            } else {
                busqueda_user = "No existe";

            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_user;

    }

    public static String BuscarUsuarioRegistrado(String usuario, String password) {
        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = con.Conectarse();
            String sentencia_buscar_usuario = ("SELECT nombre,usuario,password FROM usuarios WHERE usuario= '" + usuario + "' AND password= '" + password + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "usuario encontrado";

            } else {
                busqueda_usuario = "usuario no encontrado";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;

    }

    public int actualizar(Usuario p) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE usuarios SET nombre=?,apellido=?,password=?,rango=?,estado=?,rol=?,recuperarcodigo=? WHERE usuario=?";
//        UPDATE usuarios
//   SET nombre=?, apellido=?, usuario=?, password=?, rango=?, estado=?, 
//       rol=?, recuperarcodigo=?
// WHERE <condition>;
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            sentencia_preparada.setString(1, p.getNombre());
            sentencia_preparada.setString(2, p.getApellido());
            sentencia_preparada.setString(3, p.getContrasena());
            sentencia_preparada.setString(4, p.getRango());
            sentencia_preparada.setBoolean(5, p.getEstado());
            sentencia_preparada.setInt(6, p.getRol());
            sentencia_preparada.setString(7, p.getCodrecuperar());

            sentencia_preparada.setString(8, p.getNick());

            res = sentencia_preparada.executeUpdate();

            sentencia_preparada.close();

            if (res > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS", "Actualizar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public int eliminarRegistro(String usuario) {
        int res = 0;
        PreparedStatement St;
        String SQLDELETE = "DELETE FROM usuarios WHERE usuario='" + usuario + "'";
        try {
            St = con.Conectarse().prepareStatement(SQLDELETE);
            res = St.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR REGISTRO", "Eliminar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    private DefaultTableModel setTitulos() {
//        NOMBRE APELLIDO USUARIO PASSWORD RANGO RECUPERARCODIGO
        DIM = new DefaultTableModel();
        DIM.addColumn("NOMBRE");
        DIM.addColumn("APELLIDO");
        DIM.addColumn("USUARIO");
        DIM.addColumn("PASSWORD");
        DIM.addColumn("RANGO");
        DIM.addColumn("RECUPERARCODIGO");
        return DIM;
    }

    public DefaultTableModel getDatos() {

        String sql = "SELECT * FROM usuarios";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("nombre");
                fila[1] = rst.getString("apellido");
                fila[2] = rst.getString("usuario");
                fila[3] = rst.getString("password");
                fila[4] = rst.getString("rango");
                fila[5] = rst.getString("recuperarcodigo");
                DIM.addRow(fila);

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DIM;
    }

    public DefaultTableModel buscaDato(int criterio, String parametro) {
//        NOMBRE APELLIDO USUARIO  RANGO
        String sql = null;
        if (criterio == 1) {
            sql = "SELECT * FROM usuarios WHERE nombre ILIKE'%" + parametro + "%'";

        } else if (criterio == 2) {
            sql = "SELECT * FROM usuarios WHERE apellido ILIKE'%" + parametro + "%'";

        } else if (criterio == 3) {

            sql = "SELECT * FROM usuarios  WHERE usuario='" + parametro + "'";
        } else if (criterio == 4) {
            sql = "SELECT * FROM usuarios WHERE rango ILIKE'%" + parametro + "%'";
        }
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("nombre");
                fila[1] = rst.getString("apellido");
                fila[2] = rst.getString("usuario");
                fila[3] = rst.getString("password");
                fila[4] = rst.getString("rango");
                fila[5] = rst.getString("recuperarcodigo");
                DIM.addRow(fila);

            }
            switch (criterio) {
                case 1:
                    try {
                    if (parametro.equalsIgnoreCase((String) fila[0])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                }

                break;
                case 2:
                        try {
                    if (parametro.equalsIgnoreCase((String) fila[1])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                }

                break;
                case 3:
                       try {
                    if (parametro.equalsIgnoreCase((String) fila[2])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                }

                break;
                case 4:
                        try {
                    if (parametro.equalsIgnoreCase((String) fila[4])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                }
                break;

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DIM;
    }

    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT * FROM usuarios ORDER BY apellido";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
//            C:\Users\Brayan\Desktop\pdf
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Usuario.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("NOMINA USUARIOS",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\RerportesUsuarios.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));
            tabla.addCell(new Paragraph("NOMBRE ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("APELLIDO ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("USER", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("PASS", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("RANGO", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("RCOD", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(5), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(8), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Usuario.pdf");
                Desktop.getDesktop().open(archivo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | IOException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTE EL DOCUMENTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel Ordernar() {
        String sql;
        sql = "SELECT * FROM usuarios ORDER BY apellido";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("nombre");
                fila[1] = rst.getString("apellido");
                fila[2] = rst.getString("usuario");
                fila[3] = rst.getString("password");
                fila[4] = rst.getString("rango");
                fila[5] = rst.getString("recuperarcodigo");
                DIM.addRow(fila);

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        return DIM;
    }
}
