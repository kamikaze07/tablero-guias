/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class OperadoresEliminar extends JPanel {
/*     */   Border borde;
/*  14 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  15 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  16 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  17 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  18 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  19 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*     */   String USUARIO;
/*  21 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*     */   AltaOperador operador;
/*  25 */   int contador = 0;
/*     */   JFrame padre;
/*  27 */   CeldaRender celda = new CeldaRender();
/*  28 */   String RUTA = "";
/*  29 */   MensajePop mensajeTry = null; private JButton jButton1; private JButton jButton5; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4;
/*     */   public OperadoresEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  31 */     this.mensajeTry = mensajeTry;
/*  32 */     initComponents();
/*  33 */     this.con.consultar("fotosOperadores", "configuraciones", "");
/*  34 */     this.RUTA = this.con.Campo;
/*  35 */     this.padre = padre;
/*  36 */     this.fichas = fichas;
/*  37 */     colorear();
/*  38 */     this.USUARIO = USUARIO;
/*  39 */     panelito.setViewportView(this);
/*  40 */     this.panel = panelito;
/*  41 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  47 */     this.jPanel1 = new JPanel();
/*  48 */     this.jPanel17 = new JPanel();
/*  49 */     this.jLabel14 = new JLabel();
/*  50 */     this.jLabel32 = new JLabel();
/*  51 */     this.jLabel38 = new JLabel();
/*  52 */     this.jTextField1 = new JTextField();
/*  53 */     this.jTextField2 = new JTextField();
/*  54 */     this.jTextField3 = new JTextField();
/*  55 */     this.jComboBox1 = new JComboBox();
/*  56 */     this.jLabel57 = new JLabel();
/*  57 */     this.jTextField4 = new JTextField();
/*  58 */     this.jLabel15 = new JLabel();
/*  59 */     this.jLabel58 = new JLabel();
/*  60 */     this.jComboBox2 = new JComboBox();
/*  61 */     this.jComboBox3 = new JComboBox();
/*  62 */     this.jLabel40 = new JLabel();
/*  63 */     this.jLabel54 = new JLabel();
/*  64 */     this.jPanel5 = new JPanel();
/*  65 */     this.jScrollPane3 = new JScrollPane();
/*  66 */     this.jTable3 = new JTable();
/*  67 */     this.jButton5 = new JButton();
/*  68 */     this.jLabel52 = new JLabel();
/*  69 */     this.jCheckBox1 = new JCheckBox();
/*  70 */     this.jLabel59 = new JLabel();
/*  71 */     this.jButton1 = new JButton();
/*  72 */     this.jLabel48 = new JLabel();
/*     */     
/*  74 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  75 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  77 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  78 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Operadores ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  80 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  81 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  82 */     this.jLabel14.setText("Nombre (s)");
/*     */     
/*  84 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  85 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  86 */     this.jLabel32.setText("Apellido Paterno");
/*     */     
/*  88 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  89 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  90 */     this.jLabel38.setHorizontalAlignment(0);
/*  91 */     this.jLabel38.setText("Apellido Materno");
/*     */     
/*  93 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  95 */             OperadoresEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  99 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 101 */             OperadoresEliminar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 105 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 107 */             OperadoresEliminar.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 111 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 112 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 113 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "CUALQUIERA", "PIPA", "GÓNDOLA" }));
/* 114 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 116 */             OperadoresEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 120 */     this.jLabel57.setFont(new Font("Tahoma", 2, 11));
/* 121 */     this.jLabel57.setForeground(new Color(15, 87, 51));
/* 122 */     this.jLabel57.setHorizontalAlignment(0);
/* 123 */     this.jLabel57.setText("Puesto");
/*     */     
/* 125 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 127 */             OperadoresEliminar.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 131 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 132 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 133 */     this.jLabel15.setHorizontalAlignment(0);
/* 134 */     this.jLabel15.setText("Clave");
/*     */     
/* 136 */     this.jLabel58.setFont(new Font("Tahoma", 2, 11));
/* 137 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/* 138 */     this.jLabel58.setHorizontalAlignment(0);
/* 139 */     this.jLabel58.setText("Datos");
/*     */     
/* 141 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 142 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 143 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Activos", "Eliminados", "Todos" }));
/* 144 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 146 */             OperadoresEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 150 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 151 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 152 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "OPERADOR", "FUNCIONARIO", "TODOS" }));
/* 153 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 155 */             OperadoresEliminar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 159 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 160 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 161 */     this.jLabel40.setHorizontalAlignment(0);
/* 162 */     this.jLabel40.setText("Tipo Trabajador");
/*     */     
/* 164 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 165 */     this.jPanel17.setLayout(jPanel17Layout);
/* 166 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 167 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 168 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 169 */           .addContainerGap()
/* 170 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 171 */             .addComponent(this.jLabel15, -2, 49, -2)
/* 172 */             .addComponent(this.jTextField4, -2, 49, -2))
/* 173 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 174 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 175 */             .addComponent(this.jTextField1, -2, 159, -2)
/* 176 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 177 */               .addGap(51, 51, 51)
/* 178 */               .addComponent(this.jLabel14, -2, 63, -2)))
/* 179 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 180 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 181 */             .addComponent(this.jTextField2, -2, 151, -2)
/* 182 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
/* 183 */               .addComponent(this.jLabel32, -2, 90, -2)
/* 184 */               .addGap(27, 27, 27)))
/* 185 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 186 */             .addComponent(this.jTextField3, -2, 163, -2)
/* 187 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 188 */               .addGap(49, 49, 49)
/* 189 */               .addComponent(this.jLabel38)))
/* 190 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 191 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 192 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 193 */             .addComponent(this.jComboBox3, -2, 131, -2))
/* 194 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 195 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 196 */             .addComponent(this.jLabel57, -1, -1, 32767)
/* 197 */             .addComponent(this.jComboBox1, -2, 123, -2))
/* 198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 199 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 200 */             .addComponent(this.jLabel58, -1, -1, 32767)
/* 201 */             .addComponent(this.jComboBox2, -2, 108, -2))
/* 202 */           .addGap(607, 607, 607)));
/*     */     
/* 204 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 205 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 206 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 207 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 209 */               .addComponent(this.jTextField4, -2, -1, -2)
/* 210 */               .addGap(8, 8, 8)
/* 211 */               .addComponent(this.jLabel15))
/* 212 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 213 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 214 */               .addGap(8, 8, 8)
/* 215 */               .addComponent(this.jLabel14))
/* 216 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 217 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 218 */               .addGap(8, 8, 8)
/* 219 */               .addComponent(this.jLabel32))
/* 220 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 221 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 222 */               .addGap(8, 8, 8)
/* 223 */               .addComponent(this.jLabel38))
/* 224 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 225 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 226 */               .addGap(8, 8, 8)
/* 227 */               .addComponent(this.jLabel40))
/* 228 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 229 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 230 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 231 */                 .addComponent(this.jComboBox2, -2, -1, -2))
/* 232 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 233 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 234 */                 .addComponent(this.jLabel57)
/* 235 */                 .addComponent(this.jLabel58))))
/* 236 */           .addContainerGap()));
/*     */ 
/*     */     
/* 239 */     this.jLabel54.setFont(new Font("Tahoma", 1, 20));
/* 240 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 241 */     this.jLabel54.setHorizontalAlignment(0);
/* 242 */     this.jLabel54.setText("Eliminar Operadores");
/*     */     
/* 244 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 245 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 247 */     this.jTable3.setAutoCreateRowSorter(true);
/* 248 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 249 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "Teléfono 1", "Correo", "Abogado", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 257 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 260 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false };
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 265 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 269 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 272 */     this.jTable3.setShowVerticalLines(false);
/* 273 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 275 */             OperadoresEliminar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 278 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 280 */             OperadoresEliminar.this.jTable3KeyReleased(evt);
/*     */           }
/*     */         });
/* 283 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 284 */     if (this.jTable3.getColumnModel().getColumnCount() > 0) {
/* 285 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(40);
/* 286 */       this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 287 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 288 */       this.jTable3.getColumnModel().getColumn(5).setMinWidth(60);
/* 289 */       this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(60);
/* 290 */       this.jTable3.getColumnModel().getColumn(5).setMaxWidth(60);
/* 291 */       this.jTable3.getColumnModel().getColumn(10).setMinWidth(40);
/* 292 */       this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(40);
/* 293 */       this.jTable3.getColumnModel().getColumn(10).setMaxWidth(40);
/*     */     } 
/*     */     
/* 296 */     this.jButton5.setMnemonic('E');
/* 297 */     this.jButton5.setText("Eliminar");
/* 298 */     this.jButton5.setToolTipText("Eliminar (Alt+E)");
/* 299 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 301 */             OperadoresEliminar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 305 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 306 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 307 */     this.jLabel52.setHorizontalAlignment(4);
/* 308 */     this.jLabel52.setText("Si deseas eliminar información, sólo activa la casilla y pulsa el botón 'Eliminar'");
/*     */     
/* 310 */     this.jCheckBox1.setFont(new Font("Tahoma", 2, 10));
/* 311 */     this.jCheckBox1.setText("Seleccionar Todos");
/* 312 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 314 */             OperadoresEliminar.this.jCheckBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 318 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 319 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 320 */     this.jLabel59.setHorizontalAlignment(0);
/* 321 */     this.jLabel59.setText("Activar Operador");
/* 322 */     this.jLabel59.setEnabled(false);
/*     */     
/* 324 */     this.jButton1.setText("Activar");
/* 325 */     this.jButton1.setToolTipText("Activa un operador para que puedas procesar información acerca de él.");
/* 326 */     this.jButton1.setEnabled(false);
/* 327 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 329 */             OperadoresEliminar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 333 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 334 */     this.jLabel48.setForeground(Color.red);
/* 335 */     this.jLabel48.setHorizontalAlignment(0);
/* 336 */     this.jLabel48.setText("t");
/* 337 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 339 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 340 */     this.jPanel5.setLayout(jPanel5Layout);
/* 341 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 342 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 343 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 344 */           .addContainerGap()
/* 345 */           .addComponent(this.jCheckBox1, -2, 129, -2)
/* 346 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 347 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 348 */           .addGap(92, 92, 92)
/* 349 */           .addComponent(this.jLabel59, -2, 99, -2)
/* 350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 351 */           .addComponent(this.jButton1, -2, 93, -2)
/* 352 */           .addGap(18, 18, 18)
/* 353 */           .addComponent(this.jLabel52, -2, 383, -2)
/* 354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 355 */           .addComponent(this.jButton5, -2, 105, -2)
/* 356 */           .addContainerGap(-1, 32767))
/* 357 */         .addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING));
/*     */     
/* 359 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 360 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 361 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 362 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 363 */             .addComponent(this.jCheckBox1)
/* 364 */             .addComponent(this.jLabel59)
/* 365 */             .addComponent(this.jButton1)
/* 366 */             .addComponent(this.jButton5)
/* 367 */             .addComponent(this.jLabel52)
/* 368 */             .addComponent(this.jLabel48))
/* 369 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 370 */           .addComponent(this.jScrollPane3, -1, 167, 32767)));
/*     */ 
/*     */     
/* 373 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 374 */     this.jPanel1.setLayout(jPanel1Layout);
/* 375 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 376 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 377 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 378 */           .addContainerGap()
/* 379 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 380 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 381 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 382 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 383 */               .addGap(240, 240, 240)
/* 384 */               .addComponent(this.jLabel54, -2, 958, -2)))
/* 385 */           .addContainerGap()));
/*     */     
/* 387 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 389 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 390 */           .addComponent(this.jLabel54, -2, 26, -2)
/* 391 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 392 */           .addComponent(this.jPanel17, -2, 68, -2)
/* 393 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 394 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 397 */     GroupLayout layout = new GroupLayout(this);
/* 398 */     setLayout(layout);
/* 399 */     layout.setHorizontalGroup(layout
/* 400 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 401 */         .addGap(0, 1601, 32767)
/* 402 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 403 */           .addGroup(layout.createSequentialGroup()
/* 404 */             .addContainerGap()
/* 405 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 406 */             .addContainerGap())));
/*     */     
/* 408 */     layout.setVerticalGroup(layout
/* 409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 410 */         .addGap(0, 343, 32767)
/* 411 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 412 */           .addGroup(layout.createSequentialGroup()
/* 413 */             .addGap(7, 7, 7)
/* 414 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 415 */             .addGap(8, 8, 8))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 420 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 424 */     consultar();
/*     */   }
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 427 */     consultar();
/*     */   }
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 430 */     consultar();
/*     */   }
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 433 */     String ind = "";
/* 434 */     int contar = 0;
/* 435 */     this.contador = 0;
/* 436 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 437 */       String val = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 438 */       if (val.equals("true")) {
/* 439 */         contar++;
/*     */       }
/*     */     } 
/* 442 */     if (contar == 0) {
/* 443 */       JOptionPane.showMessageDialog(this.padre, "Necesitas activar una casilla para poder eliminar operadores", "Selecciona Un Operador", 0, this.INFO);
/*     */     }
/* 445 */     else if (contar == 1) {
/* 446 */       int doc = 0;
/* 447 */       for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 448 */         String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 449 */         if (val.equals("true")) {
/* 450 */           String str = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 451 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 455 */       String valor = "<html><b>Número de Operador: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 3)) + "<br></html>";
/* 456 */       if (this.jComboBox2.getSelectedIndex() == 0) {
/* 457 */         int res = JOptionPane.showConfirmDialog(this.padre, "A continuación se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas guardar un historial para consultas posteriores?", "Eliminar Operador", 1, 2, this.ELIMINAR);
/* 458 */         if (res == 0) {
/* 459 */           String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/* 460 */           this.con.inserSinMsj("update operadores set actual = 1 where num_ope = " + String.valueOf(this.jTable3.getValueAt(doc, 1)));
/* 461 */           this.con.inserSinMsj("update tarjeta_deudor set estatus='<BAJA>' where tipo = 'operador' and num_ope = " + String.valueOf(this.jTable3.getValueAt(doc, 1)));
/* 462 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el operador " + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "','Clave Operador: " + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "\nSe almacenó para consultas posteriores')");
/* 463 */           this.con.consultar("comentarios", "operadores", "where num_ope = " + String.valueOf(this.jTable3.getValueAt(doc, 1)));
/* 464 */           String var = this.con.Campo;
/* 465 */           this.mensajeTry.guardarConf("Se ha eliminado un operador-" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2)) + ", Usuario: " + this.USUARIO, "Operador de Baja", "ERROR", "Operadores");
/* 466 */           String nuevo = "EL OPERADOR SE DIÓ DE BAJA EN ESTA FECHA.";
/* 467 */           this.con.inserSinMsj("update operadores set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where num_ope = " + String.valueOf(this.jTable3.getValueAt(doc, 1)));
/*     */           
/* 469 */           consultar();
/* 470 */           JOptionPane.showMessageDialog(this.padre, "Se ha eliminado el operador satisfactoriamente con clave " + val, "Operador Eliminado", 0, this.INFO);
/*     */         }
/* 472 */         else if (res == 1) {
/* 473 */           String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/* 474 */           String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,fecha_licen,tipo_licen,num_licen,nss,rfc,ingreso,num_tracto,num_rem", "operadores", "where num_ope = " + val, 19);
/* 475 */           this.encontrado = this.con.consultar("num_ope", "llamadas_historicas", "where num_ope = " + val);
/* 476 */           if (this.encontrado) {
/* 477 */             JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el operador ya que tiene viajes en su historial\nSi eliminas esta información también desaparecerá su historial de viajes.", "VIAJES ASIGNADOS", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 480 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el operador " + val + " definitivamente.','Clave Operador: " + val + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nFecha de Licencia: " + reg[11] + "\nNúmero de Licencia y Tipo: " + reg[13] + " " + reg[12] + "\nNSS: " + reg[14] + "\nRFC: " + reg[15] + "\nFecha de Ingreso: " + reg[16] + "\nNúmero de Tracto y Caja: " + reg[17] + " " + reg[18] + "')");
/* 481 */             this.con.eliminar2("operadores", "where num_ope = '" + val + "'");
/* 482 */             this.mensajeTry.guardarConf("Se ha eliminado un operador-" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2)) + ", Usuario: " + this.USUARIO, "Operador ELiminado", "ERROR", "Operadores");
/* 483 */             consultar();
/* 484 */             JOptionPane.showMessageDialog(this.padre, "Se ha eliminado definitivamente el operador con clave " + val, "Operador Eliminado", 0, this.INFO);
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 489 */         valor = "<html><b>Número de Operador: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 3)) + "<br></html>";
/* 490 */         int res = JOptionPane.showConfirmDialog(this.padre, "Se eliminarán los siguientes datos:\n" + valor + "\n¿Deseas eliminar los datos definitivamente?", "Eliminar Operadores", 0, 3, this.ELIMINAR);
/* 491 */         if (res == 0) {
/* 492 */           String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/* 493 */           this.encontrado = this.con.consultar("num_ope", "llamadas_historicas", "where num_ope = " + val);
/* 494 */           if (this.encontrado) {
/* 495 */             JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el operador ya que tiene viajes en su historial\nSi eliminas esta información también desaparecerá su historial de viajes.", "VIAJES ASIGNADOS", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 498 */             this.con.eliminar2("operadores", "where num_ope = '" + val + "'");
/* 499 */             this.mensajeTry.guardarConf("Se ha eliminado un operador-" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2)) + ", Usuario: " + this.USUARIO, "Operador ELiminado", "ERROR", "Operadores");
/* 500 */             consultar();
/* 501 */             JOptionPane.showMessageDialog(this.padre, "Se ha eliminado definitivamente el operador con clave " + val, "Operador Eliminado", 0, this.INFO);
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } 
/* 507 */     } else if (this.jComboBox2.getSelectedIndex() == 0) {
/* 508 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos y poder consultar los datos posteriormente?", "Eliminar Operadores", 1, 2, this.ELIMINAR);
/* 509 */       if (res == 0) {
/* 510 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 511 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 512 */           if (val.equals("true")) {
/* 513 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 514 */             this.contador++;
/* 515 */             this.con.inserSinMsj("update tarjeta_deudor set estatus='<BAJA>' where tipo = 'operador' and num_ope = " + valor);
/* 516 */             this.con.inserSinMsj("update operadores set actual = 1 where num_ope = " + valor);
/*     */             
/* 518 */             this.con.consultar("comentarios", "operadores", "where num_ope = " + valor);
/* 519 */             String var = this.con.Campo;
/* 520 */             String nuevo = "EL OPERADOR SE DIÓ DE BAJA EN ESTA FECHA.";
/* 521 */             this.con.inserSinMsj("update operadores set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where num_ope = " + valor);
/*     */             
/* 523 */             this.mensajeTry.guardarConf("Se han eliminado varios operadores, Usuario: " + this.USUARIO, "Operador de Baja", "ERROR", "Operadores");
/*     */             
/* 525 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el operador " + valor + "','Clave Operador: " + valor + "\nSe almacenó para consultas posteriores')");
/*     */           } 
/*     */         } 
/* 528 */         consultar();
/* 529 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado satisfactoriamente " + this.contador + " operadores.", "Operador Eliminado", 0, this.INFO);
/*     */       }
/* 531 */       else if (res == 1) {
/* 532 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 533 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 534 */           if (val.equals("true")) {
/* 535 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 536 */             this.encontrado = this.con.consultar("num_ope", "llamadas_historicas", "where num_ope = " + valor);
/* 537 */             if (this.encontrado) {
/* 538 */               JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el operador ya que tiene viajes en su historial\nSi eliminas esta información también desaparecerá su historial de viajes.", "VIAJES ASIGNADOS", 0, this.ERROR);
/*     */             } else {
/*     */               
/* 541 */               String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,fecha_licen,tipo_licen,num_licen,nss,rfc,ingreso,num_tracto,num_rem", "operadores", "where num_ope = " + valor, 19);
/* 542 */               this.contador++;
/* 543 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el operador " + valor + " definitivamente.','Clave Operador: " + valor + "\nNombre Completo: " + reg[0] + " " + reg[1] + " " + reg[2] + "\nDirección: " + reg[3] + " " + reg[4] + " " + reg[5] + " " + reg[6] + " " + reg[7] + "\nTeléfonos: " + reg[8] + " " + reg[9] + "\nFecha de Nacimiento: " + reg[10] + "\nFecha de Licencia: " + reg[11] + "\nNúmero de Licencia y Tipo: " + reg[13] + " " + reg[12] + "\nNSS: " + reg[14] + "\nRFC: " + reg[15] + "\nFecha de Ingreso: " + reg[16] + "\nNúmero de Tracto y Caja: " + reg[17] + " " + reg[18] + "')");
/* 544 */               this.con.eliminar2("operadores", "where num_ope = '" + valor + "'");
/* 545 */               this.mensajeTry.guardarConf("Se ha eliminado varios operadores, Usuario: " + this.USUARIO, "Operador Eliminado", "ERROR", "Operadores");
/*     */             } 
/*     */           } 
/*     */         } 
/* 549 */         consultar();
/* 550 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado definitivamente " + this.contador + " operadores.", "Operador Eliminados", 0, this.INFO);
/*     */       } 
/*     */     } else {
/*     */       
/* 554 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas eliminar estos " + contar + " elementos definitivamente?", "Eliminar Operadores", 0, 3, this.ELIMINAR);
/* 555 */       if (res == 0) {
/* 556 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 557 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 558 */           if (val.equals("true")) {
/* 559 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 560 */             this.encontrado = this.con.consultar("num_ope", "llamadas_historicas", "where num_ope = " + valor);
/* 561 */             if (this.encontrado) {
/* 562 */               JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el operador ya que tiene viajes en su historial\nSi eliminas esta información también desaparecerá su historial de viajes.", "VIAJES ASIGNADOS", 0, this.ERROR);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 571 */         consultar();
/* 572 */         JOptionPane.showMessageDialog(this.padre, "Se han eliminado definitivamente " + this.contador + " operadores.", "Operadores Eliminados", 0, this.INFO);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 579 */     if (this.jCheckBox1.isSelected() == true) {
/* 580 */       for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 581 */         this.jTable3.setValueAt(Boolean.valueOf(true), i, 0);
/*     */       }
/*     */     } else {
/*     */       
/* 585 */       for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 586 */         this.jTable3.setValueAt(Boolean.valueOf(false), i, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 592 */     consultar();
/*     */   }
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 595 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 596 */       this.jButton1.setEnabled(false);
/* 597 */       this.jLabel59.setEnabled(false);
/*     */     } else {
/*     */       
/* 600 */       this.jButton1.setEnabled(true);
/* 601 */       this.jLabel59.setEnabled(true);
/*     */     } 
/* 603 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 607 */     cambiar();
/*     */   }
/*     */   
/*     */   private void jTable3KeyReleased(KeyEvent evt) {
/* 611 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 615 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 616 */     int ind = this.jTable3.getSelectedRow();
/* 617 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 618 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 619 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 623 */     consultar();
/*     */   }
/*     */   public void operadores(String usu) {
/* 626 */     this.USUARIO = usu;
/* 627 */     this.panel.setViewportView(this);
/* 628 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 631 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 633 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 636 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 639 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 641 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jTextField4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 644 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jTextField4, evt);
/*     */           }
/*     */         });
/* 647 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 649 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 652 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 655 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 657 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jTextField3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 660 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 663 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 665 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 668 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 671 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 673 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 676 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 679 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 681 */             OperadoresEliminar.this.jTextGanado(OperadoresEliminar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 684 */             OperadoresEliminar.this.jTextPerdido(OperadoresEliminar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 689 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 692 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 695 */     this.jCheckBox1.setSelected(false);
/* 696 */     String datos = "0";
/* 697 */     String tipo = "";
/* 698 */     String actual = "0";
/* 699 */     String trabajador = "";
/* 700 */     if (this.jComboBox2.getSelectedIndex() == 1) {
/* 701 */       actual = "1";
/*     */     }
/* 703 */     else if (this.jComboBox2.getSelectedIndex() == 2) {
/* 704 */       actual = "";
/*     */     } 
/* 706 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 707 */       tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 709 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 710 */       datos = "1";
/*     */     }
/* 712 */     if (this.jComboBox3.getSelectedIndex() != 2) {
/* 713 */       trabajador = this.jComboBox3.getSelectedItem().toString();
/*     */     }
/* 715 */     this.encontrado = this.con.consultar("count(num_ope)", "operadores,estados", "where num_ope like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and tipoTrabajador like '%" + trabajador + "%' and operadores.id_edo=estados.id_edo and operadores.tipo like '%" + tipo + "%' and actual like '%" + actual + "%' order by num_ope");
/* 716 */     int totreg = Integer.parseInt(this.con.Campo);
/* 717 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 718 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 719 */           .buscarReg(24, totreg, "num_ope,ap_pat,ap_mat,nombre,calle,num,col,cp,ciudad,estados.estado,tel_casa,celular,fecha_nac,fecha_licen,num_licen,tipo_licen,nss,rfc,ingreso,numInfo,infonavitLetra,tipoTrabajador,num_tracto,num_rem", "operadores,estados", "where num_ope like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and tipoTrabajador like '%" + trabajador + "%' and operadores.id_edo=estados.id_edo and operadores.tipo like '%" + tipo + "%' and actual like '%" + actual + "%' order by num_ope"), (Object[])new String[] { "Núm", "Nombre Completo", "Apellido Materno", "Nombre", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Fecha de Nac.", "Venc. Licen.", "# Licencia", "Tipo", "NSS", "RFC", "Ingreso", "Infonavit", "Infonavit $", "Trabajador", "T", "C", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 724 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 728 */             return this.canEdit[columnIndex];
/*     */           }
/* 730 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 734 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/* 737 */     this.jTable3.setShowVerticalLines(false);
/* 738 */     eliminarColumna(2, 1, "Apellido Materno");
/* 739 */     eliminarColumna(2, 1, "Nombre");
/*     */     
/* 741 */     eliminarColumna(3, 2, "Número");
/* 742 */     eliminarColumna(3, 2, "Colonia");
/* 743 */     eliminarColumna(3, 2, "CP");
/* 744 */     eliminarColumna(3, 2, "Ciudad");
/* 745 */     eliminarColumna(3, 2, "Estado");
/* 746 */     eliminarColumna(8, 7, "Tipo");
/*     */     
/* 748 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 749 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 750 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 751 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(270);
/* 752 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(270);
/* 753 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 754 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 755 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 756 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(70);
/* 757 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 758 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 759 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 760 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 761 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(75);
/* 762 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(75);
/* 763 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(65);
/* 764 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(65);
/* 765 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 766 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 767 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(60);
/* 768 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(60);
/* 769 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(60);
/* 770 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(60);
/* 771 */     this.jTable3.getColumnModel().getColumn(12).setPreferredWidth(60);
/* 772 */     this.jTable3.getColumnModel().getColumn(12).setMaxWidth(60);
/* 773 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(30);
/* 774 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(30);
/* 775 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(90);
/* 776 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(90);
/* 777 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(30);
/* 778 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(30);
/* 779 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(30);
/* 780 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(30);
/* 781 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(50);
/* 782 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(50);
/*     */     
/* 784 */     this.jTable3.setSelectionMode(0);
/* 785 */     this.jTable3.setAutoCreateRowSorter(true);
/* 786 */     this.jTable3.getColumnModel().moveColumn(16, 0);
/* 787 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 789 */     if (this.jComboBox2.getSelectedIndex() == 2) {
/* 790 */       this.con.consultar("count(num_ope)", "operadores", "where actual =1");
/* 791 */       String[] arre = this.con.regresaCol("num_ope", "operadores", "where actual =1", Integer.parseInt(this.con.Campo));
/* 792 */       this.celda.pasarInd(arre);
/*     */     } else {
/*     */       
/* 795 */       String[] arre = new String[0];
/* 796 */       this.celda.pasarInd(arre);
/*     */     } 
/*     */     
/* 799 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 800 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 801 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 802 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 803 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 804 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 805 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 806 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 807 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 808 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 809 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 810 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 811 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 812 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 813 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 814 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 817 */     int cont = this.jTable3.getRowCount();
/* 818 */     String[] registros = new String[cont]; int i;
/* 819 */     for (i = 0; i < cont; i++) {
/* 820 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*     */     }
/* 822 */     for (i = 0; i < cont; i++) {
/* 823 */       registros[i] = registros[i] + " " + registros[i];
/* 824 */       this.jTable3.setValueAt(registros[i], i, destino);
/*     */     } 
/* 826 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 827 */     this.jTable3.removeColumn(columna);
/*     */   }
/*     */   public void eliminarOperador(String valor) {
/* 830 */     boolean unico = false;
/* 831 */     this.con.consultar("count(num_ope)", "operadores", "where num_ope=" + valor);
/* 832 */     String[] tocas = this.con.regresaCol("toca", "actores_demandas", "where id_actores=" + valor, Integer.parseInt(this.con.Campo));
/* 833 */     for (int i = 0; i < tocas.length; i++) {
/* 834 */       this.con.consultar("count(id_actores)", "actores_demandas", "where toca='" + tocas[i] + "'");
/* 835 */       int total = Integer.parseInt(this.con.Campo);
/* 836 */       if (total == 1) {
/* 837 */         unico = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 841 */     if (!unico) {
/* 842 */       String[] inf = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,estado,tel1,tel2,correo,sexo,abogado", "actores", "where id_actores='" + valor + "'", 14);
/* 843 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el actor No: " + valor + "','Nombre: " + inf[0] + "\nApellido Paterno: " + inf[1] + "\nApellido Materno: " + inf[2] + "\nCalle: " + inf[3] + "\nNúmero: " + inf[4] + "\nColonia: " + inf[5] + "\nCódigo Postal: " + inf[6] + "\nCiudad: " + inf[7] + "\nEstado: " + inf[8] + "\nTeléfono 1: " + inf[9] + "\nTeléfono 2: " + inf[10] + "\nCorreo: " + inf[11] + "\nSexo: " + inf[12] + "\nAbogado: " + inf[13] + "')");
/* 844 */       this.con.eliminar("actores", "where id_actores = " + valor);
/* 845 */       this.con.eliminar2("actores_demandas", "where id_actores = " + valor);
/*     */     } else {
/*     */       
/* 848 */       JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el actor que seleccionaste porque sólo existe\n esa persona asignado a una demanda.", "Único Actor", 0, this.ERROR);
/*     */     } 
/*     */   }
/*     */   public void eliminarActor2(String valor) {
/* 852 */     boolean unico = false;
/* 853 */     this.con.consultar("count(toca)", "actores_demandas", "where id_actores=" + valor);
/* 854 */     String[] tocas = this.con.regresaCol("toca", "actores_demandas", "where id_actores=" + valor, Integer.parseInt(this.con.Campo));
/* 855 */     for (int i = 0; i < tocas.length; i++) {
/* 856 */       this.con.consultar("count(id_actores)", "actores_demandas", "where toca='" + tocas[i] + "'");
/* 857 */       int total = Integer.parseInt(this.con.Campo);
/* 858 */       if (total == 1) {
/* 859 */         unico = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 863 */     if (!unico) {
/* 864 */       this.contador++;
/* 865 */       String[] inf = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,estado,tel1,tel2,correo,sexo,abogado", "actores", "where id_actores='" + valor + "'", 14);
/* 866 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Eliminó el Actor No: " + valor + "','Nombre: " + inf[0] + "\nApellido Paterno: " + inf[1] + "\nApellido Materno: " + inf[2] + "\nCalle: " + inf[3] + "\nNúmero: " + inf[4] + "\nColonia: " + inf[5] + "\nCódigo Postal: " + inf[6] + "\nCiudad: " + inf[7] + "\nEstado: " + inf[8] + "\nTeléfono 1: " + inf[9] + "\nTeléfono 2: " + inf[10] + "\nCorreo: " + inf[11] + "\nSexo: " + inf[12] + "\nAbogado: " + inf[13] + "')");
/* 867 */       this.con.eliminar2("actores", "where id_actores = " + valor);
/* 868 */       this.con.eliminar2("actores_demandas", "where id_actores = " + valor);
/*     */     } else {
/*     */       
/* 871 */       JOptionPane.showMessageDialog(this.padre, "No puedes eliminar el actor con identificador " + valor + ", porque sólo existe esa persona\n asignado a una demanda, se intentarán eliminar los demás actores.", "Único Actor", 0, this.ERROR);
/*     */     } 
/*     */   }
/*     */   public void cambiar() {
/* 875 */     String ind = "";
/* 876 */     int contar = 0;
/* 877 */     this.contador = 0;
/* 878 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 879 */       String val = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 880 */       if (val.equals("true")) {
/* 881 */         contar++;
/*     */       }
/*     */     } 
/* 884 */     if (contar == 0) {
/* 885 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una casilla para volver a activar algún operador", "Selecciona un operador", 0, this.INFO);
/*     */     }
/* 887 */     else if (contar == 1) {
/* 888 */       int doc = 0;
/* 889 */       for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 890 */         String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 891 */         if (val.equals("true")) {
/* 892 */           String str = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 893 */           doc = j;
/*     */           break;
/*     */         } 
/*     */       } 
/* 897 */       String valor = "<html><b>Número de Operador: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 1)) + "<br><b>Nombre Completo: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 2)) + "<br><b>Dirección: </b>" + String.valueOf(this.jTable3.getValueAt(doc, 3)) + "<br></html>";
/* 898 */       int res = JOptionPane.showConfirmDialog(this.padre, "Se activará el siguiente operador:\n" + valor + "\n¿Estás seguro que deseas volver a activar el operador?", "Activar Operadores", 0, 3, this.PREG);
/*     */       
/* 900 */       if (res == 0) {
/* 901 */         String val = String.valueOf(this.jTable3.getValueAt(doc, 1));
/*     */         
/* 903 */         this.con.inserSinMsj("update operadores set actual = 0 where num_ope = " + val);
/* 904 */         this.con.inserSinMsj("update tarjeta_deudor set estatus = '<CONGELADA>' where num_ope = " + val);
/* 905 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Activo Operador " + val + "','Clave Operador: " + val + "\nSe activó el operador')");
/*     */         
/* 907 */         this.con.consultar("comentarios", "operadores", "where num_ope = " + val);
/* 908 */         String var = this.con.Campo;
/* 909 */         String nuevo = "EL OPERADOR SE ACTIVÓ EN ESTA FECHA";
/* 910 */         this.con.inserSinMsj("update operadores set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where num_ope = " + val);
/*     */         
/* 912 */         consultar();
/* 913 */         JOptionPane.showMessageDialog(this.padre, "Se ha activado satisfactoriamente el operador con clave " + val, "Operador Activado", 0, this.INFO);
/*     */       } 
/*     */     } else {
/*     */       
/* 917 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas activar estos " + contar + " elementos para poder actualizar información?", "Activar Operadores", 0, 3, this.PREG);
/* 918 */       if (res == 0) {
/* 919 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 920 */           String val = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 921 */           if (val.equals("true")) {
/* 922 */             String valor = String.valueOf(this.jTable3.getValueAt(j, 1));
/* 923 */             this.contador++;
/* 924 */             this.con.inserSinMsj("update operadores set actual = 0 where num_ope = " + valor);
/* 925 */             this.con.inserSinMsj("update tarjeta_deudor set estatus = '<CONGELADA>' where num_ope = " + valor);
/*     */             
/* 927 */             this.con.consultar("comentarios", "operadores", "where num_ope = " + valor);
/* 928 */             String var = this.con.Campo;
/* 929 */             String nuevo = "EL OPERADOR SE ACTIVÓ EN ESTA FECHA.";
/* 930 */             this.con.inserSinMsj("update operadores set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where num_ope = " + valor);
/*     */             
/* 932 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Activo Operador " + val + "','Clave Operador: " + val + "\nSe activó el operador')");
/*     */           } 
/*     */         } 
/* 935 */         consultar();
/* 936 */         JOptionPane.showMessageDialog(this.padre, "Se han activado satisfactoriamente " + this.contador + " operadores.", "Operadores Activados", 0, this.INFO);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public String cargarFechaHoy() {
/* 941 */     Date fecha = new Date();
/* 942 */     Calendar ahoraCal = Calendar.getInstance();
/* 943 */     ahoraCal.setTime(fecha);
/* 944 */     String mesesito = "";
/* 945 */     String hoy = "";
/* 946 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 947 */     hoy = "" + ahoraCal.get(5);
/* 948 */     if (ahoraCal.get(2) + 1 < 10) {
/* 949 */       mesesito = "0" + mesesito;
/*     */     }
/* 951 */     if (ahoraCal.get(5) < 10) {
/* 952 */       hoy = "0" + hoy;
/*     */     }
/* 954 */     return "(" + hoy + "/" + mesesito + "/" + ahoraCal.get(1) + "): ";
/*     */   }
/*     */   
/* 957 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 958 */     String[] indices = new String[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 960 */       setEnabled((table == null || table.isEnabled()));
/* 961 */       String valor = "PR-06055";
/* 962 */       String comp = String.valueOf(table.getValueAt(row, 1));
/* 963 */       if (comparar(comp)) {
/* 964 */         setBackground(Color.red);
/* 965 */         setForeground(Color.white);
/*     */       }
/* 967 */       else if (row % 2 == 0) {
/* 968 */         setBackground(new Color(194, 213, 151));
/* 969 */         setForeground(Color.black);
/*     */       } else {
/*     */         
/* 972 */         setBackground((Color)null);
/* 973 */         setForeground(Color.black);
/*     */       } 
/* 975 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 976 */       return this;
/*     */     }
/*     */     public void pasarInd(String[] ind) {
/* 979 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(String reg) {
/* 982 */       for (int i = 0; i < this.indices.length; i++) {
/* 983 */         if (this.indices[i].equals(reg)) {
/* 984 */           return true;
/*     */         }
/*     */       } 
/* 987 */       return false;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/OperadoresEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */