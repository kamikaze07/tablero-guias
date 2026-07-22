/*    */ package sicret;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.awt.print.PageFormat;
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ 
/*    */ public class imprimeMani2 implements Printable {
/* 12 */   String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 13 */   int OPC = 0; public int print(Graphics g, PageFormat f, int pageIndex) {
/*    */     Font fuente;
/* 15 */     Graphics2D g2 = (Graphics2D)g;
/* 16 */     Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(), f.getImageableY(), f.getImageableWidth(), f.getImageableHeight());
/* 17 */     Ellipse2D circle = new Ellipse2D.Double(100.0D, 100.0D, 100.0D, 100.0D);
/* 18 */     switch (pageIndex) {
/*    */       case 0:
/* 20 */         g.setColor(Color.black);
/* 21 */         g2 = (Graphics2D)g;
/* 22 */         fuente = new Font("ARIAL", 1, 10);
/* 23 */         g.setFont(fuente);
/* 24 */         g.drawString(this.DATOS[0], 82, 137);
/* 25 */         g.drawString(this.DATOS[1], 210, 137);
/* 26 */         g.drawString(this.DATOS[2], 443, 137);
/*    */         
/* 28 */         fuente = new Font("ARIAL", 1, 12);
/* 29 */         g.setFont(fuente);
/* 30 */         g.drawString(this.DATOS[3], 430, 170);
/*    */         
/* 32 */         g.drawString(this.DATOS[4].toUpperCase(), 130, 280);
/*    */         
/* 34 */         fuente = new Font("ARIAL", 1, 9);
/* 35 */         g.setFont(fuente);
/* 36 */         g.drawString(this.DATOS[5], 388, 280);
/*    */         
/* 38 */         g.drawString("", 460, 280);
/*    */         
/* 40 */         fuente = new Font("ARIAL", 1, 9);
/* 41 */         g.setFont(fuente);
/* 42 */         g.drawString(this.DATOS[7], 130, 495);
/*    */         
/* 44 */         g.drawString(this.DATOS[8], 210, 567);
/* 45 */         g.drawString(this.DATOS[9], 310, 567);
/* 46 */         g.drawString(this.DATOS[10], 530, 558);
/* 47 */         g.drawString(this.DATOS[11], 530, 572);
/*    */         
/* 49 */         g.drawString(this.DATOS[12], 240, 587);
/* 50 */         g.drawString(this.DATOS[13], 120, 600);
/* 51 */         return 0;
/* 52 */     }  return 1;
/*    */   }
/*    */   
/*    */   public void recibeDatos(String[] datos) {
/* 56 */     imprimeMani2 im = new imprimeMani2();
/* 57 */     im.DATOS = datos;
/* 58 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 59 */     job.setPrintable(im);
/* 60 */     if (job.printDialog())
/*    */       try {
/* 62 */         job.print();
/*    */       }
/* 64 */       catch (PrinterException e) {
/* 65 */         JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*    */       }  
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/imprimeMani2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */