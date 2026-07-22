/*     */ package sicret;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class ReporteQHSE {
/*  10 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  11 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  12 */   Consultas con = new Consultas();
/*  13 */   String archivo = "";
/*  14 */   Calendar calendario = Calendar.getInstance(); int hora; int minutos; int segundos;
/*     */   
/*     */   public ReporteQHSE(String Titulo, JTable tabla, String[] Campitos, String Usuario) {
/*  17 */     this.archivo = direccion();
/*  18 */     this.hora = this.calendario.get(11);
/*  19 */     this.minutos = this.calendario.get(12);
/*  20 */     this.segundos = this.calendario.get(13);
/*  21 */     if (!this.archivo.equals("no")) {
/*  22 */       String cadenaFecha = "";
/*  23 */       SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
/*  24 */       Date fecha = new Date();
/*  25 */       cadenaFecha = formato.format(fecha);
/*  26 */       this.con.consultar("count(num)", "reportes", "");
/*  27 */       String nombre = Usuario;
/*  28 */       FileOutputStream fos = null;
/*  29 */       PrintWriter pw = null;
/*  30 */       File f = new File(this.archivo + ".xls");
/*     */       try {
/*  32 */         f.createNewFile();
/*     */         try {
/*  34 */           fos = new FileOutputStream(f);
/*     */         }
/*  36 */         catch (IOException l) {
/*  37 */           JOptionPane.showMessageDialog(null, "Error: " + String.valueOf(l), "Error con el archivo", 64);
/*     */         }
/*  39 */         catch (SecurityException l) {
/*  40 */           JOptionPane.showMessageDialog(null, "Error: " + String.valueOf(l), "Error con el archivo", 64);
/*     */         } 
/*  42 */         int numR = Integer.parseInt(this.con.Campo);
/*  43 */         numR++;
/*  44 */         this.con.inserSinMsj("insert into reportes(num)values(" + numR + ")");
/*  45 */         pw = new PrintWriter(fos);
/*  46 */         pw.println("<!-- Este archivo fué creado por Uzziel Contreras Portilla, Software SICRE - Sistema Integral para el Control de Residuos y Empleados.");
/*  47 */         pw.print(" Se prohibe su distribución total o parcial, ");
/*  48 */         pw.println("quedan todos los derechos reservados a ");
/*  49 */         pw.println("los creadores de este archivo-->");
/*  50 */         pw.println("<h2><center><font color=006666>SICRE - Sistema Integral para el Control de Residuos y Empleados</font></center></h2><hr>");
/*  51 */         pw.println("<center><h3>:: Reporte de " + Titulo + " ::</h3></center>");
/*  52 */         pw.println("<b><font size=3>Datos del Reporte</font></b>");
/*  53 */         pw.println("<br>Usuario: " + nombre);
/*  54 */         pw.println("<br>Fecha: " + cadenaFecha);
/*  55 */         pw.println("<br>Hora: " + this.hora + ":" + this.minutos + ":" + this.segundos);
/*  56 */         pw.println("<br>Número: " + numR);
/*  57 */         pw.println("<p><table cellspacing=2 border=1 align=center>");
/*  58 */         pw.println("<tr>");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  80 */         pw.println(" <FONT SIZE=-1 align=''><I ALIGN= 'RIGHT'>Se prohíbe su distribución total o parcial, quedan todos los derechos reservados a <br>Grupo Forsis S.A. de C.V.</I></FONT>");
/*  81 */         pw.flush();
/*     */         try {
/*  83 */           fos.close();
/*     */         }
/*  85 */         catch (IOException l) {
/*  86 */           JOptionPane.showMessageDialog(null, "A ocurrido un problema al cerrar el archivo: " + String.valueOf(l), "Error al cerrar el archivo", 64);
/*     */         } 
/*  88 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + Usuario + "','Creó un reporte','Número: " + numR + "\nTipo: Reporte de " + Titulo + "')");
/*  89 */         int res = JOptionPane.showConfirmDialog(null, "El archivo se ha creado satisfactoriamente en la dirección " + String.valueOf(f) + "\n¿Deseas verificar el contenido?", "Reporte Creado", 0, 3, this.PREG);
/*  90 */         if (res == 0) {
/*     */           try {
/*  92 */             Process process = Runtime.getRuntime().exec("cmd /c " + String.valueOf(f));
/*     */           }
/*  94 */           catch (Exception e) {
/*  95 */             JOptionPane.showMessageDialog(null, "El proceso de apagado no se pudo cumplir por varias razones", "Apagado Inconcluso", 2);
/*     */           }
/*     */         
/*     */         }
/*  99 */       } catch (IOException i) {
/* 100 */         JOptionPane.showMessageDialog(null, "Error al crear el archivo");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public String direccion() {
/* 105 */     JFileChooser fileChooser = new JFileChooser();
/* 106 */     String fileName = "";
/* 107 */     int retVal = fileChooser.showSaveDialog(null);
/* 108 */     if (retVal == 0) {
/* 109 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 110 */       return fileName;
/*     */     } 
/* 112 */     return "no";
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ReporteQHSE.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */