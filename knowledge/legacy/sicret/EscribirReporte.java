/*     */ package sicret;
/*     */ 
/*     */ import java.awt.Desktop;
/*     */ import java.awt.Toolkit;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTable;
/*     */ import jxl.Workbook;
/*     */ import jxl.format.Border;
/*     */ import jxl.format.BorderLineStyle;
/*     */ import jxl.format.CellFormat;
/*     */ import jxl.format.Colour;
/*     */ import jxl.write.Alignment;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.Number;
/*     */ import jxl.write.WritableCell;
/*     */ import jxl.write.WritableCellFormat;
/*     */ import jxl.write.WritableFont;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ 
/*     */ 
/*     */ public class EscribirReporte
/*     */ {
/*  35 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  36 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  37 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  38 */   Consultas con = new Consultas();
/*  39 */   String archivo = "";
/*  40 */   Calendar calendario = Calendar.getInstance();
/*     */   int hora;
/*     */   
/*     */   public EscribirReporte(String Titulo, JTable tabla, String[] Campitos, String Usuario) {
/*  44 */     this.archivo = direccion();
/*  45 */     this.hora = this.calendario.get(11);
/*  46 */     this.minutos = this.calendario.get(12);
/*  47 */     this.segundos = this.calendario.get(13);
/*  48 */     if (!this.archivo.equals("no")) {
/*  49 */       String cadenaFecha = "";
/*  50 */       SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/*  51 */       Date fecha = new Date();
/*  52 */       cadenaFecha = formato.format(fecha);
/*  53 */       String[] nombre = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + Usuario + "'", 3);
/*  54 */       this.con.consultar("count(num)", "reportes", "");
/*  55 */       FileOutputStream fos = null;
/*  56 */       PrintWriter pw = null;
/*  57 */       File f = new File(this.archivo + ".xls");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 198 */         Workbook libro1 = Workbook.getWorkbook(new File("Formatos/FormatoArchivo.xls"));
/* 199 */         WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/* 200 */         WritableSheet hoja2 = copy.getSheet(0);
/* 201 */         WritableFont fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 12);
/* 202 */         fuente.setColour(Colour.RED);
/* 203 */         fuente.setBoldStyle(WritableFont.BOLD);
/* 204 */         WritableCellFormat forma = new WritableCellFormat(fuente);
/* 205 */         Label label = new Label(0, 3, "REPORTE DE " + Titulo);
/* 206 */         forma.setAlignment(Alignment.CENTRE);
/* 207 */         label.setCellFormat((CellFormat)forma);
/* 208 */         hoja2.addCell((WritableCell)label);
/* 209 */         int numR = Integer.parseInt(this.con.Campo);
/* 210 */         numR++;
/* 211 */         this.con.inserSinMsj("insert into reportes(num)values(" + numR + ")");
/* 212 */         fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 8);
/* 213 */         fuente.setColour(Colour.RED);
/* 214 */         fuente.setBoldStyle(WritableFont.NO_BOLD);
/* 215 */         forma = new WritableCellFormat(fuente);
/* 216 */         label = new Label(2, 4, Usuario);
/* 217 */         forma.setAlignment(Alignment.LEFT);
/* 218 */         label.setCellFormat((CellFormat)forma);
/* 219 */         hoja2.addCell((WritableCell)label);
/* 220 */         label = new Label(11, 4, cadenaFecha);
/* 221 */         label.setCellFormat((CellFormat)forma);
/* 222 */         hoja2.addCell((WritableCell)label);
/* 223 */         label = new Label(6, 4, "" + numR);
/* 224 */         label.setCellFormat((CellFormat)forma);
/* 225 */         hoja2.addCell((WritableCell)label);
/* 226 */         label = new Label(2, 6, "" + tabla.getRowCount());
/* 227 */         label.setCellFormat((CellFormat)forma);
/* 228 */         hoja2.addCell((WritableCell)label);
/* 229 */         fuente = new WritableFont(WritableFont.ARIAL, 7);
/* 230 */         fuente.setColour(Colour.WHITE);
/* 231 */         fuente.setBoldStyle(WritableFont.BOLD);
/* 232 */         forma = new WritableCellFormat(fuente);
/* 233 */         forma.setBackground(Colour.RED);
/* 234 */         forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/* 235 */         label = new Label(0, 10, "NÚM");
/* 236 */         forma.setAlignment(Alignment.CENTRE);
/* 237 */         label.setCellFormat((CellFormat)forma);
/* 238 */         hoja2.addCell((WritableCell)label);
/* 239 */         for (int r = 0; r < Campitos.length; r++) {
/* 240 */           label = new Label(r + 1, 10, Campitos[r]);
/* 241 */           label.setCellFormat((CellFormat)forma);
/* 242 */           hoja2.addCell((WritableCell)label);
/*     */         } 
/* 244 */         int cont = 11;
/* 245 */         fuente = new WritableFont(WritableFont.ARIAL, 6);
/* 246 */         fuente.setColour(Colour.BLACK);
/* 247 */         int num = 1;
/* 248 */         int valorN = -1;
/* 249 */         for (int i = 0; i < tabla.getRowCount(); i++) {
/* 250 */           Colour[] colores = Colour.getAllColours();
/* 251 */           forma = new WritableCellFormat(fuente);
/* 252 */           forma.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
/* 253 */           num++;
/* 254 */           for (int c = -1; c < tabla.getColumnCount(); c++) {
/* 255 */             if (c == -1) {
/* 256 */               Number number = new Number(c + 1, cont, (cont - 10));
/* 257 */               number.setCellFormat((CellFormat)forma);
/* 258 */               hoja2.addCell((WritableCell)number);
/*     */             } else {
/*     */               try {
/* 261 */                 DecimalFormat formatoN = new DecimalFormat("000.00");
/* 262 */                 formatoN.setMaximumFractionDigits(2);
/* 263 */                 float valor = Float.parseFloat(String.valueOf(tabla.getValueAt(i, c)));
/* 264 */                 formatoN.format(valor);
/* 265 */                 Number number = new Number(c + 1, cont, Integer.parseInt(formatoN.format(valor)));
/* 266 */                 number.setCellFormat((CellFormat)forma);
/* 267 */                 hoja2.addCell((WritableCell)number);
/* 268 */               } catch (NumberFormatException e) {
/* 269 */                 String le = String.valueOf(tabla.getValueAt(i, c));
/* 270 */                 if (le.equals("null")) {
/* 271 */                   tabla.setValueAt("", i, c);
/* 272 */                   label = new Label(c + 1, cont, String.valueOf(tabla.getValueAt(i, c)));
/* 273 */                 } else if (le.equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/* 274 */                   label = new Label(c + 1, cont, "WTF");
/* 275 */                 } else if (le.equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/* 276 */                   label = new Label(c + 1, cont, "SLB");
/* 277 */                 } else if (le.equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/* 278 */                   label = new Label(c + 1, cont, "PMX");
/* 279 */                 } else if (le.equals("ADT PETROSERVICIOS S.A. DE C.V.")) {
/* 280 */                   label = new Label(c + 1, cont, "ADT");
/* 281 */                 } else if (le.equals("CLEANMEX S.A. DE C.V.")) {
/* 282 */                   label = new Label(c + 1, cont, "CLEANMEX");
/* 283 */                 } else if (le.equals("QMAX SOLUCIONES AMBIENTALES S.A. DE C.V.")) {
/* 284 */                   label = new Label(c + 1, cont, "Q-MAX");
/* 285 */                 } else if (le.equals("RECORTE BASE AGUA")) {
/* 286 */                   label = new Label(c + 1, cont, "R. BASE AGUA");
/* 287 */                 } else if (le.equals("RECORTE BASE ACEITE")) {
/* 288 */                   label = new Label(c + 1, cont, "R. BASE ACEITE");
/* 289 */                 } else if (le.equals("LODO BASE AGUA")) {
/* 290 */                   label = new Label(c + 1, cont, "L. BASE AGUA");
/* 291 */                 } else if (le.equals("AGUA RESIDUAL")) {
/* 292 */                   label = new Label(c + 1, cont, "A. RESIDUAL");
/* 293 */                 } else if (le.equals("AGUA RESIDUAL")) {
/* 294 */                   label = new Label(c + 1, cont, "A. RESIDUAL");
/* 295 */                 } else if (le.equals("AGUA DE FRACTURA")) {
/* 296 */                   label = new Label(c + 1, cont, "A. DE FRAC.");
/* 297 */                 } else if (le.equals("ECOLTEC S.A. DE C.V. (PLANTA ORIZABA)")) {
/* 298 */                   label = new Label(c + 1, cont, "ECOLTEC-ORIZABA");
/* 299 */                 } else if (le.equals("ECOLTEC S.A. DE C.V. (PLANTA MACUSPANA)")) {
/* 300 */                   label = new Label(c + 1, cont, "ECOLTEC-MACUSPANA");
/* 301 */                 } else if (le.equals("ECOLTEC (PLANTA RAMOS ARIZPE)")) {
/* 302 */                   label = new Label(c + 1, cont, "ECOLTEC-RAMOS ARIZPE");
/* 303 */                 } else if (le.equals("CEMEX MÉXICO S.A DE C.V (PLANTA TEPEACA)")) {
/* 304 */                   label = new Label(c + 1, cont, "CEMEX-TEPEACA");
/* 305 */                 } else if (le.equals("CEMEX MÉXICO (PLANTA TAMUÍN)")) {
/* 306 */                   label = new Label(c + 1, cont, "CEMEX-TAMUÍN");
/* 307 */                 } else if (le.equals("WEATHERFORD")) {
/* 308 */                   label = new Label(c + 1, cont, "WTF");
/*     */                 } else {
/* 310 */                   label = new Label(c + 1, cont, String.valueOf(tabla.getValueAt(i, c)));
/*     */                 } 
/* 312 */                 label.setCellFormat((CellFormat)forma);
/* 313 */                 hoja2.addCell((WritableCell)label);
/*     */               } 
/*     */             } 
/*     */           } 
/* 317 */           cont++;
/*     */         } 
/* 319 */         copy.write();
/* 320 */         copy.close();
/* 321 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + Usuario + "','Creó un reporte','Número: " + numR + "\nTipo: Reporte de " + Titulo + "')");
/*     */         
/* 323 */         int res = JOptionPane.showConfirmDialog(null, "<HTML>El reporte se creó satisfactoriamente en la siguiente dirección:<HR><B>" + f
/*     */             
/* 325 */             .getAbsolutePath() + "</B><p>¿Deseas abrir el archivo?</HTML>", "Reporte Creado", 0, 3, this.INFO);
/*     */         
/* 327 */         if (res == 0) {
/*     */           try {
/* 329 */             File path = new File(f.getAbsolutePath());
/* 330 */             Desktop.getDesktop().open(path);
/* 331 */           } catch (IOException ex) {
/* 332 */             ex.printStackTrace();
/*     */           } 
/*     */         }
/* 335 */       } catch (Exception i) {
/* 336 */         JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   int minutos; int segundos;
/*     */   
/*     */   public String direccion() {
/* 343 */     JFileChooser fileChooser = new JFileChooser();
/* 344 */     String fileName = "";
/* 345 */     int retVal = fileChooser.showSaveDialog(null);
/* 346 */     if (retVal == 0) {
/* 347 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 348 */       return fileName;
/*     */     } 
/* 350 */     return "no";
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/EscribirReporte.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */