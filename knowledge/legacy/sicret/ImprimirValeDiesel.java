/*    */ package sicret;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.print.PageFormat;
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ 
/*    */ public class ImprimirValeDiesel implements Printable {
/* 11 */   String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" }; public int print(Graphics g, PageFormat f, int pageIndex) {
/*    */     Font fuente;
/* 13 */     Graphics2D g2 = (Graphics2D)g;
/* 14 */     Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(), f.getImageableY(), f.getImageableWidth(), f.getImageableHeight());
/* 15 */     Ellipse2D circle = new Ellipse2D.Double(100.0D, 100.0D, 100.0D, 100.0D);
/* 16 */     switch (pageIndex) {
/*    */       case 0:
/* 18 */         g.setColor(Color.black);
/* 19 */         g2 = (Graphics2D)g;
/* 20 */         fuente = new Font("ARIAL", 0, 9);
/* 21 */         g.setFont(fuente);
/* 22 */         g.drawString(this.DATOS[0], 397, 80);
/*    */         
/* 24 */         fuente = new Font("ARIAL", 1, 11);
/* 25 */         g.setFont(fuente);
/* 26 */         g.drawString(this.DATOS[27], 500, 570);
/*    */         
/* 28 */         fuente = new Font("ARIAL", 0, 7);
/* 29 */         g.setFont(fuente);
/*    */         
/* 31 */         g.drawString(this.DATOS[1], 65, 155);
/* 32 */         g.drawString(this.DATOS[2], 65, 170);
/* 33 */         g.drawString(this.DATOS[3], 65, 185);
/* 34 */         g.drawString(this.DATOS[4], 65, 200);
/* 35 */         g.drawString(this.DATOS[5], 65, 215);
/*    */         
/* 37 */         g.drawString(this.DATOS[6], 365, 155);
/* 38 */         g.drawString(this.DATOS[7], 365, 170);
/* 39 */         g.drawString(this.DATOS[8], 365, 185);
/* 40 */         g.drawString(this.DATOS[9], 365, 200);
/* 41 */         g.drawString(this.DATOS[10], 365, 215);
/*    */         
/* 43 */         fuente = new Font("ARIAL", 0, 9);
/* 44 */         g.setFont(fuente);
/*    */         
/* 46 */         g.drawString("1 FLETE DE", 27, 290);
/* 47 */         g.drawString("TIPO: " + this.DATOS[11], 116, 305);
/* 48 */         g.drawString(this.DATOS[12], 116, 290);
/* 49 */         g.drawString("EQ: " + this.DATOS[13], 116, 320);
/* 50 */         g.drawString("PLAT: " + this.DATOS[14], 116, 335);
/* 51 */         g.drawString(this.DATOS[20], 116, 350);
/*    */         
/* 53 */         fuente = new Font("ARIAL", 0, 8);
/* 54 */         g.setFont(fuente);
/*    */         
/* 56 */         g.drawString(this.DATOS[15], 400, 290);
/* 57 */         g.drawString(this.DATOS[16], 520, 290);
/* 58 */         g.drawString(this.DATOS[16], 520, 442);
/* 59 */         g.drawString(this.DATOS[17], 520, 454);
/* 60 */         g.drawString(this.DATOS[18], 518, 477);
/* 61 */         fuente = new Font("ARIAL", 0, 8);
/* 62 */         g.setFont(fuente);
/* 63 */         g.drawString(this.DATOS[19], 240, 507);
/*    */         
/* 65 */         fuente = new Font("ARIAL", 0, 9);
/* 66 */         g.setFont(fuente);
/* 67 */         g.drawString(this.DATOS[21], 25, 510);
/* 68 */         g.drawString(this.DATOS[22], 25, 500);
/* 69 */         g.drawString(this.DATOS[23], 168, 510);
/* 70 */         g.drawString(this.DATOS[24], 168, 500);
/*    */         
/* 72 */         fuente = new Font("ARIAL", 0, 8);
/* 73 */         g.setFont(fuente);
/* 74 */         g.drawString(this.DATOS[25], 15, 470);
/*    */         
/* 76 */         fuente = new Font("ARIAL", 0, 6);
/* 77 */         g.setFont(fuente);
/* 78 */         g.drawString(this.DATOS[26], 410, 555);
/*    */         
/* 80 */         return 0;
/* 81 */     }  return 1;
/*    */   }
/*    */   
/*    */   public void recibeDatos(String[] datos) {
/* 85 */     ImprimirValeDiesel im = new ImprimirValeDiesel();
/* 86 */     im.DATOS = datos;
/* 87 */     for (int i = 0; i < this.DATOS.length; i++) {
/* 88 */       System.out.println(this.DATOS[i]);
/*    */     }
/* 90 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 91 */     job.setPrintable(im);
/* 92 */     if (job.printDialog())
/*    */       try {
/* 94 */         job.print();
/*    */       }
/* 96 */       catch (PrinterException e) {
/* 97 */         JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*    */       }  
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ImprimirValeDiesel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */