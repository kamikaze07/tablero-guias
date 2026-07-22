/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class DepositosClientes extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   39 */   Date fechaActual = new Date();
/*   40 */   Date fechaInicio = null;
/*   41 */   Date fecha = new Date();
/*   42 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   43 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   44 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   45 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   46 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   47 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   48 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   49 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   50 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   51 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   52 */   JFrame padre = null;
/*   53 */   JTabbedPane fichas = null;
/*   54 */   String[] CLAVES = new String[18];
/*   55 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   EscribirReporte esc;
/*   58 */   CeldaRender celda = new CeldaRender();
/*   59 */   CeldaRender2 celda2 = new CeldaRender2();
/*   60 */   String[] DATOS = new String[18];
/*   61 */   double VALOR1 = 0.0D;
/*   62 */   double VALOR2 = 0.0D;
/*   63 */   String DEPARTAMENTO = ""; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton19; private JButton jButton20; private JButton jButton23; private JButton jButton28; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDialog jDialog1; private JDialog jDialog2; private JFormattedTextField jFormattedTextField1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel2; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41;
/*      */   
/*      */   public DepositosClientes(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   66 */     String año = "2011";
/*   67 */     String mes = "01";
/*   68 */     String dia = "01";
/*   69 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   70 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   72 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   73 */     } catch (ParseException ex) {
/*   74 */       ex.printStackTrace();
/*      */     } 
/*   76 */     this.padre = padre;
/*   77 */     fichas = fichas;
/*   78 */     initComponents();
/*   79 */     this.USUARIO = USUARIO;
/*   80 */     panelito.setViewportView(this);
/*   81 */     this.panel = panelito;
/*   82 */     colorear();
/*   83 */     consultar();
/*      */     
/*   85 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   86 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   87 */     this.jLabel5.setCursor(micursor);
/*   88 */     this.jLabel6.setCursor(micursor);
/*   89 */     this.jLabel7.setCursor(micursor);
/*   90 */     this.jLabel37.setCursor(micursor);
/*   91 */     this.jLabel40.setCursor(micursor);
/*   92 */     this.jLabel44.setCursor(micursor);
/*   93 */     llenarCombos();
/*      */     
/*   95 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   96 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   97 */     this.jDialog1.setCursor(micursor);
/*   98 */     this.jDialog2.setCursor(micursor);
/*      */     
/*  100 */     int w = this.tama.width;
/*  101 */     int h = this.tama.height;
/*  102 */     int rw = (w - 1005) / 2;
/*  103 */     int rh = (h - 495) / 2;
/*  104 */     this.jDialog1.setLocation(rw, rh);
/*  105 */     this.jDialog1.setSize(1005, 495);
/*  106 */     this.jDialog1.setVisible(false);
/*  107 */     this.jDialog1.setResizable(false);
/*      */     
/*  109 */     rw = (w - 320) / 2;
/*  110 */     rh = (h - 230) / 2;
/*  111 */     this.jDialog2.setLocation(rw, rh);
/*  112 */     this.jDialog2.setSize(310, 230);
/*  113 */     this.jDialog2.setVisible(false);
/*  114 */     this.jDialog2.setResizable(false);
/*      */     
/*  116 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  117 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  118 */     editFormat.setGroupingUsed(false);
/*  119 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  120 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  121 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  122 */     enFormat.setAllowsInvalid(true);
/*  123 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  124 */     this.cantidad.setFormatterFactory(currFactory);
/*      */     
/*  126 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  127 */     this.cantidad.setValue(Integer.valueOf(0));
/*  128 */     privilegios();
/*      */   }
/*      */   private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel54; private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel75; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel12; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane3; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator5; private JSeparator jSeparator9; private JTable jTable2; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7;
/*      */   
/*      */   private void initComponents() {
/*  133 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  134 */     this.jPanel12 = new JPanel();
/*  135 */     this.jScrollPane5 = new JScrollPane();
/*  136 */     this.jTable2 = new JTable();
/*  137 */     this.jPanel3 = new JPanel();
/*  138 */     this.jLabel29 = new JLabel();
/*  139 */     this.jLabel75 = new JLabel();
/*  140 */     this.jSeparator9 = new JSeparator();
/*  141 */     this.jLabel30 = new JLabel();
/*  142 */     this.jPanel4 = new JPanel();
/*  143 */     this.jLabel2 = new JLabel();
/*  144 */     this.jPanel6 = new JPanel();
/*  145 */     this.jLabel31 = new JLabel();
/*  146 */     this.jLabel33 = new JLabel();
/*  147 */     this.jLabel47 = new JLabel();
/*  148 */     this.jLabel49 = new JLabel();
/*  149 */     this.jLabel50 = new JLabel();
/*  150 */     this.jLabel51 = new JLabel();
/*  151 */     this.jSeparator10 = new JSeparator();
/*  152 */     this.jPanel7 = new JPanel();
/*  153 */     this.jLabel35 = new JLabel();
/*  154 */     this.jLabel36 = new JLabel();
/*  155 */     this.jPanel8 = new JPanel();
/*  156 */     this.jLabel46 = new JLabel();
/*  157 */     this.jLabel44 = new JLabel();
/*  158 */     this.jLabel41 = new JLabel();
/*  159 */     this.jLabel40 = new JLabel();
/*  160 */     this.jLabel38 = new JLabel();
/*  161 */     this.jLabel37 = new JLabel();
/*  162 */     this.jLabel39 = new JLabel();
/*  163 */     this.jLabel52 = new JLabel();
/*  164 */     this.jPanel9 = new JPanel();
/*  165 */     this.jLabel3 = new JLabel();
/*  166 */     this.jLabel8 = new JLabel();
/*  167 */     this.jLabel9 = new JLabel();
/*  168 */     this.jLabel10 = new JLabel();
/*  169 */     this.jSeparator1 = new JSeparator();
/*  170 */     this.jLabel11 = new JLabel();
/*  171 */     this.jLabel12 = new JLabel();
/*  172 */     this.jLabel32 = new JLabel();
/*  173 */     this.jLabel34 = new JLabel();
/*  174 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  175 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  176 */     this.jPanel10 = new JPanel();
/*  177 */     this.jLabel21 = new JLabel();
/*  178 */     this.jSeparator5 = new JSeparator();
/*  179 */     this.jLabel22 = new JLabel();
/*  180 */     this.jTextField5 = new JTextField();
/*  181 */     this.jButton8 = new JButton();
/*  182 */     this.jButton9 = new JButton();
/*  183 */     this.jLabel23 = new JLabel();
/*  184 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  185 */     this.jLabel24 = new JLabel();
/*  186 */     this.jTextField6 = new JTextField();
/*  187 */     this.jLabel25 = new JLabel();
/*  188 */     this.jTextField7 = new JTextField();
/*  189 */     this.cantidad = new JFormattedTextField();
/*  190 */     this.jPanel1 = new JPanel();
/*  191 */     this.jLabel54 = new JLabel();
/*  192 */     this.jPanel5 = new JPanel();
/*  193 */     this.jLabel48 = new JLabel();
/*  194 */     this.jScrollPane3 = new JScrollPane();
/*  195 */     this.jTable3 = new JTable();
/*  196 */     this.jButton19 = new JButton();
/*  197 */     this.jButton23 = new JButton();
/*  198 */     this.jButton20 = new JButton();
/*  199 */     this.jLabel42 = new JLabel();
/*  200 */     this.jLabel43 = new JLabel();
/*  201 */     this.jButton28 = new JButton();
/*  202 */     this.jPanel17 = new JPanel();
/*  203 */     this.jTextField1 = new JTextField();
/*  204 */     this.jLabel15 = new JLabel();
/*  205 */     this.jLabel45 = new JLabel();
/*  206 */     this.jComboBox1 = new JComboBox();
/*  207 */     this.jTextField2 = new JTextField();
/*  208 */     this.jLabel16 = new JLabel();
/*  209 */     this.jTextField3 = new JTextField();
/*  210 */     this.jLabel17 = new JLabel();
/*  211 */     this.jTextField4 = new JTextField();
/*  212 */     this.jLabel18 = new JLabel();
/*  213 */     this.jPanel2 = new JPanel();
/*  214 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  215 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  216 */     this.jLabel5 = new JLabel();
/*  217 */     this.jLabel6 = new JLabel();
/*  218 */     this.jLabel7 = new JLabel();
/*  219 */     this.jLabel1 = new JLabel();
/*  220 */     this.jLabel4 = new JLabel();
/*  221 */     this.jButton1 = new JButton();
/*      */     
/*  223 */     this.jDialog1.setTitle("Ver Abono");
/*  224 */     this.jDialog1.setModal(true);
/*      */     
/*  226 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/*  228 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/*  229 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Folio", "Fecha", "Nombre", "Concepto", "Cargo", "Eco", "Monto" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  240 */     this.jTable2.setShowVerticalLines(false);
/*  241 */     this.jScrollPane5.setViewportView(this.jTable2);
/*      */     
/*  243 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*  244 */     this.jPanel3.setForeground(new Color(255, 255, 255));
/*      */     
/*  246 */     this.jLabel29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  248 */     this.jLabel75.setFont(new Font("Times New Roman", 3, 22));
/*  249 */     this.jLabel75.setForeground(Color.red);
/*  250 */     this.jLabel75.setText("FLETES Y MATERIALES GRUPO FORSIS S.A. DE C.V.");
/*      */     
/*  252 */     this.jLabel30.setFont(new Font("Tahoma", 2, 16));
/*  253 */     this.jLabel30.setText("DETALLES DEL ABONO - PR-00001");
/*      */     
/*  255 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  256 */     this.jPanel4.setForeground(new Color(255, 255, 255));
/*      */     
/*  258 */     this.jLabel2.setBackground(new Color(255, 255, 255));
/*  259 */     this.jLabel2.setText("jLabel2");
/*      */     
/*  261 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  262 */     this.jPanel4.setLayout(jPanel4Layout);
/*  263 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  265 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  266 */           .addComponent(this.jLabel2, -2, 313, -2)
/*  267 */           .addContainerGap(-1, 32767)));
/*      */     
/*  269 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  270 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  271 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  272 */           .addComponent(this.jLabel2, -2, 78, -2)
/*  273 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  276 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*      */     
/*  278 */     this.jLabel31.setFont(new Font("Tahoma", 0, 14));
/*  279 */     this.jLabel31.setForeground(Color.blue);
/*  280 */     this.jLabel31.setText("Banco: ");
/*      */     
/*  282 */     this.jLabel33.setFont(new Font("Tahoma", 0, 14));
/*  283 */     this.jLabel33.setText("Aquí va el banco");
/*      */     
/*  285 */     this.jLabel47.setFont(new Font("Tahoma", 0, 14));
/*  286 */     this.jLabel47.setForeground(Color.blue);
/*  287 */     this.jLabel47.setText("Cuenta: ");
/*      */     
/*  289 */     this.jLabel49.setFont(new Font("Tahoma", 0, 14));
/*  290 */     this.jLabel49.setText("Aquí va la cuenta");
/*      */     
/*  292 */     this.jLabel50.setFont(new Font("Tahoma", 0, 14));
/*  293 */     this.jLabel50.setForeground(Color.blue);
/*  294 */     this.jLabel50.setText("Ref: ");
/*      */     
/*  296 */     this.jLabel51.setFont(new Font("Tahoma", 0, 14));
/*  297 */     this.jLabel51.setText("Aquí va la referencia");
/*      */     
/*  299 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  300 */     this.jPanel6.setLayout(jPanel6Layout);
/*  301 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  303 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  304 */           .addContainerGap()
/*  305 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  306 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  307 */               .addComponent(this.jLabel31, -2, 59, -2)
/*  308 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  309 */               .addComponent(this.jLabel33, -2, 241, -2))
/*  310 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  311 */               .addComponent(this.jLabel47, -2, 59, -2)
/*  312 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  313 */               .addComponent(this.jLabel49, -2, 241, -2))
/*  314 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  315 */               .addComponent(this.jLabel50, -2, 59, -2)
/*  316 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  317 */               .addComponent(this.jLabel51, -2, 241, -2)))
/*  318 */           .addContainerGap(-1, 32767)));
/*      */     
/*  320 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  322 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  323 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  324 */             .addComponent(this.jLabel31)
/*  325 */             .addComponent(this.jLabel33, -1, -1, 32767))
/*  326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  327 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  328 */             .addComponent(this.jLabel47)
/*  329 */             .addComponent(this.jLabel49, -1, -1, 32767))
/*  330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  331 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  332 */             .addComponent(this.jLabel50)
/*  333 */             .addComponent(this.jLabel51, -1, -1, 32767))
/*  334 */           .addGap(13, 13, 13)));
/*      */ 
/*      */     
/*  337 */     this.jPanel7.setBackground(new Color(255, 255, 255));
/*      */     
/*  339 */     this.jLabel35.setHorizontalAlignment(4);
/*  340 */     this.jLabel35.setText("13/05/2010");
/*      */     
/*  342 */     this.jLabel36.setHorizontalAlignment(4);
/*  343 */     this.jLabel36.setText("Usuario");
/*      */     
/*  345 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  346 */     this.jPanel7.setLayout(jPanel7Layout);
/*  347 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  348 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  349 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/*  350 */           .addContainerGap(51, 32767)
/*  351 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  352 */             .addComponent(this.jLabel36, -2, 162, -2)
/*  353 */             .addComponent(this.jLabel35, -2, 82, -2))
/*  354 */           .addContainerGap()));
/*      */     
/*  356 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  358 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  359 */           .addComponent(this.jLabel35)
/*  360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  361 */           .addComponent(this.jLabel36)
/*  362 */           .addContainerGap(56, 32767)));
/*      */ 
/*      */     
/*  365 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  366 */     this.jPanel3.setLayout(jPanel3Layout);
/*  367 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  369 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  370 */           .addComponent(this.jLabel29, -2, 75, -2)
/*  371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  372 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  373 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  374 */               .addComponent(this.jLabel75, -2, 560, -2)
/*  375 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  376 */               .addComponent(this.jLabel30, -2, 283, -2))
/*  377 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  378 */               .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING)
/*  379 */               .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING)
/*  380 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
/*  381 */                 .addComponent(this.jPanel4, -2, -1, -2)
/*  382 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  383 */                 .addComponent(this.jPanel6, -2, -1, -2)
/*  384 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  385 */                 .addComponent(this.jPanel7, -2, -1, -2))))
/*  386 */           .addContainerGap()));
/*      */     
/*  388 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  390 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  391 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  392 */             .addComponent(this.jLabel75, -2, 25, -2)
/*  393 */             .addComponent(this.jLabel30))
/*  394 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  395 */           .addComponent(this.jSeparator9, -2, 10, -2)
/*  396 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  397 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  398 */             .addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  399 */             .addComponent(this.jPanel6, -2, -1, -2)
/*  400 */             .addComponent(this.jPanel7, -2, -1, -2))
/*  401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  402 */           .addComponent(this.jSeparator10, -2, 10, -2))
/*  403 */         .addComponent(this.jLabel29, -1, -1, 32767));
/*      */ 
/*      */     
/*  406 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/*  407 */     this.jPanel8.setForeground(new Color(255, 255, 255));
/*      */     
/*  409 */     this.jLabel46.setFont(new Font("Tahoma", 1, 11));
/*  410 */     this.jLabel46.setText("|");
/*      */     
/*  412 */     this.jLabel44.setFont(new Font("Tahoma", 1, 11));
/*  413 */     this.jLabel44.setForeground(Color.red);
/*  414 */     this.jLabel44.setHorizontalAlignment(0);
/*  415 */     this.jLabel44.setText("<html><U>Guardar</u></html>");
/*  416 */     this.jLabel44.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  418 */             DepositosClientes.this.jLabel44MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  421 */             DepositosClientes.this.jLabel44MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  424 */             DepositosClientes.this.jLabel44MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  428 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/*  429 */     this.jLabel41.setText("|");
/*      */     
/*  431 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/*  432 */     this.jLabel40.setForeground(Color.red);
/*  433 */     this.jLabel40.setHorizontalAlignment(0);
/*  434 */     this.jLabel40.setText("<html><U>Imprimir</u></html>");
/*  435 */     this.jLabel40.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  437 */             DepositosClientes.this.jLabel40MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  440 */             DepositosClientes.this.jLabel40MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  443 */             DepositosClientes.this.jLabel40MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  447 */     this.jLabel38.setFont(new Font("Tahoma", 1, 11));
/*  448 */     this.jLabel38.setText("|");
/*      */     
/*  450 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/*  451 */     this.jLabel37.setForeground(Color.red);
/*  452 */     this.jLabel37.setHorizontalAlignment(0);
/*  453 */     this.jLabel37.setText("<html><u>Cerrar</u></html>");
/*  454 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  456 */             DepositosClientes.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  459 */             DepositosClientes.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  462 */             DepositosClientes.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  466 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/*  467 */     this.jLabel39.setText("|");
/*      */     
/*  469 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/*  470 */     this.jLabel52.setForeground(Color.red);
/*  471 */     this.jLabel52.setHorizontalAlignment(0);
/*  472 */     this.jLabel52.setText("<html><U>Saldar Manualmente</u></html>");
/*  473 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  475 */             DepositosClientes.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  478 */             DepositosClientes.this.jLabel52MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  481 */             DepositosClientes.this.jLabel52MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  485 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  486 */     this.jPanel8.setLayout(jPanel8Layout);
/*  487 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  488 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  489 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  490 */           .addContainerGap(-1, 32767)
/*  491 */           .addComponent(this.jLabel52, -2, 184, -2)
/*  492 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  493 */           .addComponent(this.jLabel46)
/*  494 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  495 */           .addComponent(this.jLabel44, -2, 78, -2)
/*  496 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  497 */           .addComponent(this.jLabel41)
/*  498 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  499 */           .addComponent(this.jLabel40, -2, 78, -2)
/*  500 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  501 */           .addComponent(this.jLabel38)
/*  502 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  503 */           .addComponent(this.jLabel37, -2, 78, -2)
/*  504 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  505 */           .addComponent(this.jLabel39)
/*  506 */           .addContainerGap()));
/*      */     
/*  508 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  509 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  510 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  511 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  512 */             .addComponent(this.jLabel37, -2, -1, -2)
/*  513 */             .addComponent(this.jLabel38)
/*  514 */             .addComponent(this.jLabel39)
/*  515 */             .addComponent(this.jLabel40, -2, -1, -2)
/*  516 */             .addComponent(this.jLabel41)
/*  517 */             .addComponent(this.jLabel44, -2, -1, -2)
/*  518 */             .addComponent(this.jLabel46)
/*  519 */             .addComponent(this.jLabel52, -2, -1, -2))
/*  520 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/*  523 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/*  525 */     this.jLabel3.setText(" Facturas Abonadas:");
/*      */     
/*  527 */     this.jLabel8.setFont(new Font("Tahoma", 1, 12));
/*  528 */     this.jLabel8.setText("jLabel8");
/*      */     
/*  530 */     this.jLabel9.setText(" Facturas Pagadas:");
/*      */     
/*  532 */     this.jLabel10.setFont(new Font("Tahoma", 1, 12));
/*  533 */     this.jLabel10.setText("jLabel8");
/*      */     
/*  535 */     this.jLabel11.setText(" Total de Facturas:");
/*      */     
/*  537 */     this.jLabel12.setFont(new Font("Tahoma", 1, 12));
/*  538 */     this.jLabel12.setText("jLabel8");
/*      */     
/*  540 */     this.jLabel32.setFont(new Font("Tahoma", 0, 14));
/*  541 */     this.jLabel32.setForeground(Color.blue);
/*  542 */     this.jLabel32.setText("Depósito por:");
/*      */     
/*  544 */     this.jLabel34.setFont(new Font("Tahoma", 1, 16));
/*  545 */     this.jLabel34.setText("Aquí va el depósito");
/*      */     
/*  547 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  548 */     this.jPanel9.setLayout(jPanel9Layout);
/*  549 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  551 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  552 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  553 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  554 */               .addComponent(this.jLabel3, -2, 117, -2)
/*  555 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  556 */               .addComponent(this.jLabel8, -2, 150, -2))
/*  557 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  558 */               .addComponent(this.jLabel9, -2, 117, -2)
/*  559 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  560 */               .addComponent(this.jLabel10, -2, 150, -2))
/*  561 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  562 */               .addComponent(this.jLabel11, -2, 117, -2)
/*  563 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  564 */               .addComponent(this.jLabel12, -2, 146, -2))
/*  565 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  566 */               .addContainerGap()
/*  567 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  568 */                 .addGroup(jPanel9Layout.createSequentialGroup()
/*  569 */                   .addComponent(this.jLabel32, -2, 92, -2)
/*  570 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  571 */                   .addComponent(this.jLabel34, -1, -1, 32767))
/*  572 */                 .addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING, -2, 195, -2))))
/*  573 */           .addContainerGap()));
/*      */     
/*  575 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  576 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  577 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  578 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  579 */             .addComponent(this.jLabel3)
/*  580 */             .addComponent(this.jLabel8))
/*  581 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  582 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  583 */             .addComponent(this.jLabel9)
/*  584 */             .addComponent(this.jLabel10))
/*  585 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  586 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  587 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  588 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  589 */             .addComponent(this.jLabel11)
/*  590 */             .addComponent(this.jLabel12))
/*  591 */           .addGap(144, 144, 144)
/*  592 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  593 */             .addComponent(this.jLabel32)
/*  594 */             .addComponent(this.jLabel34))
/*  595 */           .addGap(34, 34, 34)));
/*      */ 
/*      */     
/*  598 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  599 */     this.jPanel12.setLayout(jPanel12Layout);
/*  600 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  601 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  602 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  603 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  604 */             .addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  605 */             .addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  606 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/*  607 */               .addComponent(this.jPanel9, -2, 282, -2)
/*  608 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  609 */               .addComponent(this.jScrollPane5)))
/*  610 */           .addContainerGap(-1, 32767)));
/*      */     
/*  612 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  613 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  614 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  615 */           .addComponent(this.jPanel3, -2, -1, -2)
/*  616 */           .addGap(11, 11, 11)
/*  617 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  618 */             .addComponent(this.jPanel9, -1, -1, 32767)
/*  619 */             .addComponent(this.jScrollPane5, -2, 0, 32767))
/*  620 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  621 */           .addComponent(this.jPanel8, -2, -1, -2)));
/*      */ 
/*      */     
/*  624 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  625 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  626 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  628 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */     
/*  630 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  631 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  632 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/*  635 */     this.jFormattedTextField1.setText("jFormattedTextField1");
/*      */     
/*  637 */     this.jDialog2.setTitle("Modificar Depósito");
/*  638 */     this.jDialog2.setModal(true);
/*      */     
/*  640 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/*  642 */     this.jLabel21.setFont(new Font("Tahoma", 1, 14));
/*  643 */     this.jLabel21.setHorizontalAlignment(0);
/*  644 */     this.jLabel21.setText("Modificar datos del depósito");
/*      */     
/*  646 */     this.jLabel22.setText("Banco:");
/*      */     
/*  648 */     this.jButton8.setMnemonic('C');
/*  649 */     this.jButton8.setText("Cerrar");
/*  650 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/*  651 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  653 */             DepositosClientes.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  657 */     this.jButton9.setMnemonic('M');
/*  658 */     this.jButton9.setText("Modificar");
/*  659 */     this.jButton9.setToolTipText("Modificar (Alt+M)");
/*  660 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  662 */             DepositosClientes.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  666 */     this.jLabel23.setText("Fecha");
/*      */     
/*  668 */     this.jDateChooser6.setDate(this.fechaActual);
/*  669 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  670 */     this.jDateChooser6.setIcon(this.icon);
/*  671 */     this.jDateChooser6.setMaxSelectableDate(this.fecha);
/*  672 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  674 */     this.jLabel24.setText("Cuenta:");
/*      */     
/*  676 */     this.jLabel25.setText("Referencia:");
/*      */     
/*  678 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  679 */     this.jPanel10.setLayout(jPanel10Layout);
/*  680 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  681 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  682 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  683 */           .addContainerGap()
/*  684 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */             .addComponent(this.jLabel21, -1, -1, 32767)
/*  686 */             .addGroup(jPanel10Layout.createSequentialGroup()
/*  687 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  688 */                 .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  689 */                   .addGroup(jPanel10Layout.createSequentialGroup()
/*  690 */                     .addComponent(this.jLabel22, -2, 70, -2)
/*  691 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  692 */                     .addComponent(this.jTextField5, -2, 195, -2))
/*  693 */                   .addGroup(jPanel10Layout.createSequentialGroup()
/*  694 */                     .addComponent(this.jLabel23, -2, 70, -2)
/*  695 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  696 */                     .addComponent((Component)this.jDateChooser6, -1, -1, 32767))
/*  697 */                   .addGroup(jPanel10Layout.createSequentialGroup()
/*  698 */                     .addComponent(this.jLabel24, -2, 70, -2)
/*  699 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  700 */                     .addComponent(this.jTextField6, -2, 195, -2))
/*  701 */                   .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  702 */                     .addGroup(jPanel10Layout.createSequentialGroup()
/*  703 */                       .addComponent(this.jButton9, -2, 88, -2)
/*  704 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  705 */                       .addComponent(this.jButton8, -2, 88, -2))
/*  706 */                     .addGroup(jPanel10Layout.createSequentialGroup()
/*  707 */                       .addComponent(this.jLabel25, -2, 70, -2)
/*  708 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  709 */                       .addComponent(this.jTextField7, -2, 195, -2))))
/*  710 */                 .addComponent(this.jSeparator5, -2, 280, -2))
/*  711 */               .addGap(0, 0, 32767)))
/*  712 */           .addContainerGap()));
/*      */     
/*  714 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  715 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  716 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  717 */           .addComponent(this.jLabel21)
/*  718 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  719 */           .addComponent(this.jSeparator5, -2, 10, -2)
/*  720 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  721 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  722 */             .addComponent((Component)this.jDateChooser6, -1, -1, 32767)
/*  723 */             .addComponent(this.jLabel23, -1, -1, 32767))
/*  724 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  725 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  726 */             .addComponent(this.jLabel22)
/*  727 */             .addComponent(this.jTextField5, -2, -1, -2))
/*  728 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  729 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  730 */             .addComponent(this.jLabel24)
/*  731 */             .addComponent(this.jTextField6, -2, -1, -2))
/*  732 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  733 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  734 */             .addComponent(this.jLabel25)
/*  735 */             .addComponent(this.jTextField7, -2, -1, -2))
/*  736 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  737 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  738 */             .addComponent(this.jButton8)
/*  739 */             .addComponent(this.jButton9))
/*  740 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  743 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  744 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  745 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  746 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  747 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */     
/*  749 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  750 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  751 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  752 */           .addComponent(this.jPanel10, -2, -1, -2)
/*  753 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  756 */     this.cantidad.setText("jFormattedTextField2");
/*      */     
/*  758 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  759 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  761 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/*  762 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  763 */     this.jLabel54.setText("DEPÓSTIOS A FACTURAS");
/*      */     
/*  765 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*  766 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  768 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/*  769 */     this.jLabel48.setForeground(Color.red);
/*  770 */     this.jLabel48.setHorizontalAlignment(0);
/*  771 */     this.jLabel48.setText("t");
/*  772 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  774 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  775 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  783 */     this.jTable3.setShowVerticalLines(false);
/*  784 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  786 */             DepositosClientes.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/*  789 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  791 */             DepositosClientes.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/*  794 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  796 */     this.jButton19.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Email.png")));
/*  797 */     this.jButton19.setMnemonic('E');
/*  798 */     this.jButton19.setText("Enviar Correo");
/*  799 */     this.jButton19.setToolTipText("Enviar Correo (Alt+E)");
/*  800 */     this.jButton19.setEnabled(false);
/*  801 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  803 */             DepositosClientes.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  807 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/*  808 */     this.jButton23.setMnemonic('V');
/*  809 */     this.jButton23.setText("Ver");
/*  810 */     this.jButton23.setToolTipText("Ver Significados de los Colores (Alt+V)");
/*  811 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  813 */             DepositosClientes.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  817 */     this.jButton20.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/*  818 */     this.jButton20.setMnemonic('E');
/*  819 */     this.jButton20.setText("Guardar Reporte");
/*  820 */     this.jButton20.setToolTipText("Enviar Correo (Alt+E)");
/*  821 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  823 */             DepositosClientes.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  827 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/*  828 */     this.jLabel42.setHorizontalAlignment(4);
/*  829 */     this.jLabel42.setText("SUMAS:");
/*      */     
/*  831 */     this.jLabel43.setFont(new Font("Tahoma", 0, 10));
/*  832 */     this.jLabel43.setHorizontalAlignment(4);
/*  833 */     this.jLabel43.setText("jLabel31");
/*      */     
/*  835 */     this.jButton28.setMnemonic('M');
/*  836 */     this.jButton28.setText("Modificar");
/*  837 */     this.jButton28.setToolTipText("Modificar Documentos (Alt+M)");
/*  838 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  840 */             DepositosClientes.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  844 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  845 */     this.jPanel5.setLayout(jPanel5Layout);
/*  846 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  849 */           .addComponent(this.jScrollPane3, -1, 1074, 32767)
/*  850 */           .addContainerGap())
/*  851 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/*  852 */           .addGap(0, 0, 32767)
/*  853 */           .addComponent(this.jLabel42, -2, 51, -2)
/*  854 */           .addGap(18, 18, 18)
/*  855 */           .addComponent(this.jLabel43, -2, 108, -2)
/*  856 */           .addGap(154, 154, 154))
/*  857 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  858 */           .addComponent(this.jLabel48, -2, 159, -2)
/*  859 */           .addGap(38, 38, 38)
/*  860 */           .addComponent(this.jButton23, -2, 119, -2)
/*  861 */           .addGap(13, 13, 13)
/*  862 */           .addComponent(this.jButton20, -2, 150, -2)
/*  863 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  864 */           .addComponent(this.jButton28, -2, 119, -2)
/*  865 */           .addGap(99, 99, 99)
/*  866 */           .addComponent(this.jButton19, -2, 137, -2)
/*  867 */           .addContainerGap(-1, 32767)));
/*      */     
/*  869 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  870 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  871 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  872 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  873 */             .addComponent(this.jButton23, -2, 28, -2)
/*  874 */             .addComponent(this.jButton20)
/*  875 */             .addComponent(this.jButton19)
/*  876 */             .addComponent(this.jLabel48)
/*  877 */             .addComponent(this.jButton28, -2, 29, -2))
/*  878 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  879 */           .addComponent(this.jScrollPane3, -1, 174, 32767)
/*  880 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  881 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  882 */             .addComponent(this.jLabel42)
/*  883 */             .addComponent(this.jLabel43))));
/*      */ 
/*      */     
/*  886 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  887 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Abonos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  889 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  891 */             DepositosClientes.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  895 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/*  896 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/*  897 */     this.jLabel15.setHorizontalAlignment(0);
/*  898 */     this.jLabel15.setText("Folio");
/*      */     
/*  900 */     this.jLabel45.setFont(new Font("Tahoma", 3, 12));
/*  901 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/*  902 */     this.jLabel45.setHorizontalAlignment(0);
/*  903 */     this.jLabel45.setText("Cliente");
/*      */     
/*  905 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  906 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  907 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  909 */             DepositosClientes.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  913 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  915 */             DepositosClientes.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  919 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/*  920 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/*  921 */     this.jLabel16.setHorizontalAlignment(0);
/*  922 */     this.jLabel16.setText("Banco");
/*      */     
/*  924 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  926 */             DepositosClientes.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  930 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/*  931 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/*  932 */     this.jLabel17.setHorizontalAlignment(0);
/*  933 */     this.jLabel17.setText("Cuenta");
/*      */     
/*  935 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  937 */             DepositosClientes.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  941 */     this.jLabel18.setFont(new Font("Tahoma", 3, 12));
/*  942 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/*  943 */     this.jLabel18.setHorizontalAlignment(0);
/*  944 */     this.jLabel18.setText("Referencia");
/*      */     
/*  946 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/*  947 */     this.jPanel17.setLayout(jPanel17Layout);
/*  948 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/*  949 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  950 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  951 */           .addContainerGap()
/*  952 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  953 */             .addComponent(this.jLabel15, -1, -1, 32767)
/*  954 */             .addComponent(this.jTextField1, -2, 81, -2))
/*  955 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  956 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  957 */             .addComponent(this.jLabel16, -1, -1, 32767)
/*  958 */             .addComponent(this.jTextField2, -1, 155, 32767))
/*  959 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  960 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  961 */             .addComponent(this.jLabel17, -1, -1, 32767)
/*  962 */             .addComponent(this.jTextField3, -2, 155, -2))
/*  963 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  964 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  965 */             .addComponent(this.jLabel18, -1, -1, 32767)
/*  966 */             .addComponent(this.jTextField4, -2, 155, -2))
/*  967 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  968 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  969 */             .addComponent(this.jLabel45, -1, -1, 32767)
/*  970 */             .addComponent(this.jComboBox1, 0, 164, 32767))
/*  971 */           .addContainerGap(340, 32767)));
/*      */     
/*  973 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/*  974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  975 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  976 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  978 */               .addComponent(this.jTextField1, -2, -1, -2)
/*  979 */               .addGap(8, 8, 8)
/*  980 */               .addComponent(this.jLabel15, -1, -1, 32767))
/*  981 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  982 */               .addComponent(this.jTextField2, -2, -1, -2)
/*  983 */               .addGap(8, 8, 8)
/*  984 */               .addComponent(this.jLabel16, -1, -1, 32767))
/*  985 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  986 */               .addComponent(this.jTextField3, -2, -1, -2)
/*  987 */               .addGap(8, 8, 8)
/*  988 */               .addComponent(this.jLabel17, -1, -1, 32767))
/*  989 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  990 */               .addComponent(this.jTextField4, -2, -1, -2)
/*  991 */               .addGap(8, 8, 8)
/*  992 */               .addComponent(this.jLabel18, -1, -1, 32767))
/*  993 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  994 */               .addComponent(this.jComboBox1, -2, -1, -2)
/*  995 */               .addGap(8, 8, 8)
/*  996 */               .addComponent(this.jLabel45)))
/*  997 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1000 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 1001 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1003 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1004 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1005 */     this.jDateChooser4.setIcon(this.icon);
/* 1006 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1007 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1009 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1010 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1011 */     this.jDateChooser5.setIcon(this.icon);
/* 1012 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 1013 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1015 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 1016 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 1017 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 1018 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1020 */             DepositosClientes.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1023 */             DepositosClientes.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1026 */             DepositosClientes.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1030 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 1031 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 1032 */     this.jLabel6.setHorizontalAlignment(0);
/* 1033 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 1034 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1036 */             DepositosClientes.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1039 */             DepositosClientes.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1042 */             DepositosClientes.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1046 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 1047 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 1048 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 1049 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1051 */             DepositosClientes.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1054 */             DepositosClientes.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1057 */             DepositosClientes.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1061 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 1062 */     this.jLabel1.setForeground(Color.red);
/* 1063 */     this.jLabel1.setHorizontalAlignment(4);
/* 1064 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 1066 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 1067 */     this.jLabel4.setForeground(Color.red);
/* 1068 */     this.jLabel4.setHorizontalAlignment(0);
/* 1069 */     this.jLabel4.setText("AL");
/*      */     
/* 1071 */     this.jButton1.setMnemonic('F');
/* 1072 */     this.jButton1.setText("Filtrar");
/* 1073 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 1074 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1076 */             DepositosClientes.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1080 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1081 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1082 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1083 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1084 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1085 */           .addContainerGap()
/* 1086 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 1087 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1088 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1089 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1090 */           .addComponent(this.jLabel4)
/* 1091 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1092 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1093 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1094 */           .addComponent(this.jButton1)
/* 1095 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1096 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 1097 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1098 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 1099 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1100 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 1101 */           .addContainerGap(21, 32767)));
/*      */     
/* 1103 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1104 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1105 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1106 */           .addContainerGap()
/* 1107 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1108 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1109 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1110 */               .addGap(1, 1, 1)
/* 1111 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1112 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 1113 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1114 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 1115 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 1116 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 1117 */                   .addComponent(this.jButton1))
/* 1118 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1119 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 1120 */                   .addGap(1, 1, 1))
/* 1121 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 1124 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1125 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1126 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1128 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1129 */           .addContainerGap()
/* 1130 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1131 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 1132 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 1133 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1134 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 1135 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1136 */               .addComponent(this.jLabel54, -1, 491, 32767)))
/* 1137 */           .addContainerGap()));
/*      */     
/* 1139 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1141 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1142 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1143 */             .addComponent(this.jLabel54, -1, -1, 32767)
/* 1144 */             .addComponent(this.jPanel2, -1, -1, 32767))
/* 1145 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1146 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1147 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1148 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1149 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1152 */     GroupLayout layout = new GroupLayout(this);
/* 1153 */     setLayout(layout);
/* 1154 */     layout.setHorizontalGroup(layout
/* 1155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1156 */         .addGap(0, 1140, 32767)
/* 1157 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1158 */           .addGroup(layout.createSequentialGroup()
/* 1159 */             .addContainerGap()
/* 1160 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1161 */             .addContainerGap())));
/*      */     
/* 1163 */     layout.setVerticalGroup(layout
/* 1164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1165 */         .addGap(0, 409, 32767)
/* 1166 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1167 */           .addGroup(layout.createSequentialGroup()
/* 1168 */             .addContainerGap()
/* 1169 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1170 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 1175 */     if (evt.getClickCount() == 2) {
/* 1176 */       verAbonos();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 1191 */     int ind = this.jTable3.getSelectedRow();
/* 1192 */     if (ind < 0) {
/* 1193 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para ver los datos", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 1195 */       verAbonos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1200 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1204 */     if (this.jComboBox1.getItemCount() > 0) {
/* 1205 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 1210 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1211 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1212 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 1216 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 1220 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 1224 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1225 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1226 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 1230 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 1234 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 1238 */     Calendar ca = Calendar.getInstance();
/* 1239 */     Calendar fecha = Calendar.getInstance();
/* 1240 */     int aa = fecha.get(1);
/* 1241 */     int mm = fecha.get(2);
/* 1242 */     int dd = fecha.get(5);
/* 1243 */     if (dd == 1) {
/* 1244 */       if (mm == 0) {
/* 1245 */         mm = 11;
/* 1246 */         aa--;
/*      */       } else {
/* 1248 */         mm--;
/*      */       } 
/* 1250 */       int diasTotal = diasDelMes(mm, aa);
/* 1251 */       dd = diasTotal;
/*      */     } else {
/* 1253 */       dd--;
/*      */     } 
/* 1255 */     mm++;
/* 1256 */     String año = "" + aa;
/* 1257 */     String mes = "" + mm;
/* 1258 */     String dia = "" + dd;
/* 1259 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1260 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1262 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1263 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1264 */     } catch (ParseException ex) {
/* 1265 */       ex.printStackTrace();
/*      */     } 
/* 1267 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 1271 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 1275 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1279 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1283 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1287 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 1291 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 1295 */     String[] datos = { "FOLIO", "FECHA", "CLIENTE", "BANCO", "CUENTA", "REFERENCIA", "LUGAR", "CANTIDAD" };
/* 1296 */     this.esc = new EscribirReporte("DEPÓSITOS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 1300 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 1304 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 1308 */     this.jLabel37.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel40MouseClicked(MouseEvent evt) {
/* 1312 */     this.VALOR1 = 0.0D;
/* 1313 */     this.VALOR2 = 0.0D;
/* 1314 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 1315 */       this.VALOR1 += regresaMonto(this.jTable2.getValueAt(i, 1).toString());
/* 1316 */       this.VALOR2 += regresaMonto(this.jTable2.getValueAt(i, 3).toString());
/*      */     } 
/* 1318 */     ImprimirAbono impAbono = new ImprimirAbono();
/* 1319 */     impAbono.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jLabel40MouseEntered(MouseEvent evt) {
/* 1323 */     this.jLabel40.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel40MouseExited(MouseEvent evt) {
/* 1327 */     this.jLabel40.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel44MouseClicked(MouseEvent evt) {
/* 1331 */     String[] datos = { "FACTURA", "IMPORTE", "ABONO", "SALDO" };
/* 1332 */     this.esc = new EscribirReporte(this.jLabel31.getText().toUpperCase(), this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel44MouseEntered(MouseEvent evt) {
/* 1336 */     this.jLabel44.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel44MouseExited(MouseEvent evt) {
/* 1340 */     this.jLabel44.setForeground(Color.red);
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 1344 */     int ind = this.jTable3.getSelectedRow();
/* 1345 */     if (ind < 0) {
/* 1346 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder modificar la información", "Selecciona un documento", 0, this.ADVER);
/*      */     } else {
/* 1348 */       String FECHA = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 1349 */       String año = FECHA.substring(0, 4);
/* 1350 */       String mes = FECHA.substring(5, 7);
/* 1351 */       String dia = FECHA.substring(8, 10);
/* 1352 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1353 */       String strFecha = año + "-" + año + "-" + mes;
/* 1354 */       Date fecha = null;
/*      */       try {
/* 1356 */         fecha = formatoDelTexto.parse(strFecha);
/* 1357 */       } catch (ParseException ex) {
/* 1358 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 1361 */       this.jDateChooser6.setDate(fecha);
/* 1362 */       this.jTextField5.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3)));
/* 1363 */       this.jTextField6.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4)));
/* 1364 */       this.jTextField7.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5)));
/* 1365 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1370 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1374 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Está seguro que desea modificar los datos del depósito?", "Modificar", 0, 3, this.PREG);
/* 1375 */     if (res == 0) {
/* 1376 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1377 */       String cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/* 1378 */       String año = cadenaFecha1.substring(0, 4);
/* 1379 */       String mes = cadenaFecha1.substring(4, 6);
/* 1380 */       String dia = cadenaFecha1.substring(6, 8);
/* 1381 */       String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 1382 */       this.con.inserSinMsj("update abonosfacturas set fecha =" + fechaCompleta + ", banco = '" + this.jTextField5.getText().toUpperCase() + "', cuenta ='" + this.jTextField6.getText().toUpperCase() + "', referencia = '" + this.jTextField7.getText().toUpperCase() + "' where abono = '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "'");
/* 1383 */       this.con.inserSinMsj("update tarjeta_contenido_cliente set referencia = '" + this.jTextField7.getText().toUpperCase() + "' where num_abono='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "'");
/*      */       
/* 1385 */       this.jDialog2.setVisible(false);
/* 1386 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 1391 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Está seguro que desea saldar las facturas?", "Saldar", 0, 3, this.PREG);
/* 1392 */     if (res == 0) {
/* 1393 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*      */         
/* 1395 */         String v1 = String.valueOf(this.jTable2.getValueAt(i, 1));
/* 1396 */         String v2 = String.valueOf(this.jTable2.getValueAt(i, 2));
/* 1397 */         String v3 = String.valueOf(this.jTable2.getValueAt(i, 3));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1409 */         String factura = dameFolioFactura(this.jTable2.getValueAt(i, 0).toString());
/* 1410 */         this.con.consultar("importeSaldado", "facturas,tarjeta_contenido_cliente", "where tarjeta_contenido_cliente.factura = facturas.folio and folio = '" + factura + "'");
/* 1411 */         String aux = this.con.Campo;
/*      */         
/* 1413 */         if (!v3.equals("$0.00")) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1419 */           this.cantidad.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1434 */           this.con.inserSinMsj("update facturas set estatus='<Abono: " + this.cantidad.getText() + ">' where folio ='" + factura + "'");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1446 */           this.con.inserSinMsj("update facturas set estatus='<Pagada: " + cargarFechaHoy3() + ">' where folio ='" + factura + "'");
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel52MouseEntered(MouseEvent evt) {
/* 1455 */     this.jLabel52.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel52MouseExited(MouseEvent evt) {
/* 1459 */     this.jLabel52.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy3() {
/* 1463 */     Calendar ahoraCal = this.jDateChooser4.getCalendar();
/* 1464 */     ahoraCal.setTime(this.jDateChooser4.getCalendar().getTime());
/* 1465 */     String mesesito = "";
/* 1466 */     String hoy = "";
/* 1467 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1468 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 1470 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1471 */       mesesito = "0" + mesesito;
/*      */     }
/* 1473 */     if (ahoraCal.get(5) < 10) {
/* 1474 */       hoy = "0" + hoy;
/*      */     }
/* 1476 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public String dameFolioFactura(String ref) {
/* 1480 */     String[] fact = ref.split(": ");
/* 1481 */     return fact[1];
/*      */   }
/*      */   public double convertirCantTexto(String cant) {
/* 1484 */     String canti = cant;
/* 1485 */     String valorP = "";
/* 1486 */     for (int j = 0; j < canti.length(); j++) {
/* 1487 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1488 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1491 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   public void colorear() {
/* 1494 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1496 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1500 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1503 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1505 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1509 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1512 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1514 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1518 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 1521 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1523 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1527 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1530 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1532 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1536 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 1539 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1541 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1545 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 1548 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1550 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1554 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 1557 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1559 */             DepositosClientes.this.jTextGanado(DepositosClientes.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 1563 */             DepositosClientes.this.jTextPerdido(DepositosClientes.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 1569 */     int quitar = 4 * letras;
/* 1570 */     x -= quitar;
/* 1571 */     return x;
/*      */   }
/*      */   
/*      */   public double regresaMonto(String cantidad) {
/* 1575 */     double monto = 0.0D;
/* 1576 */     String valorP = "";
/* 1577 */     String canti = cantidad;
/* 1578 */     for (int k = 0; k < canti.length(); k++) {
/* 1579 */       if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 1580 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1583 */     monto = Double.parseDouble(valorP);
/* 1584 */     return monto;
/*      */   }
/*      */   
/*      */   public void verAbonos() {
/* 1588 */     int ind = this.jTable3.getSelectedRow();
/* 1589 */     String abono = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 1590 */     this.jLabel30.setText("DETALLES DEL ABONO " + String.valueOf(this.jTable3.getValueAt(ind, 0)));
/* 1591 */     this.jLabel33.setText(String.valueOf(this.jTable3.getValueAt(ind, 3)));
/* 1592 */     this.jLabel49.setText(String.valueOf(this.jTable3.getValueAt(ind, 4)));
/* 1593 */     this.jLabel51.setText(String.valueOf(this.jTable3.getValueAt(ind, 5)));
/* 1594 */     this.jLabel36.setText(String.valueOf(this.jTable3.getValueAt(ind, 7)));
/*      */     
/* 1596 */     String[] datos = this.con.regresaReg("abonosfacturas.tarjeta,empresa,calle,num,col,cp,ciudad,rfc,telefono,estados.estado", "tarjeta_deudor_cliente,abonosfacturas,emp_generadora,estados", "where tarjeta_deudor_cliente.tarjeta = abonosfacturas.tarjeta and emp_generadora.clave_gene = tarjeta_deudor_cliente.clave_gene and estados.id_edo = emp_generadora.id_edo and abonosfacturas.abono='" + abono + "'", 9);
/* 1597 */     this.DATOS[0] = datos[1];
/* 1598 */     this.DATOS[1] = datos[2];
/* 1599 */     this.DATOS[2] = datos[3];
/* 1600 */     this.DATOS[3] = datos[4];
/* 1601 */     this.DATOS[4] = datos[5];
/* 1602 */     this.DATOS[5] = datos[6];
/* 1603 */     this.DATOS[6] = datos[7];
/*      */     
/* 1605 */     this.DATOS[8] = String.valueOf(this.jTable3.getValueAt(ind, 3));
/* 1606 */     this.DATOS[9] = String.valueOf(this.jTable3.getValueAt(ind, 4));
/* 1607 */     this.DATOS[10] = String.valueOf(this.jTable3.getValueAt(ind, 5));
/* 1608 */     this.DATOS[12] = String.valueOf(this.jTable3.getValueAt(ind, 6));
/*      */     
/* 1610 */     this.jLabel2.setText("<html>" + datos[1] + "<br>" + datos[2] + " " + datos[3] + " " + datos[4] + "<br>" + datos[5] + " " + datos[6] + "<br>" + datos[7] + " " + datos[8] + "</html>");
/* 1611 */     this.jLabel34.setText(String.valueOf(this.jTable3.getValueAt(ind, 6)));
/* 1612 */     this.DATOS[17] = String.valueOf(this.jTable3.getValueAt(ind, 7));
/*      */ 
/*      */ 
/*      */     
/* 1616 */     String fecha = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 1617 */     String fechaCorta = fecha.substring(0, 10);
/*      */     
/* 1619 */     String año = fechaCorta.substring(0, 4);
/* 1620 */     String mes = fechaCorta.substring(5, 7);
/* 1621 */     String dia = fechaCorta.substring(8, 10);
/* 1622 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1623 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1624 */     this.DATOS[11] = strFecha;
/* 1625 */     this.jLabel35.setText(strFecha);
/*      */     
/* 1627 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 1628 */           .buscarDatos(4, "factura,importe,abono,saldo", "facturastransferencias", "where num_abono = '" + abono + "' order by num asc"), (Object[])new String[] { "Num de Fac", "Importe", "Abono", "Saldo" })
/*      */         {
/*      */ 
/*      */           
/* 1632 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1637 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1640 */     this.jLabel12.setText("" + this.jTable2.getRowCount() + " Facturas");
/* 1641 */     this.DATOS[15] = "" + this.jTable2.getRowCount();
/* 1642 */     this.jTable2.setSelectionMode(0);
/* 1643 */     this.jTable2.setAutoCreateRowSorter(true);
/* 1644 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1646 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 1647 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 1648 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/*      */     
/* 1650 */     this.con.consultar("count(factura)", "FacturasTransferencias", "where saldo <>'$0.00' and num_abono = '" + abono + "'");
/* 1651 */     this.jLabel8.setText(this.con.Campo);
/* 1652 */     this.DATOS[13] = this.con.Campo;
/*      */     
/* 1654 */     this.con.consultar("count(factura)", "FacturasTransferencias", "where saldo ='$0.00' and num_abono = '" + abono + "'");
/* 1655 */     this.jLabel10.setText(this.con.Campo);
/* 1656 */     this.DATOS[14] = this.con.Campo;
/*      */     
/* 1658 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1662 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1666 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 1670 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1678 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1684 */         return 30;
/*      */       
/*      */       case 1:
/* 1687 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1689 */           return 29;
/*      */         }
/* 1691 */         return 28;
/*      */     } 
/*      */     
/* 1694 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void privilegios() {
/* 1699 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 1700 */     this.DEPARTAMENTO = this.con.Campo;
/* 1701 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("ADMINISTRADOR")) {
/* 1702 */       this.jButton19.setEnabled(true);
/* 1703 */       this.jButton20.setEnabled(true);
/* 1704 */       this.jButton28.setEnabled(true);
/* 1705 */       this.jLabel44.setVisible(true);
/* 1706 */       this.jLabel40.setVisible(true);
/*      */       
/* 1708 */       this.jLabel46.setVisible(true);
/* 1709 */       this.jLabel41.setVisible(true);
/*      */     } else {
/* 1711 */       this.jButton19.setEnabled(false);
/* 1712 */       this.jButton20.setEnabled(false);
/* 1713 */       this.jButton28.setEnabled(false);
/* 1714 */       this.jLabel44.setVisible(false);
/* 1715 */       this.jLabel40.setVisible(false);
/*      */       
/* 1717 */       this.jLabel46.setVisible(false);
/* 1718 */       this.jLabel41.setVisible(false);
/*      */     } 
/* 1720 */     if (this.USUARIO.equals("KOFUZ01")) {
/* 1721 */       this.jLabel52.setVisible(true);
/*      */     } else {
/* 1723 */       this.jLabel52.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1728 */     Date fecha1 = this.jDateChooser4.getDate();
/* 1729 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 1731 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1732 */     String cadenaFecha = "";
/* 1733 */     cadenaFecha = formato.format(fecha1);
/* 1734 */     String AÑO = cadenaFecha.substring(0, 4);
/* 1735 */     String MES = cadenaFecha.substring(4, 6);
/* 1736 */     String DIA = cadenaFecha.substring(6, 8);
/* 1737 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 1739 */     cadenaFecha = formato.format(fecha2);
/* 1740 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 1741 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 1742 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 1743 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 1744 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */     
/* 1746 */     String cliente = "";
/* 1747 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 1748 */       cliente = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/*      */     
/* 1751 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1752 */           .buscarDatos(8, "abono,fecha,cliente,banco,cuenta,referencia,montoLetra,usuario", "abonosfacturas", "where abono like '%" + this.jTextField1.getText() + "%' and banco like '%" + this.jTextField2.getText() + "%' and cuenta like '%" + this.jTextField3.getText() + "%' and referencia like '%" + this.jTextField4.getText() + "%' and cliente like '%" + cliente + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num_abono desc"), (Object[])new String[] { "Folio", "Fecha", "Cliente", "Banco", "Cuenta", "Referencia", "Cantidad", "Documentó" })
/*      */         {
/*      */ 
/*      */           
/* 1756 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1761 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1764 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 1765 */     this.jTable3.setSelectionMode(0);
/* 1766 */     this.jTable3.setAutoCreateRowSorter(true);
/* 1767 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1769 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 1770 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(70);
/* 1771 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(60);
/* 1772 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(60);
/* 1773 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(115);
/* 1774 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(115);
/*      */     
/* 1776 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 1777 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 1778 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 1779 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1780 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1781 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 1782 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 1783 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */     
/* 1785 */     this.jLabel43.setText("$0.00");
/* 1786 */     double valor1 = 0.0D;
/* 1787 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 1788 */       String canti = String.valueOf(this.jTable3.getValueAt(i, 6));
/* 1789 */       String valorP = "";
/* 1790 */       for (int j = 0; j < canti.length(); j++) {
/* 1791 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1792 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 1796 */       valor1 += Double.parseDouble(valorP);
/* 1797 */       this.jFormattedTextField1.setValue(Double.valueOf(valor1));
/* 1798 */       this.jLabel43.setText(this.jFormattedTextField1.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void DepositosClientes(String usu) {
/* 1803 */     this.USUARIO = usu;
/* 1804 */     this.panel.setViewportView(this);
/*      */     
/* 1806 */     llenarCombos();
/*      */     
/* 1808 */     consultar();
/* 1809 */     privilegios();
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 1813 */     String[] datos = this.con.regresaColIndex("distinct(cliente)", "abonosfacturas", "order by cliente");
/* 1814 */     this.jComboBox1.removeAllItems();
/* 1815 */     this.jComboBox1.addItem("TODOS");
/* 1816 */     for (int i = 0; i < datos.length; i++)
/* 1817 */       this.jComboBox1.addItem(datos[i]); 
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer
/*      */   {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1824 */       setEnabled((table == null || table.isEnabled()));
/* 1825 */       if (row % 2 == 0) {
/* 1826 */         setBackground(new Color(194, 213, 151));
/* 1827 */         setForeground(Color.black);
/*      */       } else {
/* 1829 */         setBackground((Color)null);
/* 1830 */         setForeground(Color.black);
/*      */       } 
/* 1832 */       if (column == 6) {
/* 1833 */         setHorizontalAlignment(4);
/*      */       } else {
/* 1835 */         setHorizontalAlignment(10);
/*      */       } 
/* 1837 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1838 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender2
/*      */     extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1845 */       setHorizontalAlignment(4);
/* 1846 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1847 */       return this;
/*      */     } }
/*      */   public class ImprimirAbono implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirAbono() {
/* 1855 */       this.g2 = null;
/* 1856 */       this.Pag = 0;
/*      */       
/* 1858 */       this.linesPerPage = 50;
/* 1859 */       this.orientacion = 0;
/* 1860 */       this.X = 0.0D;
/* 1861 */       this.Y = 0.0D;
/* 1862 */       this.YINICIA = 75;
/* 1863 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 1864 */       this.NumLineas = 0;
/* 1865 */       this.numBreaks = 0;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initTextLines() {
/* 1870 */       if (this.textLines == null) {
/*      */ 
/*      */         
/* 1873 */         int numLines = DepositosClientes.this.jTable2.getRowCount();
/*      */         
/* 1875 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 1880 */       Font font = new Font("Serif", 0, 8);
/* 1881 */       FontMetrics metrics = g.getFontMetrics(font);
/* 1882 */       int lineHeight = metrics.getHeight();
/* 1883 */       if (this.pageBreaks == null) {
/* 1884 */         initTextLines();
/* 1885 */         this.orientacion = pf.getOrientation();
/* 1886 */         if (pf.getOrientation() == 1) {
/* 1887 */           this.linesPerPage = 42;
/* 1888 */           this.X = pf.getWidth();
/* 1889 */           this.Y = pf.getHeight();
/*      */         } else {
/* 1891 */           this.linesPerPage = 38;
/* 1892 */           this.X = pf.getWidth();
/* 1893 */           this.Y = pf.getHeight();
/*      */         } 
/* 1895 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 1896 */         this.Pag = this.numBreaks;
/* 1897 */         this.pageBreaks = new int[this.numBreaks];
/* 1898 */         for (int b = 0; b < this.numBreaks; b++) {
/* 1899 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 1902 */       if (pageIndex > this.pageBreaks.length) {
/* 1903 */         return 1;
/*      */       }
/* 1905 */       Graphics2D g2d = (Graphics2D)g;
/* 1906 */       this.g2 = g;
/* 1907 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 1908 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 1909 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 1910 */       encabezado();
/* 1911 */       int y = this.YINICIA;
/* 1912 */       int lineas = 0;
/*      */       
/* 1914 */       this.g2.drawRect(25, 170, 550, 12);
/* 1915 */       this.g2.setColor(new Color(204, 0, 0));
/* 1916 */       this.g2.fillRect(25, 171, 550, 10);
/*      */       
/* 1918 */       Font fuente = new Font("Dialog", 0, 7);
/* 1919 */       this.g2.setFont(fuente);
/* 1920 */       this.g2.setColor(Color.WHITE);
/* 1921 */       this.g2.drawString("NÚM", 29, 179);
/* 1922 */       this.g2.drawString("NÚM DE FAC", 109, 179);
/* 1923 */       this.g2.drawString("IMPORTE", 245, 179);
/* 1924 */       this.g2.drawString("ABONO", 375, 179);
/* 1925 */       this.g2.drawString("SALDO", 510, 179);
/*      */       
/* 1927 */       this.g2.setColor(Color.BLACK);
/* 1928 */       y = 180;
/* 1929 */       for (int line = start; line < end; line++) {
/* 1930 */         y += 12;
/*      */         
/* 1932 */         String valor = "";
/* 1933 */         if (line < 9) {
/* 1934 */           valor = "0" + line + 1;
/*      */         } else {
/* 1936 */           valor = "" + line + 1;
/*      */         } 
/* 1938 */         fuente = new Font("Dialog", 1, 7);
/* 1939 */         this.g2.setFont(fuente);
/* 1940 */         this.g2.drawString(valor, 27, y - 2);
/*      */         
/* 1942 */         fuente = new Font("Dialog", 0, 7);
/* 1943 */         this.g2.setFont(fuente);
/*      */         
/* 1945 */         this.g2.drawString(String.valueOf(DepositosClientes.this.jTable2.getValueAt(line, 0)), 102, y - 2);
/* 1946 */         this.g2.drawString(String.valueOf(DepositosClientes.this.jTable2.getValueAt(line, 1)), DepositosClientes.this.alinearDer(310, DepositosClientes.this.jTable2.getValueAt(line, 1).toString().length()), y - 2);
/* 1947 */         this.g2.drawString(String.valueOf(DepositosClientes.this.jTable2.getValueAt(line, 2)), DepositosClientes.this.alinearDer(441, DepositosClientes.this.jTable2.getValueAt(line, 2).toString().length()), y - 2);
/* 1948 */         this.g2.drawString(String.valueOf(DepositosClientes.this.jTable2.getValueAt(line, 3)), DepositosClientes.this.alinearDer(567, DepositosClientes.this.jTable2.getValueAt(line, 3).toString().length()), y - 2);
/*      */       } 
/* 1950 */       this.g2.drawLine(75, y, 185, y);
/* 1951 */       this.g2.drawLine(205, y, 315, y);
/* 1952 */       this.g2.drawLine(335, y, 445, y);
/* 1953 */       this.g2.drawLine(465, y, 575, y);
/*      */       
/* 1955 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 1956 */       if (this.Pag == pageIndex) {
/* 1957 */         fuente = new Font("Dialog", 1, 7);
/* 1958 */         this.g2.setFont(fuente);
/* 1959 */         g.drawString("SUMAS", 119, y + 10);
/* 1960 */         DepositosClientes.this.jFormattedTextField1.setValue(Double.valueOf(DepositosClientes.this.VALOR1));
/* 1961 */         this.g2.drawString(DepositosClientes.this.jFormattedTextField1.getText(), DepositosClientes.this.alinearDer(310, DepositosClientes.this.jFormattedTextField1.getText().length()), y + 10);
/* 1962 */         this.g2.drawString(DepositosClientes.this.jLabel34.getText(), DepositosClientes.this.alinearDer(441, DepositosClientes.this.jLabel34.getText().length()), y + 10);
/* 1963 */         DepositosClientes.this.jFormattedTextField1.setValue(Double.valueOf(DepositosClientes.this.VALOR2));
/* 1964 */         this.g2.drawString(DepositosClientes.this.jFormattedTextField1.getText(), DepositosClientes.this.alinearDer(569, DepositosClientes.this.jFormattedTextField1.getText().length()), y + 10);
/*      */         
/* 1966 */         fuente = new Font("Dialog", 1, 7);
/* 1967 */         this.g2.setFont(fuente);
/* 1968 */         this.g2.drawString("ELABORÓ", 290, 720);
/* 1969 */         this.g2.drawString("_____________________________________", 240, 752);
/* 1970 */         this.g2.drawString("NOMBRE Y FIRMA", 278, 765);
/*      */       } 
/* 1972 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 1976 */       Font fuente = new Font("Dialog", 0, 8);
/* 1977 */       this.g2.setFont(fuente);
/* 1978 */       this.g2.setColor(Color.BLACK);
/* 1979 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 1980 */       Image img = imagen.getImage();
/* 1981 */       this.g2.drawImage(img, 518, 9, 57, 57, null);
/*      */       
/* 1983 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 1984 */       img = imagen.getImage();
/* 1985 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*      */       
/* 1987 */       fuente = new Font("Times New Roman", 1, 16);
/* 1988 */       this.g2.setFont(fuente);
/* 1989 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/* 1990 */       this.g2.drawString(DepositosClientes.this.DATOS[0], 135, 65);
/*      */       
/* 1992 */       fuente = new Font("Dialog", 0, 12);
/* 1993 */       this.g2.setFont(fuente);
/* 1994 */       this.g2.drawString("DETALLES DEL DEPÓSITO " + String.valueOf(DepositosClientes.this.jTable3.getValueAt(DepositosClientes.this.jTable3.getSelectedRow(), 0)), 200, 37);
/* 1995 */       this.g2.drawLine(25, 70, 575, 70);
/*      */       
/* 1997 */       this.g2.setColor(Color.BLACK);
/* 1998 */       this.g2.drawLine(25, 98, 220, 98);
/* 1999 */       this.g2.drawLine(25, 148, 220, 148);
/*      */       
/* 2001 */       fuente = new Font("Dialog", 1, 8);
/* 2002 */       this.g2.setFont(fuente);
/* 2003 */       this.g2.setColor(Color.BLACK);
/* 2004 */       this.g2.drawString("INFORMACIÓN DEL DEPÓSITO", 25, 95);
/*      */       
/* 2006 */       fuente = new Font("Dialog", 1, 7);
/* 2007 */       this.g2.setFont(fuente);
/* 2008 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 2010 */       this.g2.drawString("Banco: ", 27, 108);
/* 2011 */       this.g2.drawString("Cuenta: ", 27, 119);
/* 2012 */       this.g2.drawString("Ref: ", 27, 130);
/* 2013 */       this.g2.drawString("Depósito por: ", 27, 141);
/*      */       
/* 2015 */       fuente = new Font("Dialog", 0, 7);
/* 2016 */       this.g2.setFont(fuente);
/* 2017 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 2019 */       this.g2.drawString(DepositosClientes.this.DATOS[8], 85, 108);
/* 2020 */       this.g2.drawString(DepositosClientes.this.DATOS[9], 85, 119);
/* 2021 */       this.g2.drawString(DepositosClientes.this.DATOS[10], 85, 130);
/* 2022 */       this.g2.drawString(DepositosClientes.this.DATOS[12], 85, 141);
/*      */       
/* 2024 */       this.g2.drawString(DepositosClientes.this.DATOS[11], 540, 78);
/*      */       
/* 2026 */       fuente = new Font("Dialog", 0, 7);
/* 2027 */       this.g2.setFont(fuente);
/* 2028 */       this.g2.drawString("A continuación se enlistan todos los movimientos del depósito:", 25, 168);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 2032 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 2033 */       job.setPrintable(this);
/*      */       
/* 2035 */       PageFormat pf = job.defaultPage();
/* 2036 */       Paper papel = pf.getPaper();
/* 2037 */       papel.setSize(612.0D, 792.0D);
/* 2038 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 2039 */       pf.setPaper(papel);
/* 2040 */       pf.setOrientation(1);
/* 2041 */       job.setPrintable(new ImprimirAbono(), pf);
/* 2042 */       job.defaultPage(pf);
/*      */       
/* 2044 */       boolean ok = job.printDialog();
/* 2045 */       if (ok)
/*      */         try {
/* 2047 */           job.print();
/* 2048 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/DepositosClientes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */