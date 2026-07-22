/*     */ package sicret;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTable;
/*     */ 
/*     */ public final class Consultas {
/*  13 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  14 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  15 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  16 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  17 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  18 */   FileOutputStream fos = null;
/*  19 */   PrintWriter pw = null;
/*  20 */   String dir = System.getProperty("user.dir");
/*  21 */   int TOTVAR = 0;
/*  22 */   String[] variables = null;
/*     */   String Servidor;
/*     */   Connection cnx;
/*     */   Statement stmt;
/*     */   ResultSet rset;
/*  27 */   String Campo = "";
/*  28 */   String baseDatos = "sicrePR";
/*  29 */   String USUARIO = "kofuz01";
/*  30 */   String CONTRASEÑA = "Xcape15948";
/*     */   
/*     */   public Consultas() {
/*  33 */     conectar();
/*  34 */     actVariables();
/*  35 */     this.Servidor = servidor();
/*     */   }
/*     */   
/*     */   public void matarProcesos() throws SQLException {
/*  39 */     int Npro = 0;
/*     */     try {
/*  41 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/*  42 */       this.stmt = this.cnx.createStatement();
/*  43 */       this.rset = this.stmt.executeQuery("SHOW STATUS LIKE 'max_used_connections'");
/*  44 */       while (this.rset.next()) {
/*  45 */         this.Campo = this.rset.getString(2);
/*     */       }
/*  47 */       this.cnx.close();
/*  48 */     } catch (SQLException sqle) {
/*     */       
/*  50 */       System.out.println(sqle.getMessage());
/*  51 */       this.cnx.close();
/*     */     } 
/*  53 */     Npro = Integer.parseInt(this.Campo);
/*  54 */     String[][] registros = new String[Npro][8];
/*  55 */     int regi = 0;
/*     */     try {
/*  57 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/*  58 */       this.stmt = this.cnx.createStatement();
/*  59 */       this.rset = this.stmt.executeQuery("show processlist");
/*  60 */       int r = 0;
/*  61 */       while (this.rset.next()) {
/*  62 */         for (int i = 1; i <= 6; i++) {
/*  63 */           registros[r][i - 1] = this.rset.getString(i);
/*     */         }
/*  65 */         r++;
/*  66 */         System.out.println();
/*  67 */         regi++;
/*     */       } 
/*  69 */       this.cnx.close();
/*  70 */     } catch (SQLException sqle) {
/*     */       
/*  72 */       this.cnx.close();
/*     */     } 
/*     */     
/*  75 */     System.out.println("______________");
/*  76 */     for (int j = 0; j < registros.length; j++) {
/*  77 */       for (int i = 0; i < 6; i++) {
/*  78 */         int seg = 0;
/*     */         try {
/*  80 */           seg = Integer.parseInt(registros[j][5]);
/*  81 */         } catch (NumberFormatException numberFormatException) {}
/*     */         
/*  83 */         if (registros[j][i] != null && registros[j][i]
/*  84 */           .equals("Sleep") && seg > 300) {
/*     */           try {
/*  86 */             this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/*  87 */             this.stmt = this.cnx.createStatement();
/*  88 */             this.rset = this.stmt.executeQuery("kill " + registros[j][0]);
/*  89 */             while (this.rset.next()) {
/*  90 */               this.Campo = this.rset.getString(2);
/*     */             }
/*  92 */             this.cnx.close();
/*  93 */           } catch (SQLException sqle) {
/*  94 */             System.out.println("Error Matar Procesos:\n " + sqle.getMessage());
/*  95 */             this.cnx.close();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBaseDatos(String baseDatos) {
/* 103 */     this.baseDatos = baseDatos;
/*     */   }
/*     */   
/*     */   public void conectar() {
/*     */     try {
/* 108 */       Class.forName("com.mysql.jdbc.Driver");
/*     */     }
/* 110 */     catch (Exception e) {
/* 111 */       JOptionPane.showMessageDialog(null, "No se encuentra el driver instalado", "Driver no encontrado", 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int numLineas() {
/* 116 */     int lNumeroLineas = 0;
/* 117 */     Reader archivo = null;
/*     */     try {
/* 119 */       archivo = new FileReader("Config.sde");
/* 120 */     } catch (FileNotFoundException ex) {
/* 121 */       Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 123 */     BufferedReader filtro = new BufferedReader(archivo);
/* 124 */     String sCadena = "";
/*     */     try {
/* 126 */       while ((sCadena = filtro.readLine()) != null) {
/* 127 */         lNumeroLineas++;
/*     */       }
/* 129 */     } catch (IOException ex) {
/* 130 */       Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 132 */     return lNumeroLineas;
/*     */   }
/*     */   
/*     */   public void actVariables() {
/* 136 */     String linea = "";
/* 137 */     int cont = 0;
/* 138 */     this.TOTVAR = numLineas();
/* 139 */     this.variables = new String[this.TOTVAR];
/*     */     try {
/* 141 */       Reader archivo = new FileReader("Config.sde");
/* 142 */       BufferedReader filtro = new BufferedReader(archivo);
/* 143 */       while ((linea = filtro.readLine()) != null) {
/* 144 */         this.variables[cont] = linea;
/*     */ 
/*     */         
/* 147 */         cont++;
/*     */       } 
/* 149 */       filtro.close();
/* 150 */       archivo.close();
/* 151 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public String servidor() {
/* 156 */     String servidor = this.variables[0].substring(9);
/* 157 */     return servidor;
/*     */   }
/*     */   
/*     */   public boolean barra() {
/* 161 */     String barra = this.variables[1].substring(6);
/* 162 */     if (barra.equals("true")) {
/* 163 */       return true;
/*     */     }
/* 165 */     return false;
/*     */   }
/*     */   
/*     */   public boolean estado() {
/* 169 */     String barra = this.variables[2].substring(7);
/* 170 */     if (barra.equals("true")) {
/* 171 */       return true;
/*     */     }
/* 173 */     return false;
/*     */   }
/*     */   
/*     */   public String avisos() {
/* 177 */     return this.variables[5].substring(7);
/*     */   }
/*     */   
/*     */   public void definirBarra(boolean act) {
/* 181 */     this.variables[1] = "Barra:" + act;
/*     */   }
/*     */   
/*     */   public void definirEstado(boolean act) {
/* 185 */     this.variables[2] = "Estado:" + act;
/*     */   }
/*     */   
/*     */   public void guardarConf() {
/*     */     try {
/* 190 */       this.fos = new FileOutputStream("Config.sde");
/* 191 */     } catch (IOException l) {
/* 192 */       JOptionPane.showMessageDialog(null, "Error al crear el archivo de configuraciones para este usuario\nSi persisten los problemas por favor contacta al diseñador o envia un correo a kofuz01@hotmail.com", "No se pudo crear el archivo config.sde", 0, this.ERROR);
/*     */     } 
/* 194 */     this.pw = new PrintWriter(this.fos);
/* 195 */     for (int i = 0; i < this.variables.length; i++) {
/* 196 */       this.pw.println(this.variables[i]);
/*     */     }
/* 198 */     this.pw.flush();
/*     */   }
/*     */   
/*     */   public synchronized boolean consultar(String Campos, String Tablas, String Condicion) {
/* 202 */     this.Campo = "";
/*     */     try {
/* 204 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 205 */       this.stmt = this.cnx.createStatement();
/* 206 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 207 */       this.rset = this.stmt.executeQuery("SELECT " + Campos.toLowerCase() + " FROM " + Tablas.toLowerCase() + " " + Condicion);
/* 208 */       if (this.rset.next()) {
/* 209 */         this.Campo = this.rset.getString(1);
/* 210 */         return true;
/*     */       } 
/* 212 */       this.cnx.close();
/* 213 */     } catch (SQLException sqle) {
/* 214 */       int res = JOptionPane.showConfirmDialog(null, "<html>Ha ocurrido un problema al conectarse con el servidor de la base de datos<br>¿Deseas ver el código del error?</html>", "Error Crítico", 0, 3, this.ERROR);
/* 215 */       if (res == 0) {
/* 216 */         JPanel jPanel = new JPanel();
/*     */       } else {
/*     */         
/* 219 */         System.exit(0);
/*     */       } 
/* 221 */       JOptionPane.showMessageDialog(null, "Error:Consultar\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 224 */     return false;
/*     */   }
/*     */   
/*     */   public void insertar(String Datos) {
/*     */     try {
/* 229 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 230 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 232 */       this.stmt.executeUpdate(Datos);
/* 233 */       this.cnx.close();
/* 234 */       JOptionPane.showMessageDialog(null, "Los datos se han almacenado perfectamente", "Datos Guardados", 1, this.INFO);
/* 235 */     } catch (SQLException sqle) {
/* 236 */       JOptionPane.showMessageDialog(null, "Error Insertar:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String ultimoUsuario() {
/* 241 */     return this.variables[31].substring(14, this.variables[31].length());
/*     */   }
/*     */   
/*     */   public void inserSinMsj(String Datos) {
/*     */     try {
/* 246 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 247 */       this.stmt = this.cnx.createStatement();
/* 248 */       System.out.println(Datos);
/* 249 */       this.stmt.executeUpdate(Datos);
/* 250 */       this.cnx.close();
/*     */     }
/* 252 */     catch (SQLException sqle) {
/* 253 */       JOptionPane.showMessageDialog(null, "Error Insertar Sin Msj:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bitacora(String Datos) {
/*     */     try {
/* 259 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 260 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 262 */       this.stmt.executeUpdate(Datos);
/* 263 */       this.cnx.close();
/* 264 */     } catch (SQLException sqle) {
/* 265 */       JOptionPane.showMessageDialog(null, "Error en Bitacora:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized boolean buscar(String Campos, String Tablas, String Condicion, String Titulo, String Msj) {
/*     */     try {
/* 271 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 272 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 274 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 275 */       if (this.rset.next()) {
/* 276 */         JOptionPane.showMessageDialog(null, Msj, Titulo, 0, this.ERROR);
/* 277 */         return true;
/*     */       } 
/* 279 */       this.cnx.close();
/* 280 */     } catch (SQLException sqle) {
/*     */       
/* 282 */       JOptionPane.showMessageDialog(null, "Error buscar:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public String[][] buscarReg(int col, int reg, String Campos, String Tablas, String Condicion) {
/* 289 */     String[][] registros = new String[reg][col];
/* 290 */     int regi = 0;
/*     */     try {
/* 292 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 293 */       this.stmt = this.cnx.createStatement();
/* 294 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 295 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 296 */       while (this.rset.next()) {
/* 297 */         for (int i = 1; i <= col; i++) {
/* 298 */           registros[regi][i - 1] = this.rset.getString(i);
/*     */         }
/* 300 */         regi++;
/*     */       } 
/* 302 */       this.cnx.close();
/* 303 */     } catch (SQLException sqle) {
/* 304 */       JOptionPane.showMessageDialog(null, "Error buscarReg:\n" + String.valueOf(sqle), "Error en BuscarReg", 0);
/*     */     } 
/*     */     
/* 307 */     return registros;
/*     */   }
/*     */   
/*     */   public int dameIndice(ResultSet rset) throws SQLException {
/* 311 */     rset.last();
/* 312 */     int indice = rset.getRow();
/* 313 */     rset.beforeFirst();
/* 314 */     return indice;
/*     */   }
/*     */   
/*     */   public String[][] buscarDatos(int col, String Campos, String Tablas, String Condicion) {
/* 318 */     String[][] registros = null;
/* 319 */     int indice = 0;
/*     */     try {
/* 321 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 322 */       this.stmt = this.cnx.createStatement();
/* 323 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 324 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 325 */       registros = new String[dameIndice(this.rset)][col];
/* 326 */       int regi = 0;
/* 327 */       while (this.rset.next()) {
/* 328 */         for (int i = 1; i <= col; i++) {
/* 329 */           registros[regi][i - 1] = this.rset.getString(i);
/*     */         }
/* 331 */         regi++;
/*     */       } 
/* 333 */       this.cnx.close();
/* 334 */     } catch (SQLException sqle) {
/* 335 */       JOptionPane.showMessageDialog(null, "Error buscarReg:\n" + String.valueOf(sqle), "Error en BuscarReg", 0);
/*     */     } 
/*     */     
/* 338 */     return registros;
/*     */   }
/*     */   
/*     */   public String[][] buscarDatos(String Campos, String Tablas, String Condicion) {
/* 342 */     String[][] registros = null;
/* 343 */     int col = (Campos.split(",")).length;
/*     */     try {
/* 345 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 346 */       this.stmt = this.cnx.createStatement();
/* 347 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 348 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 349 */       registros = new String[dameIndice(this.rset)][col];
/* 350 */       int regi = 0;
/* 351 */       while (this.rset.next()) {
/* 352 */         for (int i = 1; i <= col; i++) {
/* 353 */           registros[regi][i - 1] = this.rset.getString(i);
/*     */         }
/* 355 */         regi++;
/*     */       } 
/* 357 */       this.cnx.close();
/* 358 */     } catch (SQLException sqle) {
/* 359 */       JOptionPane.showMessageDialog(null, "Error buscarReg:\n" + String.valueOf(sqle), "Error en BuscarReg", 0);
/*     */     } 
/*     */     
/* 362 */     return registros;
/*     */   }
/*     */   
/*     */   public String[] regresaReg(String Campos, String Tablas, String Condicion, int total) {
/* 366 */     String[] Registros = new String[total];
/*     */     try {
/* 368 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/*     */ 
/*     */ 
/*     */       
/* 372 */       this.stmt = this.cnx.createStatement();
/* 373 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 374 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas + " " + Condicion);
/* 375 */       while (this.rset.next()) {
/* 376 */         for (int i = 1; i <= total; i++) {
/* 377 */           Registros[i - 1] = this.rset.getString(i);
/*     */         }
/*     */       } 
/* 380 */       this.cnx.close();
/* 381 */     } catch (SQLException sqle) {
/* 382 */       JOptionPane.showMessageDialog(null, "Error Regresa Registro:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 385 */     return Registros;
/*     */   }
/*     */   
/*     */   public String[] regresaRegIndex(String Campos, String Tablas, String Condicion) {
/* 389 */     int col = (Campos.split(",")).length;
/* 390 */     String[] Registros = new String[col];
/*     */     try {
/* 392 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 393 */       System.out.println("SELECT " + Campos + " FROM " + Tablas + " " + Condicion + " LIMIT 1");
/* 394 */       this.stmt = this.cnx.createStatement();
/* 395 */       this.rset = this.stmt.executeQuery("SELECT " + Campos + " FROM " + Tablas.toLowerCase() + " " + Condicion + " LIMIT 1");
/* 396 */       while (this.rset.next()) {
/* 397 */         for (int i = 1; i <= col; i++) {
/* 398 */           Registros[i - 1] = this.rset.getString(i);
/*     */         }
/*     */       } 
/* 401 */       this.cnx.close();
/* 402 */     } catch (SQLException sqle) {
/* 403 */       JOptionPane.showMessageDialog(null, "Error Regresa Registro:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/* 405 */     return Registros;
/*     */   }
/*     */   
/*     */   public String[] regresaColIndex(String Campo, String Tablas, String Condicion) {
/* 409 */     String[] Registros = null;
/*     */     try {
/* 411 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 412 */       this.stmt = this.cnx.createStatement();
/* 413 */       System.out.println("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 414 */       this.rset = this.stmt.executeQuery("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 415 */       int cont = 0;
/* 416 */       Registros = new String[dameIndice(this.rset)];
/* 417 */       while (this.rset.next()) {
/* 418 */         Registros[cont] = this.rset.getString(1).toUpperCase();
/*     */         
/* 420 */         cont++;
/*     */       } 
/* 422 */       this.cnx.close();
/* 423 */     } catch (SQLException sqle) {
/* 424 */       JOptionPane.showMessageDialog(null, "Error:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 427 */     return Registros;
/*     */   }
/*     */   
/*     */   public String[] regresaCol(String Campo, String Tablas, String Condicion, int total) {
/* 431 */     String[] Registros = new String[total];
/*     */     try {
/* 433 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 434 */       this.stmt = this.cnx.createStatement();
/* 435 */       System.out.println("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 436 */       this.rset = this.stmt.executeQuery("SELECT " + Campo + " FROM " + Tablas + " " + Condicion);
/* 437 */       int cont = 0;
/* 438 */       while (this.rset.next()) {
/* 439 */         Registros[cont] = this.rset.getString(1).toUpperCase();
/*     */         
/* 441 */         cont++;
/*     */       } 
/* 443 */       this.cnx.close();
/* 444 */     } catch (SQLException sqle) {
/* 445 */       JOptionPane.showMessageDialog(null, "Error:\n" + String.valueOf(sqle), "Error en la consulta", 0);
/*     */     } 
/*     */     
/* 448 */     return Registros;
/*     */   }
/*     */   
/*     */   public void eliminar(String Tablas, String Condicion) {
/*     */     try {
/* 453 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 454 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 456 */       this.stmt.executeUpdate("Delete from " + Tablas + " " + Condicion);
/* 457 */       JOptionPane.showMessageDialog(null, "Los datos se han eliminado satisfactoriamente", "Datos Eliminados", 0, this.INFO);
/* 458 */       this.cnx.close();
/* 459 */     } catch (SQLException sqle) {
/* 460 */       JOptionPane.showMessageDialog(null, "Error Eliminar:\n" + String.valueOf(sqle), "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void eliminar2(String Tablas, String Condicion) {
/*     */     try {
/* 466 */       this.cnx = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.baseDatos, this.USUARIO, this.CONTRASEÑA);
/* 467 */       this.stmt = this.cnx.createStatement();
/*     */       
/* 469 */       this.stmt.executeUpdate("Delete from " + Tablas + " " + Condicion);
/* 470 */       this.cnx.close();
/* 471 */     } catch (SQLException sqle) {
/* 472 */       JOptionPane.showMessageDialog(null, "Error Eliminar2:\n" + String.valueOf(sqle), "Error", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String[] revisarCol2(JTable tabla) {
/* 477 */     String[] regresaReg = null;
/* 478 */     int cont = 0; int i;
/* 479 */     for (i = 0; i < tabla.getRowCount(); i++) {
/* 480 */       String col1 = tabla.getValueAt(i, 21).toString();
/* 481 */       String col2 = tabla.getValueAt(i, 24).toString();
/*     */       
/* 483 */       if (!col2.equals("") && 
/* 484 */         col1.contains("Pagada Al")) {
/* 485 */         cont++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 490 */     regresaReg = new String[cont];
/* 491 */     cont = 0;
/* 492 */     for (i = 0; i < tabla.getRowCount(); i++) {
/* 493 */       String col1 = tabla.getValueAt(i, 21).toString();
/* 494 */       String col2 = tabla.getValueAt(i, 24).toString();
/* 495 */       if (!col2.equals("") && 
/* 496 */         col1.contains("Pagada Al")) {
/* 497 */         regresaReg[cont] = tabla.getValueAt(i, 0).toString();
/*     */         
/* 499 */         cont++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 504 */     return regresaReg;
/*     */   }
/*     */   
/*     */   public String[] revisarCol(JTable tabla, String buscarValor, int indice, int indiceValor, int tipo) {
/* 508 */     String[] regresaReg = null;
/* 509 */     int cont = 0;
/* 510 */     if (tipo == 0) {
/*     */       int i;
/* 512 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 513 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 514 */         if (valorComparar.equals(buscarValor)) {
/* 515 */           cont++;
/*     */         }
/*     */       } 
/* 518 */       regresaReg = new String[cont];
/* 519 */       cont = 0;
/* 520 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 521 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 522 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 523 */         if (valorComparar.equals(buscarValor)) {
/* 524 */           regresaReg[cont] = valorIndice;
/* 525 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 529 */     if (tipo == 1) {
/*     */       int i;
/* 531 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 532 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 533 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 534 */         if (!valorComparar.equals(buscarValor)) {
/* 535 */           cont++;
/*     */         }
/*     */       } 
/* 538 */       regresaReg = new String[cont];
/*     */       
/* 540 */       cont = 0;
/* 541 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 542 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 543 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 544 */         if (!valorComparar.equals(buscarValor)) {
/* 545 */           regresaReg[cont] = valorIndice;
/* 546 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 551 */     if (tipo == 2) {
/*     */       int i;
/* 553 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 554 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 555 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 556 */         if (valorComparar.contains(buscarValor)) {
/* 557 */           cont++;
/*     */         }
/*     */       } 
/* 560 */       regresaReg = new String[cont];
/*     */       
/* 562 */       cont = 0;
/* 563 */       for (i = 0; i < tabla.getRowCount(); i++) {
/* 564 */         String valorIndice = String.valueOf(tabla.getValueAt(i, indice));
/* 565 */         String valorComparar = String.valueOf(tabla.getValueAt(i, indiceValor));
/* 566 */         if (valorComparar.contains(buscarValor)) {
/* 567 */           regresaReg[cont] = valorIndice;
/* 568 */           cont++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 572 */     return regresaReg;
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Consultas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */