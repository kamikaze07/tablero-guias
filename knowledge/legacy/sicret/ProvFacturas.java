/*      */ package sicret;
/*      */ 
/*      */ import Fuentes.Fuentes;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dialog;
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
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.net.URL;
/*      */ import java.sql.Date;
/*      */ import java.text.DecimalFormat;
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
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.TreeMap;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerListModel;
/*      */ import javax.swing.filechooser.FileNameExtensionFilter;
/*      */ import javax.swing.plaf.ScrollBarUI;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import javax.xml.parsers.ParserConfigurationException;
/*      */ import net.sf.jasperreports.engine.JRDataSource;
/*      */ import net.sf.jasperreports.engine.JREmptyDataSource;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import org.jespxml.JespXML;
/*      */ import org.jespxml.modelo.Atributo;
/*      */ import org.jespxml.modelo.Tag;
/*      */ import org.xml.sax.SAXException;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import rojerusan.necesario.RSScrollBar;
/*      */ import utilerias.catMunicipios;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ public class ProvFacturas
/*      */   extends JPanel
/*      */ {
/*      */   JScrollPane panel;
/*  105 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*  107 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*  109 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*  111 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*  113 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*  115 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*  117 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*  119 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*  121 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*  123 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*  125 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*  127 */   JFrame padre = null;
/*      */   
/*  129 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  133 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  137 */   SColores lc = new SColores();
/*      */   
/*  139 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  141 */   PlaceHolder placeHolder = null;
/*      */   
/*  143 */   Consultas2 con = new Consultas2();
/*      */   
/*  145 */   Consultas2 con2 = new Consultas2();
/*      */   
/*  147 */   String[] SUCURSALES = null;
/*      */   
/*  149 */   String holderFolio = "FOLIO";
/*      */   
/*  151 */   String holderProveedor = "PROVEEDOR";
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*      */   boolean entraSucPrimera = false;
/*      */   
/*  157 */   Cursor micursor = null;
/*      */   
/*  159 */   Date fechaActual = new Date();
/*      */   
/*  161 */   Date fechaInicio = null;
/*      */   
/*  163 */   Date fecha = new Date();
/*      */   
/*  165 */   String NOMBREUSUARIOCOMP = "";
/*      */   
/*  167 */   ArrayList TODOS_SUCURSALES = new ArrayList();
/*  168 */   List<String> lista = null;
/*      */   
/*  170 */   TextAutoCompleter com_Sucursales = null;
/*      */   
/*  172 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*      */   ArrayList<Proveedores> PROVLISTA;
/*      */   
/*  176 */   int PROVSELEC = 0;
/*      */   
/*  178 */   File archivoOriginal = null;
/*      */   
/*      */   boolean primeraNuevo = false;
/*      */   
/*  182 */   Map<String, String> CAMPOSFACT = new TreeMap<>();
/*      */   
/*  184 */   String[] FORMAPAGO = new String[] { "01", "02", "03", "04", "05", "06", "08", "28", "29", "NA", "99" };
/*      */ 
/*      */ 
/*      */   
/*  188 */   String[] METODOPAGO = new String[] { "PUE", "PPD" };
/*      */   
/*      */   boolean entraRFCPrimera = false;
/*      */   
/*      */   boolean leyendoXML = false;
/*      */   
/*      */   boolean entraCatMunicipios = false;
/*      */   
/*  196 */   ArrayList TODOS_MUNICIPIOS = new ArrayList();
/*      */   
/*      */   private int xx;
/*      */   
/*      */   private int xy;
/*      */   
/*  202 */   TextAutoCompleter com_Municipios = null;
/*      */   
/*  204 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*      */   boolean entraCatMon = false;
/*      */   
/*  208 */   Errores error = new Errores(false);
/*      */   
/*  210 */   Validaciones val = new Validaciones();
/*      */   
/*      */   boolean encontrado = false;
/*      */   
/*  214 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  216 */   CeldaRender3 celda3 = new CeldaRender3();
/*      */   
/*  218 */   Presionado presionado = null;
/*      */   
/*  220 */   String ACTIVARSUC = "";
/*      */   
/*  222 */   String NUMFACT = "";
/*      */   
/*  224 */   String NOMBRECOMERCIAL = "";
/*      */   
/*  226 */   String TOTALFACTURA = "";
/*      */   
/*  228 */   String UUID = "";
/*      */   
/*  230 */   String NUMPROV = "";
/*      */   
/*  232 */   String TARJETA = "";
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*      */   boolean PRIMERA = false;
/*      */   
/*      */   boolean comboCargado = false;
/*      */   
/*      */   private JFormattedTextField cant1;
/*      */   
/*      */   private JFormattedTextField cant2;
/*      */   
/*      */   private JFormattedTextField cant3;
/*      */   
/*      */   private JFormattedTextField cant4;
/*      */   
/*      */   private JFormattedTextField cant5;
/*      */   
/*      */   private JFormattedTextField cant6;
/*      */   
/*      */   private JFormattedTextField cantidad;
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
/*      */   private JButton jButton2;
/*      */   
/*      */   private JButton jButton3;
/*      */   
/*      */   private JButton jButton34;
/*      */   
/*      */   private JButton jButton56;
/*      */   
/*      */   private JButton jButton57;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox jComboBox2;
/*      */   
/*      */   private JComboBox<String> jComboBox3;
/*      */   
/*      */   private JComboBox jComboBox4;
/*      */   
/*      */   private JComboBox jComboBox5;
/*      */   
/*      */   private JComboBox jComboBox6;
/*      */   
/*      */   private JComboBox jComboBox7;
/*      */   
/*      */   private JComboBox<String> jComboBox8;
/*      */   
/*      */   private JComboBox<String> jComboBox9;
/*      */   
/*      */   private JDateChooser jDateChooser1;
/*      */   
/*      */   private JDateChooser jDateChooser2;
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
/*      */   private JEditorPane jEditorPane1;
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
/*      */   private JLabel jLabel126;
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
/*      */   private JLabel jLabel20;
/*      */   
/*      */   private JLabel jLabel21;
/*      */   
/*      */   private JLabel jLabel216;
/*      */   
/*      */   private JLabel jLabel22;
/*      */   
/*      */   private JLabel jLabel221;
/*      */   
/*      */   private JLabel jLabel222;
/*      */   
/*      */   private JLabel jLabel23;
/*      */   
/*      */   private JLabel jLabel233;
/*      */   
/*      */   private JLabel jLabel234;
/*      */   
/*      */   private JLabel jLabel24;
/*      */   
/*      */   private JLabel jLabel25;
/*      */   
/*      */   private JLabel jLabel26;
/*      */   
/*      */   private JLabel jLabel27;
/*      */   
/*      */   private JLabel jLabel28;
/*      */   
/*      */   private JLabel jLabel29;
/*      */   
/*      */   private JLabel jLabel3;
/*      */   
/*      */   private JLabel jLabel30;
/*      */   
/*      */   private JLabel jLabel31;
/*      */   
/*      */   private JLabel jLabel32;
/*      */   
/*      */   private JLabel jLabel33;
/*      */   
/*      */   private JLabel jLabel34;
/*      */   
/*      */   private JLabel jLabel35;
/*      */   
/*      */   private JLabel jLabel36;
/*      */   
/*      */   private JLabel jLabel37;
/*      */   
/*      */   private JLabel jLabel38;
/*      */   
/*      */   private JLabel jLabel39;
/*      */   
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private JLabel jLabel40;
/*      */   
/*      */   private JLabel jLabel41;
/*      */   
/*      */   private JLabel jLabel42;
/*      */   
/*      */   private JLabel jLabel48;
/*      */   
/*      */   private JLabel jLabel49;
/*      */   
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private JLabel jLabel50;
/*      */   
/*      */   private JLabel jLabel55;
/*      */   
/*      */   private JLabel jLabel58;
/*      */   
/*      */   private JLabel jLabel59;
/*      */   
/*      */   private JLabel jLabel6;
/*      */   
/*      */   private JLabel jLabel60;
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
/*      */   private JPanel jPanel103;
/*      */   
/*      */   private JPanel jPanel104;
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
/*      */   private JPanel jPanel151;
/*      */   
/*      */   private JPanel jPanel17;
/*      */   
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel20;
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
/*      */   private JPanel jPanel37;
/*      */   
/*      */   private JPanel jPanel38;
/*      */   
/*      */   private JPanel jPanel39;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private JPanel jPanel47;
/*      */   
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private JPanel jPanel57;
/*      */   
/*      */   private JPanel jPanel6;
/*      */   
/*      */   private JPanel jPanel61;
/*      */   
/*      */   private JPanel jPanel7;
/*      */   
/*      */   private JPanel jPanel8;
/*      */   
/*      */   private JPanel jPanel9;
/*      */   
/*      */   private JPanel jPanelFecha;
/*      */   
/*      */   private JScrollPane jScrollPane13;
/*      */   
/*      */   private JScrollPane jScrollPane18;
/*      */   
/*      */   private JScrollPane jScrollPane2;
/*      */   
/*      */   private JScrollPane jScrollPane31;
/*      */   
/*      */   private JScrollPane jScrollPane32;
/*      */   
/*      */   private JScrollPane jScrollPane33;
/*      */   
/*      */   private JScrollPane jScrollPane34;
/*      */   
/*      */   private JSpinner jSpinner1;
/*      */   
/*      */   private JSpinner jSpinner2;
/*      */   
/*      */   private JSpinner jSpinner3;
/*      */   
/*      */   private JTextArea jTextArea5;
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
/*      */   private JTextField jTextField14;
/*      */   
/*      */   private JTextField jTextField15;
/*      */   
/*      */   private JTextField jTextField16;
/*      */   
/*      */   private JTextField jTextField17;
/*      */   
/*      */   private JTextField jTextField18;
/*      */   
/*      */   private JTextField jTextField19;
/*      */   
/*      */   private JTextField jTextField2;
/*      */   
/*      */   private JTextField jTextField20;
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
/*      */   private JTextField jTextField86;
/*      */   
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private JTextField ProveedorTxt;
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
/*      */   private MaterialButton materialButton38;
/*      */   
/*      */   private MaterialButton materialButton39;
/*      */   
/*      */   private MaterialButton materialButton40;
/*      */   
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private RSTableMetro rSTableMetro4;
/*      */   
/*      */   private RSTableMetro rSTableMetro7;
/*      */   
/*      */   public ProvFacturas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES) {
/*  613 */     this.EtiquetaEstado = EtiquetaEstado;
/*  614 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  615 */     this.mensajeTry = mensajeTry;
/*  616 */     this.padre = padre;
/*  617 */     this.fichas = fichas;
/*  618 */     this.USUARIO = USUARIO;
/*  619 */     this.panel = panelito;
/*  620 */     this.con.setBaseDatos("sicre2PR");
/*  621 */     this.con.cambiarServidor();
/*  622 */     this.panel.setViewportView(this);
/*  623 */     initComponents();
/*  624 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderFolio, false, "Century Gothic", 11);
/*  625 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderProveedor, false, "Century Gothic", 11);
/*  626 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  627 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  628 */     this.rSTableMetro1.setCursor(micursor);
/*  629 */     this.rSTableMetro2.setCursor(micursor);
/*  630 */     this.rSTableMetro3.setCursor(micursor);
/*  631 */     this.rSTableMetro4.setCursor(micursor);
/*  632 */     this.rSTableMetro7.setCursor(micursor);
/*  633 */     this.jDialog1.setCursor(micursor);
/*  634 */     this.jDialog2.setCursor(micursor);
/*  635 */     this.jDialog3.setCursor(micursor);
/*  636 */     this.jDialog4.setCursor(micursor);
/*  637 */     this.jDialog5.setCursor(micursor);
/*  638 */     imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  639 */     micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  640 */     this.jLabel170.setCursor(micursor);
/*  641 */     this.jLabel101.setCursor(micursor);
/*  642 */     this.jLabel171.setCursor(micursor);
/*  643 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  644 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  645 */     editFormat.setGroupingUsed(false);
/*  646 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  647 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  648 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  649 */     enFormat.setAllowsInvalid(true);
/*  650 */     this.cantidad.setFormatterFactory(currFactory);
/*  651 */     this.cant1.setFormatterFactory(currFactory);
/*  652 */     this.cant2.setFormatterFactory(currFactory);
/*  653 */     this.cant3.setFormatterFactory(currFactory);
/*  654 */     this.cant4.setFormatterFactory(currFactory);
/*  655 */     this.cant5.setFormatterFactory(currFactory);
/*  656 */     this.NOMBREUSUARIOCOMP = (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.ap_pat") + " " + (String)CAMPOSGENERALES.get("empleados.ap_mat");
/*  657 */     this.jScrollPane31.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  658 */     this.jScrollPane34.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  659 */     int w = this.tama.width;
/*  660 */     int h = this.tama.height;
/*  661 */     int rw = (w - 870) / 2;
/*  662 */     int rh = (h - 10) / 2;
/*  663 */     rw = (w - 450) / 2;
/*  664 */     rh = (h - 200) / 2;
/*  665 */     this.jDialog1.setLocation(rw, rh);
/*  666 */     this.jDialog1.setSize(380, 160);
/*  667 */     this.jDialog1.setResizable(false);
/*  668 */     rw = (w - 680) / 2;
/*  669 */     rh = (h - 280) / 2;
/*  670 */     this.jDialog2.setLocation(rw, rh);
/*  671 */     this.jDialog2.setSize(680, 280);
/*  672 */     this.jDialog2.setResizable(false);
/*  673 */     rw = (w - 650) / 2;
/*  674 */     rh = (h - 280) / 2;
/*  675 */     this.jDialog3.setLocation(rw, rh);
/*  676 */     this.jDialog3.setSize(650, 280);
/*  677 */     this.jDialog3.setResizable(false);
/*  678 */     rw = (w - 390) / 2;
/*  679 */     rh = (h - 175) / 2;
/*  680 */     this.jDialog4.setLocation(rw, rh);
/*  681 */     this.jDialog4.setSize(390, 175);
/*  682 */     this.jDialog4.setVisible(false);
/*  683 */     this.jDialog4.setResizable(false);
/*  684 */     rw = (w - 890) / 2;
/*  685 */     rh = (h - 475) / 2;
/*  686 */     this.jDialog5.setLocation(rw, rh);
/*  687 */     this.jDialog5.setSize(890, 475);
/*  688 */     this.jDialog5.setVisible(false);
/*  689 */     this.jDialog5.setResizable(false);
/*  690 */     this.rSTableMetro7.setSelectionMode(0);
/*  691 */     this.rSTableMetro7.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/*  692 */     this.rSTableMetro7.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/*  693 */     llenarCombo();
/*  694 */     llenarComboUsuario();
/*  695 */     llenarSucursales();
/*  696 */     privilegios();
/*  697 */     consultar();
/*  698 */     colorear();
/*  699 */     this.comboCargado = false;
/*  700 */     this.jComboBox9.setSelectedItem(CAMPOSGENERALES.get("sucursal"));
/*  701 */     this.comboCargado = true;
/*  702 */     verPendientes();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  706 */     this.jPanel20 = new JPanel();
/*  707 */     this.jPanel9 = new JPanel();
/*  708 */     this.materialButton21 = new MaterialButton();
/*  709 */     this.materialButton22 = new MaterialButton();
/*  710 */     this.jLabel1 = new JLabel();
/*  711 */     this.materialButton23 = new MaterialButton();
/*  712 */     this.jPanel12 = new JPanel();
/*  713 */     this.jPanel25 = new JPanel();
/*  714 */     this.jLabel30 = new JLabel();
/*  715 */     this.jPanel28 = new JPanel();
/*  716 */     this.jLabel2 = new JLabel();
/*  717 */     this.jTextField3 = new JTextField();
/*  718 */     this.jLabel3 = new JLabel();
/*  719 */     this.jTextField4 = new JTextField();
/*  720 */     this.jLabel5 = new JLabel();
/*  721 */     this.jTextField5 = new JTextField();
/*  722 */     this.jLabel4 = new JLabel();
/*  723 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  724 */     this.jLabel28 = new JLabel();
/*  725 */     this.jPanel57 = new JPanel();
/*  726 */     this.jSpinner1 = new JSpinner();
/*  727 */     this.jSpinner2 = new JSpinner();
/*  728 */     this.jSpinner3 = new JSpinner();
/*  729 */     this.jPanel31 = new JPanel();
/*  730 */     this.jLabel31 = new JLabel();
/*  731 */     this.jPanel32 = new JPanel();
/*  732 */     this.jLabel12 = new JLabel();
/*  733 */     this.cant1 = new JFormattedTextField();
/*  734 */     this.jLabel13 = new JLabel();
/*  735 */     this.cant2 = new JFormattedTextField();
/*  736 */     this.jLabel14 = new JLabel();
/*  737 */     this.cant3 = new JFormattedTextField();
/*  738 */     this.jLabel15 = new JLabel();
/*  739 */     this.cant4 = new JFormattedTextField();
/*  740 */     this.jLabel16 = new JLabel();
/*  741 */     this.cant5 = new JFormattedTextField();
/*  742 */     this.jLabel17 = new JLabel();
/*  743 */     this.jPanel136 = new JPanel();
/*  744 */     this.jTextField86 = new JTextField();
/*  745 */     this.jButton56 = new JButton();
/*  746 */     this.jLabel18 = new JLabel();
/*  747 */     this.cant6 = new JFormattedTextField();
/*  748 */     this.jPanel26 = new JPanel();
/*  749 */     this.jLabel29 = new JLabel();
/*  750 */     this.jPanel30 = new JPanel();
/*  751 */     this.jPanel27 = new JPanel();
/*  752 */     this.jLabel7 = new JLabel();
/*  753 */     this.jComboBox3 = new JComboBox<>();
/*  754 */     this.jLabel8 = new JLabel();
/*  755 */     this.jTextField8 = new JTextField();
/*  756 */     this.jLabel11 = new JLabel();
/*  757 */     this.jTextField10 = new JTextField();
/*  758 */     this.jLabel20 = new JLabel();
/*  759 */     this.jComboBox5 = new JComboBox();
/*  760 */     this.jLabel6 = new JLabel();
/*  761 */     this.jPanel103 = new JPanel();
/*  762 */     this.jTextField6 = new JTextField();
/*  763 */     this.jButton34 = new JButton();
/*  764 */     this.jPanel29 = new JPanel();
/*  765 */     this.jLabel9 = new JLabel();
/*  766 */     this.jTextField7 = new JTextField();
/*  767 */     this.jLabel10 = new JLabel();
/*  768 */     this.jTextField9 = new JTextField();
/*  769 */     this.jLabel19 = new JLabel();
/*  770 */     this.jComboBox4 = new JComboBox();
/*  771 */     this.jLabel21 = new JLabel();
/*  772 */     this.jComboBox6 = new JComboBox();
/*  773 */     this.jPanel33 = new JPanel();
/*  774 */     this.jLabel32 = new JLabel();
/*  775 */     this.jPanel34 = new JPanel();
/*  776 */     this.jPanel35 = new JPanel();
/*  777 */     this.jLabel22 = new JLabel();
/*  778 */     this.jTextField17 = new JTextField();
/*  779 */     this.jLabel24 = new JLabel();
/*  780 */     this.jTextField19 = new JTextField();
/*  781 */     this.jLabel26 = new JLabel();
/*  782 */     this.jPanel134 = new JPanel();
/*  783 */     this.jTextField20 = new JTextField();
/*  784 */     this.jButton57 = new JButton();
/*  785 */     this.jPanel36 = new JPanel();
/*  786 */     this.jLabel23 = new JLabel();
/*  787 */     this.jTextField18 = new JTextField();
/*  788 */     this.jLabel25 = new JLabel();
/*  789 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  790 */     this.jPanel37 = new JPanel();
/*  791 */     this.jLabel33 = new JLabel();
/*  792 */     this.jScrollPane2 = new JScrollPane();
/*  793 */     this.jEditorPane1 = new JEditorPane();
/*  794 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  795 */     this.jPanel135 = new JPanel();
/*  796 */     this.jScrollPane32 = new JScrollPane();
/*  797 */     this.rSTableMetro2 = new RSTableMetro();
/*  798 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  799 */     this.jPanel104 = new JPanel();
/*  800 */     this.jScrollPane34 = new JScrollPane();
/*  801 */     this.rSTableMetro7 = new RSTableMetro();
/*  802 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  803 */     this.jPanel137 = new JPanel();
/*  804 */     this.jScrollPane31 = new JScrollPane();
/*  805 */     this.rSTableMetro3 = new RSTableMetro();
/*  806 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  807 */     this.jPanel38 = new JPanel();
/*  808 */     this.jLabel125 = new JLabel();
/*  809 */     this.jScrollPane18 = new JScrollPane();
/*  810 */     this.jTextArea5 = new JTextArea();
/*  811 */     this.materialButton36 = new MaterialButton();
/*  812 */     this.materialButton37 = new MaterialButton();
/*  813 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  814 */     this.jPanel39 = new JPanel();
/*  815 */     this.materialButton38 = new MaterialButton();
/*  816 */     this.materialButton39 = new MaterialButton();
/*  817 */     this.jPanel1 = new JPanel();
/*  818 */     this.jLabel27 = new JLabel();
/*  819 */     this.jPanel61 = new JPanel();
/*  820 */     this.jLabel126 = new JLabel();
/*  821 */     this.jScrollPane33 = new JScrollPane();
/*  822 */     this.rSTableMetro4 = new RSTableMetro();
/*  823 */     this.materialButton40 = new MaterialButton();
/*  824 */     this.jPanel14 = new JPanel();
/*  825 */     this.jComboBox9 = new JComboBox<>();
/*  826 */     this.jLabel59 = new JLabel();
/*  827 */     this.jLabel49 = new JLabel();
/*  828 */     this.jLabel60 = new JLabel();
/*  829 */     this.jLabel50 = new JLabel();
/*  830 */     this.jPanel13 = new JPanel();
/*  831 */     this.jLabel34 = new JLabel();
/*  832 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  833 */     this.jButton3 = new JButton();
/*  834 */     this.cantidad = new JFormattedTextField();
/*  835 */     this.jPanel24 = new JPanel();
/*  836 */     this.jLabel35 = new JLabel();
/*  837 */     this.jLabel36 = new JLabel();
/*  838 */     this.jTextField11 = new JTextField();
/*  839 */     this.jLabel38 = new JLabel();
/*  840 */     this.jLabel39 = new JLabel();
/*  841 */     this.jLabel40 = new JLabel();
/*  842 */     this.jLabel41 = new JLabel();
/*  843 */     this.jTextField12 = new JTextField();
/*  844 */     this.jTextField13 = new JTextField();
/*  845 */     this.jTextField14 = new JTextField();
/*  846 */     this.jTextField15 = new JTextField();
/*  847 */     this.ProveedorTxt = new JTextField();
/*  848 */     this.jLabel42 = new JLabel();
/*  849 */     this.jTextField16 = new JTextField();
/*  850 */     this.jPanel2 = new JPanel();
/*  851 */     this.jPanel8 = new JPanel();
/*  852 */     this.jLabel55 = new JLabel();
/*  853 */     this.jPanel6 = new JPanel();
/*  854 */     this.jLabel233 = new JLabel();
/*  855 */     this.jPanel7 = new JPanel();
/*  856 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  857 */     this.jLabel234 = new JLabel();
/*  858 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  859 */     this.jComboBox8 = new JComboBox<>();
/*  860 */     this.jPanel11 = new JPanel();
/*  861 */     this.jButton1 = new JButton();
/*  862 */     this.jLabel170 = new JLabel();
/*  863 */     this.jLabel101 = new JLabel();
/*  864 */     this.jLabel171 = new JLabel();
/*  865 */     this.jPanel17 = new JPanel();
/*  866 */     this.jTextField1 = new JTextField();
/*  867 */     this.jTextField2 = new JTextField();
/*  868 */     this.jComboBox2 = new JComboBox();
/*  869 */     this.jComboBox1 = new JComboBox();
/*  870 */     this.jComboBox7 = new JComboBox();
/*  871 */     this.jPanel10 = new JPanel();
/*  872 */     this.jScrollPane13 = new JScrollPane();
/*  873 */     this.rSTableMetro1 = new RSTableMetro();
/*  874 */     this.jPanel3 = new JPanel();
/*  875 */     this.jPanel47 = new JPanel();
/*  876 */     this.jLabel58 = new JLabel();
/*  877 */     this.jLabel48 = new JLabel();
/*  878 */     this.jPanel4 = new JPanel();
/*  879 */     this.jPanel5 = new JPanel();
/*  880 */     this.jButton2 = new JButton();
/*  881 */     this.jButton10 = new JButton();
/*  882 */     this.jButton11 = new JButton();
/*  883 */     this.jButton12 = new JButton();
/*  884 */     this.jButton13 = new JButton();
/*  885 */     this.jButton14 = new JButton();
/*  886 */     this.jPanel151 = new JPanel();
/*  887 */     this.jLabel221 = new JLabel();
/*  888 */     this.jLabel37 = new JLabel();
/*  889 */     this.jLabel222 = new JLabel();
/*  890 */     this.jLabel216 = new JLabel();
/*  891 */     this.jPanel9.setBackground(this.lc.SECUNDARIO2);
/*  892 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/*  893 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/*  894 */     this.materialButton21.setMnemonic('C');
/*  895 */     this.materialButton21.setText("Cerrar");
/*  896 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/*  897 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/*  898 */     this.materialButton21.setHorizontalTextPosition(0);
/*  899 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  901 */             ProvFacturas.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*  904 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/*  905 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/*  906 */     this.materialButton22.setMnemonic('G');
/*  907 */     this.materialButton22.setText("Guardar");
/*  908 */     this.materialButton22.setToolTipText("Guardar (Alt +G)");
/*  909 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/*  910 */     this.materialButton22.setHorizontalTextPosition(0);
/*  911 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  913 */             ProvFacturas.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*  916 */     this.jLabel1.setForeground(this.lc.SECUNDARIO1);
/*  917 */     this.jLabel1.setText(" Leer archivo xml de la factura:");
/*  918 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/*  919 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/*  920 */     this.materialButton23.setMnemonic('G');
/*  921 */     this.materialButton23.setText("Buscar...");
/*  922 */     this.materialButton23.setToolTipText("Guardar (Alt +G)");
/*  923 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/*  924 */     this.materialButton23.setHorizontalTextPosition(0);
/*  925 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  927 */             ProvFacturas.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*  930 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  931 */     this.jPanel9.setLayout(jPanel9Layout);
/*  932 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  934 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  935 */           .addComponent(this.jLabel1, -2, 220, -2)
/*  936 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  937 */           .addComponent((Component)this.materialButton23, -2, 150, -2)
/*  938 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 395, 32767)
/*  939 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/*  940 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  941 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/*  942 */           .addContainerGap()));
/*  943 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  944 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  945 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  946 */           .addComponent((Component)this.materialButton21, -2, 38, -2)
/*  947 */           .addGap(0, 0, 32767))
/*  948 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  949 */           .addComponent((Component)this.materialButton22, -2, 38, -2)
/*  950 */           .addComponent(this.jLabel1))
/*  951 */         .addComponent((Component)this.materialButton23, -1, -1, 32767));
/*  952 */     this.jPanel25.setBackground(this.lc.SECUNDARIO1);
/*  953 */     this.jPanel25.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  954 */     this.jLabel30.setForeground(new Color(255, 255, 255));
/*  955 */     this.jLabel30.setHorizontalAlignment(0);
/*  956 */     this.jLabel30.setText("Información de la factura");
/*  957 */     this.jPanel28.setLayout(new GridLayout(5, 2, 6, 6));
/*  958 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/*  959 */     this.jLabel2.setHorizontalAlignment(4);
/*  960 */     this.jLabel2.setText("Serie");
/*  961 */     this.jPanel28.add(this.jLabel2);
/*  962 */     this.jTextField3.setText("jTextField3");
/*  963 */     this.jPanel28.add(this.jTextField3);
/*  964 */     this.jLabel3.setFont(new Font("Cantarell", 0, 11));
/*  965 */     this.jLabel3.setHorizontalAlignment(4);
/*  966 */     this.jLabel3.setText("Folio");
/*  967 */     this.jPanel28.add(this.jLabel3);
/*  968 */     this.jTextField4.setText("jTextField4");
/*  969 */     this.jPanel28.add(this.jTextField4);
/*  970 */     this.jLabel5.setFont(new Font("Cantarell", 0, 11));
/*  971 */     this.jLabel5.setHorizontalAlignment(4);
/*  972 */     this.jLabel5.setText("Folio fiscal");
/*  973 */     this.jPanel28.add(this.jLabel5);
/*  974 */     this.jTextField5.setText("jTextField5");
/*  975 */     this.jPanel28.add(this.jTextField5);
/*  976 */     this.jLabel4.setFont(new Font("Cantarell", 1, 11));
/*  977 */     this.jLabel4.setHorizontalAlignment(4);
/*  978 */     this.jLabel4.setText("Fecha");
/*  979 */     this.jPanel28.add(this.jLabel4);
/*  980 */     this.jDateChooser1.setDate(this.fechaActual);
/*  981 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/*  982 */     this.jDateChooser1.setEnabled(false);
/*  983 */     this.jDateChooser1.setIcon(this.icon);
/*  984 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  985 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*  986 */     this.jPanel28.add((Component)this.jDateChooser1);
/*  987 */     this.jLabel28.setFont(new Font("Cantarell", 1, 11));
/*  988 */     this.jLabel28.setHorizontalAlignment(4);
/*  989 */     this.jLabel28.setText("Hora");
/*  990 */     this.jPanel28.add(this.jLabel28);
/*  991 */     this.jPanel57.setLayout(new GridLayout(1, 3, 3, 0));
/*  992 */     (new String[24])[0] = "00"; (new String[24])[1] = "01"; (new String[24])[2] = "02"; (new String[24])[3] = "03"; (new String[24])[4] = "04"; (new String[24])[5] = "05"; (new String[24])[6] = "06"; (new String[24])[7] = "07"; (new String[24])[8] = "08"; (new String[24])[9] = "09"; (new String[24])[10] = "10"; (new String[24])[11] = "11"; (new String[24])[12] = "12"; (new String[24])[13] = "13"; (new String[24])[14] = "14"; (new String[24])[15] = "15"; (new String[24])[16] = "16"; (new String[24])[17] = "17"; (new String[24])[18] = "18"; (new String[24])[19] = "19"; (new String[24])[20] = "20"; (new String[24])[21] = "21"; (new String[24])[22] = "22"; (new String[24])[23] = "23"; this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[24]));
/*      */ 
/*      */ 
/*      */     
/*  996 */     this.jPanel57.add(this.jSpinner1);
/*  997 */     (new String[60])[0] = "00"; (new String[60])[1] = "01"; (new String[60])[2] = "02"; (new String[60])[3] = "03"; (new String[60])[4] = "04"; (new String[60])[5] = "05"; (new String[60])[6] = "06"; (new String[60])[7] = "07"; (new String[60])[8] = "08"; (new String[60])[9] = "09"; (new String[60])[10] = "10"; (new String[60])[11] = "11"; (new String[60])[12] = "12"; (new String[60])[13] = "13"; (new String[60])[14] = "14"; (new String[60])[15] = "15"; (new String[60])[16] = "16"; (new String[60])[17] = "17"; (new String[60])[18] = "18"; (new String[60])[19] = "19"; (new String[60])[20] = "20"; (new String[60])[21] = "21"; (new String[60])[22] = "22"; (new String[60])[23] = "23"; (new String[60])[24] = "24"; (new String[60])[25] = "25"; (new String[60])[26] = "26"; (new String[60])[27] = "27"; (new String[60])[28] = "28"; (new String[60])[29] = "29"; (new String[60])[30] = "30"; (new String[60])[31] = "31"; (new String[60])[32] = "32"; (new String[60])[33] = "33"; (new String[60])[34] = "34"; (new String[60])[35] = "35"; (new String[60])[36] = "36"; (new String[60])[37] = "37"; (new String[60])[38] = "38"; (new String[60])[39] = "39"; (new String[60])[40] = "40"; (new String[60])[41] = "41"; (new String[60])[42] = "42"; (new String[60])[43] = "43"; (new String[60])[44] = "44"; (new String[60])[45] = "45"; (new String[60])[46] = "46"; (new String[60])[47] = "47"; (new String[60])[48] = "48"; (new String[60])[49] = "49"; (new String[60])[50] = "50"; (new String[60])[51] = "51"; (new String[60])[52] = "52"; (new String[60])[53] = "53"; (new String[60])[54] = "54"; (new String[60])[55] = "55"; (new String[60])[56] = "56"; (new String[60])[57] = "57"; (new String[60])[58] = "58"; (new String[60])[59] = "59"; this.jSpinner2.setModel(new SpinnerListModel((Object[])new String[60]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1004 */     this.jPanel57.add(this.jSpinner2);
/* 1005 */     (new String[60])[0] = "00"; (new String[60])[1] = "01"; (new String[60])[2] = "02"; (new String[60])[3] = "03"; (new String[60])[4] = "04"; (new String[60])[5] = "05"; (new String[60])[6] = "06"; (new String[60])[7] = "07"; (new String[60])[8] = "08"; (new String[60])[9] = "09"; (new String[60])[10] = "10"; (new String[60])[11] = "11"; (new String[60])[12] = "12"; (new String[60])[13] = "13"; (new String[60])[14] = "14"; (new String[60])[15] = "15"; (new String[60])[16] = "16"; (new String[60])[17] = "17"; (new String[60])[18] = "18"; (new String[60])[19] = "19"; (new String[60])[20] = "20"; (new String[60])[21] = "21"; (new String[60])[22] = "22"; (new String[60])[23] = "23"; (new String[60])[24] = "24"; (new String[60])[25] = "25"; (new String[60])[26] = "26"; (new String[60])[27] = "27"; (new String[60])[28] = "28"; (new String[60])[29] = "29"; (new String[60])[30] = "30"; (new String[60])[31] = "31"; (new String[60])[32] = "32"; (new String[60])[33] = "33"; (new String[60])[34] = "34"; (new String[60])[35] = "35"; (new String[60])[36] = "36"; (new String[60])[37] = "37"; (new String[60])[38] = "38"; (new String[60])[39] = "39"; (new String[60])[40] = "40"; (new String[60])[41] = "41"; (new String[60])[42] = "42"; (new String[60])[43] = "43"; (new String[60])[44] = "44"; (new String[60])[45] = "45"; (new String[60])[46] = "46"; (new String[60])[47] = "47"; (new String[60])[48] = "48"; (new String[60])[49] = "49"; (new String[60])[50] = "50"; (new String[60])[51] = "51"; (new String[60])[52] = "52"; (new String[60])[53] = "53"; (new String[60])[54] = "54"; (new String[60])[55] = "55"; (new String[60])[56] = "56"; (new String[60])[57] = "57"; (new String[60])[58] = "58"; (new String[60])[59] = "59"; this.jSpinner3.setModel(new SpinnerListModel((Object[])new String[60]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1012 */     this.jSpinner3.setNextFocusableComponent(this.cant1);
/* 1013 */     this.jPanel57.add(this.jSpinner3);
/* 1014 */     this.jPanel28.add(this.jPanel57);
/* 1015 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1016 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1017 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1018 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1019 */         .addComponent(this.jLabel30, -1, -1, 32767)
/* 1020 */         .addComponent(this.jPanel28, GroupLayout.Alignment.TRAILING, -1, 303, 32767));
/* 1021 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1023 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1024 */           .addComponent(this.jLabel30)
/* 1025 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1026 */           .addComponent(this.jPanel28, -2, 156, -2)));
/* 1027 */     this.jPanel31.setBackground(this.lc.SECUNDARIO1);
/* 1028 */     this.jPanel31.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 1029 */     this.jLabel31.setForeground(new Color(255, 255, 255));
/* 1030 */     this.jLabel31.setHorizontalAlignment(0);
/* 1031 */     this.jLabel31.setText("Cantidades");
/* 1032 */     this.jPanel32.setLayout(new GridLayout(7, 2, 6, 6));
/* 1033 */     this.jLabel12.setFont(new Font("Cantarell", 1, 11));
/* 1034 */     this.jLabel12.setHorizontalAlignment(4);
/* 1035 */     this.jLabel12.setText("Subtotal");
/* 1036 */     this.jPanel32.add(this.jLabel12);
/* 1037 */     this.cant1.setHorizontalAlignment(4);
/* 1038 */     this.jPanel32.add(this.cant1);
/* 1039 */     this.jLabel13.setFont(new Font("Cantarell", 0, 11));
/* 1040 */     this.jLabel13.setHorizontalAlignment(4);
/* 1041 */     this.jLabel13.setText("Descuento");
/* 1042 */     this.jPanel32.add(this.jLabel13);
/* 1043 */     this.cant2.setHorizontalAlignment(4);
/* 1044 */     this.jPanel32.add(this.cant2);
/* 1045 */     this.jLabel14.setFont(new Font("Cantarell", 0, 11));
/* 1046 */     this.jLabel14.setHorizontalAlignment(4);
/* 1047 */     this.jLabel14.setText("Iva");
/* 1048 */     this.jPanel32.add(this.jLabel14);
/* 1049 */     this.cant3.setHorizontalAlignment(4);
/* 1050 */     this.jPanel32.add(this.cant3);
/* 1051 */     this.jLabel15.setFont(new Font("Cantarell", 0, 11));
/* 1052 */     this.jLabel15.setHorizontalAlignment(4);
/* 1053 */     this.jLabel15.setText("Retención");
/* 1054 */     this.jPanel32.add(this.jLabel15);
/* 1055 */     this.cant4.setHorizontalAlignment(4);
/* 1056 */     this.jPanel32.add(this.cant4);
/* 1057 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/* 1058 */     this.jLabel16.setHorizontalAlignment(4);
/* 1059 */     this.jLabel16.setText("Total");
/* 1060 */     this.jPanel32.add(this.jLabel16);
/* 1061 */     this.cant5.setHorizontalAlignment(4);
/* 1062 */     this.jPanel32.add(this.cant5);
/* 1063 */     this.jLabel17.setFont(new Font("Cantarell", 1, 11));
/* 1064 */     this.jLabel17.setHorizontalAlignment(4);
/* 1065 */     this.jLabel17.setText("Moneda");
/* 1066 */     this.jPanel32.add(this.jLabel17);
/* 1067 */     this.jPanel136.setBackground(new Color(255, 255, 255));
/* 1068 */     this.jTextField86.setEditable(false);
/* 1069 */     this.jButton56.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1070 */     this.jButton56.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1072 */             ProvFacturas.this.jButton56ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1075 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1076 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1077 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1079 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1080 */           .addComponent(this.jTextField86)
/* 1081 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1082 */           .addComponent(this.jButton56, -2, 18, -2)));
/* 1083 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1084 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1085 */         .addComponent(this.jTextField86)
/* 1086 */         .addComponent(this.jButton56, -1, -1, 32767));
/* 1087 */     this.jPanel32.add(this.jPanel136);
/* 1088 */     this.jLabel18.setFont(new Font("Cantarell", 1, 11));
/* 1089 */     this.jLabel18.setHorizontalAlignment(4);
/* 1090 */     this.jLabel18.setText("Tipo de cambio");
/* 1091 */     this.jPanel32.add(this.jLabel18);
/* 1092 */     this.cant6.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
/* 1093 */     this.cant6.setHorizontalAlignment(4);
/* 1094 */     this.jPanel32.add(this.cant6);
/* 1095 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1096 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1097 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1098 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1099 */         .addComponent(this.jLabel31, -1, -1, 32767)
/* 1100 */         .addComponent(this.jPanel32, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/* 1101 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1102 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1103 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1104 */           .addComponent(this.jLabel31)
/* 1105 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1106 */           .addComponent(this.jPanel32, -2, 220, 32767)));
/* 1107 */     this.jPanel26.setBackground(this.lc.SECUNDARIO1);
/* 1108 */     this.jPanel26.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 1109 */     this.jLabel29.setForeground(new Color(255, 255, 255));
/* 1110 */     this.jLabel29.setHorizontalAlignment(0);
/* 1111 */     this.jLabel29.setText("Información del proveedor");
/* 1112 */     this.jPanel30.setLayout(new GridLayout(1, 2, 12, 0));
/* 1113 */     this.jPanel27.setLayout(new GridLayout(5, 2, 6, 6));
/* 1114 */     this.jLabel7.setFont(new Font("Cantarell", 1, 11));
/* 1115 */     this.jLabel7.setHorizontalAlignment(4);
/* 1116 */     this.jLabel7.setText("Nombre del Proveedor");
/* 1117 */     this.jPanel27.add(this.jLabel7);
/* 1118 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1119 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO..." }));
/* 1120 */     this.jComboBox3.setNextFocusableComponent(this.jTextField7);
/* 1121 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1123 */             ProvFacturas.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1126 */     this.jPanel27.add(this.jComboBox3);
/* 1127 */     this.jLabel8.setFont(new Font("Cantarell", 1, 11));
/* 1128 */     this.jLabel8.setHorizontalAlignment(4);
/* 1129 */     this.jLabel8.setText("Código Postal");
/* 1130 */     this.jPanel27.add(this.jLabel8);
/* 1131 */     this.jTextField8.setText("jTextField8");
/* 1132 */     this.jTextField8.setNextFocusableComponent(this.jTextField9);
/* 1133 */     this.jPanel27.add(this.jTextField8);
/* 1134 */     this.jLabel11.setFont(new Font("Cantarell", 0, 11));
/* 1135 */     this.jLabel11.setHorizontalAlignment(4);
/* 1136 */     this.jLabel11.setText("Dirección de la factura");
/* 1137 */     this.jPanel27.add(this.jLabel11);
/* 1138 */     this.jTextField10.setText("jTextField10");
/* 1139 */     this.jTextField10.setNextFocusableComponent(this.jComboBox4);
/* 1140 */     this.jPanel27.add(this.jTextField10);
/* 1141 */     this.jLabel20.setFont(new Font("Cantarell", 1, 11));
/* 1142 */     this.jLabel20.setHorizontalAlignment(4);
/* 1143 */     this.jLabel20.setText("Forma de pago");
/* 1144 */     this.jPanel27.add(this.jLabel20);
/* 1145 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 1146 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "01.- EFECTIVO", "02.- CHEQUE NOMINATIVO", "03.- TRANSFERENCIA ELECTRONICA DE FONDOS", "04.- TARJETA DE CREDITO", "05.- MONEDERO ELECTRONICO", "06.- DINERO ELECTRONICO", "08.- VALES DE DESPENSA", "28.- TARJETA DE DEBITO", "29.- TARJETA DE SERVICIO", "30.- APLICACION DE ANTICIPOS", "99.- POR DEFINIR" }));
/*      */ 
/*      */     
/* 1149 */     this.jComboBox5.setNextFocusableComponent(this.jComboBox6);
/* 1150 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1152 */             ProvFacturas.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1155 */     this.jPanel27.add(this.jComboBox5);
/* 1156 */     this.jLabel6.setFont(new Font("Cantarell", 1, 11));
/* 1157 */     this.jLabel6.setHorizontalAlignment(4);
/* 1158 */     this.jLabel6.setText("Uso del CFDI");
/* 1159 */     this.jPanel27.add(this.jLabel6);
/* 1160 */     this.jTextField6.setEditable(false);
/* 1161 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1162 */     this.jButton34.setNextFocusableComponent(this.jTextField17);
/* 1163 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1165 */             ProvFacturas.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1168 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/* 1169 */     this.jPanel103.setLayout(jPanel103Layout);
/* 1170 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/* 1171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1172 */         .addGroup(jPanel103Layout.createSequentialGroup()
/* 1173 */           .addComponent(this.jTextField6, -1, 150, 32767)
/* 1174 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1175 */           .addComponent(this.jButton34, -2, 19, -2)));
/* 1176 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/* 1177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */         .addComponent(this.jTextField6)
/* 1179 */         .addComponent(this.jButton34, -1, -1, 32767));
/* 1180 */     this.jPanel27.add(this.jPanel103);
/* 1181 */     this.jPanel30.add(this.jPanel27);
/* 1182 */     this.jPanel29.setLayout(new GridLayout(5, 2, 6, 6));
/* 1183 */     this.jLabel9.setFont(new Font("Cantarell", 1, 11));
/* 1184 */     this.jLabel9.setHorizontalAlignment(4);
/* 1185 */     this.jLabel9.setText("RFC");
/* 1186 */     this.jPanel29.add(this.jLabel9);
/* 1187 */     this.jTextField7.setText("jTextField7");
/* 1188 */     this.jTextField7.setNextFocusableComponent(this.jTextField8);
/* 1189 */     this.jPanel29.add(this.jTextField7);
/* 1190 */     this.jLabel10.setFont(new Font("Cantarell", 0, 11));
/* 1191 */     this.jLabel10.setHorizontalAlignment(4);
/* 1192 */     this.jLabel10.setText("Lugar de Expedición (ciudad)");
/* 1193 */     this.jPanel29.add(this.jLabel10);
/* 1194 */     this.jTextField9.setText("jTextField9");
/* 1195 */     this.jTextField9.setNextFocusableComponent(this.jTextField10);
/* 1196 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1198 */             ProvFacturas.this.jTextField9FocusGained(evt);
/*      */           }
/*      */         });
/* 1201 */     this.jPanel29.add(this.jTextField9);
/* 1202 */     this.jLabel19.setFont(new Font("Cantarell", 1, 11));
/* 1203 */     this.jLabel19.setHorizontalAlignment(4);
/* 1204 */     this.jLabel19.setText("Condiciones de pago");
/* 1205 */     this.jLabel19.setToolTipText("Para la fecha de pago se programa con la 'fecha de recepción'");
/* 1206 */     this.jPanel29.add(this.jLabel19);
/* 1207 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1208 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO A 10 DIAS", "CREDITO A 15 DIAS", "CREDITO A 20 DIAS", "CREDITO A 25 DIAS", "CREDITO A 30 DIAS", "CREDITO A 35 DIAS", "CREDITO A 40 DIAS", "CREDITO A 45 DIAS", "CREDITO A 50 DIAS", "CREDITO A 55 DIAS", "CREDITO A 60 DIAS", "CREDITO A 65 DIAS", "CREDITO A 70 DIAS", "CREDITO A 75 DIAS", "CREDITO A 80 DIAS", "CREDITO A 85 DIAS", "CREDITO A 90 DIAS" }));
/*      */ 
/*      */     
/* 1211 */     this.jComboBox4.setNextFocusableComponent(this.jComboBox5);
/* 1212 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1214 */             ProvFacturas.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1217 */     this.jPanel29.add(this.jComboBox4);
/* 1218 */     this.jLabel21.setFont(new Font("Cantarell", 1, 11));
/* 1219 */     this.jLabel21.setHorizontalAlignment(4);
/* 1220 */     this.jLabel21.setText("Método de pago");
/* 1221 */     this.jPanel29.add(this.jLabel21);
/* 1222 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1223 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "PUE-PAGO EN UNA SOLA EXHIBICION", "PPD-PAGO EN PARCIALIDADES" }));
/* 1224 */     this.jComboBox6.setNextFocusableComponent(this.jButton34);
/* 1225 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1227 */             ProvFacturas.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1230 */     this.jPanel29.add(this.jComboBox6);
/* 1231 */     this.jPanel30.add(this.jPanel29);
/* 1232 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 1233 */     this.jPanel26.setLayout(jPanel26Layout);
/* 1234 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 1235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1236 */         .addComponent(this.jLabel29, -1, -1, 32767)
/* 1237 */         .addComponent(this.jPanel30, -2, 0, 32767));
/* 1238 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 1239 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1240 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1241 */           .addComponent(this.jLabel29)
/* 1242 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1243 */           .addComponent(this.jPanel30, -2, 0, 32767)));
/* 1244 */     this.jPanel33.setBackground(this.lc.SECUNDARIO1);
/* 1245 */     this.jPanel33.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 1246 */     this.jLabel32.setForeground(new Color(255, 255, 255));
/* 1247 */     this.jLabel32.setHorizontalAlignment(0);
/* 1248 */     this.jLabel32.setText("Información de la recepción");
/* 1249 */     this.jPanel34.setLayout(new GridLayout(1, 2, 12, 0));
/* 1250 */     this.jPanel35.setLayout(new GridLayout(3, 2, 6, 6));
/* 1251 */     this.jLabel22.setFont(new Font("Cantarell", 1, 11));
/* 1252 */     this.jLabel22.setHorizontalAlignment(4);
/* 1253 */     this.jLabel22.setText("Recibió");
/* 1254 */     this.jPanel35.add(this.jLabel22);
/* 1255 */     this.jTextField17.setText("jTextField17");
/* 1256 */     this.jTextField17.setNextFocusableComponent(this.jTextField18);
/* 1257 */     this.jPanel35.add(this.jTextField17);
/* 1258 */     this.jLabel24.setFont(new Font("Cantarell", 0, 11));
/* 1259 */     this.jLabel24.setHorizontalAlignment(4);
/* 1260 */     this.jLabel24.setText("Lugar");
/* 1261 */     this.jPanel35.add(this.jLabel24);
/* 1262 */     this.jTextField19.setText("jTextField19");
/* 1263 */     this.jTextField19.setEnabled(false);
/* 1264 */     this.jTextField19.setNextFocusableComponent((Component)this.jDateChooser2);
/* 1265 */     this.jPanel35.add(this.jTextField19);
/* 1266 */     this.jLabel26.setFont(new Font("Cantarell", 1, 11));
/* 1267 */     this.jLabel26.setHorizontalAlignment(4);
/* 1268 */     this.jLabel26.setText("Suc. Operativa");
/* 1269 */     this.jPanel35.add(this.jLabel26);
/* 1270 */     this.jPanel134.setBackground(new Color(255, 255, 255));
/* 1271 */     this.jTextField20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1273 */             ProvFacturas.this.jTextField20ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1276 */     this.jButton57.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1277 */     this.jButton57.setNextFocusableComponent(this.jEditorPane1);
/* 1278 */     this.jButton57.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1280 */             ProvFacturas.this.jButton57ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1283 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/* 1284 */     this.jPanel134.setLayout(jPanel134Layout);
/* 1285 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/* 1286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1287 */         .addGroup(jPanel134Layout.createSequentialGroup()
/* 1288 */           .addComponent(this.jTextField20)
/* 1289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1290 */           .addComponent(this.jButton57, -2, 18, -2)));
/* 1291 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/* 1292 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1293 */         .addComponent(this.jTextField20)
/* 1294 */         .addComponent(this.jButton57, -1, -1, 32767));
/* 1295 */     this.jPanel35.add(this.jPanel134);
/* 1296 */     this.jPanel34.add(this.jPanel35);
/* 1297 */     this.jPanel36.setLayout(new GridLayout(3, 2, 6, 6));
/* 1298 */     this.jLabel23.setFont(new Font("Cantarell", 0, 11));
/* 1299 */     this.jLabel23.setHorizontalAlignment(4);
/* 1300 */     this.jLabel23.setText("Entregó");
/* 1301 */     this.jPanel36.add(this.jLabel23);
/* 1302 */     this.jTextField18.setText("jTextField18");
/* 1303 */     this.jTextField18.setNextFocusableComponent(this.jTextField19);
/* 1304 */     this.jPanel36.add(this.jTextField18);
/* 1305 */     this.jLabel25.setFont(new Font("Cantarell", 1, 11));
/* 1306 */     this.jLabel25.setHorizontalAlignment(4);
/* 1307 */     this.jLabel25.setText("Fecha de recepción");
/* 1308 */     this.jLabel25.setToolTipText("Para la fecha de pago se programa con la 'fecha de recepción'");
/* 1309 */     this.jPanel36.add(this.jLabel25);
/* 1310 */     this.jDateChooser2.setDate(this.fechaActual);
/* 1311 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/* 1312 */     this.jDateChooser2.setEnabled(false);
/* 1313 */     this.jDateChooser2.setIcon(this.icon);
/* 1314 */     this.jDateChooser2.setMaxSelectableDate(this.fecha);
/* 1315 */     this.jDateChooser2.setMinSelectableDate(this.fechaInicio);
/* 1316 */     this.jDateChooser2.setNextFocusableComponent(this.jButton57);
/* 1317 */     this.jPanel36.add((Component)this.jDateChooser2);
/* 1318 */     this.jPanel34.add(this.jPanel36);
/* 1319 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1320 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1321 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1322 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1323 */         .addComponent(this.jLabel32, -1, -1, 32767)
/* 1324 */         .addComponent(this.jPanel34, -1, 725, 32767));
/* 1325 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1326 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1327 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1328 */           .addComponent(this.jLabel32)
/* 1329 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1330 */           .addComponent(this.jPanel34, -2, 90, 32767)));
/* 1331 */     this.jPanel37.setBackground(this.lc.SECUNDARIO1);
/* 1332 */     this.jPanel37.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 1333 */     this.jLabel33.setForeground(new Color(255, 255, 255));
/* 1334 */     this.jLabel33.setHorizontalAlignment(0);
/* 1335 */     this.jLabel33.setText("Comentarios adicionales");
/* 1336 */     this.jScrollPane2.setViewportView(this.jEditorPane1);
/* 1337 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 1338 */     this.jPanel37.setLayout(jPanel37Layout);
/* 1339 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 1340 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1341 */         .addComponent(this.jLabel33, -1, 725, 32767)
/* 1342 */         .addComponent(this.jScrollPane2));
/* 1343 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 1344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1345 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 1346 */           .addComponent(this.jLabel33)
/* 1347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1348 */           .addComponent(this.jScrollPane2)));
/* 1349 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1350 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1351 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1352 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1353 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1354 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1355 */             .addComponent(this.jPanel31, -1, -1, 32767)
/* 1356 */             .addComponent(this.jPanel25, -1, -1, 32767))
/* 1357 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1358 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1359 */             .addComponent(this.jPanel26, -1, -1, 32767)
/* 1360 */             .addComponent(this.jPanel33, -1, -1, 32767)
/* 1361 */             .addComponent(this.jPanel37, -1, -1, 32767))));
/* 1362 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1364 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1365 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1366 */             .addComponent(this.jPanel25, -1, -1, 32767)
/* 1367 */             .addComponent(this.jPanel26, -1, -1, 32767))
/* 1368 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1369 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1370 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1371 */               .addComponent(this.jPanel33, -2, -1, -2)
/* 1372 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1373 */               .addComponent(this.jPanel37, -1, -1, 32767))
/* 1374 */             .addComponent(this.jPanel31, -2, -1, -2))
/* 1375 */           .addGap(0, 34, 32767)));
/* 1376 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1377 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1378 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1379 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1380 */         .addComponent(this.jPanel9, -1, -1, 32767)
/* 1381 */         .addComponent(this.jPanel12, -1, -1, 32767));
/* 1382 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1384 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1385 */           .addComponent(this.jPanel12, -1, -1, 32767)
/* 1386 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1387 */           .addComponent(this.jPanel9, -2, -1, -2)));
/* 1388 */     this.jDialog1.setTitle("Sucursales");
/* 1389 */     this.jDialog1.setUndecorated(true);
/* 1390 */     (new Object[2])[0] = null; (new Object[2])[1] = "Veracruz"; (new Object[2][])[0] = new Object[2]; (new Object[2])[0] = null; (new Object[2])[1] = "Poza Rica"; (new Object[2][])[1] = new Object[2]; (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[2]) {
/* 1391 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 1393 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1396 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1400 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1403 */     this.rSTableMetro2.setAltoHead(25);
/* 1404 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1405 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 1406 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1407 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1408 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1409 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1410 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1411 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1412 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1413 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1414 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 1415 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1416 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 1417 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 1418 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1419 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1420 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1422 */             ProvFacturas.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1425 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1427 */             ProvFacturas.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1430 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 1431 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/* 1432 */     this.jPanel135.setLayout(jPanel135Layout);
/* 1433 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/* 1434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1435 */         .addComponent(this.jScrollPane32, -1, 418, 32767));
/* 1436 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/* 1437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1438 */         .addComponent(this.jScrollPane32, -1, 131, 32767));
/* 1439 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1440 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1441 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1442 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1443 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
/* 1444 */           .addGap(0, 0, 0)
/* 1445 */           .addComponent(this.jPanel135, -1, -1, 32767)));
/* 1446 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1447 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1448 */         .addComponent(this.jPanel135, -1, -1, 32767));
/* 1449 */     this.jDialog2.setTitle("Catálogo de uso de comprobantes");
/* 1450 */     this.jDialog2.setUndecorated(true);
/* 1451 */     (new Object[2])[0] = "G01"; (new Object[2])[1] = "ADQUISICIÓN DE MERCANCÍAS"; (new Object[22][])[0] = new Object[2]; (new Object[2])[0] = "D06"; (new Object[2])[1] = "APORTACIONES VOLUNTARIAS AL SAR"; (new Object[22][])[1] = new Object[2]; (new Object[2])[0] = "I07"; (new Object[2])[1] = "COMUNICACIONES SATELITALES"; (new Object[22][])[2] = new Object[2]; (new Object[2])[0] = "I06"; (new Object[2])[1] = "COMUNICACIONES TELEFÓNICAS"; (new Object[22][])[3] = new Object[2]; (new Object[2])[0] = "I01"; (new Object[2])[1] = "CONSTRUCCIONES"; (new Object[22][])[4] = new Object[2]; (new Object[2])[0] = "I05"; (new Object[2])[1] = "DADOS, TROQUELES, MOLDES Y HERRAMENTAL"; (new Object[22][])[5] = new Object[2]; (new Object[2])[0] = "D09"; (new Object[2])[1] = "DEPÓSITOS EN CUENTAS PARA EL AHORRO, PRIMAS QUE TENGAN COMO BASE PLANES DE PENSIONES"; (new Object[22][])[6] = new Object[2]; (new Object[2])[0] = "G02"; (new Object[2])[1] = "DEVOLUCIONES, DESCUENTOS O BONIFICACIONES"; (new Object[22][])[7] = new Object[2]; (new Object[2])[0] = "D04"; (new Object[2])[1] = "DONATIVOS"; (new Object[22][])[8] = new Object[2]; (new Object[2])[0] = "I04"; (new Object[2])[1] = "EQUIPO DE CÓMPUTO Y ACCESORIOS"; (new Object[22][])[9] = new Object[2]; (new Object[2])[0] = "I03"; (new Object[2])[1] = "EQUIPO DE TRANSPORTE"; (new Object[22][])[10] = new Object[2]; (new Object[2])[0] = "D08"; (new Object[2])[1] = "GASTOS DE TRANSPORTACIÓN ESCOLAR OBLIGATORIA"; (new Object[22][])[11] = new Object[2]; (new Object[2])[0] = "G03"; (new Object[2])[1] = "GASTOS EN GENERAL"; (new Object[22][])[12] = new Object[2]; (new Object[2])[0] = "D03"; (new Object[2])[1] = "GASTOS FUNERALES"; (new Object[22][])[13] = new Object[2]; (new Object[2])[0] = "D02"; (new Object[2])[1] = "GASTOS MÉDICOS POR INCAPACIDAD O DISCAPACIDAD"; (new Object[22][])[14] = new Object[2]; (new Object[2])[0] = "D01"; (new Object[2])[1] = "HONORARIOS MEDICOS, DENTALES Y GASTOS HOSPITALARIOS"; (new Object[22][])[15] = new Object[2]; (new Object[2])[0] = "D05"; (new Object[2])[1] = "INTERESES REALES EFECTIVAMENTE PAGADOS POR CRÉDITOS HIPOTECARIOS (CASA HABITACIÓN)"; (new Object[22][])[16] = new Object[2]; (new Object[2])[0] = "I02"; (new Object[2])[1] = "MOBILIARIO Y EQUIPO DE OFICINA POR INVERSIONES"; (new Object[22][])[17] = new Object[2]; (new Object[2])[0] = "I08"; (new Object[2])[1] = "OTRA MAQUINARIA Y EQUIPO"; (new Object[22][])[18] = new Object[2]; (new Object[2])[0] = "D10"; (new Object[2])[1] = "PAGOS POR SERVICIOS EDUCATIVOS (COLEGIATURAS)"; (new Object[22][])[19] = new Object[2]; (new Object[2])[0] = "P01"; (new Object[2])[1] = "POR DEFINIR"; (new Object[22][])[20] = new Object[2]; (new Object[2])[0] = "D07"; (new Object[2])[1] = "PRIMAS POR SEGUROS DE GASTOS MEDICOS"; (new Object[22][])[21] = new Object[2]; (new String[2])[0] = "Clave"; (new String[2])[1] = "Descripción"; this.rSTableMetro7.setModel(new DefaultTableModel(new Object[22][], (Object[])new String[2])
/*      */         {
/*      */ 
/*      */           
/* 1455 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1458 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1461 */     this.rSTableMetro7.setAltoHead(25);
/* 1462 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1463 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/* 1464 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/* 1465 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1466 */     this.rSTableMetro7.setColorFilasForeground1(this.lc.SECUNDARIO1);
/* 1467 */     this.rSTableMetro7.setColorFilasForeground2(this.lc.SECUNDARIO1);
/* 1468 */     this.rSTableMetro7.setColorSelBackgound(this.lc.PRIMARIO2);
/* 1469 */     this.rSTableMetro7.setFont(new Font("Cantarell", 0, 10));
/* 1470 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1471 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1472 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1473 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/* 1474 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/* 1475 */     this.rSTableMetro7.setShowHorizontalLines(false);
/* 1476 */     this.rSTableMetro7.setShowVerticalLines(false);
/* 1477 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/* 1478 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 1479 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1481 */             ProvFacturas.this.rSTableMetro7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1484 */     this.rSTableMetro7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1486 */             ProvFacturas.this.rSTableMetro7KeyReleased(evt);
/*      */           }
/*      */         });
/* 1489 */     this.jScrollPane34.setViewportView((Component)this.rSTableMetro7);
/* 1490 */     if (this.rSTableMetro7.getColumnModel().getColumnCount() > 0) {
/* 1491 */       this.rSTableMetro7.getColumnModel().getColumn(0).setMinWidth(120);
/* 1492 */       this.rSTableMetro7.getColumnModel().getColumn(0).setPreferredWidth(120);
/* 1493 */       this.rSTableMetro7.getColumnModel().getColumn(0).setMaxWidth(120);
/*      */     } 
/* 1495 */     GroupLayout jPanel104Layout = new GroupLayout(this.jPanel104);
/* 1496 */     this.jPanel104.setLayout(jPanel104Layout);
/* 1497 */     jPanel104Layout.setHorizontalGroup(jPanel104Layout
/* 1498 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1499 */         .addComponent(this.jScrollPane34, -1, 543, 32767));
/* 1500 */     jPanel104Layout.setVerticalGroup(jPanel104Layout
/* 1501 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1502 */         .addComponent(this.jScrollPane34, -1, 223, 32767));
/* 1503 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1504 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1505 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addGap(0, 543, 32767)
/* 1508 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1509 */           .addComponent(this.jPanel104, -1, -1, 32767)));
/* 1510 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1512 */         .addGap(0, 223, 32767)
/* 1513 */         .addGroup(jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1514 */           .addComponent(this.jPanel104, -1, -1, 32767)));
/* 1515 */     this.jDialog3.setTitle("Catálogo de Monedas");
/* 1516 */     this.jDialog3.setUndecorated(true);
/* 1517 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1518 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1521 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1524 */     this.rSTableMetro3.setAltoHead(25);
/* 1525 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1526 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1527 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1528 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1529 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1530 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1531 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1532 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1533 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1534 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1535 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1536 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1537 */     this.rSTableMetro3.setShowHorizontalLines(false);
/* 1538 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1539 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1540 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1541 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1543 */             ProvFacturas.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1546 */     this.jScrollPane31.setViewportView((Component)this.rSTableMetro3);
/* 1547 */     GroupLayout jPanel137Layout = new GroupLayout(this.jPanel137);
/* 1548 */     this.jPanel137.setLayout(jPanel137Layout);
/* 1549 */     jPanel137Layout.setHorizontalGroup(jPanel137Layout
/* 1550 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1551 */         .addComponent(this.jScrollPane31, -1, 543, 32767));
/* 1552 */     jPanel137Layout.setVerticalGroup(jPanel137Layout
/* 1553 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1554 */         .addComponent(this.jScrollPane31, -1, 223, 32767));
/* 1555 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1556 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1557 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1559 */         .addGap(0, 543, 32767)
/* 1560 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1561 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1562 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1563 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1564 */         .addGap(0, 223, 32767)
/* 1565 */         .addGroup(jDialog3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1566 */           .addComponent(this.jPanel137, -1, -1, 32767)));
/* 1567 */     this.jDialog4.setTitle("Cancelar Factura");
/* 1568 */     this.jDialog4.setModal(true);
/* 1569 */     this.jLabel125.setFont(new Font("Cantarell", 0, 11));
/* 1570 */     this.jLabel125.setHorizontalAlignment(4);
/* 1571 */     this.jLabel125.setText("Motivo");
/* 1572 */     this.jTextArea5.setColumns(20);
/* 1573 */     this.jTextArea5.setLineWrap(true);
/* 1574 */     this.jTextArea5.setRows(5);
/* 1575 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/* 1576 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1577 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1578 */     this.materialButton36.setMnemonic('C');
/* 1579 */     this.materialButton36.setText("Cerrar");
/* 1580 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1581 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1582 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1583 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1585 */             ProvFacturas.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1588 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1589 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1590 */     this.materialButton37.setMnemonic('A');
/* 1591 */     this.materialButton37.setText("Cancelar CFDI");
/* 1592 */     this.materialButton37.setToolTipText("Cancelar CFDI (Alt+A)");
/* 1593 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1594 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1595 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1597 */             ProvFacturas.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1601 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1602 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1603 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1604 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1605 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1606 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1607 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 1608 */               .addComponent(this.jLabel125, -2, 64, -2)
/* 1609 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1610 */               .addComponent(this.jScrollPane18, -1, 328, 32767))
/* 1611 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1612 */               .addGap(0, 0, 32767)
/* 1613 */               .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1614 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1615 */               .addComponent((Component)this.materialButton36, -2, 105, -2)))
/* 1616 */           .addContainerGap()));
/* 1617 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1618 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1619 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1620 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1621 */             .addComponent(this.jLabel125)
/* 1622 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1623 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1624 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1625 */             .addComponent((Component)this.materialButton36, -2, 38, -2)
/* 1626 */             .addComponent((Component)this.materialButton37, -2, 38, -2))
/* 1627 */           .addContainerGap(-1, 32767)));
/* 1628 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1629 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1630 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1631 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1632 */         .addComponent(this.jPanel38, -1, -1, 32767));
/* 1633 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1634 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1635 */         .addComponent(this.jPanel38, -2, -1, -2));
/* 1636 */     this.jDialog5.setTitle("Facturas por pagar");
/* 1637 */     this.jDialog5.setUndecorated(true);
/*      */     
/* 1639 */     this.jPanel39.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/* 1640 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/* 1641 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 1642 */     this.materialButton38.setMnemonic('C');
/* 1643 */     this.materialButton38.setText("Cerrar");
/* 1644 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/* 1645 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/* 1646 */     this.materialButton38.setHorizontalTextPosition(0);
/* 1647 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1649 */             ProvFacturas.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1652 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/* 1653 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 1654 */     this.materialButton39.setMnemonic('G');
/* 1655 */     this.materialButton39.setText("Guardar");
/* 1656 */     this.materialButton39.setToolTipText("Guardar (Alt+G)");
/* 1657 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/* 1658 */     this.materialButton39.setHorizontalTextPosition(0);
/* 1659 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1661 */             ProvFacturas.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1664 */     this.jPanel1.setBackground(this.lc.SECUNDARIO1);
/* 1665 */     this.jLabel27.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 1666 */     this.jLabel27.setForeground(new Color(255, 255, 255));
/* 1667 */     this.jLabel27.setHorizontalAlignment(0);
/* 1668 */     this.jLabel27.setText("Facturas Vencidas");
/* 1669 */     this.jLabel27.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/* 1671 */             ProvFacturas.this.jLabel27MouseDragged(evt);
/*      */           }
/*      */         });
/* 1674 */     this.jLabel27.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1676 */             ProvFacturas.this.jLabel27MouseClicked(evt);
/*      */           }
/*      */         });
/* 1679 */     this.jPanel61.setBackground(this.lc.PRIMARIO1);
/* 1680 */     this.jPanel61.setLayout(new GridLayout(1, 0));
/* 1681 */     this.jLabel126.setHorizontalAlignment(0);
/* 1682 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 1683 */     this.jLabel126.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1685 */             ProvFacturas.this.jLabel126MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1689 */             ProvFacturas.this.jLabel126MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 1693 */             ProvFacturas.this.jLabel126MouseExited(evt);
/*      */           }
/*      */         });
/* 1696 */     this.jPanel61.add(this.jLabel126);
/* 1697 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1698 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1699 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1700 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1701 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1702 */           .addComponent(this.jLabel27, -1, -1, 32767)
/* 1703 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1704 */           .addComponent(this.jPanel61, -2, 37, -2)));
/* 1705 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1706 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1707 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1708 */           .addComponent(this.jLabel27, -2, 30, -2)
/* 1709 */           .addGap(0, 0, 32767))
/* 1710 */         .addComponent(this.jPanel61, -1, -1, 32767));
/* 1711 */     (new Object[5])[0] = null; (new Object[5])[1] = "Veracruz"; (new Object[5])[2] = null; (new Object[5])[3] = null; (new Object[5])[4] = null; (new Object[2][])[0] = new Object[5]; (new Object[5])[0] = null; (new Object[5])[1] = "Poza Rica"; (new Object[5])[2] = null; (new Object[5])[3] = null; (new Object[5])[4] = null; (new Object[2][])[1] = new Object[5]; (new String[5])[0] = "Num"; (new String[5])[1] = "Folio"; (new String[5])[2] = "Proveedor"; (new String[5])[3] = "RFC"; (new String[5])[4] = "Total"; this.rSTableMetro4.setModel(new DefaultTableModel(new Object[2][], (Object[])new String[5]));
/* 1712 */     this.rSTableMetro4.setAltoHead(25);
/* 1713 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1714 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1715 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1716 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1717 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1718 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1719 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1720 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1721 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1722 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1723 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1724 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1725 */     this.rSTableMetro4.setShowHorizontalLines(false);
/* 1726 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 1727 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1728 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1729 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1731 */             ProvFacturas.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1734 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1736 */             ProvFacturas.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1739 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro4);
/* 1740 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/* 1741 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/* 1742 */     this.materialButton40.setMnemonic('P');
/* 1743 */     this.materialButton40.setText("Imprimir");
/* 1744 */     this.materialButton40.setToolTipText("Imprimir (Alt+P)");
/* 1745 */     this.materialButton40.setFont(new Font("Cantarell", 0, 12));
/* 1746 */     this.materialButton40.setHorizontalTextPosition(0);
/* 1747 */     this.materialButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1749 */             ProvFacturas.this.materialButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1752 */     GridBagLayout jPanel14Layout = new GridBagLayout();
/* 1753 */     jPanel14Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*      */ 
/*      */     
/* 1756 */     jPanel14Layout.rowHeights = new int[] { 0 };
/* 1757 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1758 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1759 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1761 */             ProvFacturas.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1764 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 1765 */     gridBagConstraints.gridx = 0;
/* 1766 */     gridBagConstraints.gridy = 0;
/* 1767 */     gridBagConstraints.fill = 1;
/* 1768 */     this.jPanel14.add(this.jComboBox9, gridBagConstraints);
/* 1769 */     this.jLabel59.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1770 */     this.jLabel59.setForeground(this.lc.SECUNDARIO1);
/* 1771 */     this.jLabel59.setHorizontalAlignment(4);
/* 1772 */     this.jLabel59.setText("Facturas:");
/* 1773 */     gridBagConstraints = new GridBagConstraints();
/* 1774 */     gridBagConstraints.gridx = 2;
/* 1775 */     gridBagConstraints.gridy = 0;
/* 1776 */     gridBagConstraints.fill = 1;
/* 1777 */     gridBagConstraints.weightx = 0.5D;
/* 1778 */     this.jPanel14.add(this.jLabel59, gridBagConstraints);
/* 1779 */     this.jLabel49.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1780 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/* 1781 */     this.jLabel49.setHorizontalAlignment(2);
/* 1782 */     this.jLabel49.setText("t");
/* 1783 */     gridBagConstraints = new GridBagConstraints();
/* 1784 */     gridBagConstraints.gridx = 4;
/* 1785 */     gridBagConstraints.gridy = 0;
/* 1786 */     gridBagConstraints.weightx = 0.5D;
/* 1787 */     this.jPanel14.add(this.jLabel49, gridBagConstraints);
/* 1788 */     this.jLabel60.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1789 */     this.jLabel60.setForeground(this.lc.SECUNDARIO1);
/* 1790 */     this.jLabel60.setHorizontalAlignment(4);
/* 1791 */     this.jLabel60.setText("Debe: ");
/* 1792 */     gridBagConstraints = new GridBagConstraints();
/* 1793 */     gridBagConstraints.gridx = 8;
/* 1794 */     gridBagConstraints.gridy = 0;
/* 1795 */     gridBagConstraints.fill = 1;
/* 1796 */     gridBagConstraints.weightx = 1.0D;
/* 1797 */     this.jPanel14.add(this.jLabel60, gridBagConstraints);
/* 1798 */     this.jLabel50.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 1799 */     this.jLabel50.setForeground(this.lc.PRIMARIO1);
/* 1800 */     this.jLabel50.setHorizontalAlignment(2);
/* 1801 */     this.jLabel50.setText("$0.00");
/* 1802 */     gridBagConstraints = new GridBagConstraints();
/* 1803 */     gridBagConstraints.gridx = 10;
/* 1804 */     gridBagConstraints.gridy = 0;
/* 1805 */     gridBagConstraints.fill = 1;
/* 1806 */     gridBagConstraints.weightx = 1.0D;
/* 1807 */     this.jPanel14.add(this.jLabel50, gridBagConstraints);
/*      */     
/* 1809 */     GridBagLayout jPanel13Layout = new GridBagLayout();
/* 1810 */     jPanel13Layout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
/* 1811 */     jPanel13Layout.rowHeights = new int[] { 0 };
/* 1812 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1813 */     this.jLabel34.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 1814 */     this.jLabel34.setForeground(this.lc.SECUNDARIO1);
/* 1815 */     this.jLabel34.setText(" Fecha de corte ");
/* 1816 */     gridBagConstraints = new GridBagConstraints();
/* 1817 */     gridBagConstraints.gridx = 0;
/* 1818 */     gridBagConstraints.gridy = 0;
/* 1819 */     this.jPanel13.add(this.jLabel34, gridBagConstraints);
/*      */     
/* 1821 */     this.jDateChooser6.setDate(this.fechaActual);
/* 1822 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/* 1823 */     this.jDateChooser6.setIcon(this.icon);
/* 1824 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/* 1825 */     gridBagConstraints = new GridBagConstraints();
/* 1826 */     gridBagConstraints.gridx = 2;
/* 1827 */     gridBagConstraints.gridy = 0;
/* 1828 */     gridBagConstraints.fill = 1;
/* 1829 */     gridBagConstraints.weightx = 1.0D;
/* 1830 */     this.jPanel13.add((Component)this.jDateChooser6, gridBagConstraints);
/*      */     
/* 1832 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1833 */     this.jButton3.setMnemonic('F');
/* 1834 */     this.jButton3.setToolTipText("Filtrar información (Alt+F)");
/* 1835 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1837 */             ProvFacturas.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1840 */     gridBagConstraints = new GridBagConstraints();
/* 1841 */     gridBagConstraints.gridx = 4;
/* 1842 */     gridBagConstraints.gridy = 0;
/* 1843 */     gridBagConstraints.fill = 3;
/* 1844 */     this.jPanel13.add(this.jButton3, gridBagConstraints);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1855 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 1856 */     this.jPanel39.setLayout(jPanel39Layout);
/* 1857 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 1858 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1859 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1860 */           .addContainerGap()
/* 1861 */           .addComponent(this.jPanel14, -1, -1, 32767)
/* 1862 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1863 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/* 1864 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1865 */           .addComponent((Component)this.materialButton40, -2, 150, -2)
/* 1866 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1867 */           .addComponent((Component)this.materialButton38, -2, 105, -2)
/* 1868 */           .addContainerGap())
/* 1869 */         .addComponent(this.jPanel1, -1, -1, 32767)
/* 1870 */         .addComponent(this.jScrollPane33, -1, 855, 32767)
/* 1871 */         .addGroup(jPanel39Layout.createSequentialGroup()
/*      */           
/* 1873 */           .addComponent(this.jPanel13, -2, 331, -2)
/* 1874 */           .addGap(0, 0, 32767)));
/* 1875 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 1876 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1877 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 1878 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 1879 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1880 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1881 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1882 */           .addComponent(this.jScrollPane33, -1, 351, 32767)
/* 1883 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1884 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1885 */             .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1886 */               .addComponent((Component)this.materialButton38, -2, 38, -2)
/* 1887 */               .addComponent((Component)this.materialButton39, -2, 38, -2)
/* 1888 */               .addComponent((Component)this.materialButton40, -2, 38, -2))
/* 1889 */             .addComponent(this.jPanel14, -1, -1, 32767))
/* 1890 */           .addContainerGap()));
/* 1891 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1892 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1893 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1895 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1896 */           .addComponent(this.jPanel39, -1, -1, 32767)
/* 1897 */           .addGap(0, 0, 0)));
/* 1898 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1899 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1900 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1901 */           .addComponent(this.jPanel39, -1, -1, 32767)
/* 1902 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1905 */     this.cantidad.setText("jFormattedTextField2");
/* 1906 */     this.jLabel35.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1907 */     this.jLabel35.setText("Serie");
/* 1908 */     this.jLabel36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1909 */     this.jLabel36.setText("<html>¡CONFIRMACIÓN! ya que se encuentra agregada una factura con la misma información.</html>");
/* 1910 */     this.jTextField11.setEditable(false);
/* 1911 */     this.jTextField11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1912 */     this.jLabel38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1913 */     this.jLabel38.setText("Folio");
/* 1914 */     this.jLabel39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1915 */     this.jLabel39.setText("Fecha");
/* 1916 */     this.jLabel40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1917 */     this.jLabel40.setText("Total");
/* 1918 */     this.jLabel41.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1919 */     this.jLabel41.setText("Proveedor");
/* 1920 */     this.jTextField12.setEditable(false);
/* 1921 */     this.jTextField12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1922 */     this.jTextField13.setEditable(false);
/* 1923 */     this.jTextField13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1924 */     this.jTextField14.setEditable(false);
/* 1925 */     this.jTextField14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1926 */     this.jTextField15.setEditable(false);
/* 1927 */     this.jTextField15.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1928 */     this.jLabel42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1929 */     this.jLabel42.setText("Estado");
/* 1930 */     this.jTextField16.setEditable(false);
/* 1931 */     this.jTextField16.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 1932 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 1933 */     this.jPanel24.setLayout(jPanel24Layout);
/* 1934 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 1935 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1936 */         .addComponent(this.jLabel36, -2, 0, 32767)
/* 1937 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1938 */           .addContainerGap()
/* 1939 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1940 */             .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1941 */               .addGroup(jPanel24Layout.createSequentialGroup()
/* 1942 */                 .addComponent(this.jLabel35, -2, 101, -2)
/* 1943 */                 .addGap(18, 18, 18)
/* 1944 */                 .addComponent(this.jTextField11, -2, 306, -2))
/* 1945 */               .addGroup(jPanel24Layout.createSequentialGroup()
/* 1946 */                 .addComponent(this.jLabel38, -2, 101, -2)
/* 1947 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1948 */                 .addComponent(this.jTextField12, -2, 306, -2)))
/* 1949 */             .addGroup(jPanel24Layout.createSequentialGroup()
/* 1950 */               .addComponent(this.jLabel39, -2, 101, -2)
/* 1951 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1952 */               .addComponent(this.jTextField13, -2, 306, -2))
/* 1953 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 1954 */               .addComponent(this.jLabel40, -2, 101, -2)
/* 1955 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1956 */               .addComponent(this.jTextField14, -2, 306, -2))
/* 1957 */             .addGroup(jPanel24Layout.createSequentialGroup()
/* 1958 */               .addComponent(this.jLabel41, -2, 101, -2)
/* 1959 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1960 */               .addComponent(this.jTextField15, -2, 306, -2))
/* 1961 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 1962 */               .addComponent(this.jLabel42, -2, 101, -2)
/* 1963 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1964 */               .addComponent(this.jTextField16, -2, 306, -2)))
/* 1965 */           .addContainerGap()));
/* 1966 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 1967 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1968 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1969 */           .addComponent(this.jLabel36, -2, 41, -2)
/* 1970 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1971 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1972 */             .addComponent(this.jTextField11, -2, -1, -2)
/* 1973 */             .addComponent(this.jLabel35))
/* 1974 */           .addGap(4, 4, 4)
/* 1975 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1976 */             .addComponent(this.jLabel38)
/* 1977 */             .addComponent(this.jTextField12, -2, -1, -2))
/* 1978 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1979 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1980 */             .addComponent(this.jLabel39)
/* 1981 */             .addComponent(this.jTextField13, -2, -1, -2))
/* 1982 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1983 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1984 */             .addComponent(this.jTextField14, -2, -1, -2)
/* 1985 */             .addComponent(this.jLabel40))
/* 1986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1987 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1988 */             .addComponent(this.jLabel41)
/* 1989 */             .addComponent(this.jTextField15, -2, -1, -2))
/* 1990 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1991 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1992 */             .addComponent(this.jLabel42)
/* 1993 */             .addComponent(this.jTextField16, -2, -1, -2))
/* 1994 */           .addContainerGap(10, 32767)));
/* 1995 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/* 1996 */     this.jPanel8.setBackground(this.lc.SECUNDARIO2);
/* 1997 */     this.jLabel55.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 1998 */     this.jLabel55.setForeground(this.lc.PRIMARIO2);
/* 1999 */     this.jLabel55.setHorizontalAlignment(0);
/* 2000 */     this.jLabel55.setText("Facturas de Proveedores");
/* 2001 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/* 2002 */     this.jLabel233.setFont(new Font("Cantarell", 0, 11));
/* 2003 */     this.jLabel233.setHorizontalAlignment(4);
/* 2004 */     this.jLabel233.setText("Visualizando información del ");
/* 2005 */     this.jPanel7.setBackground(this.lc.SECUNDARIO2);
/* 2006 */     this.jPanel7.setLayout(new GridBagLayout());
/* 2007 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2008 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2009 */     this.jDateChooser4.setIcon(this.icon);
/* 2010 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/* 2011 */     gridBagConstraints = new GridBagConstraints();
/* 2012 */     gridBagConstraints.gridx = 0;
/* 2013 */     gridBagConstraints.gridy = 0;
/* 2014 */     gridBagConstraints.fill = 2;
/* 2015 */     gridBagConstraints.weightx = 1.0D;
/* 2016 */     this.jPanel7.add((Component)this.jDateChooser4, gridBagConstraints);
/* 2017 */     this.jLabel234.setFont(new Font("Cantarell", 0, 11));
/* 2018 */     this.jLabel234.setHorizontalAlignment(0);
/* 2019 */     this.jLabel234.setText("     al     ");
/* 2020 */     gridBagConstraints = new GridBagConstraints();
/* 2021 */     gridBagConstraints.gridx = 1;
/* 2022 */     gridBagConstraints.gridy = 0;
/* 2023 */     gridBagConstraints.fill = 2;
/* 2024 */     this.jPanel7.add(this.jLabel234, gridBagConstraints);
/* 2025 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2026 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2027 */     this.jDateChooser5.setIcon(this.icon);
/* 2028 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/* 2029 */     gridBagConstraints = new GridBagConstraints();
/* 2030 */     gridBagConstraints.gridx = 2;
/* 2031 */     gridBagConstraints.gridy = 0;
/* 2032 */     gridBagConstraints.fill = 2;
/* 2033 */     gridBagConstraints.weightx = 1.0D;
/* 2034 */     this.jPanel7.add((Component)this.jDateChooser5, gridBagConstraints);
/* 2035 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 2036 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "Fecha de Recepción", "Fecha de Pago", "Fecha de Factura" }));
/* 2037 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2039 */             ProvFacturas.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2042 */     gridBagConstraints = new GridBagConstraints();
/* 2043 */     gridBagConstraints.fill = 2;
/* 2044 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 2045 */     this.jPanel7.add(this.jComboBox8, gridBagConstraints);
/* 2046 */     this.jPanel11.setBackground(this.lc.SECUNDARIO2);
/* 2047 */     this.jPanel11.setLayout(new GridLayout(1, 4, 6, 0));
/* 2048 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2049 */     this.jButton1.setMnemonic('F');
/* 2050 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2051 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2053 */             ProvFacturas.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2056 */     this.jPanel11.add(this.jButton1);
/* 2057 */     this.jLabel170.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 2058 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 2059 */     this.jLabel170.setHorizontalAlignment(0);
/* 2060 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 2061 */     this.jLabel170.setToolTipText("Retroceder un día en la búsqueda");
/* 2062 */     this.jLabel170.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2064 */             ProvFacturas.this.jLabel170MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2068 */             ProvFacturas.this.jLabel170MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 2072 */             ProvFacturas.this.jLabel170MouseExited(evt);
/*      */           }
/*      */         });
/* 2075 */     this.jPanel11.add(this.jLabel170);
/* 2076 */     this.jLabel101.setFont(new Font("Tahoma", 2, 12));
/* 2077 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 2078 */     this.jLabel101.setHorizontalAlignment(0);
/* 2079 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 2080 */     this.jLabel101.setToolTipText("Clic para filtrar los datos de HOY");
/* 2081 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2083 */             ProvFacturas.this.jLabel101MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2087 */             ProvFacturas.this.jLabel101MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 2091 */             ProvFacturas.this.jLabel101MouseExited(evt);
/*      */           }
/*      */         });
/* 2094 */     this.jPanel11.add(this.jLabel101);
/* 2095 */     this.jLabel171.setHorizontalAlignment(0);
/* 2096 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 2097 */     this.jLabel171.setToolTipText("Aumentar un día en la búsqueda");
/* 2098 */     this.jLabel171.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2100 */             ProvFacturas.this.jLabel171MouseClicked(evt);
/*      */           }
/*      */           
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2104 */             ProvFacturas.this.jLabel171MouseEntered(evt);
/*      */           }
/*      */           
/*      */           public void mouseExited(MouseEvent evt) {
/* 2108 */             ProvFacturas.this.jLabel171MouseExited(evt);
/*      */           }
/*      */         });
/* 2111 */     this.jPanel11.add(this.jLabel171);
/* 2112 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 2113 */     this.jPanel6.setLayout(jPanel6Layout);
/* 2114 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 2115 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2116 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2117 */           .addContainerGap()
/* 2118 */           .addComponent(this.jLabel233, -2, 155, -2)
/* 2119 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2120 */           .addComponent(this.jPanel7, -2, 442, -2)
/* 2121 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2122 */           .addComponent(this.jPanel11, -2, 132, -2)
/* 2123 */           .addContainerGap(-1, 32767)));
/* 2124 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 2125 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2126 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2127 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2128 */             .addComponent(this.jPanel11, -1, -1, 32767)
/* 2129 */             .addComponent(this.jLabel233, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2130 */             .addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2131 */           .addGap(0, 0, 32767)));
/* 2132 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 2133 */     this.jPanel8.setLayout(jPanel8Layout);
/* 2134 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 2135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2136 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 2137 */           .addComponent(this.jLabel55)
/* 2138 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2139 */           .addComponent(this.jPanel6, -1, -1, 32767)));
/* 2140 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 2141 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2142 */         .addComponent(this.jPanel6, -1, -1, 32767)
/* 2143 */         .addComponent(this.jLabel55, -1, -1, 32767));
/* 2144 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 2145 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 2146 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 2147 */     this.jPanel17.setLayout(new GridLayout(1, 5, 6, 0));
/* 2148 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2150 */             ProvFacturas.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2153 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2155 */             ProvFacturas.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2158 */     this.jPanel17.add(this.jTextField1);
/* 2159 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2161 */             ProvFacturas.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2164 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2166 */             ProvFacturas.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2169 */     this.jPanel17.add(this.jTextField2);
/* 2170 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2171 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2172 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Pendientes de pago>", "<Por Pagar>", "<Abono>", "<Pagada>", "<Cancelada>" }));
/* 2173 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2175 */             ProvFacturas.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2178 */     this.jPanel17.add(this.jComboBox2);
/* 2179 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2180 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2181 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL OPERATIVA" }));
/* 2182 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2184 */             ProvFacturas.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2187 */     this.jPanel17.add(this.jComboBox1);
/* 2188 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 2189 */     this.jComboBox7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2190 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "USUARIO" }));
/* 2191 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2193 */             ProvFacturas.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2196 */     this.jPanel17.add(this.jComboBox7);
/* 2197 */     this.jPanel10.setBackground(this.lc.SECUNDARIO2);
/* 2198 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 2199 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2202 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2205 */     this.rSTableMetro1.setAltoHead(40);
/* 2206 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2207 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 2208 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 2209 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 2210 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 2211 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 2212 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 2213 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2214 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2215 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2216 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 2217 */     this.rSTableMetro1.setRowHeight(18);
/* 2218 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 2219 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 2220 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 2221 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 2222 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2223 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2225 */             ProvFacturas.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 2228 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2230 */             ProvFacturas.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2233 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/* 2234 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/* 2235 */     this.jPanel3.setLayout(new GridLayout(1, 0, 6, 0));
/* 2236 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/* 2237 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/* 2238 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 2239 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 2240 */     this.jLabel58.setHorizontalAlignment(4);
/* 2241 */     this.jLabel58.setText("Total: ");
/* 2242 */     this.jPanel47.add(this.jLabel58);
/* 2243 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 2244 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 2245 */     this.jLabel48.setHorizontalAlignment(2);
/* 2246 */     this.jLabel48.setText("t");
/* 2247 */     this.jPanel47.add(this.jLabel48);
/* 2248 */     this.jPanel3.add(this.jPanel47);
/* 2249 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 2250 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2251 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2252 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2253 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2254 */         .addGap(0, 104, 32767));
/* 2255 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2256 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2257 */         .addGap(0, 36, 32767));
/* 2258 */     this.jPanel3.add(this.jPanel4);
/* 2259 */     this.jPanel5.setBackground(this.lc.SECUNDARIO2);
/* 2260 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2261 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2262 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2263 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2264 */         .addGap(0, 104, 32767));
/* 2265 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2266 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2267 */         .addGap(0, 36, 32767));
/* 2268 */     this.jPanel3.add(this.jPanel5);
/* 2269 */     this.jButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2270 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 2271 */     this.jButton2.setMnemonic('N');
/* 2272 */     this.jButton2.setText("Nueva");
/* 2273 */     this.jButton2.setToolTipText("Nueva Cuenta (Alt + N)");
/* 2274 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2276 */             ProvFacturas.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2279 */     this.jPanel3.add(this.jButton2);
/* 2280 */     this.jButton10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2281 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 2282 */     this.jButton10.setMnemonic('M');
/* 2283 */     this.jButton10.setText("Modificar");
/* 2284 */     this.jButton10.setToolTipText("Modificar (Alt + M)");
/* 2285 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2287 */             ProvFacturas.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2290 */     this.jPanel3.add(this.jButton10);
/* 2291 */     this.jButton11.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2292 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/money-transfer.png")));
/* 2293 */     this.jButton11.setMnemonic('E');
/* 2294 */     this.jButton11.setText("Pendientes");
/* 2295 */     this.jButton11.setToolTipText("Pendientes de pago (Alt+E)");
/* 2296 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2298 */             ProvFacturas.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2301 */     this.jPanel3.add(this.jButton11);
/* 2302 */     this.jButton12.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2303 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 2304 */     this.jButton12.setMnemonic('C');
/* 2305 */     this.jButton12.setText("Cancelar");
/* 2306 */     this.jButton12.setToolTipText("Cancelar (Alt+C)");
/* 2307 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2309 */             ProvFacturas.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2312 */     this.jPanel3.add(this.jButton12);
/* 2313 */     this.jButton13.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2314 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2315 */     this.jButton13.setMnemonic('p');
/* 2316 */     this.jButton13.setText("Imprimir");
/* 2317 */     this.jButton13.setToolTipText("Imprimir (Alt+P)");
/* 2318 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2320 */             ProvFacturas.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2323 */     this.jPanel3.add(this.jButton13);
/* 2324 */     this.jButton14.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2325 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2326 */     this.jButton14.setMnemonic('G');
/* 2327 */     this.jButton14.setText("Guardar Reporte");
/* 2328 */     this.jButton14.setToolTipText("Guardar (Alt + G)");
/* 2329 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2331 */             ProvFacturas.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2334 */     this.jPanel3.add(this.jButton14);
/* 2335 */     this.jPanel151.setBorder(BorderFactory.createBevelBorder(1));
/* 2336 */     this.jPanel151.setLayout(new GridLayout(1, 12, 12, 0));
/* 2337 */     this.jLabel221.setFont(new Font("Tahoma", 0, 10));
/* 2338 */     this.jLabel221.setHorizontalAlignment(4);
/* 2339 */     this.jLabel221.setText("TOTAL:");
/* 2340 */     this.jPanel151.add(this.jLabel221);
/* 2341 */     this.jLabel37.setFont(new Font("Tahoma", 1, 10));
/* 2342 */     this.jLabel37.setHorizontalAlignment(2);
/* 2343 */     this.jLabel37.setText("total");
/* 2344 */     this.jPanel151.add(this.jLabel37);
/* 2345 */     this.jLabel222.setFont(new Font("Tahoma", 0, 10));
/* 2346 */     this.jLabel222.setHorizontalAlignment(4);
/* 2347 */     this.jLabel222.setText(" DEBE:");
/* 2348 */     this.jPanel151.add(this.jLabel222);
/* 2349 */     this.jLabel216.setFont(new Font("Tahoma", 1, 10));
/* 2350 */     this.jLabel216.setForeground(new Color(255, 0, 0));
/* 2351 */     this.jLabel216.setHorizontalAlignment(2);
/* 2352 */     this.jLabel216.setText("debe");
/* 2353 */     this.jPanel151.add(this.jLabel216);
/* 2354 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 2355 */     this.jPanel10.setLayout(jPanel10Layout);
/* 2356 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 2357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2358 */         .addComponent(this.jScrollPane13, -1, 990, 32767)
/* 2359 */         .addComponent(this.jPanel3, -2, 0, 32767)
/* 2360 */         .addComponent(this.jPanel151, -2, 0, 32767));
/* 2361 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 2362 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2363 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 2364 */           .addComponent(this.jScrollPane13, -1, 260, 32767)
/* 2365 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2366 */           .addComponent(this.jPanel151, -2, -1, -2)
/* 2367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2368 */           .addComponent(this.jPanel3, -2, 36, -2)
/* 2369 */           .addGap(8, 8, 8)));
/* 2370 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2371 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2372 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2373 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2374 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 2375 */         .addComponent(this.jPanel17, -1, -1, 32767)
/* 2376 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 2377 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2379 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2380 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 2381 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2382 */           .addComponent(this.jPanel17, -2, 26, -2)
/* 2383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2384 */           .addComponent(this.jPanel10, -1, -1, 32767)));
/* 2385 */     GroupLayout layout = new GroupLayout(this);
/* 2386 */     setLayout(layout);
/* 2387 */     layout.setHorizontalGroup(layout
/* 2388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2389 */         .addGap(0, 990, 32767)
/* 2390 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2391 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/* 2392 */     layout.setVerticalGroup(layout
/* 2393 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2394 */         .addGap(0, 403, 32767)
/* 2395 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2396 */           .addComponent(this.jPanel2, -1, -1, 32767)));
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 2400 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2404 */     String cadena = this.jTextField1.getText();
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
/* 2415 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 2420 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2424 */     String cadena = this.jTextField2.getText();
/* 2425 */     if (!cadena.equals("")) {
/* 2426 */       if (this.presionado == null) {
/* 2427 */         this.presionado = new Presionado();
/* 2428 */         this.presionado.start();
/*      */       } else {
/* 2430 */         this.presionado.detenerFuera();
/* 2431 */         this.presionado = new Presionado();
/* 2432 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2435 */       this.jTextField2.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2440 */     if (this.PRIMERA) {
/* 2441 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2446 */     if (this.PRIMERA) {
/* 2447 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2452 */     if (!this.primeraNuevo) {
/* 2453 */       llenarComboProv();
/*      */     }
/* 2455 */     this.leyendoXML = false;
/* 2456 */     activar();
/* 2457 */     limpiarNuevo();
/* 2458 */     limpiarTablaSuc();
/* 2459 */     this.materialButton22.setVisible(true);
/* 2460 */     this.materialButton22.setText("Guardar");
/* 2461 */     this.materialButton22.setToolTipText("Guardar (Alt + G)");
/* 2462 */     this.jLabel1.setVisible(true);
/* 2463 */     this.materialButton23.setVisible(true);
/* 2464 */     this.fichas.addTab("Agregar Factura", this.jPanel20);
/* 2465 */     this.fichas.setSelectedIndex(1);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2469 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2470 */     if (indice < 0) {
/* 2471 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para modificar la información", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2473 */       if (!this.primeraNuevo) {
/* 2474 */         llenarComboProv();
/*      */       }
/* 2476 */       llenarSucursales();
/* 2477 */       limpiarTablaSuc();
/* 2478 */       this.NUMFACT = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 2479 */       this.NOMBRECOMERCIAL = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3).toString();
/* 2480 */       this.TOTALFACTURA = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 7).toString();
/* 2481 */       this.ACTIVARSUC = "";
/* 2482 */       verFactura();
/* 2483 */       activar();
/* 2484 */       String[] sucursales = this.ACTIVARSUC.split(", ");
/* 2485 */       for (String v : sucursales) {
/* 2486 */         selecTablaSucursal(v);
/*      */       }
/* 2488 */       if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 2489 */         this.jTextField20.setEnabled(true);
/* 2490 */         this.jTextField20.setText("");
/* 2491 */         this.jButton57.setEnabled(true);
/*      */       } 
/* 2493 */       this.materialButton22.setVisible(true);
/* 2494 */       this.materialButton22.setText("Modificar");
/* 2495 */       this.materialButton22.setToolTipText("Modificar (Alt + M)");
/* 2496 */       this.jLabel4.setVisible(true);
/* 2497 */       this.jLabel1.setVisible(true);
/* 2498 */       this.materialButton23.setVisible(true);
/* 2499 */       this.fichas.addTab("Modificar Factura: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)), this.jPanel20);
/* 2500 */       this.fichas.setSelectedIndex(1);
/* 2501 */       if (!this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString().contains("<Por Pagar>")) {
/* 2502 */         this.jLabel1.setVisible(false);
/* 2503 */         this.materialButton23.setVisible(false);
/* 2504 */         this.jComboBox3.setEnabled(false);
/* 2505 */         this.cant1.setEnabled(false);
/* 2506 */         this.cant2.setEnabled(false);
/* 2507 */         this.cant3.setEnabled(false);
/* 2508 */         this.cant4.setEnabled(false);
/* 2509 */         this.cant5.setEnabled(false);
/* 2510 */         JOptionPane.showMessageDialog(this.padre, "La facura que seleccionaste ya tiene movimientos agregados que afectan los saldos\nPuedes modificar solo algunos datos que no afectan la tarjeta deudor.", "Factura con movimientos", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2516 */     this.comboCargado = false;
/* 2517 */     this.jComboBox9.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 2518 */     this.comboCargado = true;
/* 2519 */     verPendientes();
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2523 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2524 */     if (indice < 0) {
/* 2525 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para poder cancelar", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 2527 */       String v = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2528 */       if (v.equals("<Por Pagar>")) {
/* 2529 */         this.jTextArea5.setText("");
/* 2530 */         this.con.consultar("numProv", "prov_facturas", "where numFactura=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 2531 */         this.TARJETA = this.con.Campo;
/* 2532 */         this.jDialog4.setTitle("Cacnelar Factura: " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 5)));
/* 2533 */         this.jDialog4.setVisible(true);
/*      */       } else {
/* 2535 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar éste comprobante porque su estatus no es '<Por Pagar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 2542 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2543 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 2544 */       String año = cadenaFecha1.substring(0, 4);
/* 2545 */       String mes = cadenaFecha1.substring(4, 6);
/* 2546 */       String dia = cadenaFecha1.substring(6, 8);
/* 2547 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/* 2548 */       cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 2549 */       año = cadenaFecha1.substring(0, 4);
/* 2550 */       mes = cadenaFecha1.substring(4, 6);
/* 2551 */       dia = cadenaFecha1.substring(6, 8);
/* 2552 */       fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/* 2553 */       String cliente = "GENERAL";
/* 2554 */       if (!this.jTextField2.getText().equals(this.holderProveedor)) {
/* 2555 */         cliente = this.jTextField2.getText().toUpperCase();
/*      */       }
/* 2557 */       String sicret = "LOGO.jpg";
/* 2558 */       String forsis = "forsis100x.jpg";
/* 2559 */       JTable aux = crearTablaAux((JTable)this.rSTableMetro1, new Object[] { "cont", "FRecepcion", "FPago", "Proveedor", "Rfc", "Factura", "FFactura", "Total", "Debe", "Estatus" });
/* 2560 */       Map<Object, Object> datos = new HashMap<>();
/* 2561 */       datos.put("sucursal", this.jComboBox9.getSelectedItem().toString());
/* 2562 */       datos.put("periodo", fechaCompleta);
/* 2563 */       datos.put("estatus", this.jComboBox2.getSelectedItem().toString().toUpperCase());
/* 2564 */       datos.put("proveedor", cliente.toUpperCase());
/* 2565 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 2566 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 2567 */       datos.put("visualizando", this.jComboBox8.getSelectedItem().toString().toUpperCase());
/* 2568 */       datos.put("TTotal", this.jLabel37.getText());
/* 2569 */       datos.put("TDebe", this.jLabel216.getText());
/* 2570 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 2571 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_FacturasGenerales.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 2572 */       JasperViewer visor = new JasperViewer(print, false);
/* 2573 */       visor.setTitle("Facturas");
/* 2574 */       visor.setIconImage(this.iconoImprimir);
/* 2575 */       visor.setZoomRatio(0.59F);
/* 2576 */       visor.setExtendedState(6);
/* 2577 */       visor.setVisible(true);
/* 2578 */     } catch (JRException e) {
/* 2579 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2584 */     String[] datos = { "ID", "RECEPCIÓN", "PAGO", "PROVEEDOR", "RFC", "FOLIO", "FECHA DE FACTURA", "TOTAL", "DEBE", "CONDICIONES DE PAGO", "ESTADO", "SUCURSAL", "ACTUALIZO (dd/mm/aaaa)" };
/*      */ 
/*      */     
/* 2587 */     this.esc = new EscribirReporte("FACTURAS - CUENTAS POR PAGAR", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 2591 */     this.fichas.removeTabAt(1);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 2595 */     int[] dias = { 0, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90 };
/* 2596 */     DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 2597 */     if (!this.materialButton22.getText().equals("Imprimir")) {
/* 2598 */       String suc = dameSucursalOp(this.jTextField20, (JTable)this.rSTableMetro2);
/* 2599 */       String actualizo = this.USUARIO + this.USUARIO;
/* 2600 */       if (this.jComboBox3.getSelectedIndex() == 0) {
/* 2601 */         this.error.cargarError(this.jComboBox3, "050");
/* 2602 */       } else if (this.jTextField7.getText().equals("")) {
/* 2603 */         this.error.cargarError(this.jTextField7, "050");
/* 2604 */       } else if (this.jTextField8.getText().equals("")) {
/* 2605 */         this.error.cargarError(this.jTextField8, "050");
/* 2606 */       } else if (this.jTextField17.getText().equals("")) {
/* 2607 */         this.error.cargarError(this.jTextField17, "050");
/* 2608 */       } else if (this.jDateChooser1.getDate() == null) {
/* 2609 */         JOptionPane.showMessageDialog(this.padre, "No puede dejar vacía la fecha de la factura, verifica tu información", "Fecha Vacía", 0, this.ERROR);
/* 2610 */       } else if (this.jDateChooser2.getDate() == null) {
/* 2611 */         JOptionPane.showMessageDialog(this.padre, "No puede dejar vacía la fecha de recepción, verifica tu información", "Fecha Vacía", 0, this.ERROR);
/* 2612 */       } else if (suc.equals("")) {
/* 2613 */         this.jTextField20.setBackground(Color.RED);
/* 2614 */         JOptionPane.showMessageDialog(this.padre, "Te falta ingresar la sucursal operativa\nPor lo menos debe estar seleccionada una sucursal.", "Falta sucursal operativa", 0, this.ADVER);
/* 2615 */       } else if (this.cant1.getText().equals("$0.00")) {
/* 2616 */         this.error.cargarError(this.cant1, "050");
/* 2617 */       } else if (this.cant5.getText().equals("$0.00")) {
/* 2618 */         this.error.cargarError(this.cant5, "050");
/* 2619 */       } else if (!this.val.validarTexto(this.jTextField7, this.jTextField7.getText(), "004") && 
/* 2620 */         !this.val.validarCodigoPostal(this.jTextField8, this.jTextField8.getText(), "014") && 
/* 2621 */         !this.val.validarTexto(this.jTextField9, this.jTextField9.getText(), "014") && 
/* 2622 */         !this.val.validarTexto(this.jTextField10, this.jTextField10.getText(), "014")) {
/* 2623 */         Instant instant = this.jDateChooser1.getDate().toInstant();
/* 2624 */         ZoneId defaultZoneId = ZoneId.systemDefault();
/* 2625 */         LocalDate fechaFact = instant.atZone(defaultZoneId).toLocalDate();
/* 2626 */         fechaFact.format(formatoFecha);
/* 2627 */         String fechaFactsql = String.valueOf(fechaFact) + " " + String.valueOf(fechaFact) + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/* 2628 */         if (!fechaFact.isAfter(LocalDate.now())) {
/* 2629 */           if (this.cant1.getText().contains("-")) {
/* 2630 */             this.error.cargarError(this.cant1, "063");
/* 2631 */           } else if (this.cant2.getText().contains("-")) {
/* 2632 */             this.error.cargarError(this.cant2, "063");
/* 2633 */           } else if (this.cant3.getText().contains("-")) {
/* 2634 */             this.error.cargarError(this.cant3, "063");
/* 2635 */           } else if (this.cant4.getText().contains("-")) {
/* 2636 */             this.error.cargarError(this.cant4, "063");
/* 2637 */           } else if (this.cant5.getText().contains("-")) {
/* 2638 */             this.error.cargarError(this.cant5, "063");
/* 2639 */           } else if (this.cant6.getText().contains("-")) {
/* 2640 */             this.error.cargarError(this.cant6, "063");
/*      */           } else {
/* 2642 */             Instant instant2 = this.jDateChooser2.getDate().toInstant();
/* 2643 */             ZoneId defaultZoneId2 = ZoneId.systemDefault();
/* 2644 */             LocalDate localFechaRecep = instant2.atZone(defaultZoneId2).toLocalDate();
/* 2645 */             localFechaRecep.format(formatoFecha);
/* 2646 */             if (!localFechaRecep.isAfter(LocalDate.now())) {
/* 2647 */               String[] reg = this.con.regresaReg("serie, folio, fechaFactura, total, proveedor, estado", "prov_facturas", "where serie='" + this.jTextField3.getText() + "' and folio='" + this.jTextField4.getText() + "' and proveedor = '" + String.valueOf(this.jComboBox3.getSelectedItem()) + "'", 6);
/* 2648 */               if (reg[3] != null && this.materialButton22.getText().equals("Guardar")) {
/* 2649 */                 this.jTextField11.setText(reg[0]);
/* 2650 */                 this.jTextField12.setText(reg[1]);
/* 2651 */                 this.jTextField13.setText(reg[2]);
/* 2652 */                 this.jTextField14.setText(reg[3]);
/* 2653 */                 this.jTextField15.setText(reg[4]);
/* 2654 */                 this.jTextField16.setText(reg[5]);
/* 2655 */                 JOptionPane.showMessageDialog(this.padre, this.jPanel24, "Factura duplicada", 0, this.ADVER);
/*      */               } 
/* 2657 */               String folioCompleto = this.jTextField3.getText().toUpperCase() + this.jTextField3.getText().toUpperCase();
/* 2658 */               String fechaFactstr = "" + fechaFact.getDayOfMonth() + "/" + fechaFact.getDayOfMonth() + "/" + fechaFact.getMonthValue();
/* 2659 */               String hora = String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/* 2660 */               String fechaRecepstr = "" + localFechaRecep.getDayOfMonth() + "/" + localFechaRecep.getDayOfMonth() + "/" + localFechaRecep.getMonthValue();
/* 2661 */               LocalDate fechaPago = localFechaRecep.plusDays(dias[this.jComboBox4.getSelectedIndex()]);
/* 2662 */               fechaPago.format(formatoFecha);
/* 2663 */               double totalF = convertirCantTexto(this.cant5.getText());
/* 2664 */               String[] formaPago = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "30", "99" };
/*      */ 
/*      */               
/* 2667 */               this.PROVSELEC = this.jComboBox3.getSelectedIndex() - 1;
/* 2668 */               Proveedores p = this.PROVLISTA.get(this.PROVSELEC);
/* 2669 */               String[] campos = { "Proveedor", "RFC", "Cógido Postal", "Lugar de Expedición", "Dirección", "Condiciones de pago", "Forma de pago", "Método de pago", "Uso del CFDI", "Serie", "Folio", "Folio Fiscal", "Fecha de factura", "Hora", "Recibió", "Entregó", "Lugar", "Fecha de recepción", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Moneda", "Tipo de cambio", "Sucursal Op" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2676 */               String[] info = { this.jComboBox3.getSelectedItem().toString(), this.jTextField7.getText().toUpperCase(), this.jTextField8.getText().toUpperCase(), this.jTextField9.getText().toUpperCase(), this.jTextField10.getText().toUpperCase(), this.jComboBox4.getSelectedItem().toString(), this.jComboBox5.getSelectedItem().toString(), this.jComboBox6.getSelectedItem().toString(), this.jTextField6.getText(), this.jTextField3.getText().toUpperCase(), this.jTextField4.getText().toUpperCase().toUpperCase(), this.jTextField5.getText().toUpperCase(), fechaFactstr, hora, this.jTextField17.getText().toUpperCase(), this.jTextField18.getText().toUpperCase(), this.jTextField19.getText().toUpperCase(), fechaRecepstr, this.cant1.getText(), this.cant2.getText(), this.cant3.getText(), this.cant4.getText(), this.cant5.getText(), this.jTextField86.getText(), this.cant6.getText().toUpperCase(), suc };
/* 2677 */               if (this.materialButton22.getText().equals("Guardar")) {
/* 2678 */                 int res = this.error.cargarDatos(campos, info);
/* 2679 */                 if (res == 0) {
/* 2680 */                   this.con.inserSinMsj("insert into prov_facturas ( serie, folio, folioComp, fechaFactura, uuid,  usoCFDIClave, proveedor, rfc, codigoPostal, lugarExpedicionCD,  dirFactura, subtotal, descMonto, iva, retencion,  total, totalDebe, moneda, tipoCambio, condiciones,  formaPagoClave, metodoPagoDesc, fechaRecepcion, personaRecep, personaEntrega, lugarRecep,  pagada, motivoCancelacion, comentariosGral, estado, sucOp,  usuario, fechaPago, numProv, complementos  ) values ( '" + this.jTextField3
/* 2681 */                       .getText().toUpperCase() + "', '" + this.jTextField4.getText().toUpperCase() + "', '" + folioCompleto + "', '" + fechaFactsql + "', '" + this.jTextField5.getText().toUpperCase() + "',  '" + this.jTextField6
/* 2682 */                       .getText().toUpperCase() + "', '" + String.valueOf(this.jComboBox3.getSelectedItem()) + "', '" + this.jTextField7.getText().toUpperCase() + "','" + this.jTextField8.getText() + "','" + this.jTextField9.getText().toUpperCase() + "',  '" + this.jTextField10
/* 2683 */                       .getText().toUpperCase() + "', '" + this.cant1.getText() + "', '" + this.cant2.getText() + "','" + this.cant3.getText() + "','" + this.cant4.getText() + "',  '" + this.cant5
/* 2684 */                       .getText() + "', '" + this.cant5.getText() + "', '" + this.jTextField86.getText().toUpperCase() + "','" + this.cant6.getText() + "','" + String.valueOf(this.jComboBox4.getSelectedItem()) + "',  '" + formaPago[this.jComboBox5
/* 2685 */                         .getSelectedIndex()] + "', '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "','" + String.valueOf(localFechaRecep) + "','" + this.jTextField17.getText().toUpperCase() + "','" + this.jTextField18.getText().toUpperCase() + "','" + this.jTextField19.getText().toUpperCase() + "',0, '', '" + this.jEditorPane1
/* 2686 */                       .getText().toUpperCase() + "','<Por Pagar>','" + suc + "',  '" + actualizo + "','" + String.valueOf(fechaPago) + "', " + p
/* 2687 */                       .getNumProv() + ",0 )");
/* 2688 */                   this.con.consultar("max(numFactura)", "prov_facturas", "");
/* 2689 */                   int numFactura = Integer.parseInt(this.con.Campo);
/* 2690 */                   double total = 0.0D;
/* 2691 */                   this.encontrado = this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + p.getNumProv());
/* 2692 */                   if (this.con.Campo == null) {
/* 2693 */                     total = totalF;
/*      */                   } else {
/* 2695 */                     String saldoFinal = this.con.Campo;
/* 2696 */                     total = Double.parseDouble(saldoFinal) + totalF;
/*      */                   } 
/* 2698 */                   this.cantidad.setValue(Double.valueOf(total));
/* 2699 */                   String saldoFinalLetra = this.cantidad.getText();
/* 2700 */                   this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv=" + p.getNumProv());
/* 2701 */                   this.con.inserSinMsj("insert into prov_tarjetadeudor ( fecha, fechaPago, tipoConcep, concepto, referencia, importe, importeLetra, abono, abonoLetra, importeSaldado, importeRestante, importeRestanteLetra, estatus, comentario,  uuid, factura, num_abono, saldoFinal, saldoFinalLetra, numProv, numFactura, usuario  ) values ( now(), '" + String.valueOf(fechaPago) + "', 1, 'CARGO POR FACTURA',  'FACTURA: " + folioCompleto + "'," + totalF + ",'" + this.cant5
/* 2702 */                       .getText() + "',0,'',  0," + totalF + ",'" + this.cant5
/* 2703 */                       .getText() + "','<Por Pagar>', '" + this.jEditorPane1.getText().toUpperCase() + "',  '" + this.jTextField5
/* 2704 */                       .getText().toUpperCase() + "', '" + folioCompleto + "', '', " + total + ", '" + saldoFinalLetra + "', " + p.getNumProv() + "," + numFactura + " ,'" + actualizo + "')");
/* 2705 */                   this.fichas.removeTabAt(1);
/* 2706 */                   consultar();
/*      */                 } 
/* 2708 */               } else if (this.materialButton22.getText().equals("Modificar")) {
/* 2709 */                 int res = this.error.cargarDatos2(campos, info);
/* 2710 */                 if (res == 0) {
/* 2711 */                   if (this.cant1.isEnabled()) {
/* 2712 */                     this.con.inserSinMsj("update prov_facturas set  serie = '" + this.jTextField3
/* 2713 */                         .getText().toUpperCase() + "', folio='" + this.jTextField4.getText().toUpperCase() + "', folioComp='" + folioCompleto + "', fechaFactura ='" + fechaFactsql + "',  uuid = '" + this.jTextField5
/* 2714 */                         .getText().toUpperCase() + "', usoCFDIClave = '" + this.jTextField6.getText().toUpperCase() + "', proveedor='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "', rfc = '" + this.jTextField7.getText().toUpperCase() + "',  codigoPostal = '" + this.jTextField8
/* 2715 */                         .getText().toUpperCase() + "', lugarExpedicionCD = '" + this.jTextField9.getText().toUpperCase() + "', dirFactura = '" + this.jTextField10.getText().toUpperCase() + "', subtotal='" + this.cant1.getText() + "',  descMonto = '" + this.cant2
/* 2716 */                         .getText() + "', iva = '" + this.cant3.getText() + "', retencion='" + this.cant4.getText() + "', total='" + this.cant5.getText() + "', totalDebe='" + this.cant5.getText() + "', moneda='" + this.jTextField86.getText() + "',  tipoCambio = '" + this.cant6
/* 2717 */                         .getText() + "', condiciones='" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', formaPagoClave='" + formaPago[this.jComboBox5.getSelectedIndex()] + "',  metodoPagoDesc = '" + 
/* 2718 */                         String.valueOf(this.jComboBox6.getSelectedItem()) + "', fechaRecepcion='" + String.valueOf(localFechaRecep) + "', personaRecep='" + this.jTextField17.getText().toUpperCase() + "', personaEntrega='" + this.jTextField18.getText().toUpperCase() + "',  lugarRecep='" + this.jTextField19
/* 2719 */                         .getText().toUpperCase() + "', fechaPago='" + String.valueOf(fechaPago) + "', comentariosGral='" + this.jEditorPane1.getText().toUpperCase() + "', sucOp='" + suc + "', usuario='" + actualizo + "', numProv = " + p.getNumProv() + " where numFactura= " + this.NUMFACT);
/*      */                   } else {
/* 2721 */                     this.con.inserSinMsj("update prov_facturas set  serie = '" + this.jTextField3
/* 2722 */                         .getText().toUpperCase() + "', folio='" + this.jTextField4.getText().toUpperCase() + "', folioComp='" + folioCompleto + "', fechaFactura ='" + fechaFactsql + "',  uuid = '" + this.jTextField5
/* 2723 */                         .getText().toUpperCase() + "', usoCFDIClave = '" + this.jTextField6.getText().toUpperCase() + "', proveedor='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "', rfc = '" + this.jTextField7.getText().toUpperCase() + "',  codigoPostal = '" + this.jTextField8
/* 2724 */                         .getText().toUpperCase() + "', lugarExpedicionCD = '" + this.jTextField9.getText().toUpperCase() + "', dirFactura = '" + this.jTextField10.getText().toUpperCase() + "', moneda='" + this.jTextField86.getText() + "',  tipoCambio = '" + this.cant6
/* 2725 */                         .getText() + "', condiciones='" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', formaPagoClave='" + formaPago[this.jComboBox5.getSelectedIndex()] + "',  metodoPagoDesc = '" + 
/* 2726 */                         String.valueOf(this.jComboBox6.getSelectedItem()) + "', fechaRecepcion='" + String.valueOf(localFechaRecep) + "', personaRecep='" + this.jTextField17.getText().toUpperCase() + "', personaEntrega='" + this.jTextField18.getText().toUpperCase() + "',  lugarRecep='" + this.jTextField19
/* 2727 */                         .getText().toUpperCase() + "', fechaPago='" + String.valueOf(fechaPago) + "', comentariosGral='" + this.jEditorPane1.getText().toUpperCase() + "', sucOp='" + suc + "', usuario='" + actualizo + "', numProv = " + p.getNumProv() + " where numFactura= " + this.NUMFACT);
/*      */                   } 
/*      */                   
/* 2730 */                   double total = 0.0D;
/* 2731 */                   double originalF = convertirCantTexto(this.TOTALFACTURA);
/* 2732 */                   double suma = 0.0D;
/* 2733 */                   double resta = 0.0D;
/* 2734 */                   if (this.NOMBRECOMERCIAL.equals(p.getNombreComercial())) {
/* 2735 */                     String consultaTotales = "";
/* 2736 */                     if (!this.TOTALFACTURA.equals(this.cant5.getText())) {
/* 2737 */                       this.encontrado = this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + p.getNumProv());
/* 2738 */                       String saldoFinal = this.con.Campo;
/* 2739 */                       if (totalF > originalF) {
/* 2740 */                         suma = totalF - originalF;
/* 2741 */                         total = Double.parseDouble(saldoFinal) + suma;
/*      */                       } else {
/* 2743 */                         resta = originalF - totalF;
/* 2744 */                         total = Double.parseDouble(saldoFinal) - resta;
/*      */                       } 
/* 2746 */                       this.cantidad.setValue(Double.valueOf(total));
/* 2747 */                       String saldoFinalLetra = this.cantidad.getText();
/* 2748 */                       this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv=" + p.getNumProv());
/* 2749 */                       consultaTotales = ", saldoFinal = " + total + ", saldoFinalLetra='" + this.cantidad.getText() + "'";
/*      */                     } 
/* 2751 */                     if (this.cant1.isEnabled()) {
/* 2752 */                       this.con.inserSinMsj("update prov_tarjetadeudor set fechaPago='" + String.valueOf(fechaPago) + "', referencia = 'FACTURA: " + folioCompleto + "', importe = " + totalF + ",  importeLetra='" + this.cant5
/* 2753 */                           .getText() + "', importeSaldado = 0, importeRestante= " + totalF + ", importeRestanteLetra = '" + this.cant5.getText() + "', uuid='" + this.jTextField5
/* 2754 */                           .getText().toUpperCase() + "', factura='" + folioCompleto + "' " + consultaTotales + " , usuario='" + actualizo + "'  where (numFactura = " + this.NUMFACT + " )");
/*      */                     } else {
/* 2756 */                       this.con.inserSinMsj("update prov_tarjetadeudor set fechaPago='" + String.valueOf(fechaPago) + "', referencia = 'FACTURA: " + folioCompleto + "', uuid='" + this.jTextField5
/* 2757 */                           .getText().toUpperCase() + "', factura='" + folioCompleto + "' " + consultaTotales + " , usuario='" + actualizo + "'  where (numFactura = " + this.NUMFACT + " )");
/*      */                     } 
/*      */                   } else {
/*      */                     
/* 2761 */                     this.encontrado = this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + this.NUMPROV);
/*      */                     
/* 2763 */                     if (!this.encontrado) {
/* 2764 */                       total = 0.0D;
/*      */                     } else {
/* 2766 */                       String saldoFinal = this.con.Campo;
/* 2767 */                       total = convertirCantTexto(saldoFinal) - originalF;
/* 2768 */                       System.out.println("tot " + total + " " + saldoFinal + " " + originalF);
/*      */                     } 
/* 2770 */                     this.cantidad.setValue(Double.valueOf(total));
/* 2771 */                     String saldoFinalLetra = this.cantidad.getText();
/* 2772 */                     this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv=" + this.NUMPROV);
/* 2773 */                     total = 0.0D;
/* 2774 */                     this.encontrado = this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + p.getNumProv());
/*      */                     
/* 2776 */                     if (!this.encontrado) {
/* 2777 */                       total = totalF;
/*      */                     } else {
/* 2779 */                       String saldoFinal = this.con.Campo;
/* 2780 */                       total = Double.parseDouble(saldoFinal) + totalF;
/*      */                     } 
/* 2782 */                     this.cantidad.setValue(Double.valueOf(total));
/* 2783 */                     saldoFinalLetra = this.cantidad.getText();
/*      */                     
/* 2785 */                     if (this.cant1.isEnabled()) {
/* 2786 */                       this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv=" + p.getNumProv());
/* 2787 */                       this.con.inserSinMsj("update prov_tarjetadeudor set  fecha =now(), fechaPago='" + String.valueOf(fechaPago) + "', referencia = 'FACTURA: " + folioCompleto + "', importe = " + totalF + ",  importeLetra='" + this.cant5
/* 2788 */                           .getText() + "', importeSaldado = 0, importeRestante= " + totalF + ", importeRestanteLetra = '" + this.cant5.getText() + "', uuid='" + this.jTextField5
/* 2789 */                           .getText().toUpperCase() + "', factura='" + folioCompleto + "', saldoFinal=" + total + ", saldoFinalLetra='" + saldoFinalLetra + "', usuario='" + actualizo + "', numProv = " + p.getNumProv() + " where (numFactura = " + this.NUMFACT + " )");
/*      */                     } else {
/* 2791 */                       this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv=" + p.getNumProv());
/* 2792 */                       this.con.inserSinMsj("update prov_tarjetadeudor set  fechaPago='" + String.valueOf(fechaPago) + "', referencia = 'FACTURA: " + folioCompleto + "', uuid='" + this.jTextField5
/* 2793 */                           .getText().toUpperCase() + "', factura='" + folioCompleto + "', saldoFinal=" + total + ", usuario='" + actualizo + "', numProv = " + p.getNumProv() + " where (numFactura = " + this.NUMFACT + " )");
/*      */                     } 
/*      */                   } 
/* 2796 */                   this.fichas.removeTabAt(1);
/* 2797 */                   consultar();
/*      */                 } 
/*      */               } 
/*      */             } else {
/* 2801 */               JOptionPane.showMessageDialog(this.padre, "<html>La <b>FECHA DE RECEPCIÓN</b> no puede ser mayor a la fecha actual, verifica tu información</html>", "Fecha de recepción incorrecta", 0, this.ERROR);
/*      */             } 
/*      */           } 
/*      */         } else {
/* 2805 */           JOptionPane.showMessageDialog(this.padre, "<html>La <b>FECHA DE LA FACTURA</b> no puede ser mayor a la fecha actual, verifica tu información</html>", "Fecha de factura incorrecta", 0, this.ERROR);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 2809 */       System.out.println("Entra fc");
/*      */       try {
/* 2811 */         int index = this.jComboBox3.getSelectedIndex();
/* 2812 */         index--;
/* 2813 */         String forsis = "forsis100x.png";
/* 2814 */         Map<Object, Object> datos = new HashMap<>();
/* 2815 */         datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 2816 */         datos.put("parameter1", (String)this.CAMPOSGENERALES.get("sucursal") + "\nTels: " + (String)this.CAMPOSGENERALES.get("sucursal"));
/* 2817 */         datos.put("parameter2", ((Proveedores)this.PROVLISTA.get(index)).getRazonSocial());
/* 2818 */         datos.put("parameter3", this.jTextField7.getText());
/* 2819 */         datos.put("parameter4", this.jTextField3.getText() + " " + this.jTextField3.getText());
/* 2820 */         datos.put("parameter5", getFechaddMMaaaa(this.jDateChooser1.getDate()));
/* 2821 */         datos.put("parameter6", this.jTextField5.getText());
/* 2822 */         datos.put("parameter7", this.jTextField10.getText());
/* 2823 */         datos.put("parameter8", this.jTextField8.getText());
/* 2824 */         datos.put("parameter9", this.jTextField9.getText());
/* 2825 */         datos.put("parameter10", this.jComboBox5.getSelectedItem());
/* 2826 */         datos.put("parameter11", this.jComboBox4.getSelectedItem());
/* 2827 */         datos.put("parameter12", this.jComboBox6.getSelectedItem());
/* 2828 */         datos.put("parameter13", this.jTextField6.getText());
/* 2829 */         datos.put("parameter14", this.jTextField17.getText());
/* 2830 */         datos.put("parameter15", this.jTextField18.getText());
/* 2831 */         datos.put("parameter16", this.jTextField19.getText());
/* 2832 */         datos.put("parameter17", getFechaddMMaaaa(this.jDateChooser2.getDate()));
/* 2833 */         datos.put("parameter18", this.cant1.getText());
/* 2834 */         datos.put("parameter19", this.cant2.getText());
/* 2835 */         datos.put("parameter20", this.cant3.getText());
/* 2836 */         datos.put("parameter21", this.cant4.getText());
/* 2837 */         datos.put("parameter22", this.cant5.getText());
/* 2838 */         datos.put("parameter23", this.jTextField86.getText());
/* 2839 */         JasperPrint reporte = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_FacturaIndividual.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 2840 */         JasperViewer visor = new JasperViewer(reporte, false);
/* 2841 */         visor.setTitle("Reporte de Factura");
/* 2842 */         visor.setIconImage(this.iconoImprimir);
/* 2843 */         visor.setZoomRatio(0.59F);
/* 2844 */         visor.setExtendedState(6);
/* 2845 */         visor.setVisible(true);
/* 2846 */       } catch (JRException e) {
/* 2847 */         System.out.println(e.getMessage());
/* 2848 */         Logger.getLogger(ProvFacturas.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2854 */     Dimension di = this.jButton34.getSize();
/* 2855 */     Point p = this.jButton34.getLocationOnScreen();
/* 2856 */     this.jDialog2.setLocation(p.x + di.width - 200, p.y + 30);
/* 2857 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton56ActionPerformed(ActionEvent evt) {
/* 2861 */     if (this.entraCatMon != true) {
/* 2862 */       this.entraCatMon = true;
/* 2863 */       llenarCatMonedas();
/*      */     } 
/* 2865 */     Dimension di = this.jButton56.getSize();
/* 2866 */     Point p = this.jButton56.getLocationOnScreen();
/* 2867 */     this.jDialog3.setLocation(p.x + di.width - 200, p.y + 30);
/* 2868 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField20ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton57ActionPerformed(ActionEvent evt) {
/* 2884 */     Dimension di = this.jButton57.getSize();
/* 2885 */     Point p = this.jButton57.getLocationOnScreen();
/* 2886 */     this.jDialog1.setLocation(p.x + di.width - 200, p.y + 30);
/* 2887 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2897 */     if (this.jTextField7.isEnabled()) {
/* 2898 */       if (this.jComboBox3.getSelectedIndex() > 0 && !this.leyendoXML) {
/* 2899 */         this.PROVSELEC = this.jComboBox3.getSelectedIndex() - 1;
/* 2900 */         Proveedores p = this.PROVLISTA.get(this.PROVSELEC);
/* 2901 */         this.jTextField7.setText(p.getRfc());
/* 2902 */         this.jTextField8.setText(p.getCondigoPostal());
/* 2903 */         this.jTextField86.setText(p.getMoneda());
/* 2904 */         this.jTextField6.setText(p.getUsoCFDIclave());
/* 2905 */         this.jTextField18.setText(p.getContacto());
/*      */       } 
/* 2907 */       if (this.jComboBox3.getSelectedIndex() == 0) {
/* 2908 */         this.jTextField7.setText("");
/* 2909 */         this.jTextField8.setText("");
/* 2910 */         this.jTextField18.setText("");
/* 2911 */         this.jTextField86.setText("");
/* 2912 */         this.jTextField6.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2921 */     if (evt.getClickCount() == 2) {
/* 2922 */       verFacturaFicha();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 2927 */     JFileChooser selectorArchivos = new JFileChooser();
/* 2928 */     FileNameExtensionFilter filtro = new FileNameExtensionFilter("xml", new String[] { "XML" });
/* 2929 */     selectorArchivos.setFileFilter(filtro);
/* 2930 */     selectorArchivos.setFileSelectionMode(2);
/* 2931 */     int resultado = selectorArchivos.showOpenDialog(this);
/* 2932 */     this.archivoOriginal = selectorArchivos.getSelectedFile();
/* 2933 */     if (this.archivoOriginal == null || this.archivoOriginal.getName().equals("")) {
/* 2934 */       JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", 0);
/*      */     } else {
/* 2936 */       this.leyendoXML = true;
/* 2937 */       limpiarNuevo();
/* 2938 */       leerXML(this.archivoOriginal.getAbsolutePath());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField9FocusGained(FocusEvent evt) {
/* 2944 */     if (!this.entraCatMunicipios) {
/* 2945 */       this.entraCatMunicipios = true;
/* 2946 */       catMunicipios mun = new catMunicipios();
/*      */       try {
/* 2948 */         this.TODOS_MUNICIPIOS = new ArrayList(mun.catMunicipios());
/* 2949 */         this.com_Municipios = new TextAutoCompleter(this.jTextField9, this.TODOS_MUNICIPIOS);
/* 2950 */       } catch (IOException ex) {
/* 2951 */         Logger.getLogger(Proveedores.class
/* 2952 */             .getName()).log(Level.SEVERE, (String)null, ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro7MouseClicked(MouseEvent evt) {
/* 2958 */     if (evt.getClickCount() == 2) {
/* 2959 */       this.jTextField6.setText(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0).toString());
/* 2960 */       this.jDialog2.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro7KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 2968 */     if (evt.getClickCount() == 2) {
/* 2969 */       this.jTextField86.setText(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0).toString());
/* 2970 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2975 */     if (this.jTextField1.getText().equals(this.holderFolio)) {
/* 2976 */       consultar();
/*      */     } else {
/* 2978 */       String campoFecha = "fechaRecepcion";
/* 2979 */       if (this.jComboBox8.getSelectedIndex() != 0) {
/* 2980 */         campoFecha = "fechaFactura";
/*      */       }
/* 2982 */       this.encontrado = this.con.consultar(campoFecha, "prov_facturas", "where folioComp like '%" + this.jTextField1.getText() + "%' order by " + campoFecha + " desc");
/* 2983 */       String f = this.con.Campo;
/* 2984 */       if (this.encontrado) {
/* 2985 */         String año = f.substring(0, 4);
/* 2986 */         String mes = f.substring(5, 7);
/* 2987 */         String dia = f.substring(8, 10);
/* 2988 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2989 */         String strFecha = año + "-" + año + "-" + mes;
/* 2990 */         Date fecha = null;
/*      */         try {
/* 2992 */           fecha = formatoDelTexto.parse(strFecha);
/* 2993 */         } catch (ParseException ex) {
/* 2994 */           ex.printStackTrace();
/*      */         } 
/* 2996 */         this.jDateChooser4.setDate(fecha);
/* 2997 */         this.jDateChooser5.setDate(fecha);
/*      */       } 
/* 2999 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel170MouseClicked(MouseEvent evt) {
/* 3004 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 3005 */     int aa = fecha.get(1);
/* 3006 */     int mm = fecha.get(2);
/* 3007 */     int dd = fecha.get(5);
/* 3008 */     if (dd == 1) {
/* 3009 */       if (mm == 0) {
/* 3010 */         mm = 11;
/* 3011 */         aa--;
/*      */       } else {
/* 3013 */         mm--;
/*      */       } 
/* 3015 */       int diasTotal = diasDelMes(mm, aa);
/* 3016 */       dd = diasTotal;
/*      */     } else {
/* 3018 */       dd--;
/*      */     } 
/* 3020 */     mm++;
/* 3021 */     String año = "" + aa;
/* 3022 */     String mes = "" + mm;
/* 3023 */     String dia = "" + dd;
/* 3024 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3025 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 3027 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 3028 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 3029 */     } catch (ParseException ex) {
/* 3030 */       ex.printStackTrace();
/*      */     } 
/* 3032 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel170MouseEntered(MouseEvent evt) {
/* 3036 */     this.jLabel170.setForeground(new Color(153, 255, 153));
/* 3037 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel170MouseExited(MouseEvent evt) {
/* 3041 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 3042 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseClicked(MouseEvent evt) {
/* 3046 */     this.jDateChooser4.setDate(this.fechaActual);
/* 3047 */     this.jDateChooser5.setDate(this.fechaActual);
/* 3048 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel101MouseEntered(MouseEvent evt) {
/* 3052 */     this.jLabel101.setForeground(new Color(153, 255, 153));
/* 3053 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseExited(MouseEvent evt) {
/* 3057 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 3058 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseClicked(MouseEvent evt) {
/* 3062 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 3063 */     calendar.setTime(this.jDateChooser4.getDate());
/* 3064 */     calendar.add(6, 1);
/* 3065 */     this.jDateChooser4.setCalendar(calendar);
/* 3066 */     this.jDateChooser5.setCalendar(calendar);
/* 3067 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel171MouseEntered(MouseEvent evt) {
/* 3071 */     this.jLabel171.setForeground(new Color(153, 255, 153));
/* 3072 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseExited(MouseEvent evt) {
/* 3076 */     this.jLabel171.setForeground(new Color(15, 87, 51));
/* 3077 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 3081 */     if (this.PRIMERA) {
/* 3082 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 3087 */     consultar();
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 3091 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 3095 */     cancelar();
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 3099 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 3103 */     String[] datos = { "RECEPCIÓN", "FECHA DE PAGO", "PROVEEDOR", "FACTURA", "FECHA DE FACTURA", "CONDICIONES", "TOTAL", "DEBE", "SUCURSAL" };
/* 3104 */     this.esc = new EscribirReporte("FACTURAS - PENDIENTES DE PAGO", (JTable)this.rSTableMetro4, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel27MouseDragged(MouseEvent evt) {
/* 3108 */     int x = evt.getXOnScreen();
/* 3109 */     int y = evt.getYOnScreen();
/* 3110 */     this.jDialog5.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel27MouseClicked(MouseEvent evt) {
/* 3114 */     this.xx = evt.getX();
/* 3115 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel126MouseClicked(MouseEvent evt) {
/* 3119 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel126MouseExited(MouseEvent evt) {
/* 3123 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel126MouseEntered(MouseEvent evt) {
/* 3127 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 3138 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3139 */       String cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/* 3140 */       String año = cadenaFecha1.substring(0, 4);
/* 3141 */       String mes = cadenaFecha1.substring(4, 6);
/* 3142 */       String dia = cadenaFecha1.substring(6, 8);
/* 3143 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/* 3144 */       String sicret = "LOGO.jpg";
/* 3145 */       String forsis = "forsis100x.jpg";
/* 3146 */       JTable aux = crearTablaAuxPendientes((JTable)this.rSTableMetro4, new Object[] { "cont", "FRecepcion", "FPago", "Proveedor", "Factura", "FFactura", "Condiciones", "Total", "Debe" });
/* 3147 */       Map<Object, Object> datos = new HashMap<>();
/* 3148 */       datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 3149 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 3150 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 3151 */       datos.put("corte", fechaCompleta);
/* 3152 */       datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 3153 */       datos.put("TDebe", this.jLabel50.getText());
/* 3154 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 3155 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_FacturasPendientes.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 3156 */       JasperViewer visor = new JasperViewer(print, false);
/* 3157 */       visor.setTitle("Facturas por pagar");
/* 3158 */       visor.setIconImage(this.iconoImprimir);
/* 3159 */       visor.setZoomRatio(0.59F);
/* 3160 */       visor.setExtendedState(6);
/* 3161 */       visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/* 3162 */       visor.setVisible(true);
/* 3163 */     } catch (JRException e) {
/* 3164 */       System.out.println(e.getMessage());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 3169 */     if (this.comboCargado) {
/* 3170 */       verPendientes();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 3175 */     verPendientes();
/*      */   }
/*      */   
/*      */   public JTable crearTablaAuxPendientes(JTable Original, Object[] columnas) {
/* 3179 */     Object[] Columnas = columnas;
/* 3180 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount() + 1];
/* 3181 */     System.out.println("reg " + Original.getRowCount() + " " + Original.getColumnCount() + " " + columnas.length);
/* 3182 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 3183 */       registros[i][0] = Integer.valueOf(i + 1);
/* 3184 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 3185 */         if (j == 0) {
/* 3186 */           registros[i][1] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3188 */         if (j == 1) {
/* 3189 */           registros[i][2] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3191 */         if (j == 2) {
/* 3192 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 3194 */         if (j == 3) {
/* 3195 */           registros[i][4] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3197 */         if (j == 4) {
/* 3198 */           registros[i][5] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3200 */         if (j == 5) {
/* 3201 */           registros[i][6] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3203 */         if (j == 6) {
/* 3204 */           registros[i][7] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3206 */         if (j == 7) {
/* 3207 */           registros[i][8] = Original.getValueAt(i, j).toString();
/*      */         }
/*      */       } 
/*      */     } 
/* 3211 */     JTable aux = new JTable(registros, Columnas);
/* 3212 */     return aux;
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux(JTable Original, Object[] columnas) {
/* 3216 */     Object[] Columnas = columnas;
/* 3217 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount()];
/* 3218 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 3219 */       registros[i][0] = Integer.valueOf(i + 1);
/* 3220 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 3221 */         if (j == 1) {
/* 3222 */           registros[i][1] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3224 */         if (j == 2) {
/* 3225 */           registros[i][2] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3227 */         if (j == 3) {
/* 3228 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 3230 */         if (j == 4) {
/* 3231 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 3233 */         if (j == 5) {
/* 3234 */           registros[i][5] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3236 */         if (j == 6) {
/* 3237 */           registros[i][6] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */         }
/* 3239 */         if (j == 7) {
/* 3240 */           registros[i][7] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3242 */         if (j == 8) {
/* 3243 */           registros[i][8] = Original.getValueAt(i, j).toString();
/*      */         }
/* 3245 */         if (j == 11) {
/* 3246 */           registros[i][9] = Original.getValueAt(i, j).toString();
/*      */         }
/*      */       } 
/*      */     } 
/* 3250 */     JTable aux = new JTable(registros, Columnas);
/* 3251 */     return aux;
/*      */   }
/*      */   
/*      */   public String getPrivilegiosSuc() {
/* 3255 */     String priv = "";
/* 3256 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO")) {
/* 3257 */       priv = "";
/*      */     } else {
/* 3259 */       priv = this.CAMPOSGENERALES.get("sucursal");
/*      */     } 
/* 3261 */     return priv;
/*      */   }
/*      */   
/*      */   public String getConsultaSuc() {
/* 3265 */     String consulta = " and sucOp like '%" + getPrivilegiosSuc() + "%' ";
/* 3266 */     return consulta;
/*      */   }
/*      */   
/*      */   public void verPendientes() {
/* 3270 */     ProvFacturasPendientes provF = null;
/* 3271 */     if (provF == null) {
/* 3272 */       provF = new ProvFacturasPendientes(this.USUARIO, this.padre, this.CAMPOSGENERALES, this.lista);
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
/*      */   public void privilegios() {
/* 3333 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 3334 */       this.jComboBox1.setEnabled(true);
/* 3335 */       this.jComboBox7.setEnabled(true);
/* 3336 */       this.jComboBox7.setSelectedIndex(0);
/* 3337 */       this.jComboBox9.setEnabled(true);
/*      */     } else {
/* 3339 */       this.jComboBox1.setEnabled(false);
/* 3340 */       this.jComboBox7.setEnabled(false);
/* 3341 */       this.jComboBox9.setEnabled(false);
/*      */     } 
/* 3343 */     this.jComboBox1.setSelectedItem(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*      */   }
/*      */   
/*      */   public String getFechaddMMaaaa(Date fechita) {
/* 3347 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3348 */     String cadenaFecha1 = formato.format(fechita);
/* 3349 */     String año = cadenaFecha1.substring(0, 4);
/* 3350 */     String mes = cadenaFecha1.substring(4, 6);
/* 3351 */     String dia = cadenaFecha1.substring(6, 8);
/* 3352 */     return dia + "/" + dia + "/" + mes;
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 3356 */     String fechaCorta = fecha.substring(0, 10);
/* 3357 */     String año = fechaCorta.substring(0, 4);
/* 3358 */     String mes = fechaCorta.substring(5, 7);
/* 3359 */     String dia = fechaCorta.substring(8, 10);
/* 3360 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 3361 */     return strFecha;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 3365 */     String motivo = this.jTextArea5.getText();
/* 3366 */     if (motivo.equals("")) {
/* 3367 */       this.jTextArea5.setBackground(Color.RED);
/* 3368 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar el motivo de cancelación de la factura", "Ingresa un comentario", 0, this.ERROR);
/*      */     } else {
/* 3370 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas cancelar el comprobante que seleccionaste?", "Cancelar CFDI", 0, 3, this.PREG);
/* 3371 */       if (res == 0) {
/* 3372 */         String actualizo = this.USUARIO + this.USUARIO;
/* 3373 */         String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 3374 */         String factura = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5));
/* 3375 */         this.con.inserSinMsj("update prov_facturas set estado='<Cancelada>', motivoCancelacion ='" + this.jTextArea5.getText().toUpperCase() + "',usuario='" + actualizo + "' where numFactura='" + num + "'");
/* 3376 */         String[] datos = this.con.regresaReg("importe,importeLetra", "prov_tarjetadeudor", "where numFactura = " + num, 2);
/* 3377 */         double total = 0.0D;
/* 3378 */         this.con.inserSinMsj("update prov_tarjetadeudor set importeSaldado =" + datos[0] + ",importeRestante=0,ImporteRestanteLetra='$0.00',comentario='" + this.jTextArea5.getText().toUpperCase() + "', estatus='<Cancelado: " + actualizo + ">' where numFactura='" + num + "'");
/* 3379 */         this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + this.TARJETA);
/* 3380 */         total = Double.parseDouble(this.con.Campo);
/* 3381 */         total = redondear(total).doubleValue();
/* 3382 */         this.cantidad.setValue(Double.valueOf(total));
/* 3383 */         this.con.inserSinMsj("insert into prov_tarjetadeudor ( fecha, fechaPago, tipoConcep, concepto, referencia, importe, importeLetra, abono, abonoLetra, importeSaldado, importeRestante, importeRestanteLetra, estatus, comentario,  uuid, factura, num_abono, saldoFinal, saldoFinalLetra, numProv, numFactura, usuario  ) values ( now(), now(), 2, 'ABONO POR CANCELACIÓN',  'FACTURA: " + factura + "',0,''," + datos[0] + ",'" + datos[1] + "',  0,0,'','<Aplicado>', 'ESTE MOVIMIENTO SE ABONÓ AUTOMÁTICO DEBIDO A UNA CANCELACIÓN POR UNA FACTURA',  '', '', '', " + total + ", '" + this.cantidad
/* 3384 */             .getText() + "', " + this.TARJETA + "," + num + ", '" + actualizo + "')");
/* 3385 */         this.con.inserSinMsj("update prov_proveedores set saldo='" + this.cantidad.getText() + "', usuarioTarjeta='" + actualizo + "' where numProv=" + this.TARJETA);
/* 3386 */         if (this.jComboBox2.getSelectedIndex() == 0) {
/* 3387 */           DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro1.getModel();
/* 3388 */           temp.removeRow(this.rSTableMetro1.getSelectedRow());
/* 3389 */           this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 3390 */           this.jLabel37.setText("$0.00");
/* 3391 */           this.jLabel216.setText("$0.00");
/* 3392 */           calcularTotalesFacturados();
/*      */         } else {
/* 3394 */           consultar();
/*      */         } 
/* 3396 */         this.jDialog4.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Double redondear(double pasar) {
/* 3402 */     return Double.valueOf(Math.rint(pasar * 100.0D) / 100.0D);
/*      */   }
/*      */   
/*      */   public void verFacturaFicha() {
/* 3406 */     if (!this.primeraNuevo) {
/* 3407 */       llenarComboProv();
/*      */     }
/* 3409 */     this.ACTIVARSUC = "";
/* 3410 */     verFactura();
/* 3411 */     this.jButton34.setEnabled(false);
/* 3412 */     this.jButton57.setEnabled(false);
/* 3413 */     String[] sucursales = this.ACTIVARSUC.split(", ");
/* 3414 */     for (String v : sucursales) {
/* 3415 */       selecTablaSucursal(v);
/*      */     }
/* 3417 */     this.NUMFACT = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 3418 */     this.materialButton22.setText("Imprimir");
/* 3419 */     this.materialButton22.setToolTipText("Imprimir (Alt + P)");
/* 3420 */     this.materialButton22.setMnemonic('P');
/* 3421 */     this.jLabel1.setVisible(false);
/* 3422 */     this.materialButton23.setVisible(false);
/* 3423 */     this.fichas.addTab("Factura:" + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5).toString(), this.jPanel20);
/* 3424 */     this.fichas.setSelectedIndex(1);
/*      */   }
/*      */   
/*      */   public void verFactura() {
/* 3428 */     limpiarNuevo();
/* 3429 */     desactivar();
/* 3430 */     String[] datos = this.con.regresaReg("serie, folio, fechaFactura, uuid, usoCFDIClave, proveedor, rfc,  codigoPostal, lugarExpedicionCD, dirFactura, subtotal, descMonto, iva, retencion,  total, moneda, tipoCambio, condiciones, formaPagoClave, metodoPagoDesc, fechaRecepcion,  personaRecep, personaEntrega, lugarRecep, comentariosGral, sucOp, numProv ", "prov_facturas", "where numFactura= " + 
/* 3431 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 27);
/* 3432 */     this.jTextField3.setText(datos[0]);
/* 3433 */     this.jTextField4.setText(datos[1]);
/* 3434 */     DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 3435 */     LocalDate fechaLocal = LocalDate.parse(datos[2].substring(0, 10), formateador);
/*      */     
/* 3437 */     this.jDateChooser1.setDate(Date.valueOf(fechaLocal));
/*      */     
/* 3439 */     String FECHA = datos[2];
/* 3440 */     String hh = FECHA.substring(11, 13);
/* 3441 */     String mm = FECHA.substring(14, 16);
/* 3442 */     String ss = FECHA.substring(17, 19);
/* 3443 */     this.jSpinner1.setValue(hh);
/* 3444 */     this.jSpinner2.setValue(mm);
/* 3445 */     this.jSpinner3.setValue(ss);
/* 3446 */     this.jTextField5.setText(datos[3]);
/* 3447 */     this.UUID = datos[3];
/* 3448 */     this.jTextField6.setText(datos[4]);
/* 3449 */     this.jComboBox3.setSelectedItem(datos[5]);
/* 3450 */     this.jTextField7.setText(datos[6]);
/* 3451 */     this.jTextField8.setText(datos[7]);
/* 3452 */     this.jTextField9.setText(datos[8]);
/* 3453 */     this.jTextField10.setText(datos[9]);
/* 3454 */     this.cant1.setValue(Double.valueOf(convertirCantTexto(datos[10])));
/* 3455 */     this.cant2.setValue(Double.valueOf(convertirCantTexto(datos[11])));
/* 3456 */     this.cant3.setValue(Double.valueOf(convertirCantTexto(datos[12])));
/* 3457 */     this.cant4.setValue(Double.valueOf(convertirCantTexto(datos[13])));
/* 3458 */     this.cant5.setValue(Double.valueOf(convertirCantTexto(datos[14])));
/* 3459 */     this.jTextField86.setText(datos[15]);
/* 3460 */     this.cant6.setValue(Double.valueOf(Double.parseDouble(datos[16])));
/* 3461 */     this.jComboBox4.setSelectedItem(datos[17]);
/* 3462 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "NA", "99" };
/*      */ 
/*      */     
/* 3465 */     String metodoPago = datos[18];
/* 3466 */     int index = 0;
/* 3467 */     for (int i = 0; i < metodos.length; i++) {
/* 3468 */       if (metodos[i].equals(datos[18])) {
/* 3469 */         index = i;
/*      */         break;
/*      */       } 
/*      */     } 
/* 3473 */     this.jComboBox5.setSelectedIndex(index);
/* 3474 */     this.jComboBox6.setSelectedItem(datos[19]);
/* 3475 */     fechaLocal = LocalDate.parse(datos[20].substring(0, 10), formateador);
/* 3476 */     this.jDateChooser2.setDate(Date.valueOf(fechaLocal));
/* 3477 */     this.jTextField17.setText(datos[21]);
/* 3478 */     this.jTextField18.setText(datos[22]);
/* 3479 */     this.jTextField19.setText(datos[23]);
/* 3480 */     this.jEditorPane1.setText(datos[24]);
/* 3481 */     this.jTextField20.setText(datos[25].substring(0, 8) + "...");
/* 3482 */     this.jTextField20.setToolTipText(datos[25]);
/* 3483 */     this.ACTIVARSUC = datos[25];
/* 3484 */     this.NUMPROV = datos[26];
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 3488 */     String canti = cant;
/* 3489 */     String valorP = "";
/* 3490 */     for (int j = 0; j < canti.length(); j++) {
/* 3491 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3492 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3495 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 3499 */     this.jTextField3.setEnabled(false);
/* 3500 */     this.jTextField4.setEnabled(false);
/* 3501 */     this.jTextField5.setEnabled(false);
/* 3502 */     this.jTextField7.setEnabled(false);
/* 3503 */     this.jDateChooser1.setEnabled(false);
/* 3504 */     this.jSpinner1.setEnabled(false);
/* 3505 */     this.jSpinner2.setEnabled(false);
/* 3506 */     this.jSpinner3.setEnabled(false);
/* 3507 */     this.jComboBox3.setEnabled(false);
/* 3508 */     this.jTextField7.setEnabled(false);
/* 3509 */     this.jTextField8.setEnabled(false);
/* 3510 */     this.jTextField9.setEnabled(false);
/* 3511 */     this.jTextField10.setEnabled(false);
/* 3512 */     this.jComboBox4.setEnabled(false);
/* 3513 */     this.jComboBox5.setEnabled(false);
/* 3514 */     this.jComboBox6.setEnabled(false);
/* 3515 */     this.cant1.setEnabled(false);
/* 3516 */     this.cant2.setEnabled(false);
/* 3517 */     this.cant3.setEnabled(false);
/* 3518 */     this.cant4.setEnabled(false);
/* 3519 */     this.cant5.setEnabled(false);
/* 3520 */     this.cant6.setEnabled(false);
/* 3521 */     this.jTextField17.setEnabled(false);
/* 3522 */     this.jTextField18.setEnabled(false);
/* 3523 */     this.jTextField20.setEnabled(false);
/* 3524 */     this.jButton57.setEnabled(false);
/* 3525 */     this.jDateChooser2.setEnabled(false);
/* 3526 */     this.jEditorPane1.setEnabled(false);
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 3530 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 3531 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 3532 */     String fecha = formatter.format(fechaHoy);
/* 3533 */     return " (" + fecha + ")";
/*      */   }
/*      */   
/*      */   public void llenarSucursales() {
/* 3537 */     this.TODOS_SUCURSALES = new ArrayList();
/* 3538 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 3539 */     Object[][] Object = new Object[lista.size()][2];
/* 3540 */     Iterator<String> it = lista.iterator();
/* 3541 */     while (it.hasNext()) {
/* 3542 */       String v = it.next();
/* 3543 */       this.TODOS_SUCURSALES.add(v);
/* 3544 */       Object[lista.indexOf(v)][0] = Boolean.valueOf(false);
/* 3545 */       Object[lista.indexOf(v)][1] = v;
/*      */     } 
/* 3547 */     llenarTablaSuc(Object);
/* 3548 */     this.com_Sucursales = new TextAutoCompleter(this.jTextField20, this.TODOS_SUCURSALES);
/*      */   }
/*      */   
/*      */   public String dameSucursalOp(JTextField campo, JTable tabla) {
/* 3552 */     String sucursales = "";
/* 3553 */     boolean entra = false;
/* 3554 */     if (campo.isEditable()) {
/* 3555 */       for (int i = 0; i < tabla.getRowCount(); i++) {
/* 3556 */         boolean selec = ((Boolean)tabla.getValueAt(i, 0)).booleanValue();
/* 3557 */         if (selec) {
/* 3558 */           sucursales = sucursales + " " + sucursales + ",";
/* 3559 */           entra = true;
/*      */         } 
/*      */       } 
/* 3562 */       if (entra) {
/* 3563 */         sucursales = sucursales.substring(1, sucursales.length() - 1);
/*      */       } else {
/* 3565 */         sucursales = "";
/*      */       } 
/*      */     } else {
/* 3568 */       sucursales = campo.getText().toUpperCase();
/*      */     } 
/* 3570 */     return sucursales;
/*      */   }
/*      */   
/*      */   public void llenarTablaSuc(Object[][] arrayOfObject) {
/* 3574 */     (new String[2])[0] = ""; (new String[2])[1] = "Sucursal"; this.rSTableMetro2.setModel(new DefaultTableModel(arrayOfObject, (Object[])new String[2]) {
/* 3575 */           Class[] types = new Class[] { Boolean.class, Object.class };
/*      */           
/* 3577 */           boolean[] canEdit = new boolean[] { true, false };
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3580 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3584 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3587 */     this.rSTableMetro2.setAltoHead(25);
/* 3588 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3589 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3590 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3591 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3592 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3593 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3594 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3595 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3596 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3597 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3598 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3599 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3600 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 3601 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 3602 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3603 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3604 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3606 */             ProvFacturas.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3609 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3611 */             ProvFacturas.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3614 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 3615 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/* 3616 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/* 3617 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3618 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/* 3620 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3621 */     this.rSTableMetro2.setSelectionMode(0);
/* 3622 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void limpiarTablaSuc() {
/* 3626 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 3627 */       this.jTextField20.setText("");
/* 3628 */       this.jTextField20.setEnabled(true);
/* 3629 */       this.jButton57.setEnabled(true);
/*      */     } else {
/* 3631 */       this.jTextField20.setEnabled(false);
/* 3632 */       this.jTextField20.setText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 3633 */       this.jButton57.setEnabled(false);
/*      */     } 
/* 3635 */     this.jTextField20.setToolTipText(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 3636 */     selecTablaSucursal(this.CAMPOSGENERALES.get("sucursal"));
/*      */   }
/*      */   
/*      */   public void selecTablaSucursal(String suc) {
/* 3640 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3641 */       String columna = this.rSTableMetro2.getValueAt(i, 1).toString();
/* 3642 */       if (columna.equals(suc)) {
/* 3643 */         this.rSTableMetro2.setValueAt(Boolean.valueOf(true), i, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3649 */     this.pintar.colorear(this.jTextField1);
/* 3650 */     this.pintar.colorear(this.jTextField2);
/* 3651 */     this.pintar.colorear(this.jComboBox1);
/* 3652 */     this.pintar.colorear(this.jComboBox2);
/* 3653 */     this.pintar.colorear(this.jComboBox3);
/* 3654 */     this.pintar.colorear(this.jComboBox7);
/* 3655 */     this.pintar.colorear(this.jTextField7);
/* 3656 */     this.pintar.colorear(this.jTextField8);
/* 3657 */     this.pintar.colorear(this.jTextField9);
/* 3658 */     this.pintar.colorear(this.jTextField10);
/* 3659 */     this.pintar.colorear(this.jComboBox4);
/* 3660 */     this.pintar.colorear(this.jComboBox5);
/* 3661 */     this.pintar.colorear(this.jComboBox6);
/* 3662 */     this.pintar.colorear(this.jComboBox8);
/* 3663 */     this.pintar.colorear(this.jTextField3);
/* 3664 */     this.pintar.colorear(this.jTextField4);
/* 3665 */     this.pintar.colorear(this.jTextField5);
/* 3666 */     this.pintar.colorear(this.jSpinner1);
/* 3667 */     this.pintar.colorear(this.jSpinner2);
/* 3668 */     this.pintar.colorear(this.jSpinner3);
/* 3669 */     this.pintar.colorear(this.jTextField17);
/* 3670 */     this.pintar.colorear(this.jTextField18);
/* 3671 */     this.pintar.colorear(this.jTextField19);
/* 3672 */     this.pintar.colorear(this.jEditorPane1);
/* 3673 */     this.pintar.colorear(this.cant1);
/* 3674 */     this.pintar.colorear(this.cant2);
/* 3675 */     this.pintar.colorear(this.cant3);
/* 3676 */     this.pintar.colorear(this.cant4);
/* 3677 */     this.pintar.colorear(this.cant5);
/* 3678 */     this.pintar.colorear(this.cant6);
/* 3679 */     this.pintar.colorear(this.jTextArea5);
/*      */   }
/*      */   
/*      */   public void limpiarNuevo() {
/* 3683 */     this.jTextField3.setText("");
/* 3684 */     this.jTextField4.setText("");
/* 3685 */     this.jTextField5.setText("");
/* 3686 */     this.jTextField6.setText("");
/* 3687 */     this.jTextField7.setText("");
/* 3688 */     this.jDateChooser1.setDate(new Date());
/* 3689 */     this.jSpinner1.setValue("00");
/* 3690 */     this.jSpinner2.setValue("00");
/* 3691 */     this.jSpinner3.setValue("00");
/* 3692 */     this.jComboBox3.setSelectedIndex(0);
/* 3693 */     this.jTextField7.setText("");
/* 3694 */     this.jTextField8.setText("");
/* 3695 */     this.jTextField9.setText("");
/* 3696 */     this.jTextField10.setText("");
/* 3697 */     this.jComboBox4.setSelectedIndex(0);
/* 3698 */     this.jComboBox5.setSelectedIndex(0);
/* 3699 */     this.jComboBox6.setSelectedIndex(0);
/* 3700 */     this.cant1.setValue(Integer.valueOf(0));
/* 3701 */     this.cant2.setValue(Integer.valueOf(0));
/* 3702 */     this.cant3.setValue(Integer.valueOf(0));
/* 3703 */     this.cant4.setValue(Integer.valueOf(0));
/* 3704 */     this.cant5.setValue(Integer.valueOf(0));
/* 3705 */     this.jTextField86.setText("");
/* 3706 */     this.cant6.setValue(Integer.valueOf(1));
/* 3707 */     this.jTextField17.setText(this.NOMBREUSUARIOCOMP);
/* 3708 */     this.jTextField18.setText("");
/* 3709 */     this.jTextField19.setText(this.CAMPOSGENERALES.get("sucursal"));
/* 3710 */     this.jDateChooser2.setDate(new Date());
/* 3711 */     this.jEditorPane1.setText("");
/* 3712 */     this.entraRFCPrimera = false;
/*      */   }
/*      */   
/*      */   public void activar() {
/* 3716 */     this.jTextField3.setEnabled(true);
/* 3717 */     this.jTextField4.setEnabled(true);
/* 3718 */     this.jTextField5.setEnabled(true);
/* 3719 */     this.jTextField7.setEnabled(true);
/* 3720 */     this.jButton34.setEnabled(true);
/* 3721 */     this.jDateChooser1.setEnabled(true);
/* 3722 */     this.jSpinner1.setEnabled(true);
/* 3723 */     this.jSpinner2.setEnabled(true);
/* 3724 */     this.jSpinner3.setEnabled(true);
/* 3725 */     this.jComboBox3.setEnabled(true);
/* 3726 */     this.jTextField8.setEnabled(true);
/* 3727 */     this.jTextField9.setEnabled(true);
/* 3728 */     this.jTextField10.setEnabled(true);
/* 3729 */     this.jComboBox4.setEnabled(true);
/* 3730 */     this.jComboBox5.setEnabled(true);
/* 3731 */     this.jComboBox6.setEnabled(true);
/* 3732 */     this.cant1.setEnabled(true);
/* 3733 */     this.cant2.setEnabled(true);
/* 3734 */     this.cant3.setEnabled(true);
/* 3735 */     this.cant4.setEnabled(true);
/* 3736 */     this.cant5.setEnabled(true);
/* 3737 */     this.jButton56.setEnabled(true);
/* 3738 */     this.cant6.setEnabled(true);
/* 3739 */     this.jTextField17.setEnabled(true);
/* 3740 */     this.jTextField18.setEnabled(true);
/* 3741 */     this.jDateChooser2.setEnabled(true);
/* 3742 */     this.jEditorPane1.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void facturas(String USUARIO) {
/* 3746 */     this.PRIMERA = false;
/* 3747 */     privilegios();
/* 3748 */     this.USUARIO = USUARIO;
/* 3749 */     this.panel.setViewportView(this);
/* 3750 */     consultar();
/*      */   }
/*      */   
/*      */   public void recorrer(Tag raiz) {
/* 3754 */     for (Tag t : raiz.getTagsHijos()) {
/* 3755 */       for (Atributo a : t.getAtributos()) {
/* 3756 */         llenarCampos(a);
/*      */       }
/* 3758 */       if (t.isHijos()) {
/* 3759 */         recorrer(t);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void leerXML(String dir) {
/* 3765 */     JespXML archivo = new JespXML(dir);
/*      */     try {
/* 3767 */       Tag raiz = archivo.leerXML();
/* 3768 */       for (Atributo a : raiz.getAtributos()) {
/* 3769 */         llenarCampos(a);
/*      */       }
/* 3771 */       recorrer(raiz);
/* 3772 */     } catch (ParserConfigurationException ex) {
/* 3773 */       Logger.getLogger(ProvFacturas.class
/* 3774 */           .getName()).log(Level.SEVERE, (String)null, ex);
/* 3775 */     } catch (SAXException ex) {
/* 3776 */       Logger.getLogger(ProvFacturas.class
/* 3777 */           .getName()).log(Level.SEVERE, (String)null, ex);
/* 3778 */     } catch (IOException ex) {
/* 3779 */       Logger.getLogger(ProvFacturas.class
/* 3780 */           .getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCampos(Atributo a) {
/* 3785 */     System.out.println("Etiqueta: " + a.getNombre() + " " + a.getValor());
/* 3786 */     if (a.getNombre().equals("Fecha")) {
/* 3787 */       String FECHA = a.getValor();
/* 3788 */       String año = FECHA.substring(0, 4);
/* 3789 */       String mes = FECHA.substring(5, 7);
/* 3790 */       String dia = FECHA.substring(8, 10);
/* 3791 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3792 */       String strFecha = año + "-" + año + "-" + mes;
/* 3793 */       Date fecha = null;
/*      */       try {
/* 3795 */         fecha = formatoDelTexto.parse(strFecha);
/* 3796 */         this.jDateChooser1.setDate(fecha);
/* 3797 */       } catch (ParseException ex) {
/* 3798 */         ex.printStackTrace();
/*      */       } 
/* 3800 */       String hh = FECHA.substring(11, 13);
/* 3801 */       String mm = FECHA.substring(14, 16);
/* 3802 */       String ss = FECHA.substring(17, 19);
/* 3803 */       this.jSpinner1.setValue(hh);
/* 3804 */       this.jSpinner2.setValue(mm);
/* 3805 */       this.jSpinner3.setValue(ss);
/*      */     } 
/* 3807 */     if (a.getNombre().equals("Folio")) {
/* 3808 */       this.jTextField4.setText(a.getValor().toUpperCase());
/*      */     }
/* 3810 */     if (a.getNombre().equals("FormaPago")) {
/* 3811 */       int index = 0;
/* 3812 */       for (int i = 0; i < this.FORMAPAGO.length; i++) {
/* 3813 */         if (this.FORMAPAGO[i].equals(a.getValor())) {
/* 3814 */           index = i;
/*      */           break;
/*      */         } 
/*      */       } 
/* 3818 */       this.jComboBox5.setSelectedIndex(index);
/*      */     } 
/* 3820 */     if (a.getNombre().equals("LugarExpedicion")) {
/* 3821 */       this.jTextField8.setText(a.getValor());
/*      */     }
/* 3823 */     if (a.getNombre().equals("MetodoPago")) {
/* 3824 */       if (a.getValor().toUpperCase().equals("PUE")) {
/* 3825 */         this.jComboBox6.setSelectedIndex(0);
/*      */       } else {
/* 3827 */         this.jComboBox6.setSelectedIndex(1);
/*      */       } 
/*      */     }
/* 3830 */     if (a.getNombre().equals("Moneda")) {
/* 3831 */       this.jTextField86.setText(a.getValor().toUpperCase());
/*      */     }
/* 3833 */     if (a.getNombre().equals("Serie")) {
/* 3834 */       this.jTextField3.setText(a.getValor().toUpperCase());
/*      */     }
/* 3836 */     if (a.getNombre().equals("SubTotal")) {
/* 3837 */       this.cant1.setValue(Double.valueOf(Double.parseDouble(a.getValor())));
/*      */     }
/* 3839 */     if (a.getNombre().equals("Descuento")) {
/* 3840 */       this.cant2.setValue(Double.valueOf(Double.parseDouble(a.getValor())));
/*      */     }
/* 3842 */     if (a.getNombre().equals("TotalImpuestosTrasladados")) {
/* 3843 */       this.cant3.setValue(Double.valueOf(Double.parseDouble(a.getValor())));
/*      */     }
/* 3845 */     if (a.getNombre().equals("TotalImpuestosRetenidos")) {
/* 3846 */       this.cant4.setValue(Double.valueOf(Double.parseDouble(a.getValor())));
/*      */     }
/*      */     
/* 3849 */     if (a.getNombre().equals("Total")) {
/* 3850 */       this.cant5.setValue(Double.valueOf(Double.parseDouble(a.getValor())));
/*      */     }
/* 3852 */     if (a.getNombre().equals("TipoCambio") && !this.cant6.getValue().equals(Integer.valueOf(1))) {
/* 3853 */       this.cant6.setValue(a.getValor());
/*      */     }
/*      */     
/* 3856 */     if (a.getNombre().toUpperCase().equals("RFC") && !this.entraRFCPrimera) {
/* 3857 */       this.entraRFCPrimera = true;
/* 3858 */       System.out.println("aa " + a.getNombre() + " " + this.entraRFCPrimera + " " + a.getValor());
/* 3859 */       this.jTextField7.setText(a.getValor().toUpperCase());
/* 3860 */       this.PROVLISTA.stream().filter(p -> p.getRfc().equals(a.getValor().toUpperCase())).forEach(s -> System.out.println(s));
/* 3861 */       this.PROVLISTA.stream().filter(p -> p.getRfc().equals(a.getValor().toUpperCase())).forEach(s -> this.jComboBox3.setSelectedItem(s.getRazonSocial()));
/* 3862 */       this.PROVSELEC = this.jComboBox3.getSelectedIndex() - 1;
/* 3863 */       Proveedores p = this.PROVLISTA.get(this.PROVSELEC);
/* 3864 */       this.jTextField18.setText(p.getContacto());
/* 3865 */       if (this.jComboBox3.getSelectedIndex() == 0) {
/* 3866 */         this.materialButton22.setEnabled(false);
/* 3867 */         JOptionPane.showMessageDialog(this, "El proveedor no se encontró registrado", "No existe el Proveedor", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 3870 */         this.materialButton22.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3878 */     if (a.getNombre().toUpperCase().equals("UUID")) {
/* 3879 */       this.jTextField5.setText(a.getValor().toUpperCase());
/*      */     }
/* 3881 */     if (a.getNombre().toUpperCase().equals("USOCFDI")) {
/* 3882 */       this.jTextField6.setText(a.getValor().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 3887 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 3888 */     this.lista = Arrays.asList(this.SUCURSALES);
/* 3889 */     Iterator<String> it = this.lista.iterator();
/* 3890 */     this.jComboBox9.addItem("GENERAL");
/* 3891 */     while (it.hasNext()) {
/* 3892 */       String v = it.next();
/* 3893 */       this.jComboBox1.addItem(v);
/* 3894 */       this.jComboBox9.addItem(v);
/*      */     } 
/* 3896 */     this.jComboBox9.removeItemAt(2);
/* 3897 */     this.comboCargado = true;
/*      */   }
/*      */   
/*      */   public void llenarComboUsuario() {
/* 3901 */     String[] usu = this.con2.regresaColIndex("nombre_usu", "usuarios", "where priv='ADMINISTRADOR' || priv ='CUENTAS POR PAGAR' || priv='SUPERVISOR DE CUENTAS POR PAGAR' || priv='SUPER USUARIO' order by nombre_usu");
/* 3902 */     List<String> lista = Arrays.asList(usu);
/* 3903 */     lista.forEach(v -> this.jComboBox7.addItem(v));
/*      */   }
/*      */   
/*      */   public void llenarComboProv() {
/* 3907 */     String[][] prov = this.con.buscarDatos(8, "numProv, razonSocial, nombreComercial, rfc, moneda, contacto, cp, usoCFDIclave", "prov_proveedores", "where estado='ACTIVO' " + getConsultaSuc() + " order by nombreComercial");
/* 3908 */     this.PROVLISTA = new ArrayList<>();
/* 3909 */     for (String[] r : prov) {
/* 3910 */       Proveedores prove = new Proveedores(r[0], r[1], r[2], r[3], r[4], r[5], r[6], r[7]);
/* 3911 */       this.jComboBox3.addItem(r[1]);
/* 3912 */       this.PROVLISTA.add(prove);
/*      */     } 
/* 3914 */     this.primeraNuevo = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarCatMonedas() {
/* 3919 */     (new String[2])[0] = "Moneda"; (new String[2])[1] = "Descripción"; this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(2, "moneda,descripcion", "catmoneda", "order by moneda"), (Object[])new String[2]) {
/* 3920 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3923 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3926 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 3927 */     this.rSTableMetro3.setSelectionMode(0);
/* 3928 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 3929 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 3930 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 3931 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(90);
/* 3932 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 3933 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 3934 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3938 */     this.PRIMERA = true;
/* 3939 */     Date fecha1 = this.jDateChooser4.getDate();
/* 3940 */     Date fecha2 = this.jDateChooser5.getDate();
/* 3941 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3942 */     String cadenaFecha = "";
/* 3943 */     cadenaFecha = formato.format(fecha1);
/* 3944 */     String AÑO = cadenaFecha.substring(0, 4);
/* 3945 */     String MES = cadenaFecha.substring(4, 6);
/* 3946 */     String DIA = cadenaFecha.substring(6, 8);
/* 3947 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3948 */     cadenaFecha = formato.format(fecha2);
/* 3949 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3950 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3951 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3952 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 3953 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 3954 */     String folio = "";
/* 3955 */     if (!this.jTextField1.getText().equals(this.holderFolio)) {
/* 3956 */       folio = this.jTextField1.getText();
/*      */     }
/* 3958 */     String proveedor = "";
/* 3959 */     if (!this.jTextField2.getText().equals(this.holderProveedor)) {
/* 3960 */       proveedor = this.jTextField2.getText();
/*      */     }
/* 3962 */     String sucursalForsis = "";
/* 3963 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3964 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 3966 */     String estado = " estado='<Por Pagar>' || estado like '%<Pagada%' || estado like '%<Abono%' || estado like '%<Aplicada%'";
/* 3967 */     if (this.jComboBox2.getSelectedIndex() == 1) {
/* 3968 */       estado = " estado like '%%'";
/* 3969 */     } else if (this.jComboBox2.getSelectedIndex() == 2) {
/* 3970 */       estado = " estado ='<Por Pagar>' || estado like '%<Abono:%'";
/* 3971 */     } else if (this.jComboBox2.getSelectedIndex() == 3) {
/* 3972 */       estado = " estado ='<Por Pagar>'";
/* 3973 */     } else if (this.jComboBox2.getSelectedIndex() == 4) {
/* 3974 */       estado = " estado like '%<Abono%'";
/* 3975 */     } else if (this.jComboBox2.getSelectedIndex() == 5) {
/* 3976 */       estado = " estado like '%<Pagada%'";
/* 3977 */     } else if (this.jComboBox2.getSelectedIndex() == 6) {
/* 3978 */       estado = " estado like '%<Cancelada%'";
/*      */     } 
/* 3980 */     String campoFecha = "fechaRecepcion";
/* 3981 */     if (this.jComboBox8.getSelectedIndex() == 1) {
/* 3982 */       campoFecha = "fechaPago";
/* 3983 */     } else if (this.jComboBox8.getSelectedIndex() == 2) {
/* 3984 */       campoFecha = "fechaFactura";
/*      */     } 
/* 3986 */     String usuario = "";
/* 3987 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 3988 */       usuario = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/*      */     
/* 3991 */     (new String[14])[0] = "ID"; (new String[14])[1] = "Recepción"; (new String[14])[2] = "Pago"; (new String[14])[3] = "Proveedor"; (new String[14])[4] = "RFC"; (new String[14])[5] = "Folio"; (new String[14])[6] = "Fecha Factura"; (new String[14])[7] = "Total"; (new String[14])[8] = "Debe"; (new String[14])[9] = "Condiciones"; (new String[14])[10] = "C"; (new String[14])[11] = "Estado"; (new String[14])[12] = "Sucursal"; (new String[14])[13] = "Actualizó"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(14, "numFactura, fechaRecepcion, fechaPago, proveedor, rfc, folioComp, fechaFactura, total, totalDebe, condiciones, complementos, estado, sucOp, usuario", "prov_facturas", "where (" + campoFecha + " between " + fechaCompleta1 + " and " + fechaCompleta2 + " ) and folioComp like '%" + folio + "%' and proveedor like '%" + proveedor + "%' and sucOp like '%" + sucursalForsis + "%' and (" + estado + ")  and usuario like '%" + usuario + "%' " + 
/* 3992 */             getConsultaSuc() + " order by " + campoFecha + " desc"), (Object[])new String[14])
/*      */         {
/*      */           
/* 3995 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4000 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4003 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 4004 */     this.jLabel37.setText("$0.00");
/* 4005 */     this.jLabel216.setText("$0.00");
/* 4006 */     calcularTotalesFacturados();
/* 4007 */     this.celda2.pasarInd3(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Pagar>", 0, 11, 0));
/* 4008 */     this.celda2.pasarInd4(this.con.revisarCol((JTable)this.rSTableMetro1, "<Abono", 0, 11, 2));
/* 4009 */     this.celda2.pasarInd5(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelada>", 0, 11, 0));
/* 4010 */     this.rSTableMetro1.setSelectionMode(0);
/* 4011 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 4012 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 4013 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 4014 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 4015 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 4016 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(70);
/* 4017 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 4018 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(70);
/* 4019 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 4020 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(100);
/* 4021 */     this.rSTableMetro1.getColumnModel().getColumn(7).setPreferredWidth(75);
/* 4022 */     this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(75);
/* 4023 */     this.rSTableMetro1.getColumnModel().getColumn(8).setPreferredWidth(75);
/* 4024 */     this.rSTableMetro1.getColumnModel().getColumn(8).setMaxWidth(75);
/* 4025 */     this.rSTableMetro1.getColumnModel().getColumn(10).setPreferredWidth(30);
/* 4026 */     this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(30);
/* 4027 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4028 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4029 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4030 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4031 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4032 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4033 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4034 */     this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 4035 */     this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 4036 */     this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 4037 */     this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 4038 */     this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 4039 */     this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 4040 */     this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 4041 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void calcularTotalesFacturados() {
/* 4045 */     double valorT = 0.0D;
/* 4046 */     double valorDE = 0.0D;
/* 4047 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 4048 */       valorT += convertirCantTexto(this.rSTableMetro1.getValueAt(i, 7).toString());
/* 4049 */       this.cantidad.setValue(Double.valueOf(valorT));
/* 4050 */       this.jLabel37.setText(this.cantidad.getText());
/* 4051 */       valorDE += convertirCantTexto(this.rSTableMetro1.getValueAt(i, 8).toString());
/* 4052 */       this.cantidad.setValue(Double.valueOf(valorDE));
/* 4053 */       this.jLabel216.setText(this.cantidad.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 4058 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 4066 */         return 31;
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 4071 */         return 30;
/*      */       case 1:
/* 4073 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0)) {
/* 4074 */           return 29;
/*      */         }
/* 4076 */         return 28;
/*      */     } 
/* 4078 */     return 0;
/*      */   }
/*      */   
/*      */   class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 4083 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4086 */       setEnabled((table == null || table.isEnabled()));
/* 4087 */       if (row % 2 == 0) {
/* 4088 */         setBackground(ProvFacturas.this.lc.FONDOTABLA);
/*      */       } else {
/* 4090 */         setBackground((Color)null);
/*      */       } 
/* 4092 */       setForeground(ProvFacturas.this.lc.SECUNDARIO1);
/* 4093 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4094 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   class Proveedores
/*      */   {
/* 4100 */     private String numProv = "";
/*      */     
/* 4102 */     private String razonSocial = "";
/*      */     
/* 4104 */     private String nombreComercial = "";
/*      */     
/* 4106 */     private String rfc = "";
/*      */     
/* 4108 */     private String moneda = "";
/*      */     
/* 4110 */     private String contacto = "";
/*      */     
/* 4112 */     private String condigoPostal = "";
/*      */     
/* 4114 */     private String usoCFDIclave = "";
/*      */ 
/*      */     
/*      */     public Proveedores() {}
/*      */     
/*      */     public Proveedores(String numProv, String razonSocial, String nombreComercial, String rfc, String moneda, String contacto, String codigoPostal, String usoCFDIclave) {
/* 4120 */       this.numProv = numProv;
/* 4121 */       this.razonSocial = razonSocial;
/* 4122 */       this.nombreComercial = nombreComercial;
/* 4123 */       this.rfc = rfc;
/* 4124 */       this.moneda = moneda;
/* 4125 */       this.contacto = contacto;
/* 4126 */       this.condigoPostal = codigoPostal;
/* 4127 */       this.usoCFDIclave = usoCFDIclave;
/*      */     }
/*      */     
/*      */     public String getUsoCFDIclave() {
/* 4131 */       return this.usoCFDIclave;
/*      */     }
/*      */     
/*      */     public void setUsoCFDIclave(String usoCFDIclave) {
/* 4135 */       this.usoCFDIclave = usoCFDIclave;
/*      */     }
/*      */     
/*      */     public String getCondigoPostal() {
/* 4139 */       return this.condigoPostal;
/*      */     }
/*      */     
/*      */     public void setCondigoPostal(String condigoPostal) {
/* 4143 */       this.condigoPostal = condigoPostal;
/*      */     }
/*      */     
/*      */     public String getNumProv() {
/* 4147 */       return this.numProv;
/*      */     }
/*      */     
/*      */     public void setNumProv(String numProv) {
/* 4151 */       this.numProv = numProv;
/*      */     }
/*      */     
/*      */     public String getRazonSocial() {
/* 4155 */       return this.razonSocial;
/*      */     }
/*      */     
/*      */     public void setRazonSocial(String razonSocial) {
/* 4159 */       this.razonSocial = razonSocial;
/*      */     }
/*      */     
/*      */     public String getNombreComercial() {
/* 4163 */       return this.nombreComercial;
/*      */     }
/*      */     
/*      */     public void setNombreComercial(String nombreComercial) {
/* 4167 */       this.nombreComercial = nombreComercial;
/*      */     }
/*      */     
/*      */     public String getRfc() {
/* 4171 */       return this.rfc;
/*      */     }
/*      */     
/*      */     public void setRfc(String rfc) {
/* 4175 */       this.rfc = rfc;
/*      */     }
/*      */     
/*      */     public String getMoneda() {
/* 4179 */       return this.moneda;
/*      */     }
/*      */     
/*      */     public void setMoneda(String moneda) {
/* 4183 */       this.moneda = moneda;
/*      */     }
/*      */     
/*      */     public String getContacto() {
/* 4187 */       return this.contacto;
/*      */     }
/*      */     
/*      */     public void setContacto(String contacto) {
/* 4191 */       this.contacto = contacto;
/*      */     }
/*      */     
/*      */     public int hashCode() {
/* 4195 */       int hash = 7;
/* 4196 */       hash = 17 * hash + Objects.hashCode(this.rfc);
/* 4197 */       return hash;
/*      */     }
/*      */     
/*      */     public boolean equals(Object obj) {
/* 4201 */       if (this == obj) {
/* 4202 */         return true;
/*      */       }
/* 4204 */       if (obj == null) {
/* 4205 */         return false;
/*      */       }
/* 4207 */       if (getClass() != obj.getClass()) {
/* 4208 */         return false;
/*      */       }
/* 4210 */       Proveedores other = (Proveedores)obj;
/* 4211 */       if (!Objects.equals(this.rfc, other.rfc)) {
/* 4212 */         return false;
/*      */       }
/* 4214 */       return true;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     CeldaRender2() {
/* 4220 */       this.otro = -1;
/*      */       
/* 4222 */       this.indices = new String[0];
/*      */       
/* 4224 */       this.indices2 = new String[0];
/*      */       
/* 4226 */       this.indices3 = new String[0];
/*      */       
/* 4228 */       this.indices4 = new String[0];
/*      */       
/* 4230 */       this.indices5 = new String[0];
/*      */       
/* 4232 */       this.indices6 = new String[0];
/*      */       
/* 4234 */       this.indices7 = new String[0];
/*      */     } String[] indices4; String[] indices5; String[] indices6; String[] indices7;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4237 */       setEnabled((table == null || table.isEnabled()));
/* 4238 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4239 */       if (comparar7(comp)) {
/* 4240 */         setBackground(new Color(34, 108, 255));
/* 4241 */         setForeground(Color.WHITE);
/* 4242 */       } else if (comparar6(comp)) {
/* 4243 */         setBackground(new Color(255, 102, 0));
/* 4244 */         setForeground(Color.WHITE);
/* 4245 */       } else if (comparar3(comp)) {
/* 4246 */         setBackground(new Color(102, 153, 255));
/* 4247 */         setForeground(Color.BLUE);
/* 4248 */       } else if (comparar4(comp)) {
/* 4249 */         setBackground(Color.LIGHT_GRAY);
/* 4250 */         setForeground(Color.RED);
/* 4251 */       } else if (comparar5(comp)) {
/* 4252 */         setBackground(Color.RED);
/* 4253 */         setForeground(Color.WHITE);
/*      */       } else {
/* 4255 */         setBackground((Color)null);
/* 4256 */         setForeground(ProvFacturas.this.lc.SECUNDARIO1);
/*      */       } 
/* 4258 */       if (column == 0 || column == 6 || column == 7 || column == 8) {
/* 4259 */         setHorizontalAlignment(4);
/* 4260 */       } else if (column == 10) {
/* 4261 */         setHorizontalAlignment(0);
/*      */       } else {
/* 4263 */         setHorizontalAlignment(10);
/*      */       } 
/* 4265 */       if (column == 1 && ProvFacturas.this.jComboBox8.getSelectedIndex() == 0) {
/* 4266 */         setBackground(ProvFacturas.this.lc.SECUNDARIO2);
/* 4267 */       } else if (column == 2 && ProvFacturas.this.jComboBox8.getSelectedIndex() == 1) {
/* 4268 */         setBackground(ProvFacturas.this.lc.SECUNDARIO2);
/* 4269 */       } else if (column == 6 && ProvFacturas.this.jComboBox8.getSelectedIndex() == 2) {
/* 4270 */         setBackground(ProvFacturas.this.lc.SECUNDARIO2);
/*      */       } 
/* 4272 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4273 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4277 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 4281 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 4285 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 4289 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 4293 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd6(String[] ind) {
/* 4297 */       this.indices6 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd7(String[] ind) {
/* 4301 */       this.indices7 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4305 */       for (int i = 0; i < this.indices.length; i++) {
/* 4306 */         if (this.indices[i].equals(reg)) {
/* 4307 */           return true;
/*      */         }
/*      */       } 
/* 4310 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 4314 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4315 */         if (this.indices2[i].equals(reg)) {
/* 4316 */           return true;
/*      */         }
/*      */       } 
/* 4319 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 4323 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4324 */         if (this.indices3[i].equals(reg)) {
/* 4325 */           return true;
/*      */         }
/*      */       } 
/* 4328 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 4332 */       for (int i = 0; i < this.indices4.length; i++) {
/* 4333 */         if (this.indices4[i].equals(reg)) {
/* 4334 */           return true;
/*      */         }
/*      */       } 
/* 4337 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 4341 */       for (int i = 0; i < this.indices5.length; i++) {
/* 4342 */         if (this.indices5[i].equals(reg)) {
/* 4343 */           return true;
/*      */         }
/*      */       } 
/* 4346 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar6(String reg) {
/* 4350 */       for (int i = 0; i < this.indices6.length; i++) {
/* 4351 */         if (this.indices6[i].equals(reg)) {
/* 4352 */           return true;
/*      */         }
/*      */       } 
/* 4355 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar7(String reg) {
/* 4359 */       for (int i = 0; i < this.indices7.length; i++) {
/* 4360 */         if (this.indices7[i].equals(reg)) {
/* 4361 */           return true;
/*      */         }
/*      */       } 
/* 4364 */       return false;
/*      */     } }
/*      */   
/*      */   class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     CeldaRender3() {
/* 4370 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4373 */       setEnabled((table == null || table.isEnabled()));
/* 4374 */       if (row % 2 == 0) {
/* 4375 */         setBackground(ProvFacturas.this.lc.FONDOTABLA);
/*      */       } else {
/* 4377 */         setBackground((Color)null);
/*      */       } 
/* 4379 */       if (column == 6 || column == 7) {
/* 4380 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4382 */         setHorizontalAlignment(2);
/*      */       } 
/* 4384 */       if (column == 1) {
/* 4385 */         setBackground(ProvFacturas.this.lc.SECUNDARIO2);
/*      */       }
/* 4387 */       setForeground(ProvFacturas.this.lc.SECUNDARIO1);
/* 4388 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4389 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 4397 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 4400 */       this.t = new Thread(this);
/* 4401 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 4409 */         ProvFacturas.this.EtiquetaEstado.setVisible(true);
/* 4410 */         ProvFacturas.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 4411 */         ProvFacturas.this.setCursor(new Cursor(3));
/* 4412 */         Thread.currentThread();
/* 4413 */         Thread.sleep(1000L);
/* 4414 */         detener();
/* 4415 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 4420 */       ProvFacturas.this.consultar();
/* 4421 */       ProvFacturas.this.setCursor(ProvFacturas.this.micursor);
/* 4422 */       ProvFacturas.this.EtiquetaEstado.setVisible(false);
/* 4423 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 4427 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvFacturas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */