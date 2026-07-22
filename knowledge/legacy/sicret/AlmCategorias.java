/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class AlmCategorias extends JPanel {
/*  19 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  20 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  21 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  22 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  23 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  24 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  25 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*  26 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  27 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  31 */   JFrame padre = null;
/*  32 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  33 */   Date fechaActual = new Date();
/*  34 */   SColores lc = new SColores();
/*     */   Map<String, String> CAMPOSGENERALES;
/*  36 */   Utilerias utilerias = new Utilerias();
/*  37 */   Consultas2 con = new Consultas2();
/*     */   String USUARIO;
/*  39 */   PlaceHolder placeHolder = null;
/*  40 */   String holderCat = "INGRESA EL NOMBRE";
/*  41 */   pintarComponentes pintar = new pintarComponentes(); private JButton jButton24; private JButton jButton25; private JButton jButton60; private JDialog jDialog1; private JLabel jLabel1; private JLabel jLabel125; private JLabel jLabel235; private JLabel jLabel4; private JLabel jLabel48; private JPanel jPanel171; private JPanel jPanel29; private JPanel jPanel4; private JPanel jPanel52; private JPanel jPanel53; private JScrollPane jScrollPane35; private JSeparator jSeparator1; private JTextField jTextField1; private JTextField jTextField2;
/*     */   private MaterialButton materialButton36;
/*     */   private MaterialButton materialButton37;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public AlmCategorias(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  47 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  48 */     this.con.setBaseDatos("sicre2PR");
/*  49 */     this.padre = padre;
/*  50 */     initComponents();
/*     */     
/*  52 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(120, 120, 120), Color.BLACK, this.holderCat, false, "Cantarell", 11);
/*  53 */     this.USUARIO = USUARIO;
/*  54 */     panelito.setViewportView(this);
/*  55 */     this.panel = panelito;
/*  56 */     consultar();
/*  57 */     this.pintar.colorear(this.jTextField1);
/*  58 */     this.pintar.colorear(this.jTextField2);
/*     */     
/*  60 */     this.utilerias.activarVentanajDialog(this.jDialog1, 535, 155);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  66 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  67 */     this.jPanel29 = new JPanel();
/*  68 */     this.jLabel125 = new JLabel();
/*  69 */     this.materialButton36 = new MaterialButton();
/*  70 */     this.materialButton37 = new MaterialButton();
/*  71 */     this.jSeparator1 = new JSeparator();
/*  72 */     this.jTextField2 = new JTextField();
/*  73 */     this.jPanel4 = new JPanel();
/*  74 */     this.jPanel52 = new JPanel();
/*  75 */     this.jLabel4 = new JLabel();
/*  76 */     this.jPanel53 = new JPanel();
/*  77 */     this.jLabel1 = new JLabel();
/*  78 */     this.jTextField1 = new JTextField();
/*  79 */     this.jScrollPane35 = new JScrollPane();
/*  80 */     this.rSTableMetro1 = new RSTableMetro();
/*  81 */     this.jButton24 = new JButton();
/*  82 */     this.jButton60 = new JButton();
/*  83 */     this.jButton25 = new JButton();
/*  84 */     this.jPanel171 = new JPanel();
/*  85 */     this.jLabel235 = new JLabel();
/*  86 */     this.jLabel48 = new JLabel();
/*     */     
/*  88 */     this.jDialog1.setTitle("Categorías");
/*  89 */     this.jDialog1.setModal(true);
/*     */     
/*  91 */     this.jLabel125.setHorizontalAlignment(4);
/*  92 */     this.jLabel125.setText("Nombre de la categoría ");
/*     */     
/*  94 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/*  95 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/*  96 */     this.materialButton36.setMnemonic('C');
/*  97 */     this.materialButton36.setText("Cerrar");
/*  98 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/*  99 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 100 */     this.materialButton36.setHorizontalTextPosition(0);
/* 101 */     this.materialButton36.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 103 */             AlmCategorias.this.materialButton36ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 108 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 109 */     this.materialButton37.setMnemonic('A');
/* 110 */     this.materialButton37.setText("Agregar");
/* 111 */     this.materialButton37.setToolTipText("Cancelar CFDI (Alt+A)");
/* 112 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 113 */     this.materialButton37.setHorizontalTextPosition(0);
/* 114 */     this.materialButton37.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 116 */             AlmCategorias.this.materialButton37ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 120 */     this.jTextField2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 122 */             AlmCategorias.this.jTextField2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 126 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 127 */     this.jPanel29.setLayout(jPanel29Layout);
/* 128 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 129 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 130 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 131 */           .addComponent(this.jLabel125, -2, 186, -2)
/* 132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 133 */           .addComponent(this.jTextField2)
/* 134 */           .addContainerGap())
/* 135 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 136 */           .addGap(0, 259, 32767)
/* 137 */           .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 138 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 139 */           .addComponent((Component)this.materialButton36, -2, 105, -2)
/* 140 */           .addGap(15, 15, 15))
/* 141 */         .addComponent(this.jSeparator1));
/*     */     
/* 143 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 145 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 146 */           .addContainerGap()
/* 147 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 148 */             .addComponent(this.jLabel125)
/* 149 */             .addComponent(this.jTextField2, -2, -1, -2))
/* 150 */           .addGap(21, 21, 21)
/* 151 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 152 */           .addGap(4, 4, 4)
/* 153 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 154 */             .addComponent((Component)this.materialButton37, -2, 38, -2)
/* 155 */             .addComponent((Component)this.materialButton36, -2, 38, -2))
/* 156 */           .addContainerGap(57, 32767)));
/*     */ 
/*     */     
/* 159 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 160 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 161 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 163 */         .addComponent(this.jPanel29, -2, -1, -2));
/*     */     
/* 165 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 166 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 167 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*     */ 
/*     */     
/* 170 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 171 */     this.jPanel4.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*     */     
/* 173 */     this.jPanel52.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 175 */     this.jLabel4.setFont(new Font("Cantarell", 1, 22));
/* 176 */     this.jLabel4.setForeground(this.lc.PRIMARIO2);
/* 177 */     this.jLabel4.setHorizontalAlignment(0);
/* 178 */     this.jLabel4.setText("Categorías");
/*     */     
/* 180 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 181 */     this.jPanel52.setLayout(jPanel52Layout);
/* 182 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 185 */           .addComponent(this.jLabel4, -1, -1, 32767)
/* 186 */           .addGap(30, 30, 30)));
/*     */     
/* 188 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 190 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 191 */           .addContainerGap()
/* 192 */           .addComponent(this.jLabel4)
/* 193 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 196 */     this.jPanel53.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 198 */     this.jLabel1.setText("Búsqueda de categoría");
/*     */     
/* 200 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 202 */             AlmCategorias.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 206 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Categoría" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 214 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 219 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 222 */     this.rSTableMetro1.setAltoHead(25);
/* 223 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 224 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 225 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 226 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 227 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 228 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 229 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 230 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 231 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 232 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 233 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 234 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 235 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 236 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 237 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 239 */             AlmCategorias.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 242 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 244 */             AlmCategorias.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 247 */     this.jScrollPane35.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 249 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 250 */     this.jButton24.setMnemonic('N');
/* 251 */     this.jButton24.setText("Nueva");
/* 252 */     this.jButton24.setToolTipText("Crear nueva categoría(Alt+N)");
/* 253 */     this.jButton24.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 255 */             AlmCategorias.this.jButton24ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 259 */     this.jButton60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 260 */     this.jButton60.setMnemonic('M');
/* 261 */     this.jButton60.setText("Modifcar");
/* 262 */     this.jButton60.setToolTipText("Modificar(Alt+M)");
/* 263 */     this.jButton60.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 265 */             AlmCategorias.this.jButton60ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 269 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 270 */     this.jButton25.setMnemonic('E');
/* 271 */     this.jButton25.setText("Eliminar");
/* 272 */     this.jButton25.setToolTipText("Eliminar (Alt+E)");
/* 273 */     this.jButton25.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 275 */             AlmCategorias.this.jButton25ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 279 */     this.jPanel171.setBackground(this.lc.SECUNDARIO1);
/* 280 */     this.jPanel171.setLayout(new GridLayout(1, 2, 3, 0));
/*     */     
/* 282 */     this.jLabel235.setFont(new Font("Cantarell", 0, 13));
/* 283 */     this.jLabel235.setForeground(this.lc.TERCERO1);
/* 284 */     this.jLabel235.setHorizontalAlignment(4);
/* 285 */     this.jLabel235.setText("Total: ");
/* 286 */     this.jPanel171.add(this.jLabel235);
/*     */     
/* 288 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 289 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/* 290 */     this.jLabel48.setHorizontalAlignment(0);
/* 291 */     this.jLabel48.setText("t");
/* 292 */     this.jPanel171.add(this.jLabel48);
/*     */     
/* 294 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/* 295 */     this.jPanel53.setLayout(jPanel53Layout);
/* 296 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/* 297 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 298 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 299 */           .addContainerGap()
/* 300 */           .addComponent(this.jLabel1, -2, 175, -2)
/* 301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 302 */           .addComponent(this.jTextField1, -2, 348, -2)
/* 303 */           .addContainerGap(-1, 32767))
/* 304 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 305 */           .addGap(12, 12, 12)
/* 306 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 307 */             .addGroup(jPanel53Layout.createSequentialGroup()
/* 308 */               .addComponent(this.jPanel171, -2, 163, -2)
/* 309 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, 32767)
/* 310 */               .addComponent(this.jButton24, -2, 163, -2)
/* 311 */               .addGap(6, 6, 6)
/* 312 */               .addComponent(this.jButton60, -2, 163, -2)
/* 313 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 314 */               .addComponent(this.jButton25, -2, 163, -2))
/* 315 */             .addComponent(this.jScrollPane35))
/* 316 */           .addContainerGap()));
/*     */     
/* 318 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/* 319 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 320 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 321 */           .addContainerGap()
/* 322 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 323 */             .addComponent(this.jLabel1)
/* 324 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 325 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 326 */           .addComponent(this.jScrollPane35, -1, 298, 32767)
/* 327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 328 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 329 */             .addComponent(this.jButton24, -2, 31, -2)
/* 330 */             .addComponent(this.jButton60, -2, 31, -2)
/* 331 */             .addComponent(this.jButton25, -2, 31, -2)
/* 332 */             .addComponent(this.jPanel171, -2, 31, -2))
/* 333 */           .addGap(16, 16, 16)));
/*     */ 
/*     */     
/* 336 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 337 */     this.jPanel4.setLayout(jPanel4Layout);
/* 338 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 339 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 340 */         .addComponent(this.jPanel52, -1, -1, 32767)
/* 341 */         .addComponent(this.jPanel53, -1, -1, 32767));
/*     */     
/* 343 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 346 */           .addComponent(this.jPanel52, -2, -1, -2)
/* 347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 348 */           .addComponent(this.jPanel53, -1, -1, 32767)));
/*     */ 
/*     */     
/* 351 */     GroupLayout layout = new GroupLayout(this);
/* 352 */     setLayout(layout);
/* 353 */     layout.setHorizontalGroup(layout
/* 354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 355 */         .addGap(0, 1249, 32767)
/* 356 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 357 */           .addGroup(layout.createSequentialGroup()
/* 358 */             .addGap(0, 0, 32767)
/* 359 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 360 */             .addGap(0, 0, 32767))));
/*     */     
/* 362 */     layout.setVerticalGroup(layout
/* 363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 364 */         .addGap(0, 472, 32767)
/* 365 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 366 */           .addGroup(layout.createSequentialGroup()
/* 367 */             .addGap(18, 18, 18)
/* 368 */             .addComponent(this.jPanel4, -1, -1, 32767)
/* 369 */             .addGap(19, 19, 19))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 382 */     this.jTextField2.setText("");
/* 383 */     this.materialButton37.setText("Agregar");
/* 384 */     this.materialButton37.setToolTipText("Agregar nueva categoría (Alt+A)");
/* 385 */     this.materialButton37.setMnemonic('A');
/* 386 */     this.jDialog1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jButton60ActionPerformed(ActionEvent evt) {
/* 390 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 391 */     if (ind < 0) {
/* 392 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una categoría para eliminar los datos.", "Selecciona una categoría", 0, this.ADVER);
/*     */     } else {
/* 394 */       this.jTextField2.setText(this.rSTableMetro1.getValueAt(ind, 1).toString());
/* 395 */       this.materialButton37.setToolTipText("Modificar");
/* 396 */       this.materialButton37.setMnemonic('M');
/* 397 */       this.materialButton37.setText("Modificar");
/* 398 */       this.jDialog1.setVisible(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 403 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 404 */     if (ind < 0) {
/* 405 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una categoría para modificar los datos.", "Selecciona una categoría", 0, this.ADVER);
/*     */     } else {
/* 407 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas eliminar la categoría que seleccionaste: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)) + "?", "Eliminar Categoría", 0, 3, this.ELIMINAR);
/* 408 */       if (res == 0) {
/* 409 */         this.con.eliminar("alm_categorias", "where idCat = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 410 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro1, this.rSTableMetro1.getSelectedRow());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 417 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 421 */     aceptar();
/*     */   }
/*     */   
/*     */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 425 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */   
/*     */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 429 */     aceptar();
/*     */   }
/*     */   
/*     */   public void aceptar() {
/* 433 */     String cat = this.jTextField2.getText().toUpperCase();
/* 434 */     if (cat.equals("")) {
/* 435 */       this.jTextField2.setBackground(Color.RED);
/* 436 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar el nombre de la categoría vacío", "Falta el nombre", 0, this.ERROR);
/* 437 */     } else if (this.materialButton37.getText().equals("Agregar")) {
/* 438 */       if (this.utilerias.buscarDatoEnTabla((JTable)this.rSTableMetro1, cat, 1)) {
/* 439 */         JOptionPane.showMessageDialog(this.jDialog1, "La categoría que deseas ingresar ya se encuentra registrada ", "Categoría ya existe", 0, this.ADVER);
/*     */       } else {
/* 441 */         this.con.inserSinMsj("insert into alm_categorias(categoria) values('" + cat.toUpperCase() + "')");
/* 442 */         this.jDialog1.setVisible(false);
/* 443 */         consultar();
/*     */       } 
/*     */     } else {
/* 446 */       this.con.inserSinMsj("update alm_categorias set categoria = '" + cat + "' where idCat = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 447 */       this.rSTableMetro1.setValueAt(cat, this.rSTableMetro1.getSelectedRow(), 1);
/* 448 */       this.jDialog1.setVisible(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void categorias(String usu) {
/* 453 */     this.USUARIO = usu;
/* 454 */     this.panel.setViewportView(this);
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 458 */     this.con.setBaseDatos("sicre2PR");
/* 459 */     String cat = "";
/* 460 */     if (!this.jTextField1.getText().equals(this.holderCat)) {
/* 461 */       cat = this.jTextField1.getText();
/*     */     }
/* 463 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "ID", "Categoría" }, "idCat, categoria", "alm_categorias", "where categoria like '%" + cat + "%' order by categoria");
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
/* 474 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 80);
/* 475 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 476 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AlmCategorias.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */