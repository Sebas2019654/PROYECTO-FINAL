/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.Persona;
import Modelo.Vehiculos;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class MetodoSQLVehiculos {

    private PreparedStatement PS;
    private DefaultTableModel DIM;
    private ResultSet rst;

    public int guardar(Vehiculos p) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO vehiculos( numplaca,  tipo,  marca,  modelo, matricula, color, estado) VALUES(?, ?, ?, ?, ?, ?,?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, p.getPlaca());
            sentencia_preparada.setString(2, p.getTipo());
            sentencia_preparada.setString(3, p.getMarca());
            sentencia_preparada.setString(4, p.getModelo());
            sentencia_preparada.setDate(5, (Date) p.getMatricula());
            sentencia_preparada.setString(6, p.getColor());
            sentencia_preparada.setBoolean(7, p.isEstado());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public int actualizar(String placa, String tipo, String marca, String modelo, Date matricula, String color) {
        int res = 0;
        boolean estado = true;
        PreparedStatement St;
        String sqlUpdate = "UPDATE vehiculos SET tipo='" + tipo + "',marca='" + marca + "',modelo='" + modelo + "',matricula='" + matricula + "',color='" + color + "',estado='" + estado + "'WHERE numplaca='" + placa + "'";
        try {
            St = con.Conectarse().prepareStatement(sqlUpdate);
            res = St.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS", "Actualizar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public int eliminarRegistro(String placa) {
        int res = 0;
        PreparedStatement St;
        String SQLDELETE = "DELETE FROM vehiculos WHERE numplaca='" + placa + "'";
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
        DIM = new DefaultTableModel();
        DIM.addColumn("PLACA");
        DIM.addColumn("Tipo");
        DIM.addColumn("Marca");
        DIM.addColumn("Modelo");
        DIM.addColumn("Matricula");
        DIM.addColumn("Color");
        return DIM;
    }

    public DefaultTableModel getDatos() {

        String sql = "SELECT * FROM vehiculos";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("numplaca");
                fila[1] = rst.getString("tipo");
                fila[2] = rst.getString("marca");
                fila[3] = rst.getString("modelo");
                fila[4] = rst.getDate("matricula");
                fila[5] = rst.getString("color");

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
            sql = "SELECT * FROM vehiculos WHERE numplaca ILIKE'%" + parametro + "%'";

        } else if (criterio == 2) {
            sql = "SELECT * FROM vehiculos WHERE modelo ILIKE'%" + parametro + "%'";

        } else if (criterio == 3) {
            sql = "SELECT * FROM vehiculos WHERE color  ILIKE'%" + parametro + "%'";
        }
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];

            while (rst.next()) {
                fila[0] = rst.getString("numplaca");
                fila[1] = rst.getString("tipo");
                fila[2] = rst.getString("marca");
                fila[3] = rst.getString("modelo");
                fila[4] = rst.getDate("matricula");
                fila[5] = rst.getString("color");

                DIM.addRow(fila);

            }
            switch (criterio) {
                case 1:
                    if (parametro.equals(fila[0])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 2:
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
                case 3:
                       try {
                    if (parametro.equalsIgnoreCase((String) fila[5])) {
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

    public DefaultTableModel Ordernar() {
        String sql;
        sql = "SELECT * FROM vehiculos ORDER BY marca";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("numplaca");
                fila[1] = rst.getString("tipo");
                fila[2] = rst.getString("marca");
                fila[3] = rst.getString("modelo");
                fila[4] = rst.getDate("matricula");
                fila[5] = rst.getString("color");
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
        sql = "SELECT * FROM vehiculos ORDER BY marca";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
//            C:\Users\Brayan\Desktop\pdf
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Vehiculos.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("NOMINA VEHICULOS",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\REPORTEVEHICULO.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));//          
            tabla.addCell(new Paragraph("PLACA ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("TIPO ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("MARCA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("MODELO", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("MATRICULA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("COLOR", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getDate(5).toString(), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(6), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Vehiculos.pdf");
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
    public void mostrarJ(JComboBox placas) {
       
        PreparedStatement St;
        String SQL = "SELECT numplaca from vehiculos";
//        String SQLDELETE = "SELECT nombre||' '||apellido AS NOMAPE from personas";
        try {
            St = con.Conectarse().prepareStatement(SQL);
            rst=St.executeQuery();
              while (rst.next()) {
                placas.addItem(rst.getString("numplaca"));
                

            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA SENTENCIA", "SQL", JOptionPane.ERROR_MESSAGE);
        }
       
    }
}
