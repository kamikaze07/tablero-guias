/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterException;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Vector;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class Aguinaldos extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   44 */   Date fechaActual = new Date();
/*   45 */   Date fechaInicio = null;
/*   46 */   Date fecha = new Date();
/*   47 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   48 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   49 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   50 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   51 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   52 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   53 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   54 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   55 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   56 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   57 */   JFrame padre = null;
/*   58 */   JTabbedPane fichas = null;
/*   59 */   String[] CLAVES = null;
/*   60 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   62 */   DefaultTableModel modelo = new DefaultTableModel();
/*   63 */   CeldaRender celda = new CeldaRender();
/*   64 */   CeldaRender2 celda2 = new CeldaRender2();
/*   65 */   String[] CLAVESOP = null;
/*   66 */   String[] CLAVESEM = null;
/*   67 */   String[] NOMBRESOP = null;
/*   68 */   String[] NOMBRESEM = null;
/*   69 */   String[] DATOS = null;
/*      */   boolean ACTIVO = false;
/*   71 */   double TOTAL1 = 0.0D;
/*   72 */   double TOTAL2 = 0.0D;
/*   73 */   String DIASXLEY = "";
/*   74 */   NumerosALetras numLetra = null;
/*   75 */   int DIAS = 0;
/*   76 */   String DIRECTIVA = "";
/*   77 */   String CLAVE = "";
/*   78 */   String SUCURSAL = "";
/*   79 */   String[] CONFIG = null;
/*      */   EscribirReporte esc;
/*   81 */   double DIASDERECHO = 0.0D;
/*   82 */   String[] IMSS = null;
/*   83 */   String[] CURP = null;
/*   84 */   int INDICE = 0;
/*   85 */   String SUC = ""; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton2; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JCheckBox jCheckBox1; private JCheckBox jCheckBox2; private JCheckBox jCheckBox3; private JCheckBox jCheckBox4; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JDateChooser jDateChooser10; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JFrame jFrame1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel20;
/*      */   
/*      */   public Aguinaldos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   88 */     String año = "2010";
/*   89 */     String mes = "10";
/*   90 */     String dia = "10";
/*   91 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   92 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   94 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   95 */     } catch (ParseException ex) {
/*   96 */       ex.printStackTrace();
/*      */     } 
/*   98 */     this.padre = padre;
/*   99 */     fichas = fichas;
/*  100 */     initComponents();
/*  101 */     this.USUARIO = USUARIO;
/*  102 */     panelito.setViewportView(this);
/*  103 */     this.panel = panelito;
/*      */     
/*  105 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  106 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  107 */     editFormat.setGroupingUsed(false);
/*  108 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  109 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  110 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  111 */     enFormat.setAllowsInvalid(true);
/*  112 */     this.cantidad.setFormatterFactory(currFactory);
/*  113 */     this.cantidad.setValue(Integer.valueOf(0));
/*      */     
/*  115 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  116 */     Cursor micursor2 = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  117 */     this.jFrame1.setCursor(micursor2);
/*  118 */     this.jDialog1.setCursor(micursor2);
/*  119 */     this.jDialog2.setCursor(micursor2);
/*  120 */     this.jDialog3.setCursor(micursor2);
/*      */     
/*  122 */     int w = this.tama.width;
/*  123 */     int h = this.tama.height;
/*  124 */     int rw = (w - 920) / 2;
/*  125 */     int rh = (h - 630) / 2;
/*  126 */     this.jFrame1.setLocation(rw, rh);
/*  127 */     this.jFrame1.setSize(920, 630);
/*  128 */     this.jFrame1.setVisible(false);
/*  129 */     this.jFrame1.setExtendedState(6);
/*      */     
/*  131 */     rw = (w - 933) / 2;
/*  132 */     rh = (h - 480) / 2;
/*  133 */     this.jDialog1.setLocation(rw, rh);
/*  134 */     this.jDialog1.setSize(933, 480);
/*  135 */     this.jDialog1.setResizable(false);
/*  136 */     this.jDialog1.setVisible(false);
/*      */     
/*  138 */     rw = (w - 305) / 2;
/*  139 */     rh = (h - 255) / 2;
/*  140 */     this.jDialog2.setLocation(rw, rh);
/*  141 */     this.jDialog2.setSize(305, 255);
/*  142 */     this.jDialog2.setResizable(false);
/*  143 */     this.jDialog2.setVisible(false);
/*      */     
/*  145 */     rw = (w - 390) / 2;
/*  146 */     rh = (h - 230) / 2;
/*  147 */     this.jDialog3.setLocation(rw, rh);
/*  148 */     this.jDialog3.setSize(390, 230);
/*  149 */     this.jDialog3.setVisible(false);
/*  150 */     this.jDialog3.setResizable(false);
/*      */     
/*  152 */     this.buttonGroup1.add(this.jRadioButton1);
/*  153 */     this.buttonGroup1.add(this.jRadioButton2);
/*  154 */     colorear();
/*  155 */     llenarCombos();
/*  156 */     calcularAnual();
/*  157 */     this.jComboBox4.setEnabled(false);
/*  158 */     consultarAguinaldos();
/*      */     
/*  160 */     this.con.consultar("directiva", "configuraciones", "");
/*  161 */     this.DIRECTIVA = this.con.Campo;
/*      */     
/*  163 */     this.con.consultar("sucursal", "configuraciones", "");
/*  164 */     this.SUCURSAL = this.con.Campo;
/*      */     
/*  166 */     this.jButton22.setVisible(false);
/*      */   }
/*      */   private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel3; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel54; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel17; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel36; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane6; private JSeparator jSeparator10; private JSeparator jSeparator29; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTabbedPane jTabbedPane1; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable6; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField6; private JTextField jTextField9;
/*      */   public void Aguinaldos(String usu) {
/*  170 */     this.USUARIO = usu;
/*  171 */     this.panel.setViewportView(this);
/*  172 */     consultarAguinaldos();
/*      */   }
/*      */   
/*      */   public void colorear() {
/*  176 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  178 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  182 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jTextField1, evt);
/*      */           }
/*      */         });
/*  185 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  187 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  191 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jTextField9, evt);
/*      */           }
/*      */         });
/*  194 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  196 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  200 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jTextField10, evt);
/*      */           }
/*      */         });
/*  203 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  205 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  209 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*  212 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  214 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  218 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/*  221 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  223 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  227 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox3, evt);
/*      */           }
/*      */         });
/*  230 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  232 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  236 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*  239 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  241 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  245 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*  248 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  250 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  254 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jComboBox6, evt);
/*      */           }
/*      */         });
/*  257 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  259 */             Aguinaldos.this.jTextGanado(Aguinaldos.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/*  263 */             Aguinaldos.this.jTextPerdido(Aguinaldos.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  269 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  273 */     campo.setBackground(Color.white);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void initComponents() {
/*  279 */     this.jFrame1 = new JFrame();
/*  280 */     this.jPanel3 = new JPanel();
/*  281 */     this.jLabel3 = new JLabel();
/*  282 */     this.jTabbedPane1 = new JTabbedPane();
/*  283 */     this.jPanel6 = new JPanel();
/*  284 */     this.jScrollPane1 = new JScrollPane();
/*  285 */     this.jTable1 = new JTable();
/*  286 */     this.jLabel14 = new JLabel();
/*  287 */     this.jLabel20 = new JLabel();
/*  288 */     this.jPanel7 = new JPanel();
/*  289 */     this.jPanel9 = new JPanel();
/*  290 */     this.jScrollPane2 = new JScrollPane();
/*  291 */     this.jTable2 = new JTable();
/*  292 */     this.jLabel18 = new JLabel();
/*  293 */     this.jLabel19 = new JLabel();
/*  294 */     this.jLabel22 = new JLabel();
/*  295 */     this.jTextField6 = new JTextField();
/*  296 */     this.jLabel23 = new JLabel();
/*  297 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  298 */     this.jPanel4 = new JPanel();
/*  299 */     this.jLabel8 = new JLabel();
/*  300 */     this.jRadioButton1 = new JRadioButton();
/*  301 */     this.jRadioButton2 = new JRadioButton();
/*  302 */     this.jLabel9 = new JLabel();
/*  303 */     this.jComboBox4 = new JComboBox();
/*  304 */     this.jLabel12 = new JLabel();
/*  305 */     this.jButton5 = new JButton();
/*  306 */     this.jLabel10 = new JLabel();
/*  307 */     this.jLabel11 = new JLabel();
/*  308 */     this.jLabel13 = new JLabel();
/*  309 */     this.jButton3 = new JButton();
/*  310 */     this.jButton4 = new JButton();
/*  311 */     this.jButton6 = new JButton();
/*  312 */     this.jButton7 = new JButton();
/*  313 */     this.jLabel21 = new JLabel();
/*  314 */     this.jDialog1 = new CerrarVentana(this.jFrame1);
/*  315 */     this.jPanel10 = new JPanel();
/*  316 */     this.jLabel60 = new JLabel();
/*  317 */     this.jPanel36 = new JPanel();
/*  318 */     this.jScrollPane6 = new JScrollPane();
/*  319 */     this.jTable6 = new JTable();
/*  320 */     this.jLabel61 = new JLabel();
/*  321 */     this.jTextField9 = new JTextField();
/*  322 */     this.jLabel62 = new JLabel();
/*  323 */     this.jTextField10 = new JTextField();
/*  324 */     this.jLabel63 = new JLabel();
/*  325 */     this.jComboBox5 = new JComboBox();
/*  326 */     this.jButton22 = new JButton();
/*  327 */     this.jButton29 = new JButton();
/*  328 */     this.jButton30 = new JButton();
/*  329 */     this.jLabel64 = new JLabel();
/*  330 */     this.jComboBox6 = new JComboBox();
/*  331 */     this.jLabel16 = new JLabel();
/*  332 */     this.jLabel17 = new JLabel();
/*  333 */     this.jCheckBox4 = new JCheckBox();
/*  334 */     this.jSeparator8 = new JSeparator();
/*  335 */     this.buttonGroup1 = new ButtonGroup();
/*  336 */     this.cantidad = new JFormattedTextField();
/*  337 */     this.jDialog2 = new CerrarVentana(this.jFrame1);
/*  338 */     this.jPanel11 = new JPanel();
/*  339 */     this.jLabel65 = new JLabel();
/*  340 */     this.jSeparator9 = new JSeparator();
/*  341 */     this.jCheckBox1 = new JCheckBox();
/*  342 */     this.jCheckBox2 = new JCheckBox();
/*  343 */     this.jCheckBox3 = new JCheckBox();
/*  344 */     this.jSeparator10 = new JSeparator();
/*  345 */     this.jButton1 = new JButton();
/*  346 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  347 */     this.jPanel29 = new JPanel();
/*  348 */     this.jLabel124 = new JLabel();
/*  349 */     this.jSeparator29 = new JSeparator();
/*  350 */     this.jLabel125 = new JLabel();
/*  351 */     this.jButton44 = new JButton();
/*  352 */     this.jButton45 = new JButton();
/*  353 */     this.jScrollPane18 = new JScrollPane();
/*  354 */     this.jTextArea5 = new JTextArea();
/*  355 */     this.jLabel126 = new JLabel();
/*  356 */     this.jPanel1 = new JPanel();
/*  357 */     this.jLabel54 = new JLabel();
/*  358 */     this.jPanel5 = new JPanel();
/*  359 */     this.jLabel48 = new JLabel();
/*  360 */     this.jScrollPane3 = new JScrollPane();
/*  361 */     this.jTable3 = new JTable();
/*  362 */     this.jButton23 = new JButton();
/*  363 */     this.jButton24 = new JButton();
/*  364 */     this.jButton25 = new JButton();
/*  365 */     this.jButton26 = new JButton();
/*  366 */     this.jButton2 = new JButton();
/*  367 */     this.jButton27 = new JButton();
/*  368 */     this.jButton28 = new JButton();
/*  369 */     this.jPanel17 = new JPanel();
/*  370 */     this.jTextField1 = new JTextField();
/*  371 */     this.jLabel15 = new JLabel();
/*  372 */     this.jComboBox1 = new JComboBox();
/*  373 */     this.jLabel46 = new JLabel();
/*  374 */     this.jComboBox2 = new JComboBox();
/*  375 */     this.jLabel47 = new JLabel();
/*  376 */     this.jComboBox3 = new JComboBox();
/*  377 */     this.jLabel49 = new JLabel();
/*      */     
/*  379 */     this.jFrame1.setTitle("Aguinaldos");
/*      */     
/*  381 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  383 */     this.jLabel3.setFont(new Font("Tahoma", 1, 15));
/*  384 */     this.jLabel3.setHorizontalAlignment(0);
/*  385 */     this.jLabel3.setText("AGUINALDOS");
/*      */     
/*  387 */     this.jTabbedPane1.setTabPlacement(3);
/*      */     
/*  389 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*      */     
/*  391 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  392 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  400 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  405 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  408 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  409 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  410 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(50);
/*  411 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/*  412 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/*  413 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/*  414 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(110);
/*  415 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
/*  416 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/*  417 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     } 
/*      */     
/*  420 */     this.jLabel14.setFont(new Font("Tahoma", 1, 15));
/*  421 */     this.jLabel14.setHorizontalAlignment(4);
/*  422 */     this.jLabel14.setText("$0.0");
/*      */     
/*  424 */     this.jLabel20.setHorizontalAlignment(4);
/*  425 */     this.jLabel20.setText("Total del complemento");
/*      */     
/*  427 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  428 */     this.jPanel6.setLayout(jPanel6Layout);
/*  429 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  430 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  431 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  432 */           .addContainerGap()
/*  433 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  434 */             .addComponent(this.jScrollPane1, -1, 677, 32767)
/*  435 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  436 */               .addComponent(this.jLabel20, -2, 129, -2)
/*  437 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  438 */               .addComponent(this.jLabel14, -2, 127, -2)))
/*  439 */           .addContainerGap()));
/*      */     
/*  441 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  442 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  443 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  444 */           .addComponent(this.jScrollPane1, -1, 496, 32767)
/*  445 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  446 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  447 */             .addComponent(this.jLabel14)
/*  448 */             .addComponent(this.jLabel20))));
/*      */ 
/*      */     
/*  451 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/*      */     
/*  453 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/*  455 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/*  456 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  464 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  469 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  472 */     this.jScrollPane2.setViewportView(this.jTable2);
/*  473 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/*  474 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/*  475 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/*  476 */       this.jTable2.getColumnModel().getColumn(2).setMinWidth(110);
/*  477 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(110);
/*  478 */       this.jTable2.getColumnModel().getColumn(3).setMinWidth(110);
/*  479 */       this.jTable2.getColumnModel().getColumn(3).setMaxWidth(110);
/*      */     } 
/*      */     
/*  482 */     this.jLabel18.setFont(new Font("Tahoma", 1, 15));
/*  483 */     this.jLabel18.setHorizontalAlignment(4);
/*  484 */     this.jLabel18.setText("$0.0");
/*      */     
/*  486 */     this.jLabel19.setHorizontalAlignment(4);
/*  487 */     this.jLabel19.setText("Total de imss");
/*      */     
/*  489 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  490 */     this.jPanel9.setLayout(jPanel9Layout);
/*  491 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  492 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  493 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  494 */           .addContainerGap()
/*  495 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  496 */             .addComponent(this.jScrollPane2, -1, 677, 32767)
/*  497 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  498 */               .addComponent(this.jLabel19, -2, 118, -2)
/*  499 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  500 */               .addComponent(this.jLabel18, -2, 127, -2)))
/*  501 */           .addContainerGap()));
/*      */     
/*  503 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  504 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  505 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  506 */           .addComponent(this.jScrollPane2, -1, 496, 32767)
/*  507 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  508 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  509 */             .addComponent(this.jLabel18)
/*  510 */             .addComponent(this.jLabel19))));
/*      */ 
/*      */     
/*  513 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  514 */     this.jPanel7.setLayout(jPanel7Layout);
/*  515 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  516 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  517 */         .addGap(0, 697, 32767)
/*  518 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  519 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */     
/*  521 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  523 */         .addGap(0, 521, 32767)
/*  524 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  525 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */ 
/*      */     
/*  528 */     this.jTabbedPane1.addTab("Imss", this.jPanel7);
/*      */     
/*  530 */     this.jLabel22.setHorizontalAlignment(2);
/*  531 */     this.jLabel22.setText("Folio:");
/*      */     
/*  533 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/*  534 */     this.jTextField6.setEnabled(false);
/*      */     
/*  536 */     this.jLabel23.setHorizontalAlignment(4);
/*  537 */     this.jLabel23.setText("Fecha:");
/*      */     
/*  539 */     this.jDateChooser10.setDate(this.fechaActual);
/*  540 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/*  541 */     this.jDateChooser10.setEnabled(false);
/*  542 */     this.jDateChooser10.setIcon(this.icon);
/*  543 */     this.jDateChooser10.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  545 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  546 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Datos del aguinaldo"));
/*      */     
/*  548 */     this.jLabel8.setText("Tipo de Aguinaldo");
/*      */     
/*  550 */     this.jRadioButton1.setBackground(new Color(255, 255, 255));
/*  551 */     this.jRadioButton1.setSelected(true);
/*  552 */     this.jRadioButton1.setText("Administrativos");
/*  553 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  555 */             Aguinaldos.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  559 */     this.jRadioButton2.setBackground(new Color(255, 255, 255));
/*  560 */     this.jRadioButton2.setText("Operadores");
/*  561 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  563 */             Aguinaldos.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  567 */     this.jLabel9.setHorizontalAlignment(4);
/*  568 */     this.jLabel9.setText("Año");
/*      */     
/*  570 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  571 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*      */     
/*  573 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  574 */     this.jPanel4.setLayout(jPanel4Layout);
/*  575 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  576 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  577 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  578 */           .addComponent(this.jLabel8, -2, 130, -2)
/*  579 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  580 */           .addComponent(this.jRadioButton1, -2, 129, -2)
/*  581 */           .addGap(8, 8, 8)
/*  582 */           .addComponent(this.jRadioButton2, -2, 129, -2)
/*  583 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 241, 32767)
/*  584 */           .addComponent(this.jLabel9, -2, 47, -2)
/*  585 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  586 */           .addComponent(this.jComboBox4, -2, 104, -2)
/*  587 */           .addContainerGap()));
/*      */     
/*  589 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  590 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  591 */         .addComponent(this.jLabel8, -1, -1, 32767)
/*  592 */         .addComponent(this.jRadioButton2, -1, -1, 32767)
/*  593 */         .addComponent(this.jRadioButton1, -1, -1, 32767)
/*  594 */         .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  595 */           .addComponent(this.jLabel9)
/*  596 */           .addComponent(this.jComboBox4, -2, -1, -2)));
/*      */ 
/*      */     
/*  599 */     this.jLabel12.setText("Para agregar empleados haz clic en el siguiente botón");
/*      */     
/*  601 */     this.jButton5.setMnemonic('A');
/*  602 */     this.jButton5.setText("Agregar Empleados");
/*  603 */     this.jButton5.setToolTipText("Agregar Empleados (Alt+A)");
/*  604 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  606 */             Aguinaldos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  610 */     this.jLabel10.setText("Total de empleados:");
/*      */     
/*  612 */     this.jLabel11.setFont(new Font("Tahoma", 1, 14));
/*  613 */     this.jLabel11.setText("0");
/*      */     
/*  615 */     this.jLabel13.setFont(new Font("Tahoma", 1, 15));
/*  616 */     this.jLabel13.setHorizontalAlignment(11);
/*  617 */     this.jLabel13.setText("$0.0");
/*      */     
/*  619 */     this.jButton3.setMnemonic('C');
/*  620 */     this.jButton3.setText("Cerrar");
/*  621 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/*  622 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  624 */             Aguinaldos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  628 */     this.jButton4.setMnemonic('G');
/*  629 */     this.jButton4.setText("Guardar");
/*  630 */     this.jButton4.setToolTipText("Guardar (Alt+G)");
/*  631 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  633 */             Aguinaldos.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  637 */     this.jButton6.setMnemonic('E');
/*  638 */     this.jButton6.setText("Exportar");
/*  639 */     this.jButton6.setToolTipText("Exportar (Alt+E)");
/*  640 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  642 */             Aguinaldos.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  646 */     this.jButton7.setMnemonic('Q');
/*  647 */     this.jButton7.setText("Quitar");
/*  648 */     this.jButton7.setToolTipText("Quitar (Alt+Q)");
/*  649 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  651 */             Aguinaldos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  655 */     this.jLabel21.setHorizontalAlignment(4);
/*  656 */     this.jLabel21.setText("Total neto");
/*      */     
/*  658 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  659 */     this.jPanel3.setLayout(jPanel3Layout);
/*  660 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  661 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  662 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  663 */           .addContainerGap()
/*  664 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  665 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  666 */               .addComponent(this.jLabel22, -2, 48, -2)
/*  667 */               .addGap(4, 4, 4)
/*  668 */               .addComponent(this.jTextField6, -2, 145, -2)
/*  669 */               .addGap(26, 26, 26)
/*  670 */               .addComponent(this.jLabel3, -1, 448, 32767)
/*  671 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  672 */               .addComponent(this.jLabel23, -2, 57, -2)
/*  673 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  674 */               .addComponent((Component)this.jDateChooser10, -2, 92, -2)
/*  675 */               .addContainerGap())
/*  676 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  677 */               .addComponent(this.jPanel4, -1, -1, 32767)
/*  678 */               .addContainerGap())
/*  679 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  680 */               .addComponent(this.jLabel12, -2, 303, -2)
/*  681 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  682 */               .addComponent(this.jButton5, -2, 143, -2)
/*  683 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  684 */               .addComponent(this.jButton7, -2, 87, -2)
/*  685 */               .addContainerGap())
/*  686 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  687 */               .addComponent(this.jTabbedPane1, -1, 702, 32767)
/*  688 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  689 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  690 */                 .addComponent(this.jButton4, -2, 106, -2)
/*  691 */                 .addComponent(this.jButton6, -1, -1, 32767)
/*  692 */                 .addComponent(this.jButton3, -2, 106, -2))
/*  693 */               .addContainerGap())
/*  694 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  695 */               .addComponent(this.jLabel10, -2, 129, -2)
/*  696 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  697 */               .addComponent(this.jLabel11, -2, 63, -2)
/*  698 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 262, 32767)
/*  699 */               .addComponent(this.jLabel21, -2, 87, -2)
/*  700 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  701 */               .addComponent(this.jLabel13, -2, 133, -2)
/*  702 */               .addGap(134, 134, 134)))));
/*      */     
/*  704 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  706 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  707 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  709 */               .addComponent(this.jLabel3)
/*  710 */               .addComponent(this.jTextField6, -2, -1, -2)
/*  711 */               .addComponent(this.jLabel22)
/*  712 */               .addComponent(this.jLabel23))
/*  713 */             .addComponent((Component)this.jDateChooser10, -2, -1, -2))
/*  714 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  715 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  716 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  717 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  718 */             .addComponent(this.jLabel12)
/*  719 */             .addComponent(this.jButton5)
/*  720 */             .addComponent(this.jButton7))
/*  721 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  722 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  723 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  724 */               .addComponent(this.jTabbedPane1, -1, 549, 32767)
/*  725 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  726 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  727 */                 .addComponent(this.jLabel21)
/*  728 */                 .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  729 */                   .addComponent(this.jLabel10)
/*  730 */                   .addComponent(this.jLabel11)
/*  731 */                   .addComponent(this.jLabel13))))
/*  732 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  733 */               .addComponent(this.jButton4, -2, 24, -2)
/*  734 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  735 */               .addComponent(this.jButton6, -2, 24, -2)
/*  736 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  737 */               .addComponent(this.jButton3, -2, 24, -2)))
/*  738 */           .addContainerGap()));
/*      */ 
/*      */     
/*  741 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/*  742 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/*  743 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/*  744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  745 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  747 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/*  748 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  749 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  752 */     this.jDialog1.setTitle("Búsqueda de Empleados");
/*  753 */     this.jDialog1.setModal(true);
/*      */     
/*  755 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/*  757 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/*  758 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/*  759 */     this.jLabel60.setHorizontalAlignment(0);
/*  760 */     this.jLabel60.setText("Busqueda de Empleados");
/*      */     
/*  762 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/*  763 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Empleados", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  765 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/*  766 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  774 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  779 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  782 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  784 */             Aguinaldos.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/*  787 */     this.jScrollPane6.setViewportView(this.jTable6);
/*      */     
/*  789 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/*  790 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/*  791 */     this.jLabel61.setHorizontalAlignment(4);
/*  792 */     this.jLabel61.setText("Clave");
/*      */     
/*  794 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  796 */             Aguinaldos.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  800 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/*  801 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/*  802 */     this.jLabel62.setHorizontalAlignment(4);
/*  803 */     this.jLabel62.setText("Nombre");
/*      */     
/*  805 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  807 */             Aguinaldos.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  811 */     this.jLabel63.setFont(new Font("Tahoma", 2, 11));
/*  812 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  813 */     this.jLabel63.setHorizontalAlignment(4);
/*  814 */     this.jLabel63.setText("Tipo");
/*      */     
/*  816 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  817 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/*  818 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  820 */             Aguinaldos.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  824 */     this.jButton22.setMnemonic('T');
/*  825 */     this.jButton22.setText("Agregar Todos");
/*  826 */     this.jButton22.setToolTipText("Agregar Todos (Alt+T)");
/*  827 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  829 */             Aguinaldos.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  833 */     this.jButton29.setMnemonic('C');
/*  834 */     this.jButton29.setText("Cerrar");
/*  835 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/*  836 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  838 */             Aguinaldos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  842 */     this.jButton30.setMnemonic('A');
/*  843 */     this.jButton30.setText("Agregar");
/*  844 */     this.jButton30.setToolTipText("Agregar (Alt+A)");
/*  845 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  847 */             Aguinaldos.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  851 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/*  852 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/*  853 */     this.jLabel64.setHorizontalAlignment(4);
/*  854 */     this.jLabel64.setText("Depto");
/*      */     
/*  856 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  857 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  858 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  860 */             Aguinaldos.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  864 */     this.jLabel16.setText("Total de datos:");
/*      */     
/*  866 */     this.jLabel17.setFont(new Font("Tahoma", 1, 14));
/*  867 */     this.jLabel17.setText("0");
/*      */     
/*  869 */     this.jCheckBox4.setText("Seleccionar todos");
/*  870 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  872 */             Aguinaldos.this.jCheckBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  876 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  877 */     this.jPanel36.setLayout(jPanel36Layout);
/*  878 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  879 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  880 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/*  881 */           .addContainerGap()
/*  882 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  883 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 835, 32767)
/*  884 */             .addComponent(this.jCheckBox4, GroupLayout.Alignment.LEADING, -2, 132, -2)
/*  885 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
/*  886 */               .addComponent(this.jLabel61, -2, 40, -2)
/*  887 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  888 */               .addComponent(this.jTextField9, -2, 52, -2)
/*  889 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  890 */               .addComponent(this.jLabel62, -2, 57, -2)
/*  891 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  892 */               .addComponent(this.jTextField10, -2, 169, -2)
/*  893 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  894 */               .addComponent(this.jLabel63, -2, 63, -2)
/*  895 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  896 */               .addComponent(this.jComboBox5, -2, 168, -2)
/*  897 */               .addGap(18, 18, 18)
/*  898 */               .addComponent(this.jLabel64, -2, 63, -2)
/*  899 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  900 */               .addComponent(this.jComboBox6, -2, 168, -2))
/*  901 */             .addGroup(jPanel36Layout.createSequentialGroup()
/*  902 */               .addComponent(this.jLabel16, -2, 90, -2)
/*  903 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  904 */               .addComponent(this.jLabel17, -2, 75, -2)
/*  905 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 272, 32767)
/*  906 */               .addComponent(this.jButton22, -2, 126, -2)
/*  907 */               .addGap(8, 8, 8)
/*  908 */               .addComponent(this.jButton30, -2, 126, -2)
/*  909 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  910 */               .addComponent(this.jButton29, -2, 126, -2)))
/*  911 */           .addContainerGap()));
/*      */     
/*  913 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  914 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  915 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  916 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  917 */             .addComponent(this.jLabel61)
/*  918 */             .addComponent(this.jTextField9, -2, -1, -2)
/*  919 */             .addComponent(this.jLabel62)
/*  920 */             .addComponent(this.jTextField10, -2, -1, -2)
/*  921 */             .addComponent(this.jLabel63)
/*  922 */             .addComponent(this.jComboBox5, -2, -1, -2)
/*  923 */             .addComponent(this.jLabel64)
/*  924 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  925 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  926 */           .addComponent(this.jCheckBox4)
/*  927 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  928 */           .addComponent(this.jScrollPane6, -1, 246, 32767)
/*  929 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  930 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  931 */             .addComponent(this.jButton29)
/*  932 */             .addComponent(this.jButton22)
/*  933 */             .addComponent(this.jButton30)
/*  934 */             .addComponent(this.jLabel16)
/*  935 */             .addComponent(this.jLabel17))
/*  936 */           .addContainerGap()));
/*      */ 
/*      */     
/*  939 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  940 */     this.jPanel10.setLayout(jPanel10Layout);
/*  941 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  942 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  943 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  944 */           .addContainerGap()
/*  945 */           .addComponent(this.jSeparator8, -1, 865, 32767)
/*  946 */           .addContainerGap())
/*  947 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  948 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/*  949 */             .addGap(8, 8, 8)
/*  950 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  951 */               .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 867, 32767)
/*  952 */               .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  953 */             .addGap(10, 10, 10))));
/*      */     
/*  955 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  956 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  957 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  958 */           .addGap(31, 31, 31)
/*  959 */           .addComponent(this.jSeparator8, -2, 10, -2)
/*  960 */           .addContainerGap(372, 32767))
/*  961 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  962 */           .addGroup(jPanel10Layout.createSequentialGroup()
/*  963 */             .addComponent(this.jLabel60, -2, 31, -2)
/*  964 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  965 */             .addComponent(this.jPanel36, -1, -1, 32767)
/*  966 */             .addContainerGap())));
/*      */ 
/*      */     
/*  969 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  970 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  971 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/*  975 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/*  980 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/*  982 */     this.jDialog2.setTitle("Impresión de reportes");
/*  983 */     this.jDialog2.setModal(true);
/*      */     
/*  985 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/*  987 */     this.jLabel65.setFont(new Font("Tahoma", 1, 16));
/*  988 */     this.jLabel65.setForeground(new Color(0, 102, 102));
/*  989 */     this.jLabel65.setHorizontalAlignment(0);
/*  990 */     this.jLabel65.setText("Selecciona el tipo de reporte");
/*      */     
/*  992 */     this.jCheckBox1.setText("Reporte de aguinaldos - Complemento");
/*      */     
/*  994 */     this.jCheckBox2.setText("Reporte de aguinaldos - Imss");
/*      */     
/*  996 */     this.jCheckBox3.setText("Reporte de comprobantes");
/*      */     
/*  998 */     this.jButton1.setMnemonic('I');
/*  999 */     this.jButton1.setText("Imprimir");
/* 1000 */     this.jButton1.setToolTipText("Imprimir (Alt+I)");
/* 1001 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1003 */             Aguinaldos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1007 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1008 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1009 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1010 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1011 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1012 */           .addContainerGap()
/* 1013 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1014 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1015 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1016 */                 .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 280, 32767)
/* 1017 */                 .addGroup(jPanel11Layout.createSequentialGroup()
/* 1018 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 181, 32767)
/* 1019 */                   .addComponent(this.jButton1, -2, 99, -2)))
/* 1020 */               .addContainerGap())
/* 1021 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1022 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1023 */                 .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING)
/* 1024 */                 .addComponent(this.jCheckBox3, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1025 */                 .addComponent(this.jCheckBox2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1026 */                 .addComponent(this.jCheckBox1, GroupLayout.Alignment.LEADING, -1, 280, 32767))
/* 1027 */               .addContainerGap(-1, 32767))))
/* 1028 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1029 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 1030 */             .addGap(8, 8, 8)
/* 1031 */             .addComponent(this.jLabel65, -1, 282, 32767)
/* 1032 */             .addContainerGap())));
/*      */     
/* 1034 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1035 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1036 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1037 */           .addGap(24, 24, 24)
/* 1038 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 1039 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1040 */           .addComponent(this.jCheckBox1)
/* 1041 */           .addGap(18, 18, 18)
/* 1042 */           .addComponent(this.jCheckBox2)
/* 1043 */           .addGap(18, 18, 18)
/* 1044 */           .addComponent(this.jCheckBox3)
/* 1045 */           .addGap(18, 18, 18)
/* 1046 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1047 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1048 */           .addComponent(this.jButton1)
/* 1049 */           .addContainerGap(-1, 32767))
/* 1050 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1051 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 1052 */             .addComponent(this.jLabel65)
/* 1053 */             .addContainerGap(189, 32767))));
/*      */ 
/*      */     
/* 1056 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1057 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1058 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1059 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1060 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */     
/* 1062 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1063 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1064 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 1067 */     this.jDialog3.setTitle("Cancelar Aguinaldo");
/* 1068 */     this.jDialog3.setModal(true);
/*      */     
/* 1070 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 1072 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1073 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1074 */     this.jLabel124.setHorizontalAlignment(0);
/* 1075 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1077 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1078 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1079 */     this.jLabel125.setHorizontalAlignment(4);
/* 1080 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1082 */     this.jButton44.setMnemonic('A');
/* 1083 */     this.jButton44.setText("Cancelar Aguinaldos");
/* 1084 */     this.jButton44.setToolTipText("Cancelar Aguinaldos (Alt+A)");
/* 1085 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1087 */             Aguinaldos.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1091 */     this.jButton45.setMnemonic('C');
/* 1092 */     this.jButton45.setText("Cerrar");
/* 1093 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1094 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1096 */             Aguinaldos.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1100 */     this.jTextArea5.setColumns(20);
/* 1101 */     this.jTextArea5.setLineWrap(true);
/* 1102 */     this.jTextArea5.setRows(5);
/* 1103 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1105 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el pago de agunaldos");
/*      */     
/* 1107 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1108 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1109 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1110 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1111 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1112 */           .addContainerGap()
/* 1113 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1114 */             .addComponent(this.jLabel126, -2, 349, 32767)
/* 1115 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1116 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1117 */                 .addComponent(this.jButton44, -2, 159, -2)
/* 1118 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1119 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1120 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1121 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1122 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1123 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1124 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1125 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1126 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1127 */           .addContainerGap()));
/*      */     
/* 1129 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1130 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1131 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1132 */           .addComponent(this.jLabel124)
/* 1133 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1134 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1135 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1136 */           .addComponent(this.jLabel126)
/* 1137 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1138 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1139 */             .addComponent(this.jLabel125)
/* 1140 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1141 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1142 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1143 */             .addComponent(this.jButton45)
/* 1144 */             .addComponent(this.jButton44))
/* 1145 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1148 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1149 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1150 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1151 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1152 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 1154 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1156 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 1159 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1160 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1162 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1163 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1164 */     this.jLabel54.setHorizontalAlignment(0);
/* 1165 */     this.jLabel54.setText("AGUINALDOS");
/*      */     
/* 1167 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1168 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1170 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1171 */     this.jLabel48.setForeground(Color.red);
/* 1172 */     this.jLabel48.setHorizontalAlignment(0);
/* 1173 */     this.jLabel48.setText("t");
/* 1174 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1176 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1177 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1185 */     this.jTable3.setShowVerticalLines(false);
/* 1186 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1188 */             Aguinaldos.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1191 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1193 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1194 */     this.jButton23.setMnemonic('V');
/* 1195 */     this.jButton23.setText("Ver");
/* 1196 */     this.jButton23.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1197 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1199 */             Aguinaldos.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1203 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1204 */     this.jButton24.setMnemonic('V');
/* 1205 */     this.jButton24.setText("Nueva");
/* 1206 */     this.jButton24.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1207 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1209 */             Aguinaldos.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1213 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1214 */     this.jButton25.setMnemonic('V');
/* 1215 */     this.jButton25.setText("Cancelar");
/* 1216 */     this.jButton25.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1217 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1219 */             Aguinaldos.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1223 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1224 */     this.jButton26.setMnemonic('V');
/* 1225 */     this.jButton26.setText("Guardar Reporte");
/* 1226 */     this.jButton26.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1227 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1229 */             Aguinaldos.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1233 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1234 */     this.jButton2.setMnemonic('I');
/* 1235 */     this.jButton2.setText("Imprimir");
/* 1236 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 1237 */     this.jButton2.setEnabled(false);
/*      */     
/* 1239 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1240 */     this.jButton27.setMnemonic('V');
/* 1241 */     this.jButton27.setText("Modificar");
/* 1242 */     this.jButton27.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1243 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1245 */             Aguinaldos.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1249 */     this.jButton28.setMnemonic('R');
/* 1250 */     this.jButton28.setText("Autorizar");
/* 1251 */     this.jButton28.setToolTipText("Autorizar (Alt+R)");
/* 1252 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1254 */             Aguinaldos.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1258 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1259 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1260 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1261 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1262 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1263 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 1264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1265 */           .addComponent(this.jButton24, -2, 119, -2)
/* 1266 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1267 */           .addComponent(this.jButton27, -2, 119, -2)
/* 1268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1269 */           .addComponent(this.jButton23, -2, 119, -2)
/* 1270 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1271 */           .addComponent(this.jButton25, -2, 119, -2)
/* 1272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1273 */           .addComponent(this.jButton28, -2, 119, -2)
/* 1274 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1275 */           .addComponent(this.jButton26)
/* 1276 */           .addGap(18, 18, 18)
/* 1277 */           .addComponent(this.jButton2, -2, 124, -2)
/* 1278 */           .addGap(31, 31, 31))
/* 1279 */         .addComponent(this.jScrollPane3));
/*      */     
/* 1281 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1283 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1284 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1285 */             .addComponent(this.jLabel48)
/* 1286 */             .addComponent(this.jButton24, -2, 28, -2)
/* 1287 */             .addComponent(this.jButton27, -2, 28, -2)
/* 1288 */             .addComponent(this.jButton23, -2, 28, -2)
/* 1289 */             .addComponent(this.jButton25, -2, 28, -2)
/* 1290 */             .addComponent(this.jButton28, -2, 28, -2)
/* 1291 */             .addComponent(this.jButton2)
/* 1292 */             .addComponent(this.jButton26, -2, 28, -2))
/* 1293 */           .addGap(7, 7, 7)
/* 1294 */           .addComponent(this.jScrollPane3, -1, 205, 32767)));
/*      */ 
/*      */     
/* 1297 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1298 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Aguinaldos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1300 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1302 */             Aguinaldos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1306 */     this.jLabel15.setFont(new Font("Tahoma", 3, 11));
/* 1307 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1308 */     this.jLabel15.setHorizontalAlignment(0);
/* 1309 */     this.jLabel15.setText("Folio");
/*      */     
/* 1311 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1312 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "TODOS", "<Por Autorizar>", "<Autorizado>", "<Cancelado>" }));
/* 1313 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1315 */             Aguinaldos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1319 */     this.jLabel46.setFont(new Font("Tahoma", 3, 11));
/* 1320 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1321 */     this.jLabel46.setHorizontalAlignment(0);
/* 1322 */     this.jLabel46.setText("Estatus");
/*      */     
/* 1324 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1325 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1327 */             Aguinaldos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1331 */     this.jLabel47.setFont(new Font("Tahoma", 3, 11));
/* 1332 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1333 */     this.jLabel47.setHorizontalAlignment(0);
/* 1334 */     this.jLabel47.setText("Año");
/*      */     
/* 1336 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1337 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1338 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1340 */             Aguinaldos.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1344 */     this.jLabel49.setFont(new Font("Tahoma", 3, 11));
/* 1345 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1346 */     this.jLabel49.setHorizontalAlignment(0);
/* 1347 */     this.jLabel49.setText("Responsable");
/*      */     
/* 1349 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1350 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1351 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1352 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1353 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1354 */           .addContainerGap()
/* 1355 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1356 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1357 */             .addComponent(this.jTextField1, -2, 81, -2))
/* 1358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1359 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1360 */             .addComponent(this.jLabel46, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1361 */             .addComponent(this.jComboBox1, GroupLayout.Alignment.TRAILING, 0, -1, 32767))
/* 1362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1363 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1364 */             .addComponent(this.jComboBox2, 0, 110, 32767)
/* 1365 */             .addComponent(this.jLabel47, -1, -1, 32767))
/* 1366 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1367 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1368 */             .addComponent(this.jComboBox3, 0, -1, 32767)
/* 1369 */             .addComponent(this.jLabel49, -2, 143, -2))
/* 1370 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1372 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1373 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1374 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1375 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1376 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1377 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 1378 */               .addGap(8, 8, 8)
/* 1379 */               .addComponent(this.jLabel15, -1, -1, 32767))
/* 1380 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1381 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 1382 */               .addGap(8, 8, 8)
/* 1383 */               .addComponent(this.jLabel46, -1, -1, 32767))
/* 1384 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1385 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 1386 */               .addGap(8, 8, 8)
/* 1387 */               .addComponent(this.jLabel47, -1, -1, 32767))
/* 1388 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1389 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 1390 */               .addGap(8, 8, 8)
/* 1391 */               .addComponent(this.jLabel49, -1, -1, 32767)))
/* 1392 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1395 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1396 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1397 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1399 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1400 */           .addContainerGap()
/* 1401 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1402 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1403 */             .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1404 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1405 */           .addContainerGap()));
/*      */     
/* 1407 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1408 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1409 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1410 */           .addComponent(this.jLabel54)
/* 1411 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1412 */           .addComponent(this.jPanel17, -2, 68, -2)
/* 1413 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1414 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1415 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1418 */     GroupLayout layout = new GroupLayout(this);
/* 1419 */     setLayout(layout);
/* 1420 */     layout.setHorizontalGroup(layout
/* 1421 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1422 */         .addGap(0, 1166, 32767)
/* 1423 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1424 */           .addGroup(layout.createSequentialGroup()
/* 1425 */             .addGap(7, 7, 7)
/* 1426 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1427 */             .addGap(7, 7, 7))));
/*      */     
/* 1429 */     layout.setVerticalGroup(layout
/* 1430 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1431 */         .addGap(0, 409, 32767)
/* 1432 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1433 */           .addGroup(layout.createSequentialGroup()
/* 1434 */             .addContainerGap()
/* 1435 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1436 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 1441 */     sacarMayor();
/* 1442 */     this.jTabbedPane1.removeAll();
/* 1443 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1444 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1445 */     this.jButton5.setEnabled(true);
/* 1446 */     this.jButton7.setEnabled(true);
/* 1447 */     this.jRadioButton1.setEnabled(true);
/* 1448 */     this.jRadioButton2.setEnabled(true);
/* 1449 */     this.jButton4.setText("Guardar");
/* 1450 */     this.jButton4.setToolTipText("Guardar");
/* 1451 */     this.jButton4.setMnemonic('G');
/* 1452 */     deshabilitar();
/* 1453 */     limpiar();
/* 1454 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1458 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 1462 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1466 */     this.jCheckBox4.setSelected(false);
/* 1467 */     if (this.jRadioButton1.isSelected()) {
/* 1468 */       this.jComboBox6.setEnabled(true);
/* 1469 */       consultar1();
/*      */     } else {
/* 1471 */       this.jComboBox6.setEnabled(false);
/* 1472 */       consultar2();
/*      */     } 
/* 1474 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 1478 */     if (this.jRadioButton1.isSelected()) {
/* 1479 */       consultar1();
/*      */     } else {
/* 1481 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 1486 */     consultar1();
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 1490 */     if (this.jRadioButton1.isSelected()) {
/* 1491 */       consultar1();
/*      */     } else {
/* 1493 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 1498 */     if (this.jRadioButton1.isSelected()) {
/* 1499 */       consultar1();
/*      */     } else {
/* 1501 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 1506 */     if (evt.getClickCount() == 2) {
/* 1507 */       if (this.jRadioButton1.isSelected()) {
/* 1508 */         pasarEmpleado1();
/*      */       } else {
/* 1510 */         pasarEmpleado2();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 1516 */     this.jTabbedPane1.removeAll();
/* 1517 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1518 */     deshabilitar();
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 1522 */     this.jTabbedPane1.removeAll();
/* 1523 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1524 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1525 */     deshabilitar();
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 1529 */     if (this.jRadioButton1.isSelected()) {
/* 1530 */       pasarEmpleado1();
/*      */     } else {
/* 1532 */       pasarEmpleado2();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1538 */     int indice = 0;
/* 1539 */     if (this.jRadioButton1.isSelected()) {
/* 1540 */       if (this.jTabbedPane1.getSelectedIndex() == 0) {
/* 1541 */         indice = this.jTable1.getSelectedRow();
/*      */       } else {
/* 1543 */         indice = this.jTable2.getSelectedRow();
/*      */       } 
/*      */     } else {
/* 1546 */       indice = this.jTable2.getSelectedRow();
/*      */     } 
/* 1548 */     if (indice < 0) {
/* 1549 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un empleado para poder quitarlo", "Selecciona un empleado", 0, this.ADVER);
/*      */     } else {
/* 1551 */       if (this.jRadioButton1.isSelected()) {
/* 1552 */         DefaultTableModel defaultTableModel = (DefaultTableModel)this.jTable1.getModel();
/* 1553 */         defaultTableModel.removeRow(indice);
/*      */       } 
/*      */       
/* 1556 */       DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 1557 */       temp.removeRow(indice);
/* 1558 */       sumas();
/*      */     } 
/* 1560 */     this.jLabel11.setText("" + this.jTable2.getRowCount());
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1564 */     if (this.jRadioButton1.isSelected()) {
/* 1565 */       if (this.jTabbedPane1.getSelectedIndex() == 0) {
/* 1566 */         String[] datos = { "CLAVE", "NOMBRE COMPLETO", "FECHA DE INGRESO", "DÍAS LABORADOS", "DÍAS X LEY", "DEPARTAMENTO", "SALARIO", "AGUINALDO" };
/* 1567 */         this.esc = new EscribirReporte("AGUINALDO (COMPLEMENTO)", this.jTable1, datos, this.USUARIO);
/*      */       } else {
/* 1569 */         String[] datos = { "CLAVE", "NOMBRE COMPLETO", "FECHA DE INGRESO", "DÍAS LABORADOS", "DÍAS X LEY", "DEPARTAMENTO", "SALARIO", "AGUINALDO" };
/* 1570 */         this.esc = new EscribirReporte("AGUINALDO (IMSS)", this.jTable2, datos, this.USUARIO);
/*      */       } 
/*      */     } else {
/* 1573 */       String[] datos = { "CLAVE", "NOMBRE COMPLETO", "FECHA DE INGRESO", "DÍAS LABORADOS", "DÍAS X LEY", "DEPARTAMENTO", "SALARIO", "AGUINALDO" };
/* 1574 */       this.esc = new EscribirReporte("AGUINALDO (IMSS)", this.jTable2, datos, this.USUARIO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1579 */     consultarAguinaldos();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1583 */     consultarAguinaldos();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1587 */     if (this.jTable2.getRowCount() == 0) {
/* 1588 */       JOptionPane.showMessageDialog(this.jFrame1, "Te falta agregar a los empleados para asignar el aguinaldo", "Agrega Empleados", 0, this.ERROR);
/*      */     }
/* 1590 */     else if (this.jButton4.getText().equals("Guardar")) {
/* 1591 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas generar el nuevo pago de aguinaldos?", "Generar Aguinaldos", 0, 3, this.PREG);
/* 1592 */       if (res == 0) {
/* 1593 */         sacarMayor();
/* 1594 */         int tipoLista = 0;
/* 1595 */         String tipo = "ADMINISTRATIVO";
/* 1596 */         if (this.jRadioButton2.isSelected()) {
/* 1597 */           tipoLista = 1;
/* 1598 */           tipo = "OPERATIVO";
/*      */         } 
/* 1600 */         this.con.inserSinMsj("insert into aguinaldos(folio_agui,fecha,anual,sucursal,numEmp,totalImss,totalComp,total,tipo,tipoLista,usuario,estatus)values('" + this.jTextField6.getText() + "',now()," + String.valueOf(this.jComboBox4.getSelectedItem()) + ",'" + this.SUCURSAL + "'," + this.jLabel11.getText() + ",'" + this.jLabel18.getText() + "','" + this.jLabel14.getText() + "','" + this.jLabel13.getText() + "','" + tipo + "'," + tipoLista + ",'" + this.USUARIO + "','<Por Autorizar>')");
/* 1601 */         for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 1602 */           if (this.jRadioButton1.isSelected()) {
/* 1603 */             this.con.inserSinMsj("insert into aguinaldos_contenido(clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo,tipo_lista,folio_agui) values(" + String.valueOf(this.jTable1.getValueAt(i, 0)) + ",'" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "'," + String.valueOf(this.jTable1.getValueAt(i, 3)) + ",'" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 7)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 1605 */           this.con.inserSinMsj("insert into aguinaldos_contenido(clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo,tipo_lista,folio_agui) values(" + String.valueOf(this.jTable2.getValueAt(i, 0)) + ",'" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "'," + String.valueOf(this.jTable2.getValueAt(i, 3)) + ",'" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 7)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */         } 
/*      */         
/* 1608 */         this.jCheckBox1.setEnabled(true);
/* 1609 */         this.jCheckBox2.setEnabled(true);
/* 1610 */         this.jCheckBox1.setSelected(true);
/* 1611 */         if (this.jRadioButton1.isSelected()) {
/* 1612 */           this.jCheckBox2.setSelected(true);
/*      */         } else {
/* 1614 */           this.jCheckBox1.setSelected(false);
/* 1615 */           this.jCheckBox1.setEnabled(false);
/* 1616 */           this.jCheckBox2.setSelected(true);
/*      */         } 
/* 1618 */         this.jDialog2.setVisible(true);
/*      */         
/* 1620 */         this.jFrame1.setVisible(false);
/* 1621 */         consultarAguinaldos();
/*      */       } 
/* 1623 */     } else if (this.jButton4.getText().equals("Modificar")) {
/* 1624 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar el formato de aguinaldos?", "Modificar Aguinaldos", 0, 3, this.PREG);
/* 1625 */       if (res == 0) {
/* 1626 */         this.con.eliminar2("aguinaldos_contenido", "where folio_agui = '" + this.jTextField6.getText() + "'");
/* 1627 */         this.con.inserSinMsj("update aguinaldos set fecha=now(),numEmp=" + this.jLabel11.getText() + ", totalImss='" + this.jLabel18.getText() + "', totalComp='" + this.jLabel14.getText() + "',total='" + this.jLabel13.getText() + "' where folio_agui='" + this.jTextField6.getText() + "'");
/* 1628 */         for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 1629 */           if (this.jRadioButton1.isSelected()) {
/* 1630 */             this.con.inserSinMsj("insert into aguinaldos_contenido(clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo,tipo_lista,folio_agui) values(" + String.valueOf(this.jTable1.getValueAt(i, 0)) + ",'" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "'," + String.valueOf(this.jTable1.getValueAt(i, 3)) + ",'" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 7)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 1632 */           this.con.inserSinMsj("insert into aguinaldos_contenido(clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo,tipo_lista,folio_agui) values(" + String.valueOf(this.jTable2.getValueAt(i, 0)) + ",'" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "'," + String.valueOf(this.jTable2.getValueAt(i, 3)) + ",'" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 7)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */         } 
/* 1634 */         this.jCheckBox1.setEnabled(true);
/* 1635 */         this.jCheckBox2.setEnabled(true);
/* 1636 */         this.jCheckBox1.setSelected(true);
/* 1637 */         if (this.jRadioButton1.isSelected()) {
/* 1638 */           this.jCheckBox2.setSelected(true);
/*      */         } else {
/* 1640 */           this.jCheckBox1.setSelected(false);
/* 1641 */           this.jCheckBox1.setEnabled(false);
/* 1642 */           this.jCheckBox2.setSelected(true);
/*      */         } 
/* 1644 */         this.jDialog2.setVisible(true);
/*      */         
/* 1646 */         this.jFrame1.setVisible(false);
/* 1647 */         consultarAguinaldos();
/*      */       } 
/*      */     } else {
/* 1650 */       this.SUC = this.SUCURSAL;
/* 1651 */       this.jCheckBox1.setEnabled(true);
/* 1652 */       this.jCheckBox2.setEnabled(true);
/* 1653 */       this.jCheckBox1.setSelected(true);
/* 1654 */       if (this.jRadioButton1.isSelected()) {
/* 1655 */         this.jCheckBox2.setSelected(true);
/*      */       } else {
/* 1657 */         this.jCheckBox1.setSelected(false);
/* 1658 */         this.jCheckBox1.setEnabled(false);
/* 1659 */         this.jCheckBox2.setSelected(true);
/*      */       } 
/* 1661 */       this.jDialog2.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 1667 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas agregar a todos los empleados?", "Agregar empleados", 0, 3, this.PREG);
/* 1668 */     if (res == 0) {
/* 1669 */       for (int k = 0; k < this.jTable6.getRowCount(); k++) {
/* 1670 */         boolean noEsta = false;
/* 1671 */         int indice = 0;
/* 1672 */         String clave = String.valueOf(this.jTable6.getValueAt(k, 0));
/* 1673 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 1674 */           String valor = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 1675 */           if (clave.equals(valor)) {
/* 1676 */             noEsta = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1680 */         if (!noEsta) {
/* 1681 */           String nombre = String.valueOf(this.jTable6.getValueAt(k, 1));
/* 1682 */           Vector<String> miVector = new Vector<>(); int i;
/* 1683 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 1684 */             miVector.add(String.valueOf(this.jTable2.getValueAt(i, 1)));
/*      */           }
/* 1686 */           miVector.add(nombre);
/* 1687 */           Collections.sort(miVector);
/*      */           
/* 1689 */           for (i = 0; i < miVector.size(); i++) {
/* 1690 */             if (((String)miVector.get(i)).equals(nombre)) {
/* 1691 */               indice = i;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/* 1696 */           String canti = String.valueOf(this.jTable6.getValueAt(k, 4));
/* 1697 */           String valorP = "";
/* 1698 */           for (int m = 0; m < canti.length(); m++) {
/* 1699 */             if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 1700 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 1703 */           double salarioReal = Double.parseDouble(valorP);
/* 1704 */           double diario = salarioReal / 7.0D;
/*      */           
/* 1706 */           canti = String.valueOf(this.jTable6.getValueAt(k, 3));
/* 1707 */           valorP = "";
/* 1708 */           for (int n = 0; n < canti.length(); n++) {
/* 1709 */             if (canti.charAt(n) != '$' && canti.charAt(n) != ',') {
/* 1710 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 1713 */           double salarioImss = Double.parseDouble(valorP);
/* 1714 */           double complemento = 0.0D;
/* 1715 */           complemento = diario - salarioImss;
/*      */           
/* 1717 */           this.cantidad.setValue(Double.valueOf(complemento));
/* 1718 */           String diarioL = this.cantidad.getText();
/* 1719 */           String aguinaldo = calcularAguinaldo(complemento, String.valueOf(this.jTable6.getValueAt(k, 2)));
/*      */           
/* 1721 */           if (this.jRadioButton1.isSelected()) {
/* 1722 */             DefaultTableModel defaultTableModel = (DefaultTableModel)this.jTable1.getModel();
/* 1723 */             Object[] arrayOfObject = { this.jTable6.getValueAt(k, 0), this.jTable6.getValueAt(k, 1), this.jTable6.getValueAt(k, 2), Double.valueOf(this.DIASDERECHO), this.DIASXLEY, this.jTable6.getValueAt(k, 5), diarioL, aguinaldo };
/* 1724 */             defaultTableModel.insertRow(indice, arrayOfObject);
/* 1725 */             this.jTable1.setSelectionMode(0);
/*      */           } 
/*      */           
/* 1728 */           aguinaldo = calcularAguinaldo(salarioImss, String.valueOf(this.jTable6.getValueAt(k, 2)));
/* 1729 */           DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 1730 */           Object[] nuevo = { this.jTable6.getValueAt(k, 0), this.jTable6.getValueAt(k, 1), this.jTable6.getValueAt(k, 2), Double.valueOf(this.DIASDERECHO), this.DIASXLEY, this.jTable6.getValueAt(k, 5), this.jTable6.getValueAt(k, 3), aguinaldo };
/* 1731 */           temp.insertRow(indice, nuevo);
/* 1732 */           this.jTable2.setSelectionMode(0);
/* 1733 */           this.jLabel11.setText("" + this.jTable2.getRowCount());
/*      */           
/* 1735 */           this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1736 */           this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1737 */           this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 1738 */           this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */           
/* 1740 */           this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1741 */           this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1742 */           this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 1743 */           this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 1744 */           sumas();
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1751 */     consultarAguinaldos();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 1755 */     consultarAguinaldos();
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 1759 */     int reg = this.jTable3.getSelectedRow();
/* 1760 */     if (reg < 0) {
/* 1761 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una lista para poder observar los datos", "Selecciona los datos", 0, this.ADVER);
/*      */     } else {
/* 1763 */       this.jRadioButton1.setEnabled(false);
/* 1764 */       this.jRadioButton2.setEnabled(false);
/* 1765 */       this.jButton5.setEnabled(false);
/* 1766 */       this.jButton7.setEnabled(false);
/* 1767 */       this.jComboBox4.setEnabled(false);
/* 1768 */       this.jButton4.setText("Imprimir");
/* 1769 */       this.jButton4.setToolTipText("Imprimir");
/* 1770 */       this.jButton4.setMnemonic('I');
/*      */       
/* 1772 */       verAguinaldo();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 1777 */     if (evt.getClickCount() == 2) {
/* 1778 */       this.jRadioButton1.setEnabled(false);
/* 1779 */       this.jRadioButton2.setEnabled(false);
/* 1780 */       this.jButton5.setEnabled(false);
/* 1781 */       this.jButton7.setEnabled(false);
/* 1782 */       this.jComboBox4.setEnabled(false);
/* 1783 */       this.jButton4.setText("Imprimir");
/* 1784 */       this.jButton4.setToolTipText("Imprimir");
/* 1785 */       this.jButton4.setMnemonic('I');
/* 1786 */       verAguinaldo();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 1791 */     String[] datos = { "FOLIO", "FECHA", "AÑO", "SUCURSAL", "TIPO", "NUM EMP", "TOTAL IMSS", "TOTAL COMP", "TOTAL", "ESTATUS", "DOCUMENTÓ" };
/* 1792 */     this.esc = new EscribirReporte("AGUINALDOS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 1796 */     int reg = this.jTable3.getSelectedRow();
/* 1797 */     if (reg < 0) {
/* 1798 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una lista para poder modificar los datos", "Selecciona los datos", 0, this.ADVER);
/*      */     } else {
/* 1800 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9));
/* 1801 */       if (!valor.equals("<Por Autorizar>")) {
/* 1802 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar estos datos ya que han sido autorizados con anterioridad", "Datos Autorizados", 0, this.ERROR);
/*      */       } else {
/* 1804 */         this.jRadioButton1.setEnabled(false);
/* 1805 */         this.jRadioButton2.setEnabled(false);
/* 1806 */         this.jButton5.setEnabled(true);
/* 1807 */         this.jButton7.setEnabled(true);
/* 1808 */         this.jComboBox4.setEnabled(false);
/* 1809 */         this.jButton4.setText("Modificar");
/* 1810 */         this.jButton4.setToolTipText("Modificar");
/* 1811 */         this.jButton4.setMnemonic('M');
/* 1812 */         verAguinaldo();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1818 */     if (this.jCheckBox1.isSelected()) {
/* 1819 */       ImprimirAguinaldos1 imprimir = new ImprimirAguinaldos1();
/* 1820 */       imprimir.recibeDatos();
/*      */     } 
/* 1822 */     if (this.jCheckBox2.isSelected()) {
/* 1823 */       ImprimirAguinaldos2 imprimir = new ImprimirAguinaldos2();
/* 1824 */       imprimir.recibeDatos();
/*      */     } 
/* 1826 */     if (this.jCheckBox3.isSelected()) {
/* 1827 */       if (this.jRadioButton1.isSelected()) {
/* 1828 */         this.IMSS = new String[this.jTable1.getRowCount()];
/* 1829 */         this.CURP = new String[this.jTable1.getRowCount()];
/* 1830 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1831 */           String[] datos = this.con.regresaReg("rfc,nss", "empleados", "where clave_emp=" + String.valueOf(this.jTable1.getValueAt(i, 0)), 2);
/* 1832 */           this.CURP[i] = datos[0];
/* 1833 */           this.IMSS[i] = datos[1];
/*      */         } 
/* 1835 */         ImprimirRecibos imprimir = new ImprimirRecibos();
/* 1836 */         imprimir.recibeDatos();
/*      */       } else {
/* 1838 */         this.INDICE = 0;
/* 1839 */         this.IMSS = new String[this.jTable2.getRowCount()];
/* 1840 */         this.CURP = new String[this.jTable2.getRowCount()];
/* 1841 */         for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 1842 */           String[] datos = this.con.regresaReg("rfc,nss", "operadores", "where num_ope=" + String.valueOf(this.jTable2.getValueAt(i, 0)), 2);
/* 1843 */           this.CURP[i] = datos[0];
/* 1844 */           this.IMSS[i] = datos[1];
/*      */         } 
/* 1846 */         ImprimirRecibos2 imprimir = new ImprimirRecibos2();
/* 1847 */         imprimir.recibeDatos();
/*      */       } 
/*      */     }
/*      */     
/* 1851 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 1855 */     int reg = this.jTable3.getSelectedRow();
/* 1856 */     if (reg < 0) {
/* 1857 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una lista para poder modificar los datos", "Selecciona los datos", 0, this.ADVER);
/*      */     } else {
/* 1859 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9));
/* 1860 */       if (!valor.equals("<Por Autorizar>")) {
/* 1861 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar estos datos ya que han sido autorizados con anterioridad", "Datos Autorizados", 0, this.ERROR);
/*      */       } else {
/* 1863 */         this.jDialog3.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 1869 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 1873 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 1877 */     int reg = this.jTable3.getSelectedRow();
/* 1878 */     if (reg < 0) {
/* 1879 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una lista para autorizar los datos", "Selecciona los datos", 0, this.ADVER);
/*      */     } else {
/* 1881 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9));
/* 1882 */       if (!valor.equals("<Por Autorizar>")) {
/* 1883 */         JOptionPane.showMessageDialog(this.padre, "No puedes autorizar estos datos ya que han sido autorizados con anterioridad", "Datos Autorizados", 0, this.ERROR);
/*      */       } else {
/* 1885 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas autorizar los datos?", "Autorizar los datos", 0, 3, this.PREG);
/* 1886 */         if (res == 0) {
/* 1887 */           String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1888 */           this.con.inserSinMsj("update aguinaldos set estatus ='<Autorizado>' where folio_agui='" + folio + "'");
/* 1889 */           consultarAguinaldos();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 1896 */     if (this.jCheckBox4.isSelected() == true) {
/* 1897 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1898 */         this.jTable6.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } else {
/* 1901 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1902 */         this.jTable6.setValueAt(Boolean.valueOf(false), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 1908 */     String motivo = this.jTextArea5.getText();
/* 1909 */     if (motivo.equals("")) {
/* 1910 */       this.jTextArea5.setBackground(Color.RED);
/* 1911 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas colocar el motivo por el cual se cancela el pago de aguinaldos", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 1913 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas cancelar el pago de aguinaldos que seleccionaste?", "Cancelar Aguinaldos", 0, 3, this.PREG);
/* 1914 */       if (res == 0) {
/* 1915 */         String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1916 */         this.con.inserSinMsj("update aguinaldos set estatus='<Cancelado: " + this.USUARIO + " " + cargarFechaHoy() + "-" + this.jTextArea5.getText().toUpperCase() + "' where folio_agui='" + num + "'");
/* 1917 */         consultarAguinaldos();
/* 1918 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 1924 */     Calendar ahoraCal = Calendar.getInstance();
/* 1925 */     ahoraCal.setTime(this.fecha);
/* 1926 */     String mesesito = "";
/* 1927 */     String hoy = "";
/* 1928 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1929 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 1931 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1932 */       mesesito = "0" + mesesito;
/*      */     }
/* 1934 */     if (ahoraCal.get(5) < 10) {
/* 1935 */       hoy = "0" + hoy;
/*      */     }
/* 1937 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void verAguinaldo() {
/* 1941 */     deshabilitar();
/*      */     
/* 1943 */     String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4));
/* 1944 */     String anual = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 1945 */     String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/*      */     
/* 1947 */     String fecha = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 1948 */     String fechaCorta = fecha.substring(0, 10);
/*      */     
/* 1950 */     String año = fechaCorta.substring(0, 4);
/* 1951 */     String mes = fechaCorta.substring(5, 7);
/* 1952 */     String dia = fechaCorta.substring(8, 10);
/* 1953 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1954 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 1955 */     Date fechaT = null;
/*      */     try {
/* 1957 */       fechaT = formatoDelTexto.parse(strFecha);
/* 1958 */       this.jDateChooser10.setDate(fechaT);
/* 1959 */     } catch (ParseException ex) {
/* 1960 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 1963 */     this.jComboBox4.setSelectedItem(anual);
/* 1964 */     this.jTextField6.setText(folio);
/*      */     
/* 1966 */     if (tipo.equals("ADMINISTRATIVO")) {
/* 1967 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 1968 */             .buscarDatos(8, "clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo", "aguinaldos_contenido", "where folio_agui = '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "' and tipo_lista=0 order by num"), (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */           {
/*      */             
/* 1971 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1976 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 1979 */       this.jLabel11.setText("" + this.jTable1.getRowCount());
/*      */       
/* 1981 */       this.jScrollPane1.setViewportView(this.jTable1);
/* 1982 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(50);
/* 1983 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 1984 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 1985 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 1986 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(110);
/* 1987 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
/* 1988 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/* 1989 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */       
/* 1991 */       this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1992 */       this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1993 */       this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 1994 */       this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */       
/* 1996 */       this.jTabbedPane1.removeAll();
/* 1997 */       this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1998 */       this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1999 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 2001 */       this.jTabbedPane1.removeAll();
/* 2002 */       this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 2003 */       this.jRadioButton2.setSelected(true);
/*      */     } 
/*      */     
/* 2006 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2007 */           .buscarDatos(8, "clave,nombre,fecha_ing,diasDerecho,diasLey,departamento,salario,aguinaldo", "aguinaldos_contenido", "where folio_agui = '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "' and tipo_lista=1 order by num"), (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */         {
/*      */           
/* 2010 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2015 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2018 */     this.jLabel11.setText("" + this.jTable2.getRowCount());
/* 2019 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 2020 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 2021 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2022 */     this.jTable2.getColumnModel().getColumn(2).setMinWidth(110);
/* 2023 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2024 */     this.jTable2.getColumnModel().getColumn(3).setMinWidth(110);
/* 2025 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(110);
/* 2026 */     this.jTable2.getColumnModel().getColumn(4).setMinWidth(80);
/* 2027 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     
/* 2029 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2030 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2031 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2032 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */     
/* 2034 */     sumas();
/* 2035 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void pasarEmpleado1() {
/* 2039 */     for (int k = 0; k < this.jTable6.getRowCount(); k++) {
/* 2040 */       boolean noEsta = false;
/* 2041 */       int indice = 0;
/* 2042 */       String val = String.valueOf(this.jTable6.getValueAt(k, 0));
/* 2043 */       if (val.equals("true")) {
/*      */         
/* 2045 */         String clave = String.valueOf(this.jTable6.getValueAt(k, 1));
/* 2046 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2047 */           String valor = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 2048 */           if (clave.equals(valor)) {
/* 2049 */             noEsta = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 2053 */         if (!noEsta) {
/* 2054 */           String nombre = String.valueOf(this.jTable6.getValueAt(k, 2));
/* 2055 */           Vector<String> miVector = new Vector<>(); int i;
/* 2056 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2057 */             miVector.add(String.valueOf(this.jTable2.getValueAt(i, 1)));
/*      */           }
/* 2059 */           miVector.add(nombre);
/* 2060 */           Collections.sort(miVector);
/*      */           
/* 2062 */           for (i = 0; i < miVector.size(); i++) {
/* 2063 */             if (((String)miVector.get(i)).equals(nombre)) {
/* 2064 */               indice = i;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/* 2069 */           String canti = String.valueOf(this.jTable6.getValueAt(k, 5));
/* 2070 */           String valorP = "";
/* 2071 */           for (int m = 0; m < canti.length(); m++) {
/* 2072 */             if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 2073 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 2076 */           double salarioReal = Double.parseDouble(valorP);
/* 2077 */           double diario = salarioReal / 7.0D;
/*      */           
/* 2079 */           canti = String.valueOf(this.jTable6.getValueAt(k, 4));
/* 2080 */           valorP = "";
/* 2081 */           for (int n = 0; n < canti.length(); n++) {
/* 2082 */             if (canti.charAt(n) != '$' && canti.charAt(n) != ',') {
/* 2083 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 2086 */           double salarioImss = Double.parseDouble(valorP);
/* 2087 */           double complemento = 0.0D;
/* 2088 */           complemento = diario - salarioImss;
/*      */           
/* 2090 */           this.cantidad.setValue(Double.valueOf(complemento));
/* 2091 */           String diarioL = this.cantidad.getText();
/* 2092 */           String aguinaldo = calcularAguinaldo(complemento, String.valueOf(this.jTable6.getValueAt(k, 3)));
/*      */           
/* 2094 */           if (this.jRadioButton1.isSelected()) {
/* 2095 */             DefaultTableModel defaultTableModel = (DefaultTableModel)this.jTable1.getModel();
/* 2096 */             Object[] arrayOfObject = { this.jTable6.getValueAt(k, 1), this.jTable6.getValueAt(k, 2), this.jTable6.getValueAt(k, 3), Double.valueOf(this.DIASDERECHO), this.DIASXLEY, this.jTable6.getValueAt(k, 6), diarioL, aguinaldo };
/* 2097 */             defaultTableModel.insertRow(indice, arrayOfObject);
/* 2098 */             this.jTable1.setSelectionMode(0);
/*      */           } 
/*      */           
/* 2101 */           aguinaldo = calcularAguinaldo(salarioImss, String.valueOf(this.jTable6.getValueAt(k, 3)));
/* 2102 */           DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 2103 */           Object[] nuevo = { this.jTable6.getValueAt(k, 1), this.jTable6.getValueAt(k, 2), this.jTable6.getValueAt(k, 3), Double.valueOf(this.DIASDERECHO), this.DIASXLEY, this.jTable6.getValueAt(k, 6), this.jTable6.getValueAt(k, 4), aguinaldo };
/* 2104 */           temp.insertRow(indice, nuevo);
/* 2105 */           this.jTable2.setSelectionMode(0);
/* 2106 */           this.jLabel11.setText("" + this.jTable2.getRowCount());
/*      */           
/* 2108 */           this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2109 */           this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2110 */           this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2111 */           this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */           
/* 2113 */           this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2114 */           this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2115 */           this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2116 */           this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 2117 */           sumas();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pasarEmpleado2() {
/* 2124 */     for (int k = 0; k < this.jTable6.getRowCount(); k++) {
/* 2125 */       boolean noEsta = false;
/* 2126 */       int indice = 0;
/* 2127 */       String val = String.valueOf(this.jTable6.getValueAt(k, 0));
/* 2128 */       if (val.equals("true")) {
/*      */         
/* 2130 */         String clave = String.valueOf(this.jTable6.getValueAt(k, 1));
/* 2131 */         for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 2132 */           String valor = String.valueOf(this.jTable2.getValueAt(j, 0));
/* 2133 */           System.out.println("claves " + clave + " " + valor);
/* 2134 */           if (clave.equals(valor)) {
/* 2135 */             noEsta = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 2139 */         if (!noEsta) {
/* 2140 */           String nombre = String.valueOf(this.jTable6.getValueAt(k, 2));
/* 2141 */           Vector<String> miVector = new Vector<>(); int i;
/* 2142 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2143 */             miVector.add(String.valueOf(this.jTable2.getValueAt(i, 1)));
/*      */           }
/* 2145 */           miVector.add(nombre);
/* 2146 */           Collections.sort(miVector);
/*      */           
/* 2148 */           for (i = 0; i < miVector.size(); i++) {
/* 2149 */             if (((String)miVector.get(i)).equals(nombre)) {
/* 2150 */               indice = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2164 */           String canti = String.valueOf(this.jTable6.getValueAt(k, 4));
/* 2165 */           String valorP = "";
/* 2166 */           for (int m = 0; m < canti.length(); m++) {
/* 2167 */             if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 2168 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 2171 */           double salarioImss = Double.parseDouble(valorP);
/* 2172 */           double complemento = 0.0D;
/* 2173 */           complemento = salarioImss;
/*      */           
/* 2175 */           this.cantidad.setValue(Double.valueOf(complemento));
/* 2176 */           String diarioL = this.cantidad.getText();
/* 2177 */           String aguinaldo = calcularAguinaldo(complemento, String.valueOf(this.jTable6.getValueAt(k, 3)));
/*      */           
/* 2179 */           DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 2180 */           Object[] nuevo = { this.jTable6.getValueAt(k, 1), this.jTable6.getValueAt(k, 2), this.jTable6.getValueAt(k, 3), Double.valueOf(this.DIASDERECHO), this.DIASXLEY, "OPERADOR", this.jTable6.getValueAt(k, 4), aguinaldo };
/* 2181 */           temp.insertRow(indice, nuevo);
/* 2182 */           this.jTable2.setSelectionMode(0);
/* 2183 */           this.jLabel11.setText("" + this.jTable2.getRowCount());
/*      */           
/* 2185 */           this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2186 */           this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2187 */           this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2188 */           this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */           
/* 2190 */           this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2191 */           this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2192 */           this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2193 */           this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 2194 */           sumas();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
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
/*      */   public String calcularAguinaldo(double cantidad, String fecha) {
/* 2272 */     String aguinaldo = "";
/* 2273 */     String fechita = fecha.substring(0, 4);
/* 2274 */     String fechaCompleta = fecha;
/* 2275 */     String anual = String.valueOf(this.jComboBox4.getSelectedItem());
/*      */     
/* 2277 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2278 */     if (fechita.equals(anual)) {
/* 2279 */       String año = fechaCompleta.substring(0, 4);
/* 2280 */       String mes = fechaCompleta.substring(5, 7);
/* 2281 */       String dia = fechaCompleta.substring(8, 10);
/* 2282 */       String strFecha = dia + "-" + dia + "-" + mes;
/*      */       
/* 2284 */       double totalDias = cantidad * 15.0D;
/* 2285 */       int dias = 0;
/*      */       
/*      */       try {
/* 2288 */         Date fechaR = formatoDelTexto.parse(strFecha);
/* 2289 */         Date fechaD = formatoDelTexto.parse("31-12-" + año);
/*      */         
/* 2291 */         long fechaInicialMs = fechaR.getTime();
/* 2292 */         long fechaFinalMs = fechaD.getTime();
/* 2293 */         long diferencia = fechaFinalMs - fechaInicialMs;
/* 2294 */         dias = (int)Math.floor((diferencia / 86400000L));
/* 2295 */         this.DIASDERECHO = dias;
/* 2296 */         if (Integer.parseInt(año) % 4 != 0) {
/* 2297 */           this.DIASDERECHO++;
/*      */         }
/* 2299 */       } catch (ParseException ex) {
/* 2300 */         ex.printStackTrace();
/*      */       } 
/* 2302 */       double valorxDia = this.DIASDERECHO * 0.0411D;
/* 2303 */       double cantA = valorxDia * cantidad;
/* 2304 */       double calc = redondear(valorxDia).doubleValue();
/* 2305 */       this.DIASXLEY = "" + calc;
/*      */       
/* 2307 */       this.cantidad.setValue(Double.valueOf(cantA));
/* 2308 */       aguinaldo = this.cantidad.getText();
/*      */     } else {
/* 2310 */       double totalDias = cantidad * 15.0D;
/* 2311 */       this.cantidad.setValue(Double.valueOf(totalDias));
/* 2312 */       this.DIASDERECHO = 365.0D;
/* 2313 */       this.DIASXLEY = "15.00";
/* 2314 */       aguinaldo = this.cantidad.getText();
/*      */     } 
/* 2316 */     return aguinaldo;
/*      */   }
/*      */   
/*      */   public Double redondear(double pasar) {
/* 2320 */     return Double.valueOf(Math.rint(pasar * 100.0D) / 100.0D);
/*      */   }
/*      */   
/*      */   public void sumas() {
/* 2324 */     double aguinaldo1 = 0.0D;
/* 2325 */     double aguinaldo2 = 0.0D;
/* 2326 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2327 */       if (this.jTable1.getRowCount() > 0) {
/* 2328 */         String str1 = String.valueOf(this.jTable1.getValueAt(i, 7));
/* 2329 */         String str2 = "";
/* 2330 */         for (int k = 0; k < str1.length(); k++) {
/* 2331 */           if (str1.charAt(k) != '$' && str1.charAt(k) != ',') {
/* 2332 */             str2 = str2 + str2;
/*      */           }
/*      */         } 
/* 2335 */         aguinaldo1 += Double.parseDouble(str2);
/*      */       } 
/*      */       
/* 2338 */       String canti = String.valueOf(this.jTable2.getValueAt(i, 7));
/* 2339 */       String valorP = "";
/* 2340 */       for (int j = 0; j < canti.length(); j++) {
/* 2341 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2342 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2345 */       aguinaldo2 += Double.parseDouble(valorP);
/*      */     } 
/* 2347 */     this.cantidad.setValue(Double.valueOf(aguinaldo1));
/* 2348 */     this.jLabel14.setText(this.cantidad.getText());
/* 2349 */     this.cantidad.setValue(Double.valueOf(aguinaldo2));
/* 2350 */     this.jLabel18.setText(this.cantidad.getText());
/* 2351 */     double total = aguinaldo1 + aguinaldo2;
/* 2352 */     this.cantidad.setValue(Double.valueOf(total));
/* 2353 */     this.jLabel13.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 2357 */     this.jRadioButton1.setSelected(true);
/* 2358 */     this.jDateChooser10.setDate(new Date());
/* 2359 */     this.jLabel13.setText("$0.00");
/* 2360 */     this.jLabel14.setText("$0.00");
/* 2361 */     this.jLabel18.setText("$0.00");
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCombos() {
/* 2366 */     String[] datos = this.con.regresaColIndex("nombre", "departamentos", "order by nombre");
/* 2367 */     this.jComboBox6.removeAllItems();
/* 2368 */     this.jComboBox6.addItem("<GENERAL>");
/* 2369 */     for (int i = 0; i < datos.length; i++) {
/* 2370 */       this.jComboBox6.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void calcularAnual() {
/* 2375 */     int año = this.fechaActual.getYear();
/* 2376 */     año += 1900;
/* 2377 */     this.jComboBox4.removeAllItems();
/* 2378 */     this.jComboBox2.removeAllItems();
/* 2379 */     this.jComboBox2.addItem("<GENERAL>");
/* 2380 */     for (int i = año; i >= 2010; i--) {
/* 2381 */       this.jComboBox4.addItem("" + i);
/* 2382 */       this.jComboBox2.addItem("" + i);
/*      */     } 
/* 2384 */     this.jComboBox4.setSelectedIndex(0);
/*      */     
/* 2386 */     String[] datos = this.con.regresaColIndex("nombre_usu", "usuarios", "order by nombre_usu");
/* 2387 */     this.jComboBox3.removeAllItems();
/* 2388 */     this.jComboBox3.addItem("<GENERAL>");
/* 2389 */     for (int j = 0; j < datos.length; j++) {
/* 2390 */       this.jComboBox3.addItem(datos[j]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultarAguinaldos() {
/* 2395 */     String estatus = "";
/* 2396 */     String año = "";
/* 2397 */     String usuario = "";
/*      */     
/* 2399 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 2400 */       estatus = " estatus like '%<Por Autorizar%' || estatus like '%<Autorizado%'";
/* 2401 */     } else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 2402 */       estatus = " estatus like '%%'";
/* 2403 */     } else if (this.jComboBox1.getSelectedIndex() == 2) {
/* 2404 */       estatus = " estatus like '%<Por Autorizar%'";
/* 2405 */     } else if (this.jComboBox1.getSelectedIndex() == 3) {
/* 2406 */       estatus = " estatus like '%<Autorizado%'";
/* 2407 */     } else if (this.jComboBox1.getSelectedIndex() == 4) {
/* 2408 */       estatus = " estatus like '%<Cancelado%'";
/*      */     } 
/*      */     
/* 2411 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 2412 */       año = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 2414 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 2415 */       usuario = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2420 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 2421 */           .buscarDatos(11, "folio_agui,fecha,anual,sucursal,tipo,numEmp,totalImss,totalComp,total,estatus,usuario", "aguinaldos", "where folio_agui like '%" + this.jTextField1.getText() + "%' and anual like '%" + año + "%' and usuario like '%" + usuario + "%' and (" + estatus + ") order by num desc"), (Object[])new String[] { "Folio", "Fecha", "Año", "Sucursal", "Tipo", "Empleados", "Total Imss", "Total Comp", "Total", "Estatus", "Documento" })
/*      */         {
/*      */ 
/*      */           
/* 2425 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2430 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2433 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2438 */     this.celda2.pasarInd3(this.con.revisarCol(this.jTable3, "<Por Autorizar>", 0, 9, 0));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2443 */     this.celda2.pasarInd4(this.con.revisarCol(this.jTable3, "<Autorizado>", 0, 9, 0));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2448 */     this.celda2.pasarInd5(this.con.revisarCol(this.jTable3, "<Cancelado", 0, 9, 0));
/*      */     
/* 2450 */     this.jTable3.setSelectionMode(0);
/* 2451 */     this.jTable3.setAutoCreateRowSorter(true);
/* 2452 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 2454 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 2455 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2456 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 2457 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(120);
/* 2458 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(80);
/* 2459 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(80);
/*      */     
/* 2461 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(100);
/* 2462 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(100);
/* 2463 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(100);
/* 2464 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(100);
/* 2465 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(100);
/* 2466 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(100);
/*      */     
/* 2468 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2469 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2470 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2471 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 2472 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 2473 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 2474 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 2475 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 2476 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 2477 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 2478 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/*      */   }
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar1() {
/* 2533 */     this.jComboBox4.setSelectedItem(Boolean.valueOf(false));
/* 2534 */     String num_ope = this.jTextField9.getText();
/* 2535 */     String tipo = "";
/* 2536 */     String depa = "";
/*      */     
/* 2538 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 2539 */       tipo = "empleado";
/* 2540 */     } else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 2541 */       tipo = "funcionario";
/*      */     } else {
/* 2543 */       tipo = "";
/*      */     } 
/*      */     
/* 2546 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 2547 */       depa = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2552 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 2553 */           .buscarDatos(8, "clave_emp,ap_pat,ap_mat,empleados.nombre,Ultimoingreso,salarioImss,salarioReal,departamentos.nombre", "departamentos,empleados", "where empleados.clave_depa=departamentos.clave_depa and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and actual=0 and clave_emp<>0 order by empleados.ap_pat, empleados.ap_mat"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Salario IMSS", "Salario Real", "Departamento", "" })
/*      */         {
/*      */           
/* 2556 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2561 */             return this.canEdit[columnIndex];
/*      */           }
/* 2563 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2568 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 2571 */     this.jLabel17.setText("" + this.jTable6.getRowCount());
/* 2572 */     eliminarColumna1(2, 1, "Paterno");
/* 2573 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 2575 */     this.jTable6.setShowVerticalLines(false);
/* 2576 */     this.jScrollPane6.setViewportView(this.jTable6);
/* 2577 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 2578 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 2580 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 2581 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2582 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 2583 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 2584 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(110);
/* 2585 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(110);
/*      */     
/* 2587 */     this.jTable6.getColumnModel().getColumn(6).setPreferredWidth(40);
/* 2588 */     this.jTable6.getColumnModel().getColumn(6).setMaxWidth(40);
/*      */     
/* 2590 */     this.jTable6.getColumnModel().moveColumn(6, 0);
/* 2591 */     this.jTable6.setSelectionMode(0);
/*      */     
/* 2593 */     this.jTable6.setAutoCreateRowSorter(true);
/* 2594 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */ 
/*      */     
/* 2597 */     this.jTable6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2598 */     this.jTable6.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 2602 */     this.jComboBox4.setSelectedItem(Boolean.valueOf(false));
/* 2603 */     String num_ope = this.jTextField9.getText();
/* 2604 */     String tipo = "";
/*      */     
/* 2606 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 2607 */       tipo = "operador";
/* 2608 */     } else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 2609 */       tipo = "funcionario";
/*      */     } else {
/* 2611 */       tipo = "";
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2616 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 2617 */           .buscarDatos(6, "num_ope,ap_pat,ap_mat,nombre,UltimaFechaIngreso,salarioImssLetra", "operadores", "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and tipoTrabajador like '%" + tipo + "%' and actual=0 and num_ope<>0 order by ap_pat"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Salario IMSS", "" })
/*      */         {
/*      */           
/* 2620 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2625 */             return this.canEdit[columnIndex];
/*      */           }
/* 2627 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 2632 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 2635 */     this.jLabel17.setText("" + this.jTable6.getRowCount());
/* 2636 */     eliminarColumna1(2, 1, "Paterno");
/* 2637 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 2639 */     this.jTable6.setShowVerticalLines(false);
/* 2640 */     this.jScrollPane6.setViewportView(this.jTable6);
/* 2641 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 2642 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/* 2643 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 2644 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2645 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 2646 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 2647 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(40);
/* 2648 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(40);
/*      */     
/* 2650 */     this.jTable6.getColumnModel().moveColumn(4, 0);
/*      */     
/* 2652 */     this.jTable6.setSelectionMode(0);
/* 2653 */     this.jTable6.setAutoCreateRowSorter(true);
/* 2654 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void eliminarColumna1(int origen, int destino, String nombreCol) {
/* 2660 */     int cont = this.jTable6.getRowCount();
/* 2661 */     String[] registros = new String[cont]; int i;
/* 2662 */     for (i = 0; i < cont; i++) {
/* 2663 */       registros[i] = this.jTable6.getValueAt(i, destino).toString();
/*      */     }
/* 2665 */     for (i = 0; i < cont; i++) {
/* 2666 */       registros[i] = registros[i] + " " + registros[i];
/* 2667 */       this.jTable6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 2669 */     TableColumn columna = this.jTable6.getColumn(nombreCol);
/* 2670 */     this.jTable6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void deshabilitar() {
/* 2674 */     this.jLabel11.setText("0");
/* 2675 */     this.jLabel18.setText("$0.00");
/* 2676 */     this.jLabel13.setText("$0.00");
/* 2677 */     this.jLabel14.setText("$0.00");
/*      */     
/* 2679 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2685 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2690 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2693 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 2694 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(50);
/* 2695 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2696 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 2697 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2698 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(110);
/* 2699 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
/* 2700 */     this.jTable1.getColumnModel().getColumn(4).setMinWidth(80);
/* 2701 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     
/* 2703 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2704 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2705 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2706 */     this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */     
/* 2708 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 2709 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Ingreso", "Días Laborados", "Días x Ley", "Departamento", "Salario", "Aguinaldo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2715 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2720 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2723 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 2724 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/* 2725 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2726 */     this.jTable2.getColumnModel().getColumn(2).setMinWidth(110);
/* 2727 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2728 */     this.jTable2.getColumnModel().getColumn(3).setMinWidth(110);
/* 2729 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(110);
/* 2730 */     this.jTable2.getColumnModel().getColumn(4).setMinWidth(80);
/* 2731 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(80);
/*      */     
/* 2733 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2734 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2735 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2736 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 2740 */     this.con.consultar("max(num)", "aguinaldos", "");
/* 2741 */     String mayor = this.con.Campo;
/* 2742 */     int MAYOR = 0;
/*      */     try {
/* 2744 */       MAYOR = Integer.parseInt(mayor);
/* 2745 */     } catch (NumberFormatException e) {
/* 2746 */       MAYOR = 0;
/*      */     } 
/* 2748 */     MAYOR++;
/* 2749 */     if (MAYOR < 10) {
/* 2750 */       this.jTextField6.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/* 2751 */     } else if (MAYOR < 100) {
/* 2752 */       this.jTextField6.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/* 2753 */     } else if (MAYOR < 1000) {
/* 2754 */       this.jTextField6.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/* 2755 */     } else if (MAYOR < 10000) {
/* 2756 */       this.jTextField6.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/* 2758 */       this.jTextField6.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 2763 */     int quitar = 3 * letras;
/* 2764 */     x -= quitar;
/* 2765 */     return x;
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2771 */       setEnabled((table == null || table.isEnabled()));
/* 2772 */       setHorizontalAlignment(4);
/* 2773 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2774 */       return this;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4;
/*      */     String[] indices5;
/*      */     
/*      */     public CeldaRender2() {
/* 2780 */       this.otro = -1;
/* 2781 */       this.indices = new String[0];
/* 2782 */       this.indices2 = new String[0];
/* 2783 */       this.indices3 = new String[0];
/* 2784 */       this.indices4 = new String[0];
/* 2785 */       this.indices5 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2788 */       setEnabled((table == null || table.isEnabled()));
/* 2789 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 2790 */       if (comparar2(comp)) {
/* 2791 */         setBackground(new Color(153, 102, 0));
/* 2792 */         setForeground(Color.WHITE);
/* 2793 */       } else if (comparar3(comp)) {
/* 2794 */         setBackground(new Color(102, 153, 255));
/* 2795 */         setForeground(Color.BLUE);
/* 2796 */       } else if (comparar5(comp)) {
/* 2797 */         setBackground(Color.RED);
/* 2798 */         setForeground(Color.WHITE);
/*      */       } else {
/* 2800 */         setBackground((Color)null);
/* 2801 */         setForeground(Color.black);
/*      */       } 
/* 2803 */       if (column == 2 || column == 5 || column == 6 || column == 7 || column == 8) {
/* 2804 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2806 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 2809 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2810 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 2814 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 2818 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 2822 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 2826 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 2830 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 2834 */       for (int i = 0; i < this.indices.length; i++) {
/* 2835 */         if (this.indices[i].equals(reg)) {
/* 2836 */           return true;
/*      */         }
/*      */       } 
/* 2839 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 2843 */       for (int i = 0; i < this.indices2.length; i++) {
/* 2844 */         if (this.indices2[i].equals(reg)) {
/* 2845 */           return true;
/*      */         }
/*      */       } 
/* 2848 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 2852 */       for (int i = 0; i < this.indices3.length; i++) {
/* 2853 */         if (this.indices3[i].equals(reg)) {
/* 2854 */           return true;
/*      */         }
/*      */       } 
/* 2857 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 2861 */       for (int i = 0; i < this.indices4.length; i++) {
/* 2862 */         if (this.indices4[i].equals(reg)) {
/* 2863 */           return true;
/*      */         }
/*      */       } 
/* 2866 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 2870 */       for (int i = 0; i < this.indices5.length; i++) {
/* 2871 */         if (this.indices5[i].equals(reg)) {
/* 2872 */           return true;
/*      */         }
/*      */       } 
/* 2875 */       return false;
/*      */     } }
/*      */   public class ImprimirAguinaldos1 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirAguinaldos1() {
/* 2883 */       this.g2 = null;
/* 2884 */       this.Pag = 0;
/*      */       
/* 2886 */       this.linesPerPage = 50;
/* 2887 */       this.orientacion = 0;
/* 2888 */       this.X = 0.0D;
/* 2889 */       this.Y = 0.0D;
/* 2890 */       this.YINICIA = 75;
/* 2891 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 2892 */       this.NumLineas = 0;
/* 2893 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 2896 */       if (this.textLines == null) {
/* 2897 */         int numLines = Aguinaldos.this.jTable1.getRowCount();
/* 2898 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 2903 */       Font font = new Font("Serif", 0, 8);
/* 2904 */       FontMetrics metrics = g.getFontMetrics(font);
/* 2905 */       int lineHeight = metrics.getHeight();
/* 2906 */       if (this.pageBreaks == null) {
/* 2907 */         initTextLines();
/* 2908 */         this.orientacion = pf.getOrientation();
/* 2909 */         if (pf.getOrientation() == 1) {
/* 2910 */           this.linesPerPage = 53;
/* 2911 */           this.X = pf.getWidth();
/* 2912 */           this.Y = pf.getHeight();
/*      */         } else {
/* 2914 */           this.linesPerPage = 38;
/* 2915 */           this.X = pf.getWidth();
/* 2916 */           this.Y = pf.getHeight();
/*      */         } 
/* 2918 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 2919 */         this.Pag = this.numBreaks;
/* 2920 */         this.pageBreaks = new int[this.numBreaks];
/* 2921 */         for (int b = 0; b < this.numBreaks; b++) {
/* 2922 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 2925 */       if (pageIndex > this.pageBreaks.length) {
/* 2926 */         return 1;
/*      */       }
/* 2928 */       Graphics2D g2d = (Graphics2D)g;
/* 2929 */       this.g2 = g;
/* 2930 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 2931 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 2932 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 2933 */       encabezado();
/* 2934 */       int y = this.YINICIA;
/* 2935 */       int lineas = 0;
/*      */       
/* 2937 */       this.g2.drawRect(25, 60, 550, 12);
/* 2938 */       this.g2.setColor(new Color(204, 0, 0));
/* 2939 */       this.g2.fillRect(25, 61, 550, 10);
/*      */       
/* 2941 */       Font fuente = new Font("Dialog", 0, 7);
/* 2942 */       this.g2.setFont(fuente);
/* 2943 */       this.g2.setColor(Color.WHITE);
/* 2944 */       int[] valores = { 29, 70, 225, 275, 320, 380, 445, 505 };
/* 2945 */       this.g2.drawString("CLAVE", valores[0], 69);
/* 2946 */       this.g2.drawString("NOMBRE COMPLETO", valores[1], 69);
/* 2947 */       this.g2.drawString("INGRESO", valores[2], 69);
/* 2948 */       this.g2.drawString("DÍAS LAB", valores[3], 69);
/* 2949 */       this.g2.drawString("DÍAS X LEY", valores[4], 69);
/* 2950 */       this.g2.drawString("DEPARTAMENTO", valores[5], 69);
/* 2951 */       this.g2.drawString("SALARIO D", valores[6] + 20, 69);
/* 2952 */       this.g2.drawString("AGUINALDO", valores[7] + 20, 69);
/*      */       
/* 2954 */       this.g2.setColor(Color.BLACK);
/* 2955 */       y = 70;
/* 2956 */       for (int line = start; line < end; line++) {
/* 2957 */         y += 12;
/*      */         
/* 2959 */         String valor = "";
/* 2960 */         if (line < 9) {
/* 2961 */           valor = "0" + line + 1;
/*      */         } else {
/* 2963 */           valor = "" + line + 1;
/*      */         } 
/* 2965 */         fuente = new Font("Dialog", 1, 7);
/* 2966 */         this.g2.setFont(fuente);
/* 2967 */         this.g2.drawString(valor, Aguinaldos.this.alinearDer(20, valor.length()), y - 2);
/*      */         
/* 2969 */         fuente = new Font("Dialog", 0, 6);
/* 2970 */         this.g2.setFont(fuente);
/*      */         
/* 2972 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 0)), Aguinaldos.this.alinearDer(valores[0] + 20, Aguinaldos.this.jTable1.getValueAt(line, 0).toString().length()), y - 2);
/* 2973 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 1)), valores[1], y - 2);
/* 2974 */         String fecha = String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 2));
/* 2975 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 2976 */         this.g2.drawString(col, valores[2], y - 2);
/* 2977 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 3)), Aguinaldos.this.alinearDer(valores[3] + 20, Aguinaldos.this.jTable1.getValueAt(line, 3).toString().length()), y - 2);
/* 2978 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 4)), Aguinaldos.this.alinearDer(valores[4] + 25, Aguinaldos.this.jTable1.getValueAt(line, 4).toString().length()), y - 2);
/* 2979 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 5)), valores[5], y - 2);
/* 2980 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 6)), Aguinaldos.this.alinearDer(valores[6] + 50, Aguinaldos.this.jTable1.getValueAt(line, 6).toString().length()), y - 2);
/* 2981 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(line, 7)), Aguinaldos.this.alinearDer(valores[7] + 57, Aguinaldos.this.jTable1.getValueAt(line, 7).toString().length()), y - 2);
/*      */       } 
/*      */       
/* 2984 */       g.drawString("Página " + pageIndex + 1, 540, 755);
/* 2985 */       if (this.Pag == pageIndex) {
/* 2986 */         this.g2.drawLine(510, y, 580, y);
/*      */         
/* 2988 */         fuente = new Font("Dialog", 1, 7);
/* 2989 */         this.g2.setFont(fuente);
/* 2990 */         this.g2.drawString(Aguinaldos.this.jLabel14.getText(), Aguinaldos.this.alinearDer(valores[7] + 55, Aguinaldos.this.jLabel14.getText().length()), y + 10);
/*      */         
/* 2992 */         fuente = new Font("Dialog", 1, 7);
/* 2993 */         this.g2.setFont(fuente);
/* 2994 */         this.g2.drawString("ELABORÓ", 290, 720);
/* 2995 */         this.g2.drawString("_____________________________________", 240, 752);
/* 2996 */         this.g2.drawString("NOMBRE Y FIRMA", 278, 765);
/*      */       } 
/* 2998 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 3002 */       Font fuente = new Font("Dialog", 0, 8);
/* 3003 */       this.g2.setFont(fuente);
/* 3004 */       this.g2.setColor(Color.BLACK);
/* 3005 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3006 */       Image img = imagen.getImage();
/* 3007 */       this.g2.drawImage(img, 542, 1, 35, 35, null);
/*      */       
/* 3009 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 3010 */       img = imagen.getImage();
/* 3011 */       this.g2.drawImage(img, 27, 8, 40, 30, null);
/*      */       
/* 3013 */       fuente = new Font("Times New Roman", 1, 16);
/* 3014 */       this.g2.setFont(fuente);
/* 3015 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */ 
/*      */       
/* 3018 */       fuente = new Font("Dialog", 0, 12);
/* 3019 */       this.g2.setFont(fuente);
/* 3020 */       this.g2.drawString("AGUINALDOS - COMPLEMENTO", 220, 37);
/* 3021 */       this.g2.drawLine(25, 52, 575, 52);
/*      */       
/* 3023 */       fuente = new Font("Dialog", 1, 7);
/* 3024 */       this.g2.setFont(fuente);
/* 3025 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 3027 */       this.g2.drawString("Folio: ", 25, 50);
/* 3028 */       this.g2.drawString("Tipo: ", 140, 50);
/* 3029 */       this.g2.drawString("Año: ", 285, 50);
/* 3030 */       this.g2.drawString("Base: ", 372, 50);
/* 3031 */       this.g2.drawString("Fecha: ", 512, 50);
/*      */       
/* 3033 */       fuente = new Font("Dialog", 0, 7);
/* 3034 */       this.g2.setFont(fuente);
/*      */       
/* 3036 */       String tipo = "ADMINISTRATIVOS";
/* 3037 */       if (!Aguinaldos.this.jRadioButton1.isSelected()) {
/* 3038 */         tipo = "OPERADORES";
/*      */       }
/* 3040 */       this.g2.drawString(Aguinaldos.this.jTextField6.getText(), 50, 50);
/* 3041 */       this.g2.drawString(tipo, 160, 50);
/* 3042 */       this.g2.drawString(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()), 305, 50);
/*      */       
/* 3044 */       Date fecha1 = new Date();
/* 3045 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3046 */       String cadenaFecha = "";
/* 3047 */       cadenaFecha = formato.format(fecha1);
/* 3048 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3049 */       String MES = cadenaFecha.substring(4, 6);
/* 3050 */       String DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 3052 */       this.g2.drawString(Aguinaldos.this.SUCURSAL, 410, 50);
/* 3053 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 540, 50);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 3057 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 3058 */       job.setPrintable(this);
/*      */       
/* 3060 */       PageFormat pf = job.defaultPage();
/* 3061 */       Paper papel = pf.getPaper();
/* 3062 */       papel.setSize(612.0D, 792.0D);
/* 3063 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 3064 */       pf.setPaper(papel);
/* 3065 */       pf.setOrientation(1);
/* 3066 */       job.setPrintable(new ImprimirAguinaldos1(), pf);
/* 3067 */       job.defaultPage(pf);
/*      */       
/* 3069 */       boolean ok = job.printDialog();
/* 3070 */       if (ok)
/*      */         try {
/* 3072 */           job.print();
/* 3073 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirAguinaldos2 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirAguinaldos2() {
/* 3083 */       this.g2 = null;
/* 3084 */       this.Pag = 0;
/*      */       
/* 3086 */       this.linesPerPage = 50;
/* 3087 */       this.orientacion = 0;
/* 3088 */       this.X = 0.0D;
/* 3089 */       this.Y = 0.0D;
/* 3090 */       this.YINICIA = 75;
/* 3091 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 3092 */       this.NumLineas = 0;
/* 3093 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 3096 */       if (this.textLines == null) {
/* 3097 */         int numLines = Aguinaldos.this.jTable2.getRowCount();
/* 3098 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 3103 */       Font font = new Font("Serif", 0, 8);
/* 3104 */       FontMetrics metrics = g.getFontMetrics(font);
/* 3105 */       int lineHeight = metrics.getHeight();
/* 3106 */       if (this.pageBreaks == null) {
/* 3107 */         initTextLines();
/* 3108 */         this.orientacion = pf.getOrientation();
/* 3109 */         if (pf.getOrientation() == 1) {
/* 3110 */           this.linesPerPage = 53;
/* 3111 */           this.X = pf.getWidth();
/* 3112 */           this.Y = pf.getHeight();
/*      */         } else {
/* 3114 */           this.linesPerPage = 38;
/* 3115 */           this.X = pf.getWidth();
/* 3116 */           this.Y = pf.getHeight();
/*      */         } 
/* 3118 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 3119 */         this.Pag = this.numBreaks;
/* 3120 */         this.pageBreaks = new int[this.numBreaks];
/* 3121 */         for (int b = 0; b < this.numBreaks; b++) {
/* 3122 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 3125 */       if (pageIndex > this.pageBreaks.length) {
/* 3126 */         return 1;
/*      */       }
/* 3128 */       Graphics2D g2d = (Graphics2D)g;
/* 3129 */       this.g2 = g;
/* 3130 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 3131 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 3132 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 3133 */       encabezado();
/* 3134 */       int y = this.YINICIA;
/* 3135 */       int lineas = 0;
/*      */       
/* 3137 */       this.g2.drawRect(25, 60, 550, 12);
/* 3138 */       this.g2.setColor(new Color(204, 0, 0));
/* 3139 */       this.g2.fillRect(25, 61, 550, 10);
/*      */       
/* 3141 */       Font fuente = new Font("Dialog", 0, 7);
/* 3142 */       this.g2.setFont(fuente);
/* 3143 */       this.g2.setColor(Color.WHITE);
/* 3144 */       int[] valores = { 29, 70, 225, 275, 320, 380, 445, 505 };
/* 3145 */       this.g2.drawString("CLAVE", valores[0], 69);
/* 3146 */       this.g2.drawString("NOMBRE COMPLETO", valores[1], 69);
/* 3147 */       this.g2.drawString("INGRESO", valores[2], 69);
/* 3148 */       this.g2.drawString("DÍAS LAB", valores[3], 69);
/* 3149 */       this.g2.drawString("DÍAS X LEY", valores[4], 69);
/* 3150 */       this.g2.drawString("DEPARTAMENTO", valores[5], 69);
/* 3151 */       this.g2.drawString("SALARIO D", valores[6] + 20, 69);
/* 3152 */       this.g2.drawString("AGUINALDO", valores[7] + 20, 69);
/*      */       
/* 3154 */       this.g2.setColor(Color.BLACK);
/* 3155 */       y = 70;
/* 3156 */       for (int line = start; line < end; line++) {
/* 3157 */         y += 12;
/*      */         
/* 3159 */         String valor = "";
/* 3160 */         if (line < 9) {
/* 3161 */           valor = "0" + line + 1;
/*      */         } else {
/* 3163 */           valor = "" + line + 1;
/*      */         } 
/* 3165 */         fuente = new Font("Dialog", 1, 7);
/* 3166 */         this.g2.setFont(fuente);
/* 3167 */         this.g2.drawString(valor, Aguinaldos.this.alinearDer(20, valor.length()), y - 2);
/*      */         
/* 3169 */         fuente = new Font("Dialog", 0, 6);
/* 3170 */         this.g2.setFont(fuente);
/*      */         
/* 3172 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 0)), Aguinaldos.this.alinearDer(valores[0] + 20, Aguinaldos.this.jTable2.getValueAt(line, 0).toString().length()), y - 2);
/* 3173 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 1)), valores[1], y - 2);
/* 3174 */         String fecha = String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 2));
/* 3175 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3176 */         this.g2.drawString(col, valores[2], y - 2);
/* 3177 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 3)), Aguinaldos.this.alinearDer(valores[3] + 20, Aguinaldos.this.jTable2.getValueAt(line, 3).toString().length()), y - 2);
/* 3178 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 4)), Aguinaldos.this.alinearDer(valores[4] + 25, Aguinaldos.this.jTable2.getValueAt(line, 4).toString().length()), y - 2);
/* 3179 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 5)), valores[5], y - 2);
/* 3180 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 6)), Aguinaldos.this.alinearDer(valores[6] + 50, Aguinaldos.this.jTable2.getValueAt(line, 6).toString().length()), y - 2);
/* 3181 */         this.g2.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(line, 7)), Aguinaldos.this.alinearDer(valores[7] + 57, Aguinaldos.this.jTable2.getValueAt(line, 7).toString().length()), y - 2);
/*      */       } 
/*      */       
/* 3184 */       g.drawString("Página " + pageIndex + 1, 540, 755);
/* 3185 */       if (this.Pag == pageIndex) {
/* 3186 */         this.g2.drawLine(510, y, 580, y);
/*      */         
/* 3188 */         fuente = new Font("Dialog", 1, 7);
/* 3189 */         this.g2.setFont(fuente);
/* 3190 */         this.g2.drawString(Aguinaldos.this.jLabel18.getText(), Aguinaldos.this.alinearDer(valores[7] + 55, Aguinaldos.this.jLabel18.getText().length()), y + 10);
/*      */         
/* 3192 */         fuente = new Font("Dialog", 1, 7);
/* 3193 */         this.g2.setFont(fuente);
/* 3194 */         this.g2.drawString("ELABORÓ", 290, 720);
/* 3195 */         this.g2.drawString("_____________________________________", 240, 752);
/* 3196 */         this.g2.drawString("NOMBRE Y FIRMA", 278, 765);
/*      */       } 
/* 3198 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 3202 */       Font fuente = new Font("Dialog", 0, 8);
/* 3203 */       this.g2.setFont(fuente);
/* 3204 */       this.g2.setColor(Color.BLACK);
/* 3205 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3206 */       Image img = imagen.getImage();
/* 3207 */       this.g2.drawImage(img, 542, 1, 35, 35, null);
/*      */       
/* 3209 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 3210 */       img = imagen.getImage();
/* 3211 */       this.g2.drawImage(img, 27, 8, 40, 30, null);
/*      */       
/* 3213 */       fuente = new Font("Times New Roman", 1, 16);
/* 3214 */       this.g2.setFont(fuente);
/* 3215 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */       
/* 3217 */       fuente = new Font("Dialog", 0, 12);
/* 3218 */       this.g2.setFont(fuente);
/* 3219 */       this.g2.drawString("AGUINALDOS", 255, 37);
/* 3220 */       this.g2.drawLine(25, 52, 575, 52);
/*      */       
/* 3222 */       fuente = new Font("Dialog", 1, 7);
/* 3223 */       this.g2.setFont(fuente);
/* 3224 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 3226 */       this.g2.drawString("Folio: ", 25, 50);
/* 3227 */       this.g2.drawString("Tipo: ", 140, 50);
/* 3228 */       this.g2.drawString("Año: ", 285, 50);
/* 3229 */       this.g2.drawString("Base: ", 372, 50);
/* 3230 */       this.g2.drawString("Fecha: ", 512, 50);
/*      */       
/* 3232 */       fuente = new Font("Dialog", 0, 7);
/* 3233 */       this.g2.setFont(fuente);
/*      */       
/* 3235 */       String tipo = "ADMINISTRATIVOS";
/* 3236 */       if (!Aguinaldos.this.jRadioButton1.isSelected()) {
/* 3237 */         tipo = "OPERADORES";
/*      */       }
/* 3239 */       this.g2.drawString(Aguinaldos.this.jTextField6.getText(), 50, 50);
/* 3240 */       this.g2.drawString(tipo, 160, 50);
/* 3241 */       this.g2.drawString(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()), 305, 50);
/*      */       
/* 3243 */       Date fecha1 = new Date();
/* 3244 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3245 */       String cadenaFecha = "";
/* 3246 */       cadenaFecha = formato.format(fecha1);
/* 3247 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3248 */       String MES = cadenaFecha.substring(4, 6);
/* 3249 */       String DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 3251 */       this.g2.drawString(Aguinaldos.this.SUCURSAL, 410, 50);
/* 3252 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 540, 50);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 3256 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 3257 */       job.setPrintable(this);
/*      */       
/* 3259 */       PageFormat pf = job.defaultPage();
/* 3260 */       Paper papel = pf.getPaper();
/* 3261 */       papel.setSize(612.0D, 792.0D);
/* 3262 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 3263 */       pf.setPaper(papel);
/* 3264 */       pf.setOrientation(1);
/* 3265 */       job.setPrintable(new ImprimirAguinaldos2(), pf);
/* 3266 */       job.defaultPage(pf);
/*      */       
/* 3268 */       boolean ok = job.printDialog();
/* 3269 */       if (ok)
/*      */         try {
/* 3271 */           job.print();
/* 3272 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirRecibos implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirRecibos() {
/* 3282 */       this.g2 = null;
/* 3283 */       this.Pag = 0;
/*      */       
/* 3285 */       this.linesPerPage = 50;
/* 3286 */       this.orientacion = 0;
/* 3287 */       this.X = 0.0D;
/* 3288 */       this.Y = 0.0D;
/* 3289 */       this.YINICIA = 75;
/* 3290 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 3291 */       this.NumLineas = 0;
/* 3292 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 3295 */       if (this.textLines == null) {
/* 3296 */         int numLines = Integer.parseInt(Aguinaldos.this.jLabel11.getText());
/* 3297 */         numLines *= 38;
/* 3298 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public void sub1() {
/* 3303 */       Font fuente = new Font("Dialog", 0, 7);
/* 3304 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void sub2() {
/* 3308 */       Font fuente = new Font("Dialog", 1, 7);
/* 3309 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 3313 */       Font font = new Font("Serif", 0, 8);
/* 3314 */       FontMetrics metrics = g.getFontMetrics(font);
/* 3315 */       int lineHeight = metrics.getHeight();
/* 3316 */       if (this.pageBreaks == null) {
/* 3317 */         initTextLines();
/* 3318 */         this.orientacion = pf.getOrientation();
/* 3319 */         if (pf.getOrientation() == 1) {
/* 3320 */           this.linesPerPage = 38;
/* 3321 */           this.X = pf.getWidth();
/* 3322 */           this.Y = pf.getHeight();
/*      */         } else {
/* 3324 */           this.linesPerPage = 38;
/* 3325 */           this.X = pf.getWidth();
/* 3326 */           this.Y = pf.getHeight();
/*      */         } 
/* 3328 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 3329 */         this.Pag = this.numBreaks;
/* 3330 */         this.pageBreaks = new int[this.numBreaks];
/* 3331 */         for (int b = 0; b < this.numBreaks; b++) {
/* 3332 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 3335 */       if (pageIndex > this.pageBreaks.length) {
/* 3336 */         return 1;
/*      */       }
/* 3338 */       Graphics2D g2d = (Graphics2D)g;
/* 3339 */       this.g2 = g;
/* 3340 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 3341 */       int INDICE = pageIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3346 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3347 */       Image img = imagen.getImage();
/* 3348 */       this.g2.drawImage(img, 165, 17, 42, 42, null);
/*      */       
/* 3350 */       Font fuente = new Font("Dialog", 1, 12);
/* 3351 */       this.g2.setFont(fuente);
/*      */       
/* 3353 */       g.drawString("FLETES Y MATERIALES", 215, 27);
/* 3354 */       g.drawString("FORSIS, S.A. DE C.V.", 225, 40);
/* 3355 */       this.g2.drawRoundRect(20, 17, 130, 40, 15, 15);
/* 3356 */       this.g2.drawLine(21, 30, 150, 30);
/*      */       
/* 3358 */       sub1();
/* 3359 */       g.drawString("DESDE                   HASTA", 37, 26);
/* 3360 */       String fecha = String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 2));
/* 3361 */       String impAño = "";
/* 3362 */       int añoSelec = Integer.parseInt(fecha.substring(0, 4));
/* 3363 */       int añoCombo = Integer.parseInt(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()));
/* 3364 */       String col = "";
/* 3365 */       if (añoSelec < añoCombo) {
/* 3366 */         impAño = String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem());
/* 3367 */         col = "01/01/" + impAño;
/*      */       } else {
/* 3369 */         impAño = fecha.substring(0, 4);
/* 3370 */         col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*      */       } 
/* 3372 */       sub2();
/* 3373 */       g.drawString(col + "             31/12/" + col, 32, 45);
/*      */ 
/*      */       
/* 3376 */       sub1();
/* 3377 */       this.g2.drawRoundRect(20, 75, 335, 75, 15, 15);
/* 3378 */       g.drawString("NOMBRE", 25, 85);
/* 3379 */       g.drawString("DOMICILIO", 25, 100);
/* 3380 */       g.drawString("CIUDAD", 25, 115);
/* 3381 */       g.drawString("BASE", 25, 130);
/* 3382 */       g.drawString("TELÉFONO", 25, 145);
/*      */       
/* 3384 */       sub2();
/* 3385 */       g.drawString("FLETES Y MATERIALES FORSIS, S.A. DE C.V.", 90, 85);
/* 3386 */       g.drawString("AUTOPISTA MONTERREY-CADEREYTA 32.5, C.P. 67450", 90, 100);
/* 3387 */       g.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 90, 115);
/* 3388 */       g.drawString(Aguinaldos.this.SUCURSAL, 90, 130);
/* 3389 */       g.drawString("(01-782) 825 6455 AL 58", 90, 145);
/*      */       
/* 3391 */       sub1();
/* 3392 */       this.g2.drawRoundRect(20, 165, 335, 45, 15, 15);
/* 3393 */       g.drawString("CLAVE EMP", 25, 175);
/* 3394 */       g.drawString("NÚM IMSS", 25, 190);
/* 3395 */       g.drawString("SALARIO D", 25, 205);
/*      */       
/* 3397 */       sub2();
/* 3398 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 0)), 70, 175);
/* 3399 */       g.drawString(Aguinaldos.this.IMSS[INDICE], 70, 190);
/* 3400 */       g.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 6)), 70, 205);
/*      */       
/* 3402 */       sub1();
/* 3403 */       g.drawString("NOMBRE", 125, 175);
/* 3404 */       g.drawString("CURP", 125, 190);
/* 3405 */       g.drawString("CATEGORÍA", 125, 205);
/*      */       
/* 3407 */       sub2();
/* 3408 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 1)), 180, 175);
/* 3409 */       g.drawString(Aguinaldos.this.CURP[INDICE], 180, 190);
/* 3410 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 5)), 180, 205);
/*      */       
/* 3412 */       fuente = new Font("Dialog", 1, 10);
/* 3413 */       this.g2.setFont(fuente);
/* 3414 */       g.drawString("DESGLOSE DE PERCEPCIONES", 115, 230);
/*      */       
/* 3416 */       this.g2.drawRoundRect(20, 235, 335, 200, 15, 15);
/* 3417 */       this.g2.drawLine(21, 247, 355, 247);
/* 3418 */       this.g2.drawLine(21, 400, 355, 400);
/*      */       
/* 3420 */       sub1();
/* 3421 */       g.drawString("       DÍAS LABORADOS                DÍAS POR LEY                SALARIO                    AGUINALDO", 25, 244);
/*      */       
/* 3423 */       sub2();
/* 3424 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 3)), 60, 260);
/* 3425 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 4)), 145, 260);
/* 3426 */       g.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 6)), 215, 260);
/* 3427 */       g.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 7)), 285, 260);
/*      */       
/* 3429 */       sub1();
/* 3430 */       g.drawString("       TOTAL CON LETRA                                                                                                    TOTAL ", 25, 408);
/*      */       
/* 3432 */       sub2();
/* 3433 */       String canti = String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 7));
/* 3434 */       String valorP = "";
/* 3435 */       for (int j = 0; j < canti.length(); j++) {
/* 3436 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3437 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3441 */       double vp = Double.parseDouble(valorP);
/* 3442 */       Aguinaldos.this.numLetra = new NumerosALetras(vp, "M.N.");
/*      */       
/* 3444 */       g.drawString(String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 7)), 290, 430);
/* 3445 */       g.drawString(Aguinaldos.this.numLetra.regresaNumero(), 25, 430);
/*      */       
/* 3447 */       this.g2.drawRoundRect(20, 450, 335, 45, 15, 15);
/* 3448 */       sub2();
/* 3449 */       g.drawString("                  FIRMA                                                                                                        HUELLAS", 25, 490);
/*      */       
/* 3451 */       fuente = new Font("Dialog", 0, 6);
/* 3452 */       this.g2.setFont(fuente);
/* 3453 */       g.drawString("       Recibí de FLETES Y MATERIALES FORSIS, S.A. DE C.V., la cantidad mencionada por concepto a mis alcances", 25, 508);
/* 3454 */       g.drawString("     económicos derivados a mi aguinaldo correspondiente al periodo " + String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()) + ", éste recibo especifica en la inteligencia que", 25, 518);
/* 3455 */       g.drawString("    estoy conforme en la relación aquí contenida y por ende en el pago que se me hace sin que a la fecha se me adeude", 25, 528);
/* 3456 */       g.drawString("                                                                cantidad alguna por el mismo concepto.", 25, 538);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3461 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3462 */       img = imagen.getImage();
/* 3463 */       this.g2.drawImage(img, 565, 17, 42, 42, null);
/*      */       
/* 3465 */       fuente = new Font("Dialog", 1, 12);
/* 3466 */       this.g2.setFont(fuente);
/*      */       
/* 3468 */       g.drawString("FLETES Y MATERIALES", 615, 27);
/* 3469 */       g.drawString("FORSIS, S.A. DE C.V.", 625, 40);
/* 3470 */       this.g2.drawRoundRect(420, 17, 130, 40, 15, 15);
/* 3471 */       this.g2.drawLine(420, 30, 550, 30);
/*      */       
/* 3473 */       sub1();
/* 3474 */       g.drawString("DESDE                   HASTA", 437, 26);
/*      */       
/* 3476 */       fecha = String.valueOf(Aguinaldos.this.jTable1.getValueAt(INDICE, 2));
/* 3477 */       impAño = "";
/* 3478 */       añoSelec = Integer.parseInt(fecha.substring(0, 4));
/* 3479 */       añoCombo = Integer.parseInt(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()));
/* 3480 */       col = "";
/* 3481 */       if (añoSelec < añoCombo) {
/* 3482 */         impAño = String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem());
/* 3483 */         col = "01/01/" + impAño;
/*      */       } else {
/* 3485 */         impAño = fecha.substring(0, 4);
/* 3486 */         col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*      */       } 
/* 3488 */       sub2();
/* 3489 */       g.drawString(col + "             31/12/" + col, 432, 45);
/*      */       
/* 3491 */       sub1();
/* 3492 */       this.g2.drawRoundRect(420, 75, 335, 75, 15, 15);
/* 3493 */       g.drawString("NOMBRE", 425, 85);
/* 3494 */       g.drawString("DOMICILIO", 425, 100);
/* 3495 */       g.drawString("CIUDAD", 425, 115);
/* 3496 */       g.drawString("BASE", 425, 130);
/* 3497 */       g.drawString("TELÉFONO", 425, 145);
/*      */       
/* 3499 */       sub2();
/* 3500 */       g.drawString("FLETES Y MATERIALES FORSIS, S.A. DE C.V.", 490, 85);
/* 3501 */       g.drawString("AUTOPISTA MONTERREY-CADEREYTA 32.5, C.P. 67450", 490, 100);
/* 3502 */       g.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 490, 115);
/* 3503 */       g.drawString(Aguinaldos.this.SUCURSAL, 490, 130);
/* 3504 */       g.drawString("(01-782) 825 6455 AL 58", 490, 145);
/*      */       
/* 3506 */       sub1();
/* 3507 */       this.g2.drawRoundRect(420, 165, 335, 45, 15, 15);
/* 3508 */       g.drawString("CLAVE EMP", 425, 175);
/* 3509 */       g.drawString("NÚM IMSS", 425, 190);
/* 3510 */       g.drawString("SALARIO D", 425, 205);
/*      */       
/* 3512 */       sub2();
/* 3513 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 0)), 470, 175);
/* 3514 */       g.drawString(Aguinaldos.this.IMSS[INDICE], 470, 190);
/* 3515 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 6)), 470, 205);
/*      */       
/* 3517 */       sub1();
/* 3518 */       g.drawString("NOMBRE", 525, 175);
/* 3519 */       g.drawString("CURP", 525, 190);
/* 3520 */       g.drawString("CATEGORÍA", 525, 205);
/*      */       
/* 3522 */       sub2();
/* 3523 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 1)), 580, 175);
/* 3524 */       g.drawString(Aguinaldos.this.CURP[INDICE], 580, 190);
/* 3525 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 5)), 580, 205);
/*      */       
/* 3527 */       fuente = new Font("Dialog", 1, 10);
/* 3528 */       this.g2.setFont(fuente);
/* 3529 */       g.drawString("DESGLOSE DE PERCEPCIONES", 515, 230);
/*      */       
/* 3531 */       this.g2.drawRoundRect(420, 235, 335, 200, 15, 15);
/* 3532 */       this.g2.drawLine(421, 247, 755, 247);
/* 3533 */       this.g2.drawLine(421, 400, 755, 400);
/* 3534 */       sub1();
/* 3535 */       g.drawString("       DÍAS LABORADOS                DÍAS POR LEY                SALARIO                    AGUINALDO", 425, 244);
/*      */       
/* 3537 */       sub2();
/* 3538 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 3)), 460, 260);
/* 3539 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 4)), 545, 260);
/* 3540 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 6)), 615, 260);
/* 3541 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 7)), 685, 260);
/*      */       
/* 3543 */       sub1();
/* 3544 */       g.drawString("       TOTAL CON LETRA                                                                                                    TOTAL ", 425, 408);
/*      */       
/* 3546 */       canti = String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 7));
/* 3547 */       valorP = "";
/* 3548 */       for (int i = 0; i < canti.length(); i++) {
/* 3549 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 3550 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3554 */       vp = Double.parseDouble(valorP);
/* 3555 */       Aguinaldos.this.numLetra = new NumerosALetras(vp, "M.N.");
/*      */       
/* 3557 */       sub2();
/* 3558 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(INDICE, 7)), 690, 430);
/* 3559 */       g.drawString(Aguinaldos.this.numLetra.regresaNumero(), 425, 430);
/*      */       
/* 3561 */       this.g2.drawRoundRect(420, 450, 335, 45, 15, 15);
/* 3562 */       sub2();
/* 3563 */       g.drawString("                  FIRMA                                                                                                        HUELLAS", 425, 490);
/*      */       
/* 3565 */       fuente = new Font("Dialog", 0, 6);
/* 3566 */       this.g2.setFont(fuente);
/* 3567 */       g.drawString("       Recibí de FLETES Y MATERIALES FORSIS, S.A. DE C.V., la cantidad mencionada por concepto a mis alcances", 425, 508);
/* 3568 */       g.drawString("     económicos derivados a mi aguinaldo correspondiente al periodo " + String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()) + ", éste recibo especifica en la inteligencia que", 425, 518);
/* 3569 */       g.drawString("    estoy conforme en la relación aquí contenida y por ende en el pago que se me hace sin que a la fecha se me adeude", 425, 528);
/* 3570 */       g.drawString("                                                                cantidad alguna por el mismo concepto.", 425, 538);
/*      */       
/* 3572 */       g.drawString("COMPLEMENTO", 25, 548);
/* 3573 */       g.drawString("Página " + pageIndex + 1, 25, 575);
/* 3574 */       return 0;
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 3578 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 3579 */       job.setPrintable(this);
/*      */       
/* 3581 */       PageFormat pf = job.defaultPage();
/* 3582 */       Paper papel = pf.getPaper();
/* 3583 */       papel.setSize(612.0D, 792.0D);
/* 3584 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 3585 */       pf.setPaper(papel);
/* 3586 */       pf.setOrientation(0);
/* 3587 */       job.setPrintable(new ImprimirRecibos(), pf);
/* 3588 */       job.defaultPage(pf);
/*      */       
/* 3590 */       boolean ok = job.printDialog();
/* 3591 */       if (ok)
/*      */         try {
/* 3593 */           job.print();
/* 3594 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirRecibos2 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirRecibos2() {
/* 3604 */       this.g2 = null;
/* 3605 */       this.Pag = 0;
/*      */       
/* 3607 */       this.linesPerPage = 50;
/* 3608 */       this.orientacion = 0;
/* 3609 */       this.X = 0.0D;
/* 3610 */       this.Y = 0.0D;
/* 3611 */       this.YINICIA = 75;
/* 3612 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 3613 */       this.NumLineas = 0;
/* 3614 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 3617 */       if (this.textLines == null) {
/* 3618 */         Aguinaldos.this.INDICE = 0;
/* 3619 */         int numLines = Integer.parseInt(Aguinaldos.this.jLabel11.getText());
/* 3620 */         numLines *= 38;
/* 3621 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public void sub1() {
/* 3626 */       Font fuente = new Font("Dialog", 0, 7);
/* 3627 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public void sub2() {
/* 3631 */       Font fuente = new Font("Dialog", 1, 7);
/* 3632 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 3636 */       Font font = new Font("Serif", 0, 8);
/* 3637 */       FontMetrics metrics = g.getFontMetrics(font);
/* 3638 */       int lineHeight = metrics.getHeight();
/* 3639 */       if (this.pageBreaks == null) {
/* 3640 */         initTextLines();
/* 3641 */         this.orientacion = pf.getOrientation();
/* 3642 */         if (pf.getOrientation() == 1) {
/* 3643 */           this.linesPerPage = 19;
/* 3644 */           this.X = pf.getWidth();
/* 3645 */           this.Y = pf.getHeight();
/*      */         } else {
/* 3647 */           this.linesPerPage = 76;
/* 3648 */           this.X = pf.getWidth();
/* 3649 */           this.Y = pf.getHeight();
/*      */         } 
/* 3651 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 3652 */         this.Pag = this.numBreaks;
/* 3653 */         this.pageBreaks = new int[this.numBreaks];
/* 3654 */         for (int b = 0; b < this.numBreaks; b++) {
/* 3655 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 3658 */       if (pageIndex > this.pageBreaks.length) {
/* 3659 */         return 1;
/*      */       }
/* 3661 */       Graphics2D g2d = (Graphics2D)g;
/* 3662 */       this.g2 = g;
/* 3663 */       g2d.translate(pf.getImageableX(), 10.0D);
/*      */       
/* 3665 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3666 */       Image img = imagen.getImage();
/* 3667 */       this.g2.drawImage(img, 165, 17, 42, 42, null);
/*      */       
/* 3669 */       Font fuente = new Font("Dialog", 1, 12);
/* 3670 */       this.g2.setFont(fuente);
/*      */       
/* 3672 */       g.drawString("FLETES Y MATERIALES", 215, 27);
/* 3673 */       g.drawString("FORSIS, S.A. DE C.V.", 225, 40);
/* 3674 */       this.g2.drawRoundRect(20, 17, 130, 40, 15, 15);
/* 3675 */       this.g2.drawLine(21, 30, 150, 30);
/*      */       
/* 3677 */       Aguinaldos.this.INDICE = pageIndex * 2;
/*      */       
/* 3679 */       sub1();
/* 3680 */       g.drawString("DESDE                   HASTA", 37, 26);
/* 3681 */       String fecha = String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 2));
/* 3682 */       String impAño = "";
/* 3683 */       int añoSelec = Integer.parseInt(fecha.substring(0, 4));
/* 3684 */       int añoCombo = Integer.parseInt(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()));
/* 3685 */       String col = "";
/* 3686 */       if (añoSelec < añoCombo) {
/* 3687 */         impAño = String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem());
/* 3688 */         col = "01/01/" + impAño;
/*      */       } else {
/* 3690 */         impAño = fecha.substring(0, 4);
/* 3691 */         col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*      */       } 
/* 3693 */       sub2();
/* 3694 */       g.drawString(col + "             31/12/" + col, 32, 45);
/*      */ 
/*      */       
/* 3697 */       sub1();
/* 3698 */       this.g2.drawRoundRect(20, 75, 335, 75, 15, 15);
/* 3699 */       g.drawString("NOMBRE", 25, 85);
/* 3700 */       g.drawString("DOMICILIO", 25, 100);
/* 3701 */       g.drawString("CIUDAD", 25, 115);
/* 3702 */       g.drawString("BASE", 25, 130);
/* 3703 */       g.drawString("TELÉFONO", 25, 145);
/*      */       
/* 3705 */       sub2();
/* 3706 */       g.drawString("FLETES Y MATERIALES FORSIS, S.A. DE C.V.", 90, 85);
/* 3707 */       g.drawString("AUTOPISTA MONTERREY-CADEREYTA 32.5, C.P. 67450", 90, 100);
/* 3708 */       g.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 90, 115);
/* 3709 */       g.drawString(Aguinaldos.this.SUC, 90, 130);
/* 3710 */       g.drawString("(01-782) 825 6455 AL 58", 90, 145);
/*      */       
/* 3712 */       sub1();
/* 3713 */       this.g2.drawRoundRect(20, 165, 335, 45, 15, 15);
/* 3714 */       g.drawString("CLAVE EMP", 25, 175);
/* 3715 */       g.drawString("NÚM IMSS", 25, 190);
/* 3716 */       g.drawString("SALARIO D", 25, 205);
/*      */       
/* 3718 */       sub2();
/* 3719 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 0)), 70, 175);
/* 3720 */       g.drawString(Aguinaldos.this.IMSS[Aguinaldos.this.INDICE], 70, 190);
/* 3721 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 6)), 70, 205);
/*      */       
/* 3723 */       sub1();
/* 3724 */       g.drawString("NOMBRE", 125, 175);
/* 3725 */       g.drawString("CURP", 125, 190);
/* 3726 */       g.drawString("CATEGORÍA", 125, 205);
/*      */       
/* 3728 */       sub2();
/* 3729 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 1)), 180, 175);
/* 3730 */       g.drawString(Aguinaldos.this.CURP[Aguinaldos.this.INDICE], 180, 190);
/* 3731 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 5)), 180, 205);
/*      */       
/* 3733 */       fuente = new Font("Dialog", 1, 10);
/* 3734 */       this.g2.setFont(fuente);
/* 3735 */       g.drawString("DESGLOSE DE PERCEPCIONES", 115, 230);
/*      */       
/* 3737 */       this.g2.drawRoundRect(20, 235, 335, 200, 15, 15);
/* 3738 */       this.g2.drawLine(21, 247, 355, 247);
/* 3739 */       this.g2.drawLine(21, 400, 355, 400);
/*      */       
/* 3741 */       sub1();
/* 3742 */       g.drawString("       DÍAS LABORADOS                DÍAS POR LEY                SALARIO                    AGUINALDO", 25, 244);
/*      */       
/* 3744 */       sub2();
/* 3745 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 3)), 60, 260);
/* 3746 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 4)), 145, 260);
/* 3747 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 6)), 215, 260);
/* 3748 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 7)), 285, 260);
/*      */       
/* 3750 */       sub1();
/* 3751 */       g.drawString("       TOTAL CON LETRA                                                                                                    TOTAL ", 25, 408);
/*      */       
/* 3753 */       sub2();
/* 3754 */       String canti = String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 7));
/* 3755 */       String valorP = "";
/* 3756 */       for (int j = 0; j < canti.length(); j++) {
/* 3757 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3758 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3762 */       double vp = Double.parseDouble(valorP);
/* 3763 */       Aguinaldos.this.numLetra = new NumerosALetras(vp, "M.N.");
/*      */       
/* 3765 */       g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(Aguinaldos.this.INDICE, 7)), 290, 430);
/* 3766 */       g.drawString(Aguinaldos.this.numLetra.regresaNumero(), 25, 430);
/*      */       
/* 3768 */       this.g2.drawRoundRect(20, 450, 335, 45, 15, 15);
/* 3769 */       sub2();
/* 3770 */       g.drawString("                  FIRMA                                                                                                        HUELLAS", 25, 490);
/*      */       
/* 3772 */       fuente = new Font("Dialog", 0, 6);
/* 3773 */       this.g2.setFont(fuente);
/* 3774 */       g.drawString("       Recibí de FLETES Y MATERIALES FORSIS, S.A. DE C.V., la cantidad mencionada por concepto a mis alcances", 25, 508);
/* 3775 */       g.drawString("     económicos derivados a mi aguinaldo correspondiente al periodo " + String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()) + ", éste recibo especifica en la inteligencia que", 25, 518);
/* 3776 */       g.drawString("    estoy conforme en la relación aquí contenida y por ende en el pago que se me hace sin que a la fecha se me adeude", 25, 528);
/* 3777 */       g.drawString("                                                                cantidad alguna por el mismo concepto.", 25, 538);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3782 */       int CONT = Aguinaldos.this.INDICE + 1;
/* 3783 */       if (CONT < Aguinaldos.this.jTable2.getRowCount()) {
/*      */         
/* 3785 */         imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3786 */         img = imagen.getImage();
/* 3787 */         this.g2.drawImage(img, 565, 17, 42, 42, null);
/*      */         
/* 3789 */         fuente = new Font("Dialog", 1, 12);
/* 3790 */         this.g2.setFont(fuente);
/*      */         
/* 3792 */         g.drawString("FLETES Y MATERIALES", 615, 27);
/* 3793 */         g.drawString("FORSIS, S.A. DE C.V.", 625, 40);
/* 3794 */         this.g2.drawRoundRect(420, 17, 130, 40, 15, 15);
/* 3795 */         this.g2.drawLine(420, 30, 550, 30);
/*      */         
/* 3797 */         sub1();
/* 3798 */         g.drawString("DESDE                   HASTA", 437, 26);
/*      */         
/* 3800 */         fecha = String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 2));
/* 3801 */         impAño = "";
/* 3802 */         añoSelec = Integer.parseInt(fecha.substring(0, 4));
/* 3803 */         añoCombo = Integer.parseInt(String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()));
/* 3804 */         col = "";
/* 3805 */         if (añoSelec < añoCombo) {
/* 3806 */           impAño = String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem());
/* 3807 */           col = "01/01/" + impAño;
/*      */         } else {
/* 3809 */           impAño = fecha.substring(0, 4);
/* 3810 */           col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*      */         } 
/* 3812 */         sub2();
/* 3813 */         g.drawString(col + "             31/12/" + col, 432, 45);
/*      */         
/* 3815 */         sub1();
/* 3816 */         this.g2.drawRoundRect(420, 75, 335, 75, 15, 15);
/* 3817 */         g.drawString("NOMBRE", 425, 85);
/* 3818 */         g.drawString("DOMICILIO", 425, 100);
/* 3819 */         g.drawString("CIUDAD", 425, 115);
/* 3820 */         g.drawString("BASE", 425, 130);
/* 3821 */         g.drawString("TELÉFONO", 425, 145);
/*      */         
/* 3823 */         sub2();
/* 3824 */         g.drawString("FLETES Y MATERIALES FORSIS, S.A. DE C.V.", 490, 85);
/* 3825 */         g.drawString("AUTOPISTA MONTERREY-CADEREYTA 32.5, C.P. 67450", 490, 100);
/* 3826 */         g.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 490, 115);
/* 3827 */         g.drawString(Aguinaldos.this.SUC, 490, 130);
/* 3828 */         g.drawString("(01-782) 825 6455 AL 58", 490, 145);
/*      */         
/* 3830 */         sub1();
/* 3831 */         this.g2.drawRoundRect(420, 165, 335, 45, 15, 15);
/* 3832 */         g.drawString("CLAVE EMP", 425, 175);
/* 3833 */         g.drawString("NÚM IMSS", 425, 190);
/* 3834 */         g.drawString("SALARIO D", 425, 205);
/*      */         
/* 3836 */         sub2();
/* 3837 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 0)), 470, 175);
/* 3838 */         g.drawString(Aguinaldos.this.IMSS[CONT], 470, 190);
/* 3839 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 6)), 470, 205);
/*      */         
/* 3841 */         sub1();
/* 3842 */         g.drawString("NOMBRE", 525, 175);
/* 3843 */         g.drawString("CURP", 525, 190);
/* 3844 */         g.drawString("CATEGORÍA", 525, 205);
/*      */         
/* 3846 */         sub2();
/* 3847 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 1)), 580, 175);
/* 3848 */         g.drawString(Aguinaldos.this.CURP[CONT], 580, 190);
/* 3849 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 5)), 580, 205);
/*      */         
/* 3851 */         fuente = new Font("Dialog", 1, 10);
/* 3852 */         this.g2.setFont(fuente);
/* 3853 */         g.drawString("DESGLOSE DE PERCEPCIONES", 515, 230);
/*      */         
/* 3855 */         this.g2.drawRoundRect(420, 235, 335, 200, 15, 15);
/* 3856 */         this.g2.drawLine(421, 247, 755, 247);
/* 3857 */         this.g2.drawLine(421, 400, 755, 400);
/* 3858 */         sub1();
/* 3859 */         g.drawString("       DÍAS LABORADOS                DÍAS POR LEY                SALARIO                    AGUINALDO", 425, 244);
/*      */         
/* 3861 */         sub2();
/* 3862 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 3)), 460, 260);
/* 3863 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 4)), 545, 260);
/* 3864 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 6)), 615, 260);
/* 3865 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 7)), 685, 260);
/*      */         
/* 3867 */         sub1();
/* 3868 */         g.drawString("       TOTAL CON LETRA                                                                                                    TOTAL ", 425, 408);
/*      */         
/* 3870 */         canti = String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 7));
/* 3871 */         valorP = "";
/* 3872 */         for (int i = 0; i < canti.length(); i++) {
/* 3873 */           if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 3874 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/*      */         
/* 3878 */         vp = Double.parseDouble(valorP);
/* 3879 */         Aguinaldos.this.numLetra = new NumerosALetras(vp, "M.N.");
/*      */         
/* 3881 */         sub2();
/* 3882 */         g.drawString(String.valueOf(Aguinaldos.this.jTable2.getValueAt(CONT, 7)), 690, 430);
/* 3883 */         g.drawString(Aguinaldos.this.numLetra.regresaNumero(), 425, 430);
/*      */         
/* 3885 */         this.g2.drawRoundRect(420, 450, 335, 45, 15, 15);
/* 3886 */         sub2();
/* 3887 */         g.drawString("                  FIRMA                                                                                                        HUELLAS", 425, 490);
/*      */         
/* 3889 */         fuente = new Font("Dialog", 0, 6);
/* 3890 */         this.g2.setFont(fuente);
/* 3891 */         g.drawString("       Recibí de FLETES Y MATERIALES FORSIS, S.A. DE C.V., la cantidad mencionada por concepto a mis alcances", 425, 508);
/* 3892 */         g.drawString("     económicos derivados a mi aguinaldo correspondiente al periodo " + String.valueOf(Aguinaldos.this.jComboBox4.getSelectedItem()) + ", éste recibo especifica en la inteligencia que", 425, 518);
/* 3893 */         g.drawString("    estoy conforme en la relación aquí contenida y por ende en el pago que se me hace sin que a la fecha se me adeude", 425, 528);
/* 3894 */         g.drawString("                                                                cantidad alguna por el mismo concepto.", 425, 538);
/*      */         
/* 3896 */         g.drawString("Página " + pageIndex + 1, 25, 575);
/*      */       } 
/* 3898 */       return 0;
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 3902 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 3903 */       job.setPrintable(this);
/*      */       
/* 3905 */       PageFormat pf = job.defaultPage();
/* 3906 */       Paper papel = pf.getPaper();
/* 3907 */       papel.setSize(612.0D, 792.0D);
/* 3908 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 3909 */       pf.setPaper(papel);
/* 3910 */       pf.setOrientation(0);
/* 3911 */       job.setPrintable(new ImprimirRecibos2(), pf);
/* 3912 */       job.defaultPage(pf);
/*      */       
/* 3914 */       boolean ok = job.printDialog();
/* 3915 */       if (ok)
/*      */         try {
/* 3917 */           job.print();
/* 3918 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Aguinaldos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */