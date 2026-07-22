/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
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
/*     */ public class DestinatarioModifi extends JPanel {
/*     */   Border borde;
/*  25 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*     */   String USUARIO;
/*  27 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  30 */   DestinatarioAlta destinatario = null;
/*     */   JFrame padre;
/*  32 */   CeldaRender celda = new CeldaRender();
/*  33 */   MensajePop mensajeTry = null;
/*  34 */   SColores lc = new SColores();
/*  35 */   PlaceHolder placeHolder = null;
/*  36 */   String holderClave = "CLAVE"; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JScrollPane jScrollPane29; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private MaterialButton materialButton1; private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public DestinatarioModifi(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  39 */     this.mensajeTry = mensajeTry;
/*  40 */     initComponents();
/*  41 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  42 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  43 */     this.rSTableMetro1.setCursor(micursor);
/*  44 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  45 */     this.padre = padre;
/*  46 */     this.fichas = fichas;
/*  47 */     colorear();
/*  48 */     this.USUARIO = USUARIO;
/*  49 */     panelito.setViewportView(this);
/*  50 */     this.panel = panelito;
/*  51 */     llenarCombo();
/*  52 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.jPanel5 = new JPanel();
/*  59 */     this.jScrollPane3 = new JScrollPane();
/*  60 */     this.jTable3 = new JTable();
/*  61 */     this.jButton5 = new JButton();
/*  62 */     this.jLabel52 = new JLabel();
/*  63 */     this.jPanel2 = new JPanel();
/*  64 */     this.jPanel3 = new JPanel();
/*  65 */     this.jLabel54 = new JLabel();
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
/*     */     
/*  77 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  78 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  80 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  81 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  83 */     this.jTable3.setAutoCreateRowSorter(true);
/*  84 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  85 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Empresa", "Dirección", "RFC", "Teléfono" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  93 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  98 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 101 */     this.jTable3.setShowVerticalLines(false);
/* 102 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 104 */             DestinatarioModifi.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 107 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 109 */     this.jButton5.setMnemonic('M');
/* 110 */     this.jButton5.setText("Modificar");
/* 111 */     this.jButton5.setToolTipText("Modificar (Alt+M)");
/* 112 */     this.jButton5.setEnabled(false);
/* 113 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 115 */             DestinatarioModifi.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 119 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 120 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 121 */     this.jLabel52.setHorizontalAlignment(2);
/* 122 */     this.jLabel52.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 124 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 125 */     this.jPanel5.setLayout(jPanel5Layout);
/* 126 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 128 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 129 */           .addGap(315, 315, 315)
/* 130 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 131 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 132 */           .addComponent(this.jButton5)
/* 133 */           .addContainerGap(398, 32767))
/* 134 */         .addComponent(this.jScrollPane3));
/*     */     
/* 136 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 138 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 139 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 140 */             .addComponent(this.jButton5)
/* 141 */             .addComponent(this.jLabel52))
/* 142 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 143 */           .addComponent(this.jScrollPane3, -1, 157, 32767)));
/*     */ 
/*     */     
/* 146 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 147 */     this.jPanel1.setLayout(jPanel1Layout);
/* 148 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 149 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 150 */         .addComponent(this.jPanel5, -1, -1, 32767));
/*     */     
/* 152 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 153 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 155 */           .addGap(109, 109, 109)
/* 156 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 159 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 161 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 163 */     this.jLabel54.setFont(new Font("Cantarell", 1, 22));
/* 164 */     this.jLabel54.setForeground(this.lc.PRIMARIO2);
/* 165 */     this.jLabel54.setHorizontalAlignment(0);
/* 166 */     this.jLabel54.setText("Modificar Destinos");
/*     */     
/* 168 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 169 */     this.jPanel3.setLayout(jPanel3Layout);
/* 170 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 172 */         .addComponent(this.jLabel54, -1, 838, 32767));
/*     */     
/* 174 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 176 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 177 */           .addContainerGap()
/* 178 */           .addComponent(this.jLabel54)
/* 179 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 182 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 184 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 186 */             DestinatarioModifi.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 190 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 191 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 192 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 194 */             DestinatarioModifi.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 198 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 199 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 200 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 202 */             DestinatarioModifi.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 206 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 207 */     this.jPanel17.setLayout(jPanel17Layout);
/* 208 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 209 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 210 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 211 */           .addContainerGap()
/* 212 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 214 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 216 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 217 */           .addContainerGap(-1, 32767)));
/*     */     
/* 219 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 221 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 222 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 223 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 224 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 227 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 229 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 237 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 242 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 245 */     this.rSTableMetro1.setAltoHead(40);
/* 246 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 247 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 248 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 249 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 250 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 251 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 252 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 253 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 254 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 255 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 256 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 257 */     this.rSTableMetro1.setRowHeight(18);
/* 258 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 259 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 260 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 261 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 262 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 263 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 265 */             DestinatarioModifi.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 268 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 270 */             DestinatarioModifi.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 273 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 275 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 276 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 277 */     this.jLabel48.setHorizontalAlignment(2);
/* 278 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 280 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 281 */     this.jLabel53.setForeground(this.lc.SECUNDARIO1);
/* 282 */     this.jLabel53.setHorizontalAlignment(4);
/* 283 */     this.jLabel53.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 285 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 286 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 287 */     this.materialButton1.setMnemonic('M');
/* 288 */     this.materialButton1.setText("Modificar");
/* 289 */     this.materialButton1.setToolTipText("Modificar (Alt+M)");
/* 290 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 291 */     this.materialButton1.setHorizontalTextPosition(0);
/* 292 */     this.materialButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 294 */             DestinatarioModifi.this.materialButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 298 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 299 */     this.jPanel4.setLayout(jPanel4Layout);
/* 300 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 302 */         .addComponent(this.jScrollPane29)
/* 303 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 304 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 305 */           .addGap(70, 70, 70)
/* 306 */           .addComponent(this.jLabel53, -1, 421, 32767)
/* 307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 308 */           .addComponent((Component)this.materialButton1, -2, 150, -2)));
/*     */     
/* 310 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 312 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 313 */           .addComponent(this.jScrollPane29, -1, 279, 32767)
/* 314 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 315 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 316 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 317 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 318 */                 .addComponent(this.jLabel48)
/* 319 */                 .addComponent(this.jLabel53))
/* 320 */               .addContainerGap())
/* 321 */             .addComponent((Component)this.materialButton1, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*     */ 
/*     */     
/* 324 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 325 */     this.jPanel2.setLayout(jPanel2Layout);
/* 326 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 327 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 328 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 329 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 330 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 332 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 334 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 335 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 336 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 337 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 339 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 342 */     GroupLayout layout = new GroupLayout(this);
/* 343 */     setLayout(layout);
/* 344 */     layout.setHorizontalGroup(layout
/* 345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 348 */     layout.setVerticalGroup(layout
/* 349 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 350 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 355 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 359 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 363 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 367 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 368 */     String nombre = String.valueOf(this.rSTableMetro1.getValueAt(ind, 0));
/* 369 */     String ap = String.valueOf(this.rSTableMetro1.getValueAt(ind, 1));
/*     */     
/* 371 */     this.materialButton1.setEnabled(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 379 */     this.materialButton1.setEnabled(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 387 */     setCursor(new Cursor(3));
/* 388 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 389 */     if (this.fichas.getTabCount() > 1) {
/* 390 */       this.fichas.remove(1);
/*     */     }
/* 392 */     if (this.destinatario == null) {
/* 393 */       this.destinatario = new DestinatarioAlta(new JScrollPane(), this.USUARIO, this.fichas, this.jTable3, num, this.padre, this.mensajeTry);
/* 394 */       this.destinatario.pasarInd(this.rSTableMetro1.getSelectedRow());
/*     */     } else {
/* 396 */       this.destinatario.destinatario(this.USUARIO, num);
/* 397 */       this.destinatario.pasarInd(this.rSTableMetro1.getSelectedRow());
/*     */     } 
/* 399 */     this.fichas.setSelectedIndex(1);
/* 400 */     cargarMouse();
/*     */   }
/*     */   public void colorear() {
/* 403 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 405 */             DestinatarioModifi.this.jTextGanado(DestinatarioModifi.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 409 */             DestinatarioModifi.this.jTextPerdido(DestinatarioModifi.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 412 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 414 */             DestinatarioModifi.this.jTextGanado(DestinatarioModifi.this.jComboBox1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 418 */             DestinatarioModifi.this.jTextPerdido(DestinatarioModifi.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 421 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 423 */             DestinatarioModifi.this.jTextGanado(DestinatarioModifi.this.jComboBox2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 427 */             DestinatarioModifi.this.jTextPerdido(DestinatarioModifi.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 433 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 437 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void cargarMouse() {
/*     */     try {
/* 442 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 443 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 444 */       setCursor(micursor);
/* 445 */     } catch (Exception e) {
/* 446 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 451 */     String clave = "";
/* 452 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 453 */       clave = this.jTextField1.getText();
/*     */     }
/* 455 */     String nombre = "";
/* 456 */     String estados = "";
/* 457 */     String id_edo = "";
/* 458 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 459 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 461 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 462 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 463 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 464 */       id_edo = this.con.Campo;
/*     */     } 
/* 466 */     this.encontrado = this.con.consultar("count(clave_desti)", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0");
/* 467 */     int totreg = Integer.parseInt(this.con.Campo);
/* 468 */     this.encontrado = this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 469 */     String tot = this.con.Campo;
/* 470 */     this.jLabel48.setText(" Registros encontrados " + totreg + " de " + tot);
/* 471 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 472 */           .buscarReg(11, totreg, "clave_desti,empresa,nombrecorto,calle,num,col,cp,ciudad,estado,rfc,semarnat", "emp_destinataria,ESTADOS", "where emp_destinataria.id_edo = estados.id_edo and clave_desti like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_desti<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Destino", "Nombre Corto", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Semarnat" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 477 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 482 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 485 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 486 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 488 */             DestinatarioModifi.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 491 */     eliminarColumna(4, 3, "Número");
/* 492 */     eliminarColumna(4, 3, "Colonia");
/* 493 */     eliminarColumna(4, 3, "CP");
/* 494 */     eliminarColumna(4, 3, "Ciudad");
/* 495 */     eliminarColumna(4, 3, "Estado");
/*     */     
/* 497 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 498 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 499 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 500 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(180);
/* 501 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(180);
/* 502 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 503 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(90);
/* 504 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(140);
/* 505 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(140);
/* 506 */     this.materialButton1.setEnabled(false);
/* 507 */     this.rSTableMetro1.setSelectionMode(0);
/* 508 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 509 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 511 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 512 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 513 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 514 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 515 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 516 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 517 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 521 */     int cont = this.rSTableMetro1.getRowCount();
/* 522 */     String[] registros = new String[cont]; int i;
/* 523 */     for (i = 0; i < cont; i++) {
/* 524 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 526 */     for (i = 0; i < cont; i++) {
/* 527 */       registros[i] = registros[i] + " " + registros[i];
/* 528 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 530 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 531 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   
/*     */   public void destinatario(String usu) {
/* 535 */     this.USUARIO = usu;
/* 536 */     this.panel.setViewportView(this);
/* 537 */     llenarCombo();
/* 538 */     consultar();
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 542 */     this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 543 */     String[] depa = this.con.regresaCol("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 544 */     this.jComboBox1.removeAllItems();
/* 545 */     this.jComboBox1.addItem("DESTINOS");
/* 546 */     for (int i = 0; i < depa.length; i++)
/* 547 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer
/*     */   {
/* 553 */     int otro = -1;
/* 554 */     int[] indices = new int[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 557 */       setEnabled((table == null || table.isEnabled()));
/* 558 */       if (comparar(row)) {
/* 559 */         setBackground(Color.red);
/* 560 */       } else if (row % 2 == 0) {
/* 561 */         setBackground(DestinatarioModifi.this.lc.FONDOTABLA);
/*     */       } else {
/* 563 */         setBackground((Color)null);
/*     */       } 
/* 565 */       setForeground(DestinatarioModifi.this.lc.SECUNDARIO1);
/* 566 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 567 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(int[] ind) {
/* 571 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(int reg) {
/* 575 */       for (int i = 0; i < this.indices.length; i++) {
/* 576 */         if (this.indices[i] == reg) {
/* 577 */           return true;
/*     */         }
/*     */       } 
/* 580 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DestinatarioModifi.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */