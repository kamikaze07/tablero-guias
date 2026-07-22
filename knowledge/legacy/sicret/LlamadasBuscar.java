/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class LlamadasBuscar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*  21 */   Toolkit tk = Toolkit.getDefaultToolkit(); JFrame padre; JScrollPane panel;
/*  22 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  23 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  24 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  25 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  26 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  27 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*     */   MostrarTabla modelo;
/*  30 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*     */   JTabbedPane fichas;
/*     */   String USUARIO;
/*     */   JTable tabla;
/*     */   EscribirReporte esc;
/*  35 */   Errores error = new Errores(false);
/*  36 */   Validaciones val = new Validaciones();
/*  37 */   String CLAVE = ""; private JButton jButton1; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JLabel jLabel15; private JLabel jLabel39; private JLabel jLabel41; private JLabel jLabel42;
/*     */   public LlamadasBuscar(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*  39 */     initComponents();
/*  40 */     this.USUARIO = usua;
/*  41 */     this.fichas = fichas;
/*  42 */     padre = padre;
/*  43 */     panelito.setViewportView(this);
/*  44 */     this.panel = panelito;
/*  45 */     colorear();
/*  46 */     consultar();
/*  47 */     int w = this.tama.width;
/*  48 */     int h = this.tama.height;
/*  49 */     int rw = (w - 300) / 2;
/*  50 */     int rh = (h - 135) / 2;
/*  51 */     llenarCombos();
/*     */   }
/*     */   private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3;
/*     */   private JTextField jTextField1;
/*     */   
/*     */   private void initComponents() {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.jLabel54 = new JLabel();
/*  59 */     this.jPanel5 = new JPanel();
/*  60 */     this.jLabel48 = new JLabel();
/*  61 */     this.jScrollPane3 = new JScrollPane();
/*  62 */     this.jTable3 = new JTable();
/*  63 */     this.jLabel59 = new JLabel();
/*  64 */     this.jButton1 = new JButton();
/*  65 */     this.jLabel52 = new JLabel();
/*  66 */     this.jButton5 = new JButton();
/*  67 */     this.jPanel17 = new JPanel();
/*  68 */     this.jTextField1 = new JTextField();
/*  69 */     this.jLabel15 = new JLabel();
/*  70 */     this.jComboBox1 = new JComboBox();
/*  71 */     this.jLabel39 = new JLabel();
/*  72 */     this.jLabel41 = new JLabel();
/*  73 */     this.jComboBox3 = new JComboBox();
/*  74 */     this.jComboBox4 = new JComboBox();
/*  75 */     this.jLabel42 = new JLabel();
/*  76 */     this.jComboBox5 = new JComboBox();
/*  77 */     this.jLabel43 = new JLabel();
/*  78 */     this.jComboBox6 = new JComboBox();
/*  79 */     this.jLabel44 = new JLabel();
/*  80 */     this.jLabel45 = new JLabel();
/*  81 */     this.jComboBox7 = new JComboBox();
/*  82 */     this.jComboBox8 = new JComboBox();
/*  83 */     this.jLabel46 = new JLabel();
/*     */     
/*  85 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  86 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*     */     
/*  88 */     this.jLabel54.setFont(new Font("Tahoma", 1, 20));
/*  89 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  90 */     this.jLabel54.setHorizontalAlignment(0);
/*  91 */     this.jLabel54.setText("HISTORIAL DE PEDIDOS");
/*     */     
/*  93 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  94 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  96 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/*  97 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/*  98 */     this.jLabel48.setHorizontalAlignment(2);
/*  99 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 101 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 102 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciudad", "Estado", "Sexo", "Teléfono 1", "Teléfono 2", "Correo", "Abogado" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     this.jTable3.setShowVerticalLines(false);
/* 111 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 113 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 114 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 115 */     this.jLabel59.setHorizontalAlignment(4);
/* 116 */     this.jLabel59.setText("Imprimir Consulta");
/*     */     
/* 118 */     this.jButton1.setText("Imprimir");
/* 119 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 121 */             LlamadasBuscar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 125 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 126 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 127 */     this.jLabel52.setHorizontalAlignment(4);
/* 128 */     this.jLabel52.setText("Si deseas crear un nuevo reporte presiona el botón de 'Guardar Reporte'");
/*     */     
/* 130 */     this.jButton5.setMnemonic('G');
/* 131 */     this.jButton5.setText("Guardar Reporte");
/* 132 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 133 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 135 */             LlamadasBuscar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 139 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 140 */     this.jPanel5.setLayout(jPanel5Layout);
/* 141 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 142 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 143 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 144 */           .addContainerGap()
/* 145 */           .addComponent(this.jLabel48, -2, 213, -2)
/* 146 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 147 */           .addComponent(this.jLabel59, -2, 99, -2)
/* 148 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 149 */           .addComponent(this.jButton1)
/* 150 */           .addGap(66, 66, 66)
/* 151 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 153 */           .addComponent(this.jButton5)
/* 154 */           .addContainerGap(639, 32767))
/* 155 */         .addComponent(this.jScrollPane3, -1, 1592, 32767));
/*     */     
/* 157 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 158 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 159 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 160 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 161 */             .addComponent(this.jLabel48)
/* 162 */             .addComponent(this.jLabel59)
/* 163 */             .addComponent(this.jButton1)
/* 164 */             .addComponent(this.jLabel52)
/* 165 */             .addComponent(this.jButton5))
/* 166 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 167 */           .addComponent(this.jScrollPane3, -1, 286, 32767)));
/*     */ 
/*     */     
/* 170 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 171 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Pedidos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 173 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 175 */             LlamadasBuscar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 179 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 180 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 181 */     this.jLabel15.setHorizontalAlignment(0);
/* 182 */     this.jLabel15.setText("Núm.");
/*     */     
/* 184 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 185 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Agua de Fractura", "Agua Residual", "Lodo Base Aceite", "Lodo Base Agua", "Recorte Base Aceite", "Recorte Base Agua", "Saneamiento" }));
/* 186 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 188 */             LlamadasBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 192 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 193 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 194 */     this.jLabel39.setHorizontalAlignment(0);
/* 195 */     this.jLabel39.setText("Residuo");
/*     */     
/* 197 */     this.jLabel41.setFont(new Font("Tahoma", 2, 11));
/* 198 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 199 */     this.jLabel41.setHorizontalAlignment(0);
/* 200 */     this.jLabel41.setText("Origen");
/*     */     
/* 202 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 203 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 204 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 206 */             LlamadasBuscar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 210 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 211 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 212 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 214 */             LlamadasBuscar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 218 */     this.jLabel42.setFont(new Font("Tahoma", 2, 11));
/* 219 */     this.jLabel42.setForeground(new Color(15, 87, 51));
/* 220 */     this.jLabel42.setHorizontalAlignment(0);
/* 221 */     this.jLabel42.setText("Destinatario");
/*     */     
/* 223 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 224 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 225 */     this.jComboBox5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 227 */             LlamadasBuscar.this.jComboBox5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 231 */     this.jLabel43.setFont(new Font("Tahoma", 2, 11));
/* 232 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/* 233 */     this.jLabel43.setHorizontalAlignment(0);
/* 234 */     this.jLabel43.setText("Equipo");
/*     */     
/* 236 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 237 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 238 */     this.jComboBox6.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 240 */             LlamadasBuscar.this.jComboBox6ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 244 */     this.jLabel44.setFont(new Font("Tahoma", 2, 11));
/* 245 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/* 246 */     this.jLabel44.setHorizontalAlignment(0);
/* 247 */     this.jLabel44.setText("Plataforma");
/*     */     
/* 249 */     this.jLabel45.setFont(new Font("Tahoma", 2, 11));
/* 250 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/* 251 */     this.jLabel45.setHorizontalAlignment(0);
/* 252 */     this.jLabel45.setText("Pozo");
/*     */     
/* 254 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 255 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 256 */     this.jComboBox7.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 258 */             LlamadasBuscar.this.jComboBox7ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 262 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 263 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Activa", "Cancelada" }));
/* 264 */     this.jComboBox8.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 266 */             LlamadasBuscar.this.jComboBox8ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 270 */     this.jLabel46.setFont(new Font("Tahoma", 2, 11));
/* 271 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 272 */     this.jLabel46.setHorizontalAlignment(0);
/* 273 */     this.jLabel46.setText("Estado");
/*     */     
/* 275 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 276 */     this.jPanel17.setLayout(jPanel17Layout);
/* 277 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 278 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 279 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 280 */           .addGap(20, 20, 20)
/* 281 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 282 */             .addComponent(this.jLabel15, -2, 49, -2)
/* 283 */             .addComponent(this.jTextField1, -2, 60, -2))
/* 284 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 285 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 286 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 287 */             .addComponent(this.jComboBox1, -2, 131, -2))
/* 288 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 289 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 290 */             .addComponent(this.jLabel41, -1, -1, 32767)
/* 291 */             .addComponent(this.jComboBox3, 0, 214, 32767))
/* 292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 293 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 294 */             .addComponent(this.jLabel42, -1, -1, 32767)
/* 295 */             .addComponent(this.jComboBox4, 0, 213, 32767))
/* 296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 297 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 298 */             .addComponent(this.jLabel43, -1, -1, 32767)
/* 299 */             .addComponent(this.jComboBox5, -2, 131, -2))
/* 300 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 301 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 302 */             .addComponent(this.jLabel44, -1, -1, 32767)
/* 303 */             .addComponent(this.jComboBox6, -2, 131, -2))
/* 304 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 305 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 306 */             .addComponent(this.jLabel45, -1, -1, 32767)
/* 307 */             .addComponent(this.jComboBox7, -2, 131, -2))
/* 308 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 309 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 310 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 311 */             .addComponent(this.jComboBox8, -2, 131, -2))
/* 312 */           .addGap(388, 388, 388)));
/*     */     
/* 314 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 316 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 317 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 318 */           .addGap(8, 8, 8)
/* 319 */           .addComponent(this.jLabel15))
/* 320 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 321 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 322 */           .addGap(8, 8, 8)
/* 323 */           .addComponent(this.jLabel39))
/* 324 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 325 */           .addComponent(this.jComboBox3, -2, -1, -2)
/* 326 */           .addGap(8, 8, 8)
/* 327 */           .addComponent(this.jLabel41))
/* 328 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 329 */           .addComponent(this.jComboBox4, -2, -1, -2)
/* 330 */           .addGap(8, 8, 8)
/* 331 */           .addComponent(this.jLabel42))
/* 332 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 333 */           .addComponent(this.jComboBox5, -2, -1, -2)
/* 334 */           .addGap(8, 8, 8)
/* 335 */           .addComponent(this.jLabel43))
/* 336 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 337 */           .addComponent(this.jComboBox6, -2, -1, -2)
/* 338 */           .addGap(8, 8, 8)
/* 339 */           .addComponent(this.jLabel44))
/* 340 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 341 */           .addComponent(this.jComboBox7, -2, -1, -2)
/* 342 */           .addGap(8, 8, 8)
/* 343 */           .addComponent(this.jLabel45))
/* 344 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 345 */           .addComponent(this.jComboBox8, -2, -1, -2)
/* 346 */           .addGap(8, 8, 8)
/* 347 */           .addComponent(this.jLabel46)));
/*     */ 
/*     */     
/* 350 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 351 */     this.jPanel1.setLayout(jPanel1Layout);
/* 352 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 353 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 354 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 355 */           .addContainerGap()
/* 356 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 357 */             .addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 358 */             .addComponent(this.jPanel17, GroupLayout.Alignment.TRAILING, -1, 1604, 32767)
/* 359 */             .addComponent(this.jLabel54, -1, 1604, 32767))
/* 360 */           .addContainerGap()));
/*     */     
/* 362 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 364 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 365 */           .addComponent(this.jLabel54)
/* 366 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 367 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 368 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 369 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 372 */     GroupLayout layout = new GroupLayout(this);
/* 373 */     setLayout(layout);
/* 374 */     layout.setHorizontalGroup(layout
/* 375 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 376 */         .addGroup(layout.createSequentialGroup()
/* 377 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 378 */           .addGap(20, 20, 20)));
/*     */     
/* 380 */     layout.setVerticalGroup(layout
/* 381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 382 */         .addGroup(layout.createSequentialGroup()
/* 383 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 384 */           .addContainerGap()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 390 */       if (!this.jTable3.print());
/*     */ 
/*     */     
/*     */     }
/* 394 */     catch (PrinterException printerException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 399 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 403 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 407 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 411 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 415 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 419 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 423 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 427 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 431 */     String[] datos = { "NÚM", "F. DE PEDIDO", "F. DE INGRESO", "RESIDUO", "CLIENTE", "DESTINO", "EQUIPO", "PLATAFORMA", "POZO", "ESTADO", "COMENTARIO" };
/* 432 */     this.esc = new EscribirReporte("Historial de Pedidos", this.jTable3, datos, this.USUARIO);
/*     */   }
/*     */   public void colorear() {
/* 435 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 437 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 440 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 443 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 445 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 448 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 451 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 453 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 456 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 459 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 461 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 464 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/* 467 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 469 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox5, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 472 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox5, evt);
/*     */           }
/*     */         });
/* 475 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 477 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox6, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 480 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox6, evt);
/*     */           }
/*     */         });
/* 483 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 485 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox7, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 488 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox7, evt);
/*     */           }
/*     */         });
/* 491 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 493 */             LlamadasBuscar.this.jTextGanado(LlamadasBuscar.this.jComboBox8, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 496 */             LlamadasBuscar.this.jTextPerdido(LlamadasBuscar.this.jComboBox8, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 501 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 504 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 507 */     String folio = this.jTextField1.getText();
/* 508 */     String residuo = "";
/* 509 */     String tipo = "";
/* 510 */     String origen = "";
/* 511 */     String destino = "";
/* 512 */     String equipo = "";
/* 513 */     String plataforma = "";
/* 514 */     String pozo = "";
/* 515 */     String estado = "";
/* 516 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 517 */       residuo = String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 519 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 520 */       origen = String.valueOf(this.jComboBox3.getSelectedItem()) + String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 522 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 523 */       destino = String.valueOf(this.jComboBox4.getSelectedItem()) + String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 525 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 526 */       equipo = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*     */     }
/* 528 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 529 */       plataforma = String.valueOf(this.jComboBox6.getSelectedItem()) + String.valueOf(this.jComboBox6.getSelectedItem());
/*     */     }
/* 531 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 532 */       pozo = String.valueOf(this.jComboBox7.getSelectedItem()) + String.valueOf(this.jComboBox7.getSelectedItem());
/*     */     }
/* 534 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 535 */       estado = String.valueOf(this.jComboBox8.getSelectedItem());
/*     */     }
/* 537 */     this.encontrado = this.con.consultar("count(llamadas_historicas.num_llama)", "llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria", "where llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and llamadas_historicas.num_llama like '%" + folio + "%' and residuo like '%" + residuo + "%' and emp_generadora.empresa like '%" + origen + "%' and emp_destinataria.empresa like '%" + destino + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and llamadas_historicas.estado like '%" + estado + "%' order by num_llama desc");
/* 538 */     int totreg = Integer.parseInt(this.con.Campo);
/* 539 */     this.encontrado = this.con.consultar("count(num_llama)", "llamadas_historicas", "");
/* 540 */     String tot = this.con.Campo;
/* 541 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 542 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 543 */           .buscarReg(12, totreg, "llamadas_historicas.num_llama,num_guia,fecha_ped,llamadas_historicas.ingreso,residuo,emp_generadora.empresa, emp_destinataria.empresa,equipo,plataforma,pozos.nombre,llamadas_historicas.estado,llamadas_historicas.comen", "llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria", "where llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and llamadas_historicas.num_llama like '%" + folio + "%' and residuo like '%" + residuo + "%' and emp_generadora.empresa like '%" + origen + "%' and emp_destinataria.empresa like '%" + destino + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and llamadas_historicas.estado like '%" + estado + "%' order by num_llama desc"), (Object[])new String[] { "Núm", "Guía", "F. de Pedido", "F. Ingreso", "Residuo", "Cliente", "Destino", "Equipo", "Plataforma", "Pozos", "Estado", "Comentario" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 548 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 552 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 555 */     this.jTable3.setShowVerticalLines(false);
/* 556 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 557 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 558 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 559 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 560 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 561 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 562 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(110);
/* 563 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 564 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(110);
/* 565 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(120);
/* 566 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(120);
/*     */     
/* 568 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(90);
/* 569 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(90);
/* 570 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(100);
/* 571 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(100);
/* 572 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(90);
/* 573 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(90);
/* 574 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(130);
/* 575 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(130);
/*     */     
/* 577 */     this.jTable3.setSelectionMode(0);
/* 578 */     this.jTable3.setAutoCreateRowSorter(true);
/* 579 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */   }
/*     */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 582 */     int cont = this.jTable3.getRowCount();
/* 583 */     String[] registros = new String[cont]; int i;
/* 584 */     for (i = 0; i < cont; i++) {
/* 585 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*     */     }
/* 587 */     for (i = 0; i < cont; i++) {
/* 588 */       registros[i] = registros[i] + " " + registros[i];
/* 589 */       this.jTable3.setValueAt(registros[i], i, destino);
/*     */     } 
/* 591 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 592 */     this.jTable3.removeColumn(columna);
/*     */   }
/*     */   public void llamadas(String usu) {
/* 595 */     this.USUARIO = usu;
/* 596 */     this.panel.setViewportView(this);
/* 597 */     llenarCombos();
/* 598 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 601 */     this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0");
/* 602 */     String[] datos = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 603 */     this.jComboBox3.removeAllItems();
/* 604 */     this.jComboBox3.addItem("Selecciona uno..."); int i;
/* 605 */     for (i = 0; i < datos.length; i++) {
/* 606 */       this.jComboBox3.addItem(datos[i]);
/*     */     }
/*     */     
/* 609 */     this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0");
/* 610 */     datos = this.con.regresaCol("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 611 */     this.jComboBox4.removeAllItems();
/* 612 */     this.jComboBox4.addItem("Selecciona uno...");
/* 613 */     for (i = 0; i < datos.length; i++) {
/* 614 */       this.jComboBox4.addItem(datos[i]);
/*     */     }
/*     */     
/* 617 */     this.con.consultar("count(equipo)", "equipos", "where num_equipo<>0");
/* 618 */     datos = this.con.regresaCol("equipo", "equipos", "where num_equipo<>0 order by equipo", Integer.parseInt(this.con.Campo));
/* 619 */     this.jComboBox5.removeAllItems();
/* 620 */     this.jComboBox5.addItem("Selecciona uno...");
/* 621 */     for (i = 0; i < datos.length; i++) {
/* 622 */       this.jComboBox5.addItem(datos[i]);
/*     */     }
/* 624 */     this.con.consultar("count(plataforma)", "plataformas", "");
/* 625 */     datos = this.con.regresaCol("plataforma", "plataformas", "order by plataforma", Integer.parseInt(this.con.Campo));
/* 626 */     this.jComboBox6.removeAllItems();
/* 627 */     this.jComboBox6.addItem("Selecciona uno...");
/* 628 */     for (i = 0; i < datos.length; i++) {
/* 629 */       this.jComboBox6.addItem(datos[i]);
/*     */     }
/*     */     
/* 632 */     this.con.consultar("count(nombre)", "pozos", "");
/* 633 */     datos = this.con.regresaCol("nombre", "pozos", "order by nombre", Integer.parseInt(this.con.Campo));
/* 634 */     this.jComboBox7.removeAllItems();
/* 635 */     this.jComboBox7.addItem("Selecciona uno...");
/* 636 */     for (i = 0; i < datos.length; i++)
/* 637 */       this.jComboBox7.addItem(datos[i]); 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/LlamadasBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */