/*     */ package sicret;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Paper;
/*     */ import java.awt.print.Printable;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImprimirFacturas
/*     */   implements Printable
/*     */ {
/*     */   int[] pageBreaks;
/*     */   String[] textLines;
/* 584 */   Graphics g2 = null;
/* 585 */   int Pag = 0;
/*     */   String[][] Lineas;
/* 587 */   int linesPerPage = 50;
/* 588 */   int orientacion = 0;
/* 589 */   double X = 0.0D;
/* 590 */   double Y = 0.0D;
/* 591 */   int YINICIA = 75;
/* 592 */   int[] PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 593 */   int NumLineas = 0;
/* 594 */   int numBreaks = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private void initTextLines() {
/* 599 */     if (this.textLines == null) {
/*     */ 
/*     */       
/* 602 */       int numLines = FacturacionPendiente.this.jTable2.getRowCount();
/*     */       
/* 604 */       this.textLines = new String[numLines];
/*     */     } 
/*     */   }
/*     */   
/*     */   public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 609 */     Font font = new Font("Serif", 0, 8);
/* 610 */     FontMetrics metrics = g.getFontMetrics(font);
/* 611 */     int lineHeight = metrics.getHeight();
/* 612 */     if (this.pageBreaks == null) {
/* 613 */       initTextLines();
/* 614 */       this.orientacion = pf.getOrientation();
/* 615 */       if (pf.getOrientation() == 1) {
/* 616 */         this.linesPerPage = 46;
/* 617 */         this.X = pf.getWidth();
/* 618 */         this.Y = pf.getHeight();
/*     */       } else {
/* 620 */         this.linesPerPage = 38;
/* 621 */         this.X = pf.getWidth();
/* 622 */         this.Y = pf.getHeight();
/*     */       } 
/* 624 */       this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 625 */       this.Pag = this.numBreaks;
/* 626 */       this.pageBreaks = new int[this.numBreaks];
/* 627 */       for (int b = 0; b < this.numBreaks; b++) {
/* 628 */         this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*     */       }
/*     */     } 
/* 631 */     if (pageIndex > this.pageBreaks.length) {
/* 632 */       return 1;
/*     */     }
/* 634 */     Graphics2D g2d = (Graphics2D)g;
/* 635 */     this.g2 = g;
/* 636 */     g2d.translate(pf.getImageableX(), 10.0D);
/* 637 */     int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 638 */     int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 639 */     encabezado();
/* 640 */     int y = this.YINICIA;
/* 641 */     int lineas = 0;
/*     */     
/* 643 */     this.g2.drawRect(25, 150, 550, 12);
/* 644 */     this.g2.setColor(new Color(204, 0, 0));
/* 645 */     this.g2.fillRect(25, 151, 550, 10);
/*     */     
/* 647 */     Font fuente = new Font("Dialog", 0, 7);
/* 648 */     this.g2.setFont(fuente);
/* 649 */     this.g2.setColor(Color.WHITE);
/* 650 */     int[] valores = { 29, 90, 150, 213, 300, 355, 450, 520 };
/* 651 */     this.g2.drawString("CLIENTE", valores[0], 159);
/* 652 */     this.g2.drawString("FACTURA", valores[1], 159);
/* 653 */     this.g2.drawString("FECHA DE FACT", valores[2] - 10, 159);
/* 654 */     this.g2.drawString("DÍAS DE CRÉDITO", valores[3], 159);
/* 655 */     this.g2.drawString("FECHA LÍMITE", valores[4] - 10, 159);
/* 656 */     this.g2.drawString("DIAS DE RETRAZO", valores[5], 159);
/* 657 */     this.g2.drawString("ESTATUS", valores[6] + 10, 159);
/* 658 */     this.g2.drawString("TOTAL", valores[7] + 10, 159);
/*     */     
/* 660 */     this.g2.setColor(Color.BLACK);
/* 661 */     y = 160;
/* 662 */     for (int line = start; line < end; line++) {
/* 663 */       y += 12;
/*     */       
/* 665 */       String valor = "";
/* 666 */       if (line < 9) {
/* 667 */         valor = "0" + line + 1;
/*     */       } else {
/* 669 */         valor = "" + line + 1;
/*     */       } 
/* 671 */       fuente = new Font("Dialog", 1, 7);
/* 672 */       this.g2.setFont(fuente);
/* 673 */       this.g2.drawString(valor, FacturacionPendiente.this.alinearDer(20, valor.length()), y - 2);
/*     */       
/* 675 */       fuente = new Font("Dialog", 0, 6);
/* 676 */       this.g2.setFont(fuente);
/*     */       
/* 678 */       String cliente = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 0));
/* 679 */       int ind = cliente.indexOf(" ");
/* 680 */       cliente = cliente.substring(0, ind);
/*     */       
/* 682 */       this.g2.drawString(cliente, valores[0], y - 2);
/* 683 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 1)), valores[1], y - 2);
/*     */       
/* 685 */       String fecha = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 2));
/* 686 */       String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 687 */       this.g2.drawString(col, valores[2], y - 2);
/*     */ 
/*     */       
/* 690 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 3)), FacturacionPendiente.this.alinearDer(valores[3] + 30, FacturacionPendiente.this.jTable2.getValueAt(line, 3).toString().length()), y - 2);
/*     */       
/* 692 */       fecha = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 4));
/* 693 */       col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 694 */       this.g2.drawString(col, valores[4], y - 2);
/*     */       
/* 696 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 5)), FacturacionPendiente.this.alinearDer(valores[5] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 5).toString().length()), y - 2);
/* 697 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 6)), FacturacionPendiente.this.alinearDer(valores[6] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 6).toString().length()), y - 2);
/* 698 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 7)), FacturacionPendiente.this.alinearDer(valores[7] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 7).toString().length()), y - 2);
/*     */     } 
/*     */     
/* 701 */     g.drawString("Página " + pageIndex + 1, 540, 749);
/* 702 */     if (this.Pag == pageIndex) {
/* 703 */       this.g2.drawLine(20, y, 90, y);
/* 704 */       this.g2.drawLine(510, y, 565, y);
/*     */       
/* 706 */       fuente = new Font("Dialog", 1, 6);
/* 707 */       this.g2.setFont(fuente);
/* 708 */       g.drawString("SUMAS", 41, y + 10);
/* 709 */       this.g2.drawString(FacturacionPendiente.this.jLabel42.getText(), FacturacionPendiente.this.alinearDer(valores[7] + 40, FacturacionPendiente.this.jLabel42.getText().length()), y + 10);
/*     */       
/* 711 */       fuente = new Font("Dialog", 1, 7);
/* 712 */       this.g2.setFont(fuente);
/* 713 */       this.g2.drawString("ELABORÓ", 190, 720);
/* 714 */       this.g2.drawString("_____________________________________", 140, 752);
/* 715 */       this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*     */       
/* 717 */       this.g2.drawString("RECIBE", 390, 720);
/* 718 */       this.g2.drawString("_____________________________________", 340, 752);
/* 719 */       this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*     */     } 
/* 721 */     return 0;
/*     */   }
/*     */   
/*     */   public void encabezado() {
/* 725 */     Font fuente = new Font("Dialog", 0, 8);
/* 726 */     this.g2.setFont(fuente);
/* 727 */     this.g2.setColor(Color.BLACK);
/* 728 */     ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 729 */     Image img = imagen.getImage();
/* 730 */     this.g2.drawImage(img, 518, 1, 57, 57, null);
/*     */     
/* 732 */     imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 733 */     img = imagen.getImage();
/* 734 */     this.g2.drawImage(img, 27, 8, 60, 50, null);
/*     */     
/* 736 */     fuente = new Font("Times New Roman", 1, 16);
/* 737 */     this.g2.setFont(fuente);
/* 738 */     this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*     */ 
/*     */     
/* 741 */     fuente = new Font("Dialog", 0, 12);
/* 742 */     this.g2.setFont(fuente);
/* 743 */     this.g2.drawString("FACTURAS VENCIDAS", 230, 37);
/* 744 */     this.g2.drawLine(25, 60, 575, 60);
/*     */     
/* 746 */     this.g2.setColor(Color.BLACK);
/* 747 */     this.g2.drawLine(25, 83, 220, 83);
/* 748 */     this.g2.drawLine(25, 130, 220, 130);
/*     */     
/* 750 */     fuente = new Font("Dialog", 1, 8);
/* 751 */     this.g2.setFont(fuente);
/* 752 */     this.g2.setColor(Color.BLACK);
/* 753 */     this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*     */     
/* 755 */     fuente = new Font("Dialog", 1, 7);
/* 756 */     this.g2.setFont(fuente);
/* 757 */     this.g2.setColor(Color.BLACK);
/*     */     
/* 759 */     this.g2.drawString("Cliente: ", 27, 93);
/* 760 */     this.g2.drawString("Total de Facturas: ", 27, 104);
/* 761 */     this.g2.drawString("Monto Vencido: ", 27, 115);
/* 762 */     this.g2.drawString("Fecha de Impresión: ", 27, 126);
/*     */ 
/*     */     
/* 765 */     fuente = new Font("Dialog", 0, 7);
/* 766 */     this.g2.setFont(fuente);
/* 767 */     this.g2.setColor(Color.BLACK);
/*     */     
/* 769 */     this.g2.drawString(String.valueOf(FacturacionPendiente.this.jComboBox9.getSelectedItem()), 100, 93);
/* 770 */     this.g2.drawString("" + FacturacionPendiente.this.jTable2.getRowCount(), 100, 104);
/* 771 */     this.g2.drawString(FacturacionPendiente.this.jLabel42.getText(), 100, 115);
/*     */     
/* 773 */     Date fecha1 = new Date();
/* 774 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 775 */     String cadenaFecha = "";
/* 776 */     cadenaFecha = formato.format(fecha1);
/* 777 */     String AÑO = cadenaFecha.substring(0, 4);
/* 778 */     String MES = cadenaFecha.substring(4, 6);
/* 779 */     String DIA = cadenaFecha.substring(6, 8);
/* 780 */     this.g2.drawString(DIA + "/" + DIA + "/" + MES, 100, 126);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 809 */     fuente = new Font("Dialog", 0, 7);
/* 810 */     this.g2.setFont(fuente);
/* 811 */     this.g2.drawString("A continuación se enlistan todas las facturas en este periodo:", 25, 148);
/*     */   }
/*     */   
/*     */   public void recibeDatos() {
/* 815 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 816 */     job.setPrintable(this);
/*     */     
/* 818 */     PageFormat pf = job.defaultPage();
/* 819 */     Paper papel = pf.getPaper();
/* 820 */     papel.setSize(612.0D, 792.0D);
/* 821 */     papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 822 */     pf.setPaper(papel);
/* 823 */     pf.setOrientation(1);
/* 824 */     job.setPrintable(new ImprimirFacturas(), pf);
/* 825 */     job.defaultPage(pf);
/*     */     
/* 827 */     boolean ok = job.printDialog();
/* 828 */     if (ok)
/*     */       try {
/* 830 */         job.print();
/* 831 */       } catch (PrinterException printerException) {} 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/FacturacionPendiente$ImprimirFacturas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */