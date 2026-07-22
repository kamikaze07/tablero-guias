/*     */ package sicret;
/*     */ import com.placeholder.PlaceHolder;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class AlmProductos extends JPanel {
/*  30 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  31 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  32 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  33 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  34 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  35 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  36 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  37 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  41 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  42 */   Utilerias utilerias = new Utilerias();
/*     */   JFrame padre;
/*  44 */   String USUARIO = "";
/*     */   
/*     */   JTabbedPane fichas;
/*  47 */   Consultas2 con2 = new Consultas2();
/*  48 */   SColores lc = new SColores();
/*     */   Map<String, String> CAMPOSGENERALES;
/*  50 */   Fuentes fuentes = new Fuentes();
/*  51 */   PlaceHolder placeHolder = null;
/*  52 */   String holderId = "ID DEL PRODUCTO";
/*  53 */   String holderDesc = "DECRIPCIÓN";
/*  54 */   String holderRef = "REFERENCIA";
/*  55 */   pintarComponentes pintar = new pintarComponentes();
/*     */   boolean actualizado = false;
/*  57 */   TextAutoCompleter com_ListaCodigos = null;
/*     */   boolean entraPrimera = false;
/*     */   boolean PRIMERA = false;
/*  60 */   CeldaRender1 celda1 = new CeldaRender1();
/*     */   EscribirReporte esc;
/*  62 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*     */   String[] CATEGORIAS;
/*     */   private int xx;
/*     */   private int xy;
/*  66 */   Date fechaActual = new Date(); private JButton jButton1; private JButton jButton15; private JButton jButton2; private JButton jButton25; private JButton jButton4; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox5; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel98; private JLabel jLabel99;
/*     */   
/*     */   public AlmProductos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  69 */     this.con2.setBaseDatos("sicre2PR");
/*  70 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*     */     
/*  72 */     this.padre = padre;
/*  73 */     this.fichas = fichas;
/*  74 */     this.USUARIO = USUARIO;
/*  75 */     this.panel = panelito;
/*  76 */     this.panel.setViewportView(this);
/*  77 */     this.PRIVILEGIOS.put("SUPER SUUARIO", "SUPER USUARIO");
/*  78 */     this.PRIVILEGIOS.put("FACTURACIÓN", "FACTURACIÓN");
/*  79 */     this.PRIVILEGIOS.put("RESETEOS", "RESETEOS");
/*  80 */     this.PRIVILEGIOS.put("QHSE", "QHSE");
/*  81 */     initComponents();
/*     */     
/*  83 */     colorear();
/*  84 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(120, 120, 120), Color.BLACK, this.holderId, false, "Century Gothic", 11);
/*  85 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(120, 120, 120), Color.BLACK, this.holderDesc, false, "Century Gothic", 11);
/*  86 */     this.placeHolder = new PlaceHolder(this.jTextField9, new Color(120, 120, 120), Color.BLACK, this.holderRef, false, "Century Gothic", 11);
/*  87 */     llenarCombo();
/*  88 */     consultar();
/*     */     
/*  90 */     int w = this.tama.width;
/*  91 */     int h = this.tama.height;
/*  92 */     int rw = (w - 870) / 2;
/*  93 */     int rh = (h - 10) / 2;
/*  94 */     privilegios();
/*     */   }
/*     */   private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel35; private JPanel jPanel9; private JScrollPane jScrollPane13; private JTextField jTextField1; private JTextField jTextField2;
/*     */   private JTextField jTextField9;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   private void initComponents() {
/* 101 */     this.jPanel9 = new JPanel();
/* 102 */     this.jPanel10 = new JPanel();
/* 103 */     this.jLabel98 = new JLabel();
/* 104 */     this.jPanel35 = new JPanel();
/* 105 */     this.jTextField1 = new JTextField();
/* 106 */     this.jTextField2 = new JTextField();
/* 107 */     this.jTextField9 = new JTextField();
/* 108 */     this.jComboBox3 = new JComboBox();
/* 109 */     this.jComboBox5 = new JComboBox();
/* 110 */     this.jComboBox1 = new JComboBox();
/* 111 */     this.jComboBox2 = new JComboBox();
/* 112 */     this.jPanel11 = new JPanel();
/* 113 */     this.jPanel12 = new JPanel();
/* 114 */     this.jPanel2 = new JPanel();
/* 115 */     this.jPanel15 = new JPanel();
/* 116 */     this.jLabel99 = new JLabel();
/* 117 */     this.jLabel100 = new JLabel();
/* 118 */     this.jPanel17 = new JPanel();
/* 119 */     this.jLabel101 = new JLabel();
/* 120 */     this.jLabel102 = new JLabel();
/* 121 */     this.jPanel16 = new JPanel();
/* 122 */     this.jButton1 = new JButton();
/* 123 */     this.jButton2 = new JButton();
/* 124 */     this.jButton25 = new JButton();
/* 125 */     this.jButton4 = new JButton();
/* 126 */     this.jButton15 = new JButton();
/* 127 */     this.jPanel1 = new JPanel();
/* 128 */     this.jScrollPane13 = new JScrollPane();
/* 129 */     this.rSTableMetro1 = new RSTableMetro();
/*     */     
/* 131 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 133 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 135 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 136 */     this.jLabel98.setForeground(this.lc.PRIMARIO1);
/* 137 */     this.jLabel98.setHorizontalAlignment(0);
/* 138 */     this.jLabel98.setText("PRODUCTOS");
/*     */     
/* 140 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 141 */     this.jPanel10.setLayout(jPanel10Layout);
/* 142 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 144 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*     */     
/* 146 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 147 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 148 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 149 */           .addContainerGap()
/* 150 */           .addComponent(this.jLabel98)
/* 151 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 154 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 155 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*     */     
/* 157 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 159 */             AlmProductos.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/* 162 */     this.jPanel35.add(this.jTextField1);
/*     */     
/* 164 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 166 */             AlmProductos.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/* 169 */     this.jPanel35.add(this.jTextField2);
/*     */     
/* 171 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 173 */             AlmProductos.this.jTextField9KeyReleased(evt);
/*     */           }
/*     */         });
/* 176 */     this.jPanel35.add(this.jTextField9);
/*     */     
/* 178 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 179 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "STOCK", "POR DEBAJO", "POR ARRIBA", "DISPONIBLES", "SIN EXISTENCIAS" }));
/* 180 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 182 */             AlmProductos.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/* 185 */     this.jPanel35.add(this.jComboBox3);
/*     */     
/* 187 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 188 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO: ALMACENABLE Y CONSUMIBLE", "ALMACENABLE", "CONSUMIBLE", "SERVICIO" }));
/* 189 */     this.jComboBox5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 191 */             AlmProductos.this.jComboBox5ActionPerformed(evt);
/*     */           }
/*     */         });
/* 194 */     this.jPanel35.add(this.jComboBox5);
/*     */     
/* 196 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 197 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "CATEGORÍA" }));
/* 198 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 200 */             AlmProductos.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 203 */     this.jPanel35.add(this.jComboBox1);
/*     */     
/* 205 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 206 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "ELIMINADOS", "TODOS" }));
/* 207 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 209 */             AlmProductos.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 212 */     this.jPanel35.add(this.jComboBox2);
/*     */     
/* 214 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 216 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 217 */     this.jPanel12.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 219 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 220 */     this.jPanel2.setLayout(new GridLayout(1, 2, 12, 0));
/*     */     
/* 222 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 223 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 225 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 226 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 227 */     this.jLabel99.setHorizontalAlignment(4);
/* 228 */     this.jLabel99.setText("Total Productos");
/* 229 */     this.jPanel15.add(this.jLabel99);
/*     */     
/* 231 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 232 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 233 */     this.jLabel100.setHorizontalAlignment(2);
/* 234 */     this.jLabel100.setText("t");
/* 235 */     this.jPanel15.add(this.jLabel100);
/*     */     
/* 237 */     this.jPanel2.add(this.jPanel15);
/*     */     
/* 239 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 240 */     this.jPanel17.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 242 */     this.jLabel101.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 243 */     this.jLabel101.setForeground(this.lc.SECUNDARIO1);
/* 244 */     this.jLabel101.setHorizontalAlignment(4);
/* 245 */     this.jLabel101.setText("Invesión");
/* 246 */     this.jPanel17.add(this.jLabel101);
/*     */     
/* 248 */     this.jLabel102.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 249 */     this.jLabel102.setForeground(this.lc.PRIMARIO1);
/* 250 */     this.jLabel102.setHorizontalAlignment(2);
/* 251 */     this.jLabel102.setText("$");
/* 252 */     this.jPanel17.add(this.jLabel102);
/*     */     
/* 254 */     this.jPanel2.add(this.jPanel17);
/*     */     
/* 256 */     this.jPanel12.add(this.jPanel2);
/*     */     
/* 258 */     this.jPanel16.setBackground(this.lc.SECUNDARIO2);
/* 259 */     this.jPanel16.setLayout(new GridLayout(1, 5, 6, 0));
/*     */     
/* 261 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 262 */     this.jButton1.setMnemonic('N');
/* 263 */     this.jButton1.setText("Nuevo");
/* 264 */     this.jButton1.setToolTipText("Nuevo(Alt + N)");
/* 265 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 267 */             AlmProductos.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 270 */     this.jPanel16.add(this.jButton1);
/*     */     
/* 272 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 273 */     this.jButton2.setMnemonic('M');
/* 274 */     this.jButton2.setText("Modificar");
/* 275 */     this.jButton2.setToolTipText("Modificar (Alt + M)");
/* 276 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 278 */             AlmProductos.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 281 */     this.jPanel16.add(this.jButton2);
/*     */     
/* 283 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 284 */     this.jButton25.setMnemonic('E');
/* 285 */     this.jButton25.setText("Eliminar");
/* 286 */     this.jButton25.setToolTipText("Eliminar  (Alt+E)");
/* 287 */     this.jButton25.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 289 */             AlmProductos.this.jButton25ActionPerformed(evt);
/*     */           }
/*     */         });
/* 292 */     this.jPanel16.add(this.jButton25);
/*     */     
/* 294 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 295 */     this.jButton4.setMnemonic('G');
/* 296 */     this.jButton4.setText("Guardar Reporte");
/* 297 */     this.jButton4.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 298 */     this.jButton4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 300 */             AlmProductos.this.jButton4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 303 */     this.jPanel16.add(this.jButton4);
/*     */     
/* 305 */     this.jButton15.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 306 */     this.jButton15.setMnemonic('I');
/* 307 */     this.jButton15.setText("Imprimir");
/* 308 */     this.jButton15.setToolTipText("Imprimir (Alt+I)");
/* 309 */     this.jButton15.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 311 */             AlmProductos.this.jButton15ActionPerformed(evt);
/*     */           }
/*     */         });
/* 314 */     this.jPanel16.add(this.jButton15);
/*     */     
/* 316 */     this.jPanel12.add(this.jPanel16);
/*     */     
/* 318 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Descripcion", "Tipo", "Ref Interna", "Unidad Med", "Min", "Max", "Disp", "Inversion", "Categorías", "U Compra", "F U Mov", "Sub", "Iva", "Precio", "Actualización", "Estado" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 326 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, true, true, true, true, true, true, true, true, 
/*     */               true, true, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 331 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 334 */     this.rSTableMetro1.setAltoHead(40);
/* 335 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 336 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 337 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 338 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 339 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 340 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 341 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 342 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 343 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 344 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 345 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 346 */     this.rSTableMetro1.setRowHeight(18);
/* 347 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 348 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 349 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 350 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 352 */             AlmProductos.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 355 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 357 */             AlmProductos.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 360 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 362 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 363 */     this.jPanel1.setLayout(jPanel1Layout);
/* 364 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 366 */         .addComponent(this.jScrollPane13, -2, 0, 32767));
/*     */     
/* 368 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 370 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 371 */           .addComponent(this.jScrollPane13, -1, 204, 32767)
/* 372 */           .addContainerGap()));
/*     */ 
/*     */     
/* 375 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 376 */     this.jPanel11.setLayout(jPanel11Layout);
/* 377 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 379 */         .addComponent(this.jPanel12, -2, 611, 32767)
/* 380 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 382 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 384 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 385 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 386 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 387 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 388 */           .addContainerGap()));
/*     */ 
/*     */     
/* 391 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 392 */     this.jPanel9.setLayout(jPanel9Layout);
/* 393 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 395 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 396 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 397 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*     */     
/* 399 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 400 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 401 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 402 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 403 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 404 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 405 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 406 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*     */ 
/*     */     
/* 409 */     GroupLayout layout = new GroupLayout(this);
/* 410 */     setLayout(layout);
/* 411 */     layout.setHorizontalGroup(layout
/* 412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 413 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 415 */     layout.setVerticalGroup(layout
/* 416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 417 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 422 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 426 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 430 */     if (this.PRIMERA) {
/* 431 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 436 */     AlmProductosForm producto = new AlmProductosForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", false, "");
/* 437 */     this.actualizado = producto.actualizado;
/* 438 */     if (this.actualizado) {
/* 439 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 444 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 445 */     if (ind < 0) {
/* 446 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un producto para poder modificarlo", "Selecciona un producto", 0, this.ERROR);
/*     */     } else {
/* 448 */       AlmProductosForm producto = new AlmProductosForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", false, this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 449 */       this.actualizado = producto.actualizado;
/* 450 */       if (this.actualizado) {
/* 451 */         consultar();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 457 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, "PRODUCTOS");
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 461 */     if (evt.getClickCount() > 1) {
/* 462 */       AlmProductosForm almProductosForm = new AlmProductosForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", false, this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 471 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 475 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 479 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 480 */     if (ind < 0) {
/* 481 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un producto para poder eliminarlo", "Selecciona un producto", 0, this.ERROR);
/*     */     } else {
/* 483 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 17).toString();
/* 484 */       if (!estatus.equals("ACTIVO")) {
/* 485 */         JOptionPane.showMessageDialog(this.padre, "Para eliminar un producto necesitas seleccionar alguno que se encuentre ACTIVO", "Selecciona otro producto", 0, this.ERROR);
/*     */       } else {
/* 487 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas ELIMINAR el producto que seleccionaste?", "Eliminar el producto", 0, 3, this.ELIMINAR);
/* 488 */         if (res == 0) {
/* 489 */           this.con2.inserSinMsj("update alm_productos set actualizacion = '" + this.utilerias.sacarUsuario(this.USUARIO) + "', estatus = 'ELIMINADO' where idProd = " + String.valueOf(this.rSTableMetro1.getValueAt(ind, 0)));
/* 490 */           consultar();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 497 */     imprimirVistaActual();
/*     */   }
/*     */   
/*     */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 501 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 505 */     consultar();
/*     */   }
/*     */   
/*     */   public JTable crearTablaAux2(JTable tabla) {
/* 509 */     DefaultTableModel modeloTablaAux = new DefaultTableModel();
/*     */     
/* 511 */     modeloTablaAux.addColumn("cont");
/* 512 */     modeloTablaAux.addColumn("ID");
/* 513 */     modeloTablaAux.addColumn("Descripcion");
/* 514 */     modeloTablaAux.addColumn("RefInterna");
/* 515 */     modeloTablaAux.addColumn("Medida");
/* 516 */     modeloTablaAux.addColumn("Min");
/* 517 */     modeloTablaAux.addColumn("Max");
/* 518 */     modeloTablaAux.addColumn("Disp");
/* 519 */     modeloTablaAux.addColumn("Inversion");
/* 520 */     modeloTablaAux.addColumn("Precio");
/* 521 */     modeloTablaAux.addColumn("UFecha");
/*     */     
/* 523 */     DefaultTableModel modeloTablaExistente = (DefaultTableModel)tabla.getModel();
/* 524 */     for (int i = 0; i < modeloTablaExistente.getRowCount(); i++) {
/* 525 */       Object[] fila = new Object[modeloTablaAux.getColumnCount()];
/*     */       
/* 527 */       fila[0] = Integer.valueOf(i + 1);
/* 528 */       fila[1] = modeloTablaExistente.getValueAt(i, 0);
/* 529 */       fila[2] = modeloTablaExistente.getValueAt(i, 1);
/* 530 */       fila[3] = modeloTablaExistente.getValueAt(i, 3);
/* 531 */       fila[4] = modeloTablaExistente.getValueAt(i, 4);
/* 532 */       fila[5] = modeloTablaExistente.getValueAt(i, 5);
/* 533 */       fila[6] = modeloTablaExistente.getValueAt(i, 6);
/* 534 */       fila[7] = modeloTablaExistente.getValueAt(i, 7);
/* 535 */       fila[8] = this.utilerias.convertirCantSinDecimalesAPESOS(modeloTablaExistente.getValueAt(i, 8).toString());
/* 536 */       fila[9] = this.utilerias.convertirCantSinDecimalesAPESOS(modeloTablaExistente.getValueAt(i, 17).toString());
/* 537 */       fila[10] = this.utilerias.convertirFechaDateStringBarras(this.utilerias.convertirFechaStringADate(modeloTablaExistente.getValueAt(i, 12).toString()));
/*     */       
/* 539 */       modeloTablaAux.addRow(fila);
/*     */     } 
/* 541 */     JTable tablaAux = new JTable();
/* 542 */     tablaAux.setModel(modeloTablaAux);
/* 543 */     return tablaAux;
/*     */   }
/*     */   
/*     */   public void imprimirVistaActual() {
/* 547 */     JTable aux = crearTablaAux2((JTable)this.rSTableMetro1);
/* 548 */     Map<Object, Object> datos = new HashMap<>();
/* 549 */     String fechaCompleta = "";
/*     */     
/* 551 */     String STOCK = "TODO";
/* 552 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 553 */       STOCK = this.jComboBox3.getSelectedItem().toString();
/*     */     }
/*     */     
/* 556 */     String TIPO = "TODO";
/* 557 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 558 */       TIPO = this.jComboBox5.getSelectedItem().toString();
/*     */     }
/*     */     
/* 561 */     String DESC = "TODOS";
/* 562 */     if (!this.jTextField2.getText().equals(this.holderDesc)) {
/* 563 */       DESC = this.jTextField2.getText().toUpperCase();
/*     */     }
/*     */     
/* 566 */     String REF = "TODOS";
/* 567 */     if (!this.jTextField9.getText().equals(this.holderRef)) {
/* 568 */       REF = this.jTextField9.getText().toUpperCase();
/*     */     }
/*     */     
/* 571 */     String CAT = "TODAS";
/* 572 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 573 */       CAT = this.jComboBox1.getSelectedItem().toString();
/*     */     }
/*     */     
/* 576 */     String ESTATUS = "ACTIVOS";
/* 577 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 578 */       ESTATUS = this.jComboBox2.getSelectedItem().toString();
/*     */     }
/*     */     
/* 581 */     datos.put("stock", STOCK);
/* 582 */     datos.put("tipo", TIPO);
/* 583 */     datos.put("desc", DESC);
/* 584 */     datos.put("referencia", REF);
/* 585 */     datos.put("categoria", CAT);
/* 586 */     datos.put("estatus", ESTATUS);
/*     */     
/* 588 */     datos.put("TProductos", this.jLabel100.getText());
/* 589 */     datos.put("TTotal", this.jLabel102.getText());
/*     */     
/* 591 */     this.utilerias.cargarImagenesAReporte(datos);
/*     */     try {
/* 593 */       this.utilerias.verImpresion("/Reportes/Almacen/Alm_ProductosVistaGral.jasper", aux, datos, "Vista General de Productos");
/* 594 */     } catch (JRException ex) {
/* 595 */       Logger.getLogger(AlmProductos.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validarRFC(String rfc) {
/* 601 */     String rfcRegex = "^([A-Z&Ñ]{3}|[A-Z][AEIOU][A-Z]{2})\\d{6}([A-Z0-9]{3})?$";
/* 602 */     Pattern pattern = Pattern.compile(rfcRegex);
/* 603 */     Matcher matcher = pattern.matcher(rfc);
/*     */     
/* 605 */     return matcher.matches();
/*     */   }
/*     */   
/*     */   public void privilegios() {
/* 609 */     if (!this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/* 610 */       this.jButton1.setEnabled(false);
/* 611 */       this.jButton2.setEnabled(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void productos(String usua) {
/* 616 */     privilegios();
/* 617 */     this.USUARIO = usua;
/* 618 */     this.panel.setViewportView(this);
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 622 */     this.pintar.colorear(this.jTextField1);
/* 623 */     this.pintar.colorear(this.jTextField2);
/* 624 */     this.pintar.colorear(this.jTextField9);
/* 625 */     this.pintar.colorear(this.jComboBox1);
/* 626 */     this.pintar.colorear(this.jComboBox2);
/* 627 */     this.pintar.colorear(this.jComboBox3);
/* 628 */     this.pintar.colorear(this.jComboBox5);
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 632 */     this.CATEGORIAS = this.con2.regresaColIndex("categoria", "alm_categorias", "order by categoria");
/* 633 */     this.utilerias.llenarCombo(this.jComboBox1, this.CATEGORIAS);
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 637 */     this.PRIMERA = true;
/* 638 */     String id = "";
/* 639 */     String desc = "";
/* 640 */     String tipo = "";
/* 641 */     String cat = "";
/* 642 */     String ref = "";
/* 643 */     String activo = "";
/* 644 */     String stock = "";
/*     */     
/* 646 */     if (!this.jTextField1.getText().equals(this.holderId)) {
/* 647 */       id = this.jTextField1.getText();
/*     */     }
/* 649 */     if (!this.jTextField2.getText().equals(this.holderDesc)) {
/* 650 */       desc = this.jTextField2.getText();
/*     */     }
/*     */     
/* 653 */     if (!this.jTextField9.getText().equals(this.holderRef)) {
/* 654 */       ref = this.jTextField9.getText();
/*     */     }
/*     */     
/* 657 */     if (id.contains("'")) {
/* 658 */       id = id.replace("'", "");
/*     */     }
/*     */     
/* 661 */     if (desc.contains("'")) {
/* 662 */       desc = desc.replace("'", "");
/*     */     }
/*     */     
/* 665 */     if (ref.contains("'")) {
/* 666 */       ref = ref.replace("'", "");
/*     */     }
/*     */     
/* 669 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 670 */       tipo = " (tipoProd ='ALMACENABLE' || tipoProd ='CONSUMIBLE' )";
/*     */     }
/* 672 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 673 */       tipo = " (tipoProd ='ALMACENABLE')";
/*     */     }
/* 675 */     else if (this.jComboBox5.getSelectedIndex() == 2) {
/* 676 */       tipo = " (tipoProd ='CONSUMIBLE')";
/*     */     }
/* 678 */     else if (this.jComboBox5.getSelectedIndex() == 3) {
/* 679 */       tipo = " ( tipoProd ='SERVICIO') ";
/*     */     } 
/*     */ 
/*     */     
/* 683 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 684 */       cat = this.jComboBox1.getSelectedItem().toString();
/*     */     }
/*     */     
/* 687 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 688 */       activo = "ACTIVO";
/* 689 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 690 */       activo = "ELIMINADO";
/*     */     } 
/*     */     
/* 693 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 694 */       stock = "disponibles < stockMin and ";
/* 695 */     } else if (this.jComboBox3.getSelectedIndex() == 2) {
/* 696 */       stock = "disponibles > stockMax and ";
/* 697 */     } else if (this.jComboBox3.getSelectedIndex() == 3) {
/* 698 */       stock = "disponibles > 0 and ";
/* 699 */     } else if (this.jComboBox3.getSelectedIndex() == 4) {
/* 700 */       stock = "disponibles = 0 and ";
/*     */     } 
/*     */     
/* 703 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro1, new String[] { "ID", "Descripción Interna", "Tipo", "Ref Interna", "Unidad Med", "Min", "Max", "Disp", "Inversión", "Categorías", "cat2", "cat3", "U. Compra", "F U Mov", "Mov", "Sub", "Iva", "Precio", "Actualización", "Estado" }, "idProd, descInterna, tipoProd, refInterna, unidadMed, stockMin, stockMax, disponibles, inversion, cat1, cat2, cat3, fechaUltimaEntrada, fechaUltimoMov, ultimoMov, compraSub, compraIva, compraPrecio, Actualizacion, estatus usuario", "alm_productos", "where " + stock + " (refInterna LIKE '%" + ref + "%' or refProv LIKE '%" + ref + "%')  and idProd like '%" + id + "%' and descInterna like '%" + desc + "%' and " + tipo + " and (cat1 like '%" + cat + "%' or cat2 like '%" + cat + "%' or cat3 like '%" + cat + "%') and estatus like '%" + activo + "%' order by descInterna");
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
/* 729 */     this.utilerias.eliminarColumna((JTable)this.rSTableMetro1, 10, 9, "cat2", " / ");
/* 730 */     this.utilerias.eliminarColumna((JTable)this.rSTableMetro1, 10, 9, "cat3", " / ");
/* 731 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/* 732 */     this.jLabel102.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 8)));
/*     */     
/* 734 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 60);
/* 735 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 110);
/* 736 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 4, 120);
/*     */     
/* 738 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 50);
/* 739 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 6, 50);
/* 740 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 7, 50);
/* 741 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 8, 80);
/*     */     
/* 743 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 70);
/* 744 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 11, 70);
/* 745 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 12, 70);
/*     */     
/* 747 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 13, 70);
/* 748 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 14, 70);
/* 749 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 15, 70);
/*     */     
/* 751 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 16, 125);
/* 752 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 17, 100);
/* 753 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*     */     
/* 755 */     this.celda1.pasarInd(this.con2.revisarCol((JTable)this.rSTableMetro1, "ELIMINADO", 0, 17, 0));
/* 756 */     this.celda1.pasarInd2(stockMinimos());
/* 757 */     this.celda1.pasarInd3(stockMaximos());
/*     */     
/* 759 */     this.rSTableMetro1.setSelectionMode(0);
/* 760 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 761 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*     */   }
/*     */   
/*     */   public String[] stockMinimos() {
/* 765 */     ArrayList<String> idsList = new ArrayList<>();
/* 766 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 767 */       double minValue = Double.parseDouble(this.rSTableMetro1.getValueAt(i, 5).toString());
/* 768 */       double dispValue = Double.parseDouble(this.rSTableMetro1.getValueAt(i, 7).toString());
/* 769 */       if (dispValue < minValue) {
/* 770 */         String idValue = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 771 */         idsList.add(idValue);
/*     */       } 
/*     */     } 
/* 774 */     String[] idsArray = idsList.<String>toArray(new String[0]);
/* 775 */     return idsArray;
/*     */   }
/*     */   
/*     */   public String[] stockMaximos() {
/* 779 */     ArrayList<String> idsList = new ArrayList<>();
/* 780 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 781 */       double maxValue = Double.parseDouble(this.rSTableMetro1.getValueAt(i, 6).toString());
/* 782 */       double dispValue = Double.parseDouble(this.rSTableMetro1.getValueAt(i, 7).toString());
/* 783 */       if (dispValue > maxValue && maxValue > 0.0D) {
/* 784 */         String idValue = this.rSTableMetro1.getValueAt(i, 0).toString();
/* 785 */         idsList.add(idValue);
/*     */       } 
/*     */     } 
/* 788 */     String[] idsArray = idsList.<String>toArray(new String[0]);
/* 789 */     return idsArray;
/*     */   }
/*     */   
/*     */   public class CeldaRender1
/*     */     extends DefaultTableCellRenderer {
/* 794 */     int otro = -1;
/* 795 */     String[] indices = new String[0];
/* 796 */     String[] indices2 = new String[0];
/* 797 */     String[] indices3 = new String[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 800 */       setEnabled((table == null || table.isEnabled()));
/* 801 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*     */       
/* 803 */       if (column == 0 || column == 5 || column == 6 || column == 7 || column == 8 || column == 13 || column == 14 || column == 15) {
/* 804 */         setHorizontalAlignment(4);
/*     */       } else {
/* 806 */         setHorizontalAlignment(2);
/*     */       } 
/*     */       
/* 809 */       if (comparar(comp)) {
/* 810 */         setBackground(Color.red);
/* 811 */         setForeground(Color.white);
/* 812 */       } else if (comparar2(comp)) {
/* 813 */         setBackground(Color.ORANGE);
/* 814 */         setForeground(Color.RED);
/* 815 */       } else if (comparar3(comp)) {
/* 816 */         setBackground(new Color(153, 153, 153));
/* 817 */         setForeground(Color.BLACK);
/*     */       } else {
/* 819 */         setBackground((Color)null);
/* 820 */         setForeground(AlmProductos.this.lc.SECUNDARIO1);
/*     */       } 
/*     */       
/* 823 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 824 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(String[] ind) {
/* 828 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public void pasarInd2(String[] ind) {
/* 832 */       this.indices2 = ind;
/*     */     }
/*     */     
/*     */     public void pasarInd3(String[] ind) {
/* 836 */       this.indices3 = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(String reg) {
/* 840 */       for (int i = 0; i < this.indices.length; i++) {
/* 841 */         if (this.indices[i].equals(reg)) {
/* 842 */           return true;
/*     */         }
/*     */       } 
/* 845 */       return false;
/*     */     }
/*     */     
/*     */     public boolean comparar2(String reg) {
/* 849 */       for (int i = 0; i < this.indices2.length; i++) {
/* 850 */         if (this.indices2[i].equals(reg)) {
/* 851 */           return true;
/*     */         }
/*     */       } 
/* 854 */       return false;
/*     */     }
/*     */     
/*     */     public boolean comparar3(String reg) {
/* 858 */       for (int i = 0; i < this.indices3.length; i++) {
/* 859 */         if (this.indices3[i].equals(reg)) {
/* 860 */           return true;
/*     */         }
/*     */       } 
/* 863 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AlmProductos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */