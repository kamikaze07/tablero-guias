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
/*     */ public class declaracionRecortes {
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
/*     */   public declaracionRecortes(String[] datos) {
/*  33 */     if (datos[18].equals("ACEITE")) {
/*  34 */       this.con.consultar("aceite", "configuraciones", "");
/*  35 */       this.tipoConf = "CO-PROCESAMIENTO";
/*  36 */       this.bascula = "";
/*  37 */       this.manejo = "HORNOS CEMENTEROS";
/*     */     } else {
/*     */       
/*  40 */       this.con.consultar("agua", "configuraciones", "");
/*  41 */       this.tipoConf = "DISPOSICION FINAL";
/*  42 */       this.bascula = "BASCULA REVUELTA MAZA (ALCANCE MAXIMO 80 TONS.) MODELO: ERCC 0102CE12216 TIPO:ELECTRONICO";
/*     */     } 
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
/*  60 */       Workbook libro1 = Workbook.getWorkbook(new File("Formatos/declaracion.xls"));
/*  61 */       System.out.println("entra declara");
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
/*  73 */       Label label = new Label(1, 2, datos[0]);
/*  74 */       label.setCellFormat((CellFormat)forma);
/*  75 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  77 */       label = new Label(1, 4, otrosDatos[0]);
/*  78 */       label.setCellFormat((CellFormat)forma);
/*  79 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  81 */       forma = new WritableCellFormat(fuente);
/*  82 */       forma.setAlignment(Alignment.CENTRE);
/*  83 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/*  84 */       label = new Label(6, 2, datos[1]);
/*  85 */       label.setCellFormat((CellFormat)forma);
/*  86 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  88 */       label = new Label(6, 4, otrosDatos[1]);
/*  89 */       label.setCellFormat((CellFormat)forma);
/*  90 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  92 */       forma = new WritableCellFormat(fuente);
/*  93 */       forma.setAlignment(Alignment.CENTRE);
/*  94 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(2));
/*  95 */       label = new Label(11, 4, otrosDatos[2]);
/*  96 */       label.setCellFormat((CellFormat)forma);
/*  97 */       hoja2.addCell((WritableCell)label);
/*     */       
/*  99 */       forma = new WritableCellFormat(fuente);
/* 100 */       forma.setAlignment(Alignment.CENTRE);
/* 101 */       if (datos[5].equals("GÓNDOLA") || datos[5].equals("GONDOLA")) {
/* 102 */         forma.setBorder(Border.ALL, BorderLineStyle.getStyle(2));
/* 103 */         label = new Label(7, 6, "X");
/* 104 */         label.setCellFormat((CellFormat)forma);
/* 105 */         hoja2.addCell((WritableCell)label);
/*     */       } else {
/*     */         
/* 108 */         label = new Label(10, 6, "PIPA");
/* 109 */         label.setCellFormat((CellFormat)forma);
/* 110 */         hoja2.addCell((WritableCell)label);
/*     */       } 
/*     */       
/* 113 */       forma = new WritableCellFormat(fuente);
/* 114 */       forma.setAlignment(Alignment.CENTRE);
/*     */       
/* 116 */       label = new Label(14, 6, cadenaFecha.substring(0, 2) + "-" + cadenaFecha.substring(0, 2) + "-" + cadenaFecha.substring(3, 5));
/* 117 */       label.setCellFormat((CellFormat)forma);
/* 118 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 120 */       label = new Label(2, 10, datos[9]);
/* 121 */       label.setCellFormat((CellFormat)forma);
/* 122 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 124 */       label = new Label(4, 10, datos[11]);
/* 125 */       label.setCellFormat((CellFormat)forma);
/* 126 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 128 */       label = new Label(1, 52, datos[4]);
/* 129 */       label.setCellFormat((CellFormat)forma);
/* 130 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 132 */       label = new Label(1, 54, datos[7]);
/* 133 */       label.setCellFormat((CellFormat)forma);
/* 134 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 136 */       label = new Label(1, 60, "TRACTO: " + datos[8]);
/* 137 */       label.setCellFormat((CellFormat)forma);
/* 138 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 140 */       label = new Label(11, 60, datos[10]);
/* 141 */       label.setCellFormat((CellFormat)forma);
/* 142 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 144 */       label = new Label(1, 71, this.tipoConf);
/* 145 */       label.setCellFormat((CellFormat)forma);
/* 146 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 148 */       label = new Label(1, 73, this.manejo);
/* 149 */       label.setCellFormat((CellFormat)forma);
/* 150 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 152 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 5);
/* 153 */       fuente.setColour(Colour.RED);
/* 154 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 155 */       forma = new WritableCellFormat(fuente);
/* 156 */       forma.setAlignment(Alignment.JUSTIFY);
/*     */       
/* 158 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(2));
/* 159 */       label = new Label(11, 73, this.bascula);
/* 160 */       label.setCellFormat((CellFormat)forma);
/* 161 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 163 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 8);
/* 164 */       fuente.setColour(Colour.RED);
/* 165 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 166 */       forma = new WritableCellFormat(fuente);
/* 167 */       forma.setAlignment(Alignment.CENTRE);
/* 168 */       label = new Label(1, 58, datos[1] + "," + datos[1] + "," + datos[0]);
/* 169 */       label.setCellFormat((CellFormat)forma);
/* 170 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 172 */       label = new Label(1, 62, datos[12]);
/* 173 */       label.setCellFormat((CellFormat)forma);
/* 174 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 176 */       label = new Label(1, 64, datos[14]);
/* 177 */       label.setCellFormat((CellFormat)forma);
/* 178 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 180 */       forma = new WritableCellFormat(fuente);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 7);
/* 193 */       fuente.setColour(Colour.RED);
/* 194 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 195 */       forma = new WritableCellFormat(fuente);
/* 196 */       forma.setAlignment(Alignment.JUSTIFY);
/* 197 */       forma.setBorder(Border.RIGHT, BorderLineStyle.getStyle(1));
/* 198 */       label = new Label(6, 66, datos[13]);
/* 199 */       label.setCellFormat((CellFormat)forma);
/* 200 */       hoja2.addCell((WritableCell)label);
/*     */ 
/*     */       
/* 203 */       fuente = new WritableFont(WritableFont.createFont("Arial"), 6);
/* 204 */       fuente.setColour(Colour.RED);
/* 205 */       fuente.setBoldStyle(WritableFont.BOLD);
/* 206 */       forma = new WritableCellFormat(fuente);
/* 207 */       forma.setAlignment(Alignment.CENTRE);
/*     */       
/* 209 */       label = new Label(1, 56, "USO COMPLETO DE EPP, GUIA: " + datos[19] + ", MANIFIESTO: " + datos[3] + ",  PERMISO: 30-ASEA-T-RME-04-17");
/* 210 */       label.setCellFormat((CellFormat)forma);
/* 211 */       hoja2.addCell((WritableCell)label);
/*     */       
/* 213 */       copy.write();
/* 214 */       copy.close();
/* 215 */       JOptionPane.showMessageDialog(null, "<HTML>El manifiesto se ha creado satisfactoriamente en la dirección: <HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, this.INFO);
/*     */     }
/* 217 */     catch (Exception i) {
/* 218 */       JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage() + "\n" + i.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/declaracionRecortes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */