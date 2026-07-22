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
/*     */ public class CajaModificar extends JPanel {
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
/*  30 */   CajaAgregar CajaA = null;
/*  31 */   CeldaRender celda = new CeldaRender();
/*  32 */   MensajePop mensajeTry = null; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40;
/*     */   public CajaModificar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
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
/*  73 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*     */     
/*  75 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  76 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Remolques ", 0, 0, new Font("Tahoma", 1, 11)));
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
/*  95 */             CajaModificar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  99 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 101 */             CajaModificar.this.jTextField1KeyReleased(evt);
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
/* 113 */             CajaModificar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 117 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 118 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Góndola", "Pipa" }));
/* 119 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 121 */             CajaModificar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 125 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 126 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 127 */     this.jLabel39.setHorizontalAlignment(0);
/* 128 */     this.jLabel39.setText("Modelo");
/*     */     
/* 130 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 131 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 133 */             CajaModificar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 137 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 138 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 139 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 141 */             CajaModificar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 145 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 146 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 147 */     this.jLabel40.setHorizontalAlignment(0);
/* 148 */     this.jLabel40.setText("Estado");
/*     */     
/* 150 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 152 */             CajaModificar.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 156 */     this.jLabel41.setFont(new Font("Tahoma", 2, 11));
/* 157 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 158 */     this.jLabel41.setHorizontalAlignment(0);
/* 159 */     this.jLabel41.setText("Número de Serie");
/*     */     
/* 161 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 162 */     this.jPanel17.setLayout(jPanel17Layout);
/* 163 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 165 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 166 */           .addContainerGap()
/* 167 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 168 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 169 */               .addComponent(this.jTextField1, -2, 49, -2)
/* 170 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 171 */               .addComponent(this.jTextField2, -2, 155, -2))
/* 172 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 173 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 174 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 175 */               .addComponent(this.jLabel14, -1, -1, 32767)))
/* 176 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 177 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 178 */             .addComponent(this.jLabel32, -1, -1, 32767)
/* 179 */             .addComponent(this.jComboBox1, 0, 217, 32767))
/* 180 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 181 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 182 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 183 */             .addComponent(this.jComboBox2, 0, 138, 32767))
/* 184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 185 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 186 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 187 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 188 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 189 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 190 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 191 */             .addComponent(this.jComboBox4, 0, 110, 32767))
/* 192 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 193 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 194 */             .addComponent(this.jLabel41, -1, -1, 32767)
/* 195 */             .addComponent(this.jTextField3, -1, 127, 32767))
/* 196 */           .addGap(457, 457, 457)));
/*     */     
/* 198 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 199 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 200 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 201 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 202 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 203 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 204 */                 .addComponent(this.jTextField2, -2, -1, -2)
/* 205 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 206 */                 .addComponent(this.jComboBox1, -2, -1, -2))
/* 207 */               .addGap(6, 6, 6)
/* 208 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 209 */                 .addComponent(this.jLabel15)
/* 210 */                 .addComponent(this.jLabel14)
/* 211 */                 .addComponent(this.jLabel32)))
/* 212 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 213 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 214 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 215 */               .addComponent(this.jLabel38))
/* 216 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 217 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 218 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 219 */               .addComponent(this.jLabel39))
/* 220 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 221 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 222 */                 .addComponent(this.jComboBox4, -2, -1, -2)
/* 223 */                 .addComponent(this.jTextField3, -2, -1, -2))
/* 224 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 225 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 226 */                 .addComponent(this.jLabel40)
/* 227 */                 .addComponent(this.jLabel41))))
/* 228 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 231 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 232 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 233 */     this.jLabel54.setHorizontalAlignment(0);
/* 234 */     this.jLabel54.setText("Modificar Remolques");
/*     */     
/* 236 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 237 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 239 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 240 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 241 */     this.jLabel48.setHorizontalAlignment(2);
/* 242 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 244 */     this.jTable3.setAutoCreateRowSorter(true);
/* 245 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 246 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 254 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 259 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 262 */     this.jTable3.setShowVerticalLines(false);
/* 263 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 265 */             CajaModificar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 268 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 270 */     this.jButton5.setMnemonic('M');
/* 271 */     this.jButton5.setText("Modificar");
/* 272 */     this.jButton5.setToolTipText("Modificar (Alt+M)");
/* 273 */     this.jButton5.setEnabled(false);
/* 274 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 276 */             CajaModificar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 280 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 281 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 282 */     this.jLabel52.setHorizontalAlignment(2);
/* 283 */     this.jLabel52.setText("Para modificar los datos, selecciona el registro y pulsa el botón 'Modificar'");
/*     */     
/* 285 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 286 */     this.jPanel5.setLayout(jPanel5Layout);
/* 287 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 288 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 289 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 290 */           .addContainerGap()
/* 291 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 292 */           .addGap(380, 380, 380)
/* 293 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 295 */           .addComponent(this.jButton5)
/* 296 */           .addContainerGap(395, 32767))
/* 297 */         .addComponent(this.jScrollPane3, -1, 1422, 32767));
/*     */     
/* 299 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 301 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 302 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 303 */             .addComponent(this.jLabel48)
/* 304 */             .addComponent(this.jButton5)
/* 305 */             .addComponent(this.jLabel52))
/* 306 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 307 */           .addComponent(this.jScrollPane3, -1, 166, 32767)));
/*     */ 
/*     */     
/* 310 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 311 */     this.jPanel1.setLayout(jPanel1Layout);
/* 312 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 314 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 315 */           .addContainerGap()
/* 316 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 317 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 318 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 319 */             .addComponent(this.jLabel54, -2, 1038, -2))
/* 320 */           .addContainerGap()));
/*     */     
/* 322 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 324 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 325 */           .addContainerGap()
/* 326 */           .addComponent(this.jLabel54)
/* 327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 328 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 329 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 330 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 331 */           .addContainerGap()));
/*     */ 
/*     */     
/* 334 */     GroupLayout layout = new GroupLayout(this);
/* 335 */     setLayout(layout);
/* 336 */     layout.setHorizontalGroup(layout
/* 337 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 338 */         .addGap(0, 1478, 32767)
/* 339 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 340 */           .addGroup(layout.createSequentialGroup()
/* 341 */             .addContainerGap()
/* 342 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 343 */             .addContainerGap())));
/*     */     
/* 345 */     layout.setVerticalGroup(layout
/* 346 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 347 */         .addGap(0, 387, 32767)
/* 348 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 349 */           .addGroup(layout.createSequentialGroup()
/* 350 */             .addGap(11, 11, 11)
/* 351 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 352 */             .addGap(11, 11, 11))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 357 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 361 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 365 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 369 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 373 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 377 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 381 */     int ind = this.jTable3.getSelectedRow();
/* 382 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 383 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/*     */     
/* 385 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 389 */     setCursor(new Cursor(3));
/* 390 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 391 */     if (this.fichas.getTabCount() > 1) {
/* 392 */       this.fichas.remove(1);
/*     */     }
/* 394 */     if (this.CajaA == null) {
/* 395 */       this.CajaA = new CajaAgregar(new JScrollPane(), this.USUARIO, this.fichas, this.jTable3, num, this.padre, this.mensajeTry);
/*     */     } else {
/*     */       
/* 398 */       this.CajaA.caja(this.USUARIO, num);
/*     */     } 
/*     */     
/* 401 */     this.fichas.setSelectedIndex(1);
/* 402 */     cargarMouse();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 406 */     consultar();
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 410 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 412 */             CajaModificar.this.jTextGanado(CajaModificar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 415 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 418 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 420 */             CajaModificar.this.jTextGanado(CajaModificar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 423 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 426 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 428 */             CajaModificar.this.jTextGanado(CajaModificar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 431 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 434 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 436 */             CajaModificar.this.jTextGanado(CajaModificar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 439 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 442 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 444 */             CajaModificar.this.jTextGanado(CajaModificar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 447 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 450 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 452 */             CajaModificar.this.jTextGanado(CajaModificar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 455 */             CajaModificar.this.jTextPerdido(CajaModificar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 460 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 463 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 467 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 468 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 469 */       setCursor(micursor);
/*     */     }
/* 471 */     catch (Exception e) {
/* 472 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void caja(String usu) {
/* 476 */     this.USUARIO = usu;
/* 477 */     this.panel.setViewportView(this);
/* 478 */     llenarCombos();
/* 479 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 482 */     this.con.consultar("count(marca)", "marca", "");
/* 483 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 484 */     this.jComboBox1.removeAllItems();
/* 485 */     this.jComboBox1.addItem("Cualquiera");
/* 486 */     for (int i = 0; i < depa.length; i++) {
/* 487 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/* 489 */     this.jComboBox3.removeAllItems();
/* 490 */     int año = this.fechaActual.getYear();
/* 491 */     año += 1901;
/* 492 */     this.jComboBox3.addItem("Cualquiera");
/* 493 */     for (int j = año; j >= 1990; j--)
/* 494 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 498 */     String numero = this.jTextField1.getText();
/* 499 */     String serie = this.jTextField2.getText();
/* 500 */     String marca = "";
/* 501 */     String tipo = "";
/* 502 */     String modelo = "";
/* 503 */     String estado = "";
/* 504 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 505 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 507 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 508 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 510 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 511 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 513 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 514 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 516 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and no_serie like '%" + this.jTextField3.getText() + "%' and num_rem<>0");
/* 517 */     int totreg = Integer.parseInt(this.con.Campo);
/* 518 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem<>0");
/* 519 */     String tot = this.con.Campo;
/* 520 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 521 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 522 */           .buscarReg(19, totreg, "num_rem,modelo,color,no_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipo,remolque.num_sem,remolque.NUM_sct,remolque.num_sed,remolque.num_seg,remolque.num_eco", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and no_serie like '%" + this.jTextField3.getText() + "%' and num_rem<>0 and num_rem<>0 order by num_rem"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 527 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 531 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 534 */     this.jTable3.setShowVerticalLines(false);
/* 535 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 537 */             CajaModificar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 540 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 541 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 542 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 543 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 544 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 545 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 546 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/* 547 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 548 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 549 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 550 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 551 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(45);
/* 552 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(45);
/* 553 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 554 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 555 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(65);
/* 556 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(65);
/* 557 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(85);
/* 558 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(85);
/*     */     
/* 560 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(65);
/* 561 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(65);
/* 562 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 563 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(65);
/* 564 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 565 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 566 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 567 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 568 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(75);
/* 569 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(75);
/* 570 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 571 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/*     */     
/* 573 */     this.jButton5.setEnabled(false);
/* 574 */     this.jTable3.setSelectionMode(0);
/* 575 */     this.jTable3.setAutoCreateRowSorter(true);
/* 576 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 578 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 579 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 14));
/* 580 */       if (valor.equals("0")) {
/* 581 */         this.jTable3.setValueAt("No", i, 14);
/*     */       } else {
/*     */         
/* 584 */         this.jTable3.setValueAt("Si", i, 14);
/*     */       } 
/*     */     } 
/*     */     
/* 588 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 589 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 590 */       if (valor.equals("0")) {
/* 591 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 594 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 598 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 599 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 600 */       if (valor.equals("0")) {
/* 601 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 604 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 608 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 609 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 610 */       if (valor.equals("0")) {
/* 611 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 614 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/*     */     
/* 618 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 619 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 620 */       if (valor.equals("0")) {
/* 621 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 624 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/*     */     
/* 628 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 629 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 630 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 631 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 632 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 633 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 634 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 635 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 636 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 637 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 638 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 639 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 640 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 641 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 642 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 643 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 644 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 645 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 646 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 649 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 650 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 652 */       setEnabled((table == null || table.isEnabled()));
/* 653 */       if (row % 2 == 0 && column == 6) {
/* 654 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 656 */       else if (row % 2 == 0) {
/* 657 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 659 */         setBackground((Color)null);
/* 660 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 661 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CajaModificar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */