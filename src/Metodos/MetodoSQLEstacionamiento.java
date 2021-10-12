/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.Estacionamiento;
import Modelo.Propetariovehiculo;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author Brayan
 */
public class MetodoSQLEstacionamiento {

    private PreparedStatement PS;
    private DefaultTableModel DIM;
    private ResultSet rst;
//

    public int guardar(Estacionamiento p) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO estacionamiento(codigo_area,numero_placa,fecha,hora_entrada,precio) VALUES(?, ?, ?, ?,?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, p.getNum_area());
            sentencia_preparada.setString(2, p.getNro_Placa());
            sentencia_preparada.setDate(3, (Date) p.getFecha());
            sentencia_preparada.setTime(4, Time.valueOf(p.getHora_entrada()));
            sentencia_preparada.setDouble(5, p.getPrecio());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
             if (result > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "ASIGNADO CORRECTAMENTE", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public int actualizar(Estacionamiento emp) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE estacionamiento SET hora_salida=? WHERE numero_placa=?";
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            sentencia_preparada.setTime(1, Time.valueOf(emp.getHora_salida()));
            sentencia_preparada.setString(2, emp.getNro_Placa());
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

    public double tarifa(String parametro, double total) {
        String sql = null;
        sql = " SELECT EXTRACT(HOUR  FROM hora_entrada) AS horae,\n"
                + "    EXTRACT(MINUTE FROM hora_entrada) AS minutoe,\n"
                + "       EXTRACT(HOUR  FROM hora_salida) AS horas,\n"
                + "    EXTRACT(MINUTE FROM hora_salida) AS minutos\n"
                + "    \n"
                + "FROM\n"
                + "   estacionamiento WHERE numero_placa='" + parametro + "'";

        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            double horaentrada = 0, horasalida = 0, minentrada = 0, minutosalida = 0;
            while (rst.next()) {
                horaentrada = rst.getDouble("horae");
                horasalida = rst.getDouble("horas");
                minentrada = rst.getDouble("minutoe");
                minutosalida = rst.getDouble("minutos");

            }
            double horas = (horasalida - horaentrada) * 60;
            double mn = (minentrada + minutosalida + horas) * 1 / 60;
            total = mn;
            JOptionPane.showMessageDialog(null, "La tarifa total es: " + total + "$", "TARIFA INFORMACION", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return total;
    }

    public int actualiza(Estacionamiento emp) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE estacionamiento SET tarifa=? WHERE numero_placa=?";
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            sentencia_preparada.setDouble(1, emp.getTarifa());
            sentencia_preparada.setString(2, emp.getNro_Placa());
            res = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            if (res > 0) {
                Toolkit.getDefaultToolkit().beep();

            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS", "Actualizar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public int guardar5(Propetariovehiculo p) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO propietariovehiculo(documento,numplaca)VALUES(?, ?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, p.getNumplaca());
            sentencia_preparada.setString(2, p.getDocumento());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

//    public int actualizar(String placa, LocalTime fechasa) {
//        int res = 0;
//        Time a;
//        a=Time.valueOf(fechasa);        
//        PreparedStatement St;
//        String sqlUpdate = "UPDATE estacionamiento SET hora_salida="+ fechasa +",WHERE numplaca='" + placa + "'";
//        try {
//            St = con.Conectarse().prepareStatement(sqlUpdate);
//            res = St.executeUpdate();
//            if (res > 0) {
//                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS", "Actualizar", JOptionPane.ERROR_MESSAGE);
//        }
//        return res;
//    }
    public void tarifa(String placa) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = (Date) cal.getTime();
        String fechaHora = dateFormat.format(date);
        int res = 0;
        boolean estado = true;
        PreparedStatement St;
        String sqlUpdate = "SELECT hora_entrada,precio FROM estacionamiento WHERE numero_placa='" + placa + "'";

        try {

            PS = con.Conectarse().prepareStatement(sqlUpdate);

            rst = PS.executeQuery();

            String hora_entrada;
            Double precio;

            while (rst.next()) {

                hora_entrada = rst.getString("Hora entrada");

                precio = rst.getDouble("precio");
            }
            String phorasalida = null;
            Date hora_sa = (Date) dateFormat.parse(phorasalida);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS", "Actualizar", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void imprimir1() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT codigo_area,numero_placa,fecha,tarifa,hora_entrada,hora_salida FROM estacionamiento ORDER BY codigo_area";

        try {
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
//            C:\Users\Brayan\Desktop\pdf
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\reportestacionamiento.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("ASIGNACION ESTACIONAMIENTO-VEHICULO",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\discusion.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));//          
            tabla.addCell(new Paragraph("AREA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("PLACA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("FECHA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("TARIFA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("HORA ENTRADA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("HORA SALIDA", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));         
            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getDate(3).toString(), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(5), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(6), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\reportestacionamiento.pdf");
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

    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT numplaca,idasigna,propietariovehiculo.documento,nombre,apellido FROM propietariovehiculo,personas WHERE propietariovehiculo.documento=personas.documento ORDER BY apellido";

        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
//            C:\Users\Brayan\Desktop\pdf
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\reportepropietario.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(5);
            Paragraph p = new Paragraph("ASIGNACION PROPETARIO-VEHICULO",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\discusion.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));//          
            tabla.addCell(new Paragraph("Placa ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Idasigna", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Documento", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Apellido", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(5), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\reportepropietario.pdf");
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
