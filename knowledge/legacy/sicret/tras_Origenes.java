/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class tras_Origenes extends JPanel {
/*  18 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  19 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  20 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  21 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  22 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  23 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  27 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  28 */   Utilerias utilerias = new Utilerias();
/*     */   JFrame padre;
/*  30 */   String USUARIO = "";
/*     */   JTabbedPane fichas;
/*  32 */   Consultas2 con = new Consultas2();
/*  33 */   Consultas2 con2 = new Consultas2();
/*  34 */   SColores lc = new SColores();
/*     */   Map<String, String> CAMPOSGENERALES;
/*  36 */   Fuentes fuentes = new Fuentes();
/*  37 */   PlaceHolder placeHolder = null;
/*  38 */   String holderId = "ID";
/*  39 */   String holderNombre = "NOMBRE";
/*  40 */   String holderCiudad = "CIUDAD";
/*  41 */   String holderCliente = "CLIENTE";
/*  42 */   pintarComponentes pintar = new pintarComponentes();
/*     */   boolean actualizado = false;
/*  44 */   List<Tras_codigos> CODIGOSP = new ArrayList<>();
/*  45 */   ArrayList LISTACODIGOS = new ArrayList();
/*  46 */   TextAutoCompleter com_ListaCodigos = null;
/*     */   boolean entraPrimera = false;
/*     */   boolean PRIMERA = false;
/*  49 */   CeldaRender1 celda1 = new CeldaRender1(); EscribirReporte esc; private JButton jButton1; private JButton jButton2; private JButton jButton4; private JComboBox jComboBox1; private JLabel jLabel100; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel2; private JPanel jPanel35; private JPanel jPanel9; private JScrollPane jScrollPane13;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public tras_Origenes(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*  57 */     this.con2.setBaseDatos("sicre2PR");
/*  58 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*     */     
/*  60 */     this.padre = padre;
/*  61 */     this.fichas = fichas;
/*  62 */     this.USUARIO = USUARIO;
/*  63 */     this.panel = panelito;
/*  64 */     this.LISTACODIGOS = LISTACODIGOS;
/*  65 */     this.CODIGOSP = CODIGOSP;
/*  66 */     this.panel.setViewportView(this);
/*  67 */     initComponents();
/*     */     
/*  69 */     colorear();
/*  70 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderId, false, "Century Gothic", 11);
/*  71 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderNombre, false, "Century Gothic", 11);
/*  72 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCiudad, false, "Century Gothic", 11);
/*  73 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderCliente, false, "Century Gothic", 11);
/*     */     
/*  75 */     llenarComboEstados();
/*  76 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  84 */     this.jPanel2 = new JPanel();
/*  85 */     this.jPanel9 = new JPanel();
/*  86 */     this.jPanel10 = new JPanel();
/*  87 */     this.jLabel98 = new JLabel();
/*  88 */     this.jPanel35 = new JPanel();
/*  89 */     this.jTextField1 = new JTextField();
/*  90 */     this.jTextField2 = new JTextField();
/*  91 */     this.jTextField3 = new JTextField();
/*  92 */     this.jTextField4 = new JTextField();
/*  93 */     this.jComboBox1 = new JComboBox();
/*  94 */     this.jPanel11 = new JPanel();
/*  95 */     this.jPanel12 = new JPanel();
/*  96 */     this.jPanel15 = new JPanel();
/*  97 */     this.jLabel99 = new JLabel();
/*  98 */     this.jLabel100 = new JLabel();
/*  99 */     this.jPanel14 = new JPanel();
/* 100 */     this.jPanel16 = new JPanel();
/* 101 */     this.jButton1 = new JButton();
/* 102 */     this.jButton2 = new JButton();
/* 103 */     this.jButton4 = new JButton();
/* 104 */     this.jPanel1 = new JPanel();
/* 105 */     this.jScrollPane13 = new JScrollPane();
/* 106 */     this.rSTableMetro1 = new RSTableMetro();
/*     */     
/* 108 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 109 */     this.jPanel2.setLayout(jPanel2Layout);
/* 110 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 111 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 112 */         .addGap(0, 738, 32767));
/*     */     
/* 114 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 115 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 116 */         .addGap(0, 267, 32767));
/*     */ 
/*     */     
/* 119 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 121 */     this.jPanel10.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 123 */     this.jLabel98.setFont(new Font("Cantarell", 1, 22));
/* 124 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/* 125 */     this.jLabel98.setHorizontalAlignment(0);
/* 126 */     this.jLabel98.setText("Origenes");
/*     */     
/* 128 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 129 */     this.jPanel10.setLayout(jPanel10Layout);
/* 130 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 131 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 132 */         .addComponent(this.jLabel98, -1, -1, 32767));
/*     */     
/* 134 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 136 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 137 */           .addContainerGap()
/* 138 */           .addComponent(this.jLabel98)
/* 139 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 142 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 143 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*     */     
/* 145 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 147 */             tras_Origenes.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/* 150 */     this.jPanel35.add(this.jTextField1);
/*     */     
/* 152 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 154 */             tras_Origenes.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/* 157 */     this.jPanel35.add(this.jTextField2);
/*     */     
/* 159 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 161 */             tras_Origenes.this.jTextField3KeyReleased(evt);
/*     */           }
/*     */         });
/* 164 */     this.jPanel35.add(this.jTextField3);
/*     */     
/* 166 */     this.jTextField4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 168 */             tras_Origenes.this.jTextField4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 171 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 173 */             tras_Origenes.this.jTextField4KeyReleased(evt);
/*     */           }
/*     */         });
/* 176 */     this.jPanel35.add(this.jTextField4);
/*     */     
/* 178 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 179 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ESTADO" }));
/* 180 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 182 */             tras_Origenes.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 185 */     this.jPanel35.add(this.jComboBox1);
/*     */     
/* 187 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 189 */     this.jPanel12.setBackground(this.lc.SECUNDARIO2);
/* 190 */     this.jPanel12.setLayout(new GridLayout(1, 6, 6, 0));
/*     */     
/* 192 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 193 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 195 */     this.jLabel99.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 196 */     this.jLabel99.setForeground(this.lc.SECUNDARIO1);
/* 197 */     this.jLabel99.setHorizontalAlignment(4);
/* 198 */     this.jLabel99.setText("Total");
/* 199 */     this.jPanel15.add(this.jLabel99);
/*     */     
/* 201 */     this.jLabel100.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 202 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 203 */     this.jLabel100.setHorizontalAlignment(2);
/* 204 */     this.jLabel100.setText("t");
/* 205 */     this.jPanel15.add(this.jLabel100);
/*     */     
/* 207 */     this.jPanel12.add(this.jPanel15);
/*     */     
/* 209 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 211 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 212 */     this.jPanel14.setLayout(jPanel14Layout);
/* 213 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 214 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 215 */         .addGap(0, 61, 32767));
/*     */     
/* 217 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 218 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 219 */         .addGap(0, 37, 32767));
/*     */ 
/*     */     
/* 222 */     this.jPanel12.add(this.jPanel14);
/*     */     
/* 224 */     this.jPanel16.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 226 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 227 */     this.jPanel16.setLayout(jPanel16Layout);
/* 228 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 230 */         .addGap(0, 61, 32767));
/*     */     
/* 232 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 234 */         .addGap(0, 37, 32767));
/*     */ 
/*     */     
/* 237 */     this.jPanel12.add(this.jPanel16);
/*     */     
/* 239 */     this.jButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 240 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 241 */     this.jButton1.setMnemonic('N');
/* 242 */     this.jButton1.setText("Nuevo");
/* 243 */     this.jButton1.setToolTipText("Nuevo(Alt + N)");
/* 244 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 246 */             tras_Origenes.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 249 */     this.jPanel12.add(this.jButton1);
/*     */     
/* 251 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 252 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 253 */     this.jButton2.setMnemonic('M');
/* 254 */     this.jButton2.setText("Modificar");
/* 255 */     this.jButton2.setToolTipText("Modificar (Alt + M)");
/* 256 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 258 */             tras_Origenes.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 261 */     this.jPanel12.add(this.jButton2);
/*     */     
/* 263 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 264 */     this.jButton4.setMnemonic('G');
/* 265 */     this.jButton4.setText("Guardar Reporte");
/* 266 */     this.jButton4.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 267 */     this.jButton4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 269 */             tras_Origenes.this.jButton4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 272 */     this.jPanel12.add(this.jButton4);
/*     */     
/* 274 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 282 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 287 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 290 */     this.rSTableMetro1.setAltoHead(40);
/* 291 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 292 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 293 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 294 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 295 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 296 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 297 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 298 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 299 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 300 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 301 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 302 */     this.rSTableMetro1.setRowHeight(18);
/* 303 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 304 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 305 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 306 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 308 */             tras_Origenes.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 311 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 313 */             tras_Origenes.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 316 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 318 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 319 */     this.jPanel1.setLayout(jPanel1Layout);
/* 320 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 322 */         .addComponent(this.jScrollPane13, -2, 0, 32767));
/*     */     
/* 324 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 325 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 326 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 327 */           .addComponent(this.jScrollPane13, -1, 173, 32767)
/* 328 */           .addContainerGap()));
/*     */ 
/*     */     
/* 331 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 332 */     this.jPanel11.setLayout(jPanel11Layout);
/* 333 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 335 */         .addComponent(this.jPanel12, -2, 400, 32767)
/* 336 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 338 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 339 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 340 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 341 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 343 */           .addComponent(this.jPanel12, -2, 37, -2)
/* 344 */           .addContainerGap()));
/*     */ 
/*     */     
/* 347 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 348 */     this.jPanel9.setLayout(jPanel9Layout);
/* 349 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 350 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 351 */         .addComponent(this.jPanel11, -1, -1, 32767)
/* 352 */         .addComponent(this.jPanel10, -1, -1, 32767)
/* 353 */         .addComponent(this.jPanel35, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*     */     
/* 355 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 356 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 357 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 358 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 359 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 360 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 361 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 362 */           .addComponent(this.jPanel11, -1, -1, 32767)));
/*     */ 
/*     */     
/* 365 */     GroupLayout layout = new GroupLayout(this);
/* 366 */     setLayout(layout);
/* 367 */     layout.setHorizontalGroup(layout
/* 368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 369 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/* 371 */     layout.setVerticalGroup(layout
/* 372 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 373 */         .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 378 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 382 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 386 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 394 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 398 */     if (this.PRIMERA) {
/* 399 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 404 */     this.actualizado = false;
/* 405 */     tras_Origenes_Form form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, "");
/* 406 */     this.actualizado = form.actualizado;
/* 407 */     if (this.actualizado) {
/* 408 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 413 */     String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString();
/* 414 */     this.actualizado = false;
/* 415 */     tras_Origenes_Form form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/* 416 */     this.actualizado = form.actualizado;
/* 417 */     if (this.actualizado) {
/* 418 */       consultar();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 423 */     String[] datos = { "NÚM", "ID", "NOMBRE", "C.P.", "CALLE", "NÚM", "COLONIA", "CIUDAD", "ESTADO", "CLIENTES", "ACTUALIZÓ" };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 428 */     this.esc = new EscribirReporte("ORIGENES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 432 */     if (evt.getClickCount() == 2) {
/* 433 */       String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString();
/* 434 */       tras_Origenes_Form tras_Origenes_Form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */   
/*     */   public void orgienes(String usua) {
/* 443 */     this.USUARIO = usua;
/* 444 */     this.panel.setViewportView(this);
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 448 */     this.pintar.colorear(this.jTextField1);
/* 449 */     this.pintar.colorear(this.jTextField2);
/* 450 */     this.pintar.colorear(this.jTextField3);
/* 451 */     this.pintar.colorear(this.jTextField4);
/* 452 */     this.pintar.colorear(this.jComboBox1);
/*     */   }
/*     */   
/*     */   public void llenarComboEstados() {
/* 456 */     String[] estados = this.con2.regresaColIndex("distinct(edo)", "tras_origenes", " order by edo");
/* 457 */     this.jComboBox1.removeAllItems();
/* 458 */     this.jComboBox1.addItem("ESTADOS");
/* 459 */     this.utilerias.llenarCombo(this.jComboBox1, estados);
/* 460 */     this.jComboBox1.setSelectedItem("ESTADOS");
/*     */   }
/*     */   
/*     */   public void llenarCodigosPostales() {
/* 464 */     this.entraPrimera = true;
/* 465 */     String[][] cod = this.con2.buscarDatos(6, "num, codigo, c_Municipio, ciudad, c_estado, estado ", "tras_codigos_postales", "order by codigo");
/* 466 */     for (String[] c : cod) {
/* 467 */       this.CODIGOSP.add(new Tras_codigos(c[0], c[1], c[2], c[3], c[4], c[5]));
/* 468 */       agregarCampo(this.LISTACODIGOS, c[1]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 473 */     if (!datos.contains(valor)) {
/* 474 */       datos.add(valor);
/*     */     }
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 479 */     this.PRIMERA = true;
/* 480 */     String id = "";
/* 481 */     String nombre = "";
/* 482 */     String ciudad = "";
/* 483 */     String cliente = "";
/* 484 */     String estados = "";
/*     */     
/* 486 */     if (!this.jTextField1.getText().equals(this.holderId)) {
/* 487 */       id = this.jTextField1.getText();
/*     */     }
/* 489 */     if (!this.jTextField2.getText().equals(this.holderNombre)) {
/* 490 */       nombre = this.jTextField2.getText();
/*     */     }
/* 492 */     if (!this.jTextField3.getText().equals(this.holderCiudad)) {
/* 493 */       ciudad = this.jTextField3.getText();
/*     */     }
/* 495 */     if (!this.jTextField4.getText().equals(this.holderCliente)) {
/* 496 */       cliente = this.jTextField4.getText();
/*     */     }
/*     */     
/* 499 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 500 */       estados = this.jComboBox1.getSelectedItem().toString();
/*     */     }
/*     */     
/* 503 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro1, new String[] { "Núm", "ID", "Nombre", "C.P.", "Calle", "Número", "Colonia", "Ciudad", "Estado", "Clientes", "Actualizó" }, "num_o, id, nombre, cp, calle, num, col, ciudad, edo, clientes, usuario", "tras_origenes", "where id like '%" + id + "%' and NOMBRE like '%" + nombre + "%' and ciudad like '%" + ciudad + "%' and clientes like '%" + cliente + "%' and edo like '%" + estados + "%' order by num_o desc");
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
/* 520 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/*     */     
/* 522 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 70);
/* 523 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 70);
/* 524 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 3, 70);
/* 525 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 5, 120);
/* 526 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 120);
/*     */     
/* 528 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda1);
/*     */   }
/*     */   
/*     */   public class CeldaRender1
/*     */     extends DefaultTableCellRenderer {
/* 533 */     int otro = -1;
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 535 */       setEnabled((table == null || table.isEnabled()));
/* 536 */       if (column == 0 || column == 3) {
/* 537 */         setHorizontalAlignment(4);
/*     */       } else {
/* 539 */         setHorizontalAlignment(2);
/*     */       } 
/* 541 */       if (row % 2 == 0) {
/* 542 */         setBackground(tras_Origenes.this.lc.FONDOTABLA);
/*     */       } else {
/* 544 */         setBackground((Color)null);
/*     */       } 
/* 546 */       setForeground(tras_Origenes.this.lc.SECUNDARIO1);
/* 547 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 548 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/tras_Origenes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */