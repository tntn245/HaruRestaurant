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
import com.itextpdf.text.PageSize;
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
import picocli.CommandLine.Help.TextTable.Cell;



public class PDFitext {
    
    public PDFitext(Connection connection, JTable table, String MANV, String SOHD) {
        String file_name = "D:\\test.pdf";
        Document document = new Document(PageSize.A5);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            //init
            BaseFont baseFont = BaseFont.createFont("/font/UTM Aptima.ttf", BaseFont.IDENTITY_H, true);
            BaseFont baseFont_bold = BaseFont.createFont("/font/UTM AptimaBold.ttf", BaseFont.IDENTITY_H, true);
            BaseFont baseFont_italic = BaseFont.createFont("/font/UTM AptimaItalic.ttf", BaseFont.IDENTITY_H, true);
            BaseFont baseFont_bolditalic = BaseFont.createFont("/font/UTM AptimaBoldItalic.ttf", BaseFont.IDENTITY_H, true);
            Font font = new Font(baseFont, 12);
            Font font_bold = new Font(baseFont_bold, 12);
            Font font_italic = new Font(baseFont_italic, 12);
            Font font_bolditalic = new Font(baseFont_bolditalic, 12);
            
            Phrase ph_temp;
            Chunk linebreak = new Chunk(new LineSeparator());
            Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            
            document.open();
            
            //table Thong tin 
            float colwidth[] ={200, 200f};
            PdfPTable table_ThongTin = new PdfPTable(colwidth);
            table_ThongTin.setWidthPercentage(100);
            
            PdfPCell c = new PdfPCell(new Phrase("NHÀ HÀNG HARU", font_bold));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Ngày hóa đơn: "+today, font));
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Linh Trung, Thủ Đức, TPHCM", font));
            c.setBorder(0);
            table_ThongTin.addCell(c);
            
            c = new PdfPCell(new Phrase("Mã nhân viên: "+ MANV, font));
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c.setBorder(0);
            c.setPaddingBottom(15);
            table_ThongTin.addCell(c);
            
            document.add(table_ThongTin);
            
            // text Hoa don
            document.add(linebreak); 
            Paragraph HD = new Paragraph("HOÁ ĐƠN", new Font(baseFont_bold, 20));
            HD.setAlignment(Element.ALIGN_CENTER);
            document.add(HD);
            Paragraph SoHD = new Paragraph("Số hóa đơn: "+SOHD, font);
            SoHD.setAlignment(Element.ALIGN_CENTER);
            document.add(SoHD);
            document.add(linebreak); 
            
            // table CTHD
            float colwidth_CTHD[] ={100f, 200f, 150f, 50f};
            PdfPTable table_CTHD = new PdfPTable(colwidth_CTHD);
            table_CTHD.setWidthPercentage(100);
            
            PdfPCell CTHD_header = new PdfPCell(new Phrase("Mã món", font_bold));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            table_CTHD.addCell(CTHD_header);
            
            CTHD_header = new PdfPCell(new Phrase("Tên món", font_bold));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            table_CTHD.addCell(CTHD_header);      
            
            CTHD_header = new PdfPCell(new Phrase("Đơn giá", font_bold));
            CTHD_header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            CTHD_header.setBorder(0);
            CTHD_header.setPaddingBottom(5);
            table_CTHD.addCell(CTHD_header);
            
            CTHD_header = new PdfPCell(new Phrase("SL", font_bold));
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
                
                CTHD = new PdfPCell(new Phrase(mamon, font));
                CTHD.setBorder(0);
                if(row == table.getRowCount()-1){
                    CTHD.setPaddingBottom(10);
                }
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(tenmon,font));
                CTHD.setBorder(0);
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(dongia,font));
                CTHD.setBorder(0);
                table_CTHD.addCell(CTHD);

                CTHD = new PdfPCell(new Phrase(sl,font));
                CTHD.setBorder(0);
                CTHD.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table_CTHD.addCell(CTHD);
            }

            PdfPCell temp = new PdfPCell(new Phrase("", font_bold));
            temp.setBorder(0);
            temp.setColspan(2);
            table_CTHD.addCell(temp);

            
            try {
                String sql = "SELECT TRIGIA FROM HOADON WHERE SOHD = '" + SOHD + "'";
                Statement statement = connection.createStatement();
                ResultSet res = statement.executeQuery(sql);
                String trigia = "0";
                while (res.next()) {
                    trigia = res.getString("TRIGIA");
                    break;
                }
                String StrTongTien = "Tổng tiền: " + trigia;
                PdfPCell TongTien = new PdfPCell(new Phrase(StrTongTien,font_bold));
                TongTien.setVerticalAlignment(Element.ALIGN_CENTER);
                TongTien.setBorder(PdfPCell.TOP);
                TongTien.setColspan(2);
                TongTien.setPaddingTop(10);
                table_CTHD.addCell(TongTien);
            } catch (SQLException | HeadlessException ex) {
                System.out.println("the error is" + ex);
            }

            document.add(table_CTHD);
            
            document.add(linebreak); 
            Paragraph p = new Paragraph("Cảm ơn quý khách!",font_italic);
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p); 

            //image
            document.add(Image.getInstance("image\\add.png"));
            
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}