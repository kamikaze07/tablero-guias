/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class OperadoresModifi extends JPanel {
/*  12 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  13 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*     */   String USUARIO;
/*  18 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  21 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  23 */   CeldaRender celda = new CeldaRender();
/*  24 */   String RUTA = "";
/*  25 */   MensajePop mensajeTry = null;
/*     */   Map<String, String> CAMPOSGENERALES;
/*  27 */   List<Tras_codigos> CODIGOSP = new ArrayList<>();
/*  28 */   ArrayList LISTACODIGOS = new ArrayList(); private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel42; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private JTextField jTextField5;
/*     */   private JTextField jTextField6;
/*     */   
/*     */   public OperadoresModifi(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*  34 */     this.mensajeTry = mensajeTry;
/*  35 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  36 */     this.LISTACODIGOS = LISTACODIGOS;
/*  37 */     this.CODIGOSP = CODIGOSP;
/*     */     
/*  39 */     initComponents();
/*  40 */     this.con.consultar("fotosOperadores", "configuraciones", "");
/*  41 */     this.RUTA = this.con.Campo;
/*  42 */     this.padre = padre;
/*  43 */     this.fichas = fichas;
/*  44 */     colorear();
/*  45 */     this.USUARIO = USUARIO;
/*  46 */     panelito.setViewportView(this);
/*  47 */     this.panel = panelito;
/*  48 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  53 */     this.jPanel1 = new JPanel();
/*  54 */     this.jPanel17 = new JPanel();
/*  55 */     this.jLabel14 = new JLabel();
/*  56 */     this.jLabel32 = new JLabel();
/*  57 */     this.jLabel38 = new JLabel();
/*  58 */     this.jTextField1 = new JTextField();
/*  59 */     this.jTextField2 = new JTextField();
/*  60 */     this.jTextField3 = new JTextField();
/*  61 */     this.jTextField4 = new JTextField();
/*  62 */     this.jLabel15 = new JLabel();
/*  63 */     this.jComboBox1 = new JComboBox();
/*  64 */     this.jLabel39 = new JLabel();
/*  65 */     this.jTextField5 = new JTextField();
/*  66 */     this.jLabel16 = new JLabel();
/*  67 */     this.jLabel17 = new JLabel();
/*  68 */     this.jTextField6 = new JTextField();
/*  69 */     this.jComboBox3 = new JComboBox();
/*  70 */     this.jLabel42 = new JLabel();
/*  71 */     this.jComboBox2 = new JComboBox();
/*  72 */     this.jLabel40 = new JLabel();
/*  73 */     this.jLabel54 = new JLabel();
/*  74 */     this.jPanel5 = new JPanel();
/*  75 */     this.jScrollPane3 = new JScrollPane();
/*  76 */     this.jTable3 = new JTable();
/*  77 */     this.jButton5 = new JButton();
/*  78 */     this.jLabel52 = new JLabel();
/*  79 */     this.jLabel48 = new JLabel();
/*     */     
/*  81 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  82 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  84 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  85 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Operadores ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  87 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  88 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  89 */     this.jLabel14.setHorizontalAlignment(0);
/*  90 */     this.jLabel14.setText("Nombre (s)");
/*     */     
/*  92 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  93 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  94 */     this.jLabel32.setText("Apellido Paterno");
/*     */     
/*  96 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  97 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  98 */     this.jLabel38.setHorizontalAlignment(0);
/*  99 */     this.jLabel38.setText("Apellido Materno");
/*     */     
/* 101 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 103 */             OperadoresModifi.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 109 */             OperadoresModifi.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 113 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 115 */             OperadoresModifi.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 119 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 121 */             OperadoresModifi.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 125 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 126 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 127 */     this.jLabel15.setHorizontalAlignment(0);
/* 128 */     this.jLabel15.setText("Clave");
/*     */     
/* 130 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 131 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 132 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "CUALQUIERA", "PIPA", "GÓNDOLA" }));
/* 133 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 135 */             OperadoresModifi.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 139 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 140 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 141 */     this.jLabel39.setHorizontalAlignment(0);
/* 142 */     this.jLabel39.setText("Puesto");
/*     */     
/* 144 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 146 */             OperadoresModifi.this.jTextField5KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 150 */     this.jLabel16.setFont(new Font("Tahoma", 2, 11));
/* 151 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 152 */     this.jLabel16.setHorizontalAlignment(0);
/* 153 */     this.jLabel16.setText("Tracto");
/*     */     
/* 155 */     this.jLabel17.setFont(new Font("Tahoma", 2, 11));
/* 156 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 157 */     this.jLabel17.setHorizontalAlignment(0);
/* 158 */     this.jLabel17.setText("Remolque");
/*     */     
/* 160 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 162 */             OperadoresModifi.this.jTextField6KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 166 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 167 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 168 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Activos", "Eliminados", "Todos" }));
/* 169 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 171 */             OperadoresModifi.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 175 */     this.jLabel42.setFont(new Font("Tahoma", 2, 11));
/* 176 */     this.jLabel42.setForeground(new Color(15, 87, 51));
/* 177 */     this.jLabel42.setHorizontalAlignment(0);
/* 178 */     this.jLabel42.setText("Actual");
/*     */     
/* 180 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 181 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 182 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "OPERADOR", "FUNCIONARIO", "TODOS" }));
/* 183 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 185 */             OperadoresModifi.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 189 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 190 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 191 */     this.jLabel40.setHorizontalAlignment(0);
/* 192 */     this.jLabel40.setText("Tipo de Trabajador");
/*     */     
/* 194 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 195 */     this.jPanel17.setLayout(jPanel17Layout);
/* 196 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 197 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 198 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 199 */           .addGap(20, 20, 20)
/* 200 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 201 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 202 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 203 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 204 */               .addComponent(this.jLabel14, -1, -1, 32767))
/* 205 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 206 */               .addComponent(this.jTextField4, -2, 49, -2)
/* 207 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 208 */               .addComponent(this.jTextField1, -2, 155, -2)))
/* 209 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 210 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 211 */             .addComponent(this.jTextField2, -2, 151, -2)
/* 212 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 213 */               .addGap(34, 34, 34)
/* 214 */               .addComponent(this.jLabel32, -2, 90, -2)))
/* 215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 216 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 217 */             .addComponent(this.jTextField3, -2, 163, -2)
/* 218 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 219 */               .addGap(43, 43, 43)
/* 220 */               .addComponent(this.jLabel38)))
/* 221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 222 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 223 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 224 */             .addComponent(this.jComboBox2, -2, 131, -2))
/* 225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 226 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 227 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 228 */             .addComponent(this.jComboBox1, -2, 131, -2))
/* 229 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 230 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 231 */             .addComponent(this.jLabel42, -1, -1, 32767)
/* 232 */             .addComponent(this.jComboBox3, -2, 111, -2))
/* 233 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 234 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 235 */             .addComponent(this.jLabel16, -2, 49, -2)
/* 236 */             .addComponent(this.jTextField5, -2, 49, -2))
/* 237 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 238 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 239 */             .addComponent(this.jLabel17, -2, 49, -2)
/* 240 */             .addComponent(this.jTextField6, -2, 49, -2))
/* 241 */           .addGap(505, 505, 505)));
/*     */     
/* 243 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 245 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 246 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 247 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 248 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 249 */               .addGap(8, 8, 8)
/* 250 */               .addComponent(this.jLabel38))
/* 251 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 252 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 253 */               .addGap(8, 8, 8)
/* 254 */               .addComponent(this.jLabel32))
/* 255 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 256 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 257 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 258 */                 .addComponent(this.jTextField4, -2, -1, -2))
/* 259 */               .addGap(8, 8, 8)
/* 260 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 261 */                 .addComponent(this.jLabel14)
/* 262 */                 .addComponent(this.jLabel15)))
/* 263 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 264 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 265 */               .addGap(8, 8, 8)
/* 266 */               .addComponent(this.jLabel40))
/* 267 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 268 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 269 */               .addGap(8, 8, 8)
/* 270 */               .addComponent(this.jLabel39))
/* 271 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 272 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 273 */               .addGap(8, 8, 8)
/* 274 */               .addComponent(this.jLabel42))
/* 275 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 276 */               .addComponent(this.jTextField5, -2, -1, -2)
/* 277 */               .addGap(8, 8, 8)
/* 278 */               .addComponent(this.jLabel16))
/* 279 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 280 */               .addComponent(this.jTextField6, -2, -1, -2)
/* 281 */               .addGap(8, 8, 8)
/* 282 */               .addComponent(this.jLabel17)))
/* 283 */           .addContainerGap()));
/*     */ 
/*     */     
/* 286 */     this.jLabel54.setFont(new Font("Tahoma", 1, 20));
/* 287 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 288 */     this.jLabel54.setHorizontalAlignment(0);
/* 289 */     this.jLabel54.setText("Modificar Operadores ");
/*     */     
/* 291 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 292 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 294 */     this.jTable3.setAutoCreateRowSorter(true);
/* 295 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 296 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Nombre Completo", "Dirección", "Teléfono", "Celular", "Fecha de Nac.", "Venc. Licen.", "Tipo", "# Licencia", "NSS", "RFC", "Ingreso", "Tracto", "Caja" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 304 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 309 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 312 */     this.jTable3.setShowVerticalLines(false);
/* 313 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 315 */             OperadoresModifi.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 318 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 320 */             OperadoresModifi.this.jTable3KeyReleased(evt);
/*     */           }
/*     */         });
/* 323 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 324 */     if (this.jTable3.getColumnModel().getColumnCount() > 0) {
/* 325 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(40);
/* 326 */       this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 327 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 328 */       this.jTable3.getColumnModel().getColumn(3).setMinWidth(100);
/* 329 */       this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(100);
/* 330 */       this.jTable3.getColumnModel().getColumn(3).setMaxWidth(100);
/* 331 */       this.jTable3.getColumnModel().getColumn(4).setMinWidth(100);
/* 332 */       this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 333 */       this.jTable3.getColumnModel().getColumn(4).setMaxWidth(100);
/* 334 */       this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 335 */       this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 336 */       this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(90);
/* 337 */       this.jTable3.getColumnModel().getColumn(6).setMaxWidth(90);
/* 338 */       this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(60);
/* 339 */       this.jTable3.getColumnModel().getColumn(7).setMaxWidth(60);
/* 340 */       this.jTable3.getColumnModel().getColumn(10).setMaxWidth(80);
/* 341 */       this.jTable3.getColumnModel().getColumn(11).setMaxWidth(70);
/* 342 */       this.jTable3.getColumnModel().getColumn(12).setPreferredWidth(40);
/* 343 */       this.jTable3.getColumnModel().getColumn(12).setMaxWidth(40);
/* 344 */       this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(40);
/* 345 */       this.jTable3.getColumnModel().getColumn(13).setMaxWidth(40);
/*     */     } 
/*     */     
/* 348 */     this.jButton5.setMnemonic('M');
/* 349 */     this.jButton5.setText("Modificar");
/* 350 */     this.jButton5.setToolTipText("Modificar (Alt+M)");
/* 351 */     this.jButton5.setEnabled(false);
/* 352 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 354 */             OperadoresModifi.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 358 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 359 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 360 */     this.jLabel52.setHorizontalAlignment(2);
/* 361 */     this.jLabel52.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 363 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 364 */     this.jLabel48.setForeground(Color.red);
/* 365 */     this.jLabel48.setHorizontalAlignment(0);
/* 366 */     this.jLabel48.setText("t");
/* 367 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 369 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 370 */     this.jPanel5.setLayout(jPanel5Layout);
/* 371 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 372 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 373 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 374 */           .addContainerGap()
/* 375 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 376 */           .addGap(179, 179, 179)
/* 377 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 378 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 379 */           .addComponent(this.jButton5, -2, 113, -2)
/* 380 */           .addContainerGap(-1, 32767))
/* 381 */         .addComponent(this.jScrollPane3));
/*     */     
/* 383 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 385 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 386 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 387 */             .addComponent(this.jButton5)
/* 388 */             .addComponent(this.jLabel52)
/* 389 */             .addComponent(this.jLabel48))
/* 390 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 391 */           .addComponent(this.jScrollPane3, -1, 191, 32767)));
/*     */ 
/*     */     
/* 394 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 395 */     this.jPanel1.setLayout(jPanel1Layout);
/* 396 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 397 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 398 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 399 */           .addContainerGap()
/* 400 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 401 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 402 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 403 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 404 */               .addGap(261, 261, 261)
/* 405 */               .addComponent(this.jLabel54, -2, 933, -2)))
/* 406 */           .addContainerGap()));
/*     */     
/* 408 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 410 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 411 */           .addComponent(this.jLabel54)
/* 412 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 413 */           .addComponent(this.jPanel17, -2, 68, -2)
/* 414 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 415 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 418 */     GroupLayout layout = new GroupLayout(this);
/* 419 */     setLayout(layout);
/* 420 */     layout.setHorizontalGroup(layout
/* 421 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 422 */         .addGap(0, 1618, 32767)
/* 423 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 424 */           .addGroup(layout.createSequentialGroup()
/* 425 */             .addGap(0, 10, 32767)
/* 426 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 427 */             .addGap(0, 10, 32767))));
/*     */     
/* 429 */     layout.setVerticalGroup(layout
/* 430 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 431 */         .addGap(0, 370, 32767)
/* 432 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 433 */           .addGroup(layout.createSequentialGroup()
/* 434 */             .addGap(7, 7, 7)
/* 435 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 436 */             .addGap(8, 8, 8))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 441 */     if (evt.getClickCount() == 2) {
/* 442 */       setCursor(new Cursor(3));
/* 443 */       String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 444 */       if (this.fichas.getTabCount() > 1) {
/* 445 */         this.fichas.remove(1);
/*     */       }
/* 447 */       if (this.operadores == null) {
/* 448 */         this.operadores = new AltaOperador(new JScrollPane(), this.USUARIO, this.fichas, this.jTable3, num, this.padre, this.mensajeTry, this.CAMPOSGENERALES, this.LISTACODIGOS, this.CODIGOSP);
/* 449 */         this.operadores.pasarInd(this.jTable3.getSelectedRow());
/*     */       } else {
/*     */         
/* 452 */         this.operadores.operadores(this.USUARIO, num);
/* 453 */         this.operadores.pasarInd(this.jTable3.getSelectedRow());
/*     */       } 
/* 455 */       this.fichas.setSelectedIndex(1);
/* 456 */       cargarMouse();
/*     */     } else {
/*     */       
/* 459 */       String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 460 */       int ind = this.jTable3.getSelectedRow();
/* 461 */       String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 462 */       String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 463 */       this.jButton5.setEnabled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 468 */     consultar();
/*     */   }
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 471 */     consultar();
/*     */   }
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 474 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 478 */     setCursor(new Cursor(3));
/* 479 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 480 */     if (this.fichas.getTabCount() > 1) {
/* 481 */       this.fichas.remove(1);
/*     */     }
/* 483 */     if (this.operadores == null) {
/* 484 */       this.operadores = new AltaOperador(new JScrollPane(), this.USUARIO, this.fichas, this.jTable3, num, this.padre, this.mensajeTry, this.CAMPOSGENERALES, this.LISTACODIGOS, this.CODIGOSP);
/* 485 */       this.operadores.pasarInd(this.jTable3.getSelectedRow());
/*     */     } else {
/*     */       
/* 488 */       this.operadores.operadores(this.USUARIO, num);
/* 489 */       this.operadores.pasarInd(this.jTable3.getSelectedRow());
/*     */     } 
/* 491 */     this.fichas.setSelectedIndex(1);
/* 492 */     cargarMouse();
/*     */   }
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 496 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 500 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 504 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 508 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 512 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3KeyReleased(KeyEvent evt) {
/* 516 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 520 */     consultar();
/*     */   }
/*     */   public void operadores(String usu) {
/* 523 */     this.USUARIO = usu;
/* 524 */     this.panel.setViewportView(this);
/* 525 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 528 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 530 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 533 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 536 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 538 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 541 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 544 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 546 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 549 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 552 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 554 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 557 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField4, evt);
/*     */           }
/*     */         });
/* 560 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 562 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField5, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 565 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField5, evt);
/*     */           }
/*     */         });
/* 568 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 570 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jTextField6, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 573 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jTextField6, evt);
/*     */           }
/*     */         });
/* 576 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 578 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 581 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 584 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 586 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 589 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 592 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 594 */             OperadoresModifi.this.jTextGanado(OperadoresModifi.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 597 */             OperadoresModifi.this.jTextPerdido(OperadoresModifi.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 602 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 605 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 608 */     String clave = this.jTextField4.getText();
/* 609 */     String tipo = "";
/* 610 */     String actual = "0";
/* 611 */     String trabajador = "";
/* 612 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 613 */       actual = "1";
/*     */     }
/* 615 */     else if (this.jComboBox3.getSelectedIndex() == 2) {
/* 616 */       actual = "";
/*     */     } 
/* 618 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 619 */       tipo = this.jComboBox1.getSelectedItem().toString();
/*     */     }
/* 621 */     if (this.jComboBox2.getSelectedIndex() != 2) {
/* 622 */       trabajador = this.jComboBox2.getSelectedItem().toString();
/*     */     }
/*     */ 
/*     */     
/* 626 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 627 */           .buscarDatos(24, "num_ope,ap_pat,ap_mat,nombre,calle,num,col,cp,ciudad,estados.estado,tel_casa,celular,fecha_nac,fecha_licen,num_licen,tipo_licen,nss,rfc,ingreso,numInfo,infonavitLetra,tipoTrabajador,num_tracto,num_rem", "operadores,estados", "where num_ope like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and operadores.id_edo=estados.id_edo and operadores.tipo like '%" + tipo + "%' and num_tracto like '%" + this.jTextField5.getText() + "%' and tipoTrabajador like '%" + trabajador + "%' and num_rem like '%" + this.jTextField6.getText() + "%' and actual like '%" + actual + "%' order by ap_pat"), (Object[])new String[] { "Clave", "Nombre Completo", "Apellido Materno", "Nombre", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Fecha de Nac.", "Venc. Licen.", "# Licencia", "Tipo", "NSS", "CURP", "Ingreso", "Infonavit", "Infonavit $", "Trabajador", "T", "C" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 632 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 636 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 639 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 640 */     this.jTable3.setShowVerticalLines(false);
/* 641 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 643 */             OperadoresModifi.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 646 */     eliminarColumna(2, 1, "Apellido Materno");
/* 647 */     eliminarColumna(2, 1, "Nombre");
/* 648 */     eliminarColumna(3, 2, "Número");
/* 649 */     eliminarColumna(3, 2, "Colonia");
/* 650 */     eliminarColumna(3, 2, "CP");
/* 651 */     eliminarColumna(3, 2, "Ciudad");
/* 652 */     eliminarColumna(3, 2, "Estado");
/* 653 */     eliminarColumna(8, 7, "Tipo");
/*     */     
/* 655 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 656 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 657 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 658 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(270);
/* 659 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(270);
/* 660 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 661 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 662 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 663 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(70);
/* 664 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 665 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 666 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 667 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 668 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(75);
/* 669 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(75);
/* 670 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(65);
/* 671 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(65);
/* 672 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 673 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 674 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(60);
/* 675 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(60);
/* 676 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(85);
/* 677 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(85);
/* 678 */     this.jTable3.getColumnModel().getColumn(12).setPreferredWidth(60);
/* 679 */     this.jTable3.getColumnModel().getColumn(12).setMaxWidth(60);
/* 680 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(90);
/* 681 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(90);
/* 682 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(30);
/* 683 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(30);
/* 684 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(30);
/* 685 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(30);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 690 */     if (this.jComboBox3.getSelectedIndex() == 2) {
/*     */       
/* 692 */       String[] arre = this.con.regresaColIndex("num_ope", "operadores", "where actual =1");
/* 693 */       this.celda.pasarInd(arre);
/*     */     } else {
/*     */       
/* 696 */       String[] arre = new String[0];
/* 697 */       this.celda.pasarInd(arre);
/*     */     } 
/*     */     
/* 700 */     this.jButton5.setEnabled(false);
/* 701 */     this.jTable3.setSelectionMode(0);
/* 702 */     this.jTable3.setAutoCreateRowSorter(true);
/* 703 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/* 704 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 705 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 706 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 707 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 708 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 709 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 710 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 711 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 712 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 713 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 714 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 715 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 716 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 717 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 718 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 719 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 722 */     int cont = this.jTable3.getRowCount();
/* 723 */     String[] registros = new String[cont]; int i;
/* 724 */     for (i = 0; i < cont; i++) {
/* 725 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*     */     }
/* 727 */     for (i = 0; i < cont; i++) {
/* 728 */       registros[i] = registros[i] + " " + registros[i];
/* 729 */       this.jTable3.setValueAt(registros[i], i, destino);
/*     */     } 
/* 731 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 732 */     this.jTable3.removeColumn(columna);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 736 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 737 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 738 */       setCursor(micursor);
/*     */     }
/* 740 */     catch (Exception e) {
/* 741 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   
/* 745 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 746 */     String[] indices = new String[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 748 */       setEnabled((table == null || table.isEnabled()));
/* 749 */       String valor = String.valueOf(value);
/* 750 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 751 */       if (comparar(comp)) {
/* 752 */         setBackground(Color.red);
/* 753 */         setForeground(Color.white);
/*     */       }
/* 755 */       else if (comparar(valor)) {
/* 756 */         setBackground(Color.red);
/* 757 */         setForeground(Color.black);
/*     */       }
/* 759 */       else if (row % 2 == 0) {
/* 760 */         setBackground(new Color(194, 213, 151));
/* 761 */         setForeground(Color.black);
/*     */       } else {
/*     */         
/* 764 */         setBackground((Color)null);
/* 765 */         setForeground(Color.black);
/*     */       } 
/* 767 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 768 */       return this;
/*     */     }
/*     */     public void pasarInd(String[] ind) {
/* 771 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(String reg) {
/* 774 */       for (int i = 0; i < this.indices.length; i++) {
/* 775 */         if (this.indices[i].equals(reg)) {
/* 776 */           return true;
/*     */         }
/*     */       } 
/* 779 */       return false;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/OperadoresModifi.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */