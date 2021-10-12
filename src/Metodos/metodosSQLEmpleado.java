package Metodos;

import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.resultado;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.Empleados;

import Modelo.Persona;
import Vista.MenuPrincipal;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class metodosSQLEmpleado {

    //VARIABLES
    private PreparedStatement PS;
    private DefaultTableModel DIM = null;
    private ResultSet rst;

    public int guardar(Empleados emp) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO empleados (documento,sueldo,trabajo) VALUES(?, ?, ?)");

        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, emp.getDocumentoper());
            sentencia_preparada.setDouble(2, emp.getSueldo());
            sentencia_preparada.setString(3, emp.getTrabajo());
            
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

   

    public int actualizar(Empleados emp) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE empleados SET sueldo=?,trabajo=? WHERE idempleado=?";
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            sentencia_preparada.setDouble(1, emp.getSueldo());
            sentencia_preparada.setString(2, emp.getTrabajo());
            sentencia_preparada.setInt(3, emp.getiDEmpleado());
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

    public int eliminarRegistro(String id_empleado) {
        int res = 0;
        PreparedStatement St;
        String SQLDELETE = "DELETE fROM empleados WHERE idempleado='" + id_empleado + "'";
        try {
            St = con.Conectarse().prepareStatement(SQLDELETE);
            res = St.executeUpdate();
            if (res > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR REGISTRO", "Eliminar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    //Buscacar ventana 
    private DefaultTableModel setTitulos() {
        DIM = new DefaultTableModel();
        DIM.addColumn("ID");
        DIM.addColumn("DOCUMENTO");
        DIM.addColumn("NOMBRE");
        DIM.addColumn("APELLIDO");
        DIM.addColumn("SUELDO");
        DIM.addColumn("ROL");
        return DIM;
    }

    public DefaultTableModel getDatos() {

        String sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getInt("idempleado");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getDouble("sueldo");
                fila[5] = rst.getString("trabajo");

                DIM.addRow(fila);

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DIM;
    }

    public DefaultTableModel buscaDato(int criterio, String parametro) {
        String sql = null;
        if (criterio == 1) {
            sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento AND empleados.documento='" + parametro + "'";

        } else if (criterio == 2) {
            sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento AND nombre ILIKE'%" + parametro + "%'";

        } else if (criterio == 3) {
            sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento AND apellido ILIKE'%" + parametro + "%'";
        } else if (criterio == 4) {
            sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento AND idempleado='" + parametro + "'";
        }
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getInt("idempleado");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getDouble("sueldo");
                fila[5] = rst.getString("trabajo");
                DIM.addRow(fila);

            }
            switch (criterio) {
                case 1:
                    if (parametro.equals(fila[1])) {
                        Toolkit.getDefaultToolkit().beep();
                        
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 2:
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
                case 3:
                       try {
                    if (parametro.equalsIgnoreCase((String) fila[3])) {
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
                    if (parametro.equalsIgnoreCase((String) fila[0])) {
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
    //fin metodo de busqueda

    //
    public DefaultTableModel Ordernar() {
        String sql;
        sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento ORDER BY idempleado";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getInt("idempleado");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getDouble("sueldo");
                fila[5] = rst.getString("trabajo");
                DIM.addRow(fila);
            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        return DIM;
    }

    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT idempleado,empleados.documento,nombre,apellido,sueldo,trabajo FROM empleados,personas WHERE empleados.documento=personas.documento ORDER BY idempleado";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Empleados.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("NOMINA EMPLEADOS",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\humanos.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));
            tabla.addCell(new Paragraph("ID", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Documento", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Apellido", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Sueldo", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Rol", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1).toString(), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(5).toString(), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(6), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Empleados.pdf");
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
}
