/*     */ package sicret;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Printable;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.awt.print.PrinterJob;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class Imprimir implements Printable {
/*  16 */   String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" }; public int print(Graphics g, PageFormat f, int pageIndex) { int i; Font fuente; int inicia, lineas;
/*     */     String[] DES;
/*     */     int j, cont, l, k;
/*  19 */     Graphics2D g2 = (Graphics2D)g;
/*  20 */     Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(), f.getImageableY(), f.getImageableWidth(), f.getImageableHeight());
/*  21 */     Ellipse2D circle = new Ellipse2D.Double(100.0D, 100.0D, 100.0D, 100.0D);
/*  22 */     switch (pageIndex) {
/*     */       case 0:
/*  24 */         for (i = 0; i < this.DATOS.length; i++) {
/*  25 */           System.out.println("" + i + ": " + i);
/*     */         }
/*  27 */         g.setColor(Color.black);
/*  28 */         g2 = (Graphics2D)g;
/*  29 */         fuente = new Font("ARIAL", 0, 12);
/*  30 */         g.setFont(fuente);
/*  31 */         g.drawString(this.DATOS[0], 407, 77);
/*     */         
/*  33 */         fuente = new Font("ARIAL", 0, 15);
/*  34 */         g.setFont(fuente);
/*  35 */         g.drawString(this.DATOS[27], 480, 536);
/*     */ 
/*     */         
/*  38 */         fuente = new Font("ARIAL", 0, 10);
/*  39 */         g.setFont(fuente);
/*     */         
/*  41 */         g.drawString(this.DATOS[1], 75, 155);
/*  42 */         g.drawString(this.DATOS[2], 75, 170);
/*  43 */         g.drawString(this.DATOS[3], 75, 185);
/*  44 */         g.drawString(this.DATOS[4], 75, 200);
/*  45 */         g.drawString(this.DATOS[5], 75, 215);
/*     */         
/*  47 */         g.drawString("CLIENTE: " + this.DATOS[33], 27, 240);
/*     */         
/*  49 */         g.drawString(this.DATOS[6], 375, 155);
/*  50 */         g.drawString(this.DATOS[7], 375, 170);
/*  51 */         g.drawString(this.DATOS[8], 375, 185);
/*  52 */         g.drawString(this.DATOS[9], 375, 200);
/*  53 */         g.drawString(this.DATOS[10], 375, 215);
/*     */         
/*  55 */         fuente = new Font("ARIAL", 0, 12);
/*  56 */         g.setFont(fuente);
/*     */ 
/*     */         
/*  59 */         if (this.DATOS[28].equals("ESTADIA")) {
/*  60 */           g.drawString("    " + this.DATOS[28] + ":", 27, 290);
/*     */         } else {
/*  62 */           g.drawString("1   " + this.DATOS[28] + ":", 27, 290);
/*     */         } 
/*  64 */         g.drawString("TIPO: " + this.DATOS[11], 116, 320);
/*  65 */         g.drawString(this.DATOS[12], 116, 305);
/*  66 */         g.drawString(this.DATOS[13], 116, 335);
/*  67 */         g.drawString(this.DATOS[14], 116, 350);
/*  68 */         g.drawString(this.DATOS[20], 116, 365);
/*     */         
/*  70 */         fuente = new Font("ARIAL", 0, 11);
/*  71 */         g.setFont(fuente);
/*     */ 
/*     */         
/*  74 */         g.drawString(this.DATOS[16], 530, 290);
/*  75 */         g.drawString(this.DATOS[16], 530, 442);
/*  76 */         g.drawString(this.DATOS[17], 530, 454);
/*  77 */         g.drawString(this.DATOS[18], 510, 477);
/*  78 */         fuente = new Font("ARIAL", 0, 11);
/*  79 */         g.setFont(fuente);
/*  80 */         g.drawString(this.DATOS[19], 250, 507);
/*     */         
/*  82 */         fuente = new Font("ARIAL", 0, 12);
/*  83 */         g.setFont(fuente);
/*  84 */         g.drawString(this.DATOS[21], 25, 513);
/*  85 */         g.drawString(this.DATOS[22], 25, 503);
/*  86 */         g.drawString(this.DATOS[23], 168, 513);
/*  87 */         g.drawString(this.DATOS[24], 168, 503);
/*     */         
/*  89 */         g.drawString(this.DATOS[31], 168, 535);
/*  90 */         g.drawString(this.DATOS[32], 168, 525);
/*     */         
/*  92 */         fuente = new Font("ARIAL", 0, 10);
/*  93 */         g.setFont(fuente);
/*  94 */         g.drawString(this.DATOS[25], 25, 455);
/*     */ 
/*     */ 
/*     */         
/*  98 */         inicia = 470;
/*  99 */         lineas = this.DATOS[29].length() / 82;
/* 100 */         lineas += 2;
/* 101 */         DES = new String[lineas];
/* 102 */         for (j = 0; j < DES.length; j++) {
/* 103 */           DES[j] = new String("");
/*     */         }
/* 105 */         cont = 0;
/* 106 */         l = 0;
/* 107 */         for (k = 0; k < this.DATOS[29].length(); k++) {
/* 108 */           if (cont <= 82) {
/* 109 */             DES[l] = DES[l] + DES[l];
/* 110 */             cont++;
/*     */           } else {
/* 112 */             DES[l] = DES[l] + DES[l];
/* 113 */             cont = 0;
/* 114 */             l++;
/*     */           } 
/*     */         } 
/* 117 */         for (k = 0; k < DES.length; k++) {
/* 118 */           g.drawString(DES[k], 25, inicia);
/* 119 */           inicia += 8;
/*     */         } 
/*     */         
/* 122 */         fuente = new Font("ARIAL", 0, 9);
/* 123 */         g.setFont(fuente);
/* 124 */         g.drawString(this.DATOS[26], 430, 570);
/*     */ 
/*     */         
/* 127 */         if (!this.DATOS[30].equals("")) {
/* 128 */           g.drawString("AUT SEMARNAT " + this.DATOS[30], 397, 38);
/*     */         }
/*     */ 
/*     */         
/* 132 */         return 0;
/*     */     } 
/* 134 */     return 1; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void recibeDatos(String[] datos) {
/* 139 */     Imprimir im = new Imprimir();
/* 140 */     im.DATOS = datos;
/* 141 */     for (int i = 0; i < this.DATOS.length; i++) {
/* 142 */       System.out.println(this.DATOS[i]);
/*     */     }
/* 144 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 145 */     job.setPrintable(im);
/* 146 */     if (job.printDialog())
/*     */       try {
/* 148 */         job.print();
/* 149 */       } catch (PrinterException e) {
/* 150 */         JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*     */       }  
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Imprimir.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */