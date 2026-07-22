/*     */ package sicret;
/*     */ import java.util.Date;
/*     */ import javax.swing.JTable;
/*     */ import jxl.format.CellFormat;
/*     */ import jxl.write.Colour;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.Number;
/*     */ import jxl.write.WritableCell;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ 
/*     */ public class reportesGuias {
/*  14 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  15 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  16 */   Consultas con = new Consultas();
/*  17 */   String archivo = "";
/*  18 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos;
/*     */   int segundos;
/*  20 */   Date fecha1 = null;
/*  21 */   Date fecha2 = null;
/*     */   public reportesGuias(String Titulo, JTable tabla, String[] Campitos, String Usuario, Date fecha1, Date fecha2) {
/*  23 */     this.fecha1 = fecha1;
/*  24 */     this.fecha2 = fecha2;
/*  25 */     this.archivo = direccion();
/*  26 */     this.hora = this.calendario.get(11);
/*  27 */     this.minutos = this.calendario.get(12);
/*  28 */     this.segundos = this.calendario.get(13);
/*  29 */     if (!this.archivo.equals("no")) {
/*  30 */       String cadenaFecha = "";
/*  31 */       SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/*  32 */       Date fecha = new Date();
/*  33 */       cadenaFecha = formato.format(fecha);
/*  34 */       String[] nombre = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + Usuario + "'", 3);
/*  35 */       this.con.consultar("count(num)", "reportes", "");
/*  36 */       FileOutputStream fos = null;
/*  37 */       PrintWriter pw = null;
/*  38 */       File f = new File(this.archivo + ".xls");
/*     */       try {
/*  40 */         WritableWorkbook workbook = Workbook.createWorkbook(f);
/*  41 */         WritableSheet sheet = workbook.createSheet(Titulo, 0);
/*  42 */         sheet.setPageSetup(PageOrientation.LANDSCAPE);
/*     */         
/*  44 */         WritableImage imagen = new WritableImage(0.0D, 0.0D, 1.5D, 4.0D, new File("Forsis 170x.png"));
/*  45 */         sheet.addImage(imagen);
/*  46 */         Label label = new Label(2, 0, "SICRE - SISTEMA INTEGRAL PARA EL CONTROL DE RESIDUOS Y EMPLEADOS");
/*  47 */         WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 16);
/*  48 */         arial10font.setColour(Colour.BLUE2);
/*  49 */         WritableCellFormat arial10format = new WritableCellFormat(arial10font);
/*  50 */         label.setCellFormat((CellFormat)arial10format);
/*  51 */         sheet.addCell((WritableCell)label);
/*     */         
/*  53 */         arial10font = new WritableFont(WritableFont.ARIAL, 11);
/*  54 */         arial10font.setColour(Colour.BLUE);
/*  55 */         arial10font.setBoldStyle(WritableFont.BOLD);
/*  56 */         arial10format = new WritableCellFormat(arial10font);
/*  57 */         label = new Label(5, 2, "REPORTE DE " + Titulo);
/*  58 */         label.setCellFormat((CellFormat)arial10format);
/*  59 */         sheet.addCell((WritableCell)label);
/*     */         
/*  61 */         arial10font = new WritableFont(WritableFont.ARIAL, 9);
/*  62 */         arial10font.setColour(Colour.BLACK);
/*  63 */         arial10font.setBoldStyle(WritableFont.BOLD);
/*  64 */         arial10format = new WritableCellFormat(arial10font);
/*  65 */         int numR = Integer.parseInt(this.con.Campo);
/*  66 */         numR++;
/*  67 */         this.con.inserSinMsj("insert into reportes(num)values(" + numR + ")");
/*     */         
/*  69 */         label = new Label(0, 4, "USUARIO: " + nombre[0] + " " + nombre[1] + " " + nombre[2]);
/*  70 */         label.setCellFormat((CellFormat)arial10format);
/*  71 */         sheet.addCell((WritableCell)label);
/*     */         
/*  73 */         arial10font = new WritableFont(WritableFont.ARIAL, 12);
/*  74 */         arial10font.setColour(Colour.BLACK);
/*  75 */         arial10font.setBoldStyle(WritableFont.BOLD);
/*  76 */         arial10format = new WritableCellFormat(arial10font);
/*     */         
/*  78 */         label = new Label(4, 4, "FECHA Y HORA: " + cadenaFecha + " - " + this.hora + ":" + this.minutos + ":" + this.segundos);
/*  79 */         label.setCellFormat((CellFormat)arial10format);
/*  80 */         sheet.addCell((WritableCell)label);
/*     */         
/*  82 */         arial10font = new WritableFont(WritableFont.ARIAL, 9);
/*  83 */         arial10font.setColour(Colour.BLACK);
/*  84 */         arial10font.setBoldStyle(WritableFont.BOLD);
/*  85 */         arial10format = new WritableCellFormat(arial10font);
/*     */         
/*  87 */         label = new Label(10, 4, "REPORTE NÚMERO: " + numR);
/*  88 */         label.setCellFormat((CellFormat)arial10format);
/*  89 */         sheet.addCell((WritableCell)label);
/*  90 */         label = new Label(12, 4, "TOTAL DE REGISTROS: " + tabla.getRowCount());
/*  91 */         label.setCellFormat((CellFormat)arial10format);
/*  92 */         sheet.addCell((WritableCell)label);
/*     */         
/*  94 */         arial10font = new WritableFont(WritableFont.ARIAL, 10);
/*  95 */         arial10font.setColour(Colour.WHITE);
/*  96 */         arial10font.setBoldStyle(WritableFont.BOLD);
/*  97 */         arial10format = new WritableCellFormat(arial10font);
/*  98 */         arial10format.setBackground(Colour.GREEN);
/*  99 */         arial10format.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
/*     */         
/* 101 */         label = new Label(0, 6, "NÚM");
/* 102 */         label.setCellFormat((CellFormat)arial10format);
/* 103 */         sheet.setColumnView(0, 7);
/* 104 */         sheet.addCell((WritableCell)label);
/* 105 */         for (int r = 0; r < Campitos.length; r++) {
/* 106 */           label = new Label(r + 1, 6, Campitos[r]);
/* 107 */           label.setCellFormat((CellFormat)arial10format);
/* 108 */           sheet.setColumnView(r + 1, Campitos[r].length() + 4);
/* 109 */           sheet.addCell((WritableCell)label);
/*     */         } 
/* 111 */         int cont = 7;
/* 112 */         arial10font = new WritableFont(WritableFont.ARIAL, 8);
/* 113 */         arial10font.setColour(Colour.BLACK);
/* 114 */         int num = 1;
/* 115 */         for (int i = 0; i < tabla.getRowCount(); i++) {
/* 116 */           arial10format = new WritableCellFormat(arial10font);
/* 117 */           arial10format.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
/* 118 */           num++;
/* 119 */           if (cont % 2 == 1) {
/* 120 */             arial10format.setBackground(Colour.GREY_25_PERCENT);
/*     */           } else {
/*     */             
/* 123 */             arial10format.setBackground(Colour.LIGHT_GREEN);
/*     */           } 
/* 125 */           for (int c = -1; c < tabla.getColumnCount(); c++) {
/* 126 */             if (c == -1) {
/* 127 */               Number number = new Number(c + 1, cont, (cont - 6));
/* 128 */               number.setCellFormat((CellFormat)arial10format);
/* 129 */               sheet.setColumnView(0, 6);
/* 130 */               sheet.addCell((WritableCell)number);
/*     */             } else {
/*     */               
/*     */               try {
/* 134 */                 DecimalFormat formatoN = new DecimalFormat("000.00");
/* 135 */                 formatoN.setMaximumFractionDigits(2);
/* 136 */                 float valor = Float.parseFloat(String.valueOf(tabla.getValueAt(i, c)));
/* 137 */                 formatoN.format(valor);
/* 138 */                 Number number = new Number(c + 1, cont, Integer.parseInt(formatoN.format(valor)));
/* 139 */                 number.setCellFormat((CellFormat)arial10format);
/* 140 */                 sheet.addCell((WritableCell)number);
/*     */               }
/* 142 */               catch (NumberFormatException e) {
/* 143 */                 if (tabla.getValueAt(i, c).toString().equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/* 144 */                   label = new Label(c + 1, cont, "WTF");
/*     */                 }
/* 146 */                 else if (tabla.getValueAt(i, c).toString().equals("DOWELL SCHLUMBERGER DE MEXICO S.A DE C.V.")) {
/* 147 */                   label = new Label(c + 1, cont, "SLB");
/*     */                 }
/* 149 */                 else if (tabla.getValueAt(i, c).toString().equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/* 150 */                   label = new Label(c + 1, cont, "PMX");
/*     */                 }
/* 152 */                 else if (tabla.getValueAt(i, c).toString().equals("ADT PETROSERVICIOS S.A. DE C.V.")) {
/* 153 */                   label = new Label(c + 1, cont, "ADT");
/*     */                 }
/* 155 */                 else if (tabla.getValueAt(i, c).toString().equals("CLEANMEX S.A. DE C.V.")) {
/* 156 */                   label = new Label(c + 1, cont, "CLEANMEX");
/*     */                 }
/* 158 */                 else if (tabla.getValueAt(i, c).toString().equals("QMAX SOLUCIONES AMBIENTALES S.A. DE C.V.")) {
/* 159 */                   label = new Label(c + 1, cont, "Q-MAX");
/*     */                 }
/* 161 */                 else if (tabla.getValueAt(i, c).toString().equals("RECORTE BASE AGUA")) {
/* 162 */                   label = new Label(c + 1, cont, "R. BASE AGUA");
/*     */                 }
/* 164 */                 else if (tabla.getValueAt(i, c).toString().equals("RECORTE BASE ACEITE")) {
/* 165 */                   label = new Label(c + 1, cont, "R. BASE ACEITE");
/*     */                 }
/* 167 */                 else if (tabla.getValueAt(i, c).toString().equals("LODO BASE AGUA")) {
/* 168 */                   label = new Label(c + 1, cont, "L. BASE AGUA");
/*     */                 }
/* 170 */                 else if (tabla.getValueAt(i, c).toString().equals("AGUA RESIDUAL")) {
/* 171 */                   label = new Label(c + 1, cont, "A. RESIDUAL");
/*     */                 }
/* 173 */                 else if (tabla.getValueAt(i, c).toString().equals("AGUA RESIDUAL")) {
/* 174 */                   label = new Label(c + 1, cont, "A. RESIDUAL");
/*     */                 }
/* 176 */                 else if (tabla.getValueAt(i, c).toString().equals("AGUA DE FRACTURA")) {
/* 177 */                   label = new Label(c + 1, cont, "A. DE FRAC.");
/*     */                 }
/* 179 */                 else if (tabla.getValueAt(i, c).toString().equals("ECOLTEC S.A. DE C.V. (PLANTA ORIZABA)")) {
/* 180 */                   label = new Label(c + 1, cont, "ECOLTEC-ORIZABA");
/*     */                 }
/* 182 */                 else if (tabla.getValueAt(i, c).toString().equals("ECOLTEC S.A. DE C.V. (PLANTA MACUSPANA)")) {
/* 183 */                   label = new Label(c + 1, cont, "ECOLTEC-MACUSPANA");
/*     */                 }
/* 185 */                 else if (tabla.getValueAt(i, c).toString().equals("ECOLTEC (PLANTA RAMOS ARIZPE)")) {
/* 186 */                   label = new Label(c + 1, cont, "ECOLTEC-RAMOS ARIZPE");
/*     */                 }
/* 188 */                 else if (tabla.getValueAt(i, c).toString().equals("CEMEX MÉXICO S.A DE C.V (PLANTA TEPEACA)")) {
/* 189 */                   label = new Label(c + 1, cont, "CEMEX-TEPEACA");
/*     */                 }
/* 191 */                 else if (tabla.getValueAt(i, c).toString().equals("CEMEX MÉXICO (PLANTA TAMUÍN)")) {
/* 192 */                   label = new Label(c + 1, cont, "CEMEX-TAMUÍN");
/*     */                 }
/* 194 */                 else if (tabla.getValueAt(i, c).toString().equals("WEATHERFORD")) {
/* 195 */                   label = new Label(c + 1, cont, "WTF");
/*     */                 } else {
/*     */                   
/* 198 */                   label = new Label(c + 1, cont, String.valueOf(tabla.getValueAt(i, c)));
/*     */                 } 
/*     */                 
/* 201 */                 label.setCellFormat((CellFormat)arial10format);
/* 202 */                 sheet.addCell((WritableCell)label);
/*     */               } 
/*     */             } 
/*     */           } 
/* 206 */           cont++;
/*     */         } 
/* 208 */         workbook.write();
/* 209 */         workbook.close();
/* 210 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + Usuario + "','Creó un reporte','Número: " + numR + "\nTipo: Reporte de " + Titulo + "')");
/* 211 */         int res = JOptionPane.showConfirmDialog(null, "El archivo se ha creado satisfactoriamente en la dirección " + String.valueOf(f) + "\n¿Deseas verificar el contenido?", "Reporte Creado", 0, 3, this.PREG);
/* 212 */         if (res == 0) {
/*     */           try {
/* 214 */             Process process = Runtime.getRuntime().exec("cmd /c " + String.valueOf(f));
/*     */           }
/* 216 */           catch (Exception e) {
/* 217 */             JOptionPane.showMessageDialog(null, "El proceso de apagado no se pudo cumplir por varias razones", "Apagado Inconcluso", 2);
/*     */           }
/*     */         
/*     */         }
/* 221 */       } catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */   
/*     */   public String direccion() {
/* 226 */     JFileChooser fileChooser = new JFileChooser();
/* 227 */     String fileName = "";
/* 228 */     int retVal = fileChooser.showSaveDialog(null);
/* 229 */     if (retVal == 0) {
/* 230 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 231 */       return fileName;
/*     */     } 
/* 233 */     return "no";
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/reportesGuias.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */