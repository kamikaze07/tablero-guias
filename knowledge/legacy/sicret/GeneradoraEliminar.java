/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class GeneradoraEliminar extends JPanel {
/*     */   Border borde;
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  23 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  24 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  25 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  26 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*     */   String USUARIO;
/*  28 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*     */   AltaOperador operador;
/*  32 */   int contador = 0;
/*     */   JFrame padre;
/*     */   EscribirReporte esc;
/*  35 */   CeldaRender celda = new CeldaRender();
/*  36 */   MensajePop mensajeTry = null;
/*  37 */   SColores lc = new SColores();
/*  38 */   PlaceHolder placeHolder = null;
/*  39 */   String holderClave = "CLAVE"; private JButton jButton5; private JCheckBox jCheckBox2; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel55; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JScrollPane jScrollPane29; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private MaterialButton materialButton1; private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public GeneradoraEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  42 */     this.mensajeTry = mensajeTry;
/*  43 */     initComponents();
/*  44 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  45 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  46 */     this.rSTableMetro1.setCursor(micursor);
/*  47 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderClave, false, "Cantarell", 11);
/*  48 */     this.padre = padre;
/*  49 */     this.fichas = fichas;
/*  50 */     colorear();
/*  51 */     this.USUARIO = USUARIO;
/*  52 */     panelito.setViewportView(this);
/*  53 */     this.panel = panelito;
/*  54 */     llenarCombo();
/*  55 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  60 */     this.jPanel1 = new JPanel();
/*  61 */     this.jLabel54 = new JLabel();
/*  62 */     this.jPanel5 = new JPanel();
/*  63 */     this.jScrollPane3 = new JScrollPane();
/*  64 */     this.jTable3 = new JTable();
/*  65 */     this.jButton5 = new JButton();
/*  66 */     this.jPanel2 = new JPanel();
/*  67 */     this.jPanel3 = new JPanel();
/*  68 */     this.jLabel55 = new JLabel();
/*  69 */     this.jPanel17 = new JPanel();
/*  70 */     this.jTextField1 = new JTextField();
/*  71 */     this.jComboBox1 = new JComboBox();
/*  72 */     this.jComboBox2 = new JComboBox();
/*  73 */     this.jPanel4 = new JPanel();
/*  74 */     this.jScrollPane29 = new JScrollPane();
/*  75 */     this.rSTableMetro1 = new RSTableMetro();
/*  76 */     this.jCheckBox2 = new JCheckBox();
/*  77 */     this.jLabel48 = new JLabel();
/*  78 */     this.jLabel52 = new JLabel();
/*  79 */     this.materialButton1 = new MaterialButton();
/*     */     
/*  81 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  82 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  84 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/*  85 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  86 */     this.jLabel54.setHorizontalAlignment(0);
/*  87 */     this.jLabel54.setText("Eliminar Empresas Origen");
/*     */     
/*  89 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  90 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  92 */     this.jTable3.setAutoCreateRowSorter(true);
/*  93 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  94 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Empresa", "Dirección", "RFC", "Teléfono", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 102 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 105 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 110 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 114 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 117 */     this.jTable3.setShowVerticalLines(false);
/* 118 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 120 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 121 */     this.jPanel5.setLayout(jPanel5Layout);
/* 122 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 123 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 124 */         .addComponent(this.jScrollPane3));
/*     */     
/* 126 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 128 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 129 */           .addGap(37, 37, 37)
/* 130 */           .addComponent(this.jScrollPane3, -1, 171, 32767)));
/*     */ 
/*     */     
/* 133 */     this.jButton5.setMnemonic('E');
/* 134 */     this.jButton5.setText("Eliminar");
/* 135 */     this.jButton5.setToolTipText("Eliminar (Alt+E)");
/* 136 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 138 */             GeneradoraEliminar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 142 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 143 */     this.jPanel1.setLayout(jPanel1Layout);
/* 144 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 145 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 146 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 147 */           .addContainerGap()
/* 148 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 149 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 150 */             .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, 842, 32767))
/* 151 */           .addContainerGap())
/* 152 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 153 */           .addGap(310, 310, 310)
/* 154 */           .addComponent(this.jButton5)
/* 155 */           .addContainerGap(-1, 32767)));
/*     */     
/* 157 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 158 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 159 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 160 */           .addContainerGap()
/* 161 */           .addComponent(this.jLabel54)
/* 162 */           .addGap(18, 18, 18)
/* 163 */           .addComponent(this.jButton5)
/* 164 */           .addGap(37, 37, 37)
/* 165 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 168 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 170 */     this.jPanel3.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 172 */     this.jLabel55.setFont(new Font("Cantarell", 1, 22));
/* 173 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 174 */     this.jLabel55.setHorizontalAlignment(0);
/* 175 */     this.jLabel55.setText("Eliminar Clientes");
/*     */     
/* 177 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 178 */     this.jPanel3.setLayout(jPanel3Layout);
/* 179 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 181 */         .addComponent(this.jLabel55, -1, -1, 32767));
/*     */     
/* 183 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 186 */           .addContainerGap()
/* 187 */           .addComponent(this.jLabel55)
/* 188 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 191 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 193 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 195 */             GeneradoraEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 199 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 200 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Gondola", "Pipa" }));
/* 201 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 203 */             GeneradoraEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 207 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 208 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADOS", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 209 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 211 */             GeneradoraEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 215 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 216 */     this.jPanel17.setLayout(jPanel17Layout);
/* 217 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 218 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 219 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 220 */           .addContainerGap()
/* 221 */           .addComponent(this.jTextField1, -2, 86, -2)
/* 222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 223 */           .addComponent(this.jComboBox1, -2, 309, -2)
/* 224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 225 */           .addComponent(this.jComboBox2, -2, 186, -2)
/* 226 */           .addContainerGap(225, 32767)));
/*     */     
/* 228 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 230 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 231 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 232 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 233 */           .addComponent(this.jComboBox2, -2, -1, -2)));
/*     */ 
/*     */     
/* 236 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 238 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 246 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 251 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 254 */     this.rSTableMetro1.setAltoHead(40);
/* 255 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 256 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 257 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 258 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 259 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 260 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 261 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 262 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 263 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 264 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 265 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 266 */     this.rSTableMetro1.setRowHeight(18);
/* 267 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 268 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 269 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 270 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 271 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 272 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 274 */             GeneradoraEliminar.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 277 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 279 */             GeneradoraEliminar.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 282 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 284 */     this.jCheckBox2.setFont(new Font("Cantarell", 0, 11));
/* 285 */     this.jCheckBox2.setText("Seleccionar Todos");
/* 286 */     this.jCheckBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 288 */             GeneradoraEliminar.this.jCheckBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 292 */     this.jLabel48.setFont(new Font("Cantarell", 0, 11));
/* 293 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 294 */     this.jLabel48.setHorizontalAlignment(2);
/* 295 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 297 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/* 298 */     this.jLabel52.setForeground(this.lc.SECUNDARIO1);
/* 299 */     this.jLabel52.setHorizontalAlignment(4);
/* 300 */     this.jLabel52.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar'");
/*     */     
/* 302 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/* 303 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/* 304 */     this.materialButton1.setMnemonic('E');
/* 305 */     this.materialButton1.setText("Eliminar");
/* 306 */     this.materialButton1.setToolTipText("Eliminar (Alt+E)");
/* 307 */     this.materialButton1.setFont(new Font("Cantarell", 0, 12));
/* 308 */     this.materialButton1.setHorizontalTextPosition(0);
/* 309 */     this.materialButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 311 */             GeneradoraEliminar.this.materialButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 315 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 316 */     this.jPanel4.setLayout(jPanel4Layout);
/* 317 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 318 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 319 */         .addComponent(this.jScrollPane29)
/* 320 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 321 */           .addContainerGap()
/* 322 */           .addComponent(this.jCheckBox2, -2, 129, -2)
/* 323 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 324 */           .addComponent(this.jLabel48, -2, 190, -2)
/* 325 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 326 */           .addComponent(this.jLabel52, -2, 1, 32767)
/* 327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 328 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/* 329 */           .addContainerGap()));
/*     */     
/* 331 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 333 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 334 */           .addComponent(this.jScrollPane29, -1, 242, 32767)
/* 335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 336 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 338 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 339 */                 .addComponent(this.jLabel52)
/* 340 */                 .addComponent(this.jLabel48)
/* 341 */                 .addComponent(this.jCheckBox2))
/* 342 */               .addContainerGap())
/* 343 */             .addComponent((Component)this.materialButton1, GroupLayout.Alignment.TRAILING, -2, 38, -2))));
/*     */ 
/*     */     
/* 346 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 347 */     this.jPanel2.setLayout(jPanel2Layout);
/* 348 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 349 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 350 */         .addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 351 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 352 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/* 354 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 355 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 356 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 357 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 359 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 361 */           .addComponent(this.jPanel4, -1, -1, 32767)));
/*     */ 
/*     */     
/* 364 */     GroupLayout layout = new GroupLayout(this);
/* 365 */     setLayout(layout);
/* 366 */     layout.setHorizontalGroup(layout
/* 367 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 368 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 370 */     layout.setVerticalGroup(layout
/* 371 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 372 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 377 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 381 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 385 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jCheckBox2ActionPerformed(ActionEvent evt) {
/* 393 */     if (this.jCheckBox2.isSelected() == true) {
/* 394 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 395 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(true), i, 0);
/*     */       }
/*     */     } else {
/*     */       
/* 399 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 400 */         this.rSTableMetro1.setValueAt(Boolean.valueOf(false), i, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void materialButton1ActionPerformed(ActionEvent evt) {
/* 414 */     String ind = "";
/* 415 */     int contar = 0;
/* 416 */     this.contador = 0;
/* 417 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 418 */       String val = String.valueOf(this.rSTableMetro1.getValueAt(i, 0));
/* 419 */       if (val.equals("true")) {
/* 420 */         contar++;
/*     */       }
/*     */     } 
/* 423 */     if (contar == 0) {
/* 424 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar la empresa", "Selecciona Una Empresa", 0, this.INFO);
/*     */     }
/* 426 */     else if (contar == 1) {
/* 427 */       int doc = 0;
/* 428 */       for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/* 429 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/* 430 */         if (val.equals("true")) {
/* 431 */           String str = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/* 432 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 436 */       String valor = "<html><b>Clave de la empresa: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 1)) + "<br><b>Nombre: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.rSTableMetro1.getValueAt(doc, 3)) + "<br></html>";
/* 437 */       int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar definitivamente los datos?", "Eliminar Empresa Origen", 0, 3, this.ELIMINAR);
/* 438 */       if (res == 0) {
/* 439 */         String val = String.valueOf(this.rSTableMetro1.getValueAt(doc, 1));
/* 440 */         String[] reg = this.con.regresaReg("clave_gene,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene = " + val, 10);
/* 441 */         this.con.eliminar("emp_generadora", "where clave_gene=" + val);
/* 442 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el empresa generadora " + val + " definitivamente.','Clave Empresa: " + val + "\nNombre de la empresa: " + reg[1] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[9] + "\nRFC: " + reg[7] + "\nTeléfono: " + reg[8] + "')");
/* 443 */         this.mensajeTry.guardarConf("Se ha eliminado un cliente-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Cliente de Baja", "ERROR", "Clientes");
/* 444 */         consultar();
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 449 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Empresas Origen", 0, 3, this.ELIMINAR);
/* 450 */       if (res == 0) {
/* 451 */         for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/* 452 */           String val = String.valueOf(this.rSTableMetro1.getValueAt(j, 0));
/* 453 */           if (val.equals("true")) {
/* 454 */             String valor = String.valueOf(this.rSTableMetro1.getValueAt(j, 1));
/* 455 */             String[] reg = this.con.regresaReg("clave_gene,empresa,calle,num,col,cp,ciudad,rfc,telefono,estado", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene = " + valor, 10);
/* 456 */             this.contador++;
/* 457 */             this.con.eliminar2("emp_generadora", "where clave_gene=" + valor);
/* 458 */             this.mensajeTry.guardarConf("Se ha eliminado un cliente-" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + ", USUARIO: " + this.USUARIO, "Cliente de Baja", "ERROR", "Clientes");
/* 459 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el empresa generadora " + valor + " definitivamente.','Clave Empresa: " + val + "\nNombre de la empresa: " + reg[1] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[9] + "\nRFC: " + reg[7] + "\nTeléfono: " + reg[8] + "')");
/*     */           } 
/*     */         } 
/* 462 */         consultar();
/* 463 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + this.contador + " empresas.", "Empresas Eliminadas", 0, this.INFO);
/*     */       } 
/*     */     } 
/* 466 */     llenarCombo();
/*     */   }
/*     */   public void colorear() {
/* 469 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 471 */             GeneradoraEliminar.this.jTextGanado(GeneradoraEliminar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 474 */             GeneradoraEliminar.this.jTextPerdido(GeneradoraEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 477 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 479 */             GeneradoraEliminar.this.jTextGanado(GeneradoraEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 482 */             GeneradoraEliminar.this.jTextPerdido(GeneradoraEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 485 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 487 */             GeneradoraEliminar.this.jTextGanado(GeneradoraEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 490 */             GeneradoraEliminar.this.jTextPerdido(GeneradoraEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 495 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 498 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 502 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 503 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 504 */       setCursor(micursor);
/*     */     }
/* 506 */     catch (Exception e) {
/* 507 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void consultar() {
/* 511 */     this.jCheckBox2.setSelected(false);
/* 512 */     String clave = "";
/* 513 */     String nombre = "";
/* 514 */     String estados = "";
/* 515 */     String id_edo = "";
/* 516 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 517 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 519 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 520 */       estados = String.valueOf(this.jComboBox2.getSelectedItem());
/* 521 */       this.con.consultar("id_edo", "estados", "where estado like '%" + estados + "%'");
/* 522 */       id_edo = this.con.Campo;
/*     */     } 
/* 524 */     if (!this.jTextField1.getText().equals(this.holderClave)) {
/* 525 */       clave = this.jTextField1.getText();
/*     */     }
/*     */     
/* 528 */     this.encontrado = this.con.consultar("count(clave_gene)", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0");
/* 529 */     int totreg = Integer.parseInt(this.con.Campo);
/* 530 */     this.encontrado = this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 531 */     String tot = this.con.Campo;
/* 532 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 533 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 534 */           .buscarReg(10, totreg, "clave_gene,empresa,calle,num,col,cp,ciudad,estado,rfc,telefono", "emp_generadora,estados", "where emp_generadora.id_edo = estados.id_edo and clave_gene like '%" + clave + "%' and empresa like '%" + nombre + "%'and estados.id_edo like '%" + id_edo + "%' and clave_gene<>0 order by empresa"), (Object[])new String[] { "Clave", "Nombre Completo de la Empresa Origen", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "RFC", "Teléfono", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 539 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 543 */             return this.types[columnIndex];
/*     */           }
/* 545 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               true };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 549 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 552 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 553 */     eliminarColumna(3, 2, "Número");
/* 554 */     eliminarColumna(3, 2, "Colonia");
/* 555 */     eliminarColumna(3, 2, "CP");
/* 556 */     eliminarColumna(3, 2, "Ciudad");
/* 557 */     eliminarColumna(3, 2, "Estado");
/*     */     
/* 559 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 560 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 561 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 562 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(310);
/* 563 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(310);
/* 564 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 565 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(110);
/* 566 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 567 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(90);
/* 568 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(30);
/* 569 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(30);
/* 570 */     this.rSTableMetro1.setSelectionMode(0);
/* 571 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 572 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 573 */     this.rSTableMetro1.getColumnModel().moveColumn(5, 0);
/*     */     
/* 575 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 576 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 577 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 578 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 579 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 580 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 583 */     int cont = this.rSTableMetro1.getRowCount();
/* 584 */     String[] registros = new String[cont]; int i;
/* 585 */     for (i = 0; i < cont; i++) {
/* 586 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*     */     }
/* 588 */     for (i = 0; i < cont; i++) {
/* 589 */       registros[i] = registros[i] + " " + registros[i];
/* 590 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*     */     } 
/* 592 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 593 */     this.rSTableMetro1.removeColumn(columna);
/*     */   }
/*     */   public void generadora(String usu) {
/* 596 */     this.USUARIO = usu;
/* 597 */     this.panel.setViewportView(this);
/* 598 */     llenarCombo();
/* 599 */     consultar();
/*     */   }
/*     */   public void llenarCombo() {
/* 602 */     this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 603 */     String[] depa = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 604 */     this.jComboBox1.removeAllItems();
/* 605 */     this.jComboBox1.addItem("CLIENTES");
/* 606 */     for (int i = 0; i < depa.length; i++)
/* 607 */       this.jComboBox1.addItem(depa[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 611 */     int otro = -1;
/* 612 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 614 */       setEnabled((table == null || table.isEnabled()));
/* 615 */       if (comparar(row)) {
/* 616 */         setBackground(Color.red);
/*     */       }
/* 618 */       else if (row % 2 == 0) {
/* 619 */         setBackground(GeneradoraEliminar.this.lc.FONDOTABLA);
/*     */       } else {
/* 621 */         setBackground((Color)null);
/* 622 */       }  setForeground(GeneradoraEliminar.this.lc.SECUNDARIO1);
/* 623 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 624 */       return this;
/*     */     }
/*     */     public void pasarInd(int[] ind) {
/* 627 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(int reg) {
/* 630 */       for (int i = 0; i < this.indices.length; i++) {
/* 631 */         if (this.indices[i] == reg) {
/* 632 */           return true;
/*     */         }
/*     */       } 
/* 635 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GeneradoraEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */