/*     */ package sicret;
/*     */ import java.awt.Color;
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
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class bitacora extends JPanel {
/*     */   Border borde;
/*  22 */   Toolkit tk = Toolkit.getDefaultToolkit(); Color color; JScrollPane panel;
/*  23 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*     */   String USUARIO;
/*  25 */   Consultas con = new Consultas();
/*     */   boolean encontrado;
/*     */   JTabbedPane fichas;
/*  28 */   AltaOperador operadores = null;
/*     */   JFrame padre;
/*  30 */   Date fechaActual = new Date();
/*  31 */   CajaAgregar CajaA = null; private JButton jButton1; private JButton jButton2; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JLabel jLabel32; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel54;
/*     */   public bitacora(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  33 */     initComponents();
/*  34 */     this.padre = padre;
/*  35 */     this.fichas = fichas;
/*  36 */     colorear();
/*  37 */     this.USUARIO = USUARIO;
/*  38 */     panelito.setViewportView(this);
/*  39 */     this.panel = panelito;
/*  40 */     llenarCombos();
/*  41 */     consultar();
/*     */   }
/*     */   private JLabel jLabel59; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JScrollPane jScrollPane1; private JScrollPane jScrollPane3; private JTable jTable3; private JTextArea jTextArea1;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   
/*     */   private void initComponents() {
/*  48 */     this.jPanel2 = new JPanel();
/*  49 */     this.jPanel6 = new JPanel();
/*  50 */     this.jPanel1 = new JPanel();
/*  51 */     this.jLabel54 = new JLabel();
/*  52 */     this.jLabel4 = new JLabel();
/*  53 */     this.jPanel17 = new JPanel();
/*  54 */     this.jComboBox1 = new JComboBox();
/*  55 */     this.jPanel4 = new JPanel();
/*  56 */     this.jComboBox2 = new JComboBox();
/*  57 */     this.jComboBox3 = new JComboBox();
/*  58 */     this.jComboBox4 = new JComboBox();
/*  59 */     this.jTextField1 = new JTextField();
/*  60 */     this.jTextField2 = new JTextField();
/*  61 */     this.jLabel32 = new JLabel();
/*  62 */     this.jLabel38 = new JLabel();
/*  63 */     this.jLabel39 = new JLabel();
/*  64 */     this.jLabel40 = new JLabel();
/*  65 */     this.jPanel5 = new JPanel();
/*  66 */     this.jPanel3 = new JPanel();
/*  67 */     this.jLabel48 = new JLabel();
/*  68 */     this.jLabel59 = new JLabel();
/*  69 */     this.jButton1 = new JButton();
/*  70 */     this.jScrollPane3 = new JScrollPane();
/*  71 */     this.jTable3 = new JTable();
/*  72 */     this.jPanel7 = new JPanel();
/*  73 */     this.jButton2 = new JButton();
/*  74 */     this.jScrollPane1 = new JScrollPane();
/*  75 */     this.jTextArea1 = new JTextArea();
/*  76 */     this.jLabel49 = new JLabel();
/*     */     
/*  78 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  79 */     this.jPanel6.setLayout(jPanel6Layout);
/*  80 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  81 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  82 */         .addGap(0, 450, 32767));
/*     */     
/*  84 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  85 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  86 */         .addGap(0, 298, 32767));
/*     */ 
/*     */     
/*  89 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  90 */     this.jPanel2.setLayout(jPanel2Layout);
/*  91 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  92 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  93 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  94 */           .addContainerGap()
/*  95 */           .addComponent(this.jPanel6, -2, -1, -2)
/*  96 */           .addContainerGap(-1, 32767)));
/*     */     
/*  98 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  99 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 100 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 101 */           .addGap(252, 252, 252)
/* 102 */           .addComponent(this.jPanel6, -2, -1, -2)
/* 103 */           .addContainerGap(105, 32767)));
/*     */ 
/*     */     
/* 106 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 107 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 109 */     this.jLabel54.setFont(new Font("Tahoma", 1, 24));
/* 110 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 111 */     this.jLabel54.setHorizontalAlignment(0);
/* 112 */     this.jLabel54.setText("Bitácora");
/*     */     
/* 114 */     this.jLabel4.setFont(new Font("Tahoma", 2, 11));
/* 115 */     this.jLabel4.setForeground(new Color(28, 126, 125));
/* 116 */     this.jLabel4.setText("<html>Aquí puedes observar cada acción que el usuario ha hecho en el sistema, es de gran ayuda cuando necesitas consultar quién modificó o eliminó algún dato sumamente importante.</html>");
/*     */     
/* 118 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 119 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda General", 0, 0, new Font("Tahoma", 1, 11)));
/* 120 */     this.jPanel17.setLayout(new GridLayout(2, 4, 6, 6));
/*     */     
/* 122 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 123 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 125 */             bitacora.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 128 */     this.jPanel17.add(this.jComboBox1);
/*     */     
/* 130 */     this.jPanel4.setLayout(new GridLayout(1, 3, 4, 0));
/*     */     
/* 132 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 133 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Año" }));
/* 134 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 136 */             bitacora.this.jComboBox2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 139 */     this.jPanel4.add(this.jComboBox2);
/*     */     
/* 141 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 142 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Mes" }));
/* 143 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 145 */             bitacora.this.jComboBox3ActionPerformed(evt);
/*     */           }
/*     */         });
/* 148 */     this.jPanel4.add(this.jComboBox3);
/*     */     
/* 150 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 151 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Día" }));
/* 152 */     this.jComboBox4.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 154 */             bitacora.this.jComboBox4ActionPerformed(evt);
/*     */           }
/*     */         });
/* 157 */     this.jPanel4.add(this.jComboBox4);
/*     */     
/* 159 */     this.jPanel17.add(this.jPanel4);
/*     */     
/* 161 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 163 */             bitacora.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/* 166 */     this.jPanel17.add(this.jTextField1);
/*     */     
/* 168 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 170 */             bitacora.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/* 173 */     this.jPanel17.add(this.jTextField2);
/*     */     
/* 175 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/* 176 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 177 */     this.jLabel32.setHorizontalAlignment(0);
/* 178 */     this.jLabel32.setText("Usuario");
/* 179 */     this.jPanel17.add(this.jLabel32);
/*     */     
/* 181 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/* 182 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 183 */     this.jLabel38.setHorizontalAlignment(0);
/* 184 */     this.jLabel38.setText("Fecha");
/* 185 */     this.jPanel17.add(this.jLabel38);
/*     */     
/* 187 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 188 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 189 */     this.jLabel39.setHorizontalAlignment(0);
/* 190 */     this.jLabel39.setText("Concepto");
/* 191 */     this.jPanel17.add(this.jLabel39);
/*     */     
/* 193 */     this.jLabel40.setFont(new Font("Tahoma", 2, 11));
/* 194 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 195 */     this.jLabel40.setHorizontalAlignment(0);
/* 196 */     this.jLabel40.setText("Datos");
/* 197 */     this.jPanel17.add(this.jLabel40);
/*     */     
/* 199 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 200 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/* 201 */     this.jPanel5.setLayout(new GridLayout(1, 2, 6, 0));
/*     */     
/* 203 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/* 204 */     GridBagLayout jPanel3Layout = new GridBagLayout();
/* 205 */     jPanel3Layout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
/* 206 */     jPanel3Layout.rowHeights = new int[] { 0, 5, 0 };
/* 207 */     this.jPanel3.setLayout(jPanel3Layout);
/*     */     
/* 209 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/* 210 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 211 */     this.jLabel48.setHorizontalAlignment(2);
/* 212 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/* 213 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 214 */     gridBagConstraints.gridx = 0;
/* 215 */     gridBagConstraints.gridy = 0;
/* 216 */     gridBagConstraints.fill = 2;
/* 217 */     gridBagConstraints.anchor = 21;
/* 218 */     this.jPanel3.add(this.jLabel48, gridBagConstraints);
/*     */     
/* 220 */     this.jLabel59.setFont(new Font("Tahoma", 2, 11));
/* 221 */     this.jLabel59.setForeground(new Color(28, 126, 125));
/* 222 */     this.jLabel59.setHorizontalAlignment(4);
/* 223 */     this.jLabel59.setText("Imprimir Consulta");
/* 224 */     gridBagConstraints = new GridBagConstraints();
/* 225 */     gridBagConstraints.gridx = 2;
/* 226 */     gridBagConstraints.gridy = 0;
/* 227 */     gridBagConstraints.anchor = 22;
/* 228 */     this.jPanel3.add(this.jLabel59, gridBagConstraints);
/*     */     
/* 230 */     this.jButton1.setText("Imprimir");
/* 231 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 233 */             bitacora.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 236 */     gridBagConstraints = new GridBagConstraints();
/* 237 */     gridBagConstraints.gridx = 4;
/* 238 */     gridBagConstraints.gridy = 0;
/* 239 */     this.jPanel3.add(this.jButton1, gridBagConstraints);
/*     */     
/* 241 */     this.jTable3.setAutoCreateRowSorter(true);
/* 242 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 243 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Fecha", "Usuario", "Concepto" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 251 */           boolean[] canEdit = new boolean[] { false, false, true, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 256 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 259 */     this.jTable3.setShowVerticalLines(false);
/* 260 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 262 */             bitacora.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 265 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 267 */             bitacora.this.jTable3KeyReleased(evt);
/*     */           }
/*     */         });
/* 270 */     this.jScrollPane3.setViewportView(this.jTable3);
/*     */     
/* 272 */     gridBagConstraints = new GridBagConstraints();
/* 273 */     gridBagConstraints.gridx = 0;
/* 274 */     gridBagConstraints.gridy = 2;
/* 275 */     gridBagConstraints.gridwidth = 5;
/* 276 */     gridBagConstraints.fill = 1;
/* 277 */     gridBagConstraints.ipadx = 5;
/* 278 */     gridBagConstraints.ipady = 5;
/* 279 */     gridBagConstraints.anchor = 1024;
/* 280 */     gridBagConstraints.weightx = 0.7D;
/* 281 */     gridBagConstraints.weighty = 0.1D;
/* 282 */     this.jPanel3.add(this.jScrollPane3, gridBagConstraints);
/*     */     
/* 284 */     this.jPanel5.add(this.jPanel3);
/*     */     
/* 286 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/* 287 */     GridBagLayout jPanel7Layout = new GridBagLayout();
/* 288 */     jPanel7Layout.columnWidths = new int[] { 0, 5, 0 };
/* 289 */     jPanel7Layout.rowHeights = new int[] { 0, 5, 0 };
/* 290 */     this.jPanel7.setLayout(jPanel7Layout);
/*     */     
/* 292 */     this.jButton2.setText("Vaciar Todo");
/* 293 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 295 */             bitacora.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/* 298 */     gridBagConstraints = new GridBagConstraints();
/* 299 */     gridBagConstraints.gridx = 0;
/* 300 */     gridBagConstraints.gridy = 0;
/* 301 */     gridBagConstraints.anchor = 21;
/* 302 */     this.jPanel7.add(this.jButton2, gridBagConstraints);
/*     */     
/* 304 */     this.jTextArea1.setEditable(false);
/* 305 */     this.jTextArea1.setColumns(20);
/* 306 */     this.jTextArea1.setRows(5);
/* 307 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/* 309 */     gridBagConstraints = new GridBagConstraints();
/* 310 */     gridBagConstraints.gridx = 0;
/* 311 */     gridBagConstraints.gridy = 2;
/* 312 */     gridBagConstraints.gridwidth = 3;
/* 313 */     gridBagConstraints.fill = 1;
/* 314 */     gridBagConstraints.weightx = 0.2D;
/* 315 */     gridBagConstraints.weighty = 0.1D;
/* 316 */     this.jPanel7.add(this.jScrollPane1, gridBagConstraints);
/*     */     
/* 318 */     this.jLabel49.setFont(new Font("Tahoma", 2, 11));
/* 319 */     this.jLabel49.setForeground(new Color(204, 0, 0));
/* 320 */     this.jLabel49.setHorizontalAlignment(0);
/* 321 */     this.jLabel49.setText("Éstos son los datos que fueron modificados");
/* 322 */     gridBagConstraints = new GridBagConstraints();
/* 323 */     gridBagConstraints.gridx = 2;
/* 324 */     gridBagConstraints.gridy = 0;
/* 325 */     gridBagConstraints.fill = 2;
/* 326 */     this.jPanel7.add(this.jLabel49, gridBagConstraints);
/*     */     
/* 328 */     this.jPanel5.add(this.jPanel7);
/*     */     
/* 330 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 331 */     this.jPanel1.setLayout(jPanel1Layout);
/* 332 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 334 */         .addComponent(this.jLabel54, -1, -1, 32767)
/* 335 */         .addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
/* 336 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 337 */         .addComponent(this.jPanel5, -1, 982, 32767));
/*     */     
/* 339 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 340 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 341 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 342 */           .addContainerGap()
/* 343 */           .addComponent(this.jLabel54)
/* 344 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 345 */           .addComponent(this.jLabel4, -2, -1, -2)
/* 346 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 347 */           .addComponent(this.jPanel17, -2, 79, -2)
/* 348 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 349 */           .addComponent(this.jPanel5, -1, 250, 32767)));
/*     */ 
/*     */     
/* 352 */     GroupLayout layout = new GroupLayout(this);
/* 353 */     setLayout(layout);
/* 354 */     layout.setHorizontalGroup(layout
/* 355 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 356 */         .addGap(0, 1010, 32767)
/* 357 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 358 */           .addGroup(layout.createSequentialGroup()
/* 359 */             .addGap(0, 0, 32767)
/* 360 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 361 */             .addGap(0, 0, 32767))));
/*     */     
/* 363 */     layout.setVerticalGroup(layout
/* 364 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 365 */         .addGap(0, 464, 32767)
/* 366 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 367 */           .addGroup(layout.createSequentialGroup()
/* 368 */             .addGap(19, 19, 19)
/* 369 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 370 */             .addGap(19, 19, 19))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 375 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 379 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3MouseClicked(MouseEvent evt) {
/* 383 */     int ind = this.jTable3.getSelectedRow();
/* 384 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 385 */     consultar2();
/*     */   }
/*     */   
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 389 */     consultar();
/*     */   }
/*     */   
/*     */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 393 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTable3KeyReleased(KeyEvent evt) {
/* 397 */     consultar2();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 401 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 405 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/*     */     try {
/* 410 */       if (!this.jTable3.print());
/*     */ 
/*     */     
/*     */     }
/* 414 */     catch (PrinterException printerException) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 419 */     int res = JOptionPane.showConfirmDialog(this, "<html><b>Una vez eliminados los datos no se pueden recuperar<hr>¿Estás seguro que deseas vaciar la bitácora del sistema?<b></html>", "Eliminar Bitácora", 0, 3, this.PREG);
/* 420 */     if (res == 0)
/* 421 */       this.con.eliminar2("bitacora", ""); 
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 425 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 427 */             bitacora.this.jTextGanado(bitacora.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 430 */             bitacora.this.jTextPerdido(bitacora.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 433 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 435 */             bitacora.this.jTextGanado(bitacora.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 438 */             bitacora.this.jTextPerdido(bitacora.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 441 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 443 */             bitacora.this.jTextGanado(bitacora.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 446 */             bitacora.this.jTextPerdido(bitacora.this.jComboBox1, evt);
/*     */           }
/*     */         });
/* 449 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 451 */             bitacora.this.jTextGanado(bitacora.this.jComboBox2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 454 */             bitacora.this.jTextPerdido(bitacora.this.jComboBox2, evt);
/*     */           }
/*     */         });
/* 457 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 459 */             bitacora.this.jTextGanado(bitacora.this.jComboBox3, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 462 */             bitacora.this.jTextPerdido(bitacora.this.jComboBox3, evt);
/*     */           }
/*     */         });
/* 465 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 467 */             bitacora.this.jTextGanado(bitacora.this.jComboBox4, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 470 */             bitacora.this.jTextPerdido(bitacora.this.jComboBox4, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 475 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 478 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 482 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 483 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 484 */       setCursor(micursor);
/*     */     }
/* 486 */     catch (Exception e) {
/* 487 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void bita(String usu) {
/* 491 */     this.USUARIO = usu;
/* 492 */     this.panel.setViewportView(this);
/* 493 */     consultar();
/*     */   }
/*     */   public void llenarCombos() {
/* 496 */     this.con.consultar("count(nombre_usu)", "usuarios", "where nombre_usu<>'usuarioadmin1'");
/* 497 */     String[] depa = this.con.regresaCol("nombre_usu", "usuarios", "where nombre_usu<>'usuarioadmin1'", Integer.parseInt(this.con.Campo));
/* 498 */     this.jComboBox1.removeAllItems();
/* 499 */     this.jComboBox1.addItem("Cualquiera");
/* 500 */     for (int i = 0; i < depa.length; i++) {
/* 501 */       this.jComboBox1.addItem(depa[i]);
/*     */     }
/*     */     
/* 504 */     int año = this.fechaActual.getYear();
/* 505 */     año += 1900; int j;
/* 506 */     for (j = año; j >= 2009; j--) {
/* 507 */       this.jComboBox2.addItem(Integer.valueOf(j));
/*     */     }
/*     */     
/* 510 */     for (j = 1; j <= 12; j++) {
/* 511 */       this.jComboBox3.addItem(Integer.valueOf(j));
/*     */     }
/*     */     
/* 514 */     for (j = 1; j <= 31; j++) {
/* 515 */       this.jComboBox4.addItem(Integer.valueOf(j));
/*     */     }
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 520 */     String concepto = this.jTextField1.getText();
/* 521 */     String datos = this.jTextField2.getText();
/* 522 */     String usuario = "";
/* 523 */     String año = "";
/* 524 */     String mes = "";
/* 525 */     String dia = "";
/* 526 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 527 */       usuario = String.valueOf(this.jComboBox1.getSelectedItem());
/*     */     }
/* 529 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 530 */       año = String.valueOf(this.jComboBox2.getSelectedItem());
/*     */     }
/* 532 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 533 */       mes = String.valueOf(this.jComboBox3.getSelectedItem());
/*     */     }
/* 535 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 536 */       dia = String.valueOf(this.jComboBox4.getSelectedItem());
/*     */     }
/* 538 */     this.encontrado = this.con.consultar("count(id_bita)", "bitacora", "where usuario like '%" + usuario + "%' and year(fecha) like '%" + año + "%' and month(fecha) like '%" + mes + "%' and day(fecha) like '%" + dia + "%' and concepto like '%" + concepto + "%' and datos like '%" + datos + "%'");
/* 539 */     int totreg = Integer.parseInt(this.con.Campo);
/* 540 */     this.encontrado = this.con.consultar("count(id_bita)", "bitacora", "");
/* 541 */     String tot = this.con.Campo;
/* 542 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 543 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 544 */           .buscarReg(4, totreg, "id_bita,fecha,usuario,concepto", "bitacora", "where USUARIO like '%" + usuario + "%' and year(fecha) like '%" + año + "%' and month(fecha) like '%" + mes + "%' and day(fecha) like '%" + dia + "%' and concepto like '%" + concepto + "%' and datos like '%" + datos + "%' order by id_bita desc"), (Object[])new String[] { "Núm", "Fecha y Hora", "Usuario", "Concepto" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 549 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 553 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 556 */     this.jTable3.setShowVerticalLines(false);
/* 557 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 559 */             bitacora.this.jTable3MouseClicked(evt);
/*     */           }
/*     */         });
/* 562 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 563 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 564 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(30);
/* 565 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 566 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(120);
/* 567 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
/* 568 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
/*     */     
/* 570 */     this.jTable3.setSelectionMode(0);
/* 571 */     this.jTable3.setAutoCreateRowSorter(true);
/* 572 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*     */   }
/*     */   public void consultar2() {
/* 575 */     if (this.jTable3.getSelectedRow() > -1) {
/* 576 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 577 */       this.encontrado = this.con.consultar("datos", "bitacora", "where id_bita=" + valor);
/* 578 */       if (this.encontrado) {
/* 579 */         this.jTextArea1.setText(this.con.Campo);
/*     */       } else {
/*     */         
/* 582 */         this.jTextArea1.setText("");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/bitacora.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */