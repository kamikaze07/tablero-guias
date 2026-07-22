/*      */ package sicret;
/*      */ 
/*      */ import Fuentes.Fuentes;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.Point;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.net.URL;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import net.sf.jasperreports.engine.JRDataSource;
/*      */ import net.sf.jasperreports.engine.JREmptyDataSource;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ProvCuentasBancarias
/*      */   extends JPanel
/*      */ {
/*      */   JScrollPane panel;
/*   76 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*   78 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*   80 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*   82 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*   84 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*   86 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*   88 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*   90 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*   92 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*   94 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*   96 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*   98 */   JFrame padre = null;
/*      */   
/*  100 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  104 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  108 */   SColores lc = new SColores();
/*      */   
/*  110 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  112 */   PlaceHolder placeHolder = null;
/*      */   
/*  114 */   Consultas2 con = new Consultas2();
/*      */   
/*  116 */   String holderBanco = "BANCO, Ej: Banamex";
/*      */   
/*  118 */   String holderSucursal = "SUCURSAL DE LA CUENTA, Ej, Cadereyta";
/*      */   
/*  120 */   String holderCuenta = "CUENTA, Ej, 0040";
/*      */   
/*  122 */   private MaskFormatter formaTel = null;
/*      */   
/*      */   boolean entraCatMon = false;
/*      */   
/*  126 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*  128 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  130 */   ArrayList TODOS_SUCURSALES = new ArrayList();
/*      */   
/*  132 */   TextAutoCompleter com_Sucursales = null;
/*      */   
/*  134 */   Validaciones val = new Validaciones();
/*      */   
/*  136 */   Errores error = new Errores(false);
/*      */   
/*  138 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*  142 */   Cursor micursor = null;
/*      */   
/*  144 */   Presionado presionado = null;
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*  148 */   String ACTIVARSUC = "";
/*      */   
/*  150 */   String[] SUCURSALES = null;
/*      */   
/*      */   boolean PRIMERA = false;
/*      */   
/*      */   private JButton jButton10;
/*      */   
/*      */   private JButton jButton11;
/*      */   
/*      */   private JButton jButton12;
/*      */   
/*      */   private JButton jButton13;
/*      */   
/*      */   private JButton jButton14;
/*      */   
/*      */   private JButton jButton2;
/*      */   
/*      */   private JButton jButton55;
/*      */   
/*      */   private JButton jButton56;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox jComboBox2;
/*      */   
/*      */   private JDialog jDialog1;
/*      */   
/*      */   private JDialog jDialog2;
/*      */   
/*      */   private JDialog jDialog3;
/*      */   
/*      */   private JFormattedTextField jFormattedTextField1;
/*      */   
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private JLabel jLabel10;
/*      */   
/*      */   private JLabel jLabel11;
/*      */   
/*      */   private JLabel jLabel12;
/*      */   
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private JLabel jLabel14;
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/*      */   private JLabel jLabel3;
/*      */   
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private JLabel jLabel48;
/*      */   
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private JLabel jLabel55;
/*      */   
/*      */   private JLabel jLabel58;
/*      */   
/*      */   private JLabel jLabel6;
/*      */   
/*      */   private JLabel jLabel7;
/*      */   
/*      */   private JLabel jLabel8;
/*      */   
/*      */   private JLabel jLabel9;
/*      */   
/*      */   private JPanel jPanel1;
/*      */   
/*      */   private JPanel jPanel10;
/*      */   
/*      */   private JPanel jPanel108;
/*      */   
/*      */   private JPanel jPanel133;
/*      */   
/*      */   private JPanel jPanel134;
/*      */   
/*      */   private JPanel jPanel135;
/*      */   
/*      */   private JPanel jPanel136;
/*      */   
/*      */   private JPanel jPanel17;
/*      */   
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private JPanel jPanel47;
/*      */   
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private JPanel jPanel8;
/*      */   
/*      */   private JScrollPane jScrollPane1;
/*      */   
/*      */   private JScrollPane jScrollPane13;
/*      */   
/*      */   private JScrollPane jScrollPane31;
/*      */   
/*      */   private JScrollPane jScrollPane32;
/*      */   
/*      */   private JSeparator jSeparator1;
/*      */   
/*      */   private JSeparator jSeparator2;
/*      */   
/*      */   private JTextArea jTextArea1;
/*      */   
/*      */   private JTextField jTextField1;
/*      */   
/*      */   private JTextField jTextField10;
/*      */   
/*      */   private JTextField jTextField11;
/*      */   
/*      */   private JTextField jTextField12;
/*      */   
/*      */   private JTextField jTextField13;
/*      */   
/*      */   private JTextField jTextField2;
/*      */   
/*      */   private JTextField jTextField3;
/*      */   
/*      */   private JTextField jTextField4;
/*      */   
/*      */   private JTextField jTextField5;
/*      */   
/*      */   private JTextField jTextField6;
/*      */   
/*      */   private JTextField jTextField7;
/*      */   
/*      */   private JTextField jTextField8;
/*      */   
/*      */   private JTextField jTextField85;
/*      */   
/*      */   private JTextField jTextField86;
/*      */   
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private MaterialButton materialButton19;
/*      */   
/*      */   private MaterialButton materialButton20;
/*      */   
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   public ProvCuentasBancarias(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES) {
/*  299 */     this.EtiquetaEstado = EtiquetaEstado;
/*  300 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  301 */     this.mensajeTry = mensajeTry;
/*  302 */     this.padre = padre;
/*  303 */     this.fichas = fichas;
/*  304 */     this.USUARIO = USUARIO;
/*  305 */     this.panel = panelito;
/*  306 */     this.con.setBaseDatos("sicre2PR");
/*  307 */     this.con.cambiarServidor();
/*      */     try {
/*  309 */       this.formaTel = new MaskFormatter("###-###-####");
/*  310 */     } catch (Exception exception) {}
/*      */     
/*  312 */     this.formaTel.setPlaceholderCharacter('_');
/*  313 */     this.panel.setViewportView(this);
/*  314 */     initComponents();
/*  315 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderBanco, false, "Century Gothic", 11);
/*  316 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderSucursal, false, "Century Gothic", 11);
/*  317 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCuenta, false, "Century Gothic", 11);
/*  318 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  319 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  320 */     this.jDialog1.setCursor(micursor);
/*  321 */     this.jDialog2.setCursor(micursor);
/*  322 */     this.jDialog3.setCursor(micursor);
/*  323 */     this.rSTableMetro1.setCursor(micursor);
/*  324 */     this.rSTableMetro2.setCursor(micursor);
/*  325 */     this.rSTableMetro3.setCursor(micursor);
/*  326 */     int w = this.tama.width;
/*  327 */     int h = this.tama.height;
/*  328 */     int rw = (w - 750) / 2;
/*  329 */     int rh = (h - 470) / 2;
/*  330 */     this.jDialog1.setLocation(rw, rh);
/*  331 */     this.jDialog1.setSize(750, 470);
/*  332 */     this.jDialog1.setResizable(false);
/*  333 */     rw = (w - 650) / 2;
/*  334 */     rh = (h - 280) / 2;
/*  335 */     this.jDialog2.setLocation(rw, rh);
/*  336 */     this.jDialog2.setSize(650, 280);
/*  337 */     this.jDialog2.setResizable(false);
/*  338 */     rw = (w - 450) / 2;
/*  339 */     rh = (h - 200) / 2;
/*  340 */     this.jDialog3.setLocation(rw, rh);
/*  341 */     this.jDialog3.setSize(380, 160);
/*  342 */     this.jDialog3.setResizable(false);
/*  343 */     llenarCombo();
/*  344 */     llenarSucursales();
/*  345 */     privilegios();
/*  346 */     consultar();
/*  347 */     colorear();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  351 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  352 */     this.jPanel1 = new JPanel();
/*  353 */     this.jLabel1 = new JLabel();
/*  354 */     this.jTextField4 = new JTextField();
/*  355 */     this.jLabel2 = new JLabel();
/*  356 */     this.jTextField5 = new JTextField();
/*  357 */     this.jLabel3 = new JLabel();
/*  358 */     this.jTextField6 = new JTextField();
/*  359 */     this.jLabel4 = new JLabel();
/*  360 */     this.jTextField7 = new JTextField();
/*  361 */     this.jLabel5 = new JLabel();
/*  362 */     this.jTextField8 = new JTextField();
/*  363 */     this.jLabel6 = new JLabel();
/*  364 */     this.jTextField9 = new JTextField();
/*  365 */     this.jLabel7 = new JLabel();
/*  366 */     this.jTextField10 = new JTextField();
/*  367 */     this.jLabel8 = new JLabel();
/*  368 */     this.jPanel133 = new JPanel();
/*  369 */     this.jTextField85 = new JTextField();
/*  370 */     this.jButton55 = new JButton();
/*  371 */     this.jLabel9 = new JLabel();
/*  372 */     this.jTextField11 = new JTextField();
/*  373 */     this.jLabel10 = new JLabel();
/*  374 */     this.jTextField12 = new JTextField();
/*  375 */     this.jLabel11 = new JLabel();
/*  376 */     this.jFormattedTextField1 = new JFormattedTextField(this.formaTel);
/*  377 */     this.jSeparator1 = new JSeparator();
/*  378 */     this.jSeparator2 = new JSeparator();
/*  379 */     this.jLabel12 = new JLabel();
/*  380 */     this.jScrollPane1 = new JScrollPane();
/*  381 */     this.jTextArea1 = new JTextArea();
/*  382 */     this.jLabel14 = new JLabel();
/*  383 */     this.jPanel136 = new JPanel();
/*  384 */     this.jTextField86 = new JTextField();
/*  385 */     this.jButton56 = new JButton();
/*  386 */     this.jLabel13 = new JLabel();
/*  387 */     this.jTextField13 = new JTextField();
/*  388 */     this.jPanel108 = new JPanel();
/*  389 */     this.materialButton19 = new MaterialButton();
/*  390 */     this.materialButton20 = new MaterialButton();
/*  391 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  392 */     this.jPanel134 = new JPanel();
/*  393 */     this.jScrollPane31 = new JScrollPane();
/*  394 */     this.rSTableMetro3 = new RSTableMetro();
/*  395 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  396 */     this.jPanel135 = new JPanel();
/*  397 */     this.jScrollPane32 = new JScrollPane();
/*  398 */     this.rSTableMetro2 = new RSTableMetro();
/*  399 */     this.jPanel2 = new JPanel();
/*  400 */     this.jPanel8 = new JPanel();
/*  401 */     this.jLabel55 = new JLabel();
/*  402 */     this.jPanel17 = new JPanel();
/*  403 */     this.jTextField1 = new JTextField();
/*  404 */     this.jTextField2 = new JTextField();
/*  405 */     this.jTextField3 = new JTextField();
/*  406 */     this.jComboBox2 = new JComboBox();
/*  407 */     this.jComboBox1 = new JComboBox();
/*  408 */     this.jPanel10 = new JPanel();
/*  409 */     this.jScrollPane13 = new JScrollPane();
/*  410 */     this.rSTableMetro1 = new RSTableMetro();
/*  411 */     this.jPanel3 = new JPanel();
/*  412 */     this.jPanel47 = new JPanel();
/*  413 */     this.jLabel58 = new JLabel();
/*  414 */     this.jLabel48 = new JLabel();
/*  415 */     this.jPanel4 = new JPanel();
/*  416 */     this.jPanel5 = new JPanel();
/*  417 */     this.jButton2 = new JButton();
/*  418 */     this.jButton10 = new JButton();
/*  419 */     this.jButton11 = new JButton();
/*  420 */     this.jButton12 = new JButton();
/*  421 */     this.jButton13 = new JButton();
/*  422 */     this.jButton14 = new JButton();
/*  423 */     this.jDialog1.setTitle("Crear nueva cuenta");
/*  424 */     GridBagLayout jPanel1Layout = new GridBagLayout();
/*  425 */     jPanel1Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*      */ 
/*      */     
/*  428 */     jPanel1Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*      */ 
/*      */ 
/*      */     
/*  432 */     this.jPanel1.setLayout(jPanel1Layout);
/*  433 */     this.jLabel1.setText("Nombre completo del banco");
/*  434 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  435 */     gridBagConstraints.gridx = 2;
/*  436 */     gridBagConstraints.gridy = 2;
/*  437 */     gridBagConstraints.anchor = 21;
/*  438 */     this.jPanel1.add(this.jLabel1, gridBagConstraints);
/*  439 */     gridBagConstraints = new GridBagConstraints();
/*  440 */     gridBagConstraints.gridx = 4;
/*  441 */     gridBagConstraints.gridy = 2;
/*  442 */     gridBagConstraints.fill = 2;
/*  443 */     gridBagConstraints.weightx = 1.0D;
/*  444 */     this.jPanel1.add(this.jTextField4, gridBagConstraints);
/*  445 */     this.jLabel2.setText("Nombre corto del banco");
/*  446 */     gridBagConstraints = new GridBagConstraints();
/*  447 */     gridBagConstraints.gridx = 6;
/*  448 */     gridBagConstraints.gridy = 2;
/*  449 */     gridBagConstraints.fill = 2;
/*  450 */     gridBagConstraints.anchor = 21;
/*  451 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  452 */     this.jPanel1.add(this.jLabel2, gridBagConstraints);
/*  453 */     gridBagConstraints = new GridBagConstraints();
/*  454 */     gridBagConstraints.gridx = 8;
/*  455 */     gridBagConstraints.gridy = 2;
/*  456 */     gridBagConstraints.fill = 2;
/*  457 */     gridBagConstraints.weightx = 1.0D;
/*  458 */     this.jPanel1.add(this.jTextField5, gridBagConstraints);
/*  459 */     this.jLabel3.setText("Número de la Sucursal");
/*  460 */     gridBagConstraints = new GridBagConstraints();
/*  461 */     gridBagConstraints.gridx = 2;
/*  462 */     gridBagConstraints.gridy = 6;
/*  463 */     gridBagConstraints.anchor = 21;
/*  464 */     this.jPanel1.add(this.jLabel3, gridBagConstraints);
/*  465 */     gridBagConstraints = new GridBagConstraints();
/*  466 */     gridBagConstraints.gridx = 4;
/*  467 */     gridBagConstraints.gridy = 6;
/*  468 */     gridBagConstraints.fill = 2;
/*  469 */     gridBagConstraints.weightx = 1.0D;
/*  470 */     this.jPanel1.add(this.jTextField6, gridBagConstraints);
/*  471 */     this.jLabel4.setText("Ciudad de la sucursal");
/*  472 */     gridBagConstraints = new GridBagConstraints();
/*  473 */     gridBagConstraints.gridx = 6;
/*  474 */     gridBagConstraints.gridy = 6;
/*  475 */     gridBagConstraints.fill = 2;
/*  476 */     gridBagConstraints.anchor = 21;
/*  477 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  478 */     this.jPanel1.add(this.jLabel4, gridBagConstraints);
/*  479 */     gridBagConstraints = new GridBagConstraints();
/*  480 */     gridBagConstraints.gridx = 8;
/*  481 */     gridBagConstraints.gridy = 6;
/*  482 */     gridBagConstraints.fill = 2;
/*  483 */     gridBagConstraints.weightx = 1.0D;
/*  484 */     this.jPanel1.add(this.jTextField7, gridBagConstraints);
/*  485 */     this.jLabel5.setText("Núm. completo de la cuenta");
/*  486 */     gridBagConstraints = new GridBagConstraints();
/*  487 */     gridBagConstraints.gridx = 2;
/*  488 */     gridBagConstraints.gridy = 10;
/*  489 */     gridBagConstraints.anchor = 21;
/*  490 */     this.jPanel1.add(this.jLabel5, gridBagConstraints);
/*  491 */     gridBagConstraints = new GridBagConstraints();
/*  492 */     gridBagConstraints.gridx = 4;
/*  493 */     gridBagConstraints.gridy = 10;
/*  494 */     gridBagConstraints.fill = 2;
/*  495 */     gridBagConstraints.weightx = 1.0D;
/*  496 */     this.jPanel1.add(this.jTextField8, gridBagConstraints);
/*  497 */     this.jLabel6.setText("Clabe");
/*  498 */     gridBagConstraints = new GridBagConstraints();
/*  499 */     gridBagConstraints.gridx = 2;
/*  500 */     gridBagConstraints.gridy = 8;
/*  501 */     gridBagConstraints.anchor = 21;
/*  502 */     this.jPanel1.add(this.jLabel6, gridBagConstraints);
/*  503 */     gridBagConstraints = new GridBagConstraints();
/*  504 */     gridBagConstraints.gridx = 4;
/*  505 */     gridBagConstraints.gridy = 8;
/*  506 */     gridBagConstraints.fill = 2;
/*  507 */     gridBagConstraints.weightx = 1.0D;
/*  508 */     this.jPanel1.add(this.jTextField9, gridBagConstraints);
/*  509 */     this.jLabel7.setText("Núm. corto de la cuenta");
/*  510 */     gridBagConstraints = new GridBagConstraints();
/*  511 */     gridBagConstraints.gridx = 6;
/*  512 */     gridBagConstraints.gridy = 10;
/*  513 */     gridBagConstraints.fill = 2;
/*  514 */     gridBagConstraints.anchor = 21;
/*  515 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  516 */     this.jPanel1.add(this.jLabel7, gridBagConstraints);
/*  517 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  519 */             ProvCuentasBancarias.this.jTextField10FocusGained(evt);
/*      */           }
/*      */         });
/*  522 */     gridBagConstraints = new GridBagConstraints();
/*  523 */     gridBagConstraints.gridx = 8;
/*  524 */     gridBagConstraints.gridy = 10;
/*  525 */     gridBagConstraints.fill = 2;
/*  526 */     gridBagConstraints.weightx = 1.0D;
/*  527 */     this.jPanel1.add(this.jTextField10, gridBagConstraints);
/*  528 */     this.jLabel8.setText("Moneda");
/*  529 */     gridBagConstraints = new GridBagConstraints();
/*  530 */     gridBagConstraints.gridx = 6;
/*  531 */     gridBagConstraints.gridy = 8;
/*  532 */     gridBagConstraints.fill = 2;
/*  533 */     gridBagConstraints.anchor = 21;
/*  534 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  535 */     this.jPanel1.add(this.jLabel8, gridBagConstraints);
/*  536 */     this.jTextField85.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  538 */             ProvCuentasBancarias.this.jTextField85ActionPerformed(evt);
/*      */           }
/*      */         });
/*  541 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  542 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  544 */             ProvCuentasBancarias.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*  547 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/*  548 */     this.jPanel133.setLayout(jPanel133Layout);
/*  549 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/*  550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  551 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  552 */           .addComponent(this.jTextField85)
/*  553 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  554 */           .addComponent(this.jButton55, -2, 18, -2)));
/*  555 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/*  556 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  557 */         .addGroup(jPanel133Layout.createSequentialGroup()
/*  558 */           .addGroup(jPanel133Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  559 */             .addComponent(this.jTextField85)
/*  560 */             .addComponent(this.jButton55, -2, 0, 32767))
/*  561 */           .addGap(0, 0, 32767)));
/*  562 */     gridBagConstraints = new GridBagConstraints();
/*  563 */     gridBagConstraints.gridx = 4;
/*  564 */     gridBagConstraints.gridy = 22;
/*  565 */     gridBagConstraints.fill = 2;
/*  566 */     gridBagConstraints.weightx = 1.0D;
/*  567 */     this.jPanel1.add(this.jPanel133, gridBagConstraints);
/*  568 */     this.jLabel9.setText("Contrato");
/*  569 */     gridBagConstraints = new GridBagConstraints();
/*  570 */     gridBagConstraints.gridx = 2;
/*  571 */     gridBagConstraints.gridy = 14;
/*  572 */     gridBagConstraints.anchor = 21;
/*  573 */     this.jPanel1.add(this.jLabel9, gridBagConstraints);
/*  574 */     gridBagConstraints = new GridBagConstraints();
/*  575 */     gridBagConstraints.gridx = 4;
/*  576 */     gridBagConstraints.gridy = 14;
/*  577 */     gridBagConstraints.fill = 2;
/*  578 */     gridBagConstraints.weightx = 1.0D;
/*  579 */     this.jPanel1.add(this.jTextField11, gridBagConstraints);
/*  580 */     this.jLabel10.setText("Ejecutivo");
/*  581 */     gridBagConstraints = new GridBagConstraints();
/*  582 */     gridBagConstraints.gridx = 6;
/*  583 */     gridBagConstraints.gridy = 14;
/*  584 */     gridBagConstraints.fill = 2;
/*  585 */     gridBagConstraints.anchor = 21;
/*  586 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  587 */     this.jPanel1.add(this.jLabel10, gridBagConstraints);
/*  588 */     gridBagConstraints = new GridBagConstraints();
/*  589 */     gridBagConstraints.gridx = 8;
/*  590 */     gridBagConstraints.gridy = 14;
/*  591 */     gridBagConstraints.fill = 2;
/*  592 */     gridBagConstraints.weightx = 1.0D;
/*  593 */     this.jPanel1.add(this.jTextField12, gridBagConstraints);
/*  594 */     this.jLabel11.setText("Teléfono");
/*  595 */     gridBagConstraints = new GridBagConstraints();
/*  596 */     gridBagConstraints.gridx = 6;
/*  597 */     gridBagConstraints.gridy = 16;
/*  598 */     gridBagConstraints.anchor = 17;
/*  599 */     gridBagConstraints.insets = new Insets(0, 25, 0, 0);
/*  600 */     this.jPanel1.add(this.jLabel11, gridBagConstraints);
/*  601 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  603 */             ProvCuentasBancarias.this.jFormattedTextField1FocusLost(evt);
/*      */           }
/*      */         });
/*  606 */     gridBagConstraints = new GridBagConstraints();
/*  607 */     gridBagConstraints.gridx = 8;
/*  608 */     gridBagConstraints.gridy = 16;
/*  609 */     gridBagConstraints.fill = 2;
/*  610 */     gridBagConstraints.weightx = 0.8D;
/*  611 */     this.jPanel1.add(this.jFormattedTextField1, gridBagConstraints);
/*  612 */     gridBagConstraints = new GridBagConstraints();
/*  613 */     gridBagConstraints.gridx = 2;
/*  614 */     gridBagConstraints.gridy = 12;
/*  615 */     gridBagConstraints.gridwidth = 7;
/*  616 */     gridBagConstraints.fill = 2;
/*  617 */     this.jPanel1.add(this.jSeparator1, gridBagConstraints);
/*  618 */     gridBagConstraints = new GridBagConstraints();
/*  619 */     gridBagConstraints.gridx = 2;
/*  620 */     gridBagConstraints.gridy = 4;
/*  621 */     gridBagConstraints.gridwidth = 7;
/*  622 */     gridBagConstraints.fill = 2;
/*  623 */     this.jPanel1.add(this.jSeparator2, gridBagConstraints);
/*  624 */     this.jLabel12.setText("Comentarios:");
/*  625 */     gridBagConstraints = new GridBagConstraints();
/*  626 */     gridBagConstraints.gridx = 2;
/*  627 */     gridBagConstraints.gridy = 18;
/*  628 */     gridBagConstraints.fill = 2;
/*  629 */     this.jPanel1.add(this.jLabel12, gridBagConstraints);
/*  630 */     this.jTextArea1.setColumns(20);
/*  631 */     this.jTextArea1.setRows(5);
/*  632 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*  633 */     gridBagConstraints = new GridBagConstraints();
/*  634 */     gridBagConstraints.gridx = 2;
/*  635 */     gridBagConstraints.gridy = 20;
/*  636 */     gridBagConstraints.gridwidth = 7;
/*  637 */     gridBagConstraints.fill = 1;
/*  638 */     gridBagConstraints.weighty = 1.0D;
/*  639 */     this.jPanel1.add(this.jScrollPane1, gridBagConstraints);
/*  640 */     this.jLabel14.setText("Sucursal Operativa");
/*  641 */     gridBagConstraints = new GridBagConstraints();
/*  642 */     gridBagConstraints.gridx = 2;
/*  643 */     gridBagConstraints.gridy = 22;
/*  644 */     gridBagConstraints.anchor = 21;
/*  645 */     this.jPanel1.add(this.jLabel14, gridBagConstraints);
/*  646 */     this.jTextField86.setEditable(false);
/*  647 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  648 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  650 */             ProvCuentasBancarias.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*  653 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/*  654 */     this.jPanel136.setLayout(jPanel136Layout);
/*  655 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/*  656 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  657 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*  658 */           .addComponent(this.jTextField86)
/*  659 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  660 */           .addComponent(this.jButton56, -2, 18, -2)));
/*  661 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/*  662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  663 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*  664 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  665 */             .addComponent(this.jTextField86)
/*  666 */             .addComponent(this.jButton56, -2, 0, 32767))
/*  667 */           .addGap(0, 0, 32767)));
/*  668 */     gridBagConstraints = new GridBagConstraints();
/*  669 */     gridBagConstraints.gridx = 8;
/*  670 */     gridBagConstraints.gridy = 8;
/*  671 */     gridBagConstraints.fill = 2;
/*  672 */     gridBagConstraints.weightx = 1.0D;
/*  673 */     this.jPanel1.add(this.jPanel136, gridBagConstraints);
/*  674 */     this.jLabel13.setText("Descripción de la cuenta");
/*  675 */     gridBagConstraints = new GridBagConstraints();
/*  676 */     gridBagConstraints.gridx = 2;
/*  677 */     gridBagConstraints.gridy = 0;
/*  678 */     gridBagConstraints.anchor = 21;
/*  679 */     this.jPanel1.add(this.jLabel13, gridBagConstraints);
/*  680 */     this.jTextField13.setText("jTextField13");
/*  681 */     gridBagConstraints = new GridBagConstraints();
/*  682 */     gridBagConstraints.gridx = 4;
/*  683 */     gridBagConstraints.gridy = 0;
/*  684 */     gridBagConstraints.gridwidth = 5;
/*  685 */     gridBagConstraints.fill = 2;
/*  686 */     this.jPanel1.add(this.jTextField13, gridBagConstraints);
/*  687 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  688 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  689 */     this.materialButton19.setMnemonic('C');
/*  690 */     this.materialButton19.setText("Cerrar");
/*  691 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/*  692 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  693 */     this.materialButton19.setHorizontalTextPosition(0);
/*  694 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  696 */             ProvCuentasBancarias.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*  699 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/*  700 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  701 */     this.materialButton20.setMnemonic('G');
/*  702 */     this.materialButton20.setText("Guardar");
/*  703 */     this.materialButton20.setToolTipText("Guardar (Alt + G)");
/*  704 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  705 */     this.materialButton20.setHorizontalTextPosition(0);
/*  706 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  708 */             ProvCuentasBancarias.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*  711 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/*  712 */     this.jPanel108.setLayout(jPanel108Layout);
/*  713 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/*  714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  715 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  716 */           .addContainerGap(-1, 32767)
/*  717 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/*  718 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  719 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/*  720 */           .addContainerGap()));
/*  721 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/*  722 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  723 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  724 */           .addGroup(jPanel108Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  725 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/*  726 */             .addComponent((Component)this.materialButton20, -2, 38, -2))
/*  727 */           .addGap(0, 0, 32767)));
/*  728 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  729 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  730 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  731 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  732 */         .addComponent(this.jPanel108, -1, -1, 32767)
/*  733 */         .addComponent(this.jPanel1, -1, 734, 32767));
/*  734 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  735 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  736 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  737 */           .addComponent(this.jPanel1, -2, -1, -2)
/*  738 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  739 */           .addComponent(this.jPanel108, -2, -1, -2)
/*  740 */           .addGap(9, 9, 9)));
/*  741 */     this.jDialog2.setTitle("Catálogo de Monedas");
/*  742 */     this.jDialog2.setUndecorated(true);
/*  743 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/*  744 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  747 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  750 */     this.rSTableMetro3.setAltoHead(25);
/*  751 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  752 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  753 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  754 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  755 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  756 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  757 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  758 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  759 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  760 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  761 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  762 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  763 */     this.rSTableMetro3.setShowHorizontalLines(false);
/*  764 */     this.rSTableMetro3.setShowVerticalLines(false);
/*  765 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  766 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  767 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  769 */             ProvCuentasBancarias.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  772 */     this.jScrollPane31.setViewportView((Component)this.rSTableMetro3);
/*  773 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/*  774 */     this.jPanel134.setLayout(jPanel134Layout);
/*  775 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/*  776 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  777 */         .addComponent(this.jScrollPane31, -1, 543, 32767));
/*  778 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/*  779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  780 */         .addComponent(this.jScrollPane31, -1, 223, 32767));
/*  781 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  782 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  783 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  784 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  785 */         .addGap(0, 543, 32767)
/*  786 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  787 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*  788 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  789 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  790 */         .addGap(0, 223, 32767)
/*  791 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  792 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*  793 */     this.jDialog3.setTitle("Sucursales");
/*  794 */     this.jDialog3.setUndecorated(true);
/*  795 */     (new Object[2])[0] = null; (new Object[2])[1] = "Veracruz"; (new Object[2][])[0] = new Object[2]; (new Object[2])[0] = null; (new Object[2])[1] = "Poza Rica"; (new Object[2][])[1] = new Object[2]; (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[2]) {
/*  796 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/*  798 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/*  801 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  805 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  808 */     this.rSTableMetro2.setAltoHead(25);
/*  809 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  810 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  811 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  812 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  813 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  814 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  815 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  816 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  817 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  818 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  819 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  820 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  821 */     this.rSTableMetro2.setShowHorizontalLines(false);
/*  822 */     this.rSTableMetro2.setShowVerticalLines(false);
/*  823 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  824 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  825 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  827 */             ProvCuentasBancarias.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  830 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  832 */             ProvCuentasBancarias.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  835 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/*  836 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  837 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/*  838 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  839 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/*  841 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/*  842 */     this.jPanel135.setLayout(jPanel135Layout);
/*  843 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/*  844 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  845 */         .addComponent(this.jScrollPane32, -1, 418, 32767));
/*  846 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/*  847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */         .addComponent(this.jScrollPane32, -1, 131, 32767));
/*  849 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  850 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  851 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  852 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  853 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
/*  854 */           .addGap(0, 0, 0)
/*  855 */           .addComponent(this.jPanel135, -1, -1, 32767)));
/*  856 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  857 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  858 */         .addComponent(this.jPanel135, -1, -1, 32767));
/*  859 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*  860 */     this.jPanel8.setBackground(this.lc.SECUNDARIO1);
/*  861 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*  862 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/*  863 */     this.jLabel55.setHorizontalAlignment(0);
/*  864 */     this.jLabel55.setText("Cuentas Bancarias");
/*  865 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  866 */     this.jPanel8.setLayout(jPanel8Layout);
/*  867 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  868 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  869 */         .addComponent(this.jLabel55, -1, -1, 32767));
/*  870 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  871 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  872 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  873 */           .addContainerGap()
/*  874 */           .addComponent(this.jLabel55)
/*  875 */           .addContainerGap(-1, 32767)));
/*  876 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*  877 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/*  878 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/*  879 */     this.jPanel17.setLayout(new GridLayout(1, 5, 6, 0));
/*  880 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  882 */             ProvCuentasBancarias.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  885 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  887 */             ProvCuentasBancarias.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*  890 */     this.jPanel17.add(this.jTextField1);
/*  891 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  893 */             ProvCuentasBancarias.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  896 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  898 */             ProvCuentasBancarias.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*  901 */     this.jPanel17.add(this.jTextField2);
/*  902 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  904 */             ProvCuentasBancarias.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  907 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  909 */             ProvCuentasBancarias.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  912 */     this.jPanel17.add(this.jTextField3);
/*  913 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  914 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  915 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "DESACTIVADA", "TODAS" }));
/*  916 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  918 */             ProvCuentasBancarias.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  921 */     this.jPanel17.add(this.jComboBox2);
/*  922 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  923 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  924 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL OPERATIVA" }));
/*  925 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  927 */             ProvCuentasBancarias.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  930 */     this.jPanel17.add(this.jComboBox1);
/*  931 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/*  932 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/*  933 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  936 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  939 */     this.rSTableMetro1.setAltoHead(40);
/*  940 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  941 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/*  942 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  943 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/*  944 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  945 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  946 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  947 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  948 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  949 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  950 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  951 */     this.rSTableMetro1.setRowHeight(18);
/*  952 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  953 */     this.rSTableMetro1.setShowHorizontalLines(false);
/*  954 */     this.rSTableMetro1.setShowVerticalLines(false);
/*  955 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  956 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  957 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  959 */             ProvCuentasBancarias.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/*  962 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  964 */             ProvCuentasBancarias.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/*  967 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*  968 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/*  969 */     this.jPanel3.setLayout(new GridLayout(1, 0, 6, 0));
/*  970 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/*  971 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*  972 */     this.jLabel58.setFont(new Font("Cantarell", 0, 13));
/*  973 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/*  974 */     this.jLabel58.setHorizontalAlignment(4);
/*  975 */     this.jLabel58.setText("Total: ");
/*  976 */     this.jPanel47.add(this.jLabel58);
/*  977 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/*  978 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/*  979 */     this.jLabel48.setHorizontalAlignment(2);
/*  980 */     this.jLabel48.setText("t");
/*  981 */     this.jPanel47.add(this.jLabel48);
/*  982 */     this.jPanel3.add(this.jPanel47);
/*  983 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/*  984 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  985 */     this.jPanel4.setLayout(jPanel4Layout);
/*  986 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  987 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  988 */         .addGap(0, 84, 32767));
/*  989 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  991 */         .addGap(0, 36, 32767));
/*  992 */     this.jPanel3.add(this.jPanel4);
/*  993 */     this.jPanel5.setBackground(this.lc.SECUNDARIO2);
/*  994 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  995 */     this.jPanel5.setLayout(jPanel5Layout);
/*  996 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  997 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  998 */         .addGap(0, 84, 32767));
/*  999 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1000 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1001 */         .addGap(0, 36, 32767));
/* 1002 */     this.jPanel3.add(this.jPanel5);
/* 1003 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1004 */     this.jButton2.setMnemonic('N');
/* 1005 */     this.jButton2.setText("Nueva");
/* 1006 */     this.jButton2.setToolTipText("Nueva Cuenta (Alt + N)");
/* 1007 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1009 */             ProvCuentasBancarias.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1012 */     this.jPanel3.add(this.jButton2);
/* 1013 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1014 */     this.jButton10.setMnemonic('M');
/* 1015 */     this.jButton10.setText("Modificar");
/* 1016 */     this.jButton10.setToolTipText("Modificar (Alt + M)");
/* 1017 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1019 */             ProvCuentasBancarias.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1022 */     this.jPanel3.add(this.jButton10);
/* 1023 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1024 */     this.jButton11.setMnemonic('V');
/* 1025 */     this.jButton11.setText("Ver Detalle");
/* 1026 */     this.jButton11.setToolTipText("Ver Detalle (Alt+V)");
/* 1027 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1029 */             ProvCuentasBancarias.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1032 */     this.jPanel3.add(this.jButton11);
/* 1033 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/exchange.png")));
/* 1034 */     this.jButton12.setMnemonic('A');
/* 1035 */     this.jButton12.setText("Activar / Desactivar");
/* 1036 */     this.jButton12.setToolTipText(" Activar o desactivar la cuenta (Alt + A)");
/* 1037 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1039 */             ProvCuentasBancarias.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1042 */     this.jPanel3.add(this.jButton12);
/* 1043 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1044 */     this.jButton13.setMnemonic('p');
/* 1045 */     this.jButton13.setText("Imprimir");
/* 1046 */     this.jButton13.setToolTipText("Imprimir (Alt+P)");
/* 1047 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1049 */             ProvCuentasBancarias.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1052 */     this.jPanel3.add(this.jButton13);
/* 1053 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1054 */     this.jButton14.setMnemonic('G');
/* 1055 */     this.jButton14.setText("Guardar Reporte");
/* 1056 */     this.jButton14.setToolTipText("Guardar (Alt + G)");
/* 1057 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1059 */             ProvCuentasBancarias.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1062 */     this.jPanel3.add(this.jButton14);
/* 1063 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1064 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1065 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1067 */         .addComponent(this.jScrollPane13, -1, 805, 32767)
/* 1068 */         .addComponent(this.jPanel3, -2, 0, 32767));
/* 1069 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1070 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1071 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1072 */           .addComponent(this.jScrollPane13, -1, 234, 32767)
/* 1073 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1074 */           .addComponent(this.jPanel3, -2, 36, -2)
/* 1075 */           .addGap(8, 8, 8)));
/* 1076 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1077 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1078 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 1081 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 1082 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 1083 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1084 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1085 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1086 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 1087 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1088 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 1089 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1090 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/* 1091 */     GroupLayout layout = new GroupLayout(this);
/* 1092 */     setLayout(layout);
/* 1093 */     layout.setHorizontalGroup(layout
/* 1094 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1095 */         .addGap(0, 805, 32767)
/* 1096 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1097 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/* 1098 */     layout.setVerticalGroup(layout
/* 1099 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */         .addGap(0, 349, 32767)
/* 1101 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1106 */     String cadena = this.jTextField1.getText();
/* 1107 */     if (!cadena.equals("")) {
/* 1108 */       if (this.presionado == null) {
/* 1109 */         this.presionado = new Presionado();
/* 1110 */         this.presionado.start();
/*      */       } else {
/* 1112 */         this.presionado.detenerFuera();
/* 1113 */         this.presionado = new Presionado();
/* 1114 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1117 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1122 */     String cadena = this.jTextField2.getText();
/* 1123 */     if (!cadena.equals("")) {
/* 1124 */       if (this.presionado == null) {
/* 1125 */         this.presionado = new Presionado();
/* 1126 */         this.presionado.start();
/*      */       } else {
/* 1128 */         this.presionado.detenerFuera();
/* 1129 */         this.presionado = new Presionado();
/* 1130 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1133 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1138 */     String cadena = this.jTextField3.getText();
/* 1139 */     if (!cadena.equals("")) {
/* 1140 */       if (this.presionado == null) {
/* 1141 */         this.presionado = new Presionado();
/* 1142 */         this.presionado.start();
/*      */       } else {
/* 1144 */         this.presionado.detenerFuera();
/* 1145 */         this.presionado = new Presionado();
/* 1146 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1149 */       this.jTextField3.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1154 */     if (this.PRIMERA) {
/* 1155 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 1160 */     if (evt.getClickCount() == 2) {
/* 1161 */       verCuenta();
/* 1162 */       this.jDialog1.setTitle("Información de la cuenta: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3)));
/* 1163 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1171 */     this.ACTIVARSUC = "";
/* 1172 */     activar();
/* 1173 */     limpiarNuevo();
/* 1174 */     limpiarTablaSuc();
/* 1175 */     this.jDialog1.setTitle("Crear nueva cuenta");
/* 1176 */     this.materialButton20.setVisible(true);
/* 1177 */     this.materialButton20.setText("Guardar");
/* 1178 */     this.materialButton20.setMnemonic('G');
/* 1179 */     this.materialButton20.setToolTipText("Guardar (Alt + G)");
/* 1180 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1184 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1185 */     if (indice < 0) {
/* 1186 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cuenta para modificar la información", "Selecciona una cuenta", 0, this.ADVER);
/*      */     } else {
/* 1188 */       this.ACTIVARSUC = "";
/* 1189 */       verCuenta();
/* 1190 */       activar();
/* 1191 */       String[] sucursales = this.ACTIVARSUC.split(", ");
/* 1192 */       for (String v : sucursales) {
/* 1193 */         selecTablaSucursal(v);
/*      */       }
/* 1195 */       if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 1196 */         this.jTextField85.setEnabled(true);
/* 1197 */         this.jTextField85.setText("");
/* 1198 */         this.jButton55.setEnabled(true);
/*      */       } 
/* 1200 */       this.materialButton20.setVisible(true);
/* 1201 */       this.materialButton20.setText("Modificar");
/* 1202 */       this.materialButton20.setToolTipText("Modificar (Alt + M)");
/* 1203 */       this.jDialog1.setTitle("Modificar la cuenta: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3)));
/* 1204 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1209 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1210 */     if (indice < 0) {
/* 1211 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cuenta para ver la información", "Selecciona una cuenta", 0, this.ADVER);
/*      */     } else {
/* 1213 */       verCuenta();
/* 1214 */       this.jDialog1.setTitle("Información de la cuenta: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3)));
/* 1215 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1220 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 1221 */     if (indice < 0) {
/* 1222 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una cuenta para Activar o Desactivar", "Selecciona una cuenta", 0, this.ADVER);
/*      */     } else {
/* 1224 */       String v = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 8).toString();
/* 1225 */       String cuenta = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5).toString();
/* 1226 */       String actualizo = this.USUARIO + this.USUARIO;
/* 1227 */       if (v.equals("ACTIVA")) {
/* 1228 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html><b>¿Estás seguro que deseas desactivar la cuenta?</b><p>No se podrán hacer movimientos como: transferencias o salida de cheques,<p>sin embargo su historial quedará intacto.</html>", "Desactivar cuenta", 0, 3, this.PREG);
/* 1229 */         if (res == 0) {
/* 1230 */           this.con.inserSinMsj("update prov_cuentasbancarias set estado ='DESACTIVADA', usuario='" + actualizo + "' where numCuenta= " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 1231 */           this.mensajeTry.guardarConf("Se ha desactivado una cuenta bancaria, usuario: " + this.USUARIO, "Cuenta Desactivada (" + cuenta + ")", "ERROR", "Cuentasporpagar");
/* 1232 */           if (this.jComboBox2.getSelectedIndex() == 0) {
/* 1233 */             DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro1.getModel();
/* 1234 */             temp.removeRow(this.rSTableMetro1.getSelectedRow());
/* 1235 */             this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/*      */           } else {
/* 1237 */             consultar();
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1241 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html><b>¿Estás seguro que deseas activar la cuenta?</b><p>Con esta acción ya se podrán realizar movimientos de transferencia y cheques</html>", "Activar cuenta", 0, 3, this.PREG);
/* 1242 */         if (res == 0) {
/* 1243 */           this.con.inserSinMsj("update prov_cuentasbancarias set estado ='ACTIVA', usuario='" + actualizo + "' where numCuenta= " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 1244 */           this.mensajeTry.guardarConf("Se ha activado una cuenta bancaria, usuario: " + this.USUARIO, "Cuenta Activada (" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4)) + ")", "INFO", "Cuentasporpagar");
/* 1245 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1252 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 1257 */       String sicret = "LOGO.jpg";
/* 1258 */       String forsis = "forsis100x.jpg";
/* 1259 */       JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "cont", "descripcion", "banco", "sucursal", "clabe", "cuenta", "moneda", "estado", "actualizo" });
/* 1260 */       Map<Object, Object> datos = new HashMap<>();
/* 1261 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 1262 */       datos.put("estatus", this.jComboBox2.getSelectedItem().toString().toUpperCase());
/* 1263 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 1264 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 1265 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 1266 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_CuentasGral.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 1267 */       JasperViewer visor = new JasperViewer(print, false);
/* 1268 */       visor.setTitle("Cuentas bancarias");
/* 1269 */       visor.setIconImage(this.iconoImprimir);
/* 1270 */       visor.setZoomRatio(0.59F);
/* 1271 */       visor.setExtendedState(6);
/* 1272 */       visor.setVisible(true);
/* 1273 */     } catch (JRException e) {
/* 1274 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 1279 */     Dimension di = this.jButton55.getSize();
/* 1280 */     Point p = this.jButton55.getLocationOnScreen();
/* 1281 */     this.jDialog3.setLocation(p.x + di.width - 200, p.y + 30);
/* 1282 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1FocusLost(FocusEvent evt) {
/* 1286 */     int cont = 0;
/* 1287 */     if (this.jFormattedTextField1.getText().contains("_") && !this.jFormattedTextField1.getText().equals("___-___-____")) {
/* 1288 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has colocado un teléfono incompleto.\nTeléfono: " + this.jFormattedTextField1.getText(), "Teléfono Incompleto", 0, this.ADVER);
/* 1289 */       this.jFormattedTextField1.setValue("");
/* 1290 */     } else if (!this.jFormattedTextField1.getText().contains("_")) {
/* 1291 */       String cadena = this.jFormattedTextField1.getText();
/* 1292 */       String cad1 = cadena.substring(0, 3);
/* 1293 */       String cad2 = cadena.substring(4, 7);
/* 1294 */       String cad3 = cadena.substring(8, 12);
/* 1295 */       String tel = cad1 + cad1 + cad2;
/* 1296 */       for (int i = 1; i < tel.length(); i++) {
/* 1297 */         char c = tel.charAt(i - 1);
/* 1298 */         char d = tel.charAt(i);
/* 1299 */         if (c != d) {
/* 1300 */           cont++;
/*      */         }
/*      */       } 
/*      */     } 
/* 1304 */     if (cont == 0 && !this.jFormattedTextField1.getText().contains("_")) {
/* 1305 */       JOptionPane.showMessageDialog(null, "El teléfono debe tener por lo menos un dígito diferente a los demás.", "Dígitos Iguales", 0, this.ADVER);
/* 1306 */       this.jFormattedTextField1.setValue("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 1311 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 1315 */     if (this.materialButton20.getText().equals("Imprimir")) {
/*      */       try {
/* 1317 */         String sicret = "LOGO.jpg";
/* 1318 */         String forsis = "forsis100x.jpg";
/* 1319 */         Map<Object, Object> datos = new HashMap<>();
/* 1320 */         datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 1321 */         datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_mat"));
/* 1322 */         datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 1323 */         datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 1324 */         datos.put("parameter1", this.jTextField13.getText());
/* 1325 */         datos.put("parameter2", this.jTextField4.getText());
/* 1326 */         datos.put("parameter3", this.jTextField5.getText());
/* 1327 */         datos.put("parameter4", this.jTextField6.getText());
/* 1328 */         datos.put("parameter5", this.jTextField7.getText());
/* 1329 */         datos.put("parameter6", this.jTextField9.getText());
/* 1330 */         datos.put("parameter7", this.jTextField86.getText());
/* 1331 */         datos.put("parameter8", this.jTextField8.getText());
/* 1332 */         datos.put("parameter9", this.jTextField10.getText());
/* 1333 */         datos.put("parameter10", this.jTextField11.getText());
/* 1334 */         datos.put("parameter11", this.jTextField12.getText());
/* 1335 */         datos.put("parameter12", this.jFormattedTextField1.getText());
/* 1336 */         datos.put("parameter13", this.jTextArea1.getText());
/* 1337 */         this.jDialog1.setVisible(false);
/* 1338 */         JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_CuentasIndividual.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 1339 */         JasperViewer visor = new JasperViewer(reporte, false);
/* 1340 */         visor.setTitle("Reporte Individual de Cuentas");
/* 1341 */         visor.setIconImage(this.iconoImprimir);
/* 1342 */         visor.setZoomRatio(0.59F);
/* 1343 */         visor.setExtendedState(6);
/* 1344 */         visor.setVisible(true);
/* 1345 */       } catch (JRException e) {
/* 1346 */         System.out.println(e.getMessage());
/*      */       } 
/*      */     } else {
/*      */       
/* 1350 */       String suc = dameSucursalOp(this.jTextField85, (JTable)this.rSTableMetro2);
/* 1351 */       String tel = this.jFormattedTextField1.getText();
/* 1352 */       String actualizo = this.USUARIO + this.USUARIO;
/* 1353 */       if (tel.equals("___-___-____")) {
/* 1354 */         tel = "";
/*      */       }
/* 1356 */       if (this.jTextField13.getText()
/* 1357 */         .equals("")) {
/* 1358 */         this.error.cargarError(this.jTextField13, "050");
/* 1359 */       } else if (this.jTextField4.getText()
/* 1360 */         .equals("")) {
/* 1361 */         this.error.cargarError(this.jTextField4, "050");
/* 1362 */       } else if (this.jTextField5.getText()
/* 1363 */         .equals("")) {
/* 1364 */         this.error.cargarError(this.jTextField5, "050");
/* 1365 */       } else if (this.jTextField5.getText()
/* 1366 */         .equals("")) {
/* 1367 */         this.error.cargarError(this.jTextField5, "050");
/* 1368 */       } else if (this.jTextField6.getText()
/* 1369 */         .equals("")) {
/* 1370 */         this.error.cargarError(this.jTextField6, "050");
/* 1371 */       } else if (this.jTextField9.getText()
/* 1372 */         .equals("")) {
/* 1373 */         this.error.cargarError(this.jTextField9, "050");
/* 1374 */       } else if (this.jTextField8.getText()
/* 1375 */         .equals("")) {
/* 1376 */         this.error.cargarError(this.jTextField8, "050");
/* 1377 */       } else if (this.jTextField10.getText()
/* 1378 */         .equals("")) {
/* 1379 */         this.error.cargarError(this.jTextField10, "050");
/* 1380 */       } else if (!this.val.validarTexto(this.jTextField13, this.jTextField13.getText(), "004") && 
/* 1381 */         !this.val.validarTexto(this.jTextField4, this.jTextField4.getText(), "004") && 
/* 1382 */         !this.val.validarTexto(this.jTextField5, this.jTextField5.getText(), "004") && 
/* 1383 */         !this.val.validarDigitos(this.jTextField6, this.jTextField6.getText()) && 
/* 1384 */         !this.val.validarTexto(this.jTextField7, this.jTextField7.getText(), "004") && 
/* 1385 */         !this.val.validarDigitos(this.jTextField9, this.jTextField9.getText()) && 
/* 1386 */         !this.val.validarDigitos(this.jTextField8, this.jTextField8.getText()) && 
/* 1387 */         !this.val.validarDigitos(this.jTextField10, this.jTextField10.getText()) && 
/* 1388 */         !this.val.validarTexto(this.jTextField11, this.jTextField11.getText(), "014") && 
/* 1389 */         !this.val.validarTexto(this.jTextField12, this.jTextField12.getText(), "014") && 
/* 1390 */         !this.val.validarTexto(this.jTextArea1, this.jTextArea1.getText(), "014")) {
/* 1391 */         if (suc.equals("")) {
/* 1392 */           this.jTextField85.setBackground(Color.RED);
/* 1393 */           JOptionPane.showMessageDialog(this.jDialog1, "Te falta ingresar la sucursal operativa\nPor lo menos debe estar seleccionada una sucursal.", "Falta sucursal operativa", 0, this.ADVER);
/* 1394 */         } else if (this.materialButton20.getText().equals("Guardar")) {
/* 1395 */           String[] campos = { "Descripción", "Nombre completo del banco", "Nombre corto del banco", "Núm de suc.", "CD de la suc.", "Clabe", "Moneda", "Núm de la cta.", "Núm corto cta.", "Contrato", "Ejecutivo", "Teléfono", "Suc. Operativa" };
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1400 */           String[] info = { this.jTextField13.getText().toUpperCase(), this.jTextField4.getText().toUpperCase(), this.jTextField5.getText().toUpperCase(), this.jTextField6.getText().toUpperCase(), this.jTextField7.getText().toUpperCase(), this.jTextField9.getText().toUpperCase(), this.jTextField86.getText().toUpperCase(), this.jTextField8.getText().toUpperCase(), this.jTextField10.getText().toUpperCase(), this.jTextField11.getText().toUpperCase(), this.jTextField12.getText().toUpperCase(), tel, suc };
/* 1401 */           int res = this.error.cargarDatos(campos, info);
/* 1402 */           if (res == 0) {
/* 1403 */             this.con.inserSinMsj("insert into prov_cuentasbancarias(bancoCompleto, bancoCorto, sucBancoNum, sucBancoCd, cuenta, clabe, cuentaCorta, moneda, contrato, ejecutivo, tel, comentarios, estado, sucOp, usuario, descripcion) values('" + this.jTextField4
/* 1404 */                 .getText().toUpperCase() + "','" + this.jTextField5.getText().toUpperCase() + "','" + this.jTextField6.getText().toUpperCase() + "','" + this.jTextField7.getText().toUpperCase() + "','" + this.jTextField8
/* 1405 */                 .getText().toUpperCase() + "','" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField86.getText().toUpperCase() + "','" + this.jTextField11
/* 1406 */                 .getText().toUpperCase() + "','" + this.jTextField12.getText().toUpperCase() + "','" + tel + "','" + this.jTextArea1.getText().toUpperCase() + "','ACTIVA','" + suc + "','" + actualizo + "','" + this.jTextField13
/* 1407 */                 .getText().toUpperCase() + "' )");
/* 1408 */             consultar();
/* 1409 */             this.jDialog1.setVisible(false);
/* 1410 */             this.mensajeTry.guardarConf("Se ha creado una cuenta bancaria, usuario: " + this.USUARIO, "Nueva Cuenta (" + this.jTextField8.getText().toUpperCase() + ")", "INFO", "Cuentasporpagar");
/*      */           } 
/* 1412 */         } else if (this.materialButton20.getText().equals("Modificar")) {
/* 1413 */           String[] campos = { "Nombre completo del banco", "Nombre corto del banco", "Núm de suc.", "CD de la suc.", "Clabe", "Moneda", "Núm de la cta.", "Núm corto cta.", "Contrato", "Ejecutivo", "Teléfono", "Suc. Operativa" };
/*      */ 
/*      */ 
/*      */           
/* 1417 */           String[] info = { this.jTextField4.getText().toUpperCase(), this.jTextField5.getText().toUpperCase(), this.jTextField6.getText().toUpperCase(), this.jTextField7.getText().toUpperCase(), this.jTextField9.getText().toUpperCase(), this.jTextField86.getText().toUpperCase(), this.jTextField8.getText().toUpperCase(), this.jTextField10.getText().toUpperCase(), this.jTextField11.getText().toUpperCase(), this.jTextField12.getText().toUpperCase(), tel, suc };
/*      */           
/* 1419 */           int res = this.error.cargarDatos2(campos, info);
/* 1420 */           if (res == 0) {
/* 1421 */             this.con.inserSinMsj("update prov_cuentasbancarias set bancoCompleto='" + this.jTextField4.getText().toUpperCase() + "', bancoCorto='" + this.jTextField5.getText().toUpperCase() + "', sucBancoNum='" + this.jTextField6.getText().toUpperCase() + "', sucBancoCd='" + this.jTextField7.getText().toUpperCase() + "', cuenta='" + this.jTextField8
/* 1422 */                 .getText().toUpperCase() + "', clabe='" + this.jTextField9.getText().toUpperCase() + "', cuentaCorta='" + this.jTextField10.getText().toUpperCase() + "', moneda='" + this.jTextField86.getText().toUpperCase() + "', contrato='" + this.jTextField11
/* 1423 */                 .getText().toUpperCase() + "', ejecutivo='" + this.jTextField12.getText().toUpperCase() + "', tel='" + tel + "', comentarios='" + this.jTextArea1.getText().toUpperCase() + "', sucOp='" + suc + "', usuario='" + actualizo + "', descripcion='" + this.jTextField13
/* 1424 */                 .getText().toUpperCase() + "' where numCuenta = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 1425 */             consultar();
/* 1426 */             this.jDialog1.setVisible(false);
/* 1427 */             this.mensajeTry.guardarConf("Se ha modificado una cuenta bancaria, usuario: " + this.USUARIO, "Cuenta Modificada (" + this.jTextField8.getText().toUpperCase() + ")", "INFO", "Cuentasporpagar");
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 1435 */     if (evt.getClickCount() == 2) {
/* 1436 */       this.jTextField86.setText(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0).toString());
/* 1437 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 1448 */     if (this.entraCatMon != true) {
/* 1449 */       this.entraCatMon = true;
/* 1450 */       llenarCatMonedas();
/*      */     } 
/* 1452 */     Dimension di = this.jButton56.getSize();
/* 1453 */     Point p = this.jButton56.getLocationOnScreen();
/* 1454 */     this.jDialog2.setLocation(p.x + di.width - 200, p.y + 30);
/* 1455 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField85ActionPerformed(ActionEvent evt) {
/* 1459 */     String v = this.jTextField85.getText().toUpperCase();
/* 1460 */     if (!this.TODOS_SUCURSALES.contains(v)) {
/* 1461 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has ingresado una sucursal que no se encuentra registrada.", "Sucursal Incorrecta", 0, this.ERROR);
/* 1462 */       this.jTextField85.setText("");
/*      */     } else {
/* 1464 */       selecTablaSucursal(v);
/* 1465 */       JOptionPane.showMessageDialog(this.padre, "Los datos también se visualizarán en la sucursal de: " + v, "Visualizando datos en otra sucursal", 0, this.INFO);
/* 1466 */       String suc = dameSucursalOp(this.jTextField85, (JTable)this.rSTableMetro2);
/* 1467 */       this.jTextField85.setToolTipText(suc);
/* 1468 */       this.jTextField85.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField10FocusGained(FocusEvent evt) {
/* 1473 */     if (this.jTextField10.getText().equals("")) {
/* 1474 */       String v = this.jTextField8.getText();
/* 1475 */       if (!v.equals("")) {
/* 1476 */         this.jTextField10.setText(v.substring(v.length() - 4, v.length()));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 1482 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 1486 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 1490 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 1494 */     String[] datos = { "ID", "BANCO", "SUCURSAL", "CLABE", "CUENTA", "MONEDA", "SUCURSAL OPERATIVA", "ESTADO", "ACTUALIZO (dd/mm/aaaa)" };
/* 1495 */     this.esc = new EscribirReporte("CUENTAS BANCARIAS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 1499 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 1500 */       this.jComboBox1.setEnabled(true);
/*      */     } else {
/* 1502 */       this.jComboBox1.setEnabled(false);
/*      */     } 
/* 1504 */     this.jComboBox1.setSelectedItem(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 1508 */     Object[] Columnas = columnas;
/* 1509 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 1510 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1511 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1512 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1513 */         if (j == 1) {
/* 1514 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1516 */         if (j == 2) {
/* 1517 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 1519 */         if (j == 3) {
/* 1520 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 1522 */         if (j == 4) {
/* 1523 */           registros[i][4] = Original.getValueAt(i, j).toString();
/*      */         }
/* 1525 */         if (j == 5) {
/* 1526 */           registros[i][5] = Original.getValueAt(i, j).toString();
/*      */         }
/* 1528 */         if (j == 6) {
/* 1529 */           registros[i][6] = Original.getValueAt(i, j).toString();
/*      */         }
/* 1531 */         if (j == 8) {
/* 1532 */           registros[i][7] = Original.getValueAt(i, j).toString();
/*      */         }
/* 1534 */         if (j == 9) {
/* 1535 */           registros[i][8] = Original.getValueAt(i, j).toString();
/*      */         }
/*      */       } 
/*      */     } 
/* 1539 */     JTable aux = new JTable(registros, Columnas);
/* 1540 */     return aux;
/*      */   }
/*      */   
/*      */   public void verCuenta() {
/* 1544 */     limpiarNuevo();
/* 1545 */     desactivar();
/* 1546 */     this.materialButton20.setText("Imprimir");
/* 1547 */     this.materialButton20.setToolTipText("Imprimir (Alt+P)");
/* 1548 */     this.materialButton20.setMnemonic('P');
/* 1549 */     String[] datos = this.con.regresaReg("bancoCompleto, bancoCorto, sucBancoNum, sucBancoCd, cuenta, clabe, cuentaCorta, moneda, contrato, ejecutivo, tel, comentarios, sucOp, descripcion", "prov_cuentasbancarias", "where numCuenta= " + 
/* 1550 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 14);
/* 1551 */     this.jTextField4.setText(datos[0]);
/* 1552 */     this.jTextField5.setText(datos[1]);
/* 1553 */     this.jTextField6.setText(datos[2]);
/* 1554 */     this.jTextField7.setText(datos[3]);
/* 1555 */     this.jTextField9.setText(datos[5]);
/* 1556 */     this.jTextField86.setText(datos[7]);
/* 1557 */     this.jTextField8.setText(datos[4]);
/* 1558 */     this.jTextField10.setText(datos[6]);
/* 1559 */     this.jTextField11.setText(datos[8]);
/* 1560 */     this.jTextField12.setText(datos[9]);
/* 1561 */     this.jTextField13.setText(datos[13]);
/* 1562 */     this.jFormattedTextField1.setValue(datos[10]);
/* 1563 */     this.jTextArea1.setText(datos[11]);
/* 1564 */     this.jTextField85.setText(datos[12].substring(0, 8) + "...");
/* 1565 */     this.jTextField85.setToolTipText(datos[12]);
/* 1566 */     this.ACTIVARSUC = datos[12];
/*      */   }
/*      */   
/*      */   public String dameSucursalOp(JTextField campo, JTable tabla) {
/* 1570 */     String sucursales = "";
/* 1571 */     boolean entra = false;
/* 1572 */     if (campo.isEditable()) {
/* 1573 */       for (int i = 0; i < tabla.getRowCount(); i++) {
/* 1574 */         boolean selec = ((Boolean)tabla.getValueAt(i, 0)).booleanValue();
/* 1575 */         if (selec) {
/* 1576 */           sucursales = sucursales + " " + sucursales + ",";
/* 1577 */           entra = true;
/*      */         } 
/*      */       } 
/* 1580 */       if (entra) {
/* 1581 */         sucursales = sucursales.substring(1, sucursales.length() - 1);
/*      */       } else {
/* 1583 */         sucursales = "";
/*      */       } 
/*      */     } else {
/* 1586 */       sucursales = campo.getText().toUpperCase();
/*      */     } 
/* 1588 */     return sucursales;
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 1592 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 1593 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 1594 */     String fecha = formatter.format(fechaHoy);
/* 1595 */     return " (" + fecha + ")";
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCatMonedas() {
/* 1600 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "moneda,descripcion", "catmoneda", "order by moneda"), (Object[])new String[2]) {
/* 1601 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1604 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1607 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1608 */     this.rSTableMetro3.setSelectionMode(0);
/* 1609 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 1610 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1611 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 1612 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(90);
/* 1613 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 1614 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 1615 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void activar() {
/* 1619 */     this.jTextField4.setEnabled(true);
/* 1620 */     this.jTextField5.setEnabled(true);
/* 1621 */     this.jTextField6.setEnabled(true);
/* 1622 */     this.jTextField7.setEnabled(true);
/* 1623 */     this.jTextField9.setEnabled(true);
/* 1624 */     this.jButton56.setEnabled(true);
/* 1625 */     this.jTextField8.setEnabled(true);
/* 1626 */     this.jTextField10.setEnabled(true);
/* 1627 */     this.jTextField11.setEnabled(true);
/* 1628 */     this.jTextField12.setEnabled(true);
/* 1629 */     this.jTextField13.setEnabled(true);
/* 1630 */     this.jFormattedTextField1.setEnabled(true);
/* 1631 */     this.jTextArea1.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 1635 */     this.jTextField4.setEnabled(false);
/* 1636 */     this.jTextField5.setEnabled(false);
/* 1637 */     this.jTextField6.setEnabled(false);
/* 1638 */     this.jTextField7.setEnabled(false);
/* 1639 */     this.jTextField9.setEnabled(false);
/* 1640 */     this.jButton56.setEnabled(false);
/* 1641 */     this.jTextField8.setEnabled(false);
/* 1642 */     this.jTextField10.setEnabled(false);
/* 1643 */     this.jTextField11.setEnabled(false);
/* 1644 */     this.jTextField12.setEnabled(false);
/* 1645 */     this.jTextField13.setEnabled(false);
/* 1646 */     this.jFormattedTextField1.setEnabled(false);
/* 1647 */     this.jTextArea1.setEnabled(false);
/* 1648 */     this.jTextField85.setEnabled(false);
/* 1649 */     this.jButton55.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void limpiarNuevo() {
/* 1653 */     this.jTextField4.setText("");
/* 1654 */     this.jTextField5.setText("");
/* 1655 */     this.jTextField6.setText("");
/* 1656 */     this.jTextField7.setText("");
/* 1657 */     this.jTextField9.setText("");
/* 1658 */     this.jTextField86.setText("MXN");
/* 1659 */     this.jTextField8.setText("");
/* 1660 */     this.jTextField10.setText("");
/* 1661 */     this.jTextField11.setText("");
/* 1662 */     this.jTextField12.setText("");
/* 1663 */     this.jTextField13.setText("");
/* 1664 */     this.jFormattedTextField1.setValue("");
/* 1665 */     this.jTextArea1.setText("");
/* 1666 */     llenarSucursales();
/*      */   }
/*      */   
/*      */   public void limpiarTablaSuc() {
/* 1670 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 1671 */       this.jTextField85.setText("");
/* 1672 */       this.jTextField85.setEnabled(true);
/* 1673 */       this.jButton55.setEnabled(true);
/*      */     } else {
/* 1675 */       this.jTextField85.setEnabled(false);
/* 1676 */       this.jTextField85.setText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1677 */       this.jButton55.setEnabled(false);
/*      */     } 
/* 1679 */     this.jTextField85.setToolTipText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1680 */     selecTablaSucursal(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void selecTablaSucursal(String suc) {
/* 1684 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 1685 */       String columna = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 1686 */       if (columna.equals(suc)) {
/* 1687 */         this.rSTableMetro2.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 1693 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 1694 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 1695 */     Iterator<String> it = lista.iterator();
/* 1696 */     while (it.hasNext()) {
/* 1697 */       String v = it.next();
/* 1698 */       this.jComboBox1.addItem(v);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarSucursales() {
/* 1703 */     this.TODOS_SUCURSALES = new ArrayList();
/* 1704 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 1705 */     Object[][] Object = new Object[lista.size()][2];
/* 1706 */     Iterator<String> it = lista.iterator();
/* 1707 */     while (it.hasNext()) {
/* 1708 */       String v = it.next();
/* 1709 */       this.TODOS_SUCURSALES.add(v);
/* 1710 */       Object[lista.indexOf(v)][0] = Boolean.valueOf(false);
/* 1711 */       Object[lista.indexOf(v)][1] = v;
/*      */     } 
/* 1713 */     llenarTablaSuc(Object);
/* 1714 */     this.com_Sucursales = new TextAutoCompleter(this.jTextField85, this.TODOS_SUCURSALES);
/*      */   }
/*      */   
/*      */   public void llenarTablaSuc(Object[][] arrayOfObject) {
/* 1718 */     (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(arrayOfObject, (Object[])new String[2]) {
/* 1719 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 1721 */           boolean[] canEdit = new boolean[] { true, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1724 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1728 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1731 */     this.rSTableMetro2.setAltoHead(25);
/* 1732 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1733 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 1734 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1735 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1736 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1737 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1738 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1739 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1740 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1741 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1742 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 1743 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1744 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 1745 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 1746 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1747 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1748 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1750 */             ProvCuentasBancarias.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1753 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1755 */             ProvCuentasBancarias.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1758 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 1759 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 1760 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 1761 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 1762 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/* 1764 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 1765 */     this.rSTableMetro2.setSelectionMode(0);
/* 1766 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 1770 */     this.PRIMERA = true;
/* 1771 */     String banco = "";
/* 1772 */     if (!this.jTextField1.getText().equals(this.holderBanco)) {
/* 1773 */       banco = this.jTextField1.getText();
/*      */     }
/* 1775 */     String sucursal = "";
/* 1776 */     if (!this.jTextField2.getText().equals(this.holderSucursal)) {
/* 1777 */       sucursal = this.jTextField2.getText();
/*      */     }
/* 1779 */     String cuenta = "";
/* 1780 */     if (!this.jTextField3.getText().equals(this.holderCuenta)) {
/* 1781 */       cuenta = this.jTextField3.getText();
/*      */     }
/* 1783 */     String sucursalForsis = "";
/* 1784 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 1785 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 1787 */     String estado = " estado like '%%'";
/* 1788 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 1789 */       estado = " estado = 'ACTIVA'";
/* 1790 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 1791 */       estado = " estado = 'DESACTIVADA'";
/*      */     } 
/*      */     
/* 1794 */     (new String[12])[0] = "ID"; (new String[12])[1] = "Descripción"; (new String[12])[2] = "Banco"; (new String[12])[3] = "Banco Completo"; (new String[12])[4] = "Sucursal"; (new String[12])[5] = "Sucursal Ciudad"; (new String[12])[6] = "Clabe"; (new String[12])[7] = "Cuenta"; (new String[12])[8] = "Moneda"; (new String[12])[9] = "Sucursal Operativa"; (new String[12])[10] = "Estado"; (new String[12])[11] = "Actualizó (dd/mm/aaaa)"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(12, "numCuenta, descripcion, bancoCorto, bancoCompleto, sucBancoNum, sucBancoCd, clabe, cuenta, moneda, sucOp, estado, usuario", "prov_cuentasbancarias", "where bancoCompleto like '%" + banco + "%' and sucBancoCd like '%" + sucursal + "%' and cuenta like '%" + cuenta + "%' and sucOp like '%" + sucursalForsis + "%' and " + estado + " order by numCuenta"), (Object[])new String[12])
/*      */         {
/*      */           
/* 1797 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1802 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1805 */     eliminarColumna(3, 2, "Banco Completo");
/* 1806 */     eliminarColumna(4, 3, "Sucursal Ciudad");
/* 1807 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 1808 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 1809 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(70);
/* 1810 */     this.rSTableMetro1.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 1811 */     this.rSTableMetro1.getColumnModel().getColumn(6).setMaxWidth(70);
/* 1812 */     this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(100);
/* 1813 */     this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(100);
/* 1814 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 1815 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 1816 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 1817 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 1818 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 1819 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 1820 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 1821 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 1822 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 1823 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 1824 */     this.rSTableMetro1.setSelectionMode(0);
/* 1825 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 1826 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1827 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 1828 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1829 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "DESACTIVADA", 0, 8, 0));
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 1833 */     int cont = this.rSTableMetro1.getRowCount();
/* 1834 */     String[] registros = new String[cont];
/*      */     int i;
/* 1836 */     for (i = 0; i < cont; i++) {
/* 1837 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*      */     }
/* 1839 */     for (i = 0; i < cont; i++) {
/* 1840 */       registros[i] = registros[i] + " - " + registros[i];
/* 1841 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*      */     } 
/* 1843 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/* 1844 */     this.rSTableMetro1.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void cuentasBancarias(String USUARIO) {
/* 1848 */     privilegios();
/* 1849 */     this.USUARIO = USUARIO;
/* 1850 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 1855 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1858 */       setEnabled((table == null || table.isEnabled()));
/* 1859 */       if (row % 2 == 0) {
/* 1860 */         setBackground(ProvCuentasBancarias.this.lc.FONDOTABLA);
/*      */       } else {
/* 1862 */         setBackground((Color)null);
/*      */       } 
/* 1864 */       setForeground(ProvCuentasBancarias.this.lc.SECUNDARIO1);
/* 1865 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1866 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender2() {
/* 1872 */       this.otro = -1;
/*      */       
/* 1874 */       this.indices = new String[0];
/*      */     } String[] indices;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1877 */       setEnabled((table == null || table.isEnabled()));
/* 1878 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 1879 */       setForeground(ProvCuentasBancarias.this.lc.SECUNDARIO1);
/* 1880 */       if (comparar(comp)) {
/* 1881 */         setBackground(new Color(102, 153, 255));
/* 1882 */         setForeground(Color.BLUE);
/* 1883 */       } else if (row % 2 == 0) {
/* 1884 */         setBackground(ProvCuentasBancarias.this.lc.FONDOTABLA);
/*      */       } else {
/* 1886 */         setBackground((Color)null);
/*      */       } 
/* 1888 */       if (column == 0 || column == 3 || column == 9 || column == 4) {
/* 1889 */         setHorizontalAlignment(4);
/*      */       } else {
/* 1891 */         setHorizontalAlignment(10);
/*      */       } 
/* 1893 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1894 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 1898 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 1902 */       for (int i = 0; i < this.indices.length; i++) {
/* 1903 */         if (this.indices[i].equals(reg)) {
/* 1904 */           return true;
/*      */         }
/*      */       } 
/* 1907 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 1912 */     this.pintar.colorear(this.jTextField1);
/* 1913 */     this.pintar.colorear(this.jTextField2);
/* 1914 */     this.pintar.colorear(this.jTextField3);
/* 1915 */     this.pintar.colorear(this.jTextField4);
/* 1916 */     this.pintar.colorear(this.jTextField5);
/* 1917 */     this.pintar.colorear(this.jTextField6);
/* 1918 */     this.pintar.colorear(this.jTextField7);
/* 1919 */     this.pintar.colorear(this.jTextField8);
/* 1920 */     this.pintar.colorear(this.jTextField9);
/* 1921 */     this.pintar.colorear(this.jTextField10);
/* 1922 */     this.pintar.colorear(this.jTextField11);
/* 1923 */     this.pintar.colorear(this.jTextField12);
/* 1924 */     this.pintar.colorear(this.jTextField13);
/* 1925 */     this.pintar.colorear(this.jTextField85);
/* 1926 */     this.pintar.colorear(this.jTextArea1);
/* 1927 */     this.pintar.colorear(this.jFormattedTextField1);
/* 1928 */     this.pintar.colorear(this.jTextField1);
/* 1929 */     this.pintar.colorear(this.jTextField2);
/* 1930 */     this.pintar.colorear(this.jTextField3);
/* 1931 */     this.pintar.colorear(this.jComboBox1);
/* 1932 */     this.pintar.colorear(this.jComboBox2);
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 1939 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 1942 */       this.t = new Thread(this);
/* 1943 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 1951 */         ProvCuentasBancarias.this.EtiquetaEstado.setVisible(true);
/* 1952 */         ProvCuentasBancarias.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 1953 */         ProvCuentasBancarias.this.setCursor(new Cursor(3));
/* 1954 */         Thread.currentThread();
/* 1955 */         Thread.sleep(1000L);
/* 1956 */         detener();
/* 1957 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 1962 */       ProvCuentasBancarias.this.consultar();
/* 1963 */       ProvCuentasBancarias.this.setCursor(ProvCuentasBancarias.this.micursor);
/* 1964 */       ProvCuentasBancarias.this.EtiquetaEstado.setVisible(false);
/* 1965 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 1969 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvCuentasBancarias.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */