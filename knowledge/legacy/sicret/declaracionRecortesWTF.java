/*     */ package sicret;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.swing.JOptionPane;
/*     */ import jxl.Workbook;
/*     */ import jxl.format.Border;
/*     */ import jxl.format.BorderLineStyle;
/*     */ import jxl.format.CellFormat;
/*     */ import jxl.write.Alignment;
/*     */ import jxl.write.Colour;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableCell;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ 
/*     */ public class declaracionRecortesWTF {
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  23 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  24 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  25 */   Consultas con = new Consultas();
/*  26 */   String archivo = "";
/*  27 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos;
/*     */   int segundos;
/*  29 */   String tipoConf = "";
/*  30 */   String bascula = "";
/*  31 */   String manejo = "";
/*     */   public declaracionRecortesWTF(String[] datos) {
/*  33 */     if (datos[18].equals("ACEITE")) {
/*  34 */       this.con.consultar("aceite", "configuraciones", "");
/*  35 */       this.tipoConf = "CO-PROCESAMIENTO";
/*  36 */       this.bascula = "";
/*  37 */       this.manejo = "HORNOS CEMENTEROS";
/*     */     } else {
/*     */       
/*  40 */       this.con.consultar("agua", "configuraciones", "");
/*  41 */       this.tipoConf = "CO-PROCESAMIENTO";
/*     */     } 
/*     */     
/*  44 */     String[] otrosDatos = this.con.regresaReg("ubicacion, municipio,estado", "equipos,estados", "where equipos.id_edo = estados.id_edo and equipo = '" + datos[0] + "'", 3);
/*     */     
/*  46 */     this.archivo = this.con.Campo;
/*  47 */     this.hora = this.calendario.get(11);
/*  48 */     this.minutos = this.calendario.get(12);
/*  49 */     this.segundos = this.calendario.get(13);
/*     */     
/*  51 */     String cadenaFecha = "";
/*  52 */     SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/*  53 */     Date fecha = new Date();
/*  54 */     cadenaFecha = formato.format(fecha);
/*  55 */     File f = new File(this.archivo + "/" + this.archivo + ".xls");
/*     */     try {
/*  57 */       for (int i = 0; i < datos.length; i++) {
/*  58 */         System.out.println("Valores: " + i + " " + datos[i]);
/*     */       }
/*  60 */       Workbook libro1 = Workbook.getWorkbook(new File("Formatos/declaracionWTF.xls"));
/*  61 */       System.out.println("entraaa--- Archivo");
/*  62 */       WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/*  63 */       WritableSheet hoja2 = copy.getSheet(0);
/*     */       
/*  65 */       WritableFont fuente = new WritableFont(WritableFont.createFont("Arial"), 9);
/*  66 */       fuente.setColour(Colour.RED);
/*  67 */       fuente.setBoldStyle(WritableFont.BOLD);
/*     */       
/*  69 */       WritableCellFormat forma = new WritableCellFormat(fuente);
/*  70 */       forma.setAlignment(Alignment.CENTRE);
/*  71 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/*  72 */       forma.setBorder(Border.LEFT, BorderLineStyle.getStyle(2));
/*  73 */       Label label = new Label(1, 5, datos[0]);
/*  74 */       label.setCellFormat((CellFormat)forma);
/*  75 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  77 */       label = new Label(1, 7, otrosDatos[0]);
/*  78 */       label.setCellFormat((CellFormat)forma);
/*  79 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  81 */       forma = new WritableCellFormat(fuente);
/*  82 */       forma.setAlignment(Alignment.CENTRE);
/*  83 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/*  84 */       label = new Label(6, 5, datos[1]);
/*  85 */       label.setCellFormat((CellFormat)forma);
/*  86 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  88 */       label = new Label(6, 7, otrosDatos[1]);
/*  89 */       label.setCellFormat((CellFormat)forma);
/*  90 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  92 */       forma = new WritableCellFormat(fuente);
/*  93 */       forma.setAlignment(Alignment.CENTRE);
/*  94 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(2));
/*  95 */       label = new Label(11, 7, otrosDatos[2]);
/*  96 */       label.setCellFormat((CellFormat)forma);
/*  97 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  99 */       forma = new WritableCellFormat(fuente);
/* 100 */       forma.setAlignment(Alignment.CENTRE);
/* 101 */       if (datos[5].equals("GÓNDOLA") || datos[5].equals("GONDOLA")) {
/* 102 */         forma.setBorder(Border.ALL, BorderLineStyle.getStyle(2));
/* 103 */         label = new Label(7, 9, "X");
/* 104 */         label.setCellFormat((CellFormat)forma);
/* 105 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 107 */         if (datos[4].contains("BASE ACEITE")) {
/* 108 */           label = new Label(7, 2, "X");
/* 109 */           label.setCellFormat((CellFormat)forma);
/* 110 */           hoja2.addCell((WritableCell)label);
/*     */         } else {
/*     */           
/* 113 */           label = new Label(15, 2, "X");
/* 114 */           label.setCellFormat((CellFormat)forma);
/* 115 */           hoja2.addCell((WritableCell)label);
/*     */         } 
/*     */       } else {
/*     */         
/* 119 */         label = new Label(10, 9, "PIPA");
/* 120 */         label.setCellFormat((CellFormat)forma);
/* 121 */         hoja2.addCell((WritableCell)label);
/*     */       } 
/*     */       
/* 124 */       forma = new WritableCellFormat(fuente);
/* 125 */       forma.setAlignment(Alignment.CENTRE);
/*     */       
/* 127 */       label = new Label(14, 9, cadenaFecha.substring(0, 2) + "/" + cadenaFecha.substring(0, 2) + "/" + cadenaFecha.substring(3, 5));
/* 128 */       label.setCellFormat((CellFormat)forma);
/* 129 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 131 */       label = new Label(2, 13, datos[9]);
/* 132 */       label.setCellFormat((CellFormat)forma);
/* 133 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       label = new Label(1, 57, datos[7]);
/* 144 */       label.setCellFormat((CellFormat)forma);
/* 145 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 147 */       label = new Label(1, 63, "TRACTOCAMION / " + datos[5]);
/* 148 */       label.setCellFormat((CellFormat)forma);
/* 149 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 151 */       label = new Label(11, 63, datos[10] + " / " + datos[10]);
/* 152 */       label.setCellFormat((CellFormat)forma);
/* 153 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 5);
/* 164 */       fuente.setColour(Colour.RED);
/* 165 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 166 */       forma = new WritableCellFormat(fuente);
/* 167 */       forma.setAlignment(Alignment.JUSTIFY);
/*     */       
/* 169 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(2));
/* 170 */       label = new Label(11, 76, datos[21]);
/* 171 */       label.setCellFormat((CellFormat)forma);
/* 172 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 174 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 8);
/* 175 */       fuente.setColour(Colour.RED);
/* 176 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 177 */       forma = new WritableCellFormat(fuente);
/* 178 */       forma.setAlignment(Alignment.CENTRE);
/* 179 */       label = new Label(1, 61, datos[1] + "," + datos[1] + "," + datos[0]);
/* 180 */       label.setCellFormat((CellFormat)forma);
/* 181 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 183 */       label = new Label(1, 65, datos[12]);
/* 184 */       label.setCellFormat((CellFormat)forma);
/* 185 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 187 */       label = new Label(1, 67, datos[14]);
/* 188 */       label.setCellFormat((CellFormat)forma);
/* 189 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 191 */       label = new Label(1, 69, datos[20]);
/* 192 */       label.setCellFormat((CellFormat)forma);
/* 193 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 195 */       forma = new WritableCellFormat(fuente);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 7);
/* 208 */       fuente.setColour(Colour.RED);
/* 209 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 210 */       forma = new WritableCellFormat(fuente);
/* 211 */       forma.setAlignment(Alignment.JUSTIFY);
/* 212 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/* 213 */       label = new Label(6, 69, datos[13]);
/* 214 */       label.setCellFormat((CellFormat)forma);
/* 215 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */       
/* 218 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 6);
/* 219 */       fuente.setColour(Colour.RED);
/* 220 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 221 */       forma = new WritableCellFormat(fuente);
/* 222 */       forma.setAlignment(Alignment.CENTRE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       copy.write();
/* 229 */       copy.close();
/* 230 */       JOptionPane.showMessageDialog(null, "<HTML>El manifiesto se ha creado satisfactoriamente en la dirección: <HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, this.INFO);
/*     */     }
/* 232 */     catch (Exception i) {
/* 233 */       JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage() + "\n" + i.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/declaracionRecortesWTF.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */