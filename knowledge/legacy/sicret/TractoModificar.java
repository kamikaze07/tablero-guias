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
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class TractoModificar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*     */   String USUARIO;
/*  24 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  27 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  29 */   Date fechaActual = new Date();
/*  30 */   TractoAgregar TractoA = null;
/*  31 */   CeldaRender celda = new CeldaRender();
/*  32 */   MensajePop mensajeTry = null; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40;
/*     */   public TractoModificar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  34 */     this.mensajeTry = mensajeTry;
/*  35 */     initComponents();
/*  36 */     this.padre = padre;
/*  37 */     this.fichas = fichas;
/*  38 */     colorear();
/*  39 */     this.USUARIO = USUARIO;
/*  40 */     panelito.setViewportView(this);
/*  41 */     this.panel = panelito;
/*  42 */     llenarCombos();
/*  43 */     consultar();
/*     */   }
/*     */   private JLabel jLabel41; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3;
/*     */   
/*     */   private void initComponents() {
/*  48 */     this.jPanel1 = new JPanel();
/*  49 */     this.jPanel17 = new JPanel();
/*  50 */     this.jLabel14 = new JLabel();
/*  51 */     this.jLabel32 = new JLabel();
/*  52 */     this.jLabel38 = new JLabel();
/*  53 */     this.jTextField2 = new JTextField();
/*  54 */     this.jTextField1 = new JTextField();
/*  55 */     this.jLabel15 = new JLabel();
/*  56 */     this.jComboBox1 = new JComboBox();
/*  57 */     this.jComboBox2 = new JComboBox();
/*  58 */     this.jLabel39 = new JLabel();
/*  59 */     this.jComboBox3 = new JComboBox();
/*  60 */     this.jComboBox4 = new JComboBox();
/*  61 */     this.jLabel40 = new JLabel();
/*  62 */     this.jTextField3 = new JTextField();
/*  63 */     this.jLabel41 = new JLabel();
/*  64 */     this.jLabel54 = new JLabel();
/*  65 */     this.jPanel5 = new JPanel();
/*  66 */     this.jLabel48 = new JLabel();
/*  67 */     this.jScrollPane3 = new JScrollPane();
/*  68 */     this.jTable3 = new JTable();
/*  69 */     this.jButton5 = new JButton();
/*  70 */     this.jLabel52 = new JLabel();
/*     */     
/*  72 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  73 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  75 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  76 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Tractos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  78 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  79 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  80 */     this.jLabel14.setHorizontalAlignment(0);
/*  81 */     this.jLabel14.setText("Placas");
/*     */     
/*  83 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  84 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  85 */     this.jLabel32.setHorizontalAlignment(0);
/*  86 */     this.jLabel32.setText("Marca");
/*     */     
/*  88 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  89 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  90 */     this.jLabel38.setHorizontalAlignment(0);
/*  91 */     this.jLabel38.setText("Tipo");
/*     */     
/*  93 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  95 */             TractoModificar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  99 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 101 */             TractoModificar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 105 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 106 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 107 */     this.jLabel15.setHorizontalAlignment(0);
/* 108 */     this.jLabel15.setText("Número");
/*     */     
/* 110 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 111 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 113 */             TractoModificar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 117 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 118 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 120 */             TractoModificar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 124 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 125 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 126 */     this.jLabel39.setHorizontalAlignment(0);
/* 127 */     this.jLabel39.setText("Modelo");
/*     */     
/* 129 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 130 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 132 */             TractoModificar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 137 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 138 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 140 */             TractoModificar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 144 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 145 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 146 */     this.jLabel40.setHorizontalAlignment(0);
/* 147 */     this.jLabel40.setText("Estado");
/*     */     
/* 149 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 151 */             TractoModificar.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 155 */     this.jLabel41.setFont(new Font("Tahoma", 2, 11));
/* 156 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 157 */     this.jLabel41.setHorizontalAlignment(0);
/* 158 */     this.jLabel41.setText("Número de Serie");
/*     */     
/* 160 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 161 */     this.jPanel17.setLayout(jPanel17Layout);
/* 162 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 163 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 164 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 165 */           .addContainerGap()
/* 166 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 167 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 168 */               .addComponent(this.jTextField1, -2, 49, -2)
/* 169 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 170 */               .addComponent(this.jTextField2, -2, 155, -2))
/* 171 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 172 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 173 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 174 */               .addComponent(this.jLabel14, -1, -1, 32767)))
/* 175 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 176 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 177 */             .addComponent(this.jComboBox1, 0, -1, 32767)
/* 178 */             .addComponent(this.jLabel32, -1, -1, 32767))
/* 179 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 180 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 181 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 182 */             .addComponent(this.jComboBox2, -2, 211, -2))
/* 183 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 184 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 185 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 186 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 187 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 188 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 189 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 190 */             .addComponent(this.jComboBox4, -2, 111, -2))
/* 191 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 192 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 193 */             .addComponent(this.jLabel41, -1, -1, 32767)
/* 194 */             .addComponent(this.jTextField3, -2, 164, -2))
/* 195 */           .addGap(618, 618, 618)));
/*     */     
/* 197 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 198 */         .createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 199 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 200 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 201 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 202 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 203 */           .addGap(6, 6, 6)
/* 204 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 205 */             .addComponent(this.jLabel15)
/* 206 */             .addComponent(this.jLabel14)))
/* 207 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */           .addGroup(jPanel17Layout.createSequentialGroup()
/* 209 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 210 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 211 */               .addComponent(this.jComboBox2, -2, -1, -2))
/* 212 */             .addGap(6, 6, 6)
/* 213 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 214 */               .addComponent(this.jLabel32)
/* 215 */               .addComponent(this.jLabel38)))
/* 216 */           .addGroup(jPanel17Layout.createSequentialGroup()
/* 217 */             .addComponent(this.jComboBox3, -2, -1, -2)
/* 218 */             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 219 */             .addComponent(this.jLabel39))
/* 220 */           .addGroup(jPanel17Layout.createSequentialGroup()
/* 221 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 222 */               .addComponent(this.jComboBox4, -2, -1, -2)
/* 223 */               .addComponent(this.jTextField3, -2, -1, -2))
/* 224 */             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 225 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 226 */               .addComponent(this.jLabel40)
/* 227 */               .addComponent(this.jLabel41)))));
/*     */ 
/*     */     
/* 230 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 231 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 232 */     this.jLabel54.setHorizontalAlignment(0);
/* 233 */     this.jLabel54.setText("Modificar Tractos");
/*     */     
/* 235 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 236 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 238 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 239 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 240 */     this.jLabel48.setHorizontalAlignment(2);
/* 241 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 243 */     this.jTable3.setAutoCreateRowSorter(true);
/* 244 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 245 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 253 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 258 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 261 */     this.jTable3.setShowVerticalLines(false);
/* 262 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 264 */             TractoModificar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 267 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 269 */     this.jButton5.setMnemonic('M');
/* 270 */     this.jButton5.setText("Modificar");
/* 271 */     this.jButton5.setToolTipText("Modificar (Alt+M)");
/* 272 */     this.jButton5.setEnabled(false);
/* 273 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 275 */             TractoModificar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 279 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 280 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 281 */     this.jLabel52.setHorizontalAlignment(2);
/* 282 */     this.jLabel52.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 284 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 285 */     this.jPanel5.setLayout(jPanel5Layout);
/* 286 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 288 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 289 */           .addContainerGap()
/* 290 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 291 */           .addGap(380, 380, 380)
/* 292 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 294 */           .addComponent(this.jButton5)
/* 295 */           .addContainerGap(-1, 32767))
/* 296 */         .addComponent(this.jScrollPane3));
/*     */     
/* 298 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 299 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 300 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 301 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 302 */             .addComponent(this.jLabel48)
/* 303 */             .addComponent(this.jButton5)
/* 304 */             .addComponent(this.jLabel52))
/* 305 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 306 */           .addComponent(this.jScrollPane3, -1, 141, 32767)));
/*     */ 
/*     */     
/* 309 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 310 */     this.jPanel1.setLayout(jPanel1Layout);
/* 311 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 312 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 313 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 314 */           .addContainerGap()
/* 315 */           .addComponent(this.jLabel54, -2, 1038, -2)
/* 316 */           .addContainerGap(606, 32767))
/* 317 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 318 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*     */     
/* 320 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 322 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 323 */           .addContainerGap()
/* 324 */           .addComponent(this.jLabel54)
/* 325 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 326 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 328 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 329 */           .addContainerGap()));
/*     */ 
/*     */     
/* 332 */     GroupLayout layout = new GroupLayout(this);
/* 333 */     setLayout(layout);
/* 334 */     layout.setHorizontalGroup(layout
/* 335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 336 */         .addGap(0, 1646, 32767)
/* 337 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 338 */           .addGroup(layout.createSequentialGroup()
/* 339 */             .addContainerGap()
/* 340 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 341 */             .addContainerGap())));
/*     */     
/* 343 */     layout.setVerticalGroup(layout
/* 344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */         .addGap(0, 340, 32767)
/* 346 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 347 */           .addGroup(layout.createSequentialGroup()
/* 348 */             .addGap(8, 8, 8)
/* 349 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 350 */             .addGap(8, 8, 8))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 355 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 359 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 363 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 367 */     int ind = this.jTable3.getSelectedRow();
/* 368 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 369 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/*     */     
/* 371 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 375 */     setCursor(new Cursor(3));
/* 376 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 377 */     if (this.fichas.getTabCount() > 1) {
/* 378 */       this.fichas.remove(1);
/*     */     }
/* 380 */     if (this.TractoA == null) {
/* 381 */       this.TractoA = new TractoAgregar(new JScrollPane(), this.USUARIO, this.fichas, this.jTable3, num, this.padre, this.mensajeTry);
/*     */     } else {
/*     */       
/* 384 */       this.TractoA.tracto(this.USUARIO, num);
/*     */     } 
/* 386 */     this.fichas.setSelectedIndex(1);
/* 387 */     cargarMouse();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 391 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 395 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 399 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 403 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 406 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 408 */             TractoModificar.this.jTextGanado(TractoModificar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 411 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 414 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 416 */             TractoModificar.this.jTextGanado(TractoModificar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 419 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 422 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 424 */             TractoModificar.this.jTextGanado(TractoModificar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 427 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 430 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 432 */             TractoModificar.this.jTextGanado(TractoModificar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 435 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 438 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 440 */             TractoModificar.this.jTextGanado(TractoModificar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 443 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 446 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 448 */             TractoModificar.this.jTextGanado(TractoModificar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 451 */             TractoModificar.this.jTextPerdido(TractoModificar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 456 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 459 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 463 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 464 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 465 */       setCursor(micursor);
/*     */     }
/* 467 */     catch (Exception e) {
/* 468 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void tracto(String usu) {
/* 472 */     this.USUARIO = usu;
/* 473 */     this.panel.setViewportView(this);
/* 474 */     llenarCombos();
/* 475 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 478 */     this.con.consultar("count(marca)", "marca", "");
/* 479 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 480 */     this.jComboBox1.removeAllItems();
/* 481 */     this.jComboBox1.addItem("Cualquiera"); int i;
/* 482 */     for (i = 0; i < depa.length; i++) {
/* 483 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/*     */     
/* 486 */     this.con.consultar("count(tipo)", "tipos", "");
/* 487 */     depa = this.con.regresaCol("tipo", "tipos", "order by tipo", Integer.parseInt(this.con.Campo));
/* 488 */     this.jComboBox2.removeAllItems();
/* 489 */     this.jComboBox2.addItem("Cualquiera");
/* 490 */     for (i = 0; i < depa.length; i++) {
/* 491 */       this.jComboBox2.addItem(depa[i]);
/*     */     }
/*     */     
/* 494 */     this.jComboBox3.removeAllItems();
/* 495 */     int año = this.fechaActual.getYear();
/* 496 */     año += 1901;
/* 497 */     this.jComboBox3.addItem("Cualquiera");
/* 498 */     for (int j = año; j >= 1990; j--)
/* 499 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 503 */     String numero = this.jTextField1.getText();
/* 504 */     String serie = this.jTextField2.getText();
/* 505 */     String marca = "";
/* 506 */     String tipo = "";
/* 507 */     String modelo = "";
/* 508 */     String estado = "";
/* 509 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 510 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 512 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 513 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 515 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 516 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 518 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 519 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 521 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and no_serie like '%" + this.jTextField3.getText() + "%' and num_tracto<>0");
/* 522 */     int totreg = Integer.parseInt(this.con.Campo);
/* 523 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto<>0");
/* 524 */     String tot = this.con.Campo;
/* 525 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 526 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 527 */           .buscarReg(20, totreg, "num_tracto,modelo,color,no_serie,no_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipos.tipo,tracto.num_sem,tracto.NUM_sct,tracto.num_sed,tracto.num_seg,tracto.num_eco", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and no_serie like '%" + this.jTextField3.getText() + "%' and num_tracto<>0 order by num_tracto"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 532 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 536 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 539 */     this.jTable3.setShowVerticalLines(false);
/* 540 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 542 */             TractoModificar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 545 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 546 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 547 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 548 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 549 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 550 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
/* 551 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(60);
/* 552 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 553 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/* 554 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(50);
/* 555 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(50);
/* 556 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 557 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 558 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 559 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 560 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 561 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 562 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 563 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 564 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 565 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 566 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(65);
/* 567 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(65);
/* 568 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 569 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/* 570 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(75);
/* 571 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(75);
/*     */     
/* 573 */     this.jButton5.setEnabled(false);
/* 574 */     this.jTable3.setSelectionMode(0);
/* 575 */     this.jTable3.setAutoCreateRowSorter(true);
/* 576 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 578 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 579 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 580 */       if (valor.equals("0")) {
/* 581 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 584 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 588 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 589 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 590 */       if (valor.equals("0")) {
/* 591 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 594 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/* 597 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 598 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 599 */       if (valor.equals("0")) {
/* 600 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 603 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/*     */     
/* 607 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 608 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 609 */       if (valor.equals("0")) {
/* 610 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 613 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/*     */     
/* 617 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 618 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 19));
/* 619 */       if (valor.equals("0")) {
/* 620 */         this.jTable3.setValueAt("No", i, 19);
/*     */       } else {
/*     */         
/* 623 */         this.jTable3.setValueAt("Si", i, 19);
/*     */       } 
/*     */     } 
/* 626 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 627 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 628 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 629 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 630 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 631 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 632 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 633 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 634 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 635 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 636 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 637 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 638 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 639 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 640 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 641 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 642 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 643 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 644 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 645 */     this.jTable3.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 648 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 649 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 651 */       setEnabled((table == null || table.isEnabled()));
/* 652 */       if (row % 2 == 0 && column == 7) {
/* 653 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 655 */       else if (row % 2 == 0) {
/* 656 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 658 */         setBackground((Color)null);
/* 659 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 660 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TractoModificar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */