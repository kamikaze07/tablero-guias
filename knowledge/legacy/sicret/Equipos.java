/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class Equipos extends JPanel {
/*  20 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  21 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  22 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  23 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  24 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  25 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  29 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  30 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  31 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  32 */   Date fechaActual = new Date();
/*  33 */   String USUARIO = "";
/*  34 */   Validaciones val = new Validaciones();
/*  35 */   Consultas con = new Consultas();
/*  36 */   Errores error = new Errores(false);
/*     */   String id;
/*     */   String[] inf;
/*     */   JTabbedPane fichas;
/*     */   int INDICE;
/*     */   JTable jTable3;
/*     */   JFrame padre;
/*  43 */   cargarDatos datos = new cargarDatos("Equipos");
/*     */   Color fondo;
/*     */   boolean encontrado = false;
/*  46 */   CeldaRender celda = new CeldaRender();
/*  47 */   JComboBox combo = new JComboBox(); MensajePop mensajeTry; private JButton jButton10; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35;
/*     */   
/*     */   public Equipos(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, MensajePop mensajeTry) {
/*  50 */     this.mensajeTry = mensajeTry;
/*  51 */     this.USUARIO = usua;
/*  52 */     this.padre = padre;
/*  53 */     this.id = num;
/*  54 */     this.fichas = fichas;
/*  55 */     initComponents();
/*  56 */     this.combo.setBackground(Color.white);
/*  57 */     panelito.setViewportView(this);
/*  58 */     this.panel = panelito;
/*  59 */     colorear();
/*  60 */     consultar();
/*  61 */     llenarCombo();
/*     */   }
/*     */   private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel48; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel6; private JPanel jPanel7; private JScrollPane jScrollPane1; private JSeparator jSeparator1; private JTable jTable1; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JToggleButton jToggleButton1;
/*     */   
/*     */   private void initComponents() {
/*  66 */     this.jPanel6 = new JPanel();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jPanel22 = new JPanel();
/*  69 */     this.jScrollPane1 = new JScrollPane();
/*  70 */     this.jTable1 = new JTable();
/*  71 */     this.jLabel33 = new JLabel();
/*  72 */     this.jTextField2 = new JTextField();
/*  73 */     this.jSeparator1 = new JSeparator();
/*  74 */     this.jButton8 = new JButton();
/*  75 */     this.jLabel48 = new JLabel();
/*  76 */     this.jButton9 = new JButton();
/*  77 */     this.jButton10 = new JButton();
/*  78 */     this.jToggleButton1 = new JToggleButton();
/*  79 */     this.jPanel7 = new JPanel();
/*  80 */     this.jLabel2 = new JLabel();
/*  81 */     this.jPanel23 = new JPanel();
/*  82 */     this.jLabel34 = new JLabel();
/*  83 */     this.jComboBox1 = new JComboBox();
/*  84 */     this.jLabel32 = new JLabel();
/*  85 */     this.jTextField1 = new JTextField();
/*  86 */     this.jButton6 = new JButton();
/*  87 */     this.jLabel35 = new JLabel();
/*  88 */     this.jTextField3 = new JTextField();
/*  89 */     this.jLabel37 = new JLabel();
/*  90 */     this.jComboBox2 = new JComboBox();
/*  91 */     this.jLabel36 = new JLabel();
/*  92 */     this.jTextField4 = new JTextField();
/*  93 */     this.jButton7 = new JButton();
/*     */     
/*  95 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*  96 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  98 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/*  99 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/* 100 */     this.jLabel1.setHorizontalAlignment(0);
/* 101 */     this.jLabel1.setText("Organizar Equipos");
/*     */     
/* 103 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 104 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "Organizar Equipos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 106 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 107 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre de Equipo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 115 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 120 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 123 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 125 */             Equipos.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/* 128 */     this.jScrollPane1.setViewportView(this.jTable1);
/*     */     
/* 130 */     this.jLabel33.setFont(new Font("Tahoma", 2, 11));
/* 131 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/* 132 */     this.jLabel33.setHorizontalAlignment(4);
/* 133 */     this.jLabel33.setText("Buscar");
/*     */     
/* 135 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 137 */             Equipos.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 141 */     this.jButton8.setMnemonic('E');
/* 142 */     this.jButton8.setText("Eliminar");
/* 143 */     this.jButton8.setToolTipText("Eliminar (Alt+E)");
/* 144 */     this.jButton8.setEnabled(false);
/* 145 */     this.jButton8.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 147 */             Equipos.this.jButton8ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 151 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 152 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 153 */     this.jLabel48.setHorizontalAlignment(2);
/* 154 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 156 */     this.jButton9.setMnemonic('Q');
/* 157 */     this.jButton9.setText("Quitar Asignación");
/* 158 */     this.jButton9.setToolTipText("Quitar Asignación(Alt+E)");
/* 159 */     this.jButton9.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 161 */             Equipos.this.jButton9ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 165 */     this.jButton10.setMnemonic('A');
/* 166 */     this.jButton10.setText("Asignar");
/* 167 */     this.jButton10.setToolTipText("Asignar (Alt+A)");
/* 168 */     this.jButton10.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 170 */             Equipos.this.jButton10ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 174 */     this.jToggleButton1.setText("Modificar");
/* 175 */     this.jToggleButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 177 */             Equipos.this.jToggleButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 181 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 182 */     this.jPanel22.setLayout(jPanel22Layout);
/* 183 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 185 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 186 */           .addContainerGap()
/* 187 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 188 */             .addGroup(jPanel22Layout.createSequentialGroup()
/* 189 */               .addComponent(this.jLabel33, -2, 51, -2)
/* 190 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 191 */               .addComponent(this.jTextField2, -2, 215, -2))
/* 192 */             .addGroup(jPanel22Layout.createSequentialGroup()
/* 193 */               .addComponent(this.jLabel48, -2, 206, -2)
/* 194 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, 32767)
/* 195 */               .addComponent(this.jButton9)
/* 196 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 197 */               .addComponent(this.jToggleButton1, -2, 94, -2)
/* 198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 199 */               .addComponent(this.jButton10, -2, 89, -2)
/* 200 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 201 */               .addComponent(this.jButton8, -2, 85, -2))
/* 202 */             .addComponent(this.jSeparator1, -1, 643, 32767)
/* 203 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 643, 32767))
/* 204 */           .addContainerGap()));
/*     */     
/* 206 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
/* 209 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 210 */             .addComponent(this.jLabel33)
/* 211 */             .addComponent(this.jTextField2, -2, -1, -2))
/* 212 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 213 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 214 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 215 */           .addComponent(this.jScrollPane1, -1, 258, 32767)
/* 216 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 217 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 218 */             .addComponent(this.jLabel48)
/* 219 */             .addComponent(this.jButton8)
/* 220 */             .addComponent(this.jButton10)
/* 221 */             .addComponent(this.jButton9)
/* 222 */             .addComponent(this.jToggleButton1))
/* 223 */           .addContainerGap()));
/*     */ 
/*     */     
/* 226 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 227 */     this.jPanel6.setLayout(jPanel6Layout);
/* 228 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 230 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 231 */           .addContainerGap()
/* 232 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 233 */             .addComponent(this.jPanel22, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 234 */             .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 675, 32767))
/* 235 */           .addContainerGap()));
/*     */     
/* 237 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 239 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 240 */           .addComponent(this.jLabel1)
/* 241 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 242 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 243 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 246 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/* 247 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 249 */     this.jLabel2.setFont(new Font("Tahoma", 1, 18));
/* 250 */     this.jLabel2.setForeground(new Color(10, 126, 68));
/* 251 */     this.jLabel2.setHorizontalAlignment(0);
/* 252 */     this.jLabel2.setText("Agregar Equipos");
/*     */     
/* 254 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/* 255 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, " Agregar Equipos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 257 */     this.jLabel34.setFont(new Font("Tahoma", 3, 11));
/* 258 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/* 259 */     this.jLabel34.setHorizontalAlignment(4);
/* 260 */     this.jLabel34.setText("Cliente");
/*     */     
/* 262 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 263 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 264 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
/* 265 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 267 */             Equipos.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 271 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/* 272 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 273 */     this.jLabel32.setHorizontalAlignment(4);
/* 274 */     this.jLabel32.setText("Equipo");
/*     */     
/* 276 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 278 */             Equipos.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 282 */     this.jButton6.setMnemonic('A');
/* 283 */     this.jButton6.setText("Agregar");
/* 284 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/* 285 */     this.jButton6.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 287 */             Equipos.this.jButton6ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 291 */     this.jLabel35.setFont(new Font("Tahoma", 2, 11));
/* 292 */     this.jLabel35.setForeground(new Color(15, 87, 51));
/* 293 */     this.jLabel35.setHorizontalAlignment(4);
/* 294 */     this.jLabel35.setText("Ubicación");
/*     */     
/* 296 */     this.jTextField3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 298 */             Equipos.this.jTextField3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 302 */     this.jLabel37.setFont(new Font("Tahoma", 3, 11));
/* 303 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/* 304 */     this.jLabel37.setHorizontalAlignment(4);
/* 305 */     this.jLabel37.setText("Estado");
/*     */     
/* 307 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 308 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS" }));
/* 309 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 311 */             Equipos.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 315 */     this.jLabel36.setFont(new Font("Tahoma", 3, 11));
/* 316 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/* 317 */     this.jLabel36.setHorizontalAlignment(4);
/* 318 */     this.jLabel36.setText("Municipio");
/*     */     
/* 320 */     this.jTextField4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 322 */             Equipos.this.jTextField4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 326 */     this.jButton7.setMnemonic('A');
/* 327 */     this.jButton7.setText("Limpiar");
/* 328 */     this.jButton7.setToolTipText("Agregar (Alt+A)");
/* 329 */     this.jButton7.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 331 */             Equipos.this.jButton7ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 335 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 336 */     this.jPanel23.setLayout(jPanel23Layout);
/* 337 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 338 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 339 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 340 */           .addContainerGap()
/* 341 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 342 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 343 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 344 */                 .addComponent(this.jLabel36, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 345 */                 .addComponent(this.jLabel37, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 346 */                 .addComponent(this.jLabel32, GroupLayout.Alignment.TRAILING, -2, 64, -2)
/* 347 */                 .addComponent(this.jLabel35, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 348 */                 .addComponent(this.jLabel34, GroupLayout.Alignment.TRAILING, -2, 77, -2))
/* 349 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 350 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 351 */                 .addComponent(this.jComboBox2, GroupLayout.Alignment.TRAILING, 0, 278, 32767)
/* 352 */                 .addComponent(this.jTextField1, GroupLayout.Alignment.TRAILING, -1, 278, 32767)
/* 353 */                 .addComponent(this.jTextField4, -1, 278, 32767)
/* 354 */                 .addComponent(this.jTextField3, GroupLayout.Alignment.TRAILING, -1, 278, 32767)
/* 355 */                 .addComponent(this.jComboBox1, 0, 278, 32767)))
/* 356 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 357 */               .addComponent(this.jButton7, -2, 77, -2)
/* 358 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 359 */               .addComponent(this.jButton6)))
/* 360 */           .addContainerGap()));
/*     */     
/* 362 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 364 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 365 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 366 */             .addComponent(this.jLabel34)
/* 367 */             .addComponent(this.jComboBox1, -2, -1, -2))
/* 368 */           .addGap(7, 7, 7)
/* 369 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 370 */             .addComponent(this.jLabel35)
/* 371 */             .addComponent(this.jTextField3, -2, -1, -2))
/* 372 */           .addGap(5, 5, 5)
/* 373 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 374 */             .addComponent(this.jLabel36)
/* 375 */             .addComponent(this.jTextField4, -2, -1, -2))
/* 376 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 377 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 378 */             .addComponent(this.jLabel37)
/* 379 */             .addComponent(this.jComboBox2, -2, -1, -2))
/* 380 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 381 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 382 */             .addComponent(this.jLabel32)
/* 383 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 384 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 385 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 386 */             .addComponent(this.jButton6)
/* 387 */             .addComponent(this.jButton7))
/* 388 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 391 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 392 */     this.jPanel7.setLayout(jPanel7Layout);
/* 393 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 395 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 396 */           .addContainerGap()
/* 397 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 398 */             .addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, 391, 32767)
/* 399 */             .addComponent(this.jPanel23, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 400 */           .addContainerGap()));
/*     */     
/* 402 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 404 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 405 */           .addContainerGap()
/* 406 */           .addComponent(this.jLabel2)
/* 407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 408 */           .addComponent(this.jPanel23, -2, -1, -2)
/* 409 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 412 */     GroupLayout layout = new GroupLayout(this);
/* 413 */     setLayout(layout);
/* 414 */     layout.setHorizontalGroup(layout
/* 415 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 416 */         .addGroup(layout.createSequentialGroup()
/* 417 */           .addContainerGap()
/* 418 */           .addComponent(this.jPanel7, -2, -1, -2)
/* 419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 420 */           .addComponent(this.jPanel6, -1, -1, 32767)
/* 421 */           .addContainerGap()));
/*     */     
/* 423 */     layout.setVerticalGroup(layout
/* 424 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 425 */         .addGroup(layout.createSequentialGroup()
/* 426 */           .addContainerGap()
/* 427 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 428 */             .addComponent(this.jPanel6, -2, -1, -2)
/* 429 */             .addComponent(this.jPanel7, -2, -1, -2))
/* 430 */           .addContainerGap(-1, 32767)));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 435 */     guardarEquipos();
/*     */   }
/*     */   
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 439 */     guardarEquipos();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton8ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 447 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 455 */     int indice = this.jTable1.getSelectedRow();
/* 456 */     if (indice < 0) {
/* 457 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un equipo para desabilitar el cliente", "Selecciona un Equipo", 0, this.ERROR);
/*     */     } else {
/*     */       
/* 460 */       String valor = String.valueOf(this.jTable1.getValueAt(indice, 1));
/* 461 */       if (valor.equals("")) {
/* 462 */         JOptionPane.showMessageDialog(this.padre, "El equipo que seleccionaste ya está desabilitado para tráfico.\nVerifica tu información", "Equipo Desabilitado", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 465 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas quitar la asignación del cliente?", "Quitar Equipo", 0, 1, this.PREG);
/* 466 */         if (res == 0) {
/* 467 */           String num = String.valueOf(this.jTable1.getValueAt(indice, 0));
/* 468 */           this.con.inserSinMsj("update equipos set clave_gene = 0 where num_equipo = " + num);
/* 469 */           consultar();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 476 */     int indice = this.jTable1.getSelectedRow();
/* 477 */     if (indice < 0) {
/* 478 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un equipo para asignar el cliente", "Selecciona un Equipo", 0, this.ERROR);
/*     */     } else {
/*     */       
/* 481 */       String valor = String.valueOf(this.jTable1.getValueAt(indice, 1));
/* 482 */       if (!valor.equals("")) {
/* 483 */         JOptionPane.showMessageDialog(this.padre, "El equipo que seleccionaste ya está asignado a un cliente.\nVerifica tu información", "Equipo Asignado", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 486 */         int res = JOptionPane.showConfirmDialog(this.padre, this.combo, "¿Estás seguro que deseas asignarlo al cliente?", 0, 1, this.PREG);
/* 487 */         if (res == 0) {
/* 488 */           if (this.combo.getSelectedIndex() == 0) {
/* 489 */             JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar el cliente para poder asignarlo a un equipo", "Selecciona el Cliente", 0, this.ADVER);
/*     */           } else {
/*     */             
/* 492 */             this.con.consultar("clave_gene", "emp_generadora", "where empresa = '" + String.valueOf(this.combo.getSelectedItem()) + "'");
/* 493 */             String clave = this.con.Campo;
/* 494 */             String num = String.valueOf(this.jTable1.getValueAt(indice, 0));
/* 495 */             this.con.inserSinMsj("update equipos set clave_gene = " + clave + " where num_equipo = " + num);
/* 496 */             consultar();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField3ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 516 */     limpiar();
/*     */   }
/*     */   
/*     */   private void jToggleButton1ActionPerformed(ActionEvent evt) {
/* 520 */     if (!this.jToggleButton1.isSelected()) {
/* 521 */       this.jComboBox1.setEnabled(true);
/* 522 */       this.jComboBox1.setSelectedIndex(0);
/* 523 */       this.jComboBox2.setSelectedIndex(0);
/* 524 */       this.jTextField3.setText("");
/* 525 */       this.jTextField4.setText("");
/* 526 */       this.jTextField1.setText("");
/* 527 */       this.jTextField1.setEnabled(true);
/* 528 */       this.jTable1.setEnabled(true);
/* 529 */       this.jButton6.setText("Guardar");
/* 530 */       this.jButton6.setToolTipText("Guardar (Alt+G)");
/* 531 */       this.jButton6.setMnemonic('G');
/* 532 */       this.jButton7.setEnabled(true);
/*     */     } else {
/*     */       
/* 535 */       int indice = this.jTable1.getSelectedRow();
/* 536 */       if (indice < 0) {
/* 537 */         this.jToggleButton1.setSelected(false);
/* 538 */         JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un equipo para asignar el cliente", "Selecciona un Equipo", 0, this.ERROR);
/*     */       } else {
/*     */         
/* 541 */         this.jButton6.setText("Modificar");
/* 542 */         this.jButton6.setToolTipText("Modificar (Alt+M)");
/* 543 */         this.jButton6.setMnemonic('M');
/* 544 */         this.jTable1.setEnabled(false);
/* 545 */         this.jButton9.setEnabled(false);
/* 546 */         this.jButton10.setEnabled(false);
/* 547 */         this.jButton8.setEnabled(false);
/* 548 */         this.jTextField1.setEnabled(false);
/* 549 */         this.jButton7.setEnabled(false);
/* 550 */         this.jComboBox1.setEnabled(false);
/* 551 */         this.jComboBox1.setSelectedItem(String.valueOf(this.jTable1.getValueAt(indice, 1)));
/* 552 */         this.jTextField3.setText(String.valueOf(this.jTable1.getValueAt(indice, 3)));
/* 553 */         this.jTextField4.setText(String.valueOf(this.jTable1.getValueAt(indice, 4)));
/* 554 */         this.jComboBox2.setSelectedItem(String.valueOf(this.jTable1.getValueAt(indice, 5)));
/* 555 */         this.jTextField1.setText(String.valueOf(this.jTable1.getValueAt(indice, 2)));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt) {
/* 561 */     this.jButton10.setEnabled(true);
/* 562 */     this.jButton9.setEnabled(true);
/*     */   }
/*     */   public void equipos(String usu) {
/* 565 */     this.USUARIO = usu;
/* 566 */     this.panel.setViewportView(this);
/* 567 */     consultar();
/* 568 */     llenarCombo();
/*     */   }
/*     */   public void colorear() {
/* 571 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 573 */             Equipos.this.jTextGanado(Equipos.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 576 */             Equipos.this.jTextPerdido(Equipos.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 579 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 581 */             Equipos.this.jTextGanado(Equipos.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 584 */             Equipos.this.jTextPerdido(Equipos.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 587 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 589 */             Equipos.this.jTextGanado(Equipos.this.jTextField3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 592 */             Equipos.this.jTextPerdido(Equipos.this.jTextField3, evt);
/*     */           }
/*     */         });
/* 595 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 597 */             Equipos.this.jTextGanado(Equipos.this.jTextField4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 600 */             Equipos.this.jTextPerdido(Equipos.this.jTextField4, evt);
/*     */           }
/*     */         });
/* 603 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 605 */             Equipos.this.jTextGanado(Equipos.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 608 */             Equipos.this.jTextPerdido(Equipos.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 611 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 613 */             Equipos.this.jTextGanado(Equipos.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 616 */             Equipos.this.jTextPerdido(Equipos.this.jComboBox2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 621 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 624 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void limpiar() {
/* 627 */     this.jComboBox1.setSelectedIndex(0);
/* 628 */     this.jTextField3.setText("");
/* 629 */     this.jTextField4.setText("");
/* 630 */     this.jComboBox2.setSelectedIndex(0);
/* 631 */     this.jTextField1.setText("");
/*     */   }
/*     */   public void consultar() {
/* 634 */     String equipo = this.jTextField2.getText();
/* 635 */     this.encontrado = this.con.consultar("count(equipos.num_equipo)", "equipos,emp_generadora,estados", "where equipos.id_edo = estados.id_edo and emp_generadora.clave_gene = equipos.clave_gene and equipo like '%" + equipo + "%' and num_equipo<>0");
/* 636 */     int totreg = Integer.parseInt(this.con.Campo);
/* 637 */     this.encontrado = this.con.consultar("count(num_equipo)", "equipos", "where num_equipo<>0");
/* 638 */     String tot = this.con.Campo;
/* 639 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 640 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 641 */           .buscarReg(6, totreg, "equipos.num_equipo,empresa,equipo,ubicacion,municipio,estado", "equipos,emp_generadora, estados", "where equipos.id_edo = estados.id_edo and emp_generadora.clave_gene = equipos.clave_gene and equipo like '%" + equipo + "%' and num_equipo<>0 order by empresa"), (Object[])new String[] { "Clave", "Cliente", "Equipo", "Ubicación", "Municipio", "Estado" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 646 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 650 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 653 */     this.jTable1.setShowVerticalLines(false);
/* 654 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 655 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 656 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
/* 657 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 658 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 659 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 660 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
/* 661 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
/* 662 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(110);
/* 663 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
/* 664 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(110);
/*     */     
/* 666 */     this.jTable1.setSelectionMode(0);
/* 667 */     this.jTable1.setAutoCreateRowSorter(true);
/* 668 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 669 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 670 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 671 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 672 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 673 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 674 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*     */   }
/*     */   public void guardarEquipos() {
/* 677 */     if (this.jButton6.getText().equals("Modificar")) {
/*     */ 
/*     */ 
/*     */       
/* 681 */       if (this.jTextField4.getText().equals("")) {
/* 682 */         this.error.cargarError(this.jTextField4, "050");
/*     */       }
/* 684 */       else if (this.jComboBox2.getSelectedIndex() == 0) {
/* 685 */         this.error.cargarError(this.jComboBox2, "050");
/*     */       
/*     */       }
/* 688 */       else if (!this.val.validarApostrofe(this.jTextField3, this.jTextField3.getText(), "020") && 
/* 689 */         !this.val.validarApostrofe(this.jTextField4, this.jTextField4.getText(), "020")) {
/* 690 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas modificar la ubicación del equipo que seleccionaste?", "Modificar Equipo", 0, 3, this.PREG);
/* 691 */         if (res == 0) {
/* 692 */           this.con.inserSinMsj("update equipos set ubicacion = '" + this.jTextField3.getText().toUpperCase() + "', municipio = '" + this.jTextField4.getText().toUpperCase() + "', id_edo = " + this.jComboBox2.getSelectedIndex() + " where equipo = '" + this.jTextField1.getText() + "'");
/* 693 */           consultar();
/* 694 */           this.jToggleButton1.setSelected(false);
/* 695 */           limpiar();
/* 696 */           this.jComboBox1.setEnabled(true);
/* 697 */           this.jComboBox1.setSelectedIndex(0);
/* 698 */           this.jComboBox2.setSelectedIndex(0);
/* 699 */           this.jTextField3.setText("");
/* 700 */           this.jTextField4.setText("");
/* 701 */           this.jTextField1.setText("");
/* 702 */           this.jTextField1.setEnabled(true);
/* 703 */           this.jTable1.setEnabled(true);
/* 704 */           this.jButton6.setText("Guardar");
/* 705 */           this.jButton6.setToolTipText("Guardar (Alt+G)");
/* 706 */           this.jButton6.setMnemonic('G');
/* 707 */           this.jButton7.setEnabled(true);
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 714 */       String equipo = this.jTextField1.getText().toUpperCase();
/* 715 */       if (this.jComboBox1.getSelectedIndex() == 0) {
/* 716 */         this.error.cargarError(this.jComboBox1, "050");
/*     */       }
/* 718 */       else if (this.jTextField3.getText().equals("")) {
/* 719 */         this.error.cargarError(this.jTextField3, "050");
/*     */       }
/* 721 */       else if (this.jTextField4.getText().equals("")) {
/* 722 */         this.error.cargarError(this.jTextField4, "050");
/*     */       }
/* 724 */       else if (this.jComboBox2.getSelectedIndex() == 0) {
/* 725 */         this.error.cargarError(this.jComboBox2, "050");
/*     */       }
/* 727 */       else if (equipo.equals("")) {
/* 728 */         this.error.cargarError(this.jTextField1, "050");
/*     */       }
/* 730 */       else if (!this.val.validarApostrofe(this.jTextField3, this.jTextField3.getText(), "020") && 
/* 731 */         !this.val.validarApostrofe(this.jTextField4, this.jTextField4.getText(), "020") && 
/* 732 */         !this.val.validarApostrofe(this.jTextField1, equipo, "020")) {
/* 733 */         this.encontrado = this.con.consultar("equipo", "equipos", "where equipo = '" + this.jTextField1.getText() + "'");
/* 734 */         if (this.encontrado) {
/* 735 */           JOptionPane.showMessageDialog(this.padre, "El equipo que deseas insertar ya se encuentra registrado en la base de datos", "Equipo ya Existe", 0, this.ERROR);
/*     */         } else {
/*     */           
/* 738 */           String[] campos = { "Cliente", "Ubicación", "Municipio", "Estado", "Equipo" };
/* 739 */           String[] info = { String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem()), this.jTextField3.getText().toUpperCase(), this.jTextField4.getText().toUpperCase(), String.valueOf(this.jComboBox2.getSelectedItem()) + String.valueOf(this.jComboBox2.getSelectedItem()), this.jTextField1.getText().toUpperCase() };
/* 740 */           int res = this.error.cargarDatos(campos, info);
/* 741 */           if (res == 0) {
/* 742 */             int edo = this.jComboBox2.getSelectedIndex();
/* 743 */             this.con.consultar("clave_gene", "emp_generadora", "where empresa = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 744 */             this.con.inserSinMsj("insert into equipos(equipo,clave_gene,ubicacion, municipio, id_edo)values('" + equipo.toUpperCase() + "'," + this.con.Campo + ",'" + this.jTextField3.getText().toUpperCase() + "','" + this.jTextField4.getText().toUpperCase() + "'," + edo + " )");
/* 745 */             this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo Equipo.','Nombre: " + this.jTextField1.getText() + "')");
/* 746 */             this.mensajeTry.guardarConf("Se ha agregado un nuevo equipo, " + equipo.toUpperCase() + ", USUARIO: " + this.USUARIO, "Nuevo Equipo", "INFO", "Perforacion");
/* 747 */             consultar();
/* 748 */             limpiar();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer {
/* 757 */     int otro = -1;
/* 758 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 760 */       setEnabled((table == null || table.isEnabled()));
/* 761 */       if (row % 2 == 0 && (column == 3 || column == 4)) {
/* 762 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 764 */       else if (row % 2 == 0 && column == 5) {
/* 765 */         setBackground(new Color(136, 191, 173));
/*     */       }
/* 767 */       else if (row % 2 == 0) {
/* 768 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 770 */         setBackground((Color)null);
/* 771 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 772 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 777 */     String[] plataformas = this.con.regresaColIndex("empresa", "emp_generadora", "where activo='activado' and clave_gene<>0 order by empresa");
/* 778 */     this.jComboBox1.removeAllItems();
/* 779 */     this.combo.removeAllItems();
/* 780 */     this.jComboBox1.addItem("Selecciona uno...");
/* 781 */     this.combo.addItem("Selecciona uno...");
/* 782 */     for (int i = 0; i < plataformas.length; i++) {
/* 783 */       this.jComboBox1.addItem(plataformas[i]);
/* 784 */       this.combo.addItem(plataformas[i]);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Equipos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */