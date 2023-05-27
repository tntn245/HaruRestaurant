/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author My PC
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.draw.*;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



public class PDFitext {

    public PDFitext(Connection connection, JTable table, String MANV, String SOHD) {
        String file_name = "D:\\test.pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            //init
            Font font_tableThongTin = new Font(FontFamily.HELVETICA, 14, Font.ITALIC, new BaseColor(0,0,0));
            Chunk linebreak = new Chunk(new LineSeparator());
            Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            
            document.open();
            
            //table Thong tin 
            float colwidth[] ={150f, 100f, 150f};
            PdfPTable table_ThongTin = new PdfPTable(colwidth);
            table_ThongTin.setWidthPercentage(100);
            
            PdfPCell c = new PdfPCell(new Phrase("NHA HANG HARU"));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase(" "));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Ngay hoa don: "+today));
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Linh Trung, Thu Duc, TPHCM"));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase(" "));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Ma nhan vien: "+ MANV));
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c.setBorder(0);
            c.setPaddingBottom(15);
            table_ThongTin.addCell(c);
            
            document.add(table_ThongTin);
            
            // text Hoa don
            document.add(linebreak); 
            Paragraph HD = new Paragraph("HOA DON", new Font(FontFamily.HELVETICA, 20, Font.BOLD, new BaseColor(0,0,0)));
            HD.setAlignment(Element.ALIGN_CENTER);
            document.add(HD);
            Paragraph SoHD = new Paragraph("So hoa don: "+SOHD, new Font(FontFamily.HELVETICA, 14, Font.NORMAL, new BaseColor(0,0,0)));
            SoHD.setAlignment(Element.ALIGN_CENTER);
            document.add(SoHD);
            document.add(linebreak); 
            
            // table CTHD
            float colwidth_CTHD[] ={100f, 200f, 150f, 50f};
            PdfPTable table_CTHD = new PdfPTable(colwidth_CTHD);
            table_CTHD.setWidthPercentage(100);
            
            PdfPCell CTHD_header = new PdfPCell(new Phrase("Ma mon"));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            table_CTHD.addCell(CTHD_header);
            
            CTHD_header = new PdfPCell(new Phrase("Ten mon"));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            table_CTHD.addCell(CTHD_header);      
            
            CTHD_header = new PdfPCell(new Phrase("Don gia"));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            CTHD_header.setPaddingBottom(5);
            table_CTHD.addCell(CTHD_header);
            
            CTHD_header = new PdfPCell(new Phrase("So luong"));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setHorizontalAlignment(Element.ALIGN_RIGHT);
            CTHD_header.setBorder(0);
            table_CTHD.addCell(CTHD_header);
            
            table_CTHD.setHeaderRows(1);
            
            PdfPCell CTHD;
            for(int row=0; row<table.getRowCount(); row++){
                String mamon = table.getValueAt(row, 0).toString();
                String dongia = table.getValueAt(row, 1).toString();
                String sl = table.getValueAt(row, 2).toString();
                String tenmon = "";
                
                try{
                    String sql = "SELECT TENMON FROM MONAN WHERE MAMON = '"+mamon+"'";
                    Statement statement = connection.createStatement();
                    ResultSet res = statement.executeQuery(sql);
                    while(res.next()){
                        tenmon = res.getString("TENMON");
                        break;
                    }
                }
                catch(SQLException | HeadlessException ex){
                    System.out.println("the error is" + ex);
                }
                
                CTHD = new PdfPCell(new Phrase(mamon));
                CTHD.setBorder(0);
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(tenmon));
                CTHD.setBorder(0);
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(dongia));
                CTHD.setBorder(0);
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(sl));
                CTHD.setBorder(0);
                CTHD.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table_CTHD.addCell(CTHD);
            }

//            PdfPCell TongTien = new PdfPCell(new Phrase(mamon));
//            TongTien.setBorder(0);
//            table_CTHD.addCell(TongTien);

            document.add(table_CTHD);
            
//            PdfPCell c1 = new PdfPCell(val_ThongTin1);
//            c1.setBackgroundColor(BaseColor.GRAY);
//            c1.setBorder(0);
//            table_ThongTin.addCell(c1);
//            
//            c1 = new PdfPCell(new Phrase("Heading 2"));
//            c1.setBackgroundColor(BaseColor.GRAY);
//            table.addCell(c1);
//            
//            c1 = new PdfPCell(new Phrase("Heading 3"));
//            c1.setBackgroundColor(BaseColor.GRAY);
//            table.addCell(c1);
            
//            table.setHeaderRows(1);
            
//            table.addCell("1.0");
//            table.addCell("1.1");
//            table.addCell("1.2");
//            table.addCell("2.0");
//            table.addCell("2.1");
//            table.addCell("2.2");
//            
//            document.add(table);
//            document.add( new Paragraph(""));
//            document.add( new Paragraph(""));
//            document.add( new Paragraph(""));
//            document.add( new Paragraph(""));
            
            
            //image
//            document.add(Image.getInstance("D:\\a.png"));
            
            document.close();
            System.out.println("finished");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}