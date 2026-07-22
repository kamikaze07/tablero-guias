/*    */ package sicret;
/*    */ import java.io.File;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.JTable;
/*    */ import jxl.Workbook;
/*    */ import jxl.format.CellFormat;
/*    */ import jxl.write.Label;
/*    */ import jxl.write.Number;
/*    */ import jxl.write.WritableCellFormat;
/*    */ import jxl.write.WritableFont;
/*    */ 
/*    */ public class imprimirQHSE {
/* 13 */   Toolkit tk = Toolkit.getDefaultToolkit();
/* 14 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/* 15 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/* 16 */   Consultas con = new Consultas();
/* 17 */   String archivo = "";
/* 18 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos; int segundos;
/*    */   
/*    */   public imprimirQHSE(JTable tabla, String Usuario, String original) throws BiffException, WriteException {
/* 21 */     this.archivo = direccion();
/* 22 */     if (!this.archivo.equals("no")) {
/* 23 */       File f = new File(this.archivo + ".xls");
/*    */       try {
/* 25 */         Workbook libro1 = Workbook.getWorkbook(new File("Formatos/" + original));
/* 26 */         WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/*    */         
/* 28 */         WritableSheet hoja2 = copy.getSheet(0);
/* 29 */         Label label = new Label(0, 0, "");
/* 30 */         WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 9);
/* 31 */         arial10font.setColour(Colour.BLACK);
/* 32 */         WritableCellFormat arial10format = new WritableCellFormat(arial10font);
/* 33 */         label.setCellFormat((CellFormat)arial10format);
/* 34 */         int cont = 1;
/* 35 */         for (int i = 0; i < tabla.getRowCount(); i++) {
/* 36 */           for (int j = 0; j < tabla.getColumnCount(); j++) {
/* 37 */             if (j == 0) {
/* 38 */               Number number = new Number(0, i + 9, cont);
/* 39 */               number.setCellFormat((CellFormat)arial10format);
/* 40 */               hoja2.addCell((WritableCell)number);
/*    */             } else {
/*    */               
/*    */               try {
/* 44 */                 DecimalFormat formatoN = new DecimalFormat("000.00");
/* 45 */                 formatoN.setMaximumFractionDigits(2);
/* 46 */                 float valor = Float.parseFloat(String.valueOf(tabla.getValueAt(i, j)));
/* 47 */                 formatoN.format(valor);
/* 48 */                 Number number = new Number(i, j, Integer.parseInt(formatoN.format(valor)));
/* 49 */                 number.setCellFormat((CellFormat)arial10format);
/* 50 */                 hoja2.addCell((WritableCell)number);
/*    */               }
/* 52 */               catch (NumberFormatException e) {
/* 53 */                 label = new Label(j, i + 9, tabla.getValueAt(i, j).toString());
/* 54 */                 label.setCellFormat((CellFormat)arial10format);
/* 55 */                 hoja2.addCell((WritableCell)label);
/*    */               } 
/*    */             } 
/*    */           } 
/* 59 */           cont++;
/*    */         } 
/* 61 */         copy.write();
/* 62 */         copy.close();
/* 63 */         JOptionPane.showMessageDialog(null, "<html>El Archivo ha sido creado satistactoriamente en la siguiente dirección:<hr><b>" + f.getPath() + "</b></hr></html>", "Reporte Creado", 0, this.INFO);
/*    */       }
/* 65 */       catch (IOException ioe) {
/* 66 */         System.err.println("Error al Generar Copia:\n " + String.valueOf(ioe));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public String direccion() {
/* 71 */     JFileChooser fileChooser = new JFileChooser();
/* 72 */     String fileName = "";
/* 73 */     int retVal = fileChooser.showSaveDialog(null);
/* 74 */     if (retVal == 0) {
/* 75 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 76 */       return fileName;
/*    */     } 
/* 78 */     return "no";
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/imprimirQHSE.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */