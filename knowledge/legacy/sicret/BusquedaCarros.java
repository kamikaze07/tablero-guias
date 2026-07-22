/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ 
/*     */ public class BusquedaCarros extends JPanel implements Runnable {
/*   9 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  10 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*  12 */   Date fechaActual = new Date();
/*  13 */   SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  14 */   String cadenaFecha = "";
/*     */   String año;
/*     */   int aa;
/*     */   JComboBox combo;
/*     */   JTextField texto;
/*  19 */   String condicion = ""; boolean salir = false; Thread t; private JDialog jDialog1; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel48; private JPanel jPanel1; private JPanel jPanel2; private JScrollPane jScrollPane1; private JTable jTable1; private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   
/*     */   public BusquedaCarros() {
/*  23 */     initComponents();
/*  24 */     colorear();
/*  25 */     cargarMouse();
/*  26 */     consultar();
/*     */   }
/*     */   public void start() {}
/*     */   
/*     */   public void run() {
/*  31 */     while (!this.salir) {
/*     */       try {
/*  33 */         Thread.currentThread(); Thread.sleep(1000L);
/*  34 */         this.salir = !this.jDialog1.isActive();
/*     */       }
/*  36 */       catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */     
/*  39 */     this.jDialog1.setVisible(false);
/*     */   }
/*     */   
/*     */   public void activar(JButton Buscar, JTextField texto) {
/*  43 */     this.jTextField1.setText("");
/*  44 */     this.combo = this.combo;
/*  45 */     this.texto = texto;
/*  46 */     consultar();
/*  47 */     Dimension di = Buscar.getSize();
/*  48 */     Point p = Buscar.getLocationOnScreen();
/*  49 */     this.jDialog1.setSize(315, 163);
/*  50 */     this.jDialog1.setLocation(p.x - 290, p.y + 25);
/*  51 */     this.jDialog1.setVisible(true);
/*  52 */     this.salir = false;
/*  53 */     this.t = new Thread(this);
/*  54 */     this.t.start();
/*     */   }
/*     */   public void cargarMouse() {
/*     */     try {
/*  58 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  59 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  60 */       this.jDialog1.setCursor(micursor);
/*     */     }
/*  62 */     catch (Exception e) {
/*  63 */       JOptionPane.showMessageDialog(null, e, "Depura", -1);
/*     */     } 
/*     */   }
/*     */   public void colorear() {
/*  67 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/*  69 */             BusquedaCarros.this.jTextGanado(BusquedaCarros.this.jTextField1, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/*  72 */             BusquedaCarros.this.jTextPerdido(BusquedaCarros.this.jTextField1, evt);
/*     */           }
/*     */         });
/*  75 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/*  77 */             BusquedaCarros.this.jTextGanado(BusquedaCarros.this.jTextField2, evt);
/*     */           }
/*     */           public void focusLost(FocusEvent evt) {
/*  80 */             BusquedaCarros.this.jTextPerdido(BusquedaCarros.this.jTextField2, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  85 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  88 */     campo.setBackground(Color.white);
/*     */   }
/*     */   public void consultar() {
/*  91 */     String num = this.jTextField1.getText();
/*  92 */     String placas = this.jTextField2.getText();
/*  93 */     this.encontrado = this.con.consultar("count(placas)", "tracto", "where num_tracto like '%" + num + "%' and placas like '%" + placas + "%' and num_tracto<>0");
/*  94 */     int totreg = Integer.parseInt(this.con.Campo);
/*  95 */     this.encontrado = this.con.consultar("count(placas)", "tracto", "where num_tracto<>0");
/*  96 */     String tot = this.con.Campo;
/*  97 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/*  98 */     this.jTable1.setFont(new Font("Tahoma", 0, 9));
/*  99 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 100 */           .buscarReg(3, totreg, "num_tracto,placas,fecha", "tracto", "where num_tracto like '%" + num + "%' and placas like '%" + placas + "%' and num_tracto<>0"), (Object[])new String[] { "Número", "Placas", "Fecha Ingreso", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 105 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 108 */           boolean[] canEdit = new boolean[] { false, false, false, true };
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 112 */             return this.types[columnIndex];
/*     */           }
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 115 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 118 */     this.jTable1.setShowVerticalLines(false);
/* 119 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 120 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(50);
/* 121 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 122 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 123 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(30);
/* 124 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
/* 125 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(30);
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/* 130 */     this.jDialog1 = new JDialog();
/* 131 */     this.jPanel1 = new JPanel();
/* 132 */     this.jScrollPane1 = new JScrollPane();
/* 133 */     this.jTable1 = new JTable();
/* 134 */     this.jLabel48 = new JLabel();
/* 135 */     this.jPanel2 = new JPanel();
/* 136 */     this.jTextField2 = new JTextField();
/* 137 */     this.jLabel15 = new JLabel();
/* 138 */     this.jTextField1 = new JTextField();
/* 139 */     this.jLabel14 = new JLabel();
/*     */     
/* 141 */     this.jDialog1.setUndecorated(true);
/*     */     
/* 143 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/* 144 */     this.jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, new Color(0, 0, 0)));
/*     */     
/* 146 */     this.jTable1.setFont(new Font("Tahoma", 0, 8));
/* 147 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Número", "Placas", "Fecha Ingreso", "" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 155 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Boolean.class };
/*     */ 
/*     */           
/* 158 */           boolean[] canEdit = new boolean[] { false, false, false, true };
/*     */ 
/*     */ 
/*     */           
/*     */           public Class getColumnClass(int columnIndex) {
/* 163 */             return this.types[columnIndex];
/*     */           }
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 167 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 170 */     this.jTable1.setShowVerticalLines(false);
/* 171 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 173 */             BusquedaCarros.this.jTable1MouseClicked(evt);
/*     */           }
/*     */         });
/* 176 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 177 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(30);
/* 178 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
/* 179 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(30);
/*     */     
/* 181 */     this.jLabel48.setFont(new Font("Tahoma", 2, 9));
/* 182 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/* 183 */     this.jLabel48.setHorizontalAlignment(2);
/* 184 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*     */     
/* 186 */     this.jPanel2.setBackground(new Color(146, 214, 169));
/*     */     
/* 188 */     this.jTextField2.setFont(new Font("Tahoma", 0, 9));
/* 189 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 191 */             BusquedaCarros.this.jTextField2KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 195 */     this.jLabel15.setFont(new Font("Tahoma", 2, 9));
/* 196 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 197 */     this.jLabel15.setHorizontalAlignment(4);
/* 198 */     this.jLabel15.setText("Placas");
/*     */     
/* 200 */     this.jTextField1.setFont(new Font("Tahoma", 0, 9));
/* 201 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 203 */             BusquedaCarros.this.jTextField1KeyReleased(evt);
/*     */           }
/*     */         });
/*     */     
/* 207 */     this.jLabel14.setFont(new Font("Tahoma", 2, 9));
/* 208 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/* 209 */     this.jLabel14.setHorizontalAlignment(4);
/* 210 */     this.jLabel14.setText("Número");
/*     */     
/* 212 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 213 */     this.jPanel2.setLayout(jPanel2Layout);
/* 214 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 215 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 216 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 217 */           .addContainerGap()
/* 218 */           .addComponent(this.jLabel14, -2, 33, -2)
/* 219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 220 */           .addComponent(this.jTextField1, -2, 55, -2)
/* 221 */           .addGap(31, 31, 31)
/* 222 */           .addComponent(this.jLabel15, -2, 47, -2)
/* 223 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 224 */           .addComponent(this.jTextField2, -2, 55, -2)
/* 225 */           .addContainerGap(54, 32767)));
/*     */     
/* 227 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 229 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 230 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 231 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 232 */             .addComponent(this.jLabel15)
/* 233 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 234 */             .addComponent(this.jLabel14))
/* 235 */           .addContainerGap(6, 32767)));
/*     */ 
/*     */     
/* 238 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 239 */     this.jPanel1.setLayout(jPanel1Layout);
/* 240 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 241 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 242 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 243 */         .addComponent(this.jScrollPane1, -1, 293, 32767)
/* 244 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 245 */           .addContainerGap(138, 32767)
/* 246 */           .addComponent(this.jLabel48, -2, 155, -2)));
/*     */     
/* 248 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 249 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 250 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 251 */           .addComponent(this.jPanel2, -2, 23, -2)
/* 252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 253 */           .addComponent(this.jScrollPane1, -2, 113, -2)
/* 254 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 255 */           .addComponent(this.jLabel48, -1, -1, 32767)
/* 256 */           .addContainerGap()));
/*     */ 
/*     */     
/* 259 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 260 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 261 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 263 */         .addComponent(this.jPanel1, -2, -1, -2));
/*     */     
/* 265 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 266 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 267 */         .addComponent(this.jPanel1, -2, 162, -2));
/*     */ 
/*     */     
/* 270 */     GroupLayout layout = new GroupLayout(this);
/* 271 */     setLayout(layout);
/* 272 */     layout.setHorizontalGroup(layout
/* 273 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 274 */         .addGap(0, 400, 32767));
/*     */     
/* 276 */     layout.setVerticalGroup(layout
/* 277 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 278 */         .addGap(0, 300, 32767));
/*     */   }
/*     */   
/*     */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 282 */     consultar();
/*     */   }
/*     */   private void jTable1MouseClicked(MouseEvent evt) {
/* 285 */     int indice = this.jTable1.getSelectedRow();
/* 286 */     if (indice > -1) {
/* 287 */       String val = String.valueOf(this.jTable1.getValueAt(indice, 3));
/* 288 */       if (val.equals("true")) {
/* 289 */         String valor = String.valueOf(this.jTable1.getValueAt(indice, 0));
/* 290 */         this.texto.setText(valor);
/* 291 */         this.salir = true;
/* 292 */         this.jDialog1.setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 297 */     consultar();
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/BusquedaCarros.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */