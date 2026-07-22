/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class GeneradoraModifi extends JPanel {
/*     */   Border borde;
/*  25 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*     */   String USUARIO;
/*  27 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  30 */   GeneradoraAlta generadora = null;
/*     */   JFrame padre;
/*  32 */   CeldaRender celda = new CeldaRender();
/*  33 */   MensajePop mensajeTry = null;
/*  34 */   SColores lc = new SColores();
/*  35 */   Cursor micursor1 = null;
/*  36 */   PlaceHolder placeHolder = null;
/*  37 */   String holderClave = "CLAVE"; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JScrollPane jScrollPane29; private JTextField jTextField1; private MaterialButton materialButton17; private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public GeneradoraModifi(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  40 */     this.mensajeTry = mensajeTry;
/*  41 */     initComponents();
/*  42 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  43 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  44 */     this.rSTableMetro1.setCursor(micursor);
/*  45 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  46 */     this.padre = padre;
/*  47 */     this.fichas = fichas;
/*  48 */     colorear();
/*  49 */     this.USUARIO = USUARIO;
/*  50 */     panelito.setViewportView(this);
/*  51 */     this.panel = panelito;
/*  52 */     llenarCombo();
/*  53 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  58 */     this.jPanel1 = new JPanel();
/*  59 */     this.jPanel5 = new JPanel();
/*  60 */     this.jButton5 = new JButton();
/*  61 */     this.jPanel2 = new JPanel();
/*  62 */     this.jPanel3 = new JPanel();
/*  63 */     this.jLabel54 = new JLabel();
/*  64 */     this.jPanel17 = new JPanel();
/*  65 */     this.jTextField1 = new JTextField();
/*  66 */     this.jComboBox1 = new JComboBox();
/*  67 */     this.jComboBox2 = new JComboBox();
/*  68 */     this.jPanel4 = new JPanel();
/*  69 */     this.jScrollPane29 = new JScrollPane();
/*  70 */     this.rSTableMetro1 = new RSTableMetro();
/*  71 */     this.jLabel48 = new JLabel();
/*  72 */     this.jLabel52 = new JLabel();
/*  73 */     this.materialButton17 = new MaterialButton();
/*     */     
/*  75 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  76 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  78 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  79 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  81 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  82 */     this.jPanel5.setLayout(jPanel5Layout);
/*  83 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  84 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  85 */         .addGap(0, 453, 32767));
/*     */     
/*  87 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  88 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  89 */         .addGap(0, 107, 32767));
/*     */ 
/*     */     
/*  92 */     this.jButton5.setMnemonic('M');
/*  93 */     this.jButton5.setText("Modificar");
/*  94 */     this.jButton5.setToolTipText("Modificar (Alt+M)");
/*  95 */     this.jButton5.setEnabled(false);
/*  96 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  98 */             GeneradoraModifi.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 102 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 103 */     this.jPanel1.setLayout(jPanel1Layout);
/* 104 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 106 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 107 */           .addContainerGap()
/* 108 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 109 */           .addContainerGap())
/* 110 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 111 */           .addGroup(jPanel1Layout.createSequentialGroup()
/* 112 */             .addGap(190, 190, 190)
/* 113 */             .addComponent(this.jButton5)
/* 114 */             .addContainerGap(190, 32767))));
/*     */     
/* 116 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 117 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 118 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 119 */           .addGap(0, 197, 32767)
/* 120 */           .addComponent(this.jPanel5, -2, -1, -2))
/* 121 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 122 */           .addGroup(jPanel1Layout.createSequentialGroup()
/* 123 */             .addGap(147, 147, 147)
/* 124 */             .addComponent(this.jButton5)
/* 125 */             .addContainerGap(147, 32767))));
/*     */ 
/*     */     
/* 128 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 130 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 132 */     this.jLabel54.setFont(new Font("Cantarell", 1, 22));
/* 133 */     this.jLabel54.setForeground(this.lc.PRIMARIO2);
/* 134 */     this.jLabel54.setHorizontalAlignment(0);
/* 135 */     this.jLabel54.setText("Modificar Clientes");
/*     */     
/* 137 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 138 */     this.jPanel3.setLayout(jPanel3Layout);
/* 139 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 141 */         .addComponent(this.jLabel54, -1, -1, 32767));
/*     */     
/* 143 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 145 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 146 */           .addContainerGap()
/* 147 */           .addComponent(this.jLabel54)
/* 148 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 151 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 153 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 155 */             GeneradoraModifi.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 159 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 160 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 161 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 163 */             GeneradoraModifi.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 167 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 168 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 169 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 171 */             GeneradoraModifi.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 175 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 176 */     this.jPanel17.setLayout(jPanel17Layout);
/* 177 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 179 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 180 */           .addContainerGap()
/* 181 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 182 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 183 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 185 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 186 */           .addContainerGap(-1, 32767)));
/*     */     
/* 188 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 190 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 191 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 192 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 193 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 196 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 198 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 206 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 211 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 214 */     this.rSTableMetro1.setAltoHead(40);
/* 215 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 216 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 217 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 218 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 219 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 220 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 221 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 222 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 223 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 224 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 225 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 226 */     this.rSTableMetro1.setRowHeight(18);
/* 227 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 228 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 229 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 230 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 231 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 232 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 234 */             GeneradoraModifi.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 237 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 239 */             GeneradoraModifi.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 242 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 244 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 245 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 246 */     this.jLabel48.setHorizontalAlignment(2);
/* 247 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 249 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/* 250 */     this.jLabel52.setForeground(this.lc.SECUNDARIO1);
/* 251 */     this.jLabel52.setHorizontalAlignment(4);
/* 252 */     this.jLabel52.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 254 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/* 255 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 256 */     this.materialButton17.setMnemonic('M');
/* 257 */     this.materialButton17.setText("Modificar");
/* 258 */     this.materialButton17.setToolTipText("Modificar (Alt+M)");
/* 259 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 260 */     this.materialButton17.setHorizontalTextPosition(0);
/* 261 */     this.materialButton17.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 263 */             GeneradoraModifi.this.materialButton17ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 267 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 268 */     this.jPanel4.setLayout(jPanel4Layout);
/* 269 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 270 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 271 */         .addComponent(this.jScrollPane29)
/* 272 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 273 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 274 */           .addGap(70, 70, 70)
/* 275 */           .addComponent(this.jLabel52, -1, 462, 32767)
/* 276 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 277 */           .addComponent((Component)this.materialButton17, -2, 150, -2)));
/*     */     
/* 279 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 280 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 281 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 282 */           .addComponent(this.jScrollPane29, -1, 249, 32767)
/* 283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 285 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 286 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 287 */                 .addComponent(this.jLabel48)
/* 288 */                 .addComponent(this.jLabel52))
/* 289 */               .addContainerGap())
/* 290 */             .addComponent((Component)this.materialButton17, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*     */ 
/*     */     
/* 293 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 294 */     this.jPanel2.setLayout(jPanel2Layout);
/* 295 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 296 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 297 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 298 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 299 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 301 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 303 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 304 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 305 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 306 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 308 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 311 */     GroupLayout layout = new GroupLayout(this);
/* 312 */     setLayout(layout);
/* 313 */     layout.setHorizontalGroup(layout
/* 314 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 315 */         .addGroup(layout.createSequentialGroup()
/* 316 */           .addComponent(this.jPanel2, -1, -1, 32767)
/* 317 */           .addGap(0, 0, 0)));
/*     */     
/* 319 */     layout.setVerticalGroup(layout
/* 320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 321 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 326 */     consultar();
/*     */   }
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 329 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 337 */     consultar();
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 341 */     this.materialButton17.setEnabled(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 349 */     setCursor(new Cursor(3));
/* 350 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 351 */     if (this.fichas.getTabCount() > 1) {
/* 352 */       this.fichas.remove(1);
/*     */     }
/* 354 */     if (this.generadora == null) {
/*     */       
/* 356 */       this.generadora.pasarInd(this.rSTableMetro1.getSelectedRow());
/*     */     } else {
/* 358 */       this.generadora.generadora(this.USUARIO, num);
/* 359 */       this.generadora.pasarInd(this.rSTableMetro1.getSelectedRow());
/*     */     } 
/* 361 */     this.fichas.setSelectedIndex(1);
/* 362 */     cargarMouse();
/*     */   }
/*     */   public void colorear() {
/* 365 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 367 */             GeneradoraModifi.this.jTextGanado(GeneradoraModifi.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 371 */             GeneradoraModifi.this.jTextPerdido(GeneradoraModifi.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 374 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 376 */             GeneradoraModifi.this.jTextGanado(GeneradoraModifi.this.jComboBox1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 380 */             GeneradoraModifi.this.jTextPerdido(GeneradoraModifi.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 383 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 385 */             GeneradoraModifi.this.jTextGanado(GeneradoraModifi.this.jComboBox2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 389 */             GeneradoraModifi.this.jTextPerdido(GeneradoraModifi.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 395 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 399 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void cargarMouse() {
/*     */     try {
/* 404 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 405 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 406 */       setCursor(micursor);
/* 407 */     } catch (Exception e) {
/* 408 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 413 */     this.materialButton17.setEnabled(false);
/* 414 */     String clave = "";
/* 415 */     String nombre = "";
/* 416 */     String estados = "";
/* 417 */     String id_edo = "";
/* 418 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 419 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/* 420 */       if (nombre.equals("null")) {
/* 421 */         nombre = "";
/*     */       }
/*     */     } 
/* 424 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 425 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 426 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 427 */       id_edo = this.con.Campo;
/*     */     } 
/* 429 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 430 */       clave = this.jTextField1.getText();
/*     */     }
/* 432 */     this.encontrado = this.con.consultar("count(clave_gene)", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0");
/* 433 */     int totreg = Integer.parseInt(this.con.Campo);
/* 434 */     this.encontrado = this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 435 */     String tot = this.con.Campo;
/* 436 */     this.jLabel48.setText(" Registros encontrados " + totreg + " de " + tot);
/* 437 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 438 */           .buscarReg(13, totreg, "clave_gene,empresa,nombre_corto,Iniciales,calle,num,col,cp,ciudad,estado,rfc,telefono,activo", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Origen", "Nombre Corto", "Iniciales", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "Estatus" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 443 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 448 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 451 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 452 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 454 */             GeneradoraModifi.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 457 */     eliminarColumna(5, 4, "Número");
/* 458 */     eliminarColumna(5, 4, "Colonia");
/* 459 */     eliminarColumna(5, 4, "CP");
/* 460 */     eliminarColumna(5, 4, "Ciudad");
/* 461 */     eliminarColumna(5, 4, "Estado");
/*     */ 
/*     */     
/* 464 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 465 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 466 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(310);
/* 467 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(310);
/* 468 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(130);
/* 469 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(130);
/* 470 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(60);
/* 471 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(60);
/* 472 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 473 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(70);
/* 474 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 475 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(70);
/* 476 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(100);
/* 477 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(100);
/* 478 */     this.materialButton17.setEnabled(false);
/* 479 */     this.rSTableMetro1.setSelectionMode(0);
/* 480 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 481 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 483 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 484 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 485 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 486 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 487 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 488 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 489 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 490 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 491 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 495 */     int cont = this.rSTableMetro1.getRowCount();
/* 496 */     String[] registros = new String[cont]; int i;
/* 497 */     for (i = 0; i < cont; i++) {
/* 498 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 500 */     for (i = 0; i < cont; i++) {
/* 501 */       registros[i] = registros[i] + " " + registros[i];
/* 502 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 504 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 505 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   
/*     */   public void generadora(String usu) {
/* 509 */     this.USUARIO = usu;
/* 510 */     this.panel.setViewportView(this);
/* 511 */     llenarCombo();
/* 512 */     consultar();
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 516 */     this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 517 */     String[] depa = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 518 */     this.jComboBox1.removeAllItems();
/* 519 */     this.jComboBox1.addItem("CLIENTES");
/* 520 */     for (int i = 0; i < depa.length; i++)
/* 521 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer
/*     */   {
/* 527 */     int otro = -1;
/* 528 */     int[] indices = new int[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 531 */       setEnabled((table == null || table.isEnabled()));
/* 532 */       if (comparar(row)) {
/* 533 */         setBackground(Color.red);
/* 534 */       } else if (row % 2 == 0) {
/* 535 */         setBackground(GeneradoraModifi.this.lc.FONDOTABLA);
/*     */       } else {
/* 537 */         setBackground((Color)null);
/*     */       } 
/* 539 */       setForeground(GeneradoraModifi.this.lc.SECUNDARIO1);
/* 540 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 541 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(int[] ind) {
/* 545 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(int reg) {
/* 549 */       for (int i = 0; i < this.indices.length; i++) {
/* 550 */         if (this.indices[i] == reg) {
/* 551 */           return true;
/*     */         }
/*     */       } 
/* 554 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GeneradoraModifi.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */