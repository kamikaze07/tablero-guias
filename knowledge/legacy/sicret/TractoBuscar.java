/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class TractoBuscar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  23 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*     */   String USUARIO;
/*  25 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  28 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  30 */   Date fechaActual = new Date();
/*  31 */   TractoAgregar TractoA = null;
/*     */   EscribirReporte esc;
/*  33 */   CeldaRender celda = new CeldaRender(); private JButton jButton1; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39;
/*     */   public TractoBuscar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
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
/*     */   private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2;
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
/*  62 */     this.jLabel54 = new JLabel();
/*  63 */     this.jPanel5 = new JPanel();
/*  64 */     this.jLabel48 = new JLabel();
/*  65 */     this.jScrollPane3 = new JScrollPane();
/*  66 */     this.jTable3 = new JTable();
/*  67 */     this.jButton5 = new JButton();
/*  68 */     this.jLabel52 = new JLabel();
/*  69 */     this.jLabel59 = new JLabel();
/*  70 */     this.jButton1 = new JButton();
/*     */     
/*  72 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  73 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  75 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  76 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Tractos ", 0, 0, new Font("Tahoma", 1, 11)));
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
/*  95 */             TractoBuscar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  99 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 101 */             TractoBuscar.this.jTextField1KeyReleased(evt);
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
/* 113 */             TractoBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 117 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 118 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 120 */             TractoBuscar.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 124 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 125 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 126 */     this.jLabel39.setHorizontalAlignment(0);
/* 127 */     this.jLabel39.setText("Modelo");
/*     */     
/* 129 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 130 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 132 */             TractoBuscar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 137 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 138 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 140 */             TractoBuscar.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 144 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 145 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 146 */     this.jLabel40.setHorizontalAlignment(0);
/* 147 */     this.jLabel40.setText("Estado");
/*     */     
/* 149 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 150 */     this.jPanel17.setLayout(jPanel17Layout);
/* 151 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 152 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 153 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 154 */           .addContainerGap()
/* 155 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 156 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 157 */               .addComponent(this.jTextField1, -2, 49, -2)
/* 158 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 159 */               .addComponent(this.jTextField2, -2, 155, -2))
/* 160 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 161 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 162 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 163 */               .addComponent(this.jLabel14, -1, -1, 32767)))
/* 164 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 165 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 166 */             .addComponent(this.jLabel32, -1, -1, 32767)
/* 167 */             .addComponent(this.jComboBox1, -2, 246, -2))
/* 168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 169 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 170 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 171 */             .addComponent(this.jComboBox2, -2, 211, -2))
/* 172 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 173 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 174 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 175 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 176 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 177 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 178 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 179 */             .addComponent(this.jComboBox4, -2, 110, -2))
/* 180 */           .addContainerGap(-1, 32767)));
/*     */     
/* 182 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 185 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 186 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 187 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 188 */           .addGap(6, 6, 6)
/* 189 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 190 */             .addComponent(this.jLabel15)
/* 191 */             .addComponent(this.jLabel14)))
/* 192 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 193 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 194 */           .addGap(6, 6, 6)
/* 195 */           .addComponent(this.jLabel32))
/* 196 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 197 */           .addComponent(this.jComboBox2, -2, -1, -2)
/* 198 */           .addGap(6, 6, 6)
/* 199 */           .addComponent(this.jLabel38))
/* 200 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 201 */           .addComponent(this.jComboBox3, -2, -1, -2)
/* 202 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 203 */           .addComponent(this.jLabel39))
/* 204 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 205 */           .addComponent(this.jComboBox4, -2, -1, -2)
/* 206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 207 */           .addComponent(this.jLabel40)));
/*     */ 
/*     */     
/* 210 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 211 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 212 */     this.jLabel54.setHorizontalAlignment(0);
/* 213 */     this.jLabel54.setText("Buscar Tractos");
/*     */     
/* 215 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 216 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 218 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 219 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 220 */     this.jLabel48.setHorizontalAlignment(2);
/* 221 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 223 */     this.jTable3.setAutoCreateRowSorter(true);
/* 224 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 225 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 233 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 238 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 241 */     this.jTable3.setShowVerticalLines(false);
/* 242 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 244 */     this.jButton5.setMnemonic('G');
/* 245 */     this.jButton5.setText("Guardar Reporte");
/* 246 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 247 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 249 */             TractoBuscar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 253 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 254 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 255 */     this.jLabel52.setHorizontalAlignment(2);
/* 256 */     this.jLabel52.setText("Si deseas crear un nuevo reporte presiona el botón de 'Guardar Reporte'");
/*     */     
/* 258 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 259 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 260 */     this.jLabel59.setHorizontalAlignment(0);
/* 261 */     this.jLabel59.setText("Imprimir Consulta");
/*     */     
/* 263 */     this.jButton1.setText("Imprimir");
/* 264 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 266 */             TractoBuscar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 270 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 271 */     this.jPanel5.setLayout(jPanel5Layout);
/* 272 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 273 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 274 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 275 */           .addContainerGap()
/* 276 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 277 */           .addGap(152, 152, 152)
/* 278 */           .addComponent(this.jLabel59, -2, 99, -2)
/* 279 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 280 */           .addComponent(this.jButton1)
/* 281 */           .addGap(54, 54, 54)
/* 282 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 284 */           .addComponent(this.jButton5)
/* 285 */           .addContainerGap(-1, 32767))
/* 286 */         .addComponent(this.jScrollPane3));
/*     */     
/* 288 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 290 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 291 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 292 */             .addComponent(this.jLabel48)
/* 293 */             .addComponent(this.jButton5)
/* 294 */             .addComponent(this.jLabel52)
/* 295 */             .addComponent(this.jLabel59)
/* 296 */             .addComponent(this.jButton1))
/* 297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 298 */           .addComponent(this.jScrollPane3, -1, 141, 32767)));
/*     */ 
/*     */     
/* 301 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 302 */     this.jPanel1.setLayout(jPanel1Layout);
/* 303 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 304 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 305 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 306 */           .addContainerGap()
/* 307 */           .addComponent(this.jLabel54, -2, 1038, -2)
/* 308 */           .addContainerGap(538, 32767))
/* 309 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 310 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*     */     
/* 312 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 314 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 315 */           .addComponent(this.jLabel54, -2, 26, -2)
/* 316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 317 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 318 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 319 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 320 */           .addContainerGap()));
/*     */ 
/*     */     
/* 323 */     GroupLayout layout = new GroupLayout(this);
/* 324 */     setLayout(layout);
/* 325 */     layout.setHorizontalGroup(layout
/* 326 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 327 */         .addGap(0, 1584, 32767)
/* 328 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 329 */           .addGroup(layout.createSequentialGroup()
/* 330 */             .addContainerGap()
/* 331 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 332 */             .addContainerGap())));
/*     */     
/* 334 */     layout.setVerticalGroup(layout
/* 335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 336 */         .addGap(0, 335, 32767)
/* 337 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 338 */           .addGroup(layout.createSequentialGroup()
/* 339 */             .addGap(9, 9, 9)
/* 340 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 341 */             .addGap(9, 9, 9))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 346 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 350 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 354 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 358 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 362 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 366 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 370 */     String[] datos = { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" };
/* 371 */     this.esc = new EscribirReporte("TRACTORES", this.jTable3, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 376 */       if (!this.jTable3.print());
/*     */ 
/*     */     
/*     */     }
/* 380 */     catch (PrinterException printerException) {}
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 384 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 386 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 389 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 392 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 394 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 397 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 400 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 402 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 405 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 408 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 410 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 413 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 416 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 418 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 421 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 424 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 426 */             TractoBuscar.this.jTextGanado(TractoBuscar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 429 */             TractoBuscar.this.jTextPerdido(TractoBuscar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 434 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 437 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 441 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 442 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 443 */       setCursor(micursor);
/*     */     }
/* 445 */     catch (Exception e) {
/* 446 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void tracto(String usu) {
/* 450 */     this.USUARIO = usu;
/* 451 */     this.panel.setViewportView(this);
/* 452 */     llenarCombos();
/* 453 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 456 */     this.con.consultar("count(marca)", "marca", "");
/* 457 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 458 */     this.jComboBox1.removeAllItems();
/* 459 */     this.jComboBox1.addItem("Cualquiera"); int i;
/* 460 */     for (i = 0; i < depa.length; i++) {
/* 461 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/*     */     
/* 464 */     this.con.consultar("count(tipo)", "tipos", "");
/* 465 */     depa = this.con.regresaCol("tipo", "tipos", "order by tipo", Integer.parseInt(this.con.Campo));
/* 466 */     this.jComboBox2.removeAllItems();
/* 467 */     this.jComboBox2.addItem("Cualquiera");
/* 468 */     for (i = 0; i < depa.length; i++) {
/* 469 */       this.jComboBox2.addItem(depa[i]);
/*     */     }
/* 471 */     this.jComboBox3.removeAllItems();
/* 472 */     int año = this.fechaActual.getYear();
/* 473 */     año += 1901;
/* 474 */     this.jComboBox3.addItem("Cualquiera");
/* 475 */     for (int j = año; j >= 1990; j--)
/* 476 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 480 */     String numero = this.jTextField1.getText();
/* 481 */     String serie = this.jTextField2.getText();
/* 482 */     String marca = "";
/* 483 */     String tipo = "";
/* 484 */     String modelo = "";
/* 485 */     String estado = "";
/* 486 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 487 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 489 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 490 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 492 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 493 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 495 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 496 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 498 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_tracto<>0");
/* 499 */     int totreg = Integer.parseInt(this.con.Campo);
/* 500 */     this.encontrado = this.con.consultar("count(num_tracto)", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto<>0");
/* 501 */     String tot = this.con.Campo;
/* 502 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 503 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 504 */           .buscarReg(20, totreg, "num_tracto,modelo,color,no_serie,no_motor,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipos.tipo,tracto.num_sem,tracto.NUM_sct,tracto.num_sed,tracto.num_seg,tracto.num_eco", "tracto,tipos,marca", "where tracto.id_tipo = tipos.id_tipo and tracto.id_marca = marca.id_marca and num_tracto like '%" + numero + "%' and placas like '%" + serie + "%' and tipos.tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_tracto<>0 order by num_tracto"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 509 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 513 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 516 */     this.jTable3.setShowVerticalLines(false);
/* 517 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 518 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 519 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 520 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 521 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 522 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(60);
/* 523 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(60);
/* 524 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 525 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/* 526 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(50);
/* 527 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(50);
/* 528 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 529 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 530 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 531 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 532 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 533 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 534 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 535 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 536 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 537 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 538 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(65);
/* 539 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(65);
/* 540 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 541 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/* 542 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(75);
/* 543 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(75);
/*     */     
/* 545 */     this.jTable3.setSelectionMode(0);
/* 546 */     this.jTable3.setAutoCreateRowSorter(true);
/* 547 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 549 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 550 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 551 */       if (valor.equals("0")) {
/* 552 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 555 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 559 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 560 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 561 */       if (valor.equals("0")) {
/* 562 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 565 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 569 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 570 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 571 */       if (valor.equals("0")) {
/* 572 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 575 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/* 578 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 579 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 580 */       if (valor.equals("0")) {
/* 581 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 584 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/*     */     
/* 588 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 589 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 19));
/* 590 */       if (valor.equals("0")) {
/* 591 */         this.jTable3.setValueAt("No", i, 19);
/*     */       } else {
/*     */         
/* 594 */         this.jTable3.setValueAt("Si", i, 19);
/*     */       } 
/*     */     } 
/* 597 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 598 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 599 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 600 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 601 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 602 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 603 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 604 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 605 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 606 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 607 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 608 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 609 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 610 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 611 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 612 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 613 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 614 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 615 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 616 */     this.jTable3.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 619 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 620 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 622 */       setEnabled((table == null || table.isEnabled()));
/* 623 */       if (row % 2 == 0 && column == 7) {
/* 624 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 626 */       else if (row % 2 == 0) {
/* 627 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 629 */         setBackground((Color)null);
/* 630 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 631 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TractoBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */