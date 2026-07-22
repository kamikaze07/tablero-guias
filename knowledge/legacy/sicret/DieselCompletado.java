/*     */ package sicret;
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class DieselCompletado extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*  32 */   Toolkit tk = Toolkit.getDefaultToolkit(); JFrame padre; JScrollPane panel;
/*  33 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  34 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  35 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  36 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  37 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  38 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  39 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  40 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*     */   MostrarTabla modelo;
/*  43 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*     */   JTabbedPane fichas;
/*     */   String USUARIO;
/*     */   JTable tabla;
/*     */   EscribirReporte esc;
/*  48 */   Errores error = new Errores(false);
/*  49 */   Validaciones val = new Validaciones();
/*  50 */   String CLAVE = "";
/*  51 */   Date fechaInicio = null;
/*  52 */   Date fechaTermino = null;
/*  53 */   Date fechaActual = new Date();
/*  54 */   Date fecha = new Date();
/*  55 */   int CONT = 0;
/*  56 */   CeldaRender celda = new CeldaRender();
/*     */ 
/*     */   
/*  59 */   String FECHA1 = "";
/*  60 */   String FECHA2 = "";
/*     */   
/*     */   boolean SIGUE = true;
/*  63 */   String viajes = ""; private JButton jButton3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JLabel jLabel15; private JLabel jLabel17; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel7;
/*     */   
/*     */   public DieselCompletado(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  66 */     String año = "2010";
/*  67 */     String mes = "03";
/*  68 */     String dia = "01";
/*  69 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  70 */     String strFecha = dia + "-" + dia + "-" + mes;
/*     */     try {
/*  72 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*     */     }
/*  74 */     catch (ParseException ex) {
/*  75 */       ex.printStackTrace();
/*     */     } 
/*  77 */     this.padre = padre;
/*  78 */     this.fichas = fichas;
/*  79 */     initComponents();
/*  80 */     this.USUARIO = USUARIO;
/*  81 */     panelito.setViewportView(this);
/*  82 */     this.panel = panelito;
/*  83 */     consultar();
/*  84 */     colorear();
/*     */     
/*  86 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  87 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  88 */     this.jLabel7.setCursor(micursor);
/*  89 */     this.jLabel8.setCursor(micursor);
/*  90 */     this.jLabel9.setCursor(micursor);
/*     */   }
/*     */   private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel2; private JPanel jPanel6; private JScrollPane jScrollPane2; private JTable jTable1; private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   
/*     */   private void initComponents() {
/*  96 */     this.jPanel6 = new JPanel();
/*  97 */     this.jLabel3 = new JLabel();
/*  98 */     this.jPanel2 = new JPanel();
/*  99 */     this.jButton3 = new JButton();
/* 100 */     this.jLabel4 = new JLabel();
/* 101 */     this.jLabel5 = new JLabel();
/* 102 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 103 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 104 */     this.jLabel7 = new JLabel();
/* 105 */     this.jLabel8 = new JLabel();
/* 106 */     this.jLabel9 = new JLabel();
/* 107 */     this.jPanel17 = new JPanel();
/* 108 */     this.jTextField1 = new JTextField();
/* 109 */     this.jLabel15 = new JLabel();
/* 110 */     this.jLabel17 = new JLabel();
/* 111 */     this.jTextField2 = new JTextField();
/* 112 */     this.jPanel18 = new JPanel();
/* 113 */     this.jScrollPane2 = new JScrollPane();
/* 114 */     this.jTable1 = new JTable();
/* 115 */     this.jLabel48 = new JLabel();
/*     */     
/* 117 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 118 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 120 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 121 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 122 */     this.jLabel3.setText("DIESEL COMPLETADO");
/*     */     
/* 124 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 125 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*     */     
/* 127 */     this.jButton3.setMnemonic('F');
/* 128 */     this.jButton3.setText("Filtrar");
/* 129 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 130 */     this.jButton3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 132 */             DieselCompletado.this.jButton3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.jLabel4.setFont(new Font("Tahoma", 1, 14));
/* 137 */     this.jLabel4.setForeground(Color.red);
/* 138 */     this.jLabel4.setHorizontalAlignment(0);
/* 139 */     this.jLabel4.setText("AL");
/*     */     
/* 141 */     this.jLabel5.setFont(new Font("Tahoma", 1, 14));
/* 142 */     this.jLabel5.setForeground(Color.red);
/* 143 */     this.jLabel5.setText(" REPORTE DE VALES");
/*     */     
/* 145 */     this.jDateChooser4.setDate(this.fechaActual);
/* 146 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 147 */     this.jDateChooser4.setIcon(this.icon);
/* 148 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 149 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*     */     
/* 151 */     this.jDateChooser5.setDate(this.fechaActual);
/* 152 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 153 */     this.jDateChooser5.setIcon(this.icon);
/* 154 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 155 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*     */     
/* 157 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 158 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 159 */     this.jLabel7.setText("<html><u>Todos </u></html>");
/* 160 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 162 */             DieselCompletado.this.jLabel7MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 165 */             DieselCompletado.this.jLabel7MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 168 */             DieselCompletado.this.jLabel7MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 172 */     this.jLabel8.setFont(new Font("Tahoma", 2, 12));
/* 173 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/* 174 */     this.jLabel8.setHorizontalAlignment(0);
/* 175 */     this.jLabel8.setText("<html><u>Hoy</u></html>");
/* 176 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 178 */             DieselCompletado.this.jLabel8MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 181 */             DieselCompletado.this.jLabel8MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 184 */             DieselCompletado.this.jLabel8MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 188 */     this.jLabel9.setFont(new Font("Tahoma", 2, 12));
/* 189 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/* 190 */     this.jLabel9.setText("<html><u>Ayer</u></html>");
/* 191 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 193 */             DieselCompletado.this.jLabel9MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 196 */             DieselCompletado.this.jLabel9MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 199 */             DieselCompletado.this.jLabel9MouseExited(evt);
/*     */           }
/*     */         });
/*     */     
/* 203 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 204 */     this.jPanel2.setLayout(jPanel2Layout);
/* 205 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 206 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 207 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 208 */           .addComponent(this.jLabel5, -2, 146, -2)
/* 209 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 210 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 211 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 212 */           .addComponent(this.jLabel4, -2, 20, -2)
/* 213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 214 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 216 */           .addComponent(this.jButton3)
/* 217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 218 */           .addComponent(this.jLabel7, -2, -1, -2)
/* 219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 220 */           .addComponent(this.jLabel8, -2, 31, -2)
/* 221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 222 */           .addComponent(this.jLabel9, -2, 31, -2)
/* 223 */           .addContainerGap(17, 32767)));
/*     */     
/* 225 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 227 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 228 */           .addContainerGap()
/* 229 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 230 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 231 */               .addComponent(this.jButton3)
/* 232 */               .addComponent(this.jLabel7)
/* 233 */               .addComponent(this.jLabel8)
/* 234 */               .addComponent(this.jLabel9, -2, 15, -2))
/* 235 */             .addComponent(this.jLabel4, -1, -1, 32767)
/* 236 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 237 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 238 */               .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 239 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 240 */           .addContainerGap()));
/*     */ 
/*     */     
/* 243 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 244 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Vales ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 246 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 248 */             DieselCompletado.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 252 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 253 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 254 */     this.jLabel15.setHorizontalAlignment(0);
/* 255 */     this.jLabel15.setText("Folio");
/*     */     
/* 257 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/* 258 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 259 */     this.jLabel17.setHorizontalAlignment(0);
/* 260 */     this.jLabel17.setText("Liquidación");
/*     */     
/* 262 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 264 */             DieselCompletado.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 268 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 269 */     this.jPanel17.setLayout(jPanel17Layout);
/* 270 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 272 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 273 */           .addContainerGap()
/* 274 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 275 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 276 */             .addComponent(this.jTextField1, -1, 104, 32767))
/* 277 */           .addGap(18, 18, 18)
/* 278 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 279 */             .addComponent(this.jLabel17, -1, -1, 32767)
/* 280 */             .addComponent(this.jTextField2, -1, 114, 32767))
/* 281 */           .addContainerGap(754, 32767)));
/*     */     
/* 283 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 284 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 285 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 286 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 287 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 288 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 289 */               .addGap(8, 8, 8)
/* 290 */               .addComponent(this.jLabel15))
/* 291 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 292 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 293 */               .addGap(8, 8, 8)
/* 294 */               .addComponent(this.jLabel17)))
/* 295 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 298 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 299 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 301 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 302 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio Diesel", "Fecha", "Liquidación", "Empresa", "Litros", "Precio", "Total", "Guías" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 310 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 315 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 318 */     this.jTable1.setShowVerticalLines(false);
/* 319 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 321 */             DieselCompletado.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/* 324 */     this.jScrollPane2.setViewportView(this.jTable1);
/*     */     
/* 326 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 327 */     this.jLabel48.setForeground(Color.red);
/* 328 */     this.jLabel48.setHorizontalAlignment(0);
/* 329 */     this.jLabel48.setText("t");
/* 330 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 332 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 333 */     this.jPanel18.setLayout(jPanel18Layout);
/* 334 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 336 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 337 */           .addContainerGap()
/* 338 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 339 */             .addComponent(this.jScrollPane2, -1, 980, 32767)
/* 340 */             .addComponent(this.jLabel48, -2, 163, -2))
/* 341 */           .addContainerGap()));
/*     */     
/* 343 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 345 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 346 */           .addComponent(this.jLabel48)
/* 347 */           .addGap(4, 4, 4)
/* 348 */           .addComponent(this.jScrollPane2, -1, 129, 32767)
/* 349 */           .addContainerGap()));
/*     */ 
/*     */     
/* 352 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 353 */     this.jPanel6.setLayout(jPanel6Layout);
/* 354 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 355 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 356 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 357 */           .addContainerGap()
/* 358 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 359 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 360 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 361 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 362 */               .addComponent(this.jLabel3, -2, 273, -2))
/* 363 */             .addComponent(this.jPanel18, -1, -1, 32767)
/* 364 */             .addComponent(this.jPanel17, -1, -1, 32767))
/* 365 */           .addContainerGap()));
/*     */     
/* 367 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 369 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 370 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 371 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 372 */               .addContainerGap()
/* 373 */               .addComponent(this.jPanel2, -2, 44, -2))
/* 374 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 375 */               .addGap(21, 21, 21)
/* 376 */               .addComponent(this.jLabel3)))
/* 377 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 378 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 379 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 380 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 381 */           .addContainerGap()));
/*     */ 
/*     */     
/* 384 */     GroupLayout layout = new GroupLayout(this);
/* 385 */     setLayout(layout);
/* 386 */     layout.setHorizontalGroup(layout
/* 387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 388 */         .addGap(0, 1056, 32767)
/* 389 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 390 */           .addGroup(layout.createSequentialGroup()
/* 391 */             .addContainerGap()
/* 392 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 393 */             .addContainerGap())));
/*     */     
/* 395 */     layout.setVerticalGroup(layout
/* 396 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 397 */         .addGap(0, 362, 32767)
/* 398 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 399 */           .addGroup(layout.createSequentialGroup()
/* 400 */             .addContainerGap()
/* 401 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 402 */             .addContainerGap())));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 407 */     consultar();
/*     */   }
/*     */   
/*     */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 411 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 412 */     this.jDateChooser5.setDate(this.fechaActual);
/* 413 */     consultar();
/*     */   }
/*     */   
/*     */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 417 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel7MouseExited(MouseEvent evt) {
/* 421 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*     */   }
/*     */   
/*     */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 425 */     this.jDateChooser4.setDate(this.fechaActual);
/* 426 */     this.jDateChooser5.setDate(this.fechaActual);
/* 427 */     consultar();
/*     */   }
/*     */   
/*     */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 431 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel8MouseExited(MouseEvent evt) {
/* 435 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/*     */   }
/*     */   
/*     */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 439 */     Calendar ca = Calendar.getInstance();
/* 440 */     Calendar fecha = Calendar.getInstance();
/* 441 */     int aa = fecha.get(1);
/* 442 */     int mm = fecha.get(2);
/* 443 */     int dd = fecha.get(5);
/* 444 */     if (dd == 1) {
/* 445 */       if (mm == 0) {
/* 446 */         mm = 11;
/* 447 */         aa--;
/*     */       } else {
/* 449 */         mm--;
/*     */       } 
/* 451 */       int diasTotal = diasDelMes(mm, aa);
/* 452 */       dd = diasTotal;
/*     */     } else {
/* 454 */       dd--;
/*     */     } 
/* 456 */     mm++;
/* 457 */     String año = "" + aa;
/* 458 */     String mes = "" + mm;
/* 459 */     String dia = "" + dd;
/* 460 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 461 */     String strFecha = año + "-" + año + "-" + mes;
/*     */     try {
/* 463 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 464 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 465 */     } catch (ParseException ex) {
/* 466 */       ex.printStackTrace();
/*     */     } 
/* 468 */     consultar();
/*     */   }
/*     */   
/*     */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 472 */     this.jLabel9.setForeground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   private void jLabel9MouseExited(MouseEvent evt) {
/* 476 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 480 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 484 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   public int diasDelMes(int mes, int año) {
/* 492 */     switch (mes) {
/*     */       case 0:
/*     */       case 2:
/*     */       case 4:
/*     */       case 6:
/*     */       case 7:
/*     */       case 9:
/*     */       case 11:
/* 500 */         return 31;
/*     */       
/*     */       case 3:
/*     */       case 5:
/*     */       case 8:
/*     */       case 10:
/* 506 */         return 30;
/*     */       
/*     */       case 1:
/* 509 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*     */         {
/* 511 */           return 29;
/*     */         }
/* 513 */         return 28;
/*     */     } 
/*     */     
/* 516 */     return 0;
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 520 */     boolean correcto = true;
/* 521 */     if (this.jDateChooser4.getDate() == null) {
/* 522 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 523 */       if (res == 0) {
/* 524 */         this.jDateChooser4.setDate(this.fechaActual);
/* 525 */         correcto = true;
/*     */       } else {
/*     */         
/* 528 */         correcto = false;
/*     */       }
/*     */     
/* 531 */     } else if (this.jDateChooser5.getDate() == null) {
/* 532 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 533 */       if (res == 0) {
/* 534 */         this.jDateChooser5.setDate(this.fechaActual);
/* 535 */         correcto = true;
/*     */       } else {
/*     */         
/* 538 */         correcto = false;
/*     */       }
/*     */     
/* 541 */     } else if (correcto) {
/* 542 */       Date fecha1 = this.jDateChooser4.getDate();
/* 543 */       Date fecha2 = this.jDateChooser5.getDate();
/*     */       
/* 545 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 546 */       String cadenaFecha = "";
/* 547 */       cadenaFecha = formato.format(fecha1);
/* 548 */       String AÑO = cadenaFecha.substring(0, 4);
/* 549 */       String MES = cadenaFecha.substring(4, 6);
/* 550 */       String DIA = cadenaFecha.substring(6, 8);
/* 551 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*     */       
/* 553 */       cadenaFecha = formato.format(fecha2);
/* 554 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 555 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 556 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 557 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 558 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 559 */       String strFecha = "";
/* 560 */       if (diasTotal == dd) {
/* 561 */         dd = 1;
/* 562 */         if (mm == 11) {
/* 563 */           aa++;
/* 564 */           mm = 0;
/*     */         } else {
/*     */           
/* 567 */           mm++;
/*     */         } 
/*     */       } else {
/* 570 */         dd++;
/*     */       } 
/* 572 */       String año = "" + aa;
/* 573 */       String mes = "" + mm;
/* 574 */       String dia = "" + dd;
/* 575 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 576 */       strFecha = dia + "-" + dia + "-" + mes;
/* 577 */       String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*     */       
/* 579 */       String folio = this.jTextField1.getText();
/* 580 */       String liq = this.jTextField2.getText();
/*     */       
/* 582 */       this.encontrado = this.con.consultar("count(folio)", "vales_diesel", "where folio like '%" + folio + "%' and folio_liq like '%" + liq + "%' and vales_diesel.fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 583 */       int tot = Integer.parseInt(this.con.Campo);
/* 584 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + tot + "</HTML>");
/* 585 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 586 */             .buscarReg(8, tot, "folio,fecha,folio_liq,empresa,litros,precioLitroLetra,totalLetra,guias", "vales_diesel", "where folio like '%" + folio + "%' and folio_liq like '%" + liq + "%' and vales_diesel.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by folio desc"), (Object[])new String[] { "Folio", "Fecha", "Liquidación", "Empresa", "Litros", "Precio", "Total", "Guías a Comprobar" })
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 591 */             boolean[] canEdit = new boolean[] { 
/*     */                 false, false, false, false, false, false, false, false, false, false, 
/*     */                 false, false, false, false };
/*     */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 595 */               return this.canEdit[columnIndex];
/*     */             }
/*     */           });
/*     */       
/* 599 */       this.jTable1.setSelectionMode(0);
/* 600 */       this.jTable1.setAutoCreateRowSorter(true);
/* 601 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 602 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(70);
/* 603 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
/* 604 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 605 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 606 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(80);
/* 607 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
/* 608 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(150);
/* 609 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
/* 610 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(60);
/* 611 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
/* 612 */       this.jTable1.getColumnModel().getColumn(5).setMinWidth(80);
/* 613 */       this.jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
/* 614 */       this.jTable1.getColumnModel().getColumn(6).setMinWidth(80);
/* 615 */       this.jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
/*     */       
/* 617 */       this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 618 */       this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 619 */       this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 620 */       this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 621 */       this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 622 */       this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 623 */       this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 624 */       this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*     */     } 
/*     */   }
/*     */   public void colorear() {
/* 628 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 630 */             DieselCompletado.this.jTextGanado(DieselCompletado.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 633 */             DieselCompletado.this.jTextPerdido(DieselCompletado.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 636 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 638 */             DieselCompletado.this.jTextGanado(DieselCompletado.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 641 */             DieselCompletado.this.jTextPerdido(DieselCompletado.this.jTextField2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 646 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 649 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   class CeldaRender extends DefaultTableCellRenderer {
/* 653 */     int otro = -1;
/* 654 */     String[] indices = new String[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 656 */       setEnabled((table == null || table.isEnabled()));
/* 657 */       String comp = String.valueOf(table.getValueAt(row, 0));
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
/* 670 */       if (row % 2 == 0) {
/* 671 */         setBackground(new Color(194, 213, 151));
/* 672 */         setForeground(Color.black);
/*     */       } else {
/*     */         
/* 675 */         setBackground((Color)null);
/* 676 */         setForeground(Color.black);
/*     */       } 
/* 678 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 679 */       return this;
/*     */     }
/*     */     public void pasarInd(String[] ind) {
/* 682 */       this.indices = ind;
/*     */     }
/*     */     public boolean comparar(String reg) {
/* 685 */       for (int i = 0; i < this.indices.length; i++) {
/* 686 */         if (this.indices[i].equals(reg)) {
/* 687 */           return true;
/*     */         }
/*     */       } 
/* 690 */       return false;
/*     */     }
/*     */   }
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
/*     */   public void dieselCompletado(String usu) {
/* 717 */     this.USUARIO = usu;
/* 718 */     this.panel.setViewportView(this);
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DieselCompletado.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */