/*     */ package sicret;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class imprimeMani implements Printable {
/*  14 */   String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/*  15 */   int OPC = 0; public int print(Graphics g, PageFormat f, int pageIndex) { Calendar ahoraCal; String mesesito, hoy; Date fecha; String horita, minutos, segundos;
/*     */     Font fuente;
/*  17 */     Graphics2D g2 = (Graphics2D)g;
/*  18 */     Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(), f.getImageableY(), f.getImageableWidth(), f.getImageableHeight());
/*  19 */     Ellipse2D circle = new Ellipse2D.Double(100.0D, 100.0D, 100.0D, 100.0D);
/*  20 */     switch (pageIndex) {
/*     */       case 0:
/*  22 */         g.setColor(Color.black);
/*  23 */         g2 = (Graphics2D)g;
/*     */         
/*  25 */         ahoraCal = Calendar.getInstance();
/*  26 */         mesesito = "";
/*  27 */         hoy = "";
/*  28 */         mesesito = "" + ahoraCal.get(2) + 1;
/*  29 */         hoy = "" + ahoraCal.get(5);
/*  30 */         fecha = new Date();
/*  31 */         horita = "" + fecha.getHours();
/*  32 */         minutos = "" + fecha.getMinutes();
/*  33 */         segundos = "" + fecha.getSeconds();
/*  34 */         if (ahoraCal.get(2) + 1 < 10) {
/*  35 */           mesesito = "0" + mesesito;
/*     */         }
/*  37 */         if (ahoraCal.get(5) < 10) {
/*  38 */           hoy = "0" + hoy;
/*     */         }
/*  40 */         if (fecha.getHours() < 10) {
/*  41 */           horita = "0" + fecha.getHours();
/*     */         }
/*  43 */         if (fecha.getMinutes() < 10) {
/*  44 */           minutos = "0" + fecha.getMinutes();
/*     */         }
/*  46 */         if (fecha.getSeconds() < 10) {
/*  47 */           segundos = "0" + fecha.getSeconds();
/*     */         }
/*  49 */         fuente = new Font("ARIAL", 0, 7);
/*  50 */         g.setFont(fuente);
/*  51 */         g.drawString("Fecha de Impresión: " + hoy + "/" + mesesito + "/" + ahoraCal.get(1) + " " + horita + ":" + minutos + ":" + segundos, 357, 187);
/*  52 */         fuente = new Font("ARIAL", 1, 8);
/*  53 */         g.setFont(fuente);
/*  54 */         g.drawString(this.DATOS[0], 68, 83);
/*  55 */         g.drawString(this.DATOS[1], 190, 83);
/*  56 */         g.drawString(this.DATOS[2], 430, 83);
/*  57 */         g.drawString(this.DATOS[3].toUpperCase(), 430, 113);
/*  58 */         fuente = new Font("ARIAL", 0, 9);
/*  59 */         g.setFont(fuente);
/*     */ 
/*     */ 
/*     */         
/*  63 */         if (this.DATOS[4].equals("SÓLIDOS CONTAMINADOS CON HIDROCARBUROS")) {
/*  64 */           g.drawString("SÓLIDOS CONTAMINADOS", 90, 257);
/*  65 */           g.drawString("CON HIDROCARBUROS", 95, 272);
/*     */         }
/*  67 */         else if (this.DATOS[4].equals("LODOS CONTAMINADOS PROVENIENTES DEL SIAC TAJÍN 5")) {
/*  68 */           g.drawString("LODOS CONTAMINADOS PROVENIENTES", 60, 257);
/*  69 */           g.drawString(" DEL SIAC TAJÍN 5", 100, 272);
/*     */         }
/*  71 */         else if (this.DATOS[4].equals("RESIDUOS ADICIONALES A LA PERFORACION")) {
/*  72 */           g.drawString("RESIDUOS ADICIONALES A LA", 60, 257);
/*  73 */           g.drawString("        PERFORACION", 70, 272);
/*     */         }
/*  75 */         else if (this.DATOS[4].equals("RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE")) {
/*  76 */           g.drawString("RESIDUOS ADICIONALES A LA", 60, 257);
/*  77 */           g.drawString("PERFORACION DE ACEITE", 70, 272);
/*     */         }
/*  79 */         else if (this.DATOS[4].equals("RESIDUOS ADICIONALES A LA PERFORACION DE AGUA")) {
/*  80 */           g.drawString("RESIDUOS ADICIONALES A LA", 60, 257);
/*  81 */           g.drawString("PERFORACION DE AGUA", 70, 272);
/*     */         }
/*  83 */         else if (this.DATOS[4].equals("FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE FORMACION")) {
/*  84 */           g.drawString("FLUIDO DE EMULSION INVERSA CONTAMINADO", 60, 257);
/*  85 */           g.drawString("CON AGUA DE FORMACION", 70, 272);
/*     */         }
/*  87 */         else if (this.DATOS[4].equals("FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS")) {
/*  88 */           g.drawString("FLUIDO RECUPERADO SALMUERA", 60, 257);
/*  89 */           g.drawString("CONTAMINADA CON HIDROCARBUROS", 55, 272);
/*     */         } else {
/*     */           
/*  92 */           g.drawString(this.DATOS[4].toUpperCase(), 90, 257);
/*     */         } 
/*     */         
/*  95 */         fuente = new Font("ARIAL", 0, 7);
/*  96 */         g.setFont(fuente);
/*  97 */         g.drawString(this.DATOS[5], 387, 258);
/*  98 */         g.drawString("", 460, 268);
/*     */         
/* 100 */         fuente = new Font("ARIAL", 0, 7);
/* 101 */         g.setFont(fuente);
/* 102 */         g.drawString(this.DATOS[7], 102, 486);
/*     */         
/* 104 */         fuente = new Font("ARIAL", 0, 8);
/* 105 */         g.setFont(fuente);
/* 106 */         g.drawString(this.DATOS[8], 205, 575);
/* 107 */         g.drawString(this.DATOS[9], 309, 575);
/* 108 */         g.drawString(this.DATOS[10], 520, 565);
/* 109 */         g.drawString(this.DATOS[11], 520, 580);
/*     */         
/* 111 */         fuente = new Font("ARIAL", 0, 7);
/* 112 */         g.setFont(fuente);
/* 113 */         g.drawString(this.DATOS[15], 38, 549);
/* 114 */         g.drawString(this.DATOS[12], 240, 600);
/* 115 */         g.drawString(this.DATOS[13], 240, 616);
/*     */         
/* 117 */         g.drawString(this.DATOS[14], 110, 635);
/*     */         
/* 119 */         fuente = new Font("ARIAL", 0, 14);
/* 120 */         g.setFont(fuente);
/* 121 */         if (this.DATOS[5].equals("PIPA")) {
/* 122 */           g.drawString("X", 365, 573);
/*     */         } else {
/*     */           
/* 125 */           g.drawString("X", 339, 573);
/*     */         } 
/*     */         
/* 128 */         if (!this.DATOS[16].equals("")) {
/* 129 */           fuente = new Font("ARIAL", 1, 8);
/* 130 */           g.setFont(fuente);
/*     */         } 
/*     */ 
/*     */         
/* 134 */         return 0;
/* 135 */     }  return 1; }
/*     */ 
/*     */   
/*     */   public void recibeDatos(String[] datos) {
/* 139 */     imprimeMani im = new imprimeMani();
/* 140 */     im.DATOS = datos;
/* 141 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 142 */     job.setPrintable(im);
/* 143 */     if (job.printDialog())
/*     */       try {
/* 145 */         job.print();
/*     */       }
/* 147 */       catch (PrinterException e) {
/* 148 */         JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*     */       }  
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/imprimeMani.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */