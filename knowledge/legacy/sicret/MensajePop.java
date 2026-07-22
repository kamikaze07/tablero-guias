/*     */ package sicret;
/*     */ import java.awt.Image;
/*     */ import java.awt.MenuItem;
/*     */ import java.awt.PopupMenu;
/*     */ import java.awt.SystemTray;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.TrayIcon;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class MensajePop {
/*  21 */   TrayIcon icono = null;
/*  22 */   String MENSAJE = "";
/*  23 */   String TITULO = "";
/*  24 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  25 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  26 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  27 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  28 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  29 */   TrayIcon.MessageType TIPO = null;
/*  30 */   JFrame padre = null;
/*  31 */   PopupMenu popupMenu1 = new PopupMenu();
/*  32 */   MenuItem menuItem2 = new MenuItem();
/*  33 */   MenuItem menuItem1 = new MenuItem();
/*  34 */   String dir = System.getProperty("user.dir");
/*  35 */   FileOutputStream fos = null;
/*  36 */   PrintWriter pw = null;
/*  37 */   String[] variables = null;
/*  38 */   String contenido = "";
/*  39 */   String folio = "";
/*  40 */   String FOLIOANT = "";
/*  41 */   String FOLIONUE = "";
/*  42 */   String[] VARIABLES = null;
/*  43 */   int LINEAS = 0;
/*  44 */   String DEPARTAMENTOS = "";
/*  45 */   String RUTA = "";
/*  46 */   String RUTA2 = "";
/*  47 */   Consultas con = new Consultas();
/*     */   boolean primera = true;
/*  49 */   String so = System.getProperty("os.name");
/*     */   
/*     */   public MensajePop(final JFrame padre) {
/*  52 */     cargar();
/*  53 */     this.padre = padre;
/*  54 */     this.menuItem1.setLabel("Abrir");
/*  55 */     this.menuItem2.setLabel("Salir");
/*  56 */     this.popupMenu1.add(this.menuItem1);
/*  57 */     this.popupMenu1.add(this.menuItem2);
/*  58 */     ocultar();
/*  59 */     this.menuItem1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  61 */             padre.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/*  65 */     this.menuItem2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  67 */             int res = JOptionPane.showConfirmDialog(padre, "<html>¿Estás seguro que deseas salir de SICRE?<br><b>Sistema Integral para el Control de Residuos y Empleados</b></html>", "Saliendo...", 0, 3, MensajePop.this.PREG);
/*  68 */             if (res == 0) {
/*  69 */               System.exit(0);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/*  74 */     if (SystemTray.isSupported()) {
/*  75 */       SystemTray tray = SystemTray.getSystemTray();
/*  76 */       Image imagenIcono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("LOGO.png"));
/*  77 */       this.icono = new TrayIcon(imagenIcono, "Sicret");
/*  78 */       this.icono.setImageAutoSize(true);
/*     */       try {
/*  80 */         tray.add(this.icono);
/*  81 */         this.icono.setPopupMenu(this.popupMenu1);
/*  82 */       } catch (AWTException e) {
/*  83 */         System.err.println("No es posible agregar el icono al System Tray");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ruta(String ruta, String ruta2) {
/*  89 */     this.RUTA = ruta;
/*  90 */     this.RUTA2 = ruta2;
/*     */   }
/*     */   
/*     */   public void Mensaje(String Mensaje, String Titulo, String tipo) {
/*  94 */     if (tipo.equals("ERROR")) {
/*  95 */       this.TIPO = TrayIcon.MessageType.ERROR;
/*  96 */     } else if (tipo.equals("INFO")) {
/*  97 */       this.TIPO = TrayIcon.MessageType.INFO;
/*  98 */     } else if (tipo.equals("NONE")) {
/*  99 */       this.TIPO = TrayIcon.MessageType.NONE;
/* 100 */     } else if (tipo.equals("WARNING")) {
/* 101 */       this.TIPO = TrayIcon.MessageType.WARNING;
/*     */     } 
/* 103 */     this.icono.displayMessage(Titulo, Mensaje, this.TIPO);
/*     */   }
/*     */   
/*     */   public void ocultar() {
/* 107 */     this.menuItem1.setEnabled(false);
/* 108 */     this.menuItem2.setEnabled(false);
/*     */   }
/*     */   
/*     */   public void visualizar() {
/* 112 */     this.menuItem1.setEnabled(true);
/* 113 */     this.menuItem2.setEnabled(true);
/*     */   }
/*     */   
/*     */   public void cargar() {
/* 117 */     this.contenido = "";
/* 118 */     String linea = "";
/* 119 */     int cont = 0;
/* 120 */     this.LINEAS = 0;
/*     */     try {
/* 122 */       if (this.primera) {
/* 123 */         File f1 = new File(this.RUTA);
/* 124 */         File f2 = new File(this.RUTA2);
/* 125 */         if (f1.length() > 100000L) {
/* 126 */           f2.delete();
/* 127 */           this.con.inserSinMsj("update configuraciones set rutaAvisos ='" + this.RUTA2 + "', rutaAvisos2='" + this.RUTA + "'");
/* 128 */           String auxR = this.RUTA2;
/* 129 */           this.RUTA2 = this.RUTA;
/* 130 */           this.RUTA = auxR;
/* 131 */           this.primera = false;
/*     */         } 
/*     */       } 
/* 134 */       Reader archivo = new FileReader(this.RUTA);
/* 135 */       BufferedReader filtro = new BufferedReader(archivo);
/* 136 */       while ((linea = filtro.readLine()) != null) {
/* 137 */         this.contenido = this.contenido + this.contenido + "\n";
/* 138 */         this.LINEAS++;
/*     */         try {
/* 140 */           cont = Integer.parseInt(linea);
/* 141 */           this.folio = linea;
/* 142 */           this.FOLIONUE = this.folio;
/* 143 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */       
/* 146 */       filtro.close();
/* 147 */       archivo.close();
/* 148 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public void actVariables() {
/* 153 */     this.contenido = "";
/* 154 */     String linea = "";
/* 155 */     int cont = 0;
/* 156 */     this.VARIABLES = new String[this.LINEAS];
/*     */     try {
/* 158 */       Reader archivo = new FileReader(this.RUTA);
/* 159 */       BufferedReader filtro = new BufferedReader(archivo);
/*     */       
/* 161 */       while ((linea = filtro.readLine()) != null) {
/* 162 */         this.VARIABLES[cont] = linea;
/* 163 */         cont++;
/*     */       } 
/* 165 */       filtro.close();
/* 166 */       archivo.close();
/* 167 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public String dameFolio() {
/* 172 */     int valor = 0;
/*     */     try {
/* 174 */       valor = Integer.parseInt(this.folio);
/* 175 */       valor++;
/* 176 */     } catch (NumberFormatException n) {
/* 177 */       valor++;
/*     */     } 
/* 179 */     return "" + valor;
/*     */   }
/*     */   
/*     */   public void departamentos(String depa) {
/* 183 */     this.DEPARTAMENTOS = depa;
/*     */   }
/*     */   
/*     */   public void guardarConf(String Mensaje, String Titulo, String Tipo, String depa) {
/* 187 */     if (!this.so.equals("Linux")) {
/* 188 */       cargar();
/*     */       try {
/* 190 */         this.fos = new FileOutputStream(this.RUTA);
/* 191 */       } catch (IOException l) {
/* 192 */         if (!Mensaje.contains("CAROLINA")) {
/* 193 */           JOptionPane.showMessageDialog(null, "Error al crear el archivo de configuraciones para este usuario\nSi persisten los problemas por favor contacta al diseñador o envia un correo a kofuz01@hotmail.com", "No se pudo crear el archivo config.sde", 0, this.ERROR);
/*     */         }
/*     */       } 
/* 196 */       this.pw = new PrintWriter(this.fos);
/* 197 */       this.pw.println(this.contenido);
/* 198 */       this.pw.println(depa);
/* 199 */       this.pw.println(Mensaje);
/* 200 */       this.pw.println(Titulo);
/* 201 */       this.pw.println(Tipo);
/* 202 */       this.pw.println(dameFolio());
/* 203 */       this.pw.flush();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actReloj() {
/* 208 */     new Esperando();
/*     */   }
/*     */   
/*     */   public class Esperando
/*     */     implements Runnable {
/*     */     Thread t;
/* 214 */     int cont = 0;
/*     */     
/*     */     Esperando() {
/* 217 */       this.t = new Thread(this);
/* 218 */       this.t.start();
/*     */     }
/*     */ 
/*     */     
/*     */     public void start() {}
/*     */     
/*     */     public void run() {
/*     */       try {
/*     */         while (true) {
/* 227 */           MensajePop.this.FOLIOANT = MensajePop.this.FOLIONUE;
/* 228 */           Thread.currentThread(); Thread.sleep(12000L);
/* 229 */           MensajePop.this.cargar();
/* 230 */           if (!MensajePop.this.FOLIOANT.equals(MensajePop.this.FOLIONUE) && !MensajePop.this.FOLIOANT.equals("")) {
/* 231 */             MensajePop.this.actVariables();
/* 232 */             String depa = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 5];
/* 233 */             System.out.println("mensaje pop: " + MensajePop.this.DEPARTAMENTOS + " " + depa);
/* 234 */             if (MensajePop.this.DEPARTAMENTOS.contains(depa)) {
/* 235 */               String msj = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 4];
/* 236 */               String tit = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 3];
/* 237 */               String tipo = MensajePop.this.VARIABLES[MensajePop.this.LINEAS - 2];
/* 238 */               MensajePop.this.Mensaje(msj, tit, tipo);
/*     */             } 
/*     */           } 
/*     */         } 
/* 242 */       } catch (InterruptedException interruptedException) {
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/MensajePop.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */