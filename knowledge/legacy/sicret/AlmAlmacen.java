/*      */ package sicret;
/*      */ import com.mxrck.autocompleter.TextAutoCompleter;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class AlmAlmacen extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   49 */   Date fechaActual = new Date();
/*   50 */   Date fechaInicio = null;
/*   51 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   52 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   53 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   54 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   55 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   56 */   Icon MODIFI = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/modificar.png")));
/*   57 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   58 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   59 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   60 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   61 */   JFrame padre = null;
/*   62 */   Consultas2 con2 = new Consultas2();
/*      */   boolean encontrado = false;
/*      */   boolean PRIMERA = false;
/*   65 */   PlaceHolder placeHolder = null;
/*   66 */   String holderFolio = "FOLIO";
/*      */   
/*   68 */   String holderProveedor = "PROVEEDOR";
/*   69 */   String holderCodigo = "CÓDIGO";
/*      */   
/*   71 */   String holderEquipo = "ORIGEN  | DESTINO  |  ECO";
/*   72 */   String holderSolicita = "SOLICITA";
/*   73 */   String holderProducto = "MERCANCIA  |  PRODUCTO  |  SERVICIO";
/*   74 */   String holderRef = "REFERENCIA";
/*   75 */   String holderFolioCot = "FOLIO";
/*      */   
/*   77 */   String holderId = "ID DEL PRODUCTO";
/*   78 */   String holderDesc = "DECRIPCIÓN";
/*   79 */   String holderRefProd = "REFERENCIA";
/*      */   
/*   81 */   SColores lc = new SColores();
/*      */   Map<String, String> CAMPOSGENERALES;
/*   83 */   Utilerias utilerias = new Utilerias();
/*   84 */   List<Tras_codigos> CODIGOSP = null;
/*   85 */   Fuentes fuentes = new Fuentes();
/*   86 */   pintarComponentes pintar = new pintarComponentes();
/*      */   private int xx;
/*      */   private int xy;
/*      */   String[] SUCURSALES;
/*      */   String[] AREAS;
/*      */   String[] SOLICITA;
/*      */   String[] AUTORIZA;
/*      */   String[] RECIBE;
/*   94 */   String DIRECTIVA = "";
/*   95 */   String UNIDADMED = "";
/*   96 */   CeldaRender1 celda1 = new CeldaRender1();
/*   97 */   CeldaRender2 celda2 = new CeldaRender2();
/*   98 */   CeldaRender3 celda3 = new CeldaRender3();
/*      */   
/*  100 */   List<String> DEPARTAMENTOSTODO = new ArrayList<>();
/*  101 */   List<String> DEPARTAMENTOSVER = new ArrayList<>();
/*  102 */   ArrayList TODOS_SOLICITA = new ArrayList();
/*  103 */   ArrayList TODOS_AUTORIZA = new ArrayList();
/*  104 */   ArrayList TODOS_RECIBE = new ArrayList();
/*      */   
/*  106 */   TextAutoCompleter com_Solicita = null;
/*  107 */   TextAutoCompleter com_Autoriza = null;
/*  108 */   TextAutoCompleter com_Recibe = null;
/*      */   boolean llenarPrimera = false;
/*      */   boolean entraConsultaRequi = false;
/*  111 */   List<Productos> PRODUCTOS = new ArrayList<>();
/*  112 */   int CONSE = 0;
/*      */   boolean actualizado = false;
/*      */   String[] CATEGORIAS;
/*  115 */   double VALORALMACEN = 0.0D;
/*      */   
/*      */   private static final String ENTRADA = "ENTRADA";
/*      */   private static final String SALIDA = "SALIDA";
/*      */   private static final String GUARDAR = "Guardar";
/*  120 */   String ESTATUS = ""; boolean ENTRAMODIFICAR = false; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton15; private JButton jButton18; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton28; private JButton jButton31; private JButton jButton52; private JButton jButton53; private JButton jButton60; private JComboBox<String> jComboBox1; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox<String> jComboBox12; private JComboBox<String> jComboBox2; private JComboBox<String> jComboBox23; private JComboBox<String> jComboBox24; private JComboBox jComboBox3; private JComboBox<String> jComboBox38; private JComboBox<String> jComboBox39; private JComboBox jComboBox4; private JComboBox<String> jComboBox5; private JComboBox<String> jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox<String> jComboBox9; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser6; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel103; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel135; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2;
/*      */   private JLabel jLabel20;
/*  122 */   String SUCURSALIMPRESION = ""; private JLabel jLabel21; private JLabel jLabel217; private JLabel jLabel219; private JLabel jLabel221; private JLabel jLabel223; private JLabel jLabel224; private JLabel jLabel235; private JLabel jLabel236; private JLabel jLabel237; private JLabel jLabel238; private JLabel jLabel239; private JLabel jLabel240; private JLabel jLabel241; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel52; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel9; private JLabel jLabel95; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel100; private JPanel jPanel108; private JPanel jPanel109; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel151;
/*      */   private JPanel jPanel159;
/*      */   
/*      */   public AlmAlmacen(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*  128 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  129 */     this.con2.setBaseDatos("sicre2PR");
/*      */     
/*  131 */     this.DEPARTAMENTOSVER.add("CONTRALORIA");
/*      */     
/*  133 */     this.DEPARTAMENTOSTODO.add("SUPER USUARIO");
/*  134 */     this.DEPARTAMENTOSTODO.add("ADMINISTRADOR");
/*  135 */     this.DEPARTAMENTOSTODO.add("RESETEOS");
/*      */     
/*  137 */     String año = "2009";
/*  138 */     String mes = "10";
/*      */     
/*  140 */     this.DIRECTIVA = this.CAMPOSGENERALES.get("directiva");
/*  141 */     String dia = "10";
/*  142 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  143 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  145 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  146 */     } catch (ParseException ex) {
/*  147 */       ex.printStackTrace();
/*      */     } 
/*  149 */     this.padre = padre;
/*  150 */     fichas = fichas;
/*  151 */     initComponents();
/*      */     
/*  153 */     this.placeHolder = new PlaceHolder(this.jTextField6, new Color(120, 120, 120), Color.BLACK, this.holderFolio, false, "Cantarell", 11);
/*  154 */     this.placeHolder = new PlaceHolder(this.jTextField24, new Color(120, 120, 120), Color.BLACK, this.holderCodigo, false, "Cantarell", 11);
/*  155 */     this.placeHolder = new PlaceHolder(this.jTextField27, new Color(120, 120, 120), Color.BLACK, this.holderProveedor, false, "Cantarell", 11);
/*  156 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(120, 120, 120), Color.BLACK, this.holderEquipo, false, "Cantarell", 11);
/*  157 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(120, 120, 120), Color.BLACK, this.holderSolicita, false, "Cantarell", 11);
/*  158 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(120, 120, 120), Color.BLACK, this.holderProducto, false, "Cantarell", 11);
/*  159 */     this.placeHolder = new PlaceHolder(this.jTextField15, new Color(120, 120, 120), Color.BLACK, this.holderRef, false, "Cantarell", 11);
/*  160 */     this.placeHolder = new PlaceHolder(this.jTextField26, new Color(120, 120, 120), Color.BLACK, this.holderFolioCot, false, "Cantarell", 11);
/*      */     
/*  162 */     this.placeHolder = new PlaceHolder(this.jTextField12, new Color(120, 120, 120), Color.BLACK, this.holderId, false, "Century Gothic", 11);
/*  163 */     this.placeHolder = new PlaceHolder(this.jTextField13, new Color(120, 120, 120), Color.BLACK, this.holderDesc, false, "Century Gothic", 11);
/*  164 */     this.placeHolder = new PlaceHolder(this.jTextField14, new Color(120, 120, 120), Color.BLACK, this.holderRefProd, false, "Century Gothic", 11);
/*      */     
/*  166 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  167 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  168 */     this.jLabel223.setCursor(micursor);
/*  169 */     this.jLabel103.setCursor(micursor);
/*  170 */     this.jLabel224.setCursor(micursor);
/*      */     
/*  172 */     this.USUARIO = USUARIO;
/*  173 */     panelito.setViewportView(this);
/*  174 */     this.panel = panelito;
/*      */     
/*  176 */     int w = this.tama.width;
/*  177 */     int h = this.tama.height;
/*  178 */     int rw = (w - 870) / 2;
/*  179 */     int rh = (h - 10) / 2;
/*      */     
/*  181 */     for (int i = 2023; i <= this.utilerias.añoActual(); i++) {
/*  182 */       this.jComboBox2.addItem("" + i);
/*  183 */       this.jComboBox39.addItem("" + i);
/*      */     } 
/*  185 */     this.jComboBox1.setSelectedIndex(this.utilerias.mesActual());
/*  186 */     this.jComboBox2.setSelectedItem("" + this.utilerias.añoActual());
/*  187 */     this.jComboBox38.setSelectedIndex(this.utilerias.mesActual() - 1);
/*  188 */     this.jComboBox39.setSelectedItem("" + this.utilerias.añoActual());
/*      */     
/*  190 */     consultar();
/*  191 */     llenarCombo();
/*  192 */     colorear();
/*  193 */     this.utilerias.activarVentanajDialog(this.jDialog1, 890, 730);
/*  194 */     this.utilerias.activarVentanajDialog(this.jDialog2, 800, 500);
/*  195 */     this.utilerias.activarVentanajDialog(this.jDialog3, 950, 400);
/*  196 */     this.utilerias.activarVentanajDialog(this.jDialog4, 500, 350);
/*  197 */     this.utilerias.activarVentanajDialog(this.jDialog5, 950, 450);
/*  198 */     this.utilerias.activarVentanajDialog(this.jDialog6, 550, 340);
/*  199 */     this.utilerias.activarVentanajDialog(this.jDialog7, 400, 190);
/*  200 */     this.utilerias.activarVentanajDialog(this.jDialog8, 1000, 890);
/*      */     
/*  202 */     llenarProductos();
/*  203 */     cambiarTablaProductos();
/*      */     
/*  205 */     this.buttonGroup1.add(this.jRadioButton1);
/*  206 */     this.buttonGroup1.add(this.jRadioButton2);
/*  207 */     this.buttonGroup1.add(this.jRadioButton3);
/*      */   }
/*      */   private JPanel jPanel16; private JPanel jPanel168; private JPanel jPanel169; private JPanel jPanel17; private JPanel jPanel170; private JPanel jPanel171; private JPanel jPanel173; private JPanel jPanel174; private JPanel jPanel175; private JPanel jPanel176; private JPanel jPanel177; private JPanel jPanel178; private JPanel jPanel179; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel5; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel6; private JPanel jPanel61; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JScrollPane jScrollPane1; private JScrollPane jScrollPane29; private JScrollPane jScrollPane3; private JScrollPane jScrollPane39; private JScrollPane jScrollPane4; private JScrollPane jScrollPane40; private JScrollPane jScrollPane41; private JScrollPane jScrollPane42; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSpinner jSpinner1; private JSpinner jSpinner2; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton44; private MaterialButton materialButton45; private MaterialButton materialButton46; private MaterialButton materialButton47; private MaterialButton materialButton48; private MaterialButton materialButton49;
/*      */   private MaterialButton materialButton50;
/*      */   private RSTableMetro rSTableMetro1;
/*      */   private RSTableMetro rSTableMetro2;
/*      */   private RSTableMetro rSTableMetro3;
/*      */   private RSTableMetro rSTableMetro4;
/*      */   private RSTableMetro rSTableMetro5;
/*      */   
/*      */   private void initComponents() {
/*  218 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  219 */     this.jPanel1 = new JPanel();
/*  220 */     this.jPanel54 = new JPanel();
/*  221 */     this.jLabel52 = new JLabel();
/*  222 */     this.jPanel100 = new JPanel();
/*  223 */     this.jLabel135 = new JLabel();
/*  224 */     this.jLabel60 = new JLabel();
/*  225 */     this.jPanel2 = new JPanel();
/*  226 */     this.jPanel3 = new JPanel();
/*  227 */     this.jPanel7 = new JPanel();
/*  228 */     this.jLabel1 = new JLabel();
/*  229 */     this.jPanel13 = new JPanel();
/*  230 */     this.jButton1 = new JButton();
/*  231 */     this.jLabel3 = new JLabel();
/*  232 */     this.jPanel14 = new JPanel();
/*  233 */     this.jPanel5 = new JPanel();
/*  234 */     this.jLabel26 = new JLabel();
/*  235 */     this.jTextField4 = new JTextField();
/*  236 */     this.jLabel7 = new JLabel();
/*  237 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  238 */     this.jPanel4 = new JPanel();
/*  239 */     this.jLabel17 = new JLabel();
/*  240 */     this.jComboBox5 = new JComboBox<>();
/*  241 */     this.jLabel6 = new JLabel();
/*  242 */     this.jComboBox6 = new JComboBox<>();
/*  243 */     this.jPanel6 = new JPanel();
/*  244 */     this.jLabel18 = new JLabel();
/*  245 */     this.jComboBox9 = new JComboBox<>();
/*  246 */     this.jLabel27 = new JLabel();
/*  247 */     this.jTextField5 = new JTextField();
/*  248 */     this.jPanel8 = new JPanel();
/*  249 */     this.jLabel28 = new JLabel();
/*  250 */     this.jTextField7 = new JTextField();
/*  251 */     this.jPanel9 = new JPanel();
/*  252 */     this.jPanel10 = new JPanel();
/*  253 */     this.jScrollPane40 = new JScrollPane();
/*  254 */     this.rSTableMetro2 = new RSTableMetro();
/*  255 */     this.jButton52 = new JButton();
/*  256 */     this.jButton53 = new JButton();
/*  257 */     this.jPanel11 = new JPanel();
/*  258 */     this.jLabel33 = new JLabel();
/*  259 */     this.jTextField22 = new JTextField();
/*  260 */     this.jLabel34 = new JLabel();
/*  261 */     this.jTextField23 = new JTextField();
/*  262 */     this.jLabel29 = new JLabel();
/*  263 */     this.jTextField8 = new JTextField();
/*  264 */     this.jPanel12 = new JPanel();
/*  265 */     this.jLabel4 = new JLabel();
/*  266 */     this.jTextField9 = new JTextField();
/*  267 */     this.jLabel5 = new JLabel();
/*  268 */     this.jTextField10 = new JTextField();
/*  269 */     this.jLabel8 = new JLabel();
/*  270 */     this.jTextField11 = new JTextField();
/*  271 */     this.jPanel18 = new JPanel();
/*  272 */     this.jScrollPane1 = new JScrollPane();
/*  273 */     this.jTextPane1 = new JTextPane();
/*  274 */     this.jPanel108 = new JPanel();
/*  275 */     this.materialButton19 = new MaterialButton();
/*  276 */     this.materialButton20 = new MaterialButton();
/*  277 */     this.jComboBox12 = new JComboBox<>();
/*  278 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  279 */     this.jPanel173 = new JPanel();
/*  280 */     this.materialButton44 = new MaterialButton();
/*  281 */     this.jPanel42 = new JPanel();
/*  282 */     this.jScrollPane39 = new JScrollPane();
/*  283 */     this.rSTableMetro3 = new RSTableMetro();
/*  284 */     this.jPanel27 = new JPanel();
/*  285 */     this.jLabel41 = new JLabel();
/*  286 */     this.jPanel28 = new JPanel();
/*  287 */     this.jTextField26 = new JTextField();
/*  288 */     this.jTextField27 = new JTextField();
/*  289 */     this.jPanel29 = new JPanel();
/*  290 */     this.jComboBox38 = new JComboBox<>();
/*  291 */     this.jComboBox39 = new JComboBox<>();
/*  292 */     this.jButton31 = new JButton();
/*  293 */     this.jPanel174 = new JPanel();
/*  294 */     this.jLabel236 = new JLabel();
/*  295 */     this.jLabel80 = new JLabel();
/*  296 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  297 */     this.jPanel175 = new JPanel();
/*  298 */     this.materialButton45 = new MaterialButton();
/*  299 */     this.jPanel43 = new JPanel();
/*  300 */     this.jScrollPane41 = new JScrollPane();
/*  301 */     this.rSTableMetro4 = new RSTableMetro();
/*  302 */     this.jLabel9 = new JLabel();
/*  303 */     this.jPanel176 = new JPanel();
/*  304 */     this.jLabel237 = new JLabel();
/*  305 */     this.jLabel81 = new JLabel();
/*  306 */     this.jPanel177 = new JPanel();
/*  307 */     this.jLabel240 = new JLabel();
/*  308 */     this.jLabel82 = new JLabel();
/*  309 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  310 */     this.jPanel20 = new JPanel();
/*  311 */     this.jPanel21 = new JPanel();
/*  312 */     this.jPanel22 = new JPanel();
/*  313 */     this.jPanel37 = new JPanel();
/*  314 */     this.jPanel38 = new JPanel();
/*  315 */     this.jLabel30 = new JLabel();
/*  316 */     this.jLabel31 = new JLabel();
/*  317 */     this.jPanel39 = new JPanel();
/*  318 */     this.jLabel32 = new JLabel();
/*  319 */     this.jLabel50 = new JLabel();
/*  320 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  321 */     this.jPanel178 = new JPanel();
/*  322 */     this.materialButton46 = new MaterialButton();
/*  323 */     this.jPanel44 = new JPanel();
/*  324 */     this.jScrollPane42 = new JScrollPane();
/*  325 */     this.rSTableMetro5 = new RSTableMetro();
/*  326 */     this.jPanel35 = new JPanel();
/*  327 */     this.jTextField12 = new JTextField();
/*  328 */     this.jTextField13 = new JTextField();
/*  329 */     this.jTextField14 = new JTextField();
/*  330 */     this.jComboBox4 = new JComboBox();
/*  331 */     this.jComboBox10 = new JComboBox();
/*  332 */     this.jComboBox11 = new JComboBox();
/*  333 */     this.jPanel179 = new JPanel();
/*  334 */     this.jLabel241 = new JLabel();
/*  335 */     this.jLabel83 = new JLabel();
/*  336 */     this.materialButton47 = new MaterialButton();
/*  337 */     this.materialButton48 = new MaterialButton();
/*  338 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  339 */     this.jPanel23 = new JPanel();
/*  340 */     this.jPanel24 = new JPanel();
/*  341 */     this.jLabel11 = new JLabel();
/*  342 */     this.jTextField16 = new JTextField();
/*  343 */     this.jLabel12 = new JLabel();
/*  344 */     this.jTextField17 = new JTextField();
/*  345 */     this.jLabel13 = new JLabel();
/*  346 */     this.jSpinner2 = new JSpinner();
/*  347 */     this.jLabel14 = new JLabel();
/*  348 */     this.jTextField18 = new JTextField();
/*  349 */     this.jLabel15 = new JLabel();
/*  350 */     this.jTextField19 = new JTextField();
/*  351 */     this.jLabel19 = new JLabel();
/*  352 */     this.jTextField21 = new JTextField();
/*  353 */     this.jLabel16 = new JLabel();
/*  354 */     this.jTextField20 = new JTextField();
/*  355 */     this.jPanel109 = new JPanel();
/*  356 */     this.materialButton21 = new MaterialButton();
/*  357 */     this.materialButton22 = new MaterialButton();
/*  358 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  359 */     this.jPanel25 = new JPanel();
/*  360 */     this.jRadioButton1 = new JRadioButton();
/*  361 */     this.jRadioButton3 = new JRadioButton();
/*  362 */     this.jRadioButton2 = new JRadioButton();
/*  363 */     this.materialButton49 = new MaterialButton();
/*  364 */     this.jSeparator1 = new JSeparator();
/*  365 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  366 */     this.materialButton50 = new MaterialButton();
/*  367 */     this.jPanel26 = new JPanel();
/*  368 */     this.jScrollPane3 = new JScrollPane();
/*  369 */     this.jTable1 = new JTable();
/*  370 */     this.jScrollPane4 = new JScrollPane();
/*  371 */     this.jTable2 = new JTable();
/*  372 */     this.jScrollPane5 = new JScrollPane();
/*  373 */     this.jTable3 = new JTable();
/*  374 */     this.jLabel20 = new JLabel();
/*  375 */     this.jLabel21 = new JLabel();
/*  376 */     this.jLabel2 = new JLabel();
/*  377 */     this.jPanel19 = new JPanel();
/*  378 */     this.jLabel10 = new JLabel();
/*  379 */     this.jSpinner1 = new JSpinner();
/*  380 */     this.buttonGroup1 = new ButtonGroup();
/*  381 */     this.jTextField24 = new JTextField();
/*  382 */     this.jPanel159 = new JPanel();
/*  383 */     this.jPanel168 = new JPanel();
/*  384 */     this.jPanel17 = new JPanel();
/*  385 */     this.jComboBox7 = new JComboBox();
/*  386 */     this.jPanel30 = new JPanel();
/*  387 */     this.jTextField6 = new JTextField();
/*  388 */     this.jTextField1 = new JTextField();
/*  389 */     this.jTextField3 = new JTextField();
/*  390 */     this.jTextField15 = new JTextField();
/*  391 */     this.jTextField2 = new JTextField();
/*  392 */     this.jComboBox8 = new JComboBox();
/*  393 */     this.jComboBox3 = new JComboBox();
/*  394 */     this.jComboBox23 = new JComboBox<>();
/*  395 */     this.jComboBox24 = new JComboBox<>();
/*  396 */     this.jPanel169 = new JPanel();
/*  397 */     this.jPanel170 = new JPanel();
/*  398 */     this.jPanel171 = new JPanel();
/*  399 */     this.jLabel235 = new JLabel();
/*  400 */     this.jLabel48 = new JLabel();
/*  401 */     this.jButton24 = new JButton();
/*  402 */     this.jButton60 = new JButton();
/*  403 */     this.jButton25 = new JButton();
/*  404 */     this.jButton18 = new JButton();
/*  405 */     this.jButton26 = new JButton();
/*  406 */     this.jButton15 = new JButton();
/*  407 */     this.jPanel15 = new JPanel();
/*  408 */     this.jPanel16 = new JPanel();
/*  409 */     this.jScrollPane29 = new JScrollPane();
/*  410 */     this.rSTableMetro1 = new RSTableMetro();
/*  411 */     this.jPanel151 = new JPanel();
/*  412 */     this.jLabel217 = new JLabel();
/*  413 */     this.jLabel42 = new JLabel();
/*  414 */     this.jLabel219 = new JLabel();
/*  415 */     this.jLabel39 = new JLabel();
/*  416 */     this.jLabel221 = new JLabel();
/*  417 */     this.jLabel40 = new JLabel();
/*  418 */     this.jPanel36 = new JPanel();
/*  419 */     this.jLabel95 = new JLabel();
/*  420 */     this.jPanel55 = new JPanel();
/*  421 */     this.jPanel61 = new JPanel();
/*  422 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  423 */     this.jLabel238 = new JLabel();
/*  424 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  425 */     this.jComboBox2 = new JComboBox<>();
/*  426 */     this.jPanel63 = new JPanel();
/*  427 */     this.jButton28 = new JButton();
/*  428 */     this.jLabel223 = new JLabel();
/*  429 */     this.jLabel103 = new JLabel();
/*  430 */     this.jLabel224 = new JLabel();
/*  431 */     this.jPanel64 = new JPanel();
/*  432 */     this.jLabel239 = new JLabel();
/*  433 */     this.jComboBox1 = new JComboBox<>();
/*      */     
/*  435 */     this.jDialog1.setTitle("Crear nuevo comprobante");
/*  436 */     this.jDialog1.setModal(true);
/*  437 */     this.jDialog1.setUndecorated(true);
/*      */     
/*  439 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*      */     
/*  441 */     this.jPanel54.setBackground(this.lc.SECUNDARIO1);
/*      */     
/*  443 */     this.jLabel52.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  444 */     this.jLabel52.setForeground(new Color(255, 255, 255));
/*  445 */     this.jLabel52.setHorizontalAlignment(0);
/*  446 */     this.jLabel52.setText("Entrada / Destino");
/*  447 */     this.jLabel52.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  449 */             AlmAlmacen.this.jLabel52MouseDragged(evt);
/*      */           }
/*      */         });
/*  452 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  454 */             AlmAlmacen.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  458 */     this.jPanel100.setBackground(this.lc.PRIMARIO1);
/*  459 */     this.jPanel100.setLayout(new GridLayout(1, 0));
/*      */     
/*  461 */     this.jLabel135.setHorizontalAlignment(0);
/*  462 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  463 */     this.jLabel135.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  465 */             AlmAlmacen.this.jLabel135MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  468 */             AlmAlmacen.this.jLabel135MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  471 */             AlmAlmacen.this.jLabel135MouseExited(evt);
/*      */           }
/*      */         });
/*  474 */     this.jPanel100.add(this.jLabel135);
/*      */     
/*  476 */     this.jLabel60.setHorizontalAlignment(0);
/*  477 */     this.jLabel60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/menu.png")));
/*      */     
/*  479 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/*  480 */     this.jPanel54.setLayout(jPanel54Layout);
/*  481 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/*  482 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  483 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  484 */           .addGap(1, 1, 1)
/*  485 */           .addComponent(this.jLabel60, -2, 36, -2)
/*  486 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  487 */           .addComponent(this.jLabel52, -1, -1, 32767)
/*  488 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  489 */           .addComponent(this.jPanel100, -2, 34, -2)));
/*      */     
/*  491 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/*  492 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  493 */         .addComponent(this.jPanel100, -1, -1, 32767)
/*  494 */         .addGroup(jPanel54Layout.createSequentialGroup()
/*  495 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  496 */             .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 30, 32767)
/*  497 */             .addComponent(this.jLabel52, -1, -1, 32767))
/*  498 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  501 */     this.jPanel2.setLayout(new GridLayout(5, 1, 0, 6));
/*      */     
/*  503 */     this.jPanel3.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  505 */     this.jPanel7.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  507 */     this.jLabel1.setText(" Cargar una orden de compra: ");
/*  508 */     this.jPanel7.add(this.jLabel1);
/*      */     
/*  510 */     this.jPanel13.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  512 */     this.jButton1.setText("Buscar...");
/*  513 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  515 */             AlmAlmacen.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*  518 */     this.jPanel13.add(this.jButton1);
/*      */     
/*  520 */     this.jLabel3.setHorizontalAlignment(2);
/*  521 */     this.jLabel3.setText("5 Prod");
/*  522 */     this.jPanel13.add(this.jLabel3);
/*      */     
/*  524 */     this.jPanel7.add(this.jPanel13);
/*      */     
/*  526 */     this.jPanel3.add(this.jPanel7);
/*      */     
/*  528 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  529 */     this.jPanel14.setLayout(jPanel14Layout);
/*  530 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  531 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  532 */         .addGap(0, 409, 32767));
/*      */     
/*  534 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  535 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  536 */         .addGap(0, 24, 32767));
/*      */ 
/*      */     
/*  539 */     this.jPanel3.add(this.jPanel14);
/*      */     
/*  541 */     this.jPanel2.add(this.jPanel3);
/*      */     
/*  543 */     this.jPanel5.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  545 */     this.jLabel26.setFont(new Font("Cantarell", 1, 12));
/*  546 */     this.jLabel26.setText(" Folio");
/*  547 */     this.jPanel5.add(this.jLabel26);
/*      */     
/*  549 */     this.jTextField4.setText("jTextField4");
/*  550 */     this.jTextField4.setEnabled(false);
/*  551 */     this.jPanel5.add(this.jTextField4);
/*      */     
/*  553 */     this.jLabel7.setFont(new Font("Cantarell", 1, 12));
/*  554 */     this.jLabel7.setHorizontalAlignment(0);
/*  555 */     this.jLabel7.setText("  Fecha");
/*  556 */     this.jPanel5.add(this.jLabel7);
/*      */     
/*  558 */     this.jDateChooser6.setDate(this.fechaActual);
/*  559 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  560 */     this.jDateChooser6.setIcon(this.icon);
/*  561 */     this.jDateChooser6.setMinSelectableDate(new Date(1257058862000L));
/*  562 */     this.jPanel5.add((Component)this.jDateChooser6);
/*      */     
/*  564 */     this.jPanel2.add(this.jPanel5);
/*      */     
/*  566 */     this.jPanel4.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  568 */     this.jLabel17.setFont(new Font("Cantarell", 1, 12));
/*  569 */     this.jLabel17.setText(" Sucursal");
/*  570 */     this.jPanel4.add(this.jLabel17);
/*      */     
/*  572 */     this.jComboBox5.setBackground(new Color(255, 255, 255));
/*  573 */     this.jPanel4.add(this.jComboBox5);
/*      */     
/*  575 */     this.jLabel6.setFont(new Font("Cantarell", 1, 12));
/*  576 */     this.jLabel6.setHorizontalAlignment(0);
/*  577 */     this.jLabel6.setText("  Área");
/*  578 */     this.jPanel4.add(this.jLabel6);
/*      */     
/*  580 */     this.jComboBox6.setBackground(new Color(255, 255, 255));
/*  581 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "AREA" }));
/*  582 */     this.jPanel4.add(this.jComboBox6);
/*      */     
/*  584 */     this.jPanel2.add(this.jPanel4);
/*      */     
/*  586 */     this.jPanel6.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  588 */     this.jLabel18.setFont(new Font("Cantarell", 1, 12));
/*  589 */     this.jLabel18.setText(" Tipo de Destino");
/*  590 */     this.jPanel6.add(this.jLabel18);
/*      */     
/*  592 */     this.jComboBox9.setBackground(new Color(255, 255, 255));
/*  593 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO" }));
/*  594 */     this.jPanel6.add(this.jComboBox9);
/*      */     
/*  596 */     this.jLabel27.setFont(new Font("Cantarell", 1, 12));
/*  597 */     this.jLabel27.setHorizontalAlignment(0);
/*  598 */     this.jLabel27.setText("  Recibe / Equipo / Asignado");
/*  599 */     this.jPanel6.add(this.jLabel27);
/*      */     
/*  601 */     this.jTextField5.setText("jTextField5");
/*  602 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  604 */             AlmAlmacen.this.jTextField5FocusLost(evt);
/*      */           }
/*      */         });
/*  607 */     this.jPanel6.add(this.jTextField5);
/*      */     
/*  609 */     this.jPanel2.add(this.jPanel6);
/*      */     
/*  611 */     this.jPanel8.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/*  613 */     this.jLabel28.setText(" Referencia");
/*  614 */     this.jPanel8.add(this.jLabel28);
/*      */     
/*  616 */     this.jTextField7.setText("OC VER-00929");
/*  617 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  619 */             AlmAlmacen.this.jTextField7FocusLost(evt);
/*      */           }
/*      */         });
/*  622 */     this.jPanel8.add(this.jTextField7);
/*      */     
/*  624 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  625 */     this.jPanel9.setLayout(jPanel9Layout);
/*  626 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  628 */         .addGap(0, 201, 32767));
/*      */     
/*  630 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  631 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  632 */         .addGap(0, 24, 32767));
/*      */ 
/*      */     
/*  635 */     this.jPanel8.add(this.jPanel9);
/*      */     
/*  637 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  638 */     this.jPanel10.setLayout(jPanel10Layout);
/*  639 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  641 */         .addGap(0, 201, 32767));
/*      */     
/*  643 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  644 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  645 */         .addGap(0, 24, 32767));
/*      */ 
/*      */     
/*  648 */     this.jPanel8.add(this.jPanel10);
/*      */     
/*  650 */     this.jPanel2.add(this.jPanel8);
/*      */     
/*  652 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Código", "Tipo", "Desc Interna", "Cant", "U / M", "Precio", "Costo", "Nuevo Stock" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  660 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  665 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  668 */     this.rSTableMetro2.setAltoHead(25);
/*  669 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  670 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  671 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  672 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  673 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  674 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  675 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  676 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  677 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  678 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  679 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  680 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  681 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  682 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  683 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  685 */             AlmAlmacen.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/*  688 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  690 */             AlmAlmacen.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/*  693 */     this.jScrollPane40.setViewportView((Component)this.rSTableMetro2);
/*      */     
/*  695 */     this.jButton52.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  696 */     this.jButton52.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  698 */             AlmAlmacen.this.jButton52ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  702 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  703 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  705 */             AlmAlmacen.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  709 */     this.jPanel11.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/*  711 */     this.jLabel33.setFont(new Font("Cantarell", 1, 12));
/*  712 */     this.jLabel33.setHorizontalAlignment(4);
/*  713 */     this.jLabel33.setText("Grupo de Productos");
/*  714 */     this.jPanel11.add(this.jLabel33);
/*      */     
/*  716 */     this.jTextField22.setHorizontalAlignment(4);
/*  717 */     this.jTextField22.setText("jTextField22");
/*  718 */     this.jTextField22.setEnabled(false);
/*  719 */     this.jPanel11.add(this.jTextField22);
/*      */     
/*  721 */     this.jLabel34.setFont(new Font("Cantarell", 1, 12));
/*  722 */     this.jLabel34.setHorizontalAlignment(4);
/*  723 */     this.jLabel34.setText("Total de Productos");
/*  724 */     this.jPanel11.add(this.jLabel34);
/*      */     
/*  726 */     this.jTextField23.setHorizontalAlignment(4);
/*  727 */     this.jTextField23.setText("jTextField23");
/*  728 */     this.jTextField23.setEnabled(false);
/*  729 */     this.jPanel11.add(this.jTextField23);
/*      */     
/*  731 */     this.jLabel29.setFont(new Font("Cantarell", 1, 12));
/*  732 */     this.jLabel29.setHorizontalAlignment(4);
/*  733 */     this.jLabel29.setText("Costo ");
/*  734 */     this.jPanel11.add(this.jLabel29);
/*      */     
/*  736 */     this.jTextField8.setHorizontalAlignment(4);
/*  737 */     this.jTextField8.setText("jTextField8");
/*  738 */     this.jTextField8.setEnabled(false);
/*  739 */     this.jPanel11.add(this.jTextField8);
/*      */     
/*  741 */     GridBagLayout jPanel12Layout = new GridBagLayout();
/*  742 */     jPanel12Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/*  743 */     jPanel12Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/*  744 */     this.jPanel12.setLayout(jPanel12Layout);
/*      */     
/*  746 */     this.jLabel4.setFont(new Font("Cantarell", 1, 12));
/*  747 */     this.jLabel4.setText(" Solicita");
/*  748 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  749 */     gridBagConstraints.gridx = 0;
/*  750 */     gridBagConstraints.gridy = 0;
/*  751 */     this.jPanel12.add(this.jLabel4, gridBagConstraints);
/*      */     
/*  753 */     this.jTextField9.setText("jTextField9");
/*  754 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  756 */             AlmAlmacen.this.jTextField9FocusGained(evt);
/*      */           }
/*      */         });
/*  759 */     gridBagConstraints = new GridBagConstraints();
/*  760 */     gridBagConstraints.gridx = 2;
/*  761 */     gridBagConstraints.gridy = 0;
/*  762 */     gridBagConstraints.fill = 2;
/*  763 */     gridBagConstraints.weightx = 1.0D;
/*  764 */     gridBagConstraints.insets = new Insets(0, 70, 0, 0);
/*  765 */     this.jPanel12.add(this.jTextField9, gridBagConstraints);
/*      */     
/*  767 */     this.jLabel5.setText(" Autoriza");
/*  768 */     gridBagConstraints = new GridBagConstraints();
/*  769 */     gridBagConstraints.gridx = 0;
/*  770 */     gridBagConstraints.gridy = 2;
/*  771 */     this.jPanel12.add(this.jLabel5, gridBagConstraints);
/*      */     
/*  773 */     this.jTextField10.setText("jTextField10");
/*  774 */     gridBagConstraints = new GridBagConstraints();
/*  775 */     gridBagConstraints.gridx = 2;
/*  776 */     gridBagConstraints.gridy = 2;
/*  777 */     gridBagConstraints.fill = 2;
/*  778 */     gridBagConstraints.weightx = 1.0D;
/*  779 */     gridBagConstraints.insets = new Insets(0, 70, 0, 0);
/*  780 */     this.jPanel12.add(this.jTextField10, gridBagConstraints);
/*      */     
/*  782 */     this.jLabel8.setText(" Entrega");
/*  783 */     gridBagConstraints = new GridBagConstraints();
/*  784 */     gridBagConstraints.gridx = 0;
/*  785 */     gridBagConstraints.gridy = 4;
/*  786 */     this.jPanel12.add(this.jLabel8, gridBagConstraints);
/*      */     
/*  788 */     this.jTextField11.setText("jTextField11");
/*  789 */     gridBagConstraints = new GridBagConstraints();
/*  790 */     gridBagConstraints.gridx = 2;
/*  791 */     gridBagConstraints.gridy = 4;
/*  792 */     gridBagConstraints.fill = 2;
/*  793 */     gridBagConstraints.weightx = 1.0D;
/*  794 */     gridBagConstraints.insets = new Insets(0, 70, 0, 0);
/*  795 */     this.jPanel12.add(this.jTextField11, gridBagConstraints);
/*      */     
/*  797 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder("[ Notas o comentarios ]"));
/*      */     
/*  799 */     this.jTextPane1.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  801 */             AlmAlmacen.this.jTextPane1FocusLost(evt);
/*      */           }
/*      */         });
/*  804 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*      */     
/*  806 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  807 */     this.jPanel18.setLayout(jPanel18Layout);
/*  808 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  809 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  810 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  811 */           .addContainerGap()
/*  812 */           .addComponent(this.jScrollPane1)
/*  813 */           .addContainerGap()));
/*      */     
/*  815 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  817 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  818 */           .addContainerGap()
/*  819 */           .addComponent(this.jScrollPane1, -1, 89, 32767)
/*  820 */           .addContainerGap()));
/*      */ 
/*      */     
/*  823 */     this.jPanel108.setBackground(this.lc.SECUNDARIO2);
/*      */     
/*  825 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  826 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  827 */     this.materialButton19.setMnemonic('C');
/*  828 */     this.materialButton19.setText("Cerrar");
/*  829 */     this.materialButton19.setToolTipText("Cerrar (Alt+C)");
/*  830 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  831 */     this.materialButton19.setHorizontalTextPosition(0);
/*  832 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  834 */             AlmAlmacen.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  838 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/*  839 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  840 */     this.materialButton20.setMnemonic('E');
/*  841 */     this.materialButton20.setText("Guardar");
/*  842 */     this.materialButton20.setToolTipText("Expedir CFDI (Alt+E)");
/*  843 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  844 */     this.materialButton20.setHorizontalTextPosition(0);
/*  845 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  847 */             AlmAlmacen.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  851 */     this.jComboBox12.setBackground(new Color(255, 255, 255));
/*  852 */     this.jComboBox12.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "<Autorizada>", "<Por Autorizar>", "CANCELADA" }));
/*      */     
/*  854 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/*  855 */     this.jPanel108.setLayout(jPanel108Layout);
/*  856 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/*  857 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  858 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  859 */           .addContainerGap()
/*  860 */           .addComponent(this.jComboBox12, -2, 195, -2)
/*  861 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  862 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/*  863 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  864 */           .addComponent((Component)this.materialButton19, -2, 105, -2)
/*  865 */           .addContainerGap()));
/*      */     
/*  867 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/*  868 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  869 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  870 */           .addGroup(jPanel108Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  871 */             .addComponent((Component)this.materialButton19, -2, 38, -2)
/*  872 */             .addComponent((Component)this.materialButton20, -2, 38, -2))
/*  873 */           .addGap(0, 6, 32767))
/*  874 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
/*  875 */           .addContainerGap(-1, 32767)
/*  876 */           .addComponent(this.jComboBox12, -2, -1, -2)
/*  877 */           .addContainerGap()));
/*      */ 
/*      */     
/*  880 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  881 */     this.jPanel1.setLayout(jPanel1Layout);
/*  882 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  883 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  884 */         .addComponent(this.jPanel54, -1, -1, 32767)
/*  885 */         .addComponent(this.jScrollPane40)
/*  886 */         .addComponent(this.jPanel12, -1, -1, 32767)
/*  887 */         .addComponent(this.jPanel18, -1, -1, 32767)
/*  888 */         .addComponent(this.jPanel108, -1, -1, 32767)
/*  889 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  890 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  891 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  892 */               .addContainerGap()
/*  893 */               .addComponent(this.jButton52)
/*  894 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  895 */               .addComponent(this.jButton53)
/*  896 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  897 */               .addComponent(this.jPanel11, -1, -1, 32767))
/*  898 */             .addComponent(this.jPanel2, -1, 825, 32767))
/*  899 */           .addContainerGap()));
/*      */     
/*  901 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  902 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  903 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  904 */           .addComponent(this.jPanel54, -2, -1, -2)
/*  905 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  906 */           .addComponent(this.jPanel2, -2, 148, -2)
/*  907 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  908 */           .addComponent(this.jScrollPane40, -2, 173, -2)
/*  909 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  910 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  911 */             .addComponent(this.jPanel11, -2, -1, -2)
/*  912 */             .addComponent(this.jButton52, -2, 26, -2)
/*  913 */             .addComponent(this.jButton53, -2, 26, -2))
/*  914 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  915 */           .addComponent(this.jPanel12, -2, 97, -2)
/*  916 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  917 */           .addComponent(this.jPanel18, -1, -1, 32767)
/*  918 */           .addGap(15, 15, 15)
/*  919 */           .addComponent(this.jPanel108, -2, -1, -2)));
/*      */ 
/*      */     
/*  922 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  923 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  924 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  926 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  928 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  929 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  930 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */ 
/*      */     
/*  933 */     this.jDialog2.setTitle("Requisiciones");
/*      */     
/*  935 */     this.materialButton44.setBackground(this.lc.PRIMARIO1);
/*  936 */     this.materialButton44.setForeground(new Color(255, 255, 255));
/*  937 */     this.materialButton44.setMnemonic('A');
/*  938 */     this.materialButton44.setText("Aceptar");
/*  939 */     this.materialButton44.setToolTipText("Aceptar (Alt+A)");
/*  940 */     this.materialButton44.setFont(new Font("Cantarell", 0, 12));
/*  941 */     this.materialButton44.setHorizontalTextPosition(0);
/*  942 */     this.materialButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  944 */             AlmAlmacen.this.materialButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  948 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  956 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  961 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  964 */     this.rSTableMetro3.setAltoHead(25);
/*  965 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  966 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  967 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  968 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  969 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  970 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  971 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  972 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  973 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  974 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  975 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  976 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  977 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  978 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  979 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  981 */             AlmAlmacen.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  984 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  986 */             AlmAlmacen.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  989 */     this.jScrollPane39.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  991 */     this.jPanel27.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  993 */     this.jLabel41.setText("Búsqueda de requisiciones");
/*  994 */     this.jPanel27.add(this.jLabel41);
/*      */     
/*  996 */     this.jPanel28.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  998 */     this.jTextField26.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1000 */             AlmAlmacen.this.jTextField26KeyReleased(evt);
/*      */           }
/*      */         });
/* 1003 */     this.jPanel28.add(this.jTextField26);
/*      */     
/* 1005 */     this.jTextField27.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1007 */             AlmAlmacen.this.jTextField27KeyReleased(evt);
/*      */           }
/*      */         });
/* 1010 */     this.jPanel28.add(this.jTextField27);
/*      */     
/* 1012 */     this.jPanel27.add(this.jPanel28);
/*      */     
/* 1014 */     this.jPanel29.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1016 */     this.jComboBox38.setBackground(new Color(255, 255, 255));
/* 1017 */     this.jComboBox38.setModel(new DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/* 1018 */     this.jComboBox38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1020 */             AlmAlmacen.this.jComboBox38ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1023 */     this.jPanel29.add(this.jComboBox38);
/*      */     
/* 1025 */     this.jComboBox39.setBackground(new Color(255, 255, 255));
/* 1026 */     this.jComboBox39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1028 */             AlmAlmacen.this.jComboBox39ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1031 */     this.jPanel29.add(this.jComboBox39);
/*      */     
/* 1033 */     this.jButton31.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 1034 */     this.jButton31.setMnemonic('F');
/* 1035 */     this.jButton31.setToolTipText("Filtrar información (Alt+F)");
/* 1036 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1038 */             AlmAlmacen.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1041 */     this.jPanel29.add(this.jButton31);
/*      */     
/* 1043 */     this.jPanel27.add(this.jPanel29);
/*      */     
/* 1045 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 1046 */     this.jPanel42.setLayout(jPanel42Layout);
/* 1047 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 1048 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1049 */         .addComponent(this.jPanel27, -2, 0, 32767)
/* 1050 */         .addComponent(this.jScrollPane39, -1, 785, 32767));
/*      */     
/* 1052 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 1053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1054 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 1055 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1056 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1057 */           .addComponent(this.jScrollPane39, -1, 253, 32767)
/* 1058 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1061 */     this.jPanel174.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 1063 */     this.jLabel236.setFont(new Font("Cantarell", 0, 13));
/* 1064 */     this.jLabel236.setForeground(this.lc.SECUNDARIO1);
/* 1065 */     this.jLabel236.setHorizontalAlignment(4);
/* 1066 */     this.jLabel236.setText("Total: ");
/* 1067 */     this.jPanel174.add(this.jLabel236);
/*      */     
/* 1069 */     this.jLabel80.setFont(new Font("Cantarell", 1, 13));
/* 1070 */     this.jLabel80.setForeground(this.lc.PRIMARIO1);
/* 1071 */     this.jLabel80.setHorizontalAlignment(0);
/* 1072 */     this.jLabel80.setText("t");
/* 1073 */     this.jPanel174.add(this.jLabel80);
/*      */     
/* 1075 */     GroupLayout jPanel173Layout = new GroupLayout(this.jPanel173);
/* 1076 */     this.jPanel173.setLayout(jPanel173Layout);
/* 1077 */     jPanel173Layout.setHorizontalGroup(jPanel173Layout
/* 1078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1079 */         .addGroup(jPanel173Layout.createSequentialGroup()
/* 1080 */           .addContainerGap()
/* 1081 */           .addComponent(this.jPanel174, -2, 131, -2)
/* 1082 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1083 */           .addComponent((Component)this.materialButton44, -2, 150, -2)
/* 1084 */           .addContainerGap())
/* 1085 */         .addComponent(this.jPanel42, -1, -1, 32767));
/*      */     
/* 1087 */     jPanel173Layout.setVerticalGroup(jPanel173Layout
/* 1088 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1089 */         .addGroup(jPanel173Layout.createSequentialGroup()
/* 1090 */           .addComponent(this.jPanel42, -1, -1, 32767)
/* 1091 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1092 */           .addGroup(jPanel173Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1093 */             .addComponent((Component)this.materialButton44, -1, 38, 32767)
/* 1094 */             .addComponent(this.jPanel174, -1, -1, 32767))
/* 1095 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1098 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1099 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1100 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */         .addComponent(this.jPanel173, -1, -1, 32767));
/*      */     
/* 1104 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1106 */         .addComponent(this.jPanel173, -1, -1, 32767));
/*      */ 
/*      */     
/* 1109 */     this.jDialog3.setTitle("Relacionar productos");
/*      */     
/* 1111 */     this.materialButton45.setBackground(this.lc.PRIMARIO1);
/* 1112 */     this.materialButton45.setForeground(new Color(255, 255, 255));
/* 1113 */     this.materialButton45.setMnemonic('A');
/* 1114 */     this.materialButton45.setText("Aceptar");
/* 1115 */     this.materialButton45.setToolTipText("Aceptar (Alt+A)");
/* 1116 */     this.materialButton45.setFont(new Font("Cantarell", 0, 12));
/* 1117 */     this.materialButton45.setHorizontalTextPosition(0);
/* 1118 */     this.materialButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1120 */             AlmAlmacen.this.materialButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1124 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Productos en la cotización", "Productos en el almacén", "Entrada", "Nuevo stock" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1132 */           Class[] types = new Class[] { Object.class, Object.class, Integer.class, Object.class };
/*      */ 
/*      */           
/* 1135 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 1140 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1144 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1147 */     this.rSTableMetro4.setAltoHead(25);
/* 1148 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1149 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/* 1150 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/* 1151 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1152 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/* 1153 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/* 1154 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/* 1155 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 13));
/* 1156 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 14));
/* 1157 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1158 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/* 1159 */     this.rSTableMetro4.setRowHeight(30);
/* 1160 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/* 1161 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/* 1162 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 1163 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1165 */             AlmAlmacen.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1168 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1170 */             AlmAlmacen.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1173 */     this.jScrollPane41.setViewportView((Component)this.rSTableMetro4);
/*      */     
/* 1175 */     this.jLabel9.setText("<html>\nRelaciona los productos de la requisición con los productos dentro del almacén, revisa cantidades , entradas y devoluciones:\n</html>");
/*      */     
/* 1177 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 1178 */     this.jPanel43.setLayout(jPanel43Layout);
/* 1179 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 1180 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1181 */         .addComponent(this.jScrollPane41)
/* 1182 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 1183 */           .addContainerGap()
/* 1184 */           .addComponent(this.jLabel9, -2, 0, 32767)
/* 1185 */           .addContainerGap()));
/*      */     
/* 1187 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 1188 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1189 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 1190 */           .addContainerGap()
/* 1191 */           .addComponent(this.jLabel9, -2, 47, -2)
/* 1192 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1193 */           .addComponent(this.jScrollPane41, -1, 184, 32767)));
/*      */ 
/*      */     
/* 1196 */     this.jPanel176.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 1198 */     this.jLabel237.setFont(new Font("Cantarell", 0, 13));
/* 1199 */     this.jLabel237.setForeground(this.lc.SECUNDARIO1);
/* 1200 */     this.jLabel237.setHorizontalAlignment(4);
/* 1201 */     this.jLabel237.setText("Articulos");
/* 1202 */     this.jPanel176.add(this.jLabel237);
/*      */     
/* 1204 */     this.jLabel81.setFont(new Font("Cantarell", 1, 13));
/* 1205 */     this.jLabel81.setForeground(this.lc.PRIMARIO1);
/* 1206 */     this.jLabel81.setHorizontalAlignment(0);
/* 1207 */     this.jLabel81.setText("t");
/* 1208 */     this.jPanel176.add(this.jLabel81);
/*      */     
/* 1210 */     this.jPanel177.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 1212 */     this.jLabel240.setFont(new Font("Cantarell", 0, 13));
/* 1213 */     this.jLabel240.setForeground(this.lc.SECUNDARIO1);
/* 1214 */     this.jLabel240.setHorizontalAlignment(4);
/* 1215 */     this.jLabel240.setText("Requisición");
/* 1216 */     this.jPanel177.add(this.jLabel240);
/*      */     
/* 1218 */     this.jLabel82.setFont(new Font("Cantarell", 1, 13));
/* 1219 */     this.jLabel82.setForeground(this.lc.PRIMARIO1);
/* 1220 */     this.jLabel82.setHorizontalAlignment(0);
/* 1221 */     this.jLabel82.setText("t");
/* 1222 */     this.jPanel177.add(this.jLabel82);
/*      */     
/* 1224 */     GroupLayout jPanel175Layout = new GroupLayout(this.jPanel175);
/* 1225 */     this.jPanel175.setLayout(jPanel175Layout);
/* 1226 */     jPanel175Layout.setHorizontalGroup(jPanel175Layout
/* 1227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1228 */         .addComponent(this.jPanel43, -1, -1, 32767)
/* 1229 */         .addGroup(jPanel175Layout.createSequentialGroup()
/* 1230 */           .addContainerGap()
/* 1231 */           .addComponent(this.jPanel176, -2, 131, -2)
/* 1232 */           .addGap(55, 55, 55)
/* 1233 */           .addComponent(this.jPanel177, -2, 220, -2)
/* 1234 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 171, 32767)
/* 1235 */           .addComponent((Component)this.materialButton45, -2, 150, -2)
/* 1236 */           .addContainerGap()));
/*      */     
/* 1238 */     jPanel175Layout.setVerticalGroup(jPanel175Layout
/* 1239 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1240 */         .addGroup(jPanel175Layout.createSequentialGroup()
/* 1241 */           .addComponent(this.jPanel43, -1, -1, 32767)
/* 1242 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1243 */           .addGroup(jPanel175Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1244 */             .addComponent((Component)this.materialButton45, -1, 38, 32767)
/* 1245 */             .addComponent(this.jPanel176, -1, -1, 32767)
/* 1246 */             .addComponent(this.jPanel177, -1, -1, 32767))
/* 1247 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1250 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1251 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1252 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1253 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1254 */         .addComponent(this.jPanel175, -1, -1, 32767));
/*      */     
/* 1256 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1257 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1258 */         .addComponent(this.jPanel175, -1, -1, 32767));
/*      */ 
/*      */     
/* 1261 */     this.jDialog4.setTitle("Entrada o Salida");
/*      */     
/* 1263 */     this.jPanel21.setPreferredSize(new Dimension(90, 0));
/*      */     
/* 1265 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 1266 */     this.jPanel21.setLayout(jPanel21Layout);
/* 1267 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 1268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1269 */         .addGap(0, 90, 32767));
/*      */     
/* 1271 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 1272 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1273 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/* 1276 */     this.jPanel22.setPreferredSize(new Dimension(90, 0));
/*      */     
/* 1278 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 1279 */     this.jPanel22.setLayout(jPanel22Layout);
/* 1280 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 1281 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1282 */         .addGap(0, 90, 32767));
/*      */     
/* 1284 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 1285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1286 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/* 1289 */     this.jPanel37.setLayout(new GridLayout(1, 3, 40, 0));
/*      */     
/* 1291 */     this.jPanel38.setBackground(this.lc.SECUNDARIO2);
/* 1292 */     this.jPanel38.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 1293 */     this.jPanel38.addMouseListener(new MouseAdapter() {
/*      */           public void mouseExited(MouseEvent evt) {
/* 1295 */             AlmAlmacen.this.jPanel38MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1298 */             AlmAlmacen.this.jPanel38MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1302 */     this.jLabel30.setHorizontalAlignment(0);
/* 1303 */     this.jLabel30.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/inventory.png")));
/* 1304 */     this.jLabel30.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1306 */             AlmAlmacen.this.jLabel30MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1309 */             AlmAlmacen.this.jLabel30MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1312 */             AlmAlmacen.this.jLabel30MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1316 */     this.jLabel31.setFont(new Font("Cantarell", 1, 13));
/* 1317 */     this.jLabel31.setForeground(this.lc.PRIMARIO1);
/* 1318 */     this.jLabel31.setHorizontalAlignment(0);
/* 1319 */     this.jLabel31.setText("<html><center>Recepcionar Productos</center></html>");
/*      */     
/* 1321 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1322 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1323 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1324 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1325 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1326 */           .addContainerGap()
/* 1327 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1328 */             .addComponent(this.jLabel30, -1, -1, 32767)
/* 1329 */             .addComponent(this.jLabel31, -1, 155, 32767))
/* 1330 */           .addContainerGap()));
/*      */     
/* 1332 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1334 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1335 */           .addContainerGap()
/* 1336 */           .addComponent(this.jLabel30, -2, 89, -2)
/* 1337 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1338 */           .addComponent(this.jLabel31, -1, 57, 32767)
/* 1339 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1342 */     this.jPanel37.add(this.jPanel38);
/*      */     
/* 1344 */     this.jPanel39.setBackground(this.lc.SECUNDARIO2);
/* 1345 */     this.jPanel39.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*      */     
/* 1347 */     this.jLabel32.setHorizontalAlignment(0);
/* 1348 */     this.jLabel32.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/warehouse(1).png")));
/* 1349 */     this.jLabel32.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1351 */             AlmAlmacen.this.jLabel32MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1354 */             AlmAlmacen.this.jLabel32MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1357 */             AlmAlmacen.this.jLabel32MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1361 */     this.jLabel50.setFont(new Font("Cantarell", 1, 13));
/* 1362 */     this.jLabel50.setForeground(this.lc.PRIMARIO1);
/* 1363 */     this.jLabel50.setHorizontalAlignment(0);
/* 1364 */     this.jLabel50.setText("<html><center>Salida de Productos</center></html>");
/*      */     
/* 1366 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 1367 */     this.jPanel39.setLayout(jPanel39Layout);
/* 1368 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 1369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1370 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1371 */           .addContainerGap()
/* 1372 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1373 */             .addComponent(this.jLabel32, -1, -1, 32767)
/* 1374 */             .addComponent(this.jLabel50, -1, 155, 32767))
/* 1375 */           .addContainerGap()));
/*      */     
/* 1377 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 1378 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1379 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1380 */           .addContainerGap()
/* 1381 */           .addComponent(this.jLabel32, -2, 89, -2)
/* 1382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1383 */           .addComponent(this.jLabel50, -1, 57, 32767)
/* 1384 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1387 */     this.jPanel37.add(this.jPanel39);
/*      */     
/* 1389 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1390 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1391 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1392 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1393 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
/* 1394 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 1395 */           .addGap(7, 7, 7)
/* 1396 */           .addComponent(this.jPanel37, -1, -1, 32767)
/* 1397 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1398 */           .addComponent(this.jPanel22, -2, -1, -2)));
/*      */     
/* 1400 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1402 */         .addComponent(this.jPanel21, GroupLayout.Alignment.TRAILING, -1, 371, 32767)
/* 1403 */         .addComponent(this.jPanel22, -1, 371, 32767)
/* 1404 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1405 */           .addGap(77, 77, 77)
/* 1406 */           .addComponent(this.jPanel37, -2, 166, -2)
/* 1407 */           .addContainerGap(128, 32767)));
/*      */ 
/*      */     
/* 1410 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1411 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1412 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1413 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1414 */         .addComponent(this.jPanel20, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1416 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1418 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 1419 */           .addGap(0, 0, 0)
/* 1420 */           .addComponent(this.jPanel20, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1423 */     this.jDialog5.setTitle("Búsqueda de productos");
/*      */     
/* 1425 */     this.materialButton46.setBackground(this.lc.PRIMARIO1);
/* 1426 */     this.materialButton46.setForeground(new Color(255, 255, 255));
/* 1427 */     this.materialButton46.setMnemonic('E');
/* 1428 */     this.materialButton46.setText("Entrada");
/* 1429 */     this.materialButton46.setToolTipText("Entrada (Alt+E)");
/* 1430 */     this.materialButton46.setFont(new Font("Cantarell", 0, 12));
/* 1431 */     this.materialButton46.setHorizontalTextPosition(0);
/* 1432 */     this.materialButton46.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1434 */             AlmAlmacen.this.materialButton46ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1438 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Moneda", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1446 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1451 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1454 */     this.rSTableMetro5.setAltoHead(25);
/* 1455 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1456 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/* 1457 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/* 1458 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1459 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/* 1460 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/* 1461 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/* 1462 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1463 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1464 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1465 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/* 1466 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/* 1467 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/* 1468 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/* 1469 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1471 */             AlmAlmacen.this.rSTableMetro5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1474 */             AlmAlmacen.this.rSTableMetro5MouseEntered(evt);
/*      */           }
/*      */         });
/* 1477 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1479 */             AlmAlmacen.this.rSTableMetro5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1482 */     this.jScrollPane42.setViewportView((Component)this.rSTableMetro5);
/*      */     
/* 1484 */     this.jPanel35.setBackground(this.lc.SECUNDARIO2);
/* 1485 */     this.jPanel35.setLayout(new GridLayout(1, 7, 6, 0));
/*      */     
/* 1487 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1489 */             AlmAlmacen.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/* 1492 */     this.jPanel35.add(this.jTextField12);
/*      */     
/* 1494 */     this.jTextField13.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1496 */             AlmAlmacen.this.jTextField13KeyReleased(evt);
/*      */           }
/*      */         });
/* 1499 */     this.jPanel35.add(this.jTextField13);
/*      */     
/* 1501 */     this.jTextField14.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1503 */             AlmAlmacen.this.jTextField14KeyReleased(evt);
/*      */           }
/*      */         });
/* 1506 */     this.jPanel35.add(this.jTextField14);
/*      */     
/* 1508 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1509 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "STOCK", "POR DEBAJO", "POR ARRIBA", "DISPONIBLES", "SIN EXISTENCIAS" }));
/* 1510 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1512 */             AlmAlmacen.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1515 */     this.jPanel35.add(this.jComboBox4);
/*      */     
/* 1517 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 1518 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO: ALMACENABLE Y CONSUMIBLE", "ALMACENABLE", "CONSUMIBLE", "SERVICIO" }));
/* 1519 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1521 */             AlmAlmacen.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1524 */     this.jPanel35.add(this.jComboBox10);
/*      */     
/* 1526 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 1527 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "CATEGORÍA" }));
/* 1528 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1530 */             AlmAlmacen.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1533 */     this.jPanel35.add(this.jComboBox11);
/*      */     
/* 1535 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 1536 */     this.jPanel44.setLayout(jPanel44Layout);
/* 1537 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 1538 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1539 */         .addComponent(this.jScrollPane42, -1, 863, 32767)
/* 1540 */         .addComponent(this.jPanel35, -2, 0, 32767));
/*      */     
/* 1542 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 1543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1544 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 1545 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1546 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1547 */           .addComponent(this.jScrollPane42, -1, 344, 32767)));
/*      */ 
/*      */     
/* 1550 */     this.jPanel179.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 1552 */     this.jLabel241.setFont(new Font("Cantarell", 0, 13));
/* 1553 */     this.jLabel241.setForeground(this.lc.SECUNDARIO1);
/* 1554 */     this.jLabel241.setHorizontalAlignment(4);
/* 1555 */     this.jLabel241.setText("Total: ");
/* 1556 */     this.jPanel179.add(this.jLabel241);
/*      */     
/* 1558 */     this.jLabel83.setFont(new Font("Cantarell", 1, 13));
/* 1559 */     this.jLabel83.setForeground(this.lc.PRIMARIO1);
/* 1560 */     this.jLabel83.setHorizontalAlignment(0);
/* 1561 */     this.jLabel83.setText("t");
/* 1562 */     this.jPanel179.add(this.jLabel83);
/*      */     
/* 1564 */     this.materialButton47.setBackground(this.lc.PRIMARIO1);
/* 1565 */     this.materialButton47.setForeground(new Color(255, 255, 255));
/* 1566 */     this.materialButton47.setMnemonic('A');
/* 1567 */     this.materialButton47.setText("Agregar nuevos productos al catalogo");
/* 1568 */     this.materialButton47.setToolTipText("Aceptar (Alt+A)");
/* 1569 */     this.materialButton47.setFont(new Font("Cantarell", 0, 12));
/* 1570 */     this.materialButton47.setHorizontalTextPosition(0);
/* 1571 */     this.materialButton47.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1573 */             AlmAlmacen.this.materialButton47ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1577 */     this.materialButton48.setBackground(this.lc.PRIMARIO1);
/* 1578 */     this.materialButton48.setForeground(new Color(255, 255, 255));
/* 1579 */     this.materialButton48.setMnemonic('E');
/* 1580 */     this.materialButton48.setText("Ver Producto");
/* 1581 */     this.materialButton48.setToolTipText("Entrada (Alt+E)");
/* 1582 */     this.materialButton48.setFont(new Font("Cantarell", 0, 12));
/* 1583 */     this.materialButton48.setHorizontalTextPosition(0);
/* 1584 */     this.materialButton48.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1586 */             AlmAlmacen.this.materialButton48ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1590 */     GroupLayout jPanel178Layout = new GroupLayout(this.jPanel178);
/* 1591 */     this.jPanel178.setLayout(jPanel178Layout);
/* 1592 */     jPanel178Layout.setHorizontalGroup(jPanel178Layout
/* 1593 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1594 */         .addComponent(this.jPanel44, -1, -1, 32767)
/* 1595 */         .addGroup(jPanel178Layout.createSequentialGroup()
/* 1596 */           .addContainerGap()
/* 1597 */           .addComponent(this.jPanel179, -2, 131, -2)
/* 1598 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1599 */           .addComponent((Component)this.materialButton47, -2, 294, -2)
/* 1600 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1601 */           .addComponent((Component)this.materialButton48, -2, 150, -2)
/* 1602 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1603 */           .addComponent((Component)this.materialButton46, -2, 150, -2)
/* 1604 */           .addContainerGap()));
/*      */     
/* 1606 */     jPanel178Layout.setVerticalGroup(jPanel178Layout
/* 1607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1608 */         .addGroup(jPanel178Layout.createSequentialGroup()
/* 1609 */           .addComponent(this.jPanel44, -1, -1, 32767)
/* 1610 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1611 */           .addGroup(jPanel178Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1612 */             .addGroup(jPanel178Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1613 */               .addComponent((Component)this.materialButton46, -1, 38, 32767)
/* 1614 */               .addComponent((Component)this.materialButton47, -1, 38, 32767)
/* 1615 */               .addComponent((Component)this.materialButton48, -1, 38, 32767))
/* 1616 */             .addComponent(this.jPanel179, -1, -1, 32767))
/* 1617 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1620 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1621 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1622 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1624 */         .addComponent(this.jPanel178, -1, -1, 32767));
/*      */     
/* 1626 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1628 */         .addComponent(this.jPanel178, -1, -1, 32767));
/*      */ 
/*      */     
/* 1631 */     this.jDialog6.setTitle("Cantidades del producto");
/*      */     
/* 1633 */     this.jPanel24.setLayout(new GridLayout(7, 2, 6, 6));
/*      */     
/* 1635 */     this.jLabel11.setText(" Descripción Interna");
/* 1636 */     this.jPanel24.add(this.jLabel11);
/*      */     
/* 1638 */     this.jTextField16.setText("jTextField16");
/* 1639 */     this.jTextField16.setEnabled(false);
/* 1640 */     this.jPanel24.add(this.jTextField16);
/*      */     
/* 1642 */     this.jLabel12.setText(" Refercia Interna o Código");
/* 1643 */     this.jPanel24.add(this.jLabel12);
/*      */     
/* 1645 */     this.jTextField17.setText("jTextField17");
/* 1646 */     this.jTextField17.setEnabled(false);
/* 1647 */     this.jPanel24.add(this.jTextField17);
/*      */     
/* 1649 */     this.jLabel13.setText(" Cantidad");
/* 1650 */     this.jPanel24.add(this.jLabel13);
/*      */     
/* 1652 */     this.jSpinner2.setModel(new SpinnerNumberModel(Double.valueOf(1.0D), Double.valueOf(0.001D), null, Double.valueOf(1.0D)));
/* 1653 */     this.jSpinner2.addChangeListener(new ChangeListener() {
/*      */           public void stateChanged(ChangeEvent evt) {
/* 1655 */             AlmAlmacen.this.jSpinner2StateChanged(evt);
/*      */           }
/*      */         });
/* 1658 */     this.jPanel24.add(this.jSpinner2);
/*      */     
/* 1660 */     this.jLabel14.setText(" Unidad de Medida");
/* 1661 */     this.jPanel24.add(this.jLabel14);
/*      */     
/* 1663 */     this.jTextField18.setText("jTextField18");
/* 1664 */     this.jTextField18.setEnabled(false);
/* 1665 */     this.jPanel24.add(this.jTextField18);
/*      */     
/* 1667 */     this.jLabel15.setText(" Precio");
/* 1668 */     this.jPanel24.add(this.jLabel15);
/*      */     
/* 1670 */     this.jTextField19.setHorizontalAlignment(4);
/* 1671 */     this.jTextField19.setText("jTextField19");
/* 1672 */     this.jTextField19.setEnabled(false);
/* 1673 */     this.jPanel24.add(this.jTextField19);
/*      */     
/* 1675 */     this.jLabel19.setText(" Costo");
/* 1676 */     this.jPanel24.add(this.jLabel19);
/*      */     
/* 1678 */     this.jTextField21.setHorizontalAlignment(4);
/* 1679 */     this.jTextField21.setText("jTextField21");
/* 1680 */     this.jPanel24.add(this.jTextField21);
/*      */     
/* 1682 */     this.jLabel16.setText(" Nuevo Stock");
/* 1683 */     this.jPanel24.add(this.jLabel16);
/*      */     
/* 1685 */     this.jTextField20.setHorizontalAlignment(4);
/* 1686 */     this.jTextField20.setText("jTextField20");
/* 1687 */     this.jTextField20.setEnabled(false);
/* 1688 */     this.jPanel24.add(this.jTextField20);
/*      */     
/* 1690 */     this.jPanel109.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1692 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 1693 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 1694 */     this.materialButton21.setMnemonic('C');
/* 1695 */     this.materialButton21.setText("Cerrar");
/* 1696 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/* 1697 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 1698 */     this.materialButton21.setHorizontalTextPosition(0);
/* 1699 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1701 */             AlmAlmacen.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1705 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/* 1706 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 1707 */     this.materialButton22.setMnemonic('A');
/* 1708 */     this.materialButton22.setText("Agregar");
/* 1709 */     this.materialButton22.setToolTipText("Agregar (Alt+A)");
/* 1710 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 1711 */     this.materialButton22.setHorizontalTextPosition(0);
/* 1712 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1714 */             AlmAlmacen.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1718 */     GroupLayout jPanel109Layout = new GroupLayout(this.jPanel109);
/* 1719 */     this.jPanel109.setLayout(jPanel109Layout);
/* 1720 */     jPanel109Layout.setHorizontalGroup(jPanel109Layout
/* 1721 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1722 */         .addGroup(jPanel109Layout.createSequentialGroup()
/* 1723 */           .addContainerGap(-1, 32767)
/* 1724 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/* 1725 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1726 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/* 1727 */           .addContainerGap()));
/*      */     
/* 1729 */     jPanel109Layout.setVerticalGroup(jPanel109Layout
/* 1730 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1731 */         .addGroup(jPanel109Layout.createSequentialGroup()
/* 1732 */           .addGroup(jPanel109Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1733 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 1734 */             .addComponent((Component)this.materialButton22, -2, 38, -2))
/* 1735 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/* 1738 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 1739 */     this.jPanel23.setLayout(jPanel23Layout);
/* 1740 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 1741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1742 */         .addComponent(this.jPanel24, -1, 483, 32767)
/* 1743 */         .addComponent(this.jPanel109, -1, -1, 32767));
/*      */     
/* 1745 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 1746 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1747 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 1748 */           .addComponent(this.jPanel24, -2, -1, -2)
/* 1749 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, 32767)
/* 1750 */           .addComponent(this.jPanel109, -2, -1, -2)));
/*      */ 
/*      */     
/* 1753 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1754 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1755 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1757 */         .addComponent(this.jPanel23, -1, -1, 32767));
/*      */     
/* 1759 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1760 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1761 */         .addComponent(this.jPanel23, -1, -1, 32767));
/*      */ 
/*      */     
/* 1764 */     this.jDialog7.setTitle("Tipo de reporte");
/*      */     
/* 1766 */     this.jPanel25.setLayout(new GridLayout(3, 1, 6, 6));
/*      */     
/* 1768 */     this.jRadioButton1.setSelected(true);
/* 1769 */     this.jRadioButton1.setText("Consumo por Bases y Áreas Anual");
/* 1770 */     this.jPanel25.add(this.jRadioButton1);
/*      */     
/* 1772 */     this.jRadioButton3.setText("Conusmo por Áreas y Equipo Anual");
/* 1773 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1775 */             AlmAlmacen.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1778 */     this.jPanel25.add(this.jRadioButton3);
/*      */     
/* 1780 */     this.jRadioButton2.setText("Vista Actual o detallado");
/* 1781 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1783 */             AlmAlmacen.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1786 */     this.jPanel25.add(this.jRadioButton2);
/*      */     
/* 1788 */     this.materialButton49.setBackground(this.lc.PRIMARIO1);
/* 1789 */     this.materialButton49.setForeground(new Color(255, 255, 255));
/* 1790 */     this.materialButton49.setMnemonic('I');
/* 1791 */     this.materialButton49.setText("Imprimir");
/* 1792 */     this.materialButton49.setToolTipText("Imprimir (Alt+I)");
/* 1793 */     this.materialButton49.setFont(new Font("Cantarell", 0, 12));
/* 1794 */     this.materialButton49.setHorizontalTextPosition(0);
/* 1795 */     this.materialButton49.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1797 */             AlmAlmacen.this.materialButton49ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1801 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1802 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1803 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1804 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1805 */         .addComponent(this.jPanel25, -1, 364, 32767)
/* 1806 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog7Layout.createSequentialGroup()
/* 1807 */           .addContainerGap(-1, 32767)
/* 1808 */           .addComponent((Component)this.materialButton49, -2, 150, -2)
/* 1809 */           .addContainerGap())
/* 1810 */         .addComponent(this.jSeparator1));
/*      */     
/* 1812 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1814 */         .addGroup(jDialog7Layout.createSequentialGroup()
/* 1815 */           .addComponent(this.jPanel25, -1, -1, 32767)
/* 1816 */           .addGap(18, 18, 18)
/* 1817 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1818 */           .addGap(3, 3, 3)
/* 1819 */           .addComponent((Component)this.materialButton49, -2, 38, -2)
/* 1820 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1823 */     this.jDialog8.setTitle("Tipo de reporte");
/*      */     
/* 1825 */     this.materialButton50.setBackground(this.lc.PRIMARIO1);
/* 1826 */     this.materialButton50.setForeground(new Color(255, 255, 255));
/* 1827 */     this.materialButton50.setMnemonic('I');
/* 1828 */     this.materialButton50.setText("Cerrar");
/* 1829 */     this.materialButton50.setToolTipText("Imprimir (Alt+I)");
/* 1830 */     this.materialButton50.setFont(new Font("Cantarell", 0, 12));
/* 1831 */     this.materialButton50.setHorizontalTextPosition(0);
/* 1832 */     this.materialButton50.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1834 */             AlmAlmacen.this.materialButton50ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1838 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Mes", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1846 */     this.jScrollPane3.setViewportView(this.jTable1);
/*      */     
/* 1848 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Ene", "Feb", "Mar", "Abri", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1856 */     this.jScrollPane4.setViewportView(this.jTable2);
/*      */     
/* 1858 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Base", "Area", "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1866 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1868 */             AlmAlmacen.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1871 */     this.jScrollPane5.setViewportView(this.jTable3);
/*      */     
/* 1873 */     this.jLabel20.setText("jLabel1");
/*      */     
/* 1875 */     this.jLabel21.setText("jLabel1");
/*      */     
/* 1877 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 1878 */     this.jPanel26.setLayout(jPanel26Layout);
/* 1879 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 1880 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1881 */         .addComponent(this.jScrollPane3, -1, 1387, 32767)
/* 1882 */         .addComponent(this.jScrollPane5)
/* 1883 */         .addComponent(this.jScrollPane4)
/* 1884 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1885 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1886 */             .addComponent(this.jLabel20, -2, 295, -2)
/* 1887 */             .addComponent(this.jLabel21, -2, 295, -2))
/* 1888 */           .addGap(0, 0, 32767)));
/*      */     
/* 1890 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 1891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1892 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1893 */           .addComponent(this.jScrollPane3, -2, 198, -2)
/* 1894 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1895 */           .addComponent(this.jScrollPane4, -2, 230, -2)
/* 1896 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1897 */           .addComponent(this.jLabel20)
/* 1898 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1899 */           .addComponent(this.jScrollPane5, -1, 402, 32767)
/* 1900 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1901 */           .addComponent(this.jLabel21)
/* 1902 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1905 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 1906 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 1907 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 1908 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1909 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog8Layout.createSequentialGroup()
/* 1910 */           .addContainerGap(1231, 32767)
/* 1911 */           .addComponent((Component)this.materialButton50, -2, 150, -2)
/* 1912 */           .addContainerGap())
/* 1913 */         .addComponent(this.jPanel26, -1, -1, 32767));
/*      */     
/* 1915 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 1916 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1917 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 1918 */           .addComponent(this.jPanel26, -1, -1, 32767)
/* 1919 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1920 */           .addComponent((Component)this.materialButton50, -2, 38, -2)
/* 1921 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1924 */     this.jLabel2.setHorizontalAlignment(0);
/* 1925 */     this.jLabel2.setText("VER-00929");
/*      */     
/* 1927 */     this.jLabel10.setText("Ingresa la cantidad de entrada: ");
/*      */     
/* 1929 */     this.jSpinner1.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
/*      */     
/* 1931 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 1932 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1933 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 1934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1935 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1936 */           .addComponent(this.jLabel10, -2, 214, -2)
/* 1937 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1938 */           .addComponent(this.jSpinner1, -2, 115, -2)
/* 1939 */           .addGap(0, 11, 32767)));
/*      */     
/* 1941 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 1942 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1943 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1944 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1945 */             .addComponent(this.jLabel10)
/* 1946 */             .addComponent(this.jSpinner1, -2, -1, -2))
/* 1947 */           .addGap(0, 9, 32767)));
/*      */ 
/*      */     
/* 1950 */     this.jTextField24.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1952 */             AlmAlmacen.this.jTextField24KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1956 */     this.jPanel159.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1958 */     this.jPanel168.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 1960 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/* 1961 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Requisiciones", 0, 1, new Font("Cantarell", 0, 11)));
/* 1962 */     this.jPanel17.setMaximumSize(new Dimension(978, 32767));
/* 1963 */     this.jPanel17.setPreferredSize(new Dimension(978, 71));
/* 1964 */     this.jPanel17.setLayout(new GridLayout(1, 9, 6, 0));
/*      */     
/* 1966 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1967 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO DE ORDEN", "ENTRADA", "SALIDA" }));
/* 1968 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1970 */             AlmAlmacen.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1973 */     this.jPanel17.add(this.jComboBox7);
/*      */     
/* 1975 */     this.jPanel30.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1977 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1979 */             AlmAlmacen.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1982 */     this.jPanel30.add(this.jTextField6);
/*      */     
/* 1984 */     this.jPanel17.add(this.jPanel30);
/*      */     
/* 1986 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1988 */             AlmAlmacen.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 1991 */     this.jPanel17.add(this.jTextField1);
/*      */     
/* 1993 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1995 */             AlmAlmacen.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1998 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2000 */             AlmAlmacen.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/* 2003 */     this.jPanel17.add(this.jTextField3);
/*      */     
/* 2005 */     this.jTextField15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2007 */             AlmAlmacen.this.jTextField15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2010 */     this.jTextField15.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2012 */             AlmAlmacen.this.jTextField15KeyReleased(evt);
/*      */           }
/*      */         });
/* 2015 */     this.jPanel17.add(this.jTextField15);
/*      */     
/* 2017 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2019 */             AlmAlmacen.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2022 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2024 */             AlmAlmacen.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2027 */     this.jPanel17.add(this.jTextField2);
/*      */     
/* 2029 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 2030 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO" }));
/* 2031 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2033 */             AlmAlmacen.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2036 */     this.jPanel17.add(this.jComboBox8);
/*      */     
/* 2038 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2039 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ÁREA" }));
/* 2040 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2042 */             AlmAlmacen.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2045 */     this.jPanel17.add(this.jComboBox3);
/*      */     
/* 2047 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/* 2048 */     this.jComboBox23.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL" }));
/* 2049 */     this.jComboBox23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2051 */             AlmAlmacen.this.jComboBox23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2054 */     this.jPanel17.add(this.jComboBox23);
/*      */     
/* 2056 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/* 2057 */     this.jComboBox24.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "<Por Autorizar>", "<Autorizada>", "CANCELADA" }));
/* 2058 */     this.jComboBox24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2060 */             AlmAlmacen.this.jComboBox24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2063 */     this.jPanel17.add(this.jComboBox24);
/*      */     
/* 2065 */     this.jPanel169.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 2067 */     this.jPanel170.setBackground(this.lc.SECUNDARIO2);
/* 2068 */     this.jPanel170.setLayout(new GridLayout(1, 9, 6, 0));
/*      */     
/* 2070 */     this.jPanel171.setBackground(this.lc.SECUNDARIO1);
/* 2071 */     this.jPanel171.setLayout(new GridLayout(1, 2, 3, 0));
/*      */     
/* 2073 */     this.jLabel235.setFont(new Font("Cantarell", 0, 13));
/* 2074 */     this.jLabel235.setForeground(this.lc.TERCERO1);
/* 2075 */     this.jLabel235.setHorizontalAlignment(4);
/* 2076 */     this.jLabel235.setText("Total: ");
/* 2077 */     this.jPanel171.add(this.jLabel235);
/*      */     
/* 2079 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 2080 */     this.jLabel48.setForeground(this.lc.PRIMARIO2);
/* 2081 */     this.jLabel48.setHorizontalAlignment(0);
/* 2082 */     this.jLabel48.setText("t");
/* 2083 */     this.jPanel171.add(this.jLabel48);
/*      */     
/* 2085 */     this.jPanel170.add(this.jPanel171);
/*      */     
/* 2087 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 2088 */     this.jButton24.setMnemonic('N');
/* 2089 */     this.jButton24.setText("Nueva");
/* 2090 */     this.jButton24.setToolTipText("Crear nuevas Requisiciones (Alt+N)");
/* 2091 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2093 */             AlmAlmacen.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2096 */     this.jPanel170.add(this.jButton24);
/*      */     
/* 2098 */     this.jButton60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 2099 */     this.jButton60.setMnemonic('M');
/* 2100 */     this.jButton60.setText("Modifcar");
/* 2101 */     this.jButton60.setToolTipText("Modificar Requisiciones (Alt+M)");
/* 2102 */     this.jButton60.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2104 */             AlmAlmacen.this.jButton60ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2107 */     this.jPanel170.add(this.jButton60);
/*      */     
/* 2109 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 2110 */     this.jButton25.setMnemonic('C');
/* 2111 */     this.jButton25.setText("Cancelar");
/* 2112 */     this.jButton25.setToolTipText("Cancelar Requisiciones (Alt+C)");
/* 2113 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2115 */             AlmAlmacen.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2118 */     this.jPanel170.add(this.jButton25);
/*      */     
/* 2120 */     this.jButton18.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/* 2121 */     this.jButton18.setMnemonic('A');
/* 2122 */     this.jButton18.setText("Autorizar");
/* 2123 */     this.jButton18.setToolTipText("Autorizar Requisiciones (Alt +A)");
/* 2124 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2126 */             AlmAlmacen.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2129 */     this.jPanel170.add(this.jButton18);
/*      */     
/* 2131 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2132 */     this.jButton26.setMnemonic('G');
/* 2133 */     this.jButton26.setText("Guardar Reporte");
/* 2134 */     this.jButton26.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 2135 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2137 */             AlmAlmacen.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2140 */     this.jPanel170.add(this.jButton26);
/*      */     
/* 2142 */     this.jButton15.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2143 */     this.jButton15.setMnemonic('I');
/* 2144 */     this.jButton15.setText("Imprimir");
/* 2145 */     this.jButton15.setToolTipText("Imprimir (Alt+I)");
/* 2146 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2148 */             AlmAlmacen.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2151 */     this.jPanel170.add(this.jButton15);
/*      */     
/* 2153 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2155 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 2156 */     this.jPanel15.setLayout(jPanel15Layout);
/* 2157 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 2158 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2159 */         .addGap(0, 122, 32767));
/*      */     
/* 2161 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 2162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2163 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 2166 */     this.jPanel170.add(this.jPanel15);
/*      */     
/* 2168 */     this.jPanel16.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2170 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2171 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2172 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 2173 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2174 */         .addGap(0, 122, 32767));
/*      */     
/* 2176 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 2177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2178 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 2181 */     this.jPanel170.add(this.jPanel16);
/*      */     
/* 2183 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "ID", "Fecha", "Proveedor", "Mercancia", "Sub", "Iva", "Total", "Condiciones", "Dias", "Estatus", "Sucursal", "Area", "Uso", "Actualizacion" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2191 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2196 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2199 */     this.rSTableMetro1.setAltoHead(40);
/* 2200 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2201 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 2202 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 2203 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2204 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 2205 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 2206 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 2207 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2208 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2209 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2210 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 2211 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 2212 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 2213 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2214 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2216 */             AlmAlmacen.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 2219 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2221 */             AlmAlmacen.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2224 */     this.jScrollPane29.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 2226 */     this.jPanel151.setBorder(BorderFactory.createBevelBorder(1));
/* 2227 */     this.jPanel151.setLayout(new GridLayout(1, 12, 6, 0));
/*      */     
/* 2229 */     this.jLabel217.setFont(new Font("Tahoma", 0, 12));
/* 2230 */     this.jLabel217.setHorizontalAlignment(4);
/* 2231 */     this.jLabel217.setText("VALOR DEL ALMACÉN: ");
/* 2232 */     this.jPanel151.add(this.jLabel217);
/*      */     
/* 2234 */     this.jLabel42.setFont(new Font("Tahoma", 1, 12));
/* 2235 */     this.jLabel42.setHorizontalAlignment(2);
/* 2236 */     this.jLabel42.setText("subtotal");
/* 2237 */     this.jPanel151.add(this.jLabel42);
/*      */     
/* 2239 */     this.jLabel219.setFont(new Font("Tahoma", 0, 12));
/* 2240 */     this.jLabel219.setHorizontalAlignment(4);
/* 2241 */     this.jLabel219.setText("COSTO DE ENTRADAS: ");
/* 2242 */     this.jPanel151.add(this.jLabel219);
/*      */     
/* 2244 */     this.jLabel39.setFont(new Font("Tahoma", 1, 12));
/* 2245 */     this.jLabel39.setHorizontalAlignment(2);
/* 2246 */     this.jLabel39.setText("iva");
/* 2247 */     this.jPanel151.add(this.jLabel39);
/*      */     
/* 2249 */     this.jLabel221.setFont(new Font("Tahoma", 0, 12));
/* 2250 */     this.jLabel221.setHorizontalAlignment(4);
/* 2251 */     this.jLabel221.setText("COSTO DE SALIDAS: ");
/* 2252 */     this.jPanel151.add(this.jLabel221);
/*      */     
/* 2254 */     this.jLabel40.setFont(new Font("Tahoma", 1, 12));
/* 2255 */     this.jLabel40.setHorizontalAlignment(2);
/* 2256 */     this.jLabel40.setText("iva");
/* 2257 */     this.jPanel151.add(this.jLabel40);
/*      */     
/* 2259 */     GroupLayout jPanel169Layout = new GroupLayout(this.jPanel169);
/* 2260 */     this.jPanel169.setLayout(jPanel169Layout);
/* 2261 */     jPanel169Layout.setHorizontalGroup(jPanel169Layout
/* 2262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2263 */         .addComponent(this.jScrollPane29)
/* 2264 */         .addGroup(jPanel169Layout.createSequentialGroup()
/* 2265 */           .addComponent(this.jPanel170, -2, 0, 32767)
/* 2266 */           .addGap(1, 1, 1))
/* 2267 */         .addComponent(this.jPanel151, -1, -1, 32767));
/*      */     
/* 2269 */     jPanel169Layout.setVerticalGroup(jPanel169Layout
/* 2270 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2271 */         .addGroup(jPanel169Layout.createSequentialGroup()
/* 2272 */           .addComponent(this.jPanel170, -2, 31, -2)
/* 2273 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2274 */           .addComponent(this.jScrollPane29, -1, 279, 32767)
/* 2275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2276 */           .addComponent(this.jPanel151, -2, -1, -2)));
/*      */ 
/*      */     
/* 2279 */     GroupLayout jPanel168Layout = new GroupLayout(this.jPanel168);
/* 2280 */     this.jPanel168.setLayout(jPanel168Layout);
/* 2281 */     jPanel168Layout.setHorizontalGroup(jPanel168Layout
/* 2282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2283 */         .addComponent(this.jPanel169, -1, -1, 32767)
/* 2284 */         .addGroup(jPanel168Layout.createSequentialGroup()
/* 2285 */           .addComponent(this.jPanel17, -2, 1151, 32767)
/* 2286 */           .addGap(1, 1, 1)));
/*      */     
/* 2288 */     jPanel168Layout.setVerticalGroup(jPanel168Layout
/* 2289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2290 */         .addGroup(jPanel168Layout.createSequentialGroup()
/* 2291 */           .addComponent(this.jPanel17, -2, 48, -2)
/* 2292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2293 */           .addComponent(this.jPanel169, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2296 */     this.jPanel36.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2298 */     this.jLabel95.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2299 */     this.jLabel95.setForeground(this.lc.PRIMARIO1);
/* 2300 */     this.jLabel95.setText("ALMACÉN");
/*      */     
/* 2302 */     this.jPanel55.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 2304 */     this.jPanel61.setBackground(this.lc.SECUNDARIO2);
/* 2305 */     this.jPanel61.setLayout(new GridBagLayout());
/*      */     
/* 2307 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2308 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 2309 */     this.jDateChooser11.setIcon(this.icon);
/* 2310 */     this.jDateChooser11.setMinSelectableDate(this.fechaInicio);
/* 2311 */     gridBagConstraints = new GridBagConstraints();
/* 2312 */     gridBagConstraints.gridx = 2;
/* 2313 */     gridBagConstraints.gridy = 0;
/* 2314 */     gridBagConstraints.fill = 2;
/* 2315 */     gridBagConstraints.weightx = 1.0D;
/* 2316 */     this.jPanel61.add((Component)this.jDateChooser11, gridBagConstraints);
/*      */     
/* 2318 */     this.jLabel238.setFont(new Font("Cantarell", 0, 11));
/* 2319 */     this.jLabel238.setHorizontalAlignment(0);
/* 2320 */     this.jLabel238.setText("     al     ");
/* 2321 */     gridBagConstraints = new GridBagConstraints();
/* 2322 */     gridBagConstraints.gridx = 4;
/* 2323 */     gridBagConstraints.gridy = 0;
/* 2324 */     gridBagConstraints.fill = 2;
/* 2325 */     this.jPanel61.add(this.jLabel238, gridBagConstraints);
/*      */     
/* 2327 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2328 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 2329 */     this.jDateChooser12.setIcon(this.icon);
/* 2330 */     this.jDateChooser12.setMinSelectableDate(this.fechaInicio);
/* 2331 */     gridBagConstraints = new GridBagConstraints();
/* 2332 */     gridBagConstraints.gridx = 6;
/* 2333 */     gridBagConstraints.gridy = 0;
/* 2334 */     gridBagConstraints.fill = 2;
/* 2335 */     gridBagConstraints.weightx = 1.0D;
/* 2336 */     this.jPanel61.add((Component)this.jDateChooser12, gridBagConstraints);
/*      */     
/* 2338 */     this.jComboBox2.setBackground(new Color(255, 255, 255));
/* 2339 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2341 */             AlmAlmacen.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2344 */     gridBagConstraints = new GridBagConstraints();
/* 2345 */     gridBagConstraints.gridx = 0;
/* 2346 */     gridBagConstraints.gridy = 0;
/* 2347 */     this.jPanel61.add(this.jComboBox2, gridBagConstraints);
/*      */     
/* 2349 */     this.jPanel63.setBackground(this.lc.SECUNDARIO2);
/* 2350 */     this.jPanel63.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 2352 */     this.jButton28.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 2353 */     this.jButton28.setMnemonic('F');
/* 2354 */     this.jButton28.setToolTipText("Filtrar información (Alt+F)");
/* 2355 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2357 */             AlmAlmacen.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2360 */     this.jPanel63.add(this.jButton28);
/*      */     
/* 2362 */     this.jLabel223.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/* 2363 */     this.jLabel223.setForeground(new Color(15, 87, 51));
/* 2364 */     this.jLabel223.setHorizontalAlignment(0);
/* 2365 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/* 2366 */     this.jLabel223.setToolTipText("Retroceder un día en la búsqueda");
/* 2367 */     this.jLabel223.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2369 */             AlmAlmacen.this.jLabel223MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2372 */             AlmAlmacen.this.jLabel223MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2375 */             AlmAlmacen.this.jLabel223MouseExited(evt);
/*      */           }
/*      */         });
/* 2378 */     this.jPanel63.add(this.jLabel223);
/*      */     
/* 2380 */     this.jLabel103.setFont(new Font("Tahoma", 2, 12));
/* 2381 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 2382 */     this.jLabel103.setHorizontalAlignment(0);
/* 2383 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/* 2384 */     this.jLabel103.setToolTipText("Clic para filtrar los datos de HOY");
/* 2385 */     this.jLabel103.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2387 */             AlmAlmacen.this.jLabel103MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2390 */             AlmAlmacen.this.jLabel103MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2393 */             AlmAlmacen.this.jLabel103MouseExited(evt);
/*      */           }
/*      */         });
/* 2396 */     this.jPanel63.add(this.jLabel103);
/*      */     
/* 2398 */     this.jLabel224.setHorizontalAlignment(0);
/* 2399 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/* 2400 */     this.jLabel224.setToolTipText("Aumentar un día en la búsqueda");
/* 2401 */     this.jLabel224.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2403 */             AlmAlmacen.this.jLabel224MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2406 */             AlmAlmacen.this.jLabel224MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2409 */             AlmAlmacen.this.jLabel224MouseExited(evt);
/*      */           }
/*      */         });
/* 2412 */     this.jPanel63.add(this.jLabel224);
/*      */     
/* 2414 */     this.jPanel64.setBackground(this.lc.SECUNDARIO2);
/* 2415 */     this.jPanel64.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2417 */     this.jLabel239.setFont(new Font("Cantarell", 0, 11));
/* 2418 */     this.jLabel239.setHorizontalAlignment(4);
/* 2419 */     this.jLabel239.setText("Visualizando información de ");
/* 2420 */     this.jPanel64.add(this.jLabel239);
/*      */     
/* 2422 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/* 2423 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "PERIODO LIBRE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/* 2424 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2426 */             AlmAlmacen.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2429 */     this.jPanel64.add(this.jComboBox1);
/*      */     
/* 2431 */     GroupLayout jPanel55Layout = new GroupLayout(this.jPanel55);
/* 2432 */     this.jPanel55.setLayout(jPanel55Layout);
/* 2433 */     jPanel55Layout.setHorizontalGroup(jPanel55Layout
/* 2434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2435 */         .addGroup(jPanel55Layout.createSequentialGroup()
/* 2436 */           .addComponent(this.jPanel64, -2, -1, -2)
/* 2437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2438 */           .addComponent(this.jPanel61, -1, 476, 32767)
/* 2439 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2440 */           .addComponent(this.jPanel63, -1, 281, 32767)
/* 2441 */           .addGap(18, 18, 18)));
/*      */     
/* 2443 */     jPanel55Layout.setVerticalGroup(jPanel55Layout
/* 2444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2445 */         .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2446 */           .addComponent(this.jPanel63, -1, -1, 32767)
/* 2447 */           .addComponent(this.jPanel61, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2448 */         .addComponent(this.jPanel64, -1, -1, 32767));
/*      */ 
/*      */     
/* 2451 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 2452 */     this.jPanel36.setLayout(jPanel36Layout);
/* 2453 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 2454 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2455 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 2456 */           .addComponent(this.jLabel95, -1, -1, 32767)
/* 2457 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2458 */           .addComponent(this.jPanel55, -2, -1, -2)));
/*      */     
/* 2460 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 2461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2462 */         .addComponent(this.jLabel95, -2, 26, -2)
/* 2463 */         .addComponent(this.jPanel55, -2, -1, -2));
/*      */ 
/*      */     
/* 2466 */     GroupLayout jPanel159Layout = new GroupLayout(this.jPanel159);
/* 2467 */     this.jPanel159.setLayout(jPanel159Layout);
/* 2468 */     jPanel159Layout.setHorizontalGroup(jPanel159Layout
/* 2469 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2470 */         .addGroup(jPanel159Layout.createSequentialGroup()
/* 2471 */           .addGroup(jPanel159Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2472 */             .addComponent(this.jPanel36, -2, -1, -2)
/* 2473 */             .addComponent(this.jPanel168, -1, -1, 32767))
/* 2474 */           .addGap(0, 0, 0)));
/*      */     
/* 2476 */     jPanel159Layout.setVerticalGroup(jPanel159Layout
/* 2477 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2478 */         .addGroup(jPanel159Layout.createSequentialGroup()
/* 2479 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 2480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2481 */           .addComponent(this.jPanel168, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2484 */     GroupLayout layout = new GroupLayout(this);
/* 2485 */     setLayout(layout);
/* 2486 */     layout.setHorizontalGroup(layout
/* 2487 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2488 */         .addComponent(this.jPanel159, -1, -1, 32767));
/*      */     
/* 2490 */     layout.setVerticalGroup(layout
/* 2491 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2492 */         .addComponent(this.jPanel159, -1, -1, 32767));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2497 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2501 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/* 2502 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2507 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 2511 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, " ORDENES DE ENTRADA / SALIDA");
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 2515 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2516 */     if (ind < 0) {
/* 2517 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una orden para poder Cancelarla", "Selecciona una orden", 0, this.ERROR);
/*      */     } else {
/* 2519 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2520 */       if (!estatus.equals("<Por Autorizar>")) {
/* 2521 */         JOptionPane.showMessageDialog(this.padre, "Para cancelar una orden necesita estar en estatus POR AUTORIZAR", "Selecciona otra orden", 0, this.ERROR);
/*      */       } else {
/* 2523 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas cancelar la orden?", "Cancelar", 0, 3, this.ELIMINAR);
/* 2524 */         if (res == 0) {
/* 2525 */           this.con2.inserSinMsj("update alm_operaciones set estatus = 'CANCELADA', actualizacion = '" + this.utilerias.sacarUsuario(this.USUARIO) + "' where movOp = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 2526 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2533 */     habilitar();
/* 2534 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton60ActionPerformed(ActionEvent evt) {
/* 2538 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2539 */     if (ind < 0) {
/* 2540 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una orden para poder MODIFICARLA", "Selecciona una orden", 0, this.ERROR);
/*      */     } else {
/* 2542 */       this.ENTRAMODIFICAR = false;
/* 2543 */       this.ESTATUS = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2544 */       this.jPanel3.setVisible(false);
/* 2545 */       this.com_Autoriza.removeAllItems();
/* 2546 */       this.com_Solicita.removeAllItems();
/* 2547 */       this.com_Recibe.removeAllItems();
/* 2548 */       verOrden();
/* 2549 */       habilitar();
/* 2550 */       carcarAutoCompletar();
/* 2551 */       habilitarPrivilegios();
/* 2552 */       this.materialButton20.setText("Modificar");
/* 2553 */       this.materialButton20.setToolTipText("Modificar (Alt + M)");
/* 2554 */       this.materialButton20.setMnemonic('M');
/* 2555 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox23ActionPerformed(ActionEvent evt) {
/* 2561 */     if (this.jComboBox23.getItemCount() > 0 && this.PRIMERA == true) {
/* 2562 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2567 */     if (evt.getClickCount() > 1) {
/* 2568 */       String tipo = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString();
/* 2569 */       this.jPanel3.setVisible(false);
/* 2570 */       this.com_Autoriza.removeAllItems();
/* 2571 */       this.com_Solicita.removeAllItems();
/* 2572 */       this.com_Recibe.removeAllItems();
/* 2573 */       verOrden();
/* 2574 */       desactivar();
/* 2575 */       carcarAutoCompletar();
/* 2576 */       this.materialButton20.setText("Imprimir");
/* 2577 */       this.materialButton20.setToolTipText("Imprimir (Alt + I)");
/* 2578 */       this.materialButton20.setMnemonic('I');
/* 2579 */       System.out.println("Texto " + this.jTextField4.getText());
/* 2580 */       if (this.jTextField4.getText().contains("EN")) {
/* 2581 */         this.jLabel52.setText("Entrada de Productos");
/*      */       } else {
/* 2583 */         this.jLabel52.setText("Salida de Productos");
/*      */       } 
/* 2585 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2595 */     this.jDialog7.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2599 */     int ind = this.rSTableMetro1.getSelectedRow();
/* 2600 */     String tipo = this.rSTableMetro1.getValueAt(ind, 1).toString();
/* 2601 */     if (ind < 0) {
/* 2602 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una orden para poder Autorizarla", "Selecciona una orden", 0, this.ERROR);
/*      */     } else {
/* 2604 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString();
/* 2605 */       if (!estatus.equals("<Por Autorizar>")) {
/* 2606 */         JOptionPane.showMessageDialog(this.padre, "Para AUTORIZAR una orden necesita estar en estatus POR AUTORIZAR", "Selecciona otra orden", 0, this.ERROR);
/*      */       } else {
/* 2608 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>Al autorizar una orden de Entrada/Salida los stocks se actualizarán y ya no se podrán cancelar<p><b>  ¿Estás seguro que deseas cancelar la orden?</b></html>", "Autorizar la orden", 0, 3, this.PREG);
/*      */ 
/*      */ 
/*      */         
/* 2612 */         if (res == 0) {
/* 2613 */           String tipoOP = "ENTRADA";
/* 2614 */           if (tipo.contains("SA")) {
/* 2615 */             tipoOP = "SALIDA";
/*      */           }
/* 2617 */           String[][] prod = this.con2.buscarDatos("codigo, descInterna, cant, precioUnit, nuevoStock, tipo", "alm_operaciones_prod", "where folioOP = '" + 
/*      */ 
/*      */               
/* 2620 */               String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)) + "'");
/*      */ 
/*      */           
/* 2623 */           for (String[] p : prod) {
/* 2624 */             if (!p[5].equals("SERVICIO")) {
/* 2625 */               actualizarStock(tipoOP, p, this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/*      */             }
/*      */           } 
/* 2628 */           this.con2.inserSinMsj("update alm_operaciones set estatus = '<Autorizada>' where movOp = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 2629 */           valorAlmacen();
/* 2630 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 2645 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel223MouseClicked(MouseEvent evt) {
/* 2649 */     Calendar fecha = this.jDateChooser11.getCalendar();
/* 2650 */     int aa = fecha.get(1);
/* 2651 */     int mm = fecha.get(2);
/* 2652 */     int dd = fecha.get(5);
/* 2653 */     if (dd == 1) {
/* 2654 */       if (mm == 0) {
/* 2655 */         mm = 11;
/* 2656 */         aa--;
/*      */       } else {
/* 2658 */         mm--;
/*      */       } 
/* 2660 */       int diasTotal = diasDelMes(mm, aa);
/* 2661 */       dd = diasTotal;
/*      */     } else {
/* 2663 */       dd--;
/*      */     } 
/* 2665 */     mm++;
/* 2666 */     String año = "" + aa;
/* 2667 */     String mes = "" + mm;
/* 2668 */     String dia = "" + dd;
/* 2669 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2670 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2672 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 2673 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 2674 */     } catch (ParseException ex) {
/* 2675 */       ex.printStackTrace();
/*      */     } 
/* 2677 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel223MouseEntered(MouseEvent evt) {
/* 2681 */     this.jLabel223.setForeground(new Color(153, 255, 153));
/* 2682 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel223MouseExited(MouseEvent evt) {
/* 2686 */     this.jLabel223.setForeground(new Color(15, 87, 51));
/* 2687 */     this.jLabel223.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseClicked(MouseEvent evt) {
/* 2691 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2692 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2693 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel103MouseEntered(MouseEvent evt) {
/* 2697 */     this.jLabel103.setForeground(new Color(153, 255, 153));
/* 2698 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel103MouseExited(MouseEvent evt) {
/* 2702 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 2703 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*      */   }
/*      */   
/*      */   private void jLabel224MouseClicked(MouseEvent evt) {
/* 2707 */     Calendar calendar = this.jDateChooser11.getCalendar();
/* 2708 */     calendar.setTime(this.jDateChooser12.getDate());
/* 2709 */     calendar.add(6, 1);
/* 2710 */     this.jDateChooser11.setCalendar(calendar);
/* 2711 */     this.jDateChooser12.setCalendar(calendar);
/* 2712 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel224MouseEntered(MouseEvent evt) {
/* 2716 */     this.jLabel224.setForeground(new Color(153, 255, 153));
/* 2717 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*      */   }
/*      */   
/*      */   private void jLabel224MouseExited(MouseEvent evt) {
/* 2721 */     this.jLabel224.setForeground(new Color(15, 87, 51));
/* 2722 */     this.jLabel224.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2726 */     int v = this.jComboBox1.getSelectedIndex();
/* 2727 */     if (v == 0) {
/* 2728 */       this.jDateChooser11.setEnabled(true);
/* 2729 */       this.jDateChooser12.setEnabled(true);
/* 2730 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/* 2732 */       this.jDateChooser11.setEnabled(false);
/* 2733 */       this.jDateChooser12.setEnabled(false);
/* 2734 */       this.jComboBox2.setEnabled(true);
/*      */     } 
/* 2736 */     if (this.PRIMERA) {
/* 2737 */       consultar();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2746 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2750 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2754 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2758 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField15ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField15KeyReleased(KeyEvent evt) {
/* 2766 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox24ActionPerformed(ActionEvent evt) {
/* 2770 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel52MouseDragged(MouseEvent evt) {
/* 2774 */     int x = evt.getXOnScreen();
/* 2775 */     int y = evt.getYOnScreen();
/* 2776 */     this.jDialog1.setLocation(x - this.xx, y - this.xy);
/*      */   }
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 2780 */     this.xx = evt.getX();
/* 2781 */     this.xy = evt.getY();
/*      */   }
/*      */   
/*      */   private void jLabel135MouseClicked(MouseEvent evt) {
/* 2785 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel135MouseEntered(MouseEvent evt) {
/* 2789 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*      */   }
/*      */   
/*      */   private void jLabel135MouseExited(MouseEvent evt) {
/* 2793 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 2797 */     int row = this.rSTableMetro2.rowAtPoint(evt.getPoint());
/* 2798 */     if (row >= 0) {
/* 2799 */       DefaultTableModel model = (DefaultTableModel)this.rSTableMetro2.getModel();
/* 2800 */       StringBuilder tooltipText = new StringBuilder("<html>");
/* 2801 */       for (int column = 0; column < model.getColumnCount(); column++) {
/* 2802 */         String columnName = "<b>" + model.getColumnName(column) + "</b>";
/* 2803 */         String cellValue = "<i>" + model.getValueAt(row, column).toString() + "</i>";
/* 2804 */         tooltipText.append(columnName).append(": ").append(cellValue).append("<br>");
/*      */       } 
/* 2806 */       tooltipText.append("</html>");
/* 2807 */       this.rSTableMetro2.setToolTipText(tooltipText.toString());
/* 2808 */       ToolTipManager.sharedInstance().mouseMoved(new MouseEvent((Component)this.rSTableMetro2, 0, 0L, 0, evt
/*      */             
/* 2810 */             .getX(), evt.getY(), 0, false));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton52ActionPerformed(ActionEvent evt) {
/* 2819 */     this.materialButton46.setToolTipText("Clic para pasar el producto");
/* 2820 */     if (this.jTextField4.getText().contains("EN")) {
/* 2821 */       this.materialButton46.setText("Entrada");
/* 2822 */       this.materialButton46.setMnemonic('E');
/*      */     } else {
/* 2824 */       this.materialButton46.setText("Salida");
/* 2825 */       this.materialButton46.setMnemonic('S');
/*      */     } 
/* 2827 */     consultarProductos();
/* 2828 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 2832 */     int ind = this.rSTableMetro2.getSelectedRow();
/* 2833 */     if (ind < 0) {
/* 2834 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona un registro", 0, this.ADVER);
/*      */     } else {
/* 2836 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, this.rSTableMetro2.getSelectedRow());
/* 2837 */       sumasCostos();
/* 2838 */       this.ENTRAMODIFICAR = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 2843 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 2847 */     String tipoMsj = "";
/* 2848 */     if (this.jTextField4.getText().contains("EN")) {
/* 2849 */       tipoMsj = "RECIBIDO";
/*      */     } else {
/* 2851 */       tipoMsj = "DESTINATARIO O EQUIPO";
/*      */     } 
/* 2853 */     if (this.jDateChooser6.getDate() == null) {
/* 2854 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la fecha de la requisición", "Fala la fecha", 0, this.ERROR);
/* 2855 */     } else if (this.jComboBox6.getSelectedIndex() == 0) {
/* 2856 */       this.jComboBox6.setBackground(Color.RED);
/* 2857 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta seleccionar el ÁREA donde será cargada la entrada", "Fala el Área", 0, this.ERROR);
/* 2858 */     } else if (this.jComboBox9.getSelectedIndex() == 0) {
/* 2859 */       this.jComboBox9.setBackground(Color.RED);
/* 2860 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta seleccionar el TIPO DE DESTINO donde será cargada la entrada", "Fala el Área", 0, this.ERROR);
/* 2861 */     } else if (this.jTextField5.getText().equals("")) {
/* 2862 */       this.jTextField5.setBackground(Color.RED);
/* 2863 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la información de " + tipoMsj, "Fala el nombre", 0, this.ERROR);
/* 2864 */     } else if (this.rSTableMetro2.getRowCount() < 1) {
/* 2865 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas agregar por lo menos un producto a la lista de entrada", "Falan los productos", 0, this.ERROR);
/* 2866 */     } else if (this.jTextField9.getText().equals("")) {
/* 2867 */       this.jTextField9.setBackground(Color.RED);
/* 2868 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la información de la persona que solicita", "Fala el solicitante", 0, this.ERROR);
/* 2869 */     } else if (this.jTextField10.getText().equals("")) {
/* 2870 */       this.jTextField10.setBackground(Color.RED);
/* 2871 */       JOptionPane.showMessageDialog(this.jDialog1, "Falta agregar la información de la persona que autoriza", "Fala quien autoriza", 0, this.ERROR);
/*      */     } else {
/* 2873 */       String productos = getProductos();
/* 2874 */       String tipoOperacion = this.jTextField4.getText().contains("EN") ? "ENTRADA" : "SALIDA";
/* 2875 */       String mensaje = tipoOperacion.equals("ENTRADA") ? "¿Deseas agregar una nueva ENTRADA de productos?" : "¿Deseas agregar una nueva SALIDA de productos?";
/*      */       
/* 2877 */       if (this.materialButton20.getText().equals("Guardar")) {
/* 2878 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, mensaje, "Agregar nueva", 0, 3, this.PREG);
/* 2879 */         if (res == 0) {
/* 2880 */           handleOperation(tipoOperacion, productos);
/*      */         }
/* 2882 */       } else if (this.materialButton20.getText().equals("Modificar")) {
/* 2883 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar la orden?", "Modificar la Orden", 0, 3, this.PREG);
/* 2884 */         if (res == 0) {
/* 2885 */           modificarOperacion(tipoOperacion, productos);
/*      */         }
/* 2887 */       } else if (this.materialButton20.getText().equals("Imprimir")) {
/* 2888 */         imprimirOrden();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2894 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro4);
/* 2895 */     if (!this.entraConsultaRequi) {
/* 2896 */       this.entraConsultaRequi = true;
/* 2897 */       consultarCot();
/*      */     } 
/*      */     
/* 2900 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton44ActionPerformed(ActionEvent evt) {
/* 2904 */     buscarProductos();
/*      */   }
/*      */   
/*      */   private void jTextField26KeyReleased(KeyEvent evt) {
/* 2908 */     consultarCot();
/*      */   }
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 2912 */     if (evt.getClickCount() > 1) {
/* 2913 */       buscarProductos();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox38ActionPerformed(ActionEvent evt) {
/* 2922 */     consultarCot();
/*      */   }
/*      */   
/*      */   private void jComboBox39ActionPerformed(ActionEvent evt) {
/* 2926 */     consultarCot();
/*      */   }
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 2930 */     consultarCot();
/*      */   }
/*      */   
/*      */   private void materialButton45ActionPerformed(ActionEvent evt) {
/* 2934 */     for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 2935 */       String valor = this.rSTableMetro4.getValueAt(i, 2).toString();
/* 2936 */       boolean selec = Boolean.valueOf(this.rSTableMetro4.getValueAt(i, 0).toString()).booleanValue();
/* 2937 */       if (valor.equals("") && selec) {
/* 2938 */         JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar vacío el campo para seleccionar el producto en el almacén", "Falta el producto", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2943 */     this.ENTRAMODIFICAR = true;
/* 2944 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro2);
/* 2945 */     revisarNuevosStock();
/* 2946 */     validarSelecPositivo();
/* 2947 */     this.jTextField5.setText(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 2).toString());
/* 2948 */     this.jTextField7.setText("OC: " + this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0).toString() + " | ");
/* 2949 */     this.jComboBox9.setSelectedItem("PROVEEDOR");
/* 2950 */     this.jComboBox6.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 4).toString());
/* 2951 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 2955 */     if (evt.getClickCount() > 1) {
/* 2956 */       boolean selec = Boolean.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0).toString()).booleanValue();
/* 2957 */       if (selec) {
/* 2958 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, this.jPanel19, "Cantidad", 0, 3, this.PREG);
/* 2959 */         if (res == 0) {
/* 2960 */           this.rSTableMetro4.setValueAt(this.jSpinner1.getValue(), this.rSTableMetro4.getSelectedRow(), 3);
/* 2961 */           revisarNuevosStock();
/*      */         } 
/*      */       } 
/*      */     } 
/* 2965 */     revisarNuevosStock();
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel30MouseClicked(MouseEvent evt) {
/* 2973 */     this.jDialog4.setVisible(false);
/* 2974 */     limpiar();
/* 2975 */     this.jLabel18.setText("Tipo de Entrada");
/* 2976 */     this.jComboBox12.setVisible(false);
/* 2977 */     this.jLabel27.setText("Recibido de");
/* 2978 */     sacarMayorEntrada();
/* 2979 */     this.jPanel3.setVisible(true);
/* 2980 */     this.jDialog1.setTitle("Entrada de productos");
/* 2981 */     this.jLabel52.setText("Entrada de productos");
/* 2982 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel30MouseEntered(MouseEvent evt) {
/* 2986 */     this.jPanel38.setBackground(this.lc.PRIMARIO2);
/* 2987 */     this.jPanel38.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 2988 */     this.jLabel31.setForeground(Color.WHITE);
/*      */   }
/*      */   
/*      */   private void jLabel30MouseExited(MouseEvent evt) {
/* 2992 */     this.jPanel38.setBackground(this.lc.SECUNDARIO2);
/* 2993 */     this.jPanel38.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 2994 */     this.jLabel31.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jPanel38MouseExited(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jPanel38MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel32MouseClicked(MouseEvent evt) {
/* 3006 */     this.jDialog4.setVisible(false);
/* 3007 */     limpiar();
/* 3008 */     this.jLabel18.setText("Tipo de Destino");
/* 3009 */     this.jPanel3.setVisible(false);
/* 3010 */     this.jComboBox12.setVisible(false);
/* 3011 */     this.jLabel27.setText("Destinatario o Equipo");
/* 3012 */     sacarMayorSalida();
/* 3013 */     this.jPanel3.setVisible(false);
/* 3014 */     this.jDialog1.setTitle("Salida de productos");
/* 3015 */     this.jLabel52.setText("Salida de productos");
/* 3016 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel32MouseEntered(MouseEvent evt) {
/* 3020 */     this.jPanel39.setBackground(this.lc.PRIMARIO2);
/* 3021 */     this.jPanel39.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/* 3022 */     this.jLabel50.setForeground(Color.WHITE);
/*      */   }
/*      */   
/*      */   private void jLabel32MouseExited(MouseEvent evt) {
/* 3026 */     this.jPanel39.setBackground(this.lc.SECUNDARIO2);
/* 3027 */     this.jPanel39.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/* 3028 */     this.jLabel50.setForeground(this.lc.PRIMARIO1);
/*      */   }
/*      */   
/*      */   private void materialButton46ActionPerformed(ActionEvent evt) {
/* 3032 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 3033 */     if (ind < 0) {
/* 3034 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas seleccionar un producto para agregarlo a la orden", "Selecciona un producto", 0, this.ADVER);
/*      */     } else {
/* 3036 */       ingresarCantidad();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/* 3041 */     if (evt.getClickCount() > 1) {
/* 3042 */       ingresarCantidad();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {
/* 3051 */     consultarProductos();
/*      */   }
/*      */   
/*      */   private void jTextField13KeyReleased(KeyEvent evt) {
/* 3055 */     consultarProductos();
/*      */   }
/*      */   
/*      */   private void jTextField14KeyReleased(KeyEvent evt) {
/* 3059 */     consultarProductos();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 3063 */     consultarProductos();
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 3067 */     consultarProductos();
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 3071 */     if (this.PRIMERA) {
/* 3072 */       consultarProductos();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton47ActionPerformed(ActionEvent evt) {
/* 3077 */     AlmProductosForm producto = new AlmProductosForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", false, "");
/* 3078 */     this.actualizado = producto.actualizado;
/* 3079 */     if (this.actualizado) {
/* 3080 */       consultarProductos();
/*      */     }
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 3085 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 3089 */     double stock = Double.parseDouble(this.jTextField20.getText());
/* 3090 */     if (stock < 0.0D) {
/* 3091 */       JOptionPane.showMessageDialog(this.jDialog6, "El producto no cuenta con suficiente disponibilidad, verifica tu información", "Confirma las cantidades", 0, this.ADVER);
/*      */     } else {
/* 3093 */       pasarDatosdelProducto();
/* 3094 */       sumasCostos();
/* 3095 */       this.ENTRAMODIFICAR = true;
/*      */       
/* 3097 */       this.jDialog6.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirOrden() {
/* 3102 */     String tipo = "ENTRADA";
/* 3103 */     if (this.jTextField4.getText().contains("SA")) {
/* 3104 */       tipo = "SALIDA";
/*      */     }
/*      */     
/* 3107 */     JTable aux = crearTablaAux3((JTable)this.rSTableMetro2);
/* 3108 */     Map<Object, Object> datos = new HashMap<>();
/*      */     
/* 3110 */     datos.put("tipoOrden", tipo);
/* 3111 */     datos.put("folio", this.jTextField4.getText().toUpperCase());
/*      */     
/* 3113 */     datos.put("fecha", this.utilerias.convertirFechaDateStringBarras(this.jDateChooser6.getDate()));
/* 3114 */     datos.put("entrega", this.jTextField11.getText().toUpperCase());
/* 3115 */     datos.put("correo", ((String)this.CAMPOSGENERALES.get("usuarios.correo")).toUpperCase());
/*      */     
/* 3117 */     datos.put("sucursalEntrega", this.jComboBox5.getSelectedItem());
/* 3118 */     datos.put("area", this.jComboBox6.getSelectedItem());
/* 3119 */     datos.put("tipo", this.jComboBox9.getSelectedItem());
/* 3120 */     datos.put("recibe", this.jTextField5.getText().toUpperCase());
/*      */     
/* 3122 */     datos.put("referencia", this.jTextField7.getText().toUpperCase());
/* 3123 */     datos.put("grupoProd", this.jTextField22.getText().toUpperCase());
/* 3124 */     datos.put("totalProd", this.utilerias.quitarDecimalesAEnteros(this.jTextField23.getText().toUpperCase()));
/*      */     
/* 3126 */     datos.put("comentarios", this.jTextPane1.getText().toUpperCase());
/* 3127 */     this.utilerias.cargarImagenesAReporte(datos);
/*      */     
/*      */     try {
/* 3130 */       this.utilerias.verImpresion("/Reportes/Almacen/Alm_Operaciones.jasper", aux, datos, "Orden de " + tipo + ": " + this.jTextField4.getText());
/* 3131 */     } catch (JRException ex) {
/* 3132 */       Logger.getLogger(AlmAlmacen.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void habilitarPrivilegios() {
/* 3137 */     if (this.ESTATUS.equals("<Autorizada>")) {
/* 3138 */       this.jButton52.setEnabled(false);
/* 3139 */       this.jButton53.setEnabled(false);
/* 3140 */       this.jComboBox12.setEnabled(false);
/*      */     } else {
/* 3142 */       this.jButton52.setEnabled(true);
/* 3143 */       this.jButton53.setEnabled(true);
/* 3144 */       this.jComboBox12.setEnabled(false);
/* 3145 */       if (this.jTextField4.getText().contains("EN")) {
/* 3146 */         this.jPanel3.setVisible(true);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jSpinner2StateChanged(ChangeEvent evt) {
/* 3152 */     double cant = Double.parseDouble(this.jSpinner2.getValue().toString());
/* 3153 */     if (this.jTextField4.getText().contains("EN")) {
/* 3154 */       this.jTextField20.setText("" + 
/* 3155 */           Double.parseDouble(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 7).toString()) + 
/* 3156 */           Double.parseDouble(this.jSpinner2.getValue().toString()));
/*      */       
/* 3158 */       this.jTextField21.setText(this.utilerias
/* 3159 */           .convertirDoublePesos(cant * this.utilerias.convertirCantTexto(this.jTextField19.getText())));
/*      */     }
/* 3161 */     else if (this.jTextField4.getText().contains("SA")) {
/* 3162 */       if (!this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 2).toString().equals("SERVICIO")) {
/* 3163 */         this.jTextField20.setText("" + 
/* 3164 */             Double.parseDouble(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 7).toString()) - 
/* 3165 */             Double.parseDouble(this.jSpinner2.getValue().toString()));
/*      */         
/* 3167 */         this.jTextField21.setText(this.utilerias
/* 3168 */             .convertirDoublePesos(cant * this.utilerias.convertirCantTexto(this.jTextField19.getText())));
/*      */       } else {
/*      */         
/* 3171 */         this.jTextField21.setText(this.utilerias
/* 3172 */             .convertirDoublePesos(cant * this.utilerias.convertirCantTexto(this.jTextField19.getText())));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro5MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton48ActionPerformed(ActionEvent evt) {
/* 3183 */     AlmProductosForm producto = new AlmProductosForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", false, this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0).toString());
/*      */   }
/*      */   
/*      */   private void jTextField5FocusLost(FocusEvent evt) {
/* 3187 */     if (this.jTextField5.getText().contains("'")) {
/* 3188 */       this.jTextField5.setText(this.jTextField5.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton49ActionPerformed(ActionEvent evt) {
/* 3197 */     if (this.jRadioButton2.isSelected()) {
/* 3198 */       imprimirVistaActual();
/* 3199 */     } else if (this.jRadioButton1.isSelected() || this.jRadioButton3.isSelected()) {
/* 3200 */       this.utilerias.vaciarTabla(this.jTable1);
/* 3201 */       this.utilerias.vaciarTabla(this.jTable2);
/* 3202 */       this.utilerias.vaciarTabla(this.jTable3);
/* 3203 */       this.llenarPrimera = false;
/* 3204 */       generarCosulta();
/* 3205 */       this.jDialog7.setVisible(false);
/*      */       
/* 3207 */       verHojaFinal();
/*      */     } 
/* 3209 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField9FocusGained(FocusEvent evt) {
/* 3213 */     if (this.jComboBox9.getSelectedItem().equals("EMPLEADO") || this.jComboBox9.getSelectedItem().equals("OTRO")) {
/* 3214 */       this.jTextField9.setText(this.jTextField5.getText().toUpperCase());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton50ActionPerformed(ActionEvent evt) {
/* 3223 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField27KeyReleased(KeyEvent evt) {
/* 3231 */     consultarCot();
/*      */   }
/*      */   
/*      */   private void jTextField7FocusLost(FocusEvent evt) {
/* 3235 */     if (this.jTextField7.getText().contains("'")) {
/* 3236 */       this.jTextField7.setText(this.jTextField7.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextPane1FocusLost(FocusEvent evt) {
/* 3241 */     if (this.jTextPane1.getText().contains("'")) {
/* 3242 */       this.jTextPane1.setText(this.jTextPane1.getText().replace("'", ""));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField24KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   public void verHojaFinal() {
/* 3251 */     if (this.jRadioButton1.isSelected()) {
/* 3252 */       Map<Object, Object> datos = new HashMap<>();
/* 3253 */       String titulo = "REPORTE DE CONSUMOS POR BASES Y ÁREAS " + String.valueOf(this.jComboBox2.getSelectedItem());
/* 3254 */       datos.put("titulo", titulo);
/* 3255 */       this.utilerias.cargarImagenesAReporte(datos);
/*      */       try {
/* 3257 */         this.utilerias.verImpresion("/Reportes/Almacen/Alm_ConsumoRep_Anual.jasper", this.jTable3, datos, titulo);
/* 3258 */       } catch (JRException ex) {
/* 3259 */         Logger.getLogger(AlmAlmacen.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/* 3261 */     } else if (this.jRadioButton3.isSelected()) {
/* 3262 */       Map<Object, Object> datos = new HashMap<>();
/* 3263 */       String titulo = "REPORTE DE CONSUMOS POR ÁREAS Y EQUIPOS " + String.valueOf(this.jComboBox2.getSelectedItem());
/* 3264 */       datos.put("titulo", titulo);
/* 3265 */       datos.put("sucursal", this.SUCURSALIMPRESION);
/* 3266 */       this.utilerias.cargarImagenesAReporte(datos);
/*      */       try {
/* 3268 */         this.utilerias.verImpresion("/Reportes/Almacen/Alm_ConsumoAreaEquipo.jasper", this.jTable3, datos, titulo);
/* 3269 */       } catch (JRException ex) {
/* 3270 */         Logger.getLogger(AlmAlmacen.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void generarCosulta() {
/* 3277 */     if (this.jRadioButton1.isSelected()) {
/* 3278 */       String consulta = "base AS 'Nombre de Sucursal',\n    area AS 'Nombre de Área',\n    CASE MONTH(fecha)\n        WHEN 1 THEN 'Ene'\n        WHEN 2 THEN 'Feb'\n        WHEN 3 THEN 'Mar'\n        WHEN 4 THEN 'Abr'\n        WHEN 5 THEN 'May'\n        WHEN 6 THEN 'Jun'\n        WHEN 7 THEN 'Jul'\n        WHEN 8 THEN 'Ago'\n        WHEN 9 THEN 'Sep'\n        WHEN 10 THEN 'Oct'\n        WHEN 11 THEN 'Nov'\n        WHEN 12 THEN 'Dic'\n    END AS 'Mes',\n    costo AS 'Total'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3296 */       String condicion = "WHERE estatus != 'Cancelada' and folio like '%SA%' and \n    YEAR(fecha) = " + String.valueOf(this.jComboBox2.getSelectedItem()) + "\nORDER BY \n    FIELD(MONTH(fecha), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), \n    base,\n    area;";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 3302 */         imprimirReporteAnual(consulta, condicion);
/* 3303 */       } catch (JRException ex) {
/* 3304 */         Logger.getLogger(AlmAlmacen.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/* 3306 */     } else if (this.jRadioButton3.isSelected()) {
/* 3307 */       String area = "";
/* 3308 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3309 */         area = " area ='" + String.valueOf(this.jComboBox3.getSelectedItem()) + "' and ";
/*      */       }
/*      */       
/* 3312 */       String tipo = "";
/* 3313 */       if (this.jComboBox8.getSelectedIndex() != 0) {
/* 3314 */         tipo = " tipoEquipo ='" + String.valueOf(this.jComboBox8.getSelectedItem()) + "' and ";
/*      */       }
/*      */       
/* 3317 */       String sucursal = "";
/* 3318 */       this.SUCURSALIMPRESION = "TODAS LAS SUCURSALES";
/* 3319 */       if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3320 */         sucursal = " and base ='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "'";
/* 3321 */         this.SUCURSALIMPRESION = this.jComboBox23.getSelectedItem().toString();
/*      */       } 
/*      */       
/* 3324 */       String consulta = "area AS 'Nombre de Area',     origenDestino AS 'Equipo',\n    CASE MONTH(fecha)\n        WHEN 1 THEN 'Ene'\n        WHEN 2 THEN 'Feb'\n        WHEN 3 THEN 'Mar'\n        WHEN 4 THEN 'Abr'\n        WHEN 5 THEN 'May'\n        WHEN 6 THEN 'Jun'\n        WHEN 7 THEN 'Jul'\n        WHEN 8 THEN 'Ago'\n        WHEN 9 THEN 'Sep'\n        WHEN 10 THEN 'Oct'\n        WHEN 11 THEN 'Nov'\n        WHEN 12 THEN 'Dic'\n    END AS 'Mes',\n    costo AS 'Total'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3342 */       String condicion = "WHERE estatus != 'Cancelada' and folio like '%SA%' and " + area + " " + tipo + "YEAR(fecha) = " + String.valueOf(this.jComboBox2.getSelectedItem()) + " " + sucursal + " ORDER BY FIELD(MONTH(fecha), 1, 2, 3, 4,5, 6, 7, 8, 9, 10, 11, 12), area, origenDestino";
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 3347 */         imprimirReporteAnual(consulta, condicion);
/* 3348 */       } catch (JRException ex) {
/* 3349 */         Logger.getLogger(AlmAlmacen.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimirReporteAnual(String consulta, String condicion) throws JRException {
/* 3355 */     this.utilerias.consultaGralTabla(this.con2, this.jTable1, new String[] { "Base", "Area", "Mes", "Total" }, consulta, "alm_operaciones", condicion);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3361 */     this.utilerias.pintarTablaReg(this.jTable1);
/* 3362 */     ordenarImpresionAnual();
/*      */   }
/*      */   
/*      */   public void ordenarImpresionAnual() {
/* 3366 */     this.utilerias.vaciarTabla(this.jTable2);
/* 3367 */     DefaultTableModel modeloTabla1 = (DefaultTableModel)this.jTable1.getModel();
/* 3368 */     DefaultTableModel modeloTabla2 = (DefaultTableModel)this.jTable2.getModel(); int i;
/* 3369 */     for (i = 0; i < modeloTabla1.getRowCount(); i++) {
/* 3370 */       String base = modeloTabla1.getValueAt(i, 0).toString();
/* 3371 */       String area = modeloTabla1.getValueAt(i, 1).toString();
/* 3372 */       String mes = modeloTabla1.getValueAt(i, 2).toString();
/* 3373 */       int columnaMes = obtenerIndiceMes(mes);
/* 3374 */       if (columnaMes != -1) {
/* 3375 */         Object[] fila = new Object[modeloTabla2.getColumnCount()];
/* 3376 */         fila[0] = base;
/* 3377 */         fila[1] = area;
/* 3378 */         fila[columnaMes + 2] = modeloTabla1.getValueAt(i, 3);
/* 3379 */         modeloTabla2.addRow(fila);
/*      */       } 
/*      */     } 
/* 3382 */     this.jLabel1.setText("" + this.jTable2.getRowCount());
/* 3383 */     llenarCeldasVaciasConCeros(this.jTable2);
/* 3384 */     for (i = 2; i < 14; i++) {
/* 3385 */       ordenarSegundaParte(i);
/*      */     }
/* 3387 */     calcularTotales();
/* 3388 */     agregarTotalGlobal();
/* 3389 */     insertarNombresBaseUnicos();
/*      */     
/* 3391 */     sumarBloques((DefaultTableModel)this.jTable3.getModel());
/* 3392 */     for (i = 2; i < 15; i++) {
/* 3393 */       sacarEncabezadosBase(i);
/*      */     }
/* 3395 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*      */     
/* 3397 */     quitarDecimales();
/*      */   }
/*      */   
/*      */   public void quitarDecimales() {
/* 3401 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3402 */       for (int j = 2; j < this.jTable3.getColumnCount(); j++) {
/* 3403 */         String valor = this.jTable3.getValueAt(i, j).toString();
/* 3404 */         if (valor.equals("0.0") || valor.equals("0") || valor.equals("")) {
/* 3405 */           this.jTable3.setValueAt("", i, j);
/*      */         } else {
/* 3407 */           this.jTable3.setValueAt(this.utilerias.quitarDecimalesAEnteros(valor), i, j);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarEncabezadosBase(int col) {
/* 3414 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 3415 */     int numBase = -1;
/* 3416 */     double suma = 0.0D;
/*      */     
/* 3418 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3419 */       Object valorColumna0 = model.getValueAt(i, 0);
/* 3420 */       if (valorColumna0 != null && !valorColumna0.toString().isEmpty()) {
/* 3421 */         numBase = i;
/* 3422 */         suma = 0.0D;
/* 3423 */         for (int j = i + 1; j < model.getRowCount(); ) {
/* 3424 */           Object valorColumnaOtra = model.getValueAt(j, col);
/* 3425 */           if (((valorColumnaOtra != null && !valorColumnaOtra.toString().isEmpty()) || !valorColumnaOtra.toString().equals("")) && valorColumnaOtra instanceof Number) {
/*      */             try {
/* 3427 */               suma += ((Number)valorColumnaOtra).doubleValue();
/* 3428 */             } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 3433 */             model.setValueAt(Double.valueOf(suma), i, col);
/*      */             j++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   } public void sumarBloques(DefaultTableModel model) {
/* 3440 */     String baseAnterior = "";
/* 3441 */     double sumaBloque = 0.0D;
/*      */     
/* 3443 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3444 */       String baseActual = model.getValueAt(i, 0).toString();
/* 3445 */       if (!model.getValueAt(i, 2).toString().equals("")) {
/* 3446 */         double valor = Double.parseDouble(model.getValueAt(i, 2).toString());
/*      */         
/* 3448 */         if (!baseActual.equals(baseAnterior)) {
/* 3449 */           if (!baseAnterior.isEmpty()) {
/* 3450 */             model.setValueAt(Double.valueOf(sumaBloque), i - 1, 2);
/*      */           }
/* 3452 */           baseAnterior = baseActual;
/* 3453 */           sumaBloque = 0.0D;
/*      */         } 
/* 3455 */         sumaBloque += valor;
/*      */       } 
/*      */     } 
/* 3458 */     if (!baseAnterior.isEmpty()) {
/* 3459 */       model.setValueAt(Double.valueOf(sumaBloque), model.getRowCount() - 1, 2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void insertarNombresBaseUnicos() {
/* 3464 */     String pie = "";
/* 3465 */     if (this.jRadioButton1.isSelected()) {
/* 3466 */       pie = "COSTO EN CONSUMOS";
/* 3467 */     } else if (this.jRadioButton3.isSelected()) {
/* 3468 */       pie = "SUMAS";
/*      */     } 
/*      */ 
/*      */     
/* 3472 */     moverFilasVeracruzAlInicio(this.jTable3);
/* 3473 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/*      */     
/* 3475 */     String baseAnterior = "";
/*      */     
/*      */     int i;
/* 3478 */     for (i = 0; i < model.getRowCount(); i++) {
/*      */       
/* 3480 */       String baseActual = (String)model.getValueAt(i, 0);
/*      */ 
/*      */       
/* 3483 */       if (!baseActual.equals(baseAnterior) && !baseActual.equals(pie)) {
/*      */         
/* 3485 */         model.insertRow(i, new Object[] { baseActual, "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/*      */         
/* 3487 */         baseAnterior = baseActual;
/*      */         
/* 3489 */         i++;
/*      */       } 
/*      */     } 
/*      */     
/* 3493 */     for (i = 0; i < model.getRowCount(); i++) {
/* 3494 */       String area = (String)model.getValueAt(i, 1);
/*      */       
/* 3496 */       if (!area.equals("")) {
/* 3497 */         model.setValueAt("", i, 0);
/*      */       }
/*      */     } 
/*      */     
/* 3501 */     insertarRenglonVacio(this.jTable3);
/*      */   }
/*      */   
/*      */   public void insertarRenglonVacio(JTable tabla) {
/* 3505 */     DefaultTableModel model = (DefaultTableModel)tabla.getModel();
/* 3506 */     int rowCount = model.getRowCount();
/*      */ 
/*      */     
/* 3509 */     for (int i = rowCount - 1; i >= 0; i--) {
/* 3510 */       Object baseValue = model.getValueAt(i, 0);
/*      */       
/* 3512 */       if (baseValue != null && !baseValue.toString().isEmpty()) {
/*      */         
/* 3514 */         model.insertRow(i, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/* 3515 */         model.insertRow(i, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
/*      */       } 
/*      */     } 
/* 3518 */     this.utilerias.eliminarRegTabla(this.jTable3, 0);
/* 3519 */     this.utilerias.eliminarRegTabla(this.jTable3, 0);
/*      */   }
/*      */   
/*      */   public void moverFilasVeracruzAlInicio(JTable tabla) {
/* 3523 */     DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
/* 3524 */     int rowCount = modelo.getRowCount();
/* 3525 */     int posicionInsertar = 0;
/*      */ 
/*      */     
/* 3528 */     for (int i = 0; i < rowCount; i++) {
/*      */       
/* 3530 */       String valorColumna0 = (String)modelo.getValueAt(i, 0);
/*      */ 
/*      */       
/* 3533 */       if ("VERACRUZ".equals(valorColumna0)) {
/*      */         
/* 3535 */         Object[] fila = new Object[modelo.getColumnCount()];
/* 3536 */         for (int j = 0; j < modelo.getColumnCount(); j++) {
/* 3537 */           fila[j] = modelo.getValueAt(i, j);
/*      */         }
/*      */ 
/*      */         
/* 3541 */         modelo.removeRow(i);
/* 3542 */         modelo.insertRow(posicionInsertar, fila);
/*      */ 
/*      */         
/* 3545 */         posicionInsertar++;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarTotalGlobal() {
/* 3551 */     String pie = "";
/* 3552 */     if (this.jRadioButton1.isSelected()) {
/* 3553 */       pie = "COSTO EN CONSUMOS";
/* 3554 */     } else if (this.jRadioButton3.isSelected()) {
/* 3555 */       pie = "SUMAS";
/*      */     } 
/*      */     
/* 3558 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 3559 */     int[] totalesPorColumna = new int[model.getColumnCount()];
/* 3560 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3561 */       for (int k = 2; k < model.getColumnCount(); k++) {
/* 3562 */         Object value = model.getValueAt(i, k);
/* 3563 */         if (value instanceof Number) {
/* 3564 */           totalesPorColumna[k] = totalesPorColumna[k] + ((Number)value).intValue();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3569 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/* 3570 */     Object[] newRowData = new Object[model.getColumnCount()];
/* 3571 */     newRowData[1] = pie;
/* 3572 */     newRowData[0] = "";
/* 3573 */     for (int j = 2; j < model.getColumnCount(); j++) {
/* 3574 */       newRowData[j] = Integer.valueOf(totalesPorColumna[j]);
/*      */     }
/* 3576 */     model.addRow(newRowData);
/*      */   }
/*      */   
/*      */   public void calcularTotales() {
/* 3580 */     DefaultTableModel model = (DefaultTableModel)this.jTable3.getModel();
/* 3581 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3582 */       int total = 0;
/* 3583 */       for (int j = model.findColumn("Ene"); j <= model.findColumn("Dic"); j++) {
/* 3584 */         Object value = model.getValueAt(i, j);
/* 3585 */         if (value instanceof Number) {
/* 3586 */           total += ((Number)value).intValue();
/* 3587 */           model.setValueAt(Integer.valueOf(total), i, model.findColumn("Total"));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private int obtenerIndiceMes(String mes) {
/* 3594 */     String[] meses = { "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" };
/* 3595 */     for (int i = 0; i < meses.length; i++) {
/* 3596 */       if (meses[i].equals(mes)) {
/* 3597 */         return i;
/*      */       }
/*      */     } 
/* 3600 */     return -1;
/*      */   }
/*      */   
/*      */   public void llenarCeldasVaciasConCeros(JTable jTable2) {
/* 3604 */     DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
/* 3605 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3606 */       for (int j = 0; j < model.getColumnCount(); j++) {
/* 3607 */         Object valor = model.getValueAt(i, j);
/* 3608 */         if (valor == null || valor.toString().isEmpty()) {
/* 3609 */           model.setValueAt(Integer.valueOf(0), i, j);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void ordenarSegundaParte(int numCol) {
/* 3616 */     DefaultTableModel model = (DefaultTableModel)this.jTable2.getModel();
/* 3617 */     Map<String, Map<String, Double>> sumasPorBaseYArea = new TreeMap<>();
/*      */     
/* 3619 */     for (int i = 0; i < model.getRowCount(); i++) {
/* 3620 */       String base = (String)model.getValueAt(i, 0);
/* 3621 */       String area = (String)model.getValueAt(i, 1);
/* 3622 */       double ene = this.utilerias.convertirCantTexto(model.getValueAt(i, numCol).toString());
/* 3623 */       if (!sumasPorBaseYArea.containsKey(base)) {
/* 3624 */         sumasPorBaseYArea.put(base, new TreeMap<>());
/*      */       }
/* 3626 */       Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3627 */       if (!sumasPorArea.containsKey(area)) {
/* 3628 */         sumasPorArea.put(area, Double.valueOf(0.0D));
/*      */       }
/* 3630 */       sumasPorArea.put(area, Double.valueOf(((Double)sumasPorArea.get(area)).doubleValue() + ene));
/*      */     } 
/*      */     
/* 3633 */     if (!this.llenarPrimera) {
/* 3634 */       this.llenarPrimera = true;
/* 3635 */       for (String base : sumasPorBaseYArea.keySet()) {
/* 3636 */         Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3637 */         for (String area : sumasPorArea.keySet()) {
/* 3638 */           agregarBaseArea(base, area);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3644 */     for (String base : sumasPorBaseYArea.keySet()) {
/* 3645 */       Map<String, Double> sumasPorArea = sumasPorBaseYArea.get(base);
/* 3646 */       for (String area : sumasPorArea.keySet()) {
/* 3647 */         Double suma = sumasPorArea.get(area);
/* 3648 */         DefaultTableModel modelNueva = (DefaultTableModel)this.jTable3.getModel();
/* 3649 */         for (int j = 0; j < modelNueva.getRowCount(); j++) {
/* 3650 */           Object baseN = modelNueva.getValueAt(j, 0);
/* 3651 */           Object areaN = modelNueva.getValueAt(j, 1);
/* 3652 */           if (baseN.toString().equals(base) && areaN.equals(area)) {
/* 3653 */             modelNueva.setValueAt(suma, j, numCol);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarBaseArea(String Base, String Area) {
/* 3661 */     this.utilerias.agregarCampoTablas(new String[] { Base, Area, "", "", "", "", "", "", "", "", "", "", "", "", "" }, this.jTable3);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable tabla) {
/* 3665 */     DefaultTableModel modeloTablaAux = new DefaultTableModel();
/*      */     
/* 3667 */     modeloTablaAux.addColumn("cont");
/* 3668 */     modeloTablaAux.addColumn("Folio");
/* 3669 */     modeloTablaAux.addColumn("Fecha");
/* 3670 */     modeloTablaAux.addColumn("Tipo");
/* 3671 */     modeloTablaAux.addColumn("Origen");
/* 3672 */     modeloTablaAux.addColumn("Referencia");
/* 3673 */     modeloTablaAux.addColumn("Costo");
/* 3674 */     modeloTablaAux.addColumn("Solicita");
/* 3675 */     modeloTablaAux.addColumn("Area");
/* 3676 */     modeloTablaAux.addColumn("Sucursal");
/*      */     
/* 3678 */     DefaultTableModel modeloTablaExistente = (DefaultTableModel)tabla.getModel();
/* 3679 */     for (int i = 0; i < modeloTablaExistente.getRowCount(); i++) {
/* 3680 */       Object[] fila = new Object[modeloTablaAux.getColumnCount()];
/*      */       
/* 3682 */       fila[0] = Integer.valueOf(i + 1);
/* 3683 */       fila[1] = modeloTablaExistente.getValueAt(i, 1);
/* 3684 */       fila[2] = this.utilerias.convertirFechaDateStringBarras(this.utilerias.convertirFechaStringADate(modeloTablaExistente.getValueAt(i, 2).toString()));
/* 3685 */       fila[3] = modeloTablaExistente.getValueAt(i, 3);
/* 3686 */       fila[4] = modeloTablaExistente.getValueAt(i, 4);
/* 3687 */       fila[5] = modeloTablaExistente.getValueAt(i, 6);
/* 3688 */       fila[6] = this.utilerias.convertirCantSinDecimalesAPESOS(modeloTablaExistente.getValueAt(i, 7).toString());
/* 3689 */       fila[7] = modeloTablaExistente.getValueAt(i, 8);
/* 3690 */       fila[8] = modeloTablaExistente.getValueAt(i, 9);
/* 3691 */       fila[9] = modeloTablaExistente.getValueAt(i, 10);
/*      */       
/* 3693 */       modeloTablaAux.addRow(fila);
/*      */     } 
/* 3695 */     JTable tablaAux = new JTable();
/* 3696 */     tablaAux.setModel(modeloTablaAux);
/* 3697 */     return tablaAux;
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux3(JTable tabla) {
/* 3701 */     DefaultTableModel modeloTablaAux = new DefaultTableModel();
/* 3702 */     modeloTablaAux.addColumn("Cont");
/* 3703 */     modeloTablaAux.addColumn("Codigo");
/* 3704 */     modeloTablaAux.addColumn("Desc");
/* 3705 */     modeloTablaAux.addColumn("Cant");
/* 3706 */     modeloTablaAux.addColumn("Medida");
/*      */ 
/*      */ 
/*      */     
/* 3710 */     DefaultTableModel modeloTablaExistente = (DefaultTableModel)tabla.getModel();
/* 3711 */     for (int i = 0; i < modeloTablaExistente.getRowCount(); i++) {
/* 3712 */       Object[] fila = new Object[modeloTablaAux.getColumnCount()];
/*      */       
/* 3714 */       fila[0] = Integer.valueOf(i + 1);
/* 3715 */       fila[1] = modeloTablaExistente.getValueAt(i, 0);
/* 3716 */       fila[2] = modeloTablaExistente.getValueAt(i, 2);
/* 3717 */       fila[3] = modeloTablaExistente.getValueAt(i, 3);
/* 3718 */       fila[4] = modeloTablaExistente.getValueAt(i, 4);
/*      */ 
/*      */       
/* 3721 */       modeloTablaAux.addRow(fila);
/*      */     } 
/* 3723 */     JTable tablaAux = new JTable();
/* 3724 */     tablaAux.setModel(modeloTablaAux);
/* 3725 */     return tablaAux;
/*      */   }
/*      */   
/*      */   public void imprimirVistaActual() {
/* 3729 */     JTable aux = crearTablaAux2((JTable)this.rSTableMetro1);
/* 3730 */     Map<Object, Object> datos = new HashMap<>();
/* 3731 */     String fechaCompleta = "";
/*      */     
/* 3733 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 3734 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3735 */       String cadenaFecha1 = formato.format(this.jDateChooser11.getDate());
/* 3736 */       String año = cadenaFecha1.substring(0, 4);
/* 3737 */       String mes = cadenaFecha1.substring(4, 6);
/* 3738 */       String dia = cadenaFecha1.substring(6, 8);
/* 3739 */       fechaCompleta = dia + "/" + dia + "/" + mes;
/* 3740 */       cadenaFecha1 = formato.format(this.jDateChooser12.getDate());
/* 3741 */       año = cadenaFecha1.substring(0, 4);
/* 3742 */       mes = cadenaFecha1.substring(4, 6);
/* 3743 */       dia = cadenaFecha1.substring(6, 8);
/* 3744 */       fechaCompleta = fechaCompleta + " AL " + fechaCompleta + "/" + dia + "/" + mes;
/*      */     } else {
/* 3746 */       fechaCompleta = String.valueOf(this.jComboBox1.getSelectedItem()) + "/" + String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     } 
/*      */     
/* 3749 */     String TIPO = "TODOS";
/* 3750 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 3751 */       TIPO = this.jComboBox7.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3754 */     String ORIGENDESTINO = "TODOS";
/* 3755 */     if (!this.jTextField1.getText().equals(this.holderEquipo)) {
/* 3756 */       ORIGENDESTINO = this.jTextField1.getText().toUpperCase();
/*      */     }
/*      */     
/* 3759 */     String MERCANCIA = "TODAS";
/* 3760 */     if (!this.jTextField3.getText().equals(this.holderProducto)) {
/* 3761 */       MERCANCIA = this.jTextField3.getText().toUpperCase();
/*      */     }
/*      */     
/* 3764 */     String AREA = "TODAS";
/* 3765 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3766 */       AREA = this.jComboBox3.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3769 */     String SOLICITA = "GENERAL";
/* 3770 */     if (!this.jTextField2.getText().equals(this.holderSolicita)) {
/* 3771 */       SOLICITA = this.jTextField2.getText().toUpperCase();
/*      */     }
/*      */     
/* 3774 */     String SUCURSAL = "TODAS";
/* 3775 */     if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3776 */       SUCURSAL = this.jComboBox23.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3779 */     String ESTATUS = "ACTIVOS";
/* 3780 */     if (this.jComboBox24.getSelectedIndex() != 0) {
/* 3781 */       ESTATUS = this.jComboBox24.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3784 */     String TITULO = "";
/* 3785 */     String LeyendaTipo = "";
/* 3786 */     if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3787 */       TITULO = "REPORTE DE ENTRADAS Y SALIDAS";
/* 3788 */       LeyendaTipo = "ENTRADA / SALIDA";
/* 3789 */     } else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 3790 */       TITULO = "REPORTE DE ENTRADAS DE ALMACÉN";
/* 3791 */       LeyendaTipo = "ENTRADAS";
/* 3792 */     } else if (this.jComboBox7.getSelectedIndex() == 2) {
/* 3793 */       TITULO = "REPORTE DE SALIDAS DE ALMACÉN";
/* 3794 */       LeyendaTipo = "SALIDAS";
/*      */     } 
/*      */     
/* 3797 */     String leyendaEntrada = "";
/* 3798 */     String leyendaSalida = "";
/* 3799 */     String montoEntrada = "";
/* 3800 */     String montoSalida = "";
/*      */     
/* 3802 */     if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3803 */       leyendaEntrada = "COSTO DE ENTRADAS: ";
/* 3804 */       leyendaSalida = "COSTO DE SALIDAS: ";
/* 3805 */       montoEntrada = this.jLabel39.getText();
/* 3806 */       montoSalida = this.jLabel40.getText();
/* 3807 */     } else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 3808 */       leyendaEntrada = "COSTO DE ENTRADAS: ";
/* 3809 */       leyendaSalida = "";
/* 3810 */       montoEntrada = this.jLabel39.getText();
/* 3811 */       montoSalida = "";
/* 3812 */     } else if (this.jComboBox7.getSelectedIndex() == 2) {
/* 3813 */       leyendaEntrada = "";
/* 3814 */       leyendaSalida = "COSTO DE SALIDAS: ";
/* 3815 */       montoEntrada = "";
/* 3816 */       montoSalida = this.jLabel40.getText();
/*      */     } 
/*      */     
/* 3819 */     datos.put("titulo", TITULO);
/* 3820 */     datos.put("fecha", fechaCompleta);
/* 3821 */     datos.put("tipo", LeyendaTipo);
/* 3822 */     datos.put("origen", ORIGENDESTINO);
/* 3823 */     datos.put("mercancia", MERCANCIA);
/* 3824 */     datos.put("solicita", SOLICITA);
/* 3825 */     datos.put("area", AREA);
/* 3826 */     datos.put("sucursal", SUCURSAL);
/* 3827 */     datos.put("estatus", ESTATUS);
/*      */     
/* 3829 */     datos.put("LeyendaEntrada", leyendaEntrada);
/* 3830 */     datos.put("LeyendaSalida", leyendaSalida);
/* 3831 */     datos.put("TEntrada", montoEntrada);
/* 3832 */     datos.put("TSalida", montoSalida);
/* 3833 */     datos.put("TSalida", montoSalida);
/* 3834 */     datos.put("origen-destino", LeyendaTipo);
/*      */     
/* 3836 */     this.utilerias.cargarImagenesAReporte(datos);
/*      */     try {
/* 3838 */       this.utilerias.verImpresion("/Reportes/Almacen/Alm_EntradaSalida.jasper", aux, datos, TITULO);
/* 3839 */     } catch (JRException ex) {
/* 3840 */       Logger.getLogger(AlmProductos.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void ingresarCantidad() {
/* 3845 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 3846 */     String prod = this.rSTableMetro5.getValueAt(ind, 1).toString();
/* 3847 */     if (this.utilerias.buscarDatoEnTabla((JTable)this.rSTableMetro2, prod, 2)) {
/* 3848 */       JOptionPane.showMessageDialog(this.jDialog5, "El producto que deseas agregar ya se encuentra en la ORDEN", "Selecciona otro producto", 0, this.ADVER);
/*      */     }
/* 3850 */     else if (this.jTextField4.getText().contains("EN")) {
/*      */ 
/*      */       
/* 3853 */       double cant = 1.0D;
/*      */ 
/*      */       
/* 3856 */       this.jTextField16.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1).toString());
/* 3857 */       this.jTextField17.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 3).toString());
/* 3858 */       this.jSpinner2.setValue(Double.valueOf(1.0D));
/* 3859 */       this.jTextField18.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4).toString());
/* 3860 */       this.jTextField19.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 9).toString());
/* 3861 */       this.jTextField20.setText("" + 
/* 3862 */           Double.parseDouble(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 7).toString()) + cant);
/*      */ 
/*      */       
/* 3865 */       this.jTextField21.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 9).toString());
/* 3866 */       this.jDialog6.setVisible(true);
/* 3867 */     } else if (this.jTextField4.getText().contains("SA")) {
/* 3868 */       double disp = Double.parseDouble(this.rSTableMetro5.getValueAt(ind, 7).toString());
/* 3869 */       if (disp < 0.0D) {
/* 3870 */         JOptionPane.showMessageDialog(this.jDialog5, "El producto que seleccionaste NO TIENE SUFICIENTE DISPONIBILIDAD, verifica tu información", "Selecciona otro producto", 0, this.ADVER);
/*      */       }
/*      */       else {
/*      */         
/* 3874 */         double cant = 1.0D;
/* 3875 */         this.jTextField16.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1).toString());
/* 3876 */         this.jTextField17.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 3).toString());
/* 3877 */         this.jSpinner2.setValue(Double.valueOf(1.0D));
/* 3878 */         this.jTextField18.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4).toString());
/* 3879 */         this.jTextField19.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 9).toString());
/* 3880 */         this.jTextField20.setText("" + 
/* 3881 */             Double.parseDouble(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 7).toString()) - cant);
/*      */ 
/*      */         
/* 3884 */         this.jTextField21.setText(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 9).toString());
/* 3885 */         this.jDialog6.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private String getProductos() {
/* 3892 */     StringBuilder productos = new StringBuilder();
/* 3893 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 3894 */       productos.append(this.rSTableMetro2.getValueAt(i, 2)).append(" | ");
/*      */     }
/* 3896 */     return productos.toString();
/*      */   }
/*      */   
/*      */   private void modificarOperacion(String operationType, String productos) {
/* 3900 */     this.actualizado = true;
/* 3901 */     Map<String, Object> campos = new HashMap<>();
/* 3902 */     campos.put("fecha", "'" + this.utilerias.convertirFechaDateString(this.jDateChooser6.getDate()) + "'");
/* 3903 */     campos.put("tipoEquipo", "'" + String.valueOf(this.jComboBox9.getSelectedItem()) + "'");
/* 3904 */     campos.put("origenDestino", "'" + this.jTextField5.getText().toUpperCase() + "'");
/* 3905 */     campos.put("referencia", "'" + this.jTextField7.getText().toUpperCase() + "'");
/* 3906 */     campos.put("productos", "'" + productos + "'");
/* 3907 */     campos.put("costo", "'" + this.jTextField8.getText().toUpperCase() + "'");
/* 3908 */     campos.put("solicita", "'" + this.jTextField9.getText().toUpperCase() + "'");
/* 3909 */     campos.put("autoriza", "'" + this.jTextField10.getText().toUpperCase() + "'");
/* 3910 */     campos.put("entrega", "'" + this.jTextField11.getText().toUpperCase() + "'");
/* 3911 */     campos.put("base", "'" + String.valueOf(this.jComboBox5.getSelectedItem()) + "'");
/* 3912 */     campos.put("area", "'" + String.valueOf(this.jComboBox6.getSelectedItem()) + "'");
/* 3913 */     campos.put("comentario", "'" + this.jTextPane1.getText().toUpperCase() + "'");
/* 3914 */     campos.put("actualizacion", "'" + this.utilerias.sacarUsuario(this.USUARIO) + "'");
/* 3915 */     campos.put("estatus", "'" + String.valueOf(this.jComboBox12.getSelectedItem()) + "'");
/* 3916 */     this.con2.actualizarReg("alm_operaciones", campos, "WHERE folio = '" + this.jTextField4.getText() + "'");
/* 3917 */     if (this.ENTRAMODIFICAR) {
/* 3918 */       this.con2.eliminar2("alm_operaciones_prod", "where folioOP = '" + this.jTextField4.getText() + "'");
/* 3919 */       insertarProductos();
/*      */     } 
/* 3921 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "Los datos se han almacenado correctamente.\n ¿Deseas imprimir la orden?", "Imprimir", 0, 3, this.PREG);
/* 3922 */     if (res == 0) {
/* 3923 */       imprimirOrden();
/*      */     }
/* 3925 */     this.jDialog1.setVisible(false);
/* 3926 */     consultar();
/*      */   }
/*      */   
/*      */   private void handleOperation(String operationType, String productos) {
/* 3930 */     if (operationType.equals("ENTRADA")) {
/* 3931 */       sacarMayorEntrada();
/*      */     } else {
/* 3933 */       sacarMayorSalida();
/*      */     } 
/* 3935 */     this.con2.inserSinMsj("insert into alm_operaciones(conse, fecha, folio, tipo, tipoEquipo, origenDestino, referencia, productos, costo, solicita, autoriza, entrega, base, area, comentario, actualizacion, estatus) values (" + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3946 */         sacarConsecutivo(this.jTextField4.getText()) + ", '" + this.utilerias.convertirFechaDateString(this.jDateChooser6.getDate()) + "', '" + this.jTextField4
/* 3947 */         .getText() + "', '" + operationType + "',  '" + 
/* 3948 */         String.valueOf(this.jComboBox9.getSelectedItem()) + "', '" + this.jTextField5.getText().toUpperCase() + "', '" + this.jTextField7
/* 3949 */         .getText().toUpperCase() + "', '" + productos + "', '" + this.jTextField8
/* 3950 */         .getText().toUpperCase() + "', '" + this.jTextField9.getText().toUpperCase() + "', '" + this.jTextField10
/* 3951 */         .getText().toUpperCase() + "', '" + this.jTextField11.getText().toUpperCase() + "', '" + 
/* 3952 */         String.valueOf(this.jComboBox5.getSelectedItem()) + "', '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "', '" + this.jTextPane1
/* 3953 */         .getText().toUpperCase() + "', '" + this.utilerias.sacarUsuario(this.USUARIO) + "', '<Por Autorizar>')");
/*      */ 
/*      */     
/* 3956 */     insertarProductos();
/* 3957 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "Los datos se han almacenado correctamente.\n ¿Deseas imprimir la orden?", "Imprimir", 0, 3, this.PREG);
/* 3958 */     if (res == 0) {
/* 3959 */       imprimirOrden();
/*      */     }
/* 3961 */     this.jDialog1.setVisible(false);
/* 3962 */     consultar();
/*      */   }
/*      */   
/*      */   public void actualizarStock(String tipo, String[] reg, String folio) {
/* 3966 */     double inv = this.utilerias.convertirCantTexto(reg[3]) * Double.parseDouble(reg[4]);
/* 3967 */     Map<String, Object> campos = new HashMap<>();
/* 3968 */     if (tipo.equals("ENTRADA")) {
/* 3969 */       campos.put("fechaUltimaEntrada", "now()");
/*      */     }
/* 3971 */     campos.put("fechaUltimoMov", "now()");
/* 3972 */     campos.put("ultimoMov", "'" + tipo + "'");
/* 3973 */     campos.put("disponibles", "'" + reg[4] + "'");
/* 3974 */     campos.put("inversion", "'" + this.utilerias.convertirDoublePesos(inv) + "'");
/* 3975 */     campos.put("actualizacion", "'" + this.utilerias.sacarUsuario(this.USUARIO) + "'");
/* 3976 */     this.con2.actualizarReg("alm_productos", campos, "where refInterna = '" + reg[0] + "' and descInterna ='" + reg[1] + "'");
/*      */   }
/*      */   
/*      */   public void insertarProductos() {
/* 3980 */     String conceptos = "";
/* 3981 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3992 */       conceptos = conceptos + "('" + conceptos + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 0)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 1)) + "', " + String.valueOf(this.rSTableMetro2.getValueAt(i, 2)) + ", '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 3)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 4)) + "', '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 5)) + "', " + String.valueOf(this.rSTableMetro2.getValueAt(i, 6)) + ", '" + String.valueOf(this.rSTableMetro2.getValueAt(i, 7)) + "')";
/*      */       
/* 3994 */       if (i + 1 < this.rSTableMetro2.getRowCount()) {
/* 3995 */         conceptos = conceptos + " , ";
/*      */       }
/*      */     } 
/* 3998 */     this.con2.inserSinMsj("INSERT INTO alm_operaciones_prod (codigo, tipo, descInterna, cant, unidadMed, precioUnit, costo, nuevoStock, folioOP) VALUES " + conceptos);
/*      */   }
/*      */   
/*      */   public void carcarAutoCompletar() {
/* 4002 */     this.com_Autoriza.addItems((Object[])this.AUTORIZA);
/* 4003 */     this.com_Solicita.addItems((Object[])this.SOLICITA);
/* 4004 */     this.com_Recibe.addItems((Object[])this.RECIBE);
/*      */   }
/*      */   
/*      */   public void desactivar() {
/* 4008 */     this.jDateChooser6.setEnabled(false);
/* 4009 */     this.jComboBox5.setEnabled(false);
/* 4010 */     this.jComboBox6.setEnabled(false);
/* 4011 */     this.jComboBox9.setEnabled(false);
/* 4012 */     this.jTextField5.setEnabled(false);
/* 4013 */     this.jTextField7.setEnabled(false);
/* 4014 */     this.jButton52.setEnabled(false);
/* 4015 */     this.jButton53.setEnabled(false);
/* 4016 */     this.jTextField7.setEnabled(false);
/* 4017 */     this.jTextField9.setEnabled(false);
/* 4018 */     this.jTextField10.setEnabled(false);
/* 4019 */     this.jTextField11.setEnabled(false);
/* 4020 */     this.jTextPane1.setEnabled(false);
/* 4021 */     this.jComboBox12.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void habilitar() {
/* 4025 */     this.jDateChooser6.setEnabled(true);
/* 4026 */     this.jComboBox5.setEnabled(true);
/* 4027 */     this.jComboBox6.setEnabled(true);
/* 4028 */     this.jComboBox9.setEnabled(true);
/* 4029 */     this.jTextField5.setEnabled(true);
/* 4030 */     this.jTextField7.setEnabled(true);
/* 4031 */     this.jButton52.setEnabled(true);
/* 4032 */     this.jButton53.setEnabled(true);
/* 4033 */     this.jTextField7.setEnabled(true);
/* 4034 */     this.jTextField9.setEnabled(true);
/* 4035 */     this.jTextField10.setEnabled(true);
/* 4036 */     this.jTextField11.setEnabled(true);
/* 4037 */     this.jTextPane1.setEnabled(true);
/* 4038 */     this.jComboBox12.setEnabled(true);
/* 4039 */     this.materialButton20.setVisible(true);
/*      */   }
/*      */   
/*      */   public void verOrden() {
/* 4043 */     int selec = this.rSTableMetro1.getSelectedRow();
/* 4044 */     String[] orden = this.con2.regresaRegIndex("fecha, tipo, tipoEquipo, origenDestino, referencia, productos, costo, solicita, autoriza, entrega, base, area, comentario, estatus", "alm_operaciones", "where movOp = " + 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4053 */         String.valueOf(this.rSTableMetro1.getValueAt(selec, 0)));
/*      */     
/* 4055 */     this.jTextField4.setText(this.rSTableMetro1.getValueAt(selec, 1).toString());
/* 4056 */     this.jDateChooser6.setDate(this.utilerias.convertirFechaStringADate(orden[0]));
/* 4057 */     this.jComboBox5.setSelectedItem(orden[10]);
/* 4058 */     this.jComboBox6.setSelectedItem(orden[11]);
/* 4059 */     this.jComboBox9.setSelectedItem(orden[2]);
/* 4060 */     this.jTextField5.setText(orden[3]);
/* 4061 */     this.jTextField7.setText(orden[4]);
/* 4062 */     this.jTextField9.setText(orden[7]);
/* 4063 */     this.jTextField10.setText(orden[8]);
/* 4064 */     this.jTextField11.setText(orden[9]);
/* 4065 */     this.jTextPane1.setText(orden[12]);
/* 4066 */     this.jComboBox12.setSelectedItem(orden[13]);
/*      */     
/* 4068 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro2, new String[] { "Código", "Tipo", "Desc Interna", "Cant", "U / M", "Precio", "Costo", "Nuevo Stock" }, "codigo, tipo, descInterna, cant, unidadMed, precioUnit, costo, nuevoStock", "alm_operaciones_prod", "where folioOP = '" + this.jTextField4
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4074 */         .getText() + "'");
/*      */     
/* 4076 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda1);
/* 4077 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 2, 260);
/* 4078 */     sumasCostos();
/* 4079 */     this.jComboBox12.setVisible(true);
/* 4080 */     if (this.jTextField4.getText().contains("EN")) {
/* 4081 */       this.jLabel18.setText("Tipo de Entrada");
/*      */     } else {
/* 4083 */       this.jLabel18.setText("Tipo de Destino");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void buscarProductos() {
/* 4088 */     this.jLabel82.setText(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0).toString());
/* 4089 */     agregarProdcutosRequi();
/* 4090 */     compararProdcutos();
/* 4091 */     revisarNuevosStock();
/* 4092 */     this.jLabel81.setText("" + this.rSTableMetro4.getRowCount());
/* 4093 */     this.jDialog2.setVisible(false);
/* 4094 */     this.jDialog3.setVisible(true);
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
/*      */   public void pasarDatosdelProducto() {
/* 4106 */     String[] dat = { this.jTextField17.getText(), this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 2).toString(), this.jTextField16.getText(), this.jSpinner2.getValue().toString(), this.jTextField18.getText(), this.jTextField19.getText(), this.jTextField21.getText(), this.jTextField20.getText() };
/* 4107 */     this.utilerias.agregarCampoTablas(dat, (JTable)this.rSTableMetro2);
/*      */   }
/*      */   
/*      */   public void validarSelecPositivo() {
/* 4111 */     boolean todoBien = true;
/* 4112 */     for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 4113 */       boolean selec = Boolean.valueOf(this.rSTableMetro4.getValueAt(i, 0).toString()).booleanValue();
/* 4114 */       Integer entrada = Integer.valueOf(Integer.parseInt(this.rSTableMetro4.getValueAt(i, 3).toString()));
/* 4115 */       if (selec && entrada.intValue() == 0) {
/* 4116 */         JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar cantidades en cero cuando el producto está seleccionado", "Falta cantidad", 0, this.ERROR);
/* 4117 */         todoBien = false;
/*      */         break;
/*      */       } 
/*      */     } 
/* 4121 */     if (todoBien) {
/* 4122 */       pasarArticulos();
/*      */     }
/*      */   }
/*      */   
/*      */   public void calcularCosto() {
/* 4127 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/* 4128 */       int cant = Integer.parseInt(this.rSTableMetro2.getValueAt(i, 3).toString());
/* 4129 */       double precio = this.utilerias.convertirCantTexto(this.rSTableMetro2.getValueAt(i, 5).toString());
/* 4130 */       this.rSTableMetro2.setValueAt(this.utilerias.convertirDoublePesos(cant * precio), i, 6);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sumasCostos() {
/* 4135 */     this.jTextField8.setText(this.utilerias.convertirDoublePesos(this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 6)));
/* 4136 */     this.jTextField22.setText("" + this.rSTableMetro2.getRowCount());
/* 4137 */     this.jTextField23.setText("" + this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro2, 3));
/*      */   }
/*      */   
/*      */   public int sacarConsecutivo(String cad) {
/* 4141 */     Pattern pattern = Pattern.compile("\\d+");
/* 4142 */     Matcher matcher = pattern.matcher(cad);
/* 4143 */     if (matcher.find()) {
/* 4144 */       String str = matcher.group();
/*      */     }
/*      */     
/* 4147 */     return Integer.parseInt(matcher.group());
/*      */   }
/*      */   
/*      */   public void sacarMayorEntrada() {
/* 4151 */     this.encontrado = this.con2.consultar("max(conse)", "alm_operaciones", "where tipo ='ENTRADA' ");
/* 4152 */     if (this.encontrado) {
/* 4153 */       this.CONSE = Integer.parseInt(this.con2.Campo);
/* 4154 */       this.CONSE++;
/* 4155 */       if (this.CONSE < 100) {
/* 4156 */         this.jTextField4.setText(this.DIRECTIVA + "-EN-000" + this.DIRECTIVA);
/* 4157 */       } else if (this.CONSE < 1000) {
/* 4158 */         this.jTextField4.setText(this.DIRECTIVA + "-EN-00" + this.DIRECTIVA);
/* 4159 */       } else if (this.CONSE < 10000) {
/* 4160 */         this.jTextField4.setText(this.DIRECTIVA + "-EN-0" + this.DIRECTIVA);
/*      */       } else {
/* 4162 */         this.jTextField4.setText(this.DIRECTIVA + "-EN-" + this.DIRECTIVA);
/*      */       } 
/*      */     } else {
/* 4165 */       this.jTextField4.setText(this.DIRECTIVA + "-EN-00001");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarMayorSalida() {
/* 4171 */     this.encontrado = this.con2.consultar("max(conse)", "alm_operaciones", "where tipo ='SALIDA' ");
/* 4172 */     if (this.encontrado) {
/* 4173 */       this.CONSE = Integer.parseInt(this.con2.Campo);
/* 4174 */       this.CONSE++;
/* 4175 */       if (this.CONSE < 100) {
/* 4176 */         this.jTextField4.setText(this.DIRECTIVA + "-SA-000" + this.DIRECTIVA);
/* 4177 */       } else if (this.CONSE < 1000) {
/* 4178 */         this.jTextField4.setText(this.DIRECTIVA + "-SA-00" + this.DIRECTIVA);
/* 4179 */       } else if (this.CONSE < 10000) {
/* 4180 */         this.jTextField4.setText(this.DIRECTIVA + "-SA-0" + this.DIRECTIVA);
/*      */       } else {
/* 4182 */         this.jTextField4.setText(this.DIRECTIVA + "-SA-" + this.DIRECTIVA);
/*      */       } 
/*      */     } else {
/* 4185 */       this.jTextField4.setText(this.DIRECTIVA + "-SA-00001");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void pasarArticulos() {
/* 4191 */     for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 4192 */       boolean selec = Boolean.valueOf(this.rSTableMetro4.getValueAt(i, 0).toString()).booleanValue();
/* 4193 */       String desc = this.rSTableMetro4.getValueAt(i, 2).toString();
/* 4194 */       if (selec) {
/* 4195 */         Productos p = ((List<Productos>)this.PRODUCTOS.stream().filter(x -> x.getDescInterna().equals(desc)).collect(Collectors.toList())).get(0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4203 */         String[] reg = { p.refInterna, p.tipoProd, p.descInterna, String.valueOf(this.rSTableMetro4.getValueAt(i, 3)), p.unidadMed, p.getCompraPrecio(), "", String.valueOf(this.rSTableMetro4.getValueAt(i, 4)) };
/*      */         
/* 4205 */         this.utilerias.agregarCampoTablas(reg, (JTable)this.rSTableMetro2);
/*      */       } 
/*      */     } 
/* 4208 */     calcularCosto();
/* 4209 */     sumasCostos();
/*      */   }
/*      */   
/*      */   public void contarArticulos() {
/* 4213 */     this.jLabel81.setText("" + this.utilerias.sumarColumnaTabla((JTable)this.rSTableMetro4, 4));
/*      */   }
/*      */   
/*      */   public void revisarNuevosStock() {
/* 4217 */     for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 4218 */       boolean selec = Boolean.valueOf(this.rSTableMetro4.getValueAt(i, 0).toString()).booleanValue();
/* 4219 */       String desc = this.rSTableMetro4.getValueAt(i, 2).toString();
/* 4220 */       int stock = 0;
/* 4221 */       if (selec) {
/* 4222 */         for (Productos p : this.PRODUCTOS) {
/* 4223 */           if (p.getDescInterna().equalsIgnoreCase(desc)) {
/* 4224 */             if (!selec) {
/* 4225 */               this.rSTableMetro4.setValueAt(Integer.valueOf(0), i, 3);
/*      */             }
/* 4227 */             stock = Integer.parseInt(p.getDisponibles()) + Integer.parseInt(this.rSTableMetro4.getValueAt(i, 3).toString());
/* 4228 */             this.rSTableMetro4.setValueAt(Integer.valueOf(stock), i, 4);
/*      */           } 
/*      */         } 
/*      */       } else {
/* 4232 */         this.rSTableMetro4.setValueAt(Integer.valueOf(0), i, 3);
/* 4233 */         this.rSTableMetro4.setValueAt(Integer.valueOf(0), i, 4);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void consultarCot() {
/* 4240 */     if (this.entraConsultaRequi) {
/* 4241 */       String folio = "";
/* 4242 */       if (!this.jTextField26.getText().equals(this.holderFolioCot)) {
/* 4243 */         folio = this.jTextField26.getText();
/*      */       }
/*      */       
/* 4246 */       String prov = "";
/* 4247 */       if (!this.jTextField27.getText().equals(this.holderProveedor)) {
/* 4248 */         prov = this.jTextField27.getText();
/*      */       }
/*      */       
/* 4251 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/* 4252 */       int aa = Integer.parseInt(this.jComboBox39.getSelectedItem().toString());
/* 4253 */       String consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.jComboBox38.getSelectedIndex() + 1] + "-" + aa + "' ";
/*      */       
/* 4255 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro3, new String[] { "Folio", "Fecha", "Proveedor", "Productos", "Área", "Actualizacion" }, "id_requi, fecha, prov_nombre, productos, area_nombre, actualizacion", "com_requi", "where prov_nombre like '%" + prov + "%' and id_requi like '%" + folio + "%'" + consultaFecha + " and estatus != '<Cancelada>' order by id_requi desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4261 */       this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3);
/* 4262 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 75);
/* 4263 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 1, 120);
/* 4264 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 5, 150);
/* 4265 */       this.jLabel80.setText("" + this.rSTableMetro3.getRowCount());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void almacen(String usua) {
/* 4270 */     this.PRODUCTOS.clear();
/* 4271 */     llenarProductos();
/* 4272 */     this.USUARIO = usua;
/* 4273 */     this.panel.setViewportView(this);
/* 4274 */     valorAlmacen();
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 4278 */     String[] equipos = this.con2.regresaColIndex("tipo", "alm_tipoEquipos", " order by tipo");
/* 4279 */     this.SUCURSALES = this.con2.regresaColIndex("nombre", "com_sucursales", "order by nombre");
/* 4280 */     this.AREAS = this.con2.regresaColIndex("nombre", "com_areas", "order by nombre");
/* 4281 */     this.CATEGORIAS = this.con2.regresaColIndex("categoria", "alm_categorias", "order by categoria");
/*      */     
/* 4283 */     this.utilerias.llenarCombo(this.jComboBox8, equipos);
/* 4284 */     this.utilerias.llenarCombo(this.jComboBox9, equipos);
/* 4285 */     this.utilerias.llenarCombo(this.jComboBox23, this.SUCURSALES);
/* 4286 */     this.utilerias.llenarCombo(this.jComboBox5, this.SUCURSALES);
/* 4287 */     this.utilerias.llenarCombo(this.jComboBox3, this.AREAS);
/* 4288 */     this.utilerias.llenarCombo(this.jComboBox6, this.AREAS);
/* 4289 */     this.utilerias.llenarCombo(this.jComboBox11, this.CATEGORIAS);
/*      */     
/* 4291 */     String[] solicita = this.con2.regresaColIndex("distinct(solicita)", "alm_operaciones", "order by solicita");
/* 4292 */     this.SOLICITA = solicita;
/* 4293 */     for (String c : solicita) {
/* 4294 */       agregarCampo(this.TODOS_SOLICITA, c);
/*      */     }
/* 4296 */     this.com_Solicita = new TextAutoCompleter(this.jTextField9, this.TODOS_SOLICITA);
/*      */     
/* 4298 */     String[] autoriza = this.con2.regresaColIndex("distinct(autoriza)", "alm_operaciones", "order by autoriza");
/* 4299 */     this.AUTORIZA = autoriza;
/* 4300 */     for (String c : autoriza) {
/* 4301 */       agregarCampo(this.TODOS_AUTORIZA, c);
/*      */     }
/* 4303 */     this.com_Autoriza = new TextAutoCompleter(this.jTextField10, this.TODOS_AUTORIZA);
/*      */     
/* 4305 */     String[] recibe = this.con2.regresaColIndex("distinct(origenDestino)", "alm_operaciones", "order by origenDestino");
/* 4306 */     this.RECIBE = recibe;
/* 4307 */     for (String c : recibe) {
/* 4308 */       agregarCampo(this.TODOS_RECIBE, c);
/*      */     }
/* 4310 */     this.com_Recibe = new TextAutoCompleter(this.jTextField5, this.TODOS_RECIBE);
/*      */   }
/*      */   
/*      */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 4314 */     if (!datos.contains(valor)) {
/* 4315 */       datos.add(valor);
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 4320 */     this.jButton1.setText("Buscar...");
/* 4321 */     this.jLabel3.setText("");
/* 4322 */     this.jComboBox5.setSelectedItem(this.CAMPOSGENERALES.get("sucursal"));
/* 4323 */     this.jComboBox6.setSelectedIndex(0);
/* 4324 */     this.jDateChooser6.setDate(new Date());
/* 4325 */     this.jComboBox9.setSelectedIndex(0);
/* 4326 */     this.jTextField5.setText("");
/* 4327 */     limpiarTablaProd();
/* 4328 */     this.jTextField8.setText("$0.00");
/* 4329 */     this.jTextField9.setText("");
/* 4330 */     this.jTextField10.setText("");
/* 4331 */     this.jTextField11.setText("");
/* 4332 */     this.jTextField7.setText("");
/* 4333 */     this.jTextPane1.setText("");
/* 4334 */     this.materialButton20.setText("Guardar");
/* 4335 */     this.materialButton20.setToolTipText("Guardar (Alt + G)");
/* 4336 */     this.materialButton20.setMnemonic('G');
/*      */     
/* 4338 */     this.jTextField22.setText("0");
/* 4339 */     this.jTextField23.setText("0");
/*      */   }
/*      */   
/*      */   public void agregarProdcutosRequi() {
/* 4343 */     DefaultTableModel modelo = (DefaultTableModel)this.rSTableMetro4.getModel();
/* 4344 */     String[][] prod = this.con2.buscarDatos("descInterna, cant", "com_requi_conceptos", "where id_requi = '" + this.jLabel82.getText() + "'");
/*      */     
/* 4346 */     for (int i = 0; i < prod.length; i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4352 */       Object[] campos = { Boolean.valueOf(true), prod[i][0], "", Integer.valueOf(Integer.parseInt(prod[i][1])), Integer.valueOf(1) };
/*      */       
/* 4354 */       modelo.addRow(campos);
/*      */     } 
/* 4356 */     setUpSportColumn((JTable)this.rSTableMetro4, this.rSTableMetro4.getColumnModel().getColumn(2));
/* 4357 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 0, 50);
/* 4358 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 3, 85);
/* 4359 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 4, 85);
/*      */   }
/*      */   
/*      */   public void cambiarTablaProductos() {
/* 4363 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "", " Productos en la cotización", "Productos en el almacén", "Entrada", "Nuevo Stock" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4369 */           Class[] types = new Class[] { Boolean.class, Object.class, Object.class, Integer.class, Object.class };
/*      */ 
/*      */           
/* 4372 */           boolean[] canEdit = new boolean[] { true, false, true, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4377 */             return this.types[columnIndex];
/*      */           }
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4381 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void valorAlmacen() {
/* 4387 */     this.VALORALMACEN = 0.0D;
/* 4388 */     String[] inv = this.con2.regresaColIndex("inversion", "alm_productos", "where estatus = 'ACTIVO' and tipoProd !='SERVICIO' order by descInterna");
/* 4389 */     for (String c : inv) {
/* 4390 */       this.VALORALMACEN += this.utilerias.convertirCantTexto(c);
/*      */     }
/* 4392 */     this.jLabel42.setText(this.utilerias.convertirDoublePesos(this.VALORALMACEN));
/*      */   }
/*      */   
/*      */   public void llenarProductos() {
/* 4396 */     this.VALORALMACEN = 0.0D;
/* 4397 */     String[][] p = this.con2.buscarDatos("idProd, unidadMed, tipoProd, descInterna, refInterna, compraPrecio, disponibles, inversion", "alm_productos", "where estatus = 'ACTIVO' and tipoProd !='SERVICIO' order by descInterna");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4402 */     for (String[] c : p) {
/* 4403 */       double val = this.utilerias.convertirCantTexto(c[7]);
/* 4404 */       this.VALORALMACEN += val;
/* 4405 */       this.PRODUCTOS.add(new Productos(c[0], c[1], c[2], c[3], c[4], c[5], c[6]));
/*      */     } 
/* 4407 */     this.jLabel42.setText(this.utilerias.convertirDoublePesos(this.VALORALMACEN));
/*      */   }
/*      */   
/*      */   public void setUpSportColumn(JTable table, TableColumn sportColumn) {
/* 4411 */     JComboBox<?> comboBox = new JComboBox();
/* 4412 */     this.PRODUCTOS.forEach(c -> comboBox.addItem(c.getDescInterna()));
/* 4413 */     sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
/* 4414 */     DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
/* 4415 */     renderer.setToolTipText("Clic para seleccionar el producto en el almacén");
/* 4416 */     sportColumn.setCellRenderer(renderer);
/* 4417 */     comboBox.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4419 */             AlmAlmacen.this.revisarNuevosStock();
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */   
/*      */   private void clicComboBox(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   public void compararProdcutos() {
/* 4429 */     for (int k = 0; k < this.rSTableMetro4.getRowCount(); k++) {
/*      */       
/* 4431 */       String producto1 = this.rSTableMetro4.getValueAt(k, 1).toString();
/* 4432 */       String[] palabrasProducto1 = producto1.split(" ");
/*      */       
/* 4434 */       int maxCoincidencias = 0;
/* 4435 */       int mejorPosicion = -1;
/* 4436 */       Productos mejorProducto = null;
/*      */ 
/*      */       
/* 4439 */       for (int i = 0; i < this.PRODUCTOS.size(); i++) {
/* 4440 */         Productos producto = this.PRODUCTOS.get(i);
/* 4441 */         String descInterna = producto.getDescInterna();
/* 4442 */         String[] palabrasProducto = descInterna.split(" ");
/*      */ 
/*      */         
/* 4445 */         int coincidencias = 0;
/* 4446 */         for (String palabra1 : palabrasProducto1) {
/* 4447 */           for (String palabraProducto : palabrasProducto) {
/* 4448 */             if (palabra1.equalsIgnoreCase(palabraProducto)) {
/* 4449 */               coincidencias++;
/*      */             }
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 4455 */         if (coincidencias > maxCoincidencias) {
/* 4456 */           maxCoincidencias = coincidencias;
/* 4457 */           mejorPosicion = i;
/* 4458 */           mejorProducto = producto;
/*      */         } 
/*      */       } 
/*      */       
/* 4462 */       if (mejorPosicion != -1) {
/* 4463 */         this.rSTableMetro4.setValueAt(mejorProducto.getDescInterna(), k, 2);
/*      */       } else {
/* 4465 */         System.out.println("No se encontraron coincidencias");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void limpiarTablaProd() {
/* 4471 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Código", "Tipo", "Desc Interna", "Cant", "U / M", "Precio", "Costo", "Nuevo Stock" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4477 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4482 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4486 */     this.rSTableMetro2.setAltoHead(25);
/* 4487 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 4488 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 4489 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 4490 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 4491 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 4492 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 4493 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 4494 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 4495 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 4496 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 4497 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 4498 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 4499 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 4500 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 4501 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda1);
/* 4502 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro2, 2, 260);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 4506 */     this.pintar.colorear(this.jTextField6);
/* 4507 */     this.pintar.colorear(this.jTextField1);
/* 4508 */     this.pintar.colorear(this.jTextField3);
/* 4509 */     this.pintar.colorear(this.jTextField2);
/* 4510 */     this.pintar.colorear(this.jTextField15);
/*      */     
/* 4512 */     this.pintar.colorear(this.jComboBox7);
/* 4513 */     this.pintar.colorear(this.jComboBox8);
/* 4514 */     this.pintar.colorear(this.jComboBox3);
/* 4515 */     this.pintar.colorear(this.jComboBox23);
/* 4516 */     this.pintar.colorear(this.jComboBox24);
/*      */     
/* 4518 */     this.pintar.colorear(this.jComboBox5);
/* 4519 */     this.pintar.colorear(this.jComboBox6);
/* 4520 */     this.pintar.colorear(this.jComboBox9);
/*      */     
/* 4522 */     this.pintar.colorear(this.jTextField4);
/* 4523 */     this.pintar.colorear(this.jTextField5);
/* 4524 */     this.pintar.colorear(this.jTextField9);
/* 4525 */     this.pintar.colorear(this.jTextField10);
/* 4526 */     this.pintar.colorear(this.jTextField11);
/* 4527 */     this.pintar.colorear(this.jTextPane1);
/* 4528 */     this.pintar.colorear(this.jTextField7);
/* 4529 */     this.pintar.colorear(this.jTextField26);
/*      */     
/* 4531 */     this.pintar.colorear(this.jTextField12);
/* 4532 */     this.pintar.colorear(this.jTextField13);
/* 4533 */     this.pintar.colorear(this.jTextField14);
/*      */     
/* 4535 */     this.pintar.colorear(this.jComboBox4);
/* 4536 */     this.pintar.colorear(this.jComboBox10);
/* 4537 */     this.pintar.colorear(this.jComboBox11);
/* 4538 */     this.pintar.colorear(this.jComboBox12);
/*      */   }
/*      */   
/*      */   public void consultarProductos() {
/* 4542 */     this.PRIMERA = true;
/* 4543 */     String id = "";
/* 4544 */     String desc = "";
/* 4545 */     String tipo = "";
/* 4546 */     String cat = "";
/* 4547 */     String ref = "";
/* 4548 */     String stock = "";
/*      */     
/* 4550 */     if (!this.jTextField12.getText().equals(this.holderId)) {
/* 4551 */       id = this.jTextField12.getText();
/*      */     }
/* 4553 */     if (!this.jTextField13.getText().equals(this.holderDesc)) {
/* 4554 */       desc = this.jTextField13.getText();
/*      */     }
/*      */     
/* 4557 */     if (!this.jTextField14.getText().equals(this.holderRefProd)) {
/* 4558 */       ref = this.jTextField14.getText();
/*      */     }
/*      */ 
/*      */     
/* 4562 */     if (id.contains("'")) {
/* 4563 */       id = id.replace("'", "");
/*      */     }
/*      */     
/* 4566 */     if (desc.contains("'")) {
/* 4567 */       desc = desc.replace("'", "");
/*      */     }
/*      */     
/* 4570 */     if (ref.contains("'")) {
/* 4571 */       ref = ref.replace("'", "");
/*      */     }
/*      */ 
/*      */     
/* 4575 */     if (this.jComboBox10.getSelectedIndex() == 0) {
/* 4576 */       tipo = " (tipoProd ='ALMACENABLE' || tipoProd ='CONSUMIBLE' )";
/*      */     }
/* 4578 */     else if (this.jComboBox10.getSelectedIndex() == 1) {
/* 4579 */       tipo = " (tipoProd ='ALMACENABLE')";
/*      */     }
/* 4581 */     else if (this.jComboBox10.getSelectedIndex() == 2) {
/* 4582 */       tipo = " (tipoProd ='CONSUMIBLE')";
/*      */     }
/* 4584 */     else if (this.jComboBox10.getSelectedIndex() == 3) {
/* 4585 */       tipo = " ( tipoProd ='SERVICIO') ";
/*      */     } 
/*      */ 
/*      */     
/* 4589 */     if (this.jComboBox11.getSelectedIndex() != 0) {
/* 4590 */       cat = this.jComboBox11.getSelectedItem().toString();
/*      */     }
/*      */     
/* 4593 */     if (this.jComboBox4.getSelectedIndex() == 1) {
/* 4594 */       stock = "disponibles < stockMin and ";
/* 4595 */     } else if (this.jComboBox4.getSelectedIndex() == 2) {
/* 4596 */       stock = "disponibles > stockMax and ";
/* 4597 */     } else if (this.jComboBox4.getSelectedIndex() == 3) {
/* 4598 */       stock = "disponibles > 0 and ";
/* 4599 */     } else if (this.jComboBox4.getSelectedIndex() == 4) {
/* 4600 */       stock = "disponibles = 0 and ";
/*      */     } 
/*      */     
/* 4603 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro5, new String[] { "ID", "Descripción Interna", "Tipo", "Ref Interna", "Unidad Med", "Min", "Max", "Disp", "Categorías", "cat2", "cat3", "Precio" }, "idProd, descInterna, tipoProd, refInterna, unidadMed, stockMin, stockMax, disponibles, cat1, cat2, cat3, compraPrecio usuario", "alm_productos", "where " + stock + " (refInterna LIKE '%" + ref + "%' or refProv LIKE '%" + ref + "%')  and idProd like '%" + id + "%' and descInterna like '%" + desc + "%' and " + tipo + " and (cat1 like '%" + cat + "%' or cat2 like '%" + cat + "%' or cat3 like '%" + cat + "%') and estatus ='ACTIVO' order by descInterna");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4625 */     this.utilerias.eliminarColumna((JTable)this.rSTableMetro5, 10, 9, "cat2", " / ");
/* 4626 */     this.utilerias.eliminarColumna((JTable)this.rSTableMetro5, 10, 9, "cat3", " / ");
/* 4627 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro5, this.celda2);
/*      */ 
/*      */     
/* 4630 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 0, 60);
/* 4631 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 2, 110);
/* 4632 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 4, 120);
/*      */     
/* 4634 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 5, 50);
/* 4635 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 6, 50);
/* 4636 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 7, 50);
/* 4637 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro5, 8, 80);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4649 */     this.jLabel83.setText("" + this.rSTableMetro5.getRowCount());
/*      */ 
/*      */     
/* 4652 */     this.celda2.pasarInd2(stockMinimos());
/* 4653 */     this.celda2.pasarInd3(stockMaximos());
/* 4654 */     this.rSTableMetro5.setSelectionMode(0);
/* 4655 */     this.rSTableMetro5.setAutoCreateRowSorter(true);
/* 4656 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*      */   }
/*      */   
/*      */   public String[] stockMinimos() {
/* 4660 */     ArrayList<String> idsList = new ArrayList<>();
/* 4661 */     for (int i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 4662 */       double minValue = Double.parseDouble(this.rSTableMetro5.getValueAt(i, 5).toString());
/* 4663 */       double dispValue = Double.parseDouble(this.rSTableMetro5.getValueAt(i, 7).toString());
/* 4664 */       if (dispValue < minValue) {
/* 4665 */         String idValue = this.rSTableMetro5.getValueAt(i, 0).toString();
/* 4666 */         idsList.add(idValue);
/*      */       } 
/*      */     } 
/* 4669 */     String[] idsArray = idsList.<String>toArray(new String[0]);
/* 4670 */     return idsArray;
/*      */   }
/*      */   
/*      */   public String[] stockMaximos() {
/* 4674 */     ArrayList<String> idsList = new ArrayList<>();
/* 4675 */     for (int i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 4676 */       double maxValue = Double.parseDouble(this.rSTableMetro5.getValueAt(i, 6).toString());
/* 4677 */       double dispValue = Double.parseDouble(this.rSTableMetro5.getValueAt(i, 7).toString());
/* 4678 */       if (dispValue > maxValue && maxValue > 0.0D) {
/* 4679 */         String idValue = this.rSTableMetro5.getValueAt(i, 0).toString();
/* 4680 */         idsList.add(idValue);
/*      */       } 
/*      */     } 
/* 4683 */     String[] idsArray = idsList.<String>toArray(new String[0]);
/* 4684 */     return idsArray;
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4688 */     this.con2.setBaseDatos("sicre2PR");
/* 4689 */     this.PRIMERA = true;
/* 4690 */     String fechaCompleta1 = "";
/* 4691 */     String fechaCompleta2 = "";
/* 4692 */     String consultaFecha = "";
/* 4693 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 4694 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/* 4696 */       int aa = Integer.parseInt(this.jComboBox2.getSelectedItem().toString());
/* 4697 */       consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.jComboBox1.getSelectedIndex()] + "-" + aa + "' ";
/*      */     } else {
/* 4699 */       Date fecha1 = this.jDateChooser11.getDate();
/* 4700 */       Date fecha2 = this.jDateChooser12.getDate();
/* 4701 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4702 */       String cadenaFecha = "";
/* 4703 */       cadenaFecha = formato.format(fecha1);
/* 4704 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4705 */       String MES = cadenaFecha.substring(4, 6);
/* 4706 */       String DIA = cadenaFecha.substring(6, 8);
/* 4707 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 4708 */       cadenaFecha = formato.format(fecha2);
/* 4709 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 4710 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 4711 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 4712 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/* 4713 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/* 4715 */     this.PRIMERA = true;
/* 4716 */     String suc = "";
/* 4717 */     if (this.jComboBox23.getSelectedIndex() != 0) {
/* 4718 */       suc = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */     }
/* 4720 */     String area = "";
/* 4721 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 4722 */       area = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 4725 */     String tipoOrden = "";
/* 4726 */     String tipoEquipo = "";
/* 4727 */     String folio = "";
/* 4728 */     String equipo = "";
/* 4729 */     String producto = "";
/* 4730 */     String solicita = "";
/* 4731 */     String ref = "";
/* 4732 */     String estatus = "";
/*      */     
/* 4734 */     if (!this.jTextField6.getText().equals(this.holderFolio)) {
/* 4735 */       folio = this.jTextField6.getText();
/*      */     }
/*      */     
/* 4738 */     if (!this.jTextField1.getText().equals(this.holderEquipo)) {
/* 4739 */       equipo = this.jTextField1.getText();
/*      */     }
/*      */     
/* 4742 */     if (!this.jTextField3.getText().equals(this.holderProducto)) {
/* 4743 */       producto = this.jTextField3.getText();
/*      */     }
/*      */     
/* 4746 */     if (!this.jTextField2.getText().equals(this.holderSolicita)) {
/* 4747 */       solicita = this.jTextField2.getText();
/*      */     }
/*      */     
/* 4750 */     if (!this.jTextField15.getText().equals(this.holderRef)) {
/* 4751 */       ref = this.jTextField15.getText();
/*      */     }
/*      */     
/* 4754 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 4755 */       tipoEquipo = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */     }
/*      */     
/* 4758 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 4759 */       tipoOrden = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/*      */     
/* 4762 */     if (folio.contains("'")) {
/* 4763 */       folio = folio.replace("'", "");
/*      */     }
/*      */     
/* 4766 */     if (equipo.contains("'")) {
/* 4767 */       equipo = equipo.replace("'", "");
/*      */     }
/* 4769 */     if (producto.contains("'")) {
/* 4770 */       producto = producto.replace("'", "");
/*      */     }
/* 4772 */     if (solicita.contains("'")) {
/* 4773 */       solicita = solicita.replace("'", "");
/*      */     }
/* 4775 */     if (ref.contains("'")) {
/* 4776 */       ref = ref.replace("'", "");
/*      */     }
/* 4778 */     if (tipoEquipo.contains("'")) {
/* 4779 */       tipoEquipo = tipoEquipo.replace("'", "");
/*      */     }
/* 4781 */     if (tipoOrden.contains("'")) {
/* 4782 */       tipoOrden = tipoOrden.replace("'", "");
/*      */     }
/*      */ 
/*      */     
/* 4786 */     if (this.jComboBox24.getSelectedIndex() == 0) {
/* 4787 */       estatus = " and estatus like '%Autoriza%' ";
/* 4788 */     } else if (this.jComboBox24.getSelectedIndex() == 1) {
/* 4789 */       estatus = " and estatus like '%Por Autoriza%' ";
/* 4790 */     } else if (this.jComboBox24.getSelectedIndex() == 2) {
/* 4791 */       estatus = " and estatus like '%Autorizada%' ";
/* 4792 */     } else if (this.jComboBox24.getSelectedIndex() == 3) {
/* 4793 */       estatus = " and estatus like '%Cancelada%' ";
/*      */     } 
/*      */     
/* 4796 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro1, new String[] { "Mov", "Folio", "Fecha", "Equipo", "Origen | Destino", "Mercancía | Producto | Servicio", "Referencia", "Costo", "Solicita", "Área", "Sucursal", "Estatus", "Actualización" }, "movOp, folio, fecha, tipoEquipo, origenDestino, productos, referencia, costo, solicita, area, base, estatus, actualizacion", "alm_operaciones", "where tipo like '%" + tipoOrden + "%' and folio like '%" + folio + "%' and origenDestino like '%" + equipo + "%' and productos like '%" + producto + "%'  and referencia like '%" + ref + "%' and solicita like '%" + solicita + "%' and tipoEquipo like '%" + tipoEquipo + "%' " + consultaFecha + " and base like '%" + suc + "%' and area like '%" + area + "%' " + estatus + " order by fecha desc, movOp desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4822 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/* 4823 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 4824 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 70);
/* 4825 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 90);
/* 4826 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 70);
/* 4827 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 7, 80);
/* 4828 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 90);
/* 4829 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 11, 100);
/*      */     
/* 4831 */     this.celda3.pasarInd(this.con2.revisarCol((JTable)this.rSTableMetro1, "CANCELADA", 0, 11, 2));
/* 4832 */     this.celda3.pasarInd2(this.con2.revisarCol((JTable)this.rSTableMetro1, "Por Autorizar", 0, 11, 2));
/* 4833 */     this.celda3.pasarInd3(this.con2.revisarCol((JTable)this.rSTableMetro1, "SA", 0, 1, 2));
/* 4834 */     sumarTotalesTablaGral();
/* 4835 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda3);
/*      */   }
/*      */   
/*      */   public void sumarTotalesTablaGral() {
/* 4839 */     double entrada = 0.0D;
/* 4840 */     double salida = 0.0D;
/* 4841 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 4842 */       String tipo = this.rSTableMetro1.getValueAt(i, 1).toString();
/* 4843 */       String valor = this.rSTableMetro1.getValueAt(i, 7).toString();
/* 4844 */       if (tipo.contains("EN")) {
/* 4845 */         entrada += this.utilerias.convertirCantTexto(valor);
/* 4846 */       } else if (tipo.contains("SA")) {
/* 4847 */         salida += this.utilerias.convertirCantTexto(valor);
/*      */       } 
/*      */     } 
/* 4850 */     this.jLabel39.setText(this.utilerias.convertirDoublePesos(entrada));
/* 4851 */     this.jLabel40.setText(this.utilerias.convertirDoublePesos(salida));
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 4855 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 4863 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 4869 */         return 30;
/*      */       
/*      */       case 1:
/* 4872 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 4874 */           return 29;
/*      */         }
/* 4876 */         return 28;
/*      */     } 
/*      */     
/* 4879 */     return 0;
/*      */   }
/*      */   
/*      */   static class SpinnerEditor
/*      */     extends AbstractCellEditor
/*      */     implements TableCellEditor
/*      */   {
/*      */     final JSpinner spinner;
/*      */     
/*      */     public SpinnerEditor(JSpinner spinner) {
/* 4889 */       this.spinner = spinner;
/*      */     }
/*      */ 
/*      */     
/*      */     public Object getCellEditorValue() {
/* 4894 */       return this.spinner.getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
/* 4899 */       this.spinner.setValue(value);
/* 4900 */       return this.spinner;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 4906 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4909 */       setEnabled((table == null || table.isEnabled()));
/* 4910 */       if (column == 5 || column == 6) {
/* 4911 */         setHorizontalAlignment(4);
/* 4912 */       } else if (column == 3 || column == 7) {
/* 4913 */         setHorizontalAlignment(0);
/*      */       } else {
/* 4915 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 4918 */       if (row % 2 == 0) {
/* 4919 */         setBackground(AlmAlmacen.this.lc.FONDOTABLA);
/*      */       } else {
/* 4921 */         setBackground(Color.WHITE);
/*      */       } 
/* 4923 */       setForeground(AlmAlmacen.this.lc.SECUNDARIO1);
/* 4924 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4925 */       return this;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     public CeldaRender2() {
/* 4931 */       this.otro = -1;
/* 4932 */       this.indices = new String[0];
/* 4933 */       this.indices2 = new String[0];
/* 4934 */       this.indices3 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4937 */       setEnabled((table == null || table.isEnabled()));
/* 4938 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 4940 */       if (column == 0 || column == 5 || column == 6 || column == 7 || column == 8 || column == 9) {
/* 4941 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4943 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 4946 */       if (comparar(comp)) {
/* 4947 */         setBackground(Color.red);
/* 4948 */         setForeground(Color.white);
/* 4949 */       } else if (comparar2(comp)) {
/* 4950 */         setBackground(Color.ORANGE);
/* 4951 */         setForeground(Color.RED);
/* 4952 */       } else if (comparar3(comp)) {
/* 4953 */         setBackground(new Color(153, 153, 153));
/* 4954 */         setForeground(Color.BLACK);
/*      */       } else {
/* 4956 */         setBackground((Color)null);
/* 4957 */         setForeground(AlmAlmacen.this.lc.SECUNDARIO1);
/*      */       } 
/*      */       
/* 4960 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4961 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4965 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 4969 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 4973 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4977 */       for (int i = 0; i < this.indices.length; i++) {
/* 4978 */         if (this.indices[i].equals(reg)) {
/* 4979 */           return true;
/*      */         }
/*      */       } 
/* 4982 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 4986 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4987 */         if (this.indices2[i].equals(reg)) {
/* 4988 */           return true;
/*      */         }
/*      */       } 
/* 4991 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 4995 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4996 */         if (this.indices3[i].equals(reg)) {
/* 4997 */           return true;
/*      */         }
/*      */       } 
/* 5000 */       return false;
/*      */     } }
/*      */   public class CeldaRender3 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     public CeldaRender3() {
/* 5006 */       this.otro = -1;
/* 5007 */       this.indices = new String[0];
/* 5008 */       this.indices2 = new String[0];
/* 5009 */       this.indices3 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5012 */       setEnabled((table == null || table.isEnabled()));
/* 5013 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 5015 */       if (column == 0 || column == 7) {
/* 5016 */         setHorizontalAlignment(4);
/*      */       } else {
/* 5018 */         setHorizontalAlignment(2);
/*      */       } 
/*      */       
/* 5021 */       if (comparar(comp)) {
/* 5022 */         setBackground(Color.red);
/* 5023 */         setForeground(Color.white);
/* 5024 */       } else if (comparar2(comp)) {
/* 5025 */         setBackground(Color.ORANGE);
/* 5026 */         setForeground(Color.RED);
/* 5027 */       } else if (comparar3(comp)) {
/* 5028 */         setBackground(new Color(153, 153, 153));
/* 5029 */         setForeground(Color.white);
/*      */       } else {
/* 5031 */         setBackground((Color)null);
/* 5032 */         setForeground(AlmAlmacen.this.lc.SECUNDARIO1);
/*      */       } 
/*      */       
/* 5035 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5036 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 5040 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 5044 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 5048 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 5052 */       for (int i = 0; i < this.indices.length; i++) {
/* 5053 */         if (this.indices[i].equals(reg)) {
/* 5054 */           return true;
/*      */         }
/*      */       } 
/* 5057 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 5061 */       for (int i = 0; i < this.indices2.length; i++) {
/* 5062 */         if (this.indices2[i].equals(reg)) {
/* 5063 */           return true;
/*      */         }
/*      */       } 
/* 5066 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 5070 */       for (int i = 0; i < this.indices3.length; i++) {
/* 5071 */         if (this.indices3[i].equals(reg)) {
/* 5072 */           return true;
/*      */         }
/*      */       } 
/* 5075 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Productos
/*      */   {
/*      */     String idProd;
/*      */     String unidadMed;
/*      */     String tipoProd;
/*      */     String descInterna;
/*      */     String refInterna;
/*      */     String compraPrecio;
/*      */     String disponibles;
/*      */     
/*      */     public Productos(String idProd, String unidadMed, String tipoProd, String descInterna, String refInterna, String compraPrecio, String disponibles) {
/* 5090 */       this.idProd = idProd;
/* 5091 */       this.unidadMed = unidadMed;
/* 5092 */       this.tipoProd = tipoProd;
/* 5093 */       this.descInterna = descInterna;
/* 5094 */       this.refInterna = refInterna;
/* 5095 */       this.compraPrecio = compraPrecio;
/* 5096 */       this.disponibles = disponibles;
/*      */     }
/*      */     
/*      */     public String getIdProd() {
/* 5100 */       return this.idProd;
/*      */     }
/*      */     
/*      */     public void setIdProd(String idProd) {
/* 5104 */       this.idProd = idProd;
/*      */     }
/*      */     
/*      */     public String getUnidadMed() {
/* 5108 */       return this.unidadMed;
/*      */     }
/*      */     
/*      */     public void setUnidadMed(String unidadMed) {
/* 5112 */       this.unidadMed = unidadMed;
/*      */     }
/*      */     
/*      */     public String getTipoProd() {
/* 5116 */       return this.tipoProd;
/*      */     }
/*      */     
/*      */     public void setTipoProd(String tipoProd) {
/* 5120 */       this.tipoProd = tipoProd;
/*      */     }
/*      */     
/*      */     public String getDescInterna() {
/* 5124 */       return this.descInterna;
/*      */     }
/*      */     
/*      */     public void setDescInterna(String descInterna) {
/* 5128 */       this.descInterna = descInterna;
/*      */     }
/*      */     
/*      */     public String getRefInterna() {
/* 5132 */       return this.refInterna;
/*      */     }
/*      */     
/*      */     public void setRefInterna(String refInterna) {
/* 5136 */       this.refInterna = refInterna;
/*      */     }
/*      */     
/*      */     public String getCompraPrecio() {
/* 5140 */       return this.compraPrecio;
/*      */     }
/*      */     
/*      */     public void setCompraPrecio(String compraPrecio) {
/* 5144 */       this.compraPrecio = compraPrecio;
/*      */     }
/*      */     
/*      */     public String getDisponibles() {
/* 5148 */       return this.disponibles;
/*      */     }
/*      */     
/*      */     public void setDisponibles(String disponibles) {
/* 5152 */       this.disponibles = disponibles;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/AlmAlmacen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */