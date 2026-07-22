/*    */ package sicret;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.File;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JOptionPane;
/*    */ import jxl.Workbook;
/*    */ import jxl.write.Label;
/*    */ import jxl.write.WritableSheet;
/*    */ import jxl.write.WritableWorkbook;
/*    */ 
/*    */ public class guardarManifiesto {
/* 13 */   Toolkit tk = Toolkit.getDefaultToolkit();
/* 14 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/* 15 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/* 16 */   Consultas con = new Consultas();
/* 17 */   String archivo = "";
/*    */   public guardarManifiesto(String[] campos, String cliente, String carpeta) {
/* 19 */     File f = new File(cliente);
/* 20 */     if (!f.exists()) {
/* 21 */       f.mkdir();
/*    */     }
/* 23 */     f = new File(cliente + "/" + cliente);
/* 24 */     if (!f.exists()) {
/* 25 */       f.mkdir();
/*    */     }
/* 27 */     File archi = new File(String.valueOf(f) + "/1003-001.xls");
/*    */     try {
/* 29 */       Workbook libro1 = Workbook.getWorkbook(new File("Formatos/FormatoManifiesto.xls"));
/* 30 */       WritableWorkbook copy = Workbook.createWorkbook(archi, libro1);
/* 31 */       WritableSheet hoja2 = copy.getSheet(0);
/* 32 */       Label label = new Label(0, 0, "REPORTE DE ejemplo de prueba");
/* 33 */       hoja2.addCell((WritableCell)label);
/* 34 */       copy.write();
/* 35 */       copy.close();
/* 36 */       JOptionPane.showMessageDialog(null, "<HTML>El reporte se creó satisfactoriamente en la siguiente dirección<HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, this.INFO);
/*    */     }
/* 38 */     catch (Exception i) {
/* 39 */       JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/guardarManifiesto.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */