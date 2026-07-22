/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class CajaBuscar extends JPanel {
/*     */   Border borde;
/*     */   Color color;
/*     */   JScrollPane panel;
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*     */   String USUARIO;
/*  24 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  27 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  29 */   Date fechaActual = new Date();
/*  30 */   CajaAgregar CajaA = null;
/*     */   EscribirReporte esc;
/*  32 */   CeldaRender celda = new CeldaRender(); private JButton jButton1; private JButton jButton5; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39;
/*     */   public CajaBuscar(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  34 */     initComponents();
/*  35 */     this.padre = padre;
/*  36 */     this.fichas = fichas;
/*  37 */     colorear();
/*  38 */     this.USUARIO = USUARIO;
/*  39 */     panelito.setViewportView(this);
/*  40 */     this.panel = panelito;
/*  41 */     llenarCombos();
/*  42 */     consultar();
/*     */   }
/*     */   private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel5; private JScrollPane jScrollPane3; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2;
/*     */   
/*     */   private void initComponents() {
/*  47 */     this.jPanel1 = new JPanel();
/*  48 */     this.jPanel17 = new JPanel();
/*  49 */     this.jLabel14 = new JLabel();
/*  50 */     this.jLabel32 = new JLabel();
/*  51 */     this.jLabel38 = new JLabel();
/*  52 */     this.jTextField2 = new JTextField();
/*  53 */     this.jTextField1 = new JTextField();
/*  54 */     this.jLabel15 = new JLabel();
/*  55 */     this.jComboBox1 = new JComboBox();
/*  56 */     this.jComboBox2 = new JComboBox();
/*  57 */     this.jLabel39 = new JLabel();
/*  58 */     this.jComboBox3 = new JComboBox();
/*  59 */     this.jComboBox4 = new JComboBox();
/*  60 */     this.jLabel40 = new JLabel();
/*  61 */     this.jLabel54 = new JLabel();
/*  62 */     this.jPanel5 = new JPanel();
/*  63 */     this.jLabel48 = new JLabel();
/*  64 */     this.jScrollPane3 = new JScrollPane();
/*  65 */     this.jTable3 = new JTable();
/*  66 */     this.jButton5 = new JButton();
/*  67 */     this.jLabel52 = new JLabel();
/*  68 */     this.jLabel59 = new JLabel();
/*  69 */     this.jButton1 = new JButton();
/*     */     
/*  71 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  72 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*     */     
/*  74 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  75 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Remolques ", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/*  77 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  78 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  79 */     this.jLabel14.setHorizontalAlignment(0);
/*  80 */     this.jLabel14.setText("Placas");
/*     */     
/*  82 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/*  83 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  84 */     this.jLabel32.setHorizontalAlignment(0);
/*  85 */     this.jLabel32.setText("Marca");
/*     */     
/*  87 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/*  88 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  89 */     this.jLabel38.setHorizontalAlignment(0);
/*  90 */     this.jLabel38.setText("Tipo");
/*     */     
/*  92 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  94 */             CajaBuscar.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/*  98 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 100 */             CajaBuscar.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 104 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 105 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 106 */     this.jLabel15.setHorizontalAlignment(0);
/* 107 */     this.jLabel15.setText("Número");
/*     */     
/* 109 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 110 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 112 */             CajaBuscar.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 116 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 117 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera", "Góndola", "Pipa" }));
/* 118 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 120 */             CajaBuscar.this.jComboBox2ActionPerformed(evt);
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
/* 132 */             CajaBuscar.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 137 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Baja", "Vendido", "Accidentado", "Robado", "Quemado", "Otro" }));
/* 138 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 140 */             CajaBuscar.this.jComboBox4ActionPerformed(evt);
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
/* 155 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
/* 167 */             .addComponent(this.jComboBox1, 0, 217, 32767))
/* 168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 169 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 170 */             .addComponent(this.jLabel38, -1, -1, 32767)
/* 171 */             .addComponent(this.jComboBox2, 0, 138, 32767))
/* 172 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 173 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 174 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 175 */             .addComponent(this.jComboBox3, -2, 123, -2))
/* 176 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 177 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 178 */             .addComponent(this.jLabel40, -1, -1, 32767)
/* 179 */             .addComponent(this.jComboBox4, 0, 110, 32767))
/* 180 */           .addGap(590, 590, 590)));
/*     */     
/* 182 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 185 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 186 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 187 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 188 */                 .addComponent(this.jTextField2, -2, -1, -2)
/* 189 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 190 */                 .addComponent(this.jComboBox1, -2, -1, -2))
/* 191 */               .addGap(6, 6, 6)
/* 192 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 193 */                 .addComponent(this.jLabel15)
/* 194 */                 .addComponent(this.jLabel14)
/* 195 */                 .addComponent(this.jLabel32)))
/* 196 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 197 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 199 */               .addComponent(this.jLabel38))
/* 200 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 201 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 202 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 203 */               .addComponent(this.jLabel39))
/* 204 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 205 */               .addComponent(this.jComboBox4, -2, -1, -2)
/* 206 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 207 */               .addComponent(this.jLabel40)))
/* 208 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 211 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/* 212 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 213 */     this.jLabel54.setHorizontalAlignment(0);
/* 214 */     this.jLabel54.setText("Buscar Remolques");
/*     */     
/* 216 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 217 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*     */     
/* 219 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 220 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 221 */     this.jLabel48.setHorizontalAlignment(2);
/* 222 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 224 */     this.jTable3.setAutoCreateRowSorter(true);
/* 225 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 226 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Motor", "Factura", "Forma de Pago", "Km Recorridos", "Peso", "Dimensión", "Estado", "Fecha Registro", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLÓGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 234 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, true, true, true, true, true };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 239 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 242 */     this.jTable3.setShowVerticalLines(false);
/* 243 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 245 */             CajaBuscar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 248 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 250 */     this.jButton5.setMnemonic('G');
/* 251 */     this.jButton5.setText("Guardar Reporte");
/* 252 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 253 */     this.jButton5.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 255 */             CajaBuscar.this.jButton5ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 259 */     this.jLabel52.setFont(new Font("Tahoma", 2, 11));
/* 260 */     this.jLabel52.setForeground(new Color(28, 126, 125));
/* 261 */     this.jLabel52.setHorizontalAlignment(2);
/* 262 */     this.jLabel52.setText("Si deseas crear un nuevo reporte presiona el botón de 'Guardar Reporte'");
/*     */     
/* 264 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 265 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 266 */     this.jLabel59.setHorizontalAlignment(0);
/* 267 */     this.jLabel59.setText("Imprimir Consulta");
/*     */     
/* 269 */     this.jButton1.setText("Imprimir");
/* 270 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 272 */             CajaBuscar.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 276 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 277 */     this.jPanel5.setLayout(jPanel5Layout);
/* 278 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 279 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 280 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 281 */           .addContainerGap()
/* 282 */           .addComponent(this.jLabel48, -2, 191, -2)
/* 283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138, 32767)
/* 284 */           .addComponent(this.jLabel59, -2, 99, -2)
/* 285 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 286 */           .addComponent(this.jButton1)
/* 287 */           .addGap(104, 104, 104)
/* 288 */           .addComponent(this.jLabel52, -2, 367, -2)
/* 289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 290 */           .addComponent(this.jButton5)
/* 291 */           .addGap(321, 321, 321))
/* 292 */         .addComponent(this.jScrollPane3, -1, 1422, 32767));
/*     */     
/* 294 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 295 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 296 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 297 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 298 */             .addComponent(this.jLabel48)
/* 299 */             .addComponent(this.jButton5)
/* 300 */             .addComponent(this.jLabel52)
/* 301 */             .addComponent(this.jLabel59)
/* 302 */             .addComponent(this.jButton1))
/* 303 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 304 */           .addComponent(this.jScrollPane3, -1, 164, 32767)));
/*     */ 
/*     */     
/* 307 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 308 */     this.jPanel1.setLayout(jPanel1Layout);
/* 309 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 311 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 312 */           .addContainerGap()
/* 313 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 314 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 315 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 316 */             .addComponent(this.jLabel54, -1, -1, 32767))
/* 317 */           .addContainerGap()));
/*     */     
/* 319 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 321 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 322 */           .addContainerGap()
/* 323 */           .addComponent(this.jLabel54)
/* 324 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 325 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 327 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 328 */           .addContainerGap()));
/*     */ 
/*     */     
/* 331 */     GroupLayout layout = new GroupLayout(this);
/* 332 */     setLayout(layout);
/* 333 */     layout.setHorizontalGroup(layout
/* 334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 335 */         .addGap(0, 1478, 32767)
/* 336 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */           .addGroup(layout.createSequentialGroup()
/* 338 */             .addContainerGap()
/* 339 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 340 */             .addContainerGap())));
/*     */     
/* 342 */     layout.setVerticalGroup(layout
/* 343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 344 */         .addGap(0, 385, 32767)
/* 345 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */           .addGroup(layout.createSequentialGroup()
/* 347 */             .addGap(11, 11, 11)
/* 348 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 349 */             .addGap(11, 11, 11))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 354 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 358 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 362 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 366 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 370 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 374 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 378 */     int ind = this.jTable3.getSelectedRow();
/* 379 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 380 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/*     */     
/* 382 */     this.jButton5.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 386 */     String[] datos = { "Núm", "Modelo", "Color", "Serie", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" };
/* 387 */     this.esc = new EscribirReporte("Remolques", this.jTable3, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 392 */       if (!this.jTable3.print());
/*     */ 
/*     */     
/*     */     }
/* 396 */     catch (PrinterException printerException) {}
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 400 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 402 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 405 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 408 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 410 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 413 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 416 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 418 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 421 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 424 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 426 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 429 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 432 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 434 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 437 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 440 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 442 */             CajaBuscar.this.jTextGanado(CajaBuscar.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 445 */             CajaBuscar.this.jTextPerdido(CajaBuscar.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 450 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 453 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 457 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 458 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 459 */       setCursor(micursor);
/*     */     }
/* 461 */     catch (Exception e) {
/* 462 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void caja(String usu) {
/* 466 */     this.USUARIO = usu;
/* 467 */     this.panel.setViewportView(this);
/* 468 */     llenarCombos();
/* 469 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 472 */     this.con.consultar("count(marca)", "marca", "");
/* 473 */     String[] depa = this.con.regresaCol("marca", "marca", "order by marca", Integer.parseInt(this.con.Campo));
/* 474 */     this.jComboBox1.removeAllItems();
/* 475 */     this.jComboBox1.addItem("Cualquiera");
/* 476 */     for (int i = 0; i < depa.length; i++) {
/* 477 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/* 479 */     this.jComboBox3.removeAllItems();
/* 480 */     int año = this.fechaActual.getYear();
/* 481 */     año += 1901;
/* 482 */     this.jComboBox3.addItem("Cualquiera");
/* 483 */     for (int j = año; j >= 1990; j--)
/* 484 */       this.jComboBox3.addItem(Integer.valueOf(j)); 
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 488 */     String numero = this.jTextField1.getText();
/* 489 */     String serie = this.jTextField2.getText();
/* 490 */     String marca = "";
/* 491 */     String tipo = "";
/* 492 */     String modelo = "";
/* 493 */     String estado = "";
/* 494 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 495 */       marca = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 497 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 498 */       tipo = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 500 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 501 */       modelo = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 503 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 504 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 506 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_rem<>0");
/* 507 */     int totreg = Integer.parseInt(this.con.Campo);
/* 508 */     this.encontrado = this.con.consultar("count(num_rem)", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem<>0");
/* 509 */     String tot = this.con.Campo;
/* 510 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 511 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 512 */           .buscarReg(19, totreg, "num_rem,modelo,color,no_serie,num_factu,forma_pago,placas,km_actual,peso,dimen,estado,fecha,marca.marca,tipo,remolque.num_sem,remolque.NUM_sct,remolque.num_sed,remolque.num_seg,remolque.num_eco", "remolque,marca", "where remolque.id_marca = marca.id_marca and num_rem like '%" + numero + "%' and placas like '%" + serie + "%' and tipo like '%" + tipo + "%' and marca like '%" + marca + "%' and modelo like '%" + modelo + "%' and estado like '%" + estado + "%' and num_rem<>0 order by num_rem"), (Object[])new String[] { "Núm", "Modelo", "Color", "Serie", "Factura", "F. Pago", "Placas", "Km Recorridos", "Peso", "Dimensión", "Estado", "F. Adquisición", "Marca", "Tipo", "SEMARNAT", "SCT", "SEDERE", "VEHICULAR", "ECOLOGICO" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 517 */           boolean[] canEdit = new boolean[] { 
/*     */               false, false, false, false, false, false, false, false, false, false, 
/*     */               false, false, false, false, false, false, false, false, false };
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 521 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 524 */     this.jTable3.setShowVerticalLines(false);
/* 525 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 527 */             CajaBuscar.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 530 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 531 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 532 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 533 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 534 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 535 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 536 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(50);
/*     */ 
/*     */     
/* 539 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 540 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 541 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(55);
/* 542 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(55);
/* 543 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(45);
/* 544 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(45);
/* 545 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(65);
/* 546 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(65);
/* 547 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(65);
/* 548 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(65);
/* 549 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(85);
/* 550 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(85);
/*     */     
/* 552 */     this.jTable3.getColumnModel().getColumn(13).setPreferredWidth(65);
/* 553 */     this.jTable3.getColumnModel().getColumn(13).setMaxWidth(65);
/* 554 */     this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 555 */     this.jTable3.getColumnModel().getColumn(14).setMaxWidth(65);
/* 556 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(65);
/* 557 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(65);
/* 558 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(65);
/* 559 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(65);
/* 560 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(75);
/* 561 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(75);
/* 562 */     this.jTable3.getColumnModel().getColumn(18).setPreferredWidth(75);
/* 563 */     this.jTable3.getColumnModel().getColumn(18).setMaxWidth(75);
/*     */     
/* 565 */     this.jTable3.setSelectionMode(0);
/* 566 */     this.jTable3.setAutoCreateRowSorter(true);
/* 567 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */     int i;
/* 569 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 570 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 14));
/* 571 */       if (valor.equals("0")) {
/* 572 */         this.jTable3.setValueAt("No", i, 14);
/*     */       } else {
/*     */         
/* 575 */         this.jTable3.setValueAt("Si", i, 14);
/*     */       } 
/*     */     } 
/*     */     
/* 579 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 580 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 15));
/* 581 */       if (valor.equals("0")) {
/* 582 */         this.jTable3.setValueAt("No", i, 15);
/*     */       } else {
/*     */         
/* 585 */         this.jTable3.setValueAt("Si", i, 15);
/*     */       } 
/*     */     } 
/*     */     
/* 589 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 590 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 16));
/* 591 */       if (valor.equals("0")) {
/* 592 */         this.jTable3.setValueAt("No", i, 16);
/*     */       } else {
/*     */         
/* 595 */         this.jTable3.setValueAt("Si", i, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 599 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 600 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 17));
/* 601 */       if (valor.equals("0")) {
/* 602 */         this.jTable3.setValueAt("No", i, 17);
/*     */       } else {
/*     */         
/* 605 */         this.jTable3.setValueAt("Si", i, 17);
/*     */       } 
/*     */     } 
/*     */     
/* 609 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 610 */       String valor = String.valueOf(this.jTable3.getValueAt(i, 18));
/* 611 */       if (valor.equals("0")) {
/* 612 */         this.jTable3.setValueAt("No", i, 18);
/*     */       } else {
/*     */         
/* 615 */         this.jTable3.setValueAt("Si", i, 18);
/*     */       } 
/*     */     } 
/* 618 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 619 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 620 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 621 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 622 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 623 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 624 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 625 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 626 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 627 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 628 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 629 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 630 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 631 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 632 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 633 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 634 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 635 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 636 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/*     */   }
/*     */   
/* 639 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 640 */     int[] indices = new int[0];
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 642 */       setEnabled((table == null || table.isEnabled()));
/* 643 */       if (row % 2 == 0 && column == 6) {
/* 644 */         setBackground(new Color(120, 200, 104));
/*     */       }
/* 646 */       else if (row % 2 == 0) {
/* 647 */         setBackground(new Color(194, 213, 151));
/*     */       } else {
/* 649 */         setBackground((Color)null);
/* 650 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 651 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/CajaBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */