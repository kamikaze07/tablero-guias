/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.Vector;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerListModel;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.JTableHeader;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableColumnModel;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ 
/*      */ public class NominasComplementos extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   47 */   Date fechaActual = new Date();
/*   48 */   Date fechaInicio = null;
/*   49 */   Date fecha = new Date();
/*   50 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   51 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   52 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   53 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   54 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   55 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   56 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   57 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   58 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   59 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   60 */   JFrame padre = null;
/*   61 */   JTabbedPane fichas = null;
/*   62 */   String[] CLAVES = null;
/*   63 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   65 */   DefaultTableModel modelo = new DefaultTableModel();
/*   66 */   CeldaRender celda = new CeldaRender();
/*   67 */   CeldaRender2 celda2 = new CeldaRender2();
/*   68 */   CeldaRender3 celda3 = new CeldaRender3();
/*   69 */   String[] DIRECTIVA = new String[2];
/*      */   EscribirReporte esc;
/*   71 */   MensajePop mensajeTry = null;
/*   72 */   double salarioRealTotal = 0.0D;
/*   73 */   double gratificacionesTotal = 0.0D;
/*   74 */   double descuentosTotal = 0.0D;
/*   75 */   double[] gratificacionesIndividualTotal = null; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton14; private JButton jButton2; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox4; private JComboBox jComboBox11; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox8; private JDateChooser jDateChooser15; private JDateChooser jDateChooser16; private JDateChooser jDateChooser17; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JFormattedTextField jFormattedTextField1;
/*   76 */   double[] descuentosIndividualTotal = null; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFrame jFrame2; private JLabel jLabel1; private JLabel jLabel15; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58;
/*      */   
/*      */   public NominasComplementos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   79 */     this.mensajeTry = mensajeTry;
/*   80 */     String año = "2010";
/*   81 */     String mes = "10";
/*   82 */     String dia = "10";
/*   83 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   84 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   86 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   87 */     } catch (ParseException ex) {
/*   88 */       ex.printStackTrace();
/*      */     } 
/*   90 */     this.padre = padre;
/*   91 */     fichas = fichas;
/*   92 */     initComponents();
/*   93 */     this.USUARIO = USUARIO;
/*   94 */     panelito.setViewportView(this);
/*   95 */     this.panel = panelito;
/*   96 */     colorear();
/*      */     
/*   98 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   99 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  100 */     this.jLabel5.setCursor(micursor);
/*  101 */     this.jLabel6.setCursor(micursor);
/*  102 */     this.jLabel7.setCursor(micursor);
/*      */     
/*  104 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  105 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*      */     
/*  107 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  108 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  109 */     editFormat.setGroupingUsed(false);
/*  110 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  111 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  112 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  113 */     enFormat.setAllowsInvalid(true);
/*  114 */     this.cantidad.setFormatterFactory(currFactory);
/*  115 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  116 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  117 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*      */     
/*  119 */     this.cantidad.setValue(Integer.valueOf(0));
/*  120 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  121 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  122 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*  123 */     consultar();
/*      */ 
/*      */     
/*  126 */     this.DIRECTIVA = this.con.regresaReg("directiva,sucursal", "configuraciones", "", 2);
/*      */     
/*  128 */     int w = this.tama.width;
/*  129 */     int h = this.tama.height;
/*  130 */     int rw = (w - 980) / 2;
/*  131 */     int rh = (h - 650) / 2;
/*      */     
/*  133 */     rw = (w - 920) / 2;
/*  134 */     rh = (h - 630) / 2;
/*  135 */     this.jFrame2.setLocation(rw, rh);
/*  136 */     this.jFrame2.setSize(920, 630);
/*  137 */     this.jFrame2.setVisible(false);
/*  138 */     this.jFrame2.setExtendedState(6);
/*      */     
/*  140 */     rw = (w - 933) / 2;
/*  141 */     rh = (h - 480) / 2;
/*  142 */     this.jDialog1.setLocation(rw, rh);
/*  143 */     this.jDialog1.setSize(933, 480);
/*  144 */     this.jDialog1.setResizable(false);
/*  145 */     this.jDialog1.setVisible(false);
/*      */     
/*  147 */     rw = (w - 635) / 2;
/*  148 */     rh = (h - 335) / 2;
/*  149 */     this.jDialog2.setLocation(rw, rh);
/*  150 */     this.jDialog2.setSize(635, 335);
/*  151 */     this.jDialog2.setResizable(false);
/*  152 */     this.jDialog2.setVisible(false);
/*      */     
/*  154 */     rw = (w - 350) / 2;
/*  155 */     rh = (h - 190) / 2;
/*  156 */     this.jDialog3.setLocation(rw, rh);
/*  157 */     this.jDialog3.setSize(350, 190);
/*  158 */     this.jDialog3.setResizable(false);
/*  159 */     this.jDialog3.setVisible(false);
/*      */     
/*  161 */     rw = (w - 400) / 2;
/*  162 */     rh = (h - 390) / 2;
/*  163 */     this.jDialog4.setLocation(rw, rh);
/*  164 */     this.jDialog4.setSize(400, 390);
/*  165 */     this.jDialog4.setResizable(false);
/*  166 */     this.jDialog4.setVisible(false);
/*      */     
/*  168 */     rw = (w - 400) / 2;
/*  169 */     rh = (h - 110) / 2;
/*  170 */     this.jDialog5.setLocation(rw, rh);
/*  171 */     this.jDialog5.setSize(400, 110);
/*  172 */     this.jDialog5.setResizable(false);
/*  173 */     this.jDialog5.setVisible(false);
/*      */     
/*  175 */     rw = (w - 300) / 2;
/*  176 */     rh = (h - 180) / 2;
/*  177 */     this.jDialog6.setLocation(rw, rh);
/*  178 */     this.jDialog6.setSize(300, 180);
/*  179 */     this.jDialog6.setResizable(false);
/*  180 */     this.jDialog6.setVisible(false);
/*      */     
/*  182 */     this.buttonGroup1.add(this.jRadioButton3);
/*  183 */     this.buttonGroup1.add(this.jRadioButton4);
/*  184 */     llenarCombos();
/*      */     
/*  186 */     this.jButton27.setVisible(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  249 */     this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(70);
/*  250 */     this.jTable7.getColumnModel().getColumn(0).setMaxWidth(70);
/*  251 */     this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(85);
/*  252 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(85);
/*  253 */     this.jTable7.getColumnModel().getColumn(3).setPreferredWidth(160);
/*  254 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(160);
/*  255 */     this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(80);
/*  256 */     this.jTable7.getColumnModel().getColumn(5).setMaxWidth(80);
/*  257 */     this.jTable7.getColumnModel().getColumn(6).setPreferredWidth(75);
/*  258 */     this.jTable7.getColumnModel().getColumn(6).setMaxWidth(75);
/*  259 */     this.jTable7.getColumnModel().getColumn(7).setPreferredWidth(75);
/*  260 */     this.jTable7.getColumnModel().getColumn(7).setMaxWidth(75);
/*  261 */     this.jTable7.getColumnModel().getColumn(8).setPreferredWidth(80);
/*  262 */     this.jTable7.getColumnModel().getColumn(8).setMaxWidth(80);
/*  263 */     this.jTable7.getColumnModel().getColumn(9).setPreferredWidth(80);
/*  264 */     this.jTable7.getColumnModel().getColumn(9).setMaxWidth(80);
/*  265 */     this.jTable7.getColumnModel().getColumn(10).setPreferredWidth(70);
/*  266 */     this.jTable7.getColumnModel().getColumn(10).setMaxWidth(70);
/*  267 */     this.jTable7.getColumnModel().getColumn(11).setPreferredWidth(90);
/*  268 */     this.jTable7.getColumnModel().getColumn(11).setMaxWidth(90);
/*  269 */     this.jTable7.getColumnModel().getColumn(12).setPreferredWidth(100);
/*  270 */     this.jTable7.getColumnModel().getColumn(12).setMaxWidth(100);
/*  271 */     this.jTable7.getColumnModel().getColumn(13).setPreferredWidth(90);
/*  272 */     this.jTable7.getColumnModel().getColumn(13).setMaxWidth(90);
/*  273 */     this.jTable7.getColumnModel().getColumn(14).setPreferredWidth(90);
/*  274 */     this.jTable7.getColumnModel().getColumn(14).setMaxWidth(90);
/*  275 */     this.jTable7.getColumnModel().getColumn(15).setPreferredWidth(90);
/*  276 */     this.jTable7.getColumnModel().getColumn(15).setMaxWidth(90);
/*      */     
/*  278 */     this.con.consultar("count(nombre_usu)", "usuarios", "where contrasena<>''");
/*  279 */     String[] datos = this.con.regresaCol("nombre_usu", "usuarios", "where contrasena<>'' order by nombre_usu", Integer.parseInt(this.con.Campo));
/*  280 */     this.jComboBox11.removeAllItems();
/*  281 */     this.jComboBox11.addItem("TODOS");
/*  282 */     for (int i = 0; i < datos.length; i++)
/*  283 */       this.jComboBox11.addItem(datos[i]); 
/*      */   }
/*      */   private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel80; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JList jList1; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel36;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   private JPanel jPanel7;
/*      */   private JRadioButton jRadioButton3;
/*      */   private JRadioButton jRadioButton4;
/*      */   private JScrollPane jScrollPane10;
/*      */   private JScrollPane jScrollPane11;
/*      */   private JScrollPane jScrollPane12;
/*      */   private JScrollPane jScrollPane13;
/*      */   private JScrollPane jScrollPane2;
/*      */   private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   private JScrollPane jScrollPane5;
/*      */   private JScrollPane jScrollPane6;
/*      */   private JScrollPane jScrollPane9;
/*      */   private JSeparator jSeparator10;
/*      */   private JSeparator jSeparator11;
/*      */   private JSeparator jSeparator12;
/*      */   private JSeparator jSeparator8;
/*      */   private JSeparator jSeparator9;
/*      */   private JSpinner jSpinner1;
/*      */   private JSpinner jSpinner2;
/*      */   private JSpinner jSpinner3;
/*      */   private JSpinner jSpinner4;
/*      */   private JSpinner jSpinner5;
/*      */   private JSpinner jSpinner6;
/*      */   private JSpinner jSpinner7;
/*      */   private JSpinner jSpinner8;
/*      */   private JSpinner jSpinner9;
/*      */   private JTable jTable1;
/*      */   private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable6;
/*      */   private JTable jTable7;
/*      */   private JTextArea jTextArea1;
/*      */   private JTextField jTextField1;
/*      */   private JTextField jTextField10;
/*      */   private JTextField jTextField11;
/*      */   private JTextField jTextField12;
/*      */   private JTextField jTextField13;
/*      */   private JTextField jTextField14;
/*      */   private JTextField jTextField15;
/*      */   private JTextField jTextField16;
/*      */   private JTextField jTextField17;
/*      */   private JTextField jTextField18;
/*      */   private JTextField jTextField2;
/*      */   private JTextField jTextField9;
/*      */   private JTextPane jTextPane2;
/*      */   
/*      */   private void initComponents() {
/*  336 */     this.cantidad = new JFormattedTextField();
/*  337 */     this.buttonGroup1 = new ButtonGroup();
/*  338 */     this.jPanel7 = new JPanel();
/*  339 */     this.jScrollPane5 = new JScrollPane();
/*  340 */     this.jPanel6 = new JPanel();
/*  341 */     this.jScrollPane6 = new JScrollPane();
/*  342 */     this.jTable4 = new JTable();
/*  343 */     this.jDialog1 = new CerrarVentana(this.jFrame2);
/*  344 */     this.jPanel10 = new JPanel();
/*  345 */     this.jLabel60 = new JLabel();
/*  346 */     this.jPanel36 = new JPanel();
/*  347 */     this.jScrollPane9 = new JScrollPane();
/*  348 */     this.jTable6 = new JTable();
/*  349 */     this.jLabel61 = new JLabel();
/*  350 */     this.jTextField9 = new JTextField();
/*  351 */     this.jLabel62 = new JLabel();
/*  352 */     this.jTextField10 = new JTextField();
/*  353 */     this.jLabel63 = new JLabel();
/*  354 */     this.jComboBox5 = new JComboBox();
/*  355 */     this.jButton29 = new JButton();
/*  356 */     this.jButton30 = new JButton();
/*  357 */     this.jLabel64 = new JLabel();
/*  358 */     this.jComboBox6 = new JComboBox();
/*  359 */     this.jLabel19 = new JLabel();
/*  360 */     this.jLabel20 = new JLabel();
/*  361 */     this.jCheckBox4 = new JCheckBox();
/*  362 */     this.jSeparator8 = new JSeparator();
/*  363 */     this.jDialog2 = new CerrarVentana(this.jFrame2);
/*  364 */     this.jPanel11 = new JPanel();
/*  365 */     this.jLabel65 = new JLabel();
/*  366 */     this.jSeparator9 = new JSeparator();
/*  367 */     this.jButton3 = new JButton();
/*  368 */     this.jButton4 = new JButton();
/*  369 */     this.jSpinner1 = new JSpinner();
/*  370 */     this.jSpinner2 = new JSpinner();
/*  371 */     this.jSpinner4 = new JSpinner();
/*  372 */     this.jSpinner5 = new JSpinner();
/*  373 */     this.jSpinner6 = new JSpinner();
/*  374 */     this.jSpinner7 = new JSpinner();
/*  375 */     this.jSpinner8 = new JSpinner();
/*  376 */     this.jLabel26 = new JLabel();
/*  377 */     this.jLabel27 = new JLabel();
/*  378 */     this.jLabel28 = new JLabel();
/*  379 */     this.jLabel29 = new JLabel();
/*  380 */     this.jLabel30 = new JLabel();
/*  381 */     this.jLabel31 = new JLabel();
/*  382 */     this.jLabel32 = new JLabel();
/*  383 */     this.jLabel33 = new JLabel();
/*  384 */     this.jScrollPane2 = new JScrollPane();
/*  385 */     this.jTextArea1 = new JTextArea();
/*  386 */     this.jLabel2 = new JLabel();
/*  387 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  388 */     this.jPanel12 = new JPanel();
/*  389 */     this.jLabel66 = new JLabel();
/*  390 */     this.jSeparator10 = new JSeparator();
/*  391 */     this.jButton5 = new JButton();
/*  392 */     this.jButton6 = new JButton();
/*  393 */     this.jLabel36 = new JLabel();
/*  394 */     this.jScrollPane4 = new JScrollPane();
/*  395 */     this.jList1 = new JList();
/*  396 */     this.jButton7 = new JButton();
/*  397 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  398 */     this.jPanel13 = new JPanel();
/*  399 */     this.jLabel67 = new JLabel();
/*  400 */     this.jSeparator11 = new JSeparator();
/*  401 */     this.jButton8 = new JButton();
/*  402 */     this.jButton9 = new JButton();
/*  403 */     this.jScrollPane10 = new JScrollPane();
/*  404 */     this.jTable1 = new JTable();
/*  405 */     this.jLabel40 = new JLabel();
/*  406 */     this.jLabel41 = new JLabel();
/*  407 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  408 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  409 */     this.jLabel43 = new JLabel();
/*  410 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  411 */     this.jButton10 = new JButton();
/*  412 */     this.jLabel44 = new JLabel();
/*  413 */     this.jTextField11 = new JTextField();
/*  414 */     this.jFrame2 = new JFrame();
/*  415 */     this.jPanel14 = new JPanel();
/*  416 */     this.jLabel45 = new JLabel();
/*  417 */     this.jLabel49 = new JLabel();
/*  418 */     this.jTextField12 = new JTextField();
/*  419 */     this.jLabel50 = new JLabel();
/*  420 */     this.jDateChooser15 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  421 */     this.jPanel15 = new JPanel();
/*  422 */     this.jLabel51 = new JLabel();
/*  423 */     this.jRadioButton3 = new JRadioButton();
/*  424 */     this.jRadioButton4 = new JRadioButton();
/*  425 */     this.jLabel96 = new JLabel();
/*  426 */     this.jDateChooser16 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  427 */     this.jLabel97 = new JLabel();
/*  428 */     this.jDateChooser17 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  429 */     this.jLabel98 = new JLabel();
/*  430 */     this.jSpinner9 = new JSpinner();
/*  431 */     this.jLabel52 = new JLabel();
/*  432 */     this.jTextField13 = new JTextField();
/*  433 */     this.jLabel53 = new JLabel();
/*  434 */     this.jTextField14 = new JTextField();
/*  435 */     this.jLabel58 = new JLabel();
/*  436 */     this.jTextField18 = new JTextField();
/*  437 */     this.jLabel55 = new JLabel();
/*  438 */     this.jButton21 = new JButton();
/*  439 */     this.jLabel56 = new JLabel();
/*  440 */     this.jLabel57 = new JLabel();
/*  441 */     this.jButton22 = new JButton();
/*  442 */     this.jButton28 = new JButton();
/*  443 */     this.jButton31 = new JButton();
/*  444 */     this.jButton32 = new JButton();
/*  445 */     this.jButton33 = new JButton();
/*  446 */     this.jPanel16 = new JPanel();
/*  447 */     this.jScrollPane11 = new JScrollPane();
/*  448 */     this.jTextPane2 = new JTextPane();
/*  449 */     this.jLabel68 = new JLabel();
/*  450 */     this.jTextField15 = new JTextField();
/*  451 */     this.jLabel69 = new JLabel();
/*  452 */     this.jTextField16 = new JTextField();
/*  453 */     this.jLabel70 = new JLabel();
/*  454 */     this.jTextField17 = new JTextField();
/*  455 */     this.jLabel71 = new JLabel();
/*  456 */     this.jLabel72 = new JLabel();
/*  457 */     this.jLabel73 = new JLabel();
/*  458 */     this.jScrollPane12 = new JScrollPane();
/*  459 */     this.jPanel18 = new JPanel();
/*  460 */     this.jScrollPane13 = new JScrollPane();
/*  461 */     this.jTable7 = new JTable();
/*  462 */     this.jLabel77 = new JLabel();
/*  463 */     this.jLabel78 = new JLabel();
/*  464 */     this.jLabel79 = new JLabel();
/*  465 */     this.jLabel80 = new JLabel();
/*  466 */     this.jDialog5 = new CerrarVentana(this.jFrame2);
/*  467 */     this.jPanel19 = new JPanel();
/*  468 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  469 */     this.jLabel74 = new JLabel();
/*  470 */     this.jDialog6 = new CerrarVentana(this.jFrame2);
/*  471 */     this.jPanel20 = new JPanel();
/*  472 */     this.jLabel75 = new JLabel();
/*  473 */     this.jSeparator12 = new JSeparator();
/*  474 */     this.jLabel76 = new JLabel();
/*  475 */     this.jSpinner3 = new JSpinner();
/*  476 */     this.jButton14 = new JButton();
/*  477 */     this.jPanel1 = new JPanel();
/*  478 */     this.jLabel54 = new JLabel();
/*  479 */     this.jPanel5 = new JPanel();
/*  480 */     this.jLabel48 = new JLabel();
/*  481 */     this.jScrollPane3 = new JScrollPane();
/*  482 */     this.jTable3 = new JTable();
/*  483 */     this.jButton23 = new JButton();
/*  484 */     this.jButton24 = new JButton();
/*  485 */     this.jButton25 = new JButton();
/*  486 */     this.jButton26 = new JButton();
/*  487 */     this.jLabel35 = new JLabel();
/*  488 */     this.jLabel37 = new JLabel();
/*  489 */     this.jLabel38 = new JLabel();
/*  490 */     this.jLabel39 = new JLabel();
/*  491 */     this.jLabel42 = new JLabel();
/*  492 */     this.jButton2 = new JButton();
/*  493 */     this.jButton27 = new JButton();
/*  494 */     this.jButton34 = new JButton();
/*  495 */     this.jPanel17 = new JPanel();
/*  496 */     this.jTextField1 = new JTextField();
/*  497 */     this.jLabel15 = new JLabel();
/*  498 */     this.jComboBox8 = new JComboBox();
/*  499 */     this.jLabel46 = new JLabel();
/*  500 */     this.jLabel47 = new JLabel();
/*  501 */     this.jComboBox11 = new JComboBox();
/*  502 */     this.jTextField2 = new JTextField();
/*  503 */     this.jLabel34 = new JLabel();
/*  504 */     this.jPanel2 = new JPanel();
/*  505 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  506 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  507 */     this.jLabel5 = new JLabel();
/*  508 */     this.jLabel6 = new JLabel();
/*  509 */     this.jLabel7 = new JLabel();
/*  510 */     this.jLabel1 = new JLabel();
/*  511 */     this.jLabel4 = new JLabel();
/*  512 */     this.jButton1 = new JButton();
/*      */     
/*  514 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/*  516 */     this.jScrollPane6.setHorizontalScrollBarPolicy(32);
/*  517 */     this.jScrollPane6.setPreferredSize(new Dimension(752, 419));
/*      */     
/*  519 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  520 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "No.", "Nombre Completo", "NSS", "F. de Ingreso", "Departamento", "CURP", "R.F.C.", "Salario Diario", "Días Lab.", "Sueldo", "SDI", "Años de Antiguedad", "Años", "Días Vacaciones", "Días Proporcionales", "Vacaciones", "Horas Extra", "Horas Extra Dobles", "Horas Extra Triple", "Gratificación", "Otros", "Subtotal", "Préstamos", "Otras deducciones", "Pensión", "Descuento IMSS", "Percepciones Excentas NO DEDUCIBLES", "Percepciones Excentas DEDUCIBLES", "Percepciones gabrables", "Total Grabal I.S.R.", "Limite Inf", "% S/EXCEDIDO", "Cuota Fija", "Subsidio para el Empleo", "I.S.P.T.", "Subtotal-neto", "Total-Neto" })
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
/*  531 */           Class[] types = new Class[] { Object.class, String.class, Integer.class, Object.class, String.class, String.class, String.class, Double.class, Integer.class, Double.class, Double.class, Integer.class, Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */           
/*  534 */           boolean[] canEdit = new boolean[] { 
/*      */               false, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true }; public Class getColumnClass(int columnIndex) {
/*  539 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  543 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  546 */     this.jTable4.setColumnSelectionAllowed(true);
/*  547 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/*  548 */     this.jTable4.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/*  550 */             NominasComplementos.this.jTable4KeyPressed(evt);
/*      */           }
/*      */         });
/*  553 */     this.jScrollPane6.setViewportView(this.jTable4);
/*  554 */     this.jTable4.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/*  556 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  557 */     this.jPanel6.setLayout(jPanel6Layout);
/*  558 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  559 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  560 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  561 */           .addContainerGap()
/*  562 */           .addComponent(this.jScrollPane6, -2, 2576, -2)
/*  563 */           .addContainerGap(-1, 32767)));
/*      */     
/*  565 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  567 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  568 */           .addContainerGap()
/*  569 */           .addComponent(this.jScrollPane6, -1, 526, 32767)
/*  570 */           .addGap(13, 13, 13)));
/*      */ 
/*      */     
/*  573 */     this.jScrollPane5.setViewportView(this.jPanel6);
/*      */     
/*  575 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  576 */     this.jPanel7.setLayout(jPanel7Layout);
/*  577 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  578 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  579 */         .addGap(0, 954, 32767)
/*  580 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  581 */           .addGroup(jPanel7Layout.createSequentialGroup()
/*  582 */             .addContainerGap()
/*  583 */             .addComponent(this.jScrollPane5, -1, 934, 32767)
/*  584 */             .addContainerGap())));
/*      */     
/*  586 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  588 */         .addGap(0, 486, 32767)
/*  589 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */           .addGroup(jPanel7Layout.createSequentialGroup()
/*  591 */             .addContainerGap()
/*  592 */             .addComponent(this.jScrollPane5, -1, 464, 32767)
/*  593 */             .addContainerGap())));
/*      */ 
/*      */     
/*  596 */     this.jDialog1.setTitle("Búsqueda de Empleados");
/*  597 */     this.jDialog1.setModal(true);
/*      */     
/*  599 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/*  601 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/*  602 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/*  603 */     this.jLabel60.setHorizontalAlignment(0);
/*  604 */     this.jLabel60.setText("Busqueda de Empleados");
/*      */     
/*  606 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/*  607 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Empleados", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  609 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/*  610 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  618 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  623 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  626 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  628 */             NominasComplementos.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/*  631 */     this.jScrollPane9.setViewportView(this.jTable6);
/*      */     
/*  633 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/*  634 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/*  635 */     this.jLabel61.setHorizontalAlignment(4);
/*  636 */     this.jLabel61.setText("Clave");
/*      */     
/*  638 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  640 */             NominasComplementos.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  644 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/*  645 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/*  646 */     this.jLabel62.setHorizontalAlignment(4);
/*  647 */     this.jLabel62.setText("Nombre");
/*      */     
/*  649 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  651 */             NominasComplementos.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  655 */     this.jLabel63.setFont(new Font("Tahoma", 2, 11));
/*  656 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  657 */     this.jLabel63.setHorizontalAlignment(4);
/*  658 */     this.jLabel63.setText("Tipo");
/*      */     
/*  660 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  661 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/*      */     
/*  663 */     this.jButton29.setMnemonic('C');
/*  664 */     this.jButton29.setText("Cerrar");
/*  665 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/*  666 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  668 */             NominasComplementos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  672 */     this.jButton30.setMnemonic('A');
/*  673 */     this.jButton30.setText("Agregar");
/*  674 */     this.jButton30.setToolTipText("Agregar (Alt+A)");
/*  675 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  677 */             NominasComplementos.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  681 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/*  682 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/*  683 */     this.jLabel64.setHorizontalAlignment(4);
/*  684 */     this.jLabel64.setText("Depto");
/*      */     
/*  686 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  687 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  688 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  690 */             NominasComplementos.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  694 */     this.jLabel19.setText("Total de datos:");
/*      */     
/*  696 */     this.jLabel20.setFont(new Font("Tahoma", 1, 14));
/*  697 */     this.jLabel20.setText("0");
/*      */     
/*  699 */     this.jCheckBox4.setText("Seleccionar todos");
/*  700 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  702 */             NominasComplementos.this.jCheckBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  706 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  707 */     this.jPanel36.setLayout(jPanel36Layout);
/*  708 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  710 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/*  711 */           .addContainerGap()
/*  712 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  713 */             .addComponent(this.jScrollPane9, GroupLayout.Alignment.LEADING, -1, 835, 32767)
/*  714 */             .addComponent(this.jCheckBox4, GroupLayout.Alignment.LEADING, -2, 132, -2)
/*  715 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
/*  716 */               .addComponent(this.jLabel61, -2, 40, -2)
/*  717 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  718 */               .addComponent(this.jTextField9, -2, 52, -2)
/*  719 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  720 */               .addComponent(this.jLabel62, -2, 57, -2)
/*  721 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  722 */               .addComponent(this.jTextField10, -2, 169, -2)
/*  723 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  724 */               .addComponent(this.jLabel63, -2, 63, -2)
/*  725 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  726 */               .addComponent(this.jComboBox5, -2, 168, -2)
/*  727 */               .addGap(18, 18, 18)
/*  728 */               .addComponent(this.jLabel64, -2, 63, -2)
/*  729 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  730 */               .addComponent(this.jComboBox6, -2, 168, -2))
/*  731 */             .addGroup(jPanel36Layout.createSequentialGroup()
/*  732 */               .addComponent(this.jLabel19, -2, 90, -2)
/*  733 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  734 */               .addComponent(this.jLabel20, -2, 75, -2)
/*  735 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  736 */               .addComponent(this.jButton30, -2, 126, -2)
/*  737 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  738 */               .addComponent(this.jButton29, -2, 126, -2)))
/*  739 */           .addContainerGap()));
/*      */     
/*  741 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  742 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  743 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  744 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  745 */             .addComponent(this.jLabel61)
/*  746 */             .addComponent(this.jTextField9, -2, -1, -2)
/*  747 */             .addComponent(this.jLabel62)
/*  748 */             .addComponent(this.jTextField10, -2, -1, -2)
/*  749 */             .addComponent(this.jLabel63)
/*  750 */             .addComponent(this.jComboBox5, -2, -1, -2)
/*  751 */             .addComponent(this.jLabel64)
/*  752 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  753 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  754 */           .addComponent(this.jCheckBox4)
/*  755 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  756 */           .addComponent(this.jScrollPane9, -1, 250, 32767)
/*  757 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  758 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  759 */             .addComponent(this.jButton29)
/*  760 */             .addComponent(this.jButton30)
/*  761 */             .addComponent(this.jLabel19)
/*  762 */             .addComponent(this.jLabel20))
/*  763 */           .addContainerGap()));
/*      */ 
/*      */     
/*  766 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  767 */     this.jPanel10.setLayout(jPanel10Layout);
/*  768 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  769 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  770 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  771 */           .addContainerGap()
/*  772 */           .addComponent(this.jSeparator8, -1, 865, 32767)
/*  773 */           .addContainerGap())
/*  774 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  775 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/*  776 */             .addGap(8, 8, 8)
/*  777 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  778 */               .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 867, 32767)
/*  779 */               .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  780 */             .addGap(10, 10, 10))));
/*      */     
/*  782 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  783 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  784 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  785 */           .addGap(31, 31, 31)
/*  786 */           .addComponent(this.jSeparator8, -2, 10, -2)
/*  787 */           .addContainerGap(372, 32767))
/*  788 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  789 */           .addGroup(jPanel10Layout.createSequentialGroup()
/*  790 */             .addComponent(this.jLabel60, -2, 31, -2)
/*  791 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  792 */             .addComponent(this.jPanel36, -1, -1, 32767)
/*  793 */             .addContainerGap())));
/*      */ 
/*      */     
/*  796 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  797 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  798 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  799 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  800 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/*  802 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  804 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/*  807 */     this.jDialog2.setTitle("Organizar Días");
/*  808 */     this.jDialog2.setModal(true);
/*      */     
/*  810 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/*  812 */     this.jLabel65.setFont(new Font("Tahoma", 1, 16));
/*  813 */     this.jLabel65.setForeground(new Color(0, 102, 102));
/*  814 */     this.jLabel65.setHorizontalAlignment(0);
/*  815 */     this.jLabel65.setText("Días Laborados");
/*      */     
/*  817 */     this.jButton3.setMnemonic('C');
/*  818 */     this.jButton3.setText("Cerrar");
/*  819 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/*  820 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  822 */             NominasComplementos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  826 */     this.jButton4.setMnemonic('G');
/*  827 */     this.jButton4.setText("Guardar");
/*  828 */     this.jButton4.setToolTipText("Guardar (Alt+G)");
/*      */     
/*  830 */     this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  832 */     this.jSpinner2.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  834 */     this.jSpinner4.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  836 */     this.jSpinner5.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  838 */     this.jSpinner6.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  840 */     this.jSpinner7.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  842 */     this.jSpinner8.setModel(new SpinnerListModel((Object[])new String[] { "A", "F", "M", "D" }));
/*      */     
/*  844 */     this.jLabel26.setHorizontalAlignment(0);
/*  845 */     this.jLabel26.setText(" ");
/*      */     
/*  847 */     this.jLabel27.setHorizontalAlignment(0);
/*  848 */     this.jLabel27.setText(" ");
/*      */     
/*  850 */     this.jLabel28.setHorizontalAlignment(0);
/*  851 */     this.jLabel28.setText(" ");
/*      */     
/*  853 */     this.jLabel29.setHorizontalAlignment(0);
/*  854 */     this.jLabel29.setText(" ");
/*      */     
/*  856 */     this.jLabel30.setHorizontalAlignment(0);
/*  857 */     this.jLabel30.setText(" ");
/*      */     
/*  859 */     this.jLabel31.setHorizontalAlignment(0);
/*  860 */     this.jLabel31.setText(" ");
/*      */     
/*  862 */     this.jLabel32.setHorizontalAlignment(0);
/*  863 */     this.jLabel32.setText(" ");
/*      */     
/*  865 */     this.jLabel33.setText("Comentario:");
/*      */     
/*  867 */     this.jTextArea1.setColumns(20);
/*  868 */     this.jTextArea1.setRows(5);
/*  869 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/*  871 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/*  872 */     this.jLabel2.setText("A = Asistencia, F = Falta, M = Medio Día, D = Descanzo");
/*  873 */     this.jLabel2.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  875 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  876 */     this.jPanel11.setLayout(jPanel11Layout);
/*  877 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  878 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  879 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  880 */           .addContainerGap()
/*  881 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  882 */             .addComponent(this.jScrollPane2)
/*  883 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  884 */               .addGap(0, 0, 32767)
/*  885 */               .addComponent(this.jButton4, -2, 114, -2)
/*  886 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  887 */               .addComponent(this.jButton3, -2, 114, -2))
/*  888 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  889 */               .addComponent(this.jLabel26, -2, 70, -2)
/*  890 */               .addGap(18, 18, 18)
/*  891 */               .addComponent(this.jLabel27, -2, 70, -2)
/*  892 */               .addGap(18, 18, 18)
/*  893 */               .addComponent(this.jLabel28, -2, 70, -2)
/*  894 */               .addGap(18, 18, 18)
/*  895 */               .addComponent(this.jLabel29, -2, 70, -2)
/*  896 */               .addGap(18, 18, 18)
/*  897 */               .addComponent(this.jLabel30, -2, 70, -2)
/*  898 */               .addGap(18, 18, 18)
/*  899 */               .addComponent(this.jLabel31, -2, 70, -2)
/*  900 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  901 */               .addComponent(this.jLabel32, -2, 70, -2))
/*  902 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  903 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  904 */                 .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  905 */                   .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING)
/*  906 */                   .addGroup(jPanel11Layout.createSequentialGroup()
/*  907 */                     .addComponent(this.jSpinner1, -2, 70, -2)
/*  908 */                     .addGap(18, 18, 18)
/*  909 */                     .addComponent(this.jSpinner2, -2, 70, -2)
/*  910 */                     .addGap(18, 18, 18)
/*  911 */                     .addComponent(this.jSpinner4, -2, 70, -2)
/*  912 */                     .addGap(18, 18, 18)
/*  913 */                     .addComponent(this.jSpinner5, -2, 70, -2)
/*  914 */                     .addGap(18, 18, 18)
/*  915 */                     .addComponent(this.jSpinner6, -2, 70, -2)
/*  916 */                     .addGap(18, 18, 18)
/*  917 */                     .addComponent(this.jSpinner7, -2, 70, -2)
/*  918 */                     .addGap(18, 18, 18)
/*  919 */                     .addComponent(this.jSpinner8, -2, 70, -2)))
/*  920 */                 .addComponent(this.jLabel33, -2, 182, -2))
/*  921 */               .addGap(0, 0, 32767)))
/*  922 */           .addContainerGap())
/*  923 */         .addComponent(this.jLabel2, -1, -1, 32767)
/*  924 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  925 */           .addGroup(jPanel11Layout.createSequentialGroup()
/*  926 */             .addGap(8, 8, 8)
/*  927 */             .addComponent(this.jLabel65, -1, 600, 32767)
/*  928 */             .addContainerGap())));
/*      */     
/*  930 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  931 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  932 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  933 */           .addGap(31, 31, 31)
/*  934 */           .addComponent(this.jSeparator9, -2, 10, -2)
/*  935 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  936 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  937 */             .addComponent(this.jSpinner1, -2, 44, -2)
/*  938 */             .addComponent(this.jSpinner2, -2, 44, -2)
/*  939 */             .addComponent(this.jSpinner4, -2, 44, -2)
/*  940 */             .addComponent(this.jSpinner5, -2, 44, -2)
/*  941 */             .addComponent(this.jSpinner6, -2, 44, -2)
/*  942 */             .addComponent(this.jSpinner7, -2, 44, -2)
/*  943 */             .addComponent(this.jSpinner8, -2, 44, -2))
/*  944 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  945 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  946 */             .addComponent(this.jLabel26)
/*  947 */             .addComponent(this.jLabel27)
/*  948 */             .addComponent(this.jLabel28)
/*  949 */             .addComponent(this.jLabel29)
/*  950 */             .addComponent(this.jLabel30)
/*  951 */             .addComponent(this.jLabel31)
/*  952 */             .addComponent(this.jLabel32))
/*  953 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  954 */           .addComponent(this.jLabel33)
/*  955 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  956 */           .addComponent(this.jScrollPane2, -2, -1, -2)
/*  957 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  958 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  959 */             .addComponent(this.jButton3)
/*  960 */             .addComponent(this.jButton4))
/*  961 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  962 */           .addComponent(this.jLabel2, -1, 26, 32767))
/*  963 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  964 */           .addGroup(jPanel11Layout.createSequentialGroup()
/*  965 */             .addComponent(this.jLabel65, -2, 31, -2)
/*  966 */             .addGap(0, 268, 32767))));
/*      */ 
/*      */     
/*  969 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  970 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  971 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  972 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */     
/*  975 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */ 
/*      */     
/*  980 */     this.jDialog3.setTitle("Tablas de subsidio");
/*  981 */     this.jDialog3.setModal(true);
/*      */     
/*  983 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/*  985 */     this.jLabel66.setFont(new Font("Tahoma", 1, 16));
/*  986 */     this.jLabel66.setForeground(new Color(0, 102, 102));
/*  987 */     this.jLabel66.setHorizontalAlignment(0);
/*  988 */     this.jLabel66.setText("Tablas del subsidio");
/*      */     
/*  990 */     this.jButton5.setMnemonic('C');
/*  991 */     this.jButton5.setText("Modificar");
/*  992 */     this.jButton5.setToolTipText("Cerrar (Alt+C)");
/*  993 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  995 */             NominasComplementos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  999 */     this.jButton6.setMnemonic('G');
/* 1000 */     this.jButton6.setText("Nueva");
/* 1001 */     this.jButton6.setToolTipText("Guardar (Alt+G)");
/* 1002 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1004 */             NominasComplementos.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1008 */     this.jLabel36.setFont(new Font("Tahoma", 3, 12));
/* 1009 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/* 1010 */     this.jLabel36.setHorizontalAlignment(2);
/* 1011 */     this.jLabel36.setText("Tablas");
/*      */     
/* 1013 */     this.jList1.setModel(new AbstractListModel() {
/* 1014 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/* 1015 */           public int getSize() { return this.strings.length; }
/* 1016 */           public Object getElementAt(int i) { return this.strings[i]; }
/*      */         });
/* 1018 */     this.jScrollPane4.setViewportView(this.jList1);
/*      */     
/* 1020 */     this.jButton7.setMnemonic('C');
/* 1021 */     this.jButton7.setText("Cerrar");
/* 1022 */     this.jButton7.setToolTipText("Cerrar (Alt+C)");
/* 1023 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1025 */             NominasComplementos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1029 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1030 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1031 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1032 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1033 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1034 */           .addContainerGap()
/* 1035 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1036 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1037 */               .addComponent(this.jLabel36, -2, 102, -2)
/* 1038 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1039 */               .addComponent(this.jScrollPane4, -2, 82, -2)
/* 1040 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1041 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1042 */                 .addComponent(this.jButton6, -2, 114, -2)
/* 1043 */                 .addComponent(this.jButton5, -2, 114, -2)
/* 1044 */                 .addComponent(this.jButton7, -2, 114, -2)))
/* 1045 */             .addComponent(this.jSeparator10, -2, 308, -2))
/* 1046 */           .addContainerGap(-1, 32767))
/* 1047 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1048 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1049 */             .addContainerGap(-1, 32767)
/* 1050 */             .addComponent(this.jLabel66, -2, 309, -2)
/* 1051 */             .addGap(499, 499, 499))));
/*      */     
/* 1053 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1054 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1055 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1056 */           .addGap(31, 31, 31)
/* 1057 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1058 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1059 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1060 */             .addComponent(this.jLabel36)
/* 1061 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1062 */               .addGroup(jPanel12Layout.createSequentialGroup()
/* 1063 */                 .addComponent(this.jButton6)
/* 1064 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1065 */                 .addComponent(this.jButton5)
/* 1066 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1067 */                 .addComponent(this.jButton7))
/* 1068 */               .addComponent(this.jScrollPane4, -2, 105, -2)))
/* 1069 */           .addContainerGap(-1, 32767))
/* 1070 */         .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1071 */           .addGroup(jPanel12Layout.createSequentialGroup()
/* 1072 */             .addComponent(this.jLabel66, -2, 31, -2)
/* 1073 */             .addGap(0, 132, 32767))));
/*      */ 
/*      */     
/* 1076 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1077 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1078 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1081 */           .addComponent(this.jPanel12, -1, 328, 32767)
/* 1082 */           .addGap(0, 0, 0)));
/*      */     
/* 1084 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1086 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1087 */           .addComponent(this.jPanel12, -1, -1, 32767)
/* 1088 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1091 */     this.jDialog4.setTitle("Ingresa los datos");
/* 1092 */     this.jDialog4.setModal(true);
/*      */     
/* 1094 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 1096 */     this.jLabel67.setFont(new Font("Tahoma", 1, 16));
/* 1097 */     this.jLabel67.setForeground(new Color(0, 102, 102));
/* 1098 */     this.jLabel67.setHorizontalAlignment(0);
/* 1099 */     this.jLabel67.setText("Capturar datos de la tabla");
/*      */     
/* 1101 */     this.jButton8.setMnemonic('C');
/* 1102 */     this.jButton8.setText("Cerrar");
/* 1103 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/* 1104 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1106 */             NominasComplementos.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1110 */     this.jButton9.setMnemonic('G');
/* 1111 */     this.jButton9.setText("Guardar");
/* 1112 */     this.jButton9.setToolTipText("Guardar (Alt+G)");
/* 1113 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1115 */             NominasComplementos.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1119 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Límite Inferior", "Cuota Fija", "% Sobre excedente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1127 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1132 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1135 */     this.jScrollPane10.setViewportView(this.jTable1);
/*      */     
/* 1137 */     this.jLabel40.setFont(new Font("Tahoma", 3, 12));
/* 1138 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/* 1139 */     this.jLabel40.setHorizontalAlignment(2);
/* 1140 */     this.jLabel40.setText("Limite Inferior");
/*      */     
/* 1142 */     this.jLabel41.setFont(new Font("Tahoma", 3, 12));
/* 1143 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 1144 */     this.jLabel41.setHorizontalAlignment(2);
/* 1145 */     this.jLabel41.setText("Cuota Fija");
/*      */     
/* 1147 */     this.jLabel43.setFont(new Font("Tahoma", 3, 12));
/* 1148 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/* 1149 */     this.jLabel43.setHorizontalAlignment(2);
/* 1150 */     this.jLabel43.setText("<html>% sobre el excedente de limite inferior</html>");
/*      */     
/* 1152 */     this.jFormattedTextField3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00%"))));
/*      */     
/* 1154 */     this.jButton10.setText("Agregar");
/* 1155 */     this.jButton10.setToolTipText("Agregar Linea (Alt+A)");
/* 1156 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1158 */             NominasComplementos.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1162 */     this.jLabel44.setFont(new Font("Tahoma", 3, 12));
/* 1163 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/* 1164 */     this.jLabel44.setHorizontalAlignment(2);
/* 1165 */     this.jLabel44.setText("Identificador");
/*      */     
/* 1167 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1168 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1169 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1171 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1172 */           .addContainerGap()
/* 1173 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1174 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1175 */               .addGroup(jPanel13Layout.createSequentialGroup()
/* 1176 */                 .addComponent(this.jButton9, -2, 114, -2)
/* 1177 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1178 */                 .addComponent(this.jButton8, -2, 114, -2))
/* 1179 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1180 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 1181 */                   .addComponent(this.jLabel40, -2, 102, -2)
/* 1182 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1183 */                   .addComponent(this.jFormattedTextField1, -2, 145, -2))
/* 1184 */                 .addComponent(this.jScrollPane10, -2, 0, 32767)
/* 1185 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 1186 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1187 */                     .addGroup(jPanel13Layout.createSequentialGroup()
/* 1188 */                       .addComponent(this.jLabel43, -2, 111, -2)
/* 1189 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1190 */                       .addComponent(this.jFormattedTextField3, -2, 142, -2))
/* 1191 */                     .addGroup(jPanel13Layout.createSequentialGroup()
/* 1192 */                       .addComponent(this.jLabel41, -2, 102, -2)
/* 1193 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1194 */                       .addComponent(this.jFormattedTextField2, -2, 145, -2)))
/* 1195 */                   .addGap(18, 18, 18)
/* 1196 */                   .addComponent(this.jButton10, -2, 94, -2))
/* 1197 */                 .addComponent(this.jSeparator11)))
/* 1198 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1199 */               .addComponent(this.jLabel44, -2, 102, -2)
/* 1200 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1201 */               .addComponent(this.jTextField11, -2, 134, -2)))
/* 1202 */           .addContainerGap(-1, 32767))
/* 1203 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1204 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1205 */             .addContainerGap(-1, 32767)
/* 1206 */             .addComponent(this.jLabel67, -2, 372, -2)
/* 1207 */             .addGap(238, 238, 238))));
/*      */     
/* 1209 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1210 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1211 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1212 */           .addGap(31, 31, 31)
/* 1213 */           .addComponent(this.jSeparator11, -2, 10, -2)
/* 1214 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1215 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1216 */             .addComponent(this.jLabel44)
/* 1217 */             .addComponent(this.jTextField11, -2, -1, -2))
/* 1218 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767)
/* 1219 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1220 */             .addComponent(this.jLabel40)
/* 1221 */             .addComponent(this.jFormattedTextField1, -2, -1, -2))
/* 1222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1223 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1224 */             .addComponent(this.jLabel41)
/* 1225 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/* 1226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1227 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1228 */             .addComponent(this.jLabel43, -2, 55, -2)
/* 1229 */             .addComponent(this.jFormattedTextField3, -2, -1, -2)
/* 1230 */             .addComponent(this.jButton10))
/* 1231 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1232 */           .addComponent(this.jScrollPane10, -2, 92, -2)
/* 1233 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1234 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1235 */             .addComponent(this.jButton8)
/* 1236 */             .addComponent(this.jButton9))
/* 1237 */           .addGap(36, 36, 36))
/* 1238 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1239 */           .addGroup(jPanel13Layout.createSequentialGroup()
/* 1240 */             .addComponent(this.jLabel67, -2, 31, -2)
/* 1241 */             .addGap(0, 331, 32767))));
/*      */ 
/*      */     
/* 1244 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1245 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1246 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1248 */         .addComponent(this.jPanel13, -1, 389, 32767));
/*      */     
/* 1250 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1251 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1252 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1253 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1254 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1257 */     this.jFrame2.setTitle("Formato de Nómina");
/*      */     
/* 1259 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 1261 */     this.jLabel45.setFont(new Font("Tahoma", 1, 15));
/* 1262 */     this.jLabel45.setHorizontalAlignment(0);
/* 1263 */     this.jLabel45.setText("NÓMINA");
/*      */     
/* 1265 */     this.jLabel49.setText("Folio:");
/*      */     
/* 1267 */     this.jTextField12.setFont(new Font("Tahoma", 1, 11));
/* 1268 */     this.jTextField12.setEnabled(false);
/*      */     
/* 1270 */     this.jLabel50.setHorizontalAlignment(4);
/* 1271 */     this.jLabel50.setText("Fecha:");
/*      */     
/* 1273 */     this.jDateChooser15.setDate(this.fechaActual);
/* 1274 */     this.jDateChooser15.setDateFormatString("dd/MM/yyyy");
/* 1275 */     this.jDateChooser15.setEnabled(false);
/* 1276 */     this.jDateChooser15.setIcon(this.icon);
/* 1277 */     this.jDateChooser15.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/* 1279 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/* 1280 */     this.jPanel15.setBorder(BorderFactory.createTitledBorder("Datos de la Nómina"));
/*      */     
/* 1282 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/* 1283 */     this.jLabel51.setText("Tipo de Nómina");
/*      */     
/* 1285 */     this.jRadioButton3.setBackground(new Color(255, 255, 255));
/* 1286 */     this.jRadioButton3.setSelected(true);
/* 1287 */     this.jRadioButton3.setText("Administrativos");
/* 1288 */     this.jRadioButton3.setEnabled(false);
/* 1289 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1291 */             NominasComplementos.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1295 */     this.jRadioButton4.setBackground(new Color(255, 255, 255));
/* 1296 */     this.jRadioButton4.setText("Operadores");
/* 1297 */     this.jRadioButton4.setEnabled(false);
/* 1298 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1300 */             NominasComplementos.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1304 */     this.jLabel96.setFont(new Font("Tahoma", 1, 11));
/* 1305 */     this.jLabel96.setText("Fecha del cálculo: ");
/*      */     
/* 1307 */     this.jDateChooser16.setDate(this.fechaActual);
/* 1308 */     this.jDateChooser16.setDateFormatString("dd/MM/yyyy");
/* 1309 */     this.jDateChooser16.setIcon(this.icon);
/* 1310 */     this.jDateChooser16.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/* 1312 */     this.jLabel97.setHorizontalAlignment(0);
/* 1313 */     this.jLabel97.setText("Al");
/*      */     
/* 1315 */     this.jDateChooser17.setDate(this.fechaActual);
/* 1316 */     this.jDateChooser17.setDateFormatString("dd/MM/yyyy");
/* 1317 */     this.jDateChooser17.setIcon(this.icon);
/* 1318 */     this.jDateChooser17.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/* 1320 */     this.jLabel98.setFont(new Font("Tahoma", 1, 11));
/* 1321 */     this.jLabel98.setText("No. de Sem:");
/*      */     
/* 1323 */     this.jSpinner9.setModel(new SpinnerNumberModel(1, 1, 53, 1));
/*      */     
/* 1325 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/* 1326 */     this.jLabel52.setText("Sucursal");
/*      */     
/* 1328 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/* 1329 */     this.jLabel53.setText("Dirección");
/*      */     
/* 1331 */     this.jLabel58.setText("Cheque");
/*      */     
/* 1333 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1334 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1335 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1337 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1338 */           .addContainerGap()
/* 1339 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1340 */             .addComponent(this.jLabel58, -1, -1, 32767)
/* 1341 */             .addComponent(this.jLabel53, -1, -1, 32767)
/* 1342 */             .addComponent(this.jLabel52, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1343 */             .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1344 */             .addComponent(this.jLabel96, GroupLayout.Alignment.LEADING, -1, 108, 32767))
/* 1345 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1346 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1347 */             .addComponent(this.jTextField14)
/* 1348 */             .addGroup(jPanel15Layout.createSequentialGroup()
/* 1349 */               .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1350 */                 .addGroup(jPanel15Layout.createSequentialGroup()
/* 1351 */                   .addComponent(this.jRadioButton3, -2, 129, -2)
/* 1352 */                   .addGap(8, 8, 8)
/* 1353 */                   .addComponent(this.jRadioButton4, -2, 129, -2))
/* 1354 */                 .addGroup(jPanel15Layout.createSequentialGroup()
/* 1355 */                   .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1356 */                     .addComponent(this.jTextField13, GroupLayout.Alignment.LEADING)
/* 1357 */                     .addGroup(GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
/* 1358 */                       .addComponent((Component)this.jDateChooser16, -2, 119, -2)
/* 1359 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1360 */                       .addComponent(this.jLabel97, -2, 50, -2)
/* 1361 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1362 */                       .addComponent((Component)this.jDateChooser17, -2, 119, -2)))
/* 1363 */                   .addGap(56, 56, 56)
/* 1364 */                   .addComponent(this.jLabel98, -2, 70, -2)
/* 1365 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1366 */                   .addComponent(this.jSpinner9, -2, 53, -2))
/* 1367 */                 .addComponent(this.jTextField18, -2, 307, -2))
/* 1368 */               .addGap(0, 222, 32767)))
/* 1369 */           .addContainerGap()));
/*      */     
/* 1371 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1372 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1373 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1374 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1375 */             .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1376 */               .addComponent((Component)this.jDateChooser16, -1, -1, 32767)
/* 1377 */               .addComponent(this.jLabel96, -1, -1, 32767)
/* 1378 */               .addComponent(this.jLabel97, -1, -1, 32767)
/* 1379 */               .addComponent((Component)this.jDateChooser17, -2, -1, -2))
/* 1380 */             .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1381 */               .addComponent(this.jLabel98)
/* 1382 */               .addComponent(this.jSpinner9, -2, -1, -2)))
/* 1383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1384 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1385 */             .addComponent(this.jRadioButton4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1386 */             .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -2, 22, -2)
/* 1387 */             .addComponent(this.jRadioButton3, GroupLayout.Alignment.LEADING))
/* 1388 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1389 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1390 */             .addComponent(this.jLabel52)
/* 1391 */             .addComponent(this.jTextField13, -2, -1, -2))
/* 1392 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1393 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1394 */             .addComponent(this.jLabel53)
/* 1395 */             .addComponent(this.jTextField14, -2, -1, -2))
/* 1396 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1397 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1398 */             .addComponent(this.jLabel58)
/* 1399 */             .addComponent(this.jTextField18, -2, -1, -2))
/* 1400 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1403 */     this.jLabel55.setText("Para agregar empleados haz clic en el siguiente botón");
/*      */     
/* 1405 */     this.jButton21.setMnemonic('A');
/* 1406 */     this.jButton21.setText("Agregar Empleados");
/* 1407 */     this.jButton21.setToolTipText("Agregar Empleados (Alt+A)");
/* 1408 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1410 */             NominasComplementos.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1414 */     this.jLabel56.setText("Total de empleados:");
/*      */     
/* 1416 */     this.jLabel57.setFont(new Font("Tahoma", 1, 14));
/* 1417 */     this.jLabel57.setHorizontalAlignment(4);
/* 1418 */     this.jLabel57.setText("0");
/*      */     
/* 1420 */     this.jButton22.setMnemonic('C');
/* 1421 */     this.jButton22.setText("Cerrar");
/* 1422 */     this.jButton22.setToolTipText("Cerrar (Alt+C)");
/* 1423 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1425 */             NominasComplementos.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1429 */     this.jButton28.setMnemonic('G');
/* 1430 */     this.jButton28.setText("Guardar");
/* 1431 */     this.jButton28.setToolTipText("Guardar (Alt+G)");
/* 1432 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1434 */             NominasComplementos.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1438 */     this.jButton31.setMnemonic('E');
/* 1439 */     this.jButton31.setText("Exportar");
/* 1440 */     this.jButton31.setToolTipText("Exportar (Alt+E)");
/* 1441 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1443 */             NominasComplementos.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1447 */     this.jButton32.setMnemonic('Q');
/* 1448 */     this.jButton32.setText("Quitar");
/* 1449 */     this.jButton32.setToolTipText("Quitar (Alt+Q)");
/* 1450 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1452 */             NominasComplementos.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1456 */     this.jButton33.setMnemonic('R');
/* 1457 */     this.jButton33.setText("Recibos");
/* 1458 */     this.jButton33.setToolTipText("Generar Recibos (Alt+R)");
/* 1459 */     this.jButton33.setEnabled(false);
/* 1460 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1462 */             NominasComplementos.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1466 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/* 1467 */     this.jPanel16.setBorder(BorderFactory.createTitledBorder("Datos Fiscales"));
/*      */     
/* 1469 */     this.jTextPane2.setEditable(false);
/* 1470 */     this.jTextPane2.setFont(new Font("Tahoma", 1, 14));
/* 1471 */     this.jTextPane2.setText("Fletes y Materiales Forsis\nDireccion\nRFC\n\nTelefono");
/* 1472 */     this.jScrollPane11.setViewportView(this.jTextPane2);
/*      */     
/* 1474 */     this.jLabel68.setFont(new Font("Tahoma", 1, 11));
/* 1475 */     this.jLabel68.setHorizontalAlignment(4);
/* 1476 */     this.jLabel68.setText("Clave Banco");
/*      */     
/* 1478 */     this.jLabel69.setFont(new Font("Tahoma", 1, 11));
/* 1479 */     this.jLabel69.setHorizontalAlignment(4);
/* 1480 */     this.jLabel69.setText("Clave Desc");
/*      */     
/* 1482 */     this.jLabel70.setFont(new Font("Tahoma", 1, 11));
/* 1483 */     this.jLabel70.setHorizontalAlignment(4);
/* 1484 */     this.jLabel70.setText("Clave Riesgo");
/*      */     
/* 1486 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 1487 */     this.jPanel16.setLayout(jPanel16Layout);
/* 1488 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 1489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1490 */         .addComponent(this.jScrollPane11)
/* 1491 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 1492 */           .addComponent(this.jLabel68, -2, 74, -2)
/* 1493 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1494 */           .addComponent(this.jTextField15, -2, 74, -2)
/* 1495 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767)
/* 1496 */           .addComponent(this.jLabel69, -2, 68, -2)
/* 1497 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1498 */           .addComponent(this.jTextField16, -2, 74, -2)
/* 1499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1500 */           .addComponent(this.jLabel70, -2, 76, -2)
/* 1501 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1502 */           .addComponent(this.jTextField17, -2, 74, -2)));
/*      */     
/* 1504 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 1505 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1506 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 1507 */           .addComponent(this.jScrollPane11, -2, 122, -2)
/* 1508 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1509 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1510 */             .addComponent(this.jLabel68)
/* 1511 */             .addComponent(this.jTextField15, -2, -1, -2)
/* 1512 */             .addComponent(this.jLabel70)
/* 1513 */             .addComponent(this.jTextField17, -2, -1, -2)
/* 1514 */             .addComponent(this.jLabel69)
/* 1515 */             .addComponent(this.jTextField16, -2, -1, -2))));
/*      */ 
/*      */     
/* 1518 */     this.jLabel71.setFont(new Font("Tahoma", 1, 15));
/* 1519 */     this.jLabel71.setHorizontalAlignment(2);
/* 1520 */     this.jLabel71.setText("$0.0");
/* 1521 */     this.jLabel71.setVerticalAlignment(3);
/*      */     
/* 1523 */     this.jLabel72.setHorizontalAlignment(4);
/* 1524 */     this.jLabel72.setText("Total Neto:");
/*      */     
/* 1526 */     this.jLabel73.setFont(new Font("Tahoma", 1, 10));
/* 1527 */     this.jLabel73.setForeground(new Color(0, 0, 255));
/* 1528 */     this.jLabel73.setText(" ");
/*      */     
/* 1530 */     this.jScrollPane12.setHorizontalScrollBarPolicy(32);
/*      */     
/* 1532 */     this.jScrollPane13.setMinimumSize(new Dimension(2, 23));
/* 1533 */     this.jScrollPane13.setPreferredSize(new Dimension(752, 419));
/*      */     
/* 1535 */     this.jTable7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "NSS", "Nombre Completo", "CURP", "Departamento", "F. de Ingreso", "Salario Real", "L", "M", "M", "J", "V", "S", "D", "Días Lab.", "Horas Extra", "Dom. Lab.", "Gratificaciones", "Turno Extra", "Faltas", "Retardos", "Vacaciones", "EPP", "Préstamo", "Nextel", "Sueldo Fiscal", "Total Comp.", "Neto Pagado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1543 */           Class[] types = new Class[] { Object.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */           
/* 1546 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false };
/*      */           public Class getColumnClass(int columnIndex) {
/* 1551 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1555 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1558 */     this.jTable7.setColumnSelectionAllowed(true);
/* 1559 */     this.jTable7.setShowHorizontalLines(false);
/* 1560 */     this.jTable7.getTableHeader().setReorderingAllowed(false);
/* 1561 */     this.jTable7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1563 */             NominasComplementos.this.jTable7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1566 */     this.jTable7.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1568 */             NominasComplementos.this.jTable7KeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1571 */             NominasComplementos.this.jTable7KeyReleased(evt);
/*      */           }
/*      */         });
/* 1574 */     this.jScrollPane13.setViewportView(this.jTable7);
/* 1575 */     this.jTable7.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/* 1577 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1578 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1579 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1581 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1582 */           .addContainerGap()
/* 1583 */           .addComponent(this.jScrollPane13, -2, 2126, -2)
/* 1584 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1586 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1588 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1589 */           .addGap(11, 11, 11)
/* 1590 */           .addComponent(this.jScrollPane13, -1, 400, 32767)));
/*      */ 
/*      */     
/* 1593 */     this.jScrollPane12.setViewportView(this.jPanel18);
/*      */     
/* 1595 */     this.jLabel77.setHorizontalAlignment(4);
/* 1596 */     this.jLabel77.setText("Total Complemento:");
/*      */     
/* 1598 */     this.jLabel78.setFont(new Font("Tahoma", 1, 15));
/* 1599 */     this.jLabel78.setHorizontalAlignment(2);
/* 1600 */     this.jLabel78.setText("$0.0");
/* 1601 */     this.jLabel78.setVerticalAlignment(3);
/*      */     
/* 1603 */     this.jLabel79.setFont(new Font("Tahoma", 1, 15));
/* 1604 */     this.jLabel79.setHorizontalAlignment(2);
/* 1605 */     this.jLabel79.setText("$0.0");
/* 1606 */     this.jLabel79.setVerticalAlignment(3);
/*      */     
/* 1608 */     this.jLabel80.setHorizontalAlignment(4);
/* 1609 */     this.jLabel80.setText("Total Imss:");
/*      */     
/* 1611 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1612 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1613 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1614 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1615 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1616 */           .addContainerGap()
/* 1617 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1618 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1619 */               .addComponent(this.jLabel49, -2, 54, -2)
/* 1620 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1621 */               .addComponent(this.jTextField12, -2, 145, -2)
/* 1622 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1623 */               .addComponent(this.jLabel45, -1, -1, 32767)
/* 1624 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1625 */               .addComponent(this.jLabel50, -2, 57, -2)
/* 1626 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1627 */               .addComponent((Component)this.jDateChooser15, -2, 92, -2))
/* 1628 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1629 */               .addComponent(this.jPanel16, -2, -1, -2)
/* 1630 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1631 */               .addComponent(this.jPanel15, -1, -1, 32767))
/* 1632 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1633 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1634 */                 .addGroup(jPanel14Layout.createSequentialGroup()
/* 1635 */                   .addComponent(this.jLabel55, -2, 303, -2)
/* 1636 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1637 */                   .addComponent(this.jButton21, -2, 143, -2)
/* 1638 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1639 */                   .addComponent(this.jButton32, -2, 87, -2))
/* 1640 */                 .addComponent(this.jLabel73, -2, 398, -2))
/* 1641 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1642 */               .addComponent(this.jLabel56, -2, 129, -2)
/* 1643 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1644 */               .addComponent(this.jLabel57, -2, 49, -2)
/* 1645 */               .addGap(125, 125, 125))
/* 1646 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1647 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1648 */                 .addGroup(jPanel14Layout.createSequentialGroup()
/* 1649 */                   .addGap(0, 0, 32767)
/* 1650 */                   .addComponent(this.jLabel80, -2, 104, -2)
/* 1651 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1652 */                   .addComponent(this.jLabel79, -2, 133, -2)
/* 1653 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1654 */                   .addComponent(this.jLabel77, -2, 134, -2)
/* 1655 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1656 */                   .addComponent(this.jLabel78, -2, 133, -2)
/* 1657 */                   .addGap(27, 27, 27)
/* 1658 */                   .addComponent(this.jLabel72, -2, 87, -2)
/* 1659 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1660 */                   .addComponent(this.jLabel71, -2, 112, -2))
/* 1661 */                 .addComponent(this.jScrollPane12, -2, 0, 32767))
/* 1662 */               .addGap(12, 12, 12)
/* 1663 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1664 */                 .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1665 */                   .addComponent(this.jButton28, -2, 106, -2)
/* 1666 */                   .addComponent(this.jButton31, -1, -1, 32767)
/* 1667 */                   .addComponent(this.jButton22, -2, 106, -2))
/* 1668 */                 .addComponent(this.jButton33, GroupLayout.Alignment.TRAILING, -2, 106, -2))))
/* 1669 */           .addContainerGap()));
/*      */     
/* 1671 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1672 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1673 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1674 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1675 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1676 */               .addComponent(this.jLabel45)
/* 1677 */               .addComponent(this.jTextField12, -2, -1, -2)
/* 1678 */               .addComponent(this.jLabel49)
/* 1679 */               .addComponent(this.jLabel50))
/* 1680 */             .addComponent((Component)this.jDateChooser15, -2, -1, -2))
/* 1681 */           .addGap(6, 6, 6)
/* 1682 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1683 */             .addComponent(this.jPanel16, -1, -1, 32767)
/* 1684 */             .addComponent(this.jPanel15, -1, -1, 32767))
/* 1685 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1686 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1687 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1688 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1689 */                 .addComponent(this.jLabel55)
/* 1690 */                 .addComponent(this.jButton21)
/* 1691 */                 .addComponent(this.jButton32)))
/* 1692 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1693 */               .addGap(15, 15, 15)
/* 1694 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1695 */                 .addComponent(this.jLabel56)
/* 1696 */                 .addComponent(this.jLabel57))))
/* 1697 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1698 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1699 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1700 */               .addComponent(this.jButton28, -2, 24, -2)
/* 1701 */               .addGap(8, 8, 8)
/* 1702 */               .addComponent(this.jButton33, -2, 24, -2)
/* 1703 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1704 */               .addComponent(this.jButton31, -2, 24, -2)
/* 1705 */               .addGap(37, 37, 37)
/* 1706 */               .addComponent(this.jButton22, -2, 24, -2)
/* 1707 */               .addGap(0, 0, 32767))
/* 1708 */             .addComponent(this.jScrollPane12, -1, 426, 32767))
/* 1709 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1710 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1711 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1712 */               .addComponent(this.jLabel71)
/* 1713 */               .addComponent(this.jLabel72))
/* 1714 */             .addComponent(this.jLabel73)
/* 1715 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1716 */               .addComponent(this.jLabel78, -1, -1, 32767)
/* 1717 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1718 */                 .addComponent(this.jLabel77)
/* 1719 */                 .addComponent(this.jLabel79, -1, -1, 32767)
/* 1720 */                 .addComponent(this.jLabel80))))
/* 1721 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1724 */     GroupLayout jFrame2Layout = new GroupLayout(this.jFrame2.getContentPane());
/* 1725 */     this.jFrame2.getContentPane().setLayout(jFrame2Layout);
/* 1726 */     jFrame2Layout.setHorizontalGroup(jFrame2Layout
/* 1727 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1728 */         .addGroup(jFrame2Layout.createSequentialGroup()
/* 1729 */           .addComponent(this.jPanel14, -1, -1, 32767)
/* 1730 */           .addGap(0, 0, 0)));
/*      */     
/* 1732 */     jFrame2Layout.setVerticalGroup(jFrame2Layout
/* 1733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1734 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */ 
/*      */     
/* 1737 */     this.jDialog5.setTitle("Ingresa la cantidad");
/* 1738 */     this.jDialog5.setModal(true);
/*      */     
/* 1740 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*      */     
/* 1742 */     this.jFormattedTextField4.setFont(new Font("Tahoma", 1, 20));
/* 1743 */     this.jFormattedTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1745 */             NominasComplementos.this.jFormattedTextField4KeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1749 */     this.jLabel74.setFont(new Font("Tahoma", 3, 15));
/* 1750 */     this.jLabel74.setForeground(new Color(15, 87, 51));
/* 1751 */     this.jLabel74.setHorizontalAlignment(4);
/* 1752 */     this.jLabel74.setText("Cantidad ");
/*      */     
/* 1754 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 1755 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1756 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 1757 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1758 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1759 */           .addContainerGap()
/* 1760 */           .addComponent(this.jLabel74, -2, 73, -2)
/* 1761 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1762 */           .addComponent(this.jFormattedTextField4, -2, 269, -2)
/* 1763 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1765 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 1766 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1767 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1768 */           .addContainerGap()
/* 1769 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1770 */             .addComponent(this.jLabel74, -1, -1, 32767)
/* 1771 */             .addComponent(this.jFormattedTextField4, -1, 52, 32767))
/* 1772 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1775 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1776 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1777 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1779 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1780 */           .addComponent(this.jPanel19, -1, -1, 32767)
/* 1781 */           .addGap(0, 0, 0)));
/*      */     
/* 1783 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1784 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1785 */         .addComponent(this.jPanel19, -2, -1, -2));
/*      */ 
/*      */     
/* 1788 */     this.jDialog6.setTitle("Asistencia");
/* 1789 */     this.jDialog6.setModal(true);
/*      */     
/* 1791 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/*      */     
/* 1793 */     this.jLabel75.setFont(new Font("Tahoma", 1, 16));
/* 1794 */     this.jLabel75.setForeground(new Color(0, 102, 102));
/* 1795 */     this.jLabel75.setHorizontalAlignment(0);
/* 1796 */     this.jLabel75.setText("Asistencia");
/*      */     
/* 1798 */     this.jLabel76.setFont(new Font("Tahoma", 3, 12));
/* 1799 */     this.jLabel76.setForeground(new Color(15, 87, 51));
/* 1800 */     this.jLabel76.setHorizontalAlignment(2);
/* 1801 */     this.jLabel76.setText("Asistencia");
/*      */     
/* 1803 */     this.jSpinner3.setFont(new Font("Tahoma", 0, 30));
/* 1804 */     this.jSpinner3.setModel(new SpinnerListModel((Object[])new String[] { "A", "D", "M", "F" }));
/* 1805 */     this.jSpinner3.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1807 */             NominasComplementos.this.jSpinner3KeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1811 */     this.jButton14.setMnemonic('A');
/* 1812 */     this.jButton14.setText("Aceptar");
/* 1813 */     this.jButton14.setToolTipText("Aceptar (Alt+A)");
/* 1814 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1816 */             NominasComplementos.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1820 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1821 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1822 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1824 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1825 */           .addContainerGap()
/* 1826 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1827 */             .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1828 */               .addComponent(this.jSeparator12, -2, 213, -2)
/* 1829 */               .addGroup(jPanel20Layout.createSequentialGroup()
/* 1830 */                 .addComponent(this.jLabel76, -2, 71, -2)
/* 1831 */                 .addGap(6, 6, 6)
/* 1832 */                 .addComponent(this.jSpinner3)))
/* 1833 */             .addComponent(this.jButton14, -2, 98, -2))
/* 1834 */           .addContainerGap(-1, 32767))
/* 1835 */         .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1836 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
/* 1837 */             .addContainerGap(-1, 32767)
/* 1838 */             .addComponent(this.jLabel75, -2, 215, -2)
/* 1839 */             .addGap(593, 593, 593))));
/*      */     
/* 1841 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1842 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1843 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1844 */           .addGap(31, 31, 31)
/* 1845 */           .addComponent(this.jSeparator12, -2, 10, -2)
/* 1846 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1847 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1848 */             .addComponent(this.jLabel76, -1, -1, 32767)
/* 1849 */             .addComponent(this.jSpinner3, -1, 46, 32767))
/* 1850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1851 */           .addComponent(this.jButton14)
/* 1852 */           .addContainerGap(12, 32767))
/* 1853 */         .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1854 */           .addGroup(jPanel20Layout.createSequentialGroup()
/* 1855 */             .addComponent(this.jLabel75, -2, 31, -2)
/* 1856 */             .addGap(0, 108, 32767))));
/*      */ 
/*      */     
/* 1859 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1860 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1861 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1862 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1863 */         .addComponent(this.jPanel20, -1, 234, 32767));
/*      */     
/* 1865 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1866 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1867 */         .addGroup(jDialog6Layout.createSequentialGroup()
/* 1868 */           .addComponent(this.jPanel20, -1, -1, 32767)
/* 1869 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1872 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1873 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1875 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1876 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1877 */     this.jLabel54.setText("Nóminas");
/*      */     
/* 1879 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1880 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1882 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1883 */     this.jLabel48.setForeground(Color.red);
/* 1884 */     this.jLabel48.setHorizontalAlignment(0);
/* 1885 */     this.jLabel48.setText("t");
/* 1886 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1888 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1889 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1897 */     this.jTable3.setShowVerticalLines(false);
/* 1898 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1900 */             NominasComplementos.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1903 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1905 */             NominasComplementos.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1908 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1910 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1911 */     this.jButton23.setMnemonic('M');
/* 1912 */     this.jButton23.setText(" Modificar");
/* 1913 */     this.jButton23.setToolTipText("Modificar (Alt+M)");
/* 1914 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1916 */             NominasComplementos.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1920 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1921 */     this.jButton24.setMnemonic('N');
/* 1922 */     this.jButton24.setText("Nueva");
/* 1923 */     this.jButton24.setToolTipText("Crea nuevas Nóminas (Alt+N)");
/* 1924 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1926 */             NominasComplementos.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1930 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1931 */     this.jButton25.setMnemonic('C');
/* 1932 */     this.jButton25.setText("Cancelar");
/* 1933 */     this.jButton25.setToolTipText("Cancelar Nóminas (debe estar en estatus \"<Por Autorizar>\") (Alt+C)");
/* 1934 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1936 */             NominasComplementos.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1940 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1941 */     this.jButton26.setMnemonic('G');
/* 1942 */     this.jButton26.setText("Guardar Reporte");
/* 1943 */     this.jButton26.setToolTipText("Clic para exportar un reporte a excel (Alt+G)");
/* 1944 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1946 */             NominasComplementos.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1950 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 1951 */     this.jLabel35.setHorizontalAlignment(4);
/* 1952 */     this.jLabel35.setText("SUMAS:");
/*      */     
/* 1954 */     this.jLabel37.setFont(new Font("Tahoma", 0, 10));
/* 1955 */     this.jLabel37.setHorizontalAlignment(4);
/* 1956 */     this.jLabel37.setText("$0.00");
/*      */     
/* 1958 */     this.jLabel38.setFont(new Font("Tahoma", 0, 10));
/* 1959 */     this.jLabel38.setHorizontalAlignment(4);
/* 1960 */     this.jLabel38.setText("$0.00");
/*      */     
/* 1962 */     this.jLabel39.setFont(new Font("Tahoma", 0, 10));
/* 1963 */     this.jLabel39.setHorizontalAlignment(4);
/* 1964 */     this.jLabel39.setText("$0.00");
/*      */     
/* 1966 */     this.jLabel42.setFont(new Font("Tahoma", 0, 10));
/* 1967 */     this.jLabel42.setHorizontalAlignment(4);
/* 1968 */     this.jLabel42.setText("$0.00");
/*      */     
/* 1970 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1971 */     this.jButton2.setMnemonic('I');
/* 1972 */     this.jButton2.setText("Imprimir");
/* 1973 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 1974 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1976 */             NominasComplementos.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1980 */     this.jButton27.setMnemonic('G');
/* 1981 */     this.jButton27.setText("Tablas");
/* 1982 */     this.jButton27.setToolTipText("Clic para exportar un reporte a excel (Alt+G)");
/* 1983 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1985 */             NominasComplementos.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1989 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1990 */     this.jButton34.setMnemonic('V');
/* 1991 */     this.jButton34.setText("Ver");
/* 1992 */     this.jButton34.setToolTipText("Clic para ver el detalle de una nómina (Alt+V)");
/* 1993 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1995 */             NominasComplementos.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1999 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2000 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2001 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2002 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2003 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2004 */           .addComponent(this.jScrollPane3)
/* 2005 */           .addContainerGap())
/* 2006 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 2007 */           .addContainerGap(593, 32767)
/* 2008 */           .addComponent(this.jLabel35, -2, 68, -2)
/* 2009 */           .addGap(18, 18, 18)
/* 2010 */           .addComponent(this.jLabel42, -2, 77, -2)
/* 2011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2012 */           .addComponent(this.jLabel39, -2, 77, -2)
/* 2013 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2014 */           .addComponent(this.jLabel38, -2, 77, -2)
/* 2015 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2016 */           .addComponent(this.jLabel37, -2, 77, -2)
/* 2017 */           .addGap(252, 252, 252))
/* 2018 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2019 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 2020 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2021 */           .addComponent(this.jButton24, -2, 119, -2)
/* 2022 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2023 */           .addComponent(this.jButton34, -2, 119, -2)
/* 2024 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2025 */           .addComponent(this.jButton23, -2, 119, -2)
/* 2026 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2027 */           .addComponent(this.jButton25, -2, 119, -2)
/* 2028 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2029 */           .addComponent(this.jButton26)
/* 2030 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2031 */           .addComponent(this.jButton27, -2, 150, -2)
/* 2032 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2033 */           .addComponent(this.jButton2, -2, 124, -2)
/* 2034 */           .addContainerGap()));
/*      */     
/* 2036 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2037 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2038 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2039 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2040 */             .addComponent(this.jLabel48)
/* 2041 */             .addComponent(this.jButton24, -2, 28, -2)
/* 2042 */             .addComponent(this.jButton23, -2, 28, -2)
/* 2043 */             .addComponent(this.jButton25, -2, 28, -2)
/* 2044 */             .addComponent(this.jButton26, -2, 28, -2)
/* 2045 */             .addComponent(this.jButton2)
/* 2046 */             .addComponent(this.jButton27, -2, 28, -2)
/* 2047 */             .addComponent(this.jButton34, -2, 28, -2))
/* 2048 */           .addGap(7, 7, 7)
/* 2049 */           .addComponent(this.jScrollPane3, -1, 107, 32767)
/* 2050 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2051 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2052 */             .addComponent(this.jLabel37)
/* 2053 */             .addComponent(this.jLabel38)
/* 2054 */             .addComponent(this.jLabel39)
/* 2055 */             .addComponent(this.jLabel42)
/* 2056 */             .addComponent(this.jLabel35))));
/*      */ 
/*      */     
/* 2059 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2060 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Nóminas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2062 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2064 */             NominasComplementos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2068 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 2069 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 2070 */     this.jLabel15.setHorizontalAlignment(0);
/* 2071 */     this.jLabel15.setText("Folio");
/*      */     
/* 2073 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 2074 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Autorizada>", "<Cancelada>", "<Por Autorizar>" }));
/* 2075 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2077 */             NominasComplementos.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2081 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 2082 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 2083 */     this.jLabel46.setHorizontalAlignment(0);
/* 2084 */     this.jLabel46.setText("Estatus");
/*      */     
/* 2086 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 2087 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 2088 */     this.jLabel47.setHorizontalAlignment(0);
/* 2089 */     this.jLabel47.setText("Usuario");
/*      */     
/* 2091 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 2092 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 2093 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2095 */             NominasComplementos.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2099 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2101 */             NominasComplementos.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2105 */     this.jLabel34.setFont(new Font("Tahoma", 3, 12));
/* 2106 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/* 2107 */     this.jLabel34.setHorizontalAlignment(0);
/* 2108 */     this.jLabel34.setText("Semana");
/*      */     
/* 2110 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2111 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2112 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2113 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2114 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2115 */           .addContainerGap()
/* 2116 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2117 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 2118 */             .addComponent(this.jTextField1, -2, 81, -2))
/* 2119 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2120 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2121 */             .addComponent(this.jLabel34, -1, -1, 32767)
/* 2122 */             .addComponent(this.jTextField2, -1, 124, 32767))
/* 2123 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2124 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2125 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 2126 */             .addComponent(this.jComboBox8, -2, 104, -2))
/* 2127 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2128 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2129 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 2130 */             .addComponent(this.jComboBox11, -2, 152, -2))
/* 2131 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2133 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2134 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2135 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2136 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2137 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2138 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 2139 */               .addGap(8, 8, 8)
/* 2140 */               .addComponent(this.jLabel15, -1, -1, 32767))
/* 2141 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2142 */               .addComponent(this.jComboBox11, -2, -1, -2)
/* 2143 */               .addGap(8, 8, 8)
/* 2144 */               .addComponent(this.jLabel47))
/* 2145 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2146 */               .addComponent(this.jComboBox8, -2, -1, -2)
/* 2147 */               .addGap(8, 8, 8)
/* 2148 */               .addComponent(this.jLabel46, -1, -1, 32767))
/* 2149 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2150 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 2151 */               .addGap(8, 8, 8)
/* 2152 */               .addComponent(this.jLabel34, -1, -1, 32767)))
/* 2153 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2156 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 2157 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 2159 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2160 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2161 */     this.jDateChooser4.setIcon(this.icon);
/* 2162 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 2163 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2165 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2166 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2167 */     this.jDateChooser5.setIcon(this.icon);
/* 2168 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2170 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 2171 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 2172 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 2173 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2175 */             NominasComplementos.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2178 */             NominasComplementos.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2181 */             NominasComplementos.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2185 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 2186 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 2187 */     this.jLabel6.setHorizontalAlignment(0);
/* 2188 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 2189 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2191 */             NominasComplementos.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2194 */             NominasComplementos.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2197 */             NominasComplementos.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2201 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 2202 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 2203 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 2204 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2206 */             NominasComplementos.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2209 */             NominasComplementos.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2212 */             NominasComplementos.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2216 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 2217 */     this.jLabel1.setForeground(Color.red);
/* 2218 */     this.jLabel1.setHorizontalAlignment(4);
/* 2219 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 2221 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 2222 */     this.jLabel4.setForeground(Color.red);
/* 2223 */     this.jLabel4.setHorizontalAlignment(0);
/* 2224 */     this.jLabel4.setText("AL");
/*      */     
/* 2226 */     this.jButton1.setMnemonic('F');
/* 2227 */     this.jButton1.setText("Filtrar");
/* 2228 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2229 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2231 */             NominasComplementos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2235 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2236 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2237 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2239 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2240 */           .addContainerGap()
/* 2241 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 2242 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2243 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2244 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2245 */           .addComponent(this.jLabel4)
/* 2246 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2247 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2248 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2249 */           .addComponent(this.jButton1)
/* 2250 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2251 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 2252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2253 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 2254 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2255 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 2256 */           .addContainerGap(21, 32767)));
/*      */     
/* 2258 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2259 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2260 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2261 */           .addContainerGap()
/* 2262 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2263 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2264 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2265 */               .addGap(1, 1, 1)
/* 2266 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2267 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 2268 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2269 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 2270 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 2271 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 2272 */                   .addComponent(this.jButton1))
/* 2273 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2274 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 2275 */                   .addGap(1, 1, 1))
/* 2276 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 2279 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2280 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2281 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2283 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 2284 */           .addContainerGap()
/* 2285 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2286 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2287 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2288 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 2289 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 2290 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2291 */               .addComponent(this.jLabel54, -1, -1, 32767)))
/* 2292 */           .addContainerGap()));
/*      */     
/* 2294 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2295 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2296 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2297 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2298 */             .addComponent(this.jLabel54, -1, -1, 32767)
/* 2299 */             .addComponent(this.jPanel2, -1, -1, 32767))
/* 2300 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2301 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 2302 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2303 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 2304 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2307 */     GroupLayout layout = new GroupLayout(this);
/* 2308 */     setLayout(layout);
/* 2309 */     layout.setHorizontalGroup(layout
/* 2310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2311 */         .addGap(0, 1313, 32767)
/* 2312 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2313 */           .addGroup(layout.createSequentialGroup()
/* 2314 */             .addContainerGap()
/* 2315 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2316 */             .addContainerGap())));
/*      */     
/* 2318 */     layout.setVerticalGroup(layout
/* 2319 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2320 */         .addGap(0, 341, 32767)
/* 2321 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2322 */           .addGroup(layout.createSequentialGroup()
/* 2323 */             .addGap(10, 10, 10)
/* 2324 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2325 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 2330 */     if (evt.getClickCount() == 2) {
/* 2331 */       bloquear();
/* 2332 */       verNomina();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2344 */     int reg = this.jTable3.getSelectedRow();
/* 2345 */     if (reg >= 0) {
/* 2346 */       String edo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 14));
/* 2347 */       if (edo.equals("<Por Autorizar>")) {
/* 2348 */         desbloquear();
/* 2349 */         verNomina();
/* 2350 */         this.jButton28.setText("Modificar");
/* 2351 */         this.jButton28.setToolTipText("Modificar (Alt + M)");
/* 2352 */         this.jButton28.setMnemonic('M');
/*      */       } else {
/*      */         
/* 2355 */         JOptionPane.showMessageDialog(this.padre, "Para modificar una nómina debe estar en estatus '<Por Autorizar>'", "Verifica tu selección", 0, this.ADVER);
/*      */       } 
/*      */     } else {
/*      */       
/* 2359 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un formato de nómina", "Selecciona un registro", 0, this.ADVER);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2364 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 2365 */     StyleConstants.setBold(attrs, true);
/* 2366 */     this.jTextPane2.setText("");
/*      */     try {
/* 2368 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "FLETES Y MATERIALES FORSIS, S.A. DE C.V.\n", attrs);
/* 2369 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "AUTOPISTA CADEREYTA-MONTEREY K.M. 32.5\n", attrs);
/* 2370 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "CADEREYTA JIMENEZ, NUEVO LEON\n", attrs);
/* 2371 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "C.P. 67450\n\n", attrs);
/* 2372 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "RFC: FMF901004UZ9", attrs);
/* 2373 */     } catch (BadLocationException ex) {
/* 2374 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/* 2376 */     desbloquear();
/* 2377 */     sacarMayor();
/* 2378 */     sacarNumSem();
/* 2379 */     sacarFechas();
/* 2380 */     this.jRadioButton3.setSelected(true);
/* 2381 */     this.jTextField15.setText("");
/* 2382 */     this.jTextField16.setText("");
/* 2383 */     this.jTextField17.setText("");
/* 2384 */     this.jTextField13.setText(this.DIRECTIVA[1]);
/* 2385 */     this.jTextField14.setText("");
/* 2386 */     this.jTextField18.setText("");
/*      */     
/* 2388 */     this.jTable7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "NSS", "Nombre Completo", "CURP", "Departamento", "F. de Ingreso", "Salario Real", "L", "M", "M", "J", "V", "S", "D", "Días Lab.", "Horas Extra", "Dom. Lab.", "Gratificaciones", "Turno Extra", "Faltas", "Retardos", "Vacaciones", "EPP", "Préstamo", "Nextel", "Sueldo Fiscal", "Total Comp.", "Neto Pagado" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2395 */           Class[] types = new Class[] { Object.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */           
/* 2398 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false }; public Class getColumnClass(int columnIndex) {
/* 2402 */             return this.types[columnIndex];
/*      */           }
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2405 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2408 */     this.jTable7.setColumnSelectionAllowed(true);
/* 2409 */     this.jTable7.setShowHorizontalLines(false);
/* 2410 */     this.jTable7.getTableHeader().setReorderingAllowed(false);
/* 2411 */     this.jScrollPane13.setViewportView(this.jTable7);
/* 2412 */     this.jTable7.getColumnModel().getSelectionModel().setSelectionMode(0);
/*      */     
/* 2414 */     this.jFrame2.setVisible(true);
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
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 2437 */     String[] datos = { "FOLIO", "F DE ELABORACIÓN", "F INICIO", "F FINAL", "SEM", "PERIODO", "TIPO", "NO. EMP", "BANCO", "CHEQUE", "TOTAL IMSS", "TOTAL COMP", "TOTAL NETO", "USUARIO", "ESTATUS" };
/* 2438 */     this.esc = new EscribirReporte("FACTURAS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2447 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2451 */     if (this.jComboBox8.getItemCount() > 0) {
/* 2452 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 2457 */     if (this.jComboBox11.getItemCount() > 0) {
/* 2458 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2463 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 2467 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 2468 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2469 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 2473 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 2477 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 2481 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2482 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2483 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 2487 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 2491 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 2495 */     Calendar ca = Calendar.getInstance();
/* 2496 */     Calendar fecha = Calendar.getInstance();
/* 2497 */     int aa = fecha.get(1);
/* 2498 */     int mm = fecha.get(2);
/* 2499 */     int dd = fecha.get(5);
/* 2500 */     if (dd == 1) {
/* 2501 */       if (mm == 0) {
/* 2502 */         mm = 11;
/* 2503 */         aa--;
/*      */       } else {
/* 2505 */         mm--;
/*      */       } 
/* 2507 */       int diasTotal = diasDelMes(mm, aa);
/* 2508 */       dd = diasTotal;
/*      */     } else {
/* 2510 */       dd--;
/*      */     } 
/* 2512 */     mm++;
/* 2513 */     String año = "" + aa;
/* 2514 */     String mes = "" + mm;
/* 2515 */     String dia = "" + dd;
/* 2516 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2517 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2519 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2520 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2521 */     } catch (ParseException ex) {
/* 2522 */       ex.printStackTrace();
/*      */     } 
/* 2524 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 2528 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 2532 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2536 */     consultar();
/*      */   }
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
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 2550 */     if (evt.getClickCount() == 2);
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
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 2564 */     consultar1();
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 2568 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 2572 */     if (this.jRadioButton3.isSelected()) {
/* 2573 */       pasarEmpleado1();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2581 */     consultar1();
/*      */   }
/*      */   
/*      */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 2585 */     if (this.jCheckBox4.isSelected() == true) {
/* 2586 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 2587 */         this.jTable6.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } else {
/*      */       
/* 2591 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 2592 */         this.jTable6.setValueAt(Boolean.valueOf(false), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2598 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2602 */     verTablas();
/* 2603 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2611 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2615 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Límite Inferior", "Cuota Fija", "% Sobre excedente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2622 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2626 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2629 */     this.jScrollPane10.setViewportView(this.jTable1);
/* 2630 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2631 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2632 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */     
/* 2634 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2638 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2642 */     DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 2643 */     Object[] nuevo = { this.jFormattedTextField1.getText(), this.jFormattedTextField2.getText(), this.jFormattedTextField3.getText() };
/* 2644 */     temp.addRow(nuevo);
/* 2645 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2646 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2647 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2648 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2649 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 2650 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2654 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas guardar la nueva tabla de subsidio?", "Guardar Tabla", 0, 1, this.PREG);
/* 2655 */     if (res == 0) {
/* 2656 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2657 */         this.con.inserSinMsj("insert into ");
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2671 */     this.jCheckBox4.setSelected(false);
/* 2672 */     for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 2673 */       this.jTable6.setValueAt(Boolean.valueOf(false), i, 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2683 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 2687 */     this.jFrame2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 2691 */     if (this.jDateChooser16.getDate() == null) {
/* 2692 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacía la fecha de inicio, verifica tu información", "Fecha Vacía", 0, this.ERROR);
/*      */     }
/* 2694 */     else if (this.jDateChooser17.getDate() == null) {
/* 2695 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacía la fecha final, verifica tu información", "Fecha Vacía", 0, this.ERROR);
/*      */     }
/* 2697 */     else if (this.jTextField15.getText().equals("")) {
/* 2698 */       this.jTextField15.setBackground(Color.RED);
/* 2699 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacío el campo para ingrear el banco, verifica tu información", "Falta Banco", 0, this.ERROR);
/*      */     }
/* 2701 */     else if (this.jTextField16.getText().equals("")) {
/* 2702 */       this.jTextField16.setBackground(Color.RED);
/* 2703 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacío el campo para ingrear la clave de descripción, verifica tu información", "Falta Descripción", 0, this.ERROR);
/*      */     }
/* 2705 */     else if (this.jTextField17.getText().equals("")) {
/* 2706 */       this.jTextField17.setBackground(Color.RED);
/* 2707 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacío el campo para ingrear la clave de riesgo, verifica tu información", "Falta Riesgo", 0, this.ERROR);
/*      */     }
/* 2709 */     else if (this.jTextField13.getText().equals("")) {
/* 2710 */       this.jTextField13.setBackground(Color.RED);
/* 2711 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacío el campo para ingrear la sucursal, verifica tu información", "Falta Sucursal", 0, this.ERROR);
/*      */     }
/* 2713 */     else if (this.jTextField14.getText().equals("")) {
/* 2714 */       this.jTextField14.setBackground(Color.RED);
/* 2715 */       JOptionPane.showMessageDialog(this.jFrame2, "No puede dejar vacío el campo para ingrear la dirección, verifica tu información", "Falta Dirección", 0, this.ERROR);
/*      */     }
/* 2717 */     else if (this.jTable7.getRowCount() == 0) {
/* 2718 */       JOptionPane.showMessageDialog(this.jFrame2, "No puedes guardar la nómina, ya que debes tener por lo menos un empleado agregado.", "No existen empleados", 0, this.ERROR);
/*      */     }
/* 2720 */     else if (this.jButton28.getText().equals("Guardar")) {
/* 2721 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas crear una nueva nómina?", "Guardar Nómina", 0, 3, this.PREG);
/* 2722 */       if (res == 0) {
/* 2723 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2724 */         String cadenaFecha1 = formato.format(this.jDateChooser16.getDate());
/* 2725 */         String año = cadenaFecha1.substring(0, 4);
/* 2726 */         String mes = cadenaFecha1.substring(4, 6);
/* 2727 */         String dia = cadenaFecha1.substring(6, 8);
/* 2728 */         String fechaCompleta1 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 2730 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 2731 */         cadenaFecha1 = formato.format(this.jDateChooser17.getDate());
/* 2732 */         año = cadenaFecha1.substring(0, 4);
/* 2733 */         mes = cadenaFecha1.substring(4, 6);
/* 2734 */         dia = cadenaFecha1.substring(6, 8);
/* 2735 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 2737 */         this.con.inserSinMsj("insert into nominas(folio,fecha_creacion, fecha_inicio, fecha_final, semana, periodo_pago, tipo, num_empleados, generales, banco, descripcion, riesgo, sucursal, direccion, cheque, motivo, usuario, total_imss, total_comp, total_neto, estatus) values ('" + this.jTextField12.getText() + "',now()," + fechaCompleta1 + "," + fechaCompleta2 + "," + String.valueOf(this.jSpinner9.getValue()) + ",'','ADMINISTRATIVO'," + this.jLabel57.getText() + ",'" + this.jTextPane2.getText().toUpperCase() + "','" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "','" + this.jTextField13.getText().toUpperCase() + "','" + this.jTextField14.getText().toUpperCase() + "','" + this.jTextField18.getText().toUpperCase() + "','','" + this.USUARIO + "','$0.00','" + this.jLabel78.getText() + "','" + this.jLabel71.getText() + "','<Por Autorizar>')");
/* 2738 */         for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 2739 */           this.con.inserSinMsj("insert into nominas_empleados2 (clave_emp, nss, nombre, curp, departamento, fecha_ingreso, salario_real, dia1, dia2, dia3, dia4, dia5, dia6, dia7, dias_lab, horas_extra, dom_lab, gratificaciones, turno_extra, faltas, retardos, vacaciones, epp, prestamos, nextel, sueldo_fiscal, total_comp, neto, num_nomina) values ('" + String.valueOf(this.jTable7.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 7)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 8)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 9)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 10)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 11)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 12)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 13)) + "'," + String.valueOf(this.jTable7.getValueAt(i, 14)) + ",'" + String.valueOf(this.jTable7.getValueAt(i, 15)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 16)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 17)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 18)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 19)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 20)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 21)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 22)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 23)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 24)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 25)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 26)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 27)) + "','" + this.jTextField12.getText() + "')");
/*      */         }
/*      */         
/* 2742 */         JOptionPane.showMessageDialog(this.jFrame2, "Los datos se han actualizado correctamente", "Nómina Mofificada", 0, this.INFO);
/*      */       }
/*      */     
/* 2745 */     } else if (this.jButton28.getText().equals("Modificar")) {
/* 2746 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar la nómina?", "Modificar Nómina", 0, 3, this.PREG);
/* 2747 */       if (res == 0) {
/* 2748 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2749 */         String cadenaFecha1 = formato.format(this.jDateChooser16.getDate());
/* 2750 */         String año = cadenaFecha1.substring(0, 4);
/* 2751 */         String mes = cadenaFecha1.substring(4, 6);
/* 2752 */         String dia = cadenaFecha1.substring(6, 8);
/* 2753 */         String fechaCompleta1 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 2755 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 2756 */         cadenaFecha1 = formato.format(this.jDateChooser17.getDate());
/* 2757 */         año = cadenaFecha1.substring(0, 4);
/* 2758 */         mes = cadenaFecha1.substring(4, 6);
/* 2759 */         dia = cadenaFecha1.substring(6, 8);
/* 2760 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2770 */         this.con.inserSinMsj("update nominas set fecha_creacion = now(), fecha_inicio=" + fechaCompleta1 + ", fecha_final=" + fechaCompleta2 + ", semana=" + String.valueOf(this.jSpinner9.getValue()) + ", periodo_pago='',tipo='ADMINISTRATIVO', num_empleados=" + this.jLabel57.getText() + ", generales='" + this.jTextPane2.getText() + "',banco='" + this.jTextField15.getText().toUpperCase() + "', descripcion='" + this.jTextField16.getText().toUpperCase() + "',riesgo='" + this.jTextField17.getText().toUpperCase() + "', sucursal='" + this.jTextField13.getText().toUpperCase() + "', direccion='" + this.jTextField14.getText().toUpperCase() + "', cheque='" + this.jTextField18.getText().toUpperCase() + "', motivo='', usuario='" + this.USUARIO + "',total_Imss='" + this.jLabel79.getText() + "',total_comp='" + this.jLabel78.getText() + "', total_neto='" + this.jLabel71.getText() + "',estatus='<Por Autorizar>' where folio='" + this.jTextField12.getText() + "'");
/* 2771 */         this.con.eliminar2("nominas_empleados2", "where num_nomina = '" + this.jTextField12.getText() + "'");
/* 2772 */         for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 2773 */           this.con.inserSinMsj("insert into nominas_empleados2 (clave_emp, nss, nombre, curp, departamento, fecha_ingreso, salario_real, dia1, dia2, dia3, dia4, dia5, dia6, dia7, dias_lab, horas_extra, dom_lab, gratificaciones, turno_extra, faltas, retardos, vacaciones, epp, prestamos, nextel, sueldo_fiscal, total_comp, neto, num_nomina) values ('" + String.valueOf(this.jTable7.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 7)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 8)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 9)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 10)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 11)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 12)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 13)) + "'," + String.valueOf(this.jTable7.getValueAt(i, 14)) + ",'" + String.valueOf(this.jTable7.getValueAt(i, 15)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 16)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 17)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 18)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 19)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 20)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 21)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 22)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 23)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 24)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 25)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 26)) + "','" + String.valueOf(this.jTable7.getValueAt(i, 27)) + "','" + this.jTextField12.getText() + "')");
/*      */         }
/*      */         
/* 2776 */         JOptionPane.showMessageDialog(this.jFrame2, "Los datos se han actualizado correctamente", "Nómina Mofificada", 0, this.INFO);
/*      */         
/* 2778 */         this.jFrame2.setVisible(false);
/* 2779 */         consultar();
/*      */       } 
/*      */     } else {
/*      */       
/* 2783 */       sumarFinales();
/* 2784 */       ImprimirNomina imprimir = new ImprimirNomina();
/* 2785 */       imprimir.recibeDatos();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 2791 */     String[] datos = new String[this.jTable7.getColumnCount()];
/* 2792 */     for (int i = 0; i < this.jTable7.getColumnCount(); i++) {
/* 2793 */       datos[i] = this.jTable7.getColumnName(i);
/*      */     }
/* 2795 */     this.esc = new EscribirReporte(" NOMINA " + this.jTextField12.getText().toLowerCase(), this.jTable7, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 2799 */     int indice = this.jTable7.getSelectedRow();
/* 2800 */     if (indice < 0) {
/* 2801 */       JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un empleado para poder quitarlo", "Selecciona un empleado", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2804 */       DefaultTableModel temp = (DefaultTableModel)this.jTable7.getModel();
/* 2805 */       temp.removeRow(indice);
/* 2806 */       totalNeto();
/* 2807 */       totalComplemento();
/* 2808 */       totalImss();
/*      */     } 
/* 2810 */     this.jLabel57.setText("" + this.jTable7.getRowCount());
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTable7KeyReleased(KeyEvent evt) {
/* 2818 */     int ind = this.jTable7.getSelectedRow();
/* 2819 */     if (ind > 0) {
/* 2820 */       this.jLabel73.setText(String.valueOf(this.jTable7.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable7.getValueAt(ind, 0)));
/*      */     } else {
/*      */       
/* 2823 */       this.jLabel73.setText(String.valueOf(this.jTable7.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable7.getValueAt(ind, 0)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable7KeyPressed(KeyEvent evt) {
/* 2828 */     int valor = this.jTable7.getSelectedColumn();
/* 2829 */     int p = evt.getKeyCode();
/* 2830 */     if (p == 10 && (this.jButton28.getText().equals("Guardar") || this.jButton28.getText().equals("Modificar")) && (this.jTable7.getSelectedColumn() == 15 || this.jTable7.getSelectedColumn() == 16 || this.jTable7.getSelectedColumn() == 17 || this.jTable7.getSelectedColumn() == 18 || this.jTable7.getSelectedColumn() == 19 || this.jTable7.getSelectedColumn() == 20 || this.jTable7.getSelectedColumn() == 21 || this.jTable7.getSelectedColumn() == 22 || this.jTable7.getSelectedColumn() == 23 || this.jTable7.getSelectedColumn() == 24 || this.jTable7.getSelectedColumn() == 25)) {
/* 2831 */       String canti = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn()));
/* 2832 */       String valorP = "";
/* 2833 */       for (int j = 0; j < canti.length(); j++) {
/* 2834 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2835 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2838 */       double cantidad = Double.parseDouble(valorP);
/* 2839 */       this.jFormattedTextField4.setValue(Double.valueOf(cantidad));
/* 2840 */       this.jDialog5.setVisible(true);
/* 2841 */       System.out.println("Entroooooooo");
/*      */     }
/* 2843 */     else if (p == 10 && (this.jTable7.getSelectedColumn() == 7 || this.jTable7.getSelectedColumn() == 8 || this.jTable7.getSelectedColumn() == 9 || this.jTable7.getSelectedColumn() == 10 || this.jTable7.getSelectedColumn() == 11 || this.jTable7.getSelectedColumn() == 12 || this.jTable7.getSelectedColumn() == 13)) {
/* 2844 */       this.jSpinner3.setValue(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn()));
/* 2845 */       this.jDialog6.setVisible(true);
/*      */     } 
/*      */     
/* 2848 */     if (valor > 9 || valor * 45 < 680) {
/* 2849 */       this.jScrollPane12.getHorizontalScrollBar().setValue(valor * 45);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField4KeyPressed(KeyEvent evt) {
/* 2856 */     int valor = this.jTable7.getSelectedColumn();
/* 2857 */     int p = evt.getKeyCode();
/* 2858 */     if (p == 10) {
/* 2859 */       double val = Double.parseDouble(this.jFormattedTextField4.getText());
/* 2860 */       this.cantidad.setValue(Double.valueOf(val));
/*      */       
/* 2862 */       this.jDialog5.setVisible(false);
/* 2863 */       this.jTable7.setValueAt(this.cantidad.getText(), this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn());
/* 2864 */       calculaTotal(this.jTable7.getSelectedRow());
/* 2865 */       calculaComplemento(this.jTable7.getSelectedRow());
/* 2866 */       totalNeto();
/* 2867 */       totalComplemento();
/* 2868 */       totalImss();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2873 */     this.jTable7.setValueAt(this.jSpinner3.getValue(), this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn());
/* 2874 */     sacarDias();
/* 2875 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jSpinner3KeyPressed(KeyEvent evt) {
/* 2879 */     int p = evt.getKeyCode();
/* 2880 */     System.out.println("Tecla " + p + " 10");
/* 2881 */     if (p == 10) {
/* 2882 */       this.jTable7.setValueAt(this.jSpinner3.getValue(), this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn());
/* 2883 */       this.jDialog6.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable7MouseClicked(MouseEvent evt) {
/* 2888 */     if (evt.getClickCount() == 2 && (this.jButton28.getText().equals("Guardar") || this.jButton28.getText().equals("Modificar"))) {
/* 2889 */       if (this.jTable7.getSelectedColumn() == 15 || this.jTable7.getSelectedColumn() == 16 || this.jTable7.getSelectedColumn() == 17 || this.jTable7.getSelectedColumn() == 18 || this.jTable7.getSelectedColumn() == 19 || this.jTable7.getSelectedColumn() == 20 || this.jTable7.getSelectedColumn() == 21 || this.jTable7.getSelectedColumn() == 22 || this.jTable7.getSelectedColumn() == 23 || this.jTable7.getSelectedColumn() == 24 || this.jTable7.getSelectedColumn() == 25) {
/* 2890 */         String canti = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn()));
/* 2891 */         String valorP = "";
/* 2892 */         for (int j = 0; j < canti.length(); j++) {
/* 2893 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2894 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 2897 */         double cantidad = Double.parseDouble(valorP);
/* 2898 */         this.jFormattedTextField4.setValue(Double.valueOf(cantidad));
/* 2899 */         this.jDialog5.setVisible(true);
/*      */       
/*      */       }
/* 2902 */       else if (this.jTable7.getSelectedColumn() == 7 || this.jTable7.getSelectedColumn() == 8 || this.jTable7.getSelectedColumn() == 9 || this.jTable7.getSelectedColumn() == 10 || this.jTable7.getSelectedColumn() == 11 || this.jTable7.getSelectedColumn() == 12 || this.jTable7.getSelectedColumn() == 13) {
/* 2903 */         this.jSpinner3.setValue(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), this.jTable7.getSelectedColumn()));
/* 2904 */         this.jDialog6.setVisible(true);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 2909 */       int ind = this.jTable7.getSelectedRow();
/* 2910 */       if (ind > 0) {
/* 2911 */         this.jLabel73.setText(String.valueOf(this.jTable7.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable7.getValueAt(ind, 0)));
/*      */       } else {
/*      */         
/* 2914 */         this.jLabel73.setText(String.valueOf(this.jTable7.getValueAt(ind, 0)) + "  :  " + String.valueOf(this.jTable7.getValueAt(ind, 0)));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2920 */     int reg = this.jTable3.getSelectedRow();
/* 2921 */     if (reg >= 0) {
/* 2922 */       bloquear();
/* 2923 */       verNomina();
/*      */     } else {
/*      */       
/* 2926 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un formato de nómina", "Selecciona un registro", 0, this.ADVER);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 2931 */     consultar1();
/*      */   }
/*      */   
/*      */   public void totalNeto() {
/* 2935 */     double totalNeto = 0.0D;
/* 2936 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 2937 */       String canti = String.valueOf(this.jTable7.getValueAt(i, 27));
/* 2938 */       String valorP = "";
/* 2939 */       for (int j = 0; j < canti.length(); j++) {
/* 2940 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2941 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2944 */       totalNeto += Double.parseDouble(valorP);
/*      */     } 
/* 2946 */     this.cantidad.setValue(Double.valueOf(totalNeto));
/* 2947 */     this.jLabel71.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void sumarFinales() {
/* 2951 */     this.gratificacionesIndividualTotal = new double[this.jTable7.getRowCount()];
/* 2952 */     this.descuentosIndividualTotal = new double[this.jTable7.getRowCount()];
/*      */     
/* 2954 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/*      */       
/* 2956 */       String canti = String.valueOf(this.jTable7.getValueAt(i, 6));
/* 2957 */       String valorP = "";
/* 2958 */       for (int j = 0; j < canti.length(); j++) {
/* 2959 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2960 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2963 */       this.salarioRealTotal += Double.parseDouble(valorP);
/*      */       
/* 2965 */       double aux1 = 0.0D;
/* 2966 */       canti = String.valueOf(this.jTable7.getValueAt(i, 15));
/* 2967 */       valorP = ""; int k;
/* 2968 */       for (k = 0; k < canti.length(); k++) {
/* 2969 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 2970 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2973 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 2975 */       canti = String.valueOf(this.jTable7.getValueAt(i, 16));
/* 2976 */       valorP = "";
/* 2977 */       for (k = 0; k < canti.length(); k++) {
/* 2978 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 2979 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2982 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 2984 */       canti = String.valueOf(this.jTable7.getValueAt(i, 17));
/* 2985 */       valorP = "";
/* 2986 */       for (k = 0; k < canti.length(); k++) {
/* 2987 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 2988 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2991 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 2993 */       canti = String.valueOf(this.jTable7.getValueAt(i, 18));
/* 2994 */       valorP = "";
/* 2995 */       for (k = 0; k < canti.length(); k++) {
/* 2996 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 2997 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3000 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3002 */       this.gratificacionesIndividualTotal[i] = aux1;
/* 3003 */       this.gratificacionesTotal += aux1;
/*      */       
/* 3005 */       aux1 = 0.0D;
/*      */       
/* 3007 */       canti = String.valueOf(this.jTable7.getValueAt(i, 19));
/* 3008 */       valorP = "";
/* 3009 */       for (k = 0; k < canti.length(); k++) {
/* 3010 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3011 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3014 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3016 */       canti = String.valueOf(this.jTable7.getValueAt(i, 20));
/* 3017 */       valorP = "";
/* 3018 */       for (k = 0; k < canti.length(); k++) {
/* 3019 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3020 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3023 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3025 */       canti = String.valueOf(this.jTable7.getValueAt(i, 21));
/* 3026 */       valorP = "";
/* 3027 */       for (k = 0; k < canti.length(); k++) {
/* 3028 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3029 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3032 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3034 */       canti = String.valueOf(this.jTable7.getValueAt(i, 22));
/* 3035 */       valorP = "";
/* 3036 */       for (k = 0; k < canti.length(); k++) {
/* 3037 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3038 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3041 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3043 */       canti = String.valueOf(this.jTable7.getValueAt(i, 23));
/* 3044 */       valorP = "";
/* 3045 */       for (k = 0; k < canti.length(); k++) {
/* 3046 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3047 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3050 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3052 */       canti = String.valueOf(this.jTable7.getValueAt(i, 24));
/* 3053 */       valorP = "";
/* 3054 */       for (k = 0; k < canti.length(); k++) {
/* 3055 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 3056 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3059 */       aux1 += Double.parseDouble(valorP);
/*      */       
/* 3061 */       this.descuentosIndividualTotal[i] = aux1;
/* 3062 */       this.descuentosTotal += aux1;
/*      */     } 
/*      */   }
/*      */   public void totalComplemento() {
/* 3066 */     double totalNeto = 0.0D;
/* 3067 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 3068 */       String canti = String.valueOf(this.jTable7.getValueAt(i, 26));
/* 3069 */       String valorP = "";
/* 3070 */       for (int j = 0; j < canti.length(); j++) {
/* 3071 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3072 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3075 */       totalNeto += Double.parseDouble(valorP);
/*      */     } 
/* 3077 */     this.cantidad.setValue(Double.valueOf(totalNeto));
/* 3078 */     this.jLabel78.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void totalImss() {
/* 3082 */     double totalNeto = 0.0D;
/* 3083 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 3084 */       String canti = String.valueOf(this.jTable7.getValueAt(i, 25));
/* 3085 */       String valorP = "";
/* 3086 */       for (int j = 0; j < canti.length(); j++) {
/* 3087 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3088 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3091 */       totalNeto += Double.parseDouble(valorP);
/*      */     } 
/* 3093 */     this.cantidad.setValue(Double.valueOf(totalNeto));
/* 3094 */     this.jLabel79.setText(this.cantidad.getText());
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarSubTotal(int indice) {
/* 3099 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 16));
/* 3100 */     String valorP = "";
/* 3101 */     for (int j = 0; j < canti.length(); j++) {
/* 3102 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3103 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3106 */     double salarioComp = Double.parseDouble(valorP);
/* 3107 */     int dias = Integer.parseInt(String.valueOf(this.jTable7.getValueAt(indice, 14)));
/* 3108 */     double subtotal = salarioComp * dias;
/* 3109 */     this.cantidad.setValue(Double.valueOf(subtotal));
/* 3110 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 17);
/*      */   }
/*      */   public void sacarDias() {
/* 3113 */     int dias = 0;
/* 3114 */     for (int i = 0; i < 7; i++) {
/* 3115 */       String valor = String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), i + 7));
/* 3116 */       if (valor.equals("A") || valor.equals("D")) {
/* 3117 */         dias++;
/*      */       }
/*      */     } 
/* 3120 */     this.jTable7.setValueAt(Integer.valueOf(dias), this.jTable7.getSelectedRow(), 14);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 3126 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3128 */             NominasComplementos.this.jTextGanado(NominasComplementos.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3131 */             NominasComplementos.this.jTextPerdido(NominasComplementos.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 3135 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3137 */             NominasComplementos.this.jTextGanado(NominasComplementos.this.jTextField15, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3140 */             NominasComplementos.this.jTextPerdido(NominasComplementos.this.jTextField15, evt);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3284 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3287 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void verNomina() {
/* 3291 */     this.jTextField12.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)));
/*      */     
/* 3293 */     String FECHA = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 3294 */     String año = FECHA.substring(0, 4);
/* 3295 */     String mes = FECHA.substring(5, 7);
/* 3296 */     String dia = FECHA.substring(8, 10);
/* 3297 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3298 */     String strFecha = año + "-" + año + "-" + mes;
/* 3299 */     Date fecha = null;
/*      */     try {
/* 3301 */       fecha = formatoDelTexto.parse(strFecha);
/* 3302 */       this.jDateChooser16.setDate(fecha);
/*      */     }
/* 3304 */     catch (ParseException ex) {
/* 3305 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3308 */     FECHA = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3));
/* 3309 */     año = FECHA.substring(0, 4);
/* 3310 */     mes = FECHA.substring(5, 7);
/* 3311 */     dia = FECHA.substring(8, 10);
/* 3312 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3313 */     strFecha = año + "-" + año + "-" + mes;
/* 3314 */     fecha = null;
/*      */     try {
/* 3316 */       fecha = formatoDelTexto.parse(strFecha);
/* 3317 */       this.jDateChooser17.setDate(fecha);
/*      */     }
/* 3319 */     catch (ParseException ex) {
/* 3320 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3323 */     FECHA = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 3324 */     año = FECHA.substring(0, 4);
/* 3325 */     mes = FECHA.substring(5, 7);
/* 3326 */     dia = FECHA.substring(8, 10);
/* 3327 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3328 */     strFecha = año + "-" + año + "-" + mes;
/* 3329 */     fecha = null;
/*      */     try {
/* 3331 */       fecha = formatoDelTexto.parse(strFecha);
/* 3332 */       this.jDateChooser15.setDate(fecha);
/*      */     }
/* 3334 */     catch (ParseException ex) {
/* 3335 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3338 */     int num = Integer.parseInt(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4)));
/* 3339 */     this.jSpinner9.setValue(Integer.valueOf(num));
/* 3340 */     String[] datos = this.con.regresaReg("sucursal,direccion,descripcion,riesgo,total_imss,total_comp,total_neto,generales", "nominas", "where folio ='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "'", 8);
/* 3341 */     this.jLabel79.setText(datos[4]);
/* 3342 */     this.jLabel78.setText(datos[5]);
/* 3343 */     this.jLabel71.setText(datos[6]);
/* 3344 */     this.jTextPane2.setText(datos[7]);
/*      */     
/* 3346 */     this.jTextField15.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8)));
/* 3347 */     this.jTextField16.setText(datos[2]);
/* 3348 */     this.jTextField17.setText(datos[3]);
/*      */     
/* 3350 */     this.jTextField13.setText(datos[0]);
/* 3351 */     this.jTextField14.setText(datos[1]);
/* 3352 */     this.jTextField18.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9)));
/*      */     
/* 3354 */     this.con.consultar("count(num)", "nominas_empleados2", "where num_nomina='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "' order by num asc");
/* 3355 */     int totreg = Integer.parseInt(this.con.Campo);
/* 3356 */     this.jLabel57.setText("" + totreg);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3370 */     totalNeto();
/* 3371 */     totalComplemento();
/* 3372 */     this.jLabel57.setText("" + this.jTable7.getRowCount());
/*      */     
/* 3374 */     this.jTable7.setColumnSelectionAllowed(true);
/* 3375 */     this.jTable7.setSelectionMode(0);
/*      */     
/* 3377 */     int fila = this.jTable7.getSelectedRow();
/* 3378 */     int col = this.jTable7.getSelectedColumn();
/* 3379 */     GregorianCalendar cal = (GregorianCalendar)this.jDateChooser16.getCalendar();
/* 3380 */     int diaL = cal.get(7);
/* 3381 */     dia = regresaDiaLetra(diaL);
/*      */     
/* 3383 */     JTableHeader th = this.jTable7.getTableHeader();
/* 3384 */     TableColumnModel tcm = th.getColumnModel();
/* 3385 */     TableColumn tc = tcm.getColumn(7);
/* 3386 */     tc.setHeaderValue(dia);
/*      */     
/* 3388 */     cal.add(5, 1);
/* 3389 */     diaL = cal.get(7);
/* 3390 */     dia = regresaDiaLetra(diaL);
/*      */     
/* 3392 */     th = this.jTable7.getTableHeader();
/* 3393 */     tcm = th.getColumnModel();
/* 3394 */     tc = tcm.getColumn(8);
/* 3395 */     tc.setHeaderValue(dia);
/*      */     
/* 3397 */     cal.add(5, 1);
/* 3398 */     diaL = cal.get(7);
/* 3399 */     dia = regresaDiaLetra(diaL);
/* 3400 */     th = this.jTable7.getTableHeader();
/* 3401 */     tcm = th.getColumnModel();
/* 3402 */     tc = tcm.getColumn(9);
/* 3403 */     tc.setHeaderValue(dia);
/*      */     
/* 3405 */     cal.add(5, 1);
/* 3406 */     diaL = cal.get(7);
/* 3407 */     dia = regresaDiaLetra(diaL);
/* 3408 */     th = this.jTable7.getTableHeader();
/* 3409 */     tcm = th.getColumnModel();
/* 3410 */     tc = tcm.getColumn(10);
/* 3411 */     tc.setHeaderValue(dia);
/*      */     
/* 3413 */     cal.add(5, 1);
/* 3414 */     diaL = cal.get(7);
/* 3415 */     dia = regresaDiaLetra(diaL);
/* 3416 */     th = this.jTable7.getTableHeader();
/* 3417 */     tcm = th.getColumnModel();
/* 3418 */     tc = tcm.getColumn(11);
/* 3419 */     tc.setHeaderValue(dia);
/*      */     
/* 3421 */     cal.add(5, 1);
/* 3422 */     diaL = cal.get(7);
/* 3423 */     dia = regresaDiaLetra(diaL);
/* 3424 */     th = this.jTable7.getTableHeader();
/* 3425 */     tcm = th.getColumnModel();
/* 3426 */     tc = tcm.getColumn(12);
/* 3427 */     tc.setHeaderValue(dia);
/*      */     
/* 3429 */     cal.add(5, 1);
/* 3430 */     diaL = cal.get(7);
/* 3431 */     dia = regresaDiaLetra(diaL);
/* 3432 */     th = this.jTable7.getTableHeader();
/* 3433 */     tcm = th.getColumnModel();
/* 3434 */     tc = tcm.getColumn(13);
/* 3435 */     tc.setHeaderValue(dia);
/* 3436 */     th.repaint();
/*      */     
/* 3438 */     this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 3439 */     this.jTable7.getColumnModel().getColumn(0).setMaxWidth(70);
/* 3440 */     this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(85);
/* 3441 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(85);
/* 3442 */     this.jTable7.getColumnModel().getColumn(3).setPreferredWidth(160);
/* 3443 */     this.jTable7.getColumnModel().getColumn(3).setMaxWidth(160);
/* 3444 */     this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 3445 */     this.jTable7.getColumnModel().getColumn(5).setMaxWidth(80);
/* 3446 */     this.jTable7.getColumnModel().getColumn(6).setPreferredWidth(75);
/* 3447 */     this.jTable7.getColumnModel().getColumn(6).setMaxWidth(75);
/*      */     
/* 3449 */     this.jTable7.getColumnModel().getColumn(7).setPreferredWidth(35);
/* 3450 */     this.jTable7.getColumnModel().getColumn(7).setMaxWidth(35);
/* 3451 */     this.jTable7.getColumnModel().getColumn(8).setPreferredWidth(35);
/* 3452 */     this.jTable7.getColumnModel().getColumn(8).setMaxWidth(35);
/* 3453 */     this.jTable7.getColumnModel().getColumn(9).setPreferredWidth(35);
/* 3454 */     this.jTable7.getColumnModel().getColumn(9).setMaxWidth(35);
/* 3455 */     this.jTable7.getColumnModel().getColumn(10).setPreferredWidth(35);
/* 3456 */     this.jTable7.getColumnModel().getColumn(10).setMaxWidth(35);
/* 3457 */     this.jTable7.getColumnModel().getColumn(11).setPreferredWidth(35);
/* 3458 */     this.jTable7.getColumnModel().getColumn(11).setMaxWidth(35);
/* 3459 */     this.jTable7.getColumnModel().getColumn(12).setPreferredWidth(35);
/* 3460 */     this.jTable7.getColumnModel().getColumn(12).setMaxWidth(35);
/* 3461 */     this.jTable7.getColumnModel().getColumn(13).setPreferredWidth(35);
/* 3462 */     this.jTable7.getColumnModel().getColumn(13).setMaxWidth(35);
/*      */     
/* 3464 */     this.jTable7.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 3465 */     this.jTable7.getColumnModel().getColumn(14).setMaxWidth(65);
/* 3466 */     this.jTable7.getColumnModel().getColumn(15).setPreferredWidth(80);
/* 3467 */     this.jTable7.getColumnModel().getColumn(15).setMaxWidth(80);
/* 3468 */     this.jTable7.getColumnModel().getColumn(16).setPreferredWidth(60);
/* 3469 */     this.jTable7.getColumnModel().getColumn(16).setMaxWidth(60);
/* 3470 */     this.jTable7.getColumnModel().getColumn(17).setPreferredWidth(90);
/* 3471 */     this.jTable7.getColumnModel().getColumn(17).setMaxWidth(90);
/* 3472 */     this.jTable7.getColumnModel().getColumn(18).setPreferredWidth(80);
/* 3473 */     this.jTable7.getColumnModel().getColumn(18).setMaxWidth(80);
/* 3474 */     this.jTable7.getColumnModel().getColumn(19).setPreferredWidth(60);
/* 3475 */     this.jTable7.getColumnModel().getColumn(19).setMaxWidth(60);
/* 3476 */     this.jTable7.getColumnModel().getColumn(20).setPreferredWidth(70);
/* 3477 */     this.jTable7.getColumnModel().getColumn(20).setMaxWidth(70);
/* 3478 */     this.jTable7.getColumnModel().getColumn(21).setPreferredWidth(75);
/* 3479 */     this.jTable7.getColumnModel().getColumn(21).setMaxWidth(75);
/* 3480 */     this.jTable7.getColumnModel().getColumn(22).setPreferredWidth(60);
/* 3481 */     this.jTable7.getColumnModel().getColumn(22).setMaxWidth(60);
/* 3482 */     this.jTable7.getColumnModel().getColumn(23).setPreferredWidth(80);
/* 3483 */     this.jTable7.getColumnModel().getColumn(23).setMaxWidth(80);
/* 3484 */     this.jTable7.getColumnModel().getColumn(24).setPreferredWidth(60);
/* 3485 */     this.jTable7.getColumnModel().getColumn(24).setMaxWidth(60);
/* 3486 */     this.jTable7.getColumnModel().getColumn(25).setPreferredWidth(80);
/* 3487 */     this.jTable7.getColumnModel().getColumn(25).setMaxWidth(80);
/* 3488 */     this.jTable7.getColumnModel().getColumn(26).setPreferredWidth(70);
/* 3489 */     this.jTable7.getColumnModel().getColumn(26).setMaxWidth(70);
/* 3490 */     this.jTable7.getColumnModel().getColumn(27).setPreferredWidth(90);
/* 3491 */     this.jTable7.getColumnModel().getColumn(27).setMaxWidth(90);
/*      */     
/* 3493 */     this.jTable7.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3494 */     this.jTable7.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3495 */     this.jTable7.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3496 */     this.jTable7.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3497 */     this.jTable7.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3498 */     this.jTable7.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3499 */     this.jTable7.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3500 */     this.jTable7.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3501 */     this.jTable7.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3502 */     this.jTable7.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3503 */     this.jTable7.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3504 */     this.jTable7.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3505 */     this.jTable7.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3506 */     this.jTable7.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 3507 */     this.jTable7.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/* 3508 */     this.jTable7.getColumnModel().getColumn(15).setCellRenderer(this.celda2);
/* 3509 */     this.jTable7.getColumnModel().getColumn(16).setCellRenderer(this.celda2);
/* 3510 */     this.jTable7.getColumnModel().getColumn(17).setCellRenderer(this.celda2);
/* 3511 */     this.jTable7.getColumnModel().getColumn(18).setCellRenderer(this.celda2);
/* 3512 */     this.jTable7.getColumnModel().getColumn(19).setCellRenderer(this.celda2);
/* 3513 */     this.jTable7.getColumnModel().getColumn(20).setCellRenderer(this.celda2);
/* 3514 */     this.jTable7.getColumnModel().getColumn(21).setCellRenderer(this.celda2);
/* 3515 */     this.jTable7.getColumnModel().getColumn(22).setCellRenderer(this.celda2);
/* 3516 */     this.jTable7.getColumnModel().getColumn(23).setCellRenderer(this.celda2);
/* 3517 */     this.jTable7.getColumnModel().getColumn(24).setCellRenderer(this.celda2);
/* 3518 */     this.jTable7.getColumnModel().getColumn(25).setCellRenderer(this.celda2);
/* 3519 */     this.jTable7.getColumnModel().getColumn(26).setCellRenderer(this.celda2);
/* 3520 */     this.jTable7.getColumnModel().getColumn(27).setCellRenderer(this.celda2);
/* 3521 */     this.jFrame2.setVisible(true);
/*      */   }
/*      */   
/*      */   public void desbloquear() {
/* 3525 */     this.jDateChooser16.setEnabled(true);
/* 3526 */     this.jDateChooser17.setEnabled(true);
/* 3527 */     this.jSpinner9.setEnabled(true);
/* 3528 */     this.jTextField13.setEnabled(true);
/* 3529 */     this.jTextField14.setEnabled(true);
/* 3530 */     this.jTextField18.setEnabled(true);
/*      */     
/* 3532 */     this.jTextField15.setEnabled(true);
/* 3533 */     this.jTextField16.setEnabled(true);
/* 3534 */     this.jTextField17.setEnabled(true);
/* 3535 */     this.jButton28.setText("Guardar");
/* 3536 */     this.jButton28.setToolTipText("Guardar Nómina (Alt + G)");
/* 3537 */     this.jButton28.setMnemonic('G');
/* 3538 */     this.jButton21.setEnabled(true);
/* 3539 */     this.jButton32.setEnabled(true);
/* 3540 */     this.jLabel73.setText("");
/* 3541 */     this.jLabel79.setText("$0.00");
/* 3542 */     this.jLabel78.setText("$0.00");
/* 3543 */     this.jLabel71.setText("$0.00");
/* 3544 */     this.jLabel57.setText("0");
/*      */   }
/*      */   
/*      */   public void bloquear() {
/* 3548 */     this.jDateChooser16.setEnabled(false);
/* 3549 */     this.jDateChooser17.setEnabled(false);
/* 3550 */     this.jSpinner9.setEnabled(false);
/* 3551 */     this.jTextField13.setEnabled(false);
/* 3552 */     this.jTextField14.setEnabled(false);
/* 3553 */     this.jTextField18.setEnabled(false);
/*      */     
/* 3555 */     this.jTextField15.setEnabled(false);
/* 3556 */     this.jTextField16.setEnabled(false);
/* 3557 */     this.jTextField17.setEnabled(false);
/* 3558 */     this.jButton28.setText("Imprimir");
/* 3559 */     this.jButton28.setToolTipText("Imprimir Nómina (Alt + I)");
/* 3560 */     this.jButton28.setMnemonic('I');
/* 3561 */     this.jButton21.setEnabled(false);
/* 3562 */     this.jButton32.setEnabled(false);
/* 3563 */     this.jLabel73.setText("");
/*      */   }
/*      */   public void consultar() {
/* 3566 */     Date fecha1 = this.jDateChooser4.getDate();
/* 3567 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 3569 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3570 */     String cadenaFecha = "";
/* 3571 */     cadenaFecha = formato.format(fecha1);
/* 3572 */     String AÑO = cadenaFecha.substring(0, 4);
/* 3573 */     String MES = cadenaFecha.substring(4, 6);
/* 3574 */     String DIA = cadenaFecha.substring(6, 8);
/* 3575 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + " 00:00:00'";
/*      */     
/* 3577 */     cadenaFecha = formato.format(fecha2);
/* 3578 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3579 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3580 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3581 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 3582 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3625 */     String usuario = "";
/* 3626 */     if (this.jComboBox11.getSelectedIndex() != 0) {
/* 3627 */       usuario = String.valueOf(this.jComboBox11.getSelectedItem());
/*      */     }
/*      */     
/* 3630 */     this.con.consultar("count(num_nomina)", "nominas", "where fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2 + " and folio like '%" + this.jTextField1.getText() + "%' and semana like '%" + this.jTextField2.getText() + "%' and usuario like '%" + usuario + "%' order by num_nomina desc");
/* 3631 */     int totreg = Integer.parseInt(this.con.Campo);
/* 3632 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3702 */     this.con.consultar("count(folio)", "nominas", "where estatus ='<Por Autorizar>' and fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 3703 */     String[] arre = this.con.regresaCol("folio", "nominas", "where estatus ='<Por Autorizar>' and fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2, Integer.parseInt(this.con.Campo));
/* 3704 */     this.celda3.pasarInd3(arre);
/*      */     
/* 3706 */     this.con.consultar("count(folio)", "nominas", "where estatus like '%<Cancelada%' and fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 3707 */     arre = this.con.regresaCol("folio", "nominas", "where estatus like '%<Cancelada%' and fecha_creacion between " + fechaCompleta1 + " and " + fechaCompleta2, Integer.parseInt(this.con.Campo));
/* 3708 */     this.celda3.pasarInd5(arre);
/*      */     
/* 3710 */     this.jTable3.setSelectionMode(0);
/* 3711 */     this.jTable3.setAutoCreateRowSorter(true);
/* 3712 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3729 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 3730 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 3731 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 3732 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 3733 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 3734 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 3735 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 3736 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 3737 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/* 3738 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda3);
/* 3739 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda3);
/* 3740 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda3);
/* 3741 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda3);
/* 3742 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda3);
/* 3743 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3747 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3755 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3761 */         return 30;
/*      */       
/*      */       case 1:
/* 3764 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3766 */           return 29;
/*      */         }
/* 3768 */         return 28;
/*      */     } 
/*      */     
/* 3771 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void Nominas(String usu) {
/* 3776 */     this.USUARIO = usu;
/* 3777 */     this.panel.setViewportView(this);
/*      */ 
/*      */ 
/*      */     
/* 3781 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarMayor() {
/* 3786 */     this.con.consultar("max(num_nomina)", "nominas", "");
/* 3787 */     String mayor = this.con.Campo;
/* 3788 */     int MAYOR = 0;
/*      */     try {
/* 3790 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 3792 */     catch (NumberFormatException e) {
/* 3793 */       MAYOR = 0;
/*      */     } 
/* 3795 */     MAYOR++;
/* 3796 */     if (MAYOR < 10) {
/* 3797 */       this.jTextField12.setText(this.DIRECTIVA[0] + "-0000" + this.DIRECTIVA[0]);
/*      */     }
/* 3799 */     else if (MAYOR < 100) {
/* 3800 */       this.jTextField12.setText(this.DIRECTIVA[0] + "-000" + this.DIRECTIVA[0]);
/*      */     }
/* 3802 */     else if (MAYOR < 1000) {
/* 3803 */       this.jTextField12.setText(this.DIRECTIVA[0] + "-00" + this.DIRECTIVA[0]);
/*      */     }
/* 3805 */     else if (MAYOR < 10000) {
/* 3806 */       this.jTextField12.setText(this.DIRECTIVA[0] + "-0" + this.DIRECTIVA[0]);
/*      */     } else {
/*      */       
/* 3809 */       this.jTextField12.setText(this.DIRECTIVA[0] + "-" + this.DIRECTIVA[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarNumSem() {
/* 3814 */     this.con.consultar("max(semana)", "nominas", "where num_nomina=(select max(num_nomina) from nominas)");
/* 3815 */     String mayor = this.con.Campo;
/* 3816 */     int MAYOR = 0;
/*      */     try {
/* 3818 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 3820 */     catch (NumberFormatException e) {
/* 3821 */       MAYOR = 0;
/*      */     } 
/* 3823 */     MAYOR++;
/* 3824 */     this.jSpinner9.setValue(Integer.valueOf(MAYOR));
/*      */   }
/*      */   
/*      */   public void sacarFechas() {
/* 3828 */     this.encontrado = this.con.consultar("fecha_inicio", "nominas", "where num_nomina=(select max(num_nomina) from nominas)");
/* 3829 */     String[] fechas = this.con.regresaReg("fecha_inicio,fecha_final", "nominas", "where num_nomina=(select max(num_nomina) from nominas)", 2);
/* 3830 */     String FECHA1 = fechas[1];
/* 3831 */     if (this.encontrado) {
/* 3832 */       String año = FECHA1.substring(0, 4);
/* 3833 */       String mes = FECHA1.substring(5, 7);
/* 3834 */       String dia = FECHA1.substring(8, 10);
/* 3835 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3836 */       String strFecha = año + "-" + año + "-" + mes;
/* 3837 */       Date fecha = null;
/*      */       try {
/* 3839 */         fecha = formatoDelTexto.parse(strFecha);
/* 3840 */         this.jDateChooser16.setDate(fecha);
/* 3841 */         Calendar cal1 = this.jDateChooser16.getCalendar();
/* 3842 */         cal1.add(5, 1);
/* 3843 */         this.jDateChooser16.setDate(cal1.getTime());
/* 3844 */         cal1.add(5, 6);
/* 3845 */         this.jDateChooser17.setDate(cal1.getTime());
/*      */       }
/* 3847 */       catch (ParseException ex) {
/* 3848 */         ex.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar1() {
/* 3855 */     String num_ope = this.jTextField9.getText();
/* 3856 */     String tipo = "";
/* 3857 */     String depa = "";
/*      */     
/* 3859 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 3860 */       tipo = "empleado";
/*      */     }
/* 3862 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 3863 */       tipo = "funcionario";
/*      */     } else {
/*      */       
/* 3866 */       tipo = "";
/*      */     } 
/*      */     
/* 3869 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3870 */       depa = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/*      */     
/* 3873 */     this.encontrado = this.con.consultar("count(ap_pat)", "departamentos,Empleados", "where empleados.clave_depa=departamentos.clave_depa and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and actual=0 and clave_emp<>0 order by empleados.ap_pat");
/* 3874 */     int tot = Integer.parseInt(this.con.Campo);
/* 3875 */     this.jLabel20.setText("" + tot);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3893 */     eliminarColumna1(2, 1, "Paterno");
/* 3894 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 3896 */     this.jTable6.setShowVerticalLines(false);
/* 3897 */     this.jScrollPane9.setViewportView(this.jTable6);
/* 3898 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3899 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 3901 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 3902 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 3903 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 3904 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 3905 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(110);
/* 3906 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(110);
/*      */     
/* 3908 */     this.jTable6.getColumnModel().getColumn(6).setPreferredWidth(40);
/* 3909 */     this.jTable6.getColumnModel().getColumn(6).setMaxWidth(40);
/*      */     
/* 3911 */     this.jTable6.getColumnModel().moveColumn(6, 0);
/* 3912 */     this.jTable6.setSelectionMode(0);
/*      */     
/* 3914 */     this.jTable6.setAutoCreateRowSorter(true);
/* 3915 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */ 
/*      */     
/* 3918 */     this.jTable6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 3919 */     this.jTable6.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 3920 */     this.jTable6.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 3924 */     this.con.consultar("count(nombre)", "departamentos", "");
/* 3925 */     String[] datos = this.con.regresaCol("nombre", "departamentos", "order by nombre", Integer.parseInt(this.con.Campo));
/* 3926 */     this.jComboBox6.removeAllItems();
/* 3927 */     this.jComboBox6.addItem("<GENERAL>");
/* 3928 */     for (int i = 0; i < datos.length; i++) {
/* 3929 */       this.jComboBox6.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultar2() {
/* 3935 */     String num_ope = this.jTextField9.getText();
/* 3936 */     String tipo = "";
/*      */     
/* 3938 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 3939 */       tipo = "operador";
/*      */     }
/* 3941 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 3942 */       tipo = "funcionario";
/*      */     } else {
/*      */       
/* 3945 */       tipo = "";
/*      */     } 
/*      */     
/* 3948 */     this.encontrado = this.con.consultar("count(ap_pat)", "operadores", "where num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and tipoTrabajador like '%" + tipo + "%' and actual=0 and num_ope<>0 order by ap_pat");
/* 3949 */     int tot = Integer.parseInt(this.con.Campo);
/* 3950 */     this.jLabel20.setText("" + tot);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3968 */     eliminarColumna1(2, 1, "Paterno");
/* 3969 */     eliminarColumna1(2, 1, "Materno");
/*      */     
/* 3971 */     this.jTable6.setShowVerticalLines(false);
/* 3972 */     this.jScrollPane9.setViewportView(this.jTable6);
/* 3973 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3974 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/* 3975 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
/* 3976 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
/* 3977 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
/* 3978 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
/* 3979 */     this.jTable6.getColumnModel().getColumn(4).setPreferredWidth(40);
/* 3980 */     this.jTable6.getColumnModel().getColumn(4).setMaxWidth(40);
/*      */     
/* 3982 */     this.jTable6.getColumnModel().moveColumn(4, 0);
/*      */     
/* 3984 */     this.jTable6.setSelectionMode(0);
/* 3985 */     this.jTable6.setAutoCreateRowSorter(true);
/* 3986 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void pasarEmpleado1() {
/* 3992 */     for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 3993 */       boolean noEsta = false;
/* 3994 */       int indice = 0;
/* 3995 */       String val = String.valueOf(this.jTable6.getValueAt(i, 0));
/* 3996 */       if (val.equals("true")) {
/* 3997 */         String clave = String.valueOf(this.jTable6.getValueAt(i, 1));
/* 3998 */         clave = sacarClave(clave);
/* 3999 */         for (int j = 0; j < this.jTable7.getRowCount(); j++) {
/* 4000 */           String valor = String.valueOf(this.jTable7.getValueAt(j, 0));
/* 4001 */           if (clave.equals(valor)) {
/* 4002 */             noEsta = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 4006 */         if (!noEsta) {
/* 4007 */           String nombre = String.valueOf(this.jTable6.getValueAt(i, 2));
/*      */           
/* 4009 */           Vector<String> miVector = new Vector<>(); int k;
/* 4010 */           for (k = 0; k < this.jTable7.getRowCount(); k++) {
/* 4011 */             miVector.add(String.valueOf(this.jTable7.getValueAt(k, 2)));
/*      */           }
/* 4013 */           miVector.add(nombre);
/* 4014 */           Collections.sort(miVector);
/*      */           
/* 4016 */           for (k = 0; k < miVector.size(); k++) {
/* 4017 */             if (((String)miVector.get(k)).equals(nombre)) {
/* 4018 */               indice = k;
/*      */               break;
/*      */             } 
/*      */           } 
/* 4022 */           String CLAVE = String.valueOf(this.jTable6.getValueAt(i, 1));
/* 4023 */           String[] datosEmp = this.con.regresaReg("nss,rfc,ultimoIngreso,infonavitLetra", "empleados", "where clave_emp=" + CLAVE, 4);
/* 4024 */           String RFC = datosEmp[1].substring(0, 10);
/*      */           
/* 4026 */           String canti = String.valueOf(this.jTable6.getValueAt(i, 4));
/* 4027 */           String valorP = "";
/* 4028 */           for (int m = 0; m < canti.length(); m++) {
/* 4029 */             if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 4030 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 4033 */           double salarioDiario = Double.parseDouble(valorP);
/* 4034 */           double SDI = salarioDiario * 1.0452D;
/* 4035 */           this.cantidad.setValue(Double.valueOf(SDI));
/*      */           
/* 4037 */           canti = String.valueOf(this.jTable6.getValueAt(i, 5));
/* 4038 */           valorP = "";
/* 4039 */           for (int n = 0; n < canti.length(); n++) {
/* 4040 */             if (canti.charAt(n) != '$' && canti.charAt(n) != ',') {
/* 4041 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 4044 */           double salarioReal = Double.parseDouble(valorP);
/*      */           
/* 4046 */           DefaultTableModel temp = (DefaultTableModel)this.jTable7.getModel();
/*      */ 
/*      */           
/* 4049 */           System.out.println("Datos: " + datosEmp[0] + " " + datosEmp[1] + " " + datosEmp[2] + " " + i);
/* 4050 */           Object[] nuevo = { sacarClave(String.valueOf(this.jTable6.getValueAt(i, 1))), datosEmp[0], this.jTable6.getValueAt(i, 2), datosEmp[1], this.jTable6.getValueAt(i, 6), datosEmp[2], this.jTable6.getValueAt(i, 5), "A", "A", "A", "A", "A", "A", "A", Integer.valueOf(7), "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00", "$0.00" };
/* 4051 */           temp.insertRow(indice, nuevo);
/* 4052 */           this.jTable7.setColumnSelectionAllowed(true);
/* 4053 */           this.jTable7.setSelectionMode(0);
/* 4054 */           calculaTotal(indice);
/* 4055 */           calculaComplemento(indice);
/* 4056 */           totalNeto();
/* 4057 */           totalComplemento();
/* 4058 */           this.jLabel57.setText("" + this.jTable7.getRowCount());
/*      */           
/* 4060 */           int fila = this.jTable7.getSelectedRow();
/* 4061 */           int col = this.jTable7.getSelectedColumn();
/* 4062 */           GregorianCalendar cal = (GregorianCalendar)this.jDateChooser16.getCalendar();
/* 4063 */           int diaL = cal.get(7);
/* 4064 */           String dia = regresaDiaLetra(diaL);
/*      */           
/* 4066 */           JTableHeader th = this.jTable7.getTableHeader();
/* 4067 */           TableColumnModel tcm = th.getColumnModel();
/* 4068 */           TableColumn tc = tcm.getColumn(7);
/* 4069 */           tc.setHeaderValue(dia);
/*      */           
/* 4071 */           cal.add(5, 1);
/* 4072 */           diaL = cal.get(7);
/* 4073 */           dia = regresaDiaLetra(diaL);
/*      */           
/* 4075 */           th = this.jTable7.getTableHeader();
/* 4076 */           tcm = th.getColumnModel();
/* 4077 */           tc = tcm.getColumn(8);
/* 4078 */           tc.setHeaderValue(dia);
/*      */           
/* 4080 */           cal.add(5, 1);
/* 4081 */           diaL = cal.get(7);
/* 4082 */           dia = regresaDiaLetra(diaL);
/* 4083 */           th = this.jTable7.getTableHeader();
/* 4084 */           tcm = th.getColumnModel();
/* 4085 */           tc = tcm.getColumn(9);
/* 4086 */           tc.setHeaderValue(dia);
/*      */           
/* 4088 */           cal.add(5, 1);
/* 4089 */           diaL = cal.get(7);
/* 4090 */           dia = regresaDiaLetra(diaL);
/* 4091 */           th = this.jTable7.getTableHeader();
/* 4092 */           tcm = th.getColumnModel();
/* 4093 */           tc = tcm.getColumn(10);
/* 4094 */           tc.setHeaderValue(dia);
/*      */           
/* 4096 */           cal.add(5, 1);
/* 4097 */           diaL = cal.get(7);
/* 4098 */           dia = regresaDiaLetra(diaL);
/* 4099 */           th = this.jTable7.getTableHeader();
/* 4100 */           tcm = th.getColumnModel();
/* 4101 */           tc = tcm.getColumn(11);
/* 4102 */           tc.setHeaderValue(dia);
/*      */           
/* 4104 */           cal.add(5, 1);
/* 4105 */           diaL = cal.get(7);
/* 4106 */           dia = regresaDiaLetra(diaL);
/* 4107 */           th = this.jTable7.getTableHeader();
/* 4108 */           tcm = th.getColumnModel();
/* 4109 */           tc = tcm.getColumn(12);
/* 4110 */           tc.setHeaderValue(dia);
/*      */           
/* 4112 */           cal.add(5, 1);
/* 4113 */           diaL = cal.get(7);
/* 4114 */           dia = regresaDiaLetra(diaL);
/* 4115 */           th = this.jTable7.getTableHeader();
/* 4116 */           tcm = th.getColumnModel();
/* 4117 */           tc = tcm.getColumn(13);
/* 4118 */           tc.setHeaderValue(dia);
/* 4119 */           th.repaint();
/*      */           
/* 4121 */           this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 4122 */           this.jTable7.getColumnModel().getColumn(0).setMaxWidth(70);
/* 4123 */           this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(85);
/* 4124 */           this.jTable7.getColumnModel().getColumn(1).setMaxWidth(85);
/* 4125 */           this.jTable7.getColumnModel().getColumn(3).setPreferredWidth(160);
/* 4126 */           this.jTable7.getColumnModel().getColumn(3).setMaxWidth(160);
/* 4127 */           this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 4128 */           this.jTable7.getColumnModel().getColumn(5).setMaxWidth(80);
/* 4129 */           this.jTable7.getColumnModel().getColumn(6).setPreferredWidth(75);
/* 4130 */           this.jTable7.getColumnModel().getColumn(6).setMaxWidth(75);
/*      */           
/* 4132 */           this.jTable7.getColumnModel().getColumn(7).setPreferredWidth(35);
/* 4133 */           this.jTable7.getColumnModel().getColumn(7).setMaxWidth(35);
/* 4134 */           this.jTable7.getColumnModel().getColumn(8).setPreferredWidth(35);
/* 4135 */           this.jTable7.getColumnModel().getColumn(8).setMaxWidth(35);
/* 4136 */           this.jTable7.getColumnModel().getColumn(9).setPreferredWidth(35);
/* 4137 */           this.jTable7.getColumnModel().getColumn(9).setMaxWidth(35);
/* 4138 */           this.jTable7.getColumnModel().getColumn(10).setPreferredWidth(35);
/* 4139 */           this.jTable7.getColumnModel().getColumn(10).setMaxWidth(35);
/* 4140 */           this.jTable7.getColumnModel().getColumn(11).setPreferredWidth(35);
/* 4141 */           this.jTable7.getColumnModel().getColumn(11).setMaxWidth(35);
/* 4142 */           this.jTable7.getColumnModel().getColumn(12).setPreferredWidth(35);
/* 4143 */           this.jTable7.getColumnModel().getColumn(12).setMaxWidth(35);
/* 4144 */           this.jTable7.getColumnModel().getColumn(13).setPreferredWidth(35);
/* 4145 */           this.jTable7.getColumnModel().getColumn(13).setMaxWidth(35);
/*      */           
/* 4147 */           this.jTable7.getColumnModel().getColumn(14).setPreferredWidth(65);
/* 4148 */           this.jTable7.getColumnModel().getColumn(14).setMaxWidth(65);
/* 4149 */           this.jTable7.getColumnModel().getColumn(15).setPreferredWidth(80);
/* 4150 */           this.jTable7.getColumnModel().getColumn(15).setMaxWidth(80);
/* 4151 */           this.jTable7.getColumnModel().getColumn(16).setPreferredWidth(60);
/* 4152 */           this.jTable7.getColumnModel().getColumn(16).setMaxWidth(60);
/* 4153 */           this.jTable7.getColumnModel().getColumn(17).setPreferredWidth(90);
/* 4154 */           this.jTable7.getColumnModel().getColumn(17).setMaxWidth(90);
/* 4155 */           this.jTable7.getColumnModel().getColumn(18).setPreferredWidth(80);
/* 4156 */           this.jTable7.getColumnModel().getColumn(18).setMaxWidth(80);
/* 4157 */           this.jTable7.getColumnModel().getColumn(19).setPreferredWidth(60);
/* 4158 */           this.jTable7.getColumnModel().getColumn(19).setMaxWidth(60);
/* 4159 */           this.jTable7.getColumnModel().getColumn(20).setPreferredWidth(70);
/* 4160 */           this.jTable7.getColumnModel().getColumn(20).setMaxWidth(70);
/* 4161 */           this.jTable7.getColumnModel().getColumn(21).setPreferredWidth(75);
/* 4162 */           this.jTable7.getColumnModel().getColumn(21).setMaxWidth(75);
/* 4163 */           this.jTable7.getColumnModel().getColumn(22).setPreferredWidth(60);
/* 4164 */           this.jTable7.getColumnModel().getColumn(22).setMaxWidth(60);
/* 4165 */           this.jTable7.getColumnModel().getColumn(23).setPreferredWidth(80);
/* 4166 */           this.jTable7.getColumnModel().getColumn(23).setMaxWidth(80);
/* 4167 */           this.jTable7.getColumnModel().getColumn(24).setPreferredWidth(60);
/* 4168 */           this.jTable7.getColumnModel().getColumn(24).setMaxWidth(60);
/* 4169 */           this.jTable7.getColumnModel().getColumn(25).setPreferredWidth(80);
/* 4170 */           this.jTable7.getColumnModel().getColumn(25).setMaxWidth(80);
/* 4171 */           this.jTable7.getColumnModel().getColumn(26).setPreferredWidth(70);
/* 4172 */           this.jTable7.getColumnModel().getColumn(26).setMaxWidth(70);
/* 4173 */           this.jTable7.getColumnModel().getColumn(27).setPreferredWidth(90);
/* 4174 */           this.jTable7.getColumnModel().getColumn(27).setMaxWidth(90);
/*      */           
/* 4176 */           this.jTable7.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4177 */           this.jTable7.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4178 */           this.jTable7.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4179 */           this.jTable7.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4180 */           this.jTable7.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4181 */           this.jTable7.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4182 */           this.jTable7.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4183 */           this.jTable7.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 4184 */           this.jTable7.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 4185 */           this.jTable7.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 4186 */           this.jTable7.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 4187 */           this.jTable7.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 4188 */           this.jTable7.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 4189 */           this.jTable7.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 4190 */           this.jTable7.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/* 4191 */           this.jTable7.getColumnModel().getColumn(15).setCellRenderer(this.celda2);
/* 4192 */           this.jTable7.getColumnModel().getColumn(16).setCellRenderer(this.celda2);
/* 4193 */           this.jTable7.getColumnModel().getColumn(17).setCellRenderer(this.celda2);
/* 4194 */           this.jTable7.getColumnModel().getColumn(18).setCellRenderer(this.celda2);
/* 4195 */           this.jTable7.getColumnModel().getColumn(19).setCellRenderer(this.celda2);
/* 4196 */           this.jTable7.getColumnModel().getColumn(20).setCellRenderer(this.celda2);
/* 4197 */           this.jTable7.getColumnModel().getColumn(21).setCellRenderer(this.celda2);
/* 4198 */           this.jTable7.getColumnModel().getColumn(22).setCellRenderer(this.celda2);
/* 4199 */           this.jTable7.getColumnModel().getColumn(23).setCellRenderer(this.celda2);
/* 4200 */           this.jTable7.getColumnModel().getColumn(24).setCellRenderer(this.celda2);
/* 4201 */           this.jTable7.getColumnModel().getColumn(25).setCellRenderer(this.celda2);
/* 4202 */           this.jTable7.getColumnModel().getColumn(26).setCellRenderer(this.celda2);
/* 4203 */           this.jTable7.getColumnModel().getColumn(27).setCellRenderer(this.celda2);
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
/*      */   public void calculaComplemento(int indice) {
/* 4295 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 27));
/* 4296 */     String valorP = "";
/* 4297 */     for (int j = 0; j < canti.length(); j++) {
/* 4298 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4299 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4302 */     double neto = Double.parseDouble(valorP);
/*      */     
/* 4304 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 25));
/* 4305 */     valorP = "";
/* 4306 */     for (int i = 0; i < canti.length(); i++) {
/* 4307 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 4308 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4311 */     double sueldoFiscal = Double.parseDouble(valorP);
/*      */     
/* 4313 */     double total = neto - sueldoFiscal;
/* 4314 */     this.cantidad.setValue(Double.valueOf(total));
/* 4315 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 26);
/*      */   }
/*      */   public void calculaTotal(int indice) {
/* 4318 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 15));
/* 4319 */     String valorP = "";
/* 4320 */     for (int j = 0; j < canti.length(); j++) {
/* 4321 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4322 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4325 */     double horas_extra = Double.parseDouble(valorP);
/*      */     
/* 4327 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 16));
/* 4328 */     valorP = "";
/* 4329 */     for (int i = 0; i < canti.length(); i++) {
/* 4330 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 4331 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4334 */     double dom_lab = Double.parseDouble(valorP);
/*      */     
/* 4336 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 17));
/* 4337 */     valorP = "";
/* 4338 */     for (int k = 0; k < canti.length(); k++) {
/* 4339 */       if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 4340 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4343 */     double gratificaciones = Double.parseDouble(valorP);
/*      */     
/* 4345 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 18));
/* 4346 */     valorP = "";
/* 4347 */     for (int m = 0; m < canti.length(); m++) {
/* 4348 */       if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 4349 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4352 */     double turno_extra = Double.parseDouble(valorP);
/*      */     
/* 4354 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 19));
/* 4355 */     valorP = "";
/* 4356 */     for (int n = 0; n < canti.length(); n++) {
/* 4357 */       if (canti.charAt(n) != '$' && canti.charAt(n) != ',') {
/* 4358 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4361 */     double faltas = Double.parseDouble(valorP);
/*      */     
/* 4363 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 20));
/* 4364 */     valorP = "";
/* 4365 */     for (int i1 = 0; i1 < canti.length(); i1++) {
/* 4366 */       if (canti.charAt(i1) != '$' && canti.charAt(i1) != ',') {
/* 4367 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4370 */     double retardos = Double.parseDouble(valorP);
/*      */     
/* 4372 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 21));
/* 4373 */     valorP = "";
/* 4374 */     for (int i2 = 0; i2 < canti.length(); i2++) {
/* 4375 */       if (canti.charAt(i2) != '$' && canti.charAt(i2) != ',') {
/* 4376 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4379 */     double vacaciones = Double.parseDouble(valorP);
/*      */     
/* 4381 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 22));
/* 4382 */     valorP = "";
/* 4383 */     for (int i3 = 0; i3 < canti.length(); i3++) {
/* 4384 */       if (canti.charAt(i3) != '$' && canti.charAt(i3) != ',') {
/* 4385 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4388 */     double epp = Double.parseDouble(valorP);
/*      */     
/* 4390 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 23));
/* 4391 */     valorP = "";
/* 4392 */     for (int i4 = 0; i4 < canti.length(); i4++) {
/* 4393 */       if (canti.charAt(i4) != '$' && canti.charAt(i4) != ',') {
/* 4394 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4397 */     double prestamos = Double.parseDouble(valorP);
/*      */     
/* 4399 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 24));
/* 4400 */     valorP = "";
/* 4401 */     for (int i5 = 0; i5 < canti.length(); i5++) {
/* 4402 */       if (canti.charAt(i5) != '$' && canti.charAt(i5) != ',') {
/* 4403 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4406 */     double nextel = Double.parseDouble(valorP);
/*      */     
/* 4408 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 6));
/* 4409 */     valorP = "";
/* 4410 */     for (int i6 = 0; i6 < canti.length(); i6++) {
/* 4411 */       if (canti.charAt(i6) != '$' && canti.charAt(i6) != ',') {
/* 4412 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4415 */     double salarioReal = Double.parseDouble(valorP);
/*      */     
/* 4417 */     double total = salarioReal + horas_extra + dom_lab + gratificaciones + turno_extra - faltas + retardos + vacaciones + epp + prestamos + nextel;
/* 4418 */     this.cantidad.setValue(Double.valueOf(total));
/* 4419 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 27);
/*      */   }
/*      */   public String sacarSueldo(int dias, double salario) {
/* 4422 */     double sal = dias * salario;
/* 4423 */     this.cantidad.setValue(Double.valueOf(sal));
/* 4424 */     return this.cantidad.getText();
/*      */   }
/*      */   
/*      */   public String regresaDiaLetra(int diaL) {
/* 4428 */     String dia = "";
/* 4429 */     if (diaL == 1) {
/* 4430 */       dia = "D";
/*      */     }
/* 4432 */     else if (diaL == 2) {
/* 4433 */       dia = "L";
/*      */     }
/* 4435 */     else if (diaL == 3) {
/* 4436 */       dia = "M";
/*      */     }
/* 4438 */     else if (diaL == 4) {
/* 4439 */       dia = "M";
/*      */     }
/* 4441 */     else if (diaL == 5) {
/* 4442 */       dia = "J";
/*      */     }
/* 4444 */     else if (diaL == 6) {
/* 4445 */       dia = "V";
/*      */     }
/* 4447 */     else if (diaL == 7) {
/* 4448 */       dia = "S";
/*      */     } 
/* 4450 */     return dia;
/*      */   }
/*      */   public synchronized void eliminarColumna1(int origen, int destino, String nombreCol) {
/* 4453 */     int cont = this.jTable6.getRowCount();
/* 4454 */     String[] registros = new String[cont]; int i;
/* 4455 */     for (i = 0; i < cont; i++) {
/* 4456 */       registros[i] = this.jTable6.getValueAt(i, destino).toString();
/*      */     }
/* 4458 */     for (i = 0; i < cont; i++) {
/* 4459 */       registros[i] = registros[i] + " " + registros[i];
/* 4460 */       this.jTable6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4462 */     TableColumn columna = this.jTable6.getColumn(nombreCol);
/* 4463 */     this.jTable6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 4467 */     String mayor = clave;
/* 4468 */     int MAYOR = Integer.parseInt(mayor);
/* 4469 */     String clave1 = "";
/* 4470 */     if (MAYOR < 10) {
/* 4471 */       clave1 = "-0000" + MAYOR;
/*      */     }
/* 4473 */     else if (MAYOR < 100) {
/* 4474 */       clave1 = "-000" + MAYOR;
/*      */     }
/* 4476 */     else if (MAYOR < 1000) {
/* 4477 */       clave1 = "-00" + MAYOR;
/*      */     }
/* 4479 */     else if (MAYOR < 10000) {
/* 4480 */       clave1 = "-0" + MAYOR;
/*      */     } else {
/*      */       
/* 4483 */       clave1 = "-" + MAYOR;
/*      */     } 
/* 4485 */     return this.DIRECTIVA[0] + this.DIRECTIVA[0];
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
/*      */   public void sacarPercepNoDeduc(int indice) {
/* 4559 */     double horas_extra2 = 0.0D;
/*      */     
/* 4561 */     double gratificacion = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4573 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 12));
/* 4574 */     String valorP = ""; int j;
/* 4575 */     for (j = 0; j < canti.length(); j++) {
/* 4576 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4577 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4580 */     horas_extra2 = Double.parseDouble(valorP);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4591 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 14));
/* 4592 */     valorP = "";
/* 4593 */     for (j = 0; j < canti.length(); j++) {
/* 4594 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4595 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4598 */     gratificacion = Double.parseDouble(valorP);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4609 */     double sumas = (horas_extra2 + gratificacion) * 0.53D;
/* 4610 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 4611 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPercepDeduc(int indice) {
/* 4616 */     double horas_extra2 = 0.0D;
/*      */     
/* 4618 */     double gratificacion = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4630 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 12));
/* 4631 */     String valorP = ""; int j;
/* 4632 */     for (j = 0; j < canti.length(); j++) {
/* 4633 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4634 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4637 */     horas_extra2 = Double.parseDouble(valorP);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4648 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 14));
/* 4649 */     valorP = "";
/* 4650 */     for (j = 0; j < canti.length(); j++) {
/* 4651 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4652 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4655 */     gratificacion = Double.parseDouble(valorP);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4666 */     double sumas = (horas_extra2 + gratificacion) * 0.47D;
/* 4667 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 4668 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 22);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void percepaGravar(int indice) {
/* 4674 */     double horas_extra3 = 0.0D;
/* 4675 */     double gratificacion = 0.0D;
/*      */ 
/*      */     
/* 4678 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 13));
/* 4679 */     String valorP = ""; int j;
/* 4680 */     for (j = 0; j < canti.length(); j++) {
/* 4681 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4682 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4685 */     horas_extra3 = Double.parseDouble(valorP);
/*      */     
/* 4687 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 14));
/* 4688 */     valorP = "";
/* 4689 */     for (j = 0; j < canti.length(); j++) {
/* 4690 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4691 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4694 */     gratificacion = Double.parseDouble(valorP);
/*      */     
/* 4696 */     double sumas = (horas_extra3 + gratificacion) * 0.47D;
/* 4697 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 4698 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 23);
/*      */   }
/*      */   
/*      */   public void totalaGravar(int indice) {
/* 4702 */     double percepExcentas = 0.0D;
/* 4703 */     double percepGravables = 0.0D;
/*      */     
/* 4705 */     String canti = String.valueOf(this.jTable7.getValueAt(indice, 22));
/* 4706 */     String valorP = ""; int j;
/* 4707 */     for (j = 0; j < canti.length(); j++) {
/* 4708 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4709 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4712 */     percepExcentas = Double.parseDouble(valorP);
/*      */     
/* 4714 */     canti = String.valueOf(this.jTable7.getValueAt(indice, 23));
/* 4715 */     valorP = "";
/* 4716 */     for (j = 0; j < canti.length(); j++) {
/* 4717 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4718 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4721 */     percepGravables = Double.parseDouble(valorP);
/*      */     
/* 4723 */     double sumas = (percepExcentas + percepGravables) * 0.47D;
/* 4724 */     this.cantidad.setValue(Double.valueOf(sumas));
/* 4725 */     this.jTable7.setValueAt(this.cantidad.getText(), indice, 24);
/*      */   }
/*      */   
/*      */   public void verTablas() {
/* 4729 */     this.con.consultar("count(distinct(identificador))", "nominas_tablas", "");
/* 4730 */     String[] tablas = this.con.regresaCol("distinct(identificador)", "nominas_tablas", "", Integer.parseInt(this.con.Campo));
/* 4731 */     this.jList1 = new JList<>(tablas);
/* 4732 */     this.jScrollPane4.setViewportView(this.jList1);
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 4736 */     int quitar = 3 * letras;
/* 4737 */     x -= quitar;
/* 4738 */     return x;
/*      */   }
/*      */   
/*      */   public class CeldaRender extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4743 */       setEnabled((table == null || table.isEnabled()));
/* 4744 */       setHorizontalAlignment(4);
/* 4745 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4746 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4752 */       setEnabled((table == null || table.isEnabled()));
/* 4753 */       if (row % 2 == 0) {
/* 4754 */         if (column == 26 || column == 25) {
/* 4755 */           setBackground(new Color(136, 191, 173));
/* 4756 */           setForeground(Color.black);
/*      */         }
/* 4758 */         else if (column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12 || column == 13) {
/* 4759 */           setBackground(Color.YELLOW);
/* 4760 */           if (value.equals("F")) {
/* 4761 */             setForeground(Color.RED);
/*      */           } else {
/*      */             
/* 4764 */             setForeground(Color.black);
/*      */           } 
/*      */         } else {
/*      */           
/* 4768 */           setBackground(new Color(194, 213, 151));
/* 4769 */           setForeground(Color.black);
/*      */         }
/*      */       
/* 4772 */       } else if (column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12 || column == 13) {
/* 4773 */         setBackground(Color.WHITE);
/* 4774 */         if (value.equals("F")) {
/* 4775 */           setForeground(Color.RED);
/*      */         } else {
/*      */           
/* 4778 */           setForeground(Color.black);
/*      */         } 
/*      */       } else {
/*      */         
/* 4782 */         setForeground(Color.black);
/* 4783 */         setBackground((Color)null);
/*      */       } 
/*      */       
/* 4786 */       if (column == 1 || column == 5 || column == 6 || column == 14 || column == 15 || column == 16 || column == 17 || column == 18 || column == 19 || column == 20 || column == 21 || column == 22 || column == 23 || column == 24 || column == 25 || column == 26 || column == 27) {
/* 4787 */         setHorizontalAlignment(4);
/*      */       }
/* 4789 */       else if (column == 7 || column == 8 || column == 9 || column == 10 || column == 11 || column == 12 || column == 13) {
/* 4790 */         setHorizontalAlignment(0);
/*      */       } else {
/*      */         
/* 4793 */         setHorizontalAlignment(2);
/*      */       } 
/* 4795 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4796 */       return this;
/*      */     } }
/*      */   public class CeldaRender3 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4; String[] indices5;
/*      */     
/*      */     public CeldaRender3() {
/* 4801 */       this.otro = -1;
/* 4802 */       this.indices = new String[0];
/* 4803 */       this.indices2 = new String[0];
/* 4804 */       this.indices3 = new String[0];
/* 4805 */       this.indices4 = new String[0];
/* 4806 */       this.indices5 = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4808 */       setEnabled((table == null || table.isEnabled()));
/* 4809 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4814 */       if (comparar3(comp)) {
/* 4815 */         setBackground(new Color(102, 153, 255));
/* 4816 */         setForeground(Color.BLUE);
/*      */       }
/* 4818 */       else if (comparar5(comp)) {
/* 4819 */         setBackground(Color.RED);
/* 4820 */         setForeground(Color.WHITE);
/*      */       } else {
/*      */         
/* 4823 */         setBackground((Color)null);
/* 4824 */         setForeground(Color.black);
/*      */       } 
/* 4826 */       if (column == 10 || column == 11 || column == 12) {
/* 4827 */         setHorizontalAlignment(4);
/*      */       } else {
/*      */         
/* 4830 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 4833 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4834 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 4837 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 4840 */       this.indices2 = ind;
/*      */     }
/*      */     public void pasarInd3(String[] ind) {
/* 4843 */       this.indices3 = ind;
/*      */     }
/*      */     public void pasarInd4(String[] ind) {
/* 4846 */       this.indices4 = ind;
/*      */     }
/*      */     public void pasarInd5(String[] ind) {
/* 4849 */       this.indices5 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 4852 */       for (int i = 0; i < this.indices.length; i++) {
/* 4853 */         if (this.indices[i].equals(reg)) {
/* 4854 */           return true;
/*      */         }
/*      */       } 
/* 4857 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 4860 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4861 */         if (this.indices2[i].equals(reg)) {
/* 4862 */           return true;
/*      */         }
/*      */       } 
/* 4865 */       return false;
/*      */     }
/*      */     public boolean comparar3(String reg) {
/* 4868 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4869 */         if (this.indices3[i].equals(reg)) {
/* 4870 */           return true;
/*      */         }
/*      */       } 
/* 4873 */       return false;
/*      */     }
/*      */     public boolean comparar4(String reg) {
/* 4876 */       for (int i = 0; i < this.indices4.length; i++) {
/* 4877 */         if (this.indices4[i].equals(reg)) {
/* 4878 */           return true;
/*      */         }
/*      */       } 
/* 4881 */       return false;
/*      */     }
/*      */     public boolean comparar5(String reg) {
/* 4884 */       for (int i = 0; i < this.indices5.length; i++) {
/* 4885 */         if (this.indices5[i].equals(reg)) {
/* 4886 */           return true;
/*      */         }
/*      */       } 
/* 4889 */       return false;
/*      */     } }
/*      */   public class ImprimirNomina implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirNomina() {
/* 4897 */       this.g2 = null;
/* 4898 */       this.Pag = 0;
/*      */       
/* 4900 */       this.linesPerPage = 50;
/* 4901 */       this.orientacion = 0;
/* 4902 */       this.X = 0.0D;
/* 4903 */       this.Y = 0.0D;
/* 4904 */       this.YINICIA = 100;
/* 4905 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 4906 */       this.NumLineas = 0;
/* 4907 */       this.numBreaks = 0;
/*      */     } private void initTextLines() {
/* 4909 */       if (this.textLines == null) {
/* 4910 */         int numLines = NominasComplementos.this.jTable7.getRowCount();
/* 4911 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     public void pintar(int x, int y) {
/* 4915 */       this.g2.setColor(Color.WHITE);
/* 4916 */       this.g2.fillRect(x - 2, y - 6, 50, 12);
/* 4917 */       this.g2.setColor(Color.BLACK);
/*      */     }
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4920 */       Font font = new Font("Serif", 0, 8);
/* 4921 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4922 */       int lineHeight = metrics.getHeight();
/* 4923 */       if (this.pageBreaks == null) {
/* 4924 */         initTextLines();
/* 4925 */         this.orientacion = pf.getOrientation();
/* 4926 */         if (pf.getOrientation() == 1) {
/* 4927 */           this.linesPerPage = 53;
/* 4928 */           this.X = pf.getWidth();
/* 4929 */           this.Y = pf.getHeight();
/*      */         } else {
/*      */           
/* 4932 */           this.linesPerPage = 38;
/* 4933 */           this.X = pf.getWidth();
/* 4934 */           this.Y = pf.getHeight();
/*      */         } 
/* 4936 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4937 */         this.Pag = this.numBreaks;
/* 4938 */         this.pageBreaks = new int[this.numBreaks];
/* 4939 */         for (int b = 0; b < this.numBreaks; b++) {
/* 4940 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4943 */       if (pageIndex > this.pageBreaks.length) {
/* 4944 */         return 1;
/*      */       }
/* 4946 */       Graphics2D g2d = (Graphics2D)g;
/* 4947 */       this.g2 = g;
/* 4948 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4949 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4950 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4951 */       encabezado();
/* 4952 */       int y = this.YINICIA;
/* 4953 */       int lineas = 0;
/*      */       
/* 4955 */       Date fecha1 = new Date();
/* 4956 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4957 */       String cadenaFecha = "";
/* 4958 */       cadenaFecha = formato.format(fecha1);
/* 4959 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4960 */       String MES = cadenaFecha.substring(4, 6);
/* 4961 */       String DIA = cadenaFecha.substring(6, 8);
/* 4962 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*      */       
/* 4964 */       this.g2.setColor(Color.ORANGE);
/* 4965 */       this.g2.fillRect(25, 81, 730, 10);
/* 4966 */       this.g2.setColor(new Color(204, 0, 0));
/* 4967 */       this.g2.fillRect(25, 92, 730, 20);
/* 4968 */       this.g2.setColor(Color.BLACK);
/* 4969 */       this.g2.drawRect(25, 80, 730, 12);
/* 4970 */       this.g2.drawRect(25, 91, 730, 22);
/* 4971 */       this.g2.drawString("SUCURSAL: " + NominasComplementos.this.DIRECTIVA[1], 27, 89);
/* 4972 */       this.g2.drawString("EMPLEADOS: " + NominasComplementos.this.jTable7.getRowCount(), 360, 89);
/* 4973 */       this.g2.drawString("FECHA DE IMPRESIÓN: " + fechaCompleta1, 630, 89);
/*      */       
/* 4975 */       Font fuente = new Font("Dialog", 0, 7);
/* 4976 */       this.g2.setFont(fuente);
/* 4977 */       this.g2.setColor(Color.WHITE);
/* 4978 */       int[] valores = { 29, 65, 110, 245, 320, 365, 375, 385, 395, 405, 415, 425, 440, 465, 515, 563, 611, 659, 707, 755 };
/* 4979 */       this.g2.drawString("CLAVE", valores[0], 104);
/* 4980 */       this.g2.drawString("NSS", valores[1], 104);
/* 4981 */       this.g2.drawString("NOMBRE COMPLETO", valores[2], 104);
/* 4982 */       this.g2.drawString("DEPARTAMENTO", valores[3], 104);
/* 4983 */       this.g2.drawString("FECHA DE", valores[4] - 1, 100);
/* 4984 */       this.g2.drawString("INGRESO", valores[4], 109);
/* 4985 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(7), valores[5], 104);
/* 4986 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(8), valores[6], 104);
/* 4987 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(9), valores[7], 104);
/* 4988 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(10), valores[8], 104);
/* 4989 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(11), valores[9], 104);
/* 4990 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(12), valores[10], 104);
/* 4991 */       this.g2.drawString(NominasComplementos.this.jTable7.getColumnName(13), valores[11], 104);
/* 4992 */       this.g2.drawString("DÍAS", valores[12], 100);
/* 4993 */       this.g2.drawString(" LAB", valores[12], 109);
/* 4994 */       this.g2.drawString("SALARIO", valores[13], 100);
/* 4995 */       this.g2.drawString("   REAL", valores[13], 109);
/* 4996 */       this.g2.drawString("+ GRATIF.", valores[14], 104);
/* 4997 */       this.g2.drawString("- DESC.", valores[15], 104);
/* 4998 */       this.g2.drawString("SUELDO", valores[16], 100);
/* 4999 */       this.g2.drawString(" FISCAL", valores[16], 109);
/* 5000 */       this.g2.drawString("TOTAL", valores[17], 100);
/* 5001 */       this.g2.drawString("COMP.", valores[17], 109);
/* 5002 */       this.g2.drawString("  NETO", valores[18], 100);
/* 5003 */       this.g2.drawString("PAGADO", valores[18], 109);
/* 5004 */       this.g2.setColor(Color.BLACK);
/* 5005 */       y = 110;
/* 5006 */       for (int line = start; line < end; line++) {
/* 5007 */         y += 12;
/*      */         
/* 5009 */         String valor = "";
/* 5010 */         if (line < 9) {
/* 5011 */           valor = "0" + line + 1;
/*      */         } else {
/*      */           
/* 5014 */           valor = "" + line + 1;
/*      */         } 
/* 5016 */         fuente = new Font("Dialog", 1, 7);
/* 5017 */         this.g2.setFont(fuente);
/* 5018 */         this.g2.drawString(valor, NominasComplementos.this.alinearDer(20, valor.length()), y - 2);
/*      */         
/* 5020 */         fuente = new Font("Dialog", 0, 6);
/* 5021 */         this.g2.setFont(fuente);
/*      */         
/* 5023 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 0)), valores[0], y - 2);
/* 5024 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 1)), valores[1], y - 2);
/* 5025 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 2)), valores[2], y - 2); pintar(valores[3], y - 2);
/* 5026 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 4)), valores[3], y - 2); pintar(valores[4], y - 2);
/* 5027 */         String fecha = String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 5));
/* 5028 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 5029 */         this.g2.drawString(col, valores[4], y - 2); pintar(valores[5], y - 2);
/* 5030 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 7)), valores[5], y - 2);
/* 5031 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 8)), valores[6], y - 2);
/* 5032 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 9)), valores[7], y - 2);
/* 5033 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 10)), valores[8], y - 2);
/* 5034 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 11)), valores[9], y - 2);
/* 5035 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 12)), valores[10], y - 2);
/* 5036 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 13)), valores[11], y - 2);
/* 5037 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 14)), valores[12] + 3, y - 2);
/* 5038 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 6)), NominasComplementos.this.alinearDer(valores[13], NominasComplementos.this.jTable7.getValueAt(line, 6).toString().length()) + 30, y - 2);
/* 5039 */         NominasComplementos.this.cantidad.setValue(Double.valueOf(NominasComplementos.this.gratificacionesIndividualTotal[line]));
/* 5040 */         this.g2.drawString(NominasComplementos.this.cantidad.getText(), NominasComplementos.this.alinearDer(valores[14], NominasComplementos.this.cantidad.getText().length()) + 30, y - 2);
/* 5041 */         NominasComplementos.this.cantidad.setValue(Double.valueOf(NominasComplementos.this.descuentosIndividualTotal[line]));
/* 5042 */         this.g2.drawString(NominasComplementos.this.cantidad.getText(), NominasComplementos.this.alinearDer(valores[15], NominasComplementos.this.cantidad.getText().length()) + 30, y - 2);
/* 5043 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 25)), NominasComplementos.this.alinearDer(valores[16], NominasComplementos.this.jTable7.getValueAt(line, 25).toString().length()) + 30, y - 2);
/* 5044 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 26)), NominasComplementos.this.alinearDer(valores[17], NominasComplementos.this.jTable7.getValueAt(line, 26).toString().length()) + 30, y - 2);
/* 5045 */         this.g2.drawString(String.valueOf(NominasComplementos.this.jTable7.getValueAt(line, 27)), NominasComplementos.this.alinearDer(valores[18], NominasComplementos.this.jTable7.getValueAt(line, 27).toString().length()) + 30, y - 2);
/*      */       } 
/*      */       
/* 5048 */       g.drawString("Página " + pageIndex + 1, 15, 580);
/* 5049 */       if (this.Pag == pageIndex) {
/* 5050 */         this.g2.drawLine(30, y + 2, 745, y + 2);
/*      */         
/* 5052 */         this.g2.drawLine(30, y + 15, 745, y + 15);
/* 5053 */         this.g2.drawLine(30, y + 16, 745, y + 16);
/* 5054 */         this.g2.drawLine(30, y + 17, 745, y + 17);
/*      */         
/* 5056 */         fuente = new Font("Dialog", 1, 7);
/* 5057 */         this.g2.setFont(fuente);
/*      */         
/* 5059 */         fuente = new Font("Dialog", 1, 7);
/* 5060 */         this.g2.setFont(fuente);
/* 5061 */         this.g2.drawString("**T O T A L E S**", 290, y + 11);
/*      */         
/* 5063 */         NominasComplementos.this.cantidad.setValue(Double.valueOf(NominasComplementos.this.salarioRealTotal));
/* 5064 */         this.g2.drawString(NominasComplementos.this.cantidad.getText(), NominasComplementos.this.alinearDer(valores[13], NominasComplementos.this.cantidad.getText().length()) + 25, y + 11);
/* 5065 */         NominasComplementos.this.cantidad.setValue(Double.valueOf(NominasComplementos.this.gratificacionesTotal));
/* 5066 */         this.g2.drawString(NominasComplementos.this.cantidad.getText(), NominasComplementos.this.alinearDer(valores[14], NominasComplementos.this.cantidad.getText().length()) + 25, y + 11);
/* 5067 */         NominasComplementos.this.cantidad.setValue(Double.valueOf(NominasComplementos.this.descuentosTotal));
/* 5068 */         this.g2.drawString(NominasComplementos.this.cantidad.getText(), NominasComplementos.this.alinearDer(valores[15], NominasComplementos.this.cantidad.getText().length()) + 25, y + 11);
/* 5069 */         this.g2.drawString(NominasComplementos.this.jLabel79.getText(), NominasComplementos.this.alinearDer(valores[16], NominasComplementos.this.jLabel79.getText().length()) + 25, y + 11);
/* 5070 */         this.g2.drawString(NominasComplementos.this.jLabel78.getText(), NominasComplementos.this.alinearDer(valores[17], NominasComplementos.this.jLabel78.getText().length()) + 25, y + 11);
/* 5071 */         this.g2.drawString(NominasComplementos.this.jLabel71.getText(), NominasComplementos.this.alinearDer(valores[18], NominasComplementos.this.jLabel71.getText().length()) + 25, y + 11);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5077 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5081 */       Font fuente = new Font("Dialog", 0, 8);
/* 5082 */       this.g2.setFont(fuente);
/* 5083 */       this.g2.setColor(Color.BLACK);
/* 5084 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5085 */       Image img = imagen.getImage();
/* 5086 */       this.g2.drawImage(img, 700, 15, 40, 40, null);
/*      */       
/* 5088 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 5089 */       img = imagen.getImage();
/* 5090 */       this.g2.drawImage(img, 15, 15, 40, 30, null);
/*      */       
/* 5092 */       fuente = new Font("Times New Roman", 0, 9);
/* 5093 */       this.g2.setFont(fuente);
/* 5094 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 65, 20);
/* 5095 */       this.g2.drawString("AUTOPISTA CADEREYTA-MONTERREY KM. 32.5", 65, 30);
/* 5096 */       this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 65, 40);
/* 5097 */       this.g2.drawString("C.P. 67450", 65, 50);
/*      */       
/* 5099 */       this.g2.drawString("BANCO: " + NominasComplementos.this.jTextField15.getText().toUpperCase(), 300, 20);
/* 5100 */       this.g2.drawString("DESC: " + NominasComplementos.this.jTextField16.getText().toUpperCase(), 300, 36);
/* 5101 */       this.g2.drawString("RIESGO: " + NominasComplementos.this.jTextField17.getText().toUpperCase(), 300, 51);
/*      */       
/* 5103 */       fuente = new Font("Times New Roman", 1, 11);
/* 5104 */       this.g2.setFont(fuente);
/* 5105 */       this.g2.drawString("NÓMINA DEL ", 480, 20);
/* 5106 */       fuente = new Font("Times New Roman", 0, 9);
/* 5107 */       this.g2.setFont(fuente);
/* 5108 */       this.g2.drawString("COMPLEMENTO DE NÓMINA SEM: " + String.valueOf(NominasComplementos.this.jSpinner9.getValue()), 480, 36);
/* 5109 */       this.g2.drawString("CHEQUE: " + NominasComplementos.this.jTextField18.getText().toUpperCase(), 480, 51);
/*      */       
/* 5111 */       Date fecha1 = NominasComplementos.this.jDateChooser16.getDate();
/* 5112 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5113 */       String cadenaFecha = "";
/* 5114 */       cadenaFecha = formato.format(fecha1);
/* 5115 */       String AÑO = cadenaFecha.substring(0, 4);
/* 5116 */       String MES = cadenaFecha.substring(4, 6);
/* 5117 */       String DIA = cadenaFecha.substring(6, 8);
/* 5118 */       String fechaStr = DIA + "/" + DIA + "/" + MES;
/*      */       
/* 5120 */       fecha1 = NominasComplementos.this.jDateChooser17.getDate();
/* 5121 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 5122 */       cadenaFecha = "";
/* 5123 */       cadenaFecha = formato.format(fecha1);
/* 5124 */       AÑO = cadenaFecha.substring(0, 4);
/* 5125 */       MES = cadenaFecha.substring(4, 6);
/* 5126 */       DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 5128 */       fuente = new Font("Times New Roman", 1, 11);
/* 5129 */       this.g2.setFont(fuente);
/* 5130 */       fechaStr = fechaStr + " AL " + fechaStr + "/" + DIA + "/" + MES;
/* 5131 */       this.g2.drawString(fechaStr, 555, 20);
/*      */       
/* 5133 */       this.g2.setColor(Color.RED);
/* 5134 */       this.g2.fillRect(63, 57, 619, 7);
/*      */       
/* 5136 */       this.g2.drawRect(62, 8, 620, 57);
/* 5137 */       this.g2.drawLine(297, 8, 297, 64);
/* 5138 */       this.g2.drawLine(477, 8, 477, 64);
/*      */       
/* 5140 */       this.g2.drawLine(297, 27, 681, 27);
/* 5141 */       this.g2.drawLine(297, 41, 681, 41);
/* 5142 */       this.g2.drawLine(297, 57, 681, 57);
/*      */       
/* 5144 */       this.g2.setColor(Color.BLACK);
/* 5145 */       fuente = new Font("Times New Roman", 1, 7);
/* 5146 */       this.g2.setFont(fuente);
/* 5147 */       this.g2.drawString("DATOS GENERALES", 147, 63);
/* 5148 */       this.g2.drawString("ACUERDO", 367, 63);
/* 5149 */       this.g2.drawString("DATOS NOMINALES", 545, 63);
/*      */     }
/*      */     public void recibeDatos() {
/* 5152 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5153 */       job.setPrintable(this);
/*      */       
/* 5155 */       PageFormat pf = job.defaultPage();
/* 5156 */       Paper papel = pf.getPaper();
/* 5157 */       papel.setSize(612.0D, 792.0D);
/* 5158 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5159 */       pf.setPaper(papel);
/* 5160 */       pf.setOrientation(0);
/* 5161 */       job.setPrintable(new ImprimirNomina(), pf);
/* 5162 */       job.defaultPage(pf);
/*      */       
/* 5164 */       boolean ok = job.printDialog();
/* 5165 */       if (ok)
/*      */         try {
/* 5167 */           job.print();
/*      */         }
/* 5169 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/NominasComplementos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */