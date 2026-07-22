/*     */ package sicret;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.JOptionPane;
/*     */ import jxl.Workbook;
/*     */ import jxl.format.Border;
/*     */ import jxl.format.BorderLineStyle;
/*     */ import jxl.format.CellFormat;
/*     */ import jxl.format.VerticalAlignment;
/*     */ import jxl.write.Alignment;
/*     */ import jxl.write.Colour;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableCell;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ 
/*     */ public class ManifiestosAceite {
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  23 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  24 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  25 */   Consultas con = new Consultas();
/*  26 */   String archivo = "";
/*  27 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos; int segundos;
/*     */   
/*     */   public ManifiestosAceite(String[] datos) {
/*  30 */     this.con.consultar("aceite", "configuraciones", "");
/*  31 */     this.archivo = this.con.Campo;
/*  32 */     this.hora = this.calendario.get(11);
/*  33 */     this.minutos = this.calendario.get(12);
/*  34 */     this.segundos = this.calendario.get(13);
/*     */     
/*  36 */     String cadenaFecha = "";
/*  37 */     SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/*  38 */     Date fecha = new Date();
/*  39 */     cadenaFecha = formato.format(fecha);
/*  40 */     File f = new File(this.archivo + "/" + this.archivo + ".xls");
/*     */     try {
/*  42 */       for (int i = 0; i < datos.length; i++) {
/*  43 */         System.out.println("Valores: " + i + " " + datos[i]);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  48 */       Workbook libro1 = Workbook.getWorkbook(new File("Formatos/Aceite.xls"));
/*  49 */       WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/*  50 */       WritableSheet hoja2 = copy.getSheet(0);
/*     */       
/*  52 */       WritableFont fuente = new WritableFont(WritableFont.createFont("Arial"), 10);
/*  53 */       fuente.setColour(Colour.RED);
/*  54 */       fuente.setBoldStyle(WritableFont.BOLD);
/*  55 */       WritableCellFormat forma = new WritableCellFormat(fuente);
/*     */       
/*  57 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/*  58 */       Label label = new Label(0, 6, "EQUIPO: " + datos[0]);
/*  59 */       label.setCellFormat((CellFormat)forma);
/*  60 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  62 */       forma = new WritableCellFormat(fuente);
/*  63 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/*  64 */       label = new Label(7, 6, "POZO: " + datos[1]);
/*  65 */       label.setCellFormat((CellFormat)forma);
/*  66 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  68 */       forma = new WritableCellFormat(fuente);
/*  69 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/*  70 */       label = new Label(17, 6, "PLATAFORMA: " + datos[2]);
/*  71 */       label.setCellFormat((CellFormat)forma);
/*  72 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  74 */       forma = new WritableCellFormat(fuente);
/*  75 */       forma.setAlignment(Alignment.CENTRE);
/*  76 */       label = new Label(20, 8, datos[3]);
/*  77 */       label.setCellFormat((CellFormat)forma);
/*  78 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */       
/*  81 */       forma = new WritableCellFormat(fuente);
/*  82 */       forma.setVerticalAlignment(VerticalAlignment.CENTRE);
/*  83 */       forma.setAlignment(Alignment.CENTRE);
/*  84 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/*  85 */       forma.setWrap(true);
/*  86 */       label = new Label(1, 17, datos[4]);
/*  87 */       label.setCellFormat((CellFormat)forma);
/*  88 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  90 */       label = new Label(18, 17, datos[5]);
/*  91 */       label.setCellFormat((CellFormat)forma);
/*  92 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  94 */       forma = new WritableCellFormat(fuente);
/*  95 */       forma.setAlignment(Alignment.LEFT);
/*  96 */       label = new Label(4, 36, datos[7]);
/*  97 */       label.setCellFormat((CellFormat)forma);
/*  98 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 100 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 102 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/* 103 */       label = new Label(1, 40, datos[15]);
/* 104 */       label.setCellFormat((CellFormat)forma);
/* 105 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 107 */       forma = new WritableCellFormat(fuente);
/* 108 */       forma.setAlignment(Alignment.CENTRE);
/* 109 */       forma.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 110 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/* 111 */       label = new Label(9, 41, datos[8]);
/* 112 */       label.setCellFormat((CellFormat)forma);
/* 113 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 115 */       forma = new WritableCellFormat(fuente);
/* 116 */       forma.setAlignment(Alignment.CENTRE);
/* 117 */       forma.setVerticalAlignment(VerticalAlignment.CENTRE);
/* 118 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/*     */       
/* 120 */       label = new Label(14, 41, datos[9]);
/* 121 */       label.setCellFormat((CellFormat)forma);
/* 122 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 124 */       forma = new WritableCellFormat(fuente);
/* 125 */       forma.setAlignment(Alignment.CENTRE);
/* 126 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/* 127 */       label = new Label(23, 41, datos[10]);
/* 128 */       label.setCellFormat((CellFormat)forma);
/* 129 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 131 */       forma = new WritableCellFormat(fuente);
/* 132 */       forma.setAlignment(Alignment.CENTRE);
/* 133 */       forma.setBorder(Border.ALL, BorderLineStyle.getStyle(6));
/* 134 */       label = new Label(23, 42, datos[11]);
/* 135 */       label.setCellFormat((CellFormat)forma);
/* 136 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 138 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 140 */       forma.setBorder(Border.BOTTOM, BorderLineStyle.getStyle(1));
/* 141 */       label = new Label(11, 44, datos[13]);
/* 142 */       label.setCellFormat((CellFormat)forma);
/* 143 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 145 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 147 */       forma.setBorder(Border.BOTTOM, BorderLineStyle.getStyle(1));
/* 148 */       label = new Label(4, 45, datos[14]);
/* 149 */       label.setCellFormat((CellFormat)forma);
/* 150 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 152 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 10);
/* 153 */       fuente.setColour(Colour.RED);
/* 154 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 155 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 157 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 8);
/* 158 */       fuente.setColour(Colour.RED);
/* 159 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 160 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 162 */       forma.setBorder(Border.BOTTOM, BorderLineStyle.getStyle(1));
/* 163 */       label = new Label(17, 12, "Fecha de impresión: " + fecha.toLocaleString());
/* 164 */       label.setCellFormat((CellFormat)forma);
/* 165 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */ 
/*     */       
/* 169 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 8);
/* 170 */       fuente.setColour(Colour.RED);
/* 171 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 172 */       forma = new WritableCellFormat(fuente);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       forma.setBorder(Border.TOP, BorderLineStyle.getStyle(6));
/* 178 */       forma.setBorder(Border.BOTTOM, BorderLineStyle.getStyle(1));
/* 179 */       label = new Label(11, 43, datos[12]);
/* 180 */       label.setCellFormat((CellFormat)forma);
/* 181 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */       
/* 184 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 8);
/* 185 */       fuente.setColour(Colour.RED);
/* 186 */       fuente.setBoldStyle(WritableFont.NO_BOLD);
/* 187 */       forma = new WritableCellFormat(fuente);
/*     */       
/* 189 */       forma.setBorder(Border.BOTTOM, BorderLineStyle.getStyle(1));
/* 190 */       label = new Label(1, 44, datos[17] + ":");
/* 191 */       label.setCellFormat((CellFormat)forma);
/* 192 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       copy.write();
/* 233 */       copy.close();
/* 234 */       JOptionPane.showMessageDialog(null, "<HTML>El manifiesto se ha creado satisfactoriamente en la dirección: <HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, this.INFO);
/*     */     }
/* 236 */     catch (Exception i) {
/* 237 */       JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage() + "\n" + i.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ManifiestosAceite.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */