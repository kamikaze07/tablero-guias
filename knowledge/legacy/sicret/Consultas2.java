/*     */ package sicret;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeBodyPart;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import javax.mail.internet.MimeMultipart;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ 
/*     */ public final class Consultas2 {
/*  25 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  26 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  27 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  28 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  29 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  30 */   FileOutputStream fos = null;
/*  31 */   PrintWriter pw = null;
/*  32 */   String dir = System.getProperty("user.dir");
/*  33 */   int TOTVAR = 0;
/*  34 */   String[] variables = null;
/*     */   Connection cnx;
/*     */   Statement stmt;
/*     */   ResultSet rset;
/*  38 */   String Campo = "";
/*     */   String Servidor;
/*     */   String ServidorMaestro;
/*  41 */   String baseDatos = "sicrePR";
/*  42 */   String USUARIO = "kofuz01";
/*  43 */   String CONTRASEÑA = "Xcape15948";
/*  44 */   JTextArea areaError = new JTextArea();
/*  45 */   JPanel panel = new JPanel();
/*     */   boolean correcto = false;
/*     */   boolean encontrado = false;
/*     */   Map<String, String> CAMPOSGENERALES;
/*     */   
/*     */   public Consultas2() {
/*  51 */     conectar();
/*  52 */     actVariables();
/*  53 */     this.Servidor = servidor();
/*  54 */     System.out.println("Servidor " + this.Servidor);
/*     */   }
/*     */   
/*     */   public void setCamposGenerales(Map<String, String> CAMPOSGENERALES) {
/*  58 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*     */   }
/*     */   
/*     */   public void enviarCorreo(String consulta) {
/*  62 */     if (this.CAMPOSGENERALES != null) {
/*  63 */       Enviando enviando = new Enviando(consulta);
/*     */     }
/*     */   }
/*     */   
/*     */   public void cambiarServidor() {
/*  68 */     this.Servidor = this.ServidorMaestro;
/*     */   }
/*     */   
/*     */   public void setBaseDatos(String baseDatos) {
/*  72 */     this.baseDatos = baseDatos;
/*     */   }
/*     */ 
/*     */   
/*     */   public String ultimoUsuario() {
/*  77 */     return this.variables[31].substring(14, this.variables[31].length());
/*     */   }
/*     */ 
/*     */   
/*     */   public void escribirUltimoUsuario(String usu) {
/*  82 */     this.variables[31] = "Ultimousuario:" + usu;
/*  83 */     guardarConf();
/*     */   }
/*     */ 
/*     */   
/*     */   public void visualizaError(String error) {
/*  88 */     this.areaError.setText(error);
/*  89 */     this.panel.add(this.areaError);
/*  90 */     JOptionPane.showMessageDialog(this.panel, this.panel, "Ha ocurrido un problema", 0, this.ERROR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void matarProcesos() throws SQLException {
/*  95 */     int Npro = 0;
/*     */     try {
/*  97 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/*  98 */       this.stmt = this.cnx.createStatement();
/*  99 */       this.rset = this.stmt.executeQuery("SHOW STATUS LIKE 'max_used_connections'");
/* 100 */       while (this.rset.next()) {
/* 101 */         this.Campo = this.rset.getString(2);
/*     */       }
/* 103 */       this.cnx.close();
/* 104 */     } catch (SQLException sqle) {
/* 105 */       System.out.println(sqle.getMessage());
/* 106 */       this.cnx.close();
/*     */     } 
/* 108 */     Npro = Integer.parseInt(this.Campo);
/* 109 */     String[][] registros = new String[Npro][8];
/* 110 */     int regi = 0;
/*     */     try {
/* 112 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 113 */       this.stmt = this.cnx.createStatement();
/* 114 */       this.rset = this.stmt.executeQuery("show processlist");
/* 115 */       int r = 0;
/* 116 */       while (this.rset.next()) {
/* 117 */         for (int i = 1; i <= 6; i++) {
/* 118 */           registros[r][i - 1] = this.rset.getString(i);
/*     */         }
/* 120 */         r++;
/* 121 */         regi++;
/*     */       } 
/* 123 */       this.cnx.close();
/* 124 */     } catch (SQLException sqle) {
/* 125 */       this.cnx.close();
/*     */     } 
/* 127 */     System.out.println("*** Eliminando procesos muertos en BD ***");
/* 128 */     System.out.println("- Cantidad de conexiones pendientes: " + regi + "\n");
/* 129 */     for (int j = 0; j < registros.length; j++) {
/* 130 */       for (int i = 0; i < 6; i++) {
/* 131 */         int seg = 0;
/*     */         try {
/* 133 */           seg = Integer.parseInt(registros[j][5]);
/* 134 */         } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */         
/* 137 */         if (registros[j][i] != null && registros[j][i]
/* 138 */           .equals("Sleep") && seg > 360) {
/*     */           try {
/* 140 */             this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 141 */             this.stmt = this.cnx.createStatement();
/* 142 */             System.out.print("kill " + registros[j][0] + ", Tiempo " + seg);
/* 143 */             this.rset = this.stmt.executeQuery("kill " + registros[j][0]);
/* 144 */             while (this.rset.next()) {
/* 145 */               this.Campo = this.rset.getString(2);
/*     */             }
/* 147 */             this.cnx.close();
/* 148 */           } catch (SQLException sqle) {
/* 149 */             System.out.println(": Exception - " + sqle.getMessage());
/* 150 */             this.cnx.close();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void conectar() {
/*     */     try {
/* 159 */       Class.forName("com.mysql.jdbc.Driver");
/* 160 */     } catch (Exception e) {
/* 161 */       JOptionPane.showMessageDialog(null, "No se encuentra el driver instalado", "Driver no encontrado", 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int numLineas() {
/* 166 */     int lNumeroLineas = 0;
/* 167 */     Reader archivo = null;
/*     */     try {
/* 169 */       archivo = new FileReader("Config.sde");
/* 170 */     } catch (FileNotFoundException ex) {
/* 171 */       Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 173 */     BufferedReader filtro = new BufferedReader(archivo);
/* 174 */     String sCadena = "";
/*     */     try {
/* 176 */       while ((sCadena = filtro.readLine()) != null) {
/* 177 */         lNumeroLineas++;
/*     */       }
/* 179 */     } catch (IOException ex) {
/* 180 */       Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 182 */     return lNumeroLineas;
/*     */   }
/*     */   
/*     */   public String dameCampo() {
/* 186 */     return this.Campo;
/*     */   }
/*     */   
/*     */   public void actVariables() {
/* 190 */     String linea = "";
/* 191 */     int cont = 0;
/* 192 */     this.TOTVAR = numLineas();
/* 193 */     this.variables = new String[this.TOTVAR];
/*     */     try {
/* 195 */       Reader archivo = new FileReader("Config.sde");
/* 196 */       BufferedReader filtro = new BufferedReader(archivo);
/* 197 */       while ((linea = filtro.readLine()) != null) {
/* 198 */         this.variables[cont] = linea;
/* 199 */         cont++;
/*     */       } 
/* 201 */       filtro.close();
/* 202 */       archivo.close();
/* 203 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSucursal() {
/* 210 */     String suc = this.variables[40].substring(9);
/*     */     
/* 212 */     return suc;
/*     */   }
/*     */ 
/*     */   
/*     */   public String servidor() {
/* 217 */     String cadena = this.variables[0].substring(9);
/* 218 */     String[] servidores = cadena.split(",");
/* 219 */     String servidor1 = servidores[0];
/* 220 */     this.ServidorMaestro = servidores[1];
/* 221 */     return servidor1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean barra() {
/* 226 */     String barra = this.variables[1].substring(6);
/* 227 */     if (barra.equals("true")) {
/* 228 */       return true;
/*     */     }
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean estado() {
/* 235 */     String barra = this.variables[2].substring(7);
/* 236 */     if (barra.equals("true")) {
/* 237 */       return true;
/*     */     }
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String avisos() {
/* 244 */     return this.variables[5];
/*     */   }
/*     */ 
/*     */   
/*     */   public void definirBarra(boolean act) {
/* 249 */     this.variables[1] = "Barra:" + act;
/*     */   }
/*     */ 
/*     */   
/*     */   public void definirEstado(boolean act) {
/* 254 */     this.variables[2] = "Estado:" + act;
/*     */   }
/*     */ 
/*     */   
/*     */   public void guardarConf() {
/*     */     try {
/* 260 */       this.fos = new FileOutputStream("Config.sde");
/* 261 */     } catch (IOException l) {
/* 262 */       JOptionPane.showMessageDialog(null, "Error al crear el archivo de configuraciones para este usuario\nSi persisten los problemas por favor contacta al diseñador o envia un correo a kofuz01@hotmail.com", "No se pudo crear el archivo config.sde", 0, this.ERROR);
/*     */     } 
/* 264 */     this.pw = new PrintWriter(this.fos);
/* 265 */     for (int i = 0; i < this.variables.length; i++) {
/* 266 */       this.pw.println(this.variables[i]);
/*     */     }
/* 268 */     this.pw.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean consultar(String Campos, String Tablas, String Condicion) {
/* 273 */     this.Campo = "";
/*     */     try {
/* 275 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 276 */       this.stmt = this.cnx.createStatement();
/* 277 */       System.out.println("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion + " LIMIT 1");
/* 278 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion + " LIMIT 1");
/* 279 */       if (this.rset.next()) {
/* 280 */         this.Campo = this.rset.getString(1);
/* 281 */         return true;
/*     */       } 
/* 283 */       this.cnx.close();
/* 284 */     } catch (SQLException sqle) {
/* 285 */       int res = JOptionPane.showConfirmDialog(null, "<html>Ha ocurrido un problema al conectarse con el servidor de la base de datos<br>¿Deseas ver el código del error?</html>", "Error Crítico", 0, 3, this.ERROR);
/* 286 */       if (res == 0) {
/* 287 */         JPanel jPanel = new JPanel();
/*     */       } else {
/* 289 */         System.exit(0);
/*     */       } 
/* 291 */       JOptionPane.showMessageDialog(null, "Error: Consultar ->\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/* 293 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void insertar(String Datos) {
/*     */     try {
/* 299 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 300 */       this.stmt = this.cnx.createStatement();
/* 301 */       System.out.println(Datos);
/* 302 */       this.stmt.executeUpdate(Datos);
/* 303 */       this.cnx.close();
/* 304 */       JOptionPane.showMessageDialog(null, "Los datos se han almacenado perfectamente", "Datos Guardados", 1, this.INFO);
/* 305 */     } catch (SQLException sqle) {
/* 306 */       enviarCorreo(Datos);
/* 307 */       JOptionPane.showMessageDialog(null, "Error Insertar:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void inserSinMsj(String Datos) {
/*     */     try {
/* 313 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 314 */       this.stmt = this.cnx.createStatement();
/* 315 */       System.out.println(Datos);
/*     */       
/* 317 */       this.stmt.executeUpdate(Datos);
/* 318 */       this.correcto = true;
/* 319 */       this.cnx.close();
/* 320 */     } catch (SQLException sqle) {
/* 321 */       enviarCorreo(Datos);
/* 322 */       JOptionPane.showMessageDialog(null, "Error Insertar Sin Msj:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/* 323 */       this.correcto = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bitacora(String Datos) {
/*     */     try {
/* 329 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 330 */       this.stmt = this.cnx.createStatement();
/* 331 */       System.out.println(Datos);
/* 332 */       this.stmt.executeUpdate(Datos);
/* 333 */       this.cnx.close();
/* 334 */     } catch (SQLException sqle) {
/* 335 */       JOptionPane.showMessageDialog(null, "Error en Bitacora:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean buscar(String Campos, String Tablas, String Condicion, String Titulo, String Msj) {
/*     */     try {
/* 343 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 344 */       this.stmt = this.cnx.createStatement();
/* 345 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 346 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 347 */       if (this.rset.next()) {
/* 348 */         this.cnx.close();
/* 349 */         JOptionPane.showMessageDialog(null, Msj, Titulo, 0, this.ERROR);
/* 350 */         return true;
/*     */       } 
/* 352 */     } catch (SQLException sqle) {
/*     */       
/* 354 */       JOptionPane.showMessageDialog(null, "Error buscar:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 357 */     return false;
/*     */   }
/*     */   
/*     */   public int dameIndice(ResultSet rset) throws SQLException {
/* 361 */     rset.last();
/* 362 */     int indice = rset.getRow();
/* 363 */     rset.beforeFirst();
/* 364 */     return indice;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[][] buscarDatos(int numCol, String Campos, String Tablas, String Condicion) {
/* 369 */     String[][] registros = null;
/*     */     try {
/* 371 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 372 */       this.stmt = this.cnx.createStatement();
/* 373 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 374 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion);
/* 375 */       registros = new String[dameIndice(this.rset)][numCol];
/* 376 */       int regi = 0;
/* 377 */       while (this.rset.next()) {
/* 378 */         for (int i = 1; i <= numCol; i++) {
/* 379 */           registros[regi][i - 1] = this.rset.getString(i);
/*     */         }
/* 381 */         regi++;
/*     */       } 
/* 383 */       this.cnx.close();
/* 384 */     } catch (SQLException sqle) {
/* 385 */       System.out.println("ERROR: Buscar Datos - >" + String.valueOf(sqle));
/*     */     } 
/*     */     
/* 388 */     return registros;
/*     */   }
/*     */   
/*     */   public String[][] buscarDatos(String Campos, String Tablas, String Condicion) {
/* 392 */     String[][] registros = null;
/* 393 */     int col = (Campos.split(",")).length;
/*     */     try {
/* 395 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 396 */       this.stmt = this.cnx.createStatement();
/* 397 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 398 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 399 */       registros = new String[dameIndice(this.rset)][col];
/* 400 */       int regi = 0;
/* 401 */       while (this.rset.next()) {
/* 402 */         for (int i = 1; i <= col; i++) {
/* 403 */           registros[regi][i - 1] = this.rset.getString(i);
/*     */         }
/* 405 */         regi++;
/*     */       } 
/* 407 */       this.cnx.close();
/* 408 */     } catch (SQLException sqle) {
/* 409 */       JOptionPane.showMessageDialog(null, "Error buscarReg:\n" + String.valueOf(sqle), "Error en BuscarReg", 0);
/*     */     } 
/*     */     
/* 412 */     return registros;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] regresaReg(String Campos, String Tablas, String Condicion, int numCol) {
/* 417 */     String[] Registros = new String[numCol];
/*     */     try {
/* 419 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 420 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion + " LIMIT 1");
/* 421 */       this.stmt = this.cnx.createStatement();
/* 422 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion + " LIMIT 1");
/* 423 */       while (this.rset.next()) {
/* 424 */         for (int i = 1; i <= numCol; i++) {
/* 425 */           Registros[i - 1] = this.rset.getString(i);
/*     */         }
/*     */       } 
/* 428 */       this.cnx.close();
/* 429 */     } catch (SQLException sqle) {
/* 430 */       JOptionPane.showMessageDialog(null, "Error Regresa Registro:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/* 432 */     return Registros;
/*     */   }
/*     */   
/*     */   public String[] regresaRegIndex(String Campos, String Tablas, String Condicion) {
/* 436 */     int col = (Campos.split(",")).length;
/* 437 */     String[] Registros = new String[col];
/*     */     try {
/* 439 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 440 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion + " LIMIT 1");
/* 441 */       this.stmt = this.cnx.createStatement();
/* 442 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion + " LIMIT 1");
/* 443 */       while (this.rset.next()) {
/* 444 */         for (int i = 1; i <= col; i++) {
/* 445 */           Registros[i - 1] = this.rset.getString(i);
/*     */         }
/*     */       } 
/* 448 */       this.cnx.close();
/* 449 */       this.encontrado = (Registros[0] != null);
/* 450 */     } catch (SQLException sqle) {
/* 451 */       JOptionPane.showMessageDialog(null, "Error Regresa Registro:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/* 453 */     return Registros;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] regresaCol(String Campo, String Tablas, String Condicion, int total) {
/* 458 */     String[] Registros = new String[total];
/*     */     try {
/* 460 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 461 */       this.stmt = this.cnx.createStatement();
/* 462 */       System.out.println("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 463 */       this.rset = this.stmt.executeQuery("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 464 */       int cont = 0;
/* 465 */       while (this.rset.next()) {
/* 466 */         Registros[cont] = this.rset.getString(1).toUpperCase();
/* 467 */         cont++;
/*     */       } 
/* 469 */       this.cnx.close();
/* 470 */     } catch (SQLException sqle) {
/* 471 */       JOptionPane.showMessageDialog(null, "Error: RegresaCol->\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 474 */     return Registros;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] regresaColIndex(String Campo, String Tablas, String Condicion) {
/* 479 */     String[] Registros = null;
/* 480 */     boolean entra = false;
/*     */     try {
/* 482 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 483 */       this.stmt = this.cnx.createStatement();
/* 484 */       System.out.println("SELECT " + Campo + " FROM " + Tablas.toLowerCase() + " " + Condicion);
/* 485 */       entra = true;
/* 486 */       this.rset = this.stmt.executeQuery("SELECT " + Campo + " FROM " + Tablas.toLowerCase() + " " + Condicion);
/*     */       
/* 488 */       int cont = 0;
/* 489 */       Registros = new String[dameIndice(this.rset)];
/* 490 */       while (this.rset.next()) {
/* 491 */         Registros[cont] = this.rset.getString(1).toUpperCase();
/* 492 */         cont++;
/*     */       } 
/* 494 */       this.cnx.close();
/* 495 */     } catch (SQLException sqle) {
/* 496 */       if (entra) {
/* 497 */         JOptionPane.showMessageDialog(null, "ERROR: RegresaColIndex->\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */       } else {
/*     */         
/* 500 */         System.out.println("ERROR: RegresaColIndex ->\nMensaje" + sqle.getMessage() + "\nEstado" + sqle.getSQLState());
/*     */       } 
/*     */     } 
/* 503 */     return Registros;
/*     */   }
/*     */   
/*     */   public void eliminar(String Tablas, String Condicion) {
/*     */     try {
/* 508 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 509 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 511 */       this.stmt.executeUpdate("Delete from " + Tablas + " " + Condicion);
/* 512 */       JOptionPane.showMessageDialog(null, "Los datos se han eliminado satisfactoriamente", "Datos Eliminados", 0, this.INFO);
/* 513 */       this.cnx.close();
/* 514 */     } catch (SQLException sqle) {
/* 515 */       enviarCorreo("Delete from " + Tablas + " " + Condicion);
/* 516 */       JOptionPane.showMessageDialog(null, "Error Eliminar:\n" + String.valueOf(sqle), "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void eliminar2(String Tablas, String Condicion) {
/*     */     try {
/* 522 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 523 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 525 */       System.out.println("Delete from " + Tablas + " " + Condicion);
/* 526 */       this.stmt.executeUpdate("Delete from " + Tablas + " " + Condicion);
/* 527 */       this.cnx.close();
/* 528 */     } catch (SQLException sqle) {
/* 529 */       enviarCorreo("Delete from " + Tablas + " " + Condicion);
/* 530 */       JOptionPane.showMessageDialog(null, "Error Eliminar2:\n" + String.valueOf(sqle), "Error", 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] revisarCol(JTable tabla, String buscarValor, int indice, int indiceValor, int tipo) {
/* 537 */     String[] regresaReg = null;
/* 538 */     int cont = 0;
/* 539 */     if (tipo == 0) {
/*     */       int i;
/* 541 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 542 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 543 */         if (valorComparar.equals(buscarValor)) {
/* 544 */           cont++;
/*     */         }
/*     */       } 
/* 547 */       regresaReg = new String[cont];
/* 548 */       cont = 0;
/* 549 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 550 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 551 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 552 */         if (valorComparar.equals(buscarValor)) {
/* 553 */           regresaReg[cont] = valorIndice;
/* 554 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 558 */     if (tipo == 1) {
/*     */       int i;
/* 560 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 561 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 562 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 563 */         if (!valorComparar.equals(buscarValor)) {
/* 564 */           cont++;
/*     */         }
/*     */       } 
/* 567 */       regresaReg = new String[cont];
/*     */       
/* 569 */       cont = 0;
/* 570 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 571 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 572 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 573 */         if (!valorComparar.equals(buscarValor)) {
/* 574 */           regresaReg[cont] = valorIndice;
/* 575 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 580 */     if (tipo == 2) {
/*     */       int i;
/* 582 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 583 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 584 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 585 */         if (valorComparar.contains(buscarValor)) {
/* 586 */           cont++;
/*     */         }
/*     */       } 
/* 589 */       regresaReg = new String[cont];
/*     */       
/* 591 */       cont = 0;
/* 592 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 593 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 594 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 595 */         if (valorComparar.contains(buscarValor)) {
/* 596 */           regresaReg[cont] = valorIndice;
/* 597 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 601 */     return regresaReg;
/*     */   }
/*     */   
/*     */   public void actualizarReg(String tableName, Map<String, Object> camposValores, String condicion) {
/* 605 */     PreparedStatement preparedStatement = null;
/*     */     try {
/* 607 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 608 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 610 */       StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
/* 611 */       for (String field : camposValores.keySet()) {
/* 612 */         sql.append(field).append(" = " + String.valueOf(camposValores.get(field)) + ", ");
/*     */       }
/* 614 */       sql.setLength(sql.length() - 2);
/* 615 */       sql.append(" " + condicion);
/* 616 */       System.out.println(sql.toString());
/* 617 */       this.stmt.executeUpdate(sql.toString());
/* 618 */       this.correcto = true;
/* 619 */       this.cnx.close();
/* 620 */     } catch (SQLException sqle) {
/* 621 */       JOptionPane.showMessageDialog(null, "Error Insertar Sin Msj:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/* 622 */       this.correcto = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   class Enviando
/*     */   {
/* 628 */     String[] DIRECCIONES = new String[] { "sistemas.poza@forsis.com.mx" };
/*     */     
/*     */     public Enviando(String consulta) {
/*     */       try {
/* 632 */         Properties props = new Properties();
/* 633 */         props.put("mail.smtp.host", "smtp.gmail.com");
/* 634 */         props.setProperty("mail.smtp.starttls.enable", "true");
/* 635 */         props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
/* 636 */         props.setProperty("mail.smtp.port", "587");
/* 637 */         props.setProperty("mail.smtp.user", "forsis4@gmail.com");
/* 638 */         props.setProperty("mail.smtp.auth", "true");
/*     */         
/* 640 */         MimeBodyPart mimeBodyPart = new MimeBodyPart();
/* 641 */         mimeBodyPart.setText("Se ha generado un mensaje de error dentro del sistema de: \n" + (String)Consultas2.this.CAMPOSGENERALES
/* 642 */             .get("sucursal") + "\nUsuario: " + (String)Consultas2.this.CAMPOSGENERALES
/* 643 */             .get("usuario") + "\nConsulta: " + consulta);
/*     */ 
/*     */ 
/*     */         
/* 647 */         Session session = Session.getDefaultInstance(props);
/* 648 */         MimeMessage message = new MimeMessage(session);
/* 649 */         message.setFrom((Address)new InternetAddress("forsis4@gmail.com"));
/*     */         
/* 651 */         MimeMultipart multiParte = new MimeMultipart();
/* 652 */         multiParte.addBodyPart((BodyPart)mimeBodyPart);
/* 653 */         session.getProperties().put("mail.smtp.starttls.enable", "true");
/*     */         
/* 655 */         Address[] direccion = new Address[this.DIRECCIONES.length];
/* 656 */         for (int i = 0; i < this.DIRECCIONES.length; i++) {
/* 657 */           direccion[i] = (Address)new InternetAddress(this.DIRECCIONES[i]);
/*     */         }
/* 659 */         message.addRecipients(Message.RecipientType.TO, direccion);
/*     */         
/* 661 */         message.setSubject("ERROR EN SISTEMA SICRET: " + (String)Consultas2.this.CAMPOSGENERALES.get("sucursal"));
/* 662 */         message.setContent((Multipart)multiParte);
/*     */         
/* 664 */         Transport t = session.getTransport("smtp");
/*     */         
/* 666 */         t.connect("forsis4@gmail.com", "dpceabhsjgudkusm");
/* 667 */         t.sendMessage((Message)message, message.getAllRecipients());
/* 668 */         System.out.println("*** Correo enviado con errores ***");
/* 669 */         t.close();
/* 670 */       } catch (Exception e) {
/* 671 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Consultas2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */