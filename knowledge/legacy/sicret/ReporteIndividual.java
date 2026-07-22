/*     */ package sicret;
/*     */ import java.io.File;
/*     */ import jxl.format.CellFormat;
/*     */ import jxl.write.Colour;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableCell;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ 
/*     */ public class ReporteIndividual {
/*  12 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  13 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  14 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  15 */   Consultas con = new Consultas();
/*  16 */   String archivo = "";
/*  17 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos; int segundos;
/*     */   
/*     */   public ReporteIndividual(String Titulo, String[] Campitos, String Usuario) {
/*  20 */     this.archivo = direccion();
/*  21 */     this.hora = this.calendario.get(11);
/*  22 */     this.minutos = this.calendario.get(12);
/*  23 */     this.segundos = this.calendario.get(13);
/*  24 */     if (!this.archivo.equals("no")) {
/*  25 */       String cadenaFecha = "";
/*  26 */       SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/*  27 */       Date fecha = new Date();
/*  28 */       cadenaFecha = formato.format(fecha);
/*  29 */       String[] nombre = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + Usuario + "'", 3);
/*  30 */       this.con.consultar("count(num)", "reportes", "");
/*  31 */       FileOutputStream fos = null;
/*  32 */       PrintWriter pw = null;
/*  33 */       File f = new File(this.archivo + ".xls");
/*     */       try {
/*  35 */         Workbook libro1 = Workbook.getWorkbook(new File("Formatos/FormatoIndividualOp.xls"));
/*  36 */         WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/*  37 */         WritableSheet hoja2 = copy.getSheet(0);
/*     */         
/*  39 */         WritableFont fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 12);
/*  40 */         fuente.setColour(Colour.RED);
/*  41 */         fuente.setBoldStyle(WritableFont.BOLD);
/*  42 */         WritableCellFormat forma = new WritableCellFormat(fuente);
/*  43 */         fuente.setBoldStyle(WritableFont.BOLD);
/*  44 */         forma = new WritableCellFormat(fuente);
/*  45 */         forma.setAlignment(Alignment.CENTRE);
/*     */         
/*  47 */         Label label = new Label(1, 2, Titulo);
/*  48 */         label.setCellFormat((CellFormat)forma);
/*  49 */         hoja2.addCell((WritableCell)label);
/*     */         try {
/*  51 */           if ((new File(Campitos[24])).exists()) {
/*  52 */             WritableImage wi = new WritableImage(0.0D, 7.0D, 3.0D, 14.0D, new File(Campitos[24]));
/*  53 */             hoja2.addImage(wi);
/*     */           }
/*     */         
/*  56 */         } catch (Exception e) {
/*  57 */           System.out.println(e.getMessage());
/*     */         } 
/*     */         
/*  60 */         fuente = new WritableFont(WritableFont.createFont("Calibri"), 11);
/*  61 */         fuente.setColour(Colour.RED);
/*  62 */         fuente.setBoldStyle(WritableFont.BOLD);
/*  63 */         forma = new WritableCellFormat(fuente);
/*  64 */         forma.setAlignment(Alignment.LEFT);
/*     */         
/*  66 */         label = new Label(1, 4, Campitos[0]);
/*  67 */         label.setCellFormat((CellFormat)forma);
/*  68 */         hoja2.addCell((WritableCell)label);
/*     */         
/*  70 */         label = new Label(6, 4, nombre[0] + " " + nombre[0] + " " + nombre[1]);
/*  71 */         label.setCellFormat((CellFormat)forma);
/*  72 */         hoja2.addCell((WritableCell)label);
/*     */         
/*  74 */         fuente = new WritableFont(WritableFont.createFont("Calibri"), 12);
/*  75 */         fuente.setColour(Colour.BLACK);
/*  76 */         fuente.setBoldStyle(WritableFont.BOLD);
/*  77 */         forma = new WritableCellFormat(fuente);
/*  78 */         forma.setAlignment(Alignment.CENTRE);
/*  79 */         forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/*  80 */         forma.setBackground(Colour.YELLOW);
/*     */         
/*  82 */         label = new Label(7, 7, Campitos[1]);
/*  83 */         label.setCellFormat((CellFormat)forma);
/*  84 */         hoja2.addCell((WritableCell)label);
/*     */         
/*  86 */         fuente = new WritableFont(WritableFont.createFont("Calibri"), 9);
/*  87 */         fuente.setColour(Colour.BLUE);
/*  88 */         fuente.setBoldStyle(WritableFont.BOLD);
/*  89 */         forma = new WritableCellFormat(fuente);
/*  90 */         forma.setAlignment(Alignment.LEFT);
/*  91 */         forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/*     */         
/*  93 */         label = new Label(5, 8, Campitos[2]);
/*  94 */         label.setCellFormat((CellFormat)forma);
/*  95 */         hoja2.addCell((WritableCell)label);
/*     */         
/*  97 */         label = new Label(5, 9, Campitos[3]);
/*  98 */         label.setCellFormat((CellFormat)forma);
/*  99 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 101 */         label = new Label(5, 10, Campitos[4]);
/* 102 */         label.setCellFormat((CellFormat)forma);
/* 103 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 105 */         label = new Label(5, 11, Campitos[5]);
/* 106 */         label.setCellFormat((CellFormat)forma);
/* 107 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 109 */         label = new Label(5, 12, Campitos[6]);
/* 110 */         label.setCellFormat((CellFormat)forma);
/* 111 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 113 */         label = new Label(5, 13, Campitos[7]);
/* 114 */         label.setCellFormat((CellFormat)forma);
/* 115 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 117 */         label = new Label(7, 13, Campitos[8]);
/* 118 */         label.setCellFormat((CellFormat)forma);
/* 119 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 121 */         label = new Label(5, 14, Campitos[9]);
/* 122 */         label.setCellFormat((CellFormat)forma);
/* 123 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 125 */         label = new Label(5, 15, Campitos[10]);
/* 126 */         label.setCellFormat((CellFormat)forma);
/* 127 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 129 */         label = new Label(5, 16, Campitos[11]);
/* 130 */         label.setCellFormat((CellFormat)forma);
/* 131 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 133 */         label = new Label(5, 17, Campitos[12]);
/* 134 */         label.setCellFormat((CellFormat)forma);
/* 135 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 137 */         label = new Label(5, 18, Campitos[13]);
/* 138 */         label.setCellFormat((CellFormat)forma);
/* 139 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 141 */         label = new Label(7, 18, Campitos[14]);
/* 142 */         label.setCellFormat((CellFormat)forma);
/* 143 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 145 */         label = new Label(5, 19, Campitos[15]);
/* 146 */         label.setCellFormat((CellFormat)forma);
/* 147 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 149 */         label = new Label(7, 19, Campitos[16]);
/* 150 */         label.setCellFormat((CellFormat)forma);
/* 151 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 153 */         label = new Label(5, 20, Campitos[17]);
/* 154 */         label.setCellFormat((CellFormat)forma);
/* 155 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 157 */         label = new Label(7, 20, Campitos[18]);
/* 158 */         label.setCellFormat((CellFormat)forma);
/* 159 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 161 */         label = new Label(1, 22, Campitos[19]);
/* 162 */         label.setCellFormat((CellFormat)forma);
/* 163 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 165 */         label = new Label(3, 22, Campitos[20]);
/* 166 */         label.setCellFormat((CellFormat)forma);
/* 167 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 169 */         label = new Label(6, 22, Campitos[21]);
/* 170 */         label.setCellFormat((CellFormat)forma);
/* 171 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 173 */         label = new Label(8, 22, Campitos[22]);
/* 174 */         label.setCellFormat((CellFormat)forma);
/* 175 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 177 */         fuente = new WritableFont(WritableFont.createFont("Calibri"), 13);
/* 178 */         fuente.setColour(Colour.BLACK);
/* 179 */         fuente.setBoldStyle(WritableFont.BOLD);
/* 180 */         forma = new WritableCellFormat(fuente);
/* 181 */         forma.setAlignment(Alignment.JUSTIFY);
/* 182 */         forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 183 */         forma.setWrap(true);
/* 184 */         forma.setLocked(true);
/*     */         
/* 186 */         label = new Label(0, 26, Campitos[23]);
/* 187 */         label.setCellFormat((CellFormat)forma);
/* 188 */         hoja2.addCell((WritableCell)label);
/*     */         
/* 190 */         copy.write();
/* 191 */         copy.close();
/* 192 */         JOptionPane.showMessageDialog(null, "<HTML>El reporte se creó satisfactoriamente en la siguiente dirección<HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, this.INFO);
/*     */       }
/* 194 */       catch (Exception i) {
/* 195 */         JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public String direccion() {
/* 200 */     JFileChooser fileChooser = new JFileChooser();
/* 201 */     String fileName = "";
/* 202 */     int retVal = fileChooser.showSaveDialog(null);
/* 203 */     if (retVal == 0) {
/* 204 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 205 */       return fileName;
/*     */     } 
/* 207 */     return "no";
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ReporteIndividual.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */