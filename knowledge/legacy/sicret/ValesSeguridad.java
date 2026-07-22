/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class ValesSeguridad extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  35 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  36 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  37 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  38 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  39 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  40 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  41 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  42 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*     */   String USUARIO;
/*  44 */   Validaciones val = new Validaciones();
/*  45 */   Consultas con = new Consultas();
/*  46 */   Errores error = new Errores(false);
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*     */   AltaOperador operador;
/*  50 */   int contador = 0;
/*     */   JFrame padre;
/*     */   EscribirReporte esc;
/*  53 */   Date fechaActual = new Date();
/*  54 */   Date fecha = new Date();
/*  55 */   Date fechaInicio = null;
/*  56 */   Date fechaTermino = null;
/*  57 */   Date fechaMinimo = null;
/*     */ 
/*     */ 
/*     */   
/*  61 */   String CLAVEOP = "";
/*     */   String[] operadores;
/*  63 */   String NOMBRE = "";
/*  64 */   String[] GUIAS = new String[10];
/*  65 */   String CLAVE = ""; boolean CONCEPTO = false; private JButton jButton1; private JButton jButton14; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JDialog jDialog1;
/*     */   private JDialog jDialog2;
/*  67 */   int INDICE = 0; private JLabel jLabel1; private JLabel jLabel12; private JLabel jLabel2; private JLabel jLabel3; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel46; private JLabel jLabel48; private JLabel jLabel56; private JLabel jLabel59; private JLabel jLabel60; private JLabel jLabel61;
/*     */   
/*     */   public ValesSeguridad(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  70 */     String año = "2010";
/*  71 */     String mes = "03";
/*  72 */     String dia = "01";
/*  73 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  74 */     String strFecha = dia + "-" + dia + "-" + mes;
/*     */     try {
/*  76 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*     */     }
/*  78 */     catch (ParseException ex) {
/*  79 */       ex.printStackTrace();
/*     */     } 
/*  81 */     this.padre = padre;
/*  82 */     this.fichas = fichas;
/*  83 */     initComponents();
/*  84 */     this.USUARIO = USUARIO;
/*  85 */     panelito.setViewportView(this);
/*  86 */     this.panel = panelito;
/*  87 */     initComponents();
/*     */     
/*  89 */     int w = this.tama.width;
/*  90 */     int h = this.tama.height;
/*  91 */     int rw = (w - 700) / 2;
/*  92 */     int rh = (h - 370) / 2;
/*  93 */     this.jDialog1.setLocation(rw, rh);
/*  94 */     this.jDialog1.setSize(700, 370);
/*  95 */     this.jDialog1.setVisible(false);
/*  96 */     this.jDialog1.setResizable(false);
/*     */     
/*  98 */     rw = (w - 500) / 2;
/*  99 */     rh = (h - 550) / 2;
/* 100 */     this.jDialog2.setLocation(rw, rh);
/* 101 */     this.jDialog2.setSize(500, 550);
/* 102 */     this.jDialog2.setVisible(false);
/* 103 */     this.jDialog2.setResizable(false);
/*     */   }
/*     */   private JLabel jLabel62; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel4; private JPanel jPanel6; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JSeparator jSeparator1; private JSeparator jSeparator5; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTextArea jTextArea1; private JTextField jTextField1; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6;
/*     */   private JTextField jTextField7;
/*     */   
/*     */   private void initComponents() {
/* 109 */     this.jDialog1 = new JDialog(this.padre);
/* 110 */     this.jPanel4 = new JPanel();
/* 111 */     this.jLabel1 = new JLabel();
/* 112 */     this.jSeparator1 = new JSeparator();
/* 113 */     this.jScrollPane1 = new JScrollPane();
/* 114 */     this.jTable1 = new JTable();
/* 115 */     this.jButton5 = new JButton();
/* 116 */     this.jButton6 = new JButton();
/* 117 */     this.jLabel2 = new JLabel();
/* 118 */     this.jTextField1 = new JTextField();
/* 119 */     this.jDialog2 = new JDialog(this.jDialog1);
/* 120 */     this.jPanel1 = new JPanel();
/* 121 */     this.jLabel12 = new JLabel();
/* 122 */     this.jSeparator5 = new JSeparator();
/* 123 */     this.jPanel21 = new JPanel();
/* 124 */     this.jTextField18 = new JTextField();
/* 125 */     this.jLabel32 = new JLabel();
/* 126 */     this.jButton14 = new JButton();
/* 127 */     this.jLabel33 = new JLabel();
/* 128 */     this.jScrollPane4 = new JScrollPane();
/* 129 */     this.jTextArea1 = new JTextArea();
/* 130 */     this.jLabel34 = new JLabel();
/* 131 */     this.jTextField19 = new JTextField();
/* 132 */     this.jPanel22 = new JPanel();
/* 133 */     this.jScrollPane3 = new JScrollPane();
/* 134 */     this.jTable3 = new JTable();
/* 135 */     this.jButton8 = new JButton();
/* 136 */     this.jButton9 = new JButton();
/* 137 */     this.jButton3 = new JButton();
/* 138 */     this.jPanel6 = new JPanel();
/* 139 */     this.jLabel3 = new JLabel();
/* 140 */     this.jPanel17 = new JPanel();
/* 141 */     this.jLabel56 = new JLabel();
/* 142 */     this.jTextField3 = new JTextField();
/* 143 */     this.jComboBox1 = new JComboBox();
/* 144 */     this.jLabel46 = new JLabel();
/* 145 */     this.jTextField4 = new JTextField();
/* 146 */     this.jLabel59 = new JLabel();
/* 147 */     this.jTextField5 = new JTextField();
/* 148 */     this.jLabel60 = new JLabel();
/* 149 */     this.jTextField6 = new JTextField();
/* 150 */     this.jLabel61 = new JLabel();
/* 151 */     this.jTextField7 = new JTextField();
/* 152 */     this.jLabel62 = new JLabel();
/* 153 */     this.jPanel18 = new JPanel();
/* 154 */     this.jScrollPane2 = new JScrollPane();
/* 155 */     this.jTable2 = new JTable();
/* 156 */     this.jLabel48 = new JLabel();
/* 157 */     this.jButton1 = new JButton();
/* 158 */     this.jButton2 = new JButton();
/* 159 */     this.jButton4 = new JButton();
/* 160 */     this.jButton7 = new JButton();
/*     */     
/* 162 */     this.jDialog1.setTitle("Listado de Vales");
/* 163 */     this.jDialog1.setModal(true);
/*     */     
/* 165 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*     */     
/* 167 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/* 168 */     this.jLabel1.setForeground(new Color(15, 87, 51));
/* 169 */     this.jLabel1.setHorizontalAlignment(0);
/* 170 */     this.jLabel1.setText("LISTADO DE VALES");
/*     */     
/* 172 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, , { null, null, null }, , { null, null, null }, , { null, null, null },  }, (Object[])new String[] { "CLave", "Fecha", "Descripción" }));
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
/* 183 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 184 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 185 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 186 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(150);
/* 187 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
/*     */     
/* 189 */     this.jButton5.setText("Salir");
/* 190 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 192 */             ValesSeguridad.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 196 */     this.jButton6.setText("Ver Detalle");
/*     */     
/* 198 */     this.jLabel2.setFont(new Font("Tahoma", 2, 11));
/* 199 */     this.jLabel2.setText("Búsqueda por Descripción");
/*     */     
/* 201 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 202 */     this.jPanel4.setLayout(jPanel4Layout);
/* 203 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 204 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 205 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 206 */           .addContainerGap()
/* 207 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */             .addComponent(this.jLabel1, -1, 670, 32767)
/* 209 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 210 */               .addComponent(this.jLabel2, -2, 135, -2)
/* 211 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 212 */               .addComponent(this.jTextField1, -2, 215, -2))
/* 213 */             .addComponent(this.jSeparator1, -1, 670, 32767)
/* 214 */             .addComponent(this.jScrollPane1, -1, 670, 32767)
/* 215 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 216 */               .addComponent(this.jButton6, -2, 105, -2)
/* 217 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 218 */               .addComponent(this.jButton5, -2, 105, -2)))
/* 219 */           .addContainerGap()));
/*     */     
/* 221 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 223 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 224 */           .addContainerGap()
/* 225 */           .addComponent(this.jLabel1)
/* 226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 227 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 228 */             .addComponent(this.jLabel2)
/* 229 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 231 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 233 */           .addComponent(this.jScrollPane1, -2, 207, -2)
/* 234 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 235 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 236 */             .addComponent(this.jButton5)
/* 237 */             .addComponent(this.jButton6))
/* 238 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 241 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 242 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 243 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 245 */         .addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 247 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 248 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 249 */         .addComponent(this.jPanel4, -2, -1, -2));
/*     */ 
/*     */     
/* 252 */     this.jDialog2.setTitle("Conceptos de Vales");
/* 253 */     this.jDialog2.setModal(true);
/* 254 */     this.jDialog2.setResizable(false);
/*     */     
/* 256 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*     */     
/* 258 */     this.jLabel12.setFont(new Font("Tahoma", 1, 15));
/* 259 */     this.jLabel12.setForeground(new Color(0, 102, 102));
/* 260 */     this.jLabel12.setHorizontalAlignment(0);
/* 261 */     this.jLabel12.setText(" CATÁLOGO DE VALES");
/*     */     
/* 263 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/* 264 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " Agregar Conceptos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 266 */     this.jTextField18.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 268 */             ValesSeguridad.this.jTextField18ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 272 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/* 273 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 274 */     this.jLabel32.setHorizontalAlignment(4);
/* 275 */     this.jLabel32.setText("Concepto");
/*     */     
/* 277 */     this.jButton14.setMnemonic('A');
/* 278 */     this.jButton14.setText("Agregar");
/* 279 */     this.jButton14.setToolTipText("Agregar (Alt+A)");
/* 280 */     this.jButton14.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 282 */             ValesSeguridad.this.jButton14ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 286 */     this.jLabel33.setFont(new Font("Tahoma", 3, 11));
/* 287 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/* 288 */     this.jLabel33.setHorizontalAlignment(4);
/* 289 */     this.jLabel33.setText("Descripción");
/*     */     
/* 291 */     this.jTextArea1.setColumns(20);
/* 292 */     this.jTextArea1.setRows(5);
/* 293 */     this.jScrollPane4.setViewportView(this.jTextArea1);
/*     */     
/* 295 */     this.jLabel34.setFont(new Font("Tahoma", 3, 11));
/* 296 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/* 297 */     this.jLabel34.setHorizontalAlignment(4);
/* 298 */     this.jLabel34.setText("Precio  $");
/*     */     
/* 300 */     this.jTextField19.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 302 */             ValesSeguridad.this.jTextField19ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 306 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 307 */     this.jPanel21.setLayout(jPanel21Layout);
/* 308 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 309 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 310 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 311 */           .addContainerGap()
/* 312 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 313 */             .addGroup(jPanel21Layout.createSequentialGroup()
/* 314 */               .addComponent(this.jLabel32, -2, 65, -2)
/* 315 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 316 */               .addComponent(this.jTextField18, -2, 197, -2))
/* 317 */             .addGroup(jPanel21Layout.createSequentialGroup()
/* 318 */               .addComponent(this.jLabel34, -2, 65, -2)
/* 319 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 320 */               .addComponent(this.jTextField19, -2, 197, -2))
/* 321 */             .addGroup(jPanel21Layout.createSequentialGroup()
/* 322 */               .addComponent(this.jLabel33, -2, 65, -2)
/* 323 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 324 */               .addComponent(this.jScrollPane4, -2, 350, -2))
/* 325 */             .addComponent(this.jButton14, GroupLayout.Alignment.TRAILING, -2, 106, -2))
/* 326 */           .addContainerGap(16, 32767)));
/*     */     
/* 328 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 329 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 330 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 331 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 332 */             .addComponent(this.jLabel32)
/* 333 */             .addComponent(this.jTextField18, -2, -1, -2))
/* 334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 335 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 336 */             .addComponent(this.jLabel34)
/* 337 */             .addComponent(this.jTextField19, -2, -1, -2))
/* 338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 339 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 340 */             .addComponent(this.jLabel33)
/* 341 */             .addComponent(this.jScrollPane4, -2, -1, -2))
/* 342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 343 */           .addComponent(this.jButton14)));
/*     */ 
/*     */     
/* 346 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/* 347 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, " Organizar Conceptos ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 349 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 350 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 358 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 363 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 366 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 368 */     this.jButton8.setText("Modificar");
/*     */     
/* 370 */     this.jButton9.setText("Eliminar");
/*     */     
/* 372 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 373 */     this.jPanel22.setLayout(jPanel22Layout);
/* 374 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 375 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 376 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 377 */           .addContainerGap()
/* 378 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 379 */             .addComponent(this.jScrollPane3, -1, 431, 32767)
/* 380 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
/* 381 */               .addComponent(this.jButton9, -2, 108, -2)
/* 382 */               .addGap(18, 18, 18)
/* 383 */               .addComponent(this.jButton8, -2, 108, -2)))
/* 384 */           .addContainerGap()));
/*     */     
/* 386 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 388 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 389 */           .addComponent(this.jScrollPane3, -2, 134, -2)
/* 390 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 391 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 392 */             .addComponent(this.jButton8)
/* 393 */             .addComponent(this.jButton9))
/* 394 */           .addContainerGap(6, 32767)));
/*     */ 
/*     */     
/* 397 */     this.jButton3.setText("Cerrar");
/* 398 */     this.jButton3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 400 */             ValesSeguridad.this.jButton3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 404 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 405 */     this.jPanel1.setLayout(jPanel1Layout);
/* 406 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 408 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 409 */           .addContainerGap()
/* 410 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 411 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 412 */               .addComponent(this.jPanel22, -1, -1, 32767)
/* 413 */               .addContainerGap())
/* 414 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 415 */               .addComponent(this.jSeparator5, -2, -1, -2)
/* 416 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 417 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 418 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 419 */                   .addComponent(this.jLabel12, -1, 459, 32767))
/* 420 */                 .addComponent(this.jPanel21, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 421 */               .addContainerGap())
/* 422 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 423 */               .addComponent(this.jButton3, -2, 108, -2)
/* 424 */               .addGap(28, 28, 28)))));
/*     */     
/* 426 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 427 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 428 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 429 */           .addContainerGap()
/* 430 */           .addComponent(this.jLabel12)
/* 431 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 432 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 433 */             .addComponent(this.jSeparator5, -2, 10, -2)
/* 434 */             .addComponent(this.jPanel21, -2, -1, -2))
/* 435 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 436 */           .addComponent(this.jPanel22, -1, 201, 32767)
/* 437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 438 */           .addComponent(this.jButton3)
/* 439 */           .addContainerGap()));
/*     */ 
/*     */     
/* 442 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 443 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 444 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 445 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 446 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 447 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 448 */           .addGap(20, 20, 20)));
/*     */     
/* 450 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 451 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 452 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 453 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 454 */           .addContainerGap()));
/*     */ 
/*     */     
/* 457 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 458 */     this.jPanel6.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*     */     
/* 460 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 461 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 462 */     this.jLabel3.setHorizontalAlignment(0);
/* 463 */     this.jLabel3.setText("VALES DE SEGURIDAD");
/*     */     
/* 465 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 466 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Vales ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 468 */     this.jLabel56.setFont(new Font("Tahoma", 3, 12));
/* 469 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 470 */     this.jLabel56.setHorizontalAlignment(0);
/* 471 */     this.jLabel56.setText("Nombre del Operador");
/*     */     
/* 473 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 475 */             ValesSeguridad.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 479 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 480 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 481 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 482 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 484 */             ValesSeguridad.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 488 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 489 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 490 */     this.jLabel46.setHorizontalAlignment(0);
/* 491 */     this.jLabel46.setText("Estado-Vales");
/*     */     
/* 493 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 495 */             ValesSeguridad.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 499 */     this.jLabel59.setFont(new Font("Tahoma", 3, 12));
/* 500 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 501 */     this.jLabel59.setHorizontalAlignment(0);
/* 502 */     this.jLabel59.setText("Apellido Paterno");
/*     */     
/* 504 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 506 */             ValesSeguridad.this.jTextField5KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 510 */     this.jLabel60.setFont(new Font("Tahoma", 3, 12));
/* 511 */     this.jLabel60.setForeground(new Color(15, 87, 51));
/* 512 */     this.jLabel60.setHorizontalAlignment(0);
/* 513 */     this.jLabel60.setText("Apellido Materno");
/*     */     
/* 515 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 517 */             ValesSeguridad.this.jTextField6KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 521 */     this.jLabel61.setFont(new Font("Tahoma", 3, 12));
/* 522 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 523 */     this.jLabel61.setHorizontalAlignment(0);
/* 524 */     this.jLabel61.setText("Eco");
/*     */     
/* 526 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 528 */             ValesSeguridad.this.jTextField7KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 532 */     this.jLabel62.setFont(new Font("Tahoma", 3, 12));
/* 533 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 534 */     this.jLabel62.setHorizontalAlignment(0);
/* 535 */     this.jLabel62.setText("Rem");
/*     */     
/* 537 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 538 */     this.jPanel17.setLayout(jPanel17Layout);
/* 539 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 540 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 541 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 542 */           .addContainerGap()
/* 543 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 544 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 545 */             .addComponent(this.jComboBox1, 0, 114, 32767))
/* 546 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 547 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 548 */             .addComponent(this.jLabel56, -1, -1, 32767)
/* 549 */             .addComponent(this.jTextField3, -2, 150, -2))
/* 550 */           .addGap(8, 8, 8)
/* 551 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 552 */             .addComponent(this.jLabel59, -1, -1, 32767)
/* 553 */             .addComponent(this.jTextField4, -2, 150, -2))
/* 554 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 555 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 556 */             .addComponent(this.jLabel60, -1, -1, 32767)
/* 557 */             .addComponent(this.jTextField5, -2, 150, -2))
/* 558 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 559 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 560 */             .addComponent(this.jTextField6)
/* 561 */             .addComponent(this.jLabel61, -1, 65, 32767))
/* 562 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 563 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 564 */             .addComponent(this.jTextField7)
/* 565 */             .addComponent(this.jLabel62, -2, 65, -2))
/* 566 */           .addContainerGap(94, 32767)));
/*     */     
/* 568 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 569 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 570 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 571 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 572 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 573 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 574 */               .addGap(8, 8, 8)
/* 575 */               .addComponent(this.jLabel46))
/* 576 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 577 */               .addComponent(this.jTextField4, -2, -1, -2)
/* 578 */               .addGap(8, 8, 8)
/* 579 */               .addComponent(this.jLabel59))
/* 580 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 581 */               .addComponent(this.jTextField5, -2, -1, -2)
/* 582 */               .addGap(8, 8, 8)
/* 583 */               .addComponent(this.jLabel60))
/* 584 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 585 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 586 */               .addGap(8, 8, 8)
/* 587 */               .addComponent(this.jLabel56))
/* 588 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 589 */               .addComponent(this.jTextField6, -2, -1, -2)
/* 590 */               .addGap(8, 8, 8)
/* 591 */               .addComponent(this.jLabel61))
/* 592 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 593 */               .addComponent(this.jTextField7, -2, -1, -2)
/* 594 */               .addGap(8, 8, 8)
/* 595 */               .addComponent(this.jLabel62)))
/* 596 */           .addContainerGap()));
/*     */ 
/*     */     
/* 599 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 600 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 602 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 603 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 611 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 616 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 619 */     this.jTable2.setShowVerticalLines(false);
/* 620 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 622 */             ValesSeguridad.this.jTable2MouseClicked(evt);
/*     */           }
/*     */         });
/* 625 */     this.jScrollPane2.setViewportView(this.jTable2);
/*     */     
/* 627 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 628 */     this.jLabel48.setForeground(Color.red);
/* 629 */     this.jLabel48.setHorizontalAlignment(2);
/* 630 */     this.jLabel48.setText("t");
/* 631 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 633 */     this.jButton1.setText("Nuevo");
/* 634 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 636 */             ValesSeguridad.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 640 */     this.jButton2.setText("Cancelar");
/*     */     
/* 642 */     this.jButton4.setText("Ver Vales");
/* 643 */     this.jButton4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 645 */             ValesSeguridad.this.jButton4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 649 */     this.jButton7.setText("Catálogo");
/* 650 */     this.jButton7.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 652 */             ValesSeguridad.this.jButton7ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 656 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 657 */     this.jPanel18.setLayout(jPanel18Layout);
/* 658 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 659 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 660 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 661 */           .addContainerGap()
/* 662 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 663 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 810, 32767)
/* 664 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 665 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 666 */               .addGap(67, 67, 67)
/* 667 */               .addComponent(this.jButton1, -2, 111, -2)
/* 668 */               .addGap(27, 27, 27)
/* 669 */               .addComponent(this.jButton2, -2, 111, -2)
/* 670 */               .addGap(26, 26, 26)
/* 671 */               .addComponent(this.jButton4, -2, 111, -2)
/* 672 */               .addGap(27, 27, 27)
/* 673 */               .addComponent(this.jButton7, -2, 111, -2)))
/* 674 */           .addContainerGap()));
/*     */     
/* 676 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 678 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 679 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 680 */             .addComponent(this.jLabel48)
/* 681 */             .addComponent(this.jButton1)
/* 682 */             .addComponent(this.jButton2)
/* 683 */             .addComponent(this.jButton4)
/* 684 */             .addComponent(this.jButton7))
/* 685 */           .addGap(4, 4, 4)
/* 686 */           .addComponent(this.jScrollPane2, -2, 242, -2)));
/*     */ 
/*     */     
/* 689 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 690 */     this.jPanel6.setLayout(jPanel6Layout);
/* 691 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 692 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 693 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 694 */           .addContainerGap()
/* 695 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 696 */             .addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING, -1, 842, 32767)
/* 697 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 698 */             .addComponent(this.jPanel18, -1, -1, 32767))
/* 699 */           .addContainerGap()));
/*     */     
/* 701 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 702 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 703 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 704 */           .addContainerGap()
/* 705 */           .addComponent(this.jLabel3)
/* 706 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 707 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 708 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 709 */           .addComponent(this.jPanel18, -2, -1, -2)
/* 710 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 713 */     GroupLayout layout = new GroupLayout(this);
/* 714 */     setLayout(layout);
/* 715 */     layout.setHorizontalGroup(layout
/* 716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 717 */         .addGap(0, 886, 32767)
/* 718 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 719 */           .addGroup(layout.createSequentialGroup()
/* 720 */             .addContainerGap()
/* 721 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 722 */             .addContainerGap())));
/*     */     
/* 724 */     layout.setVerticalGroup(layout
/* 725 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 726 */         .addGap(0, 447, 32767)
/* 727 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 728 */           .addGroup(layout.createSequentialGroup()
/* 729 */             .addContainerGap()
/* 730 */             .addComponent(this.jPanel6, -2, -1, -2)
/* 731 */             .addContainerGap(-1, 32767))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField5KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTable2MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 756 */     this.jDialog1.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 760 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField18ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton14ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField19ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 776 */     this.jDialog2.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 780 */     this.jDialog2.setVisible(true);
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void jTextField6KeyReleased(KeyEvent evt) {}
/*     */   
/*     */   private void jTextField7KeyReleased(KeyEvent evt) {}
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ValesSeguridad.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */