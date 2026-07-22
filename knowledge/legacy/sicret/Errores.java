/*     */ package sicret;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class Errores extends JFrame implements Runnable {
/*   9 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  10 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*  11 */   Icon MODIFI = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/modificar.png")));
/*     */   boolean salir = false;
/*     */   Thread t;
/*  14 */   int seg = 0;
/*  15 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  16 */   Consultas con = new Consultas();
/*  17 */   String Datos = "";
/*     */   boolean MODAL = true;
/*  19 */   CeldaRender celda = new CeldaRender();
/*  20 */   SColores lc = new SColores();
/*  21 */   String[] errores = new String[] { "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037", "038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052", "053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063" };
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
/*  35 */   String[] TemaError = new String[] { "Campo Vacío", "Contraseña Incorrecta", "Nombre Incorrecto", "Caracteres Inválidos", "Usuario Existente", "Contraseñas Diferentes", "Tamaño Incorrecto", "Contraseña igual al Nombre", "Tamaño incorrecto", "Nombre Incorrecto", "Contraseña igual a Paterno", "Contraseña igual a  Materno", "Tamaño Incorrecto", "Caracteres Inválidos", "Error en el Número", "Tamaño del C.P. Incorrecto", "Caracteres Inválidos del C.P.", "Sólo letras en Ciudad", "Correo Erróneo", "Caracteres Reservados", "Fecha Incorrecta", "Tamaño Muy Pequeño", "Tamaño Muy Grande", "Tamaño Muy Grande", "Contraseña igual al Nombre", "Tamaño Incorrecto", "Caracteres Inválidos", "Demasiados Nombres", "Doble Espacio", "Nombres Muy Cortos", "Espacio De Más", "Número Muy Grande", "Número Muy Pequeño", "Inválido sólo Números", "Número Muy Grande", "Demasiados Caracteres", "Número Incorrecto", "Palabras Muy Cortas", "Pocas Palabras", "Caracteres Encontrados", "Número no Válido", "Tamaño Incorrecto", "Sólo Letras y Números", "Debe ser mayor de Edad", "Menos de 100 años", "Sólo Números", "Demasiados Nombres", "Clave Duplicada", "Número Mayor a 0", "Falta Información", "Muchos Dígitos", "Tamaño Incorrecto", "Tamaño Incorrecto", "Muchos Nombres", "Sólo Números", "Faltan Caracteres", "Caracteres de Más", "Faltan Caracteres", "Caracteres de Más", "Hora Inconrrecta", "Cantidad Larga", "Formato Incorrecto", "Número solo positivos" };
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
/*  49 */   String[] DescError = new String[] { "El campo esperaba un dato, es necesario que almacenes la información que se pide.", "La contraseña no coincide con el nombre de usuario, por favor verifica tu información.", "El nombre de usuario no se encontró en la base de datos.", "En el campo no puedes colocar caracteres inválidos. Puedes ocupar los siguientes elementos a,b,c...z - 0,1,2...9 y _", "El nombre de usuario ya se encuentra registrado en la base de datos.", "Verifica tu información, porque las contraseñas son diferentes.", "El número de caracteres debe ser como mínimo de 6 letras y máximo de 30.", "Necesitas poner otra contraseña. La contraseña no debe ser igual al nombre de usuario", "La longitud de la contraseña debe ser como mínimo 6 caracteres y maximo 30.", "Sólo puedes colocar letras en el campo, por favor verifica tu información.", "Necesitas poner otra contraseña. La contraseña no debe ser igual al apellido paterno", "Necesitas poner otra contraseña. La contraseña no debe ser igual al apellido materno", "Para que puedas agregar un comentario es necesario que teclees más de 6 caracteres.", "El campo no puede contener caracteres que no sean alfanuméricos como por ejemplo: _[]´+¡?)(&%$#!=!|@{}", "El formato para especificar el número es el siguiente:<br> Sólo Número - 9999 <br>Número y Letra - 244B <br>Sin Número - s/n <br>Otro - 234 bis", "El tamaño del código postal es obligatoriamente de 5 caracteres.", "El código postal debe contener obligatoriamente sólo números. <br>Ejemplo: 93600", "La ciudad sólo puede contener letras. Verifica que no hayas escrito números o caracteres especiales.", "Error al especificar el correo electrónico, verfica que contenga un @ antes del servidor y el tipo de correo como .com<br>Ejemplo: micorreo@servidor.com", "Puedes insertar todos los caracteres alfanuméricos y caracteres especiales excepto apóstrofe (') y comillas dobles (\").", "Necesitas colocar una fecha que sea menor a la fecha actual.", "Debes agregar una palabra mayor a 6 letras.", "El tamaño del campo no puede contener más de 300 caracteres.", "El tamaño del campo no puede contener más de 90 caracteres.", "Tu contraseña no puede ser igual a tu nombre personal. Por favor cambia tu información.", "No puedes colocar más de 5 dígitos en el campo.", "No puedes colocar caracteres en el campo, recuerda que sólo debes colocar números<br>Ejemplo: 00230", "Sólo puedes colocar 5 nombres en el campo.", "Verifica tu información porque tienes doble espacio en el campo.", "Necesitas colocar un nombre que sea mayor a dos letras.", "Verifica tu información porque tienes un espacio de más.", "No existen calles con nombre mayor a 999.", "No existen calles con nombre menor a 1.", "No puedes colocar sólo números en el campo, necesitas especificar palabras con números.", "El número que colocaste es demaciado grande por favor verificalo.", "No puedes colocar más de diez caracteres en el campo para especificar el número.", "No existe número menor a 1, Verifica tu información.", "Necesitas agregar por lo menos una palabra mayor a dos caracteres.", "Debes agregar una frase que contenga por lo menos dos palabras.", "Únicamente puedes colocar dígitos en este campo.", "Necesitas agregar por lo menos un dígito mayor a 0.", "Es necesario que coloques 5 dígitos.", "No puedes agregar caracteres especiales, recuerda que sólo puedes agregar letras con números.", "Para almacenar un nuevo empleado es necesario que el individuo ya tenga la mayoría de edad.", "Para almacenar una operador el individuo debe tener menos de 100 años.", "El campo esperaba un dato sólo númerico.", "Demasiados nombres para especificar el contenido del campo, sólo puedes almacenar máximo 10 nombres.", "La clave del operador ya ha sido asiganada anteriormente, cambiala por otro dato o verifica tu información.", "No puedes colocar número menores a 1.", "El campo esperaba algún tipo de información, por favor complétalo.", "No puedes colocar una cantidad con más de seis dígitos en este campo, por favor verifica tu información.", "El número de seguro social es obligatoriamente de once dígitos.", "El campo esperaba 10 caracteres, por favor verifica tu información.", "No puedes colocar más de 10 palabras en el campo para especificar los nombres o conceptos.", "Sólo puedes colocar números en este campo, verifcia tu información.", "No puedes colcoar menos de 16 caraceteres en este campo, verifica tu información", "No puedes colocar más de 16 caracteres en este campo, verifica tu información", "No puedes colocar menos de 8 caracteres en éste campo, verifica tu información", "No puedes colocar más de 8 caracteres en éste campo, verifica tu información", "Has insertado un formato incorrecto en el campo para especificar la hora. El formato es el siguiente: hh:mm", "Sólo puedes colocar una cantidad con 6 caracteres incluyendo el punto decimal, Verifica tu Información.", "El formato que colocaste no es correcto, necesitas colocar números con fracciones: Ejemplo 34.78", "El campo sólo puede acpetar números positivos, verifica tu información." }; JComponent componente;
/*     */   Border borde;
/*     */   Color color;
/*     */   private JDialog jDialog1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel48;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JScrollPane jScrollPane13;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public Errores(boolean modal) {
/*  68 */     this.MODAL = modal;
/*  69 */     initComponents();
/*     */     
/*  71 */     this.jScrollPane13.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  72 */     cargarMouse();
/*     */   }
/*     */   public void pasarModal(boolean MODAL) {
/*  75 */     MODAL = MODAL;
/*  76 */     this.jDialog1.setModal(this.MODAL);
/*     */   }
/*     */   public void start() {}
/*     */   
/*     */   public void run() {
/*  81 */     while (!this.salir) {
/*     */       try {
/*  83 */         Thread.currentThread(); Thread.sleep(1000L);
/*  84 */         this.seg++;
/*  85 */         this.salir = !this.jDialog1.isActive();
/*  86 */         if (this.salir || this.seg > 5) {
/*  87 */           this.jDialog1.setVisible(false);
/*  88 */           this.seg = 0;
/*  89 */           this.t.stop();
/*  90 */           this.salir = true;
/*     */         }
/*     */       
/*  93 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dameErrores(String error) {
/*  98 */     for (int i = 0; i < this.errores.length; i++) {
/*  99 */       if (this.errores[i].equals(error)) {
/* 100 */         this.jLabel9.setText("<html>Error " + error + ":</html>");
/* 101 */         this.jLabel7.setText(this.TemaError[i]);
/* 102 */         this.jLabel8.setText("<html><center>" + this.DescError[i] + "</center></html>");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/* 109 */     this.jDialog1 = new JDialog();
/* 110 */     this.jPanel1 = new JPanel();
/* 111 */     this.jLabel10 = new JLabel();
/* 112 */     this.jLabel7 = new JLabel();
/* 113 */     this.jLabel8 = new JLabel();
/* 114 */     this.jLabel9 = new JLabel();
/* 115 */     this.jPanel2 = new JPanel();
/* 116 */     this.jLabel1 = new JLabel();
/* 117 */     this.jPanel4 = new JPanel();
/* 118 */     this.jPanel3 = new JPanel();
/* 119 */     this.jLabel48 = new JLabel();
/* 120 */     this.jLabel2 = new JLabel();
/* 121 */     this.jScrollPane13 = new JScrollPane();
/* 122 */     this.rSTableMetro1 = new RSTableMetro();
/*     */     
/* 124 */     this.jDialog1.setAlwaysOnTop(true);
/* 125 */     this.jDialog1.setModal(this.MODAL);
/* 126 */     this.jDialog1.setUndecorated(true);
/* 127 */     this.jDialog1.setResizable(false);
/*     */     
/* 129 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/* 130 */     this.jPanel1.setLayout((LayoutManager)null);
/*     */     
/* 132 */     this.jLabel10.setHorizontalAlignment(0);
/* 133 */     this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 134 */     this.jLabel10.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 136 */             Errores.this.jLabel10MouseClicked(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 139 */             Errores.this.jLabel10MouseExited(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 142 */             Errores.this.jLabel10MouseEntered(evt);
/*     */           }
/*     */         });
/* 145 */     this.jPanel1.add(this.jLabel10);
/* 146 */     this.jLabel10.setBounds(310, 10, 20, 30);
/*     */     
/* 148 */     this.jLabel7.setFont(new Font("Tahoma", 0, 19));
/* 149 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 150 */     this.jLabel7.setHorizontalAlignment(2);
/* 151 */     this.jLabel7.setText("Contraseña Invalida");
/* 152 */     this.jPanel1.add(this.jLabel7);
/* 153 */     this.jLabel7.setBounds(90, 10, 250, 30);
/*     */     
/* 155 */     this.jLabel8.setFont(new Font("Cantarell", 0, 13));
/* 156 */     this.jLabel8.setForeground(this.lc.PRIMARIO1);
/* 157 */     this.jLabel8.setText("<html><center>Elemento sin completar, Aquí se muestra el error y la descripción puedes obsservar las letras</center></html>");
/* 158 */     this.jPanel1.add(this.jLabel8);
/* 159 */     this.jLabel8.setBounds(50, 40, 290, 120);
/*     */     
/* 161 */     this.jLabel9.setFont(new Font("Cantarell", 1, 11));
/* 162 */     this.jLabel9.setForeground(this.lc.SECUNDARIO2);
/* 163 */     this.jLabel9.setText("Error 001 :");
/* 164 */     this.jPanel1.add(this.jLabel9);
/* 165 */     this.jLabel9.setBounds(20, 17, 70, 20);
/*     */     
/* 167 */     this.jPanel2.setBackground(this.lc.PRIMARIO1);
/*     */     
/* 169 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 170 */     this.jPanel2.setLayout(jPanel2Layout);
/* 171 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 172 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 173 */         .addGap(0, 330, 32767));
/*     */     
/* 175 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 176 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 177 */         .addGap(0, 30, 32767));
/*     */ 
/*     */     
/* 180 */     this.jPanel1.add(this.jPanel2);
/* 181 */     this.jPanel2.setBounds(10, 10, 330, 30);
/*     */     
/* 183 */     this.jLabel1.setHorizontalAlignment(0);
/* 184 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/exclamation-mark.png")));
/* 185 */     this.jPanel1.add(this.jLabel1);
/* 186 */     this.jLabel1.setBounds(0, 40, 50, 120);
/*     */     
/* 188 */     this.jPanel4.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 190 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 191 */     this.jPanel4.setLayout(jPanel4Layout);
/* 192 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 193 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 194 */         .addGap(0, 330, 32767));
/*     */     
/* 196 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 197 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 198 */         .addGap(0, 4, 32767));
/*     */ 
/*     */     
/* 201 */     this.jPanel1.add(this.jPanel4);
/* 202 */     this.jPanel4.setBounds(10, 40, 330, 4);
/*     */     
/* 204 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 205 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 206 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */         .addComponent(this.jPanel1, -1, 346, 32767));
/*     */     
/* 210 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 211 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 212 */         .addComponent(this.jPanel1, -1, 161, 32767));
/*     */ 
/*     */     
/* 215 */     this.jLabel48.setFont(new Font("Cantarell", 0, 13));
/* 216 */     this.jLabel48.setText("Éstos son todos los datos recolectados:");
/*     */     
/* 218 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/* 219 */     this.jLabel2.setText("¿Deseas guardar la información?");
/*     */     
/* 221 */     this.rSTableMetro1.setForeground(this.lc.SECUNDARIO1);
/* 222 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 230 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 235 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 238 */     this.rSTableMetro1.setAltoHead(25);
/* 239 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 240 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 241 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 242 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.FONDOTABLA);
/* 243 */     this.rSTableMetro1.setColorFilasForeground1(this.lc.SECUNDARIO1);
/* 244 */     this.rSTableMetro1.setColorFilasForeground2(this.lc.SECUNDARIO1);
/* 245 */     this.rSTableMetro1.setColorSelBackgound(this.lc.PRIMARIO2);
/* 246 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 247 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 248 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 249 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 250 */     this.rSTableMetro1.setRowHeight(18);
/* 251 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 252 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 253 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 254 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 255 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 256 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 258 */             Errores.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 261 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 263 */             Errores.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 266 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 268 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 269 */     this.jPanel3.setLayout(jPanel3Layout);
/* 270 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 272 */         .addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 273 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 274 */           .addComponent(this.jLabel48, -2, 329, -2)
/* 275 */           .addGap(0, 23, 32767))
/* 276 */         .addComponent(this.jScrollPane13, -2, 0, 32767));
/*     */     
/* 278 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 279 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 280 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 281 */           .addContainerGap()
/* 282 */           .addComponent(this.jLabel48)
/* 283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */           .addComponent(this.jScrollPane13, -1, 350, 32767)
/* 285 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 286 */           .addComponent(this.jLabel2)));
/*     */ 
/*     */     
/* 289 */     setDefaultCloseOperation(3);
/*     */     
/* 291 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 292 */     getContentPane().setLayout(layout);
/* 293 */     layout.setHorizontalGroup(layout
/* 294 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 295 */         .addGap(0, 212, 32767));
/*     */     
/* 297 */     layout.setVerticalGroup(layout
/* 298 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 299 */         .addGap(0, 118, 32767));
/*     */ 
/*     */     
/* 302 */     pack();
/*     */   }
/*     */   public void cargarError(JComponent comp, String error) {
/* 305 */     this.salir = false;
/* 306 */     this.seg = 0;
/* 307 */     this.componente = comp;
/* 308 */     dameErrores(error);
/* 309 */     this.borde = comp.getBorder();
/* 310 */     this.color = comp.getBackground();
/*     */     
/* 312 */     comp.setBackground(new Color(255, 51, 51));
/* 313 */     this.jDialog1.setSize(346, 162);
/* 314 */     Dimension di = comp.getSize();
/* 315 */     Point p = comp.getLocationOnScreen();
/* 316 */     this.jDialog1.setLocation(p.x + di.width + 20, p.y);
/* 317 */     this.t = new Thread(this);
/* 318 */     this.t.start();
/*     */     
/* 320 */     this.jDialog1.setAlwaysOnTop(true);
/* 321 */     this.jDialog1.setAutoRequestFocus(true);
/* 322 */     this.jDialog1.setVisible(true);
/* 323 */     getToolkit().beep();
/*     */   }
/*     */   private void jLabel10MouseEntered(MouseEvent evt) {
/* 326 */     this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*     */   }
/*     */   private void jLabel10MouseExited(MouseEvent evt) {
/* 329 */     this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*     */   }
/*     */   private void jLabel10MouseClicked(MouseEvent evt) {
/* 332 */     this.salir = true;
/* 333 */     this.seg = 0;
/* 334 */     this.t.stop();
/* 335 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   public int cargarDatos(String[] cam, String[] in) {
/* 346 */     String[] campos = cam;
/* 347 */     String[] info = in;
/* 348 */     int ind = campos.length;
/* 349 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[])new String[] { "Datos", "Información" }, ind)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 354 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 358 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 361 */     for (int i = 0; i < campos.length; i++) {
/* 362 */       this.rSTableMetro1.setValueAt(campos[i], i, 0);
/* 363 */       this.rSTableMetro1.setValueAt(info[i], i, 1);
/*     */     } 
/* 365 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMinWidth(100);
/* 366 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(100);
/*     */     
/* 368 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 369 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 370 */     this.rSTableMetro1.setGridColor(new Color(200, 200, 200));
/* 371 */     this.rSTableMetro1.setSelectionMode(0);
/*     */     
/* 373 */     int res = JOptionPane.showConfirmDialog(this, this.jPanel3, "Resumen de la Información", 0, 3, this.GUARDAR);
/* 374 */     return res;
/*     */   }
/*     */   public int cargarDatos2(String[] cam, String[] in) {
/* 377 */     String[] campos = cam;
/* 378 */     String[] info = in;
/* 379 */     int ind = campos.length;
/* 380 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[])new String[] { "Datos", "Información" }, ind)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 385 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 389 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 392 */     for (int i = 0; i < campos.length; i++) {
/* 393 */       this.rSTableMetro1.setValueAt(campos[i], i, 0);
/* 394 */       this.rSTableMetro1.setValueAt(info[i], i, 1);
/*     */     } 
/* 396 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMinWidth(100);
/* 397 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(100);
/*     */     
/* 399 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 400 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 401 */     this.rSTableMetro1.setGridColor(new Color(200, 200, 200));
/* 402 */     this.rSTableMetro1.setSelectionMode(0);
/*     */     
/* 404 */     int res = JOptionPane.showConfirmDialog(this, this.jPanel3, "Resumen de la Información", 0, 3, this.MODIFI);
/* 405 */     return res;
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 409 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 410 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 411 */       setCursor(micursor);
/* 412 */       this.jDialog1.setCursor(micursor);
/* 413 */       this.rSTableMetro1.setCursor(micursor);
/*     */     }
/* 415 */     catch (Exception e) {
/* 416 */       JOptionPane.showMessageDialog(null, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 421 */     int otro = -1;
/* 422 */     int[] indices = new int[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 425 */       setEnabled((table == null || table.isEnabled()));
/* 426 */       if (row % 2 == 0) {
/* 427 */         setBackground(Errores.this.lc.FONDOTABLA);
/*     */       } else {
/* 429 */         setBackground((Color)null);
/*     */       } 
/* 431 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 432 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Errores.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */