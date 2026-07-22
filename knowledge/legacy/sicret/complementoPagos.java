/*      */ package sicret;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Point;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.beans.PropertyChangeEvent;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.IOException;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.time.ZoneId;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
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
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import org.jespxml.modelo.Atributo;
/*      */ import org.jespxml.modelo.Tag;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import utilerias.Esperando;
/*      */ 
/*      */ public class complementoPagos extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   70 */   Date fechaActual = new Date();
/*   71 */   Date fechaInicio = null;
/*   72 */   Date fecha = new Date();
/*   73 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   74 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   75 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   76 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   77 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   78 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   79 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   80 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   81 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   82 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   83 */   JFrame padre = null;
/*   84 */   JTabbedPane fichas = null;
/*   85 */   String[] CLAVES = null;
/*   86 */   Consultas2 con = new Consultas2();
/*      */   boolean encontrado = false;
/*      */   EscribirReporte esc;
/*   89 */   String MONTO = "";
/*   90 */   double CANTIDAD = 0.0D;
/*   91 */   DefaultTableModel modelo = new DefaultTableModel();
/*   92 */   CeldaRender celda = new CeldaRender();
/*   93 */   CeldaRender2 celda2 = new CeldaRender2();
/*   94 */   CeldaRender3 celda3 = new CeldaRender3();
/*   95 */   CeldaRender4 celda4 = new CeldaRender4();
/*   96 */   CeldaRender5 celda5 = new CeldaRender5();
/*   97 */   CeldaRender6 celda6 = new CeldaRender6();
/*   98 */   CeldaRender7 celda7 = new CeldaRender7();
/*   99 */   String[] DATOS = null;
/*  100 */   String ENTREGA = "";
/*  101 */   String RECIBE = "";
/*      */   
/*      */   PlaceHolder place;
/*  104 */   HashMap CLIENTES = new HashMap<>();
/*  105 */   HashMap RAZONSOCIAL = new HashMap<>();
/*  106 */   HashMap CALLE = new HashMap<>();
/*  107 */   HashMap NUMEROS = new HashMap<>();
/*  108 */   HashMap COLONIAS = new HashMap<>();
/*  109 */   HashMap CIUDADES = new HashMap<>();
/*  110 */   HashMap CODIGOS = new HashMap<>();
/*  111 */   HashMap RFC = new HashMap<>();
/*  112 */   HashMap ESTADOS = new HashMap<>();
/*  113 */   HashMap REGIMENES = new HashMap<>();
/*  114 */   Fuentes fuentes = new Fuentes();
/*      */   NumerosALetras numLetra;
/*      */   bancosEmisores[] BANCOS;
/*  117 */   TextAutoCompleter com_EmisorBancoRFC = null;
/*  118 */   TextAutoCompleter com_EmisorBancoCuenta = null;
/*  119 */   TextAutoCompleter com_EmisorBancoNombre = null;
/*      */   
/*  121 */   TextAutoCompleter com_ReceptorBancoRFC = null;
/*  122 */   TextAutoCompleter com_ReceptorBancoCuenta = null;
/*  123 */   TextAutoCompleter com_ReceptorBancoNombre = null;
/*      */   
/*  125 */   ArrayList TODOS_EMISORBANCOCLIENTES = new ArrayList();
/*  126 */   ArrayList TODOS_EMISORBANCORFC = new ArrayList();
/*  127 */   ArrayList TODOS_EMISORBANCOCUENTA = new ArrayList();
/*  128 */   ArrayList TODOS_EMISORBANCONOMBRE = new ArrayList();
/*      */   
/*  130 */   ArrayList TODOS_RECEPTORBANCORFC = new ArrayList();
/*  131 */   ArrayList TODOS_RECEPTORBANCOCUENTA = new ArrayList();
/*  132 */   ArrayList TODOS_RECEPTORBANCONOMBRE = new ArrayList();
/*  133 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*  134 */   String FECHAGRAL = "";
/*  135 */   String RUTAENTRADA = "";
/*  136 */   String DEPARTAMENTO = "";
/*      */   
/*  138 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*  140 */   String[] metodos = new String[] { "01", "02", "03", "04", "05", "06", "08", "28", "29", "30", "99" };
/*  141 */   SColores lc = new SColores();
/*      */   
/*  143 */   PlaceHolder placeHolder = null;
/*  144 */   String holderFolio = "FOLIO";
/*      */   boolean PRIMERA = false;
/*  146 */   Utilerias utilerias = new Utilerias();
/*      */   Map<String, String> CAMPOSGENERALES;
/*  148 */   Map<String, Facturas> FACTURAS = new HashMap<>();
/*  149 */   Map<String, ImpuestosRet> IMPUESTOSRET = new HashMap<>();
/*  150 */   Map<String, ImpuestosIva> IMPUESTOSIVA = new HashMap<>();
/*      */   private int xx;
/*      */   private int xy;
/*  153 */   int VERSION = 0;
/*  154 */   String RUTA20 = "";
/*  155 */   String[] COL1 = null;
/*  156 */   double VALOR1 = 0.0D;
/*  157 */   double VALOR2 = 0.0D;
/*  158 */   String[] TIPOS = null;
/*  159 */   String CLAVECLIENTE = ""; boolean SINXML = false; boolean leyendoXML = false; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton16; private JButton jButton2; private JButton jButton20; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton29; private JButton jButton37; private JButton jButton49; private JButton jButton50; private JButton jButton51; private JButton jButton52; private JButton jButton53; private JButton jButton54; private JButton jButton55; private JButton jButton60; private JButton jButton62; private JComboBox jComboBox1; private JComboBox<String> jComboBox10; private JComboBox jComboBox18; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox<String> jComboBox36; private JComboBox<String> jComboBox37; private JComboBox jComboBox4; private JComboBox<String> jComboBox40; private JComboBox<String> jComboBox41; private JComboBox jComboBox6; private JDateChooser jDateChooser1; private JDateChooser jDateChooser10; private JDateChooser jDateChooser14; private JDateChooser jDateChooser15; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog12; private JDialog jDialog13; private JDialog jDialog17; private JDialog jDialog18; private JDialog jDialog2; private JDialog jDialog22; private JDialog jDialog3; private JDialog jDialog37; private JDialog jDialog4; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField10; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField8; private JFormattedTextField jFormattedTextField9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel103; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel125;
/*      */   private JLabel jLabel129;
/*      */   private JLabel jLabel130;
/*  162 */   File archivoOriginal = null; private JLabel jLabel169; private JLabel jLabel170; private JLabel jLabel171; private JLabel jLabel172; private JLabel jLabel173; private JLabel jLabel18; private JLabel jLabel189; private JLabel jLabel192; private JLabel jLabel193; private JLabel jLabel194; private JLabel jLabel196; private JLabel jLabel2; private JLabel jLabel225; private JLabel jLabel233; private JLabel jLabel234; private JLabel jLabel235; private JLabel jLabel236; private JLabel jLabel237; private JLabel jLabel241; private JLabel jLabel242; private JLabel jLabel244; private JLabel jLabel26; private JLabel jLabel3; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76;
/*      */   private JLabel jLabel77;
/*      */   
/*      */   public complementoPagos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES) {
/*  166 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*      */     
/*  168 */     initComponents();
/*  169 */     String año = "2011";
/*  170 */     String mes = "01";
/*  171 */     String dia = "01";
/*  172 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  173 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  175 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  176 */     } catch (ParseException ex) {
/*  177 */       ex.printStackTrace();
/*      */     } 
/*  179 */     this.padre = padre;
/*  180 */     fichas = fichas;
/*  181 */     initComponents();
/*  182 */     this.con.setCamposGenerales(CAMPOSGENERALES);
/*  183 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderFolio, false, "Cantarell", 11);
/*  184 */     this.jScrollPane8.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  185 */     this.jScrollPane34.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*  186 */     llenarCombo();
/*  187 */     this.USUARIO = USUARIO;
/*  188 */     panelito.setViewportView(this);
/*  189 */     this.panel = panelito;
/*  190 */     colorear();
/*      */     
/*  192 */     int w = this.tama.width;
/*  193 */     int h = this.tama.height;
/*  194 */     int rw = (w - 750) / 2;
/*  195 */     int rh = (h - 680) / 2;
/*      */     
/*  197 */     rw = (w - 390) / 2;
/*  198 */     rh = (h - 165) / 2;
/*  199 */     this.jDialog3.setLocation(rw, rh);
/*  200 */     this.jDialog3.setSize(390, 165);
/*  201 */     this.jDialog3.setVisible(false);
/*  202 */     this.jDialog3.setResizable(false);
/*      */     
/*  204 */     int largo = this.tama.height - 50;
/*  205 */     if (largo > 1110) {
/*  206 */       largo = 1110;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  215 */     this.utilerias.activarVentanajDialog(this.jDialog1, 850, largo);
/*  216 */     this.utilerias.activarVentanajDialog(this.jDialog9, 850, 365);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  231 */     rw = (w - 410) / 2;
/*  232 */     rh = (h - 200) / 2;
/*  233 */     this.jDialog11.setLocation(rw, rh);
/*  234 */     this.jDialog11.setSize(410, 200);
/*  235 */     this.jDialog11.setVisible(false);
/*  236 */     this.jDialog11.setResizable(false);
/*      */     
/*  238 */     rw = (w - 380) / 2;
/*  239 */     rh = (h - 110) / 2;
/*  240 */     this.jDialog12.setLocation(rw, rh);
/*  241 */     this.jDialog12.setSize(380, 130);
/*  242 */     this.jDialog12.setResizable(false);
/*      */     
/*  244 */     rw = (w - 650) / 2;
/*  245 */     rh = (h - 280) / 2;
/*  246 */     this.jDialog17.setLocation(rw, rh);
/*  247 */     this.jDialog17.setSize(650, 280);
/*  248 */     this.jDialog17.setResizable(false);
/*      */     
/*  250 */     rw = (w - 750) / 2;
/*  251 */     rh = (h - 160) / 2;
/*  252 */     this.jDialog18.setLocation(rw, rh);
/*  253 */     this.jDialog18.setSize(750, 160);
/*  254 */     this.jDialog18.setResizable(false);
/*      */     
/*  256 */     this.utilerias.activarVentanajDialog(this.jDialog37, 870, 700);
/*      */     
/*  258 */     this.utilerias.activarVentanajDialog(this.jDialog13, 870, 700);
/*      */     
/*  260 */     this.utilerias.activarVentanajDialog(this.jDialog10, 380, 300);
/*  261 */     this.utilerias.activarVentanajDialog(this.jDialog2, 390, 245);
/*  262 */     this.utilerias.activarVentanajDialog(this.jDialog22, 740, 225);
/*      */     
/*  264 */     this.utilerias.activarVentanajDialog(this.jDialog4, 870, 500);
/*      */     
/*  266 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  267 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  268 */     this.jLabel170.setCursor(micursor);
/*  269 */     this.jLabel101.setCursor(micursor);
/*  270 */     this.jLabel171.setCursor(micursor);
/*  271 */     this.jLabel12.setCursor(micursor);
/*  272 */     this.jLabel66.setCursor(micursor);
/*      */     
/*  274 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  275 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  276 */     this.jDialog3.setCursor(micursor);
/*  277 */     this.jDialog1.setCursor(micursor);
/*  278 */     this.jDialog9.setCursor(micursor);
/*  279 */     this.jDialog10.setCursor(micursor);
/*  280 */     this.jDialog11.setCursor(micursor);
/*  281 */     this.jDialog17.setCursor(micursor);
/*  282 */     this.jDialog18.setCursor(micursor);
/*  283 */     this.rSTableMetro1.setCursor(micursor);
/*  284 */     this.rSTableMetro5.setCursor(micursor);
/*  285 */     this.rSTableMetro6.setCursor(micursor);
/*  286 */     this.rSTableMetro7.setCursor(micursor);
/*  287 */     this.rSTableMetro8.setCursor(micursor);
/*      */     
/*  289 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  290 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  291 */     editFormat.setGroupingUsed(false);
/*  292 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  293 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  294 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  295 */     enFormat.setAllowsInvalid(true);
/*  296 */     this.cantidad.setFormatterFactory(currFactory);
/*  297 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  298 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*      */     
/*  300 */     this.utilerias.formatearAPesos(this.jFormattedTextField7);
/*  301 */     this.utilerias.formatearAPesos(this.jFormattedTextField8);
/*  302 */     this.utilerias.formatearAPesos(this.jFormattedTextField9);
/*  303 */     this.utilerias.formatearAPesos(this.jFormattedTextField10);
/*      */     
/*  305 */     this.cantidad.setValue(Integer.valueOf(0));
/*  306 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*  307 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     
/*  309 */     this.modelo.addColumn("Factura");
/*  310 */     this.modelo.addColumn("Monto Original");
/*  311 */     this.modelo.addColumn("Monto a Saldar");
/*  312 */     this.modelo.addColumn("Tipo");
/*      */     
/*  314 */     desplazarFecha();
/*      */     
/*  316 */     for (int i = 2010; i <= añoActual(); i++) {
/*  317 */       this.jComboBox36.addItem("" + i);
/*  318 */       this.jComboBox40.addItem("" + i);
/*      */     } 
/*  320 */     this.jComboBox37.setSelectedIndex(mesActual());
/*  321 */     this.jComboBox36.setSelectedItem("" + añoActual());
/*      */     
/*  323 */     this.jComboBox41.setSelectedIndex(this.utilerias.mesActual());
/*  324 */     this.jComboBox40.setSelectedItem("" + this.utilerias.añoActual());
/*      */ 
/*      */     
/*  327 */     this.DATOS = new String[] { CAMPOSGENERALES.get("folioFacturas").toString(), CAMPOSGENERALES.get("contraloria").toString(), CAMPOSGENERALES.get("sucursal").toString(), CAMPOSGENERALES.get("codigoPostal").toString(), CAMPOSGENERALES.get("numCertificado").toString(), CAMPOSGENERALES.get("factEntrada33").toString() };
/*  328 */     this.RUTAENTRADA = this.DATOS[5];
/*  329 */     this.jTextField24.setText(this.DATOS[5]);
/*      */     
/*  331 */     consultar();
/*  332 */     sacarUsuarios();
/*  333 */     sacarDepa();
/*      */     
/*  335 */     llenarCatMonedas();
/*  336 */     this.RUTA20 = this.CAMPOSGENERALES.get("factEntrada40");
/*      */     
/*  338 */     this.jButton26.setEnabled(false);
/*  339 */     this.jButton27.setEnabled(false);
/*      */     
/*  341 */     this.pintar.colorear(this.jFormattedTextField7);
/*  342 */     this.pintar.colorear(this.jFormattedTextField8);
/*  343 */     this.pintar.colorear(this.jFormattedTextField9);
/*  344 */     this.pintar.colorear(this.jFormattedTextField10);
/*      */     
/*  346 */     if (((String)this.CAMPOSGENERALES.get("priv")).equals("SUPER USUARIO")) {
/*  347 */       this.jTextField91.setEditable(true);
/*      */     } else {
/*  349 */       this.jTextField91.setEditable(false);
/*      */     } 
/*      */   }
/*      */   private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel9; private JLabel jLabel94; private JLabel jLabel96; private JLabel jLabel97; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel103; private JPanel jPanel12; private JPanel jPanel127; private JPanel jPanel13; private JPanel jPanel133; private JPanel jPanel134; private JPanel jPanel135; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel154; private JPanel jPanel16; private JPanel jPanel165; private JPanel jPanel17; private JPanel jPanel172; private JPanel jPanel175; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel24; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel4; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel5; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel7; private JPanel jPanel74; private JPanel jPanel78; private JPanel jPanel8;
/*      */   private JPanel jPanel87;
/*      */   private JPanel jPanel9;
/*      */   
/*      */   private void initComponents() {
/*  357 */     this.cantidad = new JFormattedTextField();
/*  358 */     this.buttonGroup1 = new ButtonGroup();
/*  359 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  360 */     this.jScrollPane8 = new JScrollPane();
/*  361 */     this.jPanel67 = new JPanel();
/*  362 */     this.jPanel16 = new JPanel();
/*  363 */     this.jLabel26 = new JLabel();
/*  364 */     this.jTextField5 = new JTextField();
/*  365 */     this.jLabel53 = new JLabel();
/*  366 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  367 */     this.jLabel169 = new JLabel();
/*  368 */     this.jPanel103 = new JPanel();
/*  369 */     this.jTextField71 = new JTextField();
/*  370 */     this.jButton37 = new JButton();
/*  371 */     this.jPanel8 = new JPanel();
/*  372 */     this.jPanel55 = new JPanel();
/*  373 */     this.jLabel5 = new JLabel();
/*  374 */     this.jTextField14 = new JTextField();
/*  375 */     this.jLabel6 = new JLabel();
/*  376 */     this.jLabel3 = new JLabel();
/*  377 */     this.jComboBox4 = new JComboBox();
/*  378 */     this.jScrollPane5 = new JScrollPane();
/*  379 */     this.jTextArea1 = new JTextArea();
/*  380 */     this.jPanel18 = new JPanel();
/*  381 */     this.jPanel24 = new JPanel();
/*  382 */     this.jLabel55 = new JLabel();
/*  383 */     this.jTextField26 = new JTextField();
/*  384 */     this.jLabel56 = new JLabel();
/*  385 */     this.jTextField27 = new JTextField();
/*  386 */     this.jLabel57 = new JLabel();
/*  387 */     this.jTextField28 = new JTextField();
/*  388 */     this.jLabel58 = new JLabel();
/*  389 */     this.jTextField29 = new JTextField();
/*  390 */     this.jLabel42 = new JLabel();
/*  391 */     this.jTextField15 = new JTextField();
/*  392 */     this.jLabel44 = new JLabel();
/*  393 */     this.jLabel51 = new JLabel();
/*  394 */     this.jTextField16 = new JTextField();
/*  395 */     this.jTextField17 = new JTextField();
/*  396 */     this.jLabel52 = new JLabel();
/*  397 */     this.jTextField18 = new JTextField();
/*  398 */     this.jPanel53 = new JPanel();
/*  399 */     this.jLabel59 = new JLabel();
/*  400 */     this.jLabel60 = new JLabel();
/*  401 */     this.jTextField31 = new JTextField();
/*  402 */     this.jTextField30 = new JTextField();
/*  403 */     this.jLabel61 = new JLabel();
/*  404 */     this.jTextField32 = new JTextField();
/*  405 */     this.jPanel54 = new JPanel();
/*  406 */     this.jPanel56 = new JPanel();
/*  407 */     this.jLabel68 = new JLabel();
/*  408 */     this.jLabel69 = new JLabel();
/*  409 */     this.jPanel58 = new JPanel();
/*  410 */     this.jLabel64 = new JLabel();
/*  411 */     this.jPanel133 = new JPanel();
/*  412 */     this.jTextField85 = new JTextField();
/*  413 */     this.jButton55 = new JButton();
/*  414 */     this.jLabel63 = new JLabel();
/*  415 */     this.jComboBox18 = new JComboBox();
/*  416 */     this.jLabel67 = new JLabel();
/*  417 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  418 */     this.jLabel62 = new JLabel();
/*  419 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  420 */     this.jLabel70 = new JLabel();
/*  421 */     this.jPanel57 = new JPanel();
/*  422 */     this.jSpinner1 = new JSpinner();
/*  423 */     this.jSpinner2 = new JSpinner();
/*  424 */     this.jSpinner3 = new JSpinner();
/*  425 */     this.jLabel66 = new JLabel();
/*  426 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  427 */     this.jPanel127 = new JPanel();
/*  428 */     this.jButton49 = new JButton();
/*  429 */     this.jButton50 = new JButton();
/*  430 */     this.jButton51 = new JButton();
/*  431 */     this.jLabel192 = new JLabel();
/*  432 */     this.jScrollPane31 = new JScrollPane();
/*  433 */     this.rSTableMetro5 = new RSTableMetro();
/*  434 */     this.jPanel59 = new JPanel();
/*  435 */     this.jLabel194 = new JLabel();
/*  436 */     this.jButton52 = new JButton();
/*  437 */     this.jButton54 = new JButton();
/*  438 */     this.jButton53 = new JButton();
/*  439 */     this.jPanel12 = new JPanel();
/*  440 */     this.jLabel36 = new JLabel();
/*  441 */     this.jLabel37 = new JLabel();
/*  442 */     this.jLabel71 = new JLabel();
/*  443 */     this.jLabel38 = new JLabel();
/*  444 */     this.jLabel73 = new JLabel();
/*  445 */     this.jLabel40 = new JLabel();
/*  446 */     this.jLabel74 = new JLabel();
/*  447 */     this.jLabel65 = new JLabel();
/*  448 */     this.jLabel84 = new JLabel();
/*  449 */     this.jLabel85 = new JLabel();
/*  450 */     this.jScrollPane32 = new JScrollPane();
/*  451 */     this.rSTableMetro6 = new RSTableMetro();
/*  452 */     this.materialButton19 = new MaterialButton();
/*  453 */     this.materialButton20 = new MaterialButton();
/*  454 */     this.materialButton21 = new MaterialButton();
/*  455 */     this.materialButton22 = new MaterialButton();
/*  456 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  457 */     this.jPanel65 = new JPanel();
/*  458 */     this.jPanel66 = new JPanel();
/*  459 */     this.jLabel47 = new JLabel();
/*  460 */     this.jPanel87 = new JPanel();
/*  461 */     this.jLabel129 = new JLabel();
/*  462 */     this.jLabel54 = new JLabel();
/*  463 */     this.jPanel38 = new JPanel();
/*  464 */     this.jPanel43 = new JPanel();
/*  465 */     this.jLabel94 = new JLabel();
/*  466 */     this.jLabel96 = new JLabel();
/*  467 */     this.jPanel92 = new JPanel();
/*  468 */     this.jLabel97 = new JLabel();
/*  469 */     this.jLabel100 = new JLabel();
/*  470 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  471 */     this.jPanel29 = new JPanel();
/*  472 */     this.jLabel125 = new JLabel();
/*  473 */     this.jScrollPane18 = new JScrollPane();
/*  474 */     this.jTextArea5 = new JTextArea();
/*  475 */     this.materialButton36 = new MaterialButton();
/*  476 */     this.materialButton37 = new MaterialButton();
/*  477 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  478 */     this.jPanel6 = new JPanel();
/*  479 */     this.jPanel13 = new JPanel();
/*  480 */     this.jPanel14 = new JPanel();
/*  481 */     this.jLabel2 = new JLabel();
/*  482 */     this.jTextField8 = new JTextField();
/*  483 */     this.jPanel15 = new JPanel();
/*  484 */     this.jLabel7 = new JLabel();
/*  485 */     this.jTextField11 = new JTextField();
/*  486 */     this.jPanel19 = new JPanel();
/*  487 */     this.jLabel8 = new JLabel();
/*  488 */     this.jTextField12 = new JTextField();
/*  489 */     this.jScrollPane33 = new JScrollPane();
/*  490 */     this.rSTableMetro7 = new RSTableMetro();
/*  491 */     this.materialButton23 = new MaterialButton();
/*  492 */     this.materialButton24 = new MaterialButton();
/*  493 */     this.jLabel1 = new JLabel();
/*  494 */     this.jLabel4 = new JLabel();
/*  495 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  496 */     this.jPanel20 = new JPanel();
/*  497 */     this.jLabel9 = new JLabel();
/*  498 */     this.materialButton38 = new MaterialButton();
/*  499 */     this.jSeparator1 = new JSeparator();
/*  500 */     this.jPanel2 = new JPanel();
/*  501 */     this.jLabel75 = new JLabel();
/*  502 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  503 */     this.jLabel77 = new JLabel();
/*  504 */     this.jTextField4 = new JTextField();
/*  505 */     this.jLabel72 = new JLabel();
/*  506 */     this.jTextField2 = new JTextField();
/*  507 */     this.jLabel76 = new JLabel();
/*  508 */     this.jTextField3 = new JTextField();
/*  509 */     this.jLabel83 = new JLabel();
/*  510 */     this.jTextField6 = new JTextField();
/*  511 */     this.jLabel12 = new JLabel();
/*  512 */     this.jDialog11 = new CerrarVentana(this.padre);
/*  513 */     this.jPanel33 = new JPanel();
/*  514 */     this.jScrollPane19 = new JScrollPane();
/*  515 */     this.jTextArea6 = new JTextArea();
/*  516 */     this.jLabel130 = new JLabel();
/*  517 */     this.materialButton39 = new MaterialButton();
/*  518 */     this.jDialog12 = new CerrarVentana(this.padre);
/*  519 */     this.jPanel172 = new JPanel();
/*  520 */     this.materialButton40 = new MaterialButton();
/*  521 */     this.materialButton41 = new MaterialButton();
/*  522 */     this.jTextField24 = new JTextField();
/*  523 */     this.jDialog17 = new CerrarVentana(this.padre);
/*  524 */     this.jPanel134 = new JPanel();
/*  525 */     this.jScrollPane34 = new JScrollPane();
/*  526 */     this.rSTableMetro8 = new RSTableMetro();
/*  527 */     this.jDialog18 = new CerrarVentana(this.padre);
/*  528 */     this.jPanel135 = new JPanel();
/*  529 */     this.jLabel189 = new JLabel();
/*  530 */     this.jLabel193 = new JLabel();
/*  531 */     this.jTextField87 = new JTextField();
/*  532 */     this.jTextField88 = new JTextField();
/*  533 */     this.jSeparator4 = new JSeparator();
/*  534 */     this.materialButton42 = new MaterialButton();
/*  535 */     this.jPanel4 = new JPanel();
/*  536 */     this.jLabel11 = new JLabel();
/*  537 */     this.jComboBox10 = new JComboBox<>();
/*  538 */     this.jLabel18 = new JLabel();
/*  539 */     this.jPanel1 = new JPanel();
/*  540 */     this.jLabel233 = new JLabel();
/*  541 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  542 */     this.jLabel234 = new JLabel();
/*  543 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  544 */     this.jButton1 = new JButton();
/*  545 */     this.jLabel170 = new JLabel();
/*  546 */     this.jLabel101 = new JLabel();
/*  547 */     this.jLabel171 = new JLabel();
/*  548 */     this.jPanel3 = new JPanel();
/*  549 */     this.jLabel79 = new JLabel();
/*  550 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  551 */     this.jLabel80 = new JLabel();
/*  552 */     this.jFormattedTextField8 = new JFormattedTextField();
/*  553 */     this.jLabel81 = new JLabel();
/*  554 */     this.jFormattedTextField9 = new JFormattedTextField();
/*  555 */     this.jLabel82 = new JLabel();
/*  556 */     this.jFormattedTextField10 = new JFormattedTextField();
/*  557 */     this.jDialog37 = new CerrarVentana(this.padre);
/*  558 */     this.jPanel45 = new JPanel();
/*  559 */     this.jPanel44 = new JPanel();
/*  560 */     this.jScrollPane25 = new JScrollPane();
/*  561 */     this.rSTableMetro20 = new RSTableMetro();
/*  562 */     this.jPanel78 = new JPanel();
/*  563 */     this.jLabel244 = new JLabel();
/*  564 */     this.jComboBox41 = new JComboBox<>();
/*  565 */     this.jComboBox40 = new JComboBox<>();
/*  566 */     this.jPanel74 = new JPanel();
/*  567 */     this.jDateChooser14 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  568 */     this.jLabel241 = new JLabel();
/*  569 */     this.jDateChooser15 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  570 */     this.jButton29 = new JButton();
/*  571 */     this.jDialog13 = new CerrarVentana(this.padre);
/*  572 */     this.jPanel9 = new JPanel();
/*  573 */     this.jScrollPane20 = new JScrollPane();
/*  574 */     this.rSTableMetro9 = new RSTableMetro();
/*  575 */     this.jDialog22 = new CerrarVentana(this.padre);
/*  576 */     this.jPanel165 = new JPanel();
/*  577 */     this.jPanel10 = new JPanel();
/*  578 */     this.jLabel196 = new JLabel();
/*  579 */     this.jTextField91 = new JTextField();
/*  580 */     this.jLabel225 = new JLabel();
/*  581 */     this.jTextField98 = new JTextField();
/*  582 */     this.jButton2 = new JButton();
/*  583 */     this.jTextField104 = new JTextField();
/*  584 */     this.jLabel237 = new JLabel();
/*  585 */     this.materialButton26 = new MaterialButton();
/*  586 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  587 */     this.jPanel154 = new JPanel();
/*  588 */     this.jLabel45 = new JLabel();
/*  589 */     this.jLabel46 = new JLabel();
/*  590 */     this.jScrollPane41 = new JScrollPane();
/*  591 */     this.rSTableMetro22 = new RSTableMetro();
/*  592 */     this.jPanel175 = new JPanel();
/*  593 */     this.jLabel242 = new JLabel();
/*  594 */     this.jLabel86 = new JLabel();
/*  595 */     this.jButton62 = new JButton();
/*  596 */     this.jPanel21 = new JPanel();
/*  597 */     this.jPanel22 = new JPanel();
/*  598 */     this.jLabel78 = new JLabel();
/*  599 */     this.jPanel52 = new JPanel();
/*  600 */     this.jPanel60 = new JPanel();
/*  601 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  602 */     this.jLabel235 = new JLabel();
/*  603 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  604 */     this.jComboBox36 = new JComboBox<>();
/*  605 */     this.jPanel62 = new JPanel();
/*  606 */     this.jLabel236 = new JLabel();
/*  607 */     this.jComboBox37 = new JComboBox<>();
/*  608 */     this.jPanel63 = new JPanel();
/*  609 */     this.jButton16 = new JButton();
/*  610 */     this.jLabel172 = new JLabel();
/*  611 */     this.jLabel103 = new JLabel();
/*  612 */     this.jLabel173 = new JLabel();
/*  613 */     this.jPanel34 = new JPanel();
/*  614 */     this.jPanel17 = new JPanel();
/*  615 */     this.jTextField1 = new JTextField();
/*  616 */     this.jComboBox1 = new JComboBox();
/*  617 */     this.jComboBox2 = new JComboBox();
/*  618 */     this.jComboBox6 = new JComboBox();
/*  619 */     this.jComboBox3 = new JComboBox();
/*  620 */     this.jPanel35 = new JPanel();
/*  621 */     this.jPanel36 = new JPanel();
/*  622 */     this.jPanel37 = new JPanel();
/*  623 */     this.jLabel10 = new JLabel();
/*  624 */     this.jLabel48 = new JLabel();
/*  625 */     this.jButton24 = new JButton();
/*  626 */     this.jButton60 = new JButton();
/*  627 */     this.jButton25 = new JButton();
/*  628 */     this.jButton23 = new JButton();
/*  629 */     this.jButton26 = new JButton();
/*  630 */     this.jButton27 = new JButton();
/*  631 */     this.jButton20 = new JButton();
/*  632 */     this.jPanel5 = new JPanel();
/*  633 */     this.jScrollPane29 = new JScrollPane();
/*  634 */     this.rSTableMetro1 = new RSTableMetro();
/*  635 */     this.jPanel7 = new JPanel();
/*  636 */     this.jLabel35 = new JLabel();
/*  637 */     this.jLabel31 = new JLabel();
/*  638 */     this.jLabel43 = new JLabel();
/*  639 */     this.jLabel34 = new JLabel();
/*  640 */     this.jLabel39 = new JLabel();
/*  641 */     this.jLabel32 = new JLabel();
/*  642 */     this.jLabel41 = new JLabel();
/*  643 */     this.jLabel33 = new JLabel();
/*      */     
/*  645 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/*  647 */     this.jDialog1.setTitle("Crear Nuevo");
/*  648 */     this.jDialog1.setModal(true);
/*      */     
/*  650 */     this.jPanel16.setLayout(new GridLayout(1, 6, 12, 0));
/*      */     
/*  652 */     this.jLabel26.setFont(new Font("Cantarell", 1, 11));
/*  653 */     this.jLabel26.setHorizontalAlignment(4);
/*  654 */     this.jLabel26.setText("Folio:");
/*  655 */     this.jPanel16.add(this.jLabel26);
/*      */     
/*  657 */     this.jTextField5.setEditable(false);
/*  658 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  660 */             complementoPagos.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  663 */     this.jPanel16.add(this.jTextField5);
/*      */     
/*  665 */     this.jLabel53.setFont(new Font("Cantarell", 1, 11));
/*  666 */     this.jLabel53.setHorizontalAlignment(4);
/*  667 */     this.jLabel53.setText("Fecha:");
/*  668 */     this.jPanel16.add(this.jLabel53);
/*      */     
/*  670 */     this.jDateChooser8.setDate(this.fechaActual);
/*  671 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/*  672 */     this.jDateChooser8.setEnabled(false);
/*  673 */     this.jDateChooser8.setIcon(this.icon);
/*  674 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/*  675 */     this.jDateChooser8.setMinSelectableDate(this.fechaInicio);
/*  676 */     this.jPanel16.add((Component)this.jDateChooser8);
/*      */     
/*  678 */     this.jLabel169.setFont(new Font("Cantarell", 1, 11));
/*  679 */     this.jLabel169.setHorizontalAlignment(4);
/*  680 */     this.jLabel169.setText("Uso del CFDI:");
/*  681 */     this.jPanel16.add(this.jLabel169);
/*      */     
/*  683 */     this.jTextField71.setEditable(false);
/*      */     
/*  685 */     this.jButton37.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  686 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  688 */             complementoPagos.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  692 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/*  693 */     this.jPanel103.setLayout(jPanel103Layout);
/*  694 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/*  695 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  696 */         .addGroup(jPanel103Layout.createSequentialGroup()
/*  697 */           .addComponent(this.jTextField71)
/*  698 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  699 */           .addComponent(this.jButton37, -2, 19, -2)));
/*      */     
/*  701 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/*  702 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  703 */         .addGroup(jPanel103Layout.createSequentialGroup()
/*  704 */           .addGroup(jPanel103Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  705 */             .addComponent(this.jButton37, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/*  706 */             .addComponent(this.jTextField71, GroupLayout.Alignment.LEADING))
/*  707 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  710 */     this.jPanel16.add(this.jPanel103);
/*      */     
/*  712 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Información del Cliente", 0, 0, new Font("Cantarell", 0, 11)));
/*      */     
/*  714 */     GridBagLayout jPanel55Layout = new GridBagLayout();
/*  715 */     jPanel55Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  716 */     jPanel55Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/*  717 */     this.jPanel55.setLayout(jPanel55Layout);
/*      */     
/*  719 */     this.jLabel5.setFont(new Font("Cantarell", 1, 11));
/*  720 */     this.jLabel5.setText("R.F.C.");
/*  721 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  722 */     gridBagConstraints.gridx = 0;
/*  723 */     gridBagConstraints.gridy = 2;
/*  724 */     gridBagConstraints.anchor = 21;
/*  725 */     this.jPanel55.add(this.jLabel5, gridBagConstraints);
/*      */     
/*  727 */     this.jTextField14.setEditable(false);
/*  728 */     this.jTextField14.setText("jTextField14");
/*  729 */     gridBagConstraints = new GridBagConstraints();
/*  730 */     gridBagConstraints.gridx = 2;
/*  731 */     gridBagConstraints.gridy = 2;
/*  732 */     gridBagConstraints.gridwidth = 9;
/*  733 */     gridBagConstraints.fill = 2;
/*  734 */     gridBagConstraints.ipadx = 1;
/*  735 */     gridBagConstraints.anchor = 256;
/*  736 */     gridBagConstraints.weightx = 1.0D;
/*  737 */     this.jPanel55.add(this.jTextField14, gridBagConstraints);
/*      */     
/*  739 */     this.jLabel6.setFont(new Font("Cantarell", 0, 11));
/*  740 */     this.jLabel6.setText("Información ");
/*  741 */     gridBagConstraints = new GridBagConstraints();
/*  742 */     gridBagConstraints.gridx = 0;
/*  743 */     gridBagConstraints.gridy = 4;
/*  744 */     gridBagConstraints.anchor = 21;
/*  745 */     this.jPanel55.add(this.jLabel6, gridBagConstraints);
/*      */     
/*  747 */     this.jLabel3.setFont(new Font("Cantarell", 1, 11));
/*  748 */     this.jLabel3.setText("Cliente:");
/*  749 */     gridBagConstraints = new GridBagConstraints();
/*  750 */     gridBagConstraints.gridx = 0;
/*  751 */     gridBagConstraints.gridy = 0;
/*  752 */     gridBagConstraints.anchor = 21;
/*  753 */     this.jPanel55.add(this.jLabel3, gridBagConstraints);
/*      */     
/*  755 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  756 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  758 */             complementoPagos.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  761 */     gridBagConstraints = new GridBagConstraints();
/*  762 */     gridBagConstraints.gridx = 2;
/*  763 */     gridBagConstraints.gridy = 0;
/*  764 */     gridBagConstraints.gridwidth = 9;
/*  765 */     gridBagConstraints.fill = 2;
/*  766 */     this.jPanel55.add(this.jComboBox4, gridBagConstraints);
/*      */     
/*  768 */     this.jTextArea1.setEditable(false);
/*  769 */     this.jTextArea1.setColumns(20);
/*  770 */     this.jTextArea1.setFont(new Font("Cantarell", 0, 11));
/*  771 */     this.jTextArea1.setLineWrap(true);
/*  772 */     this.jTextArea1.setRows(3);
/*  773 */     this.jScrollPane5.setViewportView(this.jTextArea1);
/*      */     
/*  775 */     gridBagConstraints = new GridBagConstraints();
/*  776 */     gridBagConstraints.gridx = 2;
/*  777 */     gridBagConstraints.gridy = 4;
/*  778 */     gridBagConstraints.gridwidth = 9;
/*  779 */     gridBagConstraints.fill = 1;
/*  780 */     gridBagConstraints.weighty = 1.0D;
/*  781 */     this.jPanel55.add(this.jScrollPane5, gridBagConstraints);
/*      */     
/*  783 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  784 */     this.jPanel8.setLayout(jPanel8Layout);
/*  785 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  786 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  787 */         .addComponent(this.jPanel55, -2, 813, -2));
/*      */     
/*  789 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  791 */         .addComponent(this.jPanel55, -2, -1, -2));
/*      */ 
/*      */     
/*  794 */     this.jPanel18.setLayout(new GridLayout(1, 2, 20, 0));
/*      */     
/*  796 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Datos del ordenante (Cliente)", 0, 0, new Font("Cantarell", 0, 11)));
/*  797 */     GridBagLayout jPanel24Layout = new GridBagLayout();
/*  798 */     jPanel24Layout.columnWidths = new int[] { 0, 5, 0 };
/*  799 */     jPanel24Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  800 */     this.jPanel24.setLayout(jPanel24Layout);
/*      */     
/*  802 */     this.jLabel55.setFont(new Font("Cantarell", 0, 11));
/*  803 */     this.jLabel55.setText("Núm. de Operación");
/*  804 */     gridBagConstraints = new GridBagConstraints();
/*  805 */     gridBagConstraints.gridx = 0;
/*  806 */     gridBagConstraints.gridy = 6;
/*  807 */     gridBagConstraints.anchor = 21;
/*  808 */     this.jPanel24.add(this.jLabel55, gridBagConstraints);
/*      */     
/*  810 */     this.jTextField26.setText("jTextField26");
/*  811 */     gridBagConstraints = new GridBagConstraints();
/*  812 */     gridBagConstraints.gridx = 2;
/*  813 */     gridBagConstraints.gridy = 6;
/*  814 */     gridBagConstraints.fill = 2;
/*  815 */     gridBagConstraints.weightx = 1.0D;
/*  816 */     this.jPanel24.add(this.jTextField26, gridBagConstraints);
/*      */     
/*  818 */     this.jLabel56.setFont(new Font("Cantarell", 0, 11));
/*  819 */     this.jLabel56.setText("RFC Banco Emisor");
/*  820 */     gridBagConstraints = new GridBagConstraints();
/*  821 */     gridBagConstraints.gridx = 0;
/*  822 */     gridBagConstraints.gridy = 2;
/*  823 */     gridBagConstraints.anchor = 21;
/*  824 */     this.jPanel24.add(this.jLabel56, gridBagConstraints);
/*      */     
/*  826 */     this.jTextField27.setText("jTextField27");
/*  827 */     gridBagConstraints = new GridBagConstraints();
/*  828 */     gridBagConstraints.gridx = 2;
/*  829 */     gridBagConstraints.gridy = 2;
/*  830 */     gridBagConstraints.fill = 2;
/*  831 */     gridBagConstraints.weightx = 1.0D;
/*  832 */     this.jPanel24.add(this.jTextField27, gridBagConstraints);
/*      */     
/*  834 */     this.jLabel57.setFont(new Font("Cantarell", 0, 11));
/*  835 */     this.jLabel57.setText("Nombre del Banco Emisor");
/*  836 */     gridBagConstraints = new GridBagConstraints();
/*  837 */     gridBagConstraints.gridx = 0;
/*  838 */     gridBagConstraints.gridy = 0;
/*  839 */     gridBagConstraints.anchor = 21;
/*  840 */     this.jPanel24.add(this.jLabel57, gridBagConstraints);
/*      */     
/*  842 */     this.jTextField28.setText("jTextField28");
/*  843 */     gridBagConstraints = new GridBagConstraints();
/*  844 */     gridBagConstraints.gridx = 2;
/*  845 */     gridBagConstraints.gridy = 0;
/*  846 */     gridBagConstraints.fill = 2;
/*  847 */     gridBagConstraints.weightx = 1.0D;
/*  848 */     this.jPanel24.add(this.jTextField28, gridBagConstraints);
/*      */     
/*  850 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/*  851 */     this.jLabel58.setText("Cta. Banco Emisor");
/*  852 */     gridBagConstraints = new GridBagConstraints();
/*  853 */     gridBagConstraints.gridx = 0;
/*  854 */     gridBagConstraints.gridy = 4;
/*  855 */     gridBagConstraints.anchor = 21;
/*  856 */     this.jPanel24.add(this.jLabel58, gridBagConstraints);
/*      */     
/*  858 */     this.jTextField29.setText("jTextField29");
/*  859 */     gridBagConstraints = new GridBagConstraints();
/*  860 */     gridBagConstraints.gridx = 2;
/*  861 */     gridBagConstraints.gridy = 4;
/*  862 */     gridBagConstraints.fill = 2;
/*  863 */     gridBagConstraints.weightx = 1.0D;
/*  864 */     this.jPanel24.add(this.jTextField29, gridBagConstraints);
/*      */     
/*  866 */     this.jLabel42.setFont(new Font("Cantarell", 0, 11));
/*  867 */     this.jLabel42.setText("Cadena de Pago");
/*  868 */     gridBagConstraints = new GridBagConstraints();
/*  869 */     gridBagConstraints.gridx = 0;
/*  870 */     gridBagConstraints.gridy = 8;
/*  871 */     gridBagConstraints.anchor = 21;
/*  872 */     this.jPanel24.add(this.jLabel42, gridBagConstraints);
/*      */     
/*  874 */     this.jTextField15.setText("jTextField15");
/*  875 */     gridBagConstraints = new GridBagConstraints();
/*  876 */     gridBagConstraints.gridx = 2;
/*  877 */     gridBagConstraints.gridy = 8;
/*  878 */     gridBagConstraints.fill = 2;
/*  879 */     this.jPanel24.add(this.jTextField15, gridBagConstraints);
/*      */     
/*  881 */     this.jLabel44.setFont(new Font("Cantarell", 0, 11));
/*  882 */     this.jLabel44.setText("Tipo de Cadena");
/*  883 */     gridBagConstraints = new GridBagConstraints();
/*  884 */     gridBagConstraints.gridx = 0;
/*  885 */     gridBagConstraints.gridy = 10;
/*  886 */     gridBagConstraints.anchor = 21;
/*  887 */     this.jPanel24.add(this.jLabel44, gridBagConstraints);
/*      */     
/*  889 */     this.jLabel51.setFont(new Font("Cantarell", 0, 11));
/*  890 */     this.jLabel51.setText("Certificado de pago");
/*  891 */     gridBagConstraints = new GridBagConstraints();
/*  892 */     gridBagConstraints.gridx = 0;
/*  893 */     gridBagConstraints.gridy = 12;
/*  894 */     gridBagConstraints.anchor = 21;
/*  895 */     this.jPanel24.add(this.jLabel51, gridBagConstraints);
/*      */     
/*  897 */     this.jTextField16.setText("jTextField16");
/*  898 */     gridBagConstraints = new GridBagConstraints();
/*  899 */     gridBagConstraints.gridx = 2;
/*  900 */     gridBagConstraints.gridy = 10;
/*  901 */     gridBagConstraints.fill = 2;
/*  902 */     this.jPanel24.add(this.jTextField16, gridBagConstraints);
/*      */     
/*  904 */     this.jTextField17.setText("jTextField17");
/*  905 */     gridBagConstraints = new GridBagConstraints();
/*  906 */     gridBagConstraints.gridx = 2;
/*  907 */     gridBagConstraints.gridy = 12;
/*  908 */     gridBagConstraints.fill = 2;
/*  909 */     this.jPanel24.add(this.jTextField17, gridBagConstraints);
/*      */     
/*  911 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/*  912 */     this.jLabel52.setText("Sello de pago");
/*  913 */     gridBagConstraints = new GridBagConstraints();
/*  914 */     gridBagConstraints.gridx = 0;
/*  915 */     gridBagConstraints.gridy = 14;
/*  916 */     gridBagConstraints.anchor = 21;
/*  917 */     this.jPanel24.add(this.jLabel52, gridBagConstraints);
/*      */     
/*  919 */     this.jTextField18.setText("jTextField18");
/*  920 */     gridBagConstraints = new GridBagConstraints();
/*  921 */     gridBagConstraints.gridx = 2;
/*  922 */     gridBagConstraints.gridy = 14;
/*  923 */     gridBagConstraints.fill = 2;
/*  924 */     this.jPanel24.add(this.jTextField18, gridBagConstraints);
/*      */     
/*  926 */     this.jPanel18.add(this.jPanel24);
/*      */     
/*  928 */     this.jPanel53.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Datos del Emisor (Forsis)", 0, 0, new Font("Cantarell", 0, 11)));
/*  929 */     GridBagLayout jPanel53Layout = new GridBagLayout();
/*  930 */     jPanel53Layout.columnWidths = new int[] { 0, 5, 0 };
/*  931 */     jPanel53Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/*  932 */     this.jPanel53.setLayout(jPanel53Layout);
/*      */     
/*  934 */     this.jLabel59.setFont(new Font("Cantarell", 0, 11));
/*  935 */     this.jLabel59.setText("RFC Banco Receptor");
/*  936 */     gridBagConstraints = new GridBagConstraints();
/*  937 */     gridBagConstraints.gridx = 0;
/*  938 */     gridBagConstraints.gridy = 2;
/*  939 */     gridBagConstraints.anchor = 22;
/*  940 */     this.jPanel53.add(this.jLabel59, gridBagConstraints);
/*      */     
/*  942 */     this.jLabel60.setFont(new Font("Cantarell", 1, 11));
/*  943 */     this.jLabel60.setText("Cta. Banco Receptor");
/*  944 */     gridBagConstraints = new GridBagConstraints();
/*  945 */     gridBagConstraints.gridx = 0;
/*  946 */     gridBagConstraints.gridy = 4;
/*  947 */     gridBagConstraints.anchor = 22;
/*  948 */     this.jPanel53.add(this.jLabel60, gridBagConstraints);
/*      */     
/*  950 */     this.jTextField31.setText("jTextField31");
/*  951 */     gridBagConstraints = new GridBagConstraints();
/*  952 */     gridBagConstraints.gridx = 2;
/*  953 */     gridBagConstraints.gridy = 4;
/*  954 */     gridBagConstraints.fill = 2;
/*  955 */     gridBagConstraints.weightx = 1.0D;
/*  956 */     this.jPanel53.add(this.jTextField31, gridBagConstraints);
/*      */     
/*  958 */     this.jTextField30.setText("jTextField30");
/*  959 */     gridBagConstraints = new GridBagConstraints();
/*  960 */     gridBagConstraints.gridx = 2;
/*  961 */     gridBagConstraints.gridy = 2;
/*  962 */     gridBagConstraints.fill = 2;
/*  963 */     gridBagConstraints.weightx = 1.0D;
/*  964 */     this.jPanel53.add(this.jTextField30, gridBagConstraints);
/*      */     
/*  966 */     this.jLabel61.setFont(new Font("Cantarell", 0, 11));
/*  967 */     this.jLabel61.setText("Nombre del Banco Receptor");
/*  968 */     gridBagConstraints = new GridBagConstraints();
/*  969 */     gridBagConstraints.gridx = 0;
/*  970 */     gridBagConstraints.gridy = 0;
/*  971 */     gridBagConstraints.anchor = 21;
/*  972 */     this.jPanel53.add(this.jLabel61, gridBagConstraints);
/*      */     
/*  974 */     this.jTextField32.setText("jTextField32");
/*  975 */     gridBagConstraints = new GridBagConstraints();
/*  976 */     gridBagConstraints.gridx = 2;
/*  977 */     gridBagConstraints.gridy = 0;
/*  978 */     gridBagConstraints.fill = 2;
/*  979 */     gridBagConstraints.weightx = 1.0D;
/*  980 */     this.jPanel53.add(this.jTextField32, gridBagConstraints);
/*      */     
/*  982 */     this.jPanel18.add(this.jPanel53);
/*      */     
/*  984 */     this.jPanel54.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Datos del depósito", 0, 0, new Font("Dialog", 0, 11)));
/*      */     
/*  986 */     this.jLabel68.setFont(new Font("Cantarell", 1, 11));
/*  987 */     this.jLabel68.setText("Cantidad en Letra");
/*      */     
/*  989 */     this.jLabel69.setText("Ochociento");
/*  990 */     this.jLabel69.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  992 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/*  993 */     this.jPanel56.setLayout(jPanel56Layout);
/*  994 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/*  995 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  996 */         .addGroup(jPanel56Layout.createSequentialGroup()
/*  997 */           .addComponent(this.jLabel68, -2, 134, -2)
/*  998 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  999 */           .addComponent(this.jLabel69, -1, 673, 32767)));
/*      */     
/* 1001 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/* 1002 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1003 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
/* 1004 */           .addContainerGap(-1, 32767)
/* 1005 */           .addGroup(jPanel56Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1006 */             .addComponent(this.jLabel68)
/* 1007 */             .addComponent(this.jLabel69))
/* 1008 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1011 */     this.jPanel58.setLayout(new GridLayout(2, 6, 6, 6));
/*      */     
/* 1013 */     this.jLabel64.setFont(new Font("Cantarell", 1, 11));
/* 1014 */     this.jLabel64.setText("Moneda");
/* 1015 */     this.jPanel58.add(this.jLabel64);
/*      */     
/* 1017 */     this.jTextField85.setEditable(false);
/*      */     
/* 1019 */     this.jButton55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1020 */     this.jButton55.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1022 */             complementoPagos.this.jButton55ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1026 */     GroupLayout jPanel133Layout = new GroupLayout(this.jPanel133);
/* 1027 */     this.jPanel133.setLayout(jPanel133Layout);
/* 1028 */     jPanel133Layout.setHorizontalGroup(jPanel133Layout
/* 1029 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1030 */         .addGroup(jPanel133Layout.createSequentialGroup()
/* 1031 */           .addComponent(this.jTextField85)
/* 1032 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1033 */           .addComponent(this.jButton55, -2, 18, -2)));
/*      */     
/* 1035 */     jPanel133Layout.setVerticalGroup(jPanel133Layout
/* 1036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1037 */         .addGroup(jPanel133Layout.createSequentialGroup()
/* 1038 */           .addGroup(jPanel133Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1039 */             .addComponent(this.jTextField85)
/* 1040 */             .addComponent(this.jButton55, -2, 0, 32767))
/* 1041 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1044 */     this.jPanel58.add(this.jPanel133);
/*      */     
/* 1046 */     this.jLabel63.setFont(new Font("Cantarell", 1, 11));
/* 1047 */     this.jLabel63.setHorizontalAlignment(4);
/* 1048 */     this.jLabel63.setText("Forma de pago");
/* 1049 */     this.jPanel58.add(this.jLabel63);
/*      */     
/* 1051 */     this.jComboBox18.setBackground(new Color(244, 244, 244));
/* 1052 */     this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "01.- EFECTIVO", "02.- CHEQUE NOMINATIVO", "03.- TRANSFERENCIA ELECTRONICA DE FONDOS", "04.- TARJETA DE CREDITO", "05.- MONEDERO ELECTRONICO", "06.- DINERO ELECTRONICO", "08.- VALES DE DESPENSA", "17.- COMPENSACION", "28.- TARJETA DE DEBITO", "29.- TARJETA DE SERVICIO", "30.- APLICACION DE ANTICIPOS", "99.- POR DEFINIR" }));
/* 1053 */     this.jComboBox18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1055 */             complementoPagos.this.jComboBox18ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1058 */     this.jPanel58.add(this.jComboBox18);
/*      */     
/* 1060 */     this.jLabel67.setFont(new Font("Cantarell", 1, 11));
/* 1061 */     this.jLabel67.setHorizontalAlignment(4);
/* 1062 */     this.jLabel67.setText("Cantidad");
/* 1063 */     this.jPanel58.add(this.jLabel67);
/*      */     
/* 1065 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/* 1066 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/* 1067 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1069 */             complementoPagos.this.jFormattedTextField4FocusLost(evt);
/*      */           }
/*      */         });
/* 1072 */     this.jFormattedTextField4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1074 */             complementoPagos.this.jFormattedTextField4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1077 */     this.jPanel58.add(this.jFormattedTextField4);
/*      */     
/* 1079 */     this.jLabel62.setFont(new Font("Cantarell", 1, 11));
/* 1080 */     this.jLabel62.setText("Fecha del depósito");
/* 1081 */     this.jPanel58.add(this.jLabel62);
/*      */     
/* 1083 */     this.jDateChooser1.setDate(this.fechaActual);
/* 1084 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/* 1085 */     this.jDateChooser1.setEnabled(false);
/* 1086 */     this.jDateChooser1.setIcon(this.icon);
/* 1087 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/* 1088 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/* 1089 */     this.jDateChooser1.addPropertyChangeListener(new PropertyChangeListener() {
/*      */           public void propertyChange(PropertyChangeEvent evt) {
/* 1091 */             complementoPagos.this.jDateChooser1PropertyChange(evt);
/*      */           }
/*      */         });
/* 1094 */     this.jPanel58.add((Component)this.jDateChooser1);
/*      */     
/* 1096 */     this.jLabel70.setFont(new Font("Cantarell", 1, 11));
/* 1097 */     this.jLabel70.setHorizontalAlignment(4);
/* 1098 */     this.jLabel70.setText("Hora del depósito");
/* 1099 */     this.jPanel58.add(this.jLabel70);
/*      */     
/* 1101 */     this.jPanel57.setLayout(new GridLayout(1, 3));
/*      */     
/* 1103 */     this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
/* 1104 */     this.jPanel57.add(this.jSpinner1);
/*      */     
/* 1106 */     this.jSpinner2.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
/* 1107 */     this.jPanel57.add(this.jSpinner2);
/*      */     
/* 1109 */     this.jSpinner3.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
/* 1110 */     this.jPanel57.add(this.jSpinner3);
/*      */     
/* 1112 */     this.jPanel58.add(this.jPanel57);
/*      */     
/* 1114 */     this.jLabel66.setFont(new Font("Cantarell", 1, 11));
/* 1115 */     this.jLabel66.setHorizontalAlignment(4);
/* 1116 */     this.jLabel66.setText("<html><u>Tipo de Cambio</u></html>");
/* 1117 */     this.jLabel66.setToolTipText("Clic para ver el catálogo de Tipos de Cambio");
/* 1118 */     this.jLabel66.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1120 */             complementoPagos.this.jLabel66MouseClicked(evt);
/*      */           }
/*      */         });
/* 1123 */     this.jPanel58.add(this.jLabel66);
/*      */     
/* 1125 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.####"))));
/* 1126 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 1127 */     this.jFormattedTextField1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1129 */             complementoPagos.this.jFormattedTextField1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1132 */     this.jPanel58.add(this.jFormattedTextField1);
/*      */     
/* 1134 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/* 1135 */     this.jPanel54.setLayout(jPanel54Layout);
/* 1136 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/* 1137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */         .addComponent(this.jPanel56, -1, -1, 32767)
/* 1139 */         .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1140 */           .addComponent(this.jPanel58, -2, 664, 32767)));
/*      */     
/* 1142 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/* 1143 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1144 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
/* 1145 */           .addGap(0, 58, 32767)
/* 1146 */           .addComponent(this.jPanel56, -2, -1, -2))
/* 1147 */         .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1148 */           .addGroup(jPanel54Layout.createSequentialGroup()
/* 1149 */             .addComponent(this.jPanel58, -2, -1, -2)
/* 1150 */             .addGap(0, 25, 32767))));
/*      */ 
/*      */     
/* 1153 */     this.jPanel127.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Comentarios adicionales", 0, 0, new Font("Cantarell", 0, 11)));
/*      */     
/* 1155 */     this.jButton49.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1156 */     this.jButton49.setToolTipText("Agregar");
/* 1157 */     this.jButton49.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1159 */             complementoPagos.this.jButton49ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1163 */     this.jButton50.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1164 */     this.jButton50.setToolTipText("Modificar");
/* 1165 */     this.jButton50.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1167 */             complementoPagos.this.jButton50ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1171 */     this.jButton51.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 1172 */     this.jButton51.setToolTipText("Eliminar");
/* 1173 */     this.jButton51.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1175 */             complementoPagos.this.jButton51ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1179 */     this.jLabel192.setFont(new Font("Cantarell", 1, 11));
/* 1180 */     this.jLabel192.setForeground(this.lc.PRIMARIO1);
/* 1181 */     this.jLabel192.setText("jLabel192");
/*      */     
/* 1183 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1191 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1196 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1199 */     this.rSTableMetro5.setAltoHead(25);
/* 1200 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1201 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/* 1202 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/* 1203 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1204 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/* 1205 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/* 1206 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/* 1207 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1208 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1209 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1210 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/* 1211 */     this.rSTableMetro5.setRowHeight(18);
/* 1212 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/* 1213 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/* 1214 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/* 1215 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1217 */             complementoPagos.this.rSTableMetro5MouseClicked(evt);
/*      */           }
/*      */         });
/* 1220 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1222 */             complementoPagos.this.rSTableMetro5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1225 */     this.jScrollPane31.setViewportView((Component)this.rSTableMetro5);
/*      */     
/* 1227 */     GroupLayout jPanel127Layout = new GroupLayout(this.jPanel127);
/* 1228 */     this.jPanel127.setLayout(jPanel127Layout);
/* 1229 */     jPanel127Layout.setHorizontalGroup(jPanel127Layout
/* 1230 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1231 */         .addGroup(jPanel127Layout.createSequentialGroup()
/* 1232 */           .addContainerGap()
/* 1233 */           .addComponent(this.jLabel192, -2, 395, -2)
/* 1234 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1235 */           .addComponent(this.jButton49)
/* 1236 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1237 */           .addComponent(this.jButton50)
/* 1238 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1239 */           .addComponent(this.jButton51))
/* 1240 */         .addComponent(this.jScrollPane31, GroupLayout.Alignment.TRAILING, -2, 813, -2));
/*      */     
/* 1242 */     jPanel127Layout.setVerticalGroup(jPanel127Layout
/* 1243 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1244 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel127Layout.createSequentialGroup()
/* 1245 */           .addGroup(jPanel127Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1246 */             .addComponent(this.jButton49, -2, 26, -2)
/* 1247 */             .addComponent(this.jButton50, -2, 26, -2)
/* 1248 */             .addComponent(this.jButton51, -2, 26, -2)
/* 1249 */             .addComponent(this.jLabel192, GroupLayout.Alignment.TRAILING))
/* 1250 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1251 */           .addComponent(this.jScrollPane31, -1, 134, 32767)));
/*      */ 
/*      */     
/* 1254 */     this.jPanel59.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "CFDI Relacionados", 0, 0, new Font("Cantarell", 0, 11)));
/*      */     
/* 1256 */     this.jLabel194.setFont(new Font("Cantarell", 1, 11));
/* 1257 */     this.jLabel194.setForeground(this.lc.PRIMARIO1);
/* 1258 */     this.jLabel194.setText("jLabel194");
/*      */     
/* 1260 */     this.jButton52.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1261 */     this.jButton52.setToolTipText("Agregar");
/* 1262 */     this.jButton52.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1264 */             complementoPagos.this.jButton52ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1268 */     this.jButton54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1269 */     this.jButton54.setToolTipText("Modificar");
/* 1270 */     this.jButton54.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1272 */             complementoPagos.this.jButton54ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1276 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 1277 */     this.jButton53.setToolTipText("Eliminar");
/* 1278 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1280 */             complementoPagos.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1284 */     this.jPanel12.setBorder(BorderFactory.createBevelBorder(1));
/* 1285 */     this.jPanel12.setLayout(new GridLayout(1, 10, 6, 0));
/*      */     
/* 1287 */     this.jLabel36.setFont(new Font("Tahoma", 1, 11));
/* 1288 */     this.jLabel36.setHorizontalAlignment(4);
/* 1289 */     this.jLabel36.setText("Subtotal: ");
/* 1290 */     this.jPanel12.add(this.jLabel36);
/*      */     
/* 1292 */     this.jLabel37.setFont(new Font("Tahoma", 0, 10));
/* 1293 */     this.jLabel37.setHorizontalAlignment(2);
/* 1294 */     this.jLabel37.setText("jLabel37");
/* 1295 */     this.jPanel12.add(this.jLabel37);
/*      */     
/* 1297 */     this.jLabel71.setFont(new Font("Tahoma", 1, 11));
/* 1298 */     this.jLabel71.setHorizontalAlignment(4);
/* 1299 */     this.jLabel71.setText("IVA:");
/* 1300 */     this.jPanel12.add(this.jLabel71);
/*      */     
/* 1302 */     this.jLabel38.setFont(new Font("Tahoma", 0, 10));
/* 1303 */     this.jLabel38.setHorizontalAlignment(2);
/* 1304 */     this.jLabel38.setText("jLabel38");
/* 1305 */     this.jPanel12.add(this.jLabel38);
/*      */     
/* 1307 */     this.jLabel73.setFont(new Font("Tahoma", 1, 11));
/* 1308 */     this.jLabel73.setHorizontalAlignment(4);
/* 1309 */     this.jLabel73.setText("Retención: ");
/* 1310 */     this.jPanel12.add(this.jLabel73);
/*      */     
/* 1312 */     this.jLabel40.setFont(new Font("Tahoma", 0, 10));
/* 1313 */     this.jLabel40.setHorizontalAlignment(2);
/* 1314 */     this.jLabel40.setText("jLabel40");
/* 1315 */     this.jPanel12.add(this.jLabel40);
/*      */     
/* 1317 */     this.jLabel74.setFont(new Font("Tahoma", 1, 11));
/* 1318 */     this.jLabel74.setHorizontalAlignment(4);
/* 1319 */     this.jLabel74.setText("Saldos: ");
/* 1320 */     this.jPanel12.add(this.jLabel74);
/*      */     
/* 1322 */     this.jLabel65.setFont(new Font("Tahoma", 0, 10));
/* 1323 */     this.jLabel65.setHorizontalAlignment(2);
/* 1324 */     this.jLabel65.setText("jLabel65");
/* 1325 */     this.jPanel12.add(this.jLabel65);
/*      */     
/* 1327 */     this.jLabel84.setFont(new Font("Tahoma", 1, 11));
/* 1328 */     this.jLabel84.setHorizontalAlignment(4);
/* 1329 */     this.jLabel84.setText("Fluctuación: ");
/* 1330 */     this.jPanel12.add(this.jLabel84);
/*      */     
/* 1332 */     this.jLabel85.setFont(new Font("Tahoma", 0, 10));
/* 1333 */     this.jLabel85.setHorizontalAlignment(2);
/* 1334 */     this.jLabel85.setText("jLabel85");
/* 1335 */     this.jPanel12.add(this.jLabel85);
/*      */     
/* 1337 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1345 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1350 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1353 */     this.rSTableMetro6.setAltoHead(25);
/* 1354 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1355 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 1356 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 1357 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1358 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/* 1359 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/* 1360 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/* 1361 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1362 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1363 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1364 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 1365 */     this.rSTableMetro6.setRowHeight(18);
/* 1366 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 1367 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 1368 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 1369 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1371 */             complementoPagos.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1374 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1376 */             complementoPagos.this.rSTableMetro6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1379 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro6);
/*      */     
/* 1381 */     GroupLayout jPanel59Layout = new GroupLayout(this.jPanel59);
/* 1382 */     this.jPanel59.setLayout(jPanel59Layout);
/* 1383 */     jPanel59Layout.setHorizontalGroup(jPanel59Layout
/* 1384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1385 */         .addComponent(this.jPanel12, -2, 813, -2)
/* 1386 */         .addGroup(jPanel59Layout.createSequentialGroup()
/* 1387 */           .addContainerGap()
/* 1388 */           .addComponent(this.jLabel194, -2, 383, -2)
/* 1389 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1390 */           .addComponent(this.jButton52)
/* 1391 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1392 */           .addComponent(this.jButton54)
/* 1393 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1394 */           .addComponent(this.jButton53))
/* 1395 */         .addComponent(this.jScrollPane32, GroupLayout.Alignment.TRAILING, -2, 813, -2));
/*      */     
/* 1397 */     jPanel59Layout.setVerticalGroup(jPanel59Layout
/* 1398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1399 */         .addGroup(jPanel59Layout.createSequentialGroup()
/* 1400 */           .addGroup(jPanel59Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1401 */             .addComponent(this.jButton52, -2, 26, -2)
/* 1402 */             .addComponent(this.jButton54, -2, 26, -2)
/* 1403 */             .addComponent(this.jButton53, -2, 26, -2)
/* 1404 */             .addGroup(jPanel59Layout.createSequentialGroup()
/* 1405 */               .addContainerGap()
/* 1406 */               .addComponent(this.jLabel194)))
/* 1407 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1408 */           .addComponent(this.jScrollPane32, -1, 209, 32767)
/* 1409 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1410 */           .addComponent(this.jPanel12, -2, -1, -2)));
/*      */ 
/*      */     
/* 1413 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/* 1414 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 1415 */     this.materialButton19.setMnemonic('C');
/* 1416 */     this.materialButton19.setText("Cerrar");
/* 1417 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/* 1418 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 1419 */     this.materialButton19.setHorizontalTextPosition(0);
/* 1420 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1422 */             complementoPagos.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1426 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/* 1427 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 1428 */     this.materialButton20.setMnemonic('G');
/* 1429 */     this.materialButton20.setText("Guardar");
/* 1430 */     this.materialButton20.setToolTipText("Guardar (Alt+G)");
/* 1431 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 1432 */     this.materialButton20.setHorizontalTextPosition(0);
/* 1433 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1435 */             complementoPagos.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1439 */     this.materialButton21.setBackground(this.lc.PRIMARIO1);
/* 1440 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 1441 */     this.materialButton21.setMnemonic('T');
/* 1442 */     this.materialButton21.setText("Timbrar");
/* 1443 */     this.materialButton21.setToolTipText("Timbrar (Alt+T)");
/* 1444 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 1445 */     this.materialButton21.setHorizontalTextPosition(0);
/* 1446 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1448 */             complementoPagos.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1452 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/* 1453 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 1454 */     this.materialButton22.setText("Cancelado");
/* 1455 */     this.materialButton22.setToolTipText("Cancelado");
/* 1456 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 1457 */     this.materialButton22.setHorizontalTextPosition(0);
/* 1458 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1460 */             complementoPagos.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1464 */     GroupLayout jPanel67Layout = new GroupLayout(this.jPanel67);
/* 1465 */     this.jPanel67.setLayout(jPanel67Layout);
/* 1466 */     jPanel67Layout.setHorizontalGroup(jPanel67Layout
/* 1467 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1468 */         .addComponent(this.jPanel8, -2, -1, -2)
/* 1469 */         .addComponent(this.jPanel18, -2, 823, -2)
/* 1470 */         .addComponent(this.jPanel54, -2, -1, -2)
/* 1471 */         .addComponent(this.jPanel127, -2, -1, -2)
/* 1472 */         .addComponent(this.jPanel59, -2, -1, -2)
/* 1473 */         .addComponent(this.jPanel16, -2, 823, -2)
/* 1474 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
/* 1475 */           .addComponent((Component)this.materialButton21, -2, 150, -2)
/* 1476 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1477 */           .addComponent((Component)this.materialButton22, -2, 105, -2)
/* 1478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1479 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/* 1480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1481 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/* 1482 */           .addContainerGap()));
/*      */     
/* 1484 */     jPanel67Layout.setVerticalGroup(jPanel67Layout
/* 1485 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1486 */         .addGroup(jPanel67Layout.createSequentialGroup()
/* 1487 */           .addComponent(this.jPanel16, -2, -1, -2)
/* 1488 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1489 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 1490 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1491 */           .addComponent(this.jPanel18, -2, 268, -2)
/* 1492 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1493 */           .addComponent(this.jPanel54, -2, -1, -2)
/* 1494 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1495 */           .addComponent(this.jPanel127, -2, -1, -2)
/* 1496 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1497 */           .addComponent(this.jPanel59, -2, -1, -2)
/* 1498 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1499 */           .addGroup(jPanel67Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1500 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/* 1501 */             .addComponent((Component)this.materialButton20, -2, 38, -2)
/* 1502 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 1503 */             .addComponent((Component)this.materialButton22, -2, 38, -2))
/* 1504 */           .addContainerGap(41, 32767)));
/*      */ 
/*      */     
/* 1507 */     this.jScrollPane8.setViewportView(this.jPanel67);
/*      */     
/* 1509 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1510 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1511 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1513 */         .addComponent(this.jScrollPane8, GroupLayout.Alignment.TRAILING));
/*      */     
/* 1515 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1516 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1517 */         .addComponent(this.jScrollPane8));
/*      */ 
/*      */     
/* 1520 */     this.jDialog2.setTitle("Licencias Vencidas");
/* 1521 */     this.jDialog2.setUndecorated(true);
/*      */     
/* 1523 */     this.jPanel65.setBackground(new Color(255, 255, 255));
/* 1524 */     this.jPanel65.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/* 1526 */     this.jPanel66.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 1528 */     this.jLabel47.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 1529 */     this.jLabel47.setForeground(new Color(255, 255, 255));
/* 1530 */     this.jLabel47.setHorizontalAlignment(0);
/* 1531 */     this.jLabel47.setText(" Selecciona la versión");
/* 1532 */     this.jLabel47.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/* 1534 */             complementoPagos.this.jLabel47MouseDragged(evt);
/*      */           }
/*      */         });
/* 1537 */     this.jLabel47.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1539 */             complementoPagos.this.jLabel47MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1543 */     this.jPanel87.setBackground(this.lc.PRIMARIO1);
/* 1544 */     this.jPanel87.setLayout(new GridLayout(1, 0));
/*      */     
/* 1546 */     this.jLabel129.setHorizontalAlignment(0);
/* 1547 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 1548 */     this.jLabel129.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1550 */             complementoPagos.this.jLabel129MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1553 */             complementoPagos.this.jLabel129MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1556 */             complementoPagos.this.jLabel129MouseExited(evt);
/*      */           }
/*      */         });
/* 1559 */     this.jPanel87.add(this.jLabel129);
/*      */     
/* 1561 */     this.jLabel54.setHorizontalAlignment(0);
/*      */     
/* 1563 */     GroupLayout jPanel66Layout = new GroupLayout(this.jPanel66);
/* 1564 */     this.jPanel66.setLayout(jPanel66Layout);
/* 1565 */     jPanel66Layout.setHorizontalGroup(jPanel66Layout
/* 1566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1567 */         .addGroup(jPanel66Layout.createSequentialGroup()
/* 1568 */           .addGap(1, 1, 1)
/* 1569 */           .addComponent(this.jLabel54, -2, 36, -2)
/* 1570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1571 */           .addComponent(this.jLabel47, -1, -1, 32767)
/* 1572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1573 */           .addComponent(this.jPanel87, -2, 34, -2)));
/*      */     
/* 1575 */     jPanel66Layout.setVerticalGroup(jPanel66Layout
/* 1576 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1577 */         .addComponent(this.jPanel87, -1, -1, 32767)
/* 1578 */         .addGroup(jPanel66Layout.createSequentialGroup()
/* 1579 */           .addGroup(jPanel66Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1580 */             .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1581 */             .addComponent(this.jLabel47, -2, 30, -2))
/* 1582 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1585 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/* 1586 */     this.jPanel38.setLayout(new GridLayout(1, 3, 40, 0));
/*      */     
/* 1588 */     this.jPanel43.setBackground(this.lc.SECUNDARIO2);
/* 1589 */     this.jPanel43.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*      */     
/* 1591 */     this.jLabel94.setHorizontalAlignment(0);
/* 1592 */     this.jLabel94.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bill(1).png")));
/* 1593 */     this.jLabel94.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1595 */             complementoPagos.this.jLabel94MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1598 */             complementoPagos.this.jLabel94MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1601 */             complementoPagos.this.jLabel94MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1605 */     this.jLabel96.setFont(new Font("Cantarell", 1, 13));
/* 1606 */     this.jLabel96.setForeground(this.lc.PRIMARIO1);
/* 1607 */     this.jLabel96.setHorizontalAlignment(0);
/* 1608 */     this.jLabel96.setText("<html><center>Complemento de Pago 1.0</center></html>");
/*      */     
/* 1610 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 1611 */     this.jPanel43.setLayout(jPanel43Layout);
/* 1612 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 1613 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1614 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 1615 */           .addContainerGap()
/* 1616 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1617 */             .addComponent(this.jLabel94, -1, -1, 32767)
/* 1618 */             .addComponent(this.jLabel96, -1, 148, 32767))
/* 1619 */           .addContainerGap()));
/*      */     
/* 1621 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 1622 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1623 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 1624 */           .addContainerGap()
/* 1625 */           .addComponent(this.jLabel94, -2, 89, -2)
/* 1626 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1627 */           .addComponent(this.jLabel96)
/* 1628 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1631 */     this.jPanel38.add(this.jPanel43);
/*      */     
/* 1633 */     this.jPanel92.setBackground(this.lc.SECUNDARIO2);
/* 1634 */     this.jPanel92.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*      */     
/* 1636 */     this.jLabel97.setHorizontalAlignment(0);
/* 1637 */     this.jLabel97.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/invoice.png")));
/* 1638 */     this.jLabel97.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1640 */             complementoPagos.this.jLabel97MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1643 */             complementoPagos.this.jLabel97MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1646 */             complementoPagos.this.jLabel97MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1650 */     this.jLabel100.setFont(new Font("Cantarell", 1, 13));
/* 1651 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/* 1652 */     this.jLabel100.setHorizontalAlignment(0);
/* 1653 */     this.jLabel100.setText("<html><center>Nuevo Complemento 2.0</center></html>");
/* 1654 */     this.jLabel100.addMouseListener(new MouseAdapter() {
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1656 */             complementoPagos.this.jLabel100MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1660 */     GroupLayout jPanel92Layout = new GroupLayout(this.jPanel92);
/* 1661 */     this.jPanel92.setLayout(jPanel92Layout);
/* 1662 */     jPanel92Layout.setHorizontalGroup(jPanel92Layout
/* 1663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1664 */         .addGroup(jPanel92Layout.createSequentialGroup()
/* 1665 */           .addContainerGap()
/* 1666 */           .addGroup(jPanel92Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1667 */             .addComponent(this.jLabel97, -1, -1, 32767)
/* 1668 */             .addComponent(this.jLabel100, -1, 148, 32767))
/* 1669 */           .addContainerGap()));
/*      */     
/* 1671 */     jPanel92Layout.setVerticalGroup(jPanel92Layout
/* 1672 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1673 */         .addGroup(jPanel92Layout.createSequentialGroup()
/* 1674 */           .addContainerGap()
/* 1675 */           .addComponent(this.jLabel97, -2, 89, -2)
/* 1676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1677 */           .addComponent(this.jLabel100)
/* 1678 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1681 */     this.jPanel38.add(this.jPanel92);
/*      */     
/* 1683 */     GroupLayout jPanel65Layout = new GroupLayout(this.jPanel65);
/* 1684 */     this.jPanel65.setLayout(jPanel65Layout);
/* 1685 */     jPanel65Layout.setHorizontalGroup(jPanel65Layout
/* 1686 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1687 */         .addComponent(this.jPanel66, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1688 */         .addGroup(jPanel65Layout.createSequentialGroup()
/* 1689 */           .addContainerGap()
/* 1690 */           .addComponent(this.jPanel38, -2, 365, -2)
/* 1691 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1693 */     jPanel65Layout.setVerticalGroup(jPanel65Layout
/* 1694 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1695 */         .addGroup(jPanel65Layout.createSequentialGroup()
/* 1696 */           .addComponent(this.jPanel66, -2, -1, -2)
/* 1697 */           .addGap(18, 18, 18)
/* 1698 */           .addComponent(this.jPanel38, -2, -1, -2)
/* 1699 */           .addContainerGap(28, 32767)));
/*      */ 
/*      */     
/* 1702 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1703 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1704 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1706 */         .addComponent(this.jPanel65, -1, -1, 32767));
/*      */     
/* 1708 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1710 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1711 */           .addComponent(this.jPanel65, -1, -1, 32767)
/* 1712 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1715 */     this.jDialog3.setTitle("Cancelar complemento de pago");
/* 1716 */     this.jDialog3.setModal(true);
/*      */     
/* 1718 */     this.jLabel125.setFont(new Font("Cantarell", 0, 11));
/* 1719 */     this.jLabel125.setHorizontalAlignment(4);
/* 1720 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1722 */     this.jTextArea5.setColumns(20);
/* 1723 */     this.jTextArea5.setLineWrap(true);
/* 1724 */     this.jTextArea5.setRows(5);
/* 1725 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1727 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1728 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1729 */     this.materialButton36.setMnemonic('C');
/* 1730 */     this.materialButton36.setText("Cerrar");
/* 1731 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1732 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1733 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1734 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1736 */             complementoPagos.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1740 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1741 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1742 */     this.materialButton37.setMnemonic('A');
/* 1743 */     this.materialButton37.setText("Cancelar CFDI");
/* 1744 */     this.materialButton37.setToolTipText("Cancelar CFDI (Alt+A)");
/* 1745 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1746 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1747 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1749 */             complementoPagos.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1753 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1754 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1755 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1757 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1758 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1759 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1760 */               .addComponent(this.jLabel125, -2, 68, -2)
/* 1761 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1762 */               .addComponent(this.jScrollPane18, -1, 352, 32767))
/* 1763 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1764 */               .addContainerGap(-1, 32767)
/* 1765 */               .addComponent((Component)this.materialButton37, -2, 150, -2)
/* 1766 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1767 */               .addComponent((Component)this.materialButton36, -2, 105, -2)))
/* 1768 */           .addContainerGap()));
/*      */     
/* 1770 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1771 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1772 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1773 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1774 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1775 */               .addComponent(this.jLabel125)
/* 1776 */               .addGap(0, 0, 32767))
/* 1777 */             .addComponent(this.jScrollPane18, -1, 149, 32767))
/* 1778 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1779 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1780 */             .addComponent((Component)this.materialButton36, -2, 38, -2)
/* 1781 */             .addComponent((Component)this.materialButton37, -2, 38, -2))
/* 1782 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1785 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1786 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1787 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1789 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */     
/* 1791 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1792 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1793 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */ 
/*      */     
/* 1796 */     this.jDialog9.setTitle("Búsqueda de facturas");
/* 1797 */     this.jDialog9.setModal(true);
/*      */     
/* 1799 */     this.jPanel13.setLayout(new GridLayout(1, 3, 30, 0));
/*      */     
/* 1801 */     this.jPanel14.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1803 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/* 1804 */     this.jLabel2.setHorizontalAlignment(4);
/* 1805 */     this.jLabel2.setText("Folio Fiscal");
/* 1806 */     this.jPanel14.add(this.jLabel2);
/*      */     
/* 1808 */     this.jTextField8.setText("jTextField8");
/* 1809 */     this.jTextField8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1811 */             complementoPagos.this.jTextField8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1814 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1816 */             complementoPagos.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/* 1819 */     this.jPanel14.add(this.jTextField8);
/*      */     
/* 1821 */     this.jPanel13.add(this.jPanel14);
/*      */     
/* 1823 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1825 */     this.jLabel7.setFont(new Font("Cantarell", 0, 11));
/* 1826 */     this.jLabel7.setHorizontalAlignment(4);
/* 1827 */     this.jLabel7.setText("Folio Interno");
/* 1828 */     this.jPanel15.add(this.jLabel7);
/*      */     
/* 1830 */     this.jTextField11.setText("jTextField11");
/* 1831 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1833 */             complementoPagos.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/* 1836 */     this.jPanel15.add(this.jTextField11);
/*      */     
/* 1838 */     this.jPanel13.add(this.jPanel15);
/*      */     
/* 1840 */     this.jPanel19.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1842 */     this.jLabel8.setFont(new Font("Cantarell", 0, 11));
/* 1843 */     this.jLabel8.setHorizontalAlignment(4);
/* 1844 */     this.jLabel8.setText("Cliente");
/* 1845 */     this.jPanel19.add(this.jLabel8);
/*      */     
/* 1847 */     this.jTextField12.setText("jTextField12");
/* 1848 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1850 */             complementoPagos.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/* 1853 */     this.jPanel19.add(this.jTextField12);
/*      */     
/* 1855 */     this.jPanel13.add(this.jPanel19);
/*      */     
/* 1857 */     this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1865 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1870 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1873 */     this.rSTableMetro7.setAltoHead(25);
/* 1874 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1875 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/* 1876 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/* 1877 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1878 */     this.rSTableMetro7.setColorFilasForeground1(new Color(102, 102, 102));
/* 1879 */     this.rSTableMetro7.setColorFilasForeground2(new Color(102, 102, 102));
/* 1880 */     this.rSTableMetro7.setColorSelBackgound(new Color(237, 107, 107));
/* 1881 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1882 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1883 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1884 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/* 1885 */     this.rSTableMetro7.setRowHeight(18);
/* 1886 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/* 1887 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/* 1888 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 1889 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1891 */             complementoPagos.this.rSTableMetro7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1894 */     this.rSTableMetro7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1896 */             complementoPagos.this.rSTableMetro7KeyReleased(evt);
/*      */           }
/*      */         });
/* 1899 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro7);
/*      */     
/* 1901 */     this.materialButton23.setBackground(this.lc.SECUNDARIO1);
/* 1902 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 1903 */     this.materialButton23.setMnemonic('C');
/* 1904 */     this.materialButton23.setText("Cerrar");
/* 1905 */     this.materialButton23.setToolTipText("Cerrar (Alt+C)");
/* 1906 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 1907 */     this.materialButton23.setHorizontalTextPosition(0);
/* 1908 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1910 */             complementoPagos.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1914 */     this.materialButton24.setBackground(this.lc.PRIMARIO1);
/* 1915 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 1916 */     this.materialButton24.setMnemonic('A');
/* 1917 */     this.materialButton24.setText("Agregar");
/* 1918 */     this.materialButton24.setToolTipText("Agregar (Alt+A)");
/* 1919 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 1920 */     this.materialButton24.setHorizontalTextPosition(0);
/* 1921 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1923 */             complementoPagos.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1927 */     this.jLabel1.setFont(new Font("Cantarell", 1, 13));
/* 1928 */     this.jLabel1.setForeground(this.lc.PRIMARIO1);
/* 1929 */     this.jLabel1.setText("0 Facturas");
/*      */     
/* 1931 */     this.jLabel4.setFont(new Font("Cantarell", 0, 13));
/* 1932 */     this.jLabel4.setForeground(this.lc.SECUNDARIO1);
/* 1933 */     this.jLabel4.setText("Total: ");
/*      */     
/* 1935 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1936 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1937 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1938 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1939 */         .addComponent(this.jScrollPane33)
/* 1940 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1941 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1942 */             .addComponent(this.jPanel13, -1, 729, 32767)
/* 1943 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1944 */               .addGap(10, 10, 10)
/* 1945 */               .addComponent(this.jLabel4, -2, 52, -2)
/* 1946 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1947 */               .addComponent(this.jLabel1, -2, 142, -2)
/* 1948 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1949 */               .addComponent((Component)this.materialButton24, -2, 150, -2)
/* 1950 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1951 */               .addComponent((Component)this.materialButton23, -2, 105, -2)))
/* 1952 */           .addContainerGap()));
/*      */     
/* 1954 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1955 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1956 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1957 */           .addContainerGap()
/* 1958 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1959 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1960 */           .addComponent(this.jScrollPane33, -1, 256, 32767)
/* 1961 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1962 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1963 */             .addComponent((Component)this.materialButton23, -2, 38, -2)
/* 1964 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 1965 */             .addComponent(this.jLabel1)
/* 1966 */             .addComponent(this.jLabel4))
/* 1967 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1970 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 1971 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 1972 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 1973 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1974 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */     
/* 1976 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 1977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1978 */         .addComponent(this.jPanel6, -1, -1, 32767));
/*      */ 
/*      */     
/* 1981 */     this.jDialog10.setTitle("Cantidad a saldar");
/* 1982 */     this.jDialog10.setModal(true);
/*      */     
/* 1984 */     this.jLabel9.setFont(new Font("Cantarell", 0, 14));
/* 1985 */     this.jLabel9.setHorizontalAlignment(0);
/* 1986 */     this.jLabel9.setText("Ingresa la cantidad del abono");
/*      */     
/* 1988 */     this.materialButton38.setBackground(this.lc.PRIMARIO1);
/* 1989 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 1990 */     this.materialButton38.setMnemonic('A');
/* 1991 */     this.materialButton38.setText("Aceptar");
/* 1992 */     this.materialButton38.setToolTipText("Aceptar (Alt+A)");
/* 1993 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/* 1994 */     this.materialButton38.setHorizontalTextPosition(0);
/* 1995 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1997 */             complementoPagos.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2001 */     this.jPanel2.setLayout(new GridLayout(5, 2, 12, 12));
/*      */     
/* 2003 */     this.jLabel75.setFont(new Font("Cantarell", 1, 14));
/* 2004 */     this.jLabel75.setText("  Total del Abono");
/* 2005 */     this.jPanel2.add(this.jLabel75);
/*      */     
/* 2007 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/* 2008 */     this.jFormattedTextField6.setFont(new Font("Dialog", 1, 20));
/* 2009 */     this.jFormattedTextField6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2011 */             complementoPagos.this.jFormattedTextField6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2014 */     this.jFormattedTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2016 */             complementoPagos.this.jFormattedTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 2019 */     this.jPanel2.add(this.jFormattedTextField6);
/*      */     
/* 2021 */     this.jLabel77.setFont(new Font("Cantarell", 1, 14));
/* 2022 */     this.jLabel77.setText("<html><u>&nbsp;Abono al Subtotal</u></html>");
/* 2023 */     this.jLabel77.setToolTipText("Subtotal = Abono / ( (1+Tasa Iva) - Tasa Ret)");
/* 2024 */     this.jPanel2.add(this.jLabel77);
/*      */     
/* 2026 */     this.jTextField4.setFont(new Font("SF UI Display Light", 1, 20));
/* 2027 */     this.jTextField4.setHorizontalAlignment(4);
/* 2028 */     this.jTextField4.setEnabled(false);
/* 2029 */     this.jPanel2.add(this.jTextField4);
/*      */     
/* 2031 */     this.jLabel72.setFont(new Font("Cantarell", 1, 14));
/* 2032 */     this.jLabel72.setText("  Abono de Iva");
/* 2033 */     this.jPanel2.add(this.jLabel72);
/*      */     
/* 2035 */     this.jTextField2.setEditable(false);
/* 2036 */     this.jTextField2.setFont(new Font("SF UI Display Light", 1, 20));
/* 2037 */     this.jTextField2.setHorizontalAlignment(4);
/* 2038 */     this.jTextField2.setEnabled(false);
/* 2039 */     this.jPanel2.add(this.jTextField2);
/*      */     
/* 2041 */     this.jLabel76.setFont(new Font("Cantarell", 1, 14));
/* 2042 */     this.jLabel76.setText("  Abono de Retención");
/* 2043 */     this.jPanel2.add(this.jLabel76);
/*      */     
/* 2045 */     this.jTextField3.setEditable(false);
/* 2046 */     this.jTextField3.setFont(new Font("SF UI Display Light", 1, 20));
/* 2047 */     this.jTextField3.setHorizontalAlignment(4);
/* 2048 */     this.jTextField3.setEnabled(false);
/* 2049 */     this.jPanel2.add(this.jTextField3);
/*      */     
/* 2051 */     this.jLabel83.setFont(new Font("Cantarell", 1, 14));
/* 2052 */     this.jLabel83.setText("  Fluctuación en MXN");
/* 2053 */     this.jPanel2.add(this.jLabel83);
/*      */     
/* 2055 */     this.jTextField6.setEditable(false);
/* 2056 */     this.jTextField6.setFont(new Font("SF UI Display Light", 1, 20));
/* 2057 */     this.jTextField6.setHorizontalAlignment(4);
/* 2058 */     this.jTextField6.setEnabled(false);
/* 2059 */     this.jPanel2.add(this.jTextField6);
/*      */     
/* 2061 */     this.jLabel12.setForeground(new Color(51, 51, 255));
/* 2062 */     this.jLabel12.setText("<html><u>Cambiar Cantidades</u></html>");
/* 2063 */     this.jLabel12.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2065 */             complementoPagos.this.jLabel12MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 2069 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2070 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2071 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2072 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2073 */         .addComponent(this.jLabel9, -1, -1, 32767)
/* 2074 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
/* 2075 */           .addContainerGap()
/* 2076 */           .addComponent(this.jLabel12, -2, 197, -2)
/* 2077 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2078 */           .addComponent((Component)this.materialButton38, -2, 150, -2))
/* 2079 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 2080 */         .addComponent(this.jSeparator1));
/*      */     
/* 2082 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2083 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2084 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2085 */           .addComponent(this.jLabel9)
/* 2086 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2087 */           .addComponent(this.jPanel2, -2, 175, 32767)
/* 2088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2089 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 2090 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2091 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2092 */             .addComponent((Component)this.materialButton38, -2, 38, -2)
/* 2093 */             .addComponent(this.jLabel12, -2, -1, -2))
/* 2094 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2097 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2098 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2099 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2100 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2101 */         .addComponent(this.jPanel20, -1, -1, 32767));
/*      */     
/* 2103 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2104 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2105 */         .addComponent(this.jPanel20, -1, -1, 32767));
/*      */ 
/*      */     
/* 2108 */     this.jDialog11.setTitle("Descripción de la cancelación");
/* 2109 */     this.jDialog11.setModal(true);
/*      */     
/* 2111 */     this.jTextArea6.setEditable(false);
/* 2112 */     this.jTextArea6.setColumns(20);
/* 2113 */     this.jTextArea6.setLineWrap(true);
/* 2114 */     this.jTextArea6.setRows(5);
/* 2115 */     this.jScrollPane19.setViewportView(this.jTextArea6);
/*      */     
/* 2117 */     this.jLabel130.setFont(new Font("Cantarell", 0, 11));
/* 2118 */     this.jLabel130.setText("Éste es el motivo de la cancelación");
/*      */     
/* 2120 */     this.materialButton39.setBackground(this.lc.SECUNDARIO1);
/* 2121 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 2122 */     this.materialButton39.setMnemonic('C');
/* 2123 */     this.materialButton39.setText("Cerrar");
/* 2124 */     this.materialButton39.setToolTipText("Cerrar (Alt+C)");
/* 2125 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/* 2126 */     this.materialButton39.setHorizontalTextPosition(0);
/* 2127 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2129 */             complementoPagos.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2133 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 2134 */     this.jPanel33.setLayout(jPanel33Layout);
/* 2135 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 2136 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2137 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 2138 */           .addContainerGap()
/* 2139 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2140 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 2141 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2142 */                 .addComponent(this.jScrollPane19, -1, 485, 32767)
/* 2143 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/* 2144 */                   .addGap(0, 0, 32767)
/* 2145 */                   .addComponent((Component)this.materialButton39, -2, 105, -2)))
/* 2146 */               .addContainerGap())
/* 2147 */             .addComponent(this.jLabel130, GroupLayout.Alignment.TRAILING, -1, -1, 32767))));
/*      */     
/* 2149 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 2150 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2151 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 2152 */           .addComponent(this.jLabel130)
/* 2153 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2154 */           .addComponent(this.jScrollPane19, -1, 122, 32767)
/* 2155 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2156 */           .addComponent((Component)this.materialButton39, -2, 38, -2)
/* 2157 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/* 2160 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 2161 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 2162 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 2163 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2164 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 2165 */           .addComponent(this.jPanel33, -1, -1, 32767)
/* 2166 */           .addGap(0, 0, 0)));
/*      */     
/* 2168 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 2169 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2170 */         .addComponent(this.jPanel33, -1, -1, 32767));
/*      */ 
/*      */     
/* 2173 */     this.jDialog12.setTitle("Ruta del Timbrado");
/*      */     
/* 2175 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/* 2176 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/* 2177 */     this.materialButton40.setMnemonic('T');
/* 2178 */     this.materialButton40.setText("Predeterminada");
/* 2179 */     this.materialButton40.setToolTipText("Timbrar CFDI (Alt+T)");
/* 2180 */     this.materialButton40.setFont(new Font("Cantarell", 0, 12));
/* 2181 */     this.materialButton40.setHorizontalTextPosition(0);
/* 2182 */     this.materialButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2184 */             complementoPagos.this.materialButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2188 */     this.materialButton41.setBackground(this.lc.PRIMARIO1);
/* 2189 */     this.materialButton41.setForeground(new Color(255, 255, 255));
/* 2190 */     this.materialButton41.setMnemonic('T');
/* 2191 */     this.materialButton41.setText("Nueva");
/* 2192 */     this.materialButton41.setToolTipText("Timbrar CFDI (Alt+T)");
/* 2193 */     this.materialButton41.setFont(new Font("Cantarell", 0, 12));
/* 2194 */     this.materialButton41.setHorizontalTextPosition(0);
/* 2195 */     this.materialButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2197 */             complementoPagos.this.materialButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2201 */     this.jTextField24.setEditable(false);
/*      */     
/* 2203 */     GroupLayout jPanel172Layout = new GroupLayout(this.jPanel172);
/* 2204 */     this.jPanel172.setLayout(jPanel172Layout);
/* 2205 */     jPanel172Layout.setHorizontalGroup(jPanel172Layout
/* 2206 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2207 */         .addGroup(jPanel172Layout.createSequentialGroup()
/* 2208 */           .addContainerGap()
/* 2209 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2210 */             .addGroup(jPanel172Layout.createSequentialGroup()
/* 2211 */               .addComponent((Component)this.materialButton40, -2, 150, -2)
/* 2212 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2213 */               .addComponent(this.jTextField24, -1, 256, 32767))
/* 2214 */             .addGroup(jPanel172Layout.createSequentialGroup()
/* 2215 */               .addComponent((Component)this.materialButton41, -2, 150, -2)
/* 2216 */               .addGap(0, 0, 32767)))
/* 2217 */           .addContainerGap()));
/*      */     
/* 2219 */     jPanel172Layout.setVerticalGroup(jPanel172Layout
/* 2220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2221 */         .addGroup(jPanel172Layout.createSequentialGroup()
/* 2222 */           .addContainerGap()
/* 2223 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2224 */             .addComponent((Component)this.materialButton40, -2, 38, -2)
/* 2225 */             .addComponent(this.jTextField24, -2, -1, -2))
/* 2226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2227 */           .addComponent((Component)this.materialButton41, -2, 38, -2)
/* 2228 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2231 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/* 2232 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/* 2233 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/* 2234 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2235 */         .addComponent(this.jPanel172, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 2237 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/* 2238 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2239 */         .addComponent(this.jPanel172, -2, -1, -2));
/*      */ 
/*      */     
/* 2242 */     this.jDialog17.setTitle("Catálogo de Monedas");
/*      */     
/* 2244 */     this.rSTableMetro8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2252 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2257 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2260 */     this.rSTableMetro8.setAltoHead(25);
/* 2261 */     this.rSTableMetro8.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2262 */     this.rSTableMetro8.setColorBordeFilas(new Color(200, 200, 200));
/* 2263 */     this.rSTableMetro8.setColorBordeHead(this.lc.PRIMARIO1);
/* 2264 */     this.rSTableMetro8.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2265 */     this.rSTableMetro8.setColorFilasForeground1(new Color(102, 102, 102));
/* 2266 */     this.rSTableMetro8.setColorFilasForeground2(new Color(102, 102, 102));
/* 2267 */     this.rSTableMetro8.setColorSelBackgound(new Color(237, 107, 107));
/* 2268 */     this.rSTableMetro8.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2269 */     this.rSTableMetro8.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2270 */     this.rSTableMetro8.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2271 */     this.rSTableMetro8.setGrosorBordeFilas(0);
/* 2272 */     this.rSTableMetro8.setRowHeight(18);
/* 2273 */     this.rSTableMetro8.setSelectionBackground(this.lc.PRIMARIO2);
/* 2274 */     this.rSTableMetro8.getTableHeader().setResizingAllowed(false);
/* 2275 */     this.rSTableMetro8.getTableHeader().setReorderingAllowed(false);
/* 2276 */     this.rSTableMetro8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2278 */             complementoPagos.this.rSTableMetro8MouseClicked(evt);
/*      */           }
/*      */         });
/* 2281 */     this.rSTableMetro8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2283 */             complementoPagos.this.rSTableMetro8KeyReleased(evt);
/*      */           }
/*      */         });
/* 2286 */     this.jScrollPane34.setViewportView((Component)this.rSTableMetro8);
/*      */     
/* 2288 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/* 2289 */     this.jPanel134.setLayout(jPanel134Layout);
/* 2290 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/* 2291 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2292 */         .addComponent(this.jScrollPane34, -1, 543, 32767));
/*      */     
/* 2294 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/* 2295 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2296 */         .addComponent(this.jScrollPane34, -1, 223, 32767));
/*      */ 
/*      */     
/* 2299 */     GroupLayout jDialog17Layout = new GroupLayout(this.jDialog17.getContentPane());
/* 2300 */     this.jDialog17.getContentPane().setLayout(jDialog17Layout);
/* 2301 */     jDialog17Layout.setHorizontalGroup(jDialog17Layout
/* 2302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2303 */         .addGap(0, 543, 32767)
/* 2304 */         .addGroup(jDialog17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2305 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */     
/* 2307 */     jDialog17Layout.setVerticalGroup(jDialog17Layout
/* 2308 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2309 */         .addGap(0, 223, 32767)
/* 2310 */         .addGroup(jDialog17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2311 */           .addComponent(this.jPanel134, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2314 */     this.jDialog18.setTitle("Agredar Leyendas");
/*      */     
/* 2316 */     this.jLabel189.setText("Titulo:");
/*      */     
/* 2318 */     this.jLabel193.setText("Descripción:");
/*      */     
/* 2320 */     this.jTextField87.setText("jTextField87");
/* 2321 */     this.jTextField87.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2323 */             complementoPagos.this.jTextField87ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2327 */     this.jTextField88.setText("jTextField88");
/* 2328 */     this.jTextField88.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2330 */             complementoPagos.this.jTextField88ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2334 */     this.materialButton42.setBackground(this.lc.PRIMARIO1);
/* 2335 */     this.materialButton42.setForeground(new Color(255, 255, 255));
/* 2336 */     this.materialButton42.setMnemonic('A');
/* 2337 */     this.materialButton42.setText("Cancelar CFDI");
/* 2338 */     this.materialButton42.setToolTipText("Cancelar CFDI (Alt+A)");
/* 2339 */     this.materialButton42.setFont(new Font("Cantarell", 0, 12));
/* 2340 */     this.materialButton42.setHorizontalTextPosition(0);
/* 2341 */     this.materialButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2343 */             complementoPagos.this.materialButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2347 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/* 2348 */     this.jPanel135.setLayout(jPanel135Layout);
/* 2349 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/* 2350 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2351 */         .addGroup(jPanel135Layout.createSequentialGroup()
/* 2352 */           .addContainerGap()
/* 2353 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2354 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING)
/* 2355 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel135Layout.createSequentialGroup()
/* 2356 */               .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2357 */                 .addComponent(this.jLabel189, -1, -1, 32767)
/* 2358 */                 .addComponent(this.jLabel193, -1, 120, 32767))
/* 2359 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2360 */               .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2361 */                 .addComponent(this.jTextField87)
/* 2362 */                 .addComponent(this.jTextField88, -1, 642, 32767)))
/* 2363 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel135Layout.createSequentialGroup()
/* 2364 */               .addGap(0, 0, 32767)
/* 2365 */               .addComponent((Component)this.materialButton42, -2, 150, -2)))
/* 2366 */           .addContainerGap()));
/*      */     
/* 2368 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/* 2369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2370 */         .addGroup(jPanel135Layout.createSequentialGroup()
/* 2371 */           .addContainerGap()
/* 2372 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2373 */             .addComponent(this.jLabel189)
/* 2374 */             .addComponent(this.jTextField87, -2, -1, -2))
/* 2375 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2376 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2377 */             .addComponent(this.jLabel193)
/* 2378 */             .addComponent(this.jTextField88, -2, -1, -2))
/* 2379 */           .addGap(12, 12, 12)
/* 2380 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 2381 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2382 */           .addComponent((Component)this.materialButton42, -2, 38, -2)
/* 2383 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2386 */     GroupLayout jDialog18Layout = new GroupLayout(this.jDialog18.getContentPane());
/* 2387 */     this.jDialog18.getContentPane().setLayout(jDialog18Layout);
/* 2388 */     jDialog18Layout.setHorizontalGroup(jDialog18Layout
/* 2389 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2390 */         .addGap(0, 780, 32767)
/* 2391 */         .addGroup(jDialog18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2392 */           .addGroup(jDialog18Layout.createSequentialGroup()
/* 2393 */             .addComponent(this.jPanel135, -1, -1, 32767)
/* 2394 */             .addGap(0, 0, 0))));
/*      */     
/* 2396 */     jDialog18Layout.setVerticalGroup(jDialog18Layout
/* 2397 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2398 */         .addGap(0, 130, 32767)
/* 2399 */         .addGroup(jDialog18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2400 */           .addGroup(jDialog18Layout.createSequentialGroup()
/* 2401 */             .addComponent(this.jPanel135, -2, -1, -2)
/* 2402 */             .addGap(0, 0, 32767))));
/*      */ 
/*      */     
/* 2405 */     this.jLabel11.setText("Ingresa el nuevo estado:");
/*      */     
/* 2407 */     this.jComboBox10.setBackground(Color.white);
/* 2408 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "<Por Timbrar>", "<Timbrado>", "<Timbrado y Aplicado>" }));
/*      */     
/* 2410 */     this.jLabel18.setText("¿Estás seguro que deseas cambiar el estado del complemento?");
/*      */     
/* 2412 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2413 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2414 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2415 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2416 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2417 */           .addComponent(this.jLabel11, -1, -1, 32767)
/* 2418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2419 */           .addComponent(this.jComboBox10, -2, 178, -2))
/* 2420 */         .addComponent(this.jLabel18, -1, -1, 32767));
/*      */     
/* 2422 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2423 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2424 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2425 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2426 */             .addComponent(this.jComboBox10, -2, -1, -2)
/* 2427 */             .addComponent(this.jLabel11))
/* 2428 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2429 */           .addComponent(this.jLabel18)));
/*      */ 
/*      */     
/* 2432 */     this.jLabel233.setFont(new Font("Cantarell", 0, 11));
/* 2433 */     this.jLabel233.setHorizontalAlignment(4);
/* 2434 */     this.jLabel233.setText("Visualizando información del ");
/*      */     
/* 2436 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2437 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2438 */     this.jDateChooser4.setIcon(this.icon);
/* 2439 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 2440 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2442 */     this.jLabel234.setFont(new Font("Cantarell", 0, 11));
/* 2443 */     this.jLabel234.setHorizontalAlignment(0);
/* 2444 */     this.jLabel234.setText("al");
/*      */     
/* 2446 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2447 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2448 */     this.jDateChooser5.setIcon(this.icon);
/* 2449 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2450 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2452 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2453 */     this.jButton1.setMnemonic('F');
/* 2454 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2455 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2457 */             complementoPagos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2461 */     this.jLabel170.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 2462 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 2463 */     this.jLabel170.setHorizontalAlignment(0);
/* 2464 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 2465 */     this.jLabel170.setToolTipText("Retroceder un día en la búsqueda");
/* 2466 */     this.jLabel170.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2468 */             complementoPagos.this.jLabel170MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2471 */             complementoPagos.this.jLabel170MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2474 */             complementoPagos.this.jLabel170MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2478 */     this.jLabel101.setFont(new Font("Tahoma", 2, 12));
/* 2479 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 2480 */     this.jLabel101.setHorizontalAlignment(0);
/* 2481 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 2482 */     this.jLabel101.setToolTipText("Clic para filtrar los datos de HOY");
/* 2483 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2485 */             complementoPagos.this.jLabel101MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2488 */             complementoPagos.this.jLabel101MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2491 */             complementoPagos.this.jLabel101MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2495 */     this.jLabel171.setHorizontalAlignment(0);
/* 2496 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 2497 */     this.jLabel171.setToolTipText("Aumentar un día en la búsqueda");
/* 2498 */     this.jLabel171.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2500 */             complementoPagos.this.jLabel171MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2503 */             complementoPagos.this.jLabel171MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2506 */             complementoPagos.this.jLabel171MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2510 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2511 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2512 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2513 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2514 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2515 */           .addContainerGap()
/* 2516 */           .addComponent(this.jLabel233, -2, 149, -2)
/* 2517 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2518 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2519 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2520 */           .addComponent(this.jLabel234, -2, 16, -2)
/* 2521 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2522 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2523 */           .addGap(70, 70, 70)
/* 2524 */           .addComponent(this.jLabel170)
/* 2525 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2526 */           .addComponent(this.jLabel101)
/* 2527 */           .addContainerGap(402, 32767))
/* 2528 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2529 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 2530 */             .addContainerGap(447, 32767)
/* 2531 */             .addComponent(this.jButton1)
/* 2532 */             .addContainerGap(448, 32767)))
/* 2533 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2534 */           .addGroup(jPanel1Layout.createSequentialGroup()
/* 2535 */             .addGap(0, 0, 32767)
/* 2536 */             .addComponent(this.jLabel171)
/* 2537 */             .addGap(0, 0, 32767))));
/*      */     
/* 2539 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2540 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2541 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2542 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2543 */             .addComponent(this.jLabel233, -2, 90, -2)
/* 2544 */             .addComponent((Component)this.jDateChooser4, -2, 49, -2)
/* 2545 */             .addComponent(this.jLabel234, -2, 49, -2)
/* 2546 */             .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2547 */               .addComponent(this.jLabel170)
/* 2548 */               .addComponent((Component)this.jDateChooser5, -2, -1, -2))
/* 2549 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 2550 */               .addGap(12, 12, 12)
/* 2551 */               .addComponent(this.jLabel101)))
/* 2552 */           .addContainerGap(259, 32767))
/* 2553 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2554 */           .addGroup(jPanel1Layout.createSequentialGroup()
/* 2555 */             .addContainerGap()
/* 2556 */             .addComponent(this.jButton1)
/* 2557 */             .addContainerGap(321, 32767)))
/* 2558 */         .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2559 */           .addGroup(jPanel1Layout.createSequentialGroup()
/* 2560 */             .addGap(0, 0, 32767)
/* 2561 */             .addComponent(this.jLabel171)
/* 2562 */             .addGap(0, 0, 32767))));
/*      */ 
/*      */     
/* 2565 */     this.jPanel3.setLayout(new GridLayout(4, 2, 12, 12));
/*      */     
/* 2567 */     this.jLabel79.setFont(new Font("Cantarell", 1, 14));
/* 2568 */     this.jLabel79.setText("  Total del Abono");
/* 2569 */     this.jPanel3.add(this.jLabel79);
/*      */     
/* 2571 */     this.jFormattedTextField7.setEditable(false);
/* 2572 */     this.jFormattedTextField7.setHorizontalAlignment(4);
/* 2573 */     this.jFormattedTextField7.setFont(new Font("Dialog", 1, 20));
/* 2574 */     this.jFormattedTextField7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2576 */             complementoPagos.this.jFormattedTextField7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2579 */     this.jFormattedTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2581 */             complementoPagos.this.jFormattedTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/* 2584 */     this.jPanel3.add(this.jFormattedTextField7);
/*      */     
/* 2586 */     this.jLabel80.setFont(new Font("Cantarell", 1, 14));
/* 2587 */     this.jLabel80.setText("<html><u>&nbsp;Abono al Subtotal</u></html>");
/* 2588 */     this.jLabel80.setToolTipText("Subtotal = Abono / ( (1+Tasa Iva) - Tasa Ret)");
/* 2589 */     this.jPanel3.add(this.jLabel80);
/*      */     
/* 2591 */     this.jFormattedTextField8.setHorizontalAlignment(4);
/* 2592 */     this.jFormattedTextField8.setFont(new Font("Dialog", 1, 20));
/* 2593 */     this.jFormattedTextField8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2595 */             complementoPagos.this.jFormattedTextField8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2598 */     this.jFormattedTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2600 */             complementoPagos.this.jFormattedTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/* 2603 */     this.jPanel3.add(this.jFormattedTextField8);
/*      */     
/* 2605 */     this.jLabel81.setFont(new Font("Cantarell", 1, 14));
/* 2606 */     this.jLabel81.setText("  Abono de Iva");
/* 2607 */     this.jPanel3.add(this.jLabel81);
/*      */     
/* 2609 */     this.jFormattedTextField9.setHorizontalAlignment(4);
/* 2610 */     this.jFormattedTextField9.setFont(new Font("Dialog", 1, 20));
/* 2611 */     this.jFormattedTextField9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2613 */             complementoPagos.this.jFormattedTextField9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2616 */     this.jFormattedTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2618 */             complementoPagos.this.jFormattedTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/* 2621 */     this.jPanel3.add(this.jFormattedTextField9);
/*      */     
/* 2623 */     this.jLabel82.setFont(new Font("Cantarell", 1, 14));
/* 2624 */     this.jLabel82.setText("  Abono de Retención");
/* 2625 */     this.jPanel3.add(this.jLabel82);
/*      */     
/* 2627 */     this.jFormattedTextField10.setHorizontalAlignment(4);
/* 2628 */     this.jFormattedTextField10.setFont(new Font("Dialog", 1, 20));
/* 2629 */     this.jFormattedTextField10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2631 */             complementoPagos.this.jFormattedTextField10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2634 */     this.jFormattedTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2636 */             complementoPagos.this.jFormattedTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/* 2639 */     this.jPanel3.add(this.jFormattedTextField10);
/*      */     
/* 2641 */     this.jDialog37.setTitle("Historial de precios del dolar");
/*      */     
/* 2643 */     this.jPanel44.setBorder(BorderFactory.createTitledBorder("Datos Históricos"));
/*      */     
/* 2645 */     this.rSTableMetro20.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Titulo", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2653 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2658 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2661 */     this.rSTableMetro20.setAltoHead(25);
/* 2662 */     this.rSTableMetro20.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2663 */     this.rSTableMetro20.setColorBordeFilas(new Color(200, 200, 200));
/* 2664 */     this.rSTableMetro20.setColorBordeHead(this.lc.PRIMARIO1);
/* 2665 */     this.rSTableMetro20.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2666 */     this.rSTableMetro20.setColorFilasForeground1(new Color(102, 102, 102));
/* 2667 */     this.rSTableMetro20.setColorFilasForeground2(new Color(102, 102, 102));
/* 2668 */     this.rSTableMetro20.setColorSelBackgound(new Color(237, 107, 107));
/* 2669 */     this.rSTableMetro20.setFont(new Font("Cantarell", 0, 10));
/* 2670 */     this.rSTableMetro20.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 2671 */     this.rSTableMetro20.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 2672 */     this.rSTableMetro20.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2673 */     this.rSTableMetro20.setGrosorBordeFilas(0);
/* 2674 */     this.rSTableMetro20.setSelectionBackground(this.lc.PRIMARIO2);
/* 2675 */     this.rSTableMetro20.getTableHeader().setResizingAllowed(false);
/* 2676 */     this.rSTableMetro20.getTableHeader().setReorderingAllowed(false);
/* 2677 */     this.rSTableMetro20.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2679 */             complementoPagos.this.rSTableMetro20MouseClicked(evt);
/*      */           }
/*      */         });
/* 2682 */     this.rSTableMetro20.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2684 */             complementoPagos.this.rSTableMetro20KeyReleased(evt);
/*      */           }
/*      */         });
/* 2687 */     this.jScrollPane25.setViewportView((Component)this.rSTableMetro20);
/*      */     
/* 2689 */     this.jLabel244.setHorizontalAlignment(4);
/* 2690 */     this.jLabel244.setText("Visualizando");
/*      */     
/* 2692 */     this.jComboBox41.setBackground(new Color(255, 255, 255));
/* 2693 */     this.jComboBox41.setModel(new DefaultComboBoxModel<>(new String[] { "PERIODO LIBRE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/* 2694 */     this.jComboBox41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2696 */             complementoPagos.this.jComboBox41ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2700 */     this.jComboBox40.setBackground(new Color(255, 255, 255));
/* 2701 */     this.jComboBox40.setModel(new DefaultComboBoxModel<>(new String[] { "2004" }));
/* 2702 */     this.jComboBox40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2704 */             complementoPagos.this.jComboBox40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2708 */     this.jDateChooser14.setDate(this.fechaActual);
/* 2709 */     this.jDateChooser14.setDateFormatString("dd/MM/yyyy");
/* 2710 */     this.jDateChooser14.setIcon(this.icon);
/* 2711 */     this.jDateChooser14.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2713 */     this.jLabel241.setHorizontalAlignment(0);
/* 2714 */     this.jLabel241.setText("     al     ");
/*      */     
/* 2716 */     this.jDateChooser15.setDate(this.fechaActual);
/* 2717 */     this.jDateChooser15.setDateFormatString("dd/MM/yyyy");
/* 2718 */     this.jDateChooser15.setIcon(this.icon);
/* 2719 */     this.jDateChooser15.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2721 */     GroupLayout jPanel74Layout = new GroupLayout(this.jPanel74);
/* 2722 */     this.jPanel74.setLayout(jPanel74Layout);
/* 2723 */     jPanel74Layout.setHorizontalGroup(jPanel74Layout
/* 2724 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2725 */         .addGroup(jPanel74Layout.createSequentialGroup()
/* 2726 */           .addComponent((Component)this.jDateChooser14, -2, 121, -2)
/* 2727 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2728 */           .addComponent(this.jLabel241)
/* 2729 */           .addGap(18, 18, 18)
/* 2730 */           .addComponent((Component)this.jDateChooser15, -2, 120, -2)
/* 2731 */           .addContainerGap()));
/*      */     
/* 2733 */     jPanel74Layout.setVerticalGroup(jPanel74Layout
/* 2734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2735 */         .addComponent((Component)this.jDateChooser14, -2, 30, -2)
/* 2736 */         .addComponent(this.jLabel241, -2, 30, -2)
/* 2737 */         .addComponent((Component)this.jDateChooser15, -2, 30, -2));
/*      */ 
/*      */     
/* 2740 */     this.jButton29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2741 */     this.jButton29.setMnemonic('F');
/* 2742 */     this.jButton29.setToolTipText("Filtrar información (Alt+F)");
/* 2743 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2745 */             complementoPagos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2749 */     GroupLayout jPanel78Layout = new GroupLayout(this.jPanel78);
/* 2750 */     this.jPanel78.setLayout(jPanel78Layout);
/* 2751 */     jPanel78Layout.setHorizontalGroup(jPanel78Layout
/* 2752 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2753 */         .addGroup(jPanel78Layout.createSequentialGroup()
/* 2754 */           .addContainerGap()
/* 2755 */           .addComponent(this.jLabel244, -2, 152, -2)
/* 2756 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2757 */           .addComponent(this.jComboBox41, -2, 165, -2)
/* 2758 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2759 */           .addComponent(this.jComboBox40, -2, 94, -2)
/* 2760 */           .addGap(18, 18, 18)
/* 2761 */           .addComponent(this.jPanel74, -2, -1, -2)
/* 2762 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2763 */           .addComponent(this.jButton29, -2, 62, -2)
/* 2764 */           .addContainerGap(26, 32767)));
/*      */     
/* 2766 */     jPanel78Layout.setVerticalGroup(jPanel78Layout
/* 2767 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2768 */         .addGroup(jPanel78Layout.createSequentialGroup()
/* 2769 */           .addContainerGap()
/* 2770 */           .addGroup(jPanel78Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2771 */             .addGroup(jPanel78Layout.createSequentialGroup()
/* 2772 */               .addGroup(jPanel78Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2773 */                 .addComponent(this.jButton29, -2, 30, -2)
/* 2774 */                 .addComponent(this.jPanel74, -2, -1, -2))
/* 2775 */               .addGap(0, 0, 32767))
/* 2776 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
/* 2777 */               .addGap(0, 0, 32767)
/* 2778 */               .addGroup(jPanel78Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2779 */                 .addComponent(this.jComboBox41, -2, 30, -2)
/* 2780 */                 .addComponent(this.jComboBox40, -2, 30, -2)))
/* 2781 */             .addComponent(this.jLabel244, -1, -1, 32767))
/* 2782 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2785 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 2786 */     this.jPanel44.setLayout(jPanel44Layout);
/* 2787 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 2788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2789 */         .addComponent(this.jPanel78, -1, -1, 32767)
/* 2790 */         .addComponent(this.jScrollPane25));
/*      */     
/* 2792 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 2793 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2794 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 2795 */           .addComponent(this.jPanel78, -2, -1, -2)
/* 2796 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2797 */           .addComponent(this.jScrollPane25, -1, 542, 32767)));
/*      */ 
/*      */     
/* 2800 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/* 2801 */     this.jPanel45.setLayout(jPanel45Layout);
/* 2802 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/* 2803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2804 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */     
/* 2806 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/* 2807 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2808 */         .addComponent(this.jPanel44, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */ 
/*      */     
/* 2811 */     GroupLayout jDialog37Layout = new GroupLayout(this.jDialog37.getContentPane());
/* 2812 */     this.jDialog37.getContentPane().setLayout(jDialog37Layout);
/* 2813 */     jDialog37Layout.setHorizontalGroup(jDialog37Layout
/* 2814 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2815 */         .addComponent(this.jPanel45, -1, -1, 32767));
/*      */     
/* 2817 */     jDialog37Layout.setVerticalGroup(jDialog37Layout
/* 2818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2819 */         .addComponent(this.jPanel45, -1, -1, 32767));
/*      */ 
/*      */     
/* 2822 */     this.jDialog13.setTitle("Ruta del Timbrado");
/*      */     
/* 2824 */     this.rSTableMetro9.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2832 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2837 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2840 */     this.rSTableMetro9.setAltoHead(25);
/* 2841 */     this.rSTableMetro9.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2842 */     this.rSTableMetro9.setColorBordeFilas(new Color(200, 200, 200));
/* 2843 */     this.rSTableMetro9.setColorBordeHead(this.lc.PRIMARIO1);
/* 2844 */     this.rSTableMetro9.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2845 */     this.rSTableMetro9.setColorFilasForeground1(new Color(102, 102, 102));
/* 2846 */     this.rSTableMetro9.setColorFilasForeground2(new Color(102, 102, 102));
/* 2847 */     this.rSTableMetro9.setColorSelBackgound(new Color(237, 107, 107));
/* 2848 */     this.rSTableMetro9.setFont(new Font("Cantarell", 0, 10));
/* 2849 */     this.rSTableMetro9.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 2850 */     this.rSTableMetro9.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 2851 */     this.rSTableMetro9.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2852 */     this.rSTableMetro9.setGrosorBordeFilas(0);
/* 2853 */     this.rSTableMetro9.setRowHeight(18);
/* 2854 */     this.rSTableMetro9.setSelectionBackground(this.lc.PRIMARIO2);
/* 2855 */     this.rSTableMetro9.getTableHeader().setResizingAllowed(false);
/* 2856 */     this.rSTableMetro9.getTableHeader().setReorderingAllowed(false);
/* 2857 */     this.rSTableMetro9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2859 */             complementoPagos.this.rSTableMetro9MouseClicked(evt);
/*      */           }
/*      */         });
/* 2862 */     this.rSTableMetro9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2864 */             complementoPagos.this.rSTableMetro9KeyReleased(evt);
/*      */           }
/*      */         });
/* 2867 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro9);
/*      */     
/* 2869 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 2870 */     this.jPanel9.setLayout(jPanel9Layout);
/* 2871 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 2872 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2873 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2874 */           .addContainerGap()
/* 2875 */           .addComponent(this.jScrollPane20, -1, 674, 32767)
/* 2876 */           .addContainerGap()));
/*      */     
/* 2878 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 2879 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2880 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2881 */           .addContainerGap()
/* 2882 */           .addComponent(this.jScrollPane20, -2, 276, -2)
/* 2883 */           .addContainerGap(214, 32767)));
/*      */ 
/*      */     
/* 2886 */     GroupLayout jDialog13Layout = new GroupLayout(this.jDialog13.getContentPane());
/* 2887 */     this.jDialog13.getContentPane().setLayout(jDialog13Layout);
/* 2888 */     jDialog13Layout.setHorizontalGroup(jDialog13Layout
/* 2889 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2890 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 2892 */     jDialog13Layout.setVerticalGroup(jDialog13Layout
/* 2893 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2894 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/* 2897 */     this.jDialog22.setTitle("Folio Fiscal");
/*      */     
/* 2899 */     this.jPanel10.setLayout(new GridBagLayout());
/*      */     
/* 2901 */     this.jLabel196.setFont(new Font("Dialog", 0, 12));
/* 2902 */     this.jLabel196.setText("  Ruta del archivo");
/* 2903 */     gridBagConstraints = new GridBagConstraints();
/* 2904 */     gridBagConstraints.gridx = 0;
/* 2905 */     gridBagConstraints.gridy = 0;
/* 2906 */     gridBagConstraints.fill = 2;
/* 2907 */     gridBagConstraints.ipadx = 20;
/* 2908 */     gridBagConstraints.ipady = 20;
/* 2909 */     gridBagConstraints.anchor = 17;
/* 2910 */     this.jPanel10.add(this.jLabel196, gridBagConstraints);
/*      */     
/* 2912 */     this.jTextField91.setEditable(false);
/* 2913 */     this.jTextField91.setFont(new Font("Dialog", 1, 17));
/* 2914 */     this.jTextField91.setText("jTextField91");
/* 2915 */     this.jTextField91.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2917 */             complementoPagos.this.jTextField91ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2920 */     gridBagConstraints = new GridBagConstraints();
/* 2921 */     gridBagConstraints.gridx = 2;
/* 2922 */     gridBagConstraints.gridy = 2;
/* 2923 */     gridBagConstraints.fill = 2;
/* 2924 */     gridBagConstraints.anchor = 17;
/* 2925 */     gridBagConstraints.weightx = 1.0D;
/* 2926 */     this.jPanel10.add(this.jTextField91, gridBagConstraints);
/*      */     
/* 2928 */     this.jLabel225.setFont(new Font("Dialog", 0, 12));
/* 2929 */     this.jLabel225.setText("  Última actualización:");
/* 2930 */     gridBagConstraints = new GridBagConstraints();
/* 2931 */     gridBagConstraints.gridx = 0;
/* 2932 */     gridBagConstraints.gridy = 5;
/* 2933 */     gridBagConstraints.fill = 2;
/* 2934 */     gridBagConstraints.ipadx = 20;
/* 2935 */     gridBagConstraints.ipady = 20;
/* 2936 */     gridBagConstraints.anchor = 17;
/* 2937 */     this.jPanel10.add(this.jLabel225, gridBagConstraints);
/*      */     
/* 2939 */     this.jTextField98.setEditable(false);
/* 2940 */     this.jTextField98.setText("jTextField98");
/* 2941 */     gridBagConstraints = new GridBagConstraints();
/* 2942 */     gridBagConstraints.gridx = 2;
/* 2943 */     gridBagConstraints.gridy = 5;
/* 2944 */     gridBagConstraints.fill = 2;
/* 2945 */     gridBagConstraints.anchor = 17;
/* 2946 */     gridBagConstraints.weightx = 1.0D;
/* 2947 */     this.jPanel10.add(this.jTextField98, gridBagConstraints);
/*      */     
/* 2949 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 2950 */     this.jButton2.setMnemonic('B');
/* 2951 */     this.jButton2.setToolTipText("Buscar archivo xml... (Alt+B)");
/* 2952 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2954 */             complementoPagos.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2957 */     gridBagConstraints = new GridBagConstraints();
/* 2958 */     gridBagConstraints.gridx = 3;
/* 2959 */     gridBagConstraints.gridy = 0;
/* 2960 */     gridBagConstraints.fill = 2;
/* 2961 */     gridBagConstraints.anchor = 17;
/* 2962 */     this.jPanel10.add(this.jButton2, gridBagConstraints);
/*      */     
/* 2964 */     this.jTextField104.setEditable(false);
/* 2965 */     this.jTextField104.setText("j1 TextField104");
/* 2966 */     gridBagConstraints = new GridBagConstraints();
/* 2967 */     gridBagConstraints.gridx = 2;
/* 2968 */     gridBagConstraints.gridy = 0;
/* 2969 */     gridBagConstraints.fill = 2;
/* 2970 */     gridBagConstraints.anchor = 17;
/* 2971 */     this.jPanel10.add(this.jTextField104, gridBagConstraints);
/*      */     
/* 2973 */     this.jLabel237.setFont(new Font("Dialog", 0, 12));
/* 2974 */     this.jLabel237.setText("  Folio fiscal:");
/* 2975 */     gridBagConstraints = new GridBagConstraints();
/* 2976 */     gridBagConstraints.gridx = 0;
/* 2977 */     gridBagConstraints.gridy = 2;
/* 2978 */     gridBagConstraints.fill = 2;
/* 2979 */     gridBagConstraints.ipadx = 20;
/* 2980 */     gridBagConstraints.ipady = 20;
/* 2981 */     gridBagConstraints.anchor = 17;
/* 2982 */     this.jPanel10.add(this.jLabel237, gridBagConstraints);
/*      */     
/* 2984 */     this.materialButton26.setBackground(this.lc.PRIMARIO1);
/* 2985 */     this.materialButton26.setForeground(new Color(255, 255, 255));
/* 2986 */     this.materialButton26.setMnemonic('A');
/* 2987 */     this.materialButton26.setText("Actualizar");
/* 2988 */     this.materialButton26.setToolTipText("Actualizar (Alt+A)");
/* 2989 */     this.materialButton26.setFont(new Font("Cantarell", 0, 12));
/* 2990 */     this.materialButton26.setHorizontalTextPosition(0);
/* 2991 */     this.materialButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2993 */             complementoPagos.this.materialButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2997 */     GroupLayout jPanel165Layout = new GroupLayout(this.jPanel165);
/* 2998 */     this.jPanel165.setLayout(jPanel165Layout);
/* 2999 */     jPanel165Layout.setHorizontalGroup(jPanel165Layout
/* 3000 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3001 */         .addComponent(this.jPanel10, -1, 788, 32767)
/* 3002 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel165Layout.createSequentialGroup()
/* 3003 */           .addContainerGap(-1, 32767)
/* 3004 */           .addComponent((Component)this.materialButton26, -2, 136, -2)
/* 3005 */           .addGap(34, 34, 34)));
/*      */     
/* 3007 */     jPanel165Layout.setVerticalGroup(jPanel165Layout
/* 3008 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3009 */         .addGroup(jPanel165Layout.createSequentialGroup()
/* 3010 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 3011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3012 */           .addComponent((Component)this.materialButton26, -2, 40, -2)
/* 3013 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 3016 */     GroupLayout jDialog22Layout = new GroupLayout(this.jDialog22.getContentPane());
/* 3017 */     this.jDialog22.getContentPane().setLayout(jDialog22Layout);
/* 3018 */     jDialog22Layout.setHorizontalGroup(jDialog22Layout
/* 3019 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3020 */         .addComponent(this.jPanel165, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 3022 */     jDialog22Layout.setVerticalGroup(jDialog22Layout
/* 3023 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3024 */         .addGroup(jDialog22Layout.createSequentialGroup()
/* 3025 */           .addComponent(this.jPanel165, -2, -1, -2)
/* 3026 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3029 */     this.jDialog4.setTitle("XML Faltantes");
/*      */     
/* 3031 */     this.jLabel45.setText("Algunos complementos  no tienen registrado su archivo XML.");
/*      */     
/* 3033 */     this.jLabel46.setText("Por favor, carga el archivo correspondiente para continuar con el proceso.");
/*      */     
/* 3035 */     this.rSTableMetro22.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3043 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3048 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3051 */     this.rSTableMetro22.setAltoHead(25);
/* 3052 */     this.rSTableMetro22.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3053 */     this.rSTableMetro22.setColorBordeFilas(new Color(200, 200, 200));
/* 3054 */     this.rSTableMetro22.setColorBordeHead(this.lc.PRIMARIO1);
/* 3055 */     this.rSTableMetro22.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3056 */     this.rSTableMetro22.setColorFilasForeground1(this.lc.SECUNDARIO1);
/* 3057 */     this.rSTableMetro22.setColorFilasForeground2(this.lc.SECUNDARIO1);
/* 3058 */     this.rSTableMetro22.setColorSelBackgound(this.lc.PRIMARIO2);
/* 3059 */     this.rSTableMetro22.setFont(new Font("Cantarell", 0, 10));
/* 3060 */     this.rSTableMetro22.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 3061 */     this.rSTableMetro22.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 3062 */     this.rSTableMetro22.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3063 */     this.rSTableMetro22.setGrosorBordeFilas(0);
/* 3064 */     this.rSTableMetro22.setSelectionBackground(this.lc.PRIMARIO2);
/* 3065 */     this.rSTableMetro22.getTableHeader().setResizingAllowed(false);
/* 3066 */     this.rSTableMetro22.getTableHeader().setReorderingAllowed(false);
/* 3067 */     this.rSTableMetro22.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3069 */             complementoPagos.this.rSTableMetro22MouseClicked(evt);
/*      */           }
/*      */         });
/* 3072 */     this.rSTableMetro22.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3074 */             complementoPagos.this.rSTableMetro22KeyReleased(evt);
/*      */           }
/*      */         });
/* 3077 */     this.jScrollPane41.setViewportView((Component)this.rSTableMetro22);
/*      */     
/* 3079 */     this.jPanel175.setBackground(this.lc.SECUNDARIO1);
/* 3080 */     this.jPanel175.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 3082 */     this.jLabel242.setFont(new Font("Cantarell", 0, 13));
/* 3083 */     this.jLabel242.setForeground(this.lc.TERCERO1);
/* 3084 */     this.jLabel242.setHorizontalAlignment(4);
/* 3085 */     this.jLabel242.setText("Total: ");
/* 3086 */     this.jPanel175.add(this.jLabel242);
/*      */     
/* 3088 */     this.jLabel86.setFont(new Font("Cantarell", 1, 13));
/* 3089 */     this.jLabel86.setForeground(this.lc.PRIMARIO2);
/* 3090 */     this.jLabel86.setHorizontalAlignment(0);
/* 3091 */     this.jLabel86.setText("t");
/* 3092 */     this.jPanel175.add(this.jLabel86);
/*      */     
/* 3094 */     this.jButton62.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/* 3095 */     this.jButton62.setMnemonic('F');
/* 3096 */     this.jButton62.setText("Folio Fiscal");
/* 3097 */     this.jButton62.setToolTipText("Folio Fiscal (Alt+F)");
/* 3098 */     this.jButton62.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3100 */             complementoPagos.this.jButton62ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3104 */     GroupLayout jPanel154Layout = new GroupLayout(this.jPanel154);
/* 3105 */     this.jPanel154.setLayout(jPanel154Layout);
/* 3106 */     jPanel154Layout.setHorizontalGroup(jPanel154Layout
/* 3107 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3108 */         .addGroup(jPanel154Layout.createSequentialGroup()
/* 3109 */           .addContainerGap()
/* 3110 */           .addGroup(jPanel154Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3111 */             .addComponent(this.jLabel45, -1, -1, 32767)
/* 3112 */             .addComponent(this.jLabel46, GroupLayout.Alignment.TRAILING, -1, 692, 32767)
/* 3113 */             .addComponent(this.jScrollPane41, GroupLayout.Alignment.TRAILING)
/* 3114 */             .addGroup(jPanel154Layout.createSequentialGroup()
/* 3115 */               .addComponent(this.jPanel175, -2, 115, -2)
/* 3116 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3117 */               .addComponent(this.jButton62)))
/* 3118 */           .addContainerGap()));
/*      */     
/* 3120 */     jPanel154Layout.setVerticalGroup(jPanel154Layout
/* 3121 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3122 */         .addGroup(jPanel154Layout.createSequentialGroup()
/* 3123 */           .addContainerGap()
/* 3124 */           .addComponent(this.jLabel45)
/* 3125 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3126 */           .addComponent(this.jLabel46)
/* 3127 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3128 */           .addComponent(this.jScrollPane41, -1, 220, 32767)
/* 3129 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3130 */           .addGroup(jPanel154Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3131 */             .addComponent(this.jPanel175, -2, 31, -2)
/* 3132 */             .addComponent(this.jButton62))));
/*      */ 
/*      */     
/* 3135 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 3136 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 3137 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 3138 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3139 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 3140 */           .addGap(0, 0, 0)
/* 3141 */           .addComponent(this.jPanel154, -1, -1, 32767)));
/*      */     
/* 3143 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 3144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3145 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 3146 */           .addGap(0, 0, 0)
/* 3147 */           .addComponent(this.jPanel154, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3150 */     this.jPanel21.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3152 */     this.jPanel22.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3154 */     this.jLabel78.setFont(new Font("Cantarell", 1, 22));
/* 3155 */     this.jLabel78.setForeground(this.lc.PRIMARIO1);
/* 3156 */     this.jLabel78.setText("Complemento de pagos");
/*      */     
/* 3158 */     this.jPanel52.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3160 */     this.jPanel60.setBackground(this.lc.SECUNDARIO2);
/* 3161 */     this.jPanel60.setLayout(new GridBagLayout());
/*      */     
/* 3163 */     this.jDateChooser9.setDate(this.fechaActual);
/* 3164 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/* 3165 */     this.jDateChooser9.setIcon(this.icon);
/* 3166 */     this.jDateChooser9.setMinSelectableDate(this.fechaInicio);
/* 3167 */     gridBagConstraints = new GridBagConstraints();
/* 3168 */     gridBagConstraints.gridx = 2;
/* 3169 */     gridBagConstraints.gridy = 0;
/* 3170 */     gridBagConstraints.fill = 2;
/* 3171 */     gridBagConstraints.weightx = 1.0D;
/* 3172 */     this.jPanel60.add((Component)this.jDateChooser9, gridBagConstraints);
/*      */     
/* 3174 */     this.jLabel235.setFont(new Font("Cantarell", 0, 11));
/* 3175 */     this.jLabel235.setHorizontalAlignment(0);
/* 3176 */     this.jLabel235.setText("     al     ");
/* 3177 */     gridBagConstraints = new GridBagConstraints();
/* 3178 */     gridBagConstraints.gridx = 4;
/* 3179 */     gridBagConstraints.gridy = 0;
/* 3180 */     gridBagConstraints.fill = 2;
/* 3181 */     this.jPanel60.add(this.jLabel235, gridBagConstraints);
/*      */     
/* 3183 */     this.jDateChooser10.setDate(this.fechaActual);
/* 3184 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/* 3185 */     this.jDateChooser10.setIcon(this.icon);
/* 3186 */     this.jDateChooser10.setMinSelectableDate(this.fechaInicio);
/* 3187 */     gridBagConstraints = new GridBagConstraints();
/* 3188 */     gridBagConstraints.gridx = 6;
/* 3189 */     gridBagConstraints.gridy = 0;
/* 3190 */     gridBagConstraints.fill = 2;
/* 3191 */     gridBagConstraints.weightx = 1.0D;
/* 3192 */     this.jPanel60.add((Component)this.jDateChooser10, gridBagConstraints);
/*      */     
/* 3194 */     this.jComboBox36.setBackground(new Color(255, 255, 255));
/* 3195 */     this.jComboBox36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3197 */             complementoPagos.this.jComboBox36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3200 */     gridBagConstraints = new GridBagConstraints();
/* 3201 */     gridBagConstraints.gridx = 0;
/* 3202 */     gridBagConstraints.gridy = 0;
/* 3203 */     this.jPanel60.add(this.jComboBox36, gridBagConstraints);
/*      */     
/* 3205 */     this.jPanel62.setBackground(this.lc.SECUNDARIO2);
/* 3206 */     this.jPanel62.setLayout(new GridBagLayout());
/*      */     
/* 3208 */     this.jLabel236.setFont(new Font("Cantarell", 0, 11));
/* 3209 */     this.jLabel236.setHorizontalAlignment(4);
/* 3210 */     this.jLabel236.setText("Visualizando información de ");
/* 3211 */     this.jPanel62.add(this.jLabel236, new GridBagConstraints());
/*      */     
/* 3213 */     this.jComboBox37.setBackground(new Color(255, 255, 255));
/* 3214 */     this.jComboBox37.setModel(new DefaultComboBoxModel<>(new String[] { "PERIODO LIBRE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/* 3215 */     this.jComboBox37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3217 */             complementoPagos.this.jComboBox37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3220 */     this.jPanel62.add(this.jComboBox37, new GridBagConstraints());
/*      */     
/* 3222 */     this.jPanel63.setBackground(this.lc.SECUNDARIO2);
/* 3223 */     this.jPanel63.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 3225 */     this.jButton16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 3226 */     this.jButton16.setMnemonic('F');
/* 3227 */     this.jButton16.setToolTipText("Filtrar información (Alt+F)");
/* 3228 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3230 */             complementoPagos.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3233 */     this.jPanel63.add(this.jButton16);
/*      */     
/* 3235 */     this.jLabel172.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 3236 */     this.jLabel172.setForeground(new Color(15, 87, 51));
/* 3237 */     this.jLabel172.setHorizontalAlignment(0);
/* 3238 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 3239 */     this.jLabel172.setToolTipText("Retroceder un día en la búsqueda");
/* 3240 */     this.jLabel172.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3242 */             complementoPagos.this.jLabel172MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3245 */             complementoPagos.this.jLabel172MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3248 */             complementoPagos.this.jLabel172MouseExited(evt);
/*      */           }
/*      */         });
/* 3251 */     this.jPanel63.add(this.jLabel172);
/*      */     
/* 3253 */     this.jLabel103.setFont(new Font("Tahoma", 2, 12));
/* 3254 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 3255 */     this.jLabel103.setHorizontalAlignment(0);
/* 3256 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 3257 */     this.jLabel103.setToolTipText("Clic para filtrar los datos de HOY");
/* 3258 */     this.jLabel103.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3260 */             complementoPagos.this.jLabel103MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3263 */             complementoPagos.this.jLabel103MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3266 */             complementoPagos.this.jLabel103MouseExited(evt);
/*      */           }
/*      */         });
/* 3269 */     this.jPanel63.add(this.jLabel103);
/*      */     
/* 3271 */     this.jLabel173.setHorizontalAlignment(0);
/* 3272 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 3273 */     this.jLabel173.setToolTipText("Aumentar un día en la búsqueda");
/* 3274 */     this.jLabel173.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3276 */             complementoPagos.this.jLabel173MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3279 */             complementoPagos.this.jLabel173MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3282 */             complementoPagos.this.jLabel173MouseExited(evt);
/*      */           }
/*      */         });
/* 3285 */     this.jPanel63.add(this.jLabel173);
/*      */     
/* 3287 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 3288 */     this.jPanel52.setLayout(jPanel52Layout);
/* 3289 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 3290 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3291 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 3292 */           .addComponent(this.jPanel62, -2, -1, -2)
/* 3293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3294 */           .addComponent(this.jPanel60, -2, 370, -2)
/* 3295 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3296 */           .addComponent(this.jPanel63, -2, 132, -2)
/* 3297 */           .addContainerGap(-1, 32767)));
/*      */     
/* 3299 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 3300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3301 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 3302 */           .addContainerGap()
/* 3303 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3304 */             .addComponent(this.jPanel62, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 3305 */             .addComponent(this.jPanel60, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 3306 */             .addComponent(this.jPanel63, GroupLayout.Alignment.TRAILING, -1, -1, 32767))));
/*      */ 
/*      */     
/* 3309 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 3310 */     this.jPanel22.setLayout(jPanel22Layout);
/* 3311 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 3312 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3313 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 3314 */           .addComponent(this.jLabel78, -2, 263, -2)
/* 3315 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3316 */           .addComponent(this.jPanel52, -2, -1, -2)
/* 3317 */           .addContainerGap()));
/*      */     
/* 3319 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 3320 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3321 */         .addComponent(this.jPanel52, -1, -1, 32767)
/* 3322 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 3323 */           .addContainerGap()
/* 3324 */           .addComponent(this.jLabel78, -2, 21, -2)
/* 3325 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3328 */     this.jPanel34.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3330 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 3331 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de depósitos", 0, 1, new Font("Cantarell", 0, 11)));
/*      */     
/* 3333 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3335 */             complementoPagos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3339 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 3340 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 3341 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3343 */             complementoPagos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3347 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 3348 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 3349 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3351 */             complementoPagos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3355 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 3356 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "<Cancelado>", "<Por Timbrar>", "<Timbrado>" }));
/* 3357 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3359 */             complementoPagos.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3363 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 3364 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "MONEDA", "MXN", "USD" }));
/* 3365 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3367 */             complementoPagos.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3371 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 3372 */     this.jPanel17.setLayout(jPanel17Layout);
/* 3373 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 3374 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3375 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 3376 */           .addComponent(this.jTextField1, -2, 87, -2)
/* 3377 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3378 */           .addComponent(this.jComboBox6, -2, 149, -2)
/* 3379 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3380 */           .addComponent(this.jComboBox1, -2, 380, -2)
/* 3381 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3382 */           .addComponent(this.jComboBox2, -2, 181, -2)
/* 3383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3384 */           .addComponent(this.jComboBox3, -2, 181, -2)
/* 3385 */           .addContainerGap(-1, 32767)));
/*      */     
/* 3387 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 3388 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3389 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3390 */           .addComponent(this.jTextField1, -2, -1, -2)
/* 3391 */           .addComponent(this.jComboBox6, -2, -1, -2))
/* 3392 */         .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3393 */           .addComponent(this.jComboBox1, -2, -1, -2)
/* 3394 */           .addComponent(this.jComboBox2, -2, -1, -2)
/* 3395 */           .addComponent(this.jComboBox3, -2, -1, -2)));
/*      */ 
/*      */     
/* 3398 */     this.jPanel35.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 3400 */     this.jPanel36.setBackground(this.lc.SECUNDARIO2);
/* 3401 */     this.jPanel36.setLayout(new GridLayout(1, 9, 6, 0));
/*      */     
/* 3403 */     this.jPanel37.setBackground(this.lc.SECUNDARIO1);
/* 3404 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3406 */     this.jLabel10.setFont(new Font("Cantarell", 0, 13));
/* 3407 */     this.jLabel10.setForeground(this.lc.TERCERO1);
/* 3408 */     this.jLabel10.setHorizontalAlignment(4);
/* 3409 */     this.jLabel10.setText("Total");
/* 3410 */     this.jPanel37.add(this.jLabel10);
/*      */     
/* 3412 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 3413 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 3414 */     this.jLabel48.setHorizontalAlignment(0);
/* 3415 */     this.jLabel48.setText("t");
/* 3416 */     this.jPanel37.add(this.jLabel48);
/*      */     
/* 3418 */     this.jPanel36.add(this.jPanel37);
/*      */     
/* 3420 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 3421 */     this.jButton24.setMnemonic('N');
/* 3422 */     this.jButton24.setText("Nuevo");
/* 3423 */     this.jButton24.setToolTipText("Nuevo Documento (Alt+N)");
/* 3424 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3426 */             complementoPagos.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3429 */     this.jPanel36.add(this.jButton24);
/*      */     
/* 3431 */     this.jButton60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/* 3432 */     this.jButton60.setMnemonic('F');
/* 3433 */     this.jButton60.setText("Folio Fiscal");
/* 3434 */     this.jButton60.setToolTipText("Folio Fiscal (Alt+F)");
/* 3435 */     this.jButton60.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3437 */             complementoPagos.this.jButton60ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3440 */     this.jPanel36.add(this.jButton60);
/*      */     
/* 3442 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 3443 */     this.jButton25.setMnemonic('N');
/* 3444 */     this.jButton25.setText("Modificar");
/* 3445 */     this.jButton25.setToolTipText("Nuevo Documento (Alt+N)");
/* 3446 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3448 */             complementoPagos.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3451 */     this.jPanel36.add(this.jButton25);
/*      */     
/* 3453 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 3454 */     this.jButton23.setMnemonic('V');
/* 3455 */     this.jButton23.setText("Ver");
/* 3456 */     this.jButton23.setToolTipText("Ver Documento(Alt+V)");
/* 3457 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3459 */             complementoPagos.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3462 */     this.jPanel36.add(this.jButton23);
/*      */     
/* 3464 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 3465 */     this.jButton26.setMnemonic('C');
/* 3466 */     this.jButton26.setText("Cancelar");
/* 3467 */     this.jButton26.setToolTipText("Cancelar Documentos (Alt+C)");
/* 3468 */     this.jButton26.setEnabled(false);
/* 3469 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3471 */             complementoPagos.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3474 */     this.jPanel36.add(this.jButton26);
/*      */     
/* 3476 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Refresh.png")));
/* 3477 */     this.jButton27.setMnemonic('E');
/* 3478 */     this.jButton27.setText("Cambiar de estado");
/* 3479 */     this.jButton27.setToolTipText("Camibar de estado (Alt+E)");
/* 3480 */     this.jButton27.setEnabled(false);
/* 3481 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3483 */             complementoPagos.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3486 */     this.jPanel36.add(this.jButton27);
/*      */     
/* 3488 */     this.jButton20.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 3489 */     this.jButton20.setMnemonic('G');
/* 3490 */     this.jButton20.setText("Guardar Reporte");
/* 3491 */     this.jButton20.setToolTipText("Guardar Reporte (Alt+G)");
/* 3492 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3494 */             complementoPagos.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3497 */     this.jPanel36.add(this.jButton20);
/*      */     
/* 3499 */     this.jPanel5.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 3501 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 3502 */     this.jPanel5.setLayout(jPanel5Layout);
/* 3503 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 3504 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3505 */         .addGap(0, 164, 32767));
/*      */     
/* 3507 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 3508 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3509 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 3512 */     this.jPanel36.add(this.jPanel5);
/*      */     
/* 3514 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3522 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3527 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3530 */     this.rSTableMetro1.setAltoHead(40);
/* 3531 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3532 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 3533 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 3534 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3535 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 3536 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 3537 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 3538 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3539 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3540 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3541 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 3542 */     this.rSTableMetro1.setRowHeight(18);
/* 3543 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 3544 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 3545 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3546 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3548 */             complementoPagos.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3551 */             complementoPagos.this.rSTableMetro1MouseEntered(evt);
/*      */           }
/*      */         });
/* 3554 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3556 */             complementoPagos.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 3559 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 3561 */     this.jPanel7.setBorder(BorderFactory.createBevelBorder(1));
/* 3562 */     this.jPanel7.setLayout(new GridLayout(1, 6, 15, 0));
/*      */     
/* 3564 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 3565 */     this.jLabel35.setHorizontalAlignment(4);
/* 3566 */     this.jLabel35.setText("SUMAS DE MXN: ");
/* 3567 */     this.jPanel7.add(this.jLabel35);
/*      */     
/* 3569 */     this.jLabel31.setFont(new Font("Tahoma", 0, 10));
/* 3570 */     this.jLabel31.setHorizontalAlignment(2);
/* 3571 */     this.jLabel31.setText("jLabel31");
/* 3572 */     this.jPanel7.add(this.jLabel31);
/*      */     
/* 3574 */     this.jLabel43.setFont(new Font("Tahoma", 1, 11));
/* 3575 */     this.jLabel43.setHorizontalAlignment(4);
/* 3576 */     this.jLabel43.setText("SUMAS DE DLS: ");
/* 3577 */     this.jPanel7.add(this.jLabel43);
/*      */     
/* 3579 */     this.jLabel34.setFont(new Font("Tahoma", 0, 10));
/* 3580 */     this.jLabel34.setHorizontalAlignment(2);
/* 3581 */     this.jLabel34.setText("jLabel34");
/* 3582 */     this.jPanel7.add(this.jLabel34);
/*      */     
/* 3584 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/* 3585 */     this.jLabel39.setHorizontalAlignment(4);
/* 3586 */     this.jLabel39.setText("SUMAS CONVERTIDOS EN PESOS:");
/* 3587 */     this.jPanel7.add(this.jLabel39);
/*      */     
/* 3589 */     this.jLabel32.setFont(new Font("Tahoma", 0, 10));
/* 3590 */     this.jLabel32.setHorizontalAlignment(2);
/* 3591 */     this.jLabel32.setText("jLabel32");
/* 3592 */     this.jPanel7.add(this.jLabel32);
/*      */     
/* 3594 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/* 3595 */     this.jLabel41.setHorizontalAlignment(4);
/* 3596 */     this.jLabel41.setText("FLUCTUACION: ");
/* 3597 */     this.jPanel7.add(this.jLabel41);
/*      */     
/* 3599 */     this.jLabel33.setFont(new Font("Tahoma", 0, 10));
/* 3600 */     this.jLabel33.setHorizontalAlignment(2);
/* 3601 */     this.jLabel33.setText("jLabel33");
/* 3602 */     this.jPanel7.add(this.jLabel33);
/*      */     
/* 3604 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 3605 */     this.jPanel35.setLayout(jPanel35Layout);
/* 3606 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 3607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3608 */         .addComponent(this.jPanel36, -2, 0, 32767)
/* 3609 */         .addComponent(this.jScrollPane29)
/* 3610 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 3612 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 3613 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3614 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 3615 */           .addComponent(this.jPanel36, -2, 31, -2)
/* 3616 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3617 */           .addComponent(this.jScrollPane29, -1, 268, 32767)
/* 3618 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3619 */           .addComponent(this.jPanel7, -2, -1, -2)));
/*      */ 
/*      */     
/* 3622 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 3623 */     this.jPanel34.setLayout(jPanel34Layout);
/* 3624 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 3625 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3626 */         .addComponent(this.jPanel35, -1, -1, 32767)
/* 3627 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*      */     
/* 3629 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 3630 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3631 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 3632 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 3633 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3634 */           .addComponent(this.jPanel35, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3637 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 3638 */     this.jPanel21.setLayout(jPanel21Layout);
/* 3639 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 3640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3641 */         .addComponent(this.jPanel22, -1, -1, 32767)
/* 3642 */         .addComponent(this.jPanel34, -1, -1, 32767));
/*      */     
/* 3644 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 3645 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3646 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 3647 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 3648 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3649 */           .addComponent(this.jPanel34, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3652 */     GroupLayout layout = new GroupLayout(this);
/* 3653 */     setLayout(layout);
/* 3654 */     layout.setHorizontalGroup(layout
/* 3655 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3656 */         .addGap(0, 1525, 32767)
/* 3657 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3658 */           .addComponent(this.jPanel21, -1, -1, 32767)));
/*      */     
/* 3660 */     layout.setVerticalGroup(layout
/* 3661 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3662 */         .addGap(0, 423, 32767)
/* 3663 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3664 */           .addComponent(this.jPanel21, -1, -1, 32767)));
/*      */   }
/*      */   private JPanel jPanel92; private JScrollPane jScrollPane18; private JScrollPane jScrollPane19; private JScrollPane jScrollPane20; private JScrollPane jScrollPane25; private JScrollPane jScrollPane29; private JScrollPane jScrollPane31; private JScrollPane jScrollPane32; private JScrollPane jScrollPane33; private JScrollPane jScrollPane34; private JScrollPane jScrollPane41; private JScrollPane jScrollPane5; private JScrollPane jScrollPane8; private JSeparator jSeparator1; private JSeparator jSeparator4; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JTextArea jTextArea1; private JTextArea jTextArea5; private JTextArea jTextArea6; private JTextField jTextField1; private JTextField jTextField104; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField2; private JTextField jTextField24; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField71; private JTextField jTextField8; private JTextField jTextField85; private JTextField jTextField87; private JTextField jTextField88; private JTextField jTextField91; private JTextField jTextField98; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton23; private MaterialButton materialButton24; private MaterialButton materialButton26; private MaterialButton materialButton36; private MaterialButton materialButton37; private MaterialButton materialButton38; private MaterialButton materialButton39; private MaterialButton materialButton40; private MaterialButton materialButton41; private MaterialButton materialButton42; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro20; private RSTableMetro rSTableMetro22; private RSTableMetro rSTableMetro5; private RSTableMetro rSTableMetro6; private RSTableMetro rSTableMetro7; private RSTableMetro rSTableMetro8; private RSTableMetro rSTableMetro9;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 3669 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3673 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 3674 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3679 */     if (this.jTextField1.getText().equals(this.holderFolio)) {
/* 3680 */       consultar();
/*      */     } else {
/* 3682 */       this.encontrado = this.con.consultar("fechaCaptura", "complementopagos", "where folioPago like '%" + this.jTextField1.getText() + "%' order by fechaCaptura desc");
/* 3683 */       String f = this.con.Campo;
/* 3684 */       if (this.encontrado) {
/* 3685 */         String año = f.substring(0, 4);
/* 3686 */         String mes = f.substring(5, 7);
/* 3687 */         String dia = f.substring(8, 10);
/* 3688 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3689 */         String strFecha = año + "-" + año + "-" + mes;
/* 3690 */         Date fecha = null;
/*      */         try {
/* 3692 */           fecha = formatoDelTexto.parse(strFecha);
/* 3693 */         } catch (ParseException ex) {
/* 3694 */           ex.printStackTrace();
/*      */         } 
/* 3696 */         this.jDateChooser4.setDate(fecha);
/* 3697 */         this.jDateChooser5.setDate(fecha);
/*      */       } 
/* 3699 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 3704 */     if (this.jComboBox2.getItemCount() > 0 && this.PRIMERA == true) {
/* 3705 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 3710 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3711 */       this.jTextField14.setText(this.RFC.get(this.jComboBox4.getSelectedItem()).toString());
/* 3712 */       this.jTextArea1.setText("REGIMEN FISCAL: " + String.valueOf(this.REGIMENES.get(this.jComboBox4.getSelectedItem())) + "\n" + String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + ", " + String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + ", " + String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + ", " + String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + ", " + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())));
/* 3713 */       this.con.consultar("tarjeta", "tarjeta_deudor_cliente", "where nombreCompleto = '" + String.valueOf(this.jComboBox4.getSelectedItem()) + "'");
/* 3714 */       this.CLAVECLIENTE = this.con.Campo;
/*      */       
/* 3716 */       if (this.TODOS_EMISORBANCOCLIENTES.contains(this.jComboBox4.getSelectedItem())) {
/* 3717 */         int cont = 0;
/* 3718 */         int indice = 0;
/* 3719 */         for (bancosEmisores ba : this.BANCOS) {
/* 3720 */           if (ba.getCliente().equals(this.jComboBox4.getSelectedItem())) {
/* 3721 */             indice = cont;
/*      */           }
/* 3723 */           cont++;
/*      */         } 
/* 3725 */         this.jTextField27.setText(this.BANCOS[indice].getRfcBanco());
/* 3726 */         this.jTextField28.setText(this.BANCOS[indice].getBanco());
/* 3727 */         this.jTextField29.setText(this.BANCOS[indice].getCuentaBanco());
/*      */         
/* 3729 */         this.jTextField30.setText(this.BANCOS[indice].getReceptorRfc());
/* 3730 */         this.jTextField32.setText(this.BANCOS[indice].getReceptorBanco());
/*      */ 
/*      */         
/* 3733 */         this.jTextField31.setText(this.BANCOS[indice].getReceptorCuenta());
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 3739 */         this.jTextField27.setText("");
/* 3740 */         this.jTextField28.setText("");
/* 3741 */         this.jTextField29.setText("");
/*      */         
/* 3743 */         this.jTextField30.setText("");
/* 3744 */         this.jTextField32.setText("");
/* 3745 */         this.jTextField31.setText("");
/*      */       } 
/*      */     } else {
/*      */       
/* 3749 */       this.jTextArea1.setText("");
/*      */       
/* 3751 */       this.jTextField27.setText("");
/* 3752 */       this.jTextField28.setText("");
/* 3753 */       this.jTextField29.setText("");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 3759 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 3760 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 3765 */     String estado = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15).toString();
/* 3766 */     if (estado.equals("<Por Timbrar>")) {
/* 3767 */       String tipo = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 16).toString();
/* 3768 */       if (tipo.equals("1.0")) {
/* 3769 */         this.VERSION = 1;
/*      */         
/* 3771 */         limpiar();
/* 3772 */         bloquear();
/* 3773 */         verComplemento();
/* 3774 */         desbloquear();
/* 3775 */       } else if (tipo.equals("2.0")) {
/* 3776 */         limpiar();
/* 3777 */         this.VERSION = 2;
/*      */         
/* 3779 */         convertir20();
/*      */         
/* 3781 */         cargarImpuestos20(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString());
/* 3782 */         verComplemento();
/* 3783 */         this.jDateChooser8.setDate(new Date());
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3793 */       this.materialButton20.setText("Modificar");
/* 3794 */       this.materialButton20.setToolTipText("Modificar (Alt+M)");
/* 3795 */       this.materialButton20.setMnemonic('M');
/* 3796 */       this.jDialog1.setTitle("Modificar el complemento de pago " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)));
/* 3797 */       this.jDialog1.setVisible(true);
/*      */     } else {
/* 3799 */       JOptionPane.showMessageDialog(this, "No puedes modificar complementos de pago ya timbrados o cancelados", "Complemento timbrado", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 3804 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 3805 */     String valor = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15));
/* 3806 */     if (ind < 0) {
/* 3807 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder cancelar los datos", "Selecciona un documento", 0, this.ADVER);
/* 3808 */     } else if (valor.equals("<Timbrado y Aplicado>")) {
/* 3809 */       JOptionPane.showMessageDialog(this.padre, "Para cancelar un documento, debe estar en estatus ='<Por Timbrar>' o '<Timbrado>'", "No se puede cancelar", 0, this.ADVER);
/*      */     } else {
/* 3811 */       this.jTextArea5.setText("");
/* 3812 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 3817 */     nuevoComplemento();
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
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 3831 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, "COMPLEMENTOS DE PAGO");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 3837 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 3838 */     if (ind < 0) {
/* 3839 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder ver los datos", "Selecciona un documento", 0, this.ADVER);
/*      */     } else {
/* 3841 */       limpiar();
/*      */       
/* 3843 */       bloquear();
/* 3844 */       String tipo = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 16).toString();
/*      */       
/* 3846 */       if (tipo.equals("1.0")) {
/* 3847 */         this.VERSION = 1;
/* 3848 */         convertir10();
/* 3849 */         verComplemento();
/*      */       }
/* 3851 */       else if (tipo.equals("2.0")) {
/* 3852 */         this.VERSION = 2;
/*      */         
/* 3854 */         convertir20();
/* 3855 */         System.out.println("Complemento.... " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString());
/* 3856 */         cargarImpuestos20(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString());
/* 3857 */         verComplemento();
/*      */       } 
/*      */       
/* 3860 */       this.jDialog1.setTitle("Ver complemento de pago " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)) + ", Estado: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 8)));
/* 3861 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel170MouseClicked(MouseEvent evt) {
/* 3866 */     Calendar fecha = this.jDateChooser4.getCalendar();
/* 3867 */     int aa = fecha.get(1);
/* 3868 */     int mm = fecha.get(2);
/* 3869 */     int dd = fecha.get(5);
/* 3870 */     if (dd == 1) {
/* 3871 */       if (mm == 0) {
/* 3872 */         mm = 11;
/* 3873 */         aa--;
/*      */       } else {
/* 3875 */         mm--;
/*      */       } 
/* 3877 */       int diasTotal = diasDelMes(mm, aa);
/* 3878 */       dd = diasTotal;
/*      */     } else {
/* 3880 */       dd--;
/*      */     } 
/* 3882 */     mm++;
/* 3883 */     String año = "" + aa;
/* 3884 */     String mes = "" + mm;
/* 3885 */     String dia = "" + dd;
/* 3886 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3887 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 3889 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 3890 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 3891 */     } catch (ParseException ex) {
/* 3892 */       ex.printStackTrace();
/*      */     } 
/* 3894 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel170MouseExited(MouseEvent evt) {
/* 3898 */     this.jLabel170.setForeground(new Color(15, 87, 51));
/* 3899 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel170MouseEntered(MouseEvent evt) {
/* 3903 */     this.jLabel170.setForeground(new Color(153, 255, 153));
/* 3904 */     this.jLabel170.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseClicked(MouseEvent evt) {
/* 3908 */     this.jDateChooser4.setDate(this.fechaActual);
/* 3909 */     this.jDateChooser5.setDate(this.fechaActual);
/* 3910 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel101MouseExited(MouseEvent evt) {
/* 3914 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 3915 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel101MouseEntered(MouseEvent evt) {
/* 3919 */     this.jLabel101.setForeground(new Color(153, 255, 153));
/* 3920 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseClicked(MouseEvent evt) {
/* 3924 */     Calendar calendar = this.jDateChooser4.getCalendar();
/* 3925 */     calendar.setTime(this.jDateChooser4.getDate());
/* 3926 */     calendar.add(6, 1);
/* 3927 */     this.jDateChooser4.setCalendar(calendar);
/* 3928 */     this.jDateChooser5.setCalendar(calendar);
/* 3929 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel171MouseExited(MouseEvent evt) {
/* 3933 */     this.jLabel171.setForeground(new Color(15, 87, 51));
/* 3934 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel171MouseEntered(MouseEvent evt) {
/* 3938 */     this.jLabel171.setForeground(new Color(153, 255, 153));
/* 3939 */     this.jLabel171.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox18ActionPerformed(ActionEvent evt) {
/* 3947 */     if (this.jTextField32.isEnabled());
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
/*      */   private void jButton55ActionPerformed(ActionEvent evt) {
/* 3966 */     Dimension di = this.jButton55.getSize();
/* 3967 */     Point p = this.jButton55.getLocationOnScreen();
/* 3968 */     this.jDialog17.setLocation(p.x + di.width - 200, p.y + 30);
/* 3969 */     if (this.jTextField32.isEnabled())
/*      */     {
/* 3971 */       validarDolar();
/*      */     }
/* 3973 */     this.jDialog17.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton49ActionPerformed(ActionEvent evt) {
/* 3977 */     this.materialButton42.setText("Agregar");
/* 3978 */     this.materialButton42.setMnemonic('A');
/* 3979 */     this.materialButton42.setToolTipText("Agregar Leyenda (Alt+M)");
/* 3980 */     this.jDialog18.setTitle("Agregar Leyenda");
/* 3981 */     this.jTextField87.setText("");
/* 3982 */     this.jTextField88.setText("");
/* 3983 */     this.place = new PlaceHolder(this.jTextField87, "Ejemplo: ANEXO");
/* 3984 */     this.place = new PlaceHolder(this.jTextField88, "Ejemplo: Se agregan guías para su revisión con soportes en físico. Guías: PR-98293");
/* 3985 */     this.jDialog18.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton50ActionPerformed(ActionEvent evt) {
/* 3989 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 3990 */     if (ind < 0) {
/* 3991 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar una leyenda para poder modificarla", "Selecciona una leyenda", 0, this.ADVER);
/*      */     } else {
/* 3993 */       this.jTextField87.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0).toString());
/* 3994 */       this.jTextField88.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1).toString());
/*      */       
/* 3996 */       this.materialButton42.setText("Modificar");
/* 3997 */       this.materialButton42.setMnemonic('M');
/* 3998 */       this.materialButton42.setToolTipText("Modificar Leyenda (Alt+M)");
/* 3999 */       this.jDialog18.setTitle("Modificar Leyenda");
/* 4000 */       this.jDialog18.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton51ActionPerformed(ActionEvent evt) {
/* 4006 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 4007 */     if (ind < 0) {
/* 4008 */       JOptionPane.showMessageDialog(this.jDialog18, "Necesitas seleccionar una leyenda para poder quitarla", "Selecciona una leyenda", 0, this.ADVER);
/*      */     } else {
/* 4010 */       DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro5.getModel();
/* 4011 */       temp.removeRow(ind);
/* 4012 */       contarLeyendas();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton52ActionPerformed(ActionEvent evt) {
/* 4017 */     if (this.VERSION == 1) {
/* 4018 */       if (this.jComboBox4.getSelectedIndex() > 0) {
/* 4019 */         if (this.materialButton20.getText().equals("Guardar") || this.materialButton20.getText().equals("Modificar")) {
/* 4020 */           String cliente = this.jComboBox4.getSelectedItem().toString();
/* 4021 */           String ponerCliente = dameCliente(cliente);
/* 4022 */           if (this.jTextField12.getText().equals("")) {
/* 4023 */             this.jTextField12.setText(ponerCliente);
/* 4024 */             buscarGuias();
/*      */           } 
/*      */         } 
/*      */       } else {
/* 4028 */         buscarGuias();
/*      */       } 
/* 4030 */       this.utilerias.activarVentanajDialog(this.jDialog9, 820, 350);
/* 4031 */       this.jDialog9.setVisible(true);
/* 4032 */     } else if (this.VERSION == 2) {
/* 4033 */       if (this.jComboBox4.getSelectedIndex() > 0) {
/* 4034 */         if (this.materialButton20.getText().equals("Guardar") || this.materialButton20.getText().equals("Modificar")) {
/* 4035 */           String cliente = this.jComboBox4.getSelectedItem().toString();
/* 4036 */           String ponerCliente = dameCliente(cliente);
/* 4037 */           if (this.jTextField12.getText().equals("")) {
/* 4038 */             this.jTextField12.setText(ponerCliente);
/* 4039 */             buscarGuias20();
/*      */           } 
/*      */         } 
/*      */       } else {
/* 4043 */         buscarGuias20();
/*      */       } 
/* 4045 */       this.utilerias.activarVentanajDialog(this.jDialog9, 950, 450);
/* 4046 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton54ActionPerformed(ActionEvent evt) {
/* 4051 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 4052 */     if (ind < 0) {
/* 4053 */       JOptionPane.showMessageDialog(this.jDialog18, "Necesitas seleccionar una factura para poder modificarla", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 4055 */       if (this.VERSION == 1) {
/* 4056 */         this.jTextField2.setText("N/A");
/* 4057 */         this.jTextField3.setText("N/A");
/* 4058 */         this.jTextField4.setText("N/A");
/*      */         
/* 4060 */         String valor = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5).toString();
/* 4061 */         double CANTIDAD = convertirCantTexto(valor);
/* 4062 */         this.jFormattedTextField6.setValue(Double.valueOf(CANTIDAD));
/* 4063 */       } else if (this.VERSION == 2) {
/* 4064 */         String valor = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4).toString();
/* 4065 */         double CANTIDAD = convertirCantTexto(valor);
/* 4066 */         this.jFormattedTextField6.setValue(Double.valueOf(CANTIDAD));
/*      */         
/* 4068 */         double facIva = 0.0D;
/* 4069 */         double facRet = 0.0D;
/*      */         
/* 4071 */         double ret = 0.0D;
/* 4072 */         double iva = 0.0D;
/*      */         
/* 4074 */         if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 6).toString().equals("0.16 / $0.00")) {
/* 4075 */           facIva = 0.16D;
/*      */         }
/*      */         
/* 4078 */         if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 7).toString().equals("0.04 / $0.00")) {
/* 4079 */           facRet = 0.04D;
/*      */         }
/*      */         
/* 4082 */         double resul = 1.0D + facIva - facRet;
/* 4083 */         double subtotal = this.utilerias.convertirCantTexto(valor) / resul;
/*      */         
/* 4085 */         this.jTextField2.setText(this.utilerias.convertirDoublePesos(subtotal * facIva));
/* 4086 */         this.jTextField3.setText(this.utilerias.convertirDoublePesos(subtotal * facRet));
/* 4087 */         this.jTextField4.setText(this.utilerias.convertirDoublePesos(subtotal));
/* 4088 */         this.jTextField6.setText(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 9).toString());
/*      */         
/* 4090 */         if (this.jDialog1.getTitle().equals("Crear nuevo")) {
/* 4091 */           this.jFormattedTextField6.setEnabled(true);
/* 4092 */         } else if (this.jDialog1.getTitle().contains("Ver complemento")) {
/* 4093 */           this.jFormattedTextField6.setEnabled(false);
/* 4094 */         } else if (this.jDialog1.getTitle().contains("Modificar el complemento")) {
/* 4095 */           this.jFormattedTextField6.setEnabled(true);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 4100 */       this.jDialog10.setTitle("Modificar Abono");
/* 4101 */       this.jDialog10.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 4107 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 4108 */     if (ind < 0) {
/* 4109 */       JOptionPane.showMessageDialog(this.jDialog18, "Necesitas seleccionar una factura para poder quitarla", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 4111 */       if (this.VERSION == 2) {
/* 4112 */         String fac = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0).toString() + this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0).toString();
/* 4113 */         if (this.materialButton20.getText().equals("Guardar") || this.materialButton20.getText().equals("Modificar")) {
/* 4114 */           this.FACTURAS.remove(fac);
/* 4115 */           this.IMPUESTOSIVA.remove(fac);
/* 4116 */           this.IMPUESTOSRET.remove(fac);
/*      */         } 
/*      */       } 
/*      */       
/* 4120 */       DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 4121 */       temp.removeRow(ind);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4126 */       sumarSaldos();
/* 4127 */       contarFacturas();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField87ActionPerformed(ActionEvent evt) {
/* 4132 */     agregarLeyendas();
/*      */   }
/*      */   
/*      */   private void jTextField88ActionPerformed(ActionEvent evt) {
/* 4136 */     agregarLeyendas();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField4FocusLost(FocusEvent evt) {
/* 4140 */     imprimirCantidadLetra();
/* 4141 */     sumarSaldos();
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/* 4145 */     if (this.VERSION == 1) {
/* 4146 */       buscarGuias();
/* 4147 */     } else if (this.VERSION == 2) {
/* 4148 */       buscarGuias20();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 4154 */     if (this.VERSION == 1) {
/* 4155 */       buscarGuias();
/* 4156 */     } else if (this.VERSION == 2) {
/* 4157 */       buscarGuias20();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {
/* 4162 */     if (this.VERSION == 1) {
/* 4163 */       buscarGuias();
/* 4164 */     } else if (this.VERSION == 2) {
/* 4165 */       buscarGuias20();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField6ActionPerformed(ActionEvent evt) {
/* 4170 */     pasarFactura();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 4186 */       crearComprobante(this.jTextField5.getText());
/* 4187 */       JOptionPane.showMessageDialog(this.jDialog12, "El comprobante se ha creado satisfactoriamente.", "Comprobante creado", 0, this.INFO);
/* 4188 */       this.jDialog12.setVisible(false);
/* 4189 */     } catch (IOException ex) {
/* 4190 */       Logger.getLogger(complementoPagos.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton41ActionPerformed(ActionEvent evt) {
/* 4195 */     String dir = direccion();
/* 4196 */     this.RUTAENTRADA = dir;
/*      */     try {
/* 4198 */       if (this.VERSION == 1) {
/* 4199 */         crearComprobante(this.jTextField5.getText());
/* 4200 */         JOptionPane.showMessageDialog(this.jDialog12, "El comprobante se ha creado satisfactoriamente. Versión 1.0", "Comprobante creado", 0, this.INFO);
/* 4201 */         this.jDialog12.setVisible(false);
/* 4202 */       } else if (this.VERSION == 2) {
/* 4203 */         this.jDialog12.setVisible(false);
/* 4204 */         crearComprobante20(this.jTextField5.getText(), dir);
/* 4205 */         Esperando esp = new Esperando(this.jDialog1, this.CAMPOSGENERALES, this.jTextField5.getText());
/* 4206 */         if (esp.TIMBRADO) {
/* 4207 */           aplicarFacturas();
/* 4208 */           JOptionPane.showMessageDialog(this.jDialog12, "El comprobante se ha creado satisfactoriamente. Versión 2.0", "Comprobante creado", 0, this.INFO);
/*      */         } else {
/* 4210 */           JOptionPane.showMessageDialog(this.jDialog12, "El comprobante NO SE PUDO TIMBRAR CORRECTAMENTE", "Comprobante no timbrado", 0, this.ADVER);
/*      */         } 
/*      */       } 
/* 4213 */     } catch (IOException ex) {
/* 4214 */       Logger.getLogger(complementoPagos.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/* 4216 */     this.jDialog12.setVisible(false);
/* 4217 */     this.RUTAENTRADA = this.DATOS[5];
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 4221 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 4222 */       this.jButton26.setEnabled(true);
/* 4223 */       this.jButton27.setEnabled(true);
/*      */     } else {
/* 4225 */       this.jButton26.setEnabled(false);
/* 4226 */       this.jButton27.setEnabled(false);
/*      */     } 
/*      */     
/* 4229 */     if (evt.getClickCount() == 2) {
/* 4230 */       limpiar();
/* 4231 */       bloquear();
/* 4232 */       this.jDialog1.setTitle("Ver Documento");
/*      */       
/* 4234 */       String tipo = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 16).toString();
/* 4235 */       if (tipo.equals("1.0")) {
/* 4236 */         this.VERSION = 1;
/* 4237 */         convertir10();
/* 4238 */         verComplemento();
/* 4239 */         this.jDialog1.setTitle("Ver complemento de pago " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)));
/* 4240 */         this.jDialog1.setVisible(true);
/* 4241 */       } else if (tipo.equals("2.0")) {
/* 4242 */         this.VERSION = 2;
/*      */         
/* 4244 */         convertir20();
/* 4245 */         cargarImpuestos20(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString());
/* 4246 */         verComplemento();
/*      */         
/* 4248 */         this.jDialog1.setTitle("Ver complemento de pago " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 4249 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {
/* 4255 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 4256 */       this.jButton26.setEnabled(true);
/* 4257 */       this.jButton27.setEnabled(true);
/*      */     } else {
/* 4259 */       this.jButton26.setEnabled(false);
/* 4260 */       this.jButton27.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 4265 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 4269 */     double dep = this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText());
/* 4270 */     double suma = 0.0D;
/*      */     
/* 4272 */     if (this.VERSION == 1) {
/* 4273 */       suma = convertirCantTexto(this.jLabel40.getText());
/* 4274 */     } else if (this.VERSION == 2) {
/* 4275 */       suma = this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro6, 4);
/*      */     } 
/*      */     
/* 4278 */     double RESTA = dep - suma;
/*      */     
/* 4280 */     if (this.jComboBox4.getSelectedIndex() == 0) {
/* 4281 */       this.jComboBox4.setBackground(Color.RED);
/* 4282 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar el cliente para generar el complemento de pago.", "Falta el cliente", 0, this.ADVER);
/*      */ 
/*      */     
/*      */     }
/* 4286 */     else if (this.jDateChooser1.getDate() == null) {
/* 4287 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar la fecha del pago.", "Falta la fecha del pago", 0, this.ADVER);
/* 4288 */     } else if (dep <= 0.0D) {
/* 4289 */       this.jFormattedTextField4.setBackground(Color.RED);
/* 4290 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar una cantidad mayor a cero.", "Cantidad menor a cero", 0, this.ADVER);
/* 4291 */     } else if (this.rSTableMetro6.getRowCount() <= 0) {
/* 4292 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas ingresar por lo menos una factura para generar el complemento de pago.", "Falta agregar facturas", 0, this.ADVER);
/*      */     }
/* 4294 */     else if (RESTA > 2.0D || RESTA < -2.0D) {
/* 4295 */       JOptionPane.showMessageDialog(this.jDialog1, "La suma de las facturas para abonar no coincide con el monto del depósito\nDIFENCIA: $" + RESTA, "Saldos no coinciden", 0, this.ERROR);
/*      */     } else {
/* 4297 */       double totalBase = 0.0D;
/* 4298 */       for (Map.Entry<String, Facturas> entry : this.FACTURAS.entrySet()) {
/* 4299 */         String key = entry.getKey();
/* 4300 */         Facturas valor = entry.getValue();
/* 4301 */         totalBase += this.utilerias.convertirCantTexto(valor.getTotalTrasBase());
/*      */       } 
/*      */       
/* 4304 */       if (this.jDialog1.getTitle().equals("Crear Nuevo")) {
/* 4305 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar el complemento de pago?", "Crear nuevo", 0, 3, this.PREG);
/* 4306 */         if (res == 0) {
/* 4307 */           sacarMayor();
/* 4308 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4309 */           String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 4310 */           String año = cadenaFecha1.substring(0, 4);
/* 4311 */           String mes = cadenaFecha1.substring(4, 6);
/* 4312 */           String dia = cadenaFecha1.substring(6, 8);
/* 4313 */           String fechaDeposito = año + "-" + año + "-" + mes + " " + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/*      */           
/* 4315 */           if (this.VERSION == 1) {
/* 4316 */             this.con.inserSinMsj("insert into complementopagos (tipo, folioPago, fechaCaptura,cliente, rfc, calle, num, colonia, cp, ciudad, estado, fechaPago, formaPago, moneda, tipoCambio, monto, numeroOperacion, bancoOrigen, cuentaOrigen, RFCOrigen, bancoDestino, cuentaDestino, RFCDestino, tipoCadena, certificado, cadenaPago, selloPago, usuario, estatus, motivo, version) values ('P','" + this.jTextField5
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 4324 */                 .getText() + "', now(), '" + 
/* 4325 */                 String.valueOf(this.jComboBox4.getSelectedItem()) + "', '" + this.jTextField14.getText() + "', '" + String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "', '" + String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "', '" + fechaDeposito + "', '" + this.metodos[this.jComboBox18
/* 4326 */                   .getSelectedIndex()] + "', '" + this.jTextField85.getText() + "','" + String.valueOf(this.jFormattedTextField1.getValue()) + "','" + this.jFormattedTextField4.getText() + "','" + this.jTextField26
/* 4327 */                 .getText().toUpperCase() + "', '" + this.jTextField28.getText().toUpperCase() + "', '" + this.jTextField29.getText().toUpperCase() + "','" + this.jTextField27.getText().toUpperCase() + "', '" + this.jTextField32
/* 4328 */                 .getText().toUpperCase() + "', '" + this.jTextField31.getText().toUpperCase() + "','" + this.jTextField30.getText().toUpperCase() + "', '" + this.jTextField16
/* 4329 */                 .getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "', '" + this.jTextField15.getText().toUpperCase() + "', '" + this.jTextField18.getText().toUpperCase() + "', '" + this.USUARIO + "', '<Por Timbrar>','', '1.0')");
/*      */           }
/* 4331 */           else if (this.VERSION == 2) {
/* 4332 */             this.con.inserSinMsj("insert into complementopagos (tipo, folioPago, fechaCaptura,cliente, rfc, calle, num, colonia, cp, ciudad, estado, fechaPago, formaPago, moneda, tipoCambio, monto, numeroOperacion, bancoOrigen, cuentaOrigen, RFCOrigen, bancoDestino, cuentaDestino, RFCDestino, tipoCadena, certificado, cadenaPago, selloPago, usuario, estatus, motivo, totalTrasladoBase, totalRetenciones, totalTrasladosImp, version, regimen, razonSocialSAT, convertidos, fluctuacion, uuid, pdf, numFacturas, bitacoraFolioFiscal, ruta) values ('P','" + this.jTextField5
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 4344 */                 .getText() + "', now(), '" + 
/* 4345 */                 String.valueOf(this.jComboBox4.getSelectedItem()) + "', '" + this.jTextField14.getText() + "', '" + String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "','" + String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "', '" + String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "', '" + fechaDeposito + "', '" + this.metodos[this.jComboBox18
/* 4346 */                   .getSelectedIndex()] + "', '" + this.jTextField85.getText() + "','" + this.jFormattedTextField1.getText() + "','" + this.jFormattedTextField4.getText() + "','" + this.jTextField26
/* 4347 */                 .getText().toUpperCase() + "', '" + this.jTextField28.getText().toUpperCase() + "', '" + this.jTextField29.getText().toUpperCase() + "','" + this.jTextField27.getText().toUpperCase() + "', '" + this.jTextField32
/* 4348 */                 .getText().toUpperCase() + "', '" + this.jTextField31.getText().toUpperCase() + "','" + this.jTextField30.getText().toUpperCase() + "', '" + this.jTextField16
/* 4349 */                 .getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "', '" + this.jTextField15.getText().toUpperCase() + "', '" + this.jTextField18.getText().toUpperCase() + "', '" + this.USUARIO + "', '<Por Timbrar>','','" + this.utilerias
/*      */                 
/* 4351 */                 .convertirDoublePesos(totalBase) + "', '" + this.jLabel40.getText() + "', '" + this.jLabel38.getText() + "', '2.0', '" + 
/* 4352 */                 String.valueOf(this.REGIMENES.get(this.jComboBox4.getSelectedItem())) + "', '" + String.valueOf(this.RAZONSOCIAL.get(this.jComboBox4.getSelectedItem())) + "', '','" + this.jLabel85
/* 4353 */                 .getText() + "','',''," + this.rSTableMetro6.getRowCount() + ", '','' )");
/*      */           } 
/*      */           
/*      */           int i;
/* 4357 */           for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 4358 */             this.con.inserSinMsj("insert into leyendasfacturas (titulo, descripcion, numfactura) values ('" + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)) + "','" + String.valueOf(this.rSTableMetro5.getValueAt(i, 1)) + "', '" + this.jTextField5.getText().toUpperCase() + "')");
/*      */           }
/*      */           
/* 4361 */           for (i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 4362 */             String folios = "";
/* 4363 */             if (this.VERSION == 1) {
/* 4364 */               folios = this.rSTableMetro6.getValueAt(i, 1).toString();
/*      */             } else {
/* 4366 */               folios = String.valueOf(this.rSTableMetro6.getValueAt(i, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(i, 0));
/*      */             } 
/*      */             
/* 4369 */             String[] datos = this.con.regresaReg("moneda, pagoMetodo, tipoCambio", "facturas33", "where folio='" + folios + "'", 3);
/* 4370 */             if (this.VERSION == 1) {
/* 4371 */               this.con.inserSinMsj("insert into complementopagosfacturas (folioFiscal, folioInterno, moneda, tipoCambio, metodoPago, numParcialidad, importeOriginal, importeAnterior, importeSaldado, importeInsoluto, folioPago) values ( '" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 4378 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 0)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 1)) + "','" + datos[2] + "', '" + datos[0] + "','" + datos[1]
/*      */                   
/* 4380 */                   .substring(0, 3) + "', " + String.valueOf(this.rSTableMetro6.getValueAt(i, 2)) + ", '" + 
/* 4381 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 3)) + "','" + String.valueOf(this.rSTableMetro6.getValueAt(i, 4)) + "','" + 
/* 4382 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 5)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 6)) + "', '" + this.jTextField5
/* 4383 */                   .getText() + "')");
/* 4384 */             } else if (this.VERSION == 2) {
/* 4385 */               this.con.inserSinMsj("insert into complementopagosfacturas (folioFiscal, folioInterno, moneda, tipoCambio, metodoPago, numParcialidad, importeOriginal, importeAnterior, importeSaldado, importeInsoluto, folioPago,serie, folio, objImp, equivalencia, trasBase, retBase, totalTrasladoBase, fluctuacion, dolarFacturado, dolarPagado) values ( '" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 4397 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 2)) + "', '" + folios + "','" + datos[0] + "', '" + datos[2] + "','" + datos[1]
/*      */                   
/* 4399 */                   .substring(0, 3) + "', " + ((Facturas)this.FACTURAS.get(folios)).getParcialidad() + ", '" + 
/* 4400 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 3)) + "','" + ((Facturas)this.FACTURAS.get(folios)).getSaldo() + "','" + 
/* 4401 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 4)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 5)) + "', '" + this.jTextField5
/* 4402 */                   .getText() + "','" + ((Facturas)this.FACTURAS
/* 4403 */                   .get(folios)).getSerie() + "', '" + ((Facturas)this.FACTURAS.get(folios)).getFolio() + "', '" + ((Facturas)this.FACTURAS
/* 4404 */                   .get(folios)).getObjImp() + "', 1, '" + 
/* 4405 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 6)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 7)) + "', '" + ((Facturas)this.FACTURAS.get(folios)).getTotalTrasBase() + "', '" + 
/* 4406 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 9)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 8)) + "', '" + this.jFormattedTextField1.getText() + "' )");
/*      */ 
/*      */               
/* 4409 */               if (this.IMPUESTOSIVA.containsKey(folios) && (
/* 4410 */                 (ImpuestosIva)this.IMPUESTOSIVA.get(folios)).getEstatus().equals("NUEVO")) {
/* 4411 */                 this.con.inserSinMsj("insert into complementopagosfacturasimpuestos (tipo, tasa, importe, folioComp, factura, estatus) values('" + ((ImpuestosIva)this.IMPUESTOSIVA
/*      */                     
/* 4413 */                     .get(folios)).getTipo() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4414 */                     .get(folios)).getTasa() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4415 */                     .get(folios)).getImporte() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4416 */                     .get(folios)).getFolioComplemento() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4417 */                     .get(folios)).getFactura() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4418 */                     .get(folios)).getEstatus() + "')");
/*      */               }
/*      */ 
/*      */ 
/*      */               
/* 4423 */               if (this.IMPUESTOSRET.containsKey(folios) && (
/* 4424 */                 (ImpuestosRet)this.IMPUESTOSRET.get(folios)).getEstatus().equals("NUEVO")) {
/* 4425 */                 this.con.inserSinMsj("insert into complementopagosfacturasimpuestos (tipo, tasa, importe, folioComp, factura, estatus) values('" + ((ImpuestosRet)this.IMPUESTOSRET
/*      */                     
/* 4427 */                     .get(folios)).getTipo() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4428 */                     .get(folios)).getTasa() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4429 */                     .get(folios)).getImporte() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4430 */                     .get(folios)).getFolioComplemento() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4431 */                     .get(folios)).getFactura() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4432 */                     .get(folios)).getEstatus() + "')");
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 4438 */           imprimirComprobante();
/* 4439 */           this.jDialog1.setVisible(false);
/* 4440 */           consultar();
/*      */         } 
/* 4442 */       } else if (this.materialButton20.getText().equals("Modificar")) {
/* 4443 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar el complemento de pago?", "Modificar el complemento", 0, 3, this.PREG);
/* 4444 */         if (res == 0) {
/* 4445 */           if (this.VERSION == 1) {
/* 4446 */             this.con.eliminar2("complementopagosfacturas", "where folioPago ='" + this.jTextField5.getText() + "'");
/* 4447 */             this.con.eliminar2("leyendasfacturas", "where numFactura ='" + this.jTextField5.getText() + "'");
/*      */             
/* 4449 */             SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4450 */             String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 4451 */             String año = cadenaFecha1.substring(0, 4);
/* 4452 */             String mes = cadenaFecha1.substring(4, 6);
/* 4453 */             String dia = cadenaFecha1.substring(6, 8);
/* 4454 */             String fechaDeposito = año + "-" + año + "-" + mes + " " + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/*      */             
/* 4456 */             this.con.inserSinMsj("update complementopagos set fechaCaptura=now(), cliente='" + 
/* 4457 */                 String.valueOf(this.jComboBox4.getSelectedItem()) + "', rfc='" + this.jTextField14
/* 4458 */                 .getText() + "', calle='" + 
/* 4459 */                 String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "', num='" + 
/* 4460 */                 String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "', colonia='" + 
/* 4461 */                 String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "', cp='" + 
/* 4462 */                 String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "', ciudad='" + 
/* 4463 */                 String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "', estado='" + 
/* 4464 */                 String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "', fechaPago='" + fechaDeposito + "', formaPago='" + this.metodos[this.jComboBox18
/*      */                   
/* 4466 */                   .getSelectedIndex()] + "', moneda='" + this.jTextField85
/* 4467 */                 .getText() + "', tipoCambio='" + 
/* 4468 */                 String.valueOf(this.jFormattedTextField1.getValue()) + "', monto='" + this.jFormattedTextField4
/* 4469 */                 .getText() + "', numeroOperacion='" + this.jTextField26
/* 4470 */                 .getText().toUpperCase() + "', bancoOrigen='" + this.jTextField28
/* 4471 */                 .getText().toUpperCase() + "', cuentaOrigen='" + this.jTextField29
/* 4472 */                 .getText().toUpperCase() + "', RFCOrigen='" + this.jTextField27
/* 4473 */                 .getText().toUpperCase() + "', bancoDestino='" + this.jTextField32
/* 4474 */                 .getText().toUpperCase() + "', cuentaDestino='" + this.jTextField31
/* 4475 */                 .getText().toUpperCase() + "', RFCDestino='" + this.jTextField30
/* 4476 */                 .getText().toUpperCase() + "', tipoCadena='" + this.jTextField16
/* 4477 */                 .getText().toUpperCase() + "', certificado='" + this.jTextField17
/* 4478 */                 .getText().toUpperCase() + "', cadenaPago='" + this.jTextField15
/* 4479 */                 .getText().toUpperCase() + "', selloPago='" + this.jTextField18
/* 4480 */                 .getText().toUpperCase() + "', usuario='" + this.USUARIO + "' motivo = '', flucutuacion = '" + this.jLabel85
/*      */ 
/*      */                 
/* 4483 */                 .getText() + "', convertidos = '',  numFactruas = " + this.rSTableMetro6
/*      */                 
/* 4485 */                 .getRowCount() + " where folioPago='" + this.jTextField5
/* 4486 */                 .getText() + "'");
/*      */             int i;
/* 4488 */             for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 4489 */               this.con.inserSinMsj("insert into leyendasfacturas (titulo, descripcion, numfactura) values ('" + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)) + "','" + String.valueOf(this.rSTableMetro5.getValueAt(i, 1)) + "', '" + this.jTextField5.getText().toUpperCase() + "')");
/*      */             }
/*      */             
/* 4492 */             for (i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 4493 */               String[] datos = this.con.regresaReg("moneda, pagoMetodo, tipoCambio", "facturas33", "where folio='" + String.valueOf(this.rSTableMetro6.getValueAt(i, 1)) + "'", 3);
/*      */               
/* 4495 */               this.con.inserSinMsj("insert into complementopagosfacturas (folioFiscal, folioInterno, moneda, tipoCambio, metodoPago, numParcialidad, importeOriginal, importeAnterior, importeSaldado, importeInsoluto, folioPago) values ( '" + 
/* 4496 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 0)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 1)) + "','" + datos[2] + "', '" + datos[0] + "','" + datos[1].substring(0, 3) + "', " + String.valueOf(this.rSTableMetro6.getValueAt(i, 2)) + ", '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 3)) + "','" + String.valueOf(this.rSTableMetro6.getValueAt(i, 4)) + "','" + String.valueOf(this.rSTableMetro6.getValueAt(i, 5)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 6)) + "', '" + this.jTextField5.getText() + "')");
/*      */             } 
/* 4498 */             imprimirComprobante();
/* 4499 */             consultar();
/* 4500 */             this.jDialog1.setVisible(false);
/* 4501 */           } else if (this.VERSION == 2) {
/* 4502 */             this.con.eliminar2("complementopagosfacturas", "where folioPago ='" + this.jTextField5.getText() + "'");
/* 4503 */             this.con.eliminar2("leyendasfacturas", "where numFactura ='" + this.jTextField5.getText() + "'");
/* 4504 */             this.con.eliminar2("complementopagosfacturasimpuestos", "where folioComp = '" + this.jTextField5.getText() + "'");
/*      */             
/* 4506 */             SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4507 */             String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 4508 */             String año = cadenaFecha1.substring(0, 4);
/* 4509 */             String mes = cadenaFecha1.substring(4, 6);
/* 4510 */             String dia = cadenaFecha1.substring(6, 8);
/* 4511 */             String fechaDeposito = año + "-" + año + "-" + mes + " " + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/*      */             
/* 4513 */             this.con.inserSinMsj("update complementopagos set fechaCaptura=now(), cliente='" + 
/* 4514 */                 String.valueOf(this.jComboBox4.getSelectedItem()) + "', rfc='" + this.jTextField14
/* 4515 */                 .getText() + "', calle='" + 
/* 4516 */                 String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "', num='" + 
/* 4517 */                 String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "', colonia='" + 
/* 4518 */                 String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "', cp='" + 
/* 4519 */                 String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "', ciudad='" + 
/* 4520 */                 String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "', estado='" + 
/* 4521 */                 String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "', fechaPago='" + fechaDeposito + "', formaPago='" + this.metodos[this.jComboBox18
/*      */                   
/* 4523 */                   .getSelectedIndex()] + "', moneda='" + this.jTextField85
/* 4524 */                 .getText() + "', tipoCambio='" + 
/* 4525 */                 String.valueOf(this.jFormattedTextField1.getValue()) + "', monto='" + this.jFormattedTextField4
/* 4526 */                 .getText() + "', numeroOperacion='" + this.jTextField26
/* 4527 */                 .getText().toUpperCase() + "', bancoOrigen='" + this.jTextField28
/* 4528 */                 .getText().toUpperCase() + "', cuentaOrigen='" + this.jTextField29
/* 4529 */                 .getText().toUpperCase() + "', RFCOrigen='" + this.jTextField27
/* 4530 */                 .getText().toUpperCase() + "', bancoDestino='" + this.jTextField32
/* 4531 */                 .getText().toUpperCase() + "', cuentaDestino='" + this.jTextField31
/* 4532 */                 .getText().toUpperCase() + "', RFCDestino='" + this.jTextField30
/* 4533 */                 .getText().toUpperCase() + "', tipoCadena='" + this.jTextField16
/* 4534 */                 .getText().toUpperCase() + "', certificado='" + this.jTextField17
/* 4535 */                 .getText().toUpperCase() + "', cadenaPago='" + this.jTextField15
/* 4536 */                 .getText().toUpperCase() + "', selloPago='" + this.jTextField18
/* 4537 */                 .getText().toUpperCase() + "', usuario='" + this.USUARIO + "', totalTrasladoBase ='" + this.utilerias
/*      */                 
/* 4539 */                 .convertirDoublePesos(totalBase) + "', totalRetenciones='" + this.jLabel40
/* 4540 */                 .getText() + "', totalTrasladosImp='" + this.jLabel38
/* 4541 */                 .getText() + "', regimen='" + 
/* 4542 */                 String.valueOf(this.REGIMENES.get(this.jComboBox4.getSelectedItem())) + "', razonSocialSAT ='" + 
/* 4543 */                 String.valueOf(this.RAZONSOCIAL.get(this.jComboBox4.getSelectedItem())) + "', motivo = '',convertidos = '', fluctuacion = '" + this.jLabel85
/*      */ 
/*      */                 
/* 4546 */                 .getText() + "', numFacturas = " + this.rSTableMetro6
/* 4547 */                 .getRowCount() + "   where folioPago='" + this.jTextField5
/* 4548 */                 .getText() + "'");
/*      */             int i;
/* 4550 */             for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 4551 */               this.con.inserSinMsj("insert into leyendasfacturas (titulo, descripcion, numfactura) values ('" + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)) + "','" + String.valueOf(this.rSTableMetro5.getValueAt(i, 1)) + "', '" + this.jTextField5.getText().toUpperCase() + "')");
/*      */             }
/*      */             
/* 4554 */             for (i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 4555 */               String folios = "";
/*      */               
/* 4557 */               String ObjImp = "";
/* 4558 */               String obj = "";
/* 4559 */               String valor1 = this.rSTableMetro6.getValueAt(i, 6).toString();
/* 4560 */               String valor2 = this.rSTableMetro6.getValueAt(i, 7).toString();
/*      */               
/* 4562 */               if (valor1.equals("0.16 / $0.00") && valor2.equals("0.04 / $0.00")) {
/* 4563 */                 obj = "01";
/*      */               } else {
/* 4565 */                 obj = "02";
/*      */               } 
/*      */               
/* 4568 */               folios = String.valueOf(this.rSTableMetro6.getValueAt(i, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(i, 0));
/*      */               
/* 4570 */               imprimirImpuestos();
/*      */               
/* 4572 */               String[] datos = this.con.regresaRegIndex("moneda, pagoMetodo, tipoCambio, numParcialidad", "facturas33", "where folio='" + folios + "'");
/*      */               
/* 4574 */               this.con.inserSinMsj("insert into complementopagosfacturas (folioFiscal, folioInterno, moneda, tipoCambio, metodoPago, numParcialidad, importeOriginal, importeAnterior, importeSaldado, importeInsoluto, folioPago,serie, folio, objImp, equivalencia, trasBase, retBase, totalTrasladoBase, fluctuacion, dolarFacturado, dolarPagado) values ( '" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 4586 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 2)) + "', '" + folios + "','" + datos[0] + "', '" + datos[2] + "','" + datos[1]
/*      */                   
/* 4588 */                   .substring(0, 3) + "', " + ((Facturas)this.FACTURAS.get(folios)).getParcialidad() + ", '" + 
/* 4589 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 3)) + "','" + ((Facturas)this.FACTURAS.get(folios)).getSaldo() + "','" + 
/* 4590 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 4)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 5)) + "', '" + this.jTextField5
/* 4591 */                   .getText() + "','" + ((Facturas)this.FACTURAS
/* 4592 */                   .get(folios)).getSerie() + "', '" + ((Facturas)this.FACTURAS.get(folios)).getFolio() + "', '" + ((Facturas)this.FACTURAS
/* 4593 */                   .get(folios)).getObjImp() + "', 1, '" + 
/* 4594 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 6)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 7)) + "', '" + ((Facturas)this.FACTURAS.get(folios)).getTotalTrasBase() + "', '" + 
/* 4595 */                   String.valueOf(this.rSTableMetro6.getValueAt(i, 9)) + "', '" + String.valueOf(this.rSTableMetro6.getValueAt(i, 8)) + "', '" + this.jFormattedTextField1.getText() + "' )");
/*      */ 
/*      */               
/* 4598 */               if (this.IMPUESTOSIVA.containsKey(folios) && (
/* 4599 */                 (ImpuestosIva)this.IMPUESTOSIVA.get(folios)).getEstatus().equals("NUEVO")) {
/* 4600 */                 this.con.inserSinMsj("insert into complementopagosfacturasimpuestos (tipo, tasa, importe, folioComp, factura, estatus) values('" + ((ImpuestosIva)this.IMPUESTOSIVA
/*      */                     
/* 4602 */                     .get(folios)).getTipo() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4603 */                     .get(folios)).getTasa() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4604 */                     .get(folios)).getImporte() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4605 */                     .get(folios)).getFolioComplemento() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4606 */                     .get(folios)).getFactura() + "', '" + ((ImpuestosIva)this.IMPUESTOSIVA
/* 4607 */                     .get(folios)).getEstatus() + "')");
/*      */               }
/*      */ 
/*      */ 
/*      */               
/* 4612 */               if (this.IMPUESTOSRET.containsKey(folios) && (
/* 4613 */                 (ImpuestosRet)this.IMPUESTOSRET.get(folios)).getEstatus().equals("NUEVO")) {
/* 4614 */                 this.con.inserSinMsj("insert into complementopagosfacturasimpuestos (tipo, tasa, importe, folioComp, factura, estatus) values('" + ((ImpuestosRet)this.IMPUESTOSRET
/*      */                     
/* 4616 */                     .get(folios)).getTipo() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4617 */                     .get(folios)).getTasa() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4618 */                     .get(folios)).getImporte() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4619 */                     .get(folios)).getFolioComplemento() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4620 */                     .get(folios)).getFactura() + "', '" + ((ImpuestosRet)this.IMPUESTOSRET
/* 4621 */                     .get(folios)).getEstatus() + "')");
/*      */               }
/*      */             } 
/*      */ 
/*      */             
/* 4626 */             imprimirComprobante();
/* 4627 */             consultar();
/* 4628 */             this.jDialog1.setVisible(false);
/*      */           } 
/*      */         }
/*      */       } else {
/* 4632 */         imprimirComprobante();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 4638 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas timbrar el comprobante?", "Timbrar comprobante", 0, 3, this.PREG);
/* 4639 */     if (res == 0) {
/* 4640 */       if (this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15).equals("<Por Timbrar>")) {
/*      */         try {
/* 4642 */           if (this.VERSION == 1) {
/* 4643 */             crearComprobante(this.jTextField5.getText());
/* 4644 */             this.con.inserSinMsj("update complementopagos set estatus='<Timbrado>' where foliopago='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'");
/* 4645 */           } else if (this.VERSION == 2) {
/* 4646 */             crearComprobante20(this.jTextField5.getText(), this.RUTA20);
/* 4647 */             Esperando esp = new Esperando(this.jDialog1, this.CAMPOSGENERALES, this.jTextField5.getText());
/* 4648 */             if (esp.TIMBRADO) {
/* 4649 */               aplicarFacturas();
/* 4650 */               this.con.inserSinMsj("update complementopagos set estatus='<Timbrado y Aplicado>' where foliopago='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'");
/* 4651 */               JOptionPane.showMessageDialog(this.jDialog12, "El comprobante se ha creado satisfactoriamente. Versión 2.0", "Comprobante creado", 0, this.INFO);
/*      */             } else {
/* 4653 */               JOptionPane.showMessageDialog(this.jDialog12, "El comprobante NO SE PUDO TIMBRAR CORRECTAMENTE", "Comprobante no timbrado", 0, this.ADVER);
/*      */             } 
/*      */           } 
/* 4656 */           consultar();
/* 4657 */           this.jDialog1.setVisible(false);
/* 4658 */         } catch (IOException ex) {
/* 4659 */           Logger.getLogger(complementoPagos.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */         } 
/*      */       } else {
/* 4662 */         if (this.VERSION == 1) {
/* 4663 */           this.jTextField24.setText(this.RUTAENTRADA);
/* 4664 */         } else if (this.VERSION == 2) {
/* 4665 */           this.jTextField24.setText(this.RUTA20);
/*      */         } 
/* 4667 */         this.jDialog12.setVisible(true);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 4673 */     this.con.consultar("motivo", "complementopagos", "where numPago='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/* 4674 */     this.jTextArea6.setText(this.con.Campo);
/* 4675 */     this.jDialog11.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro5MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 4690 */     if (evt.getClickCount() == 2 && this.VERSION == 2) {
/* 4691 */       String valor = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4).toString();
/* 4692 */       double CANTIDAD = convertirCantTexto(valor);
/* 4693 */       this.jFormattedTextField6.setValue(Double.valueOf(CANTIDAD));
/*      */       
/* 4695 */       double facIva = 0.0D;
/* 4696 */       double facRet = 0.0D;
/*      */       
/* 4698 */       double ret = 0.0D;
/* 4699 */       double iva = 0.0D;
/*      */       
/* 4701 */       if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 6).toString().equals("0.16 / $0.00")) {
/* 4702 */         facIva = 0.16D;
/*      */       }
/*      */       
/* 4705 */       if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 7).toString().equals("0.04 / $0.00")) {
/* 4706 */         facRet = 0.04D;
/*      */       }
/*      */       
/* 4709 */       double resul = 1.0D + facIva - facRet;
/* 4710 */       double subtotal = this.utilerias.convertirCantTexto(valor) / resul;
/*      */       
/* 4712 */       this.jTextField2.setText(this.utilerias.convertirDoublePesos(subtotal * facIva));
/* 4713 */       this.jTextField3.setText(this.utilerias.convertirDoublePesos(subtotal * facRet));
/* 4714 */       this.jTextField4.setText(this.utilerias.convertirDoublePesos(subtotal));
/*      */       
/* 4716 */       if (this.jDialog1.getTitle().equals("Crear nuevo")) {
/* 4717 */         this.jFormattedTextField6.setEnabled(true);
/* 4718 */       } else if (this.jDialog1.getTitle().contains("Ver complemento")) {
/* 4719 */         this.jFormattedTextField6.setEnabled(false);
/* 4720 */       } else if (this.jDialog1.getTitle().contains("Modificar el complemento")) {
/* 4721 */         this.jFormattedTextField6.setEnabled(true);
/*      */       } 
/*      */       
/* 4724 */       this.jTextField6.setText(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 9).toString());
/*      */       
/* 4726 */       this.jDialog10.setTitle("Modificar Abono");
/* 4727 */       this.jDialog10.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 4736 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 4740 */     cancelar();
/*      */   }
/*      */   
/*      */   private void rSTableMetro7MouseClicked(MouseEvent evt) {
/* 4744 */     if (evt.getClickCount() == 2) {
/* 4745 */       validarFactura();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro7KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 4754 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 4758 */     validarFactura();
/*      */   }
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 4762 */     if (this.jDialog10.getTitle().equals("Agregar Factura")) {
/* 4763 */       pasarFactura();
/* 4764 */     } else if (this.jDialog10.getTitle().equals("Modificar Abono")) {
/* 4765 */       pasarFactura();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 4770 */     this.jDialog11.setVisible(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro8MouseClicked(MouseEvent evt) {
/* 4774 */     if (evt.getClickCount() == 2) {
/* 4775 */       if (this.jTextField85.getText().equals("USD"))
/*      */       {
/* 4777 */         validarDolar();
/*      */       }
/*      */       
/* 4780 */       this.jTextField85.setText(this.rSTableMetro8.getValueAt(this.rSTableMetro8.getSelectedRow(), 0).toString());
/* 4781 */       if (this.jTextField85.getText().equals("MXN")) {
/* 4782 */         this.jFormattedTextField1.setValue(Integer.valueOf(1));
/* 4783 */         this.jFormattedTextField1.setEnabled(false);
/*      */       } 
/*      */       
/* 4786 */       this.jDialog17.setVisible(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro8KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton42ActionPerformed(ActionEvent evt) {
/* 4795 */     agregarLeyendas();
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 4799 */     this.jComboBox10.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15));
/* 4800 */     int res = JOptionPane.showConfirmDialog(this, this.jPanel4, "Cambiar de estado", 0, 3, this.PREG);
/* 4801 */     if (res == 0) {
/* 4802 */       this.con.insertar("update complementopagos set estatus ='" + String.valueOf(this.jComboBox10.getSelectedItem()) + "' where  folioPago = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'");
/* 4803 */       this.rSTableMetro1.setValueAt(this.jComboBox10.getSelectedItem(), this.rSTableMetro1.getSelectedRow(), 15);
/* 4804 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel47MouseDragged(MouseEvent evt) {
/* 4809 */     int x = evt.getXOnScreen();
/* 4810 */     int y = evt.getYOnScreen();
/* 4811 */     this.jDialog2.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel47MouseClicked(MouseEvent evt) {
/* 4815 */     this.xx = evt.getX();
/* 4816 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel129MouseClicked(MouseEvent evt) {
/* 4820 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel129MouseEntered(MouseEvent evt) {
/* 4824 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel129MouseExited(MouseEvent evt) {
/* 4828 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel94MouseClicked(MouseEvent evt) {
/* 4832 */     this.VERSION = 1;
/* 4833 */     limpiar();
/* 4834 */     sacarMayor();
/* 4835 */     sumarSaldos();
/* 4836 */     convertir10();
/* 4837 */     this.jDialog2.setVisible(false);
/* 4838 */     this.jDialog1.setTitle("Crear Nuevo");
/* 4839 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel94MouseEntered(MouseEvent evt) {
/* 4843 */     this.jPanel43.setBackground(this.lc.PRIMARIO2);
/* 4844 */     this.jPanel43.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 4845 */     this.jLabel96.setForeground(Color.WHITE);
/*      */   }
/*      */   
/*      */   private void jLabel94MouseExited(MouseEvent evt) {
/* 4849 */     this.jPanel43.setBackground(this.lc.SECUNDARIO2);
/* 4850 */     this.jPanel43.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 4851 */     this.jLabel96.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void jLabel97MouseClicked(MouseEvent evt) {
/* 4855 */     this.VERSION = 2;
/* 4856 */     limpiar();
/* 4857 */     sacarMayor();
/* 4858 */     convertir20();
/* 4859 */     this.jDialog2.setVisible(false);
/* 4860 */     this.jDialog1.setTitle("Crear Nuevo");
/* 4861 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel97MouseEntered(MouseEvent evt) {
/* 4865 */     this.jPanel92.setBackground(this.lc.PRIMARIO2);
/* 4866 */     this.jPanel92.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 4867 */     this.jLabel100.setForeground(Color.WHITE);
/*      */   }
/*      */   
/*      */   private void jLabel97MouseExited(MouseEvent evt) {
/* 4871 */     this.jPanel92.setBackground(this.lc.SECUNDARIO2);
/* 4872 */     this.jPanel92.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 4873 */     this.jLabel100.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel100MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox36ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox37ActionPerformed(ActionEvent evt) {
/* 4885 */     int v = this.jComboBox37.getSelectedIndex();
/* 4886 */     if (v == 0) {
/* 4887 */       this.jDateChooser9.setEnabled(true);
/* 4888 */       this.jDateChooser10.setEnabled(true);
/* 4889 */       this.jComboBox36.setEnabled(false);
/*      */     } else {
/* 4891 */       this.jDateChooser9.setEnabled(false);
/* 4892 */       this.jDateChooser10.setEnabled(false);
/* 4893 */       this.jComboBox36.setEnabled(true);
/*      */     } 
/* 4895 */     if (this.PRIMERA) {
/* 4896 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 4901 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel172MouseClicked(MouseEvent evt) {
/* 4905 */     Calendar fecha = this.jDateChooser9.getCalendar();
/* 4906 */     int aa = fecha.get(1);
/* 4907 */     int mm = fecha.get(2);
/* 4908 */     int dd = fecha.get(5);
/* 4909 */     if (dd == 1) {
/* 4910 */       if (mm == 0) {
/* 4911 */         mm = 11;
/* 4912 */         aa--;
/*      */       } else {
/* 4914 */         mm--;
/*      */       } 
/* 4916 */       int diasTotal = diasDelMes(mm, aa);
/* 4917 */       dd = diasTotal;
/*      */     } else {
/* 4919 */       dd--;
/*      */     } 
/* 4921 */     mm++;
/* 4922 */     String año = "" + aa;
/* 4923 */     String mes = "" + mm;
/* 4924 */     String dia = "" + dd;
/* 4925 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4926 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 4928 */       this.jDateChooser9.setDate(formatoDelTexto.parse(strFecha));
/* 4929 */       this.jDateChooser10.setDate(formatoDelTexto.parse(strFecha));
/* 4930 */     } catch (ParseException ex) {
/* 4931 */       ex.printStackTrace();
/*      */     } 
/* 4933 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel172MouseEntered(MouseEvent evt) {
/* 4937 */     this.jLabel172.setForeground(new Color(153, 255, 153));
/* 4938 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel172MouseExited(MouseEvent evt) {
/* 4942 */     this.jLabel172.setForeground(new Color(15, 87, 51));
/* 4943 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseClicked(MouseEvent evt) {
/* 4947 */     this.jDateChooser9.setDate(this.fechaActual);
/* 4948 */     this.jDateChooser10.setDate(this.fechaActual);
/* 4949 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel103MouseEntered(MouseEvent evt) {
/* 4953 */     this.jLabel103.setForeground(new Color(153, 255, 153));
/* 4954 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseExited(MouseEvent evt) {
/* 4958 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 4959 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel173MouseClicked(MouseEvent evt) {
/* 4963 */     Calendar calendar = this.jDateChooser9.getCalendar();
/* 4964 */     calendar.setTime(this.jDateChooser4.getDate());
/* 4965 */     calendar.add(6, 1);
/* 4966 */     this.jDateChooser9.setCalendar(calendar);
/* 4967 */     this.jDateChooser10.setCalendar(calendar);
/* 4968 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel173MouseEntered(MouseEvent evt) {
/* 4972 */     this.jLabel173.setForeground(new Color(153, 255, 153));
/* 4973 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel173MouseExited(MouseEvent evt) {
/* 4977 */     this.jLabel173.setForeground(new Color(15, 87, 51));
/* 4978 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jFormattedTextField6KeyReleased(KeyEvent evt) {
/* 4982 */     if (this.VERSION == 2) {
/* 4983 */       actualizaImpuestos();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField7ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField7KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField8KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField9ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField9KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField10ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jFormattedTextField10KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel12MouseClicked(MouseEvent evt) {
/* 5024 */     this.jFormattedTextField7.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.jFormattedTextField6.getText())));
/* 5025 */     this.jFormattedTextField8.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.jTextField4.getText())));
/* 5026 */     this.jFormattedTextField9.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.jTextField2.getText())));
/* 5027 */     this.jFormattedTextField10.setValue(Double.valueOf(this.utilerias.convertirCantTexto(this.jTextField3.getText())));
/* 5028 */     int val = JOptionPane.showConfirmDialog(this.jDialog10, this.jPanel3, "Nuevas Cantidades", 0, 0, this.PREG);
/* 5029 */     if (val == 0) {
/* 5030 */       this.jTextField4.setText(this.jFormattedTextField8.getText());
/* 5031 */       this.jTextField2.setText(this.jFormattedTextField9.getText());
/* 5032 */       this.jTextField3.setText(this.jFormattedTextField10.getText());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jDateChooser1PropertyChange(PropertyChangeEvent evt) {
/* 5038 */     if (this.jTextField32.isEnabled())
/*      */     {
/* 5040 */       validarDolar();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel66MouseClicked(MouseEvent evt) {
/* 5046 */     if (this.jTextField32.isEnabled()) {
/*      */       
/* 5048 */       validarDolar();
/* 5049 */       this.jDialog37.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField1MouseClicked(MouseEvent evt) {
/* 5055 */     if (this.jTextField32.isEnabled())
/*      */     {
/* 5057 */       validarDolar();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro20MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro20KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox41ActionPerformed(ActionEvent evt) {
/* 5071 */     int v = this.jComboBox41.getSelectedIndex();
/* 5072 */     if (v == 0) {
/* 5073 */       this.jDateChooser14.setEnabled(true);
/* 5074 */       this.jDateChooser15.setEnabled(true);
/* 5075 */       this.jComboBox40.setEnabled(false);
/*      */     } else {
/* 5077 */       this.jDateChooser14.setEnabled(false);
/* 5078 */       this.jDateChooser15.setEnabled(false);
/* 5079 */       this.jComboBox40.setEnabled(true);
/*      */     } 
/* 5081 */     consultarHistorialDolar();
/*      */   }
/*      */   
/*      */   private void jComboBox40ActionPerformed(ActionEvent evt) {
/* 5085 */     consultarHistorialDolar();
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 5089 */     consultarHistorialDolar();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField4MouseClicked(MouseEvent evt) {
/* 5093 */     if (this.jTextField32.isEnabled())
/*      */     {
/* 5095 */       validarDolar();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro9MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro9KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 5108 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/* 5109 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton60ActionPerformed(ActionEvent evt) {
/* 5114 */     this.SINXML = false;
/* 5115 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 5116 */     if (ind < 0) {
/* 5117 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para ingresar el Folio Fiscal", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 5120 */       this.jTextField104.setText("");
/* 5121 */       String[] dat = this.con.regresaRegIndex("bitacoraFolioFiscal, ruta, uuid", "complementopagos", "where folioPago ='" + String.valueOf(this.rSTableMetro1.getValueAt(ind, 2)) + "'");
/* 5122 */       if (!dat[0].equals("")) {
/* 5123 */         this.jTextField91.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3).toString());
/* 5124 */         this.jTextField98.setText(dat[0]);
/* 5125 */         this.jTextField104.setText(dat[1]);
/*      */       } else {
/* 5127 */         this.jTextField104.setText("");
/* 5128 */         this.jTextField91.setText("");
/* 5129 */         this.jTextField98.setText("");
/*      */       } 
/* 5131 */       this.jDialog22.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField91ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 5140 */     JFileChooser selectorArchivos = new JFileChooser();
/* 5141 */     FileNameExtensionFilter filtro = new FileNameExtensionFilter("xml", new String[] { "XML" });
/* 5142 */     selectorArchivos.setFileFilter(filtro);
/* 5143 */     selectorArchivos.setFileSelectionMode(2);
/* 5144 */     selectorArchivos.setCurrentDirectory(new File(this.CAMPOSGENERALES.get("factSalida")));
/* 5145 */     int resultado = selectorArchivos.showOpenDialog(this);
/* 5146 */     this.archivoOriginal = selectorArchivos.getSelectedFile();
/* 5147 */     if (this.archivoOriginal == null || this.archivoOriginal.getName().equals("")) {
/* 5148 */       JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", 0);
/*      */     } else {
/* 5150 */       this.leyendoXML = true;
/* 5151 */       this.jTextField104.setText(this.archivoOriginal.getAbsolutePath());
/* 5152 */       leerXML(this.archivoOriginal.getAbsolutePath());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton26ActionPerformed(ActionEvent evt) {
/* 5157 */     if (this.SINXML) {
/* 5158 */       actualizarFolioFiscal2();
/*      */     } else {
/* 5160 */       actualizarFolioFiscal();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro22MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro22KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton62ActionPerformed(ActionEvent evt) {
/* 5173 */     this.SINXML = true;
/* 5174 */     int ind = this.rSTableMetro22.getSelectedRow();
/* 5175 */     if (ind < 0) {
/* 5176 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un complemento para ingresar el Folio Fiscal", "Selecciona un Complemento", 0, this.ADVER);
/*      */     } else {
/* 5178 */       this.jTextField104.setText("");
/* 5179 */       this.jTextField104.setText("");
/* 5180 */       this.jTextField91.setText("");
/* 5181 */       this.jTextField98.setText("");
/* 5182 */       this.jDialog22.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void actualizarFolioFiscal() {
/* 5187 */     this.encontrado = this.con.consultar("uuid", "complementopagos", "where uuid='" + this.jTextField91.getText() + "'");
/* 5188 */     if (this.jTextField91.getText().equals("")) {
/* 5189 */       this.jTextField91.setBackground(Color.RED);
/* 5190 */       JOptionPane.showMessageDialog(this.jDialog22, "Necesitas ingresar el folio fiscal", "Faltan datos", 0, this.ERROR);
/* 5191 */     } else if (this.encontrado && !this.jTextField91.getText().equals(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 3))) {
/* 5192 */       this.jTextField91.setBackground(Color.YELLOW);
/* 5193 */       JOptionPane.showMessageDialog(this.jDialog22, "El folio que deseas ingresar ya se encuentra en la base de datos", "Folio Duplicado", 0, this.ADVER);
/*      */     } else {
/* 5195 */       int esp = 0;
/*      */       
/* 5197 */       String texto = this.jTextField91.getText(); int i;
/* 5198 */       for (i = 0; i < texto.length(); i++) {
/* 5199 */         if (texto.charAt(i) == ' ') {
/* 5200 */           esp++;
/*      */         }
/*      */       } 
/* 5203 */       String[] nombres = new String[esp + 1];
/* 5204 */       for (i = 0; i <= esp; i++) {
/* 5205 */         nombres[i] = "";
/*      */       }
/* 5207 */       esp = 0;
/* 5208 */       for (i = 0; i < texto.length(); i++) {
/* 5209 */         if (texto.charAt(i) == ' ') {
/* 5210 */           esp++;
/*      */         } else {
/* 5212 */           nombres[esp] = nombres[esp] + nombres[esp];
/*      */         } 
/*      */       } 
/* 5215 */       for (i = 0; i < nombres.length; i++) {
/* 5216 */         if (nombres[i].length() == 0) {
/* 5217 */           this.jTextField91.setBackground(Color.RED);
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/* 5222 */       int res = JOptionPane.showConfirmDialog(this.jDialog22, "¿Estás seguro que deseas actualizar el folio fiscal fiscal?", "Actualizar Folio", 0, 3, this.PREG);
/* 5223 */       if (res == 0) {
/* 5224 */         String nuevaRuta = this.jTextField104.getText().replace("\\", "\\\\");
/*      */ 
/*      */         
/* 5227 */         this.con.insertar("update complementopagos set ruta = '" + nuevaRuta + "',  uuid='" + this.jTextField91.getText().toUpperCase() + "', bitacoraFolioFiscal='Usuario: " + this.USUARIO + ", Fecha: " + (new Date()).toGMTString() + " ' where folioPago='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'");
/* 5228 */         this.rSTableMetro1.setValueAt(this.jTextField91.getText().toUpperCase(), this.rSTableMetro1.getSelectedRow(), 3);
/* 5229 */         this.jDialog22.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void actualizarFolioFiscal2() {
/* 5235 */     this.encontrado = this.con.consultar("uuid", "complementopagos", "where uuid='" + this.jTextField91.getText() + "'");
/* 5236 */     if (this.jTextField91.getText().equals("")) {
/* 5237 */       this.jTextField91.setBackground(Color.RED);
/* 5238 */       JOptionPane.showMessageDialog(this.jDialog22, "Necesitas ingresar el folio fiscal", "Faltan datos", 0, this.ERROR);
/*      */     } else {
/* 5240 */       int esp = 0;
/*      */       
/* 5242 */       String texto = this.jTextField91.getText(); int i;
/* 5243 */       for (i = 0; i < texto.length(); i++) {
/* 5244 */         if (texto.charAt(i) == ' ') {
/* 5245 */           esp++;
/*      */         }
/*      */       } 
/* 5248 */       String[] nombres = new String[esp + 1];
/* 5249 */       for (i = 0; i <= esp; i++) {
/* 5250 */         nombres[i] = "";
/*      */       }
/* 5252 */       esp = 0;
/* 5253 */       for (i = 0; i < texto.length(); i++) {
/* 5254 */         if (texto.charAt(i) == ' ') {
/* 5255 */           esp++;
/*      */         } else {
/* 5257 */           nombres[esp] = nombres[esp] + nombres[esp];
/*      */         } 
/*      */       } 
/* 5260 */       for (i = 0; i < nombres.length; i++) {
/* 5261 */         if (nombres[i].length() == 0) {
/* 5262 */           this.jTextField91.setBackground(Color.RED);
/*      */           return;
/*      */         } 
/*      */       } 
/* 5266 */       int res = JOptionPane.showConfirmDialog(this.jDialog22, "¿Estás seguro que deseas actualizar el folio fiscal fiscal?", "Actualizar Folio", 0, 3, this.PREG);
/* 5267 */       if (res == 0) {
/* 5268 */         String nuevaRuta = this.jTextField104.getText().replace("\\", "\\\\");
/*      */ 
/*      */         
/* 5271 */         this.con.insertar("update complementopagos set ruta = '" + nuevaRuta + "',  uuid='" + this.jTextField91.getText().toUpperCase() + "', bitacoraFolioFiscal='Usuario: " + this.USUARIO + ", Fecha: " + (new Date()).toGMTString() + " ' where folioPago='" + String.valueOf(this.rSTableMetro22.getValueAt(this.rSTableMetro22.getSelectedRow(), 0)) + "'");
/* 5272 */         consultar();
/* 5273 */         this.jDialog22.setVisible(false);
/* 5274 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro22, this.rSTableMetro22.getSelectedRow());
/* 5275 */         this.jLabel51.setText("" + this.rSTableMetro22.getRowCount());
/* 5276 */         if (this.rSTableMetro22.getRowCount() <= 0) {
/* 5277 */           this.jDialog4.setVisible(false);
/* 5278 */           nuevoComplemento();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void nuevoComplemento() {
/* 5285 */     boolean sigue = true;
/* 5286 */     String[][] reg = this.con.buscarDatos(8, "f.folioPago,f.cliente,f.fechaCaptura AS ultima_fecha_sin_folio,NOW() AS fecha_actual,TIMESTAMPDIFF(SECOND, f.fechaCaptura, NOW()) AS segundos_transcurridos,TIMESTAMPDIFF(MINUTE, f.fechaCaptura, NOW()) AS minutos_transcurridos,TIMESTAMPDIFF(HOUR, f.fechaCaptura, NOW()) AS horas_transcurridos,TIMESTAMPDIFF(DAY, f.fechaCaptura, NOW()) AS dias_transcurridos", "complementopagos f", "WHERE \n(f.uuid IS NULL OR f.uuid = '' OR f.uuid = '0')AND f.fechaCaptura = (SELECT MIN(fechaCaptura) FROM complementopagos WHERE (uuid IS NULL OR uuid = '' OR uuid = '0') and fechaCaptura >'2025-06-16')");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5305 */     int horas = 0;
/* 5306 */     int dias = 0;
/* 5307 */     for (String[] r : reg) {
/* 5308 */       horas = Integer.parseInt(r[6]);
/* 5309 */       dias = Integer.parseInt(r[7]);
/* 5310 */       System.out.println(r[0] + " " + r[0] + " " + r[1] + " " + r[2] + " " + r[3] + " " + r[4] + " " + r[5] + " " + r[6]);
/*      */     } 
/*      */     
/* 5313 */     if (horas > Integer.parseInt((String)this.CAMPOSGENERALES.get("tiempoSubirXMLComplemento"))) {
/* 5314 */       this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro22, new String[] { "Folio", "Cliente", "Fecha", "Moneda" }, "folioPago, cliente, fechaCaptura, moneda", "complementopagos", "where uuid ='' and fechaCaptura >'2025-06-16' order by folioPago desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5322 */       this.jLabel86.setText("" + this.rSTableMetro22.getRowCount());
/* 5323 */       this.jDialog4.setVisible(true);
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5332 */     if (sigue) {
/* 5333 */       this.VERSION = 2;
/* 5334 */       limpiar();
/* 5335 */       sacarMayor();
/* 5336 */       convertir20();
/* 5337 */       this.jFormattedTextField1.setEnabled(false);
/* 5338 */       this.jDialog2.setVisible(false);
/* 5339 */       this.jDialog1.setTitle("Crear Nuevo");
/* 5340 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void leerXML(String dir) {
/* 5345 */     Map<String, String> camposXML = new HashMap<>();
/* 5346 */     Map<String, String> camposFactura = new HashMap<>();
/* 5347 */     String[] valores = { "Folio", "Serie" };
/*      */     
/* 5349 */     if (this.SINXML) {
/* 5350 */       String folioCompleto = this.rSTableMetro22.getValueAt(this.rSTableMetro22.getSelectedRow(), 0).toString();
/*      */ 
/*      */       
/* 5353 */       String letras = folioCompleto.replaceAll("[0-9]", "");
/* 5354 */       String numeros = folioCompleto.replaceAll("[^0-9]", "");
/*      */ 
/*      */       
/* 5357 */       camposFactura.put(valores[0], numeros);
/*      */       
/* 5359 */       camposFactura.put(valores[1], letras);
/*      */     } else {
/* 5361 */       String folioCompleto = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString();
/*      */ 
/*      */       
/* 5364 */       String letras = folioCompleto.replaceAll("[0-9]", "");
/* 5365 */       String numeros = folioCompleto.replaceAll("[^0-9]", "");
/*      */ 
/*      */       
/* 5368 */       camposFactura.put(valores[0], numeros);
/*      */       
/* 5370 */       camposFactura.put(valores[1], letras);
/*      */     } 
/*      */     
/* 5373 */     JespXML archivo = new JespXML(dir);
/*      */     try {
/* 5375 */       Tag raiz = archivo.leerXML();
/* 5376 */       for (Atributo a : raiz.getAtributos()) {
/* 5377 */         if (Arrays.<String>asList(valores).contains(a.getNombre())) {
/* 5378 */           if (a.getNombre().equals("Fecha")) {
/* 5379 */             camposXML.put(a.getNombre(), a.getValor().substring(0, a.getValor().length() - 3));
/*      */           } else {
/* 5381 */             camposXML.put(a.getNombre(), a.getValor());
/*      */           } 
/*      */         }
/* 5384 */         llenarCampos(a);
/*      */       } 
/* 5386 */       recorrer(raiz);
/*      */     }
/* 5388 */     catch (ParserConfigurationException ex) {
/* 5389 */       Logger.getLogger(ProvFacturas.class
/* 5390 */           .getName()).log(Level.SEVERE, (String)null, ex);
/*      */     }
/* 5392 */     catch (SAXException ex) {
/* 5393 */       Logger.getLogger(ProvFacturas.class
/* 5394 */           .getName()).log(Level.SEVERE, (String)null, ex);
/*      */     }
/* 5396 */     catch (IOException ex) {
/* 5397 */       Logger.getLogger(ProvFacturas.class
/* 5398 */           .getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */     
/* 5401 */     this.utilerias.imprimirMapa(camposXML);
/* 5402 */     System.out.println("__________________");
/* 5403 */     this.utilerias.imprimirMapa(camposFactura);
/* 5404 */     if (!camposXML.equals(camposFactura)) {
/* 5405 */       this.jTextField104.setText("");
/* 5406 */       this.jTextField91.setText("");
/* 5407 */       this.jTextField98.setText("");
/* 5408 */       JOptionPane.showMessageDialog(this.padre, "La información del XMl no corresponde a la factura capturada", "Diferentes", 0, this.ADVER);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void recorrer(Tag raiz) {
/* 5414 */     for (Tag t : raiz.getTagsHijos()) {
/* 5415 */       for (Atributo a : t.getAtributos()) {
/* 5416 */         llenarCampos(a);
/*      */       }
/* 5418 */       if (t.isHijos()) {
/* 5419 */         recorrer(t);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCampos(Atributo a) {
/* 5425 */     if (a.getNombre().toUpperCase().equals("UUID")) {
/* 5426 */       this.jTextField91.setText(a.getValor().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   public void aplicarFacturas() {
/* 5431 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro9, new String[] { "mov", "Interno", "importeOriginal", "Anterior", "saldado", "Pago1", "Pago2", "Pago3", "Pago4", "numParcialidad", "Impor Sal Tarj", "Importe Original" }, "mov, folioInterno, importeOriginal, importeAnterior, complementopagosfacturas.importeSaldado, pago1, pago2, pago3, pago4, numParcialidad, tarjeta_contenido_cliente.importeSaldado, tarjeta_contenido_cliente.importeLetra", "complementopagosfacturas, tarjeta_contenido_cliente", "WHERE complementopagosfacturas.folioInterno = tarjeta_contenido_cliente.factura and  folioPago = '" + this.jTextField5
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5437 */         .getText() + "'");
/*      */ 
/*      */     
/* 5440 */     String txtSalda = "";
/* 5441 */     double[] abonos = new double[this.rSTableMetro9.getRowCount()];
/* 5442 */     double[] saldado = new double[this.rSTableMetro9.getRowCount()];
/* 5443 */     double[] restante = new double[this.rSTableMetro9.getRowCount()];
/* 5444 */     this.COL1 = new String[this.rSTableMetro9.getRowCount()];
/* 5445 */     this.VALOR1 = 0.0D;
/* 5446 */     this.VALOR2 = 0.0D;
/*      */ 
/*      */     
/* 5449 */     String[] auxSaldado = this.utilerias.dameColumnaDeTabla((JTable)this.rSTableMetro9, 4);
/* 5450 */     for (int i = 0; i < this.rSTableMetro9.getRowCount(); i++) {
/* 5451 */       String factura = String.valueOf(this.rSTableMetro9.getValueAt(i, 1));
/*      */       
/* 5453 */       String v1 = String.valueOf(this.rSTableMetro9.getValueAt(i, 3));
/* 5454 */       String v2 = String.valueOf(this.rSTableMetro9.getValueAt(i, 4));
/*      */       
/* 5456 */       if (!v1.equals(v2)) {
/* 5457 */         txtSalda = txtSalda + "\n" + txtSalda + "   <Abono>";
/*      */       } else {
/* 5459 */         txtSalda = txtSalda + "\n" + txtSalda + "   <Pagada>";
/*      */       } 
/* 5461 */       saldado[i] = this.utilerias.convertirCantTexto(auxSaldado[i]); saldado[i] = this.utilerias.convertirCantTexto(auxSaldado[i]);
/* 5462 */       restante[i] = this.utilerias.convertirCantTexto(v1);
/* 5463 */       abonos[i] = this.utilerias.convertirCantTexto(v2);
/*      */     } 
/*      */ 
/*      */     
/* 5467 */     int nAbono = 0;
/* 5468 */     int nPagada = 0;
/* 5469 */     this.TIPOS = new String[this.rSTableMetro9.getRowCount()];
/*      */ 
/*      */     
/* 5472 */     String insertarFac = "";
/* 5473 */     String insertarGuias = "";
/*      */     
/* 5475 */     int rowCount = this.rSTableMetro9.getRowCount();
/* 5476 */     int colCount = 4;
/* 5477 */     String[][] MovTabla = new String[rowCount][colCount];
/* 5478 */     for (int j = 0; j < rowCount; j++) {
/* 5479 */       for (int m = 4; m < 8; m++)
/*      */       {
/* 5481 */         MovTabla[j][m - 4] = this.rSTableMetro9.getValueAt(j, m + 1).toString();
/*      */       }
/*      */     } 
/*      */     
/* 5485 */     boolean insertando = false;
/* 5486 */     boolean modificando = false;
/* 5487 */     for (int k = 0; k < this.rSTableMetro9.getRowCount(); k++) {
/* 5488 */       String mov = String.valueOf(this.rSTableMetro9.getValueAt(k, 0));
/* 5489 */       String v1 = String.valueOf(this.rSTableMetro9.getValueAt(k, 3));
/* 5490 */       String v2 = String.valueOf(this.rSTableMetro9.getValueAt(k, 4));
/* 5491 */       String actRef = "pago4";
/*      */       
/* 5493 */       this.VALOR1 += this.utilerias.convertirCantTexto(String.valueOf(this.rSTableMetro9.getValueAt(k, 2)));
/* 5494 */       if (MovTabla[k][0].equals("")) {
/* 5495 */         actRef = "pago1";
/* 5496 */       } else if (MovTabla[k][1].equals("")) {
/* 5497 */         actRef = "pago2";
/* 5498 */       } else if (MovTabla[k][2].equals("")) {
/* 5499 */         actRef = "pago3";
/* 5500 */       } else if (MovTabla[k][3].equals("")) {
/* 5501 */         actRef = "pago4";
/*      */       } 
/*      */       
/* 5504 */       if (!v1.equals(v2)) {
/* 5505 */         double ImporteSaldadoTarjeta = Double.parseDouble(this.rSTableMetro9.getValueAt(k, 10).toString()) + saldado[k];
/* 5506 */         modificando = true;
/* 5507 */         nAbono++;
/* 5508 */         double salda = saldado[k] + abonos[k];
/* 5509 */         salda = redondear(salda).doubleValue();
/* 5510 */         this.cantidad.setValue(Double.valueOf(salda));
/*      */         
/* 5512 */         restante[k] = restante[k] - abonos[k];
/* 5513 */         restante[k] = redondear(restante[k]).doubleValue();
/*      */ 
/*      */ 
/*      */         
/* 5517 */         this.TIPOS[k] = "<ABONO>";
/* 5518 */         this.COL1[k] = this.utilerias.convertirDoublePesos(restante[k]);
/* 5519 */         this.VALOR2 += restante[k];
/*      */ 
/*      */         
/* 5522 */         this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField5
/*      */             
/* 5524 */             .getText().toUpperCase() + " - " + this.jTextField31.getText().toUpperCase() + " - " + this.utilerias.convertirDoublePesos(saldado[k]) + "', importesaldado = " + ImporteSaldadoTarjeta + ", estatus='<Abono:" + this.utilerias
/* 5525 */             .convertirDoublePesos(ImporteSaldadoTarjeta) + ">',importeRestante = " + restante[k] + ",importeRestanteLetra='" + this.utilerias
/* 5526 */             .convertirDoublePesos(restante[k]) + "' where mov=" + mov);
/*      */ 
/*      */         
/* 5529 */         String factura = this.rSTableMetro9.getValueAt(k, 1).toString();
/*      */         
/* 5531 */         int parcialidad = Integer.parseInt(this.rSTableMetro9.getValueAt(k, 9).toString());
/* 5532 */         this.con.inserSinMsj("update facturas33 set estatus='<Abono: " + this.utilerias.convertirDoublePesos(ImporteSaldadoTarjeta) + ">', numParcialidad=" + parcialidad + ", totalDebe='" + this.utilerias.convertirDoublePesos(restante[k]) + "' where folio ='" + factura + "'");
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5542 */         insertando = true;
/* 5543 */         nPagada++;
/* 5544 */         this.TIPOS[k] = "<PAGADA>";
/* 5545 */         double salda = saldado[k] + abonos[k];
/* 5546 */         this.COL1[k] = "$0.00";
/* 5547 */         this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "= '" + this.jTextField5
/*      */             
/* 5549 */             .getText().toUpperCase() + " - " + this.jTextField31.getText().toUpperCase() + " - " + this.utilerias.convertirDoublePesos(saldado[k]) + "',estatus = '<Pagado:" + 
/* 5550 */             cargarFechaHoy3() + ">', importeSaldado = " + this.utilerias.convertirCantTexto(this.rSTableMetro9.getValueAt(k, 11).toString()) + ",importeRestante =0, importeRestanteLetra='$0.00' where mov=" + mov);
/*      */ 
/*      */         
/* 5553 */         String factura = this.rSTableMetro9.getValueAt(k, 1).toString();
/* 5554 */         int parcialidad = Integer.parseInt(this.rSTableMetro9.getValueAt(k, 9).toString());
/* 5555 */         this.con.inserSinMsj("update facturas33 set estatus='<Pagada: " + cargarFechaHoy3() + ">', numParcialidad=" + parcialidad + ", totalDebe='$0.00' where folio ='" + factura + "'");
/*      */         
/* 5557 */         insertarFac = insertarFac + "('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro9.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro9.getValueAt(k, 2)) + "','$0.00')";
/* 5558 */         insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 5559 */         if (k + 1 < this.rSTableMetro9.getRowCount()) {
/* 5560 */           insertarFac = insertarFac + " , ";
/* 5561 */           insertarGuias = insertarGuias + " or ";
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5566 */     System.out.println("linea antes: " + insertarGuias);
/*      */ 
/*      */     
/* 5569 */     if (!insertarGuias.equals("")) {
/* 5570 */       System.out.println("linea: " + insertarGuias.substring(insertarGuias.length() - 4, insertarGuias.length()));
/* 5571 */       String termina = insertarGuias.substring(insertarGuias.length() - 4, insertarGuias.length());
/* 5572 */       if (termina.equals(" or ")) {
/* 5573 */         insertarGuias = insertarGuias.substring(0, insertarGuias.length() - 4);
/*      */       }
/* 5575 */       this.con.inserSinMsj("update guias set estatus='<Pagada: " + cargarFechaHoy3() + ">' where " + insertarGuias);
/*      */     } 
/*      */     
/* 5578 */     int tipo = 1;
/* 5579 */     String concepto = "ABONO A FACTURAS";
/* 5580 */     this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 5581 */     double total = Double.parseDouble(this.con.Campo);
/* 5582 */     this.cantidad.setValue(Double.valueOf(total));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5590 */     this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep, tipo,concepto, referencia, importe,importeLetra, abono, abonoLetra,importeSaldado, importeRestante, importeRestanteLetra, estatus, comentario, factura,num_abono, saldoFinal, saldoFinalLetra, pago1, pago2, pago3, pago4,tarjeta, usuario, fechaPago, moneda, tipoCambio, saldoMXN )values( now(),    2," + tipo + ", '" + concepto + "','" + this.jTextField5
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5602 */         .getText().toUpperCase() + " - " + this.jTextField31.getText().toUpperCase() + "',0,''," + 
/* 5603 */         String.valueOf(this.jFormattedTextField4.getValue()) + ",'" + this.jFormattedTextField4.getText() + "',0,0,'','<Aplicado>','','','ABONO'," + total + ",'" + this.cantidad
/*      */ 
/*      */         
/* 5606 */         .getText() + "','','','',''," + this.CLAVECLIENTE + ",'" + this.USUARIO + "',now(), '" + this.jTextField85
/*      */         
/* 5608 */         .getText() + "','" + this.jFormattedTextField1.getText() + "','')");
/*      */ 
/*      */     
/* 5611 */     this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.CLAVECLIENTE);
/*      */   }
/*      */   
/*      */   public Double redondear(double pasar) {
/* 5615 */     return Double.valueOf(Math.rint(pasar * 100.0D) / 100.0D);
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy3() {
/* 5619 */     Calendar ahoraCal = this.jDateChooser4.getCalendar();
/* 5620 */     ahoraCal.setTime(this.jDateChooser4.getCalendar().getTime());
/* 5621 */     String mesesito = "";
/* 5622 */     String hoy = "";
/* 5623 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 5624 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 5626 */     if (ahoraCal.get(2) + 1 < 10) {
/* 5627 */       mesesito = "0" + mesesito;
/*      */     }
/* 5629 */     if (ahoraCal.get(5) < 10) {
/* 5630 */       hoy = "0" + hoy;
/*      */     }
/* 5632 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void consultarHistorialDolar() {
/* 5636 */     String fechaCompleta1 = "";
/* 5637 */     String fechaCompleta2 = "";
/* 5638 */     String consultaFecha = "";
/* 5639 */     if (this.jComboBox41.getSelectedIndex() != 0) {
/* 5640 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/* 5642 */       int aa = Integer.parseInt(this.jComboBox40.getSelectedItem().toString());
/* 5643 */       consultaFecha = "  date_format( fecha, '%m-%Y') = '" + mes[this.jComboBox41.getSelectedIndex()] + "-" + aa + "' ";
/*      */     } else {
/* 5645 */       Date fecha1 = this.jDateChooser14.getDate();
/* 5646 */       Date fecha2 = this.jDateChooser15.getDate();
/* 5647 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5648 */       String cadenaFecha = "";
/* 5649 */       cadenaFecha = formato.format(fecha1);
/* 5650 */       String AÑO = cadenaFecha.substring(0, 4);
/* 5651 */       String MES = cadenaFecha.substring(4, 6);
/* 5652 */       String DIA = cadenaFecha.substring(6, 8);
/* 5653 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 5655 */       cadenaFecha = formato.format(fecha2);
/* 5656 */       String aa = cadenaFecha.substring(0, 4);
/* 5657 */       String mm = cadenaFecha.substring(4, 6);
/* 5658 */       String dd = cadenaFecha.substring(6, 8);
/* 5659 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 5660 */       consultaFecha = " fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*      */     
/* 5663 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro20, new String[] { "ID", "Fecha", "Día", "Tipo de Cambio", "Usuario" }, "num, fecha, dia, cambio, usuario", "dolarhistorico", "where " + consultaFecha + " order by num desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5671 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro20, this.celda6);
/*      */   }
/*      */ 
/*      */   
/*      */   public void validarDolar() {
/* 5676 */     if (this.jDialog1.getTitle().equals("Crear Nuevo"))
/*      */     {
/* 5678 */       if (this.jTextField85.getText().equals("USD")) {
/* 5679 */         String fechaSelec = this.utilerias.convertirFechaDateString(this.jDateChooser1.getDate());
/* 5680 */         String fechaAnt = "2024-10-07";
/* 5681 */         if (this.jDateChooser1.getDate().before(this.utilerias.convertirFechaStringADate(fechaAnt))) {
/* 5682 */           this.jFormattedTextField1.setEnabled(true);
/* 5683 */           this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */         } else {
/* 5685 */           this.encontrado = this.con.consultar("cambio", "dolarhistorico", "WHERE DATE(`fecha`) = '" + fechaSelec + "' ");
/* 5686 */           if (this.encontrado) {
/* 5687 */             this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 5688 */             this.jFormattedTextField1.setEnabled(false);
/*      */           } else {
/*      */             
/* 5691 */             String[] datos = this.con.regresaRegIndex("cambio, fecha", "dolarhistorico", "WHERE fecha = '" + fechaSelec + "' UNION ALL SELECT cambio, fecha FROM dolarhistorico WHERE fecha >'" + fechaSelec + "' ORDER BY fecha ASC ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5701 */             this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(datos[0])));
/* 5702 */             this.jFormattedTextField1.setEnabled(false);
/*      */           } 
/*      */         } 
/*      */       } else {
/* 5706 */         this.jFormattedTextField1.setValue(Integer.valueOf(1));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void cargarAutoCuentasReceptoras() {
/* 5714 */     this.com_ReceptorBancoCuenta.addItems(this.TODOS_RECEPTORBANCOCUENTA);
/*      */   }
/*      */   
/*      */   public int sacarParcialidad(String folio) {
/* 5718 */     this.con.consultar("numParcialidad", "facturas33", "where folio ='" + folio + "'");
/* 5719 */     int parcialidad = Integer.parseInt(this.con.Campo);
/* 5720 */     parcialidad++;
/* 5721 */     return parcialidad;
/*      */   }
/*      */   
/*      */   public void crearComprobante20(String nombre, String RUTA20) throws IOException {
/* 5725 */     String[] datComplemento = this.con.regresaColIndex("totalTrasladoBase", "complementopagos", "where folioPago = '" + nombre + "'");
/* 5726 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "30", "99" };
/* 5727 */     String folio = this.jTextField5.getText();
/* 5728 */     String conse = "";
/* 5729 */     String letra = "";
/* 5730 */     double baseRetencion = 0.0D;
/* 5731 */     double retenciones = 0.0D;
/* 5732 */     double basesIva = 0.0D;
/* 5733 */     double basesRet = 0.0D;
/* 5734 */     for (int i = 0; i < folio.length(); i++) {
/*      */       try {
/* 5736 */         int valor = Integer.parseInt("" + folio.charAt(i));
/* 5737 */         conse = conse + conse;
/* 5738 */       } catch (NumberFormatException e) {
/* 5739 */         letra = letra + letra;
/*      */       } 
/*      */     } 
/*      */     
/* 5743 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RUTA20 + "/" + RUTA20 + ".yaml"), "utf-8"));
/* 5744 */     out.write("\n");
/* 5745 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/* 5746 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/* 5747 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/* 5748 */     out.write("\n");
/* 5749 */     out.write("--- !diverza.com/v2.0\n\n");
/* 5750 */     out.write("#DATOS GENERALES\n");
/* 5751 */     out.write("Comprobante:\n\n");
/* 5752 */     out.write("  NombreCfdi: \"" + this.jTextField5.getText() + "\"\n");
/* 5753 */     out.write("  RefId: \"" + this.jTextField5.getText() + "\"\n");
/* 5754 */     out.write("  Serie: \"" + letra + "\"\n");
/* 5755 */     out.write("  Folio: \"" + conse + "\"\n");
/* 5756 */     out.write("  Version: \"4.0\"\n");
/* 5757 */     String fecha = "";
/* 5758 */     if (this.jDialog1.getTitle().equals("Crear Nuevo")) {
/* 5759 */       DateFormat hr = new SimpleDateFormat("HH:mm:ss");
/* 5760 */       fecha = this.FECHAGRAL + " " + this.FECHAGRAL;
/*      */     } else {
/* 5762 */       fecha = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4).toString();
/*      */     } 
/* 5764 */     String año = fecha.substring(0, 4);
/* 5765 */     String mes = fecha.substring(5, 7);
/* 5766 */     String dia = fecha.substring(8, 10);
/* 5767 */     String hh = fecha.substring(11, 13);
/* 5768 */     String mm = fecha.substring(14, 16);
/* 5769 */     String ss = fecha.substring(17, 19);
/* 5770 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/*      */     
/* 5772 */     out.write("  Sello: \"\"\n");
/* 5773 */     out.write("  NoCertificado: \"" + this.DATOS[4] + "\"\n");
/* 5774 */     out.write("  SubTotal: \"0\"\n");
/* 5775 */     out.write("  Moneda: \"XXX\"\n");
/* 5776 */     out.write("  Total: \"0\"\n");
/* 5777 */     out.write("  TipoDeComprobante: \"P\"\n");
/* 5778 */     out.write("  LugarExpedicion: \"" + this.DATOS[3] + "\"\n\n");
/* 5779 */     out.write("  Exportacion: \"01\"\n");
/*      */     
/* 5781 */     out.write("  Emisor:\n");
/* 5782 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/* 5783 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS\"\n");
/* 5784 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*      */     
/* 5786 */     out.write("  Receptor: \n");
/* 5787 */     out.write("    Rfc: \"" + this.jTextField14.getText() + "\"\n");
/*      */     
/* 5789 */     out.write("    Nombre: \"" + String.valueOf(this.RAZONSOCIAL.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 5790 */     if (this.jTextField14.getText().equals("XEXX010101000")) {
/* 5791 */       out.write("    DomicilioFiscalReceptor: \"" + (String)this.CAMPOSGENERALES.get("codigoPostal") + "\"\n");
/*      */     } else {
/* 5793 */       out.write("    DomicilioFiscalReceptor: \"" + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/*      */     } 
/*      */     
/* 5796 */     out.write("    RegimenFiscalReceptor: \"" + String.valueOf(this.REGIMENES.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 5797 */     out.write("    UsoCFDI: \"CP01\"\n\n");
/*      */     
/* 5799 */     out.write("  Conceptos: \n");
/* 5800 */     out.write("    -\n");
/* 5801 */     out.write("      Concepto: \n");
/* 5802 */     out.write("      ClaveProdServ: \"84111506\"\n");
/* 5803 */     out.write("      Cantidad: \"1\"\n");
/* 5804 */     out.write("      ClaveUnidad: \"ACT\"\n");
/* 5805 */     out.write("      Descripcion: \"Pago\"\n");
/* 5806 */     out.write("      ValorUnitario: \"0\"\n");
/* 5807 */     out.write("      Importe: \"0\"\n");
/* 5808 */     out.write("      ObjetoImp: \"01\"\n");
/* 5809 */     out.write("\n");
/*      */     
/* 5811 */     out.write("  Complemento: \n");
/* 5812 */     out.write("    Pagos:\n");
/* 5813 */     out.write("      Version: \"2.0\"\n");
/* 5814 */     out.write("      Totales:\n");
/* 5815 */     DecimalFormat df = new DecimalFormat("0.00");
/*      */     
/* 5817 */     if (this.jTextField85.getText().equals("USD")) {
/* 5818 */       double dolar = this.utilerias.convertirCantTexto(this.jFormattedTextField1.getText());
/*      */ 
/*      */       
/* 5821 */       if (this.utilerias.convertirCantTexto(datComplemento[0]) > 0.0D) {
/* 5822 */         double d = dolar * this.utilerias.convertirCantTexto(datComplemento[0]);
/*      */ 
/*      */ 
/*      */         
/* 5826 */         out.write("        TotalTrasladosBaseIVA16: \"" + String.format("%.2f", new Object[] { Double.valueOf(d) }) + "\"\n");
/*      */       } 
/*      */       
/* 5829 */       if (this.utilerias.convertirCantTexto(this.jLabel38.getText()) > 0.0D) {
/* 5830 */         double d = dolar * this.utilerias.convertirCantTexto(this.jLabel38.getText());
/* 5831 */         out.write("        TotalTrasladosImpuestoIVA16: \"" + String.format("%.2f", new Object[] { Double.valueOf(d) }) + "\"\n");
/*      */       } 
/*      */       
/* 5834 */       if (this.utilerias.convertirCantTexto(this.jLabel40.getText()) > 0.0D) {
/* 5835 */         double d = dolar * this.utilerias.convertirCantTexto(this.jLabel40.getText());
/* 5836 */         out.write("        TotalRetencionesIVA: \"" + String.format("%.2f", new Object[] { Double.valueOf(d) }) + "\"\n");
/*      */       } 
/*      */       
/* 5839 */       double op = dolar * this.utilerias.convertirCantTexto(this.jFormattedTextField4.getText());
/* 5840 */       out.write("        MontoTotalPagos: \"" + String.format("%.2f", new Object[] { Double.valueOf(op) }) + "\"\n");
/*      */     } else {
/*      */       
/* 5843 */       String str = df.format(this.jFormattedTextField4.getValue());
/* 5844 */       if (this.utilerias.convertirCantTexto(datComplemento[0]) > 0.0D) {
/*      */ 
/*      */         
/* 5847 */         double sum = this.utilerias.convertirCantTexto(datComplemento[0]);
/* 5848 */         String montoIva = df.format(sum);
/* 5849 */         out.write("        TotalTrasladosBaseIVA16: \"" + montoIva + "\"\n");
/*      */       } 
/*      */       
/* 5852 */       if (this.utilerias.convertirCantTexto(this.jLabel38.getText()) > 0.0D) {
/* 5853 */         out.write("        TotalTrasladosImpuestoIVA16: \"" + this.utilerias.convertirCantTexto(this.jLabel38.getText()) + "\"\n");
/*      */       }
/*      */       
/* 5856 */       if (this.utilerias.convertirCantTexto(this.jLabel40.getText()) > 0.0D) {
/* 5857 */         out.write("        TotalRetencionesIVA: \"" + this.utilerias.convertirCantTexto(this.jLabel40.getText()) + "\"\n");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 5862 */       out.write("        MontoTotalPagos: \"" + str + "\"\n");
/*      */     } 
/*      */     
/* 5865 */     out.write("      Pago:\n");
/* 5866 */     out.write("        -\n");
/*      */     
/* 5868 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5869 */     String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 5870 */     año = cadenaFecha1.substring(0, 4);
/* 5871 */     mes = cadenaFecha1.substring(4, 6);
/* 5872 */     dia = cadenaFecha1.substring(6, 8);
/* 5873 */     String fechaDeposito = año + "-" + año + "-" + mes + "T" + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/* 5874 */     out.write("          FechaPago: \"" + fechaDeposito + "\"\n");
/* 5875 */     out.write("          FormaDePagoP: \"" + metodos[this.jComboBox18.getSelectedIndex()] + "\"\n");
/* 5876 */     out.write("          MonedaP: \"" + this.jTextField85.getText() + "\"\n");
/* 5877 */     if (!this.jTextField85.getText().equals("MXN")) {
/* 5878 */       out.write("          TipoCambioP: \"" + this.jFormattedTextField1.getText() + "\"\n");
/*      */     } else {
/* 5880 */       out.write("          TipoCambioP: \"1\"\n");
/*      */     } 
/*      */     
/* 5883 */     String monto = df.format(this.jFormattedTextField4.getValue());
/*      */     
/* 5885 */     out.write("          Monto: \"" + monto + "\"\n");
/* 5886 */     out.write("          NumOperacion: \"" + this.jTextField26.getText().toUpperCase() + "\"\n");
/* 5887 */     out.write("          RfcEmisorCtaOrd: \"" + this.jTextField27.getText().toUpperCase() + "\"\n");
/* 5888 */     out.write("          CtaOrdenante: \"" + this.jTextField29.getText().toUpperCase() + "\"\n");
/* 5889 */     out.write("          RfcEmisorCtaBen: \"" + this.jTextField30.getText().toUpperCase() + "\"\n");
/* 5890 */     out.write("          CtaBeneficiario: \"" + this.jTextField31.getText().toUpperCase() + "\"\n");
/* 5891 */     out.write("          TipoCadPago: \"" + this.jTextField16.getText().toUpperCase() + "\"\n");
/* 5892 */     out.write("          CertPago: \"" + this.jTextField17.getText().toUpperCase() + "\"\n");
/* 5893 */     out.write("          SelloPago: \"" + this.jTextField18.getText().toUpperCase() + "\"\n");
/*      */     
/* 5895 */     out.write("\n");
/* 5896 */     out.write("          DoctoRelacionado: \n"); int j;
/* 5897 */     for (j = 0; j < this.rSTableMetro6.getRowCount(); j++) {
/* 5898 */       out.write("            -\n");
/* 5899 */       out.write("              IdDocumento: \"" + String.valueOf(this.rSTableMetro6.getValueAt(j, 2)) + "\"\n");
/* 5900 */       String folioFact = String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(j, 0));
/* 5901 */       out.write("              Serie: \"" + String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + "\"\n");
/* 5902 */       out.write("              Folio: \"" + String.valueOf(this.rSTableMetro6.getValueAt(j, 1)) + "\"\n");
/* 5903 */       String[] datos = this.con.regresaRegIndex("moneda, pagoMetodo, tipoCambio, numParcialidad", "facturas33", "where folio='" + folioFact + "'");
/* 5904 */       out.write("              MonedaDR: \"" + datos[0] + "\"\n");
/* 5905 */       out.write("              NumParcialidad: \"" + Integer.parseInt(datos[3]) + 1 + "\"\n");
/* 5906 */       out.write("              ImpSaldoAnt: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 3).toString()) + "\"\n");
/* 5907 */       out.write("              ImpPagado: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 4).toString()) + "\"\n");
/* 5908 */       out.write("              ImpSaldoInsoluto: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 5).toString()) + "\"\n");
/* 5909 */       out.write("              ObjetoImpDR: \"" + ((Facturas)this.FACTURAS.get(folioFact)).getObjImp() + "\"\n");
/* 5910 */       out.write("              EquivalenciaDR: \"1\"\n");
/* 5911 */       out.write("\n");
/* 5912 */       imprimirImpuestos();
/*      */ 
/*      */ 
/*      */       
/* 5916 */       if ((this.IMPUESTOSIVA.containsKey(folioFact) || this.IMPUESTOSRET.containsKey(folioFact)) && (!((ImpuestosIva)this.IMPUESTOSIVA.get(folioFact)).getImporte().equals("$0.00") || !((ImpuestosRet)this.IMPUESTOSRET.get(folioFact)).getImporte().equals("$0.00"))) {
/* 5917 */         out.write("              ImpuestosDR:\n");
/*      */         
/* 5919 */         if (this.IMPUESTOSIVA.containsKey(folioFact) && !((ImpuestosIva)this.IMPUESTOSIVA.get(folioFact)).getImporte().equals("$0.00")) {
/* 5920 */           out.write("                TrasladosDR:\n");
/* 5921 */           out.write("                  TrasladoDR:\n");
/* 5922 */           out.write("                    -\n");
/* 5923 */           out.write("                      BaseDR: \"" + this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase()) + "\"\n");
/* 5924 */           System.out.println("ivass " + this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase()));
/* 5925 */           basesIva += this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase());
/*      */           
/* 5927 */           out.write("                      ImpuestoDR: \"002\"\n");
/* 5928 */           out.write("                      TipoFactorDR: \"Tasa\"\n");
/* 5929 */           out.write("                      TasaOCuotaDR: \"0.160000\"\n");
/* 5930 */           out.write("                      ImporteDR: \"" + this.utilerias.convertirCantTexto(((ImpuestosIva)this.IMPUESTOSIVA.get(folioFact)).getImporte()) + "\"\n");
/*      */         } 
/*      */         
/* 5933 */         out.write("\n");
/*      */         
/* 5935 */         if (this.IMPUESTOSRET.containsKey(folioFact) && !((ImpuestosRet)this.IMPUESTOSRET.get(folioFact)).getImporte().equals("$0.00")) {
/* 5936 */           double importeBase = this.utilerias.convertirCantTexto(((ImpuestosRet)this.IMPUESTOSRET.get(folioFact)).getImporte()) * 100.0D / 4.0D;
/* 5937 */           double res1 = this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase()) - importeBase;
/* 5938 */           double res2 = importeBase - this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5944 */           if (res1 < 1.5D) {
/* 5945 */             importeBase = this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folioFact)).getTotalTrasBase());
/*      */           }
/* 5947 */           baseRetencion += importeBase;
/* 5948 */           System.out.println("bases REt " + baseRetencion + " , " + importeBase);
/*      */           
/* 5950 */           out.write("                RetencionesDR:\n");
/* 5951 */           out.write("                  RetencionDR:\n");
/* 5952 */           out.write("                    -\n");
/*      */           
/* 5954 */           out.write("                      BaseDR: \"" + importeBase + "\"\n");
/* 5955 */           out.write("                      ImpuestoDR: \"002\"\n");
/* 5956 */           out.write("                      TipoFactorDR: \"Tasa\"\n");
/* 5957 */           out.write("                      TasaOCuotaDR: \"0.040000\"\n");
/* 5958 */           out.write("                      ImporteDR: \"" + this.utilerias.convertirCantTexto(((ImpuestosRet)this.IMPUESTOSRET.get(folioFact)).getImporte()) + "\"\n");
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 5963 */       out.write("\n");
/*      */     } 
/*      */ 
/*      */     
/* 5967 */     if (this.IMPUESTOSIVA.size() > 0 || this.IMPUESTOSRET.size() > 0) {
/* 5968 */       out.write("          ImpuestosP: \n");
/* 5969 */       if (this.IMPUESTOSIVA.size() > 0 && this.utilerias.convertirCantTexto(this.jLabel38.getText()) > 0.0D) {
/* 5970 */         out.write("            TrasladosP: \n");
/* 5971 */         out.write("              TrasladoP: \n");
/* 5972 */         out.write("                -\n");
/* 5973 */         out.write("                  BaseP: \"" + this.utilerias.convertirCantTexto(datComplemento[0]) + "\"\n");
/* 5974 */         out.write("                  ImpuestoP: \"002\"\n");
/* 5975 */         out.write("                  TipoFactorP: \"Tasa\"\n");
/* 5976 */         out.write("                  TasaOCuotaP: \"0.160000\"\n");
/* 5977 */         out.write("                  ImporteP: \"" + this.utilerias.convertirCantTexto(this.jLabel38.getText()) + "\"\n");
/*      */       } 
/*      */ 
/*      */       
/* 5981 */       if (this.IMPUESTOSRET.size() > 0 && this.utilerias.convertirCantTexto(this.jLabel40.getText()) > 0.0D) {
/* 5982 */         out.write("            RetencionesP: \n");
/* 5983 */         out.write("              RetencionP: \n");
/* 5984 */         out.write("                -\n");
/*      */         
/* 5986 */         out.write("                  BaseP: \"" + baseRetencion + "\"\n");
/* 5987 */         out.write("                  ImpuestoP: \"002\"\n");
/* 5988 */         out.write("                  TipoFactorP: \"Tasa\"\n");
/* 5989 */         out.write("                  TasaOCuotaP: \"0.040000\"\n");
/* 5990 */         out.write("                  ImporteP: \"" + this.utilerias.convertirCantTexto(this.jLabel40.getText()) + "\"\n");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 5995 */     System.out.println("bases iva " + basesIva);
/*      */     
/* 5997 */     out.write("\n");
/* 5998 */     out.write("  Addenda: \n");
/* 5999 */     out.write("    Diverza: \n");
/* 6000 */     out.write("      Version: \"1.1\"\n\n");
/* 6001 */     out.write("      Generales: \n");
/*      */     
/* 6003 */     out.write("      DatosContactoE: \n");
/* 6004 */     if (this.DATOS[2].equals("POZA RICA")) {
/* 6005 */       out.write("        Telefono: \"01 782 825 6455 al 01 782 825 6458\"\n");
/* 6006 */     } else if (this.DATOS[2].equals("VERACRUZ")) {
/* 6007 */       out.write("        Telefono: \"01 (229) 924-8600 al 03\"\n");
/* 6008 */     } else if (this.DATOS[2].equals("CARDENAS")) {
/* 6009 */       out.write("        Telefono: \"(01 937) 372 7301 al 10\"\n");
/* 6010 */     } else if (this.DATOS[2].equals("CADEREYTA")) {
/* 6011 */       out.write("        Telefono: \"828 284 4444\"\n");
/*      */     } 
/* 6013 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*      */     
/* 6015 */     out.write("      Emisor: \n");
/* 6016 */     out.write("        DomicilioFiscalE: \n");
/* 6017 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/* 6018 */     out.write("          Numero: \"KM 32.5\"\n");
/* 6019 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/* 6020 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/* 6021 */     out.write("          Estado: \"NUEVO LEON\"\n");
/* 6022 */     out.write("          Pais: \"MEXICO\"\n");
/* 6023 */     out.write("          CodigoPostal: \"67483\"\n");
/*      */     
/* 6025 */     if (this.DATOS[2].equals("POZA RICA")) {
/* 6026 */       out.write("        SucursalE: \n");
/* 6027 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6028 */       out.write("          DomicilioSucursal: \n");
/* 6029 */       out.write("            Calle: \"CARRETERA POZA RICA A TIHUATLAN KM 8.5 \"\n");
/* 6030 */       out.write("            Ciudad: \"TIHUATLAN\"\n");
/* 6031 */       out.write("            Estado: \"VERACRUZ\"\n");
/* 6032 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6033 */       out.write("            CodigoPostal: \"92900\"\n\n");
/* 6034 */     } else if (this.DATOS[2].equals("VERACRUZ")) {
/* 6035 */       out.write("        SucursalE: \n");
/* 6036 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6037 */       out.write("          DomicilioSucursal: \n");
/* 6038 */       out.write("            Calle: \"CARRETERA A CARDEL (NUEVA ERA) KM 5\"\n");
/* 6039 */       out.write("            Ciudad: \"VERACRUZ\"\n");
/* 6040 */       out.write("            Estado: \"VERACRUZ\"\n");
/* 6041 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6042 */       out.write("            CodigoPostal: \"91809\"\n\n");
/* 6043 */     } else if (this.DATOS[2].equals("CARDENAS")) {
/* 6044 */       out.write("        SucursalE: \n");
/* 6045 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6046 */       out.write("          DomicilioSucursal: \n");
/* 6047 */       out.write("            Calle: \"CARRETERA VILLAHERMOSA-CARDENAS KM 125+500\"\n");
/* 6048 */       out.write("            Ciudad: \"H. CARDENAS\"\n");
/* 6049 */       out.write("            Estado: \"TABASCO\"\n");
/* 6050 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6051 */       out.write("            CodigoPostal: \"86470\"\n\n");
/*      */     } 
/*      */     
/* 6054 */     out.write("      Receptor: \n");
/* 6055 */     out.write("        DomicilioFiscalR: \n");
/*      */     
/* 6057 */     out.write("          Calle: \"" + String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6058 */     out.write("          Numero: \"" + String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6059 */     out.write("          Colonia: \"" + String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6060 */     out.write("          Ciudad: \"" + String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6061 */     out.write("          Estado: \"" + String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6062 */     out.write("          CodigoPostal: \"" + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/*      */     
/* 6064 */     out.write("\n");
/* 6065 */     out.write("  LeyendasImpresion: \n");
/* 6066 */     out.write("    -\n");
/* 6067 */     for (j = 0; j < this.rSTableMetro5.getRowCount(); j++) {
/* 6068 */       out.write("      Atributo: \"" + String.valueOf(this.rSTableMetro5.getValueAt(j, 0)) + "\"\n");
/* 6069 */       out.write("      Valor: \"" + String.valueOf(this.rSTableMetro5.getValueAt(j, 1)) + "\"\n");
/*      */     } 
/* 6071 */     out.write("---");
/* 6072 */     out.close();
/*      */   }
/*      */   
/*      */   public void cargarImpuestos20(String folioComp) {
/* 6076 */     System.out.println("entra");
/* 6077 */     String[][] impuestos = this.con.buscarDatos("tipo, tasa, importe, folioComp, factura, estatus", "complementopagosfacturasimpuestos", "where folioComp = '" + folioComp + "'");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6082 */     for (int i = 0; i < impuestos.length; i++) {
/* 6083 */       String[] datos = { impuestos[i][4], impuestos[i][0], impuestos[i][1], "", folioComp, impuestos[i][4] };
/* 6084 */       agregarImpuesto(impuestos[i][0], impuestos[i][1], impuestos[i][2], datos, "NUEVO");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void imprimirImpuestos() {
/* 6092 */     for (Map.Entry<String, ImpuestosIva> entry : this.IMPUESTOSIVA.entrySet())
/*      */     {
/* 6094 */       ImpuestosIva impuestosIva = entry.getValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6107 */     for (Map.Entry<String, ImpuestosRet> entry : this.IMPUESTOSRET.entrySet())
/*      */     {
/* 6109 */       ImpuestosRet impuestosRet = entry.getValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6123 */     for (Map.Entry<String, Facturas> entry : this.FACTURAS.entrySet()) {
/* 6124 */       String key = entry.getKey();
/* 6125 */       Facturas facturas = entry.getValue();
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
/*      */   public void actualizaImpuestos() {
/* 6147 */     if (this.jDialog10.getTitle().equals("Agregar Factura")) {
/* 6148 */       double abono = 0.0D;
/*      */       try {
/* 6150 */         abono = Double.parseDouble(this.jFormattedTextField6.getText());
/* 6151 */       } catch (NumberFormatException n) {
/* 6152 */         abono = Double.parseDouble(String.valueOf(this.jFormattedTextField6.getValue()));
/*      */       } 
/*      */       
/* 6155 */       double facIva = 0.0D;
/* 6156 */       double facRet = 0.0D;
/*      */       
/* 6158 */       double ret = 0.0D;
/* 6159 */       double iva = 0.0D;
/* 6160 */       if (!this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 8).toString().equals("$0.00")) {
/* 6161 */         facIva = 0.16D;
/*      */       }
/*      */       
/* 6164 */       if (!this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 9).toString().equals("$0.00")) {
/* 6165 */         facRet = 0.04D;
/*      */       }
/* 6167 */       double resul = 1.0D + facIva - facRet;
/* 6168 */       double subtotal = abono / resul;
/*      */       
/* 6170 */       this.jTextField2.setText(this.utilerias.convertirDoublePesos(subtotal * facIva));
/* 6171 */       this.jTextField3.setText(this.utilerias.convertirDoublePesos(subtotal * facRet));
/* 6172 */       this.jTextField4.setText(this.utilerias.convertirDoublePesos(subtotal));
/*      */ 
/*      */ 
/*      */       
/* 6176 */       double pagado = this.utilerias.convertirCantTexto(this.jFormattedTextField6.getText());
/* 6177 */       double fluc = validarFluctuacion(pagado, this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 6).toString(), this.jFormattedTextField1.getText());
/* 6178 */       this.jTextField6.setText(this.utilerias.convertirDoublePesos4Decimales(fluc));
/*      */     }
/* 6180 */     else if (this.jDialog10.getTitle().equals("Modificar Abono")) {
/* 6181 */       double abono = 0.0D;
/*      */       try {
/* 6183 */         abono = Double.parseDouble(this.jFormattedTextField6.getText());
/* 6184 */       } catch (NumberFormatException n) {
/* 6185 */         abono = Double.parseDouble(String.valueOf(this.jFormattedTextField6.getValue()));
/*      */       } 
/*      */       
/* 6188 */       double facIva = 0.0D;
/* 6189 */       double facRet = 0.0D;
/*      */       
/* 6191 */       double ret = 0.0D;
/* 6192 */       double iva = 0.0D;
/*      */       
/* 6194 */       if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 6).toString().equals("0.16 / $0.00")) {
/* 6195 */         facIva = 0.16D;
/*      */       }
/*      */       
/* 6198 */       if (!this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 7).toString().equals("0.04 / $0.00")) {
/* 6199 */         facRet = 0.04D;
/*      */       }
/* 6201 */       double resul = 1.0D + facIva - facRet;
/* 6202 */       double subtotal = abono / resul;
/*      */       
/* 6204 */       this.jTextField2.setText(this.utilerias.convertirDoublePesos(subtotal * facIva));
/* 6205 */       this.jTextField3.setText(this.utilerias.convertirDoublePesos(subtotal * facRet));
/* 6206 */       this.jTextField4.setText(this.utilerias.convertirDoublePesos(subtotal));
/*      */       
/* 6208 */       double pagado = this.utilerias.convertirCantTexto(this.jFormattedTextField6.getText());
/* 6209 */       double fluc = validarFluctuacion(pagado, this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 8).toString(), this.jFormattedTextField1.getText());
/* 6210 */       this.jTextField6.setText(this.utilerias.convertirDoublePesos4Decimales(fluc));
/*      */     } 
/*      */   }
/*      */   
/*      */   public int añoActual() {
/* 6215 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 6216 */     Instant instant = (new Date()).toInstant();
/* 6217 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 6218 */     return fechaTrans.getYear();
/*      */   }
/*      */   
/*      */   public int mesActual() {
/* 6222 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 6223 */     Instant instant = (new Date()).toInstant();
/* 6224 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 6225 */     return fechaTrans.getMonthValue();
/*      */   }
/*      */   
/*      */   public String iniciales(String usuario) {
/* 6229 */     String iniciales = "";
/* 6230 */     String[] nombres = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + usuario + "'", 3);
/* 6231 */     iniciales = "" + nombres[0].charAt(0) + " " + nombres[0].charAt(0) + " " + nombres[1].charAt(0);
/* 6232 */     return iniciales;
/*      */   }
/*      */   
/*      */   public String dameCliente(String cliente) {
/* 6236 */     String[] reg = cliente.split(" ");
/* 6237 */     return reg[0] + " " + reg[0];
/*      */   }
/*      */   
/*      */   public String direccion() {
/* 6241 */     JFileChooser fileChooser = new JFileChooser();
/* 6242 */     fileChooser.setFileSelectionMode(1);
/* 6243 */     String fileName = "";
/* 6244 */     int retVal = fileChooser.showSaveDialog(null);
/* 6245 */     if (retVal == 0) {
/* 6246 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/* 6247 */       return fileName;
/*      */     } 
/* 6249 */     return "no";
/*      */   }
/*      */   
/*      */   public void convertir10() {
/* 6253 */     this.jTextField71.setText("P01");
/* 6254 */     this.jLabel71.setText("Anterior: ");
/* 6255 */     this.jLabel73.setText("Abono: ");
/* 6256 */     this.jLabel74.setText("Insoluto: ");
/*      */   }
/*      */   
/*      */   public void convertir20() {
/* 6260 */     this.rSTableMetro6.setFont(new Font("Dialog", 0, 11));
/* 6261 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", "Folio", "Folio Fiscal", "Saldo", "Abono", "Remanente", "Tras Base", "Ret Base", "Cambio", "Fluctuacion" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6267 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6272 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6276 */     if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 6277 */       this.rSTableMetro6.getColumnModel().getColumn(0).setResizable(false);
/* 6278 */       this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(25);
/* 6279 */       this.rSTableMetro6.getColumnModel().getColumn(1).setResizable(false);
/* 6280 */       this.rSTableMetro6.getColumnModel().getColumn(1).setPreferredWidth(40);
/* 6281 */       this.rSTableMetro6.getColumnModel().getColumn(2).setResizable(false);
/* 6282 */       this.rSTableMetro6.getColumnModel().getColumn(2).setPreferredWidth(250);
/* 6283 */       this.rSTableMetro6.getColumnModel().getColumn(3).setResizable(false);
/* 6284 */       this.rSTableMetro6.getColumnModel().getColumn(4).setResizable(false);
/* 6285 */       this.rSTableMetro6.getColumnModel().getColumn(5).setResizable(false);
/* 6286 */       this.rSTableMetro6.getColumnModel().getColumn(6).setResizable(false);
/* 6287 */       this.rSTableMetro6.getColumnModel().getColumn(7).setResizable(false);
/*      */     } 
/*      */     
/* 6290 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 6291 */     this.rSTableMetro6.setSelectionMode(0);
/* 6292 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 6293 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 6294 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda7);
/* 6295 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda7);
/* 6296 */     this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda7);
/* 6297 */     this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda7);
/* 6298 */     this.rSTableMetro6.getColumnModel().getColumn(4).setCellRenderer(this.celda7);
/* 6299 */     this.rSTableMetro6.getColumnModel().getColumn(5).setCellRenderer(this.celda7);
/* 6300 */     this.rSTableMetro6.getColumnModel().getColumn(6).setCellRenderer(this.celda7);
/* 6301 */     this.rSTableMetro6.getColumnModel().getColumn(7).setCellRenderer(this.celda7);
/* 6302 */     this.rSTableMetro6.getColumnModel().getColumn(8).setCellRenderer(this.celda7);
/* 6303 */     this.rSTableMetro6.getColumnModel().getColumn(9).setCellRenderer(this.celda7);
/* 6304 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/*      */     
/* 6306 */     this.jTextField71.setText("CP01");
/* 6307 */     this.jLabel36.setText("Subtotal: ");
/* 6308 */     this.jLabel71.setText("Iva: ");
/* 6309 */     this.jLabel73.setText("Retenciones: ");
/* 6310 */     this.jLabel74.setText("Saldos: ");
/*      */   }
/*      */ 
/*      */   
/*      */   public void crearComprobante(String nombre) throws IOException {
/* 6315 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "30", "99" };
/* 6316 */     String folio = this.jTextField5.getText();
/* 6317 */     String conse = "";
/* 6318 */     String letra = "";
/* 6319 */     for (int i = 0; i < folio.length(); i++) {
/*      */       try {
/* 6321 */         int valor = Integer.parseInt("" + folio.charAt(i));
/* 6322 */         conse = conse + conse;
/* 6323 */       } catch (NumberFormatException e) {
/* 6324 */         letra = letra + letra;
/*      */       } 
/*      */     } 
/*      */     
/* 6328 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.RUTAENTRADA + "/" + this.RUTAENTRADA + ".yaml"), "utf-8"));
/* 6329 */     out.write("\n");
/* 6330 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/* 6331 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/* 6332 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/* 6333 */     out.write("\n");
/* 6334 */     out.write("--- !diverza.com/v2.0\n\n");
/* 6335 */     out.write("#DATOS GENERALES\n");
/* 6336 */     out.write("Comprobante:\n\n");
/* 6337 */     out.write("  NombreCfdi: \"" + this.jTextField5.getText() + "\"\n");
/* 6338 */     out.write("  RefId: \"" + this.jTextField5.getText() + "\"\n");
/* 6339 */     out.write("  Version: \"3.3\"\n");
/* 6340 */     out.write("  Serie: \"" + letra + "\"\n");
/* 6341 */     out.write("  Folio: \"" + conse + "\"\n");
/*      */     
/* 6343 */     String fecha = "";
/* 6344 */     if (this.jDialog1.getTitle().equals("Crear Nuevo")) {
/* 6345 */       DateFormat hr = new SimpleDateFormat("HH:mm:ss");
/* 6346 */       fecha = this.FECHAGRAL + " " + this.FECHAGRAL;
/*      */     } else {
/* 6348 */       fecha = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4).toString();
/*      */     } 
/* 6350 */     String año = fecha.substring(0, 4);
/* 6351 */     String mes = fecha.substring(5, 7);
/* 6352 */     String dia = fecha.substring(8, 10);
/* 6353 */     String hh = fecha.substring(11, 13);
/* 6354 */     String mm = fecha.substring(14, 16);
/* 6355 */     String ss = fecha.substring(17, 19);
/* 6356 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/* 6357 */     out.write("  Sello: \"\"\n");
/* 6358 */     out.write("  NoCertificado: \"" + this.DATOS[4] + "\"\n");
/* 6359 */     out.write("  SubTotal: \"0\"\n");
/* 6360 */     out.write("  Moneda: \"XXX\"\n");
/* 6361 */     out.write("  Total: \"0\"\n");
/* 6362 */     out.write("  TipoDeComprobante: \"P\"\n");
/* 6363 */     out.write("  LugarExpedicion: \"" + this.DATOS[3] + "\"\n\n");
/*      */     
/* 6365 */     out.write("  Emisor:\n");
/* 6366 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/* 6367 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS, S.A. DE C.V.\"\n");
/* 6368 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*      */     
/* 6370 */     out.write("  Receptor: \n");
/* 6371 */     out.write("    Rfc: \"" + this.jTextField14.getText() + "\"\n");
/* 6372 */     out.write("    Nombre: \"" + String.valueOf(this.jComboBox4.getSelectedItem()) + "\"\n");
/* 6373 */     out.write("    UsoCFDI: \"P01\"\n\n");
/*      */     
/* 6375 */     out.write("  Conceptos: \n");
/* 6376 */     out.write("    -\n");
/* 6377 */     out.write("      Concepto: \n");
/* 6378 */     out.write("      ClaveProdServ: \"84111506\"\n");
/* 6379 */     out.write("      Cantidad: \"1\"\n");
/* 6380 */     out.write("      ClaveUnidad: \"ACT\"\n");
/* 6381 */     out.write("      Descripcion: \"Pago\"\n");
/* 6382 */     out.write("      ValorUnitario: \"0\"\n");
/* 6383 */     out.write("      Importe: \"0\"\n");
/* 6384 */     out.write("\n");
/*      */     
/* 6386 */     out.write("  Complemento: \n");
/* 6387 */     out.write("    Pagos:\n");
/* 6388 */     out.write("      Version: \"1.0\"\n");
/* 6389 */     out.write("      Pago:\n");
/* 6390 */     out.write("        -\n");
/*      */     
/* 6392 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 6393 */     String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 6394 */     año = cadenaFecha1.substring(0, 4);
/* 6395 */     mes = cadenaFecha1.substring(4, 6);
/* 6396 */     dia = cadenaFecha1.substring(6, 8);
/* 6397 */     String fechaDeposito = año + "-" + año + "-" + mes + "T" + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/* 6398 */     out.write("          FechaPago: \"" + fechaDeposito + "\"\n");
/* 6399 */     out.write("          FormaDePagoP: \"" + metodos[this.jComboBox18.getSelectedIndex()] + "\"\n");
/* 6400 */     out.write("          MonedaP: \"" + this.jTextField85.getText() + "\"\n");
/* 6401 */     if (!this.jTextField85.getText().equals("MXN")) {
/* 6402 */       out.write("          TipoCambioP: \"" + this.jFormattedTextField1.getText() + "\"\n");
/*      */     }
/* 6404 */     out.write("          Monto: \"" + convertirCantTexto(this.jFormattedTextField4.getText()) + "\"\n");
/* 6405 */     out.write("          NumOperacion: \"" + this.jTextField26.getText().toUpperCase() + "\"\n");
/* 6406 */     out.write("          RfcEmisorCtaOrd: \"" + this.jTextField27.getText().toUpperCase() + "\"\n");
/* 6407 */     out.write("          NomBancoOrdExt: \"" + this.jTextField28.getText().toUpperCase() + "\"\n");
/* 6408 */     out.write("          CtaOrdenante: \"" + this.jTextField29.getText().toUpperCase() + "\"\n");
/* 6409 */     out.write("          RfcEmisorCtaBen: \"" + this.jTextField30.getText().toUpperCase() + "\"\n");
/* 6410 */     out.write("          CtaBeneficiario: \"" + this.jTextField31.getText().toUpperCase() + "\"\n");
/* 6411 */     out.write("          TipoCadPago: \"" + this.jTextField16.getText().toUpperCase() + "\"\n");
/* 6412 */     out.write("          CertPago: \"" + this.jTextField17.getText().toUpperCase() + "\"\n");
/* 6413 */     out.write("          SelloPago: \"" + this.jTextField18.getText().toUpperCase() + "\"\n");
/*      */     
/* 6415 */     out.write("\n");
/* 6416 */     out.write("          DoctoRelacionado: \n"); int j;
/* 6417 */     for (j = 0; j < this.rSTableMetro6.getRowCount(); j++) {
/* 6418 */       out.write("            -\n");
/* 6419 */       out.write("              IdDocumento: \"" + String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + "\"\n");
/* 6420 */       String folio1 = this.rSTableMetro6.getValueAt(j, 1).toString();
/* 6421 */       String conse1 = "";
/* 6422 */       String letra1 = "";
/* 6423 */       for (int k = 0; k < folio1.length(); k++) {
/*      */         try {
/* 6425 */           int valor1 = Integer.parseInt("" + folio1.charAt(k));
/* 6426 */           conse1 = conse1 + conse1;
/* 6427 */         } catch (NumberFormatException e) {
/* 6428 */           letra1 = letra1 + letra1;
/*      */         } 
/*      */       } 
/* 6431 */       out.write("              Serie: \"" + letra1 + "\"\n");
/* 6432 */       out.write("              Folio: \"" + conse1 + "\"\n");
/* 6433 */       String folioFact = String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(j, 0));
/* 6434 */       String[] datos = this.con.regresaReg("moneda, pagoMetodo, tipoCambio", "facturas33", "where folio='" + folioFact + "'", 3);
/* 6435 */       out.write("              MonedaDR: \"" + datos[0] + "\"\n");
/* 6436 */       if (!datos[0].equals("MXN")) {
/* 6437 */         out.write("              TipoCambioDR: \"" + datos[2] + "\"\n");
/*      */       }
/* 6439 */       out.write("              MetodoDePagoDR: \"" + datos[1].substring(0, 3) + "\"\n");
/* 6440 */       out.write("              NumParcialidad: \"" + String.valueOf(this.rSTableMetro6.getValueAt(j, 2)) + "\"\n");
/* 6441 */       out.write("              ImpSaldoAnt: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 4).toString()) + "\"\n");
/* 6442 */       out.write("              ImpPagado: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 5).toString()) + "\"\n");
/* 6443 */       out.write("              ImpSaldoInsoluto: \"" + convertirCantTexto(this.rSTableMetro6.getValueAt(j, 6).toString()) + "\"\n");
/* 6444 */       out.write("\n");
/*      */     } 
/*      */     
/* 6447 */     out.write("\n");
/* 6448 */     out.write("  Addenda: \n");
/* 6449 */     out.write("    Diverza: \n");
/* 6450 */     out.write("      Version: \"1.1\"\n\n");
/* 6451 */     out.write("      Generales: \n");
/*      */     
/* 6453 */     out.write("      DatosContactoE: \n");
/* 6454 */     if (this.DATOS[2].equals("POZA RICA")) {
/* 6455 */       out.write("        Telefono: \"01 782 825 6455 al 01 782 825 6458\"\n");
/* 6456 */     } else if (this.DATOS[2].equals("VERACRUZ")) {
/* 6457 */       out.write("        Telefono: \"01 (229) 924-8600 al 03\"\n");
/* 6458 */     } else if (this.DATOS[2].equals("CARDENAS")) {
/* 6459 */       out.write("        Telefono: \"(01 937) 372 7301 al 10\"\n");
/* 6460 */     } else if (this.DATOS[2].equals("CADEREYTA")) {
/* 6461 */       out.write("        Telefono: \"828 284 4444\"\n");
/*      */     } 
/* 6463 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*      */     
/* 6465 */     out.write("      Emisor: \n");
/* 6466 */     out.write("        DomicilioFiscalE: \n");
/* 6467 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/* 6468 */     out.write("          Numero: \"KM 32.5\"\n");
/* 6469 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/* 6470 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/* 6471 */     out.write("          Estado: \"NUEVO LEON\"\n");
/* 6472 */     out.write("          Pais: \"MEXICO\"\n");
/* 6473 */     out.write("          CodigoPostal: \"67483\"\n");
/*      */     
/* 6475 */     if (this.DATOS[2].equals("POZA RICA")) {
/* 6476 */       out.write("        SucursalE: \n");
/* 6477 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6478 */       out.write("          DomicilioSucursal: \n");
/* 6479 */       out.write("            Calle: \"CARRETERA POZA RICA A TIHUATLAN KM 8.5 \"\n");
/* 6480 */       out.write("            Ciudad: \"TIHUATLAN\"\n");
/* 6481 */       out.write("            Estado: \"VERACRUZ\"\n");
/* 6482 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6483 */       out.write("            CodigoPostal: \"92900\"\n\n");
/* 6484 */     } else if (this.DATOS[2].equals("VERACRUZ")) {
/* 6485 */       out.write("        SucursalE: \n");
/* 6486 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6487 */       out.write("          DomicilioSucursal: \n");
/* 6488 */       out.write("            Calle: \"CARRETERA A CARDEL (NUEVA ERA) KM 5\"\n");
/* 6489 */       out.write("            Ciudad: \"VERACRUZ\"\n");
/* 6490 */       out.write("            Estado: \"VERACRUZ\"\n");
/* 6491 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6492 */       out.write("            CodigoPostal: \"91809\"\n\n");
/* 6493 */     } else if (this.DATOS[2].equals("CARDENAS")) {
/* 6494 */       out.write("        SucursalE: \n");
/* 6495 */       out.write("          Alias: \"" + this.DATOS[2] + "\"\n");
/* 6496 */       out.write("          DomicilioSucursal: \n");
/* 6497 */       out.write("            Calle: \"CARRETERA VILLAHERMOSA-CARDENAS KM 125+500\"\n");
/* 6498 */       out.write("            Ciudad: \"H. CARDENAS\"\n");
/* 6499 */       out.write("            Estado: \"TABASCO\"\n");
/* 6500 */       out.write("            Pais: \"MÉXICO\"\n");
/* 6501 */       out.write("            CodigoPostal: \"86470\"\n\n");
/*      */     } 
/*      */     
/* 6504 */     out.write("      Receptor: \n");
/* 6505 */     out.write("        DomicilioFiscalR: \n");
/*      */     
/* 6507 */     out.write("          Calle: \"" + String.valueOf(this.CALLE.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6508 */     out.write("          Numero: \"" + String.valueOf(this.NUMEROS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6509 */     out.write("          Colonia: \"" + String.valueOf(this.COLONIAS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6510 */     out.write("          Ciudad: \"" + String.valueOf(this.CIUDADES.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6511 */     out.write("          Estado: \"" + String.valueOf(this.ESTADOS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/* 6512 */     out.write("          CodigoPostal: \"" + String.valueOf(this.CODIGOS.get(this.jComboBox4.getSelectedItem())) + "\"\n");
/*      */     
/* 6514 */     out.write("\n");
/* 6515 */     out.write("  LeyendasImpresion: \n");
/* 6516 */     out.write("    -\n");
/* 6517 */     for (j = 0; j < this.rSTableMetro5.getRowCount(); j++) {
/* 6518 */       out.write("      Atributo: \"" + String.valueOf(this.rSTableMetro5.getValueAt(j, 0)) + "\"\n");
/* 6519 */       out.write("      Valor: \"" + String.valueOf(this.rSTableMetro5.getValueAt(j, 1)) + "\"\n");
/*      */     } 
/* 6521 */     out.write("---");
/* 6522 */     out.close();
/*      */   }
/*      */   
/*      */   public void imprimirComprobante() {
/*      */     try {
/* 6527 */       Map<Object, Object> datos = new HashMap<>();
/* 6528 */       String forsis = "/Reportes/Imagenes/forsis100x.jpg";
/* 6529 */       datos.put("sucursal", this.DATOS[3] + "-" + this.DATOS[3]);
/* 6530 */       datos.put("folio", this.jTextField5.getText());
/*      */       
/* 6532 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 6533 */       String cadenaFecha2 = formato.format(this.jDateChooser8.getDate());
/* 6534 */       String año = cadenaFecha2.substring(0, 4);
/* 6535 */       String mes = cadenaFecha2.substring(4, 6);
/* 6536 */       String dia = cadenaFecha2.substring(6, 8);
/* 6537 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 6539 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 6540 */       String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 6541 */       año = cadenaFecha1.substring(0, 4);
/* 6542 */       mes = cadenaFecha1.substring(4, 6);
/* 6543 */       dia = cadenaFecha1.substring(6, 8);
/* 6544 */       String fechaDeposito = año + "-" + año + "-" + mes + " " + dia + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/*      */       
/* 6546 */       datos.put("fecha", fechaCompleta);
/* 6547 */       datos.put("documento", iniciales(this.USUARIO).toUpperCase());
/*      */       
/* 6549 */       datos.put("cliente", this.jComboBox4.getSelectedItem());
/* 6550 */       datos.put("rfc", this.jTextField14.getText());
/* 6551 */       datos.put("domicilio", this.jTextArea1.getText().toUpperCase());
/* 6552 */       datos.put("usoCFDI", "P01 - POR DEFINIR");
/*      */       
/* 6554 */       datos.put("Cantidad", this.jFormattedTextField4.getText());
/* 6555 */       datos.put("fechaDeposito", fechaDeposito);
/* 6556 */       datos.put("FormaPago", this.jComboBox18.getSelectedItem());
/* 6557 */       datos.put("Moneda", this.jTextField85.getText());
/* 6558 */       datos.put("TipoCambio", this.jFormattedTextField1.getText());
/*      */       
/* 6560 */       datos.put("BancoOrdenante", this.jTextField28.getText().toUpperCase());
/* 6561 */       datos.put("RFCOrdenante", this.jTextField27.getText().toUpperCase());
/* 6562 */       datos.put("CuentaOrdenante", this.jTextField29.getText().toUpperCase());
/*      */       
/* 6564 */       datos.put("BancoReceptor", this.jTextField32.getText().toUpperCase());
/* 6565 */       datos.put("RFCReceptor", this.jTextField30.getText().toUpperCase());
/* 6566 */       datos.put("CuentaReceptor", this.jTextField31.getText().toUpperCase());
/*      */       
/* 6568 */       datos.put("Operacion", this.jTextField26.getText().toUpperCase());
/* 6569 */       datos.put("Cadena", this.jTextField15.getText().toUpperCase());
/* 6570 */       datos.put("Tipo", this.jTextField16.getText().toUpperCase());
/* 6571 */       datos.put("Certificado", this.jTextField17.getText().toUpperCase());
/* 6572 */       datos.put("Sello", this.jTextField18.getText().toUpperCase());
/*      */       
/* 6574 */       datos.put("Subtotal", this.jLabel37.getText());
/* 6575 */       datos.put("Iva", this.jLabel38.getText());
/* 6576 */       datos.put("Retenido", this.jLabel40.getText());
/*      */       
/* 6578 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/*      */       
/* 6580 */       JTable aux = crearTablaAuxCotizacion((JTable)this.rSTableMetro6, (JTable)this.rSTableMetro5, new Object[] { "num", "folio", "uuid", "parcialidad", "saldoOriginal", "saldoAnterior", "importePagado", "saldo" });
/* 6581 */       JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 6582 */       JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/ComplementoPago.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 6583 */       this.jDialog1.setVisible(false);
/* 6584 */       JasperViewer visor = new JasperViewer(print, false);
/* 6585 */       visor.setTitle("Complemento de pago " + this.jTextField5.getText().toUpperCase());
/* 6586 */       visor.setIconImage(this.iconoImprimir);
/* 6587 */       visor.setZoomRatio(0.59F);
/* 6588 */       visor.setExtendedState(6);
/* 6589 */       visor.setVisible(true);
/* 6590 */     } catch (JRException e) {
/* 6591 */       System.out.println(e.getMessage());
/*      */       
/* 6593 */       Logger.getLogger(complementoPagos.class
/* 6594 */           .getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public JTable crearTablaAuxCotizacion(JTable Original, JTable leyendas, Object[] columnas) {
/* 6599 */     int AumentarLineas = 3;
/* 6600 */     Object[] Columnas = columnas;
/* 6601 */     Object[][] registros = new Object[Original.getRowCount() + leyendas.getRowCount() + AumentarLineas][columnas.length];
/* 6602 */     for (int i = 0; i < registros.length; i++) {
/* 6603 */       for (int k = 0; k < (registros[i]).length; k++) {
/* 6604 */         registros[i][k] = "";
/*      */       }
/*      */     } 
/* 6607 */     int cont = 0; int j;
/* 6608 */     for (j = 0; j < Original.getRowCount(); j++) {
/*      */       
/* 6610 */       registros[j][0] = "" + j + 1 + " ";
/* 6611 */       registros[j][1] = Original.getValueAt(j, 1).toString();
/* 6612 */       registros[j][2] = Original.getValueAt(j, 2).toString();
/* 6613 */       registros[j][3] = Original.getValueAt(j, 3).toString();
/* 6614 */       registros[j][4] = Original.getValueAt(j, 4).toString();
/* 6615 */       registros[j][5] = Original.getValueAt(j, 5).toString();
/* 6616 */       registros[j][6] = Original.getValueAt(j, 6).toString();
/* 6617 */       registros[j][7] = Original.getValueAt(j, 7).toString();
/* 6618 */       cont++;
/*      */     } 
/*      */     
/* 6621 */     for (j = 0; j < AumentarLineas - 2; j++) {
/* 6622 */       cont++;
/*      */     }
/*      */     
/* 6625 */     if (leyendas.getRowCount() > 0) {
/* 6626 */       registros[cont][0] = "COMENTARIOS ADICIONALES:";
/* 6627 */       cont++;
/* 6628 */       cont++;
/*      */       
/* 6630 */       for (j = 0; j < leyendas.getRowCount(); j++) {
/* 6631 */         registros[cont][0] = "" + j + 1 + ".- " + j + 1;
/* 6632 */         cont++;
/*      */       } 
/*      */     } 
/* 6635 */     JTable aux = new JTable(registros, Columnas);
/* 6636 */     return aux;
/*      */   }
/*      */   
/*      */   public void imprimirCantidadLetra() {
/* 6640 */     double v = convertirCantTexto(this.jFormattedTextField4.getText());
/* 6641 */     this.numLetra = new NumerosALetras(v, this.jTextField85.getText());
/* 6642 */     this.jLabel69.setText(this.numLetra.regresaNumero());
/*      */   }
/*      */   
/*      */   public void validarFactura() {
/* 6646 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 6647 */     if (ind < 0) {
/* 6648 */       JOptionPane.showMessageDialog(this.jDialog9, "Necesitas seleccionar un factura para agregar los datos", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 6650 */       this.jFormattedTextField6.setEnabled(true);
/* 6651 */       Object folio = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 2);
/* 6652 */       if (this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0).toString().equals("")) {
/* 6653 */         JOptionPane.showMessageDialog(this.jDialog9, "La factura que seleccionaste no está completada con el folio Fiscal.\nNecesitas ingresar el folio", "Falta el folio fiscal", 0, this.ADVER);
/*      */         return;
/*      */       } 
/* 6656 */       String clienteFactura = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 3).toString();
/* 6657 */       String clienteSelec = this.jComboBox4.getSelectedItem().toString();
/* 6658 */       boolean seguir = false;
/* 6659 */       if (!clienteFactura.equals(clienteSelec)) {
/* 6660 */         int res = JOptionPane.showConfirmDialog(this.jDialog9, "La factura que seleccionaste corresponde a otro cliente\n¿Deseas seguir y abonar la factura seleccionada?", "Clientes diferentes", 0, 3, this.ADVER);
/* 6661 */         if (res == 0) {
/* 6662 */           seguir = true;
/*      */         }
/*      */       } else {
/* 6665 */         seguir = true;
/*      */       } 
/* 6667 */       if (seguir) {
/* 6668 */         if (this.VERSION == 1) {
/* 6669 */           for (int i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 6670 */             Object reg = this.rSTableMetro6.getValueAt(i, 2);
/* 6671 */             if (reg.equals(folio)) {
/* 6672 */               JOptionPane.showMessageDialog(this.jDialog10, "La factura que deseas agregar ya se encuentra registrada.", "Factura duplicada", 0, this.ADVER);
/*      */               return;
/*      */             } 
/*      */           } 
/* 6676 */         } else if (this.VERSION == 2) {
/* 6677 */           for (int i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 6678 */             Object reg = this.rSTableMetro6.getValueAt(i, 2);
/* 6679 */             if (reg.equals(folio)) {
/* 6680 */               JOptionPane.showMessageDialog(this.jDialog10, "La factura que deseas agregar ya se encuentra registrada.", "Factura duplicada", 0, this.ADVER);
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/* 6686 */         String valor = "";
/* 6687 */         if (this.VERSION == 1) {
/* 6688 */           valor = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 4).toString();
/* 6689 */           this.jTextField2.setText("N/A");
/* 6690 */           this.jTextField3.setText("N/A");
/* 6691 */           this.jTextField4.setText("N/A");
/* 6692 */         } else if (this.VERSION == 2) {
/* 6693 */           valor = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 11).toString();
/*      */           
/* 6695 */           double facIva = 0.0D;
/* 6696 */           double facRet = 0.0D;
/*      */           
/* 6698 */           double ret = 0.0D;
/* 6699 */           double iva = 0.0D;
/* 6700 */           if (!this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 8).toString().equals("$0.00")) {
/* 6701 */             facIva = 0.16D;
/*      */           }
/*      */           
/* 6704 */           if (!this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 9).toString().equals("$0.00")) {
/* 6705 */             facRet = 0.04D;
/*      */           }
/* 6707 */           double resul = 1.0D + facIva - facRet;
/* 6708 */           double subtotal = this.utilerias.convertirCantTexto(valor) / resul;
/*      */           
/* 6710 */           this.jTextField2.setText(this.utilerias.convertirDoublePesos(subtotal * facIva));
/* 6711 */           this.jTextField3.setText(this.utilerias.convertirDoublePesos(subtotal * facRet));
/* 6712 */           this.jTextField4.setText(this.utilerias.convertirDoublePesos(subtotal));
/*      */         } 
/* 6714 */         double CANTIDAD = convertirCantTexto(valor);
/* 6715 */         this.jFormattedTextField6.setValue(Double.valueOf(CANTIDAD));
/* 6716 */         double fluc = validarFluctuacion(CANTIDAD, this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 6).toString(), this.jFormattedTextField1.getText());
/* 6717 */         this.jTextField6.setText(this.utilerias.convertirDoublePesos4Decimales(fluc));
/* 6718 */         this.jDialog10.setTitle("Agregar Factura");
/* 6719 */         this.jDialog10.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public double validarFluctuacion(double total, String dolarPasado, String dolarPagado) {
/* 6725 */     double MXNPasado = total * this.utilerias.convertirCantTexto(dolarPasado);
/* 6726 */     double MXNPagado = total * this.utilerias.convertirCantTexto(dolarPagado);
/* 6727 */     double fluc = MXNPagado - MXNPasado;
/* 6728 */     return fluc;
/*      */   }
/*      */   
/*      */   public void pasarFactura() {
/* 6732 */     double cAbono = convertirCantTexto(this.jFormattedTextField6.getText());
/* 6733 */     if (cAbono < 1.0D) {
/* 6734 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes agregar valores menores a $1.00, verifica tu información", "Cantidad incorrecta", 0, this.ERROR);
/*      */       return;
/*      */     } 
/* 6737 */     if (this.jDialog10.getTitle().equals("Agregar Factura")) {
/* 6738 */       if (this.VERSION == 1) {
/* 6739 */         double cAnterior = convertirCantTexto(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 5).toString());
/* 6740 */         double insoluto = cAnterior - cAbono;
/* 6741 */         this.cantidad.setValue(Double.valueOf(insoluto));
/* 6742 */         String TextoInsoluto = this.cantidad.getText();
/* 6743 */         this.cantidad.setValue(Double.valueOf(cAbono));
/* 6744 */         int parte = Integer.parseInt(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 3).toString());
/* 6745 */         parte++;
/*      */         
/* 6747 */         DefaultTableModel nueva = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 6748 */         Object[] nuevo = { this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0), this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 1), Integer.valueOf(parte), this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 4), this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 5), this.cantidad.getText(), TextoInsoluto };
/* 6749 */         nueva.addRow(nuevo);
/*      */       }
/* 6751 */       else if (this.VERSION == 2) {
/* 6752 */         double cAnterior = convertirCantTexto(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 11).toString());
/* 6753 */         double insoluto = cAnterior - cAbono;
/* 6754 */         this.cantidad.setValue(Double.valueOf(insoluto));
/* 6755 */         String TextoInsoluto = this.cantidad.getText();
/* 6756 */         this.cantidad.setValue(Double.valueOf(cAbono));
/* 6757 */         int parte = Integer.parseInt(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 4).toString());
/* 6758 */         parte++;
/* 6759 */         String ponerRet = "";
/* 6760 */         String ponerIva = "";
/*      */         
/* 6762 */         ponerIva = ponerIva();
/* 6763 */         ponerRet = ponerRetencion();
/*      */         
/* 6765 */         String[] folioCompleto = separarFolio(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0).toString());
/* 6766 */         DefaultTableModel nueva = (DefaultTableModel)this.rSTableMetro6.getModel();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6777 */         Object[] nuevo = { folioCompleto[0], folioCompleto[1], this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 2), this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 11), this.cantidad.getText(), TextoInsoluto, ponerIva, ponerRet, this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 6), this.jTextField6.getText() };
/*      */         
/* 6779 */         nueva.addRow(nuevo);
/* 6780 */         agregarFacturaRelacion(folioCompleto, TextoInsoluto);
/*      */         
/* 6782 */         String item = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0).toString();
/* 6783 */         String[] datos = { item, "IVA", "0.16", ponerIva, this.jTextField5.getText(), item };
/*      */         
/* 6785 */         agregarImpuesto("IVA", "0.16", this.jTextField2.getText(), datos, "NUEVO");
/* 6786 */         agregarImpuesto("RET", "0.04", this.jTextField3.getText(), datos, "NUEVO");
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 6791 */     else if (this.VERSION == 1) {
/* 6792 */       double cAnterior = convertirCantTexto(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4).toString());
/* 6793 */       double insoluto = cAnterior - cAbono;
/* 6794 */       this.cantidad.setValue(Double.valueOf(insoluto));
/* 6795 */       String TextoInsoluto = this.cantidad.getText();
/* 6796 */       this.cantidad.setValue(Double.valueOf(cAbono));
/* 6797 */       this.rSTableMetro6.setValueAt(this.cantidad.getText(), this.rSTableMetro6.getSelectedRow(), 5);
/* 6798 */       this.rSTableMetro6.setValueAt(TextoInsoluto, this.rSTableMetro6.getSelectedRow(), 6);
/* 6799 */     } else if (this.VERSION == 2) {
/* 6800 */       int selec = this.rSTableMetro6.getSelectedRow();
/* 6801 */       this.cantidad.setValue(Double.valueOf(cAbono));
/*      */       
/* 6803 */       String folio = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0)) + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0));
/*      */ 
/*      */       
/* 6806 */       double rema = this.utilerias.convertirCantTexto(((Facturas)this.FACTURAS.get(folio)).getSaldo()) - this.utilerias.convertirCantTexto(this.jFormattedTextField6.getText());
/*      */       
/* 6808 */       ((Facturas)this.FACTURAS.get(folio)).setAbono(this.cantidad.getText());
/* 6809 */       ((Facturas)this.FACTURAS.get(folio)).setRemanente(this.utilerias.convertirDoublePesos(rema));
/* 6810 */       ((Facturas)this.FACTURAS.get(folio)).setSubTotal(this.jTextField4.getText());
/*      */       
/* 6812 */       ((Facturas)this.FACTURAS.get(folio)).setAbono(this.cantidad.getText());
/* 6813 */       ((Facturas)this.FACTURAS.get(folio)).setRemanente(this.utilerias.convertirDoublePesos(rema));
/* 6814 */       ((Facturas)this.FACTURAS.get(folio)).setTrasBase("0.16 / " + this.jTextField2.getText());
/* 6815 */       ((Facturas)this.FACTURAS.get(folio)).setRetBase("0.04 / " + this.jTextField3.getText());
/* 6816 */       if (!this.jTextField2.getText().equals("$0.00")) {
/* 6817 */         ((Facturas)this.FACTURAS.get(folio)).setTotalTrasBase(this.jTextField4.getText());
/*      */       } else {
/* 6819 */         ((Facturas)this.FACTURAS.get(folio)).setTotalTrasBase("$0.00");
/*      */       } 
/*      */       
/* 6822 */       ((ImpuestosIva)this.IMPUESTOSIVA.get(folio)).setImporte(this.jTextField2.getText());
/* 6823 */       ((ImpuestosRet)this.IMPUESTOSRET.get(folio)).setImporte(this.jTextField3.getText());
/* 6824 */       ((ImpuestosIva)this.IMPUESTOSIVA.get(folio)).setEstatus("NUEVO");
/* 6825 */       ((ImpuestosRet)this.IMPUESTOSRET.get(folio)).setEstatus("NUEVO");
/*      */       
/* 6827 */       this.rSTableMetro6.setValueAt(this.cantidad.getText(), selec, 4);
/* 6828 */       this.rSTableMetro6.setValueAt(this.utilerias.convertirDoublePesos(rema), selec, 5);
/* 6829 */       this.rSTableMetro6.setValueAt("0.16 / " + this.jTextField2.getText(), selec, 6);
/* 6830 */       this.rSTableMetro6.setValueAt("0.04 / " + this.jTextField3.getText(), selec, 7);
/*      */       
/* 6832 */       this.rSTableMetro6.setValueAt(this.jTextField6.getText(), selec, 9);
/*      */       
/* 6834 */       imprimirImpuestos();
/*      */     } 
/*      */     
/* 6837 */     sumarSaldos();
/* 6838 */     contarFacturas();
/* 6839 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void agregarImpuesto(String tipo, String valor, String textoValor, String[] datos, String estado) {
/* 6843 */     String[] dat = { datos[0], tipo, valor, textoValor, datos[4], datos[0], estado };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6852 */     agregarFacturaImpuestos(dat);
/*      */   }
/*      */   
/*      */   public void agregarFacturaImpuestos(String[] datosImp) {
/* 6856 */     if (datosImp[1].equals("IVA")) {
/* 6857 */       this.IMPUESTOSIVA.put(datosImp[0], new ImpuestosIva(datosImp[0], datosImp[1], datosImp[2], datosImp[3], datosImp[4], datosImp[5], datosImp[6]));
/* 6858 */     } else if (datosImp[1].equals("RET")) {
/* 6859 */       this.IMPUESTOSRET.put(datosImp[0], new ImpuestosRet(datosImp[0], datosImp[1], datosImp[2], datosImp[3], datosImp[4], datosImp[5], datosImp[6]));
/*      */     } 
/*      */   }
/*      */   
/*      */   public String ponerRetencion() {
/* 6864 */     int selec = this.rSTableMetro7.getSelectedRow();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6871 */     ImpuestosRet imp = new ImpuestosRet(this.jTextField5.getText() + "/" + this.jTextField5.getText(), "RETENCION", ".040000", this.jTextField3.getText(), this.jTextField5.getText(), this.rSTableMetro7.getValueAt(selec, 0).toString(), "NUEVO");
/*      */ 
/*      */ 
/*      */     
/* 6875 */     this.IMPUESTOSRET.put(this.rSTableMetro7.getValueAt(selec, 0).toString(), imp);
/* 6876 */     return "0.04 / " + this.jTextField3.getText();
/*      */   }
/*      */   
/*      */   public String ponerIva() {
/* 6880 */     int selec = this.rSTableMetro7.getSelectedRow();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6887 */     ImpuestosIva imp = new ImpuestosIva(this.jTextField5.getText() + "/" + this.jTextField5.getText(), "IVA", ".160000", this.jTextField2.getText(), this.jTextField5.getText(), this.rSTableMetro7.getValueAt(selec, 0).toString(), "NUEVO");
/*      */ 
/*      */     
/* 6890 */     this.IMPUESTOSIVA.put(this.rSTableMetro7.getValueAt(selec, 0).toString(), imp);
/* 6891 */     return "0.16 / " + this.jTextField2.getText();
/*      */   }
/*      */   
/*      */   public void agregarFacturaRelacion(String[] folioCompleto, String Insoluto) {
/* 6895 */     int selec = this.rSTableMetro7.getSelectedRow();
/*      */     
/* 6897 */     String ObjImp = FactEsObjImp();
/* 6898 */     int parte = Integer.parseInt(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 4).toString());
/* 6899 */     parte++;
/* 6900 */     String totalBase = "$0.00";
/* 6901 */     if (!this.jTextField2.getText().equals("$0.00")) {
/* 6902 */       totalBase = this.jTextField4.getText();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6942 */     Facturas f = new Facturas(this.rSTableMetro7.getValueAt(selec, 0).toString(), folioCompleto[0], folioCompleto[1], this.rSTableMetro7.getValueAt(selec, 2).toString(), this.rSTableMetro7.getValueAt(selec, 4).toString(), ObjImp, "" + parte, this.rSTableMetro7.getValueAt(selec, 11).toString(), this.cantidad.getText(), Insoluto, "Ret", "tras", this.jTextField4.getText(), this.rSTableMetro7.getValueAt(selec, 7).toString(), totalBase, this.rSTableMetro7.getValueAt(selec, 6).toString(), this.jTextField6.getText());
/*      */     
/* 6944 */     this.FACTURAS.put(this.rSTableMetro7.getValueAt(selec, 0).toString(), f);
/*      */   }
/*      */   
/*      */   public String FactEsObjImp() {
/* 6948 */     String obj = "";
/* 6949 */     String valor1 = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 8).toString();
/* 6950 */     String valor2 = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 9).toString();
/*      */     
/* 6952 */     if (valor1.equals("$0.00") && valor2.equals("$0.00")) {
/* 6953 */       obj = "01";
/*      */     } else {
/* 6955 */       obj = "02";
/*      */     } 
/*      */     
/* 6958 */     System.out.println("impues: " + obj + " " + valor1 + " " + valor2);
/*      */     
/* 6960 */     return obj;
/*      */   }
/*      */   
/*      */   public String[] dameImpuestos(String TextoInsoluto, int reg) {
/* 6964 */     boolean tieneRet = false;
/* 6965 */     boolean tieneIva = false;
/* 6966 */     String textoRetencion = "";
/* 6967 */     String textoIva = "";
/* 6968 */     String[] impuestos = { "", "" };
/*      */     
/* 6970 */     if (TextoInsoluto.equals("$0.00") && 
/* 6971 */       !this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 6).equals("$0.00")) {
/* 6972 */       impuestos[0] = "0.04% / " + this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 6).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6978 */     return impuestos;
/*      */   }
/*      */   
/*      */   public String[] separarFolio(String folio) {
/* 6982 */     String[] dat = { "", "" };
/* 6983 */     String conse = "";
/* 6984 */     String letra = "";
/* 6985 */     for (int i = 0; i < folio.length(); i++) {
/*      */       try {
/* 6987 */         int valor = Integer.parseInt("" + folio.charAt(i));
/* 6988 */         conse = conse + conse;
/* 6989 */       } catch (NumberFormatException e) {
/* 6990 */         letra = letra + letra;
/*      */       } 
/*      */     } 
/* 6993 */     dat[0] = letra;
/* 6994 */     dat[1] = conse;
/* 6995 */     return dat;
/*      */   }
/*      */   
/*      */   public void contarFacturas() {
/* 6999 */     this.jLabel194.setText("" + this.rSTableMetro6.getRowCount() + " Facturas Agregadas.");
/*      */   }
/*      */   
/*      */   public void sumarTotales20() {
/* 7003 */     double sub = 0.0D;
/* 7004 */     double iva = 0.0D;
/* 7005 */     double ret = 0.0D;
/* 7006 */     double saldos = 0.0D;
/*      */     
/* 7008 */     for (Facturas valor : this.FACTURAS.values()) {
/* 7009 */       sub += this.utilerias.convertirCantTexto(valor.getSubTotal());
/*      */     }
/*      */     
/* 7012 */     this.jLabel37.setText(this.utilerias.convertirDoublePesos(sub));
/*      */     
/* 7014 */     for (ImpuestosIva valor : this.IMPUESTOSIVA.values()) {
/* 7015 */       iva += this.utilerias.convertirCantTexto(valor.getImporte());
/*      */     }
/* 7017 */     this.jLabel38.setText(this.utilerias.convertirDoublePesos(iva));
/*      */     
/* 7019 */     for (ImpuestosRet valor : this.IMPUESTOSRET.values()) {
/* 7020 */       ret += this.utilerias.convertirCantTexto(valor.getImporte());
/*      */     }
/*      */     
/* 7023 */     this.jLabel40.setText(this.utilerias.convertirDoublePesos(ret));
/*      */   }
/*      */   
/*      */   public void sumarSaldos() {
/* 7027 */     if (this.VERSION == 1) {
/*      */       
/* 7029 */       double total = regresaSuma(3);
/* 7030 */       this.cantidad.setValue(Double.valueOf(total));
/* 7031 */       this.jLabel37.setText(this.cantidad.getText());
/*      */       
/* 7033 */       double anterior = regresaSuma(4);
/* 7034 */       this.cantidad.setValue(Double.valueOf(anterior));
/* 7035 */       this.jLabel38.setText(this.cantidad.getText());
/*      */       
/* 7037 */       double abono = regresaSuma(5);
/* 7038 */       this.cantidad.setValue(Double.valueOf(abono));
/* 7039 */       this.jLabel40.setText(this.cantidad.getText());
/*      */       
/* 7041 */       double insoluto = regresaSuma(6);
/* 7042 */       this.cantidad.setValue(Double.valueOf(insoluto));
/* 7043 */       this.jLabel65.setText(this.cantidad.getText());
/*      */       
/* 7045 */       double v = convertirCantTexto(this.jFormattedTextField4.getText());
/* 7046 */       if (abono > v) {
/* 7047 */         this.jLabel40.setForeground(Color.RED);
/*      */       } else {
/* 7049 */         this.jLabel40.setForeground(Color.BLACK);
/*      */       } 
/* 7051 */     } else if (this.VERSION == 2) {
/*      */       
/* 7053 */       sumarTotales20();
/*      */       
/* 7055 */       double saldos = regresaSuma(5);
/* 7056 */       this.cantidad.setValue(Double.valueOf(saldos));
/* 7057 */       this.jLabel65.setText(this.cantidad.getText());
/*      */       
/* 7059 */       this.jLabel85.setText(this.utilerias.convertirDoublePesos4Decimales(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro6, 9)));
/*      */     } 
/*      */   }
/*      */   
/*      */   public double regresaSuma(int columna) {
/* 7064 */     double suma = 0.0D;
/* 7065 */     for (int i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 7066 */       String valor = this.rSTableMetro6.getValueAt(i, columna).toString();
/* 7067 */       double monto = convertirCantTexto(valor);
/* 7068 */       suma += monto;
/*      */     } 
/* 7070 */     return suma;
/*      */   }
/*      */   
/*      */   public void buscarGuias() {
/* 7074 */     this.rSTableMetro7.setModel(new DefaultTableModel((Object[][])this.con
/* 7075 */           .buscarDatos(6, "folioFiscal, folio, cliente,numParcialidad, total, totaldebe", "facturas33", "where folioFiscal like '%" + this.jTextField8.getText() + "%' and folio like '%" + this.jTextField11.getText() + "%' and cliente like '%" + this.jTextField12.getText() + "%' and (estatus like '%<Abono%' || estatus='<Por Pagar>') and foliofiscal<>'' and tipo='F' order by folio desc"), (Object[])new String[] { "Folio Fiscal", "Folio Interno", "Cliente", "Parcialidad", "Total", "Debe" })
/*      */         {
/*      */ 
/*      */           
/* 7079 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7084 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7087 */     this.jLabel1.setText("" + this.rSTableMetro7.getRowCount() + " Facturas.");
/*      */   }
/*      */   
/*      */   public void buscarGuias20() {
/* 7091 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro7, new String[] { "Folio", "Fecha", "Folio Fiscal", "Cliente", "Par", "Mon", "Cambio", "SUB", "IVA", "RET", "TOTAL", "DEBE" }, "folio, fecha, folioFiscal, cliente, numParcialidad, moneda, tipoCambio, subtotal, iva, retencion, total, totaldebe", "facturas33", "where pagoMetodo NOT like '%PUE%' and folioFiscal like '%" + this.jTextField8
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7096 */         .getText() + "%' and folio like '%" + this.jTextField11.getText() + "%' and cliente like '%" + this.jTextField12.getText() + "%' and (estatus like '%<Abono%' || estatus='<Por Pagar>') and foliofiscal<>'' and tipo='F' order by fecha desc");
/*      */     
/* 7098 */     this.jLabel1.setText("" + this.rSTableMetro7.getRowCount() + " Facturas.");
/* 7099 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 4, 40);
/* 7100 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 5, 40);
/* 7101 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 6, 55);
/* 7102 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 7, 60);
/* 7103 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 8, 60);
/* 7104 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 9, 60);
/* 7105 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 10, 60);
/* 7106 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 11, 60);
/* 7107 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro7, this.celda4);
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 7111 */     String canti = cant;
/* 7112 */     String valorP = "";
/* 7113 */     for (int j = 0; j < canti.length(); j++) {
/* 7114 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7115 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 7118 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void agregarLeyendas() {
/* 7122 */     if (this.jTextField87.getText().equals("") || this.jTextField87.getText().equals("Ejemplo: ANEXO")) {
/* 7123 */       this.jTextField87.setBackground(Color.RED);
/* 7124 */       JOptionPane.showMessageDialog(this.jDialog18, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/* 7125 */     } else if (this.jTextField88.getText().equals("") || this.jTextField88.getText().equals("Ejemplo: Se agregan guías para su revisión con soportes en físico. Guías: PR-98293")) {
/* 7126 */       this.jTextField88.setBackground(Color.RED);
/* 7127 */       JOptionPane.showMessageDialog(this.jDialog18, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     }
/* 7129 */     else if (this.jDialog18.getTitle().equals("Modificar Leyenda")) {
/* 7130 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas modificar la leyenda que seleccionaste?", "Modificar leyenda", 0, 3, this.PREG);
/* 7131 */       if (res == 0) {
/* 7132 */         DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro5.getModel();
/* 7133 */         this.rSTableMetro5.setValueAt(this.jTextField87.getText().toUpperCase(), this.rSTableMetro5.getSelectedRow(), 0);
/* 7134 */         this.rSTableMetro5.setValueAt(this.jTextField88.getText().toUpperCase(), this.rSTableMetro5.getSelectedRow(), 1);
/* 7135 */         this.jTextField87.setText("");
/* 7136 */         this.jTextField88.setText("");
/* 7137 */         this.jDialog18.setVisible(false);
/*      */       } 
/*      */     } else {
/* 7140 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Deseas agregar una nueva leyenda?", "Agregar Leyenda", 0, 3, this.PREG);
/* 7141 */       if (res == 0) {
/* 7142 */         DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro5.getModel();
/* 7143 */         Object[] nuevo = { this.jTextField87.getText().toUpperCase(), this.jTextField88.getText().toUpperCase() };
/* 7144 */         temp.addRow(nuevo);
/* 7145 */         this.jTextField87.setText("");
/* 7146 */         this.jTextField88.setText("");
/* 7147 */         contarLeyendas();
/* 7148 */         this.jDialog18.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void contarLeyendas() {
/* 7156 */     this.jLabel192.setText("" + this.rSTableMetro5.getRowCount() + " Leyendas agregadas.");
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 7160 */     Calendar ahoraCal = Calendar.getInstance();
/* 7161 */     ahoraCal.setTime(this.fecha);
/* 7162 */     String mesesito = "";
/* 7163 */     String hoy = "";
/* 7164 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 7165 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 7167 */     if (ahoraCal.get(2) + 1 < 10) {
/* 7168 */       mesesito = "0" + mesesito;
/*      */     }
/* 7170 */     if (ahoraCal.get(5) < 10) {
/* 7171 */       hoy = "0" + hoy;
/*      */     }
/* 7173 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 7177 */     String motivo = this.jTextArea5.getText();
/* 7178 */     if (motivo.equals("")) {
/* 7179 */       this.jTextArea5.setBackground(Color.RED);
/* 7180 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas colocar el motivo por el cual se cancela el documento", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 7182 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas cancelar el documento que seleccionaste?", "Cancelar Documento", 0, 3, this.PREG);
/* 7183 */       if (res == 0) {
/* 7184 */         this.con.inserSinMsj("update complementopagos set estatus='<Cancelado " + cargarFechaHoy() + ": " + this.USUARIO + ">', motivo ='" + this.jTextArea5.getText().toUpperCase() + "' where numPago =" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 7185 */         consultar();
/* 7186 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarUsuarios() {
/* 7193 */     String[] datos = { ((String)this.CAMPOSGENERALES.get("empleados.ap_pat")).toString(), ((String)this.CAMPOSGENERALES.get("empleados.ap_mat")).toString(), ((String)this.CAMPOSGENERALES.get("empleados.nombre")).toString() };
/* 7194 */     this.ENTREGA = datos[0] + " " + datos[0] + " " + datos[1];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void limpiar() {
/* 7201 */     this.jDialog1.setTitle("Complementos");
/* 7202 */     System.out.println("Lmpiarrrrr ");
/* 7203 */     this.FACTURAS.clear();
/* 7204 */     this.IMPUESTOSIVA.clear();
/* 7205 */     this.IMPUESTOSRET.clear();
/* 7206 */     this.jButton37.setEnabled(false);
/* 7207 */     this.jComboBox4.setEnabled(true);
/* 7208 */     this.jTextField15.setEnabled(true);
/* 7209 */     this.jTextField16.setEnabled(true);
/* 7210 */     this.jTextField17.setEnabled(true);
/* 7211 */     this.jTextField18.setEnabled(true);
/*      */     
/* 7213 */     this.jTextField26.setEnabled(true);
/* 7214 */     this.jTextField27.setEnabled(true);
/* 7215 */     this.jTextField28.setEnabled(true);
/* 7216 */     this.jTextField29.setEnabled(true);
/*      */     
/* 7218 */     this.jTextField30.setEnabled(true);
/* 7219 */     this.jTextField31.setEnabled(true);
/* 7220 */     this.jTextField32.setEnabled(true);
/*      */     
/* 7222 */     this.jDateChooser1.setEnabled(true);
/* 7223 */     this.jSpinner1.setEnabled(true);
/* 7224 */     this.jSpinner2.setEnabled(true);
/* 7225 */     this.jSpinner3.setEnabled(true);
/*      */     
/* 7227 */     this.jComboBox18.setEnabled(true);
/* 7228 */     this.jButton55.setEnabled(true);
/* 7229 */     this.jFormattedTextField4.setEnabled(true);
/*      */     
/* 7231 */     this.jButton49.setEnabled(true);
/* 7232 */     this.jButton50.setEnabled(true);
/* 7233 */     this.jButton51.setEnabled(true);
/*      */     
/* 7235 */     this.jButton52.setEnabled(true);
/* 7236 */     this.jButton53.setEnabled(true);
/* 7237 */     this.jButton54.setEnabled(true);
/*      */ 
/*      */     
/* 7240 */     this.materialButton20.setText("Guardar");
/* 7241 */     this.materialButton20.setToolTipText("Guardar (Alt+G)");
/* 7242 */     this.materialButton20.setMnemonic('G');
/* 7243 */     this.jTextField8.setText("");
/* 7244 */     this.jTextField11.setText("");
/* 7245 */     this.jTextField12.setText("");
/* 7246 */     this.jLabel69.setText("CERO MXN, 00/100");
/* 7247 */     this.jComboBox4.setSelectedIndex(0);
/* 7248 */     this.jDateChooser8.setDate(new Date());
/* 7249 */     this.jTextField14.setText("");
/* 7250 */     this.jTextArea1.setText("");
/* 7251 */     this.jTextField26.setText("");
/* 7252 */     this.jTextField27.setText("");
/* 7253 */     this.jTextField28.setText("");
/* 7254 */     this.jTextField29.setText("");
/* 7255 */     this.jTextField15.setText("");
/* 7256 */     this.jTextField16.setText("");
/* 7257 */     this.jTextField17.setText("");
/* 7258 */     this.jTextField18.setText("");
/* 7259 */     this.jTextField30.setText("");
/* 7260 */     this.jTextField32.setText("");
/* 7261 */     this.jTextField31.setText("");
/* 7262 */     this.jDateChooser1.setDate(new Date());
/* 7263 */     this.jComboBox18.setSelectedIndex(0);
/* 7264 */     this.jTextField85.setText("MXN");
/* 7265 */     this.jFormattedTextField1.setValue(Double.valueOf(1.0D));
/* 7266 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 7267 */     this.rSTableMetro5.setFont(new Font("Dialog", 0, 11));
/* 7268 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Título", "Descripción" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7275 */     if (this.rSTableMetro5.getColumnModel().getColumnCount() > 0) {
/* 7276 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMinWidth(200);
/* 7277 */       this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(200);
/* 7278 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(200);
/*      */     } 
/* 7280 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 7281 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 7282 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 10));
/*      */     
/* 7284 */     this.jLabel192.setText(" 0 Leyendas Agregadas");
/* 7285 */     this.jLabel194.setText(" 0 Conceptos Agregados");
/* 7286 */     this.jSpinner1.setValue("00");
/* 7287 */     this.jSpinner2.setValue("00");
/* 7288 */     this.jSpinner3.setValue("00");
/*      */ 
/*      */     
/* 7291 */     this.rSTableMetro6.setFont(new Font("Dialog", 0, 11));
/* 7292 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio Fiscal", "Folio Interno", "Total", "Saldo", "Abono", "Remanente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7298 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7303 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 7307 */     this.rSTableMetro6.setFont(new Font("Dialog", 0, 11));
/* 7308 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio Fiscal", "Folio Interno", "Parcialidad", "Total", "Saldo", "Abono", "Remanente" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7314 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7319 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 7323 */     if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 7324 */       this.rSTableMetro6.getColumnModel().getColumn(0).setResizable(false);
/* 7325 */       this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(230);
/* 7326 */       this.rSTableMetro6.getColumnModel().getColumn(1).setResizable(false);
/* 7327 */       this.rSTableMetro6.getColumnModel().getColumn(2).setResizable(false);
/* 7328 */       this.rSTableMetro6.getColumnModel().getColumn(3).setResizable(false);
/* 7329 */       this.rSTableMetro6.getColumnModel().getColumn(4).setResizable(false);
/* 7330 */       this.rSTableMetro6.getColumnModel().getColumn(5).setResizable(false);
/* 7331 */       this.rSTableMetro6.getColumnModel().getColumn(6).setResizable(false);
/*      */     } 
/*      */     
/* 7334 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 7335 */     this.rSTableMetro6.setSelectionMode(0);
/* 7336 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 7337 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 7338 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda5);
/* 7339 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda5);
/* 7340 */     this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda5);
/* 7341 */     this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda5);
/* 7342 */     this.rSTableMetro6.getColumnModel().getColumn(4).setCellRenderer(this.celda5);
/* 7343 */     this.rSTableMetro6.getColumnModel().getColumn(5).setCellRenderer(this.celda5);
/* 7344 */     this.rSTableMetro6.getColumnModel().getColumn(6).setCellRenderer(this.celda5);
/* 7345 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/*      */     
/* 7347 */     this.jTextField71.setText("P01");
/* 7348 */     this.materialButton21.setVisible(false);
/* 7349 */     this.materialButton22.setVisible(false);
/* 7350 */     this.jLabel37.setText("$0.00");
/* 7351 */     this.jLabel38.setText("$0.00");
/* 7352 */     this.jLabel40.setText("$0.00");
/* 7353 */     this.jLabel65.setText("$0.00");
/*      */   }
/*      */   
/*      */   public void sacarDepa() {
/* 7357 */     this.DEPARTAMENTO = this.CAMPOSGENERALES.get("priv");
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
/*      */   public void contar() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pasarFact() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pasarFact2() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void llenarCatMonedas() {
/* 7491 */     this.rSTableMetro8.setModel(new DefaultTableModel((Object[][])this.con
/* 7492 */           .buscarDatos(2, "moneda,descripcion", "catMoneda", "order by moneda"), (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */           
/* 7495 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7500 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7503 */     this.rSTableMetro8.setShowVerticalLines(false);
/*      */     
/* 7505 */     this.rSTableMetro8.setSelectionMode(0);
/* 7506 */     this.rSTableMetro8.setAutoCreateRowSorter(true);
/* 7507 */     this.rSTableMetro8.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7509 */     this.rSTableMetro8.getColumnModel().getColumn(0).setPreferredWidth(90);
/* 7510 */     this.rSTableMetro8.getColumnModel().getColumn(0).setMaxWidth(90);
/*      */     
/* 7512 */     this.rSTableMetro8.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 7513 */     this.rSTableMetro8.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 7514 */     this.rSTableMetro8.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 7518 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 7522 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 7526 */     this.pintar.colorear(this.jComboBox36);
/* 7527 */     this.pintar.colorear(this.jComboBox37);
/* 7528 */     this.pintar.colorear(this.jFormattedTextField4);
/* 7529 */     this.pintar.colorear(this.jTextField2);
/* 7530 */     this.pintar.colorear(this.jTextField3);
/*      */     
/* 7532 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7534 */             complementoPagos.this.jTextGanado(complementoPagos.this.jFormattedTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7538 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/* 7541 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7543 */             complementoPagos.this.jTextGanado(complementoPagos.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7547 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 7552 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7554 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7558 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 7561 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7563 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7567 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 7570 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7572 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7576 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField12, evt);
/*      */           }
/*      */         });
/*      */     
/* 7580 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7582 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7586 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 7589 */     this.jComboBox18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7591 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7595 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox18, evt);
/*      */           }
/*      */         });
/* 7598 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7600 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7604 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 7607 */     this.jTextField87.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7609 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField87, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7613 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField87, evt);
/*      */           }
/*      */         });
/* 7616 */     this.jTextField88.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7618 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField88, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7622 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField88, evt);
/*      */           }
/*      */         });
/* 7625 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7627 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7631 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 7634 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7636 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField26, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7640 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField26, evt);
/*      */           }
/*      */         });
/* 7643 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7645 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7649 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 7652 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7654 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField28, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7658 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 7661 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7663 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7667 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 7670 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7672 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7676 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 7679 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7681 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7685 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 7688 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7690 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7694 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 7697 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7699 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7703 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 7706 */     this.jTextField30.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7708 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField30, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7712 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField30, evt);
/*      */           }
/*      */         });
/* 7715 */     this.jTextField32.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7717 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField32, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7721 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField32, evt);
/*      */           }
/*      */         });
/* 7724 */     this.jTextField31.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7726 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField31, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7730 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField31, evt);
/*      */           }
/*      */         });
/* 7733 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7735 */             complementoPagos.this.jTextGanado(complementoPagos.this.jFormattedTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7739 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 7744 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7746 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7750 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 7753 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7755 */             complementoPagos.this.jTextGanado(complementoPagos.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7759 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 7762 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7764 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7768 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 7771 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7773 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7777 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 7780 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7782 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7786 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 7789 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7791 */             complementoPagos.this.jTextGanado(complementoPagos.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7795 */             complementoPagos.this.jTextPerdido(complementoPagos.this.jComboBox6, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 7801 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 7809 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 7815 */         return 30;
/*      */       
/*      */       case 1:
/* 7818 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 7820 */           return 29;
/*      */         }
/* 7822 */         return 28;
/*      */     } 
/*      */     
/* 7825 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void Pagos(String usu) {
/* 7830 */     this.USUARIO = usu;
/* 7831 */     this.panel.setViewportView(this);
/* 7832 */     consultar();
/* 7833 */     sacarUsuarios();
/* 7834 */     sacarDepa();
/* 7835 */     this.jButton26.setEnabled(false);
/* 7836 */     this.jButton27.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 7840 */     this.CLAVES = this.con.regresaColIndex("tarjeta", "tarjeta_deudor_cliente", "order by nombre_corto");
/* 7841 */     String[] datos = this.con.regresaColIndex("distinct(nombre_corto)", "tarjeta_deudor_cliente", "order by nombre_corto");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7848 */     this.jComboBox1.removeAllItems();
/* 7849 */     this.jComboBox1.addItem("CLIENTES");
/* 7850 */     datos = this.con.regresaColIndex("distinct(cliente)", "complementopagos", "order by cliente"); int i;
/* 7851 */     for (i = 0; i < datos.length; i++) {
/* 7852 */       this.jComboBox1.addItem(datos[i]);
/*      */     }
/*      */     
/* 7855 */     datos = this.con.regresaColIndex("distinct(usuario)", "complementopagos", "order by usuario");
/* 7856 */     this.jComboBox2.removeAllItems();
/* 7857 */     this.jComboBox2.addItem("USUARIOS");
/* 7858 */     for (i = 0; i < datos.length; i++) {
/* 7859 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */     
/* 7862 */     this.jComboBox4.removeAllItems();
/* 7863 */     String[][] datClientes = this.con.buscarDatos("empresa, calle, num, col, ciudad, cp, rfc, edo, regimenFiscalClave, razonSocialSAT", "emp_generadora", "where usoCFDIClave!='' order by empresa");
/*      */     
/* 7865 */     for (int j = 0; j < datClientes.length; j++) {
/* 7866 */       this.jComboBox4.addItem(datClientes[j][0]);
/* 7867 */       this.CLIENTES.put(datClientes[j][0], datClientes[j][0]);
/* 7868 */       this.CALLE.put(datClientes[j][0], datClientes[j][1]);
/* 7869 */       this.NUMEROS.put(datClientes[j][0], datClientes[j][2]);
/* 7870 */       this.COLONIAS.put(datClientes[j][0], datClientes[j][3]);
/* 7871 */       this.CIUDADES.put(datClientes[j][0], datClientes[j][4]);
/* 7872 */       this.CODIGOS.put(datClientes[j][0], datClientes[j][5]);
/* 7873 */       this.RFC.put(datClientes[j][0], datClientes[j][6]);
/* 7874 */       this.ESTADOS.put(datClientes[j][0], datClientes[j][7]);
/* 7875 */       this.REGIMENES.put(datClientes[j][0], datClientes[j][8]);
/* 7876 */       this.RAZONSOCIAL.put(datClientes[j][0], datClientes[j][9]);
/*      */     } 
/*      */     
/* 7879 */     String[][] DATOS = this.con.buscarDatos(7, "cliente, bancoOrigen, rfcOrigen, cuentaOrigen, bancoDestino, rfcDestino, cuentaDestino", "complementopagos", " order by numPago");
/* 7880 */     this.BANCOS = new bancosEmisores[DATOS.length];
/* 7881 */     for (int k = 0; k < DATOS.length; k++) {
/* 7882 */       this.BANCOS[k] = new bancosEmisores(k, DATOS[k][0], DATOS[k][1], DATOS[k][2], DATOS[k][3], DATOS[k][4], DATOS[k][5], DATOS[k][6]);
/*      */     }
/*      */     
/* 7885 */     for (bancosEmisores bancos : this.BANCOS) {
/* 7886 */       agregarCampo(this.TODOS_EMISORBANCOCLIENTES, bancos.getCliente());
/* 7887 */       agregarCampo(this.TODOS_EMISORBANCONOMBRE, bancos.getBanco());
/* 7888 */       agregarCampo(this.TODOS_EMISORBANCORFC, bancos.getRfcBanco());
/*      */ 
/*      */       
/* 7891 */       agregarCampo(this.TODOS_RECEPTORBANCONOMBRE, bancos.getReceptorBanco());
/* 7892 */       agregarCampo(this.TODOS_RECEPTORBANCORFC, bancos.getReceptorRfc());
/*      */     } 
/*      */ 
/*      */     
/* 7896 */     this.com_EmisorBancoNombre = new TextAutoCompleter(this.jTextField28, this.TODOS_EMISORBANCONOMBRE);
/* 7897 */     this.com_EmisorBancoRFC = new TextAutoCompleter(this.jTextField27, this.TODOS_EMISORBANCORFC);
/*      */ 
/*      */     
/* 7900 */     this.com_ReceptorBancoNombre = new TextAutoCompleter(this.jTextField32, this.TODOS_RECEPTORBANCONOMBRE);
/* 7901 */     this.com_ReceptorBancoRFC = new TextAutoCompleter(this.jTextField30, this.TODOS_RECEPTORBANCORFC);
/*      */   }
/*      */ 
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 7906 */     if (!datos.contains(valor)) {
/* 7907 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 7912 */     this.PRIMERA = true;
/*      */     
/* 7914 */     String fechaCompleta1 = "";
/* 7915 */     String fechaCompleta2 = "";
/*      */     
/* 7917 */     String consultaFecha = "";
/* 7918 */     if (this.jComboBox37.getSelectedIndex() != 0) {
/* 7919 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/* 7921 */       int aa = Integer.parseInt(this.jComboBox36.getSelectedItem().toString());
/* 7922 */       consultaFecha = " and  date_format( fechaCaptura, '%m-%Y') = '" + mes[this.jComboBox37.getSelectedIndex()] + "-" + aa + "' ";
/*      */     } else {
/* 7924 */       Date fecha1 = this.jDateChooser9.getDate();
/* 7925 */       Date fecha2 = this.jDateChooser10.getDate();
/* 7926 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 7927 */       String cadenaFecha = "";
/* 7928 */       cadenaFecha = formato.format(fecha1);
/* 7929 */       String AÑO = cadenaFecha.substring(0, 4);
/* 7930 */       String MES = cadenaFecha.substring(4, 6);
/* 7931 */       String DIA = cadenaFecha.substring(6, 8);
/* 7932 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 7933 */       cadenaFecha = formato.format(fecha2);
/* 7934 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 7935 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 7936 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 7937 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 7938 */       consultaFecha = " and fechaCaptura between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7957 */     String cliente = "";
/* 7958 */     String entrega = "";
/* 7959 */     String estatus = "";
/* 7960 */     String folio = "";
/*      */     
/* 7962 */     if (!this.jTextField1.getText().equals(this.holderFolio)) {
/* 7963 */       folio = this.jTextField1.getText();
/*      */     }
/*      */     
/* 7966 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 7967 */       cliente = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 7969 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 7970 */       entrega = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 7972 */     if (this.jComboBox6.getSelectedIndex() == 0) {
/* 7973 */       estatus = " and (estatus ='<Por Timbrar>' || estatus like '%<Timbrado%')";
/*      */     }
/* 7975 */     if (this.jComboBox6.getSelectedIndex() == 1) {
/* 7976 */       estatus = " and estatus like '%<Cancelado%'";
/* 7977 */     } else if (this.jComboBox6.getSelectedIndex() == 2) {
/* 7978 */       estatus = " and estatus like '<Por Timbrar>'";
/* 7979 */     } else if (this.jComboBox6.getSelectedIndex() == 3) {
/* 7980 */       estatus = " and estatus like '%<Timbrado%'";
/*      */     } 
/* 7982 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 7983 */       entrega = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/*      */     
/* 7986 */     String monedaFiltro = "";
/* 7987 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 7988 */       monedaFiltro = "MXN";
/* 7989 */     } else if (this.jComboBox3.getSelectedIndex() == 2) {
/* 7990 */       monedaFiltro = "USD";
/*      */     } 
/*      */     
/* 7993 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro1, new String[] { "", "Núm", "Folio", "UUID", "Fecha de Creación", "Cliente", "RFC", "Fecha del Depósito", "Cantidad", "Moneda", "Cambio", "Convertidos MXN", "Fluctuación", "Num Facts", "Usuario", "Estatus", "Version" }, "pdf, numPago, folioPago, uuid,  fechaCaptura, cliente, rfc, fechaPago, monto, moneda, tipoCambio, convertidos, fluctuacion, numFacturas, usuario, estatus, version", "complementopagos", "where moneda like '%" + monedaFiltro + "%' and  folioPago like '%" + folio + "%' and cliente like '%" + cliente + "%' and usuario like '%" + entrega + "%' " + estatus + " " + consultaFecha + "  order by numPago desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 8003 */     double MXN = 0.0D;
/* 8004 */     double DLS = 0.0D;
/* 8005 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 8006 */       double precioDolar = this.utilerias.convertirCantTexto(this.rSTableMetro1.getValueAt(i, 10).toString());
/* 8007 */       double valorFact = this.utilerias.convertirCantTexto(this.rSTableMetro1.getValueAt(i, 8).toString());
/* 8008 */       this.rSTableMetro1.setValueAt(this.utilerias.convertirDoublePesos(precioDolar * valorFact), i, 11);
/*      */       
/* 8010 */       String moneda = this.rSTableMetro1.getValueAt(i, 9).toString();
/* 8011 */       if (moneda.equals("MXN")) {
/* 8012 */         MXN += this.utilerias.convertirCantTexto(this.rSTableMetro1.getValueAt(i, 8).toString());
/*      */       } else {
/* 8014 */         DLS += this.utilerias.convertirCantTexto(this.rSTableMetro1.getValueAt(i, 8).toString());
/*      */       } 
/*      */     } 
/*      */     
/* 8018 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 8019 */     this.jLabel31.setText(this.utilerias.convertirDoublePesos(MXN));
/* 8020 */     this.jLabel34.setText(this.utilerias.convertirDoublePesos(DLS));
/*      */     
/* 8022 */     this.jLabel32.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 11)));
/* 8023 */     this.jLabel33.setText(this.utilerias.convertirDoublePesos4Decimales(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro1, 12)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 8039 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Timbrar", 1, 15, 2));
/* 8040 */     this.celda2.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro1, "<Timbrado>", 1, 15, 2));
/*      */     
/* 8042 */     this.celda2.pasarInd5(this.con.revisarCol((JTable)this.rSTableMetro1, "<Cancelado", 1, 15, 2));
/*      */     
/* 8044 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda2);
/* 8045 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 30);
/* 8046 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 50);
/* 8047 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 90);
/* 8048 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 9, 60);
/* 8049 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 60);
/* 8050 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 13, 90);
/* 8051 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 16, 60);
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
/*      */   public void desplazarFecha() {
/* 8066 */     Calendar ca = Calendar.getInstance();
/* 8067 */     Calendar fecha = Calendar.getInstance();
/* 8068 */     fecha.add(2, -3);
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 8072 */     if (this.PRIMERA) {
/* 8073 */       this.con.consultar("max(numPago)", "complementopagos", "");
/* 8074 */       String mayor = this.con.Campo;
/* 8075 */       int MAYOR = 0;
/* 8076 */       if (mayor != null) {
/* 8077 */         MAYOR = Integer.parseInt(mayor);
/*      */       }
/* 8079 */       MAYOR++;
/* 8080 */       if (MAYOR < 100) {
/* 8081 */         this.jTextField5.setText("P" + this.DATOS[0] + "000" + MAYOR);
/*      */       }
/* 8083 */       else if (MAYOR < 1000) {
/* 8084 */         this.jTextField5.setText("P" + this.DATOS[0] + "00" + MAYOR);
/*      */       }
/* 8086 */       else if (MAYOR < 10000) {
/* 8087 */         this.jTextField5.setText("P" + this.DATOS[0] + "0" + MAYOR);
/*      */       } else {
/*      */         
/* 8090 */         this.jTextField5.setText("P" + this.DATOS[0] + MAYOR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void desbloquear() {
/* 8097 */     this.jComboBox4.setEnabled(true);
/* 8098 */     this.jTextField28.setEnabled(true);
/* 8099 */     this.jTextField27.setEnabled(true);
/* 8100 */     this.jTextField29.setEnabled(true);
/* 8101 */     this.jTextField26.setEnabled(true);
/* 8102 */     this.jTextField15.setEnabled(true);
/* 8103 */     this.jTextField16.setEnabled(true);
/* 8104 */     this.jTextField17.setEnabled(true);
/* 8105 */     this.jTextField18.setEnabled(true);
/*      */     
/* 8107 */     this.jTextField30.setEnabled(true);
/* 8108 */     this.jTextField31.setEnabled(true);
/* 8109 */     this.jTextField32.setEnabled(true);
/*      */     
/* 8111 */     this.jDateChooser1.setEnabled(true);
/* 8112 */     this.jSpinner1.setEnabled(true);
/* 8113 */     this.jSpinner2.setEnabled(true);
/* 8114 */     this.jSpinner3.setEnabled(true);
/*      */     
/* 8116 */     this.jComboBox18.setEnabled(true);
/* 8117 */     this.jButton55.setEnabled(true);
/*      */     
/* 8119 */     this.jFormattedTextField4.setEnabled(true);
/* 8120 */     this.jButton49.setEnabled(true);
/* 8121 */     this.jButton50.setEnabled(true);
/* 8122 */     this.jButton51.setEnabled(true);
/* 8123 */     this.jButton52.setEnabled(true);
/* 8124 */     this.jButton53.setEnabled(true);
/* 8125 */     this.jButton54.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void bloquear() {
/* 8130 */     String estado = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 8).toString();
/* 8131 */     if (estado.equals(""));
/*      */ 
/*      */     
/* 8134 */     this.materialButton21.setVisible(true);
/*      */     
/* 8136 */     this.materialButton20.setText("Imprimir");
/* 8137 */     this.materialButton20.setToolTipText("Imprimir (Alt+I)");
/* 8138 */     this.materialButton20.setMnemonic('I');
/* 8139 */     this.jComboBox4.setEnabled(false);
/* 8140 */     this.jTextField15.setEnabled(false);
/* 8141 */     this.jTextField16.setEnabled(false);
/* 8142 */     this.jTextField17.setEnabled(false);
/* 8143 */     this.jTextField18.setEnabled(false);
/*      */     
/* 8145 */     this.jTextField26.setEnabled(false);
/* 8146 */     this.jTextField27.setEnabled(false);
/* 8147 */     this.jTextField28.setEnabled(false);
/* 8148 */     this.jTextField29.setEnabled(false);
/*      */     
/* 8150 */     this.jTextField30.setEnabled(false);
/* 8151 */     this.jTextField31.setEnabled(false);
/* 8152 */     this.jTextField32.setEnabled(false);
/*      */     
/* 8154 */     this.jDateChooser1.setEnabled(false);
/* 8155 */     this.jSpinner1.setEnabled(false);
/* 8156 */     this.jSpinner2.setEnabled(false);
/* 8157 */     this.jSpinner3.setEnabled(false);
/* 8158 */     this.jFormattedTextField1.setEnabled(false);
/* 8159 */     this.jComboBox18.setEnabled(false);
/* 8160 */     this.jButton55.setEnabled(false);
/* 8161 */     this.jFormattedTextField4.setEnabled(false);
/*      */     
/* 8163 */     this.jButton49.setEnabled(false);
/* 8164 */     this.jButton50.setEnabled(false);
/* 8165 */     this.jButton51.setEnabled(false);
/*      */     
/* 8167 */     this.jButton52.setEnabled(false);
/* 8168 */     this.jButton53.setEnabled(false);
/* 8169 */     this.jButton54.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void verComplemento() {
/* 8173 */     if (this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15).toString().contains("Cancelado")) {
/* 8174 */       this.materialButton21.setVisible(false);
/* 8175 */       this.materialButton22.setVisible(true);
/* 8176 */     } else if (this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15).toString().equals("<Por Timbrar>")) {
/* 8177 */       this.materialButton21.setVisible(true);
/* 8178 */       this.materialButton22.setVisible(false);
/*      */     } else {
/* 8180 */       this.materialButton21.setVisible(false);
/* 8181 */       this.materialButton22.setVisible(false);
/*      */     } 
/* 8183 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 8184 */       this.materialButton21.setVisible(true);
/*      */     }
/*      */     
/* 8187 */     this.jTextField5.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString());
/* 8188 */     String FECHA = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4).toString();
/* 8189 */     String año = FECHA.substring(0, 4);
/* 8190 */     String mes = FECHA.substring(5, 7);
/* 8191 */     String dia = FECHA.substring(8, 10);
/* 8192 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 8193 */     String strFecha = año + "-" + año + "-" + mes;
/* 8194 */     Date fecha = null;
/*      */     try {
/* 8196 */       fecha = formatoDelTexto.parse(strFecha);
/* 8197 */     } catch (ParseException ex) {
/* 8198 */       ex.printStackTrace();
/*      */     } 
/* 8200 */     this.jDateChooser8.setDate(fecha);
/* 8201 */     this.jComboBox4.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5));
/* 8202 */     String[] datos = this.con.regresaRegIndex("calle, num, colonia, cp, ciudad, estado, formaPago, moneda, tipoCambio, numeroOperacion, bancoOrigen, cuentaOrigen, RFCOrigen, bancoDestino, cuentaDestino, RFCDestino, tipoCadena, certificado, cadenaPago, selloPago, razonSocialSAT, regimen", "complementopagos", "where folioPago='" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8209 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'");
/*      */     
/* 8211 */     this.jTextField14.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6).toString());
/* 8212 */     this.jTextArea1.setText(datos[0] + ", " + datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4]);
/* 8213 */     this.jTextField26.setText(datos[9]);
/* 8214 */     this.jTextField27.setText(datos[12]);
/* 8215 */     this.jTextField28.setText(datos[10]);
/*      */ 
/*      */     
/* 8218 */     this.jTextField29.setText(datos[11]);
/*      */     
/* 8220 */     this.jTextField15.setText(datos[18]);
/* 8221 */     this.jTextField16.setText(datos[16]);
/* 8222 */     this.jTextField17.setText(datos[17]);
/* 8223 */     this.jTextField18.setText(datos[19]);
/* 8224 */     this.jTextField30.setText(datos[15]);
/* 8225 */     this.jTextField32.setText(datos[13]);
/*      */ 
/*      */     
/* 8228 */     this.jTextField31.setText(datos[14]);
/* 8229 */     this.jTextField85.setText(datos[7]);
/*      */     
/* 8231 */     this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(datos[8])));
/*      */     
/* 8233 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "17", "28", "29", "NA", "99" };
/* 8234 */     String metodoPago = datos[6];
/* 8235 */     if (metodoPago.contains("TRANSFERENCIA")) {
/* 8236 */       this.jComboBox18.setSelectedIndex(2);
/* 8237 */     } else if (metodoPago.equals("NO IDENTIFICADO")) {
/* 8238 */       this.jComboBox18.setSelectedIndex(10);
/* 8239 */     } else if (metodoPago.contains("CHEQUE")) {
/* 8240 */       this.jComboBox18.setSelectedIndex(1);
/* 8241 */     } else if (metodoPago.contains("EFECTIVO")) {
/* 8242 */       this.jComboBox18.setSelectedIndex(0);
/*      */     } else {
/* 8244 */       int index = 0;
/* 8245 */       for (int i = 0; i < metodos.length; i++) {
/* 8246 */         if (metodos[i].equals(datos[6])) {
/* 8247 */           index = i;
/*      */           break;
/*      */         } 
/*      */       } 
/* 8251 */       this.jComboBox18.setSelectedIndex(index);
/*      */     } 
/* 8253 */     String cant = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 8).toString();
/* 8254 */     double v = convertirCantTexto(cant);
/* 8255 */     this.jFormattedTextField4.setValue(Double.valueOf(v));
/*      */     
/* 8257 */     FECHA = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 7).toString();
/* 8258 */     año = FECHA.substring(0, 4);
/* 8259 */     mes = FECHA.substring(5, 7);
/* 8260 */     dia = FECHA.substring(8, 10);
/* 8261 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 8262 */     strFecha = año + "-" + año + "-" + mes;
/* 8263 */     fecha = null;
/*      */     try {
/* 8265 */       fecha = formatoDelTexto.parse(strFecha);
/* 8266 */     } catch (ParseException ex) {
/* 8267 */       ex.printStackTrace();
/*      */     } 
/* 8269 */     this.jDateChooser1.setDate(fecha);
/*      */     
/* 8271 */     String hh = FECHA.substring(11, 13);
/* 8272 */     String mm = FECHA.substring(14, 16);
/* 8273 */     String ss = FECHA.substring(17, 19);
/* 8274 */     this.jSpinner1.setValue(hh);
/* 8275 */     this.jSpinner2.setValue(mm);
/* 8276 */     this.jSpinner3.setValue(ss);
/*      */     
/* 8278 */     this.rSTableMetro5.setModel(new DefaultTableModel((Object[][])this.con
/* 8279 */           .buscarDatos(2, "titulo,descripcion", "leyendasfacturas", "where numFactura = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "' order by numLeyenda asc"), (Object[])new String[] { "Titulo", "Leyenda" })
/*      */         {
/*      */ 
/*      */           
/* 8283 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8288 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 8291 */     if (this.rSTableMetro5.getColumnModel().getColumnCount() > 0) {
/* 8292 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMinWidth(200);
/* 8293 */       this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(200);
/* 8294 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(200);
/*      */     } 
/* 8296 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 8297 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 8298 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 10));
/*      */     
/* 8300 */     contarLeyendas();
/* 8301 */     imprimirCantidadLetra();
/*      */     
/* 8303 */     if (this.VERSION == 1) {
/* 8304 */       this.rSTableMetro6.setFont(new Font("Dialog", 0, 11));
/* 8305 */       this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 8306 */             .buscarDatos(7, "folioFiscal,folioInterno,numParcialidad, importeOriginal, importeAnterior, importeSaldado, importeInsoluto", "complementopagosfacturas", "where folioPago = '" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)) + "' order by folioFiscal desc"), (Object[])new String[] { "Folio Fiscal", "Folio Interno", "Parcialidad", "Total", "Saldo", "Abono", "Remanente" })
/*      */           {
/*      */ 
/*      */             
/* 8310 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8315 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 8319 */       if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 8320 */         this.rSTableMetro6.getColumnModel().getColumn(0).setResizable(false);
/* 8321 */         this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(230);
/* 8322 */         this.rSTableMetro6.getColumnModel().getColumn(1).setResizable(false);
/* 8323 */         this.rSTableMetro6.getColumnModel().getColumn(2).setResizable(false);
/* 8324 */         this.rSTableMetro6.getColumnModel().getColumn(3).setResizable(false);
/* 8325 */         this.rSTableMetro6.getColumnModel().getColumn(4).setResizable(false);
/* 8326 */         this.rSTableMetro6.getColumnModel().getColumn(5).setResizable(false);
/* 8327 */         this.rSTableMetro6.getColumnModel().getColumn(6).setResizable(false);
/*      */       } 
/* 8329 */       this.rSTableMetro6.setShowVerticalLines(false);
/* 8330 */       this.rSTableMetro6.setSelectionMode(0);
/* 8331 */       this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 8332 */       this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 8333 */       this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda5);
/* 8334 */       this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda5);
/* 8335 */       this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda5);
/* 8336 */       this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda5);
/* 8337 */       this.rSTableMetro6.getColumnModel().getColumn(4).setCellRenderer(this.celda5);
/* 8338 */       this.rSTableMetro6.getColumnModel().getColumn(5).setCellRenderer(this.celda5);
/* 8339 */       this.rSTableMetro6.getColumnModel().getColumn(6).setCellRenderer(this.celda5);
/* 8340 */       this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/*      */     }
/* 8342 */     else if (this.VERSION == 2) {
/* 8343 */       this.rSTableMetro6.setFont(new Font("Dialog", 0, 11));
/* 8344 */       this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 8345 */             .buscarDatos("serie, folio, folioFiscal, importeAnterior, importeSaldado, importeInsoluto, trasBase, retBase, dolarFacturado, fluctuacion", "complementopagosfacturas", "where folioPago = '" + 
/*      */               
/* 8347 */               String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "' order by folioInterno desc"), (Object[])new String[] { "", "Folio", "Folio Fiscal", "Saldo", "Abono", "Remanente", "Tras Base", "Ret Base", "Cambio", "Fluctuacion" })
/*      */           {
/*      */ 
/*      */             
/* 8351 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8356 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 8359 */       if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/* 8360 */         this.rSTableMetro6.getColumnModel().getColumn(0).setResizable(false);
/* 8361 */         this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(25);
/* 8362 */         this.rSTableMetro6.getColumnModel().getColumn(1).setResizable(false);
/* 8363 */         this.rSTableMetro6.getColumnModel().getColumn(1).setPreferredWidth(40);
/* 8364 */         this.rSTableMetro6.getColumnModel().getColumn(2).setResizable(false);
/* 8365 */         this.rSTableMetro6.getColumnModel().getColumn(2).setPreferredWidth(250);
/* 8366 */         this.rSTableMetro6.getColumnModel().getColumn(3).setResizable(false);
/* 8367 */         this.rSTableMetro6.getColumnModel().getColumn(4).setResizable(false);
/* 8368 */         this.rSTableMetro6.getColumnModel().getColumn(5).setResizable(false);
/* 8369 */         this.rSTableMetro6.getColumnModel().getColumn(6).setResizable(false);
/* 8370 */         this.rSTableMetro6.getColumnModel().getColumn(7).setResizable(false);
/*      */       } 
/*      */       
/* 8373 */       this.rSTableMetro6.setShowVerticalLines(false);
/* 8374 */       this.rSTableMetro6.setSelectionMode(0);
/* 8375 */       this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 8376 */       this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 8377 */       this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda7);
/* 8378 */       this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda7);
/* 8379 */       this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda7);
/* 8380 */       this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda7);
/* 8381 */       this.rSTableMetro6.getColumnModel().getColumn(4).setCellRenderer(this.celda7);
/* 8382 */       this.rSTableMetro6.getColumnModel().getColumn(5).setCellRenderer(this.celda7);
/* 8383 */       this.rSTableMetro6.getColumnModel().getColumn(6).setCellRenderer(this.celda7);
/* 8384 */       this.rSTableMetro6.getColumnModel().getColumn(7).setCellRenderer(this.celda7);
/* 8385 */       this.rSTableMetro6.getColumnModel().getColumn(8).setCellRenderer(this.celda7);
/* 8386 */       this.rSTableMetro6.getColumnModel().getColumn(9).setCellRenderer(this.celda7);
/* 8387 */       this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/*      */       
/* 8389 */       String consultasFac = "";
/* 8390 */       for (int i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 8391 */         consultasFac = consultasFac + " folio = '" + consultasFac + String.valueOf(this.rSTableMetro6.getValueAt(i, 0)) + "'";
/* 8392 */         if (i + 1 < this.rSTableMetro6.getRowCount()) {
/* 8393 */           consultasFac = consultasFac + " or ";
/*      */         }
/*      */       } 
/*      */       
/* 8397 */       String[][] datosFact = this.con.buscarDatos("subtotal, total, folio", "facturas33", "where " + consultasFac + " order by folio DESC");
/*      */       
/* 8399 */       for (int j = 0; j < this.rSTableMetro6.getRowCount(); j++) {
/* 8400 */         System.out.println("ordenamiento:  " + String.valueOf(this.rSTableMetro6.getValueAt(j, 1)));
/*      */         
/* 8402 */         String[] factura = this.con.regresaRegIndex("totalTrasladoBase, ObjImp, numParcialidad", "complementopagosfacturas", "where folioInterno = '" + String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(j, 1)) + "' and folioPago = '" + this.jTextField5.getText() + "'");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8420 */         Facturas f = new Facturas(String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(j, 0)), this.rSTableMetro6.getValueAt(j, 0).toString(), this.rSTableMetro6.getValueAt(j, 1).toString(), this.rSTableMetro6.getValueAt(j, 2).toString(), "MONEDA", factura[1], factura[2], this.rSTableMetro6.getValueAt(j, 3).toString(), this.rSTableMetro6.getValueAt(j, 4).toString(), this.rSTableMetro6.getValueAt(j, 5).toString(), this.rSTableMetro6.getValueAt(j, 6).toString(), this.rSTableMetro6.getValueAt(j, 7).toString(), datosFact[j][0], datosFact[j][1], factura[0], this.rSTableMetro6.getValueAt(j, 8).toString(), this.rSTableMetro6.getValueAt(j, 9).toString());
/*      */         
/* 8422 */         this.FACTURAS.put(String.valueOf(this.rSTableMetro6.getValueAt(j, 0)) + String.valueOf(this.rSTableMetro6.getValueAt(j, 0)), f);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 8427 */     contarFacturas();
/* 8428 */     sumarSaldos();
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 8432 */     int quitar = 4 * letras;
/* 8433 */     x -= quitar;
/* 8434 */     return x;
/*      */   }
/*      */   
/*      */   public class CeldaRender2
/*      */     extends DefaultTableCellRenderer
/*      */   {
/* 8440 */     int otro = -1;
/* 8441 */     String[] indices = new String[0];
/* 8442 */     String[] indices3 = new String[0];
/* 8443 */     String[] indices2 = new String[0];
/* 8444 */     String[] indices5 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8447 */       setEnabled((table == null || table.isEnabled()));
/* 8448 */       String comp = String.valueOf(table.getValueAt(row, 1));
/* 8449 */       if (comparar(comp)) {
/* 8450 */         setBackground(new Color(102, 153, 255));
/* 8451 */         setForeground(Color.BLUE);
/* 8452 */       } else if (comparar2(comp)) {
/* 8453 */         setBackground(new Color(153, 153, 153));
/* 8454 */         setForeground(Color.BLACK);
/* 8455 */       } else if (comparar5(comp)) {
/* 8456 */         setBackground(Color.RED);
/* 8457 */         setForeground(Color.WHITE);
/*      */       } else {
/* 8459 */         setBackground((Color)null);
/* 8460 */         setForeground(complementoPagos.this.lc.SECUNDARIO1);
/*      */       } 
/* 8462 */       if (column == 8 || column == 10 || column == 11 || column == 12 || column == 13) {
/* 8463 */         setHorizontalAlignment(4);
/*      */       } else {
/* 8465 */         setHorizontalAlignment(2);
/*      */       } 
/* 8467 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8468 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 8472 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 8476 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 8480 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 8484 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 8488 */       for (int i = 0; i < this.indices.length; i++) {
/* 8489 */         if (this.indices[i].equals(reg)) {
/* 8490 */           return true;
/*      */         }
/*      */       } 
/* 8493 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 8497 */       for (int i = 0; i < this.indices2.length; i++) {
/* 8498 */         if (this.indices2[i].equals(reg)) {
/* 8499 */           return true;
/*      */         }
/*      */       } 
/* 8502 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 8506 */       for (int i = 0; i < this.indices3.length; i++) {
/* 8507 */         if (this.indices3[i].equals(reg)) {
/* 8508 */           return true;
/*      */         }
/*      */       } 
/* 8511 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 8515 */       for (int i = 0; i < this.indices5.length; i++) {
/* 8516 */         if (this.indices5[i].equals(reg)) {
/* 8517 */           return true;
/*      */         }
/*      */       } 
/* 8520 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 8526 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8529 */       setEnabled((table == null || table.isEnabled()));
/* 8530 */       setHorizontalAlignment(4);
/* 8531 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8532 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender5
/*      */     extends DefaultTableCellRenderer {
/* 8538 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8541 */       setEnabled((table == null || table.isEnabled()));
/* 8542 */       if (row % 2 == 0) {
/* 8543 */         setBackground(complementoPagos.this.lc.FONDOTABLA);
/*      */       } else {
/* 8545 */         setBackground((Color)null);
/*      */       } 
/* 8547 */       if (column == 2 || column == 3 || column == 4 || column == 5 || column == 6) {
/* 8548 */         setHorizontalAlignment(4);
/*      */       } else {
/* 8550 */         setHorizontalAlignment(2);
/*      */       } 
/* 8552 */       setForeground(complementoPagos.this.lc.SECUNDARIO1);
/* 8553 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8554 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender7
/*      */     extends DefaultTableCellRenderer {
/* 8560 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8563 */       setEnabled((table == null || table.isEnabled()));
/* 8564 */       if (row % 2 == 0) {
/* 8565 */         setBackground(complementoPagos.this.lc.FONDOTABLA);
/*      */       } else {
/* 8567 */         setBackground((Color)null);
/*      */       } 
/* 8569 */       if (column == 1 || column == 3 || column == 4 || column == 5 || column == 8 || column == 9) {
/* 8570 */         setHorizontalAlignment(4);
/*      */       } else {
/* 8572 */         setHorizontalAlignment(2);
/*      */       } 
/* 8574 */       setForeground(complementoPagos.this.lc.SECUNDARIO1);
/* 8575 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8576 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImpuestosRet
/*      */   {
/*      */     String ID;
/*      */     String tipo;
/*      */     String tasa;
/*      */     String importe;
/*      */     String folioComplemento;
/*      */     String factura;
/*      */     String estatus;
/*      */     
/*      */     public ImpuestosRet(String ID, String tipo, String tasa, String importe, String folioComplemento, String factura, String estatus) {
/* 8591 */       this.ID = ID;
/* 8592 */       this.tipo = tipo;
/* 8593 */       this.tasa = tasa;
/* 8594 */       this.importe = importe;
/* 8595 */       this.folioComplemento = folioComplemento;
/* 8596 */       this.factura = factura;
/* 8597 */       this.estatus = estatus;
/*      */     }
/*      */     
/*      */     public String getEstatus() {
/* 8601 */       return this.estatus;
/*      */     }
/*      */     
/*      */     public void setEstatus(String estatus) {
/* 8605 */       this.estatus = estatus;
/*      */     }
/*      */     
/*      */     public String getID() {
/* 8609 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(String ID) {
/* 8613 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getTipo() {
/* 8617 */       return this.tipo;
/*      */     }
/*      */     
/*      */     public void setTipo(String tipo) {
/* 8621 */       this.tipo = tipo;
/*      */     }
/*      */     
/*      */     public String getTasa() {
/* 8625 */       return this.tasa;
/*      */     }
/*      */     
/*      */     public void setTasa(String tasa) {
/* 8629 */       this.tasa = tasa;
/*      */     }
/*      */     
/*      */     public String getImporte() {
/* 8633 */       return this.importe;
/*      */     }
/*      */     
/*      */     public void setImporte(String importe) {
/* 8637 */       this.importe = importe;
/*      */     }
/*      */     
/*      */     public String getFolioComplemento() {
/* 8641 */       return this.folioComplemento;
/*      */     }
/*      */     
/*      */     public void setFolioComplemento(String folioComplemento) {
/* 8645 */       this.folioComplemento = folioComplemento;
/*      */     }
/*      */     
/*      */     public String getFactura() {
/* 8649 */       return this.factura;
/*      */     }
/*      */     
/*      */     public void setFactura(String factura) {
/* 8653 */       this.factura = factura;
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImpuestosIva
/*      */   {
/*      */     String ID;
/*      */     String tipo;
/*      */     String tasa;
/*      */     String importe;
/*      */     String folioComplemento;
/*      */     String factura;
/*      */     String estatus;
/*      */     
/*      */     public ImpuestosIva(String ID, String tipo, String tasa, String importe, String folioComplemento, String factura, String estatus) {
/* 8668 */       this.ID = ID;
/* 8669 */       this.tipo = tipo;
/* 8670 */       this.tasa = tasa;
/* 8671 */       this.importe = importe;
/* 8672 */       this.folioComplemento = folioComplemento;
/* 8673 */       this.factura = factura;
/* 8674 */       this.estatus = estatus;
/*      */     }
/*      */     
/*      */     public String getEstatus() {
/* 8678 */       return this.estatus;
/*      */     }
/*      */     
/*      */     public void setEstatus(String estatus) {
/* 8682 */       this.estatus = estatus;
/*      */     }
/*      */     
/*      */     public String getID() {
/* 8686 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(String ID) {
/* 8690 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getTipo() {
/* 8694 */       return this.tipo;
/*      */     }
/*      */     
/*      */     public void setTipo(String tipo) {
/* 8698 */       this.tipo = tipo;
/*      */     }
/*      */     
/*      */     public String getTasa() {
/* 8702 */       return this.tasa;
/*      */     }
/*      */     
/*      */     public void setTasa(String tasa) {
/* 8706 */       this.tasa = tasa;
/*      */     }
/*      */     
/*      */     public String getImporte() {
/* 8710 */       return this.importe;
/*      */     }
/*      */     
/*      */     public void setImporte(String importe) {
/* 8714 */       this.importe = importe;
/*      */     }
/*      */     
/*      */     public String getFolioComplemento() {
/* 8718 */       return this.folioComplemento;
/*      */     }
/*      */     
/*      */     public void setFolioComplemento(String folioComplemento) {
/* 8722 */       this.folioComplemento = folioComplemento;
/*      */     }
/*      */     
/*      */     public String getFactura() {
/* 8726 */       return this.factura;
/*      */     }
/*      */     
/*      */     public void setFactura(String factura) {
/* 8730 */       this.factura = factura;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Facturas
/*      */   {
/*      */     String ID;
/*      */     String serie;
/*      */     String folio;
/*      */     String folioFiscal;
/*      */     String moneda;
/*      */     String objImp;
/*      */     String parcialidad;
/*      */     String saldo;
/*      */     String abono;
/*      */     String remanente;
/*      */     String retBase;
/*      */     String trasBase;
/*      */     String subTotal;
/*      */     String total;
/*      */     String totalTrasBase;
/*      */     String cambio;
/*      */     String fluctuacion;
/*      */     
/*      */     public Facturas(String ID, String serie, String folio, String folioFiscal, String moneda, String objImp, String parcialidad, String saldo, String abono, String remanente, String retBase, String trasBase, String subTotal, String total, String totalTrasBase, String cambio, String fluctuacion) {
/* 8756 */       this.ID = ID;
/* 8757 */       this.serie = serie;
/* 8758 */       this.folio = folio;
/* 8759 */       this.folioFiscal = folioFiscal;
/* 8760 */       this.moneda = moneda;
/* 8761 */       this.objImp = objImp;
/* 8762 */       this.parcialidad = parcialidad;
/* 8763 */       this.saldo = saldo;
/* 8764 */       this.abono = abono;
/* 8765 */       this.remanente = remanente;
/* 8766 */       this.retBase = retBase;
/* 8767 */       this.trasBase = trasBase;
/* 8768 */       this.subTotal = subTotal;
/* 8769 */       this.total = total;
/* 8770 */       this.totalTrasBase = totalTrasBase;
/* 8771 */       this.cambio = cambio;
/* 8772 */       this.fluctuacion = fluctuacion;
/*      */     }
/*      */     
/*      */     public String getCambio() {
/* 8776 */       return this.cambio;
/*      */     }
/*      */     
/*      */     public void setCambio(String cambio) {
/* 8780 */       this.cambio = cambio;
/*      */     }
/*      */     
/*      */     public String getFluctuacion() {
/* 8784 */       return this.fluctuacion;
/*      */     }
/*      */     
/*      */     public void setFluctuacion(String fluctuacion) {
/* 8788 */       this.fluctuacion = fluctuacion;
/*      */     }
/*      */     
/*      */     public String getTotalTrasBase() {
/* 8792 */       return this.totalTrasBase;
/*      */     }
/*      */     
/*      */     public void setTotalTrasBase(String totalTrasBase) {
/* 8796 */       this.totalTrasBase = totalTrasBase;
/*      */     }
/*      */     
/*      */     public String getTotal() {
/* 8800 */       return this.total;
/*      */     }
/*      */     
/*      */     public void setTotal(String total) {
/* 8804 */       this.total = total;
/*      */     }
/*      */     
/*      */     public String getSubTotal() {
/* 8808 */       return this.subTotal;
/*      */     }
/*      */     
/*      */     public void setSubTotal(String subTotal) {
/* 8812 */       this.subTotal = subTotal;
/*      */     }
/*      */     
/*      */     public String getID() {
/* 8816 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(String ID) {
/* 8820 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getSerie() {
/* 8824 */       return this.serie;
/*      */     }
/*      */     
/*      */     public void setSerie(String serie) {
/* 8828 */       this.serie = serie;
/*      */     }
/*      */     
/*      */     public String getFolio() {
/* 8832 */       return this.folio;
/*      */     }
/*      */     
/*      */     public void setFolio(String folio) {
/* 8836 */       this.folio = folio;
/*      */     }
/*      */     
/*      */     public String getFolioFiscal() {
/* 8840 */       return this.folioFiscal;
/*      */     }
/*      */     
/*      */     public void setFolioFiscal(String folioFiscal) {
/* 8844 */       this.folioFiscal = folioFiscal;
/*      */     }
/*      */     
/*      */     public String getMoneda() {
/* 8848 */       return this.moneda;
/*      */     }
/*      */     
/*      */     public void setMoneda(String moneda) {
/* 8852 */       this.moneda = moneda;
/*      */     }
/*      */     
/*      */     public String getObjImp() {
/* 8856 */       return this.objImp;
/*      */     }
/*      */     
/*      */     public void setObjImp(String objImp) {
/* 8860 */       this.objImp = objImp;
/*      */     }
/*      */     
/*      */     public String getParcialidad() {
/* 8864 */       return this.parcialidad;
/*      */     }
/*      */     
/*      */     public void setParcialidad(String parcialidad) {
/* 8868 */       this.parcialidad = parcialidad;
/*      */     }
/*      */     
/*      */     public String getSaldo() {
/* 8872 */       return this.saldo;
/*      */     }
/*      */     
/*      */     public void setSaldo(String saldo) {
/* 8876 */       this.saldo = saldo;
/*      */     }
/*      */     
/*      */     public String getAbono() {
/* 8880 */       return this.abono;
/*      */     }
/*      */     
/*      */     public void setAbono(String abono) {
/* 8884 */       this.abono = abono;
/*      */     }
/*      */     
/*      */     public String getRemanente() {
/* 8888 */       return this.remanente;
/*      */     }
/*      */     
/*      */     public void setRemanente(String remanente) {
/* 8892 */       this.remanente = remanente;
/*      */     }
/*      */     
/*      */     public String getRetBase() {
/* 8896 */       return this.retBase;
/*      */     }
/*      */     
/*      */     public void setRetBase(String retBase) {
/* 8900 */       this.retBase = retBase;
/*      */     }
/*      */     
/*      */     public String getTrasBase() {
/* 8904 */       return this.trasBase;
/*      */     }
/*      */     
/*      */     public void setTrasBase(String trasBase) {
/* 8908 */       this.trasBase = trasBase;
/*      */     }
/*      */   }
/*      */   
/*      */   public class bancosEmisores
/*      */   {
/*      */     int ID;
/*      */     String cliente;
/*      */     String banco;
/*      */     String rfcBanco;
/*      */     String cuentaBanco;
/*      */     String receptorBanco;
/*      */     String receptorRfc;
/*      */     String receptorCuenta;
/*      */     
/*      */     public bancosEmisores(int ID, String cliente, String banco, String rfcBanco, String cuentaBanco, String receptorBanco, String receptorRfc, String receptorCuenta) {
/* 8924 */       this.ID = ID;
/* 8925 */       this.cliente = cliente;
/* 8926 */       this.banco = banco;
/* 8927 */       this.rfcBanco = rfcBanco;
/* 8928 */       this.cuentaBanco = cuentaBanco;
/* 8929 */       this.receptorBanco = receptorBanco;
/* 8930 */       this.receptorRfc = receptorRfc;
/* 8931 */       this.receptorCuenta = receptorCuenta;
/*      */     }
/*      */     
/*      */     public int getID() {
/* 8935 */       return this.ID;
/*      */     }
/*      */     
/*      */     public void setID(int ID) {
/* 8939 */       this.ID = ID;
/*      */     }
/*      */     
/*      */     public String getCliente() {
/* 8943 */       return this.cliente;
/*      */     }
/*      */     
/*      */     public void setCliente(String cliente) {
/* 8947 */       this.cliente = cliente;
/*      */     }
/*      */     
/*      */     public String getBanco() {
/* 8951 */       return this.banco;
/*      */     }
/*      */     
/*      */     public void setBanco(String banco) {
/* 8955 */       this.banco = banco;
/*      */     }
/*      */     
/*      */     public String getRfcBanco() {
/* 8959 */       return this.rfcBanco;
/*      */     }
/*      */     
/*      */     public void setRfcBanco(String rfcBanco) {
/* 8963 */       this.rfcBanco = rfcBanco;
/*      */     }
/*      */     
/*      */     public String getCuentaBanco() {
/* 8967 */       return this.cuentaBanco;
/*      */     }
/*      */     
/*      */     public void setCuentaBanco(String cuentaBanco) {
/* 8971 */       this.cuentaBanco = cuentaBanco;
/*      */     }
/*      */     
/*      */     public String getReceptorBanco() {
/* 8975 */       return this.receptorBanco;
/*      */     }
/*      */     
/*      */     public void setReceptorBanco(String receptorBanco) {
/* 8979 */       this.receptorBanco = receptorBanco;
/*      */     }
/*      */     
/*      */     public String getReceptorRfc() {
/* 8983 */       return this.receptorRfc;
/*      */     }
/*      */     
/*      */     public void setReceptorRfc(String receptorRfc) {
/* 8987 */       this.receptorRfc = receptorRfc;
/*      */     }
/*      */     
/*      */     public String getReceptorCuenta() {
/* 8991 */       return this.receptorCuenta;
/*      */     }
/*      */     
/*      */     public void setReceptorCuenta(String receptorCuenta) {
/* 8995 */       this.receptorCuenta = receptorCuenta;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender3() {
/* 9002 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 9005 */       setEnabled((table == null || table.isEnabled()));
/* 9006 */       if (row % 2 == 0) {
/* 9007 */         setBackground(complementoPagos.this.lc.FONDOTABLA);
/*      */       } else {
/*      */         
/* 9010 */         setBackground((Color)null);
/*      */       } 
/*      */       
/* 9013 */       setForeground(complementoPagos.this.lc.SECUNDARIO1);
/* 9014 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 9015 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender4 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender4() {
/* 9021 */       this.otro = -1;
/*      */     }
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 9025 */       if (row % 2 == 0) {
/* 9026 */         setBackground(complementoPagos.this.lc.FONDOTABLA);
/*      */       } else {
/* 9028 */         setBackground((Color)null);
/*      */       } 
/* 9030 */       if (column == 4 || column == 6 || column == 7 || column == 8 || column == 9 || column == 10 || column == 11) {
/* 9031 */         setHorizontalAlignment(4);
/*      */       } else {
/* 9033 */         setHorizontalAlignment(2);
/*      */       } 
/* 9035 */       setForeground(complementoPagos.this.lc.SECUNDARIO1);
/* 9036 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 9037 */       return this;
/*      */     } }
/*      */   
/*      */   public class CeldaRender6 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     public CeldaRender6() {
/* 9043 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 9046 */       setEnabled((table == null || table.isEnabled()));
/*      */       
/* 9048 */       if (column == 0 || column == 1 || column == 3) {
/* 9049 */         setHorizontalAlignment(4);
/*      */       } else {
/* 9051 */         setHorizontalAlignment(0);
/*      */       } 
/*      */       
/* 9054 */       if (row % 2 == 0) {
/* 9055 */         setBackground(complementoPagos.this.lc.FONDOTABLA);
/*      */       } else {
/* 9057 */         setBackground((Color)null);
/*      */       } 
/* 9059 */       setForeground(complementoPagos.this.lc.SECUNDARIO1);
/* 9060 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 9061 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/complementoPagos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */