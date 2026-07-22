/*      */ package sicret;
/*      */ 
/*      */ import Fuentes.Fuentes;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Point;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.net.URL;
/*      */ import java.sql.Date;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.time.Instant;
/*      */ import java.time.LocalDate;
/*      */ import java.time.ZoneId;
/*      */ import java.time.format.DateTimeFormatter;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
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
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerNumberModel;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
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
/*      */ public final class ProvTransferencias
/*      */   extends JPanel
/*      */ {
/*      */   JScrollPane panel;
/*   86 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*   88 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*   90 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*   92 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*   94 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*   96 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*   98 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*  100 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*  102 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*  104 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*  106 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*  108 */   JFrame padre = null;
/*      */   
/*  110 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  114 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  118 */   SColores lc = new SColores();
/*      */   
/*  120 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  122 */   PlaceHolder placeHolder = null;
/*      */   
/*  124 */   Consultas2 con = new Consultas2();
/*      */   
/*  126 */   Consultas2 con2 = new Consultas2();
/*      */   
/*  128 */   String holderPoliza = "FOLIO DE TRANSFERENCIA";
/*      */   
/*  130 */   String holderCuenta = "NÚMERO DE CUENTA";
/*      */   
/*  132 */   String holderBeneficiario = "BENEFICIARIO";
/*      */   
/*  134 */   String holderConcepto = "CONCEPTO";
/*      */   
/*      */   boolean entraCatMon = false;
/*      */   
/*  138 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*  140 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  142 */   ArrayList TODOS_SUCURSALES = new ArrayList();
/*      */   
/*  144 */   TextAutoCompleter com_Sucursales = null;
/*      */   
/*  146 */   Validaciones val = new Validaciones();
/*      */   
/*  148 */   Errores error = new Errores(false);
/*      */   
/*  150 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*  154 */   Cursor micursor = null;
/*      */   
/*  156 */   Presionado presionado = null;
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*  160 */   String ACTIVARSUC = "";
/*      */   
/*  162 */   String NUMPOLIZA = "";
/*      */   
/*  164 */   String[] SUCURSALES = null;
/*      */   
/*  166 */   Date fechaActual = new Date();
/*      */   
/*  168 */   Date fechaInicio = null;
/*      */   
/*  170 */   Map<Integer, String> TIPOS = new LinkedHashMap<>();
/*      */   
/*  172 */   List<Cuentas> CUENTAS = new ArrayList<>();
/*      */   
/*  174 */   List<Proveedores> PROVEEDORES = new ArrayList<>();
/*      */   
/*      */   boolean entraNueva = false;
/*      */   
/*      */   boolean encontrado = true;
/*      */   
/*  180 */   TextAutoCompleter com_OtroBeneficiario = null;
/*      */   
/*  182 */   ArrayList TODOS_OTROBENEFICIARIO = new ArrayList();
/*      */   
/*  184 */   ArrayList TODOS_COBRADOPOR = new ArrayList();
/*      */   
/*  186 */   List<String> FACTURASAGREGADAS = new ArrayList<>();
/*      */   
/*      */   boolean PRIMERA = false;
/*      */   
/*  190 */   int INDICEREMPLAZAR = 0;
/*      */   
/*      */   private ButtonGroup buttonGroup1;
/*      */   
/*      */   private JFormattedTextField cantidad;
/*      */   
/*      */   private JFormattedTextField importe;
/*      */   
/*      */   private JButton jButton1;
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
/*      */   private JButton jButton15;
/*      */   
/*      */   private JButton jButton16;
/*      */   
/*      */   private JButton jButton2;
/*      */   
/*      */   private JButton jButton53;
/*      */   
/*      */   private JButton jButton54;
/*      */   
/*      */   private JButton jButton55;
/*      */   
/*      */   private JButton jButton56;
/*      */   
/*      */   private JButton jButton57;
/*      */   
/*      */   private JButton jButton58;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox jComboBox2;
/*      */   
/*      */   private JComboBox jComboBox3;
/*      */   
/*      */   private JComboBox<String> jComboBox4;
/*      */   
/*      */   private JComboBox<String> jComboBox5;
/*      */   
/*      */   private JComboBox<String> jComboBox6;
/*      */   
/*      */   private JComboBox<String> jComboBox7;
/*      */   
/*      */   private JComboBox<String> jComboBox8;
/*      */   
/*      */   private JComboBox<String> jComboBox9;
/*      */   
/*      */   private JDateChooser jDateChooser4;
/*      */   
/*      */   private JDateChooser jDateChooser5;
/*      */   
/*      */   private JDateChooser jDateChooser6;
/*      */   
/*      */   private JDialog jDialog1;
/*      */   
/*      */   private JDialog jDialog2;
/*      */   
/*      */   private JDialog jDialog3;
/*      */   
/*      */   private JDialog jDialog4;
/*      */   
/*      */   private JDialog jDialog5;
/*      */   
/*      */   private JDialog jDialog6;
/*      */   
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private JLabel jLabel10;
/*      */   
/*      */   private JLabel jLabel101;
/*      */   
/*      */   private JLabel jLabel11;
/*      */   
/*      */   private JLabel jLabel12;
/*      */   
/*      */   private JLabel jLabel125;
/*      */   
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private JLabel jLabel14;
/*      */   
/*      */   private JLabel jLabel15;
/*      */   
/*      */   private JLabel jLabel16;
/*      */   
/*      */   private JLabel jLabel17;
/*      */   
/*      */   private JLabel jLabel170;
/*      */   
/*      */   private JLabel jLabel171;
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/*      */   private JLabel jLabel221;
/*      */   
/*      */   private JLabel jLabel233;
/*      */   
/*      */   private JLabel jLabel235;
/*      */   
/*      */   private JLabel jLabel29;
/*      */   
/*      */   private JLabel jLabel3;
/*      */   
/*      */   private JLabel jLabel37;
/*      */   
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private JLabel jLabel48;
/*      */   
/*      */   private JLabel jLabel49;
/*      */   
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private JLabel jLabel55;
/*      */   
/*      */   private JLabel jLabel58;
/*      */   
/*      */   private JLabel jLabel59;
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
/*      */   private JPanel jPanel11;
/*      */   
/*      */   private JPanel jPanel12;
/*      */   
/*      */   private JPanel jPanel13;
/*      */   
/*      */   private JPanel jPanel134;
/*      */   
/*      */   private JPanel jPanel135;
/*      */   
/*      */   private JPanel jPanel136;
/*      */   
/*      */   private JPanel jPanel137;
/*      */   
/*      */   private JPanel jPanel14;
/*      */   
/*      */   private JPanel jPanel15;
/*      */   
/*      */   private JPanel jPanel151;
/*      */   
/*      */   private JPanel jPanel16;
/*      */   
/*      */   private JPanel jPanel17;
/*      */   
/*      */   private JPanel jPanel18;
/*      */   
/*      */   private JPanel jPanel19;
/*      */   
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel20;
/*      */   
/*      */   private JPanel jPanel21;
/*      */   
/*      */   private JPanel jPanel22;
/*      */   
/*      */   private JPanel jPanel23;
/*      */   
/*      */   private JPanel jPanel24;
/*      */   
/*      */   private JPanel jPanel25;
/*      */   
/*      */   private JPanel jPanel26;
/*      */   
/*      */   private JPanel jPanel27;
/*      */   
/*      */   private JPanel jPanel29;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel31;
/*      */   
/*      */   private JPanel jPanel38;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private JPanel jPanel47;
/*      */   
/*      */   private JPanel jPanel48;
/*      */   
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private JPanel jPanel6;
/*      */   
/*      */   private JPanel jPanel7;
/*      */   
/*      */   private JPanel jPanel8;
/*      */   
/*      */   private JPanel jPanel9;
/*      */   
/*      */   private JRadioButton jRadioButton1;
/*      */   
/*      */   private JRadioButton jRadioButton2;
/*      */   
/*      */   private JRadioButton jRadioButton3;
/*      */   
/*      */   private JRadioButton jRadioButton4;
/*      */   
/*      */   private JScrollPane jScrollPane1;
/*      */   
/*      */   private JScrollPane jScrollPane13;
/*      */   
/*      */   private JScrollPane jScrollPane18;
/*      */   
/*      */   private JScrollPane jScrollPane2;
/*      */   
/*      */   private JScrollPane jScrollPane3;
/*      */   
/*      */   private JScrollPane jScrollPane32;
/*      */   
/*      */   private JScrollPane jScrollPane33;
/*      */   
/*      */   private JScrollPane jScrollPane34;
/*      */   
/*      */   private JSpinner jSpinner1;
/*      */   
/*      */   private JTable jTable1;
/*      */   
/*      */   private JTextArea jTextArea5;
/*      */   
/*      */   private JTextField jTextField1;
/*      */   
/*      */   private JTextField jTextField16;
/*      */   
/*      */   private JTextField jTextField2;
/*      */   
/*      */   private JTextField jTextField25;
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
/*      */   private JTextPane jTextPane1;
/*      */   
/*      */   private JTextPane jTextPane2;
/*      */   
/*      */   private MaterialButton materialButton21;
/*      */   
/*      */   private MaterialButton materialButton22;
/*      */   
/*      */   private MaterialButton materialButton23;
/*      */   
/*      */   private MaterialButton materialButton36;
/*      */   
/*      */   private MaterialButton materialButton37;
/*      */   
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private RSTableMetro rSTableMetro4;
/*      */   
/*      */   public ProvTransferencias(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  473 */     this.EtiquetaEstado = EtiquetaEstado;
/*  474 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  475 */     this.mensajeTry = mensajeTry;
/*  476 */     this.padre = padre;
/*  477 */     this.fichas = fichas;
/*  478 */     this.USUARIO = USUARIO;
/*  479 */     this.panel = panelito;
/*  480 */     this.con.setBaseDatos("sicre2PR");
/*  481 */     this.con.cambiarServidor();
/*  482 */     this.panel.setViewportView(this);
/*  483 */     initComponents();
/*  484 */     this.buttonGroup1.add(this.jRadioButton1);
/*  485 */     this.buttonGroup1.add(this.jRadioButton2);
/*  486 */     this.buttonGroup1.add(this.jRadioButton3);
/*  487 */     this.buttonGroup1.add(this.jRadioButton4);
/*  488 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderPoliza, false, "Century Gothic", 11);
/*  489 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderCuenta, false, "Century Gothic", 11);
/*  490 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderBeneficiario, false, "Century Gothic", 11);
/*  491 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderConcepto, false, "Century Gothic", 11);
/*  492 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  493 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  494 */     editFormat.setGroupingUsed(false);
/*  495 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  496 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  497 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  498 */     enFormat.setAllowsInvalid(true);
/*  499 */     this.cantidad.setFormatterFactory(currFactory);
/*  500 */     this.importe.setFormatterFactory(currFactory);
/*  501 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  502 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  503 */     this.jDialog1.setCursor(this.micursor);
/*  504 */     this.jDialog2.setCursor(this.micursor);
/*  505 */     this.jDialog3.setCursor(this.micursor);
/*  506 */     this.jDialog4.setCursor(this.micursor);
/*  507 */     this.jDialog5.setCursor(this.micursor);
/*  508 */     this.rSTableMetro1.setCursor(this.micursor);
/*  509 */     this.rSTableMetro2.setCursor(this.micursor);
/*  510 */     this.rSTableMetro3.setCursor(this.micursor);
/*  511 */     this.rSTableMetro4.setCursor(this.micursor);
/*  512 */     imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  513 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  514 */     this.jLabel170.setCursor(this.micursor);
/*  515 */     this.jLabel101.setCursor(this.micursor);
/*  516 */     this.jLabel171.setCursor(this.micursor);
/*  517 */     int w = this.tama.width;
/*  518 */     int h = this.tama.height;
/*  519 */     int rw = (w - 870) / 2;
/*  520 */     int rh = (h - 10) / 2;
/*  521 */     rw = (w - 450) / 2;
/*  522 */     rh = (h - 200) / 2;
/*  523 */     this.jDialog1.setLocation(rw, rh);
/*  524 */     this.jDialog1.setSize(380, 160);
/*  525 */     this.jDialog1.setResizable(false);
/*  526 */     rw = (w - 450) / 2;
/*  527 */     rh = (h - 200) / 2;
/*  528 */     this.jDialog2.setLocation(rw, rh);
/*  529 */     this.jDialog2.setSize(480, 260);
/*  530 */     this.jDialog2.setResizable(false);
/*  531 */     rw = (w - 475) / 2;
/*  532 */     rh = (h - 130) / 2;
/*  533 */     this.jDialog3.setLocation(rw, rh);
/*  534 */     this.jDialog3.setSize(475, 130);
/*  535 */     this.jDialog3.setResizable(false);
/*  536 */     rw = (w - 520) / 2;
/*  537 */     rh = (h - 270) / 2;
/*  538 */     this.jDialog4.setLocation(rw, rh);
/*  539 */     this.jDialog4.setSize(520, 270);
/*  540 */     this.jDialog4.setResizable(false);
/*  541 */     rw = (w - 390) / 2;
/*  542 */     rh = (h - 175) / 2;
/*  543 */     this.jDialog5.setLocation(rw, rh);
/*  544 */     this.jDialog5.setSize(390, 175);
/*  545 */     this.jDialog5.setVisible(false);
/*  546 */     this.jDialog5.setResizable(false);
/*  547 */     rw = (w - 390) / 2;
/*  548 */     rh = (h - 175) / 2;
/*  549 */     this.jDialog6.setLocation(rw, rh);
/*  550 */     this.jDialog6.setSize(490, 375);
/*  551 */     this.jDialog6.setVisible(false);
/*  552 */     this.jDialog6.setResizable(false);
/*  553 */     for (int i = 2018; i <= añoActual(); i++) {
/*  554 */       this.jComboBox9.addItem("" + i);
/*      */     }
/*  556 */     this.jComboBox9.setSelectedItem("" + añoActual());
/*  557 */     colorear();
/*  558 */     llenarTipo();
/*  559 */     llenarComboSuc();
/*  560 */     llenarSucursales();
/*  561 */     this.com_Sucursales = new TextAutoCompleter(this.jTextField25, this.TODOS_SUCURSALES);
/*  562 */     this.jComboBox8.setSelectedIndex(mesActual());
/*  563 */     consultar();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  567 */     this.jPanel1 = new JPanel();
/*  568 */     this.jPanel13 = new JPanel();
/*  569 */     this.jLabel13 = new JLabel();
/*  570 */     this.jLabel16 = new JLabel();
/*  571 */     this.jPanel14 = new JPanel();
/*  572 */     this.jPanel15 = new JPanel();
/*  573 */     this.materialButton21 = new MaterialButton();
/*  574 */     this.materialButton22 = new MaterialButton();
/*  575 */     this.jPanel19 = new JPanel();
/*  576 */     this.jLabel11 = new JLabel();
/*  577 */     this.jButton56 = new JButton();
/*  578 */     this.jScrollPane1 = new JScrollPane();
/*  579 */     this.jTextPane1 = new JTextPane();
/*  580 */     this.jPanel9 = new JPanel();
/*  581 */     this.jPanel12 = new JPanel();
/*  582 */     this.jLabel1 = new JLabel();
/*  583 */     this.jPanel27 = new JPanel();
/*  584 */     this.jTextField5 = new JTextField();
/*  585 */     this.jSpinner1 = new JSpinner();
/*  586 */     this.jLabel3 = new JLabel();
/*  587 */     this.jComboBox4 = new JComboBox<>();
/*  588 */     this.jLabel6 = new JLabel();
/*  589 */     this.jPanel26 = new JPanel();
/*  590 */     this.jButton58 = new JButton();
/*  591 */     this.jComboBox6 = new JComboBox<>();
/*  592 */     this.jPanel16 = new JPanel();
/*  593 */     this.jLabel2 = new JLabel();
/*  594 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  595 */     this.jLabel4 = new JLabel();
/*  596 */     this.jTextField6 = new JTextField();
/*  597 */     this.jLabel7 = new JLabel();
/*  598 */     this.jComboBox7 = new JComboBox<>();
/*  599 */     this.jPanel18 = new JPanel();
/*  600 */     this.jLabel9 = new JLabel();
/*  601 */     this.jLabel10 = new JLabel();
/*  602 */     this.jLabel5 = new JLabel();
/*  603 */     this.jComboBox5 = new JComboBox<>();
/*  604 */     this.jLabel8 = new JLabel();
/*  605 */     this.jTextField7 = new JTextField();
/*  606 */     this.jPanel20 = new JPanel();
/*  607 */     this.jPanel21 = new JPanel();
/*  608 */     this.jLabel12 = new JLabel();
/*  609 */     this.importe = new JFormattedTextField();
/*  610 */     this.jPanel22 = new JPanel();
/*  611 */     this.jRadioButton1 = new JRadioButton();
/*  612 */     this.jRadioButton3 = new JRadioButton();
/*  613 */     this.jRadioButton2 = new JRadioButton();
/*  614 */     this.jRadioButton4 = new JRadioButton();
/*  615 */     this.jPanel23 = new JPanel();
/*  616 */     this.jLabel14 = new JLabel();
/*  617 */     this.jPanel134 = new JPanel();
/*  618 */     this.jTextField25 = new JTextField();
/*  619 */     this.jButton57 = new JButton();
/*  620 */     this.jPanel24 = new JPanel();
/*  621 */     this.jLabel15 = new JLabel();
/*  622 */     this.jScrollPane2 = new JScrollPane();
/*  623 */     this.jTextPane2 = new JTextPane();
/*  624 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  625 */     this.jPanel135 = new JPanel();
/*  626 */     this.jScrollPane32 = new JScrollPane();
/*  627 */     this.rSTableMetro2 = new RSTableMetro();
/*  628 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  629 */     this.jPanel136 = new JPanel();
/*  630 */     this.jScrollPane33 = new JScrollPane();
/*  631 */     this.rSTableMetro3 = new RSTableMetro();
/*  632 */     this.jButton53 = new JButton();
/*  633 */     this.jButton54 = new JButton();
/*  634 */     this.jButton55 = new JButton();
/*  635 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  636 */     this.jPanel31 = new JPanel();
/*  637 */     this.jLabel29 = new JLabel();
/*  638 */     this.jTextField16 = new JTextField();
/*  639 */     this.jButton15 = new JButton();
/*  640 */     this.jButton16 = new JButton();
/*  641 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  642 */     this.jPanel137 = new JPanel();
/*  643 */     this.jScrollPane34 = new JScrollPane();
/*  644 */     this.rSTableMetro4 = new RSTableMetro();
/*  645 */     this.materialButton23 = new MaterialButton();
/*  646 */     this.jLabel17 = new JLabel();
/*  647 */     this.jTextField8 = new JTextField();
/*  648 */     this.jPanel48 = new JPanel();
/*  649 */     this.jLabel59 = new JLabel();
/*  650 */     this.jLabel49 = new JLabel();
/*  651 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  652 */     this.jPanel38 = new JPanel();
/*  653 */     this.jLabel125 = new JLabel();
/*  654 */     this.jScrollPane18 = new JScrollPane();
/*  655 */     this.jTextArea5 = new JTextArea();
/*  656 */     this.materialButton36 = new MaterialButton();
/*  657 */     this.materialButton37 = new MaterialButton();
/*  658 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  659 */     this.jPanel29 = new JPanel();
/*  660 */     this.jScrollPane3 = new JScrollPane();
/*  661 */     this.jTable1 = new JTable();
/*  662 */     this.cantidad = new JFormattedTextField();
/*  663 */     this.buttonGroup1 = new ButtonGroup();
/*  664 */     this.jPanel2 = new JPanel();
/*  665 */     this.jPanel8 = new JPanel();
/*  666 */     this.jLabel55 = new JLabel();
/*  667 */     this.jPanel6 = new JPanel();
/*  668 */     this.jLabel233 = new JLabel();
/*  669 */     this.jPanel7 = new JPanel();
/*  670 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  671 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  672 */     this.jComboBox8 = new JComboBox<>();
/*  673 */     this.jLabel235 = new JLabel();
/*  674 */     this.jComboBox9 = new JComboBox<>();
/*  675 */     this.jPanel11 = new JPanel();
/*  676 */     this.jButton1 = new JButton();
/*  677 */     this.jLabel170 = new JLabel();
/*  678 */     this.jLabel101 = new JLabel();
/*  679 */     this.jLabel171 = new JLabel();
/*  680 */     this.jPanel17 = new JPanel();
/*  681 */     this.jComboBox3 = new JComboBox();
/*  682 */     this.jTextField1 = new JTextField();
/*  683 */     this.jTextField2 = new JTextField();
/*  684 */     this.jTextField3 = new JTextField();
/*  685 */     this.jTextField4 = new JTextField();
/*  686 */     this.jComboBox2 = new JComboBox();
/*  687 */     this.jComboBox1 = new JComboBox();
/*  688 */     this.jPanel10 = new JPanel();
/*  689 */     this.jPanel3 = new JPanel();
/*  690 */     this.jPanel47 = new JPanel();
/*  691 */     this.jLabel58 = new JLabel();
/*  692 */     this.jLabel48 = new JLabel();
/*  693 */     this.jPanel4 = new JPanel();
/*  694 */     this.jPanel5 = new JPanel();
/*  695 */     this.jButton2 = new JButton();
/*  696 */     this.jButton10 = new JButton();
/*  697 */     this.jButton11 = new JButton();
/*  698 */     this.jButton12 = new JButton();
/*  699 */     this.jButton13 = new JButton();
/*  700 */     this.jButton14 = new JButton();
/*  701 */     this.jPanel151 = new JPanel();
/*  702 */     this.jLabel221 = new JLabel();
/*  703 */     this.jLabel37 = new JLabel();
/*  704 */     this.jPanel25 = new JPanel();
/*  705 */     this.jScrollPane13 = new JScrollPane();
/*  706 */     this.rSTableMetro1 = new RSTableMetro();
/*  707 */     this.jPanel13.setBackground(this.lc.SECUNDARIO1);
/*  708 */     this.jLabel13.setFont(new Font("Cantarell", 1, 22));
/*  709 */     this.jLabel13.setForeground(this.lc.PRIMARIO2);
/*  710 */     this.jLabel13.setHorizontalAlignment(0);
/*  711 */     this.jLabel13.setText("Nueva Transferencia");
/*  712 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  713 */     this.jLabel16.setToolTipText("Cerrar");
/*  714 */     this.jLabel16.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  716 */             ProvTransferencias.this.jLabel16MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/*  720 */             ProvTransferencias.this.jLabel16MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/*  724 */             ProvTransferencias.this.jLabel16MouseExited(evt);
/*      */           }
/*      */         });
/*  727 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  728 */     this.jPanel13.setLayout(jPanel13Layout);
/*  729 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  730 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  731 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/*  732 */           .addContainerGap()
/*  733 */           .addComponent(this.jLabel13, -1, -1, 32767)
/*  734 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  735 */           .addComponent(this.jLabel16)
/*  736 */           .addContainerGap()));
/*  737 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  738 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  739 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  740 */           .addContainerGap()
/*  741 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  742 */             .addComponent(this.jLabel13, -1, -1, 32767)
/*  743 */             .addComponent(this.jLabel16, -1, -1, 32767))
/*  744 */           .addContainerGap(-1, 32767)));
/*  745 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  746 */     this.jPanel14.setLayout(jPanel14Layout);
/*  747 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  748 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  749 */         .addGap(0, 0, 32767));
/*  750 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  751 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  752 */         .addGap(0, 67, 32767));
/*  753 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/*  754 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  755 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  756 */     this.materialButton21.setMnemonic('C');
/*  757 */     this.materialButton21.setText("Cerrar");
/*  758 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/*  759 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  760 */     this.materialButton21.setHorizontalTextPosition(0);
/*  761 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  763 */             ProvTransferencias.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*  766 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  767 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  768 */     this.materialButton22.setMnemonic('G');
/*  769 */     this.materialButton22.setText("Guardar");
/*  770 */     this.materialButton22.setToolTipText("Guardar (Alt +G)");
/*  771 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  772 */     this.materialButton22.setHorizontalTextPosition(0);
/*  773 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  775 */             ProvTransferencias.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*  778 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  779 */     this.jPanel15.setLayout(jPanel15Layout);
/*  780 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/*  781 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  782 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/*  783 */           .addContainerGap(451, 32767)
/*  784 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  785 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  786 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/*  787 */           .addContainerGap()));
/*  788 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/*  789 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  790 */         .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  791 */         .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2));
/*  792 */     this.jLabel11.setText("Concepto");
/*  793 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  794 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  796 */             ProvTransferencias.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/*  799 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*  800 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  801 */     this.jPanel19.setLayout(jPanel19Layout);
/*  802 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  804 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  805 */           .addComponent(this.jLabel11, -2, 94, -2)
/*  806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */           .addComponent(this.jButton56)
/*  808 */           .addGap(0, 0, 32767))
/*  809 */         .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING));
/*  810 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  811 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  812 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  813 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  814 */             .addComponent(this.jButton56, -2, 26, -2)
/*  815 */             .addComponent(this.jLabel11, -1, -1, 32767))
/*  816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  817 */           .addComponent(this.jScrollPane1, -1, 53, 32767)
/*  818 */           .addContainerGap()));
/*  819 */     this.jPanel9.setLayout(new GridLayout(1, 3, 80, 0));
/*  820 */     this.jPanel12.setLayout(new GridLayout(3, 2, 0, 6));
/*  821 */     this.jLabel1.setHorizontalAlignment(2);
/*  822 */     this.jLabel1.setText("Folio");
/*  823 */     this.jPanel12.add(this.jLabel1);
/*  824 */     this.jPanel27.setLayout(new GridLayout(1, 2, 6, 0));
/*  825 */     this.jTextField5.setText("jTextField5");
/*  826 */     this.jTextField5.setEnabled(false);
/*  827 */     this.jPanel27.add(this.jTextField5);
/*  828 */     this.jSpinner1.setModel(new SpinnerNumberModel(1, 1, 500, 1));
/*  829 */     this.jPanel27.add(this.jSpinner1);
/*  830 */     this.jPanel12.add(this.jPanel27);
/*  831 */     this.jLabel3.setHorizontalAlignment(2);
/*  832 */     this.jLabel3.setText("A nombre de");
/*  833 */     this.jPanel12.add(this.jLabel3);
/*  834 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  835 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/*  836 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  838 */             ProvTransferencias.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  841 */     this.jPanel12.add(this.jComboBox4);
/*  842 */     this.jLabel6.setHorizontalAlignment(2);
/*  843 */     this.jLabel6.setText("Tipo");
/*  844 */     this.jPanel12.add(this.jLabel6);
/*  845 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  846 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  848 */             ProvTransferencias.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*  851 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  852 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/*  853 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  855 */             ProvTransferencias.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  858 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  859 */     this.jPanel26.setLayout(jPanel26Layout);
/*  860 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  862 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  863 */           .addComponent(this.jComboBox6, 0, 62, 32767)
/*  864 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  865 */           .addComponent(this.jButton58, -2, 18, -2)));
/*  866 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  867 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  868 */         .addComponent(this.jButton58, -1, -1, 32767)
/*  869 */         .addComponent(this.jComboBox6));
/*  870 */     this.jPanel12.add(this.jPanel26);
/*  871 */     this.jPanel9.add(this.jPanel12);
/*  872 */     this.jPanel16.setLayout(new GridLayout(3, 2, 0, 6));
/*  873 */     this.jLabel2.setHorizontalAlignment(2);
/*  874 */     this.jLabel2.setText("Fecha");
/*  875 */     this.jPanel16.add(this.jLabel2);
/*  876 */     this.jDateChooser6.setDate(this.fechaActual);
/*  877 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  878 */     this.jDateChooser6.setIcon(this.icon);
/*  879 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/*  880 */     this.jPanel16.add((Component)this.jDateChooser6);
/*  881 */     this.jLabel4.setHorizontalAlignment(2);
/*  882 */     this.jLabel4.setText("Otro");
/*  883 */     this.jPanel16.add(this.jLabel4);
/*  884 */     this.jTextField6.setText("jTextField6");
/*  885 */     this.jPanel16.add(this.jTextField6);
/*  886 */     this.jLabel7.setHorizontalAlignment(2);
/*  887 */     this.jLabel7.setText("Cuenta emisora");
/*  888 */     this.jPanel16.add(this.jLabel7);
/*  889 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  890 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNA..." }));
/*  891 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  893 */             ProvTransferencias.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  896 */     this.jPanel16.add(this.jComboBox7);
/*  897 */     this.jPanel9.add(this.jPanel16);
/*  898 */     this.jPanel18.setLayout(new GridLayout(3, 2, 0, 6));
/*  899 */     this.jPanel18.add(this.jLabel9);
/*  900 */     this.jPanel18.add(this.jLabel10);
/*  901 */     this.jLabel5.setHorizontalAlignment(2);
/*  902 */     this.jLabel5.setText("Gastos de");
/*  903 */     this.jPanel18.add(this.jLabel5);
/*  904 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  905 */     this.jComboBox5.setEditable(true);
/*  906 */     this.jPanel18.add(this.jComboBox5);
/*  907 */     this.jLabel8.setHorizontalAlignment(2);
/*  908 */     this.jLabel8.setText("Cuenta receptora");
/*  909 */     this.jPanel18.add(this.jLabel8);
/*  910 */     this.jTextField7.setText("jTextField7");
/*  911 */     this.jPanel18.add(this.jTextField7);
/*  912 */     this.jPanel9.add(this.jPanel18);
/*  913 */     this.jPanel20.setLayout(new GridLayout(1, 3, 80, 0));
/*  914 */     this.jPanel21.setLayout(new GridLayout(1, 2));
/*  915 */     this.jLabel12.setText("Importe");
/*  916 */     this.jPanel21.add(this.jLabel12);
/*  917 */     this.importe.setHorizontalAlignment(4);
/*  918 */     this.importe.setText("importe");
/*  919 */     this.jPanel21.add(this.importe);
/*  920 */     this.jPanel20.add(this.jPanel21);
/*  921 */     this.jPanel22.setLayout(new GridLayout(1, 3));
/*  922 */     this.jRadioButton1.setText("PC");
/*  923 */     this.jRadioButton1.setToolTipText("Por comprobar");
/*  924 */     this.jPanel22.add(this.jRadioButton1);
/*  925 */     this.jRadioButton3.setText("C");
/*  926 */     this.jRadioButton3.setToolTipText("Comprobado");
/*  927 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  929 */             ProvTransferencias.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  932 */     this.jPanel22.add(this.jRadioButton3);
/*  933 */     this.jRadioButton2.setText("SC");
/*  934 */     this.jRadioButton2.setToolTipText("Sin comprobante");
/*  935 */     this.jPanel22.add(this.jRadioButton2);
/*  936 */     this.jRadioButton4.setText("NA");
/*  937 */     this.jRadioButton4.setToolTipText("No aplica");
/*  938 */     this.jPanel22.add(this.jRadioButton4);
/*  939 */     this.jPanel20.add(this.jPanel22);
/*  940 */     this.jPanel23.setLayout(new GridLayout(1, 2, 6, 0));
/*  941 */     this.jLabel14.setText("Sucursal operativa");
/*  942 */     this.jPanel23.add(this.jLabel14);
/*  943 */     this.jPanel134.setBackground(new Color(255, 255, 255));
/*  944 */     this.jTextField25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  946 */             ProvTransferencias.this.jTextField25ActionPerformed(evt);
/*      */           }
/*      */         });
/*  949 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  950 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  952 */             ProvTransferencias.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/*  955 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/*  956 */     this.jPanel134.setLayout(jPanel134Layout);
/*  957 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/*  958 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  959 */         .addGroup(jPanel134Layout.createSequentialGroup()
/*  960 */           .addComponent(this.jTextField25)
/*  961 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  962 */           .addComponent(this.jButton57, -2, 18, -2)));
/*  963 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/*  964 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  965 */         .addComponent(this.jTextField25)
/*  966 */         .addComponent(this.jButton57, -1, -1, 32767));
/*  967 */     this.jPanel23.add(this.jPanel134);
/*  968 */     this.jPanel20.add(this.jPanel23);
/*  969 */     this.jLabel15.setText("Comentarios");
/*  970 */     this.jScrollPane2.setViewportView(this.jTextPane2);
/*  971 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  972 */     this.jPanel24.setLayout(jPanel24Layout);
/*  973 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  975 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  976 */           .addComponent(this.jLabel15, -2, 94, -2)
/*  977 */           .addGap(0, 582, 32767))
/*  978 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*  979 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  981 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  982 */           .addComponent(this.jLabel15)
/*  983 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  984 */           .addComponent(this.jScrollPane2, -1, 61, 32767)
/*  985 */           .addContainerGap()));
/*  986 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  987 */     this.jPanel1.setLayout(jPanel1Layout);
/*  988 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  990 */         .addComponent(this.jPanel14, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  991 */         .addComponent(this.jPanel15, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  992 */         .addComponent(this.jPanel13, -1, -1, 32767)
/*  993 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  994 */           .addGap(22, 22, 22)
/*  995 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  996 */             .addComponent(this.jPanel9, -2, 0, 32767)
/*  997 */             .addComponent(this.jPanel20, -2, 0, 32767)
/*  998 */             .addComponent(this.jPanel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  999 */             .addComponent(this.jPanel24, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1000 */           .addGap(20, 20, 20)));
/* 1001 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1002 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1003 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1004 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1006 */           .addComponent(this.jPanel9, -2, 83, -2)
/* 1007 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1008 */           .addComponent(this.jPanel19, -2, -1, -2)
/* 1009 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1010 */           .addComponent(this.jPanel20, -2, 25, -2)
/* 1011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1012 */           .addComponent(this.jPanel24, -2, -1, -2)
/* 1013 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1014 */           .addComponent(this.jPanel14, -1, -1, 32767)
/* 1015 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1016 */           .addComponent(this.jPanel15, -2, -1, -2)));
/* 1017 */     this.jDialog1.setTitle("Sucursales");
/* 1018 */     this.jDialog1.setUndecorated(true);
/* 1019 */     (new Object[2])[0] = null; (new Object[2])[1] = "Veracruz"; (new Object[2][])[0] = new Object[2]; (new Object[2])[0] = null; (new Object[2])[1] = "Poza Rica"; (new Object[2][])[1] = new Object[2]; (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[2]) {
/* 1020 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 1022 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1025 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1029 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1032 */     this.rSTableMetro2.setAltoHead(25);
/* 1033 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1034 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 1035 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1036 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1037 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1038 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1039 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1040 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1041 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1042 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1043 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 1044 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1045 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 1046 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 1047 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1048 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1049 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1051 */             ProvTransferencias.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1054 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1056 */             ProvTransferencias.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1059 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 1060 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/* 1061 */     this.jPanel135.setLayout(jPanel135Layout);
/* 1062 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/* 1063 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1064 */         .addComponent(this.jScrollPane32, -1, 418, 32767));
/* 1065 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/* 1066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1067 */         .addComponent(this.jScrollPane32, -1, 131, 32767));
/* 1068 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1069 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1070 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1071 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1072 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
/* 1073 */           .addGap(0, 0, 0)
/* 1074 */           .addComponent(this.jPanel135, -1, -1, 32767)));
/* 1075 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1076 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1077 */         .addComponent(this.jPanel135, -1, -1, 32767));
/* 1078 */     this.jDialog2.setTitle("Tipo de Póliza");
/* 1079 */     this.jDialog2.setUndecorated(true);
/* 1080 */     this.jPanel136.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/* 1081 */     (new String[2])[0] = "Num"; (new String[2])[1] = "Tipo"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1082 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1085 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1088 */     this.rSTableMetro3.setAltoHead(25);
/* 1089 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1090 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1091 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1092 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1093 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1094 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1095 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1096 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1097 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1098 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1099 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1100 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1101 */     this.rSTableMetro3.setShowHorizontalLines(false);
/* 1102 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1103 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1104 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1105 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1107 */             ProvTransferencias.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1110 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1112 */             ProvTransferencias.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1115 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/* 1116 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1117 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1119 */             ProvTransferencias.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1122 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1123 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1125 */             ProvTransferencias.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1128 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 1129 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1131 */             ProvTransferencias.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1134 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1135 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1136 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */         .addComponent(this.jScrollPane33, -1, 416, 32767)
/* 1139 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/* 1140 */           .addContainerGap(-1, 32767)
/* 1141 */           .addComponent(this.jButton53)
/* 1142 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1143 */           .addComponent(this.jButton54)
/* 1144 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1145 */           .addComponent(this.jButton55)
/* 1146 */           .addContainerGap()));
/* 1147 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1148 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1149 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1150 */           .addComponent(this.jScrollPane33, -1, 170, 32767)
/* 1151 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1152 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1153 */             .addComponent(this.jButton53, -2, 26, -2)
/* 1154 */             .addComponent(this.jButton54, -2, 26, -2)
/* 1155 */             .addComponent(this.jButton55, -2, 26, -2))));
/* 1156 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1157 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1158 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1160 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
/* 1161 */           .addGap(0, 0, 0)
/* 1162 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/* 1163 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1165 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1166 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1167 */           .addGap(0, 0, 0)));
/* 1168 */     this.jDialog3.setTitle("Nuevo Tipo");
/* 1169 */     this.jDialog3.setModal(true);
/* 1170 */     this.jLabel29.setText("Ingresa el nuevo tipo de transferencia:");
/* 1171 */     this.jTextField16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1173 */             ProvTransferencias.this.jTextField16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1176 */     this.jButton15.setMnemonic('C');
/* 1177 */     this.jButton15.setText("Cerrar");
/* 1178 */     this.jButton15.setToolTipText("Cerrar (Alt+C)");
/* 1179 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1181 */             ProvTransferencias.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1184 */     this.jButton16.setMnemonic('A');
/* 1185 */     this.jButton16.setText("Agregar");
/* 1186 */     this.jButton16.setToolTipText("Agregar (Alt+A)");
/* 1187 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1189 */             ProvTransferencias.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1192 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1193 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1194 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1195 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1196 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1197 */           .addContainerGap()
/* 1198 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1199 */             .addComponent(this.jTextField16)
/* 1200 */             .addComponent(this.jLabel29, -1, -1, 32767)
/* 1201 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1202 */               .addGap(0, 265, 32767)
/* 1203 */               .addComponent(this.jButton16, -2, 91, -2)
/* 1204 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1205 */               .addComponent(this.jButton15, -2, 91, -2)))
/* 1206 */           .addContainerGap()));
/* 1207 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1208 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1209 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1210 */           .addComponent(this.jLabel29, -2, 26, -2)
/* 1211 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1212 */           .addComponent(this.jTextField16, -2, -1, -2)
/* 1213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1214 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1215 */             .addComponent(this.jButton15)
/* 1216 */             .addComponent(this.jButton16))
/* 1217 */           .addContainerGap(-1, 32767)));
/* 1218 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1219 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1220 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1221 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1222 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1223 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 1224 */           .addGap(0, 0, 32767)));
/* 1225 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1227 */         .addComponent(this.jPanel31, -1, -1, 32767));
/* 1228 */     this.jDialog4.setTitle("Agregar datos");
/* 1229 */     this.jDialog4.setUndecorated(true);
/* 1230 */     (new String[2])[0] = "Num"; (new String[2])[1] = "Tipo"; this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1231 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1234 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1237 */     this.rSTableMetro4.setAltoHead(25);
/* 1238 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1239 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1240 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1241 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1242 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1243 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1244 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1245 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1246 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1247 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1248 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1249 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1250 */     this.rSTableMetro4.setShowHorizontalLines(false);
/* 1251 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 1252 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1253 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1254 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1256 */             ProvTransferencias.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1259 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1261 */             ProvTransferencias.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1264 */     this.jScrollPane34.setViewportView((Component)this.rSTableMetro4);
/* 1265 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/* 1266 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 1267 */     this.materialButton23.setMnemonic('A');
/* 1268 */     this.materialButton23.setText("Agregar");
/* 1269 */     this.materialButton23.setToolTipText("Agregar (Alt+A)");
/* 1270 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 1271 */     this.materialButton23.setHorizontalTextPosition(0);
/* 1272 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1274 */             ProvTransferencias.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1277 */     this.jLabel17.setText("Búsqueda por folio:");
/* 1278 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1280 */             ProvTransferencias.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/* 1283 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/* 1284 */     this.jLabel59.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1285 */     this.jLabel59.setForeground(this.lc.SECUNDARIO1);
/* 1286 */     this.jLabel59.setHorizontalAlignment(4);
/* 1287 */     this.jLabel59.setText("Total: ");
/* 1288 */     this.jPanel48.add(this.jLabel59);
/* 1289 */     this.jLabel49.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1290 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/* 1291 */     this.jLabel49.setHorizontalAlignment(2);
/* 1292 */     this.jLabel49.setText("t");
/* 1293 */     this.jPanel48.add(this.jLabel49);
/* 1294 */     GroupLayout jPanel137Layout = new GroupLayout(this.jPanel137);
/* 1295 */     this.jPanel137.setLayout(jPanel137Layout);
/* 1296 */     jPanel137Layout.setHorizontalGroup(jPanel137Layout
/* 1297 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1298 */         .addComponent(this.jScrollPane34, -1, 518, 32767)
/* 1299 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1300 */           .addContainerGap()
/* 1301 */           .addComponent(this.jLabel17, -2, 147, -2)
/* 1302 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1303 */           .addComponent(this.jTextField8)
/* 1304 */           .addContainerGap())
/* 1305 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1306 */           .addComponent(this.jPanel48, -2, 138, -2)
/* 1307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1308 */           .addComponent((Component)this.materialButton23, -2, 150, -2)));
/* 1309 */     jPanel137Layout.setVerticalGroup(jPanel137Layout
/* 1310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1311 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1312 */           .addContainerGap()
/* 1313 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1314 */             .addComponent(this.jLabel17)
/* 1315 */             .addComponent(this.jTextField8, -2, -1, -2))
/* 1316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1317 */           .addComponent(this.jScrollPane34, -1, 220, 32767)
/* 1318 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1319 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1320 */             .addComponent((Component)this.materialButton23, -1, 38, 32767)
/* 1321 */             .addComponent(this.jPanel48, -1, -1, 32767))));
/* 1322 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1323 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1324 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1325 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1326 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 1327 */           .addGap(0, 0, 0)
/* 1328 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1329 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1330 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1331 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1332 */           .addComponent(this.jPanel137, -1, -1, 32767)
/* 1333 */           .addGap(0, 0, 0)));
/* 1334 */     this.jDialog5.setTitle("Cancelar Póliza");
/* 1335 */     this.jDialog5.setModal(true);
/* 1336 */     this.jLabel125.setFont(new Font("Cantarell", 0, 11));
/* 1337 */     this.jLabel125.setHorizontalAlignment(4);
/* 1338 */     this.jLabel125.setText("Motivo");
/* 1339 */     this.jTextArea5.setColumns(20);
/* 1340 */     this.jTextArea5.setLineWrap(true);
/* 1341 */     this.jTextArea5.setRows(5);
/* 1342 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/* 1343 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1344 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1345 */     this.materialButton36.setMnemonic('C');
/* 1346 */     this.materialButton36.setText("Cerrar");
/* 1347 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1348 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1349 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1350 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1352 */             ProvTransferencias.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1355 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1356 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1357 */     this.materialButton37.setMnemonic('A');
/* 1358 */     this.materialButton37.setText("Cancelar");
/* 1359 */     this.materialButton37.setToolTipText("Cancelar Transferencia (Alt+A)");
/* 1360 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1361 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1362 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1364 */             ProvTransferencias.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1367 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1368 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1369 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1370 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1371 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1372 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1373 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 1374 */               .addComponent(this.jLabel125, -2, 64, -2)
/* 1375 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1376 */               .addComponent(this.jScrollPane18, -1, 328, 32767))
/* 1377 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1378 */               .addGap(0, 0, 32767)
/* 1379 */               .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1380 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1381 */               .addComponent((Component)this.materialButton36, -2, 105, -2)))
/* 1382 */           .addContainerGap()));
/* 1383 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1385 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1386 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1387 */             .addComponent(this.jLabel125)
/* 1388 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1389 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1390 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1391 */             .addComponent((Component)this.materialButton36, -2, 38, -2)
/* 1392 */             .addComponent((Component)this.materialButton37, -2, 38, -2))
/* 1393 */           .addContainerGap(-1, 32767)));
/* 1394 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1395 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1396 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1397 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1398 */         .addComponent(this.jPanel38, -1, -1, 32767));
/* 1399 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1400 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1401 */         .addComponent(this.jPanel38, -2, -1, -2));
/* 1402 */     this.jDialog6.setTitle("COnsecutivo Folio");
/* 1403 */     this.jDialog6.setModal(true);
/* 1404 */     (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[0] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[1] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[2] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[3] = new Object[4]; (new String[4])[0] = "Title 1"; (new String[4])[1] = "Title 2"; (new String[4])[2] = "Title 3"; (new String[4])[3] = "Title 4"; this.jTable1.setModel(new DefaultTableModel(new Object[4][], (Object[])new String[4]));
/* 1405 */     this.jScrollPane3.setViewportView(this.jTable1);
/* 1406 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1407 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1408 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1409 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1410 */         .addComponent(this.jScrollPane3, -1, 684, 32767));
/* 1411 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1413 */         .addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING, -1, 359, 32767));
/* 1414 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1415 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1416 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1418 */         .addComponent(this.jPanel29, -1, -1, 32767));
/* 1419 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1421 */         .addComponent(this.jPanel29, -1, -1, 32767));
/* 1422 */     this.cantidad.setText("jFormattedTextField2");
/* 1423 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 1424 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/* 1425 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 1426 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 1427 */     this.jLabel55.setHorizontalAlignment(0);
/* 1428 */     this.jLabel55.setText("Transferencias");
/* 1429 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/* 1430 */     this.jLabel233.setFont(new Font("Cantarell", 0, 11));
/* 1431 */     this.jLabel233.setHorizontalAlignment(4);
/* 1432 */     this.jLabel233.setText("Visualizando información de ");
/* 1433 */     this.jPanel7.setBackground(this.lc.SECUNDARIO2);
/* 1434 */     GridBagLayout jPanel7Layout = new GridBagLayout();
/* 1435 */     jPanel7Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/* 1436 */     jPanel7Layout.rowHeights = new int[] { 0 };
/* 1437 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1438 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1439 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1440 */     this.jDateChooser4.setIcon(this.icon);
/* 1441 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/* 1442 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 1443 */     gridBagConstraints.gridx = 4;
/* 1444 */     gridBagConstraints.gridy = 0;
/* 1445 */     gridBagConstraints.fill = 2;
/* 1446 */     gridBagConstraints.weightx = 1.0D;
/* 1447 */     this.jPanel7.add((Component)this.jDateChooser4, gridBagConstraints);
/* 1448 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1449 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1450 */     this.jDateChooser5.setIcon(this.icon);
/* 1451 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/* 1452 */     gridBagConstraints = new GridBagConstraints();
/* 1453 */     gridBagConstraints.gridx = 8;
/* 1454 */     gridBagConstraints.gridy = 0;
/* 1455 */     gridBagConstraints.fill = 2;
/* 1456 */     gridBagConstraints.weightx = 1.0D;
/* 1457 */     this.jPanel7.add((Component)this.jDateChooser5, gridBagConstraints);
/* 1458 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1459 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "MES", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/*      */ 
/*      */     
/* 1462 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1464 */             ProvTransferencias.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1467 */     gridBagConstraints = new GridBagConstraints();
/* 1468 */     gridBagConstraints.gridx = 0;
/* 1469 */     gridBagConstraints.gridy = 0;
/* 1470 */     this.jPanel7.add(this.jComboBox8, gridBagConstraints);
/* 1471 */     this.jLabel235.setFont(new Font("Cantarell", 0, 11));
/* 1472 */     this.jLabel235.setHorizontalAlignment(0);
/* 1473 */     this.jLabel235.setText("     al     ");
/* 1474 */     gridBagConstraints = new GridBagConstraints();
/* 1475 */     gridBagConstraints.gridx = 6;
/* 1476 */     gridBagConstraints.gridy = 0;
/* 1477 */     gridBagConstraints.fill = 2;
/* 1478 */     this.jPanel7.add(this.jLabel235, gridBagConstraints);
/* 1479 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1480 */     gridBagConstraints = new GridBagConstraints();
/* 1481 */     gridBagConstraints.gridx = 2;
/* 1482 */     gridBagConstraints.gridy = 0;
/* 1483 */     this.jPanel7.add(this.jComboBox9, gridBagConstraints);
/* 1484 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/* 1485 */     this.jPanel11.setLayout(new GridLayout(1, 4, 6, 0));
/* 1486 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1487 */     this.jButton1.setMnemonic('F');
/* 1488 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 1489 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1491 */             ProvTransferencias.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1494 */     this.jPanel11.add(this.jButton1);
/* 1495 */     this.jLabel170.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 1496 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 1497 */     this.jLabel170.setHorizontalAlignment(0);
/* 1498 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 1499 */     this.jLabel170.setToolTipText("Retroceder un día en la búsqueda");
/* 1500 */     this.jLabel170.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1502 */             ProvTransferencias.this.jLabel170MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1506 */             ProvTransferencias.this.jLabel170MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1510 */             ProvTransferencias.this.jLabel170MouseExited(evt);
/*      */           }
/*      */         });
/* 1513 */     this.jPanel11.add(this.jLabel170);
/* 1514 */     this.jLabel101.setFont(new Font("Tahoma", 2, 12));
/* 1515 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 1516 */     this.jLabel101.setHorizontalAlignment(0);
/* 1517 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 1518 */     this.jLabel101.setToolTipText("Clic para filtrar los datos de HOY");
/* 1519 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1521 */             ProvTransferencias.this.jLabel101MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1525 */             ProvTransferencias.this.jLabel101MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1529 */             ProvTransferencias.this.jLabel101MouseExited(evt);
/*      */           }
/*      */         });
/* 1532 */     this.jPanel11.add(this.jLabel101);
/* 1533 */     this.jLabel171.setHorizontalAlignment(0);
/* 1534 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 1535 */     this.jLabel171.setToolTipText("Aumentar un día en la búsqueda");
/* 1536 */     this.jLabel171.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1538 */             ProvTransferencias.this.jLabel171MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1542 */             ProvTransferencias.this.jLabel171MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1546 */             ProvTransferencias.this.jLabel171MouseExited(evt);
/*      */           }
/*      */         });
/* 1549 */     this.jPanel11.add(this.jLabel171);
/* 1550 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1551 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1552 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1553 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1554 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1555 */           .addContainerGap()
/* 1556 */           .addComponent(this.jLabel233, -2, 155, -2)
/* 1557 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1558 */           .addComponent(this.jPanel7, -2, 551, -2)
/* 1559 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1560 */           .addComponent(this.jPanel11, -2, 115, -2)
/* 1561 */           .addContainerGap(-1, 32767)));
/* 1562 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1563 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1564 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1565 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1566 */             .addComponent(this.jPanel11, -1, -1, 32767)
/* 1567 */             .addComponent(this.jLabel233, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1568 */             .addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1569 */           .addGap(0, 0, 32767)));
/* 1570 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1571 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1572 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1573 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1574 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1575 */           .addComponent(this.jLabel55)
/* 1576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1577 */           .addComponent(this.jPanel6, -1, -1, 32767)));
/* 1578 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1579 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1580 */         .addComponent(this.jPanel6, -1, -1, 32767)
/* 1581 */         .addComponent(this.jLabel55, -1, -1, 32767));
/* 1582 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1583 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 1584 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 1585 */     this.jPanel17.setLayout(new GridLayout(1, 8, 6, 0));
/* 1586 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1587 */     this.jComboBox3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1588 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO" }));
/* 1589 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1591 */             ProvTransferencias.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1594 */     this.jPanel17.add(this.jComboBox3);
/* 1595 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1597 */             ProvTransferencias.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1600 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1602 */             ProvTransferencias.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1605 */     this.jPanel17.add(this.jTextField1);
/* 1606 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1608 */             ProvTransferencias.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1611 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1613 */             ProvTransferencias.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1616 */     this.jPanel17.add(this.jTextField2);
/* 1617 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1619 */             ProvTransferencias.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1622 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1624 */             ProvTransferencias.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1627 */     this.jPanel17.add(this.jTextField3);
/* 1628 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1630 */             ProvTransferencias.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1633 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1635 */             ProvTransferencias.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1638 */     this.jPanel17.add(this.jTextField4);
/* 1639 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1640 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1641 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Aplicar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1642 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1644 */             ProvTransferencias.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1647 */     this.jPanel17.add(this.jComboBox2);
/* 1648 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1649 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1650 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "GASTOS POR SUCURSAL" }));
/* 1651 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1653 */             ProvTransferencias.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1656 */     this.jPanel17.add(this.jComboBox1);
/* 1657 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/* 1658 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/* 1659 */     this.jPanel3.setLayout(new GridLayout(1, 0, 6, 0));
/* 1660 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/* 1661 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/* 1662 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1663 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 1664 */     this.jLabel58.setHorizontalAlignment(4);
/* 1665 */     this.jLabel58.setText("Total: ");
/* 1666 */     this.jPanel47.add(this.jLabel58);
/* 1667 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1668 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 1669 */     this.jLabel48.setHorizontalAlignment(2);
/* 1670 */     this.jLabel48.setText("t");
/* 1671 */     this.jPanel47.add(this.jLabel48);
/* 1672 */     this.jPanel3.add(this.jPanel47);
/* 1673 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 1674 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1675 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1676 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1678 */         .addGap(0, 104, 32767));
/* 1679 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1680 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1681 */         .addGap(0, 36, 32767));
/* 1682 */     this.jPanel3.add(this.jPanel4);
/* 1683 */     this.jPanel5.setBackground(this.lc.SECUNDARIO2);
/* 1684 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1685 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1686 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1687 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1688 */         .addGap(0, 104, 32767));
/* 1689 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1691 */         .addGap(0, 36, 32767));
/* 1692 */     this.jPanel3.add(this.jPanel5);
/* 1693 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1694 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1695 */     this.jButton2.setMnemonic('N');
/* 1696 */     this.jButton2.setText("Nueva");
/* 1697 */     this.jButton2.setToolTipText("Nueva Cuenta (Alt + N)");
/* 1698 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1700 */             ProvTransferencias.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1703 */     this.jPanel3.add(this.jButton2);
/* 1704 */     this.jButton10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1705 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1706 */     this.jButton10.setMnemonic('M');
/* 1707 */     this.jButton10.setText("Modificar");
/* 1708 */     this.jButton10.setToolTipText("Modificar (Alt + M)");
/* 1709 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1711 */             ProvTransferencias.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1714 */     this.jPanel3.add(this.jButton10);
/* 1715 */     this.jButton11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1716 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1717 */     this.jButton11.setMnemonic('V');
/* 1718 */     this.jButton11.setText("Ver Detalle");
/* 1719 */     this.jButton11.setToolTipText("Ver Detalle (Alt+V)");
/* 1720 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1722 */             ProvTransferencias.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1725 */     this.jPanel3.add(this.jButton11);
/* 1726 */     this.jButton12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1727 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1728 */     this.jButton12.setMnemonic('C');
/* 1729 */     this.jButton12.setText("Cancelar");
/* 1730 */     this.jButton12.setToolTipText("Cancelar (Alt+C)");
/* 1731 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1733 */             ProvTransferencias.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1736 */     this.jPanel3.add(this.jButton12);
/* 1737 */     this.jButton13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1738 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1739 */     this.jButton13.setMnemonic('p');
/* 1740 */     this.jButton13.setText("Imprimir");
/* 1741 */     this.jButton13.setToolTipText("Imprimir (Alt+P)");
/* 1742 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1744 */             ProvTransferencias.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1747 */     this.jPanel3.add(this.jButton13);
/* 1748 */     this.jButton14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1749 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1750 */     this.jButton14.setMnemonic('G');
/* 1751 */     this.jButton14.setText("Guardar Reporte");
/* 1752 */     this.jButton14.setToolTipText("Guardar (Alt + G)");
/* 1753 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1755 */             ProvTransferencias.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1758 */     this.jPanel3.add(this.jButton14);
/* 1759 */     this.jPanel151.setBorder(BorderFactory.createBevelBorder(1));
/* 1760 */     this.jPanel151.setLayout(new GridLayout(1, 2, 12, 0));
/* 1761 */     this.jLabel221.setFont(new Font("Tahoma", 0, 10));
/* 1762 */     this.jLabel221.setHorizontalAlignment(4);
/* 1763 */     this.jLabel221.setText("TOTAL:");
/* 1764 */     this.jPanel151.add(this.jLabel221);
/* 1765 */     this.jLabel37.setFont(new Font("Tahoma", 1, 10));
/* 1766 */     this.jLabel37.setHorizontalAlignment(2);
/* 1767 */     this.jLabel37.setText("total");
/* 1768 */     this.jPanel151.add(this.jLabel37);
/* 1769 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1770 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1773 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1776 */     this.rSTableMetro1.setAltoHead(40);
/* 1777 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1778 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 1779 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1780 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 1781 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1782 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1783 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1784 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1785 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1786 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1787 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1788 */     this.rSTableMetro1.setRowHeight(18);
/* 1789 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1790 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 1791 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 1792 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1793 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1794 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1796 */             ProvTransferencias.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1799 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1801 */             ProvTransferencias.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1804 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/* 1805 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1806 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1807 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1809 */         .addComponent(this.jScrollPane13));
/* 1810 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1811 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1812 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1813 */           .addComponent(this.jScrollPane13, -1, 191, 32767)
/* 1814 */           .addContainerGap()));
/* 1815 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1816 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1817 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1819 */         .addComponent(this.jPanel3, -2, 989, 32767)
/* 1820 */         .addComponent(this.jPanel151, -2, 0, 32767)
/* 1821 */         .addComponent(this.jPanel25, -1, -1, 32767));
/* 1822 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1824 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1825 */           .addComponent(this.jPanel25, -1, -1, 32767)
/* 1826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1827 */           .addComponent(this.jPanel151, -2, -1, -2)
/* 1828 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1829 */           .addComponent(this.jPanel3, -2, 36, -2)
/* 1830 */           .addGap(8, 8, 8)));
/* 1831 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1832 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1833 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1834 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1835 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 1836 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 1837 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 1838 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1839 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1840 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1841 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 1842 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1843 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 1844 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1845 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/* 1846 */     GroupLayout layout = new GroupLayout(this);
/* 1847 */     setLayout(layout);
/* 1848 */     layout.setHorizontalGroup(layout
/* 1849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1850 */         .addGap(0, 989, 32767)
/* 1851 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1852 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/* 1853 */     layout.setVerticalGroup(layout
/* 1854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1855 */         .addGap(0, 340, 32767)
/* 1856 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1857 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1861 */     if (this.jTextField1.getText().equals(this.holderPoliza)) {
/* 1862 */       consultar();
/*      */     } else {
/* 1864 */       this.encontrado = this.con.consultar("fecha", "prov_transferencias", "where folio like '%" + this.jTextField1.getText() + "%' order by fecha desc");
/* 1865 */       String f = this.con.Campo;
/* 1866 */       if (this.encontrado) {
/* 1867 */         String año = f.substring(0, 4);
/* 1868 */         String mes = f.substring(5, 7);
/* 1869 */         String dia = f.substring(8, 10);
/* 1870 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1871 */         String strFecha = año + "-" + año + "-" + mes;
/* 1872 */         Date fecha = null;
/*      */         try {
/* 1874 */           fecha = formatoDelTexto.parse(strFecha);
/* 1875 */         } catch (ParseException ex) {
/* 1876 */           ex.printStackTrace();
/*      */         } 
/* 1878 */         this.jDateChooser4.setDate(fecha);
/* 1879 */         this.jDateChooser5.setDate(fecha);
/*      */       } 
/* 1881 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel170MouseClicked(MouseEvent evt) {
/* 1886 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 1887 */     int aa = fecha.get(1);
/* 1888 */     int mm = fecha.get(2);
/* 1889 */     int dd = fecha.get(5);
/* 1890 */     if (dd == 1) {
/* 1891 */       if (mm == 0) {
/* 1892 */         mm = 11;
/* 1893 */         aa--;
/*      */       } else {
/* 1895 */         mm--;
/*      */       } 
/* 1897 */       int diasTotal = diasDelMes(mm, aa);
/* 1898 */       dd = diasTotal;
/*      */     } else {
/* 1900 */       dd--;
/*      */     } 
/* 1902 */     mm++;
/* 1903 */     String año = "" + aa;
/* 1904 */     String mes = "" + mm;
/* 1905 */     String dia = "" + dd;
/* 1906 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1907 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1909 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1910 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1911 */     } catch (ParseException ex) {
/* 1912 */       ex.printStackTrace();
/*      */     } 
/* 1914 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel170MouseEntered(MouseEvent evt) {
/* 1918 */     this.jLabel170.setForeground(new Color(153, 255, 153));
/* 1919 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel170MouseExited(MouseEvent evt) {
/* 1923 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 1924 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseClicked(MouseEvent evt) {
/* 1928 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1929 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1930 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel101MouseEntered(MouseEvent evt) {
/* 1934 */     this.jLabel101.setForeground(new Color(153, 255, 153));
/* 1935 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseExited(MouseEvent evt) {
/* 1939 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 1940 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseClicked(MouseEvent evt) {
/* 1944 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 1945 */     calendar.setTime(this.jDateChooser4.getDate());
/* 1946 */     calendar.add(6, 1);
/* 1947 */     this.jDateChooser4.setCalendar(calendar);
/* 1948 */     this.jDateChooser5.setCalendar(calendar);
/* 1949 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel171MouseEntered(MouseEvent evt) {
/* 1953 */     this.jLabel171.setForeground(new Color(153, 255, 153));
/* 1954 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseExited(MouseEvent evt) {
/* 1958 */     this.jLabel171.setForeground(new Color(15, 87, 51));
/* 1959 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 1963 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA) {
/* 1964 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 1969 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1973 */     String cadena = this.jTextField1.getText();
/* 1974 */     if (!cadena.equals("")) {
/* 1975 */       if (this.presionado == null) {
/* 1976 */         this.presionado = new Presionado();
/* 1977 */         this.presionado.start();
/*      */       } else {
/* 1979 */         this.presionado.detenerFuera();
/* 1980 */         this.presionado = new Presionado();
/* 1981 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1984 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 1989 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1993 */     String cadena = this.jTextField2.getText();
/* 1994 */     if (!cadena.equals("")) {
/* 1995 */       if (this.presionado == null) {
/* 1996 */         this.presionado = new Presionado();
/* 1997 */         this.presionado.start();
/*      */       } else {
/* 1999 */         this.presionado.detenerFuera();
/* 2000 */         this.presionado = new Presionado();
/* 2001 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2004 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 2009 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2013 */     String cadena = this.jTextField3.getText();
/* 2014 */     if (!cadena.equals("")) {
/* 2015 */       if (this.presionado == null) {
/* 2016 */         this.presionado = new Presionado();
/* 2017 */         this.presionado.start();
/*      */       } else {
/* 2019 */         this.presionado.detenerFuera();
/* 2020 */         this.presionado = new Presionado();
/* 2021 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2024 */       this.jTextField3.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {
/* 2029 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 2033 */     String cadena = this.jTextField4.getText();
/* 2034 */     if (!cadena.equals("")) {
/* 2035 */       if (this.presionado == null) {
/* 2036 */         this.presionado = new Presionado();
/* 2037 */         this.presionado.start();
/*      */       } else {
/* 2039 */         this.presionado.detenerFuera();
/* 2040 */         this.presionado = new Presionado();
/* 2041 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2044 */       this.jTextField4.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2049 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2053 */     if (this.PRIMERA) {
/* 2054 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2059 */     folioInterno();
/* 2060 */     sacarNuevoInterno();
/* 2061 */     activar();
/* 2062 */     limpiarNuevo();
/* 2063 */     llenarSucursales();
/* 2064 */     limpiarTablaSuc();
/* 2065 */     if (!this.entraNueva) {
/* 2066 */       this.entraNueva = true;
/* 2067 */       llenarCuentas();
/* 2068 */       llenarProveedores();
/* 2069 */       llenarPersonas();
/*      */     } 
/* 2071 */     sacarTransferenciaMayor();
/* 2072 */     this.materialButton22.setText("Guardar");
/* 2073 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 2074 */     this.jLabel13.setText("Nueva Transferencia");
/* 2075 */     this.fichas.addTab("Nueva Transferencia", this.jPanel1);
/* 2076 */     this.fichas.setSelectedIndex(2);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2080 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2081 */     if (indice < 0) {
/* 2082 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2084 */       if (!this.entraNueva) {
/* 2085 */         this.entraNueva = true;
/* 2086 */         llenarCuentas();
/* 2087 */         llenarProveedores();
/* 2088 */         llenarPersonas();
/*      */       } 
/* 2090 */       llenarSucursales();
/* 2091 */       limpiarTablaSuc();
/* 2092 */       this.ACTIVARSUC = "";
/* 2093 */       verTransferencia();
/* 2094 */       activar();
/* 2095 */       String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2096 */       for (String v : sucursales) {
/* 2097 */         selecTablaSucursal(v);
/*      */       }
/* 2099 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2100 */       this.jTextField25.setToolTipText(suc);
/* 2101 */       if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2102 */         this.jTextField25.setEnabled(true);
/* 2103 */         this.jTextField25.setText("");
/* 2104 */         this.jButton57.setEnabled(true);
/*      */       } 
/* 2106 */       this.jLabel13.setText("Información de la Transferencia: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/* 2107 */       this.materialButton22.setVisible(true);
/* 2108 */       this.materialButton22.setText("Modificar");
/* 2109 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 2110 */       this.fichas.addTab("Modificar Transferencia: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10)), this.jPanel1);
/* 2111 */       this.fichas.setSelectedIndex(2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2116 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2117 */     if (indice < 0) {
/* 2118 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una transferencia para ver la información", "Selecciona una transferencia", 0, this.ADVER);
/*      */     } else {
/* 2120 */       verTransferenciaFicha();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2125 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2126 */     if (indice < 0) {
/* 2127 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una transferencia para poder cancelar", "Selecciona una transferencia", 0, this.ADVER);
/*      */     } else {
/* 2129 */       String v = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2130 */       if (v.equals("<Por Aplicar>")) {
/* 2131 */         this.jTextArea5.setText("");
/* 2132 */         this.jDialog5.setTitle("Cancelar Transferencia: " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 10)));
/* 2133 */         this.jDialog5.setVisible(true);
/*      */       } else {
/* 2135 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar ésta transferencia porque su estatus no es '<Por Aplicar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 2142 */       String fechaCompleta = "";
/* 2143 */       if (this.jComboBox8.getSelectedIndex() == 0) {
/* 2144 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2145 */         String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 2146 */         String año = cadenaFecha1.substring(0, 4);
/* 2147 */         String mes = cadenaFecha1.substring(4, 6);
/* 2148 */         String dia = cadenaFecha1.substring(6, 8);
/* 2149 */         fechaCompleta = dia + "/" + dia + "/" + mes;
/* 2150 */         cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 2151 */         año = cadenaFecha1.substring(0, 4);
/* 2152 */         mes = cadenaFecha1.substring(4, 6);
/* 2153 */         dia = cadenaFecha1.substring(6, 8);
/* 2154 */         fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/*      */       } else {
/* 2156 */         fechaCompleta = String.valueOf(this.jComboBox8.getSelectedItem()) + "/" + String.valueOf(this.jComboBox8.getSelectedItem());
/*      */       } 
/* 2158 */       String tipo = "GENERAL";
/* 2159 */       if (!this.jComboBox3.getSelectedItem().toString().equals("TIPO")) {
/* 2160 */         tipo = this.jComboBox3.getSelectedItem().toString();
/*      */       }
/* 2162 */       String cuenta = "GENERAL";
/* 2163 */       if (!this.jTextField2.getText().equals(this.holderCuenta)) {
/* 2164 */         cuenta = this.jTextField2.getText().toUpperCase();
/*      */       }
/* 2166 */       String beneficiario = "GENERAL";
/* 2167 */       if (!this.jTextField3.getText().equals(this.holderBeneficiario)) {
/* 2168 */         beneficiario = this.jTextField3.getText().toUpperCase();
/*      */       }
/* 2170 */       String concepto = "GENERAL";
/* 2171 */       if (!this.jTextField4.getText().equals(this.holderConcepto)) {
/* 2172 */         concepto = this.jTextField4.getText().toUpperCase();
/*      */       }
/* 2174 */       String base = "GENERAL";
/* 2175 */       if (!this.jComboBox1.getSelectedItem().toString().equals("GASTOS POR SUCURSAL")) {
/* 2176 */         base = this.jComboBox1.getSelectedItem().toString();
/*      */       }
/* 2178 */       String sicret = "LOGO.jpg";
/* 2179 */       String forsis = "forsis100x.jpg";
/* 2180 */       JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "Folio", "Fecha", "Importe", "Cuenta1", "Cuenta2", "Beneficiario", "Concepto", "Tipo", "Sucursal", "Comp" });
/* 2181 */       Map<Object, Object> datos = new HashMap<>();
/* 2182 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 2183 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 2184 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 2185 */       datos.put("periodo", fechaCompleta);
/* 2186 */       datos.put("tipo", tipo);
/* 2187 */       datos.put("cuenta", cuenta);
/* 2188 */       datos.put("beneficiario", beneficiario);
/* 2189 */       datos.put("concepto", concepto);
/* 2190 */       datos.put("base", base);
/* 2191 */       datos.put("TTotal", this.jLabel37.getText());
/* 2192 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 2193 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_TransferenciasGral.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 2194 */       JasperViewer visor = new JasperViewer(print, false);
/* 2195 */       visor.setTitle("Transferencias");
/* 2196 */       visor.setIconImage(this.iconoImprimir);
/* 2197 */       visor.setZoomRatio(0.59F);
/* 2198 */       visor.setExtendedState(6);
/* 2199 */       visor.setVisible(true);
/* 2200 */     } catch (JRException e) {
/* 2201 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2206 */     String[] datos = { "#", "FECHA", "IMPORTE", "ORIGEN", "DESTINO", "BENEFICIARIO", "CONCEPTO", "TIPO", "SUCURSAL", "COMPROBANTE", "FOLIO", "ESTADO", "ACTUALIZO (dd/mm/aaaa)" };
/*      */ 
/*      */     
/* 2209 */     this.esc = new EscribirReporte("TRANSFERENCIAS", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2213 */     if (evt.getClickCount() == 2) {
/* 2214 */       verTransferenciaFicha();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 2222 */     if (evt.getClickCount() == 2) {
/* 2223 */       this.jComboBox6.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/* 2224 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 2232 */     this.jTextField16.setText("");
/* 2233 */     this.jButton16.setText("Agregar");
/* 2234 */     this.jButton16.setMnemonic('A');
/* 2235 */     this.jButton16.setToolTipText("Agregar Tipo (Alt+A)");
/* 2236 */     this.jDialog3.setTitle("Nuevo Tipo");
/* 2237 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 2241 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 2242 */     if (ind < 0) {
/* 2243 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un tipo de cheque", 0, this.ADVER);
/*      */     } else {
/* 2245 */       this.jButton16.setText("Modificar");
/* 2246 */       this.jButton16.setMnemonic('M');
/* 2247 */       this.jButton16.setToolTipText("Modificar tipo (Alt+M)");
/* 2248 */       this.jTextField16.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 2249 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 2254 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 2255 */     if (ind < 0) {
/* 2256 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 2258 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas eleiminar el tipo de cheque que seleccionaste?", "Eliminar tipo", 0, 3, this.PREG);
/* 2259 */       if (res == 0) {
/* 2260 */         this.con.eliminar2("prov_cheques_cat_tipo", "where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2261 */         llenarTipo();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField16ActionPerformed(ActionEvent evt) {
/* 2267 */     agregarTipo();
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2271 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2275 */     agregarTipo();
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jLabel16MouseClicked(MouseEvent evt) {
/* 2285 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 2286 */     this.fichas.remove(2);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseEntered(MouseEvent evt) {
/* 2290 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel16MouseExited(MouseEvent evt) {
/* 2294 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 2298 */     this.fichas.removeTabAt(2);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 2302 */     if (this.materialButton22.getText().equals("Imprimir")) {
/* 2303 */       imprimirTransferencia();
/*      */     } else {
/* 2305 */       String interno = "";
/* 2306 */       int i = Integer.parseInt(this.jSpinner1.getValue().toString());
/* 2307 */       if (i < 10) {
/* 2308 */         interno = "00" + i;
/* 2309 */       } else if (i < 100) {
/* 2310 */         interno = "0" + i;
/*      */       } else {
/* 2312 */         interno = "" + i;
/*      */       } 
/* 2314 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2315 */       String actualizo = this.USUARIO + this.USUARIO;
/* 2316 */       if (this.jDateChooser6.getDate() == null) {
/* 2317 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la fecha de la transferencia", "Falta fecha", 0, this.ERROR);
/* 2318 */         this.jDateChooser6.setDate(new Date());
/* 2319 */       } else if (this.jComboBox4.getSelectedIndex() == 0) {
/* 2320 */         this.error.cargarError(this.jComboBox4, "050");
/* 2321 */       } else if (this.jComboBox4.getSelectedItem().equals("OTRO...") && this.jTextField6.getText().equals("")) {
/* 2322 */         this.error.cargarError(this.jTextField6, "050");
/* 2323 */       } else if (this.jComboBox6.getSelectedIndex() == 0) {
/* 2324 */         this.error.cargarError(this.jComboBox6, "050");
/* 2325 */       } else if (this.jComboBox7.getSelectedIndex() == 0) {
/* 2326 */         this.error.cargarError(this.jComboBox7, "050");
/* 2327 */       } else if (this.jTextField7.getText().equals("")) {
/* 2328 */         this.error.cargarError(this.jTextField7, "050");
/* 2329 */       } else if (this.jTextPane1.getText().equals("")) {
/* 2330 */         this.error.cargarError(this.jTextPane1, "050");
/* 2331 */       } else if (this.importe.getText().equals("$0.00")) {
/* 2332 */         this.error.cargarError(this.importe, "050");
/* 2333 */       } else if (suc.equals("")) {
/* 2334 */         this.jTextField25.setBackground(Color.RED);
/* 2335 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la sucursal operativa\nPor lo menos debe estar seleccionada una sucursal.", "Falta sucursal operativa", 0, this.ADVER);
/* 2336 */       } else if (!this.val.validarTexto(this.jTextField6, this.jTextField6.getText(), "018") && 
/* 2337 */         !this.val.validarTexto(this.jTextField7, this.jTextField7.getText(), "018")) {
/* 2338 */         if (this.importe.getText().contains("-")) {
/* 2339 */           this.error.cargarError(this.importe, "063");
/* 2340 */         } else if (!this.val.validarTexto(this.jTextPane2, this.jTextPane2.getText(), "014")) {
/* 2341 */           DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 2342 */           ZoneId defaultZoneId = ZoneId.systemDefault();
/* 2343 */           Instant instant = this.jDateChooser6.getDate().toInstant();
/* 2344 */           LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 2345 */           String fechaTransql = fechaTrans.format(formatoFecha);
/* 2346 */           String beneficiario = this.jComboBox4.getSelectedItem().toString();
/* 2347 */           int numProv = 0;
/* 2348 */           if (this.jComboBox4.getSelectedItem().equals("OTRO...")) {
/* 2349 */             beneficiario = this.jTextField6.getText().toUpperCase();
/*      */           } else {
/* 2351 */             int indiceProv = this.jComboBox4.getSelectedIndex();
/* 2352 */             numProv = ((Proveedores)this.PROVEEDORES.get(indiceProv - 1)).getNumProv();
/* 2353 */             beneficiario = ((Proveedores)this.PROVEEDORES.get(indiceProv - 1)).getRazonSocial();
/*      */           } 
/* 2355 */           String comprobante = "PC";
/* 2356 */           if (this.jRadioButton3.isSelected()) {
/* 2357 */             comprobante = "C";
/*      */           }
/* 2359 */           if (this.jRadioButton2.isSelected()) {
/* 2360 */             comprobante = "SC";
/*      */           }
/* 2362 */           if (this.jRadioButton4.isSelected()) {
/* 2363 */             comprobante = "N/A";
/*      */           }
/* 2365 */           int cuenta = this.jComboBox7.getSelectedIndex();
/* 2366 */           cuenta--;
/* 2367 */           String fact = "";
/* 2368 */           for (Object v : this.FACTURASAGREGADAS.toArray()) {
/* 2369 */             fact = fact + ", " + fact;
/*      */           }
/* 2371 */           if (this.materialButton22.getText().equals("Guardar")) {
/* 2372 */             String[] campos = { "Transferencia", "Fecha de la transferencia", "Beneficiario", "Gastos de", "Tipo de Transferencia", "Cuenta Emisora", "Cuenta Receptora", "Concepto", "Importe", "Comprobante", "Sucursal Operativa" };
/*      */ 
/*      */ 
/*      */             
/* 2376 */             String[] info = { this.jTextField5.getText().toUpperCase() + "-" + this.jTextField5.getText().toUpperCase(), fechaTransql, beneficiario, this.jComboBox5.getSelectedItem().toString(), this.jComboBox6.getSelectedItem().toString(), this.jComboBox7.getSelectedItem().toString(), this.jTextField7.getText().toUpperCase(), this.jTextPane1.getText().toUpperCase(), this.importe.getText(), comprobante, suc };
/*      */             
/* 2378 */             int res = this.error.cargarDatos(campos, info);
/* 2379 */             if (res == 0) {
/* 2380 */               boolean estaOcupado = buscarInterno(interno);
/* 2381 */               res = 3;
/* 2382 */               if (estaOcupado) {
/* 2383 */                 res = JOptionPane.showConfirmDialog(this.padre, "<html>El folio interno:<b> " + String.valueOf(this.jSpinner1.getValue()) + "</b> ya se encuentra registrado<p>¿Deseas actualizar los folios siguientes a ese número?</html>", "Folio interno duplicado", 1, 3, this.PREG);
/* 2384 */                 if (res == 0) {
/* 2385 */                   remplazarInterno(interno);
/*      */                 }
/*      */               } 
/* 2388 */               if (res != 2 && res != -1) {
/* 2389 */                 this.con.inserSinMsj("insert into prov_transferencias (folio, fecha, tipo,cuentaOrigen, cuentaDestino, beneficiario,concepto, facturasAmparadas, importe,comprobante, motivoCancelacion, comentarioGral,estado, gastosDe, sucOp,usuario, numProv, folioMensual) values ('" + this.jTextField5
/* 2390 */                     .getText().toUpperCase() + "', '" + fechaTransql + "', '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "', '" + ((Cuentas)this.CUENTAS
/* 2391 */                     .get(cuenta)).getCuentacorta() + "', '" + this.jTextField7.getText().toUpperCase() + "', '" + beneficiario + "', '" + this.jTextPane1
/* 2392 */                     .getText().toUpperCase() + "', '" + fact + "', '" + this.importe.getText() + "', '" + comprobante + "','','" + this.jTextPane2
/* 2393 */                     .getText().toUpperCase() + "', '<Por Aplicar>', '" + 
/* 2394 */                     String.valueOf(this.jComboBox5.getSelectedItem()) + "', '" + suc + "','" + actualizo + "', " + numProv + ", '" + interno + "')");
/* 2395 */                 this.fichas.removeTabAt(2);
/* 2396 */                 consultar();
/* 2397 */                 this.mensajeTry.guardarConf("Se ha capturado un nueva transferencia, usuario: " + this.USUARIO, "Nueva transferencia (" + beneficiario + ")", "INFO", "Cuentasporpagar");
/*      */               } 
/*      */             } 
/* 2400 */           } else if (this.materialButton22.getText().equals("Modificar")) {
/* 2401 */             String[] campos = { "Transferencia", "Fecha de la transferencia", "Beneficiario", "Gastos de", "Tipo de Transferencia", "Cuenta Emisora", "Cuenta Receptora", "Concepto", "Importe", "Comprobante", "Sucursal Operativa" };
/*      */ 
/*      */ 
/*      */             
/* 2405 */             String[] info = { this.jTextField5.getText().toUpperCase() + "-" + this.jTextField5.getText().toUpperCase(), fechaTransql, beneficiario, this.jComboBox5.getSelectedItem().toString(), this.jComboBox6.getSelectedItem().toString(), this.jComboBox7.getSelectedItem().toString(), this.jTextField7.getText().toUpperCase(), this.jTextPane1.getText().toUpperCase(), this.importe.getText(), comprobante, suc };
/*      */             
/* 2407 */             int res = this.error.cargarDatos(campos, info);
/* 2408 */             if (res == 0) {
/* 2409 */               folioInterno();
/* 2410 */               eliminarFolioInterno();
/* 2411 */               res = 3;
/* 2412 */               boolean estaOcupado = buscarInterno(interno);
/* 2413 */               if (estaOcupado) {
/* 2414 */                 res = JOptionPane.showConfirmDialog(this.padre, "<html>El folio interno:<b> " + String.valueOf(this.jSpinner1.getValue()) + "</b> ya se encuentra registrado<p>¿Deseas actualizar los folios siguientes a ese número?</html>", "Folio interno duplicado", 1, 3, this.PREG);
/* 2415 */                 if (res == 0) {
/* 2416 */                   remplazarInterno(interno);
/*      */                 }
/*      */               } 
/* 2419 */               if (res != 2 && res != -1) {
/* 2420 */                 this.con.inserSinMsj("update prov_transferencias set  fecha = '" + fechaTransql + "', tipo ='" + 
/* 2421 */                     String.valueOf(this.jComboBox6.getSelectedItem()) + "', cuentaOrigen='" + ((Cuentas)this.CUENTAS.get(cuenta)).getCuentacorta() + "',  cuentaDestino = '" + this.jTextField7
/* 2422 */                     .getText().toUpperCase() + "', beneficiario='" + beneficiario + "', concepto='" + this.jTextPane1.getText().toUpperCase() + "',  importe ='" + this.importe
/* 2423 */                     .getText() + "', comprobante='" + comprobante + "', comentarioGral='" + this.jTextPane2.getText().toUpperCase() + "',  gastosDe='" + 
/* 2424 */                     String.valueOf(this.jComboBox5.getSelectedItem()) + "', sucOp='" + suc + "', numProv = " + numProv + ", folioMensual='" + interno + "' where folio='" + this.jTextField5
/* 2425 */                     .getText() + "'");
/* 2426 */                 this.fichas.removeTabAt(2);
/* 2427 */                 consultar();
/* 2428 */                 this.mensajeTry.guardarConf("Se ha modificado una póliza de cheque, usuario: " + this.USUARIO, "Póliza modificada (Núm:" + this.jTextField7.getText() + ")", "ADVER", "Cuentasporpagar");
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 2438 */     Dimension di = this.jButton56.getSize();
/* 2439 */     Point p = this.jButton56.getLocationOnScreen();
/* 2440 */     String t = this.jComboBox6.getSelectedItem().toString();
/* 2441 */     consultarDatoExtra();
/* 2442 */     this.jDialog4.setLocation(p.x + di.width + 10, p.y + 0);
/* 2443 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jTextField25ActionPerformed(ActionEvent evt) {
/* 2450 */     String v = this.jTextField25.getText().toUpperCase();
/* 2451 */     if (!this.TODOS_SUCURSALES.contains(v)) {
/* 2452 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has ingresado una sucursal que no se encuentra registrada.", "Sucursal Incorrecta", 0, this.ERROR);
/* 2453 */       this.jTextField25.setText("");
/*      */     } else {
/* 2455 */       selecTablaSucursal(v);
/* 2456 */       JOptionPane.showMessageDialog(this.padre, "Los datos también se visualizarán en la sucursal de: " + v, "Visualizando datos en otra sucursal", 0, this.INFO);
/* 2457 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2458 */       this.jTextField25.setToolTipText(suc);
/* 2459 */       this.jTextField25.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 2464 */     Dimension di = this.jButton57.getSize();
/* 2465 */     Point p = this.jButton57.getLocationOnScreen();
/* 2466 */     this.jDialog1.setLocation(p.x + di.width - this.jDialog1.getWidth(), p.y + 30);
/* 2467 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2474 */     if (!this.jComboBox4.getSelectedItem().equals("SELECCIONA UNO...")) {
/* 2475 */       if (this.jComboBox4.getSelectedItem().equals("OTRO...")) {
/* 2476 */         this.jTextField6.setEnabled(true);
/* 2477 */         this.jTextField6.setText("");
/* 2478 */         this.jTextField7.setText("");
/*      */       } else {
/* 2480 */         int selec = this.jComboBox4.getSelectedIndex();
/* 2481 */         if (this.PROVEEDORES.size() > 0) {
/* 2482 */           String cuenta = ((Proveedores)this.PROVEEDORES.get(selec - 1)).getCuenta();
/* 2483 */           if (cuenta.length() > 4) {
/* 2484 */             this.jTextField7.setText(cuenta.substring(cuenta.length() - 4, cuenta.length()));
/*      */           } else {
/* 2486 */             this.jTextField7.setText(((Proveedores)this.PROVEEDORES.get(selec - 1)).getCuenta());
/*      */           } 
/*      */         } 
/* 2489 */         this.jTextField6.setText("");
/* 2490 */         this.jTextField6.setEnabled(false);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 2496 */     Dimension di = this.jButton58.getSize();
/* 2497 */     Point p = this.jButton58.getLocationOnScreen();
/* 2498 */     this.jDialog2.setLocation(p.x + di.width - 200, p.y + 30);
/* 2499 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2503 */     if (this.jComboBox6.getItemCount() > 0) {
/* 2504 */       this.FACTURASAGREGADAS = new ArrayList<>();
/* 2505 */       String t = this.jComboBox6.getSelectedItem().toString();
/* 2506 */       if (t.equals("FACILIDAD ADMINISTRATIVA") || t.equals("DEVOLUCIONES AL CLIENTE") || t.equals("MOVIMIENTO ENTRE CUENTAS")) {
/* 2507 */         this.jRadioButton2.setSelected(true);
/*      */       } else {
/* 2509 */         this.jRadioButton1.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 2515 */     if (evt.getClickCount() == 2) {
/* 2516 */       agregarDato();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 2524 */     int indice = this.rSTableMetro4.getSelectedRow();
/* 2525 */     if (indice < 0) {
/* 2526 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas seleccionar un registro para agregar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2528 */       agregarDato();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/* 2533 */     consultarDatoExtra();
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 2537 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 2541 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2545 */     int v = this.jComboBox8.getSelectedIndex();
/* 2546 */     if (v == 0) {
/* 2547 */       this.jDateChooser4.setEnabled(true);
/* 2548 */       this.jDateChooser5.setEnabled(true);
/* 2549 */       this.jComboBox9.setEnabled(false);
/*      */     } else {
/* 2551 */       this.jDateChooser4.setEnabled(false);
/* 2552 */       this.jDateChooser5.setEnabled(false);
/* 2553 */       this.jComboBox9.setEnabled(true);
/*      */     } 
/* 2555 */     if (this.PRIMERA) {
/* 2556 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   public void remplazarInterno(String interno) {
/* 2561 */     for (int i = this.jTable1.getRowCount(); i > this.INDICEREMPLAZAR; i--) {
/*      */       String ni;
/* 2563 */       int nuevoInterno = Integer.parseInt(this.jTable1.getValueAt(i - 1, 1).toString());
/* 2564 */       nuevoInterno++;
/* 2565 */       if (nuevoInterno < 10) {
/* 2566 */         ni = "00" + nuevoInterno;
/* 2567 */       } else if (nuevoInterno < 100) {
/* 2568 */         ni = "0" + nuevoInterno;
/*      */       } else {
/* 2570 */         ni = "" + nuevoInterno;
/*      */       } 
/* 2572 */       this.con.inserSinMsj("update prov_transferencias set folioMensual ='" + ni + "' where folio = '" + String.valueOf(this.jTable1.getValueAt(i - 1, 0)) + "'");
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean buscarInterno(String interno) {
/* 2577 */     boolean esta = false;
/* 2578 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2579 */       String v = this.jTable1.getValueAt(i, 1).toString();
/* 2580 */       if (v.equals(interno)) {
/* 2581 */         this.INDICEREMPLAZAR = i;
/* 2582 */         esta = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 2586 */     return esta;
/*      */   }
/*      */   
/*      */   public void eliminarFolioInterno() {
/* 2590 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2591 */       String folio = this.jTable1.getValueAt(i, 0).toString();
/* 2592 */       if (folio.equals(this.jTextField5.getText())) {
/* 2593 */         DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 2594 */         temp.removeRow(i);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int mesActual() {
/* 2600 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 2601 */     Instant instant = (new Date()).toInstant();
/* 2602 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 2603 */     return fechaTrans.getMonthValue();
/*      */   }
/*      */   
/*      */   public int añoActual() {
/* 2607 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 2608 */     Instant instant = (new Date()).toInstant();
/* 2609 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 2610 */     return fechaTrans.getYear();
/*      */   }
/*      */   
/*      */   public void folioInterno() {
/* 2614 */     int mm = mesActual();
/* 2615 */     int aa = añoActual();
/*      */     
/* 2617 */     (new String[3])[0] = "Folio"; (new String[3])[1] = "Interno"; (new String[3])[2] = "Fecha"; this.jTable1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(3, "folio, folioMensual, fecha", "prov_transferencias", "where date_format(fecha, '%m-%Y') = '" + mm + "-" + aa + "' and sucOP = '" + (String)this.CAMPOSGENERALES
/* 2618 */             .get("sucursal") + "' order by folioMensual asc"), (Object[])new String[3]) {
/* 2619 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2622 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void sacarNuevoInterno() {
/* 2628 */     int reg = 0;
/* 2629 */     String interno = "";
/* 2630 */     if (this.jTable1.getRowCount() > 0) {
/* 2631 */       interno = this.jTable1.getValueAt(this.jTable1.getRowCount() - 1, 1).toString();
/* 2632 */       reg = Integer.parseInt(interno);
/*      */     } 
/* 2634 */     reg++;
/* 2635 */     this.jSpinner1.setValue(Integer.valueOf(reg));
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 2639 */     Object[] Columnas = columnas;
/* 2640 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 2641 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 2642 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 2643 */         if (j == 0) {
/* 2644 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 2646 */         if (j == 1) {
/* 2647 */           registros[i][1] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 2649 */         if (j == 2) {
/* 2650 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 2652 */         if (j == 3) {
/* 2653 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 2655 */         if (j == 4) {
/* 2656 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 2658 */         if (j == 5) {
/* 2659 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 2661 */         if (j == 6) {
/* 2662 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 2664 */         if (j == 7) {
/* 2665 */           registros[i][7] = Original.getValueAt(i, j);
/*      */         }
/* 2667 */         if (j == 8) {
/* 2668 */           registros[i][8] = Original.getValueAt(i, j);
/*      */         }
/* 2670 */         if (j == 9) {
/* 2671 */           registros[i][9] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 2675 */     JTable aux = new JTable(registros, Columnas);
/* 2676 */     return aux;
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 2680 */     String fechaCorta = fecha.substring(0, 10);
/* 2681 */     String año = fechaCorta.substring(0, 4);
/* 2682 */     String mes = fechaCorta.substring(5, 7);
/* 2683 */     String dia = fechaCorta.substring(8, 10);
/* 2684 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 2685 */     return strFecha;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2689 */     String motivo = this.jTextArea5.getText();
/* 2690 */     if (motivo.equals("")) {
/* 2691 */       this.jTextArea5.setBackground(Color.RED);
/* 2692 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar el motivo de cancelación a la transferencia", "Ingresa un comentario", 0, this.ERROR);
/*      */     } else {
/* 2694 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas cancelar la transferencia que seleccionaste?", "Cancelar Transferencia", 0, 3, this.PREG);
/* 2695 */       if (res == 0) {
/* 2696 */         String actualizo = this.USUARIO + this.USUARIO;
/* 2697 */         String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10));
/* 2698 */         this.con.inserSinMsj("update prov_transferencias set estado='<Cancelada>', motivoCancelacion ='" + this.jTextArea5.getText().toUpperCase() + "',usuario='" + actualizo + "', importe='$0.00' where folio='" + num + "'");
/* 2699 */         if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2700 */           DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro1.getModel();
/* 2701 */           temp.removeRow(this.rSTableMetro1.getSelectedRow());
/* 2702 */           this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 2703 */           this.jLabel37.setText("$0.00");
/* 2704 */           calcularTotales();
/*      */         } else {
/* 2706 */           consultar();
/*      */         } 
/* 2708 */         this.jDialog5.setVisible(false);
/* 2709 */         this.mensajeTry.guardarConf("Se canceluna transferencia de cheque, USUARIO: " + this.USUARIO, " Cancelada (" + num + ")", "ERROR", "Cuentasporpagar");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verTransferenciaFicha() {
/* 2715 */     if (!this.entraNueva) {
/* 2716 */       this.entraNueva = true;
/* 2717 */       llenarCuentas();
/* 2718 */       llenarProveedores();
/* 2719 */       llenarPersonas();
/*      */     } 
/* 2721 */     llenarSucursales();
/* 2722 */     limpiarTablaSuc();
/* 2723 */     this.ACTIVARSUC = "";
/* 2724 */     verTransferencia();
/* 2725 */     this.jButton56.setEnabled(false);
/* 2726 */     this.jButton57.setEnabled(false);
/* 2727 */     this.jTextField6.setEnabled(false);
/* 2728 */     this.jDateChooser6.setEnabled(false);
/* 2729 */     String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2730 */     for (String v : sucursales) {
/* 2731 */       selecTablaSucursal(v);
/*      */     }
/* 2733 */     String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2734 */     this.jTextField25.setToolTipText(suc);
/* 2735 */     this.materialButton22.setText("Imprimir");
/* 2736 */     this.materialButton22.setToolTipText("Imprimir (Alt + P)");
/* 2737 */     this.materialButton22.setMnemonic('P');
/* 2738 */     this.fichas.addTab("Transferencia: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10).toString(), this.jPanel1);
/* 2739 */     this.jLabel13.setText("Información de la Transferencia: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10).toString());
/* 2740 */     this.fichas.setSelectedIndex(2);
/*      */   }
/*      */   
/*      */   public void verTransferencia() {
/* 2744 */     limpiarNuevo();
/* 2745 */     desactivar();
/* 2746 */     String[] datos = this.con.regresaReg("folio, fecha, tipo, cuentaOrigen, cuentaDestino,  beneficiario, concepto, facturasAmparadas, importe, comprobante,   motivoCancelacion, comentarioGral, gastosDe, sucOp, numProv, folioMensual", "prov_transferencias", "where folio= '" + 
/* 2747 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 10)) + "'", 16);
/* 2748 */     this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(datos[15])));
/* 2749 */     DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 2750 */     LocalDate fechaLocal = LocalDate.parse(datos[1].substring(0, 10), formateador);
/* 2751 */     this.jTextField5.setText(datos[0]);
/* 2752 */     this.jDateChooser6.setDate(Date.valueOf(fechaLocal));
/* 2753 */     this.jComboBox6.setSelectedItem(datos[2]);
/* 2754 */     this.CUENTAS.stream().filter(c -> c.getCuentacorta().equals(datos[3])).map(c -> c.getCuentacorta() + " " + c.getCuentacorta()).forEach(c -> this.jComboBox7.setSelectedItem(c));
/* 2755 */     if (datos[14].equals("0")) {
/* 2756 */       this.jComboBox4.setSelectedItem("OTRO...");
/* 2757 */       this.jTextField6.setText(datos[5]);
/*      */     } else {
/* 2759 */       this.PROVEEDORES.stream().filter(p -> (p.getNumProv() == Integer.parseInt(datos[14]))).map(p -> p.getNombreComercial()).forEach(p -> this.jComboBox4.setSelectedItem(p));
/*      */     } 
/* 2761 */     this.jTextField7.setText(datos[4]);
/* 2762 */     this.jTextPane1.setText(datos[6]);
/* 2763 */     this.importe.setValue(Double.valueOf(convertirCantTexto(datos[8])));
/* 2764 */     if (datos[9].equals("PC")) {
/* 2765 */       this.jRadioButton1.setSelected(true);
/* 2766 */     } else if (datos[9].equals("C")) {
/* 2767 */       this.jRadioButton3.setSelected(true);
/* 2768 */     } else if (datos[9].equals("SC")) {
/* 2769 */       this.jRadioButton2.setSelected(true);
/* 2770 */     } else if (datos[9].equals("N/A")) {
/* 2771 */       this.jRadioButton4.setSelected(true);
/*      */     } 
/* 2773 */     this.jTextPane2.setText(datos[11]);
/* 2774 */     this.jComboBox5.setSelectedItem(datos[12]);
/* 2775 */     this.ACTIVARSUC = datos[13];
/* 2776 */     this.jTextField25.setText(datos[13].substring(0, 8) + "...");
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 2780 */     this.jSpinner1.setEnabled(false);
/* 2781 */     this.jTextField5.setEnabled(false);
/* 2782 */     this.jTextField6.setEnabled(false);
/* 2783 */     this.jDateChooser6.setEnabled(false);
/* 2784 */     this.jComboBox4.setEnabled(false);
/* 2785 */     this.jButton58.setEnabled(false);
/* 2786 */     this.jComboBox6.setEnabled(false);
/* 2787 */     this.jComboBox7.setEnabled(false);
/* 2788 */     this.jTextField7.setEnabled(false);
/* 2789 */     this.jTextPane1.setEnabled(false);
/* 2790 */     this.jTextPane2.setEnabled(false);
/* 2791 */     this.importe.setEnabled(false);
/* 2792 */     this.jRadioButton1.setEnabled(false);
/* 2793 */     this.jRadioButton2.setEnabled(false);
/* 2794 */     this.jRadioButton3.setEnabled(false);
/* 2795 */     this.jRadioButton4.setEnabled(false);
/* 2796 */     this.jTextField25.setEnabled(false);
/* 2797 */     this.jComboBox5.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void agregarDato() {
/* 2801 */     String t = this.jComboBox6.getSelectedItem().toString();
/* 2802 */     String c = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0).toString();
/* 2803 */     String v = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString();
/* 2804 */     String coma = "";
/* 2805 */     if (!this.jTextPane1.getText().equals("")) {
/* 2806 */       coma = ", ";
/*      */     }
/* 2808 */     if (t.equals("PAGO DE FINIQUITO")) {
/* 2809 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "FINIQUITO: " + coma);
/* 2810 */     } else if (t.equals("PAGO DE VACACIONES")) {
/* 2811 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "VACACIONES: " + coma);
/* 2812 */     } else if (this.FACTURASAGREGADAS.contains(c + "-" + c)) {
/* 2813 */       JOptionPane.showMessageDialog(this.padre, "La factura que deseas agregar ya se encuentra almacenada, verifica tu información", "Factura agregada", 0, this.ERROR);
/*      */     } else {
/* 2815 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "FACTURA: " + coma);
/* 2816 */       this.FACTURASAGREGADAS.add(c + "-" + c);
/* 2817 */       this.jRadioButton3.setSelected(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 2822 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 2823 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 2824 */     String fecha = formatter.format(fechaHoy);
/* 2825 */     return " (" + fecha + ")";
/*      */   }
/*      */   
/*      */   public void consultarDatoExtra() {
/* 2829 */     String t = this.jComboBox6.getSelectedItem().toString();
/* 2830 */     String v = this.jTextField8.getText();
/* 2831 */     String campos = "";
/* 2832 */     String tabla = "";
/* 2833 */     String condicion = "";
/* 2834 */     String[] titulos = null;
/* 2835 */     String[][] matriz = null;
/* 2836 */     if (t.equals("PAGO DE FINIQUITO")) {
/* 2837 */       campos = "num, folio_fini, fecha, empleado, total_imss";
/* 2838 */       tabla = "finiquitos_regis";
/* 2839 */       condicion = "where ( estatus='<Por Pagar>' || estatus like '%<Pagado%' || estatus like '%<Abono%' || estatus like '%<Autorizado%') and folio_fini like '%" + v + "%' order by fecha desc";
/* 2840 */       titulos = new String[] { "Num", "Folio", "Fecha", "Empleado", "Total" };
/* 2841 */       matriz = this.con2.buscarDatos(5, campos, tabla, condicion);
/* 2842 */     } else if (t.equals("PAGO DE VACACIONES")) {
/* 2843 */       campos = "num_vaca, folio_vaca, fecha, trabajador, total";
/* 2844 */       tabla = "vacaciones_regis";
/* 2845 */       condicion = "where ( estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%' || estatus like '%<Autorizada%') and folio_vaca like '%" + v + "%' order by fecha desc";
/* 2846 */       titulos = new String[] { "Num", "Folio", "Fecha", "Empleado", "Total" };
/* 2847 */       matriz = this.con2.buscarDatos(5, campos, tabla, condicion);
/*      */     } else {
/* 2849 */       String nombreComercial = "";
/* 2850 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 2851 */         nombreComercial = this.jComboBox4.getSelectedItem().toString();
/*      */       }
/* 2853 */       campos = "prov_tarjetadeudor.mov, prov_tarjetadeudor.factura, prov_tarjetadeudor.fecha, prov_proveedores.nombreComercial, prov_tarjetadeudor.importeRestanteLetra";
/* 2854 */       tabla = "prov_tarjetadeudor, prov_proveedores";
/* 2855 */       condicion = "where prov_tarjetadeudor.numProv = prov_proveedores.numProv and (prov_tarjetadeudor.estatus='<Por Pagar>' || prov_tarjetadeudor.estatus like '%<Abono') and prov_tarjetadeudor.factura like '%" + v + "%' " + getConsultaSuc() + " and prov_proveedores.nombreComercial like '%" + nombreComercial + "%' order by prov_tarjetadeudor.fecha, prov_tarjetadeudor.factura, prov_proveedores.nombreComercial";
/* 2856 */       titulos = new String[] { "Mov", "Folio", "Fecha Factura", "Proveedor", "Debe" };
/* 2857 */       matriz = this.con.buscarDatos(5, campos, tabla, condicion);
/*      */     } 
/* 2859 */     this.rSTableMetro4.setModel(new DefaultTableModel((Object[][])matriz, (Object[])titulos) {
/* 2860 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2863 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2866 */     this.jLabel49.setText("" + this.rSTableMetro4.getRowCount());
/* 2867 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 2868 */     this.rSTableMetro4.setSelectionMode(0);
/* 2869 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 2870 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 2871 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 2872 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(40);
/* 2873 */     this.rSTableMetro4.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 2874 */     this.rSTableMetro4.getColumnModel().getColumn(4).setMaxWidth(90);
/* 2875 */     this.rSTableMetro4.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 2876 */     this.rSTableMetro4.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 2877 */     this.rSTableMetro4.getColumnModel().getColumn(2).setCellRenderer(this.celda1);
/* 2878 */     this.rSTableMetro4.getColumnModel().getColumn(3).setCellRenderer(this.celda1);
/* 2879 */     this.rSTableMetro4.getColumnModel().getColumn(4).setCellRenderer(this.celda1);
/* 2880 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public String dameSucursalOp(JTextField campo, JTable tabla) {
/* 2884 */     String sucursales = "";
/* 2885 */     boolean entra = false;
/* 2886 */     if (campo.isEditable()) {
/* 2887 */       for (int i = 0; i < tabla.getRowCount(); i++) {
/* 2888 */         boolean selec = ((Boolean)tabla.getValueAt(i, 0)).booleanValue();
/* 2889 */         if (selec) {
/* 2890 */           sucursales = sucursales + " " + sucursales + ",";
/* 2891 */           entra = true;
/*      */         } 
/*      */       } 
/* 2894 */       if (entra) {
/* 2895 */         sucursales = sucursales.substring(1, sucursales.length() - 1);
/*      */       } else {
/* 2897 */         sucursales = "";
/*      */       } 
/*      */     } else {
/* 2900 */       sucursales = campo.getText().toUpperCase();
/*      */     } 
/* 2902 */     return sucursales;
/*      */   }
/*      */   
/*      */   public int separarFolioMax(String folio) {
/* 2906 */     int num = 0;
/* 2907 */     String n = "";
/* 2908 */     char[] cadena = folio.toCharArray();
/* 2909 */     for (int i = 0; i < cadena.length; i++) {
/* 2910 */       if (Character.isDigit(cadena[i])) {
/* 2911 */         n = n + n;
/*      */       }
/*      */     } 
/* 2914 */     return Integer.parseInt(n);
/*      */   }
/*      */   
/*      */   public void sacarTransferenciaMayor() {
/* 2918 */     int MAYOR = 0;
/* 2919 */     this.encontrado = this.con.consultar("folio", "prov_transferencias", "where num=(select max(num) from prov_transferencias where sucOp = '" + (String)this.CAMPOSGENERALES.get("sucursal") + "') order by fecha desc ");
/* 2920 */     if (this.encontrado) {
/* 2921 */       MAYOR = separarFolioMax(this.con.Campo);
/* 2922 */       MAYOR++;
/*      */     } else {
/* 2924 */       MAYOR++;
/*      */     } 
/* 2926 */     if (MAYOR < 100) {
/* 2927 */       this.jTextField5.setText((String)this.CAMPOSGENERALES.get("directiva") + "000" + (String)this.CAMPOSGENERALES.get("directiva"));
/* 2928 */     } else if (MAYOR < 1000) {
/* 2929 */       this.jTextField5.setText((String)this.CAMPOSGENERALES.get("directiva") + "00" + (String)this.CAMPOSGENERALES.get("directiva"));
/* 2930 */     } else if (MAYOR < 10000) {
/* 2931 */       this.jTextField5.setText((String)this.CAMPOSGENERALES.get("directiva") + "0" + (String)this.CAMPOSGENERALES.get("directiva"));
/*      */     } else {
/* 2933 */       this.jTextField5.setText((String)this.CAMPOSGENERALES.get("directiva") + (String)this.CAMPOSGENERALES.get("directiva"));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarPersonas() {
/* 2938 */     String suc = getPrivilegiosSuc();
/* 2939 */     String[][] DATOS = this.con.buscarDatos(1, "beneficiario", "prov_transferencias", "where sucOp like '%" + suc + "%'");
/* 2940 */     for (String[] d : DATOS) {
/* 2941 */       agregarCampo(this.TODOS_OTROBENEFICIARIO, d[0]);
/*      */     }
/* 2943 */     this.com_OtroBeneficiario = new TextAutoCompleter(this.jTextField6, this.TODOS_OTROBENEFICIARIO);
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 2947 */     if (!datos.contains(valor)) {
/* 2948 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarCuentas() {
/* 2953 */     String[][] cuentas = this.con.buscarDatos(4, "numCuenta, bancoCorto, cuenta, cuentaCorta", "prov_cuentasbancarias", " where estado ='ACTIVA' " + getConsultaSuc() + " order by cuentaCorta");
/* 2954 */     for (String[] c : cuentas) {
/* 2955 */       this.CUENTAS.add(new Cuentas(Integer.parseInt(c[0]), c[1], c[2], c[3]));
/*      */     }
/* 2957 */     this.CUENTAS.forEach(c -> this.jComboBox7.addItem(c.getCuentacorta() + " " + c.getCuentacorta()));
/*      */   }
/*      */   
/*      */   public void llenarProveedores() {
/* 2961 */     String[][] proveedores = this.con.buscarDatos(5, "numProv, razonSocial, nombreComercial, clabe, cuenta", "prov_proveedores", " where estado ='ACTIVO' " + getConsultaSuc() + " order by nombreComercial");
/* 2962 */     for (String[] p : proveedores) {
/* 2963 */       this.PROVEEDORES.add(new Proveedores(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4]));
/*      */     }
/* 2965 */     this.PROVEEDORES.forEach(p -> this.jComboBox4.addItem(p.getNombreComercial()));
/* 2966 */     this.jComboBox4.addItem("OTRO...");
/*      */   }
/*      */   
/*      */   public void limpiarTablaSuc() {
/* 2970 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2971 */       this.jTextField25.setText("");
/* 2972 */       this.jTextField25.setEnabled(true);
/* 2973 */       this.jButton57.setEnabled(true);
/*      */     } else {
/* 2975 */       this.jTextField25.setEnabled(false);
/* 2976 */       this.jTextField25.setText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2977 */       this.jButton57.setEnabled(false);
/*      */     } 
/* 2979 */     this.jTextField25.setToolTipText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2980 */     selecTablaSucursal(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void selecTablaSucursal(String suc) {
/* 2984 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 2985 */       String columna = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 2986 */       if (columna.equals(suc)) {
/* 2987 */         this.rSTableMetro2.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarSucursales() {
/* 2993 */     this.TODOS_SUCURSALES = new ArrayList();
/* 2994 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 2995 */     Object[][] Object = new Object[lista.size()][2];
/* 2996 */     Iterator<String> it = lista.iterator();
/* 2997 */     while (it.hasNext()) {
/* 2998 */       String v = it.next();
/* 2999 */       this.TODOS_SUCURSALES.add(v);
/* 3000 */       Object[lista.indexOf(v)][0] = Boolean.valueOf(false);
/* 3001 */       Object[lista.indexOf(v)][1] = v;
/*      */     } 
/* 3003 */     llenarTablaSuc(Object);
/*      */   }
/*      */   
/*      */   public void llenarTablaSuc(Object[][] arrayOfObject) {
/* 3007 */     (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(arrayOfObject, (Object[])new String[2]) {
/* 3008 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 3010 */           boolean[] canEdit = new boolean[] { true, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3013 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3017 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3020 */     this.rSTableMetro2.setAltoHead(25);
/* 3021 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3022 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3023 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3024 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3025 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3026 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3027 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3028 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3029 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3030 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3031 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3032 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3033 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 3034 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 3035 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3036 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3037 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3039 */             ProvTransferencias.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3042 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3044 */             ProvTransferencias.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3047 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 3048 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 3049 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 3050 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3051 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/* 3053 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3054 */     this.rSTableMetro2.setSelectionMode(0);
/* 3055 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void limpiarNuevo() {
/* 3059 */     this.jTextField5.setText("");
/* 3060 */     this.jTextField6.setText("");
/* 3061 */     this.jTextField6.setEnabled(false);
/* 3062 */     this.jDateChooser6.setDate(new Date());
/* 3063 */     this.jComboBox4.setSelectedIndex(0);
/* 3064 */     this.jComboBox6.setSelectedIndex(0);
/* 3065 */     this.jComboBox7.setSelectedIndex(0);
/* 3066 */     this.jTextField7.setText("");
/* 3067 */     this.jTextPane1.setText("");
/* 3068 */     this.jTextPane2.setText("");
/* 3069 */     this.importe.setValue(Integer.valueOf(0));
/* 3070 */     this.jRadioButton1.setSelected(true);
/* 3071 */     this.jTextField25.setText(this.CAMPOSGENERALES.get("sucursal"));
/* 3072 */     this.jComboBox5.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public String getPrivilegiosSuc() {
/* 3076 */     String priv = "";
/* 3077 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO")) {
/* 3078 */       priv = "";
/*      */     } else {
/* 3080 */       priv = this.CAMPOSGENERALES.get("sucursal");
/*      */     } 
/* 3082 */     return priv;
/*      */   }
/*      */   
/*      */   public String getConsultaSuc() {
/* 3086 */     String consulta = " and sucOp like '%" + getPrivilegiosSuc() + "%' ";
/* 3087 */     return consulta;
/*      */   }
/*      */   
/*      */   public void activar() {
/* 3091 */     this.jComboBox4.setEnabled(true);
/* 3092 */     this.jComboBox5.setEnabled(true);
/* 3093 */     this.jComboBox6.setEnabled(true);
/* 3094 */     this.jButton56.setEnabled(true);
/* 3095 */     this.jButton58.setEnabled(true);
/* 3096 */     this.jComboBox7.setEnabled(true);
/* 3097 */     this.jTextField7.setEnabled(true);
/* 3098 */     this.jTextPane1.setEnabled(true);
/* 3099 */     this.importe.setEnabled(true);
/* 3100 */     this.jRadioButton1.setEnabled(true);
/* 3101 */     this.jRadioButton2.setEnabled(true);
/* 3102 */     this.jRadioButton3.setEnabled(true);
/* 3103 */     this.jRadioButton4.setEnabled(true);
/* 3104 */     this.jSpinner1.setEnabled(true);
/* 3105 */     this.jTextPane2.setEnabled(true);
/* 3106 */     if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR") || ((String)this.CAMPOSGENERALES.get("priv")).equals("RECURSOS HUMANOS")) {
/* 3107 */       this.jDateChooser6.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 3112 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 3113 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 3114 */     Iterator<String> it = lista.iterator();
/* 3115 */     while (it.hasNext()) {
/* 3116 */       String v = it.next();
/* 3117 */       this.jComboBox1.addItem(v);
/* 3118 */       this.jComboBox5.addItem(v);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarTipo() {
/* 3123 */     String t = this.jTextField16.getText().toUpperCase();
/* 3124 */     if (existeTipo(this.jTextField16.getText().toUpperCase())) {
/* 3125 */       this.jTextField16.setBackground(Color.RED);
/* 3126 */       JOptionPane.showMessageDialog(this.jDialog3, "El tipo de cheque que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Tipo ya existe", 0, this.ADVER);
/* 3127 */     } else if (this.jButton16.getText().equals("Agregar")) {
/* 3128 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas agregar nuevo tipo de cheque?", "Agregar nuevo tipo", 0, 3, this.PREG);
/* 3129 */       if (res == 0) {
/* 3130 */         this.con.inserSinMsj("insert into prov_cheques_cat_tipo (tipo) values('" + this.jTextField16.getText().toUpperCase() + "')");
/* 3131 */         llenarTipo();
/* 3132 */         this.jComboBox6.setSelectedItem(t);
/* 3133 */         this.jDialog3.setVisible(false);
/* 3134 */         this.jDialog2.setVisible(false);
/*      */       } 
/*      */     } else {
/* 3137 */       this.con.inserSinMsj("update prov_cheques_cat_tipo set tipo = '" + this.jTextField16.getText().toUpperCase() + "' where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 3138 */       this.rSTableMetro3.setValueAt(this.jTextField16.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 3139 */       llenarTipo();
/* 3140 */       this.jComboBox6.setSelectedItem(t);
/* 3141 */       this.jDialog3.setVisible(false);
/* 3142 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean existeTipo(String buscar) {
/* 3147 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3148 */       String comp = this.rSTableMetro3.getValueAt(i, 1).toString();
/* 3149 */       if (comp.equals(buscar)) {
/* 3150 */         return true;
/*      */       }
/*      */     } 
/* 3153 */     return false;
/*      */   }
/*      */   
/*      */   public void imprimirTransferencia() {
/*      */     try {
/* 3158 */       String prov = "";
/* 3159 */       String comprobante = "";
/* 3160 */       if (this.jComboBox4.getSelectedItem().equals("OTRO...")) {
/* 3161 */         prov = this.jTextField6.getText();
/*      */       } else {
/* 3163 */         prov = ((Proveedores)this.PROVEEDORES.get(this.jComboBox4.getSelectedIndex() - 1)).getRazonSocial();
/*      */       } 
/* 3165 */       if (this.jRadioButton1.isSelected()) {
/* 3166 */         comprobante = "POR COMPROBAR";
/* 3167 */       } else if (this.jRadioButton2.isSelected()) {
/* 3168 */         comprobante = "SIN COMPROBANTE";
/*      */       } else {
/* 3170 */         comprobante = "COMPROBADO";
/*      */       } 
/* 3172 */       String sicret = "LOGO.jpg";
/* 3173 */       String forsis = "forsis100x.jpg";
/* 3174 */       Map<Object, Object> datos = new HashMap<>();
/* 3175 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 3176 */       datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_mat"));
/* 3177 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 3178 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 3179 */       datos.put("parameter1", this.jTextField5.getText());
/* 3180 */       datos.put("parameter2", getFechaddMMaaaa(this.jDateChooser6.getDate()));
/* 3181 */       datos.put("parameter3", prov);
/* 3182 */       datos.put("parameter4", this.jComboBox6.getSelectedItem());
/* 3183 */       datos.put("parameter5", this.jComboBox7.getSelectedItem());
/* 3184 */       datos.put("parameter6", this.jTextField7.getText());
/* 3185 */       datos.put("parameter7", this.jTextPane1.getText().toUpperCase());
/* 3186 */       datos.put("parameter8", this.importe.getText());
/* 3187 */       datos.put("parameter9", comprobante);
/* 3188 */       datos.put("parameter10", this.jTextPane2.getText().toUpperCase());
/* 3189 */       JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_TransferenciaIndividual.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 3190 */       JasperViewer visor = new JasperViewer(reporte, false);
/* 3191 */       visor.setTitle("Reporte Individual de Transferencia");
/* 3192 */       visor.setIconImage(this.iconoImprimir);
/* 3193 */       visor.setZoomRatio(0.59F);
/* 3194 */       visor.setExtendedState(6);
/* 3195 */       visor.setVisible(true);
/* 3196 */     } catch (JRException e) {
/* 3197 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getFechaddMMaaaa(Date fechita) {
/* 3202 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3203 */     String cadenaFecha1 = formato.format(fechita);
/* 3204 */     String año = cadenaFecha1.substring(0, 4);
/* 3205 */     String mes = cadenaFecha1.substring(4, 6);
/* 3206 */     String dia = cadenaFecha1.substring(6, 8);
/* 3207 */     return dia + "/" + dia + "/" + mes;
/*      */   }
/*      */   
/*      */   public void llenarTipo() {
/* 3211 */     this.jComboBox3.removeAllItems();
/* 3212 */     this.jComboBox6.removeAllItems();
/* 3213 */     this.jComboBox3.addItem("TIPO");
/* 3214 */     this.jComboBox6.addItem("SELECCIONA UNO...");
/*      */     
/* 3216 */     (new String[2])[0] = "Núm"; (new String[2])[1] = "Tipo"; this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "numTipo, tipo", "prov_cheques_cat_tipo", "order by tipo"), (Object[])new String[2]) {
/* 3217 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3220 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3223 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3224 */       String v = this.rSTableMetro3.getValueAt(i, 1).toString();
/* 3225 */       this.TIPOS.put(Integer.valueOf(i), v);
/* 3226 */       this.jComboBox3.addItem(v);
/* 3227 */       this.jComboBox6.addItem(v);
/*      */     } 
/* 3229 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 3230 */     this.rSTableMetro3.setSelectionMode(0);
/* 3231 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 3232 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 3233 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 3234 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(90);
/* 3235 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 3236 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3237 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3241 */     this.pintar.colorear(this.jSpinner1);
/* 3242 */     this.pintar.colorear(this.jTextField1);
/* 3243 */     this.pintar.colorear(this.jTextField2);
/* 3244 */     this.pintar.colorear(this.jTextField3);
/* 3245 */     this.pintar.colorear(this.jTextField4);
/* 3246 */     this.pintar.colorear(this.jComboBox1);
/* 3247 */     this.pintar.colorear(this.jComboBox2);
/* 3248 */     this.pintar.colorear(this.jComboBox3);
/* 3249 */     this.pintar.colorear(this.jTextField5);
/* 3250 */     this.pintar.colorear(this.jComboBox4);
/* 3251 */     this.pintar.colorear(this.jTextField6);
/* 3252 */     this.pintar.colorear(this.jComboBox5);
/* 3253 */     this.pintar.colorear(this.jComboBox6);
/* 3254 */     this.pintar.colorear(this.jComboBox7);
/* 3255 */     this.pintar.colorear(this.jComboBox8);
/* 3256 */     this.pintar.colorear(this.jComboBox9);
/* 3257 */     this.pintar.colorear(this.jTextField7);
/* 3258 */     this.pintar.colorear(this.jTextPane1);
/* 3259 */     this.pintar.colorear(this.importe);
/* 3260 */     this.pintar.colorear(this.jTextPane2);
/* 3261 */     this.pintar.colorear(this.jTextArea5);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3265 */     this.PRIMERA = true;
/* 3266 */     String fechaCompleta1 = "";
/* 3267 */     String fechaCompleta2 = "";
/* 3268 */     String consultaFecha = "";
/* 3269 */     String ordenado = "";
/* 3270 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/* 3271 */       Date fecha1 = this.jDateChooser4.getDate();
/* 3272 */       Date fecha2 = this.jDateChooser5.getDate();
/* 3273 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3274 */       String cadenaFecha = "";
/* 3275 */       cadenaFecha = formato.format(fecha1);
/* 3276 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3277 */       String MES = cadenaFecha.substring(4, 6);
/* 3278 */       String DIA = cadenaFecha.substring(6, 8);
/* 3279 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3280 */       cadenaFecha = formato.format(fecha2);
/* 3281 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3282 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3283 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3284 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 3285 */       consultaFecha = " fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/* 3286 */       ordenado = " order by folio desc";
/*      */     } else {
/* 3288 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */ 
/*      */       
/* 3291 */       int aa = Integer.parseInt(this.jComboBox9.getSelectedItem().toString());
/* 3292 */       consultaFecha = " date_format(fecha, '%m-%Y') = '" + mes[this.jComboBox8.getSelectedIndex()] + "-" + aa + "' ";
/* 3293 */       ordenado = " order by folioMensual asc";
/*      */     } 
/* 3295 */     String folio = "";
/* 3296 */     if (!this.jTextField1.getText().equals(this.holderPoliza)) {
/* 3297 */       folio = this.jTextField1.getText();
/*      */     }
/* 3299 */     String cuenta = "";
/* 3300 */     if (!this.jTextField2.getText().equals(this.holderCuenta)) {
/* 3301 */       cuenta = this.jTextField2.getText();
/*      */     }
/* 3303 */     String beneficiario = "";
/* 3304 */     if (!this.jTextField3.getText().equals(this.holderBeneficiario)) {
/* 3305 */       beneficiario = this.jTextField3.getText();
/*      */     }
/* 3307 */     String concepto = "";
/* 3308 */     if (!this.jTextField4.getText().equals(this.holderConcepto)) {
/* 3309 */       concepto = this.jTextField4.getText();
/*      */     }
/* 3311 */     String sucursalForsis = "";
/* 3312 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3313 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 3315 */     String estado = " estado='<Por Aplicar>' || estado like '%<Pagada%' || estado like '%<Abono%' || estado like '%<Aplicada%'";
/* 3316 */     if (this.jComboBox2.getSelectedIndex() == 1) {
/* 3317 */       estado = " estado like '%%'";
/* 3318 */     } else if (this.jComboBox2.getSelectedIndex() == 2) {
/* 3319 */       estado = " estado ='<Por Aplicar>'";
/* 3320 */     } else if (this.jComboBox2.getSelectedIndex() == 3) {
/* 3321 */       estado = " estado like '%<Pagada%'";
/* 3322 */     } else if (this.jComboBox2.getSelectedIndex() == 4) {
/* 3323 */       estado = " estado like '%<Abono%'";
/* 3324 */     } else if (this.jComboBox2.getSelectedIndex() == 5) {
/* 3325 */       estado = " estado like '%<Cancelada%'";
/*      */     } 
/* 3327 */     String tipo = "";
/* 3328 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3329 */       tipo = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 3332 */     (new String[13])[0] = "#"; (new String[13])[1] = "Fecha"; (new String[13])[2] = "Importe"; (new String[13])[3] = "Origen"; (new String[13])[4] = "Destino"; (new String[13])[5] = "Beneficiario"; (new String[13])[6] = "Concepto"; (new String[13])[7] = "Tipo"; (new String[13])[8] = "Sucursal"; (new String[13])[9] = "C"; (new String[13])[10] = "Folio"; (new String[13])[11] = "Estado"; (new String[13])[12] = "Acutalizó"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(13, "folioMensual, fecha, importe, cuentaOrigen, cuentaDestino, beneficiario, concepto, tipo, gastosDe, comprobante, folio, estado, usuario", "prov_transferencias", "where ( " + consultaFecha + " ) and folio like '%" + folio + "%' and tipo like '%" + tipo + "%' and cuentaOrigen like '%" + cuenta + "%' and beneficiario like '%" + beneficiario + "%' and concepto like '%" + concepto + "%' and gastosDe like '%" + sucursalForsis + "%' and (" + estado + ") " + 
/* 3333 */             getConsultaSuc() + ordenado), (Object[])new String[13])
/*      */         {
/*      */           
/* 3336 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3341 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3344 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 3345 */     this.jLabel37.setText("$0.00");
/* 3346 */     calcularTotales();
/* 3347 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Aplicar>", 10, 11, 0));
/* 3348 */     this.celda2.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelada>", 10, 11, 0));
/* 3349 */     this.rSTableMetro1.setSelectionMode(0);
/* 3350 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 3351 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3352 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 3353 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(45);
/* 3354 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(65);
/* 3355 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(65);
/* 3356 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(90);
/* 3357 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(90);
/* 3358 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 3359 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(70);
/* 3360 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 3361 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(70);
/* 3362 */     this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 3363 */     this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(80);
/* 3364 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(30);
/* 3365 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(30);
/* 3366 */     this.rSTableMetro1.getColumnModel().getColumn(10).setPreferredWidth(60);
/* 3367 */     this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(60);
/* 3368 */     this.rSTableMetro1.getColumnModel().getColumn(11).setPreferredWidth(90);
/* 3369 */     this.rSTableMetro1.getColumnModel().getColumn(11).setMaxWidth(90);
/* 3370 */     this.rSTableMetro1.getColumnModel().getColumn(12).setPreferredWidth(120);
/* 3371 */     this.rSTableMetro1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 3372 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3373 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3374 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3375 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3376 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3377 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3378 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3379 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3380 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3381 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3382 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3383 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3384 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3385 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void calcularTotales() {
/* 3389 */     double valorT = 0.0D;
/* 3390 */     double valorDE = 0.0D;
/* 3391 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 3392 */       valorT += convertirCantTexto(this.rSTableMetro1.getValueAt(i, 2).toString());
/* 3393 */       this.cantidad.setValue(Double.valueOf(valorT));
/* 3394 */       this.jLabel37.setText(this.cantidad.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 3399 */     String canti = cant;
/* 3400 */     String valorP = "";
/* 3401 */     for (int j = 0; j < canti.length(); j++) {
/* 3402 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3403 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3406 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3410 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3418 */         return 31;
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3423 */         return 30;
/*      */       case 1:
/* 3425 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0)) {
/* 3426 */           return 29;
/*      */         }
/* 3428 */         return 28;
/*      */     } 
/* 3430 */     return 0;
/*      */   }
/*      */   
/*      */   public void transferencias(String USUARIO) {
/* 3434 */     this.USUARIO = USUARIO;
/* 3435 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 3442 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 3445 */       this.t = new Thread(this);
/* 3446 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 3454 */         ProvTransferencias.this.EtiquetaEstado.setVisible(true);
/* 3455 */         ProvTransferencias.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 3456 */         ProvTransferencias.this.setCursor(new Cursor(3));
/* 3457 */         Thread.currentThread();
/* 3458 */         Thread.sleep(1000L);
/* 3459 */         detener();
/* 3460 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 3465 */       ProvTransferencias.this.consultar();
/* 3466 */       ProvTransferencias.this.setCursor(ProvTransferencias.this.micursor);
/* 3467 */       ProvTransferencias.this.EtiquetaEstado.setVisible(false);
/* 3468 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 3472 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 3478 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3481 */       setEnabled((table == null || table.isEnabled()));
/* 3482 */       if (row % 2 == 0) {
/* 3483 */         setBackground(ProvTransferencias.this.lc.FONDOTABLA);
/*      */       } else {
/* 3485 */         setBackground((Color)null);
/*      */       } 
/* 3487 */       if (column == 4) {
/* 3488 */         setHorizontalAlignment(4);
/*      */       } else {
/* 3490 */         setHorizontalAlignment(2);
/*      */       } 
/* 3492 */       setForeground(ProvTransferencias.this.lc.SECUNDARIO1);
/* 3493 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3494 */       return this;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     CeldaRender2() {
/* 3500 */       this.otro = -1;
/*      */       
/* 3502 */       this.indices = new String[0];
/*      */       
/* 3504 */       this.indices2 = new String[0];
/*      */       
/* 3506 */       this.indices3 = new String[0];
/*      */       
/* 3508 */       this.indices4 = new String[0];
/*      */       
/* 3510 */       this.indices5 = new String[0];
/*      */       
/* 3512 */       this.indices6 = new String[0];
/*      */       
/* 3514 */       this.indices7 = new String[0];
/*      */     } String[] indices4; String[] indices5; String[] indices6; String[] indices7;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3517 */       setEnabled((table == null || table.isEnabled()));
/* 3518 */       String comp = String.valueOf(table.getValueAt(row, 10));
/* 3519 */       if (comparar2(comp)) {
/* 3520 */         setBackground(Color.RED);
/* 3521 */         setForeground(Color.WHITE);
/* 3522 */       } else if (comparar(comp)) {
/* 3523 */         setBackground(new Color(102, 153, 255));
/* 3524 */         setForeground(Color.BLUE);
/*      */       } else {
/* 3526 */         setBackground((Color)null);
/* 3527 */         setForeground(ProvTransferencias.this.lc.SECUNDARIO1);
/*      */       } 
/* 3529 */       if (column == 0 || column == 1 || column == 2) {
/* 3530 */         setHorizontalAlignment(4);
/*      */       } else {
/* 3532 */         setHorizontalAlignment(10);
/*      */       } 
/* 3534 */       if (column == 3 || column == 4 || column == 9) {
/* 3535 */         setHorizontalAlignment(0);
/*      */       }
/* 3537 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3538 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3542 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3546 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 3550 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 3554 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 3558 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd6(String[] ind) {
/* 3562 */       this.indices6 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd7(String[] ind) {
/* 3566 */       this.indices7 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3570 */       for (int i = 0; i < this.indices.length; i++) {
/* 3571 */         if (this.indices[i].equals(reg)) {
/* 3572 */           return true;
/*      */         }
/*      */       } 
/* 3575 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3579 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3580 */         if (this.indices2[i].equals(reg)) {
/* 3581 */           return true;
/*      */         }
/*      */       } 
/* 3584 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 3588 */       for (int i = 0; i < this.indices3.length; i++) {
/* 3589 */         if (this.indices3[i].equals(reg)) {
/* 3590 */           return true;
/*      */         }
/*      */       } 
/* 3593 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 3597 */       for (int i = 0; i < this.indices4.length; i++) {
/* 3598 */         if (this.indices4[i].equals(reg)) {
/* 3599 */           return true;
/*      */         }
/*      */       } 
/* 3602 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 3606 */       for (int i = 0; i < this.indices5.length; i++) {
/* 3607 */         if (this.indices5[i].equals(reg)) {
/* 3608 */           return true;
/*      */         }
/*      */       } 
/* 3611 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar6(String reg) {
/* 3615 */       for (int i = 0; i < this.indices6.length; i++) {
/* 3616 */         if (this.indices6[i].equals(reg)) {
/* 3617 */           return true;
/*      */         }
/*      */       } 
/* 3620 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar7(String reg) {
/* 3624 */       for (int i = 0; i < this.indices7.length; i++) {
/* 3625 */         if (this.indices7[i].equals(reg)) {
/* 3626 */           return true;
/*      */         }
/*      */       } 
/* 3629 */       return false;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public class Cuentas
/*      */   {
/*      */     private int numCuenta;
/*      */     
/*      */     private String bancoCorto;
/*      */     
/*      */     private String cuenta;
/*      */     private String cuentacorta;
/*      */     
/*      */     public Cuentas(int numCuenta, String bancoCorto, String cuenta, String cuentacorta) {
/* 3644 */       this.numCuenta = numCuenta;
/* 3645 */       this.bancoCorto = bancoCorto;
/* 3646 */       this.cuenta = cuenta;
/* 3647 */       this.cuentacorta = cuentacorta;
/*      */     }
/*      */     
/*      */     public int getNumCuenta() {
/* 3651 */       return this.numCuenta;
/*      */     }
/*      */     
/*      */     public void setNumCuenta(int numCuenta) {
/* 3655 */       this.numCuenta = numCuenta;
/*      */     }
/*      */     
/*      */     public String getBancoCorto() {
/* 3659 */       return this.bancoCorto;
/*      */     }
/*      */     
/*      */     public void setBancoCorto(String bancoCorto) {
/* 3663 */       this.bancoCorto = bancoCorto;
/*      */     }
/*      */     
/*      */     public String getCuenta() {
/* 3667 */       return this.cuenta;
/*      */     }
/*      */     
/*      */     public void setCuenta(String cuenta) {
/* 3671 */       this.cuenta = cuenta;
/*      */     }
/*      */     
/*      */     public String getCuentacorta() {
/* 3675 */       return this.cuentacorta;
/*      */     }
/*      */     
/*      */     public void setCuentacorta(String cuentacorta) {
/* 3679 */       this.cuentacorta = cuentacorta;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Proveedores
/*      */   {
/*      */     int numProv;
/*      */     
/*      */     String razonSocial;
/*      */     
/*      */     String nombreComercial;
/*      */     
/*      */     String clabe;
/*      */     String cuenta;
/*      */     
/*      */     public Proveedores(int numProv, String razonSocial, String nombreComercial, String clabe, String cuenta) {
/* 3696 */       this.numProv = numProv;
/* 3697 */       this.razonSocial = razonSocial;
/* 3698 */       this.nombreComercial = nombreComercial;
/* 3699 */       this.clabe = clabe;
/* 3700 */       this.cuenta = cuenta;
/*      */     }
/*      */     
/*      */     public String getCuenta() {
/* 3704 */       return this.cuenta;
/*      */     }
/*      */     
/*      */     public void setCuenta(String cuenta) {
/* 3708 */       this.cuenta = cuenta;
/*      */     }
/*      */     
/*      */     public int getNumProv() {
/* 3712 */       return this.numProv;
/*      */     }
/*      */     
/*      */     public void setNumProv(int numProv) {
/* 3716 */       this.numProv = numProv;
/*      */     }
/*      */     
/*      */     public String getRazonSocial() {
/* 3720 */       return this.razonSocial;
/*      */     }
/*      */     
/*      */     public void setRazonSocial(String razonSocial) {
/* 3724 */       this.razonSocial = razonSocial;
/*      */     }
/*      */     
/*      */     public String getNombreComercial() {
/* 3728 */       return this.nombreComercial;
/*      */     }
/*      */     
/*      */     public void setNombreComercial(String nombreComercial) {
/* 3732 */       this.nombreComercial = nombreComercial;
/*      */     }
/*      */     
/*      */     public String getClabe() {
/* 3736 */       return this.clabe;
/*      */     }
/*      */     
/*      */     public void setClabe(String clabe) {
/* 3740 */       this.clabe = clabe;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvTransferencias.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */