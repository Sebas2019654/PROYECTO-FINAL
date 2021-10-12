/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.*;
import Modelo.Propietario;
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
 * @author Arust
 */
public class metodosSQLPropietarios {
    
    private PreparedStatement PS;
    private DefaultTableModel DIM = null;
    private ResultSet rst;
    public int guardarPro(Propietario pro) {
        int result = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO propietarios (documento,domicilio,telefono,edad,email,id_cliente) VALUES(?, ?, ?, ?, ?, ?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, pro.getDocumentoPer());
            sentencia_preparada.setString(2, pro.getDomicilio());
            sentencia_preparada.setString(3, pro.getTelefono());
            sentencia_preparada.setInt(4, pro.getEdad());
            sentencia_preparada.setString(5, pro.getEmail());
            sentencia_preparada.setInt(6, pro.getIDCliente());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
        public int actualizar(Propietario p1) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE propietarios SET documento=?,domicilio=?,telefono=?,edad=?,email=? WHERE id_cliente=?";
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            
            sentencia_preparada.setString(1, p1.getDocumentoPer());
            sentencia_preparada.setString(2, p1.getDomicilio());
            sentencia_preparada.setString(3, p1.getTelefono());
            sentencia_preparada.setInt(4, p1.getEdad());
            sentencia_preparada.setString(5, p1.getEmail());
            sentencia_preparada.setInt(6, p1.getIDCliente());
            
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
    
         public int eliminarPro(Propietario p2, int id_pro) {
        int res = 0;
        PreparedStatement St;
        String SQLDELETE = "DELETE fROM propietarios WHERE id_cliente='" + id_pro + "'";
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
         
         //METODOS BUSCAR
          private DefaultTableModel setTitulos() {
        DIM = new DefaultTableModel();
        DIM.addColumn("DOCUMENTO");
        DIM.addColumn("NOMBRE");
        DIM.addColumn("APELLIDO");
        DIM.addColumn("DOMICILIO");       
        DIM.addColumn("TELEFONO");
        DIM.addColumn("EDAD");
        DIM.addColumn("EMAIL");
        DIM.addColumn("ID_C");
        return DIM;
    }
           public DefaultTableModel getDatos() {

         String sql1 = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento";
        
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql1);
            rst = PS.executeQuery();
            Object[] fila = new Object[8];
            while (rst.next()) {
                fila[0] = rst.getString("documento");
                fila[1] = rst.getString("nombre");
                fila[2] = rst.getString("apellido");
                fila[3] = rst.getString("domicilio");
                fila[4] = rst.getString("telefono");
                fila[5] = rst.getInt("edad");
                fila[6] = rst.getString("email");
                fila[7] = rst.getInt("id_cliente");
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
        sql = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento AND propietarios.documento = '"+parametro+"'";
        

        } else if (criterio == 2) {
            sql = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento AND nombre ILIKE'%" + parametro + "%'";
        

        } else if (criterio == 3) {
            sql = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento AND apellido ILIKE'%" + parametro + "%'";
        
        } else if (criterio == 4) {
           sql = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento AND id_cliente= '" + parametro + "'";
        
        }
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[8];
            while (rst.next()) {
                fila[0] = rst.getString("documento");
                fila[1] = rst.getString("nombre");
                fila[2] = rst.getString("apellido");
                fila[3] = rst.getString("domicilio");
                fila[4] = rst.getString("telefono");
                fila[5] = rst.getInt("edad");
                fila[6] = rst.getString("email");
                fila[7] = rst.getInt("id_cliente");
                DIM.addRow(fila);

            }
            switch (criterio) {
                case 1:
                    if (parametro.equals( fila[0])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                    case 2:
                        try{
                    if (parametro.equalsIgnoreCase((String) fila[1])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                        }catch(Exception e){}

                    break;
                   case 3:
                       try{
                    if (parametro.equalsIgnoreCase((String) fila[2])) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    }catch(Exception e){}

                    break;
                    case 4:
                        try{
                    if (parametro.equals(fila[7].toString())) {
                        Toolkit.getDefaultToolkit().beep();

                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    }catch(Exception e){}
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
        sql = "SELECT propietarios.documento,nombre,apellido,domicilio, telefono, edad, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento ORDER BY apellido";

        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[8];
            while (rst.next()) {
                fila[0] = rst.getString("documento");
                fila[1] = rst.getString("nombre");
                fila[2] = rst.getString("apellido");
                fila[3] = rst.getString("domicilio");
                fila[4] = rst.getString("telefono");
                fila[5] = rst.getInt("edad");
                fila[6] = rst.getString("email");
                fila[7] = rst.getInt("id_cliente");
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
        sql = "SELECT propietarios.documento,nombre,apellido, telefono, email, id_cliente FROM propietarios, personas WHERE propietarios.documento = personas.documento ORDER BY apellido";

        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Propietarios.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("NOMINA PROPIETARIOS",
                    FontFactory.getFont("times new roman", //FUENTE
                            14, //TAMAÑO
                            Font.BOLD, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(" "));
            Image imagenes = Image.getInstance("src\\Images\\ReportesClientes.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));
            tabla.addCell(new Paragraph("Doc", FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Apellido", FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Telefono", FontFactory.getFont("arial",9 , Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Email", FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("ID", FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.RED)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 9)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 9)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 9)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 9)));
                tabla.addCell(new Paragraph(rst.getString(5), FontFactory.getFont("arial", 9)));
                tabla.addCell(new Paragraph(rst.getString(6), FontFactory.getFont("arial", 9)));
                

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Propietarios.pdf");
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
        String SQL = "SELECT documento from propietarios";
//        String SQLDELETE = "SELECT nombre||' '||apellido AS NOMAPE from personas";
        try {
            St = con.Conectarse().prepareStatement(SQL);
            rst=St.executeQuery();
              while (rst.next()) {
                placas.addItem(rst.getString("documento"));               

            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA SENTENCIA", "SQL", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    public int guardarPro3(Propetariovehiculo pro) {
        int result = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO propietariovehiculo(documento,numplaca) VALUES(?,?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, pro.getDocumento());
            sentencia_preparada.setString(2, pro.getNumplaca());           
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
