/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class Plataformas extends JPanel {
/*  20 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  21 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  22 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  23 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  24 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  25 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*     */   JScrollPane panel;
/*  27 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  28 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  29 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  30 */   String USUARIO = "";
/*  31 */   Validaciones val = new Validaciones();
/*  32 */   Consultas con = new Consultas();
/*  33 */   Errores error = new Errores(false);
/*     */   String id;
/*     */   JTabbedPane fichas;
/*     */   int INDICE;
/*     */   JFrame padre;
/*  38 */   cargarDatos datos = new cargarDatos("Equipos");
/*     */   boolean encontrado = false;
/*  40 */   CeldaRender celda = new CeldaRender();
/*  41 */   CeldaRender2 celda2 = new CeldaRender2();
/*  42 */   MensajePop mensajeTry = null; private JButton jButton1; private JButton jButton2; private JButton jButton6; private JButton jButton8; private JComboBox jComboBox1; private JLabel jLabel1; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel48; private JPanel jPanel1;
/*     */   public Plataformas(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry) {
/*  44 */     this.mensajeTry = mensajeTry;
/*  45 */     initComponents();
/*  46 */     this.USUARIO = usua;
/*  47 */     this.padre = padre;
/*  48 */     this.id = num;
/*  49 */     this.fichas = fichas;
/*  50 */     initComponents();
/*  51 */     panelito.setViewportView(this);
/*  52 */     this.panel = panelito;
/*  53 */     colorear();
/*  54 */     consultar();
/*  55 */     verDatos();
/*     */   }
/*     */   private JPanel jPanel2; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel6; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JSeparator jSeparator1; private JTable jTable1; private JTable jTable2; private JTextField jTextField1; private JTextField jTextField2;
/*     */   
/*     */   private void initComponents() {
/*  60 */     this.jPanel2 = new JPanel();
/*  61 */     this.jLabel34 = new JLabel();
/*  62 */     this.jComboBox1 = new JComboBox();
/*  63 */     this.jPanel1 = new JPanel();
/*  64 */     this.jPanel6 = new JPanel();
/*  65 */     this.jLabel1 = new JLabel();
/*  66 */     this.jPanel21 = new JPanel();
/*  67 */     this.jTextField1 = new JTextField();
/*  68 */     this.jLabel32 = new JLabel();
/*  69 */     this.jButton6 = new JButton();
/*  70 */     this.jPanel22 = new JPanel();
/*  71 */     this.jScrollPane1 = new JScrollPane();
/*  72 */     this.jTable1 = new JTable();
/*  73 */     this.jLabel33 = new JLabel();
/*  74 */     this.jTextField2 = new JTextField();
/*  75 */     this.jSeparator1 = new JSeparator();
/*  76 */     this.jButton8 = new JButton();
/*  77 */     this.jLabel48 = new JLabel();
/*  78 */     this.jButton1 = new JButton();
/*  79 */     this.jButton2 = new JButton();
/*  80 */     this.jScrollPane2 = new JScrollPane();
/*  81 */     this.jTable2 = new JTable();
/*     */     
/*  83 */     this.jLabel34.setFont(new Font("Tahoma", 3, 11));
/*  84 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/*  85 */     this.jLabel34.setHorizontalAlignment(4);
/*  86 */     this.jLabel34.setText("Selecciona el Equipo");
/*     */     
/*  88 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*     */     
/*  90 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  91 */     this.jPanel2.setLayout(jPanel2Layout);
/*  92 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  93 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  94 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  95 */           .addComponent(this.jLabel34, -2, 121, -2)
/*  96 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  97 */           .addComponent(this.jComboBox1, 0, 404, 32767)
/*  98 */           .addContainerGap()));
/*     */     
/* 100 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 102 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 103 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 104 */             .addComponent(this.jLabel34)
/* 105 */             .addComponent(this.jComboBox1, -2, -1, -2))
/* 106 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 109 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 110 */     this.jPanel1.setLayout(jPanel1Layout);
/* 111 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 112 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 113 */         .addGap(0, 656, 32767));
/*     */     
/* 115 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 116 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 117 */         .addGap(0, 283, 32767));
/*     */ 
/*     */     
/* 120 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 121 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 123 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/* 124 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/* 125 */     this.jLabel1.setHorizontalAlignment(0);
/* 126 */     this.jLabel1.setText("Agregar Plataformas");
/*     */     
/* 128 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/* 129 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " Agregar Plataformas ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 131 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 133 */             Plataformas.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 137 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/* 138 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 139 */     this.jLabel32.setHorizontalAlignment(4);
/* 140 */     this.jLabel32.setText("Nombre");
/*     */     
/* 142 */     this.jButton6.setMnemonic('A');
/* 143 */     this.jButton6.setText("Agregar");
/* 144 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/* 145 */     this.jButton6.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 147 */             Plataformas.this.jButton6ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 151 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 152 */     this.jPanel21.setLayout(jPanel21Layout);
/* 153 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 155 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 156 */           .addContainerGap()
/* 157 */           .addComponent(this.jLabel32, -2, 65, -2)
/* 158 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 159 */           .addComponent(this.jTextField1, -2, 252, -2)
/* 160 */           .addGap(18, 18, 18)
/* 161 */           .addComponent(this.jButton6)
/* 162 */           .addContainerGap(-1, 32767)));
/*     */     
/* 164 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 165 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 166 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 167 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 168 */             .addComponent(this.jLabel32)
/* 169 */             .addComponent(this.jButton6)
/* 170 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 171 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 174 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 175 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "Organizar Plataformas ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 177 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre de la PLataforma" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 185 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 190 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 193 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 195 */             Plataformas.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/* 198 */     this.jTable1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 200 */             Plataformas.this.jTable1KeyReleased(evt);
/*     */           }
/*     */         });
/* 203 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 204 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/* 205 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 206 */       this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 207 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/*     */     } 
/*     */     
/* 210 */     this.jLabel33.setFont(new Font("Tahoma", 2, 11));
/* 211 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/* 212 */     this.jLabel33.setHorizontalAlignment(4);
/* 213 */     this.jLabel33.setText("Buscar");
/*     */     
/* 215 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 217 */             Plataformas.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 221 */     this.jButton8.setMnemonic('E');
/* 222 */     this.jButton8.setText("Eliminar");
/* 223 */     this.jButton8.setToolTipText("Eliminar (Alt+E)");
/* 224 */     this.jButton8.setEnabled(false);
/* 225 */     this.jButton8.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 227 */             Plataformas.this.jButton8ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 231 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 232 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 233 */     this.jLabel48.setHorizontalAlignment(2);
/* 234 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 236 */     this.jButton1.setMnemonic('S');
/* 237 */     this.jButton1.setText("Asignar Equipo");
/* 238 */     this.jButton1.setToolTipText("Asignar Equipo (Alt+S)");
/* 239 */     this.jButton1.setEnabled(false);
/* 240 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 242 */             Plataformas.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 246 */     this.jButton2.setMnemonic('Q');
/* 247 */     this.jButton2.setText("Quitar Equipo");
/* 248 */     this.jButton2.setToolTipText("Quitar Equipo Asignado (Alt+Q)");
/* 249 */     this.jButton2.setEnabled(false);
/* 250 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 252 */             Plataformas.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 256 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre de la PLataforma" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 264 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 269 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 272 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 274 */             Plataformas.this.jTable2MouseClicked(evt);
/*     */           }
/*     */         });
/* 277 */     this.jTable2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 279 */             Plataformas.this.jTable2KeyReleased(evt);
/*     */           }
/*     */         });
/* 282 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 283 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/* 284 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(60);
/* 285 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 286 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
/*     */     } 
/*     */     
/* 289 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 290 */     this.jPanel22.setLayout(jPanel22Layout);
/* 291 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 292 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 293 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 294 */           .addContainerGap()
/* 295 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 296 */             .addGroup(jPanel22Layout.createSequentialGroup()
/* 297 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 298 */                 .addGroup(jPanel22Layout.createSequentialGroup()
/* 299 */                   .addComponent(this.jLabel33, -2, 71, -2)
/* 300 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 301 */                   .addComponent(this.jTextField2, -2, 248, -2))
/* 302 */                 .addComponent(this.jScrollPane1, -2, -1, -2)
/* 303 */                 .addComponent(this.jLabel48, -2, 259, -2))
/* 304 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 305 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 306 */                 .addGroup(jPanel22Layout.createSequentialGroup()
/* 307 */                   .addComponent(this.jButton2)
/* 308 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 309 */                   .addComponent(this.jButton1)
/* 310 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 311 */                   .addComponent(this.jButton8, -2, 85, -2))
/* 312 */                 .addComponent(this.jScrollPane2, -2, -1, -2)))
/* 313 */             .addComponent(this.jSeparator1))
/* 314 */           .addContainerGap()));
/*     */     
/* 316 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 318 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 319 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 320 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 321 */             .addComponent(this.jLabel33))
/* 322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 323 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 324 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 325 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 326 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 162, 32767)
/* 327 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 0, 32767))
/* 328 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 329 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 330 */             .addComponent(this.jLabel48, GroupLayout.Alignment.TRAILING)
/* 331 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 332 */               .addComponent(this.jButton8)
/* 333 */               .addComponent(this.jButton1)
/* 334 */               .addComponent(this.jButton2)))
/* 335 */           .addContainerGap()));
/*     */ 
/*     */     
/* 338 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 339 */     this.jPanel6.setLayout(jPanel6Layout);
/* 340 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 342 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 343 */           .addContainerGap()
/* 344 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */             .addComponent(this.jPanel21, -1, -1, 32767)
/* 346 */             .addComponent(this.jPanel22, -1, -1, 32767)
/* 347 */             .addComponent(this.jLabel1, -1, -1, 32767))
/* 348 */           .addContainerGap()));
/*     */     
/* 350 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 352 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 353 */           .addContainerGap()
/* 354 */           .addComponent(this.jLabel1)
/* 355 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 356 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 358 */           .addComponent(this.jPanel22, -1, -1, 32767)
/* 359 */           .addContainerGap()));
/*     */ 
/*     */     
/* 362 */     GroupLayout layout = new GroupLayout(this);
/* 363 */     setLayout(layout);
/* 364 */     layout.setHorizontalGroup(layout
/* 365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 366 */         .addGap(0, 996, 32767)
/* 367 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 368 */           .addGroup(layout.createSequentialGroup()
/* 369 */             .addGap(0, 0, 32767)
/* 370 */             .addComponent(this.jPanel6, -2, -1, -2)
/* 371 */             .addGap(0, 0, 32767))));
/*     */     
/* 373 */     layout.setVerticalGroup(layout
/* 374 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 375 */         .addGap(0, 433, 32767)
/* 376 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 377 */           .addGroup(layout.createSequentialGroup()
/* 378 */             .addContainerGap()
/* 379 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 380 */             .addContainerGap())));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 385 */     guardarEquipos();
/*     */   }
/*     */   
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 389 */     guardarEquipos();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 393 */     this.jButton1.setEnabled(false);
/* 394 */     this.jButton2.setEnabled(false);
/* 395 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton8ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt) {
/* 403 */     this.jButton1.setEnabled(true);
/* 404 */     this.jButton2.setEnabled(true);
/* 405 */     verDatos();
/*     */   }
/*     */   
/*     */   private void jTable1KeyReleased(KeyEvent evt) {
/* 409 */     this.jButton1.setEnabled(true);
/* 410 */     this.jButton2.setEnabled(true);
/* 411 */     verDatos();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 415 */     this.jComboBox1.removeAllItems();
/* 416 */     this.jComboBox1.addItem("Selecciona uno...");
/* 417 */     int indice = this.jTable1.getSelectedRow();
/* 418 */     this.con.consultar("count(num_equipo)", "equipo_plataforma", "where num_equipo<>0 and num_plata = " + String.valueOf(this.jTable1.getValueAt(indice, 0)));
/* 419 */     if (Integer.parseInt(this.con.Campo) >= 20) {
/* 420 */       JOptionPane.showMessageDialog(this.padre, "No puedes asignar más de diez equipos a una plataforma", "Varios Equipos", 0, this.ERROR);
/*     */     }
/* 422 */     else if (indice >= 0) {
/*     */       
/* 424 */       String[] equipos = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 order by equipo");
/* 425 */       for (int i = 0; i < equipos.length; i++) {
/* 426 */         this.jComboBox1.addItem(equipos[i]);
/*     */       }
/* 428 */       int res = JOptionPane.showConfirmDialog(this.padre, this.jPanel2, "Equipos", 0, 3, this.PREG);
/* 429 */       if (res == 0) {
/* 430 */         if (this.jComboBox1.getSelectedIndex() == 0) {
/* 431 */           JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un equipo para poder asignarlo", "Selecciona el equipo", 0, this.ADVER);
/*     */         } else {
/*     */           
/* 434 */           this.con.consultar("num_equipo", "equipos", "where equipo = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 435 */           String num_equipo = this.con.Campo;
/* 436 */           boolean encontrado = this.con.consultar("plataformas.plataforma", "equipos,equipo_plataforma,plataformas", "where equipo_plataforma.num_plata = plataformas.num_plata and equipo_plataforma.num_equipo = equipos.num_equipo and equipo <>'WEATHERFORD' and equipo<>'PMX' and equipo<>'Q-MAX' and equipo <>'SLB' and equipo <>'ZAPATA' and equipo <>'CALFRAC' AND equipo <>'BAKER' AND equipo <>'HALLIBURTON' AND equipo <>'KOMLINE' AND equipo <>'BAKER' AND equipo <>'BAKER OP' AND equipo <>'BJ SERVICES' AND equipo <>'SAESA' and equipo <>'MI SWACO' and equipo <>'PETRO-SPM' and equipo <>'DRAKE' and equipo <>'CLEANMEX' and equipo <>'KEY' and equipo <>'PETROINTEGRAL' and equipo <>'FORZA API' and equipo <>'COMESA' and equipo <>'INTERMODAL' and equipo <>'OPERACIONES PETROLERAS SOLEDAD' and equipo <>'EQUIPAMENTO LATINA' and equipo <>'BASE LATINA' and equipo <>'PERFORADORA LATINA' and equipo<>'DIAVAZ CAMPO ÉBANO' and equipo<>'DIAVAZ' and equipo<>'SERVICIOS PJP4' and equipo<>'DS SERVICIOS' and equipo<>'OPERADORA DE CAMPOS' and equipo<>'AGMARK' and equipos.num_equipo = " + num_equipo);
/* 437 */           if (encontrado) {
/* 438 */             JOptionPane.showMessageDialog(this.padre, "<html>El equipo ya ha sido asignado a una plataforma.<br>Para cambiar de equipo necesitas quitar la asignación anterior<hr><b><font color =BLUE>" + this.con.Campo + "<font></b></html>", "Quita Asignación", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 441 */             encontrado = this.con.consultar("equipos.num_equipo", "equipos,equipo_plataforma", "where equipo_plataforma.num_equipo = equipos.num_equipo and equipos.num_equipo = " + num_equipo + " and num_plata = " + String.valueOf(this.jTable1.getValueAt(indice, 0)));
/* 442 */             if (encontrado) {
/* 443 */               JOptionPane.showMessageDialog(this.padre, "No puedes asignar el mismo equipo en la plataforma que seleccionaste, por favor asigna otro equipo.", "Mismo Equipo en la Plataforma", 0, this.ERROR);
/*     */             } else {
/*     */               
/* 446 */               this.con.insertar("insert into equipo_plataforma(num_equipo,num_plata) values(" + num_equipo + "," + String.valueOf(this.jTable1.getValueAt(indice, 0)) + ")");
/* 447 */               this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Asignó un Equipo.','Plataforma: " + String.valueOf(this.jTable1.getValueAt(indice, 1)) + " ----->>>> Equipo: " + String.valueOf(this.jComboBox1.getSelectedItem()) + "')");
/* 448 */               this.mensajeTry.guardarConf("Se ha asignado un equipo de una plataforma, USUARIO: " + this.USUARIO, "Equipo Asignado a Plataforma (" + String.valueOf(this.jTable1.getValueAt(indice, 1)) + ")", "INFO", "Perforacion");
/* 449 */               consultar();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/*     */       
/* 456 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una plataforma para poder asignarla a un equipo", "Selecciona una Plataforma", 0, this.INFO);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 461 */     String num_plata = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 462 */     this.encontrado = this.con.consultar("num_plata", "equipo_plataforma", "where num_equipo<>0 and num_plata = " + num_plata);
/* 463 */     if (!this.encontrado) {
/* 464 */       JOptionPane.showMessageDialog(this.padre, "Ésta plataforma aún no tiene equipos designados", "Ningún Equipo", 0, this.ERROR);
/*     */     } else {
/*     */       
/* 467 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas quitar un equipo designado?", "Quitar Equipo", 0, 1, this.PREG);
/* 468 */       if (res == 0) {
/* 469 */         this.jComboBox1.removeAllItems();
/* 470 */         this.jComboBox1.addItem("Selecciona uno...");
/*     */ 
/*     */ 
/*     */         
/* 474 */         String[] equipos = this.con.regresaColIndex("num_equipo", "equipo_plataforma", "where num_equipo<>0 and num_plata = " + num_plata);
/* 475 */         for (int i = 0; i < equipos.length; i++) {
/* 476 */           this.con.consultar("equipo", "equipos", "where num_equipo =" + equipos[i]);
/* 477 */           this.jComboBox1.addItem(this.con.Campo);
/*     */         } 
/* 479 */         res = JOptionPane.showConfirmDialog(this.padre, this.jPanel2, "Equipos", 0, 3, this.PREG);
/* 480 */         if (res == 0) {
/* 481 */           if (this.jComboBox1.getSelectedIndex() == 0) {
/* 482 */             JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un equipo para que pueda ser retirado de la plataforma", "Selecciona un Equipo", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 485 */             this.con.inserSinMsj("update equipo_plataforma set num_equipo=0 where num_equipo = " + equipos[this.jComboBox1.getSelectedIndex() - 1] + " and num_plata = " + num_plata);
/* 486 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Quitó el Equipo.','Equipo: " + String.valueOf(this.jComboBox1.getSelectedItem()) + "  <<<<------ " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + " ')");
/* 487 */             this.mensajeTry.guardarConf("Se ha quitado un equipo de una plataforma, USUARIO: " + this.USUARIO, "Plataforma sin equipo (" + num_plata + ")", "INFO", "Perforacion");
/* 488 */             JOptionPane.showMessageDialog(this.padre, "El equipo ha sido desactivado perfectamente", "Equipo Desactivado", 0, this.INFO);
/* 489 */             consultar();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTable2MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTable2KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   public void colorear() {
/* 505 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 507 */             Plataformas.this.jTextGanado(Plataformas.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 510 */             Plataformas.this.jTextPerdido(Plataformas.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 513 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 515 */             Plataformas.this.jTextGanado(Plataformas.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 518 */             Plataformas.this.jTextPerdido(Plataformas.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 521 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 523 */             Plataformas.this.jTextGanado(Plataformas.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 526 */             Plataformas.this.jTextPerdido(Plataformas.this.jComboBox1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 531 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 534 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 537 */     String plataforma = this.jTextField2.getText();
/* 538 */     this.encontrado = this.con.consultar("count(plataformas.num_plata)", "plataformas", "where plataforma like '%" + plataforma + "%' order by plataforma");
/* 539 */     int totreg = Integer.parseInt(this.con.Campo);
/* 540 */     this.encontrado = this.con.consultar("count(num_plata)", "plataformas", "");
/* 541 */     String tot = this.con.Campo;
/* 542 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 543 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 544 */           .buscarReg(2, totreg, "plataformas.num_plata,plataforma", "plataformas", "where plataforma like '%" + plataforma + "%' order by plataforma"), (Object[])new String[] { "Clave", "Plataforma" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 549 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 553 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 556 */     this.jTable1.setShowVerticalLines(false);
/* 557 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 558 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 559 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/*     */     
/* 561 */     this.jTable1.setSelectionMode(0);
/* 562 */     this.jTable1.setAutoCreateRowSorter(true);
/* 563 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 565 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 566 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*     */   }
/*     */   
/*     */   public void guardarEquipos() {
/* 570 */     String equipo = this.jTextField1.getText().toUpperCase();
/* 571 */     if (equipo.equals("")) {
/* 572 */       this.error.cargarError(this.jTextField1, "050");
/*     */     }
/* 574 */     else if (!this.val.validarApostrofe(this.jTextField1, equipo, "020")) {
/* 575 */       this.encontrado = this.con.consultar("plataforma", "plataformas", "where plataforma = '" + this.jTextField1.getText() + "'");
/* 576 */       if (this.encontrado) {
/* 577 */         JOptionPane.showMessageDialog(this.padre, "La plataforma que deseas insertar ya se encuentra registrada en la base de datos", "Plataforma ya Existe", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 580 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas crear una nueva plataforma?", "Crear Plataforma", 0, 1, this.PREG);
/* 581 */         if (res == 0) {
/* 582 */           this.con.insertar("insert into plataformas(plataforma)values('" + equipo + "')");
/* 583 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó una nueva plataforma.','Nombre: " + this.jTextField1.getText() + "')");
/* 584 */           this.mensajeTry.guardarConf("Se ha creado una plataforma, USUARIO: " + this.USUARIO, "Nueva Plataforma (" + this.jTextField1.getText() + ")", "INFO", "Perforacion");
/* 585 */           consultar();
/* 586 */           this.jTextField1.setText("");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void equipos(String usu) {
/* 592 */     this.USUARIO = usu;
/* 593 */     this.panel.setViewportView(this);
/* 594 */     consultar();
/*     */   }
/*     */   public void verDatos() {
/* 597 */     int indice = this.jTable1.getSelectedRow();
/* 598 */     if (indice >= 0) {
/* 599 */       String plataforma = String.valueOf(this.jTable1.getValueAt(indice, 0));
/*     */ 
/*     */       
/* 602 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 603 */             .buscarDatos(2, "equipos.num_equipo,equipo", "equipo_plataforma,equipos", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo_plataforma.num_plata = " + plataforma + " and equipos.num_equipo<>0"), (Object[])new String[] { "Clave", "Equipo" })
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 608 */             boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */             
/*     */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 612 */               return this.canEdit[columnIndex];
/*     */             }
/*     */           });
/* 615 */       this.jTable2.setShowVerticalLines(false);
/* 616 */       this.jScrollPane2.setViewportView(this.jTable2);
/* 617 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 618 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(40);
/*     */       
/* 620 */       this.jTable2.setSelectionMode(0);
/* 621 */       this.jTable2.setAutoCreateRowSorter(true);
/* 622 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*     */       
/* 624 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 625 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*     */     } 
/*     */   }
/*     */   
/* 629 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 630 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 632 */       setEnabled((table == null || table.isEnabled()));
/* 633 */       if (row % 2 == 0) {
/* 634 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 636 */         setBackground((Color)null);
/* 637 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 638 */       return this;
/*     */     } }
/*     */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; int[] indices;
/*     */     CeldaRender2() {
/* 642 */       this.otro = -1;
/* 643 */       this.indices = new int[0];
/*     */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 645 */       setEnabled((table == null || table.isEnabled()));
/* 646 */       if (row % 2 == 0) {
/* 647 */         setBackground(new Color(120, 200, 104));
/*     */       } else {
/* 649 */         setBackground((Color)null);
/* 650 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 651 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Plataformas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */