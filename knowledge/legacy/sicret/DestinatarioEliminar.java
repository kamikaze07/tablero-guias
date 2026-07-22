/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class DestinatarioEliminar extends JPanel {
/*     */   Border borde;
/*  25 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  26 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  27 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  28 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  29 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*     */   String USUARIO;
/*  31 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*     */   AltaOperador operador;
/*  35 */   int contador = 0;
/*     */   JFrame padre;
/*     */   EscribirReporte esc;
/*  38 */   CeldaRender celda = new CeldaRender();
/*  39 */   MensajePop mensajeTry = null;
/*  40 */   SColores lc = new SColores();
/*  41 */   PlaceHolder placeHolder = null;
/*  42 */   String holderClave = "CLAVE"; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel53; private JLabel jLabel55; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JScrollPane jScrollPane29; private JTextField jTextField1; private MaterialButton materialButton1; private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public DestinatarioEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  45 */     this.mensajeTry = mensajeTry;
/*  46 */     initComponents();
/*  47 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  48 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  49 */     this.rSTableMetro1.setCursor(micursor);
/*  50 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  51 */     this.padre = padre;
/*  52 */     this.fichas = fichas;
/*  53 */     colorear();
/*  54 */     this.USUARIO = USUARIO;
/*  55 */     panelito.setViewportView(this);
/*  56 */     this.panel = panelito;
/*  57 */     llenarCombo();
/*  58 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  63 */     this.jPanel2 = new JPanel();
/*  64 */     this.jPanel3 = new JPanel();
/*  65 */     this.jLabel55 = new JLabel();
/*  66 */     this.jPanel17 = new JPanel();
/*  67 */     this.jTextField1 = new JTextField();
/*  68 */     this.jComboBox1 = new JComboBox();
/*  69 */     this.jComboBox2 = new JComboBox();
/*  70 */     this.jPanel4 = new JPanel();
/*  71 */     this.jScrollPane29 = new JScrollPane();
/*  72 */     this.rSTableMetro1 = new RSTableMetro();
/*  73 */     this.jLabel48 = new JLabel();
/*  74 */     this.jLabel53 = new JLabel();
/*  75 */     this.materialButton1 = new MaterialButton();
/*  76 */     this.jCheckBox1 = new JCheckBox();
/*     */     
/*  78 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/*  80 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/*  82 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/*  83 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/*  84 */     this.jLabel55.setHorizontalAlignment(0);
/*  85 */     this.jLabel55.setText("Eliminar Destinos");
/*     */     
/*  87 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  88 */     this.jPanel3.setLayout(jPanel3Layout);
/*  89 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  90 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  91 */         .addComponent(this.jLabel55, -1, 821, 32767));
/*     */     
/*  93 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  94 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  95 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  96 */           .addContainerGap()
/*  97 */           .addComponent(this.jLabel55)
/*  98 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 101 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 103 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 105 */             DestinatarioEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 109 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 110 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 111 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 113 */             DestinatarioEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 117 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 118 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 119 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 121 */             DestinatarioEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 125 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 126 */     this.jPanel17.setLayout(jPanel17Layout);
/* 127 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 130 */           .addContainerGap()
/* 131 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 133 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 134 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 135 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 136 */           .addContainerGap(-1, 32767)));
/*     */     
/* 138 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 139 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 140 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 141 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 142 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 143 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 146 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 148 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 156 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 161 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 164 */     this.rSTableMetro1.setAltoHead(40);
/* 165 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 166 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 167 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 168 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 169 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 170 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 171 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 172 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 173 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 174 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 175 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 176 */     this.rSTableMetro1.setRowHeight(18);
/* 177 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 178 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 179 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 180 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 181 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 182 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 184 */             DestinatarioEliminar.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 187 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 189 */             DestinatarioEliminar.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 192 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 194 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 195 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 196 */     this.jLabel48.setHorizontalAlignment(2);
/* 197 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 199 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 200 */     this.jLabel53.setForeground(this.lc.SECUNDARIO1);
/* 201 */     this.jLabel53.setHorizontalAlignment(4);
/* 202 */     this.jLabel53.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar'");
/*     */     
/* 204 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 205 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 206 */     this.materialButton1.setMnemonic('E');
/* 207 */     this.materialButton1.setText("Eliminar");
/* 208 */     this.materialButton1.setToolTipText("Eliminar (Alt+E)");
/* 209 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 210 */     this.materialButton1.setHorizontalTextPosition(0);
/* 211 */     this.materialButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 213 */             DestinatarioEliminar.this.materialButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 217 */     this.jCheckBox1.setFont(new Font("Cantarell", 0, 11));
/* 218 */     this.jCheckBox1.setText("Seleccionar Todos");
/* 219 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 221 */             DestinatarioEliminar.this.jCheckBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 225 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 226 */     this.jPanel4.setLayout(jPanel4Layout);
/* 227 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 229 */         .addComponent(this.jScrollPane29, -1, 821, 32767)
/* 230 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 231 */           .addContainerGap()
/* 232 */           .addComponent(this.jCheckBox1, -2, 129, -2)
/* 233 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 234 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 235 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 236 */           .addComponent(this.jLabel53, -2, 304, -2)
/* 237 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 238 */           .addComponent((Component)this.materialButton1, -2, 150, -2)));
/*     */     
/* 240 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 241 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 242 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 243 */           .addComponent(this.jScrollPane29, -1, 271, 32767)
/* 244 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 245 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 246 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 247 */               .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 248 */                 .addComponent(this.jLabel53)
/* 249 */                 .addContainerGap())
/* 250 */               .addComponent((Component)this.materialButton1, GroupLayout.Alignment.TRAILING, -2, 38, -2))
/* 251 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 252 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 253 */                 .addComponent(this.jLabel48)
/* 254 */                 .addComponent(this.jCheckBox1))
/* 255 */               .addContainerGap()))));
/*     */ 
/*     */     
/* 258 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 259 */     this.jPanel2.setLayout(jPanel2Layout);
/* 260 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 261 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 262 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 263 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 264 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 266 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 267 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 268 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 269 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 270 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 271 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 273 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 276 */     GroupLayout layout = new GroupLayout(this);
/* 277 */     setLayout(layout);
/* 278 */     layout.setHorizontalGroup(layout
/* 279 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 280 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 282 */     layout.setVerticalGroup(layout
/* 283 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 284 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 289 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 293 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 297 */     consultar();
/*     */   }
/*     */   
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 301 */     if (this.jCheckBox1.isSelected() == true) {
/* 302 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 303 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(true), i, 0);
/*     */       }
/*     */     } else {
/* 306 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 307 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(false), i, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 313 */     this.materialButton1.setEnabled(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 321 */     String ind = "";
/* 322 */     int contar = 0;
/* 323 */     this.contador = 0;
/* 324 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 325 */       String val = String.valueOf(this.rSTableMetro1.getValueAt(i, 0));
/* 326 */       if (val.equals("true")) {
/* 327 */         contar++;
/*     */       }
/*     */     } 
/* 330 */     if (contar == 0) {
/* 331 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar la empresa", "Selecciona Una Empresa", 0, this.INFO);
/* 332 */     } else if (contar == 1) {
/* 333 */       int doc = 0;
/* 334 */       for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/* 335 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/* 336 */         if (val.equals("true")) {
/* 337 */           String str = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/* 338 */           this.encontrado = this.con.consultar("num_guia", "llamadas_historicas", "where clave_desti = " + str);
/* 339 */           if (this.encontrado) {
/* 340 */             JOptionPane.showMessageDialog(this.padre, "No puedes eliminar este confinamiento porque tiene datos refenciales a éste.", "Datos Referenciales", 0, this.ADVER);
/*     */             return;
/*     */           } 
/* 343 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 347 */       String valor = "<html><b>Clave de la empresa: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "<br><b>Nombre: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 3)) + "<br></html>";
/* 348 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Empresa Destino", 0, 3, this.ELIMINAR);
/* 349 */       if (res == 0) {
/* 350 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/* 351 */         String[] reg = this.con.regresaReg("clave_desti,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado,monto,letra", "emp_destinataria,estados", "where emp_destinataria.id_edo = estados.id_edo and clave_desti = " + val, 11);
/* 352 */         this.con.eliminar("emp_destinataria", "where clave_desti=" + val);
/* 353 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el empresa destino " + val + " definitivamente.','Clave Empresa: " + val + "\nNombre de la empresa: " + reg[1] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[9] + "\nRFC: " + reg[7] + "\nTeléfono: " + reg[8] + "\nMonto: " + reg[9] + "\nC/Letra" + reg[10] + "')");
/* 354 */         this.mensajeTry.guardarConf("Se ha eliminado un destino-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Destino de Baja", "ERROR", "Destinos");
/* 355 */         consultar();
/*     */       } 
/*     */     } else {
/*     */       
/* 359 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Empresas Destino", 0, 3, this.ELIMINAR);
/* 360 */       if (res == 0) {
/* 361 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/* 362 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/* 363 */           if (val.equals("true")) {
/* 364 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/* 365 */             String[] reg = this.con.regresaReg("clave_desti,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado,monto,letra", "emp_destinataria,estados", "where emp_destinataria.id_edo = estados.id_edo and clave_desti = " + valor, 11);
/* 366 */             this.contador++;
/* 367 */             this.encontrado = this.con.consultar("num_guia", "llamadas_historicas", "where clave_desti = " + valor);
/* 368 */             if (this.encontrado) {
/* 369 */               JOptionPane.showMessageDialog(this.padre, "No puedes eliminar este confinamiento porque tiene datos refenciales a éste.\n<html><b>CLave: " + valor + " </b></html>", "Datos Referenciales", 0, this.ADVER);
/*     */               return;
/*     */             } 
/* 372 */             this.con.eliminar2("emp_destinataria", "where clave_desti=" + valor);
/* 373 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el empresa destino " + val + " definitivamente.','Clave Empresa: " + val + "\nNombre de la empresa: " + reg[1] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[9] + "\nRFC: " + reg[7] + "\nTeléfono: " + reg[8] + "\nMonto: " + reg[9] + "\nC/Letra" + reg[10] + "')");
/* 374 */             this.mensajeTry.guardarConf("Se ha eliminado un destino-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Destino de Baja", "ERROR", "Destinos");
/*     */           } 
/*     */         } 
/*     */         
/* 378 */         consultar();
/* 379 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + this.contador + " empresas.", "Empresas Eliminadas", 0, this.INFO);
/*     */       } 
/*     */     } 
/* 382 */     llenarCombo();
/*     */   }
/*     */   public void colorear() {
/* 385 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 387 */             DestinatarioEliminar.this.jTextGanado(DestinatarioEliminar.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 391 */             DestinatarioEliminar.this.jTextPerdido(DestinatarioEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 394 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 396 */             DestinatarioEliminar.this.jTextGanado(DestinatarioEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 400 */             DestinatarioEliminar.this.jTextPerdido(DestinatarioEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 403 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 405 */             DestinatarioEliminar.this.jTextGanado(DestinatarioEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 409 */             DestinatarioEliminar.this.jTextPerdido(DestinatarioEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 415 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 419 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void cargarMouse() {
/*     */     try {
/* 424 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 425 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 426 */       setCursor(micursor);
/* 427 */     } catch (Exception e) {
/* 428 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 433 */     this.jCheckBox1.setSelected(false);
/* 434 */     String clave = "";
/* 435 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 436 */       clave = this.jTextField1.getText();
/*     */     }
/* 438 */     String nombre = "";
/* 439 */     String estados = "";
/* 440 */     String id_edo = "";
/* 441 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 442 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 444 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 445 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 446 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 447 */       id_edo = this.con.Campo;
/*     */     } 
/* 449 */     this.encontrado = this.con.consultar("count(clave_desti)", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0");
/* 450 */     int totreg = Integer.parseInt(this.con.Campo);
/* 451 */     this.encontrado = this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 452 */     String tot = this.con.Campo;
/* 453 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 454 */           .buscarReg(14, totreg, "clave_desti,empresa,calle,num,col,cp,ciudad,estado,rfc,telefono,monto,letra,semarnat,ruta", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Destino", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "Monto", "Cantidad con Letra", "Aut. Semarnat", "RUTA", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 459 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 464 */             return this.types[columnIndex];
/*     */           }
/* 466 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 471 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 474 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 475 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 476 */     eliminarColumna(3, 2, "Número");
/* 477 */     eliminarColumna(3, 2, "Colonia");
/* 478 */     eliminarColumna(3, 2, "CP");
/* 479 */     eliminarColumna(3, 2, "Ciudad");
/* 480 */     eliminarColumna(3, 2, "Estado");
/*     */ 
/*     */     
/* 483 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 484 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 485 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 486 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(70);
/* 487 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 488 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(70);
/* 489 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 490 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(70);
/* 491 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(260);
/* 492 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(260);
/* 493 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(190);
/* 494 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(190);
/* 495 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(30);
/* 496 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(30);
/* 497 */     this.rSTableMetro1.setSelectionMode(0);
/* 498 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 499 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 500 */     this.rSTableMetro1.getColumnModel().moveColumn(9, 0);
/*     */     
/* 502 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 503 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 504 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 505 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 506 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 507 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 508 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 509 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 510 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 511 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 515 */     int cont = this.rSTableMetro1.getRowCount();
/* 516 */     String[] registros = new String[cont]; int i;
/* 517 */     for (i = 0; i < cont; i++) {
/* 518 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 520 */     for (i = 0; i < cont; i++) {
/* 521 */       registros[i] = registros[i] + " " + registros[i];
/* 522 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 524 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 525 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   
/*     */   public void destinatario(String usu) {
/* 529 */     this.USUARIO = usu;
/* 530 */     this.panel.setViewportView(this);
/* 531 */     llenarCombo();
/* 532 */     consultar();
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 536 */     this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 537 */     String[] depa = this.con.regresaCol("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 538 */     this.jComboBox1.removeAllItems();
/* 539 */     this.jComboBox1.addItem("DESTINOS");
/* 540 */     for (int i = 0; i < depa.length; i++)
/* 541 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer
/*     */   {
/* 547 */     int otro = -1;
/* 548 */     int[] indices = new int[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 551 */       setEnabled((table == null || table.isEnabled()));
/* 552 */       if (comparar(row)) {
/* 553 */         setBackground(Color.red);
/* 554 */       } else if (row % 2 == 0) {
/* 555 */         setBackground(DestinatarioEliminar.this.lc.FONDOTABLA);
/*     */       } else {
/* 557 */         setBackground((Color)null);
/*     */       } 
/* 559 */       setForeground(DestinatarioEliminar.this.lc.SECUNDARIO1);
/* 560 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 561 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(int[] ind) {
/* 565 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(int reg) {
/* 569 */       for (int i = 0; i < this.indices.length; i++) {
/* 570 */         if (this.indices[i] == reg) {
/* 571 */           return true;
/*     */         }
/*     */       } 
/* 574 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DestinatarioEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */