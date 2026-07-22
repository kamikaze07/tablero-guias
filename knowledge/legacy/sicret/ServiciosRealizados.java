/*     */ package sicret;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.net.URL;
/*     */ import java.util.Calendar;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonGroup;
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
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ 
/*     */ public class ServiciosRealizados
/*     */   extends JPanel
/*     */ {
/*     */   JFrame padre;
/*     */   JScrollPane panel;
/*  48 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  49 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  50 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  51 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  52 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  53 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  54 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  55 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  56 */   Consultas con = new Consultas();
/*     */   
/*     */   boolean encontrado = false;
/*  59 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*     */   JTabbedPane fichas;
/*     */   String USUARIO;
/*     */   JTable tabla;
/*     */   EscribirReporte esc;
/*  64 */   Errores error = new Errores(false);
/*  65 */   Validaciones val = new Validaciones();
/*  66 */   String CLAVE = "";
/*  67 */   int CONT = 0;
/*  68 */   String MESLETRA = "";
/*  69 */   String FECHA1 = "";
/*  70 */   String FECHA2 = "";
/*     */   boolean SIGUE = true;
/*  72 */   String viajes = "";
/*  73 */   int diasInicio = 0;
/*  74 */   int diasFin = 0;
/*  75 */   Esperando espe = new Esperando(); private ButtonGroup buttonGroup1; private JButton jButton1; private JComboBox jComboBox1; private JFrame jFrame1; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel35; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40;
/*     */   
/*     */   public ServiciosRealizados(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*  78 */     this.USUARIO = usua;
/*     */     
/*  80 */     this.fichas = fichas;
/*  81 */     this.padre = padre;
/*  82 */     initComponents();
/*  83 */     panelito.setViewportView(this);
/*  84 */     this.panel = panelito;
/*  85 */     colorear();
/*     */     
/*  87 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  88 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  89 */     this.jFrame1.setCursor(micursor);
/*     */     
/*  91 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  92 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  93 */     this.jLabel37.setCursor(micursor);
/*  94 */     this.jLabel41.setCursor(micursor);
/*  95 */     this.jLabel42.setCursor(micursor);
/*     */     
/*  97 */     int w = this.tama.width;
/*  98 */     int h = this.tama.height;
/*  99 */     int rw = (w - 985) / 2;
/* 100 */     int rh = (h - 670) / 2;
/* 101 */     this.jFrame1.setLocation(rw, rh);
/* 102 */     this.jFrame1.setSize(1100, 670);
/* 103 */     this.jFrame1.setVisible(false);
/*     */     
/* 105 */     this.buttonGroup1.add(this.jRadioButton1);
/* 106 */     this.buttonGroup1.add(this.jRadioButton2);
/* 107 */     this.buttonGroup1.add(this.jRadioButton3);
/* 108 */     this.buttonGroup1.add(this.jRadioButton4);
/* 109 */     cargarA();
/*     */   }
/*     */   private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel5; private JLabel jLabel62; private JLabel jLabel75; private JPanel jPanel1; private JPanel jPanel12; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator9; private JSlider jSlider1; private JTable jTable2;
/*     */   
/*     */   private void initComponents() {
/* 114 */     this.jFrame1 = new JFrame();
/* 115 */     this.jPanel12 = new JPanel();
/* 116 */     this.jLabel75 = new JLabel();
/* 117 */     this.jLabel29 = new JLabel();
/* 118 */     this.jSeparator9 = new JSeparator();
/* 119 */     this.jLabel30 = new JLabel();
/* 120 */     this.jLabel31 = new JLabel();
/* 121 */     this.jLabel32 = new JLabel();
/* 122 */     this.jLabel35 = new JLabel();
/* 123 */     this.jSeparator10 = new JSeparator();
/* 124 */     this.jScrollPane5 = new JScrollPane();
/* 125 */     this.jTable2 = new JTable();
/* 126 */     this.jLabel37 = new JLabel();
/* 127 */     this.jLabel38 = new JLabel();
/* 128 */     this.jLabel39 = new JLabel();
/* 129 */     this.jLabel40 = new JLabel();
/* 130 */     this.jLabel41 = new JLabel();
/* 131 */     this.jLabel42 = new JLabel();
/* 132 */     this.jLabel43 = new JLabel();
/* 133 */     this.jLabel3 = new JLabel();
/* 134 */     this.jLabel33 = new JLabel();
/* 135 */     this.jLabel4 = new JLabel();
/* 136 */     this.buttonGroup1 = new ButtonGroup();
/* 137 */     this.jPanel1 = new JPanel();
/* 138 */     this.jLabel62 = new JLabel();
/* 139 */     this.jSeparator1 = new JSeparator();
/* 140 */     this.jLabel1 = new JLabel();
/* 141 */     this.jLabel2 = new JLabel();
/* 142 */     this.jRadioButton1 = new JRadioButton();
/* 143 */     this.jRadioButton2 = new JRadioButton();
/* 144 */     this.jRadioButton3 = new JRadioButton();
/* 145 */     this.jButton1 = new JButton();
/* 146 */     this.jComboBox1 = new JComboBox();
/* 147 */     this.jRadioButton4 = new JRadioButton();
/* 148 */     this.jLabel5 = new JLabel();
/* 149 */     this.jSlider1 = new JSlider();
/*     */     
/* 151 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*     */     
/* 153 */     this.jLabel75.setFont(new Font("Times New Roman", 3, 23));
/* 154 */     this.jLabel75.setForeground(Color.red);
/* 155 */     this.jLabel75.setText("FLETES Y MATERIALES GRUPO FORSIS S.A. DE C.V.");
/*     */     
/* 157 */     this.jLabel29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*     */     
/* 159 */     this.jLabel30.setFont(new Font("Tahoma", 2, 16));
/* 160 */     this.jLabel30.setText("Carretera a Tihuatlán Km 8.5, Poza Rica, Veracruz");
/*     */     
/* 162 */     this.jLabel31.setFont(new Font("Tahoma", 2, 15));
/* 163 */     this.jLabel31.setText("Teléfono: (01-782) 825-6455");
/*     */     
/* 165 */     this.jLabel32.setFont(new Font("Times New Roman", 1, 17));
/* 166 */     this.jLabel32.setForeground(Color.blue);
/* 167 */     this.jLabel32.setText("REPORTE COMPLETO DE VIAJES");
/*     */     
/* 169 */     this.jLabel35.setFont(new Font("Tahoma", 0, 15));
/* 170 */     this.jLabel35.setForeground(Color.blue);
/* 171 */     this.jLabel35.setText("Total de Datos: 1092");
/*     */     
/* 173 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 174 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Nombre", "Concepto", "Cargo", "Eco", "Monto" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     this.jScrollPane5.setViewportView(this.jTable2);
/*     */     
/* 184 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/* 185 */     this.jLabel37.setForeground(Color.red);
/* 186 */     this.jLabel37.setHorizontalAlignment(0);
/* 187 */     this.jLabel37.setText("<html><u>Cerrar</u></html>");
/* 188 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 190 */             ServiciosRealizados.this.jLabel37MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 193 */             ServiciosRealizados.this.jLabel37MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 196 */             ServiciosRealizados.this.jLabel37MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 200 */     this.jLabel38.setFont(new Font("Tahoma", 1, 11));
/* 201 */     this.jLabel38.setText("|");
/*     */     
/* 203 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/* 204 */     this.jLabel39.setText("|");
/*     */     
/* 206 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/* 207 */     this.jLabel40.setText("|");
/*     */     
/* 209 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/* 210 */     this.jLabel41.setForeground(Color.red);
/* 211 */     this.jLabel41.setHorizontalAlignment(0);
/* 212 */     this.jLabel41.setText("<html><u>Imprimir</u></html>");
/* 213 */     this.jLabel41.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 215 */             ServiciosRealizados.this.jLabel41MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 218 */             ServiciosRealizados.this.jLabel41MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 221 */             ServiciosRealizados.this.jLabel41MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 225 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/* 226 */     this.jLabel42.setForeground(Color.red);
/* 227 */     this.jLabel42.setHorizontalAlignment(0);
/* 228 */     this.jLabel42.setText("<html><u>Guardar</u></html>");
/* 229 */     this.jLabel42.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 231 */             ServiciosRealizados.this.jLabel42MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 234 */             ServiciosRealizados.this.jLabel42MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 237 */             ServiciosRealizados.this.jLabel42MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 241 */     this.jLabel43.setFont(new Font("Tahoma", 1, 11));
/* 242 */     this.jLabel43.setText("|");
/*     */     
/* 244 */     this.jLabel3.setFont(new Font("Times New Roman", 1, 22));
/* 245 */     this.jLabel3.setText("SERVICIOS REALIZADOS");
/*     */     
/* 247 */     this.jLabel33.setFont(new Font("Times New Roman", 1, 19));
/* 248 */     this.jLabel33.setText("Reporte de Enero");
/*     */     
/* 250 */     this.jLabel4.setText("Páginas 2");
/*     */     
/* 252 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 253 */     this.jPanel12.setLayout(jPanel12Layout);
/* 254 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 255 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 256 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 257 */           .addContainerGap()
/* 258 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 259 */             .addComponent(this.jScrollPane5, -1, 1031, 32767)
/* 260 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 261 */               .addComponent(this.jLabel29, -2, 75, -2)
/* 262 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 263 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 264 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 265 */                   .addComponent(this.jLabel30, -2, 385, -2)
/* 266 */                   .addGap(18, 18, 18)
/* 267 */                   .addComponent(this.jLabel31, -2, 202, -2))
/* 268 */                 .addComponent(this.jLabel32, -2, 410, -2))
/* 269 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, 32767)
/* 270 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 271 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 272 */                   .addComponent(this.jLabel35, -2, 178, -2)
/* 273 */                   .addGap(42, 42, 42)
/* 274 */                   .addComponent(this.jLabel4, -2, 82, -2))
/* 275 */                 .addComponent(this.jLabel33, -2, 278, -2)))
/* 276 */             .addComponent(this.jSeparator10, GroupLayout.Alignment.TRAILING, -1, 1031, 32767)
/* 277 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 278 */               .addComponent(this.jLabel43)
/* 279 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 280 */               .addComponent(this.jLabel42, -2, 78, -2)
/* 281 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 282 */               .addComponent(this.jLabel40)
/* 283 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */               .addComponent(this.jLabel41, -2, 78, -2)
/* 285 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 286 */               .addComponent(this.jLabel38)
/* 287 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 288 */               .addComponent(this.jLabel37, -2, 78, -2)
/* 289 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 290 */               .addComponent(this.jLabel39))
/* 291 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 292 */               .addGap(81, 81, 81)
/* 293 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 294 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 295 */                   .addComponent(this.jLabel75, -2, 599, 32767)
/* 296 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 297 */                   .addComponent(this.jLabel3, -2, 345, -2))
/* 298 */                 .addComponent(this.jSeparator9, -1, 950, 32767))))
/* 299 */           .addContainerGap()));
/*     */     
/* 301 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 303 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 304 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 305 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 306 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 307 */                 .addComponent(this.jLabel75, -2, 25, -2)
/* 308 */                 .addComponent(this.jLabel3))
/* 309 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 310 */               .addComponent(this.jSeparator9, -2, 2, -2)
/* 311 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 312 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 313 */                 .addComponent(this.jLabel30)
/* 314 */                 .addComponent(this.jLabel33, -1, -1, 32767)
/* 315 */                 .addComponent(this.jLabel31, -1, 22, 32767))
/* 316 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 317 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 318 */                 .addComponent(this.jLabel32, -2, 33, -2)
/* 319 */                 .addComponent(this.jLabel4)
/* 320 */                 .addComponent(this.jLabel35)))
/* 321 */             .addComponent(this.jLabel29, -2, 100, -2))
/* 322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 323 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 324 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 325 */           .addComponent(this.jScrollPane5, -1, 418, 32767)
/* 326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 327 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 328 */             .addComponent(this.jLabel37)
/* 329 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 330 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 331 */             .addComponent(this.jLabel41)
/* 332 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 333 */             .addComponent(this.jLabel42)
/* 334 */             .addComponent(this.jLabel43, -1, -1, 32767))
/* 335 */           .addContainerGap()));
/*     */ 
/*     */     
/* 338 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/* 339 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/* 340 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/* 341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 342 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*     */     
/* 344 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/* 345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*     */ 
/*     */     
/* 349 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 350 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 352 */     this.jLabel62.setFont(new Font("Times New Roman", 1, 25));
/* 353 */     this.jLabel62.setForeground(Color.blue);
/* 354 */     this.jLabel62.setHorizontalAlignment(0);
/* 355 */     this.jLabel62.setText("SERVICIOS REALIZADOS");
/*     */     
/* 357 */     this.jLabel1.setText("Selecciona la fecha del reporte");
/*     */     
/* 359 */     this.jLabel2.setText("Selecciona los datos del reporte");
/* 360 */     this.jLabel2.setCursor(new Cursor(0));
/*     */     
/* 362 */     this.jRadioButton1.setSelected(true);
/* 363 */     this.jRadioButton1.setText("Todos");
/* 364 */     this.jRadioButton1.setToolTipText("Muestra todos los viajes realizados de distintos remolques.");
/*     */     
/* 366 */     this.jRadioButton2.setText("Góndolas");
/* 367 */     this.jRadioButton2.setToolTipText("Muestra sólo los tractores que tienen remolque tipo góndola");
/*     */     
/* 369 */     this.jRadioButton3.setText("Pipas");
/* 370 */     this.jRadioButton3.setToolTipText("Muestra sólo los tractores que tienen remolque tipo pipa");
/*     */     
/* 372 */     this.jButton1.setMnemonic('v');
/* 373 */     this.jButton1.setText("Ver Reporte");
/* 374 */     this.jButton1.setToolTipText("Ver Reporte  del Mes (Alt+V)");
/* 375 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 377 */             ServiciosRealizados.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 381 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 382 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
/*     */     
/* 384 */     this.jRadioButton4.setText("Otros");
/* 385 */     this.jRadioButton4.setToolTipText("Muestra otro viajes como retros, saneamientos, planas, entre otros.");
/*     */     
/* 387 */     this.jLabel5.setFont(new Font("Tahoma", 1, 13));
/* 388 */     this.jLabel5.setText("2010");
/*     */     
/* 390 */     this.jSlider1.setBackground(new Color(146, 193, 134));
/* 391 */     this.jSlider1.setMaximum(2015);
/* 392 */     this.jSlider1.setMinimum(2009);
/* 393 */     this.jSlider1.addChangeListener(new ChangeListener() {
/*     */           public void stateChanged(ChangeEvent evt) {
/* 395 */             ServiciosRealizados.this.jSlider1StateChanged(evt);
/*     */           }
/*     */         });
/*     */     
/* 399 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 400 */     this.jPanel1.setLayout(jPanel1Layout);
/* 401 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 402 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 403 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 404 */           .addContainerGap()
/* 405 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 406 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 407 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 408 */                 .addComponent(this.jLabel1, -1, -1, 32767)
/* 409 */                 .addComponent(this.jLabel2, -2, 1, 32767))
/* 410 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 411 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 412 */                 .addComponent(this.jButton1, -2, 149, -2)
/* 413 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 414 */                   .addComponent(this.jRadioButton1)
/* 415 */                   .addGap(18, 18, 18)
/* 416 */                   .addComponent(this.jRadioButton2)
/* 417 */                   .addGap(18, 18, 18)
/* 418 */                   .addComponent(this.jRadioButton3, -2, 78, -2)
/* 419 */                   .addGap(18, 18, 18)
/* 420 */                   .addComponent(this.jRadioButton4, -2, 98, -2))
/* 421 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 422 */                   .addComponent(this.jComboBox1, -2, 127, -2)
/* 423 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 424 */                   .addComponent(this.jLabel5, -2, 47, -2)
/* 425 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 426 */                   .addComponent(this.jSlider1, 0, 0, 32767)))
/* 427 */               .addGap(26, 26, 26))
/* 428 */             .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING))
/* 429 */           .addContainerGap(30, 32767))
/* 430 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 431 */           .addComponent(this.jLabel62, -1, 612, 32767)
/* 432 */           .addContainerGap()));
/*     */     
/* 434 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 435 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 436 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 437 */           .addContainerGap()
/* 438 */           .addComponent(this.jLabel62)
/* 439 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 440 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 441 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 442 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 443 */               .addGap(8, 8, 8)
/* 444 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 445 */                 .addComponent(this.jLabel1, -1, -1, 32767)
/* 446 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 447 */                 .addComponent(this.jLabel5)))
/* 448 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 449 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 450 */               .addComponent(this.jSlider1, -2, -1, -2)))
/* 451 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 452 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 453 */             .addComponent(this.jLabel2)
/* 454 */             .addComponent(this.jRadioButton1)
/* 455 */             .addComponent(this.jRadioButton3)
/* 456 */             .addComponent(this.jRadioButton2)
/* 457 */             .addComponent(this.jRadioButton4))
/* 458 */           .addGap(82, 82, 82)
/* 459 */           .addComponent(this.jButton1, -2, 36, -2)
/* 460 */           .addGap(61, 61, 61)));
/*     */ 
/*     */     
/* 463 */     GroupLayout layout = new GroupLayout(this);
/* 464 */     setLayout(layout);
/* 465 */     layout.setHorizontalGroup(layout
/* 466 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 467 */         .addGap(0, 646, 32767)
/* 468 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 469 */           .addGroup(layout.createSequentialGroup()
/* 470 */             .addGap(0, 10, 32767)
/* 471 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 472 */             .addGap(0, 10, 32767))));
/*     */     
/* 474 */     layout.setVerticalGroup(layout
/* 475 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 476 */         .addGap(0, 346, 32767)
/* 477 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 478 */           .addGroup(layout.createSequentialGroup()
/* 479 */             .addGap(22, 22, 22)
/* 480 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 481 */             .addContainerGap(22, 32767))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 486 */     String nombreVent = "";
/* 487 */     if (this.jRadioButton1.isSelected()) {
/* 488 */       nombreVent = "Reporte Completo de Servicios";
/*     */     }
/* 490 */     else if (this.jRadioButton2.isSelected()) {
/* 491 */       nombreVent = "Reporte de Servicios de Góndolas";
/*     */     }
/* 493 */     else if (this.jRadioButton3.isSelected()) {
/* 494 */       nombreVent = "Reporte de Servicios de Pipas";
/*     */     }
/* 496 */     else if (this.jRadioButton4.isSelected()) {
/* 497 */       nombreVent = "Reporte de Servicios de Otros";
/*     */     } 
/* 499 */     cargarFecha();
/* 500 */     this.jLabel33.setText("Reporte de " + String.valueOf(this.jComboBox1.getSelectedItem()) + "/" + this.jLabel5.getText());
/* 501 */     this.jLabel32.setText(nombreVent.toUpperCase());
/* 502 */     this.jFrame1.setTitle(nombreVent);
/*     */     
/* 504 */     this.espe = new Esperando();
/* 505 */     this.espe.start();
/* 506 */     this.jFrame1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 510 */     this.jFrame1.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 514 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel37MouseExited(MouseEvent evt) {
/* 518 */     this.jLabel37.setForeground(Color.RED);
/*     */   }
/*     */   
/*     */   private void jLabel41MouseClicked(MouseEvent evt) {
/* 522 */     JOptionPane.showMessageDialog(this.jFrame1, "imprimir");
/*     */   }
/*     */   
/*     */   private void jLabel41MouseEntered(MouseEvent evt) {
/* 526 */     this.jLabel41.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel41MouseExited(MouseEvent evt) {
/* 530 */     this.jLabel41.setForeground(Color.RED);
/*     */   }
/*     */   
/*     */   private void jLabel42MouseClicked(MouseEvent evt) {
/* 534 */     JOptionPane.showMessageDialog(this.jFrame1, "Guardar");
/*     */   }
/*     */   
/*     */   private void jLabel42MouseEntered(MouseEvent evt) {
/* 538 */     this.jLabel42.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel42MouseExited(MouseEvent evt) {
/* 542 */     this.jLabel42.setForeground(Color.RED);
/*     */   }
/*     */   
/*     */   private void jSlider1StateChanged(ChangeEvent evt) {
/* 546 */     this.jLabel5.setText("" + this.jSlider1.getValue());
/*     */   }
/*     */   
/*     */   public void cargarFecha() {
/* 550 */     int aa = Integer.parseInt(this.jLabel5.getText());
/* 551 */     String strFecha = "";
/* 552 */     String año = "" + aa;
/* 553 */     int mm = this.jComboBox1.getSelectedIndex();
/* 554 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 555 */       this.MESLETRA = "ENERO";
/*     */     }
/* 557 */     else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 558 */       this.MESLETRA = "FEBRERO";
/*     */     }
/* 560 */     else if (this.jComboBox1.getSelectedIndex() == 2) {
/* 561 */       this.MESLETRA = "MARZO";
/*     */     }
/* 563 */     else if (this.jComboBox1.getSelectedIndex() == 3) {
/* 564 */       this.MESLETRA = "ABRIL";
/*     */     }
/* 566 */     else if (this.jComboBox1.getSelectedIndex() == 4) {
/* 567 */       this.MESLETRA = "MAYO";
/*     */     }
/* 569 */     else if (this.jComboBox1.getSelectedIndex() == 5) {
/* 570 */       this.MESLETRA = "JUNIO";
/*     */     }
/* 572 */     else if (this.jComboBox1.getSelectedIndex() == 6) {
/* 573 */       this.MESLETRA = "JULIO";
/*     */     }
/* 575 */     else if (this.jComboBox1.getSelectedIndex() == 7) {
/* 576 */       this.MESLETRA = "AGOSTO";
/*     */     }
/* 578 */     else if (this.jComboBox1.getSelectedIndex() == 8) {
/* 579 */       this.MESLETRA = "SEPTIEMBRE";
/*     */     }
/* 581 */     else if (this.jComboBox1.getSelectedIndex() == 9) {
/* 582 */       this.MESLETRA = "OCTUBRE";
/*     */     }
/* 584 */     else if (this.jComboBox1.getSelectedIndex() == 10) {
/* 585 */       this.MESLETRA = "NOVIEMBRE";
/*     */     }
/* 587 */     else if (this.jComboBox1.getSelectedIndex() == 11) {
/* 588 */       this.MESLETRA = "DICIEMBRE";
/*     */     } 
/* 590 */     this.diasFin = diasDelMes(mm, aa);
/* 591 */     this.FECHA1 = "'01-" + mm + "-" + aa + "'";
/* 592 */     this.FECHA2 = "'" + this.diasFin + "-" + mm + "-" + aa + "'";
/* 593 */     strFecha = "" + this.diasFin + "/" + this.diasFin + "/" + this.MESLETRA;
/*     */   }
/*     */   public void cargarA() {
/* 596 */     Calendar ca = Calendar.getInstance();
/* 597 */     Calendar fecha = Calendar.getInstance();
/* 598 */     int aa = fecha.get(1);
/* 599 */     this.jSlider1.setMaximum(aa);
/* 600 */     this.jSlider1.setValue(aa);
/*     */   }
/*     */   public int diasDelMes(int mes, int año) {
/* 603 */     switch (mes) {
/*     */       case 0:
/*     */       case 2:
/*     */       case 4:
/*     */       case 6:
/*     */       case 7:
/*     */       case 9:
/*     */       case 11:
/* 611 */         return 31;
/*     */       
/*     */       case 3:
/*     */       case 5:
/*     */       case 8:
/*     */       case 10:
/* 617 */         return 30;
/*     */       
/*     */       case 1:
/* 620 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*     */         {
/* 622 */           return 29;
/*     */         }
/* 624 */         return 28;
/*     */     } 
/*     */     
/* 627 */     return 0;
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 631 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 633 */             ServiciosRealizados.this.jTextGanado(ServiciosRealizados.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 636 */             ServiciosRealizados.this.jTextPerdido(ServiciosRealizados.this.jComboBox1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 641 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 644 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void servicios(String usu) {
/* 647 */     cargarA();
/* 648 */     this.USUARIO = usu;
/* 649 */     this.panel.setViewportView(this);
/*     */   }
/*     */   public void consultar() {
/* 652 */     DefaultTableModel modelo = new DefaultTableModel();
/* 653 */     modelo.addColumn("CONCEPTO");
/* 654 */     for (int i = 1; i <= this.diasFin; i++) {
/* 655 */       modelo.addColumn(Integer.valueOf(i));
/*     */     }
/* 657 */     this.jTable2.setModel(modelo);
/* 658 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(110);
/*     */   }
/*     */   
/*     */   class Esperando extends Thread { public void run() {
/* 662 */       ServiciosRealizados.this.consultar();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ServiciosRealizados.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */