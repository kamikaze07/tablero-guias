/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.text.NumberFormat;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ 
/*     */ public class ProvTarjetaDeudorMovimiento extends JDialog {
/*  18 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  19 */   SColores lc = new SColores();
/*  20 */   String[] CAMPOS = null;
/*  21 */   String TITULO = "";
/*  22 */   Consultas con = new Consultas();
/*  23 */   String MOV = "";
/*  24 */   CeldaRender5 celda5 = new CeldaRender5(); private JFormattedTextField cantidad; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel7; private JPanel jPanel1; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JScrollPane jScrollPane1; private JScrollPane jScrollPane13; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextPane jTextPane1; private MaterialButton materialButton18; private RSTableMetro rSTableMetro1;
/*     */   
/*     */   public ProvTarjetaDeudorMovimiento(Frame parent, boolean modal, String TITULO, String MOV, String[] CAMPOS) {
/*  27 */     super(parent, modal);
/*  28 */     this.TITULO = TITULO;
/*  29 */     this.CAMPOS = CAMPOS;
/*  30 */     this.MOV = MOV;
/*  31 */     this.con.setBaseDatos("sicre2PR");
/*  32 */     initComponents();
/*     */     
/*  34 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  35 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  36 */     editFormat.setGroupingUsed(false);
/*  37 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  38 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  39 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  40 */     enFormat.setAllowsInvalid(true);
/*  41 */     this.cantidad.setFormatterFactory(currFactory);
/*     */     
/*  43 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  44 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  45 */     setCursor(micursor);
/*  46 */     this.rSTableMetro1.setCursor(micursor);
/*     */     
/*  48 */     String campos = "";
/*  49 */     String tablas = "";
/*  50 */     String condicion = "";
/*  51 */     if ("ABONO".equals(TITULO)) {
/*  52 */       campos = "prov_tarjetadeudor.referencia, prov_tarjetadeudor_pagos.abono, prov_tarjetadeudor_pagos.usuario";
/*  53 */       tablas = "prov_tarjetadeudor,prov_tarjetadeudor_pagos";
/*  54 */       condicion = "where prov_tarjetadeudor.mov = prov_tarjetadeudor_pagos.mov and prov_tarjetadeudor_pagos.referencia= '" + CAMPOS[2] + "' ORDER BY prov_tarjetadeudor_pagos.MOV desc";
/*     */     } else {
/*  56 */       campos = "referencia, abono, usuario";
/*  57 */       tablas = "prov_tarjetadeudor_pagos";
/*  58 */       condicion = "where mov = " + MOV + " ORDER BY MOV desc";
/*     */     } 
/*     */     
/*  61 */     if (TITULO.equals("CARGO")) {
/*  62 */       this.con.consultar("comentariosGral", "prov_tarjetadeudor, prov_facturas", "where prov_tarjetadeudor.factura = prov_facturas.folioComp and prov_tarjetadeudor.mov = " + MOV);
/*  63 */       this.jTextPane1.setText(this.con.Campo);
/*     */     } 
/*     */ 
/*     */     
/*  67 */     (new String[3])[0] = "Referencia"; (new String[3])[1] = "Abono"; (new String[3])[2] = "Usuario"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(3, campos, tablas, condicion), (Object[])new String[3]) {
/*  68 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*     */           
/*  70 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  73 */             return this.canEdit[columnIndex];
/*     */           }
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/*  77 */             return this.types[columnIndex];
/*     */           }
/*     */         });
/*  80 */     this.rSTableMetro1.setShowVerticalLines(false);
/*  81 */     this.rSTableMetro1.setSelectionMode(0);
/*  82 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/*  83 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  84 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(80);
/*  85 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(80);
/*  86 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda5);
/*  87 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda5);
/*  88 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda5);
/*  89 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*  90 */     calcularTotalAbonos();
/*     */     
/*  92 */     setLocationRelativeTo(null);
/*  93 */     setResizable(false);
/*  94 */     setResizable(false);
/*  95 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/* 103 */     this.cantidad = new JFormattedTextField();
/* 104 */     this.jPanel1 = new JPanel();
/* 105 */     this.jPanel2 = new JPanel();
/* 106 */     this.jLabel1 = new JLabel();
/* 107 */     this.jTextField1 = new JTextField();
/* 108 */     this.jLabel2 = new JLabel();
/* 109 */     this.jTextField2 = new JTextField();
/* 110 */     this.jLabel3 = new JLabel();
/* 111 */     this.jTextField3 = new JTextField();
/* 112 */     this.jLabel4 = new JLabel();
/* 113 */     this.jTextField4 = new JTextField();
/* 114 */     this.jLabel5 = new JLabel();
/* 115 */     this.jTextField5 = new JTextField();
/* 116 */     this.jPanel3 = new JPanel();
/* 117 */     this.jPanel4 = new JPanel();
/* 118 */     this.jScrollPane13 = new JScrollPane();
/* 119 */     this.rSTableMetro1 = new RSTableMetro();
/* 120 */     this.jLabel6 = new JLabel();
/* 121 */     this.jLabel7 = new JLabel();
/* 122 */     this.jPanel5 = new JPanel();
/* 123 */     this.jScrollPane1 = new JScrollPane();
/* 124 */     this.jTextPane1 = new JTextPane();
/* 125 */     this.materialButton18 = new MaterialButton();
/*     */     
/* 127 */     this.cantidad.setText("jFormattedTextField1");
/*     */     
/* 129 */     setDefaultCloseOperation(2);
/* 130 */     setTitle(this.TITULO);
/*     */     
/* 132 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder("Información del movimiento"));
/* 133 */     GridBagLayout jPanel2Layout = new GridBagLayout();
/* 134 */     jPanel2Layout.columnWidths = new int[] { 0, 5, 0 };
/* 135 */     jPanel2Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 136 */     this.jPanel2.setLayout(jPanel2Layout);
/*     */     
/* 138 */     this.jLabel1.setText("Fecha");
/* 139 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 140 */     gridBagConstraints.gridx = 0;
/* 141 */     gridBagConstraints.gridy = 0;
/* 142 */     gridBagConstraints.fill = 2;
/* 143 */     gridBagConstraints.anchor = 21;
/* 144 */     this.jPanel2.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 146 */     this.jTextField1.setEditable(false);
/* 147 */     this.jTextField1.setText(this.CAMPOS[0]);
/* 148 */     gridBagConstraints = new GridBagConstraints();
/* 149 */     gridBagConstraints.gridx = 2;
/* 150 */     gridBagConstraints.gridy = 0;
/* 151 */     gridBagConstraints.fill = 2;
/* 152 */     gridBagConstraints.weightx = 1.0D;
/* 153 */     this.jPanel2.add(this.jTextField1, gridBagConstraints);
/*     */     
/* 155 */     this.jLabel2.setText("Concepto");
/* 156 */     gridBagConstraints = new GridBagConstraints();
/* 157 */     gridBagConstraints.gridx = 0;
/* 158 */     gridBagConstraints.gridy = 2;
/* 159 */     gridBagConstraints.fill = 2;
/* 160 */     gridBagConstraints.anchor = 21;
/* 161 */     this.jPanel2.add(this.jLabel2, gridBagConstraints);
/*     */     
/* 163 */     this.jTextField2.setEditable(false);
/* 164 */     this.jTextField2.setText(this.CAMPOS[1]);
/* 165 */     gridBagConstraints = new GridBagConstraints();
/* 166 */     gridBagConstraints.gridx = 2;
/* 167 */     gridBagConstraints.gridy = 2;
/* 168 */     gridBagConstraints.fill = 2;
/* 169 */     gridBagConstraints.weightx = 1.0D;
/* 170 */     this.jPanel2.add(this.jTextField2, gridBagConstraints);
/*     */     
/* 172 */     this.jLabel3.setText("Referencia");
/* 173 */     gridBagConstraints = new GridBagConstraints();
/* 174 */     gridBagConstraints.gridx = 0;
/* 175 */     gridBagConstraints.gridy = 4;
/* 176 */     gridBagConstraints.fill = 2;
/* 177 */     gridBagConstraints.anchor = 21;
/* 178 */     this.jPanel2.add(this.jLabel3, gridBagConstraints);
/*     */     
/* 180 */     this.jTextField3.setEditable(false);
/* 181 */     this.jTextField3.setText(this.CAMPOS[2]);
/* 182 */     gridBagConstraints = new GridBagConstraints();
/* 183 */     gridBagConstraints.gridx = 2;
/* 184 */     gridBagConstraints.gridy = 4;
/* 185 */     gridBagConstraints.fill = 2;
/* 186 */     gridBagConstraints.weightx = 1.0D;
/* 187 */     this.jPanel2.add(this.jTextField3, gridBagConstraints);
/*     */     
/* 189 */     this.jLabel4.setText("Importe");
/* 190 */     gridBagConstraints = new GridBagConstraints();
/* 191 */     gridBagConstraints.gridx = 0;
/* 192 */     gridBagConstraints.gridy = 6;
/* 193 */     gridBagConstraints.fill = 2;
/* 194 */     gridBagConstraints.anchor = 21;
/* 195 */     this.jPanel2.add(this.jLabel4, gridBagConstraints);
/*     */     
/* 197 */     this.jTextField4.setEditable(false);
/* 198 */     this.jTextField4.setHorizontalAlignment(4);
/* 199 */     this.jTextField4.setText(this.CAMPOS[3]);
/* 200 */     gridBagConstraints = new GridBagConstraints();
/* 201 */     gridBagConstraints.gridx = 2;
/* 202 */     gridBagConstraints.gridy = 6;
/* 203 */     gridBagConstraints.fill = 2;
/* 204 */     gridBagConstraints.weightx = 1.0D;
/* 205 */     this.jPanel2.add(this.jTextField4, gridBagConstraints);
/*     */     
/* 207 */     this.jLabel5.setText("Debe");
/* 208 */     gridBagConstraints = new GridBagConstraints();
/* 209 */     gridBagConstraints.gridx = 0;
/* 210 */     gridBagConstraints.gridy = 8;
/* 211 */     gridBagConstraints.fill = 2;
/* 212 */     gridBagConstraints.anchor = 21;
/* 213 */     this.jPanel2.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 215 */     this.jTextField5.setEditable(false);
/* 216 */     this.jTextField5.setHorizontalAlignment(4);
/* 217 */     this.jTextField5.setText(this.CAMPOS[4]);
/* 218 */     gridBagConstraints = new GridBagConstraints();
/* 219 */     gridBagConstraints.gridx = 2;
/* 220 */     gridBagConstraints.gridy = 8;
/* 221 */     gridBagConstraints.fill = 2;
/* 222 */     gridBagConstraints.weightx = 1.0D;
/* 223 */     this.jPanel2.add(this.jTextField5, gridBagConstraints);
/*     */     
/* 225 */     this.jPanel3.setLayout(new GridLayout(2, 0, 0, 6));
/*     */     
/* 227 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Relación de pagos"));
/*     */     
/* 229 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 237 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 242 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 245 */     this.rSTableMetro1.setAltoHead(25);
/* 246 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 247 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 248 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 249 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 250 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 251 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 252 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 253 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 254 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 255 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 256 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 257 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 258 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 259 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 260 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 262 */             ProvTarjetaDeudorMovimiento.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 265 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 267 */             ProvTarjetaDeudorMovimiento.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 270 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 272 */     this.jLabel6.setFont(new Font("Quicksand", 1, 12));
/* 273 */     this.jLabel6.setHorizontalAlignment(4);
/* 274 */     this.jLabel6.setText("jLabel6");
/*     */     
/* 276 */     this.jLabel7.setHorizontalAlignment(4);
/* 277 */     this.jLabel7.setText("Total");
/*     */     
/* 279 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 280 */     this.jPanel4.setLayout(jPanel4Layout);
/* 281 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 283 */         .addComponent(this.jScrollPane13, -1, 412, 32767)
/* 284 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 285 */           .addGap(0, 0, 32767)
/* 286 */           .addComponent(this.jLabel7, -2, 65, -2)
/* 287 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 288 */           .addComponent(this.jLabel6, -2, 122, -2)));
/*     */     
/* 290 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 291 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 292 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 293 */           .addComponent(this.jScrollPane13, -1, 129, 32767)
/* 294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 295 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 296 */             .addComponent(this.jLabel6)
/* 297 */             .addComponent(this.jLabel7))));
/*     */ 
/*     */     
/* 300 */     this.jPanel3.add(this.jPanel4);
/*     */     
/* 302 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder("Comentarios"));
/*     */     
/* 304 */     this.jTextPane1.setEditable(false);
/* 305 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*     */     
/* 307 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 308 */     this.jPanel5.setLayout(jPanel5Layout);
/* 309 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 311 */         .addComponent(this.jScrollPane1, -1, 412, 32767));
/*     */     
/* 313 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 314 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 315 */         .addComponent(this.jScrollPane1, -1, 150, 32767));
/*     */ 
/*     */     
/* 318 */     this.jPanel3.add(this.jPanel5);
/*     */     
/* 320 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/* 321 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/* 322 */     this.materialButton18.setMnemonic('C');
/* 323 */     this.materialButton18.setText("Cerrar");
/* 324 */     this.materialButton18.setToolTipText("Cerrar (Alt+C)");
/* 325 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/* 326 */     this.materialButton18.setHorizontalTextPosition(0);
/* 327 */     this.materialButton18.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 329 */             ProvTarjetaDeudorMovimiento.this.materialButton18ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 333 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 334 */     this.jPanel1.setLayout(jPanel1Layout);
/* 335 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 337 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 338 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 339 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 340 */           .addContainerGap(-1, 32767)
/* 341 */           .addComponent((Component)this.materialButton18, -2, 105, -2)
/* 342 */           .addContainerGap()));
/*     */     
/* 344 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 346 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 347 */           .addComponent(this.jPanel2, -1, 177, 32767)
/* 348 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 349 */           .addComponent(this.jPanel3, -2, 351, -2)
/* 350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 351 */           .addComponent((Component)this.materialButton18, -2, 38, -2)
/* 352 */           .addContainerGap()));
/*     */ 
/*     */     
/* 355 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 356 */     getContentPane().setLayout(layout);
/* 357 */     layout.setHorizontalGroup(layout
/* 358 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 359 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 361 */     layout.setVerticalGroup(layout
/* 362 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 363 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */ 
/*     */     
/* 366 */     pack();
/*     */   }
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 370 */     if (this.TITULO.equals("CARGO"));
/*     */ 
/*     */ 
/*     */     
/* 374 */     if (evt.getClickCount() == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 393 */     setVisible(false);
/*     */   }
/*     */   
/*     */   public void calcularTotalAbonos() {
/* 397 */     this.jLabel6.setText("$0.00");
/* 398 */     double valorS = 0.0D;
/* 399 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 400 */       String canti = String.valueOf(this.rSTableMetro1.getValueAt(i, 1));
/* 401 */       String valorP = "";
/* 402 */       for (int j = 0; j < canti.length(); j++) {
/* 403 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 404 */           valorP = valorP + valorP;
/*     */         }
/*     */       } 
/* 407 */       valorS += Double.parseDouble(valorP);
/*     */     } 
/* 409 */     this.cantidad.setValue(Double.valueOf(valorS));
/* 410 */     this.jLabel6.setText(this.cantidad.getText());
/*     */   }
/*     */   
/*     */   protected JRootPane createRootPane() {
/* 414 */     JRootPane rootPane = new JRootPane();
/* 415 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/* 416 */     Action actionListener = new AbstractAction() {
/*     */         public void actionPerformed(ActionEvent actionEvent) {
/* 418 */           ProvTarjetaDeudorMovimiento.this.setVisible(false);
/*     */         }
/*     */       };
/* 421 */     InputMap inputMap = rootPane.getInputMap(2);
/* 422 */     inputMap.put(stroke, "ESCAPE");
/* 423 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/* 424 */     return rootPane;
/*     */   }
/*     */   
/*     */   class CeldaRender5
/*     */     extends DefaultTableCellRenderer {
/* 429 */     int otro = -1;
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 432 */       setEnabled((table == null || table.isEnabled()));
/* 433 */       if (row % 2 == 0) {
/* 434 */         setBackground(ProvTarjetaDeudorMovimiento.this.lc.FONDOTABLA);
/*     */       } else {
/* 436 */         setBackground((Color)null);
/*     */       } 
/* 438 */       if (column == 1) {
/* 439 */         setHorizontalAlignment(4);
/*     */       } else {
/* 441 */         setHorizontalAlignment(2);
/*     */       } 
/* 443 */       setForeground(ProvTarjetaDeudorMovimiento.this.lc.SECUNDARIO1);
/* 444 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 445 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvTarjetaDeudorMovimiento.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */