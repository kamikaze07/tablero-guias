/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import jxl.write.Label;
/*      */ import jxl.write.WritableCellFormat;
/*      */ import jxl.write.WritableFont;
/*      */ import jxl.write.WritableSheet;
/*      */ import org.jfree.chart.ChartPanel;
/*      */ import org.jfree.chart.JFreeChart;
/*      */ import org.jfree.data.category.DefaultCategoryDataset;
/*      */ 
/*      */ public class Estadisticos extends JPanel {
/*      */   Color color;
/*      */   JFrame padre;
/*      */   JScrollPane panel;
/*   32 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   33 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   34 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   35 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   36 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   37 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   38 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   39 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   40 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   EscribirEstadis esc;
/*   45 */   Errores error = new Errores(false);
/*   46 */   Validaciones val = new Validaciones();
/*   47 */   Date fechaInicio = null;
/*   48 */   Date fechaTermino = null;
/*   49 */   Date fechaActual = new Date();
/*   50 */   CeldaRender celda = new CeldaRender();
/*   51 */   CeldaRender2 celda2 = new CeldaRender2();
/*   52 */   Esperando espe = new Esperando();
/*   53 */   String FECHA1 = "";
/*   54 */   String FECHA2 = "";
/*      */   boolean SIGUE = true;
/*   56 */   String viajes = "";
/*      */   String[] CLIENTESCOMP;
/*   58 */   int COLUMNAINDICE = 0; String[] RESIDUOS; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JButton jButton1; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JComboBox jComboBox1; private JDateChooser jDateChooser1; private JDateChooser jDateChooser2; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JFrame jFrame1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel2; private JLabel jLabel3; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45;
/*      */   private JLabel jLabel5;
/*      */   
/*      */   public Estadisticos(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) throws IOException {
/*   62 */     String año = "2009";
/*   63 */     String mes = "11";
/*   64 */     String dia = "19";
/*   65 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   66 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   68 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*      */     }
/*   70 */     catch (ParseException ex) {
/*   71 */       ex.printStackTrace();
/*      */     } 
/*      */ 
/*      */     
/*   75 */     Calendar ca = Calendar.getInstance();
/*   76 */     Calendar fecha = Calendar.getInstance();
/*   77 */     int aa = fecha.get(1);
/*   78 */     int mm = fecha.get(2);
/*   79 */     int dd = fecha.get(5);
/*   80 */     int diasTotal = diasDelMes(mm, aa);
/*   81 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   82 */     strFecha = "";
/*   83 */     if (diasTotal == dd) {
/*   84 */       dd = 1;
/*   85 */       if (mm == 11) {
/*   86 */         aa++;
/*   87 */         mm = 0;
/*      */       } else {
/*      */         
/*   90 */         mm++;
/*      */       } 
/*      */     } else {
/*   93 */       dd++;
/*      */     } 
/*   95 */     mm++;
/*   96 */     año = "" + aa;
/*   97 */     mes = "" + mm;
/*   98 */     dia = "" + dd;
/*   99 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  100 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  102 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/*      */     }
/*  104 */     catch (ParseException ex) {
/*  105 */       ex.printStackTrace();
/*      */     } 
/*      */     
/*  108 */     this.USUARIO = usua;
/*      */     
/*  110 */     this.fichas = fichas;
/*  111 */     this.padre = padre;
/*  112 */     initComponents();
/*  113 */     panelito.setViewportView(this);
/*  114 */     this.panel = panelito;
/*  115 */     colorear();
/*      */     
/*  117 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  118 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  119 */     this.jFrame1.setCursor(micursor);
/*  120 */     this.jDialog1.setCursor(micursor);
/*  121 */     this.jDialog4.setCursor(micursor);
/*      */     
/*  123 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  124 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  125 */     this.jLabel1.setCursor(micursor);
/*  126 */     this.jLabel37.setCursor(micursor);
/*  127 */     this.jLabel38.setCursor(micursor);
/*  128 */     this.jLabel44.setCursor(micursor);
/*      */     
/*  130 */     int w = this.tama.width;
/*  131 */     int h = this.tama.height;
/*  132 */     int rw = (w - 1100) / 2;
/*  133 */     int rh = (h - 670) / 2;
/*  134 */     this.jFrame1.setLocation(rw, rh);
/*  135 */     this.jFrame1.setSize(1100, 670);
/*  136 */     this.jFrame1.setVisible(false);
/*      */     
/*  138 */     rw = (w - 700) / 2;
/*  139 */     rh = (h - 330) / 2;
/*  140 */     this.jDialog1.setLocation(rw, rh);
/*  141 */     this.jDialog1.setSize(700, 330);
/*  142 */     this.jDialog1.setVisible(false);
/*  143 */     this.jDialog1.setResizable(false);
/*      */     
/*  145 */     rw = (w - 500) / 2;
/*  146 */     rh = (h - 130) / 2;
/*  147 */     this.jDialog3.setLocation(rw, rh);
/*  148 */     this.jDialog3.setSize(500, 130);
/*  149 */     this.jDialog3.setVisible(false);
/*  150 */     this.jDialog3.setResizable(false);
/*      */     
/*  152 */     rw = (w - 540) / 2;
/*  153 */     rh = (h - 330) / 2;
/*  154 */     this.jDialog4.setLocation(rw, rh);
/*  155 */     this.jDialog4.setSize(540, 330);
/*  156 */     this.jDialog4.setVisible(false);
/*  157 */     this.jDialog4.setResizable(false);
/*      */     
/*  159 */     this.jLabel2.setCursor(new Cursor(3));
/*      */     
/*  161 */     Image icono = this.tk.getImage(getClass().getResource("grafica.png"));
/*  162 */     this.jFrame1.setIconImage(icono);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  212 */     this.buttonGroup1.add(this.jRadioButton1);
/*  213 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  215 */     this.buttonGroup2.add(this.jRadioButton3);
/*  216 */     this.buttonGroup2.add(this.jRadioButton4);
/*      */   }
/*      */   private JLabel jLabel6; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane6; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator6; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable6;
/*      */   
/*      */   private void initComponents() {
/*  221 */     this.buttonGroup1 = new ButtonGroup();
/*  222 */     this.jFrame1 = new JFrame();
/*  223 */     this.jPanel2 = new JPanel();
/*  224 */     this.jLabel66 = new JLabel();
/*  225 */     this.jSeparator3 = new JSeparator();
/*  226 */     this.jLabel67 = new JLabel();
/*  227 */     this.jScrollPane1 = new JScrollPane();
/*  228 */     this.jTable1 = new JTable();
/*  229 */     this.jPanel10 = new JPanel();
/*  230 */     this.jScrollPane3 = new JScrollPane();
/*  231 */     this.jTable3 = new JTable();
/*  232 */     this.jLabel2 = new JLabel();
/*  233 */     this.jButton5 = new JButton();
/*  234 */     this.jButton6 = new JButton();
/*  235 */     this.jButton4 = new JButton();
/*  236 */     this.jButton3 = new JButton();
/*  237 */     this.jDialog1 = new JDialog(this.jFrame1);
/*  238 */     this.jPanel3 = new JPanel();
/*  239 */     this.jLabel3 = new JLabel();
/*  240 */     this.jLabel4 = new JLabel();
/*  241 */     this.jLabel5 = new JLabel();
/*  242 */     this.jScrollPane2 = new JScrollPane();
/*  243 */     this.jTable2 = new JTable();
/*  244 */     this.jLabel6 = new JLabel();
/*  245 */     this.jLabel39 = new JLabel();
/*  246 */     this.jLabel37 = new JLabel();
/*  247 */     this.jLabel40 = new JLabel();
/*  248 */     this.jLabel8 = new JLabel();
/*  249 */     this.jLabel9 = new JLabel();
/*  250 */     this.jPanel5 = new JPanel();
/*  251 */     this.jPanel6 = new JPanel();
/*  252 */     this.jDialog2 = new JDialog(this.jFrame1);
/*  253 */     this.jPanel4 = new JPanel();
/*  254 */     this.jLabel7 = new JLabel();
/*  255 */     this.jRadioButton3 = new JRadioButton();
/*  256 */     this.jRadioButton4 = new JRadioButton();
/*  257 */     this.jSeparator4 = new JSeparator();
/*  258 */     this.buttonGroup2 = new ButtonGroup();
/*  259 */     this.jDialog3 = new JDialog(this.jFrame1);
/*  260 */     this.jPanel8 = new JPanel();
/*  261 */     this.jLabel11 = new JLabel();
/*  262 */     this.jLabel12 = new JLabel();
/*  263 */     this.jLabel38 = new JLabel();
/*  264 */     this.jLabel41 = new JLabel();
/*  265 */     this.jLabel42 = new JLabel();
/*  266 */     this.jDialog4 = new JDialog(this.jFrame1);
/*  267 */     this.jPanel9 = new JPanel();
/*  268 */     this.jLabel13 = new JLabel();
/*  269 */     this.jSeparator6 = new JSeparator();
/*  270 */     this.jScrollPane6 = new JScrollPane();
/*  271 */     this.jTable6 = new JTable();
/*  272 */     this.jLabel43 = new JLabel();
/*  273 */     this.jLabel44 = new JLabel();
/*  274 */     this.jLabel45 = new JLabel();
/*  275 */     this.jLabel10 = new JLabel();
/*  276 */     this.jLabel14 = new JLabel();
/*  277 */     this.jPanel1 = new JPanel();
/*  278 */     this.jLabel62 = new JLabel();
/*  279 */     this.jSeparator1 = new JSeparator();
/*  280 */     this.jLabel63 = new JLabel();
/*  281 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  282 */     this.jLabel64 = new JLabel();
/*  283 */     this.jLabel1 = new JLabel();
/*  284 */     this.jSeparator2 = new JSeparator();
/*  285 */     this.jLabel65 = new JLabel();
/*  286 */     this.jComboBox1 = new JComboBox();
/*  287 */     this.jButton1 = new JButton();
/*  288 */     this.jButton2 = new JButton();
/*  289 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  290 */     this.jRadioButton1 = new JRadioButton();
/*  291 */     this.jRadioButton2 = new JRadioButton();
/*      */     
/*  293 */     this.jFrame1.setTitle("Estadísticos");
/*      */     
/*  295 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/*      */     
/*  297 */     this.jLabel66.setFont(new Font("Tahoma", 1, 15));
/*  298 */     this.jLabel66.setForeground(Color.blue);
/*  299 */     this.jLabel66.setHorizontalAlignment(0);
/*  300 */     this.jLabel66.setText("INFORME DE ");
/*      */     
/*  302 */     this.jLabel67.setFont(new Font("Tahoma", 1, 14));
/*  303 */     this.jLabel67.setHorizontalAlignment(0);
/*  304 */     this.jLabel67.setText("Periodo de");
/*      */     
/*  306 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  307 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { "CARGANDO         COMPONENTES         ESPERE       ................." },  }, (Object[])new String[] { "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  315 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  317 */             Estadisticos.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/*  320 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  322 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/*  324 */     this.jTable3.setFont(new Font("Tahoma", 1, 11));
/*  325 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { " CALCULANDO     VIAJES    .........." },  }, (Object[])new String[] { "Totales" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  333 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  335 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/*  336 */     this.jLabel2.setForeground(Color.red);
/*  337 */     this.jLabel2.setText("Calculando datos por favor espere ...");
/*      */     
/*  339 */     this.jButton5.setMnemonic('G');
/*  340 */     this.jButton5.setText("Guardar");
/*  341 */     this.jButton5.setToolTipText("Guardar (Alt+G)");
/*  342 */     this.jButton5.setEnabled(false);
/*  343 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  345 */             Estadisticos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  349 */     this.jButton6.setMnemonic('V');
/*  350 */     this.jButton6.setText("Ver Detalle");
/*  351 */     this.jButton6.setToolTipText("Ver Detalle de Viajes (Alt+V)");
/*  352 */     this.jButton6.setEnabled(false);
/*  353 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  355 */             Estadisticos.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  359 */     this.jButton4.setMnemonic('R');
/*  360 */     this.jButton4.setText("Graficar");
/*  361 */     this.jButton4.setToolTipText("Graficar Funciones (Alt+R)");
/*  362 */     this.jButton4.setEnabled(false);
/*  363 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  365 */             Estadisticos.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  369 */     this.jButton3.setMnemonic('C');
/*  370 */     this.jButton3.setText("Cerrar");
/*  371 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/*  372 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  374 */             Estadisticos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  378 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  379 */     this.jPanel10.setLayout(jPanel10Layout);
/*  380 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  382 */         .addGap(0, 713, 32767)
/*  383 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  384 */           .addGroup(jPanel10Layout.createSequentialGroup()
/*  385 */             .addContainerGap()
/*  386 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  387 */               .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/*  388 */                 .addComponent(this.jLabel2, -2, 239, -2)
/*  389 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767)
/*  390 */                 .addComponent(this.jButton5, -2, 94, -2)
/*  391 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  392 */                 .addComponent(this.jButton6, -2, 114, -2)
/*  393 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  394 */                 .addComponent(this.jButton4, -2, 94, -2)
/*  395 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  396 */                 .addComponent(this.jButton3, -2, 94, -2))
/*  397 */               .addComponent(this.jScrollPane3, -1, 693, 32767))
/*  398 */             .addContainerGap())));
/*      */     
/*  400 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGap(0, 106, 32767)
/*  403 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  404 */           .addGroup(jPanel10Layout.createSequentialGroup()
/*  405 */             .addGap(5, 5, 5)
/*  406 */             .addComponent(this.jScrollPane3, -2, 61, -2)
/*  407 */             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  408 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  409 */               .addComponent(this.jButton3)
/*  410 */               .addComponent(this.jButton4)
/*  411 */               .addComponent(this.jLabel2)
/*  412 */               .addComponent(this.jButton5)
/*  413 */               .addComponent(this.jButton6))
/*  414 */             .addContainerGap(-1, 32767))));
/*      */ 
/*      */     
/*  417 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  418 */     this.jPanel2.setLayout(jPanel2Layout);
/*  419 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  421 */         .addComponent(this.jLabel66, GroupLayout.Alignment.TRAILING, -1, 713, 32767)
/*  422 */         .addComponent(this.jPanel10, -1, -1, 32767)
/*  423 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  424 */           .addContainerGap()
/*  425 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  426 */             .addComponent(this.jSeparator3, -1, 693, 32767)
/*  427 */             .addComponent(this.jLabel67, -1, 693, 32767)
/*  428 */             .addComponent(this.jScrollPane1, -1, 693, 32767))
/*  429 */           .addContainerGap()));
/*      */     
/*  431 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  432 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  433 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  434 */           .addContainerGap()
/*  435 */           .addComponent(this.jLabel66)
/*  436 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  437 */           .addComponent(this.jLabel67)
/*  438 */           .addGap(11, 11, 11)
/*  439 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  440 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  441 */           .addComponent(this.jScrollPane1, -1, 488, 32767)
/*  442 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  443 */           .addComponent(this.jPanel10, -2, -1, -2)));
/*      */ 
/*      */     
/*  446 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/*  447 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/*  448 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/*  449 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  450 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/*  452 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/*  453 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  454 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */ 
/*      */     
/*  457 */     this.jDialog1.setTitle("Detalle de los Viajes");
/*  458 */     this.jDialog1.setModal(true);
/*      */     
/*  460 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  462 */     this.jLabel3.setFont(new Font("Tahoma", 1, 12));
/*  463 */     this.jLabel3.setText("NOMBRE DEL OPERADOR");
/*      */     
/*  465 */     this.jLabel4.setHorizontalAlignment(4);
/*  466 */     this.jLabel4.setText("Tipo");
/*      */     
/*  468 */     this.jLabel5.setFont(new Font("Tahoma", 1, 12));
/*  469 */     this.jLabel5.setText("jLabel5");
/*      */     
/*  471 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/*  472 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  483 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  485 */     this.jLabel6.setText("A continuación se muestran los detalles de los viajes");
/*      */     
/*  487 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/*  488 */     this.jLabel39.setText("|");
/*      */     
/*  490 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/*  491 */     this.jLabel37.setForeground(Color.red);
/*  492 */     this.jLabel37.setHorizontalAlignment(0);
/*  493 */     this.jLabel37.setText("<html><u>Cerrar</u></html>");
/*  494 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  496 */             Estadisticos.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  499 */             Estadisticos.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  502 */             Estadisticos.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  506 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/*  507 */     this.jLabel40.setText("|");
/*      */     
/*  509 */     this.jLabel8.setFont(new Font("Tahoma", 1, 11));
/*  510 */     this.jLabel8.setText("Viajes Completos");
/*      */     
/*  512 */     this.jLabel9.setFont(new Font("Tahoma", 1, 11));
/*  513 */     this.jLabel9.setText("Viajes pendientes por completar");
/*      */     
/*  515 */     this.jPanel5.setBackground(new Color(102, 153, 255));
/*  516 */     this.jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  518 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  519 */     this.jPanel5.setLayout(jPanel5Layout);
/*  520 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  521 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  522 */         .addGap(0, 28, 32767));
/*      */     
/*  524 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  526 */         .addGap(0, 18, 32767));
/*      */ 
/*      */     
/*  529 */     this.jPanel6.setBackground(new Color(194, 213, 151));
/*  530 */     this.jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  532 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  533 */     this.jPanel6.setLayout(jPanel6Layout);
/*  534 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  535 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  536 */         .addGap(0, 28, 32767));
/*      */     
/*  538 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  539 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  540 */         .addGap(0, 18, 32767));
/*      */ 
/*      */     
/*  543 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  544 */     this.jPanel3.setLayout(jPanel3Layout);
/*  545 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  546 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  547 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  548 */           .addContainerGap()
/*  549 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  550 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 636, 32767)
/*  551 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
/*  552 */               .addComponent(this.jLabel3, -2, 360, -2)
/*  553 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  554 */               .addComponent(this.jLabel4, -2, 82, -2)
/*  555 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  556 */               .addComponent(this.jLabel5, -1, 182, 32767))
/*  557 */             .addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -2, 554, -2)
/*  558 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  559 */               .addComponent(this.jPanel6, -2, -1, -2)
/*  560 */               .addGap(15, 15, 15)
/*  561 */               .addComponent(this.jLabel8, -2, 116, -2)
/*  562 */               .addGap(29, 29, 29)
/*  563 */               .addComponent(this.jPanel5, -2, -1, -2)
/*  564 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  565 */               .addComponent(this.jLabel9, -2, 204, -2)
/*  566 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 128, 32767)
/*  567 */               .addComponent(this.jLabel40)
/*  568 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  569 */               .addComponent(this.jLabel37, -2, 48, -2)
/*  570 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  571 */               .addComponent(this.jLabel39)))
/*  572 */           .addContainerGap()));
/*      */     
/*  574 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  575 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  576 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  577 */           .addContainerGap()
/*  578 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  579 */             .addComponent(this.jLabel3)
/*  580 */             .addComponent(this.jLabel5)
/*  581 */             .addComponent(this.jLabel4))
/*  582 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  583 */           .addComponent(this.jLabel6)
/*  584 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  585 */           .addComponent(this.jScrollPane2, -1, 232, 32767)
/*  586 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  587 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  588 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  589 */               .addComponent(this.jPanel5, -2, -1, -2)
/*  590 */               .addGroup(jPanel3Layout.createSequentialGroup()
/*  591 */                 .addGap(4, 4, 4)
/*  592 */                 .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  593 */                   .addComponent(this.jLabel39)
/*  594 */                   .addComponent(this.jLabel37, -2, -1, -2)
/*  595 */                   .addComponent(this.jLabel40)
/*  596 */                   .addComponent(this.jLabel8)
/*  597 */                   .addComponent(this.jLabel9))))
/*  598 */             .addComponent(this.jPanel6, -2, -1, -2))
/*  599 */           .addContainerGap()));
/*      */ 
/*      */     
/*  602 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  603 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  604 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  605 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  606 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  608 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  609 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  610 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  613 */     this.jDialog2.setTitle("Graficación de los Viajes");
/*  614 */     this.jDialog2.setModal(true);
/*      */     
/*  616 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  617 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  618 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  619 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  620 */         .addGap(0, 400, 32767));
/*      */     
/*  622 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  624 */         .addGap(0, 300, 32767));
/*      */ 
/*      */     
/*  627 */     this.jLabel7.setText("Selecciona los datos que deseas graficar:");
/*      */     
/*  629 */     this.jRadioButton3.setSelected(true);
/*  630 */     this.jRadioButton3.setText("Operadores");
/*      */     
/*  632 */     this.jRadioButton4.setText("Clientes");
/*      */     
/*  634 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  635 */     this.jPanel4.setLayout(jPanel4Layout);
/*  636 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  638 */         .addComponent(this.jSeparator4)
/*  639 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  640 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  641 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  642 */               .addGap(10, 10, 10)
/*  643 */               .addComponent(this.jRadioButton3, -2, 126, -2)
/*  644 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  645 */               .addComponent(this.jRadioButton4, -2, 111, -2))
/*  646 */             .addComponent(this.jLabel7, -2, 223, -2))
/*  647 */           .addContainerGap(-1, 32767)));
/*      */     
/*  649 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  650 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  651 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  652 */           .addComponent(this.jLabel7)
/*  653 */           .addGap(1, 1, 1)
/*  654 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  655 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  656 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  657 */             .addComponent(this.jRadioButton3)
/*  658 */             .addComponent(this.jRadioButton4))
/*  659 */           .addContainerGap()));
/*      */ 
/*      */     
/*  662 */     this.jDialog3.setTitle("Procesando Datos...");
/*  663 */     this.jDialog3.setCursor(new Cursor(0));
/*  664 */     this.jDialog3.setModal(true);
/*  665 */     this.jDialog3.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  667 */             Estadisticos.this.jDialog3WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  671 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/*      */     
/*  673 */     this.jLabel11.setFont(new Font("Tahoma", 1, 15));
/*  674 */     this.jLabel11.setHorizontalAlignment(0);
/*  675 */     this.jLabel11.setText("Espere un momento se están calculando los datos...");
/*      */     
/*  677 */     this.jLabel12.setFont(new Font("Tahoma", 2, 11));
/*  678 */     this.jLabel12.setText("<html><center>Éste proceso puede tardar varios min. dependiendo el rendimiento del equipo que está calculando la información</center></hyml>");
/*      */     
/*  680 */     this.jLabel38.setFont(new Font("Tahoma", 1, 11));
/*  681 */     this.jLabel38.setForeground(Color.red);
/*  682 */     this.jLabel38.setHorizontalAlignment(0);
/*  683 */     this.jLabel38.setText("<html><u>Cancelar</u></html>");
/*  684 */     this.jLabel38.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  686 */             Estadisticos.this.jLabel38MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  689 */             Estadisticos.this.jLabel38MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  692 */             Estadisticos.this.jLabel38MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  696 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/*  697 */     this.jLabel41.setText("|");
/*      */     
/*  699 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/*  700 */     this.jLabel42.setText("|");
/*      */     
/*  702 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  703 */     this.jPanel8.setLayout(jPanel8Layout);
/*  704 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  706 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  707 */           .addContainerGap()
/*  708 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  709 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  710 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  711 */                 .addComponent(this.jLabel12, GroupLayout.Alignment.LEADING, -1, 493, 32767)
/*  712 */                 .addComponent(this.jLabel11, GroupLayout.Alignment.LEADING, -1, 493, 32767))
/*  713 */               .addContainerGap())
/*  714 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  715 */               .addComponent(this.jLabel41)
/*  716 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  717 */               .addComponent(this.jLabel38, -2, 60, -2)
/*  718 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  719 */               .addComponent(this.jLabel42)
/*  720 */               .addGap(213, 213, 213)))));
/*      */     
/*  722 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  723 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  724 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  725 */           .addContainerGap()
/*  726 */           .addComponent(this.jLabel11)
/*  727 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  728 */           .addComponent(this.jLabel12, -2, -1, -2)
/*  729 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  730 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  731 */             .addComponent(this.jLabel42)
/*  732 */             .addComponent(this.jLabel38, -2, -1, -2)
/*  733 */             .addComponent(this.jLabel41))
/*  734 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  737 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  738 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  739 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  740 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  741 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/*  743 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  745 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/*  748 */     this.jDialog4.setTitle("Resumen de la Información");
/*  749 */     this.jDialog4.setCursor(new Cursor(0));
/*  750 */     this.jDialog4.setModal(true);
/*  751 */     this.jDialog4.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  753 */             Estadisticos.this.jDialog4WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  757 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/*  759 */     this.jLabel13.setFont(new Font("Times New Roman", 1, 26));
/*  760 */     this.jLabel13.setHorizontalAlignment(0);
/*  761 */     this.jLabel13.setText("Información Destacada");
/*      */     
/*  763 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/*  764 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, {} }, (Object[])new String[0]));
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
/*  775 */     this.jScrollPane6.setViewportView(this.jTable6);
/*      */     
/*  777 */     this.jLabel43.setFont(new Font("Tahoma", 1, 11));
/*  778 */     this.jLabel43.setText("|");
/*      */     
/*  780 */     this.jLabel44.setFont(new Font("Tahoma", 1, 11));
/*  781 */     this.jLabel44.setForeground(Color.red);
/*  782 */     this.jLabel44.setHorizontalAlignment(0);
/*  783 */     this.jLabel44.setText("<html><u>Cerrar</u></html>");
/*  784 */     this.jLabel44.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  786 */             Estadisticos.this.jLabel44MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  789 */             Estadisticos.this.jLabel44MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  792 */             Estadisticos.this.jLabel44MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  796 */     this.jLabel45.setFont(new Font("Tahoma", 1, 11));
/*  797 */     this.jLabel45.setText("|");
/*      */     
/*  799 */     this.jLabel10.setFont(new Font("Tahoma", 1, 15));
/*  800 */     this.jLabel10.setForeground(Color.blue);
/*  801 */     this.jLabel10.setText("Total de Datos:");
/*      */     
/*  803 */     this.jLabel14.setFont(new Font("Tahoma", 0, 18));
/*  804 */     this.jLabel14.setText("988");
/*      */     
/*  806 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  807 */     this.jPanel9.setLayout(jPanel9Layout);
/*  808 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  809 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  810 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  811 */           .addContainerGap()
/*  812 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  813 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 518, 32767)
/*  814 */             .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING, -1, 518, 32767)
/*  815 */             .addComponent(this.jLabel13, GroupLayout.Alignment.LEADING, -1, 518, 32767)
/*  816 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  817 */               .addComponent(this.jLabel10, -2, 120, -2)
/*  818 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  819 */               .addComponent(this.jLabel14, -2, 65, -2)
/*  820 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 241, 32767)
/*  821 */               .addComponent(this.jLabel43)
/*  822 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  823 */               .addComponent(this.jLabel44, -2, 60, -2)
/*  824 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  825 */               .addComponent(this.jLabel45)))
/*  826 */           .addContainerGap()));
/*      */     
/*  828 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  829 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  830 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  831 */           .addComponent(this.jLabel13)
/*  832 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  833 */           .addComponent(this.jSeparator6, -2, 10, -2)
/*  834 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  835 */           .addComponent(this.jScrollPane6, -2, 206, -2)
/*  836 */           .addGap(11, 11, 11)
/*  837 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  838 */             .addComponent(this.jLabel45)
/*  839 */             .addComponent(this.jLabel44, -2, -1, -2)
/*  840 */             .addComponent(this.jLabel43)
/*  841 */             .addComponent(this.jLabel10)
/*  842 */             .addComponent(this.jLabel14))
/*  843 */           .addContainerGap(14, 32767)));
/*      */ 
/*      */     
/*  846 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  847 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  848 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  850 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  852 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  853 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  854 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/*  857 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*  858 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  860 */     this.jLabel62.setFont(new Font("Tahoma", 1, 18));
/*  861 */     this.jLabel62.setForeground(Color.blue);
/*  862 */     this.jLabel62.setHorizontalAlignment(0);
/*  863 */     this.jLabel62.setText("INDICADORES CLAVE DE DESEMPEÑO");
/*      */     
/*  865 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*  866 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  867 */     this.jLabel63.setHorizontalAlignment(4);
/*  868 */     this.jLabel63.setText("Periodo de ");
/*      */     
/*  870 */     this.jDateChooser1.setDate(this.fechaActual);
/*  871 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/*  872 */     this.jDateChooser1.setIcon(this.icon);
/*  873 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/*  874 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  876 */     this.jLabel64.setFont(new Font("Tahoma", 3, 11));
/*  877 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/*  878 */     this.jLabel64.setHorizontalAlignment(0);
/*  879 */     this.jLabel64.setText("Al");
/*      */     
/*  881 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/*  882 */     this.jLabel1.setText("<html><u>Clic para Filtrar</u></html>");
/*  883 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  885 */             Estadisticos.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  889 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/*  890 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/*  891 */     this.jLabel65.setHorizontalAlignment(4);
/*  892 */     this.jLabel65.setText("Tipo de informe ");
/*      */     
/*  894 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  895 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/*  896 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "OPERADORES", "CLIENTES" }));
/*  897 */     this.jComboBox1.setEnabled(false);
/*  898 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  900 */             Estadisticos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  904 */     this.jButton1.setFont(new Font("Tahoma", 1, 11));
/*  905 */     this.jButton1.setText(" Ver");
/*  906 */     this.jButton1.setEnabled(false);
/*  907 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  909 */             Estadisticos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  913 */     this.jButton2.setText("Cancelar");
/*  914 */     this.jButton2.setEnabled(false);
/*  915 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  917 */             Estadisticos.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  921 */     this.jDateChooser2.setDate(this.fechaActual);
/*  922 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/*  923 */     this.jDateChooser2.setIcon(this.icon);
/*  924 */     this.jDateChooser2.setMaxSelectableDate(this.fechaActual);
/*  925 */     this.jDateChooser2.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  927 */     this.jRadioButton1.setSelected(true);
/*  928 */     this.jRadioButton1.setText("Completados");
/*  929 */     this.jRadioButton1.setToolTipText("Sólo se muestran los viajes que han sido concluidos.");
/*  930 */     this.jRadioButton1.setEnabled(false);
/*      */     
/*  932 */     this.jRadioButton2.setText("Expedidos");
/*  933 */     this.jRadioButton2.setToolTipText("Se muestran todos los viajes que han salido desde Tráfico");
/*  934 */     this.jRadioButton2.setEnabled(false);
/*      */     
/*  936 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  937 */     this.jPanel1.setLayout(jPanel1Layout);
/*  938 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  939 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  940 */         .addComponent(this.jLabel62, GroupLayout.Alignment.TRAILING, -1, 583, 32767)
/*  941 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  942 */           .addGap(10, 10, 10)
/*  943 */           .addComponent(this.jSeparator1, -1, 563, 32767)
/*  944 */           .addContainerGap())
/*  945 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  946 */           .addContainerGap()
/*  947 */           .addComponent(this.jLabel63, -2, 71, -2)
/*  948 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  949 */           .addComponent((Component)this.jDateChooser1, -2, 108, -2)
/*  950 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  951 */           .addComponent(this.jLabel64, -2, 19, -2)
/*  952 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  953 */           .addComponent((Component)this.jDateChooser2, -2, 108, -2)
/*  954 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  955 */           .addComponent(this.jLabel1, -2, 89, -2)
/*  956 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  957 */           .addComponent(this.jButton2)
/*  958 */           .addContainerGap(83, 32767))
/*  959 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  960 */           .addContainerGap()
/*  961 */           .addComponent(this.jSeparator2, -1, 563, 32767)
/*  962 */           .addContainerGap())
/*  963 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  964 */           .addContainerGap()
/*  965 */           .addComponent(this.jLabel65, -2, 97, -2)
/*  966 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  967 */           .addComponent(this.jComboBox1, -2, 131, -2)
/*  968 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  969 */           .addComponent(this.jButton1)
/*  970 */           .addGap(18, 18, 18)
/*  971 */           .addComponent(this.jRadioButton1, -2, 102, 32767)
/*  972 */           .addGap(18, 18, 18)
/*  973 */           .addComponent(this.jRadioButton2, -2, 110, -2)
/*  974 */           .addGap(32, 32, 32)));
/*      */     
/*  976 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  978 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  979 */           .addContainerGap()
/*  980 */           .addComponent(this.jLabel62)
/*  981 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  982 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  983 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  984 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  985 */             .addComponent(this.jButton2, -1, -1, 32767)
/*  986 */             .addComponent(this.jLabel64, -1, -1, 32767)
/*  987 */             .addComponent(this.jLabel63, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  988 */             .addComponent((Component)this.jDateChooser1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  989 */             .addComponent((Component)this.jDateChooser2, -1, -1, 32767)
/*  990 */             .addComponent(this.jLabel1, -2, 23, -2))
/*  991 */           .addGap(18, 18, 18)
/*  992 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  993 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  994 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  995 */             .addComponent(this.jLabel65)
/*  996 */             .addComponent(this.jComboBox1, -2, -1, -2)
/*  997 */             .addComponent(this.jButton1)
/*  998 */             .addComponent(this.jRadioButton1)
/*  999 */             .addComponent(this.jRadioButton2))
/* 1000 */           .addGap(257, 257, 257)));
/*      */ 
/*      */     
/* 1003 */     GroupLayout layout = new GroupLayout(this);
/* 1004 */     setLayout(layout);
/* 1005 */     layout.setHorizontalGroup(layout
/* 1006 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1007 */         .addGap(0, 607, 32767)
/* 1008 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1009 */           .addGroup(layout.createSequentialGroup()
/* 1010 */             .addGap(0, 10, 32767)
/* 1011 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 1012 */             .addGap(0, 10, 32767))));
/*      */     
/* 1014 */     layout.setVerticalGroup(layout
/* 1015 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1016 */         .addGap(0, 423, 32767)
/* 1017 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1018 */           .addGroup(layout.createSequentialGroup()
/* 1019 */             .addGap(0, 11, 32767)
/* 1020 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 1021 */             .addGap(0, 11, 32767))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/* 1026 */     if (this.jDateChooser1.getDate() == null) {
/* 1027 */       JOptionPane.showMessageDialog(this.padre, "La fecha de inicio no la puedes dejar vacía, por favor completa tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 1029 */     else if (this.jDateChooser2.getDate() == null) {
/* 1030 */       JOptionPane.showMessageDialog(this.padre, "La fecha de final no la puedes dejar vacía, por favor completa tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 1032 */     else if (this.jDateChooser1.getDate().after(this.jDateChooser2.getDate())) {
/* 1033 */       JOptionPane.showMessageDialog(this.padre, "La fecha de final debe ser mayor a la fecha de inicio\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1036 */       Date fecha1 = this.jDateChooser1.getDate();
/* 1037 */       Date fecha2 = this.jDateChooser2.getDate();
/*      */       
/* 1039 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1040 */       String cadenaFecha = "";
/* 1041 */       cadenaFecha = formato.format(fecha1);
/* 1042 */       String AÑO = cadenaFecha.substring(0, 4);
/* 1043 */       String MES = cadenaFecha.substring(4, 6);
/* 1044 */       String DIA = cadenaFecha.substring(6, 8);
/* 1045 */       this.FECHA1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1047 */       String año = "";
/* 1048 */       String mes = "";
/* 1049 */       String dia = "";
/*      */       
/* 1051 */       cadenaFecha = formato.format(fecha2);
/* 1052 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 1053 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 1054 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */       
/* 1056 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 1057 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1058 */       String strFecha = "";
/* 1059 */       if (diasTotal == dd) {
/* 1060 */         dd = 1;
/* 1061 */         if (mm == 11) {
/* 1062 */           aa++;
/* 1063 */           mm = 0;
/*      */         } else {
/*      */           
/* 1066 */           mm++;
/*      */         } 
/*      */       } else {
/* 1069 */         dd++;
/*      */       } 
/* 1071 */       año = "" + aa;
/* 1072 */       mes = "" + mm;
/* 1073 */       dia = "" + dd;
/* 1074 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1075 */       strFecha = dia + "-" + dia + "-" + mes;
/* 1076 */       this.FECHA2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 1078 */       this.jRadioButton1.setEnabled(true);
/* 1079 */       this.jRadioButton2.setEnabled(true);
/* 1080 */       this.jDateChooser1.setEnabled(false);
/* 1081 */       this.jDateChooser2.setEnabled(false);
/* 1082 */       this.jComboBox1.setEnabled(true);
/* 1083 */       this.jButton1.setEnabled(true);
/* 1084 */       this.jButton2.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1093 */     this.jDateChooser1.setEnabled(true);
/* 1094 */     this.jDateChooser2.setEnabled(true);
/* 1095 */     this.jComboBox1.setEnabled(false);
/* 1096 */     this.jButton1.setEnabled(false);
/* 1097 */     this.jButton2.setEnabled(false);
/* 1098 */     this.jRadioButton1.setEnabled(false);
/* 1099 */     this.jRadioButton2.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1103 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { "CARGANDO         COMPONENTES         ESPERE       ................." },  }, (Object[])new String[] { "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1111 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { " CALCULANDO     VIAJES    .........." },  }, (Object[])new String[] { "Totales" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1119 */     this.espe = new Esperando();
/* 1120 */     this.espe.start();
/*      */     
/* 1122 */     this.jFrame1.setTitle("REPORTE DE " + String.valueOf(this.jComboBox1.getSelectedItem()));
/* 1123 */     this.jLabel66.setText("REPORTE DE " + String.valueOf(this.jComboBox1.getSelectedItem()));
/*      */     
/* 1125 */     this.jLabel67.setText("Periodo del " + this.FECHA1 + " al " + this.FECHA2);
/* 1126 */     this.jLabel2.setVisible(true);
/*      */     
/* 1128 */     this.jButton4.setEnabled(false);
/* 1129 */     this.jFrame1.setExtendedState(6);
/* 1130 */     this.jFrame1.setVisible(true);
/* 1131 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 1135 */     if (evt.getClickCount() == 2) {
/* 1136 */       if (this.jLabel66.getText().equals("REPORTE DE OPERADORES")) {
/* 1137 */         verDatos1();
/*      */       }
/* 1139 */       else if (this.jLabel66.getText().equals("REPORTE DE CLIENTES")) {
/* 1140 */         verDatos2();
/*      */       } 
/*      */     }
/* 1143 */     this.jButton6.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 1147 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 1151 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 1155 */     this.jLabel37.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel38MouseClicked(MouseEvent evt) {
/* 1159 */     this.jLabel3.setVisible(false);
/* 1160 */     this.jDialog3.setVisible(false);
/*      */     
/* 1162 */     Esperando.yield();
/*      */   }
/*      */   
/*      */   private void jLabel38MouseEntered(MouseEvent evt) {
/* 1166 */     this.jLabel38.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseExited(MouseEvent evt) {
/* 1170 */     this.jLabel38.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jDialog3WindowClosing(WindowEvent evt) {
/* 1174 */     this.jLabel3.setVisible(false);
/* 1175 */     this.jDialog3.setVisible(false);
/*      */     
/* 1177 */     Esperando.yield();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jDialog4WindowClosing(WindowEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel44MouseClicked(MouseEvent evt) {
/* 1185 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel44MouseEntered(MouseEvent evt) {
/* 1189 */     this.jLabel44.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel44MouseExited(MouseEvent evt) {
/* 1193 */     this.jLabel44.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1197 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1201 */     if (this.jLabel66.getText().equals("REPORTE DE OPERADORES")) {
/* 1202 */       this.jRadioButton3.setText("Operadores");
/* 1203 */       this.jRadioButton4.setText("Clientes");
/* 1204 */       JOptionPane.showMessageDialog(this.jDialog2, this.jPanel4, "Tipo de Gráfica", 0, this.INFO);
/* 1205 */       if (this.jRadioButton3.isSelected()) {
/* 1206 */         int numVuelta = 0;
/* 1207 */         String[] claves = new String[5];
/* 1208 */         String[] nombres = new String[5];
/* 1209 */         String[] tipos = new String[5];
/* 1210 */         int[] totV = new int[5];
/* 1211 */         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/* 1212 */         String SITIO_1 = "VIAJES";
/* 1213 */         for (int i = 0; i < 5; i++) {
/* 1214 */           int max = 0;
/* 1215 */           String clave = "";
/* 1216 */           String nombre = "";
/* 1217 */           String tipo = "";
/* 1218 */           for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 1219 */             String num = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 1220 */             String cant = String.valueOf(this.jTable1.getValueAt(j, this.jTable1.getColumnCount() - 1));
/*      */             
/* 1222 */             if (!estaNum(num, claves)) {
/* 1223 */               String valor = String.valueOf(this.jTable1.getValueAt(j, this.jTable1.getColumnCount() - 1));
/* 1224 */               int comp = Integer.parseInt(valor);
/* 1225 */               if (comp > max) {
/* 1226 */                 max = comp;
/* 1227 */                 clave = num;
/* 1228 */                 nombre = String.valueOf(this.jTable1.getValueAt(j, 2));
/* 1229 */                 tipo = String.valueOf(this.jTable1.getValueAt(j, 3));
/*      */               } 
/*      */             } 
/*      */           } 
/* 1233 */           claves[i] = clave;
/* 1234 */           totV[i] = max;
/* 1235 */           nombres[i] = nombre;
/* 1236 */           tipos[i] = tipo;
/*      */         } 
/* 1238 */         dataset.setValue(totV[0], tipos[0] + " 1", nombres[0]);
/* 1239 */         dataset.setValue(totV[1], tipos[1] + " 2", nombres[1]);
/* 1240 */         dataset.setValue(totV[2], tipos[2] + " 3", nombres[2]);
/* 1241 */         dataset.setValue(totV[3], tipos[3] + " 4", nombres[3]);
/* 1242 */         dataset.setValue(totV[4], tipos[4] + " 5", nombres[4]);
/*      */         
/* 1244 */         JFreeChart chart = ChartFactory.createStackedBarChart3D("VIAJES", "Operadores", "Frecuencia de Viajes", (CategoryDataset)dataset, PlotOrientation.HORIZONTAL, true, true, true);
/* 1245 */         chart.fireChartChanged();
/* 1246 */         chart.setNotify(true);
/* 1247 */         chart.setAntiAlias(true);
/* 1248 */         chart.setBorderVisible(true);
/*      */         
/* 1250 */         chart.setTextAntiAlias(true);
/* 1251 */         ChartPanel panel = new ChartPanel(chart);
/* 1252 */         this.jDialog2 = new JDialog(this.jFrame1);
/* 1253 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1254 */         this.jDialog2.setTitle("Graficación de los Viajes");
/* 1255 */         this.jDialog2.setModal(true);
/*      */         
/* 1257 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1258 */         this.jDialog2.pack();
/* 1259 */         this.jDialog2.setVisible(true);
/*      */       } else {
/*      */         
/* 1262 */         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/* 1263 */         for (int i = 1; i < this.jTable3.getColumnCount() - 1; i++) {
/* 1264 */           String viaje = String.valueOf(this.jTable3.getValueAt(0, i));
/* 1265 */           dataset.setValue(Integer.parseInt(viaje), this.jTable3.getColumnName(i), this.jTable3.getColumnName(i));
/*      */         } 
/*      */         
/* 1268 */         JFreeChart chart = ChartFactory.createStackedBarChart3D("CLIENTES", "Clientes", "Total de Viajes", (CategoryDataset)dataset, PlotOrientation.VERTICAL, true, true, true);
/* 1269 */         chart.fireChartChanged();
/* 1270 */         chart.setNotify(true);
/* 1271 */         chart.setAntiAlias(true);
/* 1272 */         chart.setBorderVisible(true);
/*      */         
/* 1274 */         chart.setTextAntiAlias(true);
/*      */         
/* 1276 */         ChartPanel panel = new ChartPanel(chart);
/* 1277 */         this.jDialog2 = new JDialog(this.jFrame1);
/* 1278 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1279 */         this.jDialog2.setTitle("Graficación por Clientes");
/* 1280 */         this.jDialog2.setModal(true);
/*      */         
/* 1282 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1283 */         this.jDialog2.pack();
/* 1284 */         this.jDialog2.setVisible(true);
/*      */       }
/*      */     
/* 1287 */     } else if (this.jLabel66.getText().equals("REPORTE DE CLIENTES")) {
/* 1288 */       this.jRadioButton3.setText("Residuos");
/* 1289 */       this.jRadioButton4.setText("Clientes");
/* 1290 */       JOptionPane.showMessageDialog(this.jDialog2, this.jPanel4, "Tipo de Gráfica", 0, this.INFO);
/* 1291 */       if (this.jRadioButton3.isSelected()) {
/* 1292 */         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/* 1293 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1294 */           dataset.setValue(Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, this.jTable1.getColumnCount() - 1))), this.RESIDUOS[i], this.RESIDUOS[i]);
/*      */         }
/* 1296 */         JFreeChart chart = ChartFactory.createStackedBarChart3D("VIAJES", "RESIDUOS", "Cantidades", (CategoryDataset)dataset, PlotOrientation.VERTICAL, true, true, true);
/* 1297 */         chart.fireChartChanged();
/* 1298 */         chart.setNotify(true);
/* 1299 */         chart.setAntiAlias(true);
/* 1300 */         chart.setBorderVisible(true);
/*      */         
/* 1302 */         chart.setTextAntiAlias(true);
/* 1303 */         ChartPanel panel = new ChartPanel(chart);
/* 1304 */         this.jDialog2 = new JDialog(this.jFrame1);
/* 1305 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1306 */         this.jDialog2.setTitle("Graficación por Cliente");
/* 1307 */         this.jDialog2.setModal(true);
/*      */         
/* 1309 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1310 */         this.jDialog2.pack();
/* 1311 */         this.jDialog2.setVisible(true);
/*      */       } else {
/*      */         
/* 1314 */         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/* 1315 */         for (int i = 1; i < this.jTable3.getColumnCount() - 1; i++) {
/* 1316 */           String viaje = String.valueOf(this.jTable3.getValueAt(0, i));
/* 1317 */           dataset.setValue(Integer.parseInt(viaje), this.jTable3.getColumnName(i), this.jTable3.getColumnName(i));
/*      */         } 
/*      */         
/* 1320 */         JFreeChart chart = ChartFactory.createStackedBarChart3D("TOTAL DE PEDIDOS", "CLIENTES", "Cantidades", (CategoryDataset)dataset, PlotOrientation.VERTICAL, true, true, true);
/* 1321 */         chart.fireChartChanged();
/* 1322 */         chart.setNotify(true);
/* 1323 */         chart.setAntiAlias(true);
/* 1324 */         chart.setBorderVisible(true);
/*      */         
/* 1326 */         chart.setTextAntiAlias(true);
/*      */         
/* 1328 */         ChartPanel panel = new ChartPanel(chart);
/* 1329 */         this.jDialog2 = new JDialog(this.jFrame1);
/* 1330 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1331 */         this.jDialog2.setTitle("Graficación por Clientes");
/* 1332 */         this.jDialog2.setModal(true);
/*      */         
/* 1334 */         this.jDialog2.getContentPane().add((Component)panel);
/* 1335 */         this.jDialog2.pack();
/* 1336 */         this.jDialog2.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1342 */     if (this.jLabel66.getText().equals("REPORTE DE OPERADORES")) {
/* 1343 */       verDatos1();
/*      */     }
/* 1345 */     else if (this.jLabel66.getText().equals("REPORTE DE CLIENTES")) {
/* 1346 */       verDatos2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1351 */     String[] campos = new String[this.jTable1.getColumnCount()];
/* 1352 */     for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 1353 */       campos[i] = this.jTable1.getColumnName(i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1359 */     EscribirReporte esc = new EscribirReporte("ESTADÍSTICOS", this.jTable1, campos, this.USUARIO);
/*      */   }
/*      */ 
/*      */   
/*      */   public void verDatos1() {
/* 1364 */     this.COLUMNAINDICE = 2;
/* 1365 */     String clave = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 1366 */     if (clave.equals("")) {
/* 1367 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un operador para ver los detalles de sus viajes", "Selecciona un Operador", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1370 */       int indice = this.jTable1.getSelectedRow();
/* 1371 */       this.jLabel3.setText(String.valueOf(this.jTable1.getValueAt(indice, 2)));
/* 1372 */       this.jLabel5.setText(String.valueOf(this.jTable1.getValueAt(indice, 3)));
/*      */       
/* 1374 */       this.jLabel4.setText("Tipo");
/*      */       
/* 1376 */       this.encontrado = this.con.consultar("count(guias.num_guia)", "guias,llamadas_historicas,plataformas,emp_destinataria,emp_generadora", "where llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.num_guia = guias.num_guia and plataformas.num_plata = llamadas_historicas.num_plata and llamadas_historicas.clave_desti = emp_destinataria.clave_desti  and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and guias.estado='activa' and llamadas_historicas.num_ope = " + clave + this.viajes);
/* 1377 */       int tot = Integer.parseInt(this.con.Campo);
/* 1378 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 1379 */             .buscarReg(7, tot, "emp_generadora.empresa,guias.fecha,guias.num_guia,servicio,residuo,num_tracto,num_rem", "guias,llamadas_historicas,plataformas,emp_destinataria,emp_generadora", "where llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.num_guia = guias.num_guia and plataformas.num_plata = llamadas_historicas.num_plata and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.estado='activa' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and llamadas_historicas.num_ope = " + clave + this.viajes + " order by emp_generadora.empresa"), (Object[])new String[] { "Cliente", "Fecha", "Guía", "Servicio", "Residuo", "Tractor", "Rem" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 1384 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1388 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 1392 */       this.con.consultar("count(guias.num_guia)", "guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and num_vale = '' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and llamadas_historicas.num_ope = " + clave);
/* 1393 */       String[] arre = this.con.regresaCol("guias.num_guia", "guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and num_vale = '' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and llamadas_historicas.num_ope = " + clave, Integer.parseInt(this.con.Campo));
/* 1394 */       this.celda2.pasarInd(arre);
/*      */       
/* 1396 */       this.jTable2.getColumnModel().getColumn(1).setMinWidth(110);
/* 1397 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(110);
/* 1398 */       this.jTable2.getColumnModel().getColumn(2).setMinWidth(65);
/* 1399 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(65);
/*      */       
/* 1401 */       this.jTable2.getColumnModel().getColumn(5).setMinWidth(40);
/* 1402 */       this.jTable2.getColumnModel().getColumn(5).setMaxWidth(40);
/* 1403 */       this.jTable2.getColumnModel().getColumn(6).setMinWidth(40);
/* 1404 */       this.jTable2.getColumnModel().getColumn(6).setMaxWidth(40);
/*      */       
/* 1406 */       this.jTable2.setSelectionMode(0);
/* 1407 */       this.jTable2.setAutoCreateRowSorter(true);
/* 1408 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 1410 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 1411 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 1412 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 1413 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 1414 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 1415 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 1416 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/*      */       
/* 1418 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verDatos2() {
/* 1423 */     this.COLUMNAINDICE = 0;
/* 1424 */     String clave = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 1425 */     if (clave.equals("")) {
/* 1426 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un cliente para ver los detalles de sus viajes", "Selecciona un Clientes", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1429 */       int indice = this.jTable1.getSelectedRow();
/* 1430 */       this.jLabel3.setText("CONSULTAS POR RESIDUO");
/* 1431 */       this.jLabel5.setText(String.valueOf(this.jTable1.getValueAt(indice, 1)));
/* 1432 */       this.jLabel4.setText("Residuo");
/*      */       
/* 1434 */       this.encontrado = this.con.consultar("count(guias.num_guia)", "guias,llamadas_historicas,emp_generadora", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and residuo = '" + this.jLabel5.getText() + "' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and guias.estado='activa'" + this.viajes);
/* 1435 */       int tot = Integer.parseInt(this.con.Campo);
/* 1436 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 1437 */             .buscarReg(4, tot, "guias.num_guia,guias.fecha,nombre_corto,guias.servicio", "guias,llamadas_historicas,emp_generadora", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and residuo = '" + this.jLabel5.getText() + "' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and guias.estado='activa'" + this.viajes), (Object[])new String[] { "Guía", "Fecha", "Cliente", "Servicio" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 1442 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1446 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 1450 */       this.con.consultar("count(guias.num_guia)", "guias,llamadas_historicas,emp_generadora", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and residuo = '" + this.jLabel5.getText() + "' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and guias.estado='activa' and num_vale=''");
/* 1451 */       String[] arre = this.con.regresaCol("guias.num_guia", "guias,llamadas_historicas,emp_generadora", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and residuo = '" + this.jLabel5.getText() + "' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " and guias.estado='activa' and num_vale=''", Integer.parseInt(this.con.Campo));
/* 1452 */       this.celda2.pasarInd(arre);
/*      */       
/* 1454 */       this.jTable2.setSelectionMode(0);
/* 1455 */       this.jTable2.setAutoCreateRowSorter(true);
/* 1456 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 1458 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 1459 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 1460 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 1461 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 1462 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean estaNum(String num, String[] campos) {
/* 1467 */     for (int i = 0; i < campos.length; i++) {
/* 1468 */       if (num.equals(campos[i])) {
/* 1469 */         return true;
/*      */       }
/*      */     } 
/* 1472 */     return false;
/*      */   }
/*      */   
/*      */   public void estadis(String usu) {
/* 1476 */     this.USUARIO = usu;
/* 1477 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   class MyTableModel extends AbstractTableModel { public Object getValueAt(int row, int column) {
/* 1481 */       return "" + row * column;
/*      */     }
/*      */     public int getColumnCount() {
/* 1484 */       return 4;
/*      */     }
/*      */     public int getRowCount() {
/* 1487 */       return 5;
/*      */     } }
/*      */   
/*      */   public void consultar() {
/* 1491 */     if (this.jRadioButton1.isSelected()) {
/* 1492 */       this.viajes = " and guias.num_vale<>'' ";
/*      */     } else {
/*      */       
/* 1495 */       this.viajes = " ";
/*      */     } 
/* 1497 */     String etiqueta = "";
/*      */     
/* 1499 */     Date fecha1 = this.jDateChooser1.getDate();
/* 1500 */     Date fecha2 = this.jDateChooser2.getDate();
/* 1501 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1502 */     String cadenaFecha = "";
/* 1503 */     cadenaFecha = formato.format(fecha1);
/* 1504 */     String AÑO = cadenaFecha.substring(0, 4);
/* 1505 */     String MES = cadenaFecha.substring(4, 6);
/* 1506 */     String DIA = cadenaFecha.substring(6, 8);
/*      */     
/* 1508 */     etiqueta = "Perido del " + DIA + "/" + MES + "/" + AÑO;
/*      */     
/* 1510 */     cadenaFecha = formato.format(fecha2);
/* 1511 */     AÑO = cadenaFecha.substring(0, 4);
/* 1512 */     MES = cadenaFecha.substring(4, 6);
/* 1513 */     DIA = cadenaFecha.substring(6, 8);
/* 1514 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 1515 */       etiqueta = etiqueta + "  al  " + etiqueta + "/" + DIA + "/" + MES;
/* 1516 */       this.jLabel67.setText(etiqueta);
/* 1517 */       this.SIGUE = true;
/* 1518 */       this.con.consultar("count(distinct operadores.num_ope)", "operadores,llamadas_historicas,guias", "where guias.num_guia = llamadas_historicas.num_guia and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.num_ope <>0 and guias.estado='activa' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + this.viajes);
/*      */       
/* 1520 */       int totO = Integer.parseInt(this.con.Campo);
/* 1521 */       String[] clavesO = this.con.regresaCol("distinct operadores.num_ope", "operadores,llamadas_historicas,guias", "where guias.num_guia = llamadas_historicas.num_guia and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.num_ope <>0 and guias.estado='activa' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + this.viajes + " order by operadores.nombre", totO);
/* 1522 */       String[] nombre = new String[totO];
/* 1523 */       String[] ap_pat = new String[totO];
/* 1524 */       String[] ap_mat = new String[totO];
/* 1525 */       String[] tipos = new String[totO];
/* 1526 */       for (int i = 0; i < totO; i++) {
/* 1527 */         String[] aux = this.con.regresaReg("nombre,ap_pat,ap_mat,tipo", "operadores", "where num_ope = " + clavesO[i], 4);
/* 1528 */         nombre[i] = aux[0];
/* 1529 */         ap_pat[i] = aux[1];
/* 1530 */         ap_mat[i] = aux[2];
/* 1531 */         tipos[i] = aux[3];
/*      */       } 
/* 1533 */       this.con.consultar("count(clave_gene)", "emp_generadora", "where clave_gene<>0 and activo='Activado'");
/* 1534 */       int totC = Integer.parseInt(this.con.Campo);
/* 1535 */       String[] claveC = this.con.regresaCol("clave_gene", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by empresa", totC);
/* 1536 */       String[] Clientes = this.con.regresaCol("nombre_corto", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by empresa", totC);
/* 1537 */       String[] Clientes2 = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 and activo='Activado' order by empresa", totC);
/*      */       
/* 1539 */       DefaultTableModel modelo = new DefaultTableModel();
/* 1540 */       String[] columnas = new String[totC + 5];
/* 1541 */       modelo.addColumn("NÚM");
/* 1542 */       modelo.addColumn("CLAVE");
/* 1543 */       modelo.addColumn("OPERADOR");
/* 1544 */       modelo.addColumn("TIPO");
/*      */       
/* 1546 */       DefaultTableModel modelo2 = new DefaultTableModel();
/* 1547 */       modelo2.addColumn("TOTALES");
/*      */       
/* 1549 */       this.CLIENTESCOMP = new String[Clientes.length];
/* 1550 */       for (int j = 0; j < Clientes.length; j++) {
/* 1551 */         this.CLIENTESCOMP[j] = Clientes2[j];
/* 1552 */         if (Clientes[j].equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/* 1553 */           Clientes[j] = "SLB";
/*      */         }
/* 1555 */         else if (Clientes[j].equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/* 1556 */           Clientes[j] = "PMX";
/*      */         }
/* 1558 */         else if (Clientes[j].equals("QMAX SOLUCIONES AMBIENTALES S.A. DE C.V.")) {
/* 1559 */           Clientes[j] = "Q-MAX";
/*      */         }
/* 1561 */         else if (Clientes[j].equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/* 1562 */           Clientes[j] = "WTF";
/*      */         } 
/* 1564 */         modelo.addColumn(Clientes[j]);
/* 1565 */         modelo2.addColumn(Clientes[j]);
/*      */       } 
/* 1567 */       modelo2.addColumn("TOTAL");
/* 1568 */       modelo.addColumn("TOTAL");
/* 1569 */       modelo.setNumRows(totO);
/*      */       
/* 1571 */       modelo2.setNumRows(1);
/* 1572 */       this.jTable1.setModel(modelo);
/* 1573 */       this.jTable3.setModel(modelo2);
/*      */       
/* 1575 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/* 1576 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1577 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(50);
/* 1578 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
/* 1579 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(250);
/* 1580 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(250);
/* 1581 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(80);
/* 1582 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 1584 */       this.jTable1.getColumnModel().getColumn(totC + 4).setMinWidth(70);
/* 1585 */       this.jTable1.getColumnModel().getColumn(totC + 4).setMaxWidth(70);
/*      */       
/* 1587 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(420);
/* 1588 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(420);
/*      */       
/* 1590 */       String[] Columnas = new String[this.jTable1.getColumnCount()];
/* 1591 */       for (int k = 0; k < this.jTable1.getColumnCount(); k++) {
/* 1592 */         this.jTable1.getColumnModel().getColumn(k).setCellRenderer(this.celda);
/* 1593 */         Columnas[k] = this.jTable1.getColumnName(k);
/*      */       } 
/* 1595 */       this.jTable1.setAutoCreateRowSorter(true);
/* 1596 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 1597 */       int TOTALES = 0;
/* 1598 */       int mayor = 0;
/* 1599 */       int[] CLIENTES = new int[Clientes.length];
/* 1600 */       for (int m = 0; m < totO; m++) {
/* 1601 */         int total = 0;
/* 1602 */         this.jTable1.setValueAt(Integer.valueOf(m + 1), m, 0);
/* 1603 */         this.jTable1.setValueAt(clavesO[m], m, 1);
/* 1604 */         this.jTable1.setValueAt(nombre[m] + " " + nombre[m] + " " + ap_pat[m], m, 2);
/* 1605 */         this.jTable1.setValueAt(tipos[m], m, 3);
/* 1606 */         for (int i2 = 0; i2 < totC; i2++) {
/* 1607 */           this.con.consultar("count(guias.num_llama)", "guias,llamadas_historicas,operadores,emp_generadora", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.clave_gene = emp_generadora.clave_gene " + this.viajes + " and llamadas_historicas.num_ope = " + clavesO[m] + " and llamadas_historicas.clave_gene = " + claveC[i2] + " and guias.ESTADO = 'ACTIVA' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2);
/* 1608 */           this.jTable1.setValueAt(this.con.Campo, m, i2 + 4);
/* 1609 */           total += Integer.parseInt(this.con.Campo);
/* 1610 */           CLIENTES[i2] = CLIENTES[i2] + Integer.parseInt(this.con.Campo);
/* 1611 */           if (mayor < Integer.parseInt(this.con.Campo)) {
/* 1612 */             mayor = Integer.parseInt(this.con.Campo);
/*      */           }
/*      */         } 
/* 1615 */         this.jTable1.setValueAt(Integer.valueOf(total), m, totC + 4);
/* 1616 */         TOTALES += total;
/*      */       } 
/* 1618 */       String[][] registros = new String[modelo.getRowCount()][modelo.getColumnCount()]; int n;
/* 1619 */       for (n = 0; n < modelo.getRowCount(); n++) {
/* 1620 */         for (int i2 = 0; i2 < modelo.getColumnCount(); i2++) {
/* 1621 */           registros[n][i2] = String.valueOf(modelo.getValueAt(n, i2));
/*      */         }
/*      */       } 
/* 1624 */       this.jTable1.setModel(new DefaultTableModel((Object[][])registros, (Object[])Columnas)
/*      */           {
/*      */ 
/*      */             
/* 1628 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1632 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/* 1635 */       for (n = 0; n < Clientes.length; n++) {
/* 1636 */         this.jTable3.setValueAt(Integer.valueOf(CLIENTES[n]), 0, 1 + n);
/*      */       }
/* 1638 */       this.jTable3.setValueAt("-- TOTALES --", 0, 0);
/* 1639 */       this.jTable3.setValueAt(Integer.valueOf(TOTALES), 0, this.jTable3.getColumnCount() - 1);
/* 1640 */       this.jLabel14.setText("" + TOTALES);
/* 1641 */       Columnas = new String[this.jTable3.getColumnCount()];
/* 1642 */       for (n = 0; n < this.jTable3.getColumnCount(); n++) {
/* 1643 */         Columnas[n] = this.jTable3.getColumnName(n);
/*      */       }
/* 1645 */       registros = new String[modelo2.getRowCount()][modelo2.getColumnCount()];
/* 1646 */       for (n = 0; n < modelo2.getRowCount(); n++) {
/* 1647 */         for (int i2 = 0; i2 < modelo2.getColumnCount(); i2++) {
/* 1648 */           registros[n][i2] = String.valueOf(modelo2.getValueAt(n, i2));
/*      */         }
/*      */       } 
/* 1651 */       this.jTable3.setModel(new DefaultTableModel((Object[][])registros, (Object[])Columnas)
/*      */           {
/*      */ 
/*      */             
/* 1655 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1659 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/* 1662 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(420);
/* 1663 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(420);
/*      */       
/* 1665 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMinWidth(70);
/* 1666 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMaxWidth(70);
/*      */       
/* 1668 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/* 1669 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1670 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(50);
/* 1671 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
/* 1672 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(250);
/* 1673 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(250);
/* 1674 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(80);
/* 1675 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 1677 */       this.jTable1.getColumnModel().getColumn(totC + 4).setMinWidth(70);
/* 1678 */       this.jTable1.getColumnModel().getColumn(totC + 4).setMaxWidth(70);
/*      */       
/* 1680 */       for (n = 0; n < this.jTable1.getColumnCount(); n++) {
/* 1681 */         this.jTable1.getColumnModel().getColumn(n).setCellRenderer(this.celda);
/*      */       }
/* 1683 */       this.jTable1.setAutoCreateRowSorter(true);
/* 1684 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 1685 */       String[] COLUMNAS = { "Núm", "Cliente", "Total" };
/* 1686 */       String[][] Datos = new String[this.jTable3.getColumnCount() - 2][3];
/* 1687 */       for (int i1 = 0; i1 < this.jTable3.getColumnCount() - 2; i1++) {
/* 1688 */         Datos[i1][0] = "" + i1 + 1;
/* 1689 */         Datos[i1][1] = this.CLIENTESCOMP[i1];
/* 1690 */         Datos[i1][2] = String.valueOf(this.jTable3.getValueAt(0, i1 + 1));
/*      */       } 
/* 1692 */       this.jTable6.setModel(new DefaultTableModel((Object[][])Datos, (Object[])COLUMNAS)
/*      */           {
/*      */ 
/*      */             
/* 1696 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1700 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/* 1703 */       this.jTable6.getColumnModel().getColumn(0).setMinWidth(40);
/* 1704 */       this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */       
/* 1706 */       this.jTable6.getColumnModel().getColumn(2).setMinWidth(80);
/* 1707 */       this.jTable6.getColumnModel().getColumn(2).setMaxWidth(80);
/*      */       
/* 1709 */       this.jDialog3.setVisible(false);
/* 1710 */       this.jDialog4.setVisible(true);
/* 1711 */       this.jLabel2.setVisible(false);
/* 1712 */       this.jButton4.setEnabled(true);
/* 1713 */       this.jButton5.setEnabled(true);
/*      */     } else {
/*      */       
/* 1716 */       etiqueta = etiqueta + "  al  " + etiqueta + "/" + DIA + "/" + MES;
/* 1717 */       this.jLabel67.setText(etiqueta);
/* 1718 */       this.SIGUE = true;
/*      */       
/* 1720 */       this.con.consultar("count(distinct(residuo))", "llamadas_historicas,guias", "where llamadas_historicas.num_guia=guias.num_guia and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2);
/* 1721 */       int totC = Integer.parseInt(this.con.Campo);
/* 1722 */       this.RESIDUOS = this.con.regresaCol("distinct(residuo)", "llamadas_historicas,guias", "where llamadas_historicas.num_guia=guias.num_guia and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + " order by residuo", totC);
/*      */       
/* 1724 */       this.con.consultar("count(distinct(emp_generadora.clave_gene))", "emp_generadora,llamadas_historicas,guias", "where llamadas_historicas.clave_gene=emp_generadora.clave_gene and llamadas_historicas.num_guia=guias.num_guia and guias.fecha and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + "order by empresa");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1730 */       String[] claveC = this.con.regresaCol("distinct(emp_generadora.clave_gene)", "emp_generadora,llamadas_historicas,guias", "where llamadas_historicas.clave_gene=emp_generadora.clave_gene and llamadas_historicas.num_guia=guias.num_guia and guias.fecha and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + "order by empresa", Integer.parseInt(this.con.Campo));
/* 1731 */       String[] NOMBRECORTO = this.con.regresaCol("distinct(nombre_corto)", "emp_generadora,llamadas_historicas,guias", "where llamadas_historicas.clave_gene=emp_generadora.clave_gene and llamadas_historicas.num_guia=guias.num_guia and guias.fecha and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + "order by empresa", Integer.parseInt(this.con.Campo));
/* 1732 */       String[] Clientes2 = this.con.regresaCol("distinct(empresa)", "emp_generadora,llamadas_historicas,guias", "where llamadas_historicas.clave_gene=emp_generadora.clave_gene and llamadas_historicas.num_guia=guias.num_guia and guias.fecha and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + "order by empresa", Integer.parseInt(this.con.Campo));
/*      */       
/* 1734 */       DefaultTableModel modelo = new DefaultTableModel();
/* 1735 */       String[] columnas = new String[this.RESIDUOS.length + 5];
/* 1736 */       modelo.addColumn("NÚM");
/*      */ 
/*      */       
/* 1739 */       modelo.addColumn("RESIDUO");
/*      */       
/* 1741 */       DefaultTableModel modelo2 = new DefaultTableModel();
/* 1742 */       modelo2.addColumn("TOTALES");
/* 1743 */       this.CLIENTESCOMP = new String[Clientes2.length]; int i;
/* 1744 */       for (i = 0; i < NOMBRECORTO.length; i++) {
/* 1745 */         modelo.addColumn(NOMBRECORTO[i]);
/* 1746 */         modelo2.addColumn(NOMBRECORTO[i]);
/*      */       } 
/* 1748 */       modelo2.addColumn("TOTAL");
/* 1749 */       modelo.addColumn("TOTAL");
/* 1750 */       modelo.setNumRows(totC);
/*      */       
/* 1752 */       modelo2.setNumRows(1);
/* 1753 */       this.jTable1.setModel(modelo);
/* 1754 */       this.jTable3.setModel(modelo2);
/*      */       
/* 1756 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/* 1757 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1758 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(180);
/* 1759 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(180);
/* 1760 */       this.jTable1.getColumnModel().getColumn(NOMBRECORTO.length + 2).setMinWidth(60);
/* 1761 */       this.jTable1.getColumnModel().getColumn(NOMBRECORTO.length + 2).setMaxWidth(60);
/*      */       
/* 1763 */       for (i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 1764 */         this.jTable1.getColumnModel().getColumn(i).setCellRenderer(this.celda);
/*      */       }
/* 1766 */       int[] RESITOTAL = new int[this.RESIDUOS.length];
/* 1767 */       int TOTALES = 0; int j;
/* 1768 */       for (j = 0; j < totC; j++) {
/* 1769 */         int total = 0;
/* 1770 */         this.jTable1.setValueAt(Integer.valueOf(j + 1), j, 0);
/* 1771 */         this.jTable1.setValueAt(this.RESIDUOS[j], j, 1);
/*      */         
/* 1773 */         for (int i1 = 0; i1 < NOMBRECORTO.length; i1++) {
/* 1774 */           this.con.consultar("count(guias.num_llama)", "llamadas_historicas,guias", "where llamadas_historicas.num_guia = guias.num_guia and clave_gene = " + claveC[i1] + " and residuo='" + this.RESIDUOS[j] + "' and guias.ESTADO = 'ACTIVA' and guias.fecha between " + this.FECHA1 + " and " + this.FECHA2 + this.viajes);
/* 1775 */           this.jTable1.setValueAt(this.con.Campo, j, i1 + 2);
/* 1776 */           total += Integer.parseInt(this.con.Campo);
/* 1777 */           RESITOTAL[i1] = RESITOTAL[i1] + Integer.parseInt(this.con.Campo);
/*      */         } 
/* 1779 */         this.jTable1.setValueAt(Integer.valueOf(total), j, NOMBRECORTO.length + 2);
/* 1780 */         TOTALES += total;
/*      */       } 
/*      */       
/* 1783 */       for (j = 0; j < NOMBRECORTO.length; j++) {
/* 1784 */         this.jTable3.setValueAt(Integer.valueOf(RESITOTAL[j]), 0, 1 + j);
/*      */       }
/* 1786 */       this.jTable3.setValueAt("-- TOTALES --", 0, 0);
/* 1787 */       this.jTable3.setValueAt(Integer.valueOf(TOTALES), 0, this.jTable3.getColumnCount() - 1);
/* 1788 */       this.jLabel14.setText("" + TOTALES);
/*      */       
/* 1790 */       String[] Columnas = new String[this.jTable1.getColumnCount()];
/* 1791 */       for (int k = 0; k < this.jTable1.getColumnCount(); k++) {
/* 1792 */         this.jTable1.getColumnModel().getColumn(k).setCellRenderer(this.celda);
/* 1793 */         Columnas[k] = this.jTable1.getColumnName(k);
/*      */       } 
/*      */       
/* 1796 */       String[][] registros = new String[modelo.getRowCount()][modelo.getColumnCount()]; int m;
/* 1797 */       for (m = 0; m < modelo.getRowCount(); m++) {
/* 1798 */         for (int i1 = 0; i1 < modelo.getColumnCount(); i1++) {
/* 1799 */           registros[m][i1] = String.valueOf(modelo.getValueAt(m, i1));
/*      */         }
/*      */       } 
/* 1802 */       this.jTable1.setModel(new DefaultTableModel((Object[][])registros, (Object[])Columnas)
/*      */           {
/*      */ 
/*      */             
/* 1806 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1810 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/*      */       
/* 1814 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(220);
/* 1815 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(220);
/* 1816 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMinWidth(60);
/* 1817 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMaxWidth(60);
/*      */       
/* 1819 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/* 1820 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1821 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(180);
/* 1822 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(180);
/*      */       
/* 1824 */       this.jTable1.getColumnModel().getColumn(NOMBRECORTO.length + 2).setMinWidth(60);
/* 1825 */       this.jTable1.getColumnModel().getColumn(NOMBRECORTO.length + 2).setMaxWidth(60);
/*      */       
/* 1827 */       for (m = 0; m < this.jTable1.getColumnCount(); m++) {
/* 1828 */         this.jTable1.getColumnModel().getColumn(m).setCellRenderer(this.celda);
/*      */       }
/* 1830 */       this.jTable1.setAutoCreateRowSorter(true);
/* 1831 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 1833 */       String[] COLUMNAS = { "Núm", "Clientes", "Total" };
/* 1834 */       String[][] Datos = new String[this.jTable3.getColumnCount() - 2][3]; int n;
/* 1835 */       for (n = 0; n < this.jTable3.getColumnCount() - 2; n++) {
/* 1836 */         Datos[n][0] = "" + n + 1;
/* 1837 */         Datos[n][1] = Clientes2[n];
/* 1838 */         Datos[n][2] = String.valueOf(this.jTable3.getValueAt(0, n + 1));
/*      */       } 
/* 1840 */       this.jTable6.setModel(new DefaultTableModel((Object[][])Datos, (Object[])COLUMNAS)
/*      */           {
/*      */ 
/*      */             
/* 1844 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1848 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/*      */       
/* 1852 */       Columnas = new String[this.jTable3.getColumnCount()];
/* 1853 */       for (n = 0; n < this.jTable3.getColumnCount(); n++) {
/* 1854 */         Columnas[n] = this.jTable3.getColumnName(n);
/*      */       }
/* 1856 */       registros = new String[modelo2.getRowCount()][modelo2.getColumnCount()];
/* 1857 */       for (n = 0; n < modelo2.getRowCount(); n++) {
/* 1858 */         for (int i1 = 0; i1 < modelo2.getColumnCount(); i1++) {
/* 1859 */           registros[n][i1] = String.valueOf(modelo2.getValueAt(n, i1));
/*      */         }
/*      */       } 
/* 1862 */       this.jTable3.setModel(new DefaultTableModel((Object[][])registros, (Object[])Columnas)
/*      */           {
/*      */ 
/*      */             
/* 1866 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/* 1870 */                 false, false, false, false, false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */           
/*      */           });
/* 1873 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(220);
/* 1874 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(220);
/*      */       
/* 1876 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMinWidth(70);
/* 1877 */       this.jTable3.getColumnModel().getColumn(this.jTable3.getColumnCount() - 1).setMaxWidth(70);
/*      */ 
/*      */       
/* 1880 */       this.jTable6.getColumnModel().getColumn(0).setMinWidth(40);
/* 1881 */       this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */       
/* 1883 */       this.jTable6.getColumnModel().getColumn(2).setMinWidth(80);
/* 1884 */       this.jTable6.getColumnModel().getColumn(2).setMaxWidth(80);
/*      */       
/* 1886 */       this.jLabel2.setVisible(false);
/* 1887 */       this.jDialog3.setVisible(false);
/* 1888 */       this.jDialog4.setVisible(true);
/* 1889 */       this.jLabel2.setVisible(false);
/* 1890 */       this.jButton4.setEnabled(true);
/* 1891 */       this.jButton5.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   class ColoredTableCellRenderer extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1897 */       setEnabled((table == null || table.isEnabled()));
/* 1898 */       if (row % 2 == 0) {
/* 1899 */         setBackground(Color.green);
/*      */       } else {
/* 1901 */         setBackground((Color)null);
/* 1902 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1903 */       return this;
/*      */     } }
/*      */   
/*      */   class Esperando extends Thread {
/*      */     public void run() {
/* 1908 */       Estadisticos.this.consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   class CeldaRender extends DefaultTableCellRenderer {
/* 1913 */     int otro = -1;
/* 1914 */     int[] indices = new int[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1916 */       setEnabled((table == null || table.isEnabled()));
/* 1917 */       if (comparar(row)) {
/* 1918 */         setBackground(Color.red);
/*      */       }
/* 1920 */       else if (row % 2 == 0) {
/* 1921 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/* 1923 */         setBackground((Color)null);
/* 1924 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1925 */       return this;
/*      */     }
/*      */     public void pasarInd(int[] ind) {
/* 1928 */       this.indices = ind;
/*      */     }
/*      */     public boolean comparar(int reg) {
/* 1931 */       for (int i = 0; i < this.indices.length; i++) {
/* 1932 */         if (this.indices[i] == reg) {
/* 1933 */           return true;
/*      */         }
/*      */       } 
/* 1936 */       return false;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 1941 */       this.otro = -1;
/* 1942 */       this.indices = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1944 */       setEnabled((table == null || table.isEnabled()));
/* 1945 */       String comp = String.valueOf(table.getValueAt(row, Estadisticos.this.COLUMNAINDICE));
/* 1946 */       if (comparar(comp)) {
/* 1947 */         setBackground(new Color(102, 153, 255));
/*      */       } else {
/*      */         
/* 1950 */         setBackground(new Color(194, 213, 151));
/* 1951 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1952 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 1955 */       this.indices = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 1958 */       for (int i = 0; i < this.indices.length; i++) {
/* 1959 */         if (this.indices[i].equals(reg)) {
/* 1960 */           return true;
/*      */         }
/*      */       } 
/* 1963 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 1968 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1970 */             Estadisticos.this.jTextGanado(Estadisticos.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1973 */             Estadisticos.this.jTextPerdido(Estadisticos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1978 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1981 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 1984 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1992 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1998 */         return 30;
/*      */       
/*      */       case 1:
/* 2001 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 2003 */           return 29;
/*      */         }
/* 2005 */         return 28;
/*      */     } 
/*      */     
/* 2008 */     return 0;
/*      */   }
/*      */   
/*      */   class EscribirEstadis {
/* 2012 */     Calendar calendario = Calendar.getInstance(); int hora; int minutos;
/*      */     int segundos;
/* 2014 */     String archivo = "";
/*      */     
/*      */     public EscribirEstadis(String Titulo, JTable tabla, String[] Campitos) {
/* 2017 */       this.archivo = direccion();
/* 2018 */       this.hora = this.calendario.get(11);
/* 2019 */       this.minutos = this.calendario.get(12);
/* 2020 */       this.segundos = this.calendario.get(13);
/* 2021 */       if (!this.archivo.equals("no")) {
/* 2022 */         String cadenaFecha = "";
/* 2023 */         SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
/* 2024 */         Date fecha = new Date();
/* 2025 */         cadenaFecha = formato.format(fecha);
/* 2026 */         String[] nombre = Estadisticos.this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + Estadisticos.this.USUARIO + "'", 3);
/* 2027 */         FileOutputStream fos = null;
/* 2028 */         PrintWriter pw = null;
/* 2029 */         File f = new File(this.archivo + ".xls");
/*      */         try {
/* 2031 */           Workbook libro1 = Workbook.getWorkbook(new File("Formatos/FormatoEstadis.xls"));
/* 2032 */           WritableWorkbook copy = Workbook.createWorkbook(f, libro1);
/* 2033 */           WritableSheet hoja2 = copy.getSheet(0);
/*      */           
/* 2035 */           WritableFont fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 12);
/* 2036 */           fuente.setColour(Colour.RED);
/* 2037 */           fuente.setBoldStyle(WritableFont.BOLD);
/* 2038 */           WritableCellFormat forma = new WritableCellFormat(fuente);
/*      */           
/* 2040 */           Label label = new Label(4, 1, "REPORTE DE " + Titulo);
/* 2041 */           forma.setAlignment(Alignment.CENTRE);
/* 2042 */           label.setCellFormat((CellFormat)forma);
/* 2043 */           hoja2.addCell((WritableCell)label);
/* 2044 */           int numR = Integer.parseInt(Estadisticos.this.con.Campo);
/* 2045 */           numR++;
/* 2046 */           fuente = new WritableFont(WritableFont.createFont("Aquaduct"), 8);
/* 2047 */           fuente.setColour(Colour.RED);
/* 2048 */           fuente.setBoldStyle(WritableFont.NO_BOLD);
/* 2049 */           forma = new WritableCellFormat(fuente);
/* 2050 */           Estadisticos.this.con.inserSinMsj("insert into reportes(num)values(" + numR + ")");
/* 2051 */           label = new Label(2, 2, nombre[0] + " " + nombre[0] + " " + nombre[1]);
/* 2052 */           forma.setAlignment(Alignment.CENTRE);
/* 2053 */           label.setCellFormat((CellFormat)forma);
/* 2054 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 2056 */           label = new Label(9, 2, cadenaFecha);
/* 2057 */           label.setCellFormat((CellFormat)forma);
/* 2058 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 2060 */           label = new Label(6, 2, "" + numR);
/* 2061 */           label.setCellFormat((CellFormat)forma);
/* 2062 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 2064 */           label = new Label(2, 4, "" + tabla.getRowCount());
/* 2065 */           label.setCellFormat((CellFormat)forma);
/* 2066 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 2068 */           fuente = new WritableFont(WritableFont.ARIAL, 7);
/* 2069 */           fuente.setColour(Colour.WHITE);
/* 2070 */           fuente.setBoldStyle(WritableFont.BOLD);
/*      */           
/* 2072 */           forma = new WritableCellFormat(fuente);
/* 2073 */           forma.setBackground(Colour.GREEN);
/* 2074 */           forma.setBorder(Border.ALL, BorderLineStyle.THIN);
/*      */           
/* 2076 */           label = new Label(0, 7, "NÚM");
/* 2077 */           forma.setAlignment(Alignment.CENTRE);
/* 2078 */           label.setCellFormat((CellFormat)forma);
/* 2079 */           hoja2.addCell((WritableCell)label);
/*      */           
/* 2081 */           for (int r = 0; r < Campitos.length; r++) {
/* 2082 */             label = new Label(r + 1, 7, Campitos[r]);
/* 2083 */             label.setCellFormat((CellFormat)forma);
/* 2084 */             hoja2.addCell((WritableCell)label);
/*      */           } 
/*      */           
/* 2087 */           int cont = 8;
/* 2088 */           fuente = new WritableFont(WritableFont.ARIAL, 6);
/* 2089 */           fuente.setColour(Colour.BLACK);
/* 2090 */           int num = 1;
/* 2091 */           int valorN = -1;
/* 2092 */           for (int i = 0; i < tabla.getRowCount(); i++) {
/* 2093 */             Colour[] colores = Colour.getAllColours();
/* 2094 */             forma = new WritableCellFormat(fuente);
/* 2095 */             forma.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
/* 2096 */             num++;
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
/* 2108 */             for (int c = -1; c < tabla.getColumnCount(); c++) {
/* 2109 */               if (c == -1) {
/* 2110 */                 Number number = new Number(c + 1, cont, (cont - 7));
/* 2111 */                 number.setCellFormat((CellFormat)forma);
/* 2112 */                 hoja2.addCell((WritableCell)number);
/*      */               } else {
/*      */                 
/*      */                 try {
/* 2116 */                   DecimalFormat formatoN = new DecimalFormat("000.00");
/* 2117 */                   formatoN.setMaximumFractionDigits(2);
/* 2118 */                   float valor = Float.parseFloat(String.valueOf(tabla.getValueAt(i, c)));
/* 2119 */                   formatoN.format(valor);
/* 2120 */                   Number number = new Number(c + 1, cont, Integer.parseInt(formatoN.format(valor)));
/* 2121 */                   number.setCellFormat((CellFormat)forma);
/* 2122 */                   hoja2.addCell((WritableCell)number);
/*      */                 }
/* 2124 */                 catch (NumberFormatException e) {
/* 2125 */                   String le = String.valueOf(tabla.getValueAt(i, c));
/* 2126 */                   if (le.equals("null")) {
/* 2127 */                     tabla.setValueAt("", i, c);
/* 2128 */                     label = new Label(c + 1, cont, String.valueOf(tabla.getValueAt(i, c)));
/*      */                   }
/* 2130 */                   else if (le.equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/* 2131 */                     label = new Label(c + 1, cont, "WTF");
/*      */                   }
/* 2133 */                   else if (le.equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/* 2134 */                     label = new Label(c + 1, cont, "SLB");
/*      */                   }
/* 2136 */                   else if (le.equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/* 2137 */                     label = new Label(c + 1, cont, "PMX");
/*      */                   }
/* 2139 */                   else if (le.equals("ADT PETROSERVICIOS S.A. DE C.V.")) {
/* 2140 */                     label = new Label(c + 1, cont, "ADT");
/*      */                   }
/* 2142 */                   else if (le.equals("CLEANMEX S.A. DE C.V.")) {
/* 2143 */                     label = new Label(c + 1, cont, "CLEANMEX");
/*      */                   }
/* 2145 */                   else if (le.equals("QMAX SOLUCIONES AMBIENTALES S.A. DE C.V.")) {
/* 2146 */                     label = new Label(c + 1, cont, "Q-MAX");
/*      */                   }
/* 2148 */                   else if (le.equals("RECORTE BASE AGUA")) {
/* 2149 */                     label = new Label(c + 1, cont, "R. BASE AGUA");
/*      */                   }
/* 2151 */                   else if (le.equals("RECORTE BASE ACEITE")) {
/* 2152 */                     label = new Label(c + 1, cont, "R. BASE ACEITE");
/*      */                   }
/* 2154 */                   else if (le.equals("LODO BASE AGUA")) {
/* 2155 */                     label = new Label(c + 1, cont, "L. BASE AGUA");
/*      */                   }
/* 2157 */                   else if (le.equals("AGUA RESIDUAL")) {
/* 2158 */                     label = new Label(c + 1, cont, "A. RESIDUAL");
/*      */                   }
/* 2160 */                   else if (le.equals("AGUA RESIDUAL")) {
/* 2161 */                     label = new Label(c + 1, cont, "A. RESIDUAL");
/*      */                   }
/* 2163 */                   else if (le.equals("AGUA DE FRACTURA")) {
/* 2164 */                     label = new Label(c + 1, cont, "A. DE FRAC.");
/*      */                   }
/* 2166 */                   else if (le.equals("ECOLTEC S.A. DE C.V. (PLANTA ORIZABA)")) {
/* 2167 */                     label = new Label(c + 1, cont, "ECOLTEC-ORIZABA");
/*      */                   }
/* 2169 */                   else if (le.equals("ECOLTEC S.A. DE C.V. (PLANTA MACUSPANA)")) {
/* 2170 */                     label = new Label(c + 1, cont, "ECOLTEC-MACUSPANA");
/*      */                   }
/* 2172 */                   else if (le.equals("ECOLTEC (PLANTA RAMOS ARIZPE)")) {
/* 2173 */                     label = new Label(c + 1, cont, "ECOLTEC-RAMOS ARIZPE");
/*      */                   }
/* 2175 */                   else if (le.equals("CEMEX MÉXICO S.A DE C.V (PLANTA TEPEACA)")) {
/* 2176 */                     label = new Label(c + 1, cont, "CEMEX-TEPEACA");
/*      */                   }
/* 2178 */                   else if (le.equals("CEMEX MÉXICO (PLANTA TAMUÍN)")) {
/* 2179 */                     label = new Label(c + 1, cont, "CEMEX-TAMUÍN");
/*      */                   }
/* 2181 */                   else if (le.equals("WEATHERFORD")) {
/* 2182 */                     label = new Label(c + 1, cont, "WTF");
/*      */                   } else {
/*      */                     
/* 2185 */                     label = new Label(c + 1, cont, String.valueOf(tabla.getValueAt(i, c)));
/*      */                   } 
/* 2187 */                   label.setCellFormat((CellFormat)forma);
/* 2188 */                   hoja2.addCell((WritableCell)label);
/*      */                 } 
/*      */               } 
/*      */             } 
/* 2192 */             cont++;
/*      */           } 
/* 2194 */           copy.write();
/* 2195 */           copy.close();
/* 2196 */           JOptionPane.showMessageDialog(null, "<HTML>El reporte se creó satisfactoriamente en la siguiente dirección<HR><B>" + f.getAbsolutePath() + "</B></HTML>", "Reporte Creado", 0, Estadisticos.this.INFO);
/*      */         }
/* 2198 */         catch (Exception i) {
/* 2199 */           JOptionPane.showMessageDialog(null, "El archivo no se pudo crear por la siguiente razón:\n" + i.getMessage());
/*      */         } 
/*      */       } 
/*      */     }
/*      */     public String direccion() {
/* 2204 */       JFileChooser fileChooser = new JFileChooser();
/* 2205 */       String fileName = "";
/* 2206 */       int retVal = fileChooser.showSaveDialog(null);
/* 2207 */       if (retVal == 0) {
/* 2208 */         fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 2209 */         return fileName;
/*      */       } 
/* 2211 */       return "no";
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Estadisticos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */