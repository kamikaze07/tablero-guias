/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Date;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class Lineas extends JPanel {
/*     */   JScrollPane panel;
/*     */   JFrame padre;
/*  36 */   Date fechaActual = new Date();
/*  37 */   Date fechaInicio = null;
/*  38 */   Date fecha = new Date();
/*  39 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  40 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  41 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  42 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  43 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  44 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*  45 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  46 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  47 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  48 */   String USUARIO = "";
/*  49 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  50 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*  52 */   String[] CLIENTES = null;
/*  53 */   String[] DIAS = null;
/*     */   EscribirReporte esc;
/*  55 */   CeldaRender celda = new CeldaRender(); private JButton jButton1; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton7; private JButton jButton8; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JDialog jDialog1; private JLabel jLabel123; private JLabel jLabel125; private JLabel jLabel126;
/*     */   
/*     */   public Lineas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  58 */     this.padre = padre;
/*  59 */     fichas = fichas;
/*     */     
/*  61 */     initComponents();
/*  62 */     this.USUARIO = USUARIO;
/*  63 */     panelito.setViewportView(this);
/*  64 */     this.panel = panelito;
/*  65 */     colorear();
/*  66 */     consultar();
/*     */     
/*  68 */     int w = this.tama.width;
/*  69 */     int h = this.tama.height;
/*  70 */     int rw = (w - 460) / 2;
/*  71 */     int rh = (h - 160) / 2;
/*  72 */     this.jDialog1.setLocation(rw, rh);
/*  73 */     this.jDialog1.setSize(460, 190);
/*  74 */     this.jDialog1.setResizable(false);
/*  75 */     this.jDialog1.setVisible(false);
/*  76 */     llenarCombos();
/*     */   }
/*     */   private JLabel jLabel41; private JLabel jLabel48; private JLabel jLabel54; private JLabel jLabel58; private JLabel jLabel59; private JPanel jPanel17; private JPanel jPanel4; private JPanel jPanel7; private JScrollPane jScrollPane1; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JTable jTable1; private JTextField jTextField1; private JTextField jTextField3;
/*     */   public void llenarCombos() {
/*  80 */     String[] datos = this.con.regresaColIndex("distinct(empresa)", "emp_generadora", "where empresa <>'' order by empresa");
/*  81 */     this.jComboBox21.removeAllItems();
/*  82 */     this.jComboBox23.removeAllItems();
/*  83 */     this.jComboBox21.addItem("<GENERAL>");
/*  84 */     this.jComboBox23.addItem("<GENERAL>");
/*  85 */     for (int i = 0; i < datos.length; i++) {
/*  86 */       this.jComboBox21.addItem(datos[i]);
/*  87 */       this.jComboBox23.addItem(datos[i]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void Lineas(String usu) {
/*  92 */     this.USUARIO = usu;
/*  93 */     this.panel.setViewportView(this);
/*  94 */     consultar();
/*     */   }
/*     */   
/*     */   public void colorear() {
/*  98 */     this.jComboBox21.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 100 */             Lineas.this.jTextGanado(Lineas.this.jComboBox21, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 103 */             Lineas.this.jTextPerdido(Lineas.this.jComboBox21, evt);
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.jComboBox22.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 109 */             Lineas.this.jTextGanado(Lineas.this.jComboBox22, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 112 */             Lineas.this.jTextPerdido(Lineas.this.jComboBox22, evt);
/*     */           }
/*     */         });
/*     */     
/* 116 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 118 */             Lineas.this.jTextGanado(Lineas.this.jTextField3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 121 */             Lineas.this.jTextPerdido(Lineas.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 124 */     this.jComboBox23.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 126 */             Lineas.this.jTextGanado(Lineas.this.jComboBox23, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 129 */             Lineas.this.jTextPerdido(Lineas.this.jComboBox23, evt);
/*     */           }
/*     */         });
/*     */     
/* 133 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 135 */             Lineas.this.jTextGanado(Lineas.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 138 */             Lineas.this.jTextPerdido(Lineas.this.jTextField1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 144 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 147 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void jPintarTexto(JComponent campo) {
/* 150 */     campo.setBackground(Color.ORANGE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/* 156 */     this.jDialog1 = new CerrarVentana(this.padre);
/* 157 */     this.jPanel4 = new JPanel();
/* 158 */     this.jLabel123 = new JLabel();
/* 159 */     this.jSeparator2 = new JSeparator();
/* 160 */     this.jButton7 = new JButton();
/* 161 */     this.jSeparator3 = new JSeparator();
/* 162 */     this.jComboBox23 = new JComboBox();
/* 163 */     this.jLabel125 = new JLabel();
/* 164 */     this.jLabel126 = new JLabel();
/* 165 */     this.jTextField1 = new JTextField();
/* 166 */     this.jButton8 = new JButton();
/* 167 */     this.jPanel7 = new JPanel();
/* 168 */     this.jSeparator1 = new JSeparator();
/* 169 */     this.jLabel54 = new JLabel();
/* 170 */     this.jPanel17 = new JPanel();
/* 171 */     this.jLabel41 = new JLabel();
/* 172 */     this.jComboBox21 = new JComboBox();
/* 173 */     this.jLabel58 = new JLabel();
/* 174 */     this.jTextField3 = new JTextField();
/* 175 */     this.jComboBox22 = new JComboBox();
/* 176 */     this.jLabel59 = new JLabel();
/* 177 */     this.jScrollPane1 = new JScrollPane();
/* 178 */     this.jTable1 = new JTable();
/* 179 */     this.jButton1 = new JButton();
/* 180 */     this.jLabel48 = new JLabel();
/* 181 */     this.jButton2 = new JButton();
/* 182 */     this.jButton3 = new JButton();
/* 183 */     this.jButton4 = new JButton();
/* 184 */     this.jButton5 = new JButton();
/*     */     
/* 186 */     this.jDialog1.setTitle("Agregar Línea");
/* 187 */     this.jDialog1.setModal(true);
/*     */     
/* 189 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*     */     
/* 191 */     this.jLabel123.setFont(new Font("Tahoma", 1, 14));
/* 192 */     this.jLabel123.setForeground(new Color(0, 102, 102));
/* 193 */     this.jLabel123.setHorizontalAlignment(0);
/* 194 */     this.jLabel123.setText("Datos de la línea");
/*     */     
/* 196 */     this.jButton7.setMnemonic('C');
/* 197 */     this.jButton7.setText("Cancelar");
/* 198 */     this.jButton7.setToolTipText("Cancelar (Alt+C)");
/* 199 */     this.jButton7.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 201 */             Lineas.this.jButton7ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 205 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/* 206 */     this.jComboBox23.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 207 */     this.jComboBox23.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 209 */             Lineas.this.jComboBox23ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 213 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 214 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 215 */     this.jLabel125.setText("Cliente");
/*     */     
/* 217 */     this.jLabel126.setFont(new Font("Tahoma", 3, 11));
/* 218 */     this.jLabel126.setForeground(new Color(15, 87, 51));
/* 219 */     this.jLabel126.setText("Línea");
/*     */     
/* 221 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 223 */             Lineas.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 227 */     this.jButton8.setMnemonic('G');
/* 228 */     this.jButton8.setText("Guardar");
/* 229 */     this.jButton8.setToolTipText("Guardar nueva línea(Alt+G)");
/* 230 */     this.jButton8.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 232 */             Lineas.this.jButton8ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 236 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 237 */     this.jPanel4.setLayout(jPanel4Layout);
/* 238 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 239 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 240 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 241 */           .addContainerGap()
/* 242 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 243 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 244 */               .addComponent(this.jLabel123, -2, 426, -2)
/* 245 */               .addContainerGap(-1, 32767))
/* 246 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 247 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 248 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 249 */                   .addGap(0, 0, 32767)
/* 250 */                   .addComponent(this.jButton8, -2, 97, -2)
/* 251 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 252 */                   .addComponent(this.jButton7, -2, 97, -2))
/* 253 */                 .addComponent(this.jSeparator3, GroupLayout.Alignment.LEADING)
/* 254 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 255 */                   .addComponent(this.jSeparator2, -2, 429, -2)
/* 256 */                   .addGap(0, 0, 32767))
/* 257 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 258 */                   .addComponent(this.jLabel126, -2, 134, -2)
/* 259 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 260 */                   .addComponent(this.jTextField1))
/* 261 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/* 262 */                   .addComponent(this.jLabel125, -2, 134, -2)
/* 263 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 264 */                   .addComponent(this.jComboBox23, 0, -1, 32767)))
/* 265 */               .addGap(119, 119, 119)))));
/*     */     
/* 267 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 269 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 270 */           .addComponent(this.jLabel123)
/* 271 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 272 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 273 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 274 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 275 */             .addComponent(this.jComboBox23, -2, -1, -2)
/* 276 */             .addComponent(this.jLabel125))
/* 277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 278 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 279 */             .addComponent(this.jLabel126)
/* 280 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 281 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 282 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 285 */             .addComponent(this.jButton7)
/* 286 */             .addComponent(this.jButton8))
/* 287 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 290 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 291 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 292 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 293 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 294 */         .addGroup(jDialog1Layout.createSequentialGroup()
/* 295 */           .addComponent(this.jPanel4, -2, 450, -2)
/* 296 */           .addGap(0, 0, 32767)));
/*     */     
/* 298 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 299 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 300 */         .addComponent(this.jPanel4, -2, -1, -2));
/*     */ 
/*     */     
/* 303 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/* 304 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 306 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 307 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 308 */     this.jLabel54.setHorizontalAlignment(0);
/* 309 */     this.jLabel54.setText("Líneas por Cliente");
/*     */     
/* 311 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 312 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Líneas", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 314 */     this.jLabel41.setFont(new Font("Tahoma", 3, 12));
/* 315 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 316 */     this.jLabel41.setHorizontalAlignment(0);
/* 317 */     this.jLabel41.setText("Linea");
/*     */     
/* 319 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/* 320 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 321 */     this.jComboBox21.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 323 */             Lineas.this.jComboBox21ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 327 */     this.jLabel58.setFont(new Font("Tahoma", 3, 12));
/* 328 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/* 329 */     this.jLabel58.setHorizontalAlignment(0);
/* 330 */     this.jLabel58.setText("Cliente");
/*     */     
/* 332 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 334 */             Lineas.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 338 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/* 339 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "ELIMINADAS", "TODAS" }));
/* 340 */     this.jComboBox22.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 342 */             Lineas.this.jComboBox22ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 346 */     this.jLabel59.setFont(new Font("Tahoma", 3, 12));
/* 347 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 348 */     this.jLabel59.setHorizontalAlignment(0);
/* 349 */     this.jLabel59.setText("Estatus");
/*     */     
/* 351 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 352 */     this.jPanel17.setLayout(jPanel17Layout);
/* 353 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 355 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 356 */           .addContainerGap()
/* 357 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 358 */             .addComponent(this.jComboBox21, 0, 285, 32767)
/* 359 */             .addComponent(this.jLabel58, -1, -1, 32767))
/* 360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 361 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 362 */             .addComponent(this.jComboBox22, 0, -1, 32767)
/* 363 */             .addComponent(this.jLabel59, -2, 123, -2))
/* 364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 365 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 366 */             .addComponent(this.jLabel41, -1, -1, 32767)
/* 367 */             .addComponent(this.jTextField3, -2, 222, -2))
/* 368 */           .addContainerGap(-1, 32767)));
/*     */     
/* 370 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 371 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 372 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 373 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 374 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 375 */               .addComponent(this.jComboBox21, -2, -1, -2)
/* 376 */               .addGap(8, 8, 8)
/* 377 */               .addComponent(this.jLabel58, -1, -1, 32767))
/* 378 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 379 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 380 */               .addGap(8, 8, 8)
/* 381 */               .addComponent(this.jLabel41))
/* 382 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 383 */               .addComponent(this.jComboBox22, -2, -1, -2)
/* 384 */               .addGap(8, 8, 8)
/* 385 */               .addComponent(this.jLabel59, -1, -1, 32767)))
/* 386 */           .addContainerGap()));
/*     */ 
/*     */     
/* 389 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/* 400 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 402 */             Lineas.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/* 405 */     this.jTable1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 407 */             Lineas.this.jTable1KeyReleased(evt);
/*     */           }
/*     */         });
/* 410 */     this.jScrollPane1.setViewportView(this.jTable1);
/*     */     
/* 412 */     this.jButton1.setText("Nueva");
/* 413 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 415 */             Lineas.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 419 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 420 */     this.jLabel48.setForeground(Color.red);
/* 421 */     this.jLabel48.setHorizontalAlignment(0);
/* 422 */     this.jLabel48.setText("TOTAL 0");
/* 423 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 425 */     this.jButton2.setText("Modificar");
/* 426 */     this.jButton2.setEnabled(false);
/* 427 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 429 */             Lineas.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 433 */     this.jButton3.setText("Eliminar");
/* 434 */     this.jButton3.setEnabled(false);
/* 435 */     this.jButton3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 437 */             Lineas.this.jButton3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 441 */     this.jButton4.setText("Guardar");
/* 442 */     this.jButton4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 444 */             Lineas.this.jButton4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 448 */     this.jButton5.setText("Activar");
/* 449 */     this.jButton5.setEnabled(false);
/* 450 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 452 */             Lineas.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 456 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 457 */     this.jPanel7.setLayout(jPanel7Layout);
/* 458 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 459 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 460 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 461 */           .addContainerGap()
/* 462 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 463 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 464 */               .addComponent(this.jSeparator1)
/* 465 */               .addGap(11, 11, 11))
/* 466 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 467 */               .addComponent(this.jLabel54, -1, -1, 32767)
/* 468 */               .addContainerGap())
/* 469 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 470 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 471 */                 .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 1104, 32767)
/* 472 */                 .addComponent(this.jPanel17, -1, -1, 32767))
/* 473 */               .addContainerGap())
/* 474 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/* 475 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 476 */               .addGap(38, 38, 38)
/* 477 */               .addComponent(this.jButton1, -2, 104, -2)
/* 478 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 479 */               .addComponent(this.jButton2, -2, 104, -2)
/* 480 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 481 */               .addComponent(this.jButton3, -2, 104, -2)
/* 482 */               .addGap(10, 10, 10)
/* 483 */               .addComponent(this.jButton5, -2, 104, -2)
/* 484 */               .addGap(45, 45, 45)
/* 485 */               .addComponent(this.jButton4, -2, 104, -2)
/* 486 */               .addContainerGap(-1, 32767)))));
/*     */     
/* 488 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 490 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 491 */           .addComponent(this.jLabel54)
/* 492 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 493 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 494 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 495 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 496 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 497 */           .addComponent(this.jScrollPane1, -1, 229, 32767)
/* 498 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 499 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 500 */             .addComponent(this.jButton1)
/* 501 */             .addComponent(this.jLabel48)
/* 502 */             .addComponent(this.jButton2)
/* 503 */             .addComponent(this.jButton3)
/* 504 */             .addComponent(this.jButton4)
/* 505 */             .addComponent(this.jButton5))
/* 506 */           .addContainerGap()));
/*     */ 
/*     */     
/* 509 */     GroupLayout layout = new GroupLayout(this);
/* 510 */     setLayout(layout);
/* 511 */     layout.setHorizontalGroup(layout
/* 512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 513 */         .addGap(0, 1174, 32767)
/* 514 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 515 */           .addGroup(layout.createSequentialGroup()
/* 516 */             .addGap(0, 23, 32767)
/* 517 */             .addComponent(this.jPanel7, -2, -1, -2)
/* 518 */             .addGap(0, 23, 32767))));
/*     */     
/* 520 */     layout.setVerticalGroup(layout
/* 521 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 522 */         .addGap(0, 420, 32767)
/* 523 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 524 */           .addGroup(layout.createSequentialGroup()
/* 525 */             .addContainerGap()
/* 526 */             .addComponent(this.jPanel7, -1, -1, 32767)
/* 527 */             .addContainerGap())));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jComboBox21ActionPerformed(ActionEvent evt) {
/* 532 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox22ActionPerformed(ActionEvent evt) {
/* 536 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 540 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 544 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   private void jComboBox23ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 552 */     if (this.jButton8.getText().equals("Guardar")) {
/* 553 */       String linea = this.jTextField1.getText().toUpperCase();
/* 554 */       if (this.jComboBox23.getSelectedIndex() == 0) {
/* 555 */         this.jComboBox23.setBackground(Color.RED);
/* 556 */         JOptionPane.showMessageDialog(this.jDialog1, "Selecciona el cliente para poder ingresar una linea", "Selecciona el cliente", 0, this.ERROR);
/*     */       }
/* 558 */       else if (linea.equals("")) {
/* 559 */         this.jTextField1.setBackground(Color.RED);
/* 560 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el nombre de la línea", "Selecciona la línea", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 563 */         String cliente = String.valueOf(this.jComboBox23.getSelectedItem());
/* 564 */         this.encontrado = this.con.consultar("cliente", "lineas", "where linea = '" + this.jTextField1.getText() + "'");
/* 565 */         if (this.encontrado) {
/* 566 */           if (this.con.Campo.equals(cliente)) {
/* 567 */             JOptionPane.showMessageDialog(this.jDialog1, "La línea que deseas agregar ya se encuentra garabada para el cliente que seleccionaste", "Línea existente", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 570 */             int res = JOptionPane.showConfirmDialog(this.jDialog1, "La línea que colocaste ya existe para el cliente: " + this.con.Campo + "\n¿Deseas agregar la línea?", "Agregar Línea", 0, 3, this.PREG);
/* 571 */             if (res == 0) {
/* 572 */               this.con.inserSinMsj("insert into Lineas(cliente,linea,estatus,comentario) values('" + cliente + "','" + linea + "','ACTIVA','')");
/* 573 */               this.jTextField1.setText("");
/* 574 */               this.jComboBox23.setSelectedIndex(0);
/* 575 */               this.jDialog1.setVisible(false);
/* 576 */               consultar();
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 581 */           int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas agregar la línea que colocaste?", "Agregar Línea", 0, 3, this.PREG);
/* 582 */           if (res == 0) {
/* 583 */             this.con.inserSinMsj("insert into Lineas(cliente,linea,estatus,comentario) values('" + cliente + "','" + linea + "','ACTIVA','')");
/* 584 */             this.jTextField1.setText("");
/* 585 */             this.jComboBox23.setSelectedIndex(0);
/* 586 */             this.jDialog1.setVisible(false);
/* 587 */             consultar();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 593 */       String linea = this.jTextField1.getText().toUpperCase();
/* 594 */       if (this.jComboBox23.getSelectedIndex() == 0) {
/* 595 */         this.jComboBox23.setBackground(Color.RED);
/* 596 */         JOptionPane.showMessageDialog(this.jDialog1, "Selecciona el cliente para poder ingresar una linea", "Selecciona el cliente", 0, this.ERROR);
/*     */       }
/* 598 */       else if (linea.equals("")) {
/* 599 */         this.jTextField1.setBackground(Color.RED);
/* 600 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el nombre de la línea", "Selecciona la línea", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 603 */         String cliente = String.valueOf(this.jComboBox23.getSelectedItem());
/* 604 */         this.encontrado = this.con.consultar("cliente", "lineas", "where linea = '" + this.jTextField1.getText() + "'");
/* 605 */         if (this.encontrado) {
/* 606 */           if (this.con.Campo.equals(cliente)) {
/* 607 */             JOptionPane.showMessageDialog(this.jDialog1, "La línea que deseas agregar ya se encuentra garabada para el cliente que seleccionaste", "Línea existente", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 610 */             int res = JOptionPane.showConfirmDialog(this.jDialog1, "La línea que colocaste ya existe para el cliente: " + this.con.Campo + "\n¿Deseas modificar la línea?", "Agregar Línea", 0, 3, this.PREG);
/* 611 */             if (res == 0) {
/* 612 */               this.con.inserSinMsj("update lineas set cliente='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', linea = '" + this.jTextField1.getText().toUpperCase() + "' where numLinea= " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 613 */               this.jTextField1.setText("");
/* 614 */               this.jComboBox23.setSelectedIndex(0);
/* 615 */               this.jDialog1.setVisible(false);
/* 616 */               consultar();
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 621 */           int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas modificar la línea que colocaste?", "Modificar Línea", 0, 3, this.PREG);
/* 622 */           if (res == 0) {
/* 623 */             this.con.inserSinMsj("update lineas set cliente='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', linea = '" + this.jTextField1.getText().toUpperCase() + "' where numLinea= " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 624 */             this.jTextField1.setText("");
/* 625 */             this.jComboBox23.setSelectedIndex(0);
/* 626 */             this.jDialog1.setVisible(false);
/* 627 */             consultar();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 635 */     this.jDialog1.setTitle("Agregar Linea");
/* 636 */     this.jComboBox23.setSelectedIndex(0);
/* 637 */     this.jTextField1.setText("");
/* 638 */     this.jButton8.setText("Guardar");
/* 639 */     this.jButton8.setMnemonic('G');
/* 640 */     this.jButton8.setToolTipText("Guardar nueva línea(Alt+G) ");
/* 641 */     this.jDialog1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 645 */     String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3));
/* 646 */     if (estatus.equals("ELIMINADA")) {
/* 647 */       JOptionPane.showMessageDialog(this.padre, "La línea que seleccionaste ya se encuentra eliminada, verifica tu información", "Línea cancelada", 0, this.ERROR);
/*     */     } else {
/*     */       
/* 650 */       int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar la línea que seleccionaste?", "Eliminar", 0, 3, this.PREG);
/* 651 */       if (res == 0) {
/* 652 */         this.con.inserSinMsj("update lineas set estatus = 'ELIMINADA' where numLinea = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 653 */         consultar();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 659 */     if (this.jButton8.getText().equals("Guardar")) {
/* 660 */       String linea = this.jTextField1.getText().toUpperCase();
/* 661 */       if (this.jComboBox23.getSelectedIndex() == 0) {
/* 662 */         this.jComboBox23.setBackground(Color.RED);
/* 663 */         JOptionPane.showMessageDialog(this.jDialog1, "Selecciona el cliente para poder ingresar una linea", "Selecciona el cliente", 0, this.ERROR);
/*     */       }
/* 665 */       else if (linea.equals("")) {
/* 666 */         this.jTextField1.setBackground(Color.RED);
/* 667 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el nombre de la línea", "Selecciona la línea", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 670 */         String cliente = String.valueOf(this.jComboBox23.getSelectedItem());
/* 671 */         this.encontrado = this.con.consultar("cliente", "lineas", "where linea = '" + this.jTextField1.getText() + "'");
/* 672 */         if (this.encontrado) {
/* 673 */           if (this.con.Campo.equals(cliente)) {
/* 674 */             JOptionPane.showMessageDialog(this.jDialog1, "La línea que deseas agregar ya se encuentra garabada para el cliente que seleccionaste", "Línea existente", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 677 */             int res = JOptionPane.showConfirmDialog(this.jDialog1, "La línea que colocaste ya existe para el cliente: " + this.con.Campo + "\n¿Deseas agregar la línea?", "Agregar Línea", 0, 3, this.PREG);
/* 678 */             if (res == 0) {
/* 679 */               this.con.inserSinMsj("insert into Lineas(cliente,linea,estatus,comentario) values('" + cliente + "','" + linea + "','ACTIVA','')");
/* 680 */               this.jTextField1.setText("");
/* 681 */               this.jComboBox23.setSelectedIndex(0);
/* 682 */               this.jDialog1.setVisible(false);
/* 683 */               consultar();
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 688 */           int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas agregar la línea que colocaste?", "Agregar Línea", 0, 3, this.PREG);
/* 689 */           if (res == 0) {
/* 690 */             this.con.inserSinMsj("insert into Lineas(cliente,linea,estatus,comentario) values('" + cliente + "','" + linea + "','ACTIVA','')");
/* 691 */             this.jTextField1.setText("");
/* 692 */             this.jComboBox23.setSelectedIndex(0);
/* 693 */             this.jDialog1.setVisible(false);
/* 694 */             consultar();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 700 */       String linea = this.jTextField1.getText().toUpperCase();
/* 701 */       if (this.jComboBox23.getSelectedIndex() == 0) {
/* 702 */         this.jComboBox23.setBackground(Color.RED);
/* 703 */         JOptionPane.showMessageDialog(this.jDialog1, "Selecciona el cliente para poder ingresar una linea", "Selecciona el cliente", 0, this.ERROR);
/*     */       }
/* 705 */       else if (linea.equals("")) {
/* 706 */         this.jTextField1.setBackground(Color.RED);
/* 707 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el nombre de la línea", "Selecciona la línea", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 710 */         String cliente = String.valueOf(this.jComboBox23.getSelectedItem());
/* 711 */         this.encontrado = this.con.consultar("cliente", "lineas", "where linea = '" + this.jTextField1.getText() + "'");
/* 712 */         if (this.encontrado) {
/* 713 */           if (this.con.Campo.equals(cliente)) {
/* 714 */             JOptionPane.showMessageDialog(this.jDialog1, "La línea que deseas agregar ya se encuentra garabada para el cliente que seleccionaste", "Línea existente", 0, this.ERROR);
/*     */           } else {
/*     */             
/* 717 */             int res = JOptionPane.showConfirmDialog(this.jDialog1, "La línea que colocaste ya existe para el cliente: " + this.con.Campo + "\n¿Deseas modificar la línea?", "Agregar Línea", 0, 3, this.PREG);
/* 718 */             if (res == 0) {
/* 719 */               this.con.inserSinMsj("update lineas set cliente='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', linea = '" + this.jTextField1.getText().toUpperCase() + "' where numLinea= " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 720 */               this.jTextField1.setText("");
/* 721 */               this.jComboBox23.setSelectedIndex(0);
/* 722 */               this.jDialog1.setVisible(false);
/* 723 */               consultar();
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 728 */           int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas modificar la línea que colocaste?", "Modificar Línea", 0, 3, this.PREG);
/* 729 */           if (res == 0) {
/* 730 */             this.con.inserSinMsj("update lineas set cliente='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', linea = '" + this.jTextField1.getText().toUpperCase() + "' where numLinea= " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 731 */             this.jTextField1.setText("");
/* 732 */             this.jComboBox23.setSelectedIndex(0);
/* 733 */             this.jDialog1.setVisible(false);
/* 734 */             consultar();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt) {
/* 742 */     String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3));
/* 743 */     this.jButton2.setEnabled(true);
/* 744 */     if (estatus.equals("ELIMINADA")) {
/* 745 */       this.jButton5.setEnabled(true);
/* 746 */       this.jButton3.setEnabled(false);
/*     */     } else {
/*     */       
/* 749 */       this.jButton5.setEnabled(false);
/* 750 */       this.jButton3.setEnabled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTable1KeyReleased(KeyEvent evt) {
/* 755 */     String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3));
/* 756 */     this.jButton2.setEnabled(true);
/* 757 */     if (estatus.equals("ELIMINADA")) {
/* 758 */       this.jButton5.setEnabled(true);
/* 759 */       this.jButton3.setEnabled(false);
/*     */     } else {
/*     */       
/* 762 */       this.jButton5.setEnabled(false);
/* 763 */       this.jButton3.setEnabled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 768 */     int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar la línea que seleccionaste?", "Eliminar", 0, 3, this.PREG);
/* 769 */     if (res == 0) {
/* 770 */       this.con.inserSinMsj("update lineas set estatus = 'ACTIVA' where numLinea = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 771 */       consultar();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 776 */     this.jDialog1.setTitle("Modificar Linea");
/* 777 */     this.jButton8.setText("Modificar");
/* 778 */     this.jButton8.setMnemonic('M');
/* 779 */     this.jButton8.setToolTipText("Modificar línea (Alt+M)");
/* 780 */     this.jComboBox23.setSelectedItem(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 781 */     this.jTextField1.setText(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2)));
/* 782 */     this.jDialog1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 786 */     String[] datos = { "NÚM DE LA LÍNEA", "CLIENTE", "NOMBRE DE LA LÍNEA", "ESTATUS" };
/* 787 */     this.esc = new EscribirReporte("LÍNEAS", this.jTable1, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 791 */     this.jButton2.setEnabled(false);
/* 792 */     this.jButton3.setEnabled(false);
/* 793 */     this.jButton5.setEnabled(false);
/*     */     
/* 795 */     String cliente = "";
/* 796 */     String estatus = "";
/* 797 */     if (this.jComboBox21.getSelectedIndex() != 0) {
/* 798 */       cliente = String.valueOf(this.jComboBox21.getSelectedItem());
/*     */     }
/*     */     
/* 801 */     if (this.jComboBox22.getSelectedIndex() == 0) {
/* 802 */       estatus = "ACTIVA";
/*     */     }
/* 804 */     else if (this.jComboBox22.getSelectedIndex() == 1) {
/* 805 */       estatus = "ELIMINADA";
/*     */     }
/* 807 */     else if (this.jComboBox22.getSelectedIndex() == 2) {
/* 808 */       estatus = "";
/*     */     } 
/*     */     
/* 811 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 812 */           .buscarDatos(4, "numLinea, cliente, linea, estatus", "lineas", "where cliente like '%" + cliente + "%' and estatus like '%" + estatus + "%' and linea like '%" + this.jTextField3.getText() + "%' order by cliente,linea desc"), (Object[])new String[] { "Núm", "Cliente", "Nombre de la linea", "Estatus" })
/*     */         {
/*     */ 
/*     */           
/* 816 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 820 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 823 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 824 */     this.celda.pasarInd(this.con.revisarCol(this.jTable1, "ELIMINADA", 0, 3, 0));
/*     */     
/* 826 */     this.jTable1.setSelectionMode(0);
/* 827 */     this.jTable1.setAutoCreateRowSorter(true);
/* 828 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*     */     
/* 830 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 831 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 832 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
/* 833 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
/*     */     
/* 835 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 836 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 837 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 838 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*     */   }
/*     */   
/*     */   public class CeldaRender
/*     */     extends DefaultTableCellRenderer {
/* 843 */     int otro = -1;
/* 844 */     String[] indices = new String[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 846 */       setEnabled((table == null || table.isEnabled()));
/* 847 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 848 */       if (comparar(comp)) {
/* 849 */         setBackground(Color.RED);
/* 850 */         setForeground(Color.WHITE);
/*     */       } else {
/*     */         
/* 853 */         setBackground((Color)null);
/* 854 */         setForeground(Color.black);
/*     */       } 
/* 856 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 857 */       return this;
/*     */     }
/*     */     public void pasarInd(String[] ind) {
/* 860 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(String reg) {
/* 863 */       for (int i = 0; i < this.indices.length; i++) {
/* 864 */         if (this.indices[i].equals(reg)) {
/* 865 */           return true;
/*     */         }
/*     */       } 
/* 868 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Lineas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */