/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ import principal.MaterialButton;
/*     */ 
/*     */ public class AgregarUsuarios extends JPanel {
/*  29 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  30 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  31 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  32 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  33 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  34 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  38 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  39 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  40 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  41 */   Date fechaActual = new Date();
/*  42 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*  43 */   String USUARIO = "";
/*  44 */   Validaciones val = new Validaciones();
/*  45 */   Consultas con = new Consultas();
/*  46 */   Errores error = new Errores(false);
/*     */   String id;
/*     */   String[] inf;
/*     */   JTabbedPane fichas;
/*     */   int INDICE;
/*     */   JTable jTable3;
/*     */   JFrame padre;
/*  53 */   cargarDatos datos = new cargarDatos("EmpleadoAgregar");
/*     */   Color fondo;
/*     */   boolean encontrado = false;
/*  56 */   SColores lc = new SColores(); private JComboBox jComboBox1; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel2; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel7;
/*     */   
/*     */   public AgregarUsuarios(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  59 */     initComponents();
/*  60 */     this.padre = padre;
/*  61 */     this.fichas = fichas;
/*  62 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  63 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  64 */     this.jLabel3.setCursor(micursor);
/*  65 */     panelito.setViewportView(this);
/*  66 */     this.panel = panelito;
/*  67 */     colorear();
/*  68 */     this.jLabel14.setVisible(false);
/*  69 */     this.USUARIO = USUARIO;
/*  70 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  71 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  72 */     editFormat.setGroupingUsed(false);
/*  73 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  74 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  75 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  76 */     enFormat.setAllowsInvalid(true);
/*  77 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  78 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*     */   }
/*     */   private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPasswordField jPasswordField1; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private MaterialButton materialButton21;
/*     */   private MaterialButton materialButton22;
/*     */   
/*     */   private void initComponents() {
/*  84 */     this.jPanel4 = new JPanel();
/*  85 */     this.jLabel1 = new JLabel();
/*  86 */     this.jLabel14 = new JLabel();
/*  87 */     this.jPanel1 = new JPanel();
/*  88 */     this.jPanel6 = new JPanel();
/*  89 */     this.jLabel8 = new JLabel();
/*  90 */     this.jPanel7 = new JPanel();
/*  91 */     this.jLabel4 = new JLabel();
/*  92 */     this.jPanel2 = new JPanel();
/*  93 */     this.jTextField1 = new JTextField();
/*  94 */     this.jLabel2 = new JLabel();
/*  95 */     this.jLabel3 = new JLabel();
/*  96 */     this.jPanel3 = new JPanel();
/*  97 */     this.jPasswordField1 = new JPasswordField();
/*  98 */     this.jLabel5 = new JLabel();
/*  99 */     this.jTextField2 = new JTextField();
/* 100 */     this.jLabel7 = new JLabel();
/* 101 */     this.jLabel15 = new JLabel();
/* 102 */     this.jTextField3 = new JTextField();
/* 103 */     this.jLabel6 = new JLabel();
/* 104 */     this.jComboBox1 = new JComboBox();
/* 105 */     this.jLabel17 = new JLabel();
/* 106 */     this.jFormattedTextField1 = new JFormattedTextField();
/* 107 */     this.jLabel13 = new JLabel();
/* 108 */     this.jLabel10 = new JLabel();
/* 109 */     this.jLabel16 = new JLabel();
/* 110 */     this.jLabel9 = new JLabel();
/* 111 */     this.jTextField4 = new JTextField();
/* 112 */     this.jPanel8 = new JPanel();
/* 113 */     this.materialButton21 = new MaterialButton();
/* 114 */     this.materialButton22 = new MaterialButton();
/*     */     
/* 116 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/* 117 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 119 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/* 120 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/* 121 */     this.jLabel1.setHorizontalAlignment(0);
/* 122 */     this.jLabel1.setText("      Agregar Usuarios");
/*     */     
/* 124 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 125 */     this.jLabel14.setToolTipText("Cerrar");
/* 126 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 128 */             AgregarUsuarios.this.jLabel14MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 131 */             AgregarUsuarios.this.jLabel14MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 134 */             AgregarUsuarios.this.jLabel14MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 138 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 139 */     this.jPanel4.setLayout(jPanel4Layout);
/* 140 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 141 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 142 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 143 */           .addContainerGap()
/* 144 */           .addComponent(this.jLabel1, -2, 533, -2)
/* 145 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 146 */           .addComponent(this.jLabel14)
/* 147 */           .addContainerGap(37, 32767)));
/*     */     
/* 149 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 150 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 151 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 152 */           .addContainerGap()
/* 153 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */             .addComponent(this.jLabel1)
/* 155 */             .addComponent(this.jLabel14))
/* 156 */           .addContainerGap(354, 32767)));
/*     */ 
/*     */     
/* 159 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/* 160 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*     */     
/* 162 */     this.jPanel6.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 164 */     this.jLabel8.setFont(new Font("Cantarell", 1, 22));
/* 165 */     this.jLabel8.setForeground(this.lc.PRIMARIO2);
/* 166 */     this.jLabel8.setHorizontalAlignment(0);
/* 167 */     this.jLabel8.setText("Agregar Usuarios");
/*     */     
/* 169 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 170 */     this.jPanel6.setLayout(jPanel6Layout);
/* 171 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 172 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 173 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 174 */           .addContainerGap()
/* 175 */           .addComponent(this.jLabel8, -1, -1, 32767)
/* 176 */           .addContainerGap()));
/*     */     
/* 178 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 179 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 180 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 181 */           .addContainerGap()
/* 182 */           .addComponent(this.jLabel8)
/* 183 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 186 */     this.jPanel7.setBackground(new Color(255, 255, 255));
/*     */     
/* 188 */     this.jLabel4.setFont(new Font("Cantarell", 2, 11));
/* 189 */     this.jLabel4.setForeground(this.lc.PRIMARIO2);
/* 190 */     this.jLabel4.setText("<html>Agrega usuarios para que trabajen con el sistema. Para comenzar escribe el nombre de usuario de la persona que deseas registrar y confirma si está disponible.</html>");
/*     */     
/* 192 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 193 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Validar nombre de usuario", 0, 1, new Font("Cantarell", 0, 11)));
/*     */     
/* 195 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 197 */             AgregarUsuarios.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 200 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 202 */             AgregarUsuarios.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 206 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/* 207 */     this.jLabel2.setText("Nombre");
/*     */     
/* 209 */     this.jLabel3.setFont(new Font("Cantarell", 2, 11));
/* 210 */     this.jLabel3.setForeground(this.lc.PRIMARIO1);
/* 211 */     this.jLabel3.setText("<html><u>Confirmar Disponibilidad</u></html>");
/* 212 */     this.jLabel3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 214 */             AgregarUsuarios.this.jLabel3MouseClicked(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 217 */             AgregarUsuarios.this.jLabel3MouseExited(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 220 */             AgregarUsuarios.this.jLabel3MouseEntered(evt);
/*     */           }
/*     */         });
/*     */     
/* 224 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 225 */     this.jPanel2.setLayout(jPanel2Layout);
/* 226 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 228 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 229 */           .addContainerGap()
/* 230 */           .addComponent(this.jLabel2, -2, 124, -2)
/* 231 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 232 */           .addComponent(this.jTextField1, -2, 177, -2)
/* 233 */           .addGap(18, 18, 18)
/* 234 */           .addComponent(this.jLabel3, -2, 179, -2)
/* 235 */           .addContainerGap(-1, 32767)));
/*     */     
/* 237 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 239 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 240 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 241 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 242 */             .addComponent(this.jLabel2)
/* 243 */             .addComponent(this.jLabel3, -2, -1, -2))
/* 244 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 247 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/* 248 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, " Datos Personales", 0, 1, new Font("Cantarell", 0, 11)));
/* 249 */     GridBagLayout jPanel3Layout = new GridBagLayout();
/* 250 */     jPanel3Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 251 */     jPanel3Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 252 */     this.jPanel3.setLayout(jPanel3Layout);
/*     */     
/* 254 */     this.jPasswordField1.setEnabled(false);
/* 255 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 256 */     gridBagConstraints.gridx = 2;
/* 257 */     gridBagConstraints.gridy = 2;
/* 258 */     gridBagConstraints.fill = 2;
/* 259 */     gridBagConstraints.weightx = 1.0D;
/* 260 */     this.jPanel3.add(this.jPasswordField1, gridBagConstraints);
/*     */     
/* 262 */     this.jLabel5.setFont(new Font("Cantarell", 0, 11));
/* 263 */     this.jLabel5.setHorizontalAlignment(4);
/* 264 */     this.jLabel5.setText("Contraseña");
/* 265 */     this.jLabel5.setEnabled(false);
/* 266 */     gridBagConstraints = new GridBagConstraints();
/* 267 */     gridBagConstraints.gridx = 0;
/* 268 */     gridBagConstraints.gridy = 2;
/* 269 */     gridBagConstraints.anchor = 17;
/* 270 */     this.jPanel3.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 272 */     this.jTextField2.setEnabled(false);
/* 273 */     gridBagConstraints = new GridBagConstraints();
/* 274 */     gridBagConstraints.gridx = 2;
/* 275 */     gridBagConstraints.gridy = 4;
/* 276 */     gridBagConstraints.fill = 2;
/* 277 */     gridBagConstraints.weightx = 1.0D;
/* 278 */     this.jPanel3.add(this.jTextField2, gridBagConstraints);
/*     */     
/* 280 */     this.jLabel7.setFont(new Font("Cantarell", 0, 11));
/* 281 */     this.jLabel7.setHorizontalAlignment(4);
/* 282 */     this.jLabel7.setText("Departamento");
/* 283 */     this.jLabel7.setEnabled(false);
/* 284 */     gridBagConstraints = new GridBagConstraints();
/* 285 */     gridBagConstraints.gridx = 0;
/* 286 */     gridBagConstraints.gridy = 4;
/* 287 */     gridBagConstraints.anchor = 17;
/* 288 */     this.jPanel3.add(this.jLabel7, gridBagConstraints);
/*     */     
/* 290 */     this.jLabel15.setFont(new Font("Cantarell", 0, 11));
/* 291 */     this.jLabel15.setHorizontalAlignment(4);
/* 292 */     this.jLabel15.setText("Clave de Empleado");
/* 293 */     this.jLabel15.setEnabled(false);
/* 294 */     gridBagConstraints = new GridBagConstraints();
/* 295 */     gridBagConstraints.gridx = 0;
/* 296 */     gridBagConstraints.gridy = 0;
/* 297 */     gridBagConstraints.anchor = 17;
/* 298 */     this.jPanel3.add(this.jLabel15, gridBagConstraints);
/*     */     
/* 300 */     this.jTextField3.setEnabled(false);
/* 301 */     this.jTextField3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 303 */             AgregarUsuarios.this.jTextField3ActionPerformed(evt);
/*     */           }
/*     */         });
/* 306 */     gridBagConstraints = new GridBagConstraints();
/* 307 */     gridBagConstraints.gridx = 2;
/* 308 */     gridBagConstraints.gridy = 0;
/* 309 */     gridBagConstraints.fill = 2;
/* 310 */     gridBagConstraints.anchor = 18;
/* 311 */     gridBagConstraints.weightx = 1.0D;
/* 312 */     this.jPanel3.add(this.jTextField3, gridBagConstraints);
/*     */     
/* 314 */     this.jLabel6.setFont(new Font("Cantarell", 0, 11));
/* 315 */     this.jLabel6.setHorizontalAlignment(4);
/* 316 */     this.jLabel6.setText("Privilegios");
/* 317 */     this.jLabel6.setEnabled(false);
/* 318 */     gridBagConstraints = new GridBagConstraints();
/* 319 */     gridBagConstraints.gridx = 0;
/* 320 */     gridBagConstraints.gridy = 6;
/* 321 */     gridBagConstraints.anchor = 17;
/* 322 */     this.jPanel3.add(this.jLabel6, gridBagConstraints);
/*     */     
/* 324 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 325 */     this.jComboBox1.setFont(new Font("Cantarell", 0, 11));
/* 326 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Administrador", "Capturista", "Cuentas por pagar", "Facturación", "Gerente de Operaciones", "Jefe de Liquidaciones", "Jefe de Tráfico", "Liquidaciones", "Tráfico", "Sistemas", "Recursos Humanos", "Reseteos", "Supervisor de cuentas por pagar", "Super Usuario" }));
/* 327 */     this.jComboBox1.setEnabled(false);
/* 328 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 330 */             AgregarUsuarios.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 333 */     gridBagConstraints = new GridBagConstraints();
/* 334 */     gridBagConstraints.gridx = 2;
/* 335 */     gridBagConstraints.gridy = 6;
/* 336 */     gridBagConstraints.fill = 2;
/* 337 */     gridBagConstraints.anchor = 18;
/* 338 */     gridBagConstraints.weightx = 1.0D;
/* 339 */     this.jPanel3.add(this.jComboBox1, gridBagConstraints);
/*     */     
/* 341 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/* 342 */     this.jLabel17.setHorizontalAlignment(4);
/* 343 */     this.jLabel17.setText("Saldo en caja chica ");
/* 344 */     this.jLabel17.setEnabled(false);
/* 345 */     gridBagConstraints = new GridBagConstraints();
/* 346 */     gridBagConstraints.gridx = 0;
/* 347 */     gridBagConstraints.gridy = 10;
/* 348 */     gridBagConstraints.anchor = 17;
/* 349 */     this.jPanel3.add(this.jLabel17, gridBagConstraints);
/*     */     
/* 351 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 352 */     this.jFormattedTextField1.setEnabled(false);
/* 353 */     gridBagConstraints = new GridBagConstraints();
/* 354 */     gridBagConstraints.gridx = 2;
/* 355 */     gridBagConstraints.gridy = 10;
/* 356 */     gridBagConstraints.fill = 2;
/* 357 */     gridBagConstraints.anchor = 18;
/* 358 */     gridBagConstraints.weightx = 1.0D;
/* 359 */     this.jPanel3.add(this.jFormattedTextField1, gridBagConstraints);
/*     */     
/* 361 */     this.jLabel13.setFont(new Font("Cantarell", 2, 11));
/* 362 */     this.jLabel13.setForeground(this.lc.PRIMARIO2);
/* 363 */     this.jLabel13.setText("<html>Dependiendo el departamento en el que labore, serán los privilegios que el usuario obtendrá.</html>");
/* 364 */     gridBagConstraints = new GridBagConstraints();
/* 365 */     gridBagConstraints.gridx = 4;
/* 366 */     gridBagConstraints.gridy = 4;
/* 367 */     gridBagConstraints.fill = 2;
/* 368 */     this.jPanel3.add(this.jLabel13, gridBagConstraints);
/*     */     
/* 370 */     this.jLabel10.setFont(new Font("Cantarell", 2, 11));
/* 371 */     this.jLabel10.setForeground(this.lc.PRIMARIO2);
/* 372 */     this.jLabel10.setText("<html>La contraseña será la misma al nombre de usuario por ser la primera ocación.</html>");
/* 373 */     gridBagConstraints = new GridBagConstraints();
/* 374 */     gridBagConstraints.gridx = 4;
/* 375 */     gridBagConstraints.gridy = 2;
/* 376 */     gridBagConstraints.fill = 2;
/* 377 */     this.jPanel3.add(this.jLabel10, gridBagConstraints);
/*     */     
/* 379 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/* 380 */     this.jLabel16.setForeground(this.lc.PRIMARIO2);
/* 381 */     gridBagConstraints = new GridBagConstraints();
/* 382 */     gridBagConstraints.gridx = 4;
/* 383 */     gridBagConstraints.gridy = 0;
/* 384 */     gridBagConstraints.fill = 2;
/* 385 */     this.jPanel3.add(this.jLabel16, gridBagConstraints);
/*     */     
/* 387 */     this.jLabel9.setFont(new Font("Cantarell", 0, 11));
/* 388 */     this.jLabel9.setText("Correo Electrónico");
/* 389 */     this.jLabel9.setEnabled(false);
/* 390 */     gridBagConstraints = new GridBagConstraints();
/* 391 */     gridBagConstraints.gridx = 0;
/* 392 */     gridBagConstraints.gridy = 8;
/* 393 */     this.jPanel3.add(this.jLabel9, gridBagConstraints);
/*     */     
/* 395 */     this.jTextField4.setEnabled(false);
/* 396 */     gridBagConstraints = new GridBagConstraints();
/* 397 */     gridBagConstraints.gridx = 2;
/* 398 */     gridBagConstraints.gridy = 8;
/* 399 */     gridBagConstraints.fill = 2;
/* 400 */     this.jPanel3.add(this.jTextField4, gridBagConstraints);
/*     */     
/* 402 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 403 */     this.jPanel7.setLayout(jPanel7Layout);
/* 404 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 405 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 406 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 407 */           .addContainerGap()
/* 408 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 409 */             .addComponent(this.jLabel4)
/* 410 */             .addComponent(this.jPanel2, -1, -1, 32767)
/* 411 */             .addComponent(this.jPanel3, -1, -1, 32767))
/* 412 */           .addContainerGap()));
/*     */     
/* 414 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 415 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 416 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 417 */           .addComponent(this.jLabel4, -2, -1, -2)
/* 418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 419 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 420 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 421 */           .addComponent(this.jPanel3, -1, 251, 32767)
/* 422 */           .addContainerGap()));
/*     */ 
/*     */     
/* 425 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 427 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 428 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 429 */     this.materialButton21.setMnemonic('L');
/* 430 */     this.materialButton21.setText("Limpiar");
/* 431 */     this.materialButton21.setToolTipText("Limpiar (Alt+L)");
/* 432 */     this.materialButton21.setEnabled(false);
/* 433 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 434 */     this.materialButton21.setHorizontalTextPosition(0);
/* 435 */     this.materialButton21.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 437 */             AgregarUsuarios.this.materialButton21ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 441 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/* 442 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 443 */     this.materialButton22.setMnemonic('G');
/* 444 */     this.materialButton22.setText("Guardar");
/* 445 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/* 446 */     this.materialButton22.setEnabled(false);
/* 447 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 448 */     this.materialButton22.setHorizontalTextPosition(0);
/* 449 */     this.materialButton22.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 451 */             AgregarUsuarios.this.materialButton22ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 455 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 456 */     this.jPanel8.setLayout(jPanel8Layout);
/* 457 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 458 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 459 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 460 */           .addContainerGap(-1, 32767)
/* 461 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/* 462 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 463 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/* 464 */           .addContainerGap()));
/*     */     
/* 466 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 467 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 468 */         .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 469 */         .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2));
/*     */ 
/*     */     
/* 472 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 473 */     this.jPanel1.setLayout(jPanel1Layout);
/* 474 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 475 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 476 */         .addComponent(this.jPanel6, -1, -1, 32767)
/* 477 */         .addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 478 */         .addComponent(this.jPanel8, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 480 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 481 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 482 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 483 */           .addComponent(this.jPanel6, -2, -1, -2)
/* 484 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 485 */           .addComponent(this.jPanel7, -2, -1, -2)
/* 486 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 487 */           .addComponent(this.jPanel8, -2, -1, -2)));
/*     */ 
/*     */     
/* 490 */     GroupLayout layout = new GroupLayout(this);
/* 491 */     setLayout(layout);
/* 492 */     layout.setHorizontalGroup(layout
/* 493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 494 */         .addGap(0, 870, 32767)
/* 495 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 496 */           .addGroup(layout.createSequentialGroup()
/* 497 */             .addGap(0, 0, 32767)
/* 498 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 499 */             .addGap(0, 0, 32767))));
/*     */     
/* 501 */     layout.setVerticalGroup(layout
/* 502 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 503 */         .addGap(0, 478, 32767)
/* 504 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 505 */           .addGroup(layout.createSequentialGroup()
/* 506 */             .addGap(0, 0, 32767)
/* 507 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 508 */             .addGap(0, 0, 32767))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 513 */     cargarUsuarios();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jLabel3MouseClicked(MouseEvent evt) {
/* 526 */     if (this.jLabel3.getText().equals("<html><center><u>Cancelar</u></center></html>")) {
/* 527 */       this.jPasswordField1.setText("");
/* 528 */       this.jTextField2.setText("");
/* 529 */       this.jTextField3.setText("");
/* 530 */       this.jTextField1.setText("");
/* 531 */       this.jLabel3.setText("<html><center><u>Confirmar Disponibilidad</u></center></html>");
/* 532 */       this.jTextField1.setEnabled(true);
/* 533 */       this.jTextField3.setEnabled(false);
/* 534 */       this.jLabel15.setEnabled(false);
/* 535 */       this.materialButton22.setEnabled(false);
/* 536 */       this.materialButton21.setEnabled(false);
/* 537 */       this.jLabel16.setText("");
/* 538 */       this.jLabel17.setEnabled(false);
/* 539 */       this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 540 */       this.jFormattedTextField1.setEnabled(false);
/* 541 */       this.jLabel2.setEnabled(true);
/* 542 */       this.jLabel6.setEnabled(false);
/* 543 */       this.jComboBox1.setSelectedIndex(0);
/* 544 */       this.jComboBox1.setEnabled(false);
/* 545 */       this.jLabel9.setEnabled(false);
/* 546 */       this.jTextField4.setEnabled(false);
/* 547 */       this.jTextField4.setText("");
/*     */     } else {
/* 549 */       cargarUsuarios();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jLabel3MouseEntered(MouseEvent evt) {
/* 554 */     this.jLabel3.setForeground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   private void jLabel3MouseExited(MouseEvent evt) {
/* 558 */     this.jLabel3.setForeground(this.lc.PRIMARIO1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jLabel14MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jLabel14MouseEntered(MouseEvent evt) {
/* 567 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*     */   }
/*     */   
/*     */   private void jLabel14MouseExited(MouseEvent evt) {
/* 571 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*     */   }
/*     */   
/*     */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 575 */     String clave = this.jTextField3.getText();
/* 576 */     boolean encon = false;
/* 577 */     if (!this.val.validarDigitos(this.jTextField3, clave)) {
/* 578 */       encon = this.con.consultar("clave_emp", "empleados", "where clave_emp = " + clave);
/* 579 */       if (!encon) {
/* 580 */         this.jTextField3.setBackground(new Color(255, 51, 51));
/* 581 */         JOptionPane.showMessageDialog(this.padre, "El número de empleado no se encuentra registrado en la base de datos.", "Número no Encontrado", 0, this.INFO);
/*     */       } else {
/* 583 */         this.con.consultar("departamentos.nombre", "empleados,departamentos", "where empleados.clave_depa=departamentos.clave_depa and clave_emp = " + clave);
/* 584 */         this.jTextField2.setText(this.con.Campo);
/* 585 */         this.jPasswordField1.setText("UzzielC");
/* 586 */         String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados", "where clave_emp = " + clave, 3);
/* 587 */         this.jLabel16.setText("<html>" + reg[0] + " " + reg[1] + " " + reg[2] + "</html>");
/* 588 */         this.jTextField3.setEnabled(false);
/* 589 */         this.jLabel15.setEnabled(false);
/* 590 */         this.materialButton22.setEnabled(true);
/* 591 */         this.materialButton21.setEnabled(true);
/* 592 */         this.jLabel6.setEnabled(true);
/* 593 */         this.jComboBox1.setEnabled(true);
/* 594 */         this.jLabel9.setEnabled(true);
/* 595 */         this.jTextField4.setEnabled(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 601 */     if (this.jComboBox1.getSelectedItem().equals("Liquidaciones") || this.jComboBox1.getSelectedItem().equals("Jefe de Liquidaciones") || this.jComboBox1.getSelectedItem().equals("Super Usuario")) {
/* 602 */       this.jLabel17.setEnabled(true);
/* 603 */       this.jFormattedTextField1.setEnabled(true);
/*     */     } else {
/* 605 */       this.jLabel17.setEnabled(false);
/* 606 */       this.jFormattedTextField1.setEnabled(false);
/* 607 */       this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 612 */     limpiar();
/*     */   }
/*     */   
/*     */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 616 */     String clave = this.jTextField3.getText();
/* 617 */     String[] campos = { "Nombre de Usuario", "Contraseña", "Clave Empleado", "Nombre Completo", "Dirección", "Departamento", "Sexo" };
/* 618 */     String[] reg = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,sexo", "empleados", "where clave_emp = " + clave, 7);
/* 619 */     String[] info = { this.jTextField1.getText().toUpperCase(), "********", this.jTextField3.getText(), reg[0] + " " + reg[0] + " " + reg[1], reg[3] + " " + reg[3] + " " + reg[4], this.jTextField2.getText(), reg[6] };
/* 620 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 621 */       this.error.cargarError(this.jComboBox1, "050");
/* 622 */     } else if (!this.val.validarSoloNum(this.jTextField3, this.jTextField3.getText())) {
/* 623 */       String depa = String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem());
/* 624 */       float cant = Float.parseFloat(this.jFormattedTextField1.getValue().toString());
/* 625 */       boolean correo = validarEmail(this.jTextField4.getText());
/* 626 */       if (correo) {
/* 627 */         if (cant < 1000.0F && (this.jComboBox1.getSelectedItem().equals("Liquidaciones") || this.jComboBox1.getSelectedItem().equals("Jefe de Liquidaciones") || this.jComboBox1.getSelectedItem().equals("Super Usuario"))) {
/* 628 */           JOptionPane.showMessageDialog(this.padre, "No puedes agregar una cantidad menor a $1,000.00\nPor favor verifica tu información", "Cantidad Pequeña", 0, this.ERROR);
/*     */         } else {
/* 630 */           int res = this.error.cargarDatos(campos, info);
/* 631 */           if (res == 0) {
/* 632 */             String contra = DigestUtils.md5Hex(info[0]);
/* 633 */             this.con.insertar("insert into usuarios(nombre_usu,contrasena,priv,cajaChica,cajaChicaLetra,num_emp, correo) values('" + info[0] + "','" + contra + "','" + depa.toUpperCase() + "'," + cant + ",'" + this.jFormattedTextField1.getText() + "'," + info[2] + ",'" + this.jTextField4.getText().toLowerCase() + "')");
/* 634 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Creó un nuevo usuario, nombre: " + info[0] + "','Nombre Completo: " + info[3] + "\nDirección: " + info[4] + "\nFecha:" + String.valueOf(this.fechaActual) + "')");
/* 635 */             this.jLabel2.setEnabled(true);
/* 636 */             this.jTextField1.setText("");
/* 637 */             this.jTextField1.setEnabled(true);
/* 638 */             this.jLabel3.setText("<html><center><u>Confirmar Disponibilidad</u></center></html>");
/* 639 */             limpiar();
/* 640 */             this.jTextField3.setEnabled(false);
/* 641 */             this.jLabel15.setEnabled(false);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean validarEmail(String correo) {
/* 649 */     Pattern pat = null;
/* 650 */     Matcher mat = null;
/* 651 */     pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
/* 652 */     mat = pat.matcher(correo);
/* 653 */     if (mat.find()) {
/* 654 */       return true;
/*     */     }
/* 656 */     this.jTextField4.setBackground(Color.RED);
/* 657 */     JOptionPane.showMessageDialog(this, "<html>La siguiente dirección de correo parece no válida, verifica tu información: <p>" + correo + "<p></html>", "Dirección de correo no válida", 0, this.ERROR);
/* 658 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void colorear() {
/* 663 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 665 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 669 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jTextField1, evt);
/*     */           }
/*     */         });
/*     */     
/* 673 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 675 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jTextField4, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 679 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jTextField4, evt);
/*     */           }
/*     */         });
/*     */     
/* 683 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 685 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jTextField2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 689 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 692 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 694 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jTextField3, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 698 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 701 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 703 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jPasswordField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 707 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jPasswordField1, evt);
/*     */           }
/*     */         });
/* 710 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 712 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jComboBox1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 716 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 719 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 721 */             AgregarUsuarios.this.jTextGanado(AgregarUsuarios.this.jFormattedTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 725 */             AgregarUsuarios.this.jTextPerdido(AgregarUsuarios.this.jFormattedTextField1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 731 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 735 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void usuarios(String usu) {
/* 739 */     this.USUARIO = usu;
/* 740 */     this.panel.setViewportView(this);
/*     */   }
/*     */   
/*     */   public void limpiar() {
/* 744 */     this.materialButton21.setEnabled(false);
/* 745 */     this.materialButton22.setEnabled(false);
/* 746 */     this.jTextField3.setEnabled(true);
/* 747 */     this.jLabel15.setEnabled(true);
/* 748 */     this.jTextField3.setText("");
/* 749 */     this.jTextField2.setText("");
/* 750 */     this.jPasswordField1.setText("");
/* 751 */     this.jLabel16.setText("");
/* 752 */     this.jLabel6.setEnabled(false);
/* 753 */     this.jLabel17.setEnabled(false);
/* 754 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 755 */     this.jComboBox1.setSelectedIndex(0);
/* 756 */     this.jComboBox1.setEnabled(false);
/* 757 */     this.jLabel9.setEnabled(false);
/* 758 */     this.jTextField4.setEnabled(false);
/* 759 */     this.jTextField4.setText("");
/*     */   }
/*     */   
/*     */   public void cargarUsuarios() {
/* 763 */     boolean mal = false;
/* 764 */     String usu = this.jTextField1.getText();
/* 765 */     if (usu.length() < 6 || usu.length() > 30) {
/* 766 */       this.error.cargarError(this.jTextField1, "007");
/* 767 */       mal = true;
/* 768 */     } else if (usu.equals("")) {
/* 769 */       this.jTextField1.setBackground(new Color(255, 51, 51));
/* 770 */       JOptionPane.showMessageDialog(this.padre, "No puedes dejar en blanco el campo para especificar el Nombre de Usuario", "Falta Información", 0, this.ADVER);
/* 771 */       mal = true;
/* 772 */     } else if (!this.val.validarApostrofe(this.jTextField1, usu, "020")) {
/* 773 */       if (this.con.consultar("nombre_usu", "usuarios", "where nombre_usu = '" + this.jTextField1.getText() + "'")) {
/* 774 */         this.jTextField1.setBackground(new Color(255, 51, 51));
/* 775 */         JOptionPane.showMessageDialog(this.padre, "El nombre de usuario que colocaste ya se encuentra en uso", "Nombre Duplicado", 0, this.ERROR);
/*     */       } else {
/* 777 */         this.jLabel2.setEnabled(false);
/* 778 */         this.jTextField1.setEnabled(false);
/* 779 */         this.jTextField3.setEnabled(true);
/* 780 */         this.jLabel15.setEnabled(true);
/* 781 */         this.jLabel3.setText("<html><center><u>Cancelar</u></center></html>");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AgregarUsuarios.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */