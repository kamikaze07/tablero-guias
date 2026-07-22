/*     */ package sicret;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Paper;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ 
/*     */ public class FacturacionPendiente extends JPanel {
/*     */   JScrollPane panel;
/*  42 */   Date fechaActual = new Date(); JFrame padre;
/*  43 */   Date fechaInicio = null;
/*  44 */   Date fecha = new Date();
/*  45 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  46 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  47 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  48 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  49 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  50 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*  51 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  52 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  53 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  54 */   String USUARIO = "";
/*  55 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  56 */   Consultas con = new Consultas();
/*     */   boolean encontrado = false;
/*  58 */   String[] CLIENTES = null;
/*  59 */   String[] DIAS = null;
/*  60 */   CeldaRender celda = new CeldaRender(); EscribirReporte esc; private JFormattedTextField cantidad; private JButton jButton10; private JButton jButton11; private JButton jButton2; private JButton jButton9; private JComboBox jComboBox9; private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   
/*     */   public FacturacionPendiente(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  64 */     initComponents();
/*     */     
/*  66 */     padre = padre;
/*  67 */     fichas = fichas;
/*  68 */     initComponents();
/*     */     
/*  70 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  71 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  72 */     editFormat.setGroupingUsed(false);
/*  73 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  74 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  75 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  76 */     enFormat.setAllowsInvalid(true);
/*  77 */     this.cantidad.setFormatterFactory(currFactory);
/*     */     
/*  79 */     this.cantidad.setValue(Integer.valueOf(0));
/*     */     
/*  81 */     Image icono = this.tk.getImage(getClass().getResource("/entrada/Imagenes/calculator.png"));
/*     */     
/*  83 */     this.USUARIO = USUARIO;
/*  84 */     panelito.setViewportView(this);
/*  85 */     this.panel = panelito;
/*  86 */     colorear();
/*  87 */     llenarCombo();
/*     */     
/*  89 */     this.con.consultar("count(cliente)", "facturasvencidas", "");
/*  90 */     this.CLIENTES = this.con.regresaCol("cliente", "facturasvencidas", "", Integer.parseInt(this.con.Campo));
/*  91 */     this.DIAS = this.con.regresaCol("dias", "facturasvencidas", "", Integer.parseInt(this.con.Campo));
/*  92 */     for (int i = 0; i < this.DIAS.length; i++)
/*  93 */       System.out.println("CLientes " + this.CLIENTES[i] + " " + this.DIAS[i]); 
/*     */   }
/*     */   private JLabel jLabel35; private JLabel jLabel4; private JLabel jLabel42; private JLabel jLabel48; private JPanel jPanel7; private JScrollPane jScrollPane2; private JSeparator jSeparator1; private JSpinner jSpinner1;
/*     */   private JTable jTable2;
/*     */   
/*     */   private void initComponents() {
/*  99 */     this.cantidad = new JFormattedTextField();
/* 100 */     this.jPanel7 = new JPanel();
/* 101 */     this.jLabel4 = new JLabel();
/* 102 */     this.jSeparator1 = new JSeparator();
/* 103 */     this.jLabel1 = new JLabel();
/* 104 */     this.jComboBox9 = new JComboBox();
/* 105 */     this.jScrollPane2 = new JScrollPane();
/* 106 */     this.jTable2 = new JTable();
/* 107 */     this.jButton2 = new JButton();
/* 108 */     this.jLabel48 = new JLabel();
/* 109 */     this.jButton9 = new JButton();
/* 110 */     this.jButton10 = new JButton();
/* 111 */     this.jButton11 = new JButton();
/* 112 */     this.jLabel35 = new JLabel();
/* 113 */     this.jLabel42 = new JLabel();
/* 114 */     this.jLabel2 = new JLabel();
/* 115 */     this.jSpinner1 = new JSpinner();
/*     */     
/* 117 */     this.cantidad.setText("jFormattedTextField1");
/*     */     
/* 119 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/* 120 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/* 122 */     this.jLabel4.setFont(new Font("Times New Roman", 1, 22));
/* 123 */     this.jLabel4.setHorizontalAlignment(0);
/* 124 */     this.jLabel4.setText("FACTURAS VENCIDAS");
/*     */     
/* 126 */     this.jLabel1.setText("Selecciona el cliente:");
/*     */     
/* 128 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 129 */     this.jComboBox9.setFont(new Font("Tahoma", 0, 10));
/* 130 */     this.jComboBox9.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 132 */             FacturacionPendiente.this.jComboBox9ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 137 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Cliente", "Factura", "Fecha de Factura", "Fecha de Vencimiento", "Días de Crédito", "Días de retrazo", "Estatus", "Total" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 145 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, true, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 150 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 153 */     this.jTable2.setShowVerticalLines(false);
/* 154 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 156 */             FacturacionPendiente.this.jTable2MouseClicked(evt);
/*     */           }
/*     */         });
/* 159 */     this.jScrollPane2.setViewportView(this.jTable2);
/*     */     
/* 161 */     this.jButton2.setMnemonic('C');
/* 162 */     this.jButton2.setText(" Consultar");
/* 163 */     this.jButton2.setToolTipText("Consultar (Alt+C)");
/* 164 */     this.jButton2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 166 */             FacturacionPendiente.this.jButton2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 170 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 171 */     this.jLabel48.setForeground(Color.red);
/* 172 */     this.jLabel48.setHorizontalAlignment(0);
/* 173 */     this.jLabel48.setText("TOTAL 0");
/* 174 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 176 */     this.jButton9.setMnemonic('U');
/* 177 */     this.jButton9.setText("Guardar");
/* 178 */     this.jButton9.setToolTipText("Guardar(Alt+U)");
/* 179 */     this.jButton9.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 181 */             FacturacionPendiente.this.jButton9ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 185 */     this.jButton10.setMnemonic('I');
/* 186 */     this.jButton10.setText("Imprimir");
/* 187 */     this.jButton10.setToolTipText("Imprimir (Alt+I)");
/* 188 */     this.jButton10.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 190 */             FacturacionPendiente.this.jButton10ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 194 */     this.jButton11.setMnemonic('E');
/* 195 */     this.jButton11.setText("Enviar por correo");
/* 196 */     this.jButton11.setToolTipText("Enviar por correo(Alt+E)");
/* 197 */     this.jButton11.setEnabled(false);
/* 198 */     this.jButton11.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 200 */             FacturacionPendiente.this.jButton11ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 204 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 205 */     this.jLabel35.setHorizontalAlignment(4);
/* 206 */     this.jLabel35.setText("TOTAL:");
/*     */     
/* 208 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/* 209 */     this.jLabel42.setForeground(Color.red);
/* 210 */     this.jLabel42.setHorizontalAlignment(4);
/* 211 */     this.jLabel42.setText("$0.00");
/*     */     
/* 213 */     this.jLabel2.setHorizontalAlignment(4);
/* 214 */     this.jLabel2.setText("Días de Cŕedito:");
/*     */     
/* 216 */     this.jSpinner1.setModel(new SpinnerNumberModel(0, 0, 120, 1));
/*     */     
/* 218 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 219 */     this.jPanel7.setLayout(jPanel7Layout);
/* 220 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 221 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 222 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 223 */           .addContainerGap()
/* 224 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 225 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 226 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 227 */                 .addComponent(this.jSeparator1)
/* 228 */                 .addComponent(this.jLabel4, -1, -1, 32767)
/* 229 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 230 */                   .addComponent(this.jLabel1, -2, 130, -2)
/* 231 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 232 */                   .addComponent(this.jComboBox9, -2, 389, -2)
/* 233 */                   .addGap(44, 44, 44)
/* 234 */                   .addComponent(this.jLabel2, -2, 130, -2)
/* 235 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 236 */                   .addComponent(this.jSpinner1, -2, -1, -2)
/* 237 */                   .addGap(39, 39, 39)
/* 238 */                   .addComponent(this.jButton2, -2, 108, -2)
/* 239 */                   .addGap(0, 0, 32767))
/* 240 */                 .addComponent(this.jScrollPane2))
/* 241 */               .addGap(11, 11, 11))
/* 242 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 243 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 244 */               .addGap(18, 18, 18)
/* 245 */               .addComponent(this.jButton11, -2, 123, -2)
/* 246 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 247 */               .addComponent(this.jButton10, -2, 100, -2)
/* 248 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 249 */               .addComponent(this.jButton9, -2, 100, -2)
/* 250 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 347, 32767)
/* 251 */               .addComponent(this.jLabel35, -2, 68, -2)
/* 252 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 253 */               .addComponent(this.jLabel42, -2, 153, -2)
/* 254 */               .addGap(28, 28, 28)))));
/*     */     
/* 256 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 257 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 258 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 259 */           .addComponent(this.jLabel4)
/* 260 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 261 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 262 */           .addGap(8, 8, 8)
/* 263 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 264 */             .addComponent(this.jLabel1)
/* 265 */             .addComponent(this.jComboBox9, -2, -1, -2)
/* 266 */             .addComponent(this.jButton2)
/* 267 */             .addComponent(this.jLabel2)
/* 268 */             .addComponent(this.jSpinner1, -2, -1, -2))
/* 269 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 270 */           .addComponent(this.jScrollPane2, -1, 231, 32767)
/* 271 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 272 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 273 */             .addComponent(this.jLabel48)
/* 274 */             .addComponent(this.jLabel42)
/* 275 */             .addComponent(this.jLabel35)
/* 276 */             .addComponent(this.jButton9)
/* 277 */             .addComponent(this.jButton11)
/* 278 */             .addComponent(this.jButton10))
/* 279 */           .addContainerGap()));
/*     */ 
/*     */     
/* 282 */     GroupLayout layout = new GroupLayout(this);
/* 283 */     setLayout(layout);
/* 284 */     layout.setHorizontalGroup(layout
/* 285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 286 */         .addGroup(layout.createSequentialGroup()
/* 287 */           .addGap(10, 10, 10)
/* 288 */           .addComponent(this.jPanel7, -1, -1, 32767)
/* 289 */           .addGap(10, 10, 10)));
/*     */     
/* 291 */     layout.setVerticalGroup(layout
/* 292 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 293 */         .addGroup(layout.createSequentialGroup()
/* 294 */           .addContainerGap()
/* 295 */           .addComponent(this.jPanel7, -1, -1, 32767)
/* 296 */           .addContainerGap()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jComboBox9ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTable2MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 309 */     consultar();
/*     */   }
/*     */   
/*     */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 313 */     String[] datos = { "CLIENTE", "FACTURA", "FECHA DE FACT", "DIAS DE CREDITO", "FECHA LIMITE", "DIAS DE RETRAZO", "ESTATUS", "TOTAL" };
/* 314 */     this.esc = new EscribirReporte("EMPLEADOS", this.jTable2, datos, this.USUARIO);
/*     */   }
/*     */   
/*     */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 318 */     ImprimirFacturas imprimir = new ImprimirFacturas();
/* 319 */     imprimir.recibeDatos();
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton11ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   public void consultar() {
/* 327 */     boolean correcto = true;
/* 328 */     GregorianCalendar t1 = new GregorianCalendar();
/* 329 */     Date fecha1 = new Date();
/* 330 */     t1.setTime(fecha1);
/*     */     
/* 332 */     String cliente = String.valueOf(this.jComboBox9.getSelectedItem());
/* 333 */     String consulta = "";
/* 334 */     if (this.jComboBox9.getSelectedIndex() == 0) {
/* 335 */       cliente = "";
/*     */       
/* 337 */       for (int j = 0; j < this.CLIENTES.length; j++) {
/* 338 */         int days = Integer.parseInt(this.jSpinner1.getValue().toString());
/*     */         
/* 340 */         GregorianCalendar c = new GregorianCalendar();
/* 341 */         c.setTime(new Date());
/* 342 */         c.roll(6, -days);
/* 343 */         Date fechaVencida = c.getTime();
/* 344 */         Date fechaAct = new Date();
/*     */         
/* 346 */         if (fechaVencida.after(fechaAct)) {
/* 347 */           c.roll(1, -1);
/* 348 */           fechaVencida = c.getTime();
/*     */         } 
/*     */ 
/*     */         
/* 352 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 353 */         String cadenaFecha = "";
/* 354 */         cadenaFecha = formato.format(fechaVencida);
/* 355 */         String AÑO = cadenaFecha.substring(0, 4);
/* 356 */         String MES = cadenaFecha.substring(4, 6);
/* 357 */         String DIA = cadenaFecha.substring(6, 8);
/* 358 */         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*     */ 
/*     */         
/* 361 */         consulta = consulta + " cliente like '%" + consulta + "%' and fecha < " + this.CLIENTES[j];
/* 362 */         if (this.CLIENTES.length - 1 > j) {
/* 363 */           consulta = consulta + " or ";
/*     */         }
/*     */       } 
/*     */     } else {
/* 367 */       int ind = this.jComboBox9.getSelectedIndex();
/* 368 */       ind--;
/*     */       
/* 370 */       int days = Integer.parseInt(this.jSpinner1.getValue().toString());
/* 371 */       GregorianCalendar c = new GregorianCalendar();
/* 372 */       c.setTime(new Date());
/* 373 */       c.roll(6, -days);
/* 374 */       Date fechaVencida = c.getTime();
/* 375 */       Date fechaAct = new Date();
/*     */       
/* 377 */       if (fechaVencida.after(fechaAct)) {
/* 378 */         c.roll(1, -1);
/* 379 */         fechaVencida = c.getTime();
/*     */       } 
/*     */       
/* 382 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 383 */       String cadenaFecha = "";
/* 384 */       cadenaFecha = formato.format(fechaVencida);
/* 385 */       String AÑO = cadenaFecha.substring(0, 4);
/* 386 */       String MES = cadenaFecha.substring(4, 6);
/* 387 */       String DIA = cadenaFecha.substring(6, 8);
/* 388 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*     */       
/* 390 */       consulta = " cliente like '%" + String.valueOf(this.jComboBox9.getSelectedItem()) + "%' and fecha< " + fechaCompleta1;
/*     */     } 
/*     */     
/* 393 */     this.encontrado = this.con.consultar("count(folio)", "facturas", "where (estatus like '%<Por Pagar%' || estatus like '%<Abono%') and (" + consulta + ") order by fecha asc");
/*     */     
/* 395 */     int totreg = Integer.parseInt(this.con.Campo);
/* 396 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/*     */     
/* 398 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 399 */           .buscarReg(5, totreg, "cliente,folio,fecha,total,estatus", "facturas", "where (estatus like '%<Por Pagar%' || estatus like '%<Abono%') and (" + consulta + ") order by cliente asc, fecha asc"), (Object[])new String[] { "Cliente", "Factura", "Fecha de Fact", "Total", "Estatus", "Dias de Crédito", "Días de Retrazo", "Fecha Limite" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 405 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 410 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/*     */     
/* 414 */     this.jTable2.moveColumn(5, 3);
/* 415 */     this.jTable2.moveColumn(5, 4);
/* 416 */     this.jTable2.moveColumn(6, 4);
/* 417 */     this.jTable2.moveColumn(7, 4);
/*     */     
/* 419 */     this.jLabel42.setText("$0.00");
/* 420 */     double valorT = 0.0D;
/* 421 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 422 */       String canti = String.valueOf(this.jTable2.getValueAt(i, 7));
/* 423 */       String valorP = "";
/*     */       
/* 425 */       for (int j = 0; j < canti.length(); j++) {
/* 426 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 427 */           valorP = valorP + valorP;
/*     */         }
/*     */       } 
/* 430 */       valorT += Double.parseDouble(valorP);
/* 431 */       this.cantidad.setValue(Double.valueOf(valorT));
/* 432 */       this.jLabel42.setText(this.cantidad.getText());
/*     */       
/* 434 */       String clienteR = String.valueOf(this.jTable2.getValueAt(i, 0));
/* 435 */       for (int k = 0; k < this.CLIENTES.length; k++) {
/* 436 */         if (this.CLIENTES[k].equals(clienteR)) {
/* 437 */           this.jTable2.setValueAt(this.DIAS[k], i, 3);
/*     */ 
/*     */           
/* 440 */           String fecha = String.valueOf(this.jTable2.getValueAt(i, 2));
/* 441 */           String fechaCorta = fecha.substring(0, 10);
/*     */           
/* 443 */           String año = fechaCorta.substring(0, 4);
/* 444 */           String mes = fechaCorta.substring(5, 7);
/* 445 */           String dia = fechaCorta.substring(8, 10);
/* 446 */           SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 447 */           String strFecha = dia + "-" + dia + "-" + mes;
/* 448 */           Date fechaFact = null;
/*     */           try {
/* 450 */             fechaFact = formatoDelTexto.parse(strFecha);
/* 451 */           } catch (ParseException ex) {
/* 452 */             ex.printStackTrace();
/*     */           } 
/*     */           
/* 455 */           int days = Integer.parseInt(this.DIAS[k]);
/* 456 */           GregorianCalendar c = new GregorianCalendar();
/* 457 */           c.setTime(fechaFact);
/*     */           
/* 459 */           c.add(5, days);
/*     */           
/* 461 */           Date fechaLimite = c.getTime();
/* 462 */           c.setTime(fechaLimite);
/*     */           
/* 464 */           GregorianCalendar date1 = c;
/* 465 */           GregorianCalendar date2 = new GregorianCalendar();
/* 466 */           date2.setTime(new Date());
/*     */           
/* 468 */           int diasAnyo = 0;
/* 469 */           int rangoAnyos = 0;
/* 470 */           int rango = 0;
/*     */           
/* 472 */           if (date1.get(1) == date2.get(1)) {
/* 473 */             rango = date2.get(6) - date1.get(6);
/*     */           } else {
/* 475 */             diasAnyo = date1.isLeapYear(date1.get(1)) ? 366 : 365;
/* 476 */             rangoAnyos = date2.get(1) - date1.get(1);
/* 477 */             rango = rangoAnyos * diasAnyo + date2.get(6) - date1.get(6);
/*     */           } 
/*     */           
/* 480 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 481 */           String cadenaFecha1 = formato.format(c.getTime());
/* 482 */           año = cadenaFecha1.substring(0, 4);
/* 483 */           mes = cadenaFecha1.substring(4, 6);
/* 484 */           dia = cadenaFecha1.substring(6, 8);
/* 485 */           String fechaCompleta = año + "-" + año + "-" + mes;
/*     */ 
/*     */           
/* 488 */           this.jTable2.setValueAt(fechaCompleta, i, 4);
/* 489 */           this.jTable2.setValueAt(Integer.valueOf(rango), i, 5);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 495 */     this.jTable2.setShowVerticalLines(false);
/* 496 */     this.jTable2.setAutoCreateRowSorter(true);
/* 497 */     this.jScrollPane2.setViewportView(this.jTable2);
/*     */     
/* 499 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
/* 500 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(200);
/*     */     
/* 502 */     CeldaRender celda = new CeldaRender();
/* 503 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(celda);
/* 504 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(celda);
/* 505 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(celda);
/*     */   }
/*     */   
/*     */   public void pendiente(String usu) {
/* 509 */     this.USUARIO = usu;
/* 510 */     this.panel.setViewportView(this);
/* 511 */     this.con.consultar("count(cliente)", "facturasvencidas", "");
/* 512 */     this.CLIENTES = this.con.regresaCol("cliente", "facturasvencidas", "", Integer.parseInt(this.con.Campo));
/* 513 */     this.DIAS = this.con.regresaCol("dias", "facturasvencidas", "", Integer.parseInt(this.con.Campo));
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 517 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*     */           public void focusGained(FocusEvent evt) {
/* 519 */             FacturacionPendiente.this.jTextGanado(FacturacionPendiente.this.jComboBox9, evt);
/*     */           }
/*     */           
/*     */           public void focusLost(FocusEvent evt) {
/* 523 */             FacturacionPendiente.this.jTextPerdido(FacturacionPendiente.this.jComboBox9, evt);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 529 */     campo.setBackground(new Color(153, 255, 153));
/*     */   }
/*     */   
/*     */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 533 */     campo.setBackground(Color.white);
/*     */   }
/*     */   
/*     */   public void jPintarTexto(JComponent campo) {
/* 537 */     campo.setBackground(Color.ORANGE);
/*     */   }
/*     */   
/*     */   public void llenarCombo() {
/* 541 */     this.con.consultar("count(distinct(cliente))", "facturas", "");
/* 542 */     int tot = Integer.parseInt(this.con.Campo);
/* 543 */     this.jComboBox9.addItem("GENERAL");
/* 544 */     String[] datos = this.con.regresaCol("distinct(cliente)", "facturas", "order by cliente", tot);
/* 545 */     for (int i = 0; i < datos.length; i++)
/* 546 */       this.jComboBox9.addItem(datos[i]); 
/*     */   }
/*     */   
/*     */   class CeldaRender
/*     */     extends DefaultTableCellRenderer
/*     */   {
/* 552 */     int otro = -1;
/* 553 */     String[] indices = new String[0];
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 556 */       setEnabled((table == null || table.isEnabled()));
/* 557 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 558 */       if (column == 3 || column == 5 || column == 7) {
/* 559 */         setHorizontalAlignment(4);
/*     */       }
/* 561 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 562 */       return this;
/*     */     }
/*     */     
/*     */     public boolean comparar(String reg) {
/* 566 */       for (int i = 0; i < this.indices.length; i++) {
/* 567 */         if (this.indices[i].equals(reg)) {
/* 568 */           return true;
/*     */         }
/*     */       } 
/* 571 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public int alinearDer(int x, int letras) {
/* 576 */     int quitar = 3 * letras;
/* 577 */     x -= quitar;
/* 578 */     return x;
/*     */   }
/*     */   public class ImprimirFacturas implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA; int[] PXCOL; int NumLineas;
/*     */     int numBreaks;
/*     */     
/*     */     public ImprimirFacturas() {
/* 584 */       this.g2 = null;
/* 585 */       this.Pag = 0;
/*     */       
/* 587 */       this.linesPerPage = 50;
/* 588 */       this.orientacion = 0;
/* 589 */       this.X = 0.0D;
/* 590 */       this.Y = 0.0D;
/* 591 */       this.YINICIA = 75;
/* 592 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 593 */       this.NumLineas = 0;
/* 594 */       this.numBreaks = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     private void initTextLines() {
/* 599 */       if (this.textLines == null) {
/*     */ 
/*     */         
/* 602 */         int numLines = FacturacionPendiente.this.jTable2.getRowCount();
/*     */         
/* 604 */         this.textLines = new String[numLines];
/*     */       } 
/*     */     }
/*     */     
/*     */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 609 */       Font font = new Font("Serif", 0, 8);
/* 610 */       FontMetrics metrics = g.getFontMetrics(font);
/* 611 */       int lineHeight = metrics.getHeight();
/* 612 */       if (this.pageBreaks == null) {
/* 613 */         initTextLines();
/* 614 */         this.orientacion = pf.getOrientation();
/* 615 */         if (pf.getOrientation() == 1) {
/* 616 */           this.linesPerPage = 46;
/* 617 */           this.X = pf.getWidth();
/* 618 */           this.Y = pf.getHeight();
/*     */         } else {
/* 620 */           this.linesPerPage = 38;
/* 621 */           this.X = pf.getWidth();
/* 622 */           this.Y = pf.getHeight();
/*     */         } 
/* 624 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 625 */         this.Pag = this.numBreaks;
/* 626 */         this.pageBreaks = new int[this.numBreaks];
/* 627 */         for (int b = 0; b < this.numBreaks; b++) {
/* 628 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*     */         }
/*     */       } 
/* 631 */       if (pageIndex > this.pageBreaks.length) {
/* 632 */         return 1;
/*     */       }
/* 634 */       Graphics2D g2d = (Graphics2D)g;
/* 635 */       this.g2 = g;
/* 636 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 637 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 638 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 639 */       encabezado();
/* 640 */       int y = this.YINICIA;
/* 641 */       int lineas = 0;
/*     */       
/* 643 */       this.g2.drawRect(25, 150, 550, 12);
/* 644 */       this.g2.setColor(new Color(204, 0, 0));
/* 645 */       this.g2.fillRect(25, 151, 550, 10);
/*     */       
/* 647 */       Font fuente = new Font("Dialog", 0, 7);
/* 648 */       this.g2.setFont(fuente);
/* 649 */       this.g2.setColor(Color.WHITE);
/* 650 */       int[] valores = { 29, 90, 150, 213, 300, 355, 450, 520 };
/* 651 */       this.g2.drawString("CLIENTE", valores[0], 159);
/* 652 */       this.g2.drawString("FACTURA", valores[1], 159);
/* 653 */       this.g2.drawString("FECHA DE FACT", valores[2] - 10, 159);
/* 654 */       this.g2.drawString("DÍAS DE CRÉDITO", valores[3], 159);
/* 655 */       this.g2.drawString("FECHA LÍMITE", valores[4] - 10, 159);
/* 656 */       this.g2.drawString("DIAS DE RETRAZO", valores[5], 159);
/* 657 */       this.g2.drawString("ESTATUS", valores[6] + 10, 159);
/* 658 */       this.g2.drawString("TOTAL", valores[7] + 10, 159);
/*     */       
/* 660 */       this.g2.setColor(Color.BLACK);
/* 661 */       y = 160;
/* 662 */       for (int line = start; line < end; line++) {
/* 663 */         y += 12;
/*     */         
/* 665 */         String valor = "";
/* 666 */         if (line < 9) {
/* 667 */           valor = "0" + line + 1;
/*     */         } else {
/* 669 */           valor = "" + line + 1;
/*     */         } 
/* 671 */         fuente = new Font("Dialog", 1, 7);
/* 672 */         this.g2.setFont(fuente);
/* 673 */         this.g2.drawString(valor, FacturacionPendiente.this.alinearDer(20, valor.length()), y - 2);
/*     */         
/* 675 */         fuente = new Font("Dialog", 0, 6);
/* 676 */         this.g2.setFont(fuente);
/*     */         
/* 678 */         String cliente = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 0));
/* 679 */         int ind = cliente.indexOf(" ");
/* 680 */         cliente = cliente.substring(0, ind);
/*     */         
/* 682 */         this.g2.drawString(cliente, valores[0], y - 2);
/* 683 */         this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 1)), valores[1], y - 2);
/*     */         
/* 685 */         String fecha = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 2));
/* 686 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 687 */         this.g2.drawString(col, valores[2], y - 2);
/*     */ 
/*     */         
/* 690 */         this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 3)), FacturacionPendiente.this.alinearDer(valores[3] + 30, FacturacionPendiente.this.jTable2.getValueAt(line, 3).toString().length()), y - 2);
/*     */         
/* 692 */         fecha = String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 4));
/* 693 */         col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 694 */         this.g2.drawString(col, valores[4], y - 2);
/*     */         
/* 696 */         this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 5)), FacturacionPendiente.this.alinearDer(valores[5] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 5).toString().length()), y - 2);
/* 697 */         this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 6)), FacturacionPendiente.this.alinearDer(valores[6] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 6).toString().length()), y - 2);
/* 698 */         this.g2.drawString(String.valueOf(FacturacionPendiente.this.jTable2.getValueAt(line, 7)), FacturacionPendiente.this.alinearDer(valores[7] + 40, FacturacionPendiente.this.jTable2.getValueAt(line, 7).toString().length()), y - 2);
/*     */       } 
/*     */       
/* 701 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 702 */       if (this.Pag == pageIndex) {
/* 703 */         this.g2.drawLine(20, y, 90, y);
/* 704 */         this.g2.drawLine(510, y, 565, y);
/*     */         
/* 706 */         fuente = new Font("Dialog", 1, 6);
/* 707 */         this.g2.setFont(fuente);
/* 708 */         g.drawString("SUMAS", 41, y + 10);
/* 709 */         this.g2.drawString(FacturacionPendiente.this.jLabel42.getText(), FacturacionPendiente.this.alinearDer(valores[7] + 40, FacturacionPendiente.this.jLabel42.getText().length()), y + 10);
/*     */         
/* 711 */         fuente = new Font("Dialog", 1, 7);
/* 712 */         this.g2.setFont(fuente);
/* 713 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 714 */         this.g2.drawString("_____________________________________", 140, 752);
/* 715 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*     */         
/* 717 */         this.g2.drawString("RECIBE", 390, 720);
/* 718 */         this.g2.drawString("_____________________________________", 340, 752);
/* 719 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*     */       } 
/* 721 */       return 0;
/*     */     }
/*     */     
/*     */     public void encabezado() {
/* 725 */       Font fuente = new Font("Dialog", 0, 8);
/* 726 */       this.g2.setFont(fuente);
/* 727 */       this.g2.setColor(Color.BLACK);
/* 728 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 729 */       Image img = imagen.getImage();
/* 730 */       this.g2.drawImage(img, 518, 1, 57, 57, null);
/*     */       
/* 732 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 733 */       img = imagen.getImage();
/* 734 */       this.g2.drawImage(img, 27, 8, 60, 50, null);
/*     */       
/* 736 */       fuente = new Font("Times New Roman", 1, 16);
/* 737 */       this.g2.setFont(fuente);
/* 738 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*     */ 
/*     */       
/* 741 */       fuente = new Font("Dialog", 0, 12);
/* 742 */       this.g2.setFont(fuente);
/* 743 */       this.g2.drawString("FACTURAS VENCIDAS", 230, 37);
/* 744 */       this.g2.drawLine(25, 60, 575, 60);
/*     */       
/* 746 */       this.g2.setColor(Color.BLACK);
/* 747 */       this.g2.drawLine(25, 83, 220, 83);
/* 748 */       this.g2.drawLine(25, 130, 220, 130);
/*     */       
/* 750 */       fuente = new Font("Dialog", 1, 8);
/* 751 */       this.g2.setFont(fuente);
/* 752 */       this.g2.setColor(Color.BLACK);
/* 753 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*     */       
/* 755 */       fuente = new Font("Dialog", 1, 7);
/* 756 */       this.g2.setFont(fuente);
/* 757 */       this.g2.setColor(Color.BLACK);
/*     */       
/* 759 */       this.g2.drawString("Cliente: ", 27, 93);
/* 760 */       this.g2.drawString("Total de Facturas: ", 27, 104);
/* 761 */       this.g2.drawString("Monto Vencido: ", 27, 115);
/* 762 */       this.g2.drawString("Fecha de Impresión: ", 27, 126);
/*     */ 
/*     */       
/* 765 */       fuente = new Font("Dialog", 0, 7);
/* 766 */       this.g2.setFont(fuente);
/* 767 */       this.g2.setColor(Color.BLACK);
/*     */       
/* 769 */       this.g2.drawString(String.valueOf(FacturacionPendiente.this.jComboBox9.getSelectedItem()), 100, 93);
/* 770 */       this.g2.drawString("" + FacturacionPendiente.this.jTable2.getRowCount(), 100, 104);
/* 771 */       this.g2.drawString(FacturacionPendiente.this.jLabel42.getText(), 100, 115);
/*     */       
/* 773 */       Date fecha1 = new Date();
/* 774 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 775 */       String cadenaFecha = "";
/* 776 */       cadenaFecha = formato.format(fecha1);
/* 777 */       String AÑO = cadenaFecha.substring(0, 4);
/* 778 */       String MES = cadenaFecha.substring(4, 6);
/* 779 */       String DIA = cadenaFecha.substring(6, 8);
/* 780 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 100, 126);
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
/* 809 */       fuente = new Font("Dialog", 0, 7);
/* 810 */       this.g2.setFont(fuente);
/* 811 */       this.g2.drawString("A continuación se enlistan todas las facturas en este periodo:", 25, 148);
/*     */     }
/*     */     
/*     */     public void recibeDatos() {
/* 815 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 816 */       job.setPrintable(this);
/*     */       
/* 818 */       PageFormat pf = job.defaultPage();
/* 819 */       Paper papel = pf.getPaper();
/* 820 */       papel.setSize(612.0D, 792.0D);
/* 821 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 822 */       pf.setPaper(papel);
/* 823 */       pf.setOrientation(1);
/* 824 */       job.setPrintable(new ImprimirFacturas(), pf);
/* 825 */       job.defaultPage(pf);
/*     */       
/* 827 */       boolean ok = job.printDialog();
/* 828 */       if (ok)
/*     */         try {
/* 830 */           job.print();
/* 831 */         } catch (PrinterException printerException) {} 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/FacturacionPendiente.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */