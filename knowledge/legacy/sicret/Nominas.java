/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.Vector;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerListModel;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ 
/*      */ public class Nominas extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   43 */   Date fechaActual = new Date();
/*   44 */   Date fechaInicio = null;
/*   45 */   Date fecha = new Date();
/*   46 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   47 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   48 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   49 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   50 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   51 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   52 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   53 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   54 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   55 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   56 */   JFrame padre = null;
/*   57 */   JTabbedPane fichas = null;
/*   58 */   String[] CLAVES = null;
/*   59 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   61 */   DefaultTableModel modelo = new DefaultTableModel();
/*   62 */   CeldaRender celda = new CeldaRender();
/*   63 */   CeldaRender2 celda2 = new CeldaRender2(); EscribirReporte esc; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox4; private JComboBox jComboBox11; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox8; private JDateChooser jDateChooser12; private JDateChooser jDateChooser13; private JDateChooser jDateChooser14; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4;
/*   64 */   String DIRECTIVA = ""; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFrame jFrame1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40;
/*      */   private JLabel jLabel41;
/*      */   
/*      */   public Nominas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   68 */     String año = "2010";
/*   69 */     String mes = "10";
/*   70 */     String dia = "10";
/*   71 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   72 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   74 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   75 */     } catch (ParseException ex) {
/*   76 */       ex.printStackTrace();
/*      */     } 
/*   78 */     this.padre = padre;
/*   79 */     fichas = fichas;
/*   80 */     initComponents();
/*   81 */     this.USUARIO = USUARIO;
/*   82 */     panelito.setViewportView(this);
/*   83 */     this.panel = panelito;
/*   84 */     colorear();
/*      */     
/*   86 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   87 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   88 */     this.jLabel5.setCursor(micursor);
/*   89 */     this.jLabel6.setCursor(micursor);
/*   90 */     this.jLabel7.setCursor(micursor);
/*      */     
/*   92 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   93 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*      */     
/*   95 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*   96 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*   97 */     editFormat.setGroupingUsed(false);
/*   98 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*   99 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  100 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  101 */     enFormat.setAllowsInvalid(true);
/*  102 */     this.cantidad.setFormatterFactory(currFactory);
/*  103 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  104 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*      */     
/*  106 */     this.cantidad.setValue(Integer.valueOf(0));
/*  107 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  108 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  109 */     consultar();
/*      */     
/*  111 */     this.con.consultar("directiva", "configuraciones", "");
/*  112 */     this.DIRECTIVA = this.con.Campo;
/*      */     
/*  114 */     int w = this.tama.width;
/*  115 */     int h = this.tama.height;
/*  116 */     int rw = (w - 980) / 2;
/*  117 */     int rh = (h - 650) / 2;
/*      */     
/*  119 */     rw = (w - 920) / 2;
/*  120 */     rh = (h - 630) / 2;
/*  121 */     this.jFrame1.setLocation(rw, rh);
/*  122 */     this.jFrame1.setSize(920, 630);
/*  123 */     this.jFrame1.setVisible(false);
/*  124 */     this.jFrame1.setExtendedState(6);
/*      */     
/*  126 */     rw = (w - 933) / 2;
/*  127 */     rh = (h - 480) / 2;
/*  128 */     this.jDialog1.setLocation(rw, rh);
/*  129 */     this.jDialog1.setSize(933, 480);
/*  130 */     this.jDialog1.setResizable(false);
/*  131 */     this.jDialog1.setVisible(false);
/*      */     
/*  133 */     rw = (w - 635) / 2;
/*  134 */     rh = (h - 345) / 2;
/*  135 */     this.jDialog2.setLocation(rw, rh);
/*  136 */     this.jDialog2.setSize(635, 345);
/*  137 */     this.jDialog2.setResizable(false);
/*  138 */     this.jDialog2.setVisible(false);
/*      */     
/*  140 */     rw = (w - 350) / 2;
/*  141 */     rh = (h - 190) / 2;
/*  142 */     this.jDialog3.setLocation(rw, rh);
/*  143 */     this.jDialog3.setSize(350, 190);
/*  144 */     this.jDialog3.setResizable(false);
/*  145 */     this.jDialog3.setVisible(false);
/*      */     
/*  147 */     rw = (w - 400) / 2;
/*  148 */     rh = (h - 390) / 2;
/*  149 */     this.jDialog4.setLocation(rw, rh);
/*  150 */     this.jDialog4.setSize(400, 390);
/*  151 */     this.jDialog4.setResizable(false);
/*  152 */     this.jDialog4.setVisible(false);
/*      */     
/*  154 */     this.buttonGroup1.add(this.jRadioButton1);
/*  155 */     this.buttonGroup1.add(this.jRadioButton2);
/*  156 */     llenarCombos();
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
/*  219 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(70);
/*  220 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(70);
/*  221 */     this.jTable5.getColumnModel().getColumn(1).setPreferredWidth(85);
/*  222 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(85);
/*  223 */     this.jTable5.getColumnModel().getColumn(3).setPreferredWidth(160);
/*  224 */     this.jTable5.getColumnModel().getColumn(3).setMaxWidth(160);
/*  225 */     this.jTable5.getColumnModel().getColumn(4).setPreferredWidth(100);
/*  226 */     this.jTable5.getColumnModel().getColumn(4).setMaxWidth(100);
/*  227 */     this.jTable5.getColumnModel().getColumn(5).setPreferredWidth(80);
/*  228 */     this.jTable5.getColumnModel().getColumn(5).setMaxWidth(80);
/*  229 */     this.jTable5.getColumnModel().getColumn(7).setPreferredWidth(60);
/*  230 */     this.jTable5.getColumnModel().getColumn(7).setMaxWidth(60);
/*  231 */     this.jTable5.getColumnModel().getColumn(8).setPreferredWidth(80);
/*  232 */     this.jTable5.getColumnModel().getColumn(8).setMaxWidth(80);
/*  233 */     this.jTable5.getColumnModel().getColumn(9).setPreferredWidth(80);
/*  234 */     this.jTable5.getColumnModel().getColumn(9).setMaxWidth(80);
/*  235 */     this.jTable5.getColumnModel().getColumn(10).setPreferredWidth(80);
/*  236 */     this.jTable5.getColumnModel().getColumn(10).setMaxWidth(80);
/*  237 */     this.jTable5.getColumnModel().getColumn(11).setPreferredWidth(80);
/*  238 */     this.jTable5.getColumnModel().getColumn(11).setMaxWidth(80);
/*  239 */     this.jTable5.getColumnModel().getColumn(12).setPreferredWidth(110);
/*  240 */     this.jTable5.getColumnModel().getColumn(12).setMaxWidth(110);
/*  241 */     this.jTable5.getColumnModel().getColumn(13).setPreferredWidth(100);
/*  242 */     this.jTable5.getColumnModel().getColumn(13).setMaxWidth(100);
/*  243 */     this.jTable5.getColumnModel().getColumn(14).setPreferredWidth(120);
/*  244 */     this.jTable5.getColumnModel().getColumn(14).setMaxWidth(120);
/*  245 */     this.jTable5.getColumnModel().getColumn(15).setPreferredWidth(80);
/*  246 */     this.jTable5.getColumnModel().getColumn(15).setMaxWidth(80);
/*  247 */     this.jTable5.getColumnModel().getColumn(16).setPreferredWidth(100);
/*  248 */     this.jTable5.getColumnModel().getColumn(16).setMaxWidth(100);
/*  249 */     this.jTable5.getColumnModel().getColumn(17).setPreferredWidth(110);
/*  250 */     this.jTable5.getColumnModel().getColumn(17).setMaxWidth(110);
/*  251 */     this.jTable5.getColumnModel().getColumn(18).setPreferredWidth(115);
/*  252 */     this.jTable5.getColumnModel().getColumn(18).setMaxWidth(115);
/*  253 */     this.jTable5.getColumnModel().getColumn(19).setPreferredWidth(75);
/*  254 */     this.jTable5.getColumnModel().getColumn(19).setMaxWidth(75);
/*  255 */     this.jTable5.getColumnModel().getColumn(20).setPreferredWidth(100);
/*  256 */     this.jTable5.getColumnModel().getColumn(20).setMaxWidth(100);
/*  257 */     this.jTable5.getColumnModel().getColumn(21).setPreferredWidth(170);
/*  258 */     this.jTable5.getColumnModel().getColumn(21).setMaxWidth(170);
/*  259 */     this.jTable5.getColumnModel().getColumn(22).setPreferredWidth(170);
/*  260 */     this.jTable5.getColumnModel().getColumn(22).setMaxWidth(170);
/*  261 */     this.jTable5.getColumnModel().getColumn(23).setPreferredWidth(100);
/*  262 */     this.jTable5.getColumnModel().getColumn(23).setMaxWidth(100);
/*  263 */     this.jTable5.getColumnModel().getColumn(24).setPreferredWidth(135);
/*  264 */     this.jTable5.getColumnModel().getColumn(24).setMaxWidth(135);
/*  265 */     this.jTable5.getColumnModel().getColumn(25).setPreferredWidth(60);
/*  266 */     this.jTable5.getColumnModel().getColumn(25).setMaxWidth(60);
/*  267 */     this.jTable5.getColumnModel().getColumn(26).setPreferredWidth(180);
/*  268 */     this.jTable5.getColumnModel().getColumn(26).setMaxWidth(180);
/*  269 */     this.jTable5.getColumnModel().getColumn(27).setPreferredWidth(95);
/*  270 */     this.jTable5.getColumnModel().getColumn(27).setMaxWidth(95);
/*  271 */     this.jTable5.getColumnModel().getColumn(28).setPreferredWidth(60);
/*  272 */     this.jTable5.getColumnModel().getColumn(28).setMaxWidth(60);
/*  273 */     this.jTable5.getColumnModel().getColumn(29).setPreferredWidth(60);
/*  274 */     this.jTable5.getColumnModel().getColumn(29).setMaxWidth(60);
/*  275 */     this.jTable5.getColumnModel().getColumn(30).setPreferredWidth(120);
/*  276 */     this.jTable5.getColumnModel().getColumn(30).setMaxWidth(120);
/*  277 */     this.jTable5.getColumnModel().getColumn(31).setPreferredWidth(60);
/*  278 */     this.jTable5.getColumnModel().getColumn(31).setMaxWidth(60);
/*  279 */     this.jTable5.getColumnModel().getColumn(32).setPreferredWidth(90);
/*  280 */     this.jTable5.getColumnModel().getColumn(32).setMaxWidth(90);
/*  281 */     this.jTable5.getColumnModel().getColumn(33).setPreferredWidth(90);
/*  282 */     this.jTable5.getColumnModel().getColumn(33).setMaxWidth(90);
/*      */   }
/*      */   private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel54; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JList jList1; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel36; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator8; private JSeparator jSeparator9; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JSpinner jSpinner4; private JSpinner jSpinner5; private JSpinner jSpinner6; private JSpinner jSpinner7; private JSpinner jSpinner8; private JTable jTable1; private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   private JTextArea jTextArea1;
/*      */   private JTextField jTextField1;
/*      */   private JTextField jTextField10;
/*      */   private JTextField jTextField11;
/*      */   private JTextField jTextField2;
/*      */   private JTextField jTextField3;
/*      */   private JTextField jTextField4;
/*      */   private JTextField jTextField5;
/*      */   private JTextField jTextField6;
/*      */   private JTextField jTextField7;
/*      */   private JTextField jTextField8;
/*      */   private JTextField jTextField9;
/*      */   private JTextPane jTextPane1;
/*      */   
/*      */   private void initComponents() {
/*  303 */     this.cantidad = new JFormattedTextField();
/*  304 */     this.jFrame1 = new JFrame();
/*  305 */     this.jPanel3 = new JPanel();
/*  306 */     this.jLabel3 = new JLabel();
/*  307 */     this.jLabel22 = new JLabel();
/*  308 */     this.jTextField6 = new JTextField();
/*  309 */     this.jLabel23 = new JLabel();
/*  310 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  311 */     this.jPanel4 = new JPanel();
/*  312 */     this.jLabel8 = new JLabel();
/*  313 */     this.jRadioButton1 = new JRadioButton();
/*  314 */     this.jRadioButton2 = new JRadioButton();
/*  315 */     this.jLabel93 = new JLabel();
/*  316 */     this.jDateChooser13 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  317 */     this.jLabel94 = new JLabel();
/*  318 */     this.jDateChooser14 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  319 */     this.jLabel95 = new JLabel();
/*  320 */     this.jSpinner3 = new JSpinner();
/*  321 */     this.jLabel16 = new JLabel();
/*  322 */     this.jTextField7 = new JTextField();
/*  323 */     this.jLabel17 = new JLabel();
/*  324 */     this.jTextField8 = new JTextField();
/*  325 */     this.jLabel12 = new JLabel();
/*  326 */     this.jButton15 = new JButton();
/*  327 */     this.jLabel10 = new JLabel();
/*  328 */     this.jLabel11 = new JLabel();
/*  329 */     this.jLabel13 = new JLabel();
/*  330 */     this.jButton16 = new JButton();
/*  331 */     this.jButton17 = new JButton();
/*  332 */     this.jButton18 = new JButton();
/*  333 */     this.jButton19 = new JButton();
/*  334 */     this.jLabel21 = new JLabel();
/*  335 */     this.jButton20 = new JButton();
/*  336 */     this.jPanel8 = new JPanel();
/*  337 */     this.jScrollPane1 = new JScrollPane();
/*  338 */     this.jTextPane1 = new JTextPane();
/*  339 */     this.jLabel2 = new JLabel();
/*  340 */     this.jTextField3 = new JTextField();
/*  341 */     this.jLabel9 = new JLabel();
/*  342 */     this.jTextField4 = new JTextField();
/*  343 */     this.jLabel14 = new JLabel();
/*  344 */     this.jTextField5 = new JTextField();
/*  345 */     this.jScrollPane7 = new JScrollPane();
/*  346 */     this.jPanel9 = new JPanel();
/*  347 */     this.jScrollPane8 = new JScrollPane();
/*  348 */     this.jTable5 = new JTable();
/*  349 */     this.jLabel18 = new JLabel();
/*  350 */     this.jLabel24 = new JLabel();
/*  351 */     this.jLabel25 = new JLabel();
/*  352 */     this.buttonGroup1 = new ButtonGroup();
/*  353 */     this.jPanel7 = new JPanel();
/*  354 */     this.jScrollPane5 = new JScrollPane();
/*  355 */     this.jPanel6 = new JPanel();
/*  356 */     this.jScrollPane6 = new JScrollPane();
/*  357 */     this.jTable4 = new JTable();
/*  358 */     this.jDialog1 = new CerrarVentana(this.jFrame1);
/*  359 */     this.jPanel10 = new JPanel();
/*  360 */     this.jLabel60 = new JLabel();
/*  361 */     this.jPanel36 = new JPanel();
/*  362 */     this.jScrollPane9 = new JScrollPane();
/*  363 */     this.jTable6 = new JTable();
/*  364 */     this.jLabel61 = new JLabel();
/*  365 */     this.jTextField9 = new JTextField();
/*  366 */     this.jLabel62 = new JLabel();
/*  367 */     this.jTextField10 = new JTextField();
/*  368 */     this.jLabel63 = new JLabel();
/*  369 */     this.jComboBox5 = new JComboBox();
/*  370 */     this.jButton29 = new JButton();
/*  371 */     this.jButton30 = new JButton();
/*  372 */     this.jLabel64 = new JLabel();
/*  373 */     this.jComboBox6 = new JComboBox();
/*  374 */     this.jLabel19 = new JLabel();
/*  375 */     this.jLabel20 = new JLabel();
/*  376 */     this.jCheckBox4 = new JCheckBox();
/*  377 */     this.jSeparator8 = new JSeparator();
/*  378 */     this.jDialog2 = new CerrarVentana(this.jFrame1);
/*  379 */     this.jPanel11 = new JPanel();
/*  380 */     this.jLabel65 = new JLabel();
/*  381 */     this.jSeparator9 = new JSeparator();
/*  382 */     this.jButton3 = new JButton();
/*  383 */     this.jButton4 = new JButton();
/*  384 */     this.jSpinner1 = new JSpinner();
/*  385 */     this.jSpinner2 = new JSpinner();
/*  386 */     this.jSpinner4 = new JSpinner();
/*  387 */     this.jSpinner5 = new JSpinner();
/*  388 */     this.jSpinner6 = new JSpinner();
/*  389 */     this.jSpinner7 = new JSpinner();
/*  390 */     this.jSpinner8 = new JSpinner();
/*  391 */     this.jLabel26 = new JLabel();
/*  392 */     this.jLabel27 = new JLabel();
/*  393 */     this.jLabel28 = new JLabel();
/*  394 */     this.jLabel29 = new JLabel();
/*  395 */     this.jLabel30 = new JLabel();
/*  396 */     this.jLabel31 = new JLabel();
/*  397 */     this.jLabel32 = new JLabel();
/*  398 */     this.jLabel33 = new JLabel();
/*  399 */     this.jScrollPane2 = new JScrollPane();
/*  400 */     this.jTextArea1 = new JTextArea();
/*  401 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  402 */     this.jPanel12 = new JPanel();
/*  403 */     this.jLabel66 = new JLabel();
/*  404 */     this.jSeparator10 = new JSeparator();
/*  405 */     this.jButton5 = new JButton();
/*  406 */     this.jButton6 = new JButton();
/*  407 */     this.jLabel36 = new JLabel();
/*  408 */     this.jScrollPane4 = new JScrollPane();
/*  409 */     this.jList1 = new JList();
/*  410 */     this.jButton7 = new JButton();
/*  411 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  412 */     this.jPanel13 = new JPanel();
/*  413 */     this.jLabel67 = new JLabel();
/*  414 */     this.jSeparator11 = new JSeparator();
/*  415 */     this.jButton8 = new JButton();
/*  416 */     this.jButton9 = new JButton();
/*  417 */     this.jScrollPane10 = new JScrollPane();
/*  418 */     this.jTable1 = new JTable();
/*  419 */     this.jLabel40 = new JLabel();
/*  420 */     this.jLabel41 = new JLabel();
/*  421 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  422 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  423 */     this.jLabel43 = new JLabel();
/*  424 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  425 */     this.jButton10 = new JButton();
/*  426 */     this.jLabel44 = new JLabel();
/*  427 */     this.jTextField11 = new JTextField();
/*  428 */     this.jPanel1 = new JPanel();
/*  429 */     this.jLabel54 = new JLabel();
/*  430 */     this.jPanel5 = new JPanel();
/*  431 */     this.jLabel48 = new JLabel();
/*  432 */     this.jScrollPane3 = new JScrollPane();
/*  433 */     this.jTable3 = new JTable();
/*  434 */     this.jButton23 = new JButton();
/*  435 */     this.jButton24 = new JButton();
/*  436 */     this.jButton25 = new JButton();
/*  437 */     this.jButton26 = new JButton();
/*  438 */     this.jLabel35 = new JLabel();
/*  439 */     this.jLabel37 = new JLabel();
/*  440 */     this.jLabel38 = new JLabel();
/*  441 */     this.jLabel39 = new JLabel();
/*  442 */     this.jLabel42 = new JLabel();
/*  443 */     this.jButton2 = new JButton();
/*  444 */     this.jButton27 = new JButton();
/*  445 */     this.jPanel17 = new JPanel();
/*  446 */     this.jTextField1 = new JTextField();
/*  447 */     this.jLabel15 = new JLabel();
/*  448 */     this.jComboBox8 = new JComboBox();
/*  449 */     this.jLabel46 = new JLabel();
/*  450 */     this.jLabel47 = new JLabel();
/*  451 */     this.jComboBox11 = new JComboBox();
/*  452 */     this.jTextField2 = new JTextField();
/*  453 */     this.jLabel34 = new JLabel();
/*  454 */     this.jPanel2 = new JPanel();
/*  455 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  456 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  457 */     this.jLabel5 = new JLabel();
/*  458 */     this.jLabel6 = new JLabel();
/*  459 */     this.jLabel7 = new JLabel();
/*  460 */     this.jLabel1 = new JLabel();
/*  461 */     this.jLabel4 = new JLabel();
/*  462 */     this.jButton1 = new JButton();
/*      */     
/*  464 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/*  466 */     this.jFrame1.setTitle("Formato de Nómina");
/*      */     
/*  468 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  470 */     this.jLabel3.setFont(new Font("Tahoma", 1, 15));
/*  471 */     this.jLabel3.setHorizontalAlignment(0);
/*  472 */     this.jLabel3.setText("NÓMINA");
/*      */     
/*  474 */     this.jLabel22.setText("Folio:");
/*      */     
/*  476 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/*  477 */     this.jTextField6.setEnabled(false);
/*      */     
/*  479 */     this.jLabel23.setHorizontalAlignment(4);
/*  480 */     this.jLabel23.setText("Fecha:");
/*      */     
/*  482 */     this.jDateChooser12.setDate(this.fechaActual);
/*  483 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/*  484 */     this.jDateChooser12.setEnabled(false);
/*  485 */     this.jDateChooser12.setIcon(this.icon);
/*  486 */     this.jDateChooser12.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  488 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  489 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Datos de la Nómina"));
/*      */     
/*  491 */     this.jLabel8.setText("Tipo de Nómina");
/*      */     
/*  493 */     this.jRadioButton1.setBackground(new Color(255, 255, 255));
/*  494 */     this.jRadioButton1.setSelected(true);
/*  495 */     this.jRadioButton1.setText("Administrativos");
/*  496 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  498 */             Nominas.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  502 */     this.jRadioButton2.setBackground(new Color(255, 255, 255));
/*  503 */     this.jRadioButton2.setText("Operadores");
/*  504 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  506 */             Nominas.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  510 */     this.jLabel93.setText("Fecha del cálculo: ");
/*      */     
/*  512 */     this.jDateChooser13.setDate(this.fechaActual);
/*  513 */     this.jDateChooser13.setDateFormatString("dd/MM/yyyy");
/*  514 */     this.jDateChooser13.setIcon(this.icon);
/*  515 */     this.jDateChooser13.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  517 */     this.jLabel94.setHorizontalAlignment(0);
/*  518 */     this.jLabel94.setText("Al");
/*      */     
/*  520 */     this.jDateChooser14.setDate(this.fechaActual);
/*  521 */     this.jDateChooser14.setDateFormatString("dd/MM/yyyy");
/*  522 */     this.jDateChooser14.setIcon(this.icon);
/*  523 */     this.jDateChooser14.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  525 */     this.jLabel95.setText("No. de Sem:");
/*      */     
/*  527 */     this.jSpinner3.setModel(new SpinnerNumberModel(1, 1, 53, 1));
/*      */     
/*  529 */     this.jLabel16.setText("Sucursal");
/*      */     
/*  531 */     this.jLabel17.setText("Dirección");
/*      */     
/*  533 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  534 */     this.jPanel4.setLayout(jPanel4Layout);
/*  535 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  536 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  537 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  538 */           .addContainerGap()
/*  539 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  540 */             .addComponent(this.jLabel17, -1, -1, 32767)
/*  541 */             .addComponent(this.jLabel16, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  542 */             .addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  543 */             .addComponent(this.jLabel93, GroupLayout.Alignment.LEADING, -2, 108, 32767))
/*  544 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  545 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  546 */             .addComponent(this.jTextField8)
/*  547 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  548 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  549 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/*  550 */                   .addComponent(this.jRadioButton1, -2, 129, -2)
/*  551 */                   .addGap(8, 8, 8)
/*  552 */                   .addComponent(this.jRadioButton2, -2, 129, -2))
/*  553 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/*  554 */                   .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  555 */                     .addComponent(this.jTextField7, GroupLayout.Alignment.LEADING)
/*  556 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
/*  557 */                       .addComponent((Component)this.jDateChooser13, -2, 119, -2)
/*  558 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  559 */                       .addComponent(this.jLabel94, -2, 50, -2)
/*  560 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  561 */                       .addComponent((Component)this.jDateChooser14, -2, 119, -2)))
/*  562 */                   .addGap(56, 56, 56)
/*  563 */                   .addComponent(this.jLabel95, -2, 70, -2)
/*  564 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  565 */                   .addComponent(this.jSpinner3, -2, 53, -2)))
/*  566 */               .addGap(0, 0, 32767)))
/*  567 */           .addContainerGap()));
/*      */     
/*  569 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  570 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  571 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  572 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  573 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  574 */               .addComponent((Component)this.jDateChooser13, -1, -1, 32767)
/*  575 */               .addComponent(this.jLabel93, -1, -1, 32767)
/*  576 */               .addComponent(this.jLabel94, -1, -1, 32767)
/*  577 */               .addComponent((Component)this.jDateChooser14, -2, -1, -2))
/*  578 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  579 */               .addComponent(this.jLabel95)
/*  580 */               .addComponent(this.jSpinner3, -2, -1, -2)))
/*  581 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  582 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  583 */             .addComponent(this.jRadioButton2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  584 */             .addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -2, 22, -2)
/*  585 */             .addComponent(this.jRadioButton1, GroupLayout.Alignment.LEADING))
/*  586 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  587 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  588 */             .addComponent(this.jLabel16)
/*  589 */             .addComponent(this.jTextField7, -2, -1, -2))
/*  590 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  591 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  592 */             .addComponent(this.jLabel17)
/*  593 */             .addComponent(this.jTextField8, -2, -1, -2))
/*  594 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  597 */     this.jLabel12.setText("Para agregar empleados haz clic en el siguiente botón");
/*      */     
/*  599 */     this.jButton15.setMnemonic('A');
/*  600 */     this.jButton15.setText("Agregar Empleados");
/*  601 */     this.jButton15.setToolTipText("Agregar Empleados (Alt+A)");
/*  602 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  604 */             Nominas.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  608 */     this.jLabel10.setText("Total de empleados:");
/*      */     
/*  610 */     this.jLabel11.setFont(new Font("Tahoma", 1, 14));
/*  611 */     this.jLabel11.setHorizontalAlignment(4);
/*  612 */     this.jLabel11.setText("0");
/*      */     
/*  614 */     this.jLabel13.setFont(new Font("Tahoma", 1, 15));
/*  615 */     this.jLabel13.setHorizontalAlignment(11);
/*  616 */     this.jLabel13.setText("$0.0");
/*      */     
/*  618 */     this.jButton16.setMnemonic('C');
/*  619 */     this.jButton16.setText("Cerrar");
/*  620 */     this.jButton16.setToolTipText("Cerrar (Alt+C)");
/*  621 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  623 */             Nominas.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  627 */     this.jButton17.setMnemonic('G');
/*  628 */     this.jButton17.setText("Guardar");
/*  629 */     this.jButton17.setToolTipText("Guardar (Alt+G)");
/*  630 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  632 */             Nominas.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  636 */     this.jButton18.setMnemonic('E');
/*  637 */     this.jButton18.setText("Exportar");
/*  638 */     this.jButton18.setToolTipText("Exportar (Alt+E)");
/*  639 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  641 */             Nominas.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  645 */     this.jButton19.setMnemonic('Q');
/*  646 */     this.jButton19.setText("Quitar");
/*  647 */     this.jButton19.setToolTipText("Quitar (Alt+Q)");
/*  648 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  650 */             Nominas.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  654 */     this.jLabel21.setHorizontalAlignment(4);
/*  655 */     this.jLabel21.setText("Total neto");
/*      */     
/*  657 */     this.jButton20.setMnemonic('R');
/*  658 */     this.jButton20.setText("Recibos");
/*  659 */     this.jButton20.setToolTipText("Generar Recibos (Alt+R)");
/*  660 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  662 */             Nominas.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  666 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/*  667 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder("Datos Fiscales"));
/*      */     
/*  669 */     this.jTextPane1.setEditable(false);
/*  670 */     this.jTextPane1.setText("Fletes y Materiales Forsis\nDireccion\nRFC\n\nTelefono");
/*  671 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*      */     
/*  673 */     this.jLabel2.setHorizontalAlignment(4);
/*  674 */     this.jLabel2.setText("Clave Banco");
/*      */     
/*  676 */     this.jLabel9.setHorizontalAlignment(4);
/*  677 */     this.jLabel9.setText("Clave Desc");
/*      */     
/*  679 */     this.jLabel14.setHorizontalAlignment(4);
/*  680 */     this.jLabel14.setText("Clave Riesgo");
/*      */     
/*  682 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  683 */     this.jPanel8.setLayout(jPanel8Layout);
/*  684 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  685 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  686 */         .addComponent(this.jScrollPane1, -1, 475, 32767)
/*  687 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  688 */           .addComponent(this.jLabel2, -2, 74, -2)
/*  689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  690 */           .addComponent(this.jTextField3, -2, 74, -2)
/*  691 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  692 */           .addComponent(this.jLabel9, -2, 68, -2)
/*  693 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  694 */           .addComponent(this.jTextField4, -2, 74, -2)
/*  695 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  696 */           .addComponent(this.jLabel14, -2, 76, -2)
/*  697 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  698 */           .addComponent(this.jTextField5, -2, 74, -2)));
/*      */     
/*  700 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  701 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  702 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  703 */           .addComponent(this.jScrollPane1, -2, 122, -2)
/*  704 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  705 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  706 */             .addComponent(this.jLabel2)
/*  707 */             .addComponent(this.jTextField3, -2, -1, -2)
/*  708 */             .addComponent(this.jLabel14)
/*  709 */             .addComponent(this.jTextField5, -2, -1, -2)
/*  710 */             .addComponent(this.jLabel9)
/*  711 */             .addComponent(this.jTextField4, -2, -1, -2))));
/*      */ 
/*      */     
/*  714 */     this.jScrollPane7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  716 */             Nominas.this.jScrollPane7MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  720 */     this.jScrollPane8.setMinimumSize(new Dimension(2, 23));
/*  721 */     this.jScrollPane8.setPreferredSize(new Dimension(752, 419));
/*  722 */     this.jScrollPane8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  724 */             Nominas.this.jScrollPane8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  728 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "NSS", "Nombre Completo", "CURP", "R.F.C.", "F. de Ingreso", "Departamento", "Días Lab.", "Salario Diario", "Sueldo", "SDI", "Horas Extra", "Horas Extra Dobles", "Horas Extra Triple", "Gratificación Fiscal", "Otros Fiscal", "Subtotal", "Préstamos Fiscal", "Otras deducciones", "INFONAVIT", "Descuento IMSS", "Percep Excentas No Deduc", "Percep Exentas Deducibles", "Percep a Gravar", "Total a Gravar ISR", "Limite Inf", "Total a Gravar ISR menos Limite", "% S/EXCEDIDO", "Cuota Fija", "Resultado", "Subsidio para el Empleo", "I.S.P.T.", "Subtotal-neto", "Total-Neto" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  736 */           Class[] types = new Class[] { Object.class, Integer.class, String.class, String.class, String.class, Object.class, String.class, Integer.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class };
/*      */ 
/*      */           
/*  739 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               true, true, true, true, true, true, false, true, true, true, 
/*      */               true, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false }; public Class getColumnClass(int columnIndex) {
/*  744 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  748 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  751 */     this.jTable5.setColumnSelectionAllowed(true);
/*  752 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/*  753 */     this.jTable5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  755 */             Nominas.this.jTable5MouseClicked(evt);
/*      */           }
/*      */         });
/*  758 */     this.jTable5.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/*  760 */             Nominas.this.jTable5KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/*  763 */             Nominas.this.jTable5KeyReleased(evt);
/*      */           }
/*      */         });
/*  766 */     this.jScrollPane8.setViewportView(this.jTable5);
/*  767 */     this.jTable5.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/*  769 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  770 */     this.jPanel9.setLayout(jPanel9Layout);
/*  771 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  772 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  773 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  774 */           .addContainerGap()
/*  775 */           .addComponent(this.jScrollPane8, -2, 3794, -2)
/*  776 */           .addContainerGap(-1, 32767)));
/*      */     
/*  778 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  780 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  781 */           .addContainerGap()
/*  782 */           .addComponent(this.jScrollPane8, -1, 371, 32767)
/*  783 */           .addContainerGap()));
/*      */ 
/*      */     
/*  786 */     this.jScrollPane7.setViewportView(this.jPanel9);
/*      */     
/*  788 */     this.jLabel18.setFont(new Font("Tahoma", 1, 15));
/*  789 */     this.jLabel18.setHorizontalAlignment(11);
/*  790 */     this.jLabel18.setText("$0.0");
/*      */     
/*  792 */     this.jLabel24.setHorizontalAlignment(4);
/*  793 */     this.jLabel24.setText("Total Fiscal");
/*      */     
/*  795 */     this.jLabel25.setFont(new Font("Tahoma", 1, 10));
/*  796 */     this.jLabel25.setForeground(new Color(0, 0, 255));
/*  797 */     this.jLabel25.setText(" ");
/*      */     
/*  799 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  800 */     this.jPanel3.setLayout(jPanel3Layout);
/*  801 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  803 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  804 */           .addContainerGap()
/*  805 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  806 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  807 */               .addComponent(this.jLabel22, -2, 54, -2)
/*  808 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  809 */               .addComponent(this.jTextField6, -2, 145, -2)
/*  810 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  811 */               .addComponent(this.jLabel3, -1, -1, 32767)
/*  812 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  813 */               .addComponent(this.jLabel23, -2, 57, -2)
/*  814 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  815 */               .addComponent((Component)this.jDateChooser12, -2, 92, -2))
/*  816 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  817 */               .addComponent(this.jPanel8, -2, -1, -2)
/*  818 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  819 */               .addComponent(this.jPanel4, -1, -1, 32767))
/*  820 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  821 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  822 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/*  823 */                   .addComponent(this.jLabel25, -1, -1, 32767)
/*  824 */                   .addGap(64, 64, 64)
/*  825 */                   .addComponent(this.jLabel24, -2, 87, -2)
/*  826 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  827 */                   .addComponent(this.jLabel18, -2, 133, -2)
/*  828 */                   .addGap(117, 117, 117))
/*  829 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/*  830 */                   .addComponent(this.jLabel12, -2, 303, -2)
/*  831 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  832 */                   .addComponent(this.jButton15, -2, 143, -2)
/*  833 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  834 */                   .addComponent(this.jButton19, -2, 87, -2)
/*  835 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
/*  836 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  837 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/*  838 */                   .addGap(23, 23, 23)
/*  839 */                   .addComponent(this.jLabel10, -2, 129, -2)
/*  840 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  841 */                   .addComponent(this.jLabel11, -2, 49, -2))
/*  842 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/*  843 */                   .addComponent(this.jLabel21, -2, 87, -2)
/*  844 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  845 */                   .addComponent(this.jLabel13, -2, 133, -2)
/*  846 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  847 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */                     .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  849 */                       .addComponent(this.jButton17, -2, 106, -2)
/*  850 */                       .addComponent(this.jButton18, -1, -1, 32767)
/*  851 */                       .addComponent(this.jButton16, -2, 106, -2))
/*  852 */                     .addComponent(this.jButton20, GroupLayout.Alignment.TRAILING, -2, 106, -2))))))
/*  853 */           .addContainerGap())
/*  854 */         .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  855 */           .addGroup(jPanel3Layout.createSequentialGroup()
/*  856 */             .addContainerGap()
/*  857 */             .addComponent(this.jScrollPane7, -1, 997, 32767)
/*  858 */             .addGap(129, 129, 129))));
/*      */     
/*  860 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  862 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  863 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  864 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  865 */               .addComponent(this.jLabel3)
/*  866 */               .addComponent(this.jTextField6, -2, -1, -2)
/*  867 */               .addComponent(this.jLabel22)
/*  868 */               .addComponent(this.jLabel23))
/*  869 */             .addComponent((Component)this.jDateChooser12, -2, -1, -2))
/*  870 */           .addGap(6, 6, 6)
/*  871 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  872 */             .addComponent(this.jPanel8, -1, -1, 32767)
/*  873 */             .addComponent(this.jPanel4, -1, -1, 32767))
/*  874 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  875 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  876 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  877 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  878 */                 .addComponent(this.jLabel12)
/*  879 */                 .addComponent(this.jButton15)
/*  880 */                 .addComponent(this.jButton19)))
/*  881 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  882 */               .addGap(15, 15, 15)
/*  883 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  884 */                 .addComponent(this.jLabel10)
/*  885 */                 .addComponent(this.jLabel11))))
/*  886 */           .addGap(29, 29, 29)
/*  887 */           .addComponent(this.jButton17, -2, 24, -2)
/*  888 */           .addGap(8, 8, 8)
/*  889 */           .addComponent(this.jButton20, -2, 24, -2)
/*  890 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  891 */           .addComponent(this.jButton18, -2, 24, -2)
/*  892 */           .addGap(37, 37, 37)
/*  893 */           .addComponent(this.jButton16, -2, 24, -2)
/*  894 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 262, 32767)
/*  895 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  896 */             .addComponent(this.jLabel13, -1, -1, 32767)
/*  897 */             .addComponent(this.jLabel18, -1, -1, 32767)
/*  898 */             .addComponent(this.jLabel21, -1, -1, 32767)
/*  899 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  900 */               .addComponent(this.jLabel24, -1, -1, 32767)
/*  901 */               .addComponent(this.jLabel25)))
/*  902 */           .addContainerGap())
/*  903 */         .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  904 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  905 */             .addGap(243, 243, 243)
/*  906 */             .addComponent(this.jScrollPane7, -1, 412, 32767)
/*  907 */             .addGap(43, 43, 43))));
/*      */ 
/*      */     
/*  910 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/*  911 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/*  912 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/*  913 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  914 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  916 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/*  917 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  918 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  921 */     this.jScrollPane6.setHorizontalScrollBarPolicy(32);
/*  922 */     this.jScrollPane6.setPreferredSize(new Dimension(752, 419));
/*      */     
/*  924 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  925 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "No.", "Nombre Completo", "NSS", "F. de Ingreso", "Departamento", "CURP", "R.F.C.", "Salario Diario", "Días Lab.", "Sueldo", "SDI", "Años de Antiguedad", "Años", "Días Vacaciones", "Días Proporcionales", "Vacaciones", "Horas Extra", "Horas Extra Dobles", "Horas Extra Triple", "Gratificación", "Otros", "Subtotal", "Préstamos", "Otras deducciones", "Pensión", "Descuento IMSS", "Percepciones Excentas NO DEDUCIBLES", "Percepciones Excentas DEDUCIBLES", "Percepciones gabrables", "Total Grabal I.S.R.", "Limite Inf", "% S/EXCEDIDO", "Cuota Fija", "Subsidio para el Empleo", "I.S.P.T.", "Subtotal-neto", "Total-Neto" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  936 */           Class[] types = new Class[] { Object.class, String.class, Integer.class, Object.class, String.class, String.class, String.class, Double.class, Integer.class, Double.class, Double.class, Integer.class, Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */           
/*  939 */           boolean[] canEdit = new boolean[] { 
/*      */               false, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true }; public Class getColumnClass(int columnIndex) {
/*  944 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  948 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  951 */     this.jTable4.setColumnSelectionAllowed(true);
/*  952 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/*  953 */     this.jTable4.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/*  955 */             Nominas.this.jTable4KeyPressed(evt);
/*      */           }
/*      */         });
/*  958 */     this.jScrollPane6.setViewportView(this.jTable4);
/*  959 */     this.jTable4.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/*  961 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  962 */     this.jPanel6.setLayout(jPanel6Layout);
/*  963 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  964 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  965 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  966 */           .addContainerGap()
/*  967 */           .addComponent(this.jScrollPane6, -2, 2576, -2)
/*  968 */           .addContainerGap(-1, 32767)));
/*      */     
/*  970 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  971 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  972 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  973 */           .addContainerGap()
/*  974 */           .addComponent(this.jScrollPane6, -1, 526, 32767)
/*  975 */           .addGap(13, 13, 13)));
/*      */ 
/*      */     
/*  978 */     this.jScrollPane5.setViewportView(this.jPanel6);
/*      */     
/*  980 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  981 */     this.jPanel7.setLayout(jPanel7Layout);
/*  982 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  983 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  984 */         .addGap(0, 954, 32767)
/*  985 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  986 */           .addGroup(jPanel7Layout.createSequentialGroup()
/*  987 */             .addContainerGap()
/*  988 */             .addComponent(this.jScrollPane5, -1, 934, 32767)
/*  989 */             .addContainerGap())));
/*      */     
/*  991 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  992 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  993 */         .addGap(0, 486, 32767)
/*  994 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  995 */           .addGroup(jPanel7Layout.createSequentialGroup()
/*  996 */             .addContainerGap()
/*  997 */             .addComponent(this.jScrollPane5, -1, 464, 32767)
/*  998 */             .addContainerGap())));
/*      */ 
/*      */     
/* 1001 */     this.jDialog1.setTitle("Búsqueda de Empleados");
/* 1002 */     this.jDialog1.setModal(true);
/*      */     
/* 1004 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/* 1006 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/* 1007 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/* 1008 */     this.jLabel60.setHorizontalAlignment(0);
/* 1009 */     this.jLabel60.setText("Busqueda de Empleados");
/*      */     
/* 1011 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/* 1012 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Empleados", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1014 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/* 1015 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1023 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1028 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1031 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1033 */             Nominas.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1036 */     this.jScrollPane9.setViewportView(this.jTable6);
/*      */     
/* 1038 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/* 1039 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 1040 */     this.jLabel61.setHorizontalAlignment(4);
/* 1041 */     this.jLabel61.setText("Clave");
/*      */     
/* 1043 */     this.jTextField9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1045 */             Nominas.this.jTextField9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1048 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1050 */             Nominas.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1054 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/* 1055 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 1056 */     this.jLabel62.setHorizontalAlignment(4);
/* 1057 */     this.jLabel62.setText("Nombre");
/*      */     
/* 1059 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1061 */             Nominas.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1065 */     this.jLabel63.setFont(new Font("Tahoma", 2, 11));
/* 1066 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/* 1067 */     this.jLabel63.setHorizontalAlignment(4);
/* 1068 */     this.jLabel63.setText("Tipo");
/*      */     
/* 1070 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 1071 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/* 1072 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1074 */             Nominas.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1078 */     this.jButton29.setMnemonic('C');
/* 1079 */     this.jButton29.setText("Cerrar");
/* 1080 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 1081 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1083 */             Nominas.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1087 */     this.jButton30.setMnemonic('A');
/* 1088 */     this.jButton30.setText("Agregar");
/* 1089 */     this.jButton30.setToolTipText("Agregar (Alt+A)");
/* 1090 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1092 */             Nominas.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1096 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/* 1097 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/* 1098 */     this.jLabel64.setHorizontalAlignment(4);
/* 1099 */     this.jLabel64.setText("Depto");
/*      */     
/* 1101 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1102 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 1103 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1105 */             Nominas.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1109 */     this.jLabel19.setText("Total de datos:");
/*      */     
/* 1111 */     this.jLabel20.setFont(new Font("Tahoma", 1, 14));
/* 1112 */     this.jLabel20.setText("0");
/*      */     
/* 1114 */     this.jCheckBox4.setText("Seleccionar todos");
/* 1115 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1117 */             Nominas.this.jCheckBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1121 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1122 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1123 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1124 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1125 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 1126 */           .addContainerGap()
/* 1127 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1128 */             .addComponent(this.jScrollPane9, GroupLayout.Alignment.LEADING, -1, 835, 32767)
/* 1129 */             .addComponent(this.jCheckBox4, GroupLayout.Alignment.LEADING, -2, 132, -2)
/* 1130 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
/* 1131 */               .addComponent(this.jLabel61, -2, 40, -2)
/* 1132 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1133 */               .addComponent(this.jTextField9, -2, 52, -2)
/* 1134 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1135 */               .addComponent(this.jLabel62, -2, 57, -2)
/* 1136 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1137 */               .addComponent(this.jTextField10, -2, 169, -2)
/* 1138 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1139 */               .addComponent(this.jLabel63, -2, 63, -2)
/* 1140 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1141 */               .addComponent(this.jComboBox5, -2, 168, -2)
/* 1142 */               .addGap(18, 18, 18)
/* 1143 */               .addComponent(this.jLabel64, -2, 63, -2)
/* 1144 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1145 */               .addComponent(this.jComboBox6, -2, 168, -2))
/* 1146 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 1147 */               .addComponent(this.jLabel19, -2, 90, -2)
/* 1148 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1149 */               .addComponent(this.jLabel20, -2, 75, -2)
/* 1150 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1151 */               .addComponent(this.jButton30, -2, 126, -2)
/* 1152 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1153 */               .addComponent(this.jButton29, -2, 126, -2)))
/* 1154 */           .addContainerGap()));
/*      */     
/* 1156 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1157 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1158 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1159 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1160 */             .addComponent(this.jLabel61)
/* 1161 */             .addComponent(this.jTextField9, -2, -1, -2)
/* 1162 */             .addComponent(this.jLabel62)
/* 1163 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 1164 */             .addComponent(this.jLabel63)
/* 1165 */             .addComponent(this.jComboBox5, -2, -1, -2)
/* 1166 */             .addComponent(this.jLabel64)
/* 1167 */             .addComponent(this.jComboBox6, -2, -1, -2))
/* 1168 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1169 */           .addComponent(this.jCheckBox4)
/* 1170 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1171 */           .addComponent(this.jScrollPane9, -1, 250, 32767)
/* 1172 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1173 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1174 */             .addComponent(this.jButton29)
/* 1175 */             .addComponent(this.jButton30)
/* 1176 */             .addComponent(this.jLabel19)
/* 1177 */             .addComponent(this.jLabel20))
/* 1178 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1181 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1182 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1183 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1185 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1186 */           .addContainerGap()
/* 1187 */           .addComponent(this.jSeparator8, -1, 865, 32767)
/* 1188 */           .addContainerGap())
/* 1189 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1190 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1191 */             .addGap(8, 8, 8)
/* 1192 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1193 */               .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 867, 32767)
/* 1194 */               .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1195 */             .addGap(10, 10, 10))));
/*      */     
/* 1197 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1199 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1200 */           .addGap(31, 31, 31)
/* 1201 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1202 */           .addContainerGap(372, 32767))
/* 1203 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1204 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 1205 */             .addComponent(this.jLabel60, -2, 31, -2)
/* 1206 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1207 */             .addComponent(this.jPanel36, -1, -1, 32767)
/* 1208 */             .addContainerGap())));
/*      */ 
/*      */     
/* 1211 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1212 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1213 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1214 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1215 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 1217 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1218 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1219 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 1222 */     this.jDialog2.setTitle("Organizar Días");
/* 1223 */     this.jDialog2.setModal(true);
/*      */     
/* 1225 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/* 1227 */     this.jLabel65.setFont(new Font("Tahoma", 1, 16));
/* 1228 */     this.jLabel65.setForeground(new Color(0, 102, 102));
/* 1229 */     this.jLabel65.setHorizontalAlignment(0);
/* 1230 */     this.jLabel65.setText("Días Laborados");
/*      */     
/* 1232 */     this.jButton3.setMnemonic('C');
/* 1233 */     this.jButton3.setText("Cerrar");
/* 1234 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/* 1235 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1237 */             Nominas.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1241 */     this.jButton4.setMnemonic('G');
/* 1242 */     this.jButton4.setText("Guardar");
/* 1243 */     this.jButton4.setToolTipText("Guardar (Alt+G)");
/*      */     
/* 1245 */     this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1247 */     this.jSpinner2.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1249 */     this.jSpinner4.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1251 */     this.jSpinner5.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1253 */     this.jSpinner6.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1255 */     this.jSpinner7.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1257 */     this.jSpinner8.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/* 1259 */     this.jLabel26.setHorizontalAlignment(0);
/* 1260 */     this.jLabel26.setText(" ");
/*      */     
/* 1262 */     this.jLabel27.setHorizontalAlignment(0);
/* 1263 */     this.jLabel27.setText(" ");
/*      */     
/* 1265 */     this.jLabel28.setHorizontalAlignment(0);
/* 1266 */     this.jLabel28.setText(" ");
/*      */     
/* 1268 */     this.jLabel29.setHorizontalAlignment(0);
/* 1269 */     this.jLabel29.setText(" ");
/*      */     
/* 1271 */     this.jLabel30.setHorizontalAlignment(0);
/* 1272 */     this.jLabel30.setText(" ");
/*      */     
/* 1274 */     this.jLabel31.setHorizontalAlignment(0);
/* 1275 */     this.jLabel31.setText(" ");
/*      */     
/* 1277 */     this.jLabel32.setHorizontalAlignment(0);
/* 1278 */     this.jLabel32.setText(" ");
/*      */     
/* 1280 */     this.jLabel33.setText("Comentario:");
/*      */     
/* 1282 */     this.jTextArea1.setColumns(20);
/* 1283 */     this.jTextArea1.setRows(5);
/* 1284 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/* 1286 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1287 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1288 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1290 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1291 */           .addContainerGap()
/* 1292 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1293 */             .addComponent(this.jScrollPane2)
/* 1294 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1295 */               .addGap(0, 0, 32767)
/* 1296 */               .addComponent(this.jButton4, -2, 114, -2)
/* 1297 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1298 */               .addComponent(this.jButton3, -2, 114, -2))
/* 1299 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1300 */               .addComponent(this.jLabel26, -2, 70, -2)
/* 1301 */               .addGap(18, 18, 18)
/* 1302 */               .addComponent(this.jLabel27, -2, 70, -2)
/* 1303 */               .addGap(18, 18, 18)
/* 1304 */               .addComponent(this.jLabel28, -2, 70, -2)
/* 1305 */               .addGap(18, 18, 18)
/* 1306 */               .addComponent(this.jLabel29, -2, 70, -2)
/* 1307 */               .addGap(18, 18, 18)
/* 1308 */               .addComponent(this.jLabel30, -2, 70, -2)
/* 1309 */               .addGap(18, 18, 18)
/* 1310 */               .addComponent(this.jLabel31, -2, 70, -2)
/* 1311 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1312 */               .addComponent(this.jLabel32, -2, 70, -2))
/* 1313 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1314 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1315 */                 .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1316 */                   .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING)
/* 1317 */                   .addGroup(jPanel11Layout.createSequentialGroup()
/* 1318 */                     .addComponent(this.jSpinner1, -2, 70, -2)
/* 1319 */                     .addGap(18, 18, 18)
/* 1320 */                     .addComponent(this.jSpinner2, -2, 70, -2)
/* 1321 */                     .addGap(18, 18, 18)
/* 1322 */                     .addComponent(this.jSpinner4, -2, 70, -2)
/* 1323 */                     .addGap(18, 18, 18)
/* 1324 */                     .addComponent(this.jSpinner5, -2, 70, -2)
/* 1325 */                     .addGap(18, 18, 18)
/* 1326 */                     .addComponent(this.jSpinner6, -2, 70, -2)
/* 1327 */                     .addGap(18, 18, 18)
/* 1328 */                     .addComponent(this.jSpinner7, -2, 70, -2)
/* 1329 */                     .addGap(18, 18, 18)
/* 1330 */                     .addComponent(this.jSpinner8, -2, 70, -2)))
/* 1331 */                 .addComponent(this.jLabel33, -2, 182, -2))
/* 1332 */               .addGap(0, 0, 32767)))
/* 1333 */           .addContainerGap())
/* 1334 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1335 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 1336 */             .addGap(8, 8, 8)
/* 1337 */             .addComponent(this.jLabel65, -1, 600, 32767)
/* 1338 */             .addContainerGap())));
/*      */     
/* 1340 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1342 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1343 */           .addGap(31, 31, 31)
/* 1344 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 1345 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1346 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1347 */             .addComponent(this.jSpinner1, -2, 44, -2)
/* 1348 */             .addComponent(this.jSpinner2, -2, 44, -2)
/* 1349 */             .addComponent(this.jSpinner4, -2, 44, -2)
/* 1350 */             .addComponent(this.jSpinner5, -2, 44, -2)
/* 1351 */             .addComponent(this.jSpinner6, -2, 44, -2)
/* 1352 */             .addComponent(this.jSpinner7, -2, 44, -2)
/* 1353 */             .addComponent(this.jSpinner8, -2, 44, -2))
/* 1354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1355 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1356 */             .addComponent(this.jLabel26)
/* 1357 */             .addComponent(this.jLabel27)
/* 1358 */             .addComponent(this.jLabel28)
/* 1359 */             .addComponent(this.jLabel29)
/* 1360 */             .addComponent(this.jLabel30)
/* 1361 */             .addComponent(this.jLabel31)
/* 1362 */             .addComponent(this.jLabel32))
/* 1363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1364 */           .addComponent(this.jLabel33)
/* 1365 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1366 */           .addComponent(this.jScrollPane2, -1, 119, 32767)
/* 1367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1368 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1369 */             .addComponent(this.jButton3)
/* 1370 */             .addComponent(this.jButton4))
/* 1371 */           .addContainerGap())
/* 1372 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1373 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 1374 */             .addComponent(this.jLabel65, -2, 31, -2)
/* 1375 */             .addGap(0, 270, 32767))));
/*      */ 
/*      */     
/* 1378 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1379 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1380 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1382 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */     
/* 1384 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1386 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1387 */           .addComponent(this.jPanel11, -2, -1, -2)
/* 1388 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1391 */     this.jDialog3.setTitle("Tablas de subsidio");
/* 1392 */     this.jDialog3.setModal(true);
/*      */     
/* 1394 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/* 1396 */     this.jLabel66.setFont(new Font("Tahoma", 1, 16));
/* 1397 */     this.jLabel66.setForeground(new Color(0, 102, 102));
/* 1398 */     this.jLabel66.setHorizontalAlignment(0);
/* 1399 */     this.jLabel66.setText("Tablas del subsidio");
/*      */     
/* 1401 */     this.jButton5.setMnemonic('C');
/* 1402 */     this.jButton5.setText("Modificar");
/* 1403 */     this.jButton5.setToolTipText("Cerrar (Alt+C)");
/* 1404 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1406 */             Nominas.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1410 */     this.jButton6.setMnemonic('G');
/* 1411 */     this.jButton6.setText("Nueva");
/* 1412 */     this.jButton6.setToolTipText("Guardar (Alt+G)");
/* 1413 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1415 */             Nominas.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1419 */     this.jLabel36.setFont(new Font("Tahoma", 3, 12));
/* 1420 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/* 1421 */     this.jLabel36.setHorizontalAlignment(2);
/* 1422 */     this.jLabel36.setText("Tablas");
/*      */     
/* 1424 */     this.jList1.setModel(new AbstractListModel() {
/* 1425 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/* 1426 */           public int getSize() { return this.strings.length; }
/* 1427 */           public Object getElementAt(int i) { return this.strings[i]; }
/*      */         });
/* 1429 */     this.jScrollPane4.setViewportView(this.jList1);
/*      */     
/* 1431 */     this.jButton7.setMnemonic('C');
/* 1432 */     this.jButton7.setText("Cerrar");
/* 1433 */     this.jButton7.setToolTipText("Cerrar (Alt+C)");
/* 1434 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1436 */             Nominas.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1440 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1441 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1442 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1443 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1444 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1445 */           .addContainerGap()
/* 1446 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1447 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1448 */               .addComponent(this.jLabel36, -2, 102, -2)
/* 1449 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1450 */               .addComponent(this.jScrollPane4, -2, 82, -2)
/* 1451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1452 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1453 */                 .addComponent(this.jButton6, -2, 114, -2)
/* 1454 */                 .addComponent(this.jButton5, -2, 114, -2)
/* 1455 */                 .addComponent(this.jButton7, -2, 114, -2)))
/* 1456 */             .addComponent(this.jSeparator10, -2, 308, -2))
/* 1457 */           .addContainerGap(-1, 32767))
/* 1458 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1459 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1460 */             .addContainerGap(-1, 32767)
/* 1461 */             .addComponent(this.jLabel66, -2, 309, -2)
/* 1462 */             .addGap(499, 499, 499))));
/*      */     
/* 1464 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1465 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1466 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1467 */           .addGap(31, 31, 31)
/* 1468 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1469 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1470 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1471 */             .addComponent(this.jLabel36)
/* 1472 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1473 */               .addGroup(jPanel12Layout.createSequentialGroup()
/* 1474 */                 .addComponent(this.jButton6)
/* 1475 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1476 */                 .addComponent(this.jButton5)
/* 1477 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1478 */                 .addComponent(this.jButton7))
/* 1479 */               .addComponent(this.jScrollPane4, -2, 105, -2)))
/* 1480 */           .addContainerGap(-1, 32767))
/* 1481 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1482 */           .addGroup(jPanel12Layout.createSequentialGroup()
/* 1483 */             .addComponent(this.jLabel66, -2, 31, -2)
/* 1484 */             .addGap(0, 132, 32767))));
/*      */ 
/*      */     
/* 1487 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1488 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1489 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1490 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1491 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1492 */           .addComponent(this.jPanel12, -1, 328, 32767)
/* 1493 */           .addGap(0, 0, 0)));
/*      */     
/* 1495 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1496 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1497 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1498 */           .addComponent(this.jPanel12, -1, -1, 32767)
/* 1499 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1502 */     this.jDialog4.setTitle("Ingresa los datos");
/* 1503 */     this.jDialog4.setModal(true);
/*      */     
/* 1505 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 1507 */     this.jLabel67.setFont(new Font("Tahoma", 1, 16));
/* 1508 */     this.jLabel67.setForeground(new Color(0, 102, 102));
/* 1509 */     this.jLabel67.setHorizontalAlignment(0);
/* 1510 */     this.jLabel67.setText("Capturar datos de la tabla");
/*      */     
/* 1512 */     this.jButton8.setMnemonic('C');
/* 1513 */     this.jButton8.setText("Cerrar");
/* 1514 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/* 1515 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1517 */             Nominas.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1521 */     this.jButton9.setMnemonic('G');
/* 1522 */     this.jButton9.setText("Guardar");
/* 1523 */     this.jButton9.setToolTipText("Guardar (Alt+G)");
/* 1524 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1526 */             Nominas.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1530 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Límite Inferior", "Cuota Fija", "% Sobre excedente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1538 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1543 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1546 */     this.jScrollPane10.setViewportView(this.jTable1);
/*      */     
/* 1548 */     this.jLabel40.setFont(new Font("Tahoma", 3, 12));
/* 1549 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 1550 */     this.jLabel40.setHorizontalAlignment(2);
/* 1551 */     this.jLabel40.setText("Limite Inferior");
/*      */     
/* 1553 */     this.jLabel41.setFont(new Font("Tahoma", 3, 12));
/* 1554 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 1555 */     this.jLabel41.setHorizontalAlignment(2);
/* 1556 */     this.jLabel41.setText("Cuota Fija");
/*      */     
/* 1558 */     this.jLabel43.setFont(new Font("Tahoma", 3, 12));
/* 1559 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/* 1560 */     this.jLabel43.setHorizontalAlignment(2);
/* 1561 */     this.jLabel43.setText("<html>% sobre el excedente de limite inferior</html>");
/*      */     
/* 1563 */     this.jFormattedTextField3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00%"))));
/*      */     
/* 1565 */     this.jButton10.setText("Agregar");
/* 1566 */     this.jButton10.setToolTipText("Agregar Linea (Alt+A)");
/* 1567 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1569 */             Nominas.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1573 */     this.jLabel44.setFont(new Font("Tahoma", 3, 12));
/* 1574 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/* 1575 */     this.jLabel44.setHorizontalAlignment(2);
/* 1576 */     this.jLabel44.setText("Identificador");
/*      */     
/* 1578 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1579 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1580 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1581 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1582 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1583 */           .addContainerGap()
/* 1584 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1585 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1586 */               .addGroup(jPanel13Layout.createSequentialGroup()
/* 1587 */                 .addComponent(this.jButton9, -2, 114, -2)
/* 1588 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1589 */                 .addComponent(this.jButton8, -2, 114, -2))
/* 1590 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1591 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 1592 */                   .addComponent(this.jLabel40, -2, 102, -2)
/* 1593 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1594 */                   .addComponent(this.jFormattedTextField1, -2, 145, -2))
/* 1595 */                 .addComponent(this.jScrollPane10, -2, 0, 32767)
/* 1596 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 1597 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1598 */                     .addGroup(jPanel13Layout.createSequentialGroup()
/* 1599 */                       .addComponent(this.jLabel43, -2, 111, -2)
/* 1600 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1601 */                       .addComponent(this.jFormattedTextField3, -2, 142, -2))
/* 1602 */                     .addGroup(jPanel13Layout.createSequentialGroup()
/* 1603 */                       .addComponent(this.jLabel41, -2, 102, -2)
/* 1604 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1605 */                       .addComponent(this.jFormattedTextField2, -2, 145, -2)))
/* 1606 */                   .addGap(18, 18, 18)
/* 1607 */                   .addComponent(this.jButton10, -2, 94, -2))
/* 1608 */                 .addComponent(this.jSeparator11)))
/* 1609 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1610 */               .addComponent(this.jLabel44, -2, 102, -2)
/* 1611 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1612 */               .addComponent(this.jTextField11, -2, 134, -2)))
/* 1613 */           .addContainerGap(-1, 32767))
/* 1614 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1615 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1616 */             .addContainerGap(-1, 32767)
/* 1617 */             .addComponent(this.jLabel67, -2, 372, -2)
/* 1618 */             .addGap(238, 238, 238))));
/*      */     
/* 1620 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1621 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1622 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1623 */           .addGap(31, 31, 31)
/* 1624 */           .addComponent(this.jSeparator11, -2, 10, -2)
/* 1625 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1626 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1627 */             .addComponent(this.jLabel44)
/* 1628 */             .addComponent(this.jTextField11, -2, -1, -2))
/* 1629 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767)
/* 1630 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1631 */             .addComponent(this.jLabel40)
/* 1632 */             .addComponent(this.jFormattedTextField1, -2, -1, -2))
/* 1633 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1634 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1635 */             .addComponent(this.jLabel41)
/* 1636 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/* 1637 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1638 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1639 */             .addComponent(this.jLabel43, -2, 55, -2)
/* 1640 */             .addComponent(this.jFormattedTextField3, -2, -1, -2)
/* 1641 */             .addComponent(this.jButton10))
/* 1642 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1643 */           .addComponent(this.jScrollPane10, -2, 92, -2)
/* 1644 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1645 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1646 */             .addComponent(this.jButton8)
/* 1647 */             .addComponent(this.jButton9))
/* 1648 */           .addGap(36, 36, 36))
/* 1649 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1650 */           .addGroup(jPanel13Layout.createSequentialGroup()
/* 1651 */             .addComponent(this.jLabel67, -2, 31, -2)
/* 1652 */             .addGap(0, 331, 32767))));
/*      */ 
/*      */     
/* 1655 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1656 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1657 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1658 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1659 */         .addComponent(this.jPanel13, -1, 389, 32767));
/*      */     
/* 1661 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1663 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1664 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1665 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1668 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1669 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1671 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1672 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1673 */     this.jLabel54.setText("Nóminas");
/*      */     
/* 1675 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1676 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1678 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1679 */     this.jLabel48.setForeground(Color.red);
/* 1680 */     this.jLabel48.setHorizontalAlignment(0);
/* 1681 */     this.jLabel48.setText("t");
/* 1682 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1684 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1685 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1693 */     this.jTable3.setShowVerticalLines(false);
/* 1694 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1696 */             Nominas.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1699 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1701 */             Nominas.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1704 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1706 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1707 */     this.jButton23.setMnemonic('V');
/* 1708 */     this.jButton23.setText("Ver");
/* 1709 */     this.jButton23.setToolTipText("Clic para ver el detalle de una nómina (Alt+V)");
/* 1710 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1712 */             Nominas.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1716 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1717 */     this.jButton24.setMnemonic('N');
/* 1718 */     this.jButton24.setText("Nueva");
/* 1719 */     this.jButton24.setToolTipText("Crea nuevas Nóminas (Alt+N)");
/* 1720 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1722 */             Nominas.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1726 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1727 */     this.jButton25.setMnemonic('C');
/* 1728 */     this.jButton25.setText("Cancelar");
/* 1729 */     this.jButton25.setToolTipText("Cancelar Nóminas (debe estar en estatus \"<Por Autorizar>\") (Alt+C)");
/* 1730 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1732 */             Nominas.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1736 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1737 */     this.jButton26.setMnemonic('G');
/* 1738 */     this.jButton26.setText("Guardar Reporte");
/* 1739 */     this.jButton26.setToolTipText("Clic para exportar un reporte a excel (Alt+G)");
/* 1740 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1742 */             Nominas.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1746 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 1747 */     this.jLabel35.setHorizontalAlignment(4);
/* 1748 */     this.jLabel35.setText("SUMAS:");
/*      */     
/* 1750 */     this.jLabel37.setFont(new Font("Tahoma", 0, 10));
/* 1751 */     this.jLabel37.setHorizontalAlignment(4);
/* 1752 */     this.jLabel37.setText("$0.00");
/*      */     
/* 1754 */     this.jLabel38.setFont(new Font("Tahoma", 0, 10));
/* 1755 */     this.jLabel38.setHorizontalAlignment(4);
/* 1756 */     this.jLabel38.setText("$0.00");
/*      */     
/* 1758 */     this.jLabel39.setFont(new Font("Tahoma", 0, 10));
/* 1759 */     this.jLabel39.setHorizontalAlignment(4);
/* 1760 */     this.jLabel39.setText("$0.00");
/*      */     
/* 1762 */     this.jLabel42.setFont(new Font("Tahoma", 0, 10));
/* 1763 */     this.jLabel42.setHorizontalAlignment(4);
/* 1764 */     this.jLabel42.setText("$0.00");
/*      */     
/* 1766 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1767 */     this.jButton2.setMnemonic('I');
/* 1768 */     this.jButton2.setText("Imprimir");
/* 1769 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 1770 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1772 */             Nominas.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1776 */     this.jButton27.setMnemonic('G');
/* 1777 */     this.jButton27.setText("Tablas");
/* 1778 */     this.jButton27.setToolTipText("Clic para exportar un reporte a excel (Alt+G)");
/* 1779 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1781 */             Nominas.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1785 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1786 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1787 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1789 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1790 */           .addComponent(this.jScrollPane3)
/* 1791 */           .addContainerGap())
/* 1792 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 1793 */           .addContainerGap(-1, 32767)
/* 1794 */           .addComponent(this.jLabel35, -2, 68, -2)
/* 1795 */           .addGap(18, 18, 18)
/* 1796 */           .addComponent(this.jLabel42, -2, 77, -2)
/* 1797 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1798 */           .addComponent(this.jLabel39, -2, 77, -2)
/* 1799 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1800 */           .addComponent(this.jLabel38, -2, 77, -2)
/* 1801 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1802 */           .addComponent(this.jLabel37, -2, 77, -2)
/* 1803 */           .addGap(252, 252, 252))
/* 1804 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1805 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 1806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1807 */           .addComponent(this.jButton24, -2, 119, -2)
/* 1808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1809 */           .addComponent(this.jButton23, -2, 119, -2)
/* 1810 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1811 */           .addComponent(this.jButton25, -2, 119, -2)
/* 1812 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1813 */           .addComponent(this.jButton26)
/* 1814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1815 */           .addComponent(this.jButton27, -2, 150, -2)
/* 1816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 274, 32767)
/* 1817 */           .addComponent(this.jButton2, -2, 124, -2)
/* 1818 */           .addContainerGap()));
/*      */     
/* 1820 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1821 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1822 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1823 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1824 */             .addComponent(this.jLabel48)
/* 1825 */             .addComponent(this.jButton24, -2, 28, -2)
/* 1826 */             .addComponent(this.jButton23, -2, 28, -2)
/* 1827 */             .addComponent(this.jButton25, -2, 28, -2)
/* 1828 */             .addComponent(this.jButton26, -2, 28, -2)
/* 1829 */             .addComponent(this.jButton2)
/* 1830 */             .addComponent(this.jButton27, -2, 28, -2))
/* 1831 */           .addGap(7, 7, 7)
/* 1832 */           .addComponent(this.jScrollPane3, -1, 107, 32767)
/* 1833 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1834 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1835 */             .addComponent(this.jLabel37)
/* 1836 */             .addComponent(this.jLabel38)
/* 1837 */             .addComponent(this.jLabel39)
/* 1838 */             .addComponent(this.jLabel42)
/* 1839 */             .addComponent(this.jLabel35))));
/*      */ 
/*      */     
/* 1842 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1843 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Nóminas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1845 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1847 */             Nominas.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1851 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1852 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1853 */     this.jLabel15.setHorizontalAlignment(0);
/* 1854 */     this.jLabel15.setText("Folio");
/*      */     
/* 1856 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1857 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1858 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1860 */             Nominas.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1864 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1865 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1866 */     this.jLabel46.setHorizontalAlignment(0);
/* 1867 */     this.jLabel46.setText("Estatus");
/*      */     
/* 1869 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 1870 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1871 */     this.jLabel47.setHorizontalAlignment(0);
/* 1872 */     this.jLabel47.setText("Usuario");
/*      */     
/* 1874 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1875 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 1876 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1878 */             Nominas.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1882 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1884 */             Nominas.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1888 */     this.jLabel34.setFont(new Font("Tahoma", 3, 12));
/* 1889 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/* 1890 */     this.jLabel34.setHorizontalAlignment(0);
/* 1891 */     this.jLabel34.setText("Semana");
/*      */     
/* 1893 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1894 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1895 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1896 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1897 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1898 */           .addContainerGap()
/* 1899 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1900 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1901 */             .addComponent(this.jTextField1, -2, 81, -2))
/* 1902 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1903 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1904 */             .addComponent(this.jLabel34, -1, -1, 32767)
/* 1905 */             .addComponent(this.jTextField2, -1, 124, 32767))
/* 1906 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1907 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1908 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1909 */             .addComponent(this.jComboBox8, -2, 104, -2))
/* 1910 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1911 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1912 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 1913 */             .addComponent(this.jComboBox11, -2, 152, -2))
/* 1914 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1916 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1917 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1918 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1919 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1920 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1921 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 1922 */               .addGap(8, 8, 8)
/* 1923 */               .addComponent(this.jLabel15, -1, -1, 32767))
/* 1924 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1925 */               .addComponent(this.jComboBox11, -2, -1, -2)
/* 1926 */               .addGap(8, 8, 8)
/* 1927 */               .addComponent(this.jLabel47))
/* 1928 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1929 */               .addComponent(this.jComboBox8, -2, -1, -2)
/* 1930 */               .addGap(8, 8, 8)
/* 1931 */               .addComponent(this.jLabel46, -1, -1, 32767))
/* 1932 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1933 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 1934 */               .addGap(8, 8, 8)
/* 1935 */               .addComponent(this.jLabel34, -1, -1, 32767)))
/* 1936 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1939 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 1940 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1942 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1943 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1944 */     this.jDateChooser4.setIcon(this.icon);
/* 1945 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1946 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1948 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1949 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1950 */     this.jDateChooser5.setIcon(this.icon);
/* 1951 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1953 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 1954 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 1955 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 1956 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1958 */             Nominas.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1961 */             Nominas.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1964 */             Nominas.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1968 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 1969 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 1970 */     this.jLabel6.setHorizontalAlignment(0);
/* 1971 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 1972 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1974 */             Nominas.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1977 */             Nominas.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1980 */             Nominas.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1984 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 1985 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 1986 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 1987 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1989 */             Nominas.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1992 */             Nominas.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1995 */             Nominas.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1999 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 2000 */     this.jLabel1.setForeground(Color.red);
/* 2001 */     this.jLabel1.setHorizontalAlignment(4);
/* 2002 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 2004 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 2005 */     this.jLabel4.setForeground(Color.red);
/* 2006 */     this.jLabel4.setHorizontalAlignment(0);
/* 2007 */     this.jLabel4.setText("AL");
/*      */     
/* 2009 */     this.jButton1.setMnemonic('F');
/* 2010 */     this.jButton1.setText("Filtrar");
/* 2011 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2012 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2014 */             Nominas.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2018 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2019 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2020 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2021 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2022 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2023 */           .addContainerGap()
/* 2024 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 2025 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2026 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2027 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2028 */           .addComponent(this.jLabel4)
/* 2029 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2030 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2032 */           .addComponent(this.jButton1)
/* 2033 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2034 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 2035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2036 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 2037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2038 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 2039 */           .addContainerGap(21, 32767)));
/*      */     
/* 2041 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2042 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2043 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2044 */           .addContainerGap()
/* 2045 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2046 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2047 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2048 */               .addGap(1, 1, 1)
/* 2049 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2050 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 2051 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2052 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 2053 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 2054 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 2055 */                   .addComponent(this.jButton1))
/* 2056 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2057 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 2058 */                   .addGap(1, 1, 1))
/* 2059 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 2062 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2063 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2064 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2065 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2066 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 2067 */           .addContainerGap()
/* 2068 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2069 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2070 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2071 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 2072 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 2073 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2074 */               .addComponent(this.jLabel54, -1, -1, 32767)))
/* 2075 */           .addContainerGap()));
/*      */     
/* 2077 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2079 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2080 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2081 */             .addComponent(this.jLabel54, -1, -1, 32767)
/* 2082 */             .addComponent(this.jPanel2, -1, -1, 32767))
/* 2083 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2084 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 2085 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2086 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 2087 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2090 */     GroupLayout layout = new GroupLayout(this);
/* 2091 */     setLayout(layout);
/* 2092 */     layout.setHorizontalGroup(layout
/* 2093 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2094 */         .addGap(0, 1313, 32767)
/* 2095 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2096 */           .addGroup(layout.createSequentialGroup()
/* 2097 */             .addContainerGap()
/* 2098 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2099 */             .addContainerGap())));
/*      */     
/* 2101 */     layout.setVerticalGroup(layout
/* 2102 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2103 */         .addGap(0, 341, 32767)
/* 2104 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2105 */           .addGroup(layout.createSequentialGroup()
/* 2106 */             .addGap(10, 10, 10)
/* 2107 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2108 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2136 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 2137 */     StyleConstants.setBold(attrs, true);
/* 2138 */     this.jTextPane1.setText("");
/*      */     try {
/* 2140 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "FLETES Y MATERIALES FORSIS, S.A. DE C.V.\n", attrs);
/* 2141 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "AUTOPISTA CADEREYTA-MONTEREY K.M. 32.5\n", attrs);
/* 2142 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "CADEREYTA JIMENEZ, NUEVO LEON\n\n", attrs);
/* 2143 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "67450", attrs);
/* 2144 */     } catch (BadLocationException ex) {
/* 2145 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */ 
/*      */     
/* 2149 */     sacarMayor();
/* 2150 */     sacarNumSem();
/* 2151 */     sacarFechas();
/* 2152 */     this.jRadioButton1.setSelected(true);
/* 2153 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 2224 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 2225 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2226 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 2230 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 2234 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 2238 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2239 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2240 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 2244 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 2248 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 2252 */     Calendar ca = Calendar.getInstance();
/* 2253 */     Calendar fecha = Calendar.getInstance();
/* 2254 */     int aa = fecha.get(1);
/* 2255 */     int mm = fecha.get(2);
/* 2256 */     int dd = fecha.get(5);
/* 2257 */     if (dd == 1) {
/* 2258 */       if (mm == 0) {
/* 2259 */         mm = 11;
/* 2260 */         aa--;
/*      */       } else {
/* 2262 */         mm--;
/*      */       } 
/* 2264 */       int diasTotal = diasDelMes(mm, aa);
/* 2265 */       dd = diasTotal;
/*      */     } else {
/* 2267 */       dd--;
/*      */     } 
/* 2269 */     mm++;
/* 2270 */     String año = "" + aa;
/* 2271 */     String mes = "" + mm;
/* 2272 */     String dia = "" + dd;
/* 2273 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2274 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2276 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2277 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2278 */     } catch (ParseException ex) {
/* 2279 */       ex.printStackTrace();
/*      */     } 
/* 2281 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 2285 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 2289 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2293 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2310 */     this.jCheckBox4.setSelected(false);
/* 2311 */     if (this.jRadioButton1.isSelected()) {
/* 2312 */       this.jComboBox6.setEnabled(true);
/* 2313 */       consultar1();
/*      */     } else {
/*      */       
/* 2316 */       this.jComboBox6.setEnabled(false);
/* 2317 */       consultar2();
/*      */     } 
/* 2319 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2323 */     this.jFrame1.setVisible(false);
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
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {}
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
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2413 */     String[] datos = { "CLAVE", "NOMBRE COMPLETO", "FECHA DE INGRESO", "DÍAS LABORADOS", "DÍAS X LEY", "DEPARTAMENTO", "SALARIO", "AGUINALDO" };
/* 2414 */     this.esc = new EscribirReporte("AGUINALDO (IMSS)", this.jTable5, datos, this.USUARIO);
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
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {}
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
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {}
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
/*      */   private void jTable4KeyPressed(KeyEvent evt) {}
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
/*      */   private void jTable5KeyPressed(KeyEvent evt) {
/* 2476 */     int valor = this.jTable5.getSelectedColumn();
/* 2477 */     int p = evt.getKeyCode();
/* 2478 */     if (p == 10 && this.jTable5.getSelectedColumn() == 7) {
/* 2479 */       this.jSpinner1.setValue("A");
/* 2480 */       this.jSpinner2.setValue("A");
/* 2481 */       this.jSpinner4.setValue("A");
/* 2482 */       this.jSpinner5.setValue("A");
/* 2483 */       this.jSpinner6.setValue("A");
/* 2484 */       this.jSpinner7.setValue("A");
/* 2485 */       this.jSpinner8.setValue("A");
/*      */       
/* 2487 */       int fila = this.jTable5.getSelectedRow();
/* 2488 */       int col = this.jTable5.getSelectedColumn();
/* 2489 */       GregorianCalendar cal = (GregorianCalendar)this.jDateChooser13.getCalendar();
/* 2490 */       int diaL = cal.get(7);
/* 2491 */       String dia = regresaDiaLetra(diaL);
/* 2492 */       this.jLabel26.setText(dia + " : " + dia);
/* 2493 */       cal.add(5, 1);
/* 2494 */       diaL = cal.get(7);
/* 2495 */       dia = regresaDiaLetra(diaL);
/* 2496 */       this.jLabel27.setText(dia + " : " + dia);
/* 2497 */       cal.add(5, 1);
/* 2498 */       diaL = cal.get(7);
/* 2499 */       dia = regresaDiaLetra(diaL);
/* 2500 */       this.jLabel28.setText(dia + " : " + dia);
/* 2501 */       cal.add(5, 1);
/* 2502 */       diaL = cal.get(7);
/* 2503 */       dia = regresaDiaLetra(diaL);
/* 2504 */       this.jLabel29.setText(dia + " : " + dia);
/* 2505 */       cal.add(5, 1);
/* 2506 */       diaL = cal.get(7);
/* 2507 */       dia = regresaDiaLetra(diaL);
/* 2508 */       this.jLabel30.setText(dia + " : " + dia);
/* 2509 */       cal.add(5, 1);
/* 2510 */       diaL = cal.get(7);
/* 2511 */       dia = regresaDiaLetra(diaL);
/* 2512 */       this.jLabel31.setText(dia + " : " + dia);
/* 2513 */       cal.add(5, 1);
/* 2514 */       diaL = cal.get(7);
/* 2515 */       dia = regresaDiaLetra(diaL);
/* 2516 */       this.jLabel32.setText(dia + " : " + dia);
/*      */       
/* 2518 */       if (this.jLabel26.getText().contains("D")) {
/* 2519 */         this.jSpinner1.setValue("D");
/*      */       }
/* 2521 */       else if (this.jLabel27.getText().contains("D")) {
/* 2522 */         this.jSpinner2.setValue("D");
/*      */       }
/* 2524 */       else if (this.jLabel28.getText().contains("D")) {
/* 2525 */         this.jSpinner4.setValue("D");
/*      */       }
/* 2527 */       else if (this.jLabel29.getText().contains("D")) {
/* 2528 */         this.jSpinner5.setValue("D");
/*      */       }
/* 2530 */       else if (this.jLabel30.getText().contains("D")) {
/* 2531 */         this.jSpinner6.setValue("D");
/*      */       }
/* 2533 */       else if (this.jLabel31.getText().contains("D")) {
/* 2534 */         this.jSpinner7.setValue("D");
/*      */       }
/* 2536 */       else if (this.jLabel32.getText().contains("D")) {
/* 2537 */         this.jSpinner8.setValue("D");
/*      */       } 
/*      */       
/* 2540 */       this.jDialog2.setVisible(true);
/*      */     } 
/* 2542 */     if (valor > 9 || valor * 80 < 680) {
/* 2543 */       this.jScrollPane7.getHorizontalScrollBar().setValue(valor * 80);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jScrollPane7MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 2552 */     if (evt.getClickCount() != 2 || 
/* 2553 */       this.jRadioButton1.isSelected());
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
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 2566 */     if (this.jRadioButton1.isSelected()) {
/* 2567 */       consultar1();
/*      */     } else {
/*      */       
/* 2570 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 2575 */     if (this.jRadioButton1.isSelected()) {
/* 2576 */       consultar1();
/*      */     } else {
/*      */       
/* 2579 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2584 */     if (this.jRadioButton1.isSelected()) {
/* 2585 */       consultar1();
/*      */     } else {
/*      */       
/* 2588 */       consultar2();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 2593 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 2597 */     if (this.jRadioButton1.isSelected()) {
/* 2598 */       pasarEmpleado1();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2607 */     consultar1();
/*      */   }
/*      */   
/*      */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 2611 */     if (this.jCheckBox4.isSelected() == true) {
/* 2612 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 2613 */         this.jTable6.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } else {
/*      */       
/* 2617 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 2618 */         this.jTable6.setValueAt(Boolean.valueOf(false), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField9ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jScrollPane8MouseClicked(MouseEvent evt) {
/* 2628 */     String valor = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), this.jTable5.getSelectedColumn()));
/* 2629 */     this.jTable5.setToolTipText("<html>" + this.jTable5.getColumnName(this.jTable5.getSelectedColumn()) + ": <b>" + valor + "</b></html>");
/*      */   }
/*      */   
/*      */   private void jTable5MouseClicked(MouseEvent evt) {
/* 2633 */     int ind = this.jTable5.getSelectedRow();
/* 2634 */     if (ind > 0) {
/* 2635 */       this.jLabel25.setText(String.valueOf(this.jTable5.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable5.getValueAt(ind, 0)));
/*      */     } else {
/*      */       
/* 2638 */       this.jLabel25.setText(String.valueOf(this.jTable5.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable5.getValueAt(ind, 0)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable5KeyReleased(KeyEvent evt) {
/* 2643 */     int ind = this.jTable5.getSelectedRow();
/* 2644 */     if (ind > 0) {
/* 2645 */       this.jLabel25.setText(String.valueOf(this.jTable5.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable5.getValueAt(ind, 0)));
/*      */     } else {
/*      */       
/* 2648 */       this.jLabel25.setText(String.valueOf(this.jTable5.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable5.getValueAt(ind, 0)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2653 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2657 */     verTablas();
/* 2658 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2666 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2670 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Límite Inferior", "Cuota Fija", "% Sobre excedente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2677 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2681 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2684 */     this.jScrollPane10.setViewportView(this.jTable1);
/* 2685 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2686 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2687 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */     
/* 2689 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2693 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2697 */     DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 2698 */     Object[] nuevo = { this.jFormattedTextField1.getText(), this.jFormattedTextField2.getText(), this.jFormattedTextField3.getText() };
/* 2699 */     temp.addRow(nuevo);
/* 2700 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2701 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2702 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2703 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2704 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2705 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2709 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas guardar la nueva tabla de subsidio?", "Guardar Tabla", 0, 1, this.PREG);
/* 2710 */     if (res == 0) {
/* 2711 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2712 */         this.con.inserSinMsj("insert into ");
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2718 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2720 */             Nominas.this.jTextGanado(Nominas.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2723 */             Nominas.this.jTextPerdido(Nominas.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 2727 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2729 */             Nominas.this.jTextGanado(Nominas.this.jFormattedTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2732 */             Nominas.this.jTextPerdido(Nominas.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 2736 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2738 */             Nominas.this.jTextGanado(Nominas.this.jFormattedTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2741 */             Nominas.this.jTextPerdido(Nominas.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/* 2745 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2747 */             Nominas.this.jTextGanado(Nominas.this.jFormattedTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2750 */             Nominas.this.jTextPerdido(Nominas.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/*      */     
/* 2754 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2756 */             Nominas.this.jTextGanado(Nominas.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2759 */             Nominas.this.jTextPerdido(Nominas.this.jTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/* 2763 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2765 */             Nominas.this.jTextGanado(Nominas.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2768 */             Nominas.this.jTextPerdido(Nominas.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 2771 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2773 */             Nominas.this.jTextGanado(Nominas.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2776 */             Nominas.this.jTextPerdido(Nominas.this.jTextField4, evt);
/*      */           }
/*      */         });
/*      */     
/* 2780 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2782 */             Nominas.this.jTextGanado(Nominas.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2785 */             Nominas.this.jTextPerdido(Nominas.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 2788 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2790 */             Nominas.this.jTextGanado(Nominas.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2793 */             Nominas.this.jTextPerdido(Nominas.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 2796 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2798 */             Nominas.this.jTextGanado(Nominas.this.jTextField8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2801 */             Nominas.this.jTextPerdido(Nominas.this.jTextField8, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 2806 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2808 */             Nominas.this.jTextGanado(Nominas.this.jComboBox8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2811 */             Nominas.this.jTextPerdido(Nominas.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*      */     
/* 2815 */     this.jComboBox11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2817 */             Nominas.this.jTextGanado(Nominas.this.jComboBox11, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2820 */             Nominas.this.jTextPerdido(Nominas.this.jComboBox11, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 2828 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 2831 */     campo.setBackground(Color.white);
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar() {
/* 2836 */     Date fecha1 = this.jDateChooser4.getDate();
/* 2837 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 2839 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2840 */     String cadenaFecha = "";
/* 2841 */     cadenaFecha = formato.format(fecha1);
/* 2842 */     String AÑO = cadenaFecha.substring(0, 4);
/* 2843 */     String MES = cadenaFecha.substring(4, 6);
/* 2844 */     String DIA = cadenaFecha.substring(6, 8);
/* 2845 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 2847 */     cadenaFecha = formato.format(fecha2);
/* 2848 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2849 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2850 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 2851 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 2852 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
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
/* 2893 */     this.con.consultar("count(num_nomina)", "nominas", "where fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num_nomina desc");
/* 2894 */     int totreg = Integer.parseInt(this.con.Campo);
/* 2895 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 2896 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 2897 */           .buscarReg(11, totreg, "num_nomina,fecha_creacion,semana,periodo_pago,tipo,num_empleados,total_imss,total_comp,total_neto,usuario,estatus", "nominas", "where fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num_nomina desc"), (Object[])new String[] { "Núm", "F. Elaboró", "Sem", "Periodo", "Tipo", "No. Emp", "Total Imss", "Total Comp", "Total Neto", "Usuario", "Estatus" })
/*      */         {
/*      */ 
/*      */           
/* 2901 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2905 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
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
/*      */   public int diasDelMes(int mes, int año) {
/* 3009 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3017 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3023 */         return 30;
/*      */       
/*      */       case 1:
/* 3026 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3028 */           return 29;
/*      */         }
/* 3030 */         return 28;
/*      */     } 
/*      */     
/* 3033 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void Nominas(String usu) {
/* 3038 */     this.USUARIO = usu;
/* 3039 */     this.panel.setViewportView(this);
/*      */ 
/*      */ 
/*      */     
/* 3043 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarMayor() {
/* 3048 */     this.con.consultar("max(num_nomina)", "nominas", "");
/* 3049 */     String mayor = this.con.Campo;
/* 3050 */     int MAYOR = 0;
/*      */     try {
/* 3052 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 3054 */     catch (NumberFormatException e) {
/* 3055 */       MAYOR = 0;
/*      */     } 
/* 3057 */     MAYOR++;
/* 3058 */     if (MAYOR < 10) {
/* 3059 */       this.jTextField6.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/*      */     }
/* 3061 */     else if (MAYOR < 100) {
/* 3062 */       this.jTextField6.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/*      */     }
/* 3064 */     else if (MAYOR < 1000) {
/* 3065 */       this.jTextField6.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/*      */     }
/* 3067 */     else if (MAYOR < 10000) {
/* 3068 */       this.jTextField6.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/*      */       
/* 3071 */       this.jTextField6.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarNumSem() {
/* 3076 */     this.con.consultar("max(semana)", "nominas", "where num_nomina=(select max(num_nomina) from nominas)");
/* 3077 */     String mayor = this.con.Campo;
/* 3078 */     int MAYOR = 0;
/*      */     try {
/* 3080 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 3082 */     catch (NumberFormatException e) {
/* 3083 */       MAYOR = 0;
/*      */     } 
/* 3085 */     MAYOR++;
/* 3086 */     this.jSpinner3.setValue(Integer.valueOf(MAYOR));
/*      */   }
/*      */   
/*      */   public void sacarFechas() {
/* 3090 */     this.encontrado = this.con.consultar("fecha_inicio", "nominas", "where num_nomina=(select max(num_nomina) from nominas)");
/* 3091 */     String[] fechas = this.con.regresaReg("fecha_inicio,fecha_final", "nominas", "where num_nomina=(select max(num_nomina) from nominas)", 2);
/* 3092 */     String FECHA1 = fechas[1];
/* 3093 */     if (this.encontrado) {
/* 3094 */       String año = FECHA1.substring(0, 4);
/* 3095 */       String mes = FECHA1.substring(5, 7);
/* 3096 */       String dia = FECHA1.substring(8, 10);
/* 3097 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3098 */       String strFecha = año + "-" + año + "-" + mes;
/* 3099 */       Date fecha = null;
/*      */       try {
/* 3101 */         fecha = formatoDelTexto.parse(strFecha);
/* 3102 */         this.jDateChooser13.setDate(fecha);
/* 3103 */         Calendar cal1 = this.jDateChooser13.getCalendar();
/* 3104 */         cal1.add(5, 1);
/* 3105 */         this.jDateChooser13.setDate(cal1.getTime());
/* 3106 */         cal1.add(5, 6);
/* 3107 */         this.jDateChooser14.setDate(cal1.getTime());
/*      */       }
/* 3109 */       catch (ParseException ex) {
/* 3110 */         ex.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar1() {
/* 3117 */     String num_ope = this.jTextField9.getText();
/* 3118 */     String tipo = "";
/* 3119 */     String depa = "";
/*      */     
/* 3121 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 3122 */       tipo = "empleado";
/*      */     }
/* 3124 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 3125 */       tipo = "funcionario";
/*      */     } else {
/*      */       
/* 3128 */       tipo = "";
/*      */     } 
/*      */     
/* 3131 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3132 */       depa = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/*      */     
/* 3135 */     this.encontrado = this.con.consultar("count(ap_pat)", "departamentos,Empleados", "where empleados.clave_depa=departamentos.clave_depa and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and actual=0 and clave_emp<>0 order by empleados.ap_pat");
/* 3136 */     int tot = Integer.parseInt(this.con.Campo);
/* 3137 */     this.jLabel20.setText("" + tot);
/* 3138 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 3139 */           .buscarReg(8, tot, "clave_emp,ap_pat,ap_mat,empleados.nombre,Ultimoingreso,salarioImss,salarioReal,departamentos.nombre", "departamentos,Empleados", "where empleados.clave_depa=departamentos.clave_depa and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and actual=0 and clave_emp<>0 order by empleados.ap_pat, empleados.ap_mat"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Salario IMSS", "Salario Real", "Departamento", "" })
/*      */         {
/*      */           
/* 3142 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, true };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3146 */             return this.canEdit[columnIndex];
/*      */           }
/* 3148 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3152 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 3155 */     eliminarColumna1(2, 1, "Paterno");
/* 3156 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 3158 */     this.jTable6.setShowVerticalLines(false);
/* 3159 */     this.jScrollPane9.setViewportView(this.jTable6);
/* 3160 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3161 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 3163 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 3164 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 3165 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 3166 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 3167 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(110);
/* 3168 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(110);
/*      */     
/* 3170 */     this.jTable6.getColumnModel().getColumn(6).setPreferredWidth(40);
/* 3171 */     this.jTable6.getColumnModel().getColumn(6).setMaxWidth(40);
/*      */     
/* 3173 */     this.jTable6.getColumnModel().moveColumn(6, 0);
/* 3174 */     this.jTable6.setSelectionMode(0);
/*      */     
/* 3176 */     this.jTable6.setAutoCreateRowSorter(true);
/* 3177 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */ 
/*      */     
/* 3180 */     this.jTable6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 3181 */     this.jTable6.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 3182 */     this.jTable6.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 3186 */     this.con.consultar("count(nombre)", "departamentos", "");
/* 3187 */     String[] datos = this.con.regresaCol("nombre", "departamentos", "order by nombre", Integer.parseInt(this.con.Campo));
/* 3188 */     this.jComboBox6.removeAllItems();
/* 3189 */     this.jComboBox6.addItem("<GENERAL>");
/* 3190 */     for (int i = 0; i < datos.length; i++) {
/* 3191 */       this.jComboBox6.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar2() {
/* 3197 */     String num_ope = this.jTextField9.getText();
/* 3198 */     String tipo = "";
/*      */     
/* 3200 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 3201 */       tipo = "operador";
/*      */     }
/* 3203 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 3204 */       tipo = "funcionario";
/*      */     } else {
/*      */       
/* 3207 */       tipo = "";
/*      */     } 
/*      */     
/* 3210 */     this.encontrado = this.con.consultar("count(ap_pat)", "operadores", "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and tipoTrabajador like '%" + tipo + "%' and actual=0 and num_ope<>0 order by ap_pat");
/* 3211 */     int tot = Integer.parseInt(this.con.Campo);
/* 3212 */     this.jLabel20.setText("" + tot);
/* 3213 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 3214 */           .buscarReg(6, tot, "num_ope,ap_pat,ap_mat,nombre,UltimaFechaIngreso,salarioImssLetra", "operadores", "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and tipoTrabajador like '%" + tipo + "%' and actual=0 and num_ope<>0 order by ap_pat"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Salario IMSS", "" })
/*      */         {
/*      */           
/* 3217 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, true };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3221 */             return this.canEdit[columnIndex];
/*      */           }
/* 3223 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3227 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 3230 */     eliminarColumna1(2, 1, "Paterno");
/* 3231 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 3233 */     this.jTable6.setShowVerticalLines(false);
/* 3234 */     this.jScrollPane9.setViewportView(this.jTable6);
/* 3235 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3236 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/* 3237 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 3238 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 3239 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 3240 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 3241 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(40);
/* 3242 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(40);
/*      */     
/* 3244 */     this.jTable6.getColumnModel().moveColumn(4, 0);
/*      */     
/* 3246 */     this.jTable6.setSelectionMode(0);
/* 3247 */     this.jTable6.setAutoCreateRowSorter(true);
/* 3248 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void pasarEmpleado1() {
/* 3254 */     for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 3255 */       boolean noEsta = false;
/* 3256 */       int indice = 0;
/* 3257 */       String val = String.valueOf(this.jTable6.getValueAt(i, 0));
/* 3258 */       if (val.equals("true")) {
/* 3259 */         String clave = String.valueOf(this.jTable6.getValueAt(i, 1));
/* 3260 */         clave = sacarClave(clave);
/* 3261 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 3262 */           String valor = String.valueOf(this.jTable5.getValueAt(j, 0));
/* 3263 */           if (clave.equals(valor)) {
/* 3264 */             noEsta = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 3268 */         if (!noEsta) {
/* 3269 */           String nombre = String.valueOf(this.jTable6.getValueAt(i, 2));
/*      */           
/* 3271 */           Vector<String> miVector = new Vector<>(); int k;
/* 3272 */           for (k = 0; k < this.jTable5.getRowCount(); k++) {
/* 3273 */             miVector.add(String.valueOf(this.jTable5.getValueAt(k, 2)));
/*      */           }
/* 3275 */           miVector.add(nombre);
/* 3276 */           Collections.sort(miVector);
/*      */           
/* 3278 */           for (k = 0; k < miVector.size(); k++) {
/* 3279 */             if (((String)miVector.get(k)).equals(nombre)) {
/* 3280 */               indice = k;
/*      */               break;
/*      */             } 
/*      */           } 
/* 3284 */           String CLAVE = String.valueOf(this.jTable6.getValueAt(i, 1));
/* 3285 */           String[] datosEmp = this.con.regresaReg("nss,rfc,ultimoIngreso,infonavitLetra", "empleados", "where clave_emp=" + CLAVE, 4);
/* 3286 */           String RFC = datosEmp[1].substring(0, 10);
/*      */           
/* 3288 */           String canti = String.valueOf(this.jTable6.getValueAt(i, 4));
/* 3289 */           String valorP = "";
/* 3290 */           for (int m = 0; m < canti.length(); m++) {
/* 3291 */             if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 3292 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 3295 */           double salarioDiario = Double.parseDouble(valorP);
/* 3296 */           double SDI = salarioDiario * 1.0452D;
/* 3297 */           this.cantidad.setValue(Double.valueOf(SDI));
/* 3298 */           String SDILetra = this.cantidad.getText();
/*      */ 
/*      */           
/* 3301 */           String sueldoLetra = sacarSueldo(7, salarioDiario);
/*      */           
/* 3303 */           DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/*      */ 
/*      */           
/* 3306 */           Object[] nuevo = { sacarClave(String.valueOf(this.jTable6.getValueAt(i, 1))), datosEmp[0], this.jTable6.getValueAt(i, 2), datosEmp[1], RFC, datosEmp[2], this.jTable6.getValueAt(indice, 6), Integer.valueOf(7), this.jTable6.getValueAt(indice, 4), sueldoLetra, SDILetra, "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", Integer.valueOf(9), "$0.00", "$0.00", datosEmp[3], "$0.00", Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(21), Integer.valueOf(22) };
/* 3307 */           temp.insertRow(indice, nuevo);
/* 3308 */           this.jTable5.setSelectionMode(0);
/* 3309 */           this.jLabel11.setText("" + this.jTable5.getRowCount());
/*      */           
/* 3311 */           this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 3312 */           this.jTable5.getColumnModel().getColumn(0).setMaxWidth(70);
/* 3313 */           this.jTable5.getColumnModel().getColumn(1).setPreferredWidth(85);
/* 3314 */           this.jTable5.getColumnModel().getColumn(1).setMaxWidth(85);
/* 3315 */           this.jTable5.getColumnModel().getColumn(3).setPreferredWidth(160);
/* 3316 */           this.jTable5.getColumnModel().getColumn(3).setMaxWidth(160);
/* 3317 */           this.jTable5.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 3318 */           this.jTable5.getColumnModel().getColumn(4).setMaxWidth(100);
/* 3319 */           this.jTable5.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 3320 */           this.jTable5.getColumnModel().getColumn(5).setMaxWidth(80);
/* 3321 */           this.jTable5.getColumnModel().getColumn(7).setPreferredWidth(60);
/* 3322 */           this.jTable5.getColumnModel().getColumn(7).setMaxWidth(60);
/* 3323 */           this.jTable5.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 3324 */           this.jTable5.getColumnModel().getColumn(8).setMaxWidth(80);
/* 3325 */           this.jTable5.getColumnModel().getColumn(9).setPreferredWidth(80);
/* 3326 */           this.jTable5.getColumnModel().getColumn(9).setMaxWidth(80);
/* 3327 */           this.jTable5.getColumnModel().getColumn(10).setPreferredWidth(80);
/* 3328 */           this.jTable5.getColumnModel().getColumn(10).setMaxWidth(80);
/* 3329 */           this.jTable5.getColumnModel().getColumn(11).setPreferredWidth(80);
/* 3330 */           this.jTable5.getColumnModel().getColumn(11).setMaxWidth(80);
/* 3331 */           this.jTable5.getColumnModel().getColumn(12).setPreferredWidth(110);
/* 3332 */           this.jTable5.getColumnModel().getColumn(12).setMaxWidth(110);
/* 3333 */           this.jTable5.getColumnModel().getColumn(13).setPreferredWidth(100);
/* 3334 */           this.jTable5.getColumnModel().getColumn(13).setMaxWidth(100);
/* 3335 */           this.jTable5.getColumnModel().getColumn(14).setPreferredWidth(120);
/* 3336 */           this.jTable5.getColumnModel().getColumn(14).setMaxWidth(120);
/* 3337 */           this.jTable5.getColumnModel().getColumn(15).setPreferredWidth(80);
/* 3338 */           this.jTable5.getColumnModel().getColumn(15).setMaxWidth(80);
/* 3339 */           this.jTable5.getColumnModel().getColumn(16).setPreferredWidth(100);
/* 3340 */           this.jTable5.getColumnModel().getColumn(16).setMaxWidth(100);
/* 3341 */           this.jTable5.getColumnModel().getColumn(17).setPreferredWidth(110);
/* 3342 */           this.jTable5.getColumnModel().getColumn(17).setMaxWidth(110);
/* 3343 */           this.jTable5.getColumnModel().getColumn(18).setPreferredWidth(115);
/* 3344 */           this.jTable5.getColumnModel().getColumn(18).setMaxWidth(115);
/* 3345 */           this.jTable5.getColumnModel().getColumn(19).setPreferredWidth(75);
/* 3346 */           this.jTable5.getColumnModel().getColumn(19).setMaxWidth(75);
/* 3347 */           this.jTable5.getColumnModel().getColumn(20).setPreferredWidth(100);
/* 3348 */           this.jTable5.getColumnModel().getColumn(20).setMaxWidth(100);
/* 3349 */           this.jTable5.getColumnModel().getColumn(21).setPreferredWidth(170);
/* 3350 */           this.jTable5.getColumnModel().getColumn(21).setMaxWidth(170);
/* 3351 */           this.jTable5.getColumnModel().getColumn(22).setPreferredWidth(170);
/* 3352 */           this.jTable5.getColumnModel().getColumn(22).setMaxWidth(170);
/* 3353 */           this.jTable5.getColumnModel().getColumn(23).setPreferredWidth(100);
/* 3354 */           this.jTable5.getColumnModel().getColumn(23).setMaxWidth(100);
/* 3355 */           this.jTable5.getColumnModel().getColumn(24).setPreferredWidth(135);
/* 3356 */           this.jTable5.getColumnModel().getColumn(24).setMaxWidth(135);
/* 3357 */           this.jTable5.getColumnModel().getColumn(25).setPreferredWidth(60);
/* 3358 */           this.jTable5.getColumnModel().getColumn(25).setMaxWidth(60);
/* 3359 */           this.jTable5.getColumnModel().getColumn(26).setPreferredWidth(180);
/* 3360 */           this.jTable5.getColumnModel().getColumn(26).setMaxWidth(180);
/* 3361 */           this.jTable5.getColumnModel().getColumn(27).setPreferredWidth(95);
/* 3362 */           this.jTable5.getColumnModel().getColumn(27).setMaxWidth(95);
/* 3363 */           this.jTable5.getColumnModel().getColumn(28).setPreferredWidth(60);
/* 3364 */           this.jTable5.getColumnModel().getColumn(28).setMaxWidth(60);
/* 3365 */           this.jTable5.getColumnModel().getColumn(29).setPreferredWidth(60);
/* 3366 */           this.jTable5.getColumnModel().getColumn(29).setMaxWidth(60);
/* 3367 */           this.jTable5.getColumnModel().getColumn(30).setPreferredWidth(120);
/* 3368 */           this.jTable5.getColumnModel().getColumn(30).setMaxWidth(120);
/* 3369 */           this.jTable5.getColumnModel().getColumn(31).setPreferredWidth(60);
/* 3370 */           this.jTable5.getColumnModel().getColumn(31).setMaxWidth(60);
/* 3371 */           this.jTable5.getColumnModel().getColumn(32).setPreferredWidth(90);
/* 3372 */           this.jTable5.getColumnModel().getColumn(32).setMaxWidth(90);
/* 3373 */           this.jTable5.getColumnModel().getColumn(33).setPreferredWidth(90);
/* 3374 */           this.jTable5.getColumnModel().getColumn(33).setMaxWidth(90);
/*      */           
/* 3376 */           this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3377 */           this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3378 */           this.jTable5.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3379 */           this.jTable5.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3380 */           this.jTable5.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3381 */           this.jTable5.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3382 */           this.jTable5.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3383 */           this.jTable5.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3384 */           this.jTable5.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3385 */           this.jTable5.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3386 */           this.jTable5.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3387 */           this.jTable5.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3388 */           this.jTable5.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3389 */           this.jTable5.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 3390 */           this.jTable5.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/* 3391 */           this.jTable5.getColumnModel().getColumn(15).setCellRenderer(this.celda2);
/* 3392 */           this.jTable5.getColumnModel().getColumn(16).setCellRenderer(this.celda2);
/* 3393 */           this.jTable5.getColumnModel().getColumn(17).setCellRenderer(this.celda2);
/* 3394 */           this.jTable5.getColumnModel().getColumn(18).setCellRenderer(this.celda2);
/* 3395 */           this.jTable5.getColumnModel().getColumn(19).setCellRenderer(this.celda2);
/* 3396 */           this.jTable5.getColumnModel().getColumn(20).setCellRenderer(this.celda2);
/* 3397 */           this.jTable5.getColumnModel().getColumn(21).setCellRenderer(this.celda2);
/* 3398 */           this.jTable5.getColumnModel().getColumn(22).setCellRenderer(this.celda2);
/* 3399 */           this.jTable5.getColumnModel().getColumn(23).setCellRenderer(this.celda2);
/* 3400 */           this.jTable5.getColumnModel().getColumn(24).setCellRenderer(this.celda2);
/* 3401 */           this.jTable5.getColumnModel().getColumn(25).setCellRenderer(this.celda2);
/* 3402 */           this.jTable5.getColumnModel().getColumn(26).setCellRenderer(this.celda2);
/* 3403 */           this.jTable5.getColumnModel().getColumn(27).setCellRenderer(this.celda2);
/* 3404 */           this.jTable5.getColumnModel().getColumn(28).setCellRenderer(this.celda2);
/* 3405 */           this.jTable5.getColumnModel().getColumn(29).setCellRenderer(this.celda2);
/* 3406 */           this.jTable5.getColumnModel().getColumn(30).setCellRenderer(this.celda2);
/* 3407 */           this.jTable5.getColumnModel().getColumn(31).setCellRenderer(this.celda2);
/* 3408 */           this.jTable5.getColumnModel().getColumn(32).setCellRenderer(this.celda2);
/* 3409 */           this.jTable5.getColumnModel().getColumn(33).setCellRenderer(this.celda2);
/*      */           
/* 3411 */           for (int n = 0; n < this.jTable5.getRowCount(); n++) {
/* 3412 */             sacarSubtotal(n);
/* 3413 */             sacarPercepNoDeduc(n);
/* 3414 */             sacarPercepDeduc(n);
/* 3415 */             percepaGravar(n);
/* 3416 */             totalaGravar(n);
/*      */           } 
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
/*      */   public String sacarSueldo(int dias, double salario) {
/* 3509 */     double sal = dias * salario;
/* 3510 */     this.cantidad.setValue(Double.valueOf(sal));
/* 3511 */     return this.cantidad.getText();
/*      */   }
/*      */ 
/*      */   
/*      */   public String regresaDiaLetra(int diaL) {
/* 3516 */     String dia = "";
/* 3517 */     if (diaL == 1) {
/* 3518 */       dia = "D";
/*      */     }
/* 3520 */     else if (diaL == 2) {
/* 3521 */       dia = "L";
/*      */     }
/* 3523 */     else if (diaL == 3) {
/* 3524 */       dia = "M";
/*      */     }
/* 3526 */     else if (diaL == 4) {
/* 3527 */       dia = "M";
/*      */     }
/* 3529 */     else if (diaL == 5) {
/* 3530 */       dia = "J";
/*      */     }
/* 3532 */     else if (diaL == 6) {
/* 3533 */       dia = "V";
/*      */     }
/* 3535 */     else if (diaL == 7) {
/* 3536 */       dia = "S";
/*      */     } 
/* 3538 */     return dia;
/*      */   }
/*      */   public synchronized void eliminarColumna1(int origen, int destino, String nombreCol) {
/* 3541 */     int cont = this.jTable6.getRowCount();
/* 3542 */     String[] registros = new String[cont]; int i;
/* 3543 */     for (i = 0; i < cont; i++) {
/* 3544 */       registros[i] = this.jTable6.getValueAt(i, destino).toString();
/*      */     }
/* 3546 */     for (i = 0; i < cont; i++) {
/* 3547 */       registros[i] = registros[i] + " " + registros[i];
/* 3548 */       this.jTable6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 3550 */     TableColumn columna = this.jTable6.getColumn(nombreCol);
/* 3551 */     this.jTable6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 3555 */     String mayor = clave;
/* 3556 */     int MAYOR = Integer.parseInt(mayor);
/* 3557 */     String clave1 = "";
/* 3558 */     if (MAYOR < 10) {
/* 3559 */       clave1 = "-0000" + MAYOR;
/*      */     }
/* 3561 */     else if (MAYOR < 100) {
/* 3562 */       clave1 = "-000" + MAYOR;
/*      */     }
/* 3564 */     else if (MAYOR < 1000) {
/* 3565 */       clave1 = "-00" + MAYOR;
/*      */     }
/* 3567 */     else if (MAYOR < 10000) {
/* 3568 */       clave1 = "-0" + MAYOR;
/*      */     } else {
/*      */       
/* 3571 */       clave1 = "-" + MAYOR;
/*      */     } 
/* 3573 */     return this.DIRECTIVA + this.DIRECTIVA;
/*      */   }
/*      */   public void sacarSubtotal(int indice) {
/* 3576 */     double salarioDiario = 0.0D;
/* 3577 */     double sueldo = 0.0D;
/* 3578 */     double sdi = 0.0D;
/* 3579 */     double horas_extra = 0.0D;
/* 3580 */     double horas_extra2 = 0.0D;
/* 3581 */     double horas_extra3 = 0.0D;
/* 3582 */     double gratificacion = 0.0D;
/* 3583 */     double otrosFiscal = 0.0D;
/* 3584 */     double SUBTOTAL = 0.0D;
/*      */     
/* 3586 */     String canti = String.valueOf(this.jTable5.getValueAt(indice, 9));
/* 3587 */     String valorP = ""; int j;
/* 3588 */     for (j = 0; j < canti.length(); j++) {
/* 3589 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3590 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3593 */     sueldo = Double.parseDouble(valorP);
/*      */     
/* 3595 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 11));
/* 3596 */     valorP = "";
/* 3597 */     for (j = 0; j < canti.length(); j++) {
/* 3598 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3599 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3602 */     horas_extra = Double.parseDouble(valorP);
/*      */     
/* 3604 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 12));
/* 3605 */     valorP = "";
/* 3606 */     for (j = 0; j < canti.length(); j++) {
/* 3607 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3608 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3611 */     horas_extra2 = Double.parseDouble(valorP);
/*      */     
/* 3613 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 13));
/* 3614 */     valorP = "";
/* 3615 */     for (j = 0; j < canti.length(); j++) {
/* 3616 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3617 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3620 */     horas_extra3 = Double.parseDouble(valorP);
/*      */     
/* 3622 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 14));
/* 3623 */     valorP = "";
/* 3624 */     for (j = 0; j < canti.length(); j++) {
/* 3625 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3626 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3629 */     gratificacion = Double.parseDouble(valorP);
/*      */     
/* 3631 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 15));
/* 3632 */     valorP = "";
/* 3633 */     for (j = 0; j < canti.length(); j++) {
/* 3634 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3635 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3638 */     otrosFiscal = Double.parseDouble(valorP);
/* 3639 */     SUBTOTAL = sueldo + horas_extra + horas_extra2 + horas_extra3 + gratificacion + otrosFiscal;
/* 3640 */     this.cantidad.setValue(Double.valueOf(SUBTOTAL));
/* 3641 */     this.jTable5.setValueAt(this.cantidad.getText(), indice, 16);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPercepNoDeduc(int indice) {
/* 3646 */     double horas_extra2 = 0.0D;
/*      */     
/* 3648 */     double gratificacion = 0.0D;
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
/* 3660 */     String canti = String.valueOf(this.jTable5.getValueAt(indice, 12));
/* 3661 */     String valorP = ""; int j;
/* 3662 */     for (j = 0; j < canti.length(); j++) {
/* 3663 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3664 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3667 */     horas_extra2 = Double.parseDouble(valorP);
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
/* 3678 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 14));
/* 3679 */     valorP = "";
/* 3680 */     for (j = 0; j < canti.length(); j++) {
/* 3681 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3682 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3685 */     gratificacion = Double.parseDouble(valorP);
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
/* 3696 */     double sumas = (horas_extra2 + gratificacion) * 0.53D;
/* 3697 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 3698 */     this.jTable5.setValueAt(this.cantidad.getText(), indice, 21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPercepDeduc(int indice) {
/* 3703 */     double horas_extra2 = 0.0D;
/*      */     
/* 3705 */     double gratificacion = 0.0D;
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
/* 3717 */     String canti = String.valueOf(this.jTable5.getValueAt(indice, 12));
/* 3718 */     String valorP = ""; int j;
/* 3719 */     for (j = 0; j < canti.length(); j++) {
/* 3720 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3721 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3724 */     horas_extra2 = Double.parseDouble(valorP);
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
/* 3735 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 14));
/* 3736 */     valorP = "";
/* 3737 */     for (j = 0; j < canti.length(); j++) {
/* 3738 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3739 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3742 */     gratificacion = Double.parseDouble(valorP);
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
/* 3753 */     double sumas = (horas_extra2 + gratificacion) * 0.47D;
/* 3754 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 3755 */     this.jTable5.setValueAt(this.cantidad.getText(), indice, 22);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void percepaGravar(int indice) {
/* 3761 */     double horas_extra3 = 0.0D;
/* 3762 */     double gratificacion = 0.0D;
/*      */ 
/*      */ 
/*      */     
/* 3766 */     String canti = String.valueOf(this.jTable5.getValueAt(indice, 13));
/* 3767 */     String valorP = ""; int j;
/* 3768 */     for (j = 0; j < canti.length(); j++) {
/* 3769 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3770 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3773 */     horas_extra3 = Double.parseDouble(valorP);
/*      */     
/* 3775 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 14));
/* 3776 */     valorP = "";
/* 3777 */     for (j = 0; j < canti.length(); j++) {
/* 3778 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3779 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3782 */     gratificacion = Double.parseDouble(valorP);
/*      */     
/* 3784 */     double sumas = (horas_extra3 + gratificacion) * 0.47D;
/* 3785 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 3786 */     this.jTable5.setValueAt(this.cantidad.getText(), indice, 23);
/*      */   }
/*      */   
/*      */   public void totalaGravar(int indice) {
/* 3790 */     double percepExcentas = 0.0D;
/* 3791 */     double percepGravables = 0.0D;
/*      */     
/* 3793 */     String canti = String.valueOf(this.jTable5.getValueAt(indice, 22));
/* 3794 */     String valorP = ""; int j;
/* 3795 */     for (j = 0; j < canti.length(); j++) {
/* 3796 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3797 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3800 */     percepExcentas = Double.parseDouble(valorP);
/*      */     
/* 3802 */     canti = String.valueOf(this.jTable5.getValueAt(indice, 23));
/* 3803 */     valorP = "";
/* 3804 */     for (j = 0; j < canti.length(); j++) {
/* 3805 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3806 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3809 */     percepGravables = Double.parseDouble(valorP);
/*      */     
/* 3811 */     double sumas = (percepExcentas + percepGravables) * 0.47D;
/* 3812 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 3813 */     this.jTable5.setValueAt(this.cantidad.getText(), indice, 24);
/*      */   }
/*      */   
/*      */   public void verTablas() {
/* 3817 */     this.con.consultar("count(distinct(identificador))", "nominas_tablas", "");
/* 3818 */     String[] tablas = this.con.regresaCol("distinct(identificador)", "nominas_tablas", "", Integer.parseInt(this.con.Campo));
/* 3819 */     this.jList1 = new JList<>(tablas);
/* 3820 */     this.jScrollPane4.setViewportView(this.jList1);
/*      */   }
/*      */   
/*      */   public class CeldaRender extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3825 */       setEnabled((table == null || table.isEnabled()));
/* 3826 */       setHorizontalAlignment(4);
/* 3827 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3828 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender2
/*      */     extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3835 */       setEnabled((table == null || table.isEnabled()));
/* 3836 */       if (row % 2 == 0) {
/* 3837 */         setBackground(new Color(194, 213, 151));
/* 3838 */         setForeground(Color.black);
/*      */       } else {
/*      */         
/* 3841 */         setForeground(Color.black);
/* 3842 */         setBackground((Color)null);
/*      */       } 
/*      */       
/* 3845 */       if (column == 1 || column == 5 || column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12 || column == 13 || column == 14 || column == 15 || column == 16 || column == 17 || column == 18 || column == 19 || column == 20 || column == 21 || column == 22) {
/* 3846 */         setHorizontalAlignment(4);
/*      */       } else {
/*      */         
/* 3849 */         setHorizontalAlignment(2);
/*      */       } 
/* 3851 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3852 */       return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Nominas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */