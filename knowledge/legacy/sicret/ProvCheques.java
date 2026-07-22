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
/*      */ import java.awt.HeadlessException;
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
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
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
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import net.sf.jasperreports.engine.JRDataSource;
/*      */ import net.sf.jasperreports.engine.JREmptyDataSource;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.JasperPrintManager;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import utilerias.Utilerias;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ProvCheques
/*      */   extends JPanel
/*      */ {
/*      */   JScrollPane panel;
/*  119 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*  121 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*  123 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*  125 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*  127 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*  129 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*  131 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*  133 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*  135 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*  137 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*  139 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*  141 */   JFrame padre = null;
/*      */   
/*  143 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  147 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  151 */   SColores lc = new SColores();
/*      */   
/*  153 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  155 */   PlaceHolder placeHolder = null;
/*      */   
/*  157 */   Consultas2 con = new Consultas2();
/*      */   
/*  159 */   Consultas2 con2 = new Consultas2();
/*      */   
/*  161 */   String holderPoliza = "NÚMERO DE PÓLIZA";
/*      */   
/*  163 */   String holderCheque = "NÚMERO DE CHEQUE";
/*      */   
/*  165 */   String holderCuenta = "NÚMERO DE CUENTA";
/*      */   
/*  167 */   String holderBeneficiario = "BENEFICIARIO";
/*      */   
/*  169 */   String holderConcepto = "CONCEPTO";
/*      */   
/*  171 */   private MaskFormatter formaTel = null;
/*      */   
/*      */   boolean entraCatMon = false;
/*      */   
/*  175 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*  177 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  179 */   ArrayList TODOS_SUCURSALES = new ArrayList();
/*      */   
/*  181 */   TextAutoCompleter com_Sucursales = null;
/*      */   
/*  183 */   Validaciones val = new Validaciones();
/*      */   
/*  185 */   Errores error = new Errores(false);
/*      */   
/*  187 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*  191 */   Cursor micursor = null;
/*      */   
/*  193 */   Presionado presionado = null;
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*  197 */   String ACTIVARSUC = "";
/*      */   
/*  199 */   String NUMPOLIZA = "";
/*      */   
/*  201 */   String[] SUCURSALES = null;
/*      */   
/*  203 */   Date fechaActual = new Date();
/*      */   
/*  205 */   Date fechaInicio = null;
/*      */   
/*  207 */   Map<Integer, String> TIPOS = new LinkedHashMap<>();
/*      */   
/*  209 */   List<Cuentas> CUENTAS = new ArrayList<>();
/*      */   
/*  211 */   List<Proveedores> PROVEEDORES = new ArrayList<>();
/*      */   
/*      */   boolean entraNueva = false;
/*      */   
/*      */   boolean encontrado = true;
/*      */   
/*  217 */   TextAutoCompleter com_OtroBeneficiario = null;
/*      */   
/*  219 */   TextAutoCompleter com_CobradoPor = null;
/*      */   
/*  221 */   ArrayList TODOS_OTROBENEFICIARIO = new ArrayList();
/*      */   
/*  223 */   ArrayList TODOS_COBRADOPOR = new ArrayList();
/*      */   
/*  225 */   List<String> FACTURASAGREGADAS = new ArrayList<>();
/*      */   
/*      */   boolean PRIMERA = false;
/*      */   
/*  229 */   String NOMBREDE = "";
/*      */   
/*  231 */   String PRIVILEGIOSSUC = "";
/*      */   
/*  233 */   String CUENTACOMPLETA = "";
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
/*      */   private JButton jButton52;
/*      */   
/*      */   private JButton jButton53;
/*      */   
/*      */   private JButton jButton54;
/*      */   
/*      */   private JButton jButton55;
/*      */   
/*      */   private JButton jButton57;
/*      */   
/*      */   private JButton jButton58;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox<String> jComboBox10;
/*      */   
/*  275 */   Utilerias utilerias = new Utilerias();
/*      */   
/*      */   private JComboBox<String> jComboBox11;
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
/*      */   private JComboBox jComboBox7;
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
/*      */   private JDateChooser jDateChooser7;
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
/*      */   private JLabel jLabel18;
/*      */   
/*      */   private JLabel jLabel19;
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/*      */   private JLabel jLabel221;
/*      */   
/*      */   private JLabel jLabel233;
/*      */   
/*      */   private JLabel jLabel234;
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
/*      */   private JPanel jPanel28;
/*      */   
/*      */   private JPanel jPanel29;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel30;
/*      */   
/*      */   private JPanel jPanel31;
/*      */   
/*      */   private JPanel jPanel32;
/*      */   
/*      */   private JPanel jPanel33;
/*      */   
/*      */   private JPanel jPanel34;
/*      */   
/*      */   private JPanel jPanel35;
/*      */   
/*      */   private JPanel jPanel36;
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
/*      */   private JScrollPane jScrollPane32;
/*      */   
/*      */   private JScrollPane jScrollPane33;
/*      */   
/*      */   private JScrollPane jScrollPane34;
/*      */   
/*      */   private JTextArea jTextArea5;
/*      */   
/*      */   private JTextField jTextField1;
/*      */   
/*      */   private JTextField jTextField10;
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
/*      */   private JTextField jTextField9;
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
/*      */   public ProvCheques(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  538 */     this.EtiquetaEstado = EtiquetaEstado;
/*  539 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  540 */     this.mensajeTry = mensajeTry;
/*  541 */     this.padre = padre;
/*  542 */     this.fichas = fichas;
/*  543 */     this.USUARIO = USUARIO;
/*  544 */     this.panel = panelito;
/*  545 */     this.con.setBaseDatos("sicre2PR");
/*  546 */     this.con.cambiarServidor();
/*  547 */     this.panel.setViewportView(this);
/*  548 */     initComponents();
/*  549 */     this.buttonGroup1.add(this.jRadioButton1);
/*  550 */     this.buttonGroup1.add(this.jRadioButton2);
/*  551 */     this.buttonGroup1.add(this.jRadioButton3);
/*  552 */     this.buttonGroup1.add(this.jRadioButton4);
/*  553 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderPoliza, false, "Century Gothic", 11);
/*  554 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderCheque, false, "Century Gothic", 11);
/*  555 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderCuenta, false, "Century Gothic", 11);
/*  556 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderBeneficiario, false, "Century Gothic", 11);
/*  557 */     this.placeHolder = new PlaceHolder(this.jTextField5, new Color(189, 189, 189), Color.BLACK, this.holderConcepto, false, "Century Gothic", 11);
/*  558 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  559 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  560 */     editFormat.setGroupingUsed(false);
/*  561 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  562 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  563 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  564 */     enFormat.setAllowsInvalid(true);
/*  565 */     this.cantidad.setFormatterFactory(currFactory);
/*  566 */     this.importe.setFormatterFactory(currFactory);
/*  567 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  568 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  569 */     this.jDialog1.setCursor(this.micursor);
/*  570 */     this.jDialog2.setCursor(this.micursor);
/*  571 */     this.jDialog3.setCursor(this.micursor);
/*  572 */     this.jDialog4.setCursor(this.micursor);
/*  573 */     this.rSTableMetro1.setCursor(this.micursor);
/*  574 */     this.rSTableMetro2.setCursor(this.micursor);
/*  575 */     this.rSTableMetro3.setCursor(this.micursor);
/*  576 */     this.rSTableMetro4.setCursor(this.micursor);
/*  577 */     imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  578 */     this.micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  579 */     this.jLabel170.setCursor(this.micursor);
/*  580 */     this.jLabel101.setCursor(this.micursor);
/*  581 */     this.jLabel171.setCursor(this.micursor);
/*  582 */     int w = this.tama.width;
/*  583 */     int h = this.tama.height;
/*  584 */     int rw = (w - 870) / 2;
/*  585 */     int rh = (h - 10) / 2;
/*  586 */     rw = (w - 450) / 2;
/*  587 */     rh = (h - 200) / 2;
/*  588 */     this.jDialog1.setLocation(rw, rh);
/*  589 */     this.jDialog1.setSize(380, 160);
/*  590 */     this.jDialog1.setResizable(false);
/*  591 */     rw = (w - 450) / 2;
/*  592 */     rh = (h - 200) / 2;
/*  593 */     this.jDialog2.setLocation(rw, rh);
/*  594 */     this.jDialog2.setSize(480, 260);
/*  595 */     this.jDialog2.setResizable(false);
/*  596 */     rw = (w - 475) / 2;
/*  597 */     rh = (h - 130) / 2;
/*  598 */     this.jDialog3.setLocation(rw, rh);
/*  599 */     this.jDialog3.setSize(475, 130);
/*  600 */     this.jDialog3.setResizable(false);
/*  601 */     rw = (w - 520) / 2;
/*  602 */     rh = (h - 270) / 2;
/*  603 */     this.jDialog4.setLocation(rw, rh);
/*  604 */     this.jDialog4.setSize(520, 270);
/*  605 */     this.jDialog4.setResizable(false);
/*  606 */     rw = (w - 390) / 2;
/*  607 */     rh = (h - 175) / 2;
/*  608 */     this.jDialog5.setLocation(rw, rh);
/*  609 */     this.jDialog5.setSize(390, 175);
/*  610 */     this.jDialog5.setVisible(false);
/*  611 */     this.jDialog5.setResizable(false);
/*  612 */     for (int i = 2018; i <= añoActual(); i++) {
/*  613 */       this.jComboBox11.addItem("" + i);
/*      */     }
/*  615 */     this.jComboBox10.setSelectedIndex(mesActual());
/*  616 */     this.jComboBox11.setSelectedItem("" + añoActual());
/*  617 */     colorear();
/*  618 */     llenarTipo();
/*  619 */     llenarComboUsuario();
/*  620 */     llenarComboSuc();
/*  621 */     llenarSucursales();
/*  622 */     this.com_Sucursales = new TextAutoCompleter(this.jTextField25, this.TODOS_SUCURSALES);
/*  623 */     privilegios();
/*  624 */     consultar();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  628 */     this.jPanel1 = new JPanel();
/*  629 */     this.jPanel13 = new JPanel();
/*  630 */     this.jLabel13 = new JLabel();
/*  631 */     this.jLabel16 = new JLabel();
/*  632 */     this.jPanel14 = new JPanel();
/*  633 */     this.jPanel15 = new JPanel();
/*  634 */     this.materialButton21 = new MaterialButton();
/*  635 */     this.materialButton22 = new MaterialButton();
/*  636 */     this.jPanel26 = new JPanel();
/*  637 */     this.jPanel27 = new JPanel();
/*  638 */     this.jPanel28 = new JPanel();
/*  639 */     this.jLabel2 = new JLabel();
/*  640 */     this.jTextField7 = new JTextField();
/*  641 */     this.jLabel8 = new JLabel();
/*  642 */     this.jComboBox6 = new JComboBox<>();
/*      */     
/*  644 */     this.jLabel4 = new JLabel();
/*  645 */     this.jPanel12 = new JPanel();
/*  646 */     this.jButton58 = new JButton();
/*  647 */     this.jComboBox5 = new JComboBox<>();
/*  648 */     this.jLabel9 = new JLabel();
/*  649 */     this.jTextField10 = new JTextField();
/*  650 */     this.jPanel32 = new JPanel();
/*  651 */     this.jLabel3 = new JLabel();
/*  652 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  653 */     this.jLabel14 = new JLabel();
/*  654 */     this.jTextField9 = new JTextField();
/*  655 */     this.jLabel7 = new JLabel();
/*  656 */     this.jComboBox4 = new JComboBox<>();
/*  657 */     this.jLabel6 = new JLabel();
/*  658 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  659 */     this.jPanel33 = new JPanel();
/*  660 */     this.jLabel15 = new JLabel();
/*  661 */     this.jLabel17 = new JLabel();
/*  662 */     this.jLabel18 = new JLabel();
/*  663 */     this.jComboBox9 = new JComboBox<>();
/*  664 */     this.jLabel5 = new JLabel();
/*  665 */     this.jTextField8 = new JTextField();
/*  666 */     this.jPanel34 = new JPanel();
/*  667 */     this.jLabel10 = new JLabel();
/*  668 */     this.jButton52 = new JButton();
/*  669 */     this.jScrollPane1 = new JScrollPane();
/*  670 */     this.jTextPane1 = new JTextPane();
/*  671 */     this.jPanel35 = new JPanel();
/*  672 */     this.jPanel22 = new JPanel();
/*  673 */     this.jLabel11 = new JLabel();
/*  674 */     this.importe = new JFormattedTextField();
/*  675 */     this.jPanel24 = new JPanel();
/*  676 */     this.jRadioButton1 = new JRadioButton();
/*  677 */     this.jRadioButton3 = new JRadioButton();
/*  678 */     this.jRadioButton2 = new JRadioButton();
/*  679 */     this.jRadioButton4 = new JRadioButton();
/*  680 */     this.jPanel23 = new JPanel();
/*  681 */     this.jLabel12 = new JLabel();
/*  682 */     this.jPanel134 = new JPanel();
/*  683 */     this.jTextField25 = new JTextField();
/*  684 */     this.jButton57 = new JButton();
/*  685 */     this.jPanel36 = new JPanel();
/*  686 */     this.jLabel19 = new JLabel();
/*  687 */     this.jScrollPane2 = new JScrollPane();
/*  688 */     this.jTextPane2 = new JTextPane();
/*  689 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  690 */     this.jPanel135 = new JPanel();
/*  691 */     this.jScrollPane32 = new JScrollPane();
/*  692 */     this.rSTableMetro2 = new RSTableMetro();
/*  693 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  694 */     this.jPanel136 = new JPanel();
/*  695 */     this.jScrollPane33 = new JScrollPane();
/*  696 */     this.rSTableMetro3 = new RSTableMetro();
/*  697 */     this.jButton53 = new JButton();
/*  698 */     this.jButton54 = new JButton();
/*  699 */     this.jButton55 = new JButton();
/*  700 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  701 */     this.jPanel31 = new JPanel();
/*  702 */     this.jLabel29 = new JLabel();
/*  703 */     this.jTextField16 = new JTextField();
/*  704 */     this.jButton15 = new JButton();
/*  705 */     this.jButton16 = new JButton();
/*  706 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  707 */     this.jPanel137 = new JPanel();
/*  708 */     this.jScrollPane34 = new JScrollPane();
/*  709 */     this.rSTableMetro4 = new RSTableMetro();
/*  710 */     this.materialButton23 = new MaterialButton();
/*  711 */     this.jLabel1 = new JLabel();
/*  712 */     this.jTextField6 = new JTextField();
/*  713 */     this.jPanel48 = new JPanel();
/*  714 */     this.jLabel59 = new JLabel();
/*  715 */     this.jLabel49 = new JLabel();
/*  716 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  717 */     this.jPanel38 = new JPanel();
/*  718 */     this.jLabel125 = new JLabel();
/*  719 */     this.jScrollPane18 = new JScrollPane();
/*  720 */     this.jTextArea5 = new JTextArea();
/*  721 */     this.materialButton36 = new MaterialButton();
/*  722 */     this.materialButton37 = new MaterialButton();
/*  723 */     this.cantidad = new JFormattedTextField();
/*  724 */     this.buttonGroup1 = new ButtonGroup();
/*  725 */     this.jComboBox7 = new JComboBox();
/*  726 */     this.jPanel29 = new JPanel();
/*  727 */     this.jPanel30 = new JPanel();
/*  728 */     this.jPanel9 = new JPanel();
/*  729 */     this.jPanel16 = new JPanel();
/*  730 */     this.jPanel18 = new JPanel();
/*  731 */     this.jPanel19 = new JPanel();
/*  732 */     this.jPanel21 = new JPanel();
/*  733 */     this.jPanel20 = new JPanel();
/*  734 */     this.jPanel2 = new JPanel();
/*  735 */     this.jPanel8 = new JPanel();
/*  736 */     this.jLabel55 = new JLabel();
/*  737 */     this.jPanel6 = new JPanel();
/*  738 */     this.jLabel233 = new JLabel();
/*  739 */     this.jPanel7 = new JPanel();
/*  740 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  741 */     this.jLabel234 = new JLabel();
/*  742 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  743 */     this.jComboBox8 = new JComboBox<>();
/*  744 */     this.jComboBox10 = new JComboBox<>();
/*  745 */     this.jComboBox11 = new JComboBox<>();
/*  746 */     this.jPanel11 = new JPanel();
/*  747 */     this.jButton1 = new JButton();
/*  748 */     this.jLabel170 = new JLabel();
/*  749 */     this.jLabel101 = new JLabel();
/*  750 */     this.jLabel171 = new JLabel();
/*  751 */     this.jPanel17 = new JPanel();
/*  752 */     this.jComboBox3 = new JComboBox();
/*  753 */     this.jTextField1 = new JTextField();
/*  754 */     this.jTextField2 = new JTextField();
/*  755 */     this.jTextField3 = new JTextField();
/*  756 */     this.jTextField4 = new JTextField();
/*  757 */     this.jTextField5 = new JTextField();
/*  758 */     this.jComboBox2 = new JComboBox();
/*  759 */     this.jComboBox1 = new JComboBox();
/*  760 */     this.jPanel10 = new JPanel();
/*  761 */     this.jPanel3 = new JPanel();
/*  762 */     this.jPanel47 = new JPanel();
/*  763 */     this.jLabel58 = new JLabel();
/*  764 */     this.jLabel48 = new JLabel();
/*  765 */     this.jPanel4 = new JPanel();
/*  766 */     this.jPanel5 = new JPanel();
/*  767 */     this.jButton2 = new JButton();
/*  768 */     this.jButton10 = new JButton();
/*  769 */     this.jButton11 = new JButton();
/*  770 */     this.jButton12 = new JButton();
/*  771 */     this.jButton13 = new JButton();
/*  772 */     this.jButton14 = new JButton();
/*  773 */     this.jPanel151 = new JPanel();
/*  774 */     this.jLabel221 = new JLabel();
/*  775 */     this.jLabel37 = new JLabel();
/*  776 */     this.jPanel25 = new JPanel();
/*  777 */     this.jScrollPane13 = new JScrollPane();
/*  778 */     this.rSTableMetro1 = new RSTableMetro();
/*  779 */     this.jPanel13.setBackground(this.lc.SECUNDARIO1);
/*  780 */     this.jLabel13.setFont(new Font("Cantarell", 1, 22));
/*  781 */     this.jLabel13.setForeground(this.lc.PRIMARIO2);
/*  782 */     this.jLabel13.setHorizontalAlignment(0);
/*  783 */     this.jLabel13.setText("Nueva Póliza");
/*  784 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*  785 */     this.jLabel16.setToolTipText("Cerrar");
/*  786 */     this.jLabel16.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  788 */             ProvCheques.this.jLabel16MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/*  792 */             ProvCheques.this.jLabel16MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/*  796 */             ProvCheques.this.jLabel16MouseExited(evt);
/*      */           }
/*      */         });
/*  799 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  800 */     this.jPanel13.setLayout(jPanel13Layout);
/*  801 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  803 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/*  804 */           .addContainerGap()
/*  805 */           .addComponent(this.jLabel13, -1, -1, 32767)
/*  806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */           .addComponent(this.jLabel16)
/*  808 */           .addContainerGap()));
/*  809 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  810 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  811 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  812 */           .addContainerGap()
/*  813 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  814 */             .addComponent(this.jLabel13, -1, -1, 32767)
/*  815 */             .addComponent(this.jLabel16, -1, -1, 32767))
/*  816 */           .addContainerGap(-1, 32767)));
/*  817 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  818 */     this.jPanel14.setLayout(jPanel14Layout);
/*  819 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  820 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  821 */         .addGap(0, 767, 32767));
/*  822 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  824 */         .addGap(0, 64, 32767));
/*  825 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/*  826 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  827 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  828 */     this.materialButton21.setMnemonic('C');
/*  829 */     this.materialButton21.setText("Cerrar");
/*  830 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/*  831 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  832 */     this.materialButton21.setHorizontalTextPosition(0);
/*  833 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  835 */             ProvCheques.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*  838 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  839 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  840 */     this.materialButton22.setMnemonic('G');
/*  841 */     this.materialButton22.setText("Guardar");
/*  842 */     this.materialButton22.setToolTipText("Guardar (Alt +G)");
/*  843 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  844 */     this.materialButton22.setHorizontalTextPosition(0);
/*  845 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  847 */             ProvCheques.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*  850 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  851 */     this.jPanel15.setLayout(jPanel15Layout);
/*  852 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/*  853 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  854 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/*  855 */           .addContainerGap(-1, 32767)
/*  856 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  857 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  858 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/*  859 */           .addContainerGap()));
/*  860 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/*  861 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  862 */         .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  863 */         .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2));
/*  864 */     this.jPanel27.setLayout(new GridLayout(1, 3, 80, 0));
/*  865 */     this.jPanel28.setLayout(new GridLayout(4, 2, 0, 6));
/*  866 */     this.jLabel2.setText("Póliza");
/*  867 */     this.jPanel28.add(this.jLabel2);
/*  868 */     this.jTextField7.setText("jTextField7");
/*  869 */     this.jTextField7.setEnabled(false);
/*  870 */     this.jTextField7.setNextFocusableComponent((Component)this.jDateChooser6);
/*  871 */     this.jPanel28.add(this.jTextField7);
/*  872 */     this.jLabel8.setText("A nombre de");
/*  873 */     this.jPanel28.add(this.jLabel8);
/*  874 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  875 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/*  876 */     this.jComboBox6.setNextFocusableComponent(this.jTextField9);
/*  877 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  879 */             ProvCheques.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  882 */     this.jPanel28.add(this.jComboBox6);
/*  883 */     this.jLabel4.setText("Tipo");
/*  884 */     this.jPanel28.add(this.jLabel4);
/*  885 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  886 */     this.jButton58.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  888 */             ProvCheques.this.jButton58ActionPerformed(evt);
/*      */           }
/*      */         });
/*  891 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  892 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/*  893 */     this.jComboBox5.setNextFocusableComponent(this.jComboBox4);
/*  894 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  896 */             ProvCheques.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  899 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  900 */     this.jPanel12.setLayout(jPanel12Layout);
/*  901 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  902 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  903 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  904 */           .addComponent(this.jComboBox5, 0, 0, 32767)
/*  905 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  906 */           .addComponent(this.jButton58, -2, 18, -2)));
/*  907 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  908 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  909 */         .addComponent(this.jButton58, -1, -1, 32767)
/*  910 */         .addComponent(this.jComboBox5));
/*  911 */     this.jPanel28.add(this.jPanel12);
/*  912 */     this.jLabel9.setText("Cobrado por");
/*  913 */     this.jPanel28.add(this.jLabel9);
/*  914 */     this.jTextField10.setText("jTextField10");
/*  915 */     this.jTextField10.setNextFocusableComponent((Component)this.jDateChooser7);
/*  916 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  918 */             ProvCheques.this.jTextField10FocusGained(evt);
/*      */           }
/*      */         });
/*  921 */     this.jPanel28.add(this.jTextField10);
/*  922 */     this.jPanel27.add(this.jPanel28);
/*  923 */     this.jPanel32.setLayout(new GridLayout(4, 2, 0, 6));
/*  924 */     this.jLabel3.setText("Fecha de la póliza");
/*  925 */     this.jPanel32.add(this.jLabel3);
/*  926 */     this.jDateChooser6.setDate(this.fechaActual);
/*  927 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  928 */     this.jDateChooser6.setEnabled(false);
/*  929 */     this.jDateChooser6.setIcon(this.icon);
/*  930 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/*  931 */     this.jDateChooser6.setNextFocusableComponent(this.jComboBox6);
/*  932 */     this.jPanel32.add((Component)this.jDateChooser6);
/*  933 */     this.jLabel14.setText("Otro");
/*  934 */     this.jPanel32.add(this.jLabel14);
/*  935 */     this.jTextField9.setText("jTextField9");
/*  936 */     this.jTextField9.setNextFocusableComponent(this.jComboBox9);
/*  937 */     this.jPanel32.add(this.jTextField9);
/*  938 */     this.jLabel7.setText("Cuenta");
/*  939 */     this.jPanel32.add(this.jLabel7);
/*  940 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  941 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/*  942 */     this.jComboBox4.setNextFocusableComponent(this.jTextField8);
/*  943 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  945 */             ProvCheques.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  948 */     this.jPanel32.add(this.jComboBox4);
/*  949 */     this.jLabel6.setText("Fecha del cheque");
/*  950 */     this.jPanel32.add(this.jLabel6);
/*  951 */     this.jDateChooser7.setDate(this.fechaActual);
/*  952 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  953 */     this.jDateChooser7.setIcon(this.icon);
/*  954 */     this.jDateChooser7.setMinSelectableDate(this.fechaInicio);
/*  955 */     this.jDateChooser7.setNextFocusableComponent(this.jTextPane1);
/*  956 */     this.jPanel32.add((Component)this.jDateChooser7);
/*  957 */     this.jPanel27.add(this.jPanel32);
/*  958 */     this.jPanel33.setLayout(new GridLayout(4, 2, 0, 6));
/*  959 */     this.jLabel15.setText(" ");
/*  960 */     this.jPanel33.add(this.jLabel15);
/*  961 */     this.jLabel17.setText(" ");
/*  962 */     this.jPanel33.add(this.jLabel17);
/*  963 */     this.jLabel18.setText("Gastos de");
/*  964 */     this.jPanel33.add(this.jLabel18);
/*  965 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/*  966 */     this.jComboBox9.setNextFocusableComponent(this.jComboBox5);
/*  967 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  969 */             ProvCheques.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/*  972 */     this.jPanel33.add(this.jComboBox9);
/*  973 */     this.jLabel5.setText("Cheque");
/*  974 */     this.jPanel33.add(this.jLabel5);
/*  975 */     this.jTextField8.setText("jTextField8");
/*  976 */     this.jTextField8.setNextFocusableComponent(this.jTextField10);
/*  977 */     this.jPanel33.add(this.jTextField8);
/*  978 */     this.jPanel27.add(this.jPanel33);
/*  979 */     this.jLabel10.setText("Concepto");
/*  980 */     this.jButton52.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  981 */     this.jButton52.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  983 */             ProvCheques.this.jButton52ActionPerformed(evt);
/*      */           }
/*      */         });
/*  986 */     this.jTextPane1.setNextFocusableComponent(this.importe);
/*  987 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*  988 */     this.jPanel35.setLayout(new GridLayout(1, 3, 80, 0));
/*  989 */     this.jPanel22.setLayout(new GridLayout(1, 0));
/*  990 */     this.jLabel11.setText("Importe");
/*  991 */     this.jPanel22.add(this.jLabel11);
/*  992 */     this.importe.setHorizontalAlignment(4);
/*  993 */     this.importe.setText("importe");
/*  994 */     this.importe.setNextFocusableComponent(this.jRadioButton1);
/*  995 */     this.jPanel22.add(this.importe);
/*  996 */     this.jPanel35.add(this.jPanel22);
/*  997 */     this.jPanel24.setLayout(new GridLayout(1, 4, 6, 0));
/*  998 */     this.jRadioButton1.setText("PC");
/*  999 */     this.jRadioButton1.setToolTipText("Por comprobar");
/* 1000 */     this.jRadioButton1.setNextFocusableComponent(this.jRadioButton2);
/* 1001 */     this.jPanel24.add(this.jRadioButton1);
/* 1002 */     this.jRadioButton3.setText("C");
/* 1003 */     this.jRadioButton3.setToolTipText("Comprobado");
/* 1004 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1006 */             ProvCheques.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1009 */     this.jPanel24.add(this.jRadioButton3);
/* 1010 */     this.jRadioButton2.setText("SC");
/* 1011 */     this.jRadioButton2.setToolTipText("Sin comprobante");
/* 1012 */     this.jRadioButton2.setNextFocusableComponent((Component)this.materialButton22);
/* 1013 */     this.jPanel24.add(this.jRadioButton2);
/* 1014 */     this.jRadioButton4.setText("N/A");
/* 1015 */     this.jRadioButton4.setToolTipText("No aplica");
/* 1016 */     this.jPanel24.add(this.jRadioButton4);
/* 1017 */     this.jPanel35.add(this.jPanel24);
/* 1018 */     this.jPanel23.setLayout(new GridLayout(1, 2));
/* 1019 */     this.jLabel12.setText("Sucursal Operativa");
/* 1020 */     this.jPanel23.add(this.jLabel12);
/* 1021 */     this.jPanel134.setBackground(new Color(255, 255, 255));
/* 1022 */     this.jTextField25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1024 */             ProvCheques.this.jTextField25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1027 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1028 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1030 */             ProvCheques.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1033 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/* 1034 */     this.jPanel134.setLayout(jPanel134Layout);
/* 1035 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/* 1036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1037 */         .addGroup(jPanel134Layout.createSequentialGroup()
/* 1038 */           .addComponent(this.jTextField25)
/* 1039 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1040 */           .addComponent(this.jButton57, -2, 18, -2)));
/* 1041 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/* 1042 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1043 */         .addComponent(this.jTextField25)
/* 1044 */         .addComponent(this.jButton57, -1, -1, 32767));
/* 1045 */     this.jPanel23.add(this.jPanel134);
/* 1046 */     this.jPanel35.add(this.jPanel23);
/* 1047 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1048 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1049 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1050 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1051 */         .addComponent(this.jScrollPane1)
/* 1052 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1053 */           .addComponent(this.jLabel10)
/* 1054 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1055 */           .addComponent(this.jButton52)
/* 1056 */           .addGap(0, 0, 32767))
/* 1057 */         .addComponent(this.jPanel35, -2, 0, 32767));
/* 1058 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1059 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1060 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1061 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1062 */             .addComponent(this.jButton52, -2, 26, -2)
/* 1063 */             .addComponent(this.jLabel10, -1, -1, 32767))
/* 1064 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*      */           
/* 1066 */           .addComponent(this.jScrollPane1, -2, 65, -2)
/*      */           
/* 1068 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*      */ 
/*      */           
/* 1071 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1072 */           .addGap(0, 6, 32767)));
/*      */     
/* 1074 */     this.jLabel19.setText("Comentarios");
/* 1075 */     this.jScrollPane2.setViewportView(this.jTextPane2);
/* 1076 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1077 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1078 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1081 */           .addComponent(this.jLabel19)
/* 1082 */           .addGap(0, 0, 32767))
/* 1083 */         .addComponent(this.jScrollPane2));
/* 1084 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1086 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1087 */           .addComponent(this.jLabel19)
/* 1088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1089 */           .addComponent(this.jScrollPane2, -1, 69, 32767)));
/* 1090 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 1091 */     this.jPanel26.setLayout(jPanel26Layout);
/* 1092 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 1093 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1094 */         .addComponent(this.jPanel34, -1, -1, 32767)
/* 1095 */         .addComponent(this.jPanel27, -2, 0, 32767)
/* 1096 */         .addComponent(this.jPanel36, -1, -1, 32767));
/* 1097 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 1098 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1099 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1100 */           .addComponent(this.jPanel27, -2, 114, -2)
/* 1101 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1102 */           .addComponent(this.jPanel34, -2, -1, -2)
/* 1103 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1104 */           .addComponent(this.jPanel36, -2, -1, -2)));
/* 1105 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1106 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1107 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1108 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1109 */         .addComponent(this.jPanel13, -1, -1, 32767)
/* 1110 */         .addComponent(this.jPanel15, -1, -1, 32767)
/* 1111 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1112 */           .addGap(0, 0, 32767)
/* 1113 */           .addComponent(this.jPanel14, -2, -1, -2))
/* 1114 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1115 */           .addGap(19, 19, 19)
/* 1116 */           .addComponent(this.jPanel26, -1, -1, 32767)
/* 1117 */           .addGap(20, 20, 20)));
/* 1118 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1119 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1120 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1121 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1122 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1123 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 1124 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1125 */           .addComponent(this.jPanel14, -1, -1, 32767)
/* 1126 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1127 */           .addComponent(this.jPanel15, -2, -1, -2)));
/* 1128 */     this.jDialog1.setTitle("Sucursales");
/* 1129 */     this.jDialog1.setUndecorated(true);
/* 1130 */     (new Object[2])[0] = null; (new Object[2])[1] = "Veracruz"; (new Object[2][])[0] = new Object[2]; (new Object[2])[0] = null; (new Object[2])[1] = "Poza Rica"; (new Object[2][])[1] = new Object[2]; (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[2]) {
/* 1131 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 1133 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1136 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1140 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1143 */     this.rSTableMetro2.setAltoHead(25);
/* 1144 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1145 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 1146 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1147 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1148 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1149 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1150 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1151 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1152 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1153 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1154 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 1155 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1156 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 1157 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 1158 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1159 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1160 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1162 */             ProvCheques.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1165 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1167 */             ProvCheques.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1170 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 1171 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/* 1172 */     this.jPanel135.setLayout(jPanel135Layout);
/* 1173 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/* 1174 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */         .addComponent(this.jScrollPane32, -1, 418, 32767));
/* 1176 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/* 1177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */         .addComponent(this.jScrollPane32, -1, 131, 32767));
/* 1179 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1180 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1181 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1182 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1183 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
/* 1184 */           .addGap(0, 0, 0)
/* 1185 */           .addComponent(this.jPanel135, -1, -1, 32767)));
/* 1186 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1187 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1188 */         .addComponent(this.jPanel135, -1, -1, 32767));
/* 1189 */     this.jDialog2.setTitle("Tipo de Póliza");
/* 1190 */     this.jDialog2.setUndecorated(true);
/* 1191 */     (new String[2])[0] = "Num"; (new String[2])[1] = "Tipo"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1192 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1195 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1198 */     this.rSTableMetro3.setAltoHead(25);
/* 1199 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1200 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1201 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1202 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1203 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1204 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1205 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1206 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1207 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1208 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1209 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1210 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1211 */     this.rSTableMetro3.setShowHorizontalLines(false);
/* 1212 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1213 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1214 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1215 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1217 */             ProvCheques.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1220 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1222 */             ProvCheques.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1225 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/* 1226 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1227 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1229 */             ProvCheques.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1232 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1233 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1235 */             ProvCheques.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1238 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 1239 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1241 */             ProvCheques.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1244 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1245 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1246 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1248 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/* 1249 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/* 1250 */           .addContainerGap(-1, 32767)
/* 1251 */           .addComponent(this.jButton53)
/* 1252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1253 */           .addComponent(this.jButton54)
/* 1254 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1255 */           .addComponent(this.jButton55)
/* 1256 */           .addContainerGap()));
/* 1257 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1258 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1259 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1260 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/* 1261 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1262 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1263 */             .addComponent(this.jButton53, -2, 26, -2)
/* 1264 */             .addComponent(this.jButton54, -2, 26, -2)
/* 1265 */             .addComponent(this.jButton55, -2, 26, -2))));
/* 1266 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1267 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1268 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1269 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1270 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
/* 1271 */           .addGap(0, 0, 0)
/* 1272 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/* 1273 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1274 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1275 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1276 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1277 */           .addGap(0, 0, 0)));
/* 1278 */     this.jDialog3.setTitle("Nuevo Tipo");
/* 1279 */     this.jDialog3.setModal(true);
/* 1280 */     this.jLabel29.setText("Ingresa el nuevo tipo de cheque:");
/* 1281 */     this.jTextField16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1283 */             ProvCheques.this.jTextField16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1286 */     this.jButton15.setMnemonic('C');
/* 1287 */     this.jButton15.setText("Cerrar");
/* 1288 */     this.jButton15.setToolTipText("Cerrar (Alt+C)");
/* 1289 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1291 */             ProvCheques.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1294 */     this.jButton16.setMnemonic('A');
/* 1295 */     this.jButton16.setText("Agregar");
/* 1296 */     this.jButton16.setToolTipText("Agregar (Alt+A)");
/* 1297 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1299 */             ProvCheques.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1302 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1303 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1304 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1305 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1306 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1307 */           .addContainerGap()
/* 1308 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1309 */             .addComponent(this.jTextField16)
/* 1310 */             .addComponent(this.jLabel29, -1, -1, 32767)
/* 1311 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1312 */               .addGap(0, 265, 32767)
/* 1313 */               .addComponent(this.jButton16, -2, 91, -2)
/* 1314 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1315 */               .addComponent(this.jButton15, -2, 91, -2)))
/* 1316 */           .addContainerGap()));
/* 1317 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1318 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1319 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1320 */           .addComponent(this.jLabel29, -2, 26, -2)
/* 1321 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1322 */           .addComponent(this.jTextField16, -2, -1, -2)
/* 1323 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1324 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1325 */             .addComponent(this.jButton15)
/* 1326 */             .addComponent(this.jButton16))
/* 1327 */           .addContainerGap(-1, 32767)));
/* 1328 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1329 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1330 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1331 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1332 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1333 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 1334 */           .addGap(0, 0, 32767)));
/* 1335 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1337 */         .addComponent(this.jPanel31, -1, -1, 32767));
/* 1338 */     this.jDialog4.setTitle("Agregar datos");
/* 1339 */     this.jDialog4.setUndecorated(true);
/* 1340 */     (new String[2])[0] = "Num"; (new String[2])[1] = "Tipo"; this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1341 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1344 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1347 */     this.rSTableMetro4.setAltoHead(25);
/* 1348 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1349 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1350 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1351 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1352 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1353 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1354 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1355 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1356 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1357 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1358 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1359 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1360 */     this.rSTableMetro4.setShowHorizontalLines(false);
/* 1361 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 1362 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1363 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1364 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1366 */             ProvCheques.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1369 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1371 */             ProvCheques.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1374 */     this.jScrollPane34.setViewportView((Component)this.rSTableMetro4);
/* 1375 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/* 1376 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 1377 */     this.materialButton23.setMnemonic('A');
/* 1378 */     this.materialButton23.setText("Agregar");
/* 1379 */     this.materialButton23.setToolTipText("Agregar (Alt+A)");
/* 1380 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 1381 */     this.materialButton23.setHorizontalTextPosition(0);
/* 1382 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1384 */             ProvCheques.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1387 */     this.jLabel1.setText("Búsqueda por folio:");
/* 1388 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1390 */             ProvCheques.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1393 */     this.jPanel48.setLayout(new GridLayout(1, 2, 6, 0));
/* 1394 */     this.jLabel59.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1395 */     this.jLabel59.setForeground(this.lc.SECUNDARIO1);
/* 1396 */     this.jLabel59.setHorizontalAlignment(4);
/* 1397 */     this.jLabel59.setText("Total: ");
/* 1398 */     this.jPanel48.add(this.jLabel59);
/* 1399 */     this.jLabel49.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1400 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/* 1401 */     this.jLabel49.setHorizontalAlignment(2);
/* 1402 */     this.jLabel49.setText("t");
/* 1403 */     this.jPanel48.add(this.jLabel49);
/* 1404 */     GroupLayout jPanel137Layout = new GroupLayout(this.jPanel137);
/* 1405 */     this.jPanel137.setLayout(jPanel137Layout);
/* 1406 */     jPanel137Layout.setHorizontalGroup(jPanel137Layout
/* 1407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1408 */         .addComponent(this.jScrollPane34, -1, 518, 32767)
/* 1409 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1410 */           .addContainerGap()
/* 1411 */           .addComponent(this.jLabel1, -2, 147, -2)
/* 1412 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1413 */           .addComponent(this.jTextField6)
/* 1414 */           .addContainerGap())
/* 1415 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1416 */           .addComponent(this.jPanel48, -2, 138, -2)
/* 1417 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1418 */           .addComponent((Component)this.materialButton23, -2, 150, -2)));
/* 1419 */     jPanel137Layout.setVerticalGroup(jPanel137Layout
/* 1420 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1421 */         .addGroup(jPanel137Layout.createSequentialGroup()
/* 1422 */           .addContainerGap()
/* 1423 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1424 */             .addComponent(this.jLabel1)
/* 1425 */             .addComponent(this.jTextField6, -2, -1, -2))
/* 1426 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1427 */           .addComponent(this.jScrollPane34, -1, 220, 32767)
/* 1428 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1429 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1430 */             .addComponent((Component)this.materialButton23, -1, 38, 32767)
/* 1431 */             .addComponent(this.jPanel48, -1, -1, 32767))));
/* 1432 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1433 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1434 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1435 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1436 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 1437 */           .addGap(0, 0, 0)
/* 1438 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1439 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1440 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1441 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1442 */           .addComponent(this.jPanel137, -1, -1, 32767)
/* 1443 */           .addGap(0, 0, 0)));
/* 1444 */     this.jDialog5.setTitle("Cancelar Póliza");
/* 1445 */     this.jDialog5.setModal(true);
/* 1446 */     this.jLabel125.setFont(new Font("Cantarell", 0, 11));
/* 1447 */     this.jLabel125.setHorizontalAlignment(4);
/* 1448 */     this.jLabel125.setText("Motivo");
/* 1449 */     this.jTextArea5.setColumns(20);
/* 1450 */     this.jTextArea5.setLineWrap(true);
/* 1451 */     this.jTextArea5.setRows(5);
/* 1452 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/* 1453 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1454 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1455 */     this.materialButton36.setMnemonic('C');
/* 1456 */     this.materialButton36.setText("Cerrar");
/* 1457 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1458 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1459 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1460 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1462 */             ProvCheques.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1465 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1466 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1467 */     this.materialButton37.setMnemonic('A');
/* 1468 */     this.materialButton37.setText("Cancelar Póliza");
/* 1469 */     this.materialButton37.setToolTipText("Cancelar Póliza (Alt+A)");
/* 1470 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1471 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1472 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1474 */             ProvCheques.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1477 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1478 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1479 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1480 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1481 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1482 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1483 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 1484 */               .addComponent(this.jLabel125, -2, 64, -2)
/* 1485 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1486 */               .addComponent(this.jScrollPane18, -1, 328, 32767))
/* 1487 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1488 */               .addGap(0, 0, 32767)
/* 1489 */               .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1490 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1491 */               .addComponent((Component)this.materialButton36, -2, 105, -2)))
/* 1492 */           .addContainerGap()));
/* 1493 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1494 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1495 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1496 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1497 */             .addComponent(this.jLabel125)
/* 1498 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1500 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1501 */             .addComponent((Component)this.materialButton36, -2, 38, -2)
/* 1502 */             .addComponent((Component)this.materialButton37, -2, 38, -2))
/* 1503 */           .addContainerGap(-1, 32767)));
/* 1504 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1505 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1506 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1507 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1508 */         .addComponent(this.jPanel38, -1, -1, 32767));
/* 1509 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1510 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1511 */         .addComponent(this.jPanel38, -2, -1, -2));
/* 1512 */     this.cantidad.setText("jFormattedTextField2");
/* 1513 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1514 */     this.jComboBox7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1515 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "USUARIO" }));
/* 1516 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1518 */             ProvCheques.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1521 */     this.jPanel30.setLayout(new GridLayout(1, 3, 30, 0));
/* 1522 */     GridBagLayout jPanel9Layout1 = new GridBagLayout();
/* 1523 */     jPanel9Layout1.columnWidths = new int[] { 0, 5, 0 };
/* 1524 */     jPanel9Layout1.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 1525 */     this.jPanel9.setLayout(jPanel9Layout1);
/* 1526 */     this.jPanel30.add(this.jPanel9);
/* 1527 */     GridBagLayout jPanel16Layout = new GridBagLayout();
/* 1528 */     jPanel16Layout.columnWidths = new int[] { 0, 5, 0 };
/* 1529 */     jPanel16Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 1530 */     this.jPanel16.setLayout(jPanel16Layout);
/* 1531 */     this.jPanel30.add(this.jPanel16);
/* 1532 */     GridBagLayout jPanel18Layout = new GridBagLayout();
/* 1533 */     jPanel18Layout.columnWidths = new int[] { 0, 5, 0 };
/* 1534 */     jPanel18Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/* 1535 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1536 */     this.jPanel30.add(this.jPanel18);
/* 1537 */     GridBagLayout jPanel19Layout = new GridBagLayout();
/* 1538 */     jPanel19Layout.columnWidths = new int[] { 0, 5, 0 };
/* 1539 */     jPanel19Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/* 1540 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1541 */     this.jPanel21.setLayout(new GridLayout(1, 3, 30, 0));
/* 1542 */     GridBagLayout jPanel20Layout = new GridBagLayout();
/* 1543 */     jPanel20Layout.columnWidths = new int[] { 0, 5, 0 };
/* 1544 */     jPanel20Layout.rowHeights = new int[] { 0, 5, 0 };
/* 1545 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1546 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1547 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1548 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1549 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1550 */         .addComponent(this.jPanel20, -1, -1, 32767)
/* 1551 */         .addComponent(this.jPanel21, -1, 0, 32767)
/* 1552 */         .addComponent(this.jPanel19, -1, -1, 32767)
/* 1553 */         .addComponent(this.jPanel30, GroupLayout.Alignment.TRAILING, -1, 940, 32767));
/* 1554 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1555 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1556 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1557 */           .addComponent(this.jPanel30, -2, -1, -2)
/* 1558 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1559 */           .addComponent(this.jPanel19, -2, 61, -2)
/* 1560 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1561 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 1562 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1563 */           .addComponent(this.jPanel20, -2, 72, -2)
/* 1564 */           .addContainerGap(-1, 32767)));
/* 1565 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 1566 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/* 1567 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 1568 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 1569 */     this.jLabel55.setHorizontalAlignment(0);
/* 1570 */     this.jLabel55.setText("Póliza de cheques");
/* 1571 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/* 1572 */     this.jLabel233.setFont(new Font("Cantarell", 0, 11));
/* 1573 */     this.jLabel233.setHorizontalAlignment(4);
/* 1574 */     this.jLabel233.setText("Visualizando información del ");
/* 1575 */     this.jPanel7.setBackground(this.lc.SECUNDARIO2);
/* 1576 */     GridBagLayout jPanel7Layout = new GridBagLayout();
/* 1577 */     jPanel7Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*      */ 
/*      */     
/* 1580 */     jPanel7Layout.rowHeights = new int[] { 0 };
/* 1581 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1582 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1583 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1584 */     this.jDateChooser4.setIcon(this.icon);
/* 1585 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/* 1586 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 1587 */     gridBagConstraints.gridx = 4;
/* 1588 */     gridBagConstraints.gridy = 0;
/* 1589 */     gridBagConstraints.fill = 2;
/* 1590 */     gridBagConstraints.weightx = 1.0D;
/* 1591 */     this.jPanel7.add((Component)this.jDateChooser4, gridBagConstraints);
/* 1592 */     this.jLabel234.setFont(new Font("Cantarell", 0, 11));
/* 1593 */     this.jLabel234.setHorizontalAlignment(0);
/* 1594 */     this.jLabel234.setText("     al     ");
/* 1595 */     gridBagConstraints = new GridBagConstraints();
/* 1596 */     gridBagConstraints.gridx = 6;
/* 1597 */     gridBagConstraints.gridy = 0;
/* 1598 */     gridBagConstraints.fill = 2;
/* 1599 */     this.jPanel7.add(this.jLabel234, gridBagConstraints);
/* 1600 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1601 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1602 */     this.jDateChooser5.setIcon(this.icon);
/* 1603 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/* 1604 */     gridBagConstraints = new GridBagConstraints();
/* 1605 */     gridBagConstraints.gridx = 8;
/* 1606 */     gridBagConstraints.gridy = 0;
/* 1607 */     gridBagConstraints.fill = 2;
/* 1608 */     gridBagConstraints.weightx = 1.0D;
/* 1609 */     this.jPanel7.add((Component)this.jDateChooser5, gridBagConstraints);
/* 1610 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1611 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "Fecha de la Póliza", "Fecha del Cheque" }));
/* 1612 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1614 */             ProvCheques.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1617 */     gridBagConstraints = new GridBagConstraints();
/* 1618 */     gridBagConstraints.gridx = 10;
/* 1619 */     gridBagConstraints.gridy = 0;
/* 1620 */     gridBagConstraints.fill = 2;
/* 1621 */     gridBagConstraints.weightx = 1.0D;
/* 1622 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1623 */     this.jPanel7.add(this.jComboBox8, gridBagConstraints);
/* 1624 */     this.jComboBox10.setBackground(new Color(255, 255, 255));
/* 1625 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "MES", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/*      */ 
/*      */     
/* 1628 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1630 */             ProvCheques.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1633 */     gridBagConstraints = new GridBagConstraints();
/* 1634 */     gridBagConstraints.gridx = 0;
/* 1635 */     gridBagConstraints.gridy = 0;
/* 1636 */     this.jPanel7.add(this.jComboBox10, gridBagConstraints);
/* 1637 */     this.jComboBox11.setBackground(new Color(255, 255, 255));
/* 1638 */     gridBagConstraints = new GridBagConstraints();
/* 1639 */     gridBagConstraints.gridx = 2;
/* 1640 */     gridBagConstraints.gridy = 0;
/* 1641 */     this.jPanel7.add(this.jComboBox11, gridBagConstraints);
/* 1642 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/* 1643 */     this.jPanel11.setLayout(new GridLayout(1, 4, 6, 0));
/* 1644 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1645 */     this.jButton1.setMnemonic('F');
/* 1646 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 1647 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1649 */             ProvCheques.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1652 */     this.jPanel11.add(this.jButton1);
/* 1653 */     this.jLabel170.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 1654 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 1655 */     this.jLabel170.setHorizontalAlignment(0);
/* 1656 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 1657 */     this.jLabel170.setToolTipText("Retroceder un día en la búsqueda");
/* 1658 */     this.jLabel170.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1660 */             ProvCheques.this.jLabel170MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1664 */             ProvCheques.this.jLabel170MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1668 */             ProvCheques.this.jLabel170MouseExited(evt);
/*      */           }
/*      */         });
/* 1671 */     this.jPanel11.add(this.jLabel170);
/* 1672 */     this.jLabel101.setFont(new Font("Tahoma", 2, 12));
/* 1673 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 1674 */     this.jLabel101.setHorizontalAlignment(0);
/* 1675 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 1676 */     this.jLabel101.setToolTipText("Clic para filtrar los datos de HOY");
/* 1677 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1679 */             ProvCheques.this.jLabel101MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1683 */             ProvCheques.this.jLabel101MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1687 */             ProvCheques.this.jLabel101MouseExited(evt);
/*      */           }
/*      */         });
/* 1690 */     this.jPanel11.add(this.jLabel101);
/* 1691 */     this.jLabel171.setHorizontalAlignment(0);
/* 1692 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 1693 */     this.jLabel171.setToolTipText("Aumentar un día en la búsqueda");
/* 1694 */     this.jLabel171.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1696 */             ProvCheques.this.jLabel171MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1700 */             ProvCheques.this.jLabel171MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1704 */             ProvCheques.this.jLabel171MouseExited(evt);
/*      */           }
/*      */         });
/* 1707 */     this.jPanel11.add(this.jLabel171);
/* 1708 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1709 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1710 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1711 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1712 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1713 */           .addContainerGap()
/* 1714 */           .addComponent(this.jLabel233, -2, 155, -2)
/* 1715 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1716 */           .addComponent(this.jPanel7, -1, 594, 32767)
/* 1717 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1718 */           .addComponent(this.jPanel11, -2, 108, -2)
/* 1719 */           .addGap(28, 28, 28)));
/* 1720 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1721 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1722 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1723 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1724 */             .addComponent(this.jPanel11, -1, -1, 32767)
/* 1725 */             .addComponent(this.jLabel233, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1726 */             .addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1727 */           .addGap(0, 0, 32767)));
/* 1728 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1729 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1730 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1731 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1732 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1733 */           .addComponent(this.jLabel55)
/* 1734 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1735 */           .addComponent(this.jPanel6, -1, -1, 32767)));
/* 1736 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1738 */         .addComponent(this.jPanel6, -1, -1, 32767)
/* 1739 */         .addComponent(this.jLabel55, -1, -1, 32767));
/* 1740 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1741 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 1742 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 1743 */     this.jPanel17.setLayout(new GridLayout(1, 8, 6, 0));
/* 1744 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1745 */     this.jComboBox3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1746 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO" }));
/* 1747 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1749 */             ProvCheques.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1752 */     this.jPanel17.add(this.jComboBox3);
/* 1753 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1755 */             ProvCheques.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1758 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1760 */             ProvCheques.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1763 */     this.jPanel17.add(this.jTextField1);
/* 1764 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1766 */             ProvCheques.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1769 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1771 */             ProvCheques.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1774 */     this.jPanel17.add(this.jTextField2);
/* 1775 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1777 */             ProvCheques.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1780 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1782 */             ProvCheques.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1785 */     this.jPanel17.add(this.jTextField3);
/* 1786 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1788 */             ProvCheques.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1791 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1793 */             ProvCheques.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1796 */     this.jPanel17.add(this.jTextField4);
/* 1797 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1799 */             ProvCheques.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1802 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1804 */             ProvCheques.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1807 */     this.jPanel17.add(this.jTextField5);
/* 1808 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1809 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1810 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Aplicar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1811 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1813 */             ProvCheques.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1816 */     this.jPanel17.add(this.jComboBox2);
/* 1817 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1818 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1819 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "GASTOS POR SUCURSAL" }));
/* 1820 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1822 */             ProvCheques.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1825 */     this.jPanel17.add(this.jComboBox1);
/* 1826 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/* 1827 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/* 1828 */     this.jPanel3.setLayout(new GridLayout(1, 0, 6, 0));
/* 1829 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/* 1830 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/* 1831 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1832 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 1833 */     this.jLabel58.setHorizontalAlignment(4);
/* 1834 */     this.jLabel58.setText("Total: ");
/* 1835 */     this.jPanel47.add(this.jLabel58);
/* 1836 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1837 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 1838 */     this.jLabel48.setHorizontalAlignment(2);
/* 1839 */     this.jLabel48.setText("t");
/* 1840 */     this.jPanel47.add(this.jLabel48);
/* 1841 */     this.jPanel3.add(this.jPanel47);
/* 1842 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 1843 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1844 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1845 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1847 */         .addGap(0, 110, 32767));
/* 1848 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1850 */         .addGap(0, 36, 32767));
/* 1851 */     this.jPanel3.add(this.jPanel4);
/* 1852 */     this.jPanel5.setBackground(this.lc.SECUNDARIO2);
/* 1853 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1854 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1855 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1857 */         .addGap(0, 110, 32767));
/* 1858 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1859 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1860 */         .addGap(0, 36, 32767));
/* 1861 */     this.jPanel3.add(this.jPanel5);
/* 1862 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1863 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1864 */     this.jButton2.setMnemonic('N');
/* 1865 */     this.jButton2.setText("Nueva");
/* 1866 */     this.jButton2.setToolTipText("Nueva Cuenta (Alt + N)");
/* 1867 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1869 */             ProvCheques.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1872 */     this.jPanel3.add(this.jButton2);
/* 1873 */     this.jButton10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1874 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1875 */     this.jButton10.setMnemonic('M');
/* 1876 */     this.jButton10.setText("Modificar");
/* 1877 */     this.jButton10.setToolTipText("Modificar (Alt + M)");
/* 1878 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1880 */             ProvCheques.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1883 */     this.jPanel3.add(this.jButton10);
/* 1884 */     this.jButton11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1885 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1886 */     this.jButton11.setMnemonic('V');
/* 1887 */     this.jButton11.setText("Ver Detalle");
/* 1888 */     this.jButton11.setToolTipText("Ver Detalle (Alt+V)");
/* 1889 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1891 */             ProvCheques.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1894 */     this.jPanel3.add(this.jButton11);
/* 1895 */     this.jButton12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1896 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1897 */     this.jButton12.setMnemonic('C');
/* 1898 */     this.jButton12.setText("Cancelar");
/* 1899 */     this.jButton12.setToolTipText("Cancelar (Alt+C)");
/* 1900 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1902 */             ProvCheques.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1905 */     this.jPanel3.add(this.jButton12);
/* 1906 */     this.jButton13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1907 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1908 */     this.jButton13.setMnemonic('p');
/* 1909 */     this.jButton13.setText("Imprimir");
/* 1910 */     this.jButton13.setToolTipText("Imprimir (Alt+P)");
/* 1911 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1913 */             ProvCheques.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1916 */     this.jPanel3.add(this.jButton13);
/* 1917 */     this.jButton14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1918 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1919 */     this.jButton14.setMnemonic('G');
/* 1920 */     this.jButton14.setText("Guardar Reporte");
/* 1921 */     this.jButton14.setToolTipText("Guardar (Alt + G)");
/* 1922 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1924 */             ProvCheques.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1927 */     this.jPanel3.add(this.jButton14);
/* 1928 */     this.jPanel151.setBorder(BorderFactory.createBevelBorder(1));
/* 1929 */     this.jPanel151.setLayout(new GridLayout(1, 2, 12, 0));
/* 1930 */     this.jLabel221.setFont(new Font("Tahoma", 0, 10));
/* 1931 */     this.jLabel221.setHorizontalAlignment(4);
/* 1932 */     this.jLabel221.setText("TOTAL:");
/* 1933 */     this.jPanel151.add(this.jLabel221);
/* 1934 */     this.jLabel37.setFont(new Font("Tahoma", 1, 10));
/* 1935 */     this.jLabel37.setHorizontalAlignment(2);
/* 1936 */     this.jLabel37.setText("total");
/* 1937 */     this.jPanel151.add(this.jLabel37);
/* 1938 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1939 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1942 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1945 */     this.rSTableMetro1.setAltoHead(40);
/* 1946 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1947 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 1948 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 1949 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 1950 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 1951 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 1952 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 1953 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1954 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1955 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1956 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 1957 */     this.rSTableMetro1.setRowHeight(18);
/* 1958 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 1959 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 1960 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 1961 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 1962 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 1963 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1965 */             ProvCheques.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1968 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1970 */             ProvCheques.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1973 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/* 1974 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1975 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1976 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1978 */         .addComponent(this.jScrollPane13, GroupLayout.Alignment.TRAILING));
/* 1979 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1981 */         .addComponent(this.jScrollPane13, -1, 179, 32767));
/* 1982 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1983 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1984 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1985 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1986 */         .addComponent(this.jPanel3, -2, 1038, 32767)
/* 1987 */         .addComponent(this.jPanel151, -2, 0, 32767)
/* 1988 */         .addComponent(this.jPanel25, -1, -1, 32767));
/* 1989 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1991 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1992 */           .addComponent(this.jPanel25, -1, -1, 32767)
/* 1993 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1994 */           .addComponent(this.jPanel151, -2, -1, -2)
/* 1995 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1996 */           .addComponent(this.jPanel3, -2, 36, -2)
/* 1997 */           .addGap(8, 8, 8)));
/* 1998 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1999 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2000 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2001 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2002 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 2003 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 2004 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 2005 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2006 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2007 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2008 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 2009 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2010 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 2011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2012 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/* 2013 */     GroupLayout layout = new GroupLayout(this);
/* 2014 */     setLayout(layout);
/* 2015 */     layout.setHorizontalGroup(layout
/* 2016 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2017 */         .addGap(0, 1038, 32767)
/* 2018 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2019 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/* 2020 */     layout.setVerticalGroup(layout
/* 2021 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2022 */         .addGap(0, 316, 32767)
/* 2023 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2024 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2028 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2032 */     if (this.jTextField1.getText().equals(this.holderPoliza)) {
/* 2033 */       consultar();
/*      */     } else {
/* 2035 */       String campoFecha = "fechaPoliza";
/* 2036 */       if (this.jComboBox8.getSelectedIndex() != 0) {
/* 2037 */         campoFecha = "fechaCheque";
/*      */       }
/* 2039 */       this.encontrado = this.con.consultar(campoFecha, "prov_cheques", "where poliza like '%" + this.jTextField1.getText() + "%' order by " + campoFecha + " desc");
/* 2040 */       String f = this.con.Campo;
/* 2041 */       if (this.encontrado) {
/* 2042 */         String año = f.substring(0, 4);
/* 2043 */         String mes = f.substring(5, 7);
/* 2044 */         String dia = f.substring(8, 10);
/* 2045 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2046 */         String strFecha = año + "-" + año + "-" + mes;
/* 2047 */         Date fecha = null;
/*      */         try {
/* 2049 */           fecha = formatoDelTexto.parse(strFecha);
/* 2050 */         } catch (ParseException ex) {
/* 2051 */           ex.printStackTrace();
/*      */         } 
/* 2053 */         this.jDateChooser4.setDate(fecha);
/* 2054 */         this.jDateChooser5.setDate(fecha);
/*      */       } 
/* 2056 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel170MouseClicked(MouseEvent evt) {
/* 2061 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 2062 */     int aa = fecha.get(1);
/* 2063 */     int mm = fecha.get(2);
/* 2064 */     int dd = fecha.get(5);
/* 2065 */     if (dd == 1) {
/* 2066 */       if (mm == 0) {
/* 2067 */         mm = 11;
/* 2068 */         aa--;
/*      */       } else {
/* 2070 */         mm--;
/*      */       } 
/* 2072 */       int diasTotal = diasDelMes(mm, aa);
/* 2073 */       dd = diasTotal;
/*      */     } else {
/* 2075 */       dd--;
/*      */     } 
/* 2077 */     mm++;
/* 2078 */     String año = "" + aa;
/* 2079 */     String mes = "" + mm;
/* 2080 */     String dia = "" + dd;
/* 2081 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2082 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2084 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2085 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2086 */     } catch (ParseException ex) {
/* 2087 */       ex.printStackTrace();
/*      */     } 
/* 2089 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel170MouseEntered(MouseEvent evt) {
/* 2093 */     this.jLabel170.setForeground(new Color(153, 255, 153));
/* 2094 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel170MouseExited(MouseEvent evt) {
/* 2098 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 2099 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseClicked(MouseEvent evt) {
/* 2103 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2104 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2105 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel101MouseEntered(MouseEvent evt) {
/* 2109 */     this.jLabel101.setForeground(new Color(153, 255, 153));
/* 2110 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseExited(MouseEvent evt) {
/* 2114 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 2115 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseClicked(MouseEvent evt) {
/* 2119 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 2120 */     calendar.setTime(this.jDateChooser4.getDate());
/* 2121 */     calendar.add(6, 1);
/* 2122 */     this.jDateChooser4.setCalendar(calendar);
/* 2123 */     this.jDateChooser5.setCalendar(calendar);
/* 2124 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel171MouseEntered(MouseEvent evt) {
/* 2128 */     this.jLabel171.setForeground(new Color(153, 255, 153));
/* 2129 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseExited(MouseEvent evt) {
/* 2133 */     this.jLabel171.setForeground(new Color(15, 87, 51));
/* 2134 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 2138 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2142 */     String cadena = this.jTextField1.getText();
/* 2143 */     if (!cadena.equals("")) {
/* 2144 */       if (this.presionado == null) {
/* 2145 */         this.presionado = new Presionado();
/* 2146 */         this.presionado.start();
/*      */       } else {
/* 2148 */         this.presionado.detenerFuera();
/* 2149 */         this.presionado = new Presionado();
/* 2150 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2153 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 2158 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2162 */     String cadena = this.jTextField2.getText();
/* 2163 */     if (!cadena.equals("")) {
/* 2164 */       if (this.presionado == null) {
/* 2165 */         this.presionado = new Presionado();
/* 2166 */         this.presionado.start();
/*      */       } else {
/* 2168 */         this.presionado.detenerFuera();
/* 2169 */         this.presionado = new Presionado();
/* 2170 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2173 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2178 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2182 */     if (this.PRIMERA) {
/* 2183 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2188 */     consultar();
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2192 */     if (evt.getClickCount() == 2) {
/* 2193 */       verPolizaFicha();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2201 */     activar();
/* 2202 */     limpiarNuevo();
/* 2203 */     llenarSucursales();
/* 2204 */     limpiarTablaSuc();
/* 2205 */     if (!this.entraNueva) {
/* 2206 */       this.entraNueva = true;
/* 2207 */       llenarCuentas();
/* 2208 */       llenarProveedores();
/* 2209 */       llenarPersonas();
/*      */     } 
/* 2211 */     sacarPolizaMayor();
/* 2212 */     this.jTextField9.setEnabled(false);
/* 2213 */     this.materialButton22.setText("Guardar");
/* 2214 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 2215 */     this.jLabel13.setText("Nueva Póliza");
/* 2216 */     this.fichas.addTab("Nueva Póliza", this.jPanel1);
/* 2217 */     this.fichas.setSelectedIndex(2);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2221 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2222 */     if (indice < 0) {
/* 2223 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2225 */       if (!this.entraNueva) {
/* 2226 */         this.entraNueva = true;
/* 2227 */         llenarCuentas();
/* 2228 */         llenarProveedores();
/* 2229 */         llenarPersonas();
/*      */       } 
/* 2231 */       llenarSucursales();
/* 2232 */       limpiarTablaSuc();
/* 2233 */       this.ACTIVARSUC = "";
/* 2234 */       verPoliza();
/* 2235 */       activar();
/* 2236 */       String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2237 */       for (String v : sucursales) {
/* 2238 */         selecTablaSucursal(v);
/*      */       }
/* 2240 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2241 */       this.jTextField25.setToolTipText(suc);
/* 2242 */       if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2243 */         this.jTextField25.setEnabled(true);
/* 2244 */         this.jTextField25.setText("");
/* 2245 */         this.jButton57.setEnabled(true);
/*      */       } 
/* 2247 */       this.jLabel13.setText("INFORMACIÓN DE LA PÓLIZA: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 2248 */       this.materialButton22.setVisible(true);
/* 2249 */       this.materialButton22.setText("Modificar");
/* 2250 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 2251 */       this.fichas.addTab("Modificar Póliza: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)), this.jPanel1);
/* 2252 */       this.fichas.setSelectedIndex(2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2257 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2258 */     if (indice < 0) {
/* 2259 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una póliza para ver la información", "Selecciona una póliza", 0, this.ADVER);
/*      */     } else {
/* 2261 */       verPolizaFicha();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2266 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2267 */     if (indice < 0) {
/* 2268 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una póliza para poder cancelar", "Selecciona una póliza", 0, this.ADVER);
/*      */     } else {
/* 2270 */       String v = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2271 */       if (v.equals("<Por Aplicar>")) {
/* 2272 */         this.jTextArea5.setText("");
/* 2273 */         this.jDialog5.setTitle("Cancelar Póliza: " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)) + ", Cheque: " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 2)));
/* 2274 */         this.jDialog5.setVisible(true);
/*      */       } else {
/* 2276 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar ésta póliza porque su estatus no es '<Por Aplicar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2282 */     String fechaCompleta = "";
/* 2283 */     if (this.jComboBox10.getSelectedIndex() == 0) {
/* 2284 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2285 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 2286 */       String año = cadenaFecha1.substring(0, 4);
/* 2287 */       String mes = cadenaFecha1.substring(4, 6);
/* 2288 */       String dia = cadenaFecha1.substring(6, 8);
/* 2289 */       fechaCompleta = dia + "/" + dia + "/" + mes;
/* 2290 */       cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 2291 */       año = cadenaFecha1.substring(0, 4);
/* 2292 */       mes = cadenaFecha1.substring(4, 6);
/* 2293 */       dia = cadenaFecha1.substring(6, 8);
/* 2294 */       fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/*      */     } else {
/* 2296 */       fechaCompleta = String.valueOf(this.jComboBox10.getSelectedItem()) + "/" + String.valueOf(this.jComboBox10.getSelectedItem());
/*      */     } 
/* 2298 */     String tipo = "GENERAL";
/* 2299 */     if (!this.jComboBox3.getSelectedItem().toString().equals("TIPO")) {
/* 2300 */       tipo = this.jComboBox3.getSelectedItem().toString();
/*      */     }
/* 2302 */     String poliza = "GENERAL";
/* 2303 */     if (!this.jTextField1.getText().equals(this.holderPoliza)) {
/* 2304 */       poliza = this.jTextField1.getText().toUpperCase();
/*      */     }
/* 2306 */     String cheque = "GENERAL";
/* 2307 */     if (!this.jTextField2.getText().equals(this.holderCheque)) {
/* 2308 */       cheque = this.jTextField2.getText().toUpperCase();
/*      */     }
/* 2310 */     String cuenta = "GENERAL";
/* 2311 */     if (!this.jTextField3.getText().equals(this.holderCuenta)) {
/* 2312 */       cuenta = this.jTextField3.getText().toUpperCase();
/*      */     }
/* 2314 */     String beneficiario = "GENERAL";
/* 2315 */     if (!this.jTextField4.getText().equals(this.holderBeneficiario)) {
/* 2316 */       beneficiario = this.jTextField4.getText().toUpperCase();
/*      */     }
/* 2318 */     String concepto = "GENERAL";
/* 2319 */     if (!this.jTextField5.getText().equals(this.holderConcepto)) {
/* 2320 */       concepto = this.jTextField5.getText().toUpperCase();
/*      */     }
/* 2322 */     String base = "GENERAL";
/* 2323 */     if (!this.jComboBox1.getSelectedItem().toString().equals("GASTOS POR SUCURSAL")) {
/* 2324 */       base = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 2326 */     JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "cont", "Poliza", "Cheque", "Fecha", "Importe", "Beneficiario", "Concepto", "Tipo", "Comprobante", "Estado" });
/* 2327 */     Map<Object, Object> datos = new HashMap<>();
/* 2328 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2329 */     datos.put("periodo", fechaCompleta);
/* 2330 */     datos.put("tipo", tipo);
/* 2331 */     datos.put("poliza", poliza);
/* 2332 */     datos.put("chequito", cheque);
/* 2333 */     datos.put("cuenta", cuenta);
/* 2334 */     datos.put("beneficiario", beneficiario);
/* 2335 */     datos.put("concepto", concepto);
/* 2336 */     datos.put("base", base);
/* 2337 */     datos.put("TTotal", this.jLabel37.getText());
/* 2338 */     this.utilerias.cargarImagenesAReporte(datos);
/*      */     try {
/* 2340 */       this.utilerias.verImpresion("/Reportes/Proveedores/Prov_ChequesGral.jasper", aux, datos, "Reporte de Pólizas de Cheques");
/* 2341 */     } catch (JRException ex) {
/* 2342 */       Logger.getLogger(ProvCheques.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2347 */     String[] datos = { "PÓLIZA", "FECHA DE PÓLIZA", "CHEQUE", "FECHA DEL CHEQUE", "IMPORTE", "CUENTA", "BENEFICIARIO", "CONCEPTO", "TIPO", "SUCURSAL", "COMPROBADO", "ESTADO", "ACTUALIZO (dd/mm/aaaa)" };
/*      */ 
/*      */     
/* 2350 */     this.esc = new EscribirReporte("PÓLIZAS DE CHEQUES", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 2354 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2358 */     String cadena = this.jTextField3.getText();
/* 2359 */     if (!cadena.equals("")) {
/* 2360 */       if (this.presionado == null) {
/* 2361 */         this.presionado = new Presionado();
/* 2362 */         this.presionado.start();
/*      */       } else {
/* 2364 */         this.presionado.detenerFuera();
/* 2365 */         this.presionado = new Presionado();
/* 2366 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2369 */       this.jTextField3.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {
/* 2374 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 2378 */     String cadena = this.jTextField4.getText();
/* 2379 */     if (!cadena.equals("")) {
/* 2380 */       if (this.presionado == null) {
/* 2381 */         this.presionado = new Presionado();
/* 2382 */         this.presionado.start();
/*      */       } else {
/* 2384 */         this.presionado.detenerFuera();
/* 2385 */         this.presionado = new Presionado();
/* 2386 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2389 */       this.jTextField4.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2394 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA) {
/* 2395 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 2400 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 2404 */     String cadena = this.jTextField5.getText();
/* 2405 */     if (!cadena.equals("")) {
/* 2406 */       if (this.presionado == null) {
/* 2407 */         this.presionado = new Presionado();
/* 2408 */         this.presionado.start();
/*      */       } else {
/* 2410 */         this.presionado.detenerFuera();
/* 2411 */         this.presionado = new Presionado();
/* 2412 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2415 */       this.jTextField5.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jTextField25ActionPerformed(ActionEvent evt) {
/* 2426 */     String v = this.jTextField25.getText().toUpperCase();
/* 2427 */     if (!this.TODOS_SUCURSALES.contains(v)) {
/* 2428 */       JOptionPane.showMessageDialog(this.padre, "Verifica tu información porque has ingresado una sucursal que no se encuentra registrada.", "Sucursal Incorrecta", 0, this.ERROR);
/* 2429 */       this.jTextField25.setText("");
/*      */     } else {
/* 2431 */       selecTablaSucursal(v);
/* 2432 */       JOptionPane.showMessageDialog(this.padre, "Los datos también se visualizarán en la sucursal de: " + v, "Visualizando datos en otra sucursal", 0, this.INFO);
/* 2433 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2434 */       this.jTextField25.setToolTipText(suc);
/* 2435 */       this.jTextField25.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 2440 */     Dimension di = this.jButton57.getSize();
/* 2441 */     Point p = this.jButton57.getLocationOnScreen();
/* 2442 */     this.jDialog1.setLocation(p.x + di.width - this.jDialog1.getWidth(), p.y + 30);
/* 2443 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseClicked(MouseEvent evt) {
/* 2447 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/* 2448 */     this.fichas.remove(2);
/*      */   }
/*      */   
/*      */   private void jLabel16MouseEntered(MouseEvent evt) {
/* 2452 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar2.png")));
/*      */   }
/*      */   
/*      */   private void jLabel16MouseExited(MouseEvent evt) {
/* 2456 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cerrar1.png")));
/*      */   }
/*      */   
/*      */   private void jButton58ActionPerformed(ActionEvent evt) {
/* 2460 */     Dimension di = this.jButton58.getSize();
/* 2461 */     Point p = this.jButton58.getLocationOnScreen();
/* 2462 */     this.jDialog2.setLocation(p.x + di.width - 200, p.y + 30);
/* 2463 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton52ActionPerformed(ActionEvent evt) {
/* 2467 */     Dimension di = this.jButton52.getSize();
/* 2468 */     Point p = this.jButton52.getLocationOnScreen();
/* 2469 */     String t = this.jComboBox5.getSelectedItem().toString();
/* 2470 */     consultarDatoExtra();
/* 2471 */     this.jDialog4.setLocation(p.x + di.width + 10, p.y + 0);
/* 2472 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 2476 */     this.fichas.removeTabAt(2);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 2480 */     if (this.materialButton22.getText().equals("Imprimir")) {
/* 2481 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir la póliza de cheque?", "Imprimir Póliza: " + this.jTextField7.getText(), 0, 3, this.PREG);
/* 2482 */       if (res == 0) {
/* 2483 */         imprimirPoliza();
/*      */       }
/* 2485 */       res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el cheque?", "Imprimir Cheque: " + this.jTextField8.getText(), 0, 3, this.PREG);
/* 2486 */       if (res == 0) {
/* 2487 */         imprimirCheque();
/*      */       }
/*      */     } else {
/* 2490 */       String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2491 */       String actualizo = this.USUARIO + this.USUARIO;
/* 2492 */       if (this.jTextField7.getText().equals("")) {
/* 2493 */         this.error.cargarError(this.jTextField7, "050");
/* 2494 */       } else if (this.jDateChooser6.getDate() == null) {
/* 2495 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la fecha de la póliza", "Falta fecha de póliza", 0, this.ERROR);
/* 2496 */       } else if (this.jComboBox6.getSelectedIndex() == 0) {
/* 2497 */         this.error.cargarError(this.jComboBox6, "050");
/* 2498 */       } else if (this.jComboBox6.getSelectedItem().equals("OTRO...") && this.jTextField9.getText().equals("")) {
/* 2499 */         this.error.cargarError(this.jTextField9, "050");
/* 2500 */       } else if (this.jTextField10.getText().equals("")) {
/* 2501 */         this.error.cargarError(this.jTextField10, "050");
/* 2502 */       } else if (this.jComboBox5.getSelectedIndex() == 0) {
/* 2503 */         this.error.cargarError(this.jComboBox5, "050");
/* 2504 */       } else if (this.jComboBox4.getSelectedIndex() == 0) {
/* 2505 */         this.error.cargarError(this.jComboBox4, "050");
/* 2506 */       } else if (this.jTextField8.getText().equals("")) {
/* 2507 */         this.error.cargarError(this.jTextField8, "050");
/* 2508 */       } else if (this.jDateChooser7.getDate() == null) {
/* 2509 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la fecha del cheque", "Falta fecha del cheque", 0, this.ERROR);
/* 2510 */       } else if (this.jTextPane1.getText().equals("")) {
/* 2511 */         this.error.cargarError(this.jTextPane1, "050");
/* 2512 */       } else if (this.importe.getText().equals("$0.00")) {
/* 2513 */         this.error.cargarError(this.importe, "050");
/* 2514 */       } else if (suc.equals("")) {
/* 2515 */         this.jTextField25.setBackground(Color.RED);
/* 2516 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la sucursal operativa\nPor lo menos debe estar seleccionada una sucursal.", "Falta sucursal operativa", 0, this.ADVER);
/* 2517 */       } else if (!this.val.validarTexto(this.jTextField9, this.jTextField9.getText(), "018") && 
/* 2518 */         !this.val.validarTexto(this.jTextField10, this.jTextField10.getText(), "018")) {
/* 2519 */         if (this.importe.getText().contains("-")) {
/* 2520 */           this.error.cargarError(this.importe, "063");
/* 2521 */         } else if (!this.val.validarTexto(this.jTextPane2, this.jTextPane2.getText(), "014")) {
/* 2522 */           DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 2523 */           ZoneId defaultZoneId = ZoneId.systemDefault();
/* 2524 */           Instant instant = this.jDateChooser7.getDate().toInstant();
/* 2525 */           LocalDate fechaCheque = instant.atZone(defaultZoneId).toLocalDate();
/* 2526 */           String fechaChequesql = fechaCheque.format(formatoFecha);
/* 2527 */           instant = this.jDateChooser6.getDate().toInstant();
/* 2528 */           LocalDate fechaPoliza = instant.atZone(defaultZoneId).toLocalDate();
/* 2529 */           String fechaPolizasql = fechaPoliza.format(formatoFecha);
/* 2530 */           String beneficiario = this.jComboBox6.getSelectedItem().toString();
/* 2531 */           int numProv = 0;
/* 2532 */           if (this.jComboBox6.getSelectedItem().equals("OTRO...")) {
/* 2533 */             beneficiario = this.jTextField9.getText().toUpperCase();
/*      */           } else {
/* 2535 */             int indiceProv = this.jComboBox6.getSelectedIndex();
/* 2536 */             numProv = ((Proveedores)this.PROVEEDORES.get(indiceProv - 1)).getNumProv();
/* 2537 */             beneficiario = ((Proveedores)this.PROVEEDORES.get(indiceProv - 1)).getRazonSocial();
/*      */           } 
/* 2539 */           String comprobante = "PC";
/* 2540 */           if (this.jRadioButton3.isSelected()) {
/* 2541 */             comprobante = "C";
/*      */           }
/* 2543 */           if (this.jRadioButton2.isSelected()) {
/* 2544 */             comprobante = "SC";
/*      */           }
/* 2546 */           if (this.jRadioButton4.isSelected()) {
/* 2547 */             comprobante = "N/A";
/*      */           }
/* 2549 */           int cuenta = this.jComboBox4.getSelectedIndex();
/* 2550 */           cuenta--;
/* 2551 */           String fact = "";
/* 2552 */           for (Object v : this.FACTURASAGREGADAS.toArray()) {
/* 2553 */             fact = fact + ", " + fact;
/*      */           }
/* 2555 */           if (this.materialButton22.getText().equals("Guardar")) {
/* 2556 */             String[] campos = { "Póliza", "Fecha de la Póiza", "Beneficiario", "Cobrado por", "Tipo de Cheque", "Cuenta", "Cheque", "Fecha del cheque", "Concepto", "Importe", "Comprobante", "Sucursal Operativa" };
/*      */ 
/*      */ 
/*      */             
/* 2560 */             String[] info = { this.jTextField7.getText().toUpperCase(), (new Date()).toString(), beneficiario, this.jTextField10.getText().toUpperCase(), this.jComboBox5.getSelectedItem().toString(), this.jComboBox4.getSelectedItem().toString(), this.jTextField8.getText().toUpperCase(), fechaChequesql, this.jTextPane1.getText().toUpperCase(), this.importe.getText(), comprobante, suc };
/*      */             
/* 2562 */             String[] datos = this.con.regresaReg("poliza, fechaPoliza, cheque, beneficiario, importe", "prov_cheques", "where cheque = '" + this.jTextField8.getText() + "' and cuentaOrigen ='" + ((Cuentas)this.CUENTAS.get(this.jComboBox4.getSelectedIndex() - 1)).cuenta + "'", 5);
/* 2563 */             if (datos[0] != null) {
/* 2564 */               JOptionPane.showMessageDialog(this.padre, "<html>El número de cheque ya lo has agregado anteriormente, a continuación de enlistan los datos:<br>PÓLIZA: <b> " + datos[0] + "</b><br>FECHA DE LA PÓLIZA: <b> " + datos[1] + "</b><br>NÚMERO DE CHEQUE: <b> " + datos[2] + "</b><br>BENEFICIARIO: <b> " + datos[3] + "</b><br>IMPORTE: <b> " + datos[4] + "</b></html>", "Datos existentes", 0, this.ADVER);
/*      */             }
/* 2566 */             int res = this.error.cargarDatos(campos, info);
/* 2567 */             if (res == 0) {
/* 2568 */               this.con.inserSinMsj("insert into prov_cheques (poliza, fechaPoliza, tipo,cheque, fechaCheque, cuentaOrigen,beneficiario, cobradoPor, concepto,facturasAmparadas, importe, comprobante,motivoCancelacion, comentarioGral, estado,gastosDe, sucOp, usuario, numProv) values ('" + this.jTextField7
/* 2569 */                   .getText().toUpperCase() + "', '" + fechaPolizasql + "', '" + String.valueOf(this.jComboBox5.getSelectedItem()) + "', '" + this.jTextField8
/* 2570 */                   .getText().toUpperCase() + "', '" + fechaChequesql + "', '" + ((Cuentas)this.CUENTAS.get(cuenta)).getCuenta() + "', '" + beneficiario + "', '" + this.jTextField10
/* 2571 */                   .getText().toUpperCase() + "', '" + this.jTextPane1.getText().toUpperCase() + "', '" + fact + "', '" + this.importe
/* 2572 */                   .getText() + "', '" + comprobante + "', '', '" + this.jTextPane2
/* 2573 */                   .getText().toUpperCase() + "','<Por Aplicar>', '" + 
/* 2574 */                   String.valueOf(this.jComboBox9.getSelectedItem()) + "', '" + suc + "', '" + actualizo + "'," + numProv + ")");
/* 2575 */               res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir la póliza de cheque?", "Imprimir Póliza: " + this.jTextField7.getText(), 0, 3, this.PREG);
/* 2576 */               if (res == 0) {
/* 2577 */                 imprimirPoliza();
/*      */               }
/*      */               try {
/* 2580 */                 res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el cheque?", "Imprimir Cheque: " + this.jTextField8.getText(), 0, 3, this.PREG);
/* 2581 */               } catch (HeadlessException ex) {
/* 2582 */                 Logger.getLogger(ProvCheques.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */               } 
/* 2584 */               if (res == 0) {
/* 2585 */                 imprimirCheque();
/*      */               }
/* 2587 */               this.fichas.removeTabAt(2);
/* 2588 */               consultar();
/*      */             } 
/* 2590 */           } else if (this.materialButton22.getText().equals("Modificar")) {
/* 2591 */             String[] campos = { "Póliza", "Fecha de la Póliza", "Beneficiario", "Cobrado por", "Tipo de Cheque", "Cuenta", "Cheque", "Fecha del cheque", "Concepto", "Importe", "Comprobante", "Sucursal Operativa" };
/*      */ 
/*      */ 
/*      */             
/* 2595 */             String[] info = { this.jTextField7.getText().toUpperCase(), (new Date()).toString(), beneficiario, this.jTextField10.getText().toUpperCase(), this.jComboBox5.getSelectedItem().toString(), this.jComboBox4.getSelectedItem().toString(), this.jTextField8.getText().toUpperCase(), fechaChequesql, this.jTextPane1.getText().toUpperCase(), this.importe.getText(), comprobante, suc };
/*      */             
/* 2597 */             int res = this.error.cargarDatos2(campos, info);
/* 2598 */             if (res == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2612 */               this.con.inserSinMsj("update prov_cheques set poliza='" + this.jTextField7.getText() + "',  fechaPoliza = '" + fechaPolizasql + "', tipo ='" + 
/* 2613 */                   String.valueOf(this.jComboBox5.getSelectedItem()) + "', cheque='" + this.jTextField8.getText().toUpperCase() + "',  fechaCheque = '" + fechaChequesql + "', cuentaOrigen='" + ((Cuentas)this.CUENTAS
/* 2614 */                   .get(cuenta)).getCuenta() + "', beneficiario='" + beneficiario + "',  cobradoPor ='" + this.jTextField10
/* 2615 */                   .getText().toUpperCase() + "', concepto='" + this.jTextPane1.getText().toUpperCase() + "', importe='" + this.importe.getText() + "',  comprobante='" + comprobante + "', comentarioGral='" + this.jTextPane2
/* 2616 */                   .getText().toUpperCase() + "', sucOp='" + suc + "',  usuario='" + actualizo + "', numProv= " + numProv + ", gastosDe = '" + 
/* 2617 */                   String.valueOf(this.jComboBox9.getSelectedItem()) + "'  where poliza='" + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString() + "'");
/* 2618 */               res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir la póliza de cheque?", "Imprimir Póliza: " + this.jTextField7.getText(), 0, 3, this.PREG);
/* 2619 */               if (res == 0) {
/* 2620 */                 imprimirPoliza();
/*      */               }
/* 2622 */               res = JOptionPane.showConfirmDialog(this.padre, "¿Deseas imprimir el cheque?", "Imprimir Cheque: " + this.jTextField8.getText(), 0, 3, this.PREG);
/* 2623 */               if (res == 0) {
/* 2624 */                 imprimirCheque();
/*      */               }
/* 2626 */               this.fichas.removeTabAt(2);
/* 2627 */               consultar();
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2636 */     if (this.jComboBox6.getSelectedItem().equals("OTRO...")) {
/* 2637 */       this.jTextField9.setEnabled(true);
/* 2638 */       this.jTextField9.setText("");
/* 2639 */       this.jTextField10.setText("");
/*      */     } else {
/* 2641 */       this.jTextField9.setText("");
/* 2642 */       this.jTextField9.setEnabled(false);
/* 2643 */       this.jTextField10.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2648 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 2649 */       this.jTextField8.setText("");
/* 2650 */     } else if (this.jTextField8.isEnabled()) {
/* 2651 */       int selec = this.jComboBox4.getSelectedIndex();
/* 2652 */       String cuentaOrigen = ((Cuentas)this.CUENTAS.get(selec - 1)).getCuenta();
/* 2653 */       this.encontrado = this.con.consultar("cheque", "prov_cheques", "where cuentaOrigen ='" + cuentaOrigen + "' order by num desc");
/* 2654 */       String mayor = this.con.Campo;
/* 2655 */       int MAYOR = 0;
/* 2656 */       if (this.encontrado) {
/* 2657 */         if (mayor != null) {
/* 2658 */           MAYOR = Integer.parseInt(mayor);
/* 2659 */           MAYOR++;
/* 2660 */           this.jTextField8.setText("" + MAYOR);
/*      */         } 
/*      */       } else {
/* 2663 */         this.jTextField8.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 2669 */     if (evt.getClickCount() == 2) {
/* 2670 */       this.jComboBox5.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/* 2671 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 2679 */     this.jTextField16.setText("");
/* 2680 */     this.jButton16.setText("Agregar");
/* 2681 */     this.jButton16.setMnemonic('A');
/* 2682 */     this.jButton16.setToolTipText("Agregar Tipo (Alt+A)");
/* 2683 */     this.jDialog3.setTitle("Nuevo Tipo");
/* 2684 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 2688 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 2689 */     if (ind < 0) {
/* 2690 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un tipo de cheque", 0, this.ADVER);
/*      */     } else {
/* 2692 */       this.jButton16.setText("Modificar");
/* 2693 */       this.jButton16.setMnemonic('M');
/* 2694 */       this.jButton16.setToolTipText("Modificar tipo (Alt+M)");
/* 2695 */       this.jTextField16.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/* 2696 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 2701 */     int ind = this.rSTableMetro3.getSelectedRow();
/* 2702 */     if (ind < 0) {
/* 2703 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*      */     } else {
/* 2705 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas eleiminar el tipo de cheque que seleccionaste?", "Eliminar tipo", 0, 3, this.PREG);
/* 2706 */       if (res == 0) {
/* 2707 */         this.con.eliminar2("prov_cheques_cat_tipo", "where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 2708 */         llenarTipo();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField16ActionPerformed(ActionEvent evt) {
/* 2714 */     agregarTipo();
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2718 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2722 */     agregarTipo();
/*      */   }
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 2726 */     if (evt.getClickCount() == 2) {
/* 2727 */       agregarDato();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 2735 */     int indice = this.rSTableMetro4.getSelectedRow();
/* 2736 */     if (indice < 0) {
/* 2737 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas seleccionar un registro para agregar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2739 */       agregarDato();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2744 */     if (this.jComboBox5.getItemCount() > 0) {
/* 2745 */       this.FACTURASAGREGADAS = new ArrayList<>();
/* 2746 */       String t = this.jComboBox5.getSelectedItem().toString();
/* 2747 */       this.jTextPane1.setText("");
/* 2748 */       if (t.equals("FACILIDAD ADMINISTRATIVA") || t.equals("DEVOLUCIONES AL CLIENTE")) {
/* 2749 */         this.jRadioButton2.setSelected(true);
/*      */       } else {
/* 2751 */         this.jRadioButton1.setSelected(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2757 */     consultarDatoExtra();
/*      */   }
/*      */   
/*      */   private void jTextField10FocusGained(FocusEvent evt) {
/* 2761 */     if (this.jTextField10.getText().equals("")) {
/* 2762 */       if (!this.jTextField9.getText().equals("")) {
/* 2763 */         String usuario = this.jTextField9.getText().toUpperCase();
/* 2764 */         this.jTextField9.setText(usuario);
/* 2765 */         this.jTextField10.setText(usuario);
/* 2766 */       } else if (!this.jComboBox6.getSelectedItem().toString().equals("OTRO...")) {
/* 2767 */         int indiceProv = this.jComboBox6.getSelectedIndex();
/* 2768 */         this.jTextField10.setText(((Proveedores)this.PROVEEDORES.get(indiceProv - 1)).getRazonSocial());
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 2777 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 2781 */     cancelar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 2788 */     int v = this.jComboBox10.getSelectedIndex();
/* 2789 */     if (v == 0) {
/* 2790 */       this.jDateChooser4.setEnabled(true);
/* 2791 */       this.jDateChooser5.setEnabled(true);
/* 2792 */       this.jComboBox11.setEnabled(false);
/*      */     } else {
/* 2794 */       this.jDateChooser4.setEnabled(false);
/* 2795 */       this.jDateChooser5.setEnabled(false);
/* 2796 */       this.jComboBox11.setEnabled(true);
/*      */     } 
/* 2798 */     if (this.PRIMERA) {
/* 2799 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 2804 */     Object[] Columnas = columnas;
/* 2805 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 2806 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 2807 */       registros[i][0] = Integer.valueOf(i + 1);
/* 2808 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 2809 */         if (j == 0) {
/* 2810 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 2812 */         if (j == 2) {
/* 2813 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 2815 */         if (j == 3) {
/* 2816 */           registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 2818 */         if (j == 4) {
/* 2819 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 2821 */         if (j == 6) {
/* 2822 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 2824 */         if (j == 7) {
/* 2825 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 2827 */         if (j == 8) {
/* 2828 */           registros[i][7] = Original.getValueAt(i, j).toString();
/*      */         }
/* 2830 */         if (j == 10) {
/* 2831 */           registros[i][8] = Original.getValueAt(i, j).toString();
/*      */         }
/* 2833 */         if (j == 11) {
/* 2834 */           registros[i][9] = Original.getValueAt(i, j).toString();
/*      */         }
/*      */       } 
/*      */     } 
/* 2838 */     JTable aux = new JTable(registros, Columnas);
/* 2839 */     return aux;
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 2843 */     String fechaCorta = fecha.substring(0, 10);
/* 2844 */     String año = fechaCorta.substring(0, 4);
/* 2845 */     String mes = fechaCorta.substring(5, 7);
/* 2846 */     String dia = fechaCorta.substring(8, 10);
/* 2847 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 2848 */     return strFecha;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2852 */     String motivo = this.jTextArea5.getText();
/* 2853 */     if (motivo.equals("")) {
/* 2854 */       this.jTextArea5.setBackground(Color.RED);
/* 2855 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar el motivo de cancelación de la póliza", "Ingresa un comentario", 0, this.ERROR);
/*      */     } else {
/* 2857 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas cancelar la póliza que seleccionaste?", "Cancelar Póliza", 0, 3, this.PREG);
/* 2858 */       if (res == 0) {
/* 2859 */         String actualizo = this.USUARIO + this.USUARIO;
/* 2860 */         String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 2861 */         this.con.inserSinMsj("update prov_cheques set estado='<Cancelada>', motivoCancelacion ='" + this.jTextArea5.getText().toUpperCase() + "',usuario='" + actualizo + "', importe = '$0.00' where poliza='" + num + "'");
/* 2862 */         if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2863 */           DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro1.getModel();
/* 2864 */           temp.removeRow(this.rSTableMetro1.getSelectedRow());
/* 2865 */           this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 2866 */           this.jLabel37.setText("$0.00");
/* 2867 */           calcularTotales();
/*      */         } else {
/* 2869 */           consultar();
/*      */         } 
/* 2871 */         this.jDialog5.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 2877 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR"));
/*      */   }
/*      */   
/*      */   public String iniciales(String nombre, String apPat, String apMat) {
/* 2881 */     String iniciales = "";
/* 2882 */     iniciales = "" + nombre.charAt(0) + " " + nombre.charAt(0) + " " + apPat.charAt(0);
/* 2883 */     return iniciales;
/*      */   }
/*      */   
/*      */   public void imprimirPoliza() {
/* 2887 */     String prov = "";
/* 2888 */     double total = convertirCantTexto(this.importe.getText());
/* 2889 */     NumerosALetras numLetra = new NumerosALetras(total, "PESOS");
/* 2890 */     if (this.jComboBox6.getSelectedItem().equals("OTRO...")) {
/* 2891 */       prov = this.jTextField9.getText();
/*      */     } else {
/* 2893 */       prov = ((Proveedores)this.PROVEEDORES.get(this.jComboBox6.getSelectedIndex() - 1)).getRazonSocial();
/*      */     } 
/* 2895 */     Map<Object, Object> datos = new HashMap<>();
/* 2896 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 2897 */     datos.put("usuario", iniciales(this.CAMPOSGENERALES.get("empleados.nombre"), this.CAMPOSGENERALES.get("empleados.ap_pat"), this.CAMPOSGENERALES.get("empleados.ap_mat")));
/* 2898 */     datos.put("proveedor", prov);
/* 2899 */     datos.put("fecha", getFechaddMMaaaa(this.jDateChooser6.getDate()));
/* 2900 */     datos.put("cantidadNum", this.importe.getText());
/* 2901 */     datos.put("cantidadLetra", numLetra.regresaNumero() + " M.N.");
/* 2902 */     datos.put("numCheque", this.jTextField8.getText().toUpperCase());
/* 2903 */     datos.put("numCuenta", ((Cuentas)this.CUENTAS.get(this.jComboBox4.getSelectedIndex() - 1)).getCuenta());
/* 2904 */     datos.put("banco", ((Cuentas)this.CUENTAS.get(this.jComboBox4.getSelectedIndex() - 1)).getBancoCorto());
/* 2905 */     datos.put("concepto", this.jTextPane1.getText().toUpperCase());
/* 2906 */     datos.put("folio", this.jTextField7.getText().toUpperCase());
/* 2907 */     datos.put("fechaActual", this.utilerias.convertirFechaDateString(new Date()));
/* 2908 */     this.utilerias.cargarImagenesAReporte(datos);
/*      */     try {
/* 2910 */       JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_Poliza.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 2911 */       JasperPrintManager.printReport(reporte, true);
/* 2912 */     } catch (JRException ex) {
/* 2913 */       Logger.getLogger(ProvCheques.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirCheque() {
/* 2918 */     double total = convertirCantTexto(this.importe.getText());
/* 2919 */     NumerosALetras numLetra = new NumerosALetras(total, "PESOS");
/* 2920 */     String[] MES = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };
/*      */ 
/*      */     
/* 2923 */     String fechaCheque = getFechaddMMaaaa(this.jDateChooser7.getDate());
/* 2924 */     String dd = fechaCheque.substring(0, 3);
/* 2925 */     String mm = fechaCheque.substring(3, 5);
/* 2926 */     String aa = fechaCheque.substring(5, fechaCheque.length());
/* 2927 */     Map<String, Object> datos = new HashMap<>();
/* 2928 */     datos.put("fecha", dd + dd + MES[Integer.parseInt(mm) - 1]);
/* 2929 */     datos.put("cantidad", this.importe.getText().substring(1));
/* 2930 */     datos.put("letra", numLetra.regresaNumero() + " M.N.");
/* 2931 */     datos.put("aFavorDe", this.jTextField10.getText().toUpperCase());
/* 2932 */     String rutaReporte = "";
/* 2933 */     if (this.jComboBox9.getSelectedItem().toString().equals("VERACRUZ") && this.jComboBox4.getSelectedItem().toString().equals("0953 BANAMEX")) {
/* 2934 */       rutaReporte = "/Reportes/Proveedores/Prov_ChequeVer0953.jasper";
/*      */     } else {
/* 2936 */       rutaReporte = "/Reportes/Proveedores/Prov_ChequeIndividual.jasper";
/*      */     } 
/*      */     try {
/* 2939 */       JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream(rutaReporte), datos, (JRDataSource)new JREmptyDataSource());
/*      */       
/* 2941 */       JasperPrintManager.printReport(reporte, true);
/* 2942 */     } catch (JRException ex) {
/* 2943 */       Logger.getLogger(ProvCheques.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verPolizaFicha() {
/* 2948 */     if (!this.entraNueva) {
/* 2949 */       this.entraNueva = true;
/* 2950 */       llenarCuentas();
/* 2951 */       llenarProveedores();
/* 2952 */       llenarPersonas();
/*      */     } 
/* 2954 */     llenarSucursales();
/* 2955 */     limpiarTablaSuc();
/* 2956 */     this.ACTIVARSUC = "";
/* 2957 */     verPoliza();
/* 2958 */     this.jTextField9.setEnabled(false);
/* 2959 */     this.jDateChooser6.setEnabled(false);
/* 2960 */     String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2961 */     for (String v : sucursales) {
/* 2962 */       selecTablaSucursal(v);
/*      */     }
/* 2964 */     String suc = dameSucursalOp(this.jTextField25, (JTable)this.rSTableMetro2);
/* 2965 */     this.jTextField25.setToolTipText(suc);
/* 2966 */     this.materialButton22.setText("Imprimir");
/* 2967 */     this.materialButton22.setToolTipText("Imprimir (Alt + P)");
/* 2968 */     this.materialButton22.setMnemonic('P');
/* 2969 */     this.fichas.addTab("Póliza: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString(), this.jPanel1);
/* 2970 */     this.jLabel13.setText("Información de la póliza: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString());
/* 2971 */     this.fichas.setSelectedIndex(2);
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 2975 */     String canti = cant;
/* 2976 */     String valorP = "";
/* 2977 */     for (int j = 0; j < canti.length(); j++) {
/* 2978 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 2979 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 2982 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 2986 */     this.jComboBox6.setEnabled(false);
/* 2987 */     this.jTextField9.setEnabled(false);
/* 2988 */     this.jTextField10.setEnabled(false);
/* 2989 */     this.jComboBox5.setEnabled(false);
/* 2990 */     this.jButton58.setEnabled(false);
/* 2991 */     this.jComboBox4.setEnabled(false);
/* 2992 */     this.jComboBox9.setEnabled(false);
/* 2993 */     this.jTextField8.setEnabled(false);
/* 2994 */     this.jDateChooser7.setEnabled(false);
/* 2995 */     this.jTextPane1.setEnabled(false);
/* 2996 */     this.jButton52.setEnabled(false);
/* 2997 */     this.importe.setEnabled(false);
/* 2998 */     this.jRadioButton1.setEnabled(false);
/* 2999 */     this.jRadioButton2.setEnabled(false);
/* 3000 */     this.jRadioButton3.setEnabled(false);
/* 3001 */     this.jRadioButton4.setEnabled(false);
/* 3002 */     this.jTextField25.setEnabled(false);
/* 3003 */     this.jButton57.setEnabled(false);
/* 3004 */     this.jTextPane2.setEnabled(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void cargaOtrosBeneficiarios() {
/* 3009 */     this.com_OtroBeneficiario.addItems(this.TODOS_OTROBENEFICIARIO);
/*      */   }
/*      */ 
/*      */   
/*      */   public void verPoliza() {
/* 3014 */     limpiarNuevo();
/* 3015 */     desactivar();
/* 3016 */     String[] datos = this.con.regresaReg("poliza, fechaPoliza, tipo, cheque, fechaCheque,  cuentaOrigen, beneficiario, cobradoPor, concepto, facturasAmparadas,   importe, comprobante, motivoCancelacion, comentarioGral, sucOp, numProv, gastosDe ", "prov_cheques", "where poliza= '" + 
/* 3017 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'", 17);
/* 3018 */     this.jComboBox9.setSelectedItem(datos[16]);
/* 3019 */     this.jTextField7.setText(datos[0]);
/* 3020 */     DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 3021 */     LocalDate fechaLocal = LocalDate.parse(datos[1].substring(0, 10), formateador);
/* 3022 */     this.jDateChooser6.setDate(Date.valueOf(fechaLocal));
/* 3023 */     if (datos[15].equals("0")) {
/* 3024 */       this.jComboBox6.setSelectedItem("OTRO...");
/* 3025 */       this.jTextField9.setText("");
/*      */       
/* 3027 */       this.com_OtroBeneficiario.removeAllItems();
/* 3028 */       this.jTextField9.setText(datos[6]);
/* 3029 */       cargaOtrosBeneficiarios();
/*      */     } else {
/*      */       
/* 3032 */       this.PROVEEDORES.stream().filter(p -> (p.getNumProv() == Integer.parseInt(datos[15]))).map(p -> p.getNombreComercial()).forEach(p -> this.jComboBox6.setSelectedItem(p));
/*      */     } 
/* 3034 */     this.jTextField10.setText(datos[7]);
/* 3035 */     this.jComboBox5.setSelectedItem(datos[2]);
/* 3036 */     this.CUENTAS.stream().filter(c -> c.getCuenta().equals(datos[5])).map(c -> c.getCuentacorta() + " " + c.getCuentacorta()).forEach(c -> this.jComboBox4.setSelectedItem(c));
/* 3037 */     this.jTextField8.setText(datos[3]);
/* 3038 */     formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 3039 */     fechaLocal = LocalDate.parse(datos[4].substring(0, 10), formateador);
/* 3040 */     this.jDateChooser7.setDate(Date.valueOf(fechaLocal));
/* 3041 */     this.jTextPane1.setText(datos[8]);
/* 3042 */     this.jTextPane2.setText(datos[13]);
/* 3043 */     this.importe.setValue(Double.valueOf(convertirCantTexto(datos[10])));
/* 3044 */     if (datos[11].equals("PC")) {
/* 3045 */       this.jRadioButton1.setSelected(true);
/* 3046 */     } else if (datos[11].equals("C")) {
/* 3047 */       this.jRadioButton3.setSelected(true);
/* 3048 */     } else if (datos[11].equals("SC")) {
/* 3049 */       this.jRadioButton2.setSelected(true);
/* 3050 */     } else if (datos[11].equals("N/A")) {
/* 3051 */       this.jRadioButton4.setSelected(true);
/*      */     } 
/* 3053 */     this.ACTIVARSUC = datos[14];
/* 3054 */     this.NUMPOLIZA = datos[0];
/* 3055 */     this.jTextField25.setText(datos[14].substring(0, 8) + "...");
/*      */   }
/*      */   
/*      */   public String getFechaddMMaaaa(Date fechita) {
/* 3059 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3060 */     String cadenaFecha1 = formato.format(fechita);
/* 3061 */     String año = cadenaFecha1.substring(0, 4);
/* 3062 */     String mes = cadenaFecha1.substring(4, 6);
/* 3063 */     String dia = cadenaFecha1.substring(6, 8);
/* 3064 */     return dia + "/" + dia + "/" + mes;
/*      */   }
/*      */   
/*      */   public int mesActual() {
/* 3068 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 3069 */     Instant instant = (new Date()).toInstant();
/* 3070 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 3071 */     return fechaTrans.getMonthValue();
/*      */   }
/*      */   
/*      */   public int añoActual() {
/* 3075 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 3076 */     Instant instant = (new Date()).toInstant();
/* 3077 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 3078 */     return fechaTrans.getYear();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3082 */     this.pintar.colorear(this.jTextField1);
/* 3083 */     this.pintar.colorear(this.jTextField2);
/* 3084 */     this.pintar.colorear(this.jTextField3);
/* 3085 */     this.pintar.colorear(this.jTextField4);
/* 3086 */     this.pintar.colorear(this.jTextField5);
/* 3087 */     this.pintar.colorear(this.jComboBox1);
/* 3088 */     this.pintar.colorear(this.jComboBox2);
/* 3089 */     this.pintar.colorear(this.jComboBox3);
/* 3090 */     this.pintar.colorear(this.jComboBox7);
/* 3091 */     this.pintar.colorear(this.jComboBox8);
/* 3092 */     this.pintar.colorear(this.jComboBox9);
/* 3093 */     this.pintar.colorear(this.jComboBox10);
/* 3094 */     this.pintar.colorear(this.jComboBox11);
/* 3095 */     this.pintar.colorear(this.jTextField5);
/* 3096 */     this.pintar.colorear(this.jTextField8);
/* 3097 */     this.pintar.colorear(this.jTextField9);
/* 3098 */     this.pintar.colorear(this.jTextField10);
/* 3099 */     this.pintar.colorear(this.jTextField25);
/* 3100 */     this.pintar.colorear(this.jTextPane1);
/* 3101 */     this.pintar.colorear(this.jTextPane2);
/* 3102 */     this.pintar.colorear(this.importe);
/* 3103 */     this.pintar.colorear(this.jComboBox4);
/* 3104 */     this.pintar.colorear(this.jComboBox5);
/* 3105 */     this.pintar.colorear(this.jComboBox6);
/* 3106 */     this.pintar.colorear(this.jTextField16);
/* 3107 */     this.pintar.colorear(this.jTextField6);
/* 3108 */     this.pintar.colorear(this.jTextArea5);
/*      */   }
/*      */   
/*      */   public String dameSucursalOp(JTextField campo, JTable tabla) {
/* 3112 */     String sucursales = "";
/* 3113 */     boolean entra = false;
/* 3114 */     if (campo.isEditable()) {
/* 3115 */       for (int i = 0; i < tabla.getRowCount(); i++) {
/* 3116 */         boolean selec = ((Boolean)tabla.getValueAt(i, 0)).booleanValue();
/* 3117 */         if (selec) {
/* 3118 */           sucursales = sucursales + " " + sucursales + ",";
/* 3119 */           entra = true;
/*      */         } 
/*      */       } 
/* 3122 */       if (entra) {
/* 3123 */         sucursales = sucursales.substring(1, sucursales.length() - 1);
/*      */       } else {
/* 3125 */         sucursales = "";
/*      */       } 
/*      */     } else {
/* 3128 */       sucursales = campo.getText().toUpperCase();
/*      */     } 
/* 3130 */     return sucursales;
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 3134 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 3135 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 3136 */     String fecha = formatter.format(fechaHoy);
/* 3137 */     return " (" + fecha + ")";
/*      */   }
/*      */   
/*      */   public void agregarDato() {
/* 3141 */     String t = this.jComboBox5.getSelectedItem().toString();
/* 3142 */     String c = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0).toString();
/* 3143 */     String v = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString();
/* 3144 */     String coma = "";
/* 3145 */     if (!this.jTextPane1.getText().equals("")) {
/* 3146 */       coma = ", ";
/*      */     }
/* 3148 */     if (t.equals("PAGO DE FINIQUITO")) {
/* 3149 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "FINIQUITO: " + coma);
/* 3150 */     } else if (t.equals("PAGO DE VACACIONES")) {
/* 3151 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "VACACIONES: " + coma);
/* 3152 */     } else if (this.FACTURASAGREGADAS.contains(c + "-" + c)) {
/* 3153 */       JOptionPane.showMessageDialog(this.padre, "La factura que deseas agregar ya se encuentra almacenada, verifica tu información", "Factura agregada", 0, this.ERROR);
/*      */     } else {
/* 3155 */       this.jTextPane1.setText(this.jTextPane1.getText() + this.jTextPane1.getText() + "FACTURA: " + coma);
/* 3156 */       this.FACTURASAGREGADAS.add(c + "-" + c);
/* 3157 */       this.jRadioButton3.setSelected(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarDatoExtra() {
/* 3162 */     String t = this.jComboBox5.getSelectedItem().toString();
/* 3163 */     String v = this.jTextField6.getText();
/* 3164 */     String campos = "";
/* 3165 */     String tabla = "";
/* 3166 */     String condicion = "";
/* 3167 */     String[] titulos = null;
/* 3168 */     String[][] matriz = null;
/* 3169 */     if (t.equals("PAGO DE FINIQUITO")) {
/* 3170 */       campos = "num, folio_fini, fecha, empleado, total_imss";
/* 3171 */       tabla = "finiquitos_regis";
/* 3172 */       condicion = "where ( estatus='<Por Pagar>' || estatus like '%<Pagado%' || estatus like '%<Abono%' || estatus like '%<Autorizado%') and folio_fini like '%" + v + "%' order by fecha desc";
/* 3173 */       titulos = new String[] { "Num", "Folio", "Fecha", "Empleado", "Total" };
/* 3174 */       matriz = this.con2.buscarDatos(5, campos, tabla, condicion);
/* 3175 */     } else if (t.equals("PAGO DE VACACIONES")) {
/* 3176 */       campos = "num_vaca, folio_vaca, fecha, trabajador, total";
/* 3177 */       tabla = "vacaciones_regis";
/* 3178 */       condicion = "where ( estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%' || estatus like '%<Autorizada%') and folio_vaca like '%" + v + "%' order by fecha desc";
/* 3179 */       titulos = new String[] { "Num", "Folio", "Fecha", "Empleado", "Total" };
/* 3180 */       matriz = this.con2.buscarDatos(5, campos, tabla, condicion);
/*      */     } else {
/* 3182 */       String nombreComercial = "";
/* 3183 */       if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3184 */         nombreComercial = this.jComboBox6.getSelectedItem().toString();
/*      */       }
/* 3186 */       campos = "prov_tarjetadeudor.mov, prov_tarjetadeudor.factura, prov_tarjetadeudor.fecha, prov_proveedores.nombreComercial, prov_tarjetadeudor.importeRestanteLetra";
/* 3187 */       tabla = "prov_tarjetadeudor, prov_proveedores";
/* 3188 */       condicion = "where prov_tarjetadeudor.numProv = prov_proveedores.numProv and (prov_tarjetadeudor.estatus='<Por Pagar>' || prov_tarjetadeudor.estatus like '%<Abono') and prov_tarjetadeudor.factura like '%" + v + "%' " + getConsultaSuc() + " and prov_proveedores.nombreComercial like '%" + nombreComercial + "%' order by prov_tarjetadeudor.fecha, prov_tarjetadeudor.factura, prov_proveedores.nombreComercial";
/* 3189 */       titulos = new String[] { "Mov", "Folio", "Fecha Factura", "Proveedor", "Debe" };
/* 3190 */       matriz = this.con.buscarDatos(5, campos, tabla, condicion);
/*      */     } 
/* 3192 */     this.rSTableMetro4.setModel(new DefaultTableModel((Object[][])matriz, (Object[])titulos) {
/* 3193 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3196 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3199 */     this.jLabel49.setText("" + this.rSTableMetro4.getRowCount());
/* 3200 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 3201 */     this.rSTableMetro4.setSelectionMode(0);
/* 3202 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 3203 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 3204 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3205 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(40);
/* 3206 */     this.rSTableMetro4.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 3207 */     this.rSTableMetro4.getColumnModel().getColumn(4).setMaxWidth(90);
/* 3208 */     this.rSTableMetro4.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 3209 */     this.rSTableMetro4.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3210 */     this.rSTableMetro4.getColumnModel().getColumn(2).setCellRenderer(this.celda1);
/* 3211 */     this.rSTableMetro4.getColumnModel().getColumn(3).setCellRenderer(this.celda1);
/* 3212 */     this.rSTableMetro4.getColumnModel().getColumn(4).setCellRenderer(this.celda1);
/* 3213 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public boolean existeTipo(String buscar) {
/* 3217 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3218 */       String comp = this.rSTableMetro3.getValueAt(i, 1).toString();
/* 3219 */       if (comp.equals(buscar)) {
/* 3220 */         return true;
/*      */       }
/*      */     } 
/* 3223 */     return false;
/*      */   }
/*      */   
/*      */   public void agregarTipo() {
/* 3227 */     String t = this.jTextField16.getText().toUpperCase();
/* 3228 */     if (existeTipo(this.jTextField16.getText().toUpperCase())) {
/* 3229 */       this.jTextField16.setBackground(Color.RED);
/* 3230 */       JOptionPane.showMessageDialog(this.jDialog3, "El tipo de cheque que deseas agregar ya se encuentra almacenado, por favor verifica tu información", "Tipo ya existe", 0, this.ADVER);
/* 3231 */     } else if (this.jButton16.getText().equals("Agregar")) {
/* 3232 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas agregar nuevo tipo de cheque?", "Agregar nuevo tipo", 0, 3, this.PREG);
/* 3233 */       if (res == 0) {
/* 3234 */         this.con.inserSinMsj("insert into prov_cheques_cat_tipo (tipo) values('" + this.jTextField16.getText().toUpperCase() + "')");
/* 3235 */         llenarTipo();
/* 3236 */         this.jComboBox5.setSelectedItem(t);
/* 3237 */         this.jDialog3.setVisible(false);
/* 3238 */         this.jDialog2.setVisible(false);
/*      */       } 
/*      */     } else {
/* 3241 */       this.con.inserSinMsj("update prov_cheques_cat_tipo set tipo = '" + this.jTextField16.getText().toUpperCase() + "' where tipo ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "'");
/* 3242 */       this.rSTableMetro3.setValueAt(this.jTextField16.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/* 3243 */       llenarTipo();
/* 3244 */       this.jComboBox5.setSelectedItem(t);
/* 3245 */       this.jDialog3.setVisible(false);
/* 3246 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarPersonas() {
/* 3251 */     String suc = getPrivilegiosSuc();
/* 3252 */     String[][] DATOS = this.con.buscarDatos(2, "beneficiario, cobradoPor", "prov_cheques", "where sucOp like '%" + suc + "%'");
/* 3253 */     for (String[] d : DATOS) {
/* 3254 */       agregarCampo(this.TODOS_OTROBENEFICIARIO, d[0]);
/* 3255 */       agregarCampo(this.TODOS_COBRADOPOR, d[1]);
/*      */     } 
/* 3257 */     this.com_OtroBeneficiario = new TextAutoCompleter(this.jTextField9, this.TODOS_OTROBENEFICIARIO);
/* 3258 */     this.com_CobradoPor = new TextAutoCompleter(this.jTextField10, this.TODOS_COBRADOPOR);
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 3262 */     if (!datos.contains(valor)) {
/* 3263 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiarTablaSuc() {
/* 3268 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 3269 */       this.jTextField25.setText("");
/* 3270 */       this.jTextField25.setEnabled(true);
/* 3271 */       this.jButton57.setEnabled(true);
/*      */     } else {
/* 3273 */       this.jTextField25.setEnabled(false);
/* 3274 */       this.jTextField25.setText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 3275 */       this.jButton57.setEnabled(false);
/*      */     } 
/* 3277 */     this.jTextField25.setToolTipText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 3278 */     selecTablaSucursal(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void selecTablaSucursal(String suc) {
/* 3282 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3283 */       String columna = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 3284 */       if (columna.equals(suc)) {
/* 3285 */         this.rSTableMetro2.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public int separarFolioMax(String folio) {
/* 3291 */     int num = 0;
/* 3292 */     String n = "";
/* 3293 */     char[] cadena = folio.toCharArray();
/* 3294 */     for (int i = 0; i < cadena.length; i++) {
/* 3295 */       if (Character.isDigit(cadena[i])) {
/* 3296 */         n = n + n;
/*      */       }
/*      */     } 
/* 3299 */     return Integer.parseInt(n);
/*      */   }
/*      */   
/*      */   public void sacarPolizaMayor() {
/* 3303 */     int MAYOR = 0;
/* 3304 */     this.encontrado = this.con.consultar("poliza", "prov_cheques", "where num=(select max(num) from prov_cheques where sucOp = '" + (String)this.CAMPOSGENERALES.get("sucursal") + "') order by fechaPoliza desc ");
/* 3305 */     if (this.encontrado) {
/* 3306 */       MAYOR = separarFolioMax(this.con.Campo);
/* 3307 */       MAYOR++;
/*      */     } else {
/* 3309 */       MAYOR++;
/*      */     } 
/* 3311 */     if (MAYOR < 100) {
/* 3312 */       this.jTextField7.setText((String)this.CAMPOSGENERALES.get("directiva") + "000" + (String)this.CAMPOSGENERALES.get("directiva"));
/* 3313 */     } else if (MAYOR < 1000) {
/* 3314 */       this.jTextField7.setText((String)this.CAMPOSGENERALES.get("directiva") + "00" + (String)this.CAMPOSGENERALES.get("directiva"));
/* 3315 */     } else if (MAYOR < 10000) {
/* 3316 */       this.jTextField7.setText((String)this.CAMPOSGENERALES.get("directiva") + "0" + (String)this.CAMPOSGENERALES.get("directiva"));
/*      */     } else {
/* 3318 */       this.jTextField7.setText((String)this.CAMPOSGENERALES.get("directiva") + (String)this.CAMPOSGENERALES.get("directiva"));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void activar() {
/* 3323 */     this.jComboBox5.setEnabled(true);
/* 3324 */     this.jButton58.setEnabled(true);
/* 3325 */     this.jButton52.setEnabled(true);
/* 3326 */     this.jComboBox6.setEnabled(true);
/* 3327 */     this.jTextField10.setEnabled(true);
/* 3328 */     this.jTextField8.setEnabled(true);
/* 3329 */     this.jDateChooser7.setEnabled(true);
/* 3330 */     this.jComboBox4.setEnabled(true);
/* 3331 */     this.jComboBox9.setEnabled(true);
/* 3332 */     this.jTextPane1.setEnabled(true);
/* 3333 */     this.jTextPane2.setEnabled(true);
/* 3334 */     this.jRadioButton1.setEnabled(true);
/* 3335 */     this.jRadioButton2.setEnabled(true);
/* 3336 */     this.jRadioButton3.setEnabled(true);
/* 3337 */     this.jRadioButton4.setEnabled(true);
/* 3338 */     this.importe.setEnabled(true);
/* 3339 */     if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 3340 */       this.jDateChooser6.setEnabled(true);
/*      */     }
/* 3342 */     this.jTextField7.setEnabled(true);
/* 3343 */     this.jDateChooser6.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void limpiarNuevo() {
/* 3347 */     this.jTextField7.setText("");
/* 3348 */     this.jDateChooser6.setDate(new Date());
/* 3349 */     this.jComboBox5.setSelectedIndex(0);
/* 3350 */     this.jComboBox6.setSelectedIndex(0);
/* 3351 */     this.jTextField9.setText("");
/* 3352 */     this.jTextField10.setText("");
/* 3353 */     this.jComboBox4.setSelectedIndex(0);
/* 3354 */     this.jTextField8.setText("");
/* 3355 */     this.jDateChooser7.setDate(new Date());
/* 3356 */     this.jTextPane1.setText("");
/* 3357 */     this.jTextPane2.setText("");
/* 3358 */     this.importe.setValue(Integer.valueOf(0));
/* 3359 */     this.jTextField25.setText("");
/* 3360 */     this.jRadioButton1.setSelected(true);
/* 3361 */     this.jTextField25.setText(this.CAMPOSGENERALES.get("sucursal"));
/* 3362 */     this.jComboBox9.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void cheques(String USUARIO) {
/* 3366 */     privilegios();
/* 3367 */     this.USUARIO = USUARIO;
/* 3368 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void llenarTipo() {
/* 3372 */     this.jComboBox3.removeAllItems();
/* 3373 */     this.jComboBox5.removeAllItems();
/* 3374 */     this.jComboBox3.addItem("TIPO");
/* 3375 */     this.jComboBox5.addItem("SELECCIONA UNO...");
/*      */     
/* 3377 */     (new String[2])[0] = "Núm"; (new String[2])[1] = "Tipo"; this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "numTipo, tipo", "prov_cheques_cat_tipo", "order by tipo"), (Object[])new String[2]) {
/* 3378 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3381 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3384 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3385 */       String v = this.rSTableMetro3.getValueAt(i, 1).toString();
/* 3386 */       this.TIPOS.put(Integer.valueOf(i), v);
/* 3387 */       this.jComboBox3.addItem(v);
/* 3388 */       this.jComboBox5.addItem(v);
/*      */     } 
/* 3390 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 3391 */     this.rSTableMetro3.setSelectionMode(0);
/* 3392 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 3393 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 3394 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 3395 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(90);
/* 3396 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 3397 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3398 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public String getPrivilegiosSuc() {
/* 3402 */     String priv = "";
/* 3403 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO")) {
/* 3404 */       priv = "";
/*      */     } else {
/* 3406 */       priv = this.CAMPOSGENERALES.get("sucursal");
/*      */     } 
/* 3408 */     return priv;
/*      */   }
/*      */   
/*      */   public String getConsultaSuc() {
/* 3412 */     String consulta = " and sucOp like '%" + getPrivilegiosSuc() + "%' ";
/* 3413 */     return consulta;
/*      */   }
/*      */   
/*      */   public void llenarCuentas() {
/* 3417 */     String[][] cuentas = this.con.buscarDatos(4, "numCuenta, bancoCorto, cuenta, cuentaCorta", "prov_cuentasbancarias", " where estado ='ACTIVA' " + getConsultaSuc() + " order by cuentaCorta");
/* 3418 */     for (String[] c : cuentas) {
/* 3419 */       this.CUENTAS.add(new Cuentas(Integer.parseInt(c[0]), c[1], c[2], c[3]));
/*      */     }
/* 3421 */     this.CUENTAS.forEach(c -> this.jComboBox4.addItem(c.getCuentacorta() + " " + c.getCuentacorta()));
/*      */   }
/*      */   
/*      */   public void llenarProveedores() {
/* 3425 */     String suc = getPrivilegiosSuc();
/* 3426 */     String[][] proveedores = this.con.buscarDatos(3, "numProv, razonSocial, nombreComercial", "prov_proveedores", " where estado ='ACTIVO' and sucOp like '%" + suc + "%' order by nombreComercial");
/* 3427 */     for (String[] p : proveedores) {
/* 3428 */       this.PROVEEDORES.add(new Proveedores(Integer.parseInt(p[0]), p[1], p[2]));
/*      */     }
/* 3430 */     this.PROVEEDORES.forEach(p -> this.jComboBox6.addItem(p.getNombreComercial()));
/* 3431 */     this.jComboBox6.addItem("OTRO...");
/*      */   }
/*      */   
/*      */   public void llenarComboUsuario() {
/* 3435 */     String[] usu = this.con2.regresaColIndex("nombre_usu", "usuarios", "where priv='ADMINISTRADOR' || priv ='CUENTAS POR PAGAR' || priv='SUPERVISOR DE CUENTAS POR PAGAR' || priv='SUPER USUARIO' order by nombre_usu");
/* 3436 */     List<String> lista = Arrays.asList(usu);
/* 3437 */     lista.forEach(v -> this.jComboBox7.addItem(v));
/*      */   }
/*      */   
/*      */   public void llenarComboSuc() {
/* 3441 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 3442 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 3443 */     Iterator<String> it = lista.iterator();
/* 3444 */     while (it.hasNext()) {
/* 3445 */       String v = it.next();
/* 3446 */       this.jComboBox1.addItem(v);
/* 3447 */       this.jComboBox9.addItem(v);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarSucursales() {
/* 3452 */     this.TODOS_SUCURSALES = new ArrayList();
/* 3453 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 3454 */     Object[][] Object = new Object[lista.size()][2];
/* 3455 */     Iterator<String> it = lista.iterator();
/* 3456 */     while (it.hasNext()) {
/* 3457 */       String v = it.next();
/* 3458 */       this.TODOS_SUCURSALES.add(v);
/* 3459 */       Object[lista.indexOf(v)][0] = Boolean.valueOf(false);
/* 3460 */       Object[lista.indexOf(v)][1] = v;
/*      */     } 
/* 3462 */     llenarTablaSuc(Object);
/*      */   }
/*      */   
/*      */   public void llenarTablaSuc(Object[][] arrayOfObject) {
/* 3466 */     (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(arrayOfObject, (Object[])new String[2]) {
/* 3467 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 3469 */           boolean[] canEdit = new boolean[] { true, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3472 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3476 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3479 */     this.rSTableMetro2.setAltoHead(25);
/* 3480 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3481 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3482 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3483 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3484 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3485 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3486 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3487 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3488 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3489 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3490 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3491 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3492 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 3493 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 3494 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3495 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3496 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3498 */             ProvCheques.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3501 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3503 */             ProvCheques.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3506 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 3507 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 3508 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 3509 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3510 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/* 3512 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3513 */     this.rSTableMetro2.setSelectionMode(0);
/* 3514 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3518 */     this.PRIMERA = true;
/* 3519 */     String fechaCompleta1 = "";
/* 3520 */     String fechaCompleta2 = "";
/* 3521 */     String consultaFecha = "";
/* 3522 */     String campoFecha = "fechaPoliza";
/* 3523 */     if (this.jComboBox8.getSelectedIndex() == 1) {
/* 3524 */       campoFecha = "fechaCheque";
/*      */     }
/* 3526 */     if (this.jComboBox10.getSelectedIndex() == 0) {
/* 3527 */       Date fecha1 = this.jDateChooser4.getDate();
/* 3528 */       Date fecha2 = this.jDateChooser5.getDate();
/* 3529 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3530 */       String cadenaFecha = "";
/* 3531 */       cadenaFecha = formato.format(fecha1);
/* 3532 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3533 */       String MES = cadenaFecha.substring(4, 6);
/* 3534 */       String DIA = cadenaFecha.substring(6, 8);
/* 3535 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3536 */       cadenaFecha = formato.format(fecha2);
/* 3537 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3538 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3539 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3540 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 3541 */       consultaFecha = campoFecha + " between " + campoFecha + " and " + fechaCompleta1;
/*      */     } else {
/* 3543 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */ 
/*      */       
/* 3546 */       int aa = Integer.parseInt(this.jComboBox11.getSelectedItem().toString());
/* 3547 */       consultaFecha = " date_format(" + campoFecha + ", '%m-%Y') = '" + mes[this.jComboBox10.getSelectedIndex()] + "-" + aa + "' ";
/*      */     } 
/* 3549 */     String poliza = "";
/* 3550 */     if (!this.jTextField1.getText().equals(this.holderPoliza)) {
/* 3551 */       poliza = this.jTextField1.getText();
/*      */     }
/* 3553 */     String cheque = "";
/* 3554 */     if (!this.jTextField2.getText().equals(this.holderCheque)) {
/* 3555 */       cheque = this.jTextField2.getText();
/*      */     }
/* 3557 */     String cuenta = "";
/* 3558 */     if (!this.jTextField3.getText().equals(this.holderCuenta)) {
/* 3559 */       cuenta = this.jTextField3.getText();
/*      */     }
/* 3561 */     String beneficiario = "";
/* 3562 */     if (!this.jTextField4.getText().equals(this.holderBeneficiario)) {
/* 3563 */       beneficiario = this.jTextField4.getText();
/*      */     }
/* 3565 */     String concepto = "";
/* 3566 */     if (!this.jTextField5.getText().equals(this.holderConcepto)) {
/* 3567 */       concepto = this.jTextField5.getText();
/*      */     }
/* 3569 */     String sucursalForsis = "";
/* 3570 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3571 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 3573 */     String estado = " estado='<Por Aplicar>' || estado like '%<Pagada%' || estado like '%<Abono%' || estado like '%<Aplicada%'";
/* 3574 */     if (this.jComboBox2.getSelectedIndex() == 1) {
/* 3575 */       estado = " estado like '%%'";
/* 3576 */     } else if (this.jComboBox2.getSelectedIndex() == 2) {
/* 3577 */       estado = " estado ='<Por Aplicar>'";
/* 3578 */     } else if (this.jComboBox2.getSelectedIndex() == 3) {
/* 3579 */       estado = " estado like '%<Pagada%'";
/* 3580 */     } else if (this.jComboBox2.getSelectedIndex() == 4) {
/* 3581 */       estado = " estado like '%<Abono%'";
/* 3582 */     } else if (this.jComboBox2.getSelectedIndex() == 5) {
/* 3583 */       estado = " estado like '%<Cancelada%'";
/*      */     } 
/* 3585 */     String usuario = "";
/* 3586 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 3587 */       usuario = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 3589 */     String tipo = "";
/* 3590 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3591 */       tipo = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 3594 */     (new String[13])[0] = "Póliza"; (new String[13])[1] = "Fecha"; (new String[13])[2] = "Cheque"; (new String[13])[3] = "Fecha"; (new String[13])[4] = "Importe"; (new String[13])[5] = "Cuenta"; (new String[13])[6] = "Beneficiario"; (new String[13])[7] = "Concepto"; (new String[13])[8] = "Tipo"; (new String[13])[9] = "Sucursal"; (new String[13])[10] = "C"; (new String[13])[11] = "Estado"; (new String[13])[12] = "Actualizó"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(13, "poliza, fechaPoliza, cheque, fechaCheque, importe, cuentaOrigen, beneficiario, concepto, tipo, gastosDe, comprobante, estado, usuario", "prov_cheques", "where (" + consultaFecha + " ) and poliza like '%" + poliza + "%' and tipo like '%" + tipo + "%' and cheque like '%" + cheque + "%' and cuentaOrigen like '%" + cuenta + "%' and beneficiario like '%" + beneficiario + "%' and concepto like '%" + concepto + "%' and gastosDe like '%" + sucursalForsis + "%' and (" + estado + ")  and usuario like '%" + usuario + "%' " + 
/* 3595 */             getConsultaSuc() + " order by " + campoFecha + " desc, num desc"), (Object[])new String[13])
/*      */         {
/*      */           
/* 3598 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3603 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3606 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 3607 */     this.jLabel37.setText("$0.00");
/* 3608 */     calcularTotales();
/* 3609 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Aplicar>", 0, 11, 0));
/* 3610 */     this.celda2.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelada>", 0, 11, 0));
/* 3611 */     this.rSTableMetro1.setSelectionMode(0);
/* 3612 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 3613 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3614 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(65);
/* 3615 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(65);
/* 3616 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(65);
/* 3617 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(65);
/* 3618 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(65);
/* 3619 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(65);
/* 3620 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(65);
/* 3621 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(65);
/* 3622 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 3623 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(90);
/* 3624 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(85);
/* 3625 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(85);
/* 3626 */     this.rSTableMetro1.getColumnModel().getColumn(9).setPreferredWidth(80);
/* 3627 */     this.rSTableMetro1.getColumnModel().getColumn(9).setMaxWidth(80);
/* 3628 */     this.rSTableMetro1.getColumnModel().getColumn(10).setPreferredWidth(83);
/* 3629 */     this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(30);
/* 3630 */     this.rSTableMetro1.getColumnModel().getColumn(11).setPreferredWidth(90);
/* 3631 */     this.rSTableMetro1.getColumnModel().getColumn(11).setMaxWidth(90);
/* 3632 */     this.rSTableMetro1.getColumnModel().getColumn(12).setPreferredWidth(120);
/* 3633 */     this.rSTableMetro1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 3634 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3635 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3636 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3637 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3638 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3639 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3640 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3641 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3642 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3643 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3644 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3645 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3646 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3647 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void calcularTotales() {
/* 3651 */     double valorT = 0.0D;
/* 3652 */     double valorDE = 0.0D;
/* 3653 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 3654 */       valorT += convertirCantTexto(this.rSTableMetro1.getValueAt(i, 4).toString());
/* 3655 */       this.cantidad.setValue(Double.valueOf(valorT));
/* 3656 */       this.jLabel37.setText(this.cantidad.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3661 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3669 */         return 31;
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3674 */         return 30;
/*      */       case 1:
/* 3676 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0)) {
/* 3677 */           return 29;
/*      */         }
/* 3679 */         return 28;
/*      */     } 
/* 3681 */     return 0;
/*      */   }
/*      */   
/*      */   public String mesLetra(int mes) {
/* 3685 */     int month = mes;
/* 3686 */     String result = "";
/* 3687 */     switch (month) {
/*      */       case 0:
/* 3689 */         result = "ENE";
/* 3690 */         return result;
/*      */       case 1:
/* 3692 */         result = "FEB";
/* 3693 */         return result;
/*      */       case 2:
/* 3695 */         result = "MAR";
/* 3696 */         return result;
/*      */       case 3:
/* 3698 */         result = "ABR";
/* 3699 */         return result;
/*      */       case 4:
/* 3701 */         result = "MAY";
/* 3702 */         return result;
/*      */       case 5:
/* 3704 */         result = "JUN";
/* 3705 */         return result;
/*      */       case 6:
/* 3707 */         result = "JUL";
/* 3708 */         return result;
/*      */       case 7:
/* 3710 */         result = "AGO";
/* 3711 */         return result;
/*      */       case 8:
/* 3713 */         result = "SEP";
/* 3714 */         return result;
/*      */       case 9:
/* 3716 */         result = "OCT";
/* 3717 */         return result;
/*      */       case 10:
/* 3719 */         result = "NOV";
/* 3720 */         return result;
/*      */       case 11:
/* 3722 */         result = "DIC";
/* 3723 */         return result;
/*      */     } 
/* 3725 */     result = "Error";
/* 3726 */     return result;
/*      */   }
/*      */   
/*      */   class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 3731 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3734 */       setEnabled((table == null || table.isEnabled()));
/* 3735 */       if (row % 2 == 0) {
/* 3736 */         setBackground(ProvCheques.this.lc.FONDOTABLA);
/*      */       } else {
/* 3738 */         setBackground((Color)null);
/*      */       } 
/* 3740 */       if (column == 4) {
/* 3741 */         setHorizontalAlignment(4);
/*      */       } else {
/* 3743 */         setHorizontalAlignment(2);
/*      */       } 
/* 3745 */       setForeground(ProvCheques.this.lc.SECUNDARIO1);
/* 3746 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3747 */       return this;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     CeldaRender2() {
/* 3753 */       this.otro = -1;
/*      */       
/* 3755 */       this.indices = new String[0];
/*      */       
/* 3757 */       this.indices2 = new String[0];
/*      */       
/* 3759 */       this.indices3 = new String[0];
/*      */       
/* 3761 */       this.indices4 = new String[0];
/*      */       
/* 3763 */       this.indices5 = new String[0];
/*      */       
/* 3765 */       this.indices6 = new String[0];
/*      */       
/* 3767 */       this.indices7 = new String[0];
/*      */     } String[] indices4; String[] indices5; String[] indices6; String[] indices7;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3770 */       setEnabled((table == null || table.isEnabled()));
/* 3771 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 3772 */       if (comparar2(comp)) {
/* 3773 */         setBackground(Color.RED);
/* 3774 */         setForeground(Color.WHITE);
/* 3775 */       } else if (comparar(comp)) {
/* 3776 */         setBackground(new Color(102, 153, 255));
/* 3777 */         setForeground(Color.BLUE);
/*      */       } else {
/* 3779 */         setBackground((Color)null);
/* 3780 */         setForeground(ProvCheques.this.lc.SECUNDARIO1);
/*      */       } 
/* 3782 */       if (column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
/* 3783 */         setHorizontalAlignment(4);
/*      */       } else {
/* 3785 */         setHorizontalAlignment(10);
/*      */       } 
/* 3787 */       if (column == 10) {
/* 3788 */         setHorizontalAlignment(0);
/*      */       }
/* 3790 */       if (column == 1 && ProvCheques.this.jComboBox8.getSelectedIndex() == 0) {
/* 3791 */         setBackground(ProvCheques.this.lc.SECUNDARIO2);
/* 3792 */       } else if (column == 3 && ProvCheques.this.jComboBox8.getSelectedIndex() == 1) {
/* 3793 */         setBackground(ProvCheques.this.lc.SECUNDARIO2);
/*      */       } 
/* 3795 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3796 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3800 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3804 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 3808 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 3812 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 3816 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd6(String[] ind) {
/* 3820 */       this.indices6 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd7(String[] ind) {
/* 3824 */       this.indices7 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3828 */       for (int i = 0; i < this.indices.length; i++) {
/* 3829 */         if (this.indices[i].equals(reg)) {
/* 3830 */           return true;
/*      */         }
/*      */       } 
/* 3833 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3837 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3838 */         if (this.indices2[i].equals(reg)) {
/* 3839 */           return true;
/*      */         }
/*      */       } 
/* 3842 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 3846 */       for (int i = 0; i < this.indices3.length; i++) {
/* 3847 */         if (this.indices3[i].equals(reg)) {
/* 3848 */           return true;
/*      */         }
/*      */       } 
/* 3851 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 3855 */       for (int i = 0; i < this.indices4.length; i++) {
/* 3856 */         if (this.indices4[i].equals(reg)) {
/* 3857 */           return true;
/*      */         }
/*      */       } 
/* 3860 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 3864 */       for (int i = 0; i < this.indices5.length; i++) {
/* 3865 */         if (this.indices5[i].equals(reg)) {
/* 3866 */           return true;
/*      */         }
/*      */       } 
/* 3869 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar6(String reg) {
/* 3873 */       for (int i = 0; i < this.indices6.length; i++) {
/* 3874 */         if (this.indices6[i].equals(reg)) {
/* 3875 */           return true;
/*      */         }
/*      */       } 
/* 3878 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar7(String reg) {
/* 3882 */       for (int i = 0; i < this.indices7.length; i++) {
/* 3883 */         if (this.indices7[i].equals(reg)) {
/* 3884 */           return true;
/*      */         }
/*      */       } 
/* 3887 */       return false;
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
/* 3902 */       this.numCuenta = numCuenta;
/* 3903 */       this.bancoCorto = bancoCorto;
/* 3904 */       this.cuenta = cuenta;
/* 3905 */       this.cuentacorta = cuentacorta;
/*      */     }
/*      */     
/*      */     public int getNumCuenta() {
/* 3909 */       return this.numCuenta;
/*      */     }
/*      */     
/*      */     public void setNumCuenta(int numCuenta) {
/* 3913 */       this.numCuenta = numCuenta;
/*      */     }
/*      */     
/*      */     public String getBancoCorto() {
/* 3917 */       return this.bancoCorto;
/*      */     }
/*      */     
/*      */     public void setBancoCorto(String bancoCorto) {
/* 3921 */       this.bancoCorto = bancoCorto;
/*      */     }
/*      */     
/*      */     public String getCuenta() {
/* 3925 */       return this.cuenta;
/*      */     }
/*      */     
/*      */     public void setCuenta(String cuenta) {
/* 3929 */       this.cuenta = cuenta;
/*      */     }
/*      */     
/*      */     public String getCuentacorta() {
/* 3933 */       return this.cuentacorta;
/*      */     }
/*      */     
/*      */     public void setCuentacorta(String cuentacorta) {
/* 3937 */       this.cuentacorta = cuentacorta;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Proveedores
/*      */   {
/*      */     int numProv;
/*      */     
/*      */     String razonSocial;
/*      */     String nombreComercial;
/*      */     
/*      */     public Proveedores(int numProv, String razonSocial, String nombreComercial) {
/* 3950 */       this.numProv = numProv;
/* 3951 */       this.razonSocial = razonSocial;
/* 3952 */       this.nombreComercial = nombreComercial;
/*      */     }
/*      */     
/*      */     public int getNumProv() {
/* 3956 */       return this.numProv;
/*      */     }
/*      */     
/*      */     public void setNumProv(int numProv) {
/* 3960 */       this.numProv = numProv;
/*      */     }
/*      */     
/*      */     public String getRazonSocial() {
/* 3964 */       return this.razonSocial;
/*      */     }
/*      */     
/*      */     public void setRazonSocial(String razonSocial) {
/* 3968 */       this.razonSocial = razonSocial;
/*      */     }
/*      */     
/*      */     public String getNombreComercial() {
/* 3972 */       return this.nombreComercial;
/*      */     }
/*      */     
/*      */     public void setNombreComercial(String nombreComercial) {
/* 3976 */       this.nombreComercial = nombreComercial;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 3984 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 3987 */       this.t = new Thread(this);
/* 3988 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 3996 */         ProvCheques.this.EtiquetaEstado.setVisible(true);
/* 3997 */         ProvCheques.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 3998 */         ProvCheques.this.setCursor(new Cursor(3));
/* 3999 */         Thread.currentThread();
/* 4000 */         Thread.sleep(1000L);
/* 4001 */         detener();
/* 4002 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 4007 */       ProvCheques.this.consultar();
/* 4008 */       ProvCheques.this.setCursor(ProvCheques.this.micursor);
/* 4009 */       ProvCheques.this.EtiquetaEstado.setVisible(false);
/* 4010 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 4014 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvCheques.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */