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
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ 
/*     */ public class UsuariosEliminar extends JPanel {
/*     */   Border borde;
/*  35 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  36 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  37 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  38 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  39 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  40 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  41 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*     */   String USUARIO;
/*  43 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*     */   AltaOperador operador;
/*  47 */   int contador = 0;
/*     */   JFrame padre;
/*     */   EscribirReporte esc;
/*  50 */   CeldaRender celda = new CeldaRender();
/*  51 */   Errores error = new Errores(true);
/*  52 */   SColores lc = new SColores(); private JButton jButton1; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JDialog jDialog1; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel48;
/*     */   
/*     */   public UsuariosEliminar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  55 */     this.padre = padre;
/*  56 */     this.fichas = fichas;
/*  57 */     initComponents();
/*  58 */     colorear();
/*  59 */     this.USUARIO = USUARIO;
/*  60 */     panelito.setViewportView(this);
/*  61 */     this.panel = panelito;
/*  62 */     consultar();
/*     */     
/*  64 */     int w = this.tama.width;
/*  65 */     int h = this.tama.height;
/*  66 */     int rw = (w - 350) / 2;
/*  67 */     int rh = (h - 225) / 2;
/*  68 */     this.jDialog1.setLocation(rw, rh);
/*  69 */     this.jDialog1.setSize(350, 225);
/*     */     
/*  71 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  72 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  73 */     editFormat.setGroupingUsed(false);
/*  74 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  75 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  76 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  77 */     enFormat.setAllowsInvalid(true);
/*  78 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  79 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*     */   }
/*     */   private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel23; private JPanel jPanel5; private JPasswordField jPasswordField1; private JPasswordField jPasswordField2; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private MaterialButton materialButton21;
/*     */   private MaterialButton materialButton22;
/*     */   
/*     */   private void initComponents() {
/*  85 */     this.jDialog1 = new JDialog(this.padre);
/*  86 */     this.jPanel23 = new JPanel();
/*  87 */     this.jLabel20 = new JLabel();
/*  88 */     this.jLabel21 = new JLabel();
/*  89 */     this.jPasswordField1 = new JPasswordField();
/*  90 */     this.jPasswordField2 = new JPasswordField();
/*  91 */     this.jLabel22 = new JLabel();
/*  92 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  93 */     this.jLabel23 = new JLabel();
/*  94 */     this.jComboBox2 = new JComboBox();
/*  95 */     this.jLabel1 = new JLabel();
/*  96 */     this.jTextField5 = new JTextField();
/*  97 */     this.materialButton21 = new MaterialButton();
/*  98 */     this.materialButton22 = new MaterialButton();
/*  99 */     this.jPanel1 = new JPanel();
/* 100 */     this.jPanel17 = new JPanel();
/* 101 */     this.jTextField4 = new JTextField();
/* 102 */     this.jLabel15 = new JLabel();
/* 103 */     this.jLabel14 = new JLabel();
/* 104 */     this.jTextField1 = new JTextField();
/* 105 */     this.jTextField2 = new JTextField();
/* 106 */     this.jLabel32 = new JLabel();
/* 107 */     this.jLabel38 = new JLabel();
/* 108 */     this.jTextField3 = new JTextField();
/* 109 */     this.jComboBox1 = new JComboBox();
/* 110 */     this.jLabel39 = new JLabel();
/* 111 */     this.jLabel54 = new JLabel();
/* 112 */     this.jPanel5 = new JPanel();
/* 113 */     this.jScrollPane3 = new JScrollPane();
/* 114 */     this.jTable3 = new JTable();
/* 115 */     this.jButton5 = new JButton();
/* 116 */     this.jLabel52 = new JLabel();
/* 117 */     this.jLabel53 = new JLabel();
/* 118 */     this.jButton1 = new JButton();
/* 119 */     this.jLabel48 = new JLabel();
/*     */     
/* 121 */     this.jDialog1.setTitle("Activar usuario");
/* 122 */     this.jDialog1.setModal(true);
/* 123 */     this.jDialog1.setResizable(false);
/*     */     
/* 125 */     GridBagLayout jPanel23Layout = new GridBagLayout();
/* 126 */     jPanel23Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 127 */     jPanel23Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 128 */     this.jPanel23.setLayout(jPanel23Layout);
/*     */     
/* 130 */     this.jLabel20.setFont(new Font("Cantarell", 0, 11));
/* 131 */     this.jLabel20.setHorizontalAlignment(4);
/* 132 */     this.jLabel20.setText("Contraseña ");
/* 133 */     this.jLabel20.setEnabled(false);
/* 134 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 135 */     gridBagConstraints.gridx = 2;
/* 136 */     gridBagConstraints.gridy = 0;
/* 137 */     gridBagConstraints.anchor = 17;
/* 138 */     gridBagConstraints.weightx = 0.5D;
/* 139 */     this.jPanel23.add(this.jLabel20, gridBagConstraints);
/*     */     
/* 141 */     this.jLabel21.setFont(new Font("Cantarell", 0, 11));
/* 142 */     this.jLabel21.setHorizontalAlignment(4);
/* 143 */     this.jLabel21.setText("Confirmar Contraseña");
/* 144 */     this.jLabel21.setEnabled(false);
/* 145 */     gridBagConstraints = new GridBagConstraints();
/* 146 */     gridBagConstraints.gridx = 2;
/* 147 */     gridBagConstraints.gridy = 2;
/* 148 */     gridBagConstraints.anchor = 17;
/* 149 */     gridBagConstraints.weightx = 0.5D;
/* 150 */     this.jPanel23.add(this.jLabel21, gridBagConstraints);
/*     */     
/* 152 */     this.jPasswordField1.setEnabled(false);
/* 153 */     gridBagConstraints = new GridBagConstraints();
/* 154 */     gridBagConstraints.gridx = 4;
/* 155 */     gridBagConstraints.gridy = 0;
/* 156 */     gridBagConstraints.fill = 2;
/* 157 */     gridBagConstraints.anchor = 18;
/* 158 */     gridBagConstraints.weightx = 1.0D;
/* 159 */     this.jPanel23.add(this.jPasswordField1, gridBagConstraints);
/*     */     
/* 161 */     this.jPasswordField2.setEnabled(false);
/* 162 */     gridBagConstraints = new GridBagConstraints();
/* 163 */     gridBagConstraints.gridx = 4;
/* 164 */     gridBagConstraints.gridy = 2;
/* 165 */     gridBagConstraints.fill = 2;
/* 166 */     gridBagConstraints.anchor = 18;
/* 167 */     gridBagConstraints.weightx = 1.0D;
/* 168 */     this.jPanel23.add(this.jPasswordField2, gridBagConstraints);
/*     */     
/* 170 */     this.jLabel22.setFont(new Font("Cantarell", 0, 11));
/* 171 */     this.jLabel22.setHorizontalAlignment(4);
/* 172 */     this.jLabel22.setText("Caja Chica ");
/* 173 */     this.jLabel22.setEnabled(false);
/* 174 */     gridBagConstraints = new GridBagConstraints();
/* 175 */     gridBagConstraints.gridx = 2;
/* 176 */     gridBagConstraints.gridy = 8;
/* 177 */     gridBagConstraints.anchor = 17;
/* 178 */     gridBagConstraints.weightx = 0.5D;
/* 179 */     this.jPanel23.add(this.jLabel22, gridBagConstraints);
/*     */     
/* 181 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 182 */     this.jFormattedTextField1.setText("$0.0");
/* 183 */     this.jFormattedTextField1.setEnabled(false);
/* 184 */     gridBagConstraints = new GridBagConstraints();
/* 185 */     gridBagConstraints.gridx = 4;
/* 186 */     gridBagConstraints.gridy = 8;
/* 187 */     gridBagConstraints.fill = 2;
/* 188 */     gridBagConstraints.anchor = 18;
/* 189 */     gridBagConstraints.weightx = 1.0D;
/* 190 */     this.jPanel23.add(this.jFormattedTextField1, gridBagConstraints);
/*     */     
/* 192 */     this.jLabel23.setFont(new Font("Cantarell", 0, 11));
/* 193 */     this.jLabel23.setHorizontalAlignment(4);
/* 194 */     this.jLabel23.setText("Privilegios ");
/* 195 */     gridBagConstraints = new GridBagConstraints();
/* 196 */     gridBagConstraints.gridx = 2;
/* 197 */     gridBagConstraints.gridy = 4;
/* 198 */     gridBagConstraints.gridwidth = 3;
/* 199 */     gridBagConstraints.anchor = 17;
/* 200 */     gridBagConstraints.weightx = 0.5D;
/* 201 */     this.jPanel23.add(this.jLabel23, gridBagConstraints);
/*     */     
/* 203 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 204 */     this.jComboBox2.setFont(new Font("Cantarell", 0, 11));
/* 205 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "Administrador", "Capturista", "Cuentas por pagar", "Facturación", "Gerente de Operaciones", "Jefe de Liquidaciones", "Jefe de Tráfico", "Liquidaciones", "Tráfico", "Sistemas", "Recursos Humanos", "Reseteos", "Supervisor de cuentas por pagar", "Super Usuario" }));
/* 206 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 208 */             UsuariosEliminar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 211 */     gridBagConstraints = new GridBagConstraints();
/* 212 */     gridBagConstraints.gridx = 4;
/* 213 */     gridBagConstraints.gridy = 4;
/* 214 */     gridBagConstraints.fill = 2;
/* 215 */     gridBagConstraints.anchor = 18;
/* 216 */     gridBagConstraints.weightx = 1.0D;
/* 217 */     this.jPanel23.add(this.jComboBox2, gridBagConstraints);
/*     */     
/* 219 */     this.jLabel1.setFont(new Font("Cantarell", 0, 11));
/* 220 */     this.jLabel1.setText("Correo");
/* 221 */     gridBagConstraints = new GridBagConstraints();
/* 222 */     gridBagConstraints.gridx = 2;
/* 223 */     gridBagConstraints.gridy = 6;
/* 224 */     gridBagConstraints.anchor = 17;
/* 225 */     gridBagConstraints.weightx = 0.5D;
/* 226 */     this.jPanel23.add(this.jLabel1, gridBagConstraints);
/* 227 */     gridBagConstraints = new GridBagConstraints();
/* 228 */     gridBagConstraints.gridx = 4;
/* 229 */     gridBagConstraints.gridy = 6;
/* 230 */     gridBagConstraints.fill = 2;
/* 231 */     gridBagConstraints.weightx = 1.0D;
/* 232 */     this.jPanel23.add(this.jTextField5, gridBagConstraints);
/*     */     
/* 234 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 235 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 236 */     this.materialButton21.setMnemonic('S');
/* 237 */     this.materialButton21.setText("Salir");
/* 238 */     this.materialButton21.setToolTipText("Salir (Alt+S)");
/* 239 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 240 */     this.materialButton21.setHorizontalTextPosition(0);
/* 241 */     this.materialButton21.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 243 */             UsuariosEliminar.this.materialButton21ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 247 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/* 248 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 249 */     this.materialButton22.setMnemonic('A');
/* 250 */     this.materialButton22.setText("Activar ");
/* 251 */     this.materialButton22.setToolTipText("Activar (Alt+A)");
/* 252 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 253 */     this.materialButton22.setHorizontalTextPosition(0);
/* 254 */     this.materialButton22.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 256 */             UsuariosEliminar.this.materialButton22ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 260 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 261 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 262 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 263 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 264 */         .addComponent(this.jPanel23, -1, 372, 32767)
/* 265 */         .addGroup(jDialog1Layout.createSequentialGroup()
/* 266 */           .addGap(0, 0, 32767)
/* 267 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/* 268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 269 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*     */     
/* 271 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 272 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 273 */         .addGroup(jDialog1Layout.createSequentialGroup()
/* 274 */           .addComponent(this.jPanel23, -2, 160, -2)
/* 275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 276 */           .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 277 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 278 */             .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2))
/* 279 */           .addGap(0, 15, 32767)));
/*     */ 
/*     */     
/* 282 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 283 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 285 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 286 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Usuarios", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 288 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 290 */             UsuariosEliminar.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 294 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 295 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 296 */     this.jLabel15.setHorizontalAlignment(0);
/* 297 */     this.jLabel15.setText("Nombre de Usuario");
/*     */     
/* 299 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/* 300 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/* 301 */     this.jLabel14.setHorizontalAlignment(0);
/* 302 */     this.jLabel14.setText("Nombre (s)");
/*     */     
/* 304 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 306 */             UsuariosEliminar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 310 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 312 */             UsuariosEliminar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 316 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/* 317 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 318 */     this.jLabel32.setText("Apellido Paterno");
/*     */     
/* 320 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/* 321 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 322 */     this.jLabel38.setHorizontalAlignment(0);
/* 323 */     this.jLabel38.setText("Apellido Materno");
/*     */     
/* 325 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 327 */             UsuariosEliminar.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 331 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 332 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 333 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Administrador", "Facturación", "Gerente de Operaciones", "Jefe de Liquidaciones", "Jefe de Tráfico", "Liquidaciones", "Tráfico", "Sistemas", "Recursos Humanos", "Super Usuario" }));
/* 334 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 336 */             UsuariosEliminar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 340 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 341 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 342 */     this.jLabel39.setHorizontalAlignment(0);
/* 343 */     this.jLabel39.setText("Privilegios");
/*     */     
/* 345 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 346 */     this.jPanel17.setLayout(jPanel17Layout);
/* 347 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 348 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 349 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 350 */           .addContainerGap()
/* 351 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 352 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 353 */             .addComponent(this.jTextField4, -2, 155, -2))
/* 354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 355 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 356 */             .addComponent(this.jLabel14, -1, -1, 32767)
/* 357 */             .addComponent(this.jTextField1, -2, 155, -2))
/* 358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 359 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 360 */             .addComponent(this.jTextField2, -2, 151, -2)
/* 361 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 362 */               .addGap(34, 34, 34)
/* 363 */               .addComponent(this.jLabel32, -2, 90, -2)))
/* 364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 365 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 366 */             .addComponent(this.jTextField3, -2, 163, -2)
/* 367 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 368 */               .addGap(43, 43, 43)
/* 369 */               .addComponent(this.jLabel38)))
/* 370 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 371 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 372 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 373 */             .addComponent(this.jComboBox1, -2, 171, -2))
/* 374 */           .addGap(347, 347, 347)));
/*     */     
/* 376 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 377 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 378 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 379 */           .addComponent(this.jTextField4, -2, -1, -2)
/* 380 */           .addGap(8, 8, 8)
/* 381 */           .addComponent(this.jLabel15))
/* 382 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 383 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 384 */             .addComponent(this.jTextField3, -2, -1, -2)
/* 385 */             .addComponent(this.jComboBox1, -2, -1, -2))
/* 386 */           .addGap(8, 8, 8)
/* 387 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 388 */             .addComponent(this.jLabel38)
/* 389 */             .addComponent(this.jLabel39)))
/* 390 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 391 */           .addComponent(this.jTextField2, -2, -1, -2)
/* 392 */           .addGap(8, 8, 8)
/* 393 */           .addComponent(this.jLabel32))
/* 394 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 395 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 396 */           .addGap(8, 8, 8)
/* 397 */           .addComponent(this.jLabel14)));
/*     */ 
/*     */     
/* 400 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 401 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 402 */     this.jLabel54.setHorizontalAlignment(0);
/* 403 */     this.jLabel54.setText("Eliminar Usuarios");
/*     */     
/* 405 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 406 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 408 */     this.jTable3.setAutoCreateRowSorter(true);
/* 409 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 410 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "Teléfono 1", "Correo", "Abogado", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 418 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 421 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false };
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 426 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 430 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 433 */     this.jTable3.setShowVerticalLines(false);
/* 434 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 436 */             UsuariosEliminar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 439 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 441 */     this.jButton5.setMnemonic('D');
/* 442 */     this.jButton5.setText("Desactivar");
/* 443 */     this.jButton5.setToolTipText("Desactivar Usuario (Alt+D)");
/* 444 */     this.jButton5.setEnabled(false);
/* 445 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 447 */             UsuariosEliminar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 451 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 452 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 453 */     this.jLabel52.setHorizontalAlignment(4);
/* 454 */     this.jLabel52.setText("Si deseas desactivar el usuario pulsa el siguiente botón");
/*     */     
/* 456 */     this.jLabel53.setFont(new Font("Tahoma", 2, 11));
/* 457 */     this.jLabel53.setForeground(new Color(28, 126, 125));
/* 458 */     this.jLabel53.setHorizontalAlignment(4);
/* 459 */     this.jLabel53.setText("Activar Empleados");
/*     */     
/* 461 */     this.jButton1.setMnemonic('A');
/* 462 */     this.jButton1.setText("Activar");
/* 463 */     this.jButton1.setToolTipText("Activar Usuario (Alt+A)");
/* 464 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 466 */             UsuariosEliminar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 470 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 471 */     this.jLabel48.setForeground(Color.red);
/* 472 */     this.jLabel48.setHorizontalAlignment(0);
/* 473 */     this.jLabel48.setText("t");
/* 474 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 476 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 477 */     this.jPanel5.setLayout(jPanel5Layout);
/* 478 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 479 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 480 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 481 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 482 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 483 */               .addContainerGap()
/* 484 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 485 */               .addGap(68, 68, 68)
/* 486 */               .addComponent(this.jLabel53, -2, 99, -2)
/* 487 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 488 */               .addComponent(this.jButton1, -2, 113, -2)
/* 489 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 490 */               .addComponent(this.jLabel52, -2, 383, -2)
/* 491 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 492 */               .addComponent(this.jButton5, -2, 100, -2))
/* 493 */             .addComponent(this.jScrollPane3))
/* 494 */           .addContainerGap()));
/*     */     
/* 496 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 497 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 498 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 499 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 500 */             .addComponent(this.jLabel52)
/* 501 */             .addComponent(this.jButton5)
/* 502 */             .addComponent(this.jLabel48)
/* 503 */             .addComponent(this.jLabel53)
/* 504 */             .addComponent(this.jButton1))
/* 505 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 506 */           .addComponent(this.jScrollPane3, -1, 181, 32767)));
/*     */ 
/*     */     
/* 509 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 510 */     this.jPanel1.setLayout(jPanel1Layout);
/* 511 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 513 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 514 */           .addContainerGap()
/* 515 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 516 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 517 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 518 */             .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 519 */           .addContainerGap()));
/*     */     
/* 521 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 523 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 524 */           .addComponent(this.jLabel54)
/* 525 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 526 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 527 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 528 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*     */ 
/*     */     
/* 531 */     GroupLayout layout = new GroupLayout(this);
/* 532 */     setLayout(layout);
/* 533 */     layout.setHorizontalGroup(layout
/* 534 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 535 */         .addGap(0, 1245, 32767)
/* 536 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 537 */           .addGroup(layout.createSequentialGroup()
/* 538 */             .addGap(0, 16, 32767)
/* 539 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 540 */             .addGap(0, 17, 32767))));
/*     */     
/* 542 */     layout.setVerticalGroup(layout
/* 543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 544 */         .addGap(0, 358, 32767)
/* 545 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 546 */           .addGroup(layout.createSequentialGroup()
/* 547 */             .addContainerGap()
/* 548 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 549 */             .addContainerGap())));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 554 */     int reg = this.jTable3.getSelectedRow();
/* 555 */     String nombre = String.valueOf(this.jTable3.getValueAt(reg, 0));
/* 556 */     String priv = String.valueOf(this.jTable3.getValueAt(reg, 6));
/* 557 */     if (priv.equals("")) {
/* 558 */       JOptionPane.showMessageDialog(this.padre, "No puedes desactivar este usuario porque ya se encuentra en ése estado.\nSeleccionar otro usuario", "Usuario Desactivado", 0, this.ADVER);
/*     */     } else {
/* 560 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas desactivar el usuario?", "Desactivar Usuario", 0, 3, this.PREG);
/* 561 */       if (res == 0) {
/* 562 */         this.con.insertar("update usuarios set cajaChica = 0, cajaChicaLetra = '', priv = '', contrasena='' where nombre_usu = '" + nombre + "'");
/* 563 */         consultar();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 568 */     int reg = this.jTable3.getSelectedRow();
/* 569 */     String valor = String.valueOf(this.jTable3.getValueAt(reg, 5));
/* 570 */     if (!valor.equals("")) {
/* 571 */       JOptionPane.showMessageDialog(this.padre, "No puedes activar este usuario porque ya se encuentra totalmente activado", "Usuario Activado", 0, this.ADVER);
/*     */     } else {
/* 573 */       String nombre = String.valueOf(this.jTable3.getValueAt(reg, 0));
/* 574 */       this.jPasswordField1.setText(nombre);
/* 575 */       this.jPasswordField2.setText(nombre);
/* 576 */       this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 577 */       this.jComboBox2.setSelectedIndex(0);
/* 578 */       this.jTextField5.setText(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4).toString());
/* 579 */       this.jDialog1.setVisible(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 584 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 588 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 592 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 596 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 600 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 604 */     this.jButton1.setEnabled(true);
/* 605 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 609 */     String priv = String.valueOf(this.jComboBox2.getSelectedItem());
/* 610 */     if (priv.equals("Gerente de Operaciones") || priv.equals("Jefe de Liquidaciones") || priv.equals("Liquidaciones") || priv.equals("Super Usuario")) {
/* 611 */       this.jLabel22.setEnabled(true);
/* 612 */       this.jFormattedTextField1.setEnabled(true);
/*     */     } else {
/* 614 */       this.jLabel22.setEnabled(false);
/* 615 */       this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 616 */       this.jFormattedTextField1.setEnabled(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 621 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */   
/*     */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 625 */     this.error.pasarModal(true);
/* 626 */     boolean correo = validarEmail(this.jTextField5.getText());
/* 627 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 628 */       this.error.cargarError(this.jComboBox2, "050");
/* 629 */     } else if (!correo) {
/* 630 */       this.jTextField5.setBackground(Color.RED);
/* 631 */       JOptionPane.showMessageDialog(this, "<html>La siguiente dirección de correo parece no válida, verifica tu información: <p>" + this.jTextField5.getText() + "<p></html>", "Dirección de correo no válida", 0, this.ERROR);
/* 632 */     } else if (this.jFormattedTextField1.isEnabled() && this.jFormattedTextField1.getText().equals("$0.00")) {
/* 633 */       this.error.cargarError(this.jFormattedTextField1, "050");
/*     */     } else {
/*     */       
/* 636 */       cambiarContra();
/*     */     } 
/*     */   }
/*     */   public boolean validarEmail(String correo) {
/* 640 */     Pattern pat = null;
/* 641 */     Matcher mat = null;
/* 642 */     pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
/* 643 */     mat = pat.matcher(correo);
/* 644 */     if (mat.find()) {
/* 645 */       return true;
/*     */     }
/* 647 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void usuarios(String usu) {
/* 652 */     this.USUARIO = usu;
/* 653 */     this.panel.setViewportView(this);
/* 654 */     this.jButton5.setEnabled(false);
/* 655 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   public void colorear() {
/* 660 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 662 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jTextField5, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 666 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jTextField5, evt);
/*     */           }
/*     */         });
/*     */     
/* 670 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 672 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 676 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 679 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 681 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jTextField2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 685 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 688 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 690 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jTextField3, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 694 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 697 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 699 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jTextField4, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 703 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jTextField4, evt);
/*     */           }
/*     */         });
/* 706 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 708 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jComboBox1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 712 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 715 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 717 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jPasswordField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 721 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jPasswordField1, evt);
/*     */           }
/*     */         });
/* 724 */     this.jPasswordField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 726 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jPasswordField2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 730 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jPasswordField2, evt);
/*     */           }
/*     */         });
/* 733 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 735 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jFormattedTextField1, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 739 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jFormattedTextField1, evt);
/*     */           }
/*     */         });
/* 742 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 744 */             UsuariosEliminar.this.jTextGanado(UsuariosEliminar.this.jComboBox2, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 748 */             UsuariosEliminar.this.jTextPerdido(UsuariosEliminar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 754 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 758 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 762 */     this.jButton1.setEnabled(false);
/* 763 */     this.jButton5.setEnabled(false);
/* 764 */     String priv = "";
/* 765 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 766 */       priv = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 768 */     this.encontrado = this.con.consultar("count(nombre_usu)", "usuarios,empleados", "where nombre_usu != 'usuarioAdmin1' and clave_emp=num_emp and nombre_usu like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and priv like '%" + priv + "%'");
/* 769 */     int totreg = Integer.parseInt(this.con.Campo);
/* 770 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 771 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 772 */           .buscarReg(7, totreg, "nombre_usu,nombre,ap_pat,ap_mat,usuarios.correo,cajaChicaLetra,priv", "usuarios,empleados", "where nombre_usu !='usuarioAdmin1' and clave_emp=num_emp and nombre_usu like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and priv like '%" + priv + "%' order by nombre_usu"), (Object[])new String[] { "Nombre Usuario", "Nombre", "Apellido Paterno", "Apellido Materno", "Correo", "Lim Caja Chica", "Privilegios" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 777 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 782 */             return this.canEdit[columnIndex];
/*     */           }
/* 784 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 789 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/* 792 */     this.con.consultar("count(nombre_usu)", "usuarios", "");
/* 793 */     String[] arre = this.con.regresaCol("nombre_usu", "usuarios", "", Integer.parseInt(this.con.Campo));
/* 794 */     this.celda.pasarInd(arre);
/* 795 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 796 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 797 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 798 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 799 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 800 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 801 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*     */     
/* 803 */     this.jTable3.setSelectionMode(0);
/* 804 */     this.jTable3.setAutoCreateRowSorter(true);
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer {
/* 809 */     int otro = -1;
/* 810 */     String[] indices = new String[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 813 */       setEnabled((table == null || table.isEnabled()));
/* 814 */       String valor = String.valueOf(value);
/* 815 */       String comp = String.valueOf(table.getValueAt(row, 0));
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
/* 827 */       if (row % 2 == 0) {
/* 828 */         setBackground(new Color(194, 213, 151));
/* 829 */         setForeground(Color.black);
/*     */       } else {
/* 831 */         setBackground((Color)null);
/* 832 */         setForeground(Color.black);
/*     */       } 
/* 834 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 835 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(String[] ind) {
/* 839 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(String reg) {
/* 843 */       for (int i = 0; i < this.indices.length; i++) {
/* 844 */         if (this.indices[i].equals(reg)) {
/* 845 */           return true;
/*     */         }
/*     */       } 
/* 848 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void cambiarContra() {
/* 853 */     String usuario = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 854 */     this.con.consultar("num_emp", "usuarios", "where nombre_usu = '" + usuario + "'");
/* 855 */     String clave = this.con.Campo;
/* 856 */     String[] campos = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados", "where CLAVE_emp = " + clave, 3);
/* 857 */     this.error.pasarModal(true);
/* 858 */     String contra = this.jPasswordField2.getText().toUpperCase();
/* 859 */     int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas activar el usuario?", "Activar Usuario", 0, 3, this.PREG);
/* 860 */     if (res == 0) {
/* 861 */       contra = DigestUtils.md5Hex(usuario);
/* 862 */       String depa = String.valueOf(this.jComboBox2.getSelectedItem());
/* 863 */       this.con.insertar("update usuarios set contrasena='" + contra + "', priv='" + depa.toUpperCase() + "',cajaChica =" + String.valueOf(this.jFormattedTextField1.getValue()) + ",cajaChicaLetra='" + this.jFormattedTextField1.getText() + "', correo='" + this.jTextField5.getText().toLowerCase() + "' where nombre_usu='" + usuario + "'");
/* 864 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto)values(now(),'" + usuario + "','Cambió su contraseña' )");
/* 865 */       this.jPasswordField2.setText("");
/* 866 */       this.jPasswordField1.setText("");
/* 867 */       this.jDialog1.setVisible(false);
/* 868 */       this.con.consultar("priv", "usuarios", "where nombre_usu = '" + usuario + "'");
/* 869 */       consultar();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/UsuariosEliminar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */