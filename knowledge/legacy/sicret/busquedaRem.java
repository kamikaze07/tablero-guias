/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class busquedaRem extends JPanel implements Runnable {
/*  17 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  18 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*  20 */   Date fechaActual = new Date();
/*  21 */   SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  22 */   String cadenaFecha = "";
/*     */   String año;
/*     */   int aa;
/*     */   JComboBox combo;
/*     */   JTextField texto;
/*  27 */   String condicion = ""; boolean salir = false; Thread t; private JComboBox jComboBox1; private JDialog jDialog1; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel48; private JPanel jPanel1; private JPanel jPanel2; private JScrollPane jScrollPane1; private JTable jTable1; private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   
/*     */   public busquedaRem() {
/*  31 */     initComponents();
/*  32 */     colorear();
/*  33 */     cargarMouse();
/*  34 */     consultar();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  39 */     this.jDialog1 = new JDialog();
/*  40 */     this.jPanel1 = new JPanel();
/*  41 */     this.jScrollPane1 = new JScrollPane();
/*  42 */     this.jTable1 = new JTable();
/*  43 */     this.jLabel48 = new JLabel();
/*  44 */     this.jPanel2 = new JPanel();
/*  45 */     this.jTextField2 = new JTextField();
/*  46 */     this.jLabel15 = new JLabel();
/*  47 */     this.jTextField1 = new JTextField();
/*  48 */     this.jLabel14 = new JLabel();
/*  49 */     this.jLabel16 = new JLabel();
/*  50 */     this.jComboBox1 = new JComboBox();
/*     */     
/*  52 */     this.jDialog1.setUndecorated(true);
/*     */     
/*  54 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*  55 */     this.jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, new Color(0, 0, 0)));
/*     */     
/*  57 */     this.jTable1.setFont(new Font("Tahoma", 0, 8));
/*  58 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Número", "Placas", "Fecha Ingreso", "Tipo", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  66 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/*  69 */           boolean[] canEdit = new boolean[] { false, false, false, false, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/*  74 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  78 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/*  81 */     this.jTable1.setShowVerticalLines(false);
/*  82 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/*  84 */             busquedaRem.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/*  87 */     this.jScrollPane1.setViewportView(this.jTable1);
/*     */     
/*  89 */     this.jLabel48.setFont(new Font("Tahoma", 2, 9));
/*  90 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/*  91 */     this.jLabel48.setHorizontalAlignment(2);
/*  92 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/*  94 */     this.jPanel2.setBackground(new Color(146, 214, 169));
/*     */     
/*  96 */     this.jTextField2.setFont(new Font("Tahoma", 0, 9));
/*  97 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/*  99 */             busquedaRem.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 103 */     this.jLabel15.setFont(new Font("Tahoma", 2, 9));
/* 104 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 105 */     this.jLabel15.setHorizontalAlignment(4);
/* 106 */     this.jLabel15.setText("Placas");
/*     */     
/* 108 */     this.jTextField1.setFont(new Font("Tahoma", 0, 9));
/* 109 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 111 */             busquedaRem.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 114 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 116 */             busquedaRem.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 120 */     this.jLabel14.setFont(new Font("Tahoma", 2, 9));
/* 121 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/* 122 */     this.jLabel14.setHorizontalAlignment(4);
/* 123 */     this.jLabel14.setText("Número");
/*     */     
/* 125 */     this.jLabel16.setFont(new Font("Tahoma", 2, 9));
/* 126 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 127 */     this.jLabel16.setHorizontalAlignment(4);
/* 128 */     this.jLabel16.setText("Tipo");
/*     */     
/* 130 */     this.jComboBox1.setFont(new Font("Tahoma", 0, 9));
/* 131 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Gondola", "Pipa" }));
/* 132 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 134 */             busquedaRem.this.jComboBox1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 138 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 139 */     this.jPanel2.setLayout(jPanel2Layout);
/* 140 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 141 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 142 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 143 */           .addComponent(this.jLabel16, -2, 25, -2)
/* 144 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 145 */           .addComponent(this.jComboBox1, -2, 76, -2)
/* 146 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 147 */           .addComponent(this.jLabel14, -2, 33, -2)
/* 148 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 149 */           .addComponent(this.jTextField1, -2, 55, -2)
/* 150 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 151 */           .addComponent(this.jLabel15, -2, 28, -2)
/* 152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 153 */           .addComponent(this.jTextField2, -2, 55, -2)
/* 154 */           .addContainerGap(20, 32767)));
/*     */     
/* 156 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 157 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 158 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 159 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 160 */             .addComponent(this.jLabel16)
/* 161 */             .addComponent(this.jComboBox1, -2, -1, -2)
/* 162 */             .addComponent(this.jLabel14)
/* 163 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 164 */             .addComponent(this.jLabel15)
/* 165 */             .addComponent(this.jTextField2, -2, -1, -2))
/* 166 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 169 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 170 */     this.jPanel1.setLayout(jPanel1Layout);
/* 171 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 172 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 173 */         .addComponent(this.jScrollPane1, -1, 312, 32767)
/* 174 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 175 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 176 */           .addContainerGap()
/* 177 */           .addComponent(this.jLabel48, -2, 155, -2)));
/*     */     
/* 179 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 181 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 182 */           .addComponent(this.jPanel2, -2, 23, -2)
/* 183 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 184 */           .addComponent(this.jScrollPane1, -2, 113, -2)
/* 185 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 186 */           .addComponent(this.jLabel48, -1, -1, 32767)));
/*     */ 
/*     */     
/* 189 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 190 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 191 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 192 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 193 */         .addComponent(this.jPanel1, -2, -1, -2));
/*     */     
/* 195 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 196 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 197 */         .addComponent(this.jPanel1, -2, -1, -2));
/*     */ 
/*     */     
/* 200 */     GroupLayout layout = new GroupLayout(this);
/* 201 */     setLayout(layout);
/* 202 */     layout.setHorizontalGroup(layout
/* 203 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 204 */         .addGap(0, 400, 32767));
/*     */     
/* 206 */     layout.setVerticalGroup(layout
/* 207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 208 */         .addGap(0, 300, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt) {
/* 213 */     int indice = this.jTable1.getSelectedRow();
/* 214 */     if (indice > -1) {
/* 215 */       String val = String.valueOf(this.jTable1.getValueAt(indice, 4));
/* 216 */       if (val.equals("true")) {
/* 217 */         String valor = String.valueOf(this.jTable1.getValueAt(indice, 0));
/* 218 */         this.texto.setText(valor);
/* 219 */         this.salir = true;
/* 220 */         this.jDialog1.setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 225 */     consultar();
/*     */   }
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 228 */     consultar();
/*     */   }
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 234 */     consultar();
/*     */   }
/*     */   public void colorear() {
/* 237 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 239 */             busquedaRem.this.jTextGanado(busquedaRem.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 242 */             busquedaRem.this.jTextPerdido(busquedaRem.this.jTextField1, evt);
/*     */           }
/*     */         });
/* 245 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 247 */             busquedaRem.this.jTextGanado(busquedaRem.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 250 */             busquedaRem.this.jTextPerdido(busquedaRem.this.jTextField2, evt);
/*     */           }
/*     */         });
/* 253 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 255 */             busquedaRem.this.jTextGanado(busquedaRem.this.jComboBox1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/* 258 */             busquedaRem.this.jTextPerdido(busquedaRem.this.jComboBox1, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 263 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 266 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/* 269 */     String tipo = this.jComboBox1.getSelectedItem().toString();
/* 270 */     String num = this.jTextField1.getText();
/* 271 */     String placas = this.jTextField2.getText();
/* 272 */     if (tipo.equals("Todos")) {
/* 273 */       tipo = "";
/*     */     }
/* 275 */     this.encontrado = this.con.consultar("count(placas)", "remolque", "where num_rem like '%" + num + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and num_rem<>0");
/* 276 */     int totreg = Integer.parseInt(this.con.Campo);
/* 277 */     this.encontrado = this.con.consultar("count(placas)", "remolque", "where num_rem<>0");
/* 278 */     String tot = this.con.Campo;
/* 279 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 280 */     this.jTable1.setFont(new Font("Tahoma", 0, 9));
/* 281 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 282 */           .buscarReg(4, totreg, "num_rem,placas,fecha,tipo", "remolque", "where num_rem like '%" + num + "%' and placas like '%" + placas + "%' and tipo like '%" + tipo + "%' and num_rem<>0"), (Object[])new String[] { "Núm", "Placas", "Fecha Ingreso", "Tipo", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 287 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 290 */           boolean[] canEdit = new boolean[] { false, false, false, false, true };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 294 */             return this.types[columnIndex];
/*     */           }
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 297 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 300 */     this.jTable1.setShowVerticalLines(false);
/* 301 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 302 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(30);
/* 303 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
/* 304 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
/* 305 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(70);
/* 306 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 307 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
/* 308 */     this.jTable1.getColumnModel().getColumn(4).setMinWidth(30);
/* 309 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 310 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(30);
/*     */   }
/*     */   public void activar(JButton Buscar, JTextField texto) {
/* 313 */     this.jTextField1.setText("");
/* 314 */     this.texto = texto;
/* 315 */     consultar();
/* 316 */     Dimension di = Buscar.getSize();
/* 317 */     Point p = Buscar.getLocationOnScreen();
/* 318 */     this.jDialog1.setSize(355, 163);
/* 319 */     this.jDialog1.setLocation(p.x - 290, p.y + 25);
/* 320 */     this.jDialog1.setVisible(true);
/* 321 */     this.salir = false;
/* 322 */     this.t = new Thread(this);
/* 323 */     this.t.start();
/*     */   }
/*     */   public void start() {}
/*     */   
/*     */   public void run() {
/* 328 */     while (!this.salir) {
/*     */       try {
/* 330 */         Thread.currentThread(); Thread.sleep(1000L);
/* 331 */         this.salir = !this.jDialog1.isActive();
/*     */       }
/* 333 */       catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */     
/* 336 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/* 340 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 341 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 342 */       this.jDialog1.setCursor(micursor);
/*     */     }
/* 344 */     catch (Exception e) {
/* 345 */       JOptionPane.showMessageDialog(null, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/busquedaRem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */