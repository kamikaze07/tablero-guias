/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.time.LocalDate;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.InputMap;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ import utilerias.Utilerias;
/*     */ 
/*     */ public class DatosUnidades extends JDialog {
/*  27 */   String TIPO = "";
/*  28 */   String ECO = "";
/*  29 */   String ESTADO = "";
/*  30 */   SColores lc = new SColores();
/*  31 */   Fuentes fuentes = new Fuentes();
/*     */   private int xx;
/*     */   private int xy;
/*  34 */   Utilerias utilerias = new Utilerias();
/*  35 */   Consultas2 con = new Consultas2();
/*  36 */   int DIASVENCIMIENTO = 0;
/*     */   boolean entra1 = false;
/*  38 */   Map<String, String> DOC = new TreeMap<>();
/*     */   boolean diferenteEstado = false;
/*  40 */   CeldaRender celda1 = new CeldaRender();
/*  41 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*  42 */   Frame padre = null;
/*  43 */   DatosEnviarCorreo enviar = new DatosEnviarCorreo();
/*     */   String GUIA;
/*  45 */   String CONTENIDOTABLA = ""; private JLabel jLabel124; private JLabel jLabel128; private JLabel jLabel33; private JLabel jLabel35; private JLabel jLabel68; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JPanel jPanel1; private JPanel jPanel2; private JPanel jPanel3;
/*     */   
/*     */   public DatosUnidades(Frame parent, boolean modal, String TIPO, String ECO, String ESTADO, int DIASVENCIMIENTO, DatosEnviarCorreo enviar, String GUIA) {
/*  48 */     super(parent, modal);
/*  49 */     this.padre = parent;
/*  50 */     this.GUIA = GUIA;
/*  51 */     this.enviar = enviar;
/*  52 */     this.TIPO = TIPO;
/*  53 */     this.ECO = ECO;
/*  54 */     this.ESTADO = ESTADO;
/*  55 */     this.DIASVENCIMIENTO = DIASVENCIMIENTO;
/*  56 */     initComponents();
/*  57 */     this.jPanel7.removeAll();
/*     */     
/*  59 */     conusltaGralTabla();
/*  60 */     if (this.ESTADO.equals("ACTIVO")) {
/*  61 */       unidadActiva();
/*     */     } else {
/*  63 */       unidadDesactivada();
/*     */     } 
/*     */   }
/*     */   private JPanel jPanel46; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel52; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel9; private JScrollPane jScrollPane1;
/*     */   private MaterialButton materialButton2;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   private void initComponents() {
/*  71 */     this.jPanel1 = new JPanel();
/*  72 */     this.jPanel2 = new JPanel();
/*  73 */     this.jPanel52 = new JPanel();
/*  74 */     this.jLabel68 = new JLabel();
/*  75 */     this.jPanel3 = new JPanel();
/*  76 */     this.jPanel5 = new JPanel();
/*  77 */     this.jPanel6 = new JPanel();
/*  78 */     this.jPanel50 = new JPanel();
/*  79 */     this.jLabel33 = new JLabel();
/*  80 */     this.jPanel80 = new JPanel();
/*  81 */     this.jLabel128 = new JLabel();
/*  82 */     this.jLabel35 = new JLabel();
/*  83 */     this.jPanel7 = new JPanel();
/*  84 */     this.jPanel8 = new JPanel();
/*  85 */     this.jLabel71 = new JLabel();
/*  86 */     this.jLabel73 = new JLabel();
/*  87 */     this.jLabel124 = new JLabel();
/*  88 */     this.jPanel9 = new JPanel();
/*  89 */     this.jLabel72 = new JLabel();
/*  90 */     this.jScrollPane1 = new JScrollPane();
/*  91 */     this.rSTableMetro1 = new RSTableMetro();
/*  92 */     this.jPanel46 = new JPanel();
/*  93 */     this.materialButton2 = new MaterialButton();
/*     */     
/*  95 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*     */     
/*  97 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*     */     
/*  99 */     this.jPanel52.setBackground(this.lc.SECUNDARIO2);
/* 100 */     this.jPanel52.setLayout(new GridLayout(1, 0));
/*     */     
/* 102 */     this.jLabel68.setFont(new Font("Quicksand", 1, 17));
/* 103 */     this.jLabel68.setHorizontalAlignment(0);
/* 104 */     this.jLabel68.setText("RECORDATORIO");
/* 105 */     this.jPanel52.add(this.jLabel68);
/*     */     
/* 107 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/* 108 */     this.jPanel3.setLayout(new GridLayout(1, 0));
/*     */     
/* 110 */     this.jPanel5.setBackground(new Color(255, 255, 255));
/*     */     
/* 112 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 113 */     this.jPanel5.setLayout(jPanel5Layout);
/* 114 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 115 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 116 */         .addGap(0, 542, 32767));
/*     */     
/* 118 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 119 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 120 */         .addGap(0, 358, 32767));
/*     */ 
/*     */     
/* 123 */     this.jPanel3.add(this.jPanel5);
/*     */     
/* 125 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 126 */     this.jPanel2.setLayout(jPanel2Layout);
/* 127 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */         .addComponent(this.jPanel52, -1, -1, 32767)
/* 130 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*     */     
/* 132 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 133 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 134 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 135 */           .addComponent(this.jPanel52, -2, 38, -2)
/* 136 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 137 */           .addComponent(this.jPanel3, -1, -1, 32767)));
/*     */ 
/*     */     
/* 140 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 141 */     this.jPanel1.setLayout(jPanel1Layout);
/* 142 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 144 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/* 146 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 147 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 148 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 149 */           .addComponent(this.jPanel2, -1, -1, 32767)
/* 150 */           .addGap(44, 44, 44)));
/*     */ 
/*     */     
/* 153 */     setDefaultCloseOperation(2);
/* 154 */     setUndecorated(true);
/*     */     
/* 156 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/* 157 */     this.jPanel6.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*     */     
/* 159 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 161 */     this.jLabel33.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 162 */     this.jLabel33.setForeground(new Color(255, 255, 255));
/* 163 */     this.jLabel33.setHorizontalAlignment(0);
/* 164 */     this.jLabel33.setText("Recordatorio");
/* 165 */     this.jLabel33.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent evt) {
/* 167 */             DatosUnidades.this.jLabel33MouseDragged(evt);
/*     */           }
/*     */         });
/* 170 */     this.jLabel33.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 172 */             DatosUnidades.this.jLabel33MouseClicked(evt);
/*     */           }
/*     */         });
/*     */     
/* 176 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/* 177 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*     */     
/* 179 */     this.jLabel128.setHorizontalAlignment(0);
/* 180 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 181 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 183 */             DatosUnidades.this.jLabel128MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 186 */             DatosUnidades.this.jLabel128MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 189 */             DatosUnidades.this.jLabel128MouseExited(evt);
/*     */           }
/*     */         });
/* 192 */     this.jPanel80.add(this.jLabel128);
/*     */     
/* 194 */     this.jLabel35.setHorizontalAlignment(0);
/* 195 */     this.jLabel35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/calendar.png")));
/*     */     
/* 197 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 198 */     this.jPanel50.setLayout(jPanel50Layout);
/* 199 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 200 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 201 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 202 */           .addGap(1, 1, 1)
/* 203 */           .addComponent(this.jLabel35, -2, 36, -2)
/* 204 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 205 */           .addComponent(this.jLabel33, -1, -1, 32767)
/* 206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 207 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*     */     
/* 209 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 210 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 211 */         .addComponent(this.jPanel80, -1, -1, 32767)
/* 212 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 213 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 214 */             .addComponent(this.jLabel35, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 215 */             .addComponent(this.jLabel33, -2, 30, -2))
/* 216 */           .addGap(0, 0, 32767)));
/*     */ 
/*     */     
/* 219 */     this.jPanel7.setBackground(new Color(255, 255, 255));
/* 220 */     this.jPanel7.setLayout(new GridLayout(2, 1, 0, 6));
/*     */     
/* 222 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 224 */     this.jLabel71.setHorizontalAlignment(0);
/* 225 */     this.jLabel71.setText("La unidad que seleccionaste se encuentra: ");
/*     */     
/* 227 */     this.jLabel73.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 20.0F));
/* 228 */     this.jLabel73.setForeground(this.lc.PRIMARIO1);
/* 229 */     this.jLabel73.setHorizontalAlignment(0);
/* 230 */     this.jLabel73.setText("'" + this.ESTADO + "'");
/*     */     
/* 232 */     this.jLabel124.setFont(new Font("Quicksand", 0, 15));
/* 233 */     this.jLabel124.setForeground(this.lc.SECUNDARIO1);
/* 234 */     this.jLabel124.setText("<html><center>ES NECESARIO REVISAR LA DOCUMENTACIÓN Y GENERAR LA CARPETA PARA EL OPERADOR</center></html>");
/*     */     
/* 236 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 237 */     this.jPanel8.setLayout(jPanel8Layout);
/* 238 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 239 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 240 */         .addComponent(this.jLabel71, -1, -1, 32767)
/* 241 */         .addComponent(this.jLabel73, -1, 574, 32767)
/* 242 */         .addComponent(this.jLabel124, -1, 574, 32767));
/*     */     
/* 244 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 245 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 246 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 247 */           .addComponent(this.jLabel71)
/* 248 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 249 */           .addComponent(this.jLabel73, -2, 50, -2)
/* 250 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 251 */           .addComponent(this.jLabel124, -2, 53, -2)
/* 252 */           .addGap(0, 16, 32767)));
/*     */ 
/*     */     
/* 255 */     this.jPanel7.add(this.jPanel8);
/*     */     
/* 257 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*     */     
/* 259 */     this.jLabel72.setText("A continuación se adjuntan algunos documentos que se encuentran vencidos:");
/*     */     
/* 261 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Informacion", "Numero", "Vencimiento", "Estado" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 269 */     this.rSTableMetro1.setAltoHead(25);
/* 270 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 271 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 272 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 273 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 274 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 275 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 276 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 277 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 278 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 279 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 280 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 281 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 282 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 283 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 284 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 286 */             DatosUnidades.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 289 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 291 */             DatosUnidades.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 294 */     this.jScrollPane1.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 296 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 297 */     this.jPanel9.setLayout(jPanel9Layout);
/* 298 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 299 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 300 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 301 */           .addContainerGap()
/* 302 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 303 */             .addComponent(this.jScrollPane1, -1, 562, 32767)
/* 304 */             .addComponent(this.jLabel72, -1, -1, 32767))
/* 305 */           .addContainerGap()));
/*     */     
/* 307 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 308 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 309 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 310 */           .addContainerGap()
/* 311 */           .addComponent(this.jLabel72)
/* 312 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 313 */           .addComponent(this.jScrollPane1, -1, 119, 32767)));
/*     */ 
/*     */     
/* 316 */     this.jPanel7.add(this.jPanel9);
/*     */     
/* 318 */     this.jPanel46.setBackground(new Color(255, 255, 255));
/*     */     
/* 320 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/* 321 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/* 322 */     this.materialButton2.setMnemonic('C');
/* 323 */     this.materialButton2.setText("Cerrar");
/* 324 */     this.materialButton2.setToolTipText("Cerrar (Al t + C)");
/* 325 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/* 326 */     this.materialButton2.setHorizontalTextPosition(0);
/* 327 */     this.materialButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 329 */             DatosUnidades.this.materialButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 333 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 334 */     this.jPanel46.setLayout(jPanel46Layout);
/* 335 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
/* 338 */           .addContainerGap(-1, 32767)
/* 339 */           .addComponent((Component)this.materialButton2, -2, 105, -2)));
/*     */     
/* 341 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 342 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 343 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
/* 344 */           .addGap(0, 0, 32767)
/* 345 */           .addComponent((Component)this.materialButton2, -2, 38, -2)));
/*     */ 
/*     */     
/* 348 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 349 */     this.jPanel6.setLayout(jPanel6Layout);
/* 350 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 352 */         .addComponent(this.jPanel50, -1, -1, 32767)
/* 353 */         .addComponent(this.jPanel46, -1, -1, 32767)
/* 354 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*     */     
/* 356 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 358 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 359 */           .addComponent(this.jPanel50, -2, -1, -2)
/* 360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 361 */           .addComponent(this.jPanel7, -1, 299, 32767)
/* 362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 363 */           .addComponent(this.jPanel46, -2, -1, -2)));
/*     */ 
/*     */     
/* 366 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 367 */     getContentPane().setLayout(layout);
/* 368 */     layout.setHorizontalGroup(layout
/* 369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 370 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*     */     
/* 372 */     layout.setVerticalGroup(layout
/* 373 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 374 */         .addComponent(this.jPanel6, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */ 
/*     */     
/* 377 */     pack();
/*     */   }
/*     */   
/*     */   private void materialButton2ActionPerformed(ActionEvent evt) {
/* 381 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 385 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 386 */     if (evt.getClickCount() == 2) {
/* 387 */       String valor = this.rSTableMetro1.getValueAt(ind, 0).toString();
/* 388 */       if (!valor.contains("FACTURA")) {
/* 389 */         UnidadesTractosDoc unidad = new UnidadesTractosDoc(this.padre, true, this.rSTableMetro1, null, null, this.rSTableMetro1.getValueAt(ind, 2).toString(), "VISUALIZAR");
/* 390 */         unidad.consultarDoc(this.rSTableMetro1.getValueAt(ind, 0).toString());
/* 391 */         unidad.desabilitar();
/* 392 */         unidad.activarVentana();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jLabel33MouseDragged(MouseEvent evt) {
/* 402 */     int x = evt.getXOnScreen();
/* 403 */     int y = evt.getYOnScreen();
/* 404 */     setLocation(x - this.xx, y - this.xy);
/*     */   }
/*     */   
/*     */   private void jLabel33MouseClicked(MouseEvent evt) {
/* 408 */     this.xx = evt.getX();
/* 409 */     this.xy = evt.getY();
/*     */   }
/*     */   
/*     */   private void jLabel128MouseClicked(MouseEvent evt) {
/* 413 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void jLabel128MouseEntered(MouseEvent evt) {
/* 417 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*     */   }
/*     */   
/*     */   private void jLabel128MouseExited(MouseEvent evt) {
/* 421 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*     */   }
/*     */   
/*     */   protected JRootPane createRootPane() {
/* 425 */     JRootPane rootPane = new JRootPane();
/* 426 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 427 */     Action actionListener = new AbstractAction() {
/*     */         public void actionPerformed(ActionEvent actionEvent) {
/* 429 */           DatosUnidades.this.setVisible(false);
/*     */         }
/*     */       };
/* 432 */     InputMap inputMap = rootPane.getInputMap(2);
/* 433 */     inputMap.put(stroke, "ESCAPE");
/* 434 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 435 */     return rootPane;
/*     */   }
/*     */   
/*     */   public void unidadActiva() {
/* 439 */     this.jPanel8.setVisible(false);
/* 440 */     this.jPanel7.setLayout(new GridLayout(1, 1));
/* 441 */     this.jPanel7.add(this.jPanel9);
/*     */     
/* 443 */     LocalDate fecha = LocalDate.now();
/* 444 */     fecha = fecha.plusDays(this.DIASVENCIMIENTO);
/* 445 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 446 */       String vencimiento = this.rSTableMetro1.getValueAt(i, 3).toString();
/* 447 */       if (!vencimiento.equals("ÚNICO")) {
/* 448 */         String fechita = this.rSTableMetro1.getValueAt(i, 4).toString();
/* 449 */         LocalDate f = LocalDate.parse(fechita);
/* 450 */         if (fecha.isAfter(f)) {
/* 451 */           this.DOC.put(this.rSTableMetro1.getValueAt(i, 0).toString(), this.rSTableMetro1.getValueAt(i, 4).toString());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 456 */     if (!this.DOC.isEmpty()) {
/* 457 */       crearContenidoTabla();
/* 458 */       this.enviar.setEnviarCorreo(true);
/* 459 */       this.enviar.setTipo("ECO");
/* 460 */       this.enviar.setAsunto("VER - Documentación Vencida UNIDAD F" + this.ECO);
/* 461 */       String MensajePrincipal = "<font size=\"2\" style=\"font-size: 10pt\">Se ha generado en el SICRET la </font><font size=\"2\" style=\"font-size: 10pt\"><b>GUIA\n" + this.GUIA + "</b></font><font size=\"2\" style=\"font-size: 10pt\"> con la\nunidad </font><font size=\"2\" style=\"font-size: 10pt\"><b>F" + this.ECO + "</b></font><font size=\"2\" style=\"font-size: 10pt\">\n, algunos documentos se encuentran vencidos y se enlistan a continuaci&oacuten\n";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 466 */       this.enviar.setContenido(crearCorreo(MensajePrincipal));
/*     */       
/* 468 */       this.jLabel72.setText("Se adjuntan algunos documentos que se encuentran vencidos o por vencer:");
/* 469 */       this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/* 470 */       setVisible(true);
/*     */     }
/* 472 */     else if (this.rSTableMetro1.getRowCount() == 0) {
/* 473 */       this.enviar.setEnviarCorreo(true);
/* 474 */       this.enviar.setTipo("ECO");
/* 475 */       this.enviar.setAsunto("VER - Sin Documentación UNIDAD F" + this.ECO);
/*     */       
/* 477 */       String MensajePrincipal = "<font size=\"2\" style=\"font-size: 10pt\">Se ha generado en el SICRET la </font><font size=\"2\" style=\"font-size: 10pt\"><b>GUIA\n" + this.GUIA + "</b></font><font size=\"2\" style=\"font-size: 10pt\"> con la\nunidad </font><font size=\"2\" style=\"font-size: 10pt\"><b>F" + this.ECO + "</b></font><font size=\"2\" style=\"font-size: 10pt\">\ny al parecer no tiene documentos activos, por favor revisar y actualizar la documentaci&oacuten.\n";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       this.enviar.setContenido(crearCorreo(MensajePrincipal));
/*     */       
/* 484 */       this.jLabel72.setText("La unidad seleccionada no cuenta con documentación, se enviará correo informativo");
/* 485 */       setVisible(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void crearContenidoTabla() {
/* 490 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 491 */       if (this.DOC.containsKey(this.rSTableMetro1.getValueAt(i, 0))) {
/* 492 */         this
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
/* 506 */           .CONTENIDOTABLA = this.CONTENIDOTABLA + "<tr valign=\"top\">\n             <td width=\"21%\" style=\"border-top: none; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: 1px solid #999999; padding-top: 0cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"justify\">\n\t\t\t<font size=\"2\" style=\"font-size: 10pt\">" + this.CONTENIDOTABLA + "</font></p>\n\t\t</td>\n\t\t<td width=\"13%\" style=\"border-top: none; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: 1px solid #999999;; padding-top: 0cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"justify\">\n\t\t\t<font size=\"2\" style=\"font-size: 10pt\">" + String.valueOf(this.rSTableMetro1.getValueAt(i, 1)) + "</font></p>\n\t\t</td>\n\t\t<td width=\"12%\" style=\"border-top: none; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: 1px solid #999999;; padding-top: 0cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"justify\">\n\t\t\t<font size=\"2\" style=\"font-size: 10pt\">" + String.valueOf(this.rSTableMetro1.getValueAt(i, 2)) + "</font></p>\n\t\t</td>\n\t\t<td width=\"19%\" style=\"border-top: none; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: 1px solid #999999;; padding-top: 0cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"justify\">\n\t\t\t<font size=\"2\" style=\"font-size: 10pt\">" + String.valueOf(this.rSTableMetro1.getValueAt(i, 3)) + "</font></p>\n\t\t</td>\n\t\t<td width=\"25%\" style=\"border-top: none; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: 1px solid #999999;; padding-top: 0cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"justify\">\n\t\t\t<font size=\"2\" style=\"font-size: 10pt\">" + String.valueOf(this.rSTableMetro1.getValueAt(i, 4)) + "</font></p>\n\t\t</td>\n";
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unidadDesactivada() {
/* 513 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 514 */       this.DOC.put(this.rSTableMetro1.getValueAt(i, 0).toString(), this.rSTableMetro1.getValueAt(i, 4).toString());
/*     */     }
/* 516 */     crearContenidoTabla();
/* 517 */     this.enviar.setEnviarCorreo(true);
/* 518 */     this.enviar.setTipo("ECO");
/* 519 */     this.enviar.setAsunto("VER - Unidad F" + this.ECO + " en " + this.ESTADO);
/*     */     
/* 521 */     String MensajePrincipal = "<font size=\"2\" style=\"font-size: 10pt\">Se ha generado en el SICRET la </font><font size=\"2\" style=\"font-size: 10pt\"><b>GUIA\n" + this.GUIA + "</b></font><font size=\"2\" style=\"font-size: 10pt\"> con la\nunidad </font><font size=\"2\" style=\"font-size: 10pt\"><b>F" + this.ECO + "</b></font><font size=\"2\" style=\"font-size: 10pt\">\nen estado <font size=\"2\" style=\"font-size: 10pt\"><b>" + this.ESTADO + "</b></font> </font><font size=\"2\" style=\"font-size: 10pt\">\nPor favor revisar la documentaci&oacuten.\n";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 527 */     this.enviar.setContenido(crearCorreo(MensajePrincipal));
/*     */     
/* 529 */     this.jPanel8.setVisible(true);
/* 530 */     this.jPanel7.setLayout(new GridLayout(2, 1, 0, 6));
/* 531 */     this.jPanel7.add(this.jPanel8);
/* 532 */     this.jPanel7.add(this.jPanel9);
/* 533 */     this.jPanel7.repaint();
/* 534 */     this.jLabel72.setText("A continuación se enlistan los documentos asignados a esta unidad...");
/* 535 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public void conusltaGralTabla() {
/* 539 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "ID", "Información", "Número", "Periodo", "Vencimiento", "Estado" }, "unidadesdocumentos.numDoc, unidadesdocumentos.tipo, unidadesdocumentos.numeroUnico, unidadesdocumentos.periodoVencimiento, unidadesdocumentos.fechaVencimiento, unidadesdocumentos.estado", "tracto, unidadesdocumentos, unidadesdoctractos", "where tracto.num_tracto = unidadesdoctractos.num_tracto and unidadesdocumentos.numDoc = unidadesdoctractos.numDoc and tracto.num_tracto = " + this.ECO + " and unidadesdocumentos.estado = 'ACTIVO' order by unidadesdocumentos.numDoc desc");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 549 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 550 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 4, 100);
/* 551 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 60);
/*     */   }
/*     */   
/*     */   public String crearCorreo(String MensajePrincipal) {
/* 555 */     String Contenido = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n\t<title></title>\n\t<meta name=\"generator\" content=\"LibreOffice 7.0.2.2 (Linux)\"/>\n\t<meta name=\"created\" content=\"2021-01-26T12:25:39.515246406\"/>\n\t<meta name=\"changed\" content=\"2021-01-26T12:31:19.226123013\"/>\n\t<style type=\"text/css\">\n\t\t@page { size: 21.59cm 27.94cm; margin: 2cm }\n\t\tp { margin-bottom: 0.25cm; line-height: 115%; background: transparent }\n\t\ttd p { orphans: 0; widows: 0; background: transparent }\n\t\ta:link { color: #000080; so-language: zxx; text-decoration: underline }\n\t\ta:visited { color: #800000; so-language: zxx; text-decoration: underline }\n\t</style>\n</head>\n<body lang=\"es-US\" link=\"#000080\" vlink=\"#800000\" dir=\"ltr\"><p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" + MensajePrincipal + "<p lang=\"es-ES-u-co-trad\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n<br/>\n\n</p>\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\n\t<col width=\"52*\"/>\n\n\t<col width=\"33*\"/>\n\n\t<col width=\"57*\"/>\n\n\t<col width=\"49*\"/>\n\n\t<col width=\"64*\"/>\n\n\t<tr valign=\"top\">\n\t\t<td width=\"21%\" bgcolor=\"#ff4000\" style=\"background: #FE0018\" style=\"border-top: 2px solid #999999; border-bottom: 2px solid #999999; border-left: 1px solid #999999; border-right: none; padding-top: 0.2cm; padding-bottom: 0.2cm; padding-left: 0.2cm; padding-right: 0.2cm\"><p align=\"center\">\n\t\t\t<font size=\"2\" style=\"font-size: 11pt\"><b><span style=\"background: transparent\">INFORMACI&OacuteN</span></b></font></p>\n\t\t</td>\n\t\t<td width=\"13%\" bgcolor=\"#ff4000\" style=\"background: #FE0018\" style=\"border-top: 1px solid #999999; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: none; padding-top: 0.1cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"center\">\n\t\t\t<font size=\"2\" style=\"font-size: 11pt\"><b><span style=\"background: transparent\">N&UacuteMERO</span></b></font></p>\n\t\t</td>\n\t\t<td width=\"22%\" bgcolor=\"#ff4000\" style=\"background: #FE0018\" style=\"border-top: 1px solid #999999; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: none; padding-top: 0.1cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"center\">\n\t\t\t<font size=\"2\" style=\"font-size: 11pt\"><b><span style=\"background: transparent\">PERIODO</span></b></font></p>\n\t\t</td>\n\t\t<td width=\"19%\" bgcolor=\"#ff4000\" style=\"background: #FE0018\" style=\"border-top: 1px solid #999999; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: none; padding-top: 0.1cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"center\">\n\t\t\t<font size=\"2\" style=\"font-size: 11pt\"><b><span style=\"background: transparent\">VENCIMIENTO</span></b></font></p>\n\t\t</td>\n\t\t<td width=\"25%\" bgcolor=\"#ff4000\" style=\"background: #FE0018\" style=\"border-top: 1px solid #999999; border-bottom: 1px solid #999999; border-left: 1px solid #999999; border-right: none; padding-top: 0.1cm; padding-bottom: 0.1cm; padding-left: 0.1cm; padding-right: 0cm\"><p align=\"center\">\n\t\t\t<font size=\"2\" style=\"font-size: 11pt\"><b><span style=\"background: transparent\">ESTADO</span></b></font></p>\n\t\t</td>\n\t</tr>\n" + this.CONTENIDOTABLA + "\n</table>\n<p lang=\"es-ES-u-co-trad\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n<br/>\n\n</p>\n<p lang=\"es-ES-u-co-trad\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n<br/>\n\n</p>\n<p lang=\"es-ES-u-co-trad\" align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\">\n<br/>\n\n</p>\n<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font size=\"2\" style=\"font-size: 10pt\">Vis&iacutetanos\nen </font><font color=\"#000080\"><span lang=\"zxx\"><u><font size=\"2\" style=\"font-size: 10pt\"><span lang=\"es-ES-u-co-trad\"><a href=\"http://www.forsis.com.mx/\">www.forsis.com.mx</a>\n</span></font></u></span></font>\n</p>\n<p align=\"justify\" style=\"margin-bottom: 0cm; line-height: 100%\"><font color=\"#ff0000\"><font size=\"2\" style=\"font-size: 9pt\"><i>Nota:\nFavor de no responder a la direcci&oacuten remitente, ya que es enviado\ncon el sistema de Grupo Forsis.</i></font></font></p>\n<p style=\"margin-bottom: 0cm; line-height: 100%\"><br/>\n\n</p>\n</body>\n</html>";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 634 */     return Contenido;
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer {
/* 639 */     int otro = -1;
/* 640 */     String[] indices = new String[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 643 */       setEnabled((table == null || table.isEnabled()));
/* 644 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*     */       
/* 646 */       if (DatosUnidades.this.DOC.containsKey(comp)) {
/* 647 */         setBackground(Color.red);
/* 648 */         setForeground(Color.white);
/*     */       } else {
/* 650 */         setBackground(Color.WHITE);
/* 651 */         setForeground(DatosUnidades.this.lc.SECUNDARIO1);
/*     */       } 
/*     */       
/* 654 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 655 */       return this;
/*     */     }
/*     */     
/*     */     public void pasarInd(String[] ind) {
/* 659 */       this.indices = ind;
/*     */     }
/*     */     
/*     */     public boolean comparar(String reg) {
/* 663 */       for (int i = 0; i < this.indices.length; i++) {
/* 664 */         if (this.indices[i].equals(reg)) {
/* 665 */           return true;
/*     */         }
/*     */       } 
/* 668 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DatosUnidades.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */