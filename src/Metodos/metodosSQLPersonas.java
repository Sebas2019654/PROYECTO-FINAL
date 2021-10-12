package Metodos;

import static Metodos.metodosSQLUsuario.con;
import static Metodos.metodosSQLUsuario.sentencia_preparada;
import Modelo.Persona;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class metodosSQLPersonas {

    //VARIABLES
    private PreparedStatement PS;
    private DefaultTableModel DIM = null;
    private ResultSet rst;

    public int guardar(Persona per) {
        int result = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO personas (tipo_documento,documento,nombre,apellido,genero,fecha_nacimiento,estado,foto) VALUES(?, ?, ?, ?, ?, ?,?,?)");
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, per.getTipo_documento());
            sentencia_preparada.setString(2, per.getDocumento());
            sentencia_preparada.setString(3, per.getNombre());
            sentencia_preparada.setString(4, per.getApellido());
            sentencia_preparada.setString(5, per.getGenero());
            sentencia_preparada.setDate(6, (Date) per.getFecha_Nacimient());
            sentencia_preparada.setBoolean(7, per.isEstado());
            sentencia_preparada.setBytes(8, per.getFoto());
            result = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public int actualizar(Persona p) {
        int res = 0;
        Connection conexion = null;
        PreparedStatement St;
        String sqlUpdate = "UPDATE personas SET tipo_documento=?,nombre=?,apellido=?,genero=?,fecha_nacimiento=?,estado=?,foto=? WHERE documento=?";
        try {
            conexion = con.Conectarse();
            sentencia_preparada = conexion.prepareStatement(sqlUpdate);
            sentencia_preparada.setString(1, p.getTipo_documento());
            sentencia_preparada.setString(2, p.getNombre());

            sentencia_preparada.setString(3, p.getApellido());
            sentencia_preparada.setString(4, p.getGenero());
            sentencia_preparada.setDate(5, (Date) p.getFecha_Nacimient());
            sentencia_preparada.setBoolean(6, p.isEstado());
            sentencia_preparada.setBytes(7, p.getFoto());
            sentencia_preparada.setString(8, p.getDocumento());
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

    public int eliminarRegistro(String documento) {
        int res = 0;
        PreparedStatement St;
        String SQLDELETE = "DELETE fROM personas WHERE documento='" + documento + "'";
        try {
            St = con.Conectarse().prepareStatement(SQLDELETE);
            res = St.executeUpdate();
            if (res > 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR, LA CEDULA ESTA VINCULADA", "Eliminar", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    private DefaultTableModel setTitulos() {
        DIM = new DefaultTableModel();
        DIM.addColumn("TIPO DOCUMENTO");
        DIM.addColumn("DOCUMENTO");
        DIM.addColumn("NOMBRE");
        DIM.addColumn("APELLIDO");
        DIM.addColumn("GENERO");
        DIM.addColumn("FECHA NACIMIENTO");
        return DIM;
    }

    public ImageIcon Icon(String buscar) {

        String sql = null;
        ImageIcon foto;
        InputStream is;
        ImageIcon newicon = null;
        sql = "SELECT  foto FROM personas WHERE documento='" + buscar + "'";

        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();

            while (rst.next()) {

                is = rst.getBinaryStream("foto");

                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);

                java.awt.Image img = foto.getImage();
                java.awt.Image newimg = img.getScaledInstance(140, 190, java.awt.Image.SCALE_SMOOTH);

                newicon = new ImageIcon(newimg);

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();

        } catch (IOException ex) {
            Logger.getLogger(metodosSQLPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newicon;
    }

    public DefaultTableModel getDatos() {

        String sql = "SELECT * FROM personas";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("tipo_documento");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getString("genero");
                fila[5] = rst.getDate("fecha_nacimiento");
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
            sql = "SELECT * FROM personas WHERE documento='" + parametro + "'";

        } else if (criterio == 2) {
            sql = "SELECT * FROM personas WHERE nombre ILIKE'%" + parametro + "%'";

        } else if (criterio == 3) {
            sql = "SELECT * FROM personas WHERE apellido ILIKE'%" + parametro + "%'";
        } else if (criterio == 4) {
            sql = "SELECT * FROM personas WHERE genero ILIKE'%" + parametro + "%'";
        }
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("tipo_documento");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getString("genero");
                fila[5] = rst.getDate("fecha_nacimiento");
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

    public DefaultTableModel Ordernar() {
        String sql;
        sql = "SELECT * FROM personas ORDER BY apellido,nombre";
        try {
            setTitulos();
            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            Object[] fila = new Object[6];
            while (rst.next()) {
                fila[0] = rst.getString("tipo_documento");
                fila[1] = rst.getString("documento");
                fila[2] = rst.getString("nombre");
                fila[3] = rst.getString("apellido");
                fila[4] = rst.getString("genero");
                fila[5] = rst.getDate("fecha_nacimiento");
                DIM.addRow(fila);

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        return DIM;
    }

    public double Tarifatotal() {
        double tarifa = 0;
        String sql;
        sql = "SELECT SUM(tarifa) total\n"
                + "FROM estacionamiento;";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();

            while (rst.next()) {

                tarifa = rst.getDouble("total");

            }

        } catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        return tarifa;
    }

    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT * FROM personas ORDER BY apellido,nombre";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Personas.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph p = new Paragraph("NOMINA PERSONAS",
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
            document.add(new Paragraph(" "));
            tabla.addCell(new Paragraph("Tipo Doc", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Documento", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Apellido", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Genero", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));
            tabla.addCell(new Paragraph("Fecha Nac", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.RED)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString(1), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(2), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(3), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(4), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getString(5), FontFactory.getFont("arial", 10)));
                tabla.addCell(new Paragraph(rst.getDate(6).toString(), FontFactory.getFont("arial", 10)));

            }
            document.add(tabla);
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Reporte de Personas.pdf");
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

    public void imprimirDOC() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        String sql;
        sql = "SELECT tipo,COUNT(*) AS TOTAL\n"
                + "FROM vehiculos\n"
                + "GROUP BY tipo\n"
                + "ORDER BY tipo";
        try {

            PS = con.Conectarse().prepareStatement(sql);
            rst = PS.executeQuery();
            OutputStream file = new FileOutputStream(new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Informe Semanal.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            PdfPTable tabla = new PdfPTable(2);
            Paragraph p = new Paragraph("INFORME SEMANAL",
                    FontFactory.getFont("times new roman", //FUENTE
                            20, //TAMAÑO
                            Font.BOLDITALIC, //NEGRITA
                            BaseColor.RED));                    //ESTILO
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            java.util.Date date = cal.getTime();
            String fechaHora = dateFormat.format(date);
            document.add(new Paragraph("FECHA: " + fechaHora, FontFactory.getFont("arial", //FUENTE
                    14, //TAMAÑO
                    Font.BOLD, //NEGRITA
                    BaseColor.BLACK)));

            Image imagenes = Image.getInstance("src\\Images\\REPORTEESTACIONAMIENTO.png");
            imagenes.scaleToFit(200, 200);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            document.add(imagenes);
            document.add(new Paragraph(" "));
            tabla.addCell(new Paragraph("TIPO VEHICULO", FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLUE)));

            while (rst.next()) {
                tabla.addCell(new Paragraph(rst.getString("tipo"), FontFactory.getFont("arial", 13)));
                tabla.addCell(new Paragraph(rst.getString("total"), FontFactory.getFont("arial", 13)));

            }
            document.add(tabla);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("INGRESO SEMANAL: " + Tarifatotal() + "$", FontFactory.getFont("arial", //FUENTE
                    14, //TAMAÑO
                    Font.BOLD, //NEGRITA
                    BaseColor.BLACK)));
            document.close();
            file.close();
            try {
                File archivo = new File("C:\\Users\\suco0\\OneDrive\\Escritorio\\Informe Semanal.pdf");
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
